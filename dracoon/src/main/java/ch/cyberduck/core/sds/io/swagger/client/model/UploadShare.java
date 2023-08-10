/*
 * DRACOON API
 * REST Web Services for DRACOON<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.45.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.sds.io.swagger.client.model.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * Upload Share information
 */
@Schema(description = "Upload Share information")

public class UploadShare {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("targetId")
  private Long targetId = null;

  @JsonProperty("isProtected")
  private Boolean isProtected = null;

  @JsonProperty("accessKey")
  private String accessKey = null;

  @JsonProperty("createdAt")
  private DateTime createdAt = null;

  @JsonProperty("createdBy")
  private UserInfo createdBy = null;

  @JsonProperty("updatedAt")
  private DateTime updatedAt = null;

  @JsonProperty("updatedBy")
  private UserInfo updatedBy = null;

  @JsonProperty("expireAt")
  private DateTime expireAt = null;

  @JsonProperty("targetPath")
  private String targetPath = null;

  @JsonProperty("isEncrypted")
  private Boolean isEncrypted = null;

  @JsonProperty("notes")
  private String notes = null;

  @JsonProperty("internalNotes")
  private String internalNotes = null;

  @JsonProperty("filesExpiryPeriod")
  private Integer filesExpiryPeriod = null;

  @JsonProperty("cntFiles")
  private Integer cntFiles = null;

  @JsonProperty("cntUploads")
  private Integer cntUploads = null;

  @JsonProperty("showUploadedFiles")
  private Boolean showUploadedFiles = null;

  @JsonProperty("dataUrl")
  private String dataUrl = null;

  @JsonProperty("maxSlots")
  private Integer maxSlots = null;

  @JsonProperty("maxSize")
  private Long maxSize = null;

  @JsonProperty("targetType")
  private String targetType = null;

  @JsonProperty("showCreatorName")
  private Boolean showCreatorName = null;

  @JsonProperty("showCreatorUsername")
  private Boolean showCreatorUsername = null;

  @JsonProperty("notifyCreator")
  private Boolean notifyCreator = null;

  @JsonProperty("recipients")
  private String recipients = null;

  @JsonProperty("smsRecipients")
  private String smsRecipients = null;

  public UploadShare id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Share ID
   * @return id
  **/
  @Schema(required = true, description = "Share ID")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UploadShare name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Alias name
   * @return name
  **/
  @Schema(required = true, description = "Alias name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UploadShare targetId(Long targetId) {
    this.targetId = targetId;
    return this;
  }

   /**
   * Target room or folder ID
   * @return targetId
  **/
  @Schema(required = true, description = "Target room or folder ID")
  public Long getTargetId() {
    return targetId;
  }

  public void setTargetId(Long targetId) {
    this.targetId = targetId;
  }

  public UploadShare isProtected(Boolean isProtected) {
    this.isProtected = isProtected;
    return this;
  }

   /**
   * Is share protected by password
   * @return isProtected
  **/
  @Schema(required = true, description = "Is share protected by password")
  public Boolean isIsProtected() {
    return isProtected;
  }

  public void setIsProtected(Boolean isProtected) {
    this.isProtected = isProtected;
  }

  public UploadShare accessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

   /**
   * Share access key to generate secure link
   * @return accessKey
  **/
  @Schema(required = true, description = "Share access key to generate secure link")
  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public UploadShare createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Creation date
   * @return createdAt
  **/
  @Schema(required = true, description = "Creation date")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public UploadShare createdBy(UserInfo createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/
  @Schema(required = true, description = "")
  public UserInfo getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(UserInfo createdBy) {
    this.createdBy = createdBy;
  }

  public UploadShare updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Modification date
   * @return updatedAt
  **/
  @Schema(description = "Modification date")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public UploadShare updatedBy(UserInfo updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

   /**
   * Get updatedBy
   * @return updatedBy
  **/
  @Schema(description = "")
  public UserInfo getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(UserInfo updatedBy) {
    this.updatedBy = updatedBy;
  }

  public UploadShare expireAt(DateTime expireAt) {
    this.expireAt = expireAt;
    return this;
  }

   /**
   * Expiration date
   * @return expireAt
  **/
  @Schema(description = "Expiration date")
  public DateTime getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(DateTime expireAt) {
    this.expireAt = expireAt;
  }

  public UploadShare targetPath(String targetPath) {
    this.targetPath = targetPath;
    return this;
  }

   /**
   * Path to shared upload node
   * @return targetPath
  **/
  @Schema(description = "Path to shared upload node")
  public String getTargetPath() {
    return targetPath;
  }

  public void setTargetPath(String targetPath) {
    this.targetPath = targetPath;
  }

  public UploadShare isEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
    return this;
  }

   /**
   * Encryption state
   * @return isEncrypted
  **/
  @Schema(description = "Encryption state")
  public Boolean isIsEncrypted() {
    return isEncrypted;
  }

  public void setIsEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
  }

