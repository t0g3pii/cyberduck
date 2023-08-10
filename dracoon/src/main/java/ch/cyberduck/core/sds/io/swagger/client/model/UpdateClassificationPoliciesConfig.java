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
import ch.cyberduck.core.sds.io.swagger.client.model.ShareClassificationPolicies;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Set of classification policies
 */
@Schema(description = "Set of classification policies")

public class UpdateClassificationPoliciesConfig {
  @JsonProperty("shareClassificationPolicies")
  private ShareClassificationPolicies shareClassificationPolicies = null;

  public UpdateClassificationPoliciesConfig shareClassificationPolicies(ShareClassificationPolicies shareClassificationPolicies) {
    this.shareClassificationPolicies = shareClassificationPolicies;
    return this;
  }

   /**
   * Get shareClassificationPolicies
   * @return shareClassificationPolicies
  **/
  @Schema(description = "")
  public ShareClassificationPolicies getShareClassificationPolicies() {
    return shareClassificationPolicies;
  }

  public void setShareClassificationPolicies(ShareClassificationPolicies shareClassificationPolicies) {
    this.shareClassificationPolicies = shareClassificationPolicies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateClassificationPoliciesConfig updateClassificationPoliciesConfig = (UpdateClassificationPoliciesConfig) o;
    return Objects.equals(this.shareClassificationPolicies, updateClassificationPoliciesConfig.shareClassificationPolicies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shareClassificationPolicies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateClassificationPoliciesConfig {\n");
    
    sb.append("    shareClassificationPolicies: ").append(toIndentedString(shareClassificationPolicies)).append("\n");
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
