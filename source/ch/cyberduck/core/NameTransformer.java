package ch.cyberduck.core;

/*
 *  Copyright (c) 2004 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 *  Created by Marc Respass on 11/27/04. All rights reserved.
 */

import org.apache.log4j.Logger;

import com.apple.cocoa.foundation.NSPathUtilities;

public class NameTransformer {
	private static Logger log = Logger.getLogger(NameTransformer.class);
		
	private static NameTransformer instance;
	
	public static NameTransformer instance() {
		if(null == instance) {
			instance = new NameTransformer();
		}
		return instance;
	}
		
	private NameTransformer() {
		//
	}
	
	protected String transformByHonoringMaxLength(String transformName) {
		int fileLen = transformName.length();
		int maxLength = Integer.parseInt(Preferences.instance().getProperty("queue.transformer.maxLength"));
		if(Preferences.instance().getProperty("queue.transformer.keepsFilenameExtensions").equals("true")) {
			maxLength -= NSPathUtilities.pathExtension(transformName).length()+1;
		}
		log.debug("transformByHonoringMaxLength fileLen: " + fileLen);
		if(maxLength <= 0) {
			log.debug("NameTransformer maxLength <= 0. Skipping force length");
		} 
		else if(fileLen > maxLength) {
			log.debug("NameTransformer forcing length: " + maxLength + " by deleting from middle");
			int delta = fileLen - maxLength;
			log.debug("transformByHonoringMaxLength delta: " + delta);
			int frontLen = (fileLen / 2) - (delta / 2);
			log.debug("transformByHonoringMaxLength frontLen: " + frontLen);
			
			String front = transformName.substring(0, frontLen);
			
			int backStart = frontLen + delta;
			log.debug("transformByHonoringMaxLength backStart: " + backStart);
			String back = transformName.substring(backStart);
			log.debug("transformByHonoringMaxLength: name was - "+transformName);
			transformName = front + back;
			log.debug("NameTransformer forced length: "+transformName);
		}
		return transformName;
	}	
	
	public String transform(String originalName) {
		String transformName = originalName;
		if(Preferences.instance().getProperty("queue.transformer.keepsFilenameExtensions").equals("true")) {
			transformName = NSPathUtilities.stringByDeletingPathExtension(originalName);
		} 
		log.debug("NameTransformer preparing to transform: "+transformName);
		
		String prefixString = Preferences.instance().getProperty("queue.transformer.prefixString");
		log.debug("NameTransformer prefixString = " + prefixString);
		
		String appendString = Preferences.instance().getProperty("queue.transformer.appendString");
		log.debug("NameTransformer appendString = " + appendString);
		
		String replaceSearchString = Preferences.instance().getProperty("queue.transformer.replaceSearchString");
		log.debug("NameTransformer replaceSearchString = " + replaceSearchString);
		
		String replaceWithString = Preferences.instance().getProperty("queue.transformer.replaceWithString");
		log.debug("NameTransformer replaceWithString = " + replaceWithString);
		
		if(replaceSearchString != null) {
			boolean replaceAll = Preferences.instance().getProperty("queue.transformer.replaceAllOccurances").equals("true");
			do {
				transformName = replaceStringWithString(transformName, replaceSearchString, replaceWithString);
			} while (transformName.indexOf(replaceSearchString) > -1 && replaceAll);
		}
		
		if(prefixString != null) {
			log.debug("NameTransformer adding prefix: "+transformName);
			transformName = prefixString+transformName;
			log.debug("NameTransformer done adding prefix: "+transformName);
		}
		if(appendString != null) {
			log.debug("NameTransformer adding suffix: "+transformName);
			transformName = transformName + appendString;
			log.debug("NameTransformer done adding suffix: "+transformName);
		}
		
		transformName = this.handleIllegalCharacters(transformName);
		transformName = this.transformByHonoringMaxLength(transformName);
		transformName = this.fixExtension(transformName);
		
		log.debug("NameTransformer done transforming: "+transformName);
		return transformName;
	}
	
	private String handleIllegalCharacters(String transformName) {
		log.debug("NameTransformer handleIllegalCharacters");

		String illegalCharacters = Preferences.instance().getProperty("queue.transformer.illegalCharacters");
		if(illegalCharacters != null) {
			log.debug("NameTransformer illegalCharacters = " + illegalCharacters);
			char[] illegalChar = illegalCharacters.toCharArray();
			char substituteChar = '~';
			boolean canSubstitute = false;
			String substituteCharacter = Preferences.instance().getProperty("queue.transformer.substituteCharacter");

			if(substituteCharacter != null && substituteCharacter.length() > 0) {
				canSubstitute = true;
				substituteChar = substituteCharacter.toCharArray()[0];
				log.debug("NameTransformer substituteChar is: " + substituteChar);
			}
			
			for(int index = 0; index < illegalChar.length; index++) {
				log.debug("NameTransformer replacing in: "+transformName);
				if(canSubstitute) {
					transformName = transformName.replace(illegalChar[index], substituteChar);
				} else {
					String rString = illegalCharacters.substring(index, 1);
					log.debug("NameTransformer replacing: " + rString);
					transformName = replaceStringWithString(transformName, rString, null);
					log.debug("NameTransformer replacing: " + rString);
				}
			}
		}
		return transformName;
	}

	private String replaceStringWithString(String transformName, String searchString, String replaceString) {
		log.debug("NameTransformer replacing: " + searchString + " with: " + replaceString);
		int index = transformName.indexOf(searchString);
		if(index > -1) {
			String front = transformName.substring(0, index);
			String back = transformName.substring(index + searchString.length());
			
			log.debug("NameTransformer front: " + front);
			log.debug("NameTransformer back: " + back);
			
			if(replaceString != null) {
				transformName = front + replaceString + back;
			}
			else {
				transformName = front + back;
			}
			log.debug("NameTransformer done replace: "+transformName);
		} 
		else {
			log.debug("NameTransformer replace string not contained in: "+transformName);
		}
//		return index;
		return transformName;
	}		
	
	private String fixExtension(String transformName) {
		if(Preferences.instance().getProperty("queue.transformer.keepsFilenameExtensions").equals("true") && NSPathUtilities.pathExtension(transformName) != null) {
			transformName = NSPathUtilities.stringByAppendingPathExtension(transformName, NSPathUtilities.pathExtension(transformName));
		}
		return transformName;
	}		
}