  public UploadShare notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * User notes
   * @return notes
  **/
  @Schema(description = "User notes")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public UploadShare internalNotes(String internalNotes) {
    this.internalNotes = internalNotes;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Internal notes
   * @return internalNotes
  **/
  @Schema(description = "&#128640; Since v4.11.0  Internal notes")
  public String getInternalNotes() {
    return internalNotes;
  }

  public void setInternalNotes(String internalNotes) {
    this.internalNotes = internalNotes;
  }

  public UploadShare filesExpiryPeriod(Integer filesExpiryPeriod) {
    this.filesExpiryPeriod = filesExpiryPeriod;
    return this;
  }

   /**
   * Number of days after which uploaded files expire
   * @return filesExpiryPeriod
  **/
  @Schema(description = "Number of days after which uploaded files expire")
  public Integer getFilesExpiryPeriod() {
    return filesExpiryPeriod;
  }

  public void setFilesExpiryPeriod(Integer filesExpiryPeriod) {
    this.filesExpiryPeriod = filesExpiryPeriod;
  }

  public UploadShare cntFiles(Integer cntFiles) {
    this.cntFiles = cntFiles;
    return this;
  }

   /**
   * Total amount of existing files uploaded with this share.
   * @return cntFiles
  **/
  @Schema(description = "Total amount of existing files uploaded with this share.")
  public Integer getCntFiles() {
    return cntFiles;
  }

  public void setCntFiles(Integer cntFiles) {
    this.cntFiles = cntFiles;
  }

  public UploadShare cntUploads(Integer cntUploads) {
    this.cntUploads = cntUploads;
    return this;
  }

   /**
   * Total amount of uploads conducted with this share.
   * @return cntUploads
  **/
  @Schema(description = "Total amount of uploads conducted with this share.")
  public Integer getCntUploads() {
    return cntUploads;
  }

  public void setCntUploads(Integer cntUploads) {
    this.cntUploads = cntUploads;
  }

  public UploadShare showUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
    return this;
  }

   /**
   * Allow display of already uploaded files
   * @return showUploadedFiles
  **/
  @Schema(description = "Allow display of already uploaded files")
  public Boolean isShowUploadedFiles() {
    return showUploadedFiles;
  }

