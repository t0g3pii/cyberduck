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
import ch.cyberduck.core.sds.io.swagger.client.model.AlgorithmVersionInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Information of all available algorithms
 */
@Schema(description = "Information of all available algorithms")

public class AlgorithmVersionInfoList {
  @JsonProperty("fileKeyAlgorithms")
  private List<AlgorithmVersionInfo> fileKeyAlgorithms = new ArrayList<>();

  @JsonProperty("keyPairAlgorithms")
  private List<AlgorithmVersionInfo> keyPairAlgorithms = new ArrayList<>();

  public AlgorithmVersionInfoList fileKeyAlgorithms(List<AlgorithmVersionInfo> fileKeyAlgorithms) {
    this.fileKeyAlgorithms = fileKeyAlgorithms;
    return this;
  }

  public AlgorithmVersionInfoList addFileKeyAlgorithmsItem(AlgorithmVersionInfo fileKeyAlgorithmsItem) {
    this.fileKeyAlgorithms.add(fileKeyAlgorithmsItem);
    return this;
  }

   /**
   * List of file key algorithms
   * @return fileKeyAlgorithms
  **/
  @Schema(required = true, description = "List of file key algorithms")
  public List<AlgorithmVersionInfo> getFileKeyAlgorithms() {
    return fileKeyAlgorithms;
  }

  public void setFileKeyAlgorithms(List<AlgorithmVersionInfo> fileKeyAlgorithms) {
    this.fileKeyAlgorithms = fileKeyAlgorithms;
  }

  public AlgorithmVersionInfoList keyPairAlgorithms(List<AlgorithmVersionInfo> keyPairAlgorithms) {
    this.keyPairAlgorithms = keyPairAlgorithms;
    return this;
  }

  public AlgorithmVersionInfoList addKeyPairAlgorithmsItem(AlgorithmVersionInfo keyPairAlgorithmsItem) {
    this.keyPairAlgorithms.add(keyPairAlgorithmsItem);
    return this;
  }

   /**
   * List of key pair algorithms
   * @return keyPairAlgorithms
  **/
  @Schema(required = true, description = "List of key pair algorithms")
  public List<AlgorithmVersionInfo> getKeyPairAlgorithms() {
    return keyPairAlgorithms;
  }

  public void setKeyPairAlgorithms(List<AlgorithmVersionInfo> keyPairAlgorithms) {
    this.keyPairAlgorithms = keyPairAlgorithms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlgorithmVersionInfoList algorithmVersionInfoList = (AlgorithmVersionInfoList) o;
    return Objects.equals(this.fileKeyAlgorithms, algorithmVersionInfoList.fileKeyAlgorithms) &&
        Objects.equals(this.keyPairAlgorithms, algorithmVersionInfoList.keyPairAlgorithms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileKeyAlgorithms, keyPairAlgorithms);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlgorithmVersionInfoList {\n");
    
    sb.append("    fileKeyAlgorithms: ").append(toIndentedString(fileKeyAlgorithms)).append("\n");
    sb.append("    keyPairAlgorithms: ").append(toIndentedString(keyPairAlgorithms)).append("\n");
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
