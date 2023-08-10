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
import ch.cyberduck.core.sds.io.swagger.client.model.PrivateKeyContainer;
import ch.cyberduck.core.sds.io.swagger.client.model.PublicKeyContainer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Key pair container
 */
@Schema(description = "Key pair container")

public class UserKeyPairContainer {
  @JsonProperty("privateKeyContainer")
  private PrivateKeyContainer privateKeyContainer = null;

  @JsonProperty("publicKeyContainer")
  private PublicKeyContainer publicKeyContainer = null;

  public UserKeyPairContainer privateKeyContainer(PrivateKeyContainer privateKeyContainer) {
    this.privateKeyContainer = privateKeyContainer;
    return this;
  }

   /**
   * Get privateKeyContainer
   * @return privateKeyContainer
  **/
  @Schema(required = true, description = "")
  public PrivateKeyContainer getPrivateKeyContainer() {
    return privateKeyContainer;
  }

  public void setPrivateKeyContainer(PrivateKeyContainer privateKeyContainer) {
    this.privateKeyContainer = privateKeyContainer;
  }

  public UserKeyPairContainer publicKeyContainer(PublicKeyContainer publicKeyContainer) {
    this.publicKeyContainer = publicKeyContainer;
    return this;
  }

   /**
   * Get publicKeyContainer
   * @return publicKeyContainer
  **/
  @Schema(required = true, description = "")
  public PublicKeyContainer getPublicKeyContainer() {
    return publicKeyContainer;
  }

  public void setPublicKeyContainer(PublicKeyContainer publicKeyContainer) {
    this.publicKeyContainer = publicKeyContainer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserKeyPairContainer userKeyPairContainer = (UserKeyPairContainer) o;
    return Objects.equals(this.privateKeyContainer, userKeyPairContainer.privateKeyContainer) &&
        Objects.equals(this.publicKeyContainer, userKeyPairContainer.publicKeyContainer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(privateKeyContainer, publicKeyContainer);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserKeyPairContainer {\n");
    
    sb.append("    privateKeyContainer: ").append(toIndentedString(privateKeyContainer)).append("\n");
    sb.append("    publicKeyContainer: ").append(toIndentedString(publicKeyContainer)).append("\n");
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