  public void setShowUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
  }

  public UploadShare dataUrl(String dataUrl) {
    this.dataUrl = dataUrl;
    return this;
  }

   /**
   * Upload Share URL
   * @return dataUrl
  **/
  @Schema(description = "Upload Share URL")
  public String getDataUrl() {
    return dataUrl;
  }

  public void setDataUrl(String dataUrl) {
    this.dataUrl = dataUrl;
  }

  public UploadShare maxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
    return this;
  }

   /**
   * Maximal amount of files to upload
   * @return maxSlots
  **/
  @Schema(description = "Maximal amount of files to upload")
  public Integer getMaxSlots() {
    return maxSlots;
  }

  public void setMaxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
  }

  public UploadShare maxSize(Long maxSize) {
    this.maxSize = maxSize;
    return this;
  }

   /**
   * Maximal total size of uploaded files (in bytes)
   * @return maxSize
  **/
  @Schema(description = "Maximal total size of uploaded files (in bytes)")
  public Long getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(Long maxSize) {
    this.maxSize = maxSize;
  }

  public UploadShare targetType(String targetType) {
    this.targetType = targetType;
    return this;
  }

   /**
   * Node type
   * @return targetType
  **/
  @Schema(description = "Node type")
  public String getTargetType() {
    return targetType;
  }

  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

  public UploadShare showCreatorName(Boolean showCreatorName) {
    this.showCreatorName = showCreatorName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Show creator first and last name.
   * @return showCreatorName
  **/
  @Schema(description = "&#128640; Since v4.11.0  Show creator first and last name.")
  public Boolean isShowCreatorName() {
    return showCreatorName;
  }

  public void setShowCreatorName(Boolean showCreatorName) {
    this.showCreatorName = showCreatorName;
  }

  public UploadShare showCreatorUsername(Boolean showCreatorUsername) {
    this.showCreatorUsername = showCreatorUsername;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Show creator email address.
   * @return showCreatorUsername
  **/
  @Schema(description = "&#128640; Since v4.11.0  Show creator email address.")
  public Boolean isShowCreatorUsername() {
    return showCreatorUsername;
  }

  public void setShowCreatorUsername(Boolean showCreatorUsername) {
    this.showCreatorUsername = showCreatorUsername;
  }

  public UploadShare notifyCreator(Boolean notifyCreator) {
    this.notifyCreator = notifyCreator;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.20.0  Notify creator on every upload.
   * @return notifyCreator
  **/
  @Schema(required = true, description = "&#128679; Deprecated since v4.20.0  Notify creator on every upload.")
  public Boolean isNotifyCreator() {
    return notifyCreator;
  }

  public void setNotifyCreator(Boolean notifyCreator) {
    this.notifyCreator = notifyCreator;
  }

  public UploadShare recipients(String recipients) {
    this.recipients = recipients;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.11.0  CSV string of recipient email addresses
   * @return recipients
  **/
  @Schema(description = "&#128679; Deprecated since v4.11.0  CSV string of recipient email addresses")
  public String getRecipients() {
    return recipients;
  }

  public void setRecipients(String recipients) {
    this.recipients = recipients;
  }

  public UploadShare smsRecipients(String smsRecipients) {
    this.smsRecipients = smsRecipients;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.11.0  CSV string of recipient MSISDNs
   * @return smsRecipients
  **/
  @Schema(description = "&#128679; Deprecated since v4.11.0  CSV string of recipient MSISDNs")
  public String getSmsRecipients() {
    return smsRecipients;
  }

  public void setSmsRecipients(String smsRecipients) {
    this.smsRecipients = smsRecipients;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadShare uploadShare = (UploadShare) o;
    return Objects.equals(this.id, uploadShare.id) &&
        Objects.equals(this.name, uploadShare.name) &&
        Objects.equals(this.targetId, uploadShare.targetId) &&
        Objects.equals(this.isProtected, uploadShare.isProtected) &&
        Objects.equals(this.accessKey, uploadShare.accessKey) &&
        Objects.equals(this.createdAt, uploadShare.createdAt) &&
        Objects.equals(this.createdBy, uploadShare.createdBy) &&
        Objects.equals(this.updatedAt, uploadShare.updatedAt) &&
        Objects.equals(this.updatedBy, uploadShare.updatedBy) &&
        Objects.equals(this.expireAt, uploadShare.expireAt) &&
        Objects.equals(this.targetPath, uploadShare.targetPath) &&
        Objects.equals(this.isEncrypted, uploadShare.isEncrypted) &&
        Objects.equals(this.notes, uploadShare.notes) &&
        Objects.equals(this.internalNotes, uploadShare.internalNotes) &&
        Objects.equals(this.filesExpiryPeriod, uploadShare.filesExpiryPeriod) &&
        Objects.equals(this.cntFiles, uploadShare.cntFiles) &&
        Objects.equals(this.cntUploads, uploadShare.cntUploads) &&
        Objects.equals(this.showUploadedFiles, uploadShare.showUploadedFiles) &&
        Objects.equals(this.dataUrl, uploadShare.dataUrl) &&
        Objects.equals(this.maxSlots, uploadShare.maxSlots) &&
        Objects.equals(this.maxSize, uploadShare.maxSize) &&
        Objects.equals(this.targetType, uploadShare.targetType) &&
        Objects.equals(this.showCreatorName, uploadShare.showCreatorName) &&
        Objects.equals(this.showCreatorUsername, uploadShare.showCreatorUsername) &&
        Objects.equals(this.notifyCreator, uploadShare.notifyCreator) &&
        Objects.equals(this.recipients, uploadShare.recipients) &&
        Objects.equals(this.smsRecipients, uploadShare.smsRecipients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, targetId, isProtected, accessKey, createdAt, createdBy, updatedAt, updatedBy, expireAt, targetPath, isEncrypted, notes, internalNotes, filesExpiryPeriod, cntFiles, cntUploads, showUploadedFiles, dataUrl, maxSlots, maxSize, targetType, showCreatorName, showCreatorUsername, notifyCreator, recipients, smsRecipients);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadShare {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
    sb.append("    isProtected: ").append(toIndentedString(isProtected)).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    targetPath: ").append(toIndentedString(targetPath)).append("\n");
    sb.append("    isEncrypted: ").append(toIndentedString(isEncrypted)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    internalNotes: ").append(toIndentedString(internalNotes)).append("\n");
    sb.append("    filesExpiryPeriod: ").append(toIndentedString(filesExpiryPeriod)).append("\n");
    sb.append("    cntFiles: ").append(toIndentedString(cntFiles)).append("\n");
    sb.append("    cntUploads: ").append(toIndentedString(cntUploads)).append("\n");
    sb.append("    showUploadedFiles: ").append(toIndentedString(showUploadedFiles)).append("\n");
    sb.append("    dataUrl: ").append(toIndentedString(dataUrl)).append("\n");
    sb.append("    maxSlots: ").append(toIndentedString(maxSlots)).append("\n");
    sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
    sb.append("    targetType: ").append(toIndentedString(targetType)).append("\n");
    sb.append("    showCreatorName: ").append(toIndentedString(showCreatorName)).append("\n");
    sb.append("    showCreatorUsername: ").append(toIndentedString(showCreatorUsername)).append("\n");
    sb.append("    notifyCreator: ").append(toIndentedString(notifyCreator)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    smsRecipients: ").append(toIndentedString(smsRecipients)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
