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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Set virus protection policies
 */
@Schema(description = "Set virus protection policies")

public class UpdateVirusProtectionPoliciesConfig {
  @JsonProperty("isVirusProtectionEnabled")
  private Boolean isVirusProtectionEnabled = null;

  public UpdateVirusProtectionPoliciesConfig isVirusProtectionEnabled(Boolean isVirusProtectionEnabled) {
    this.isVirusProtectionEnabled = isVirusProtectionEnabled;
    return this;
  }

   /**
   * Determines whether virus protection is enabled for room. To be set by room admins
   * @return isVirusProtectionEnabled
  **/
  @Schema(description = "Determines whether virus protection is enabled for room. To be set by room admins")
  public Boolean isIsVirusProtectionEnabled() {
    return isVirusProtectionEnabled;
  }

  public void setIsVirusProtectionEnabled(Boolean isVirusProtectionEnabled) {
    this.isVirusProtectionEnabled = isVirusProtectionEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateVirusProtectionPoliciesConfig updateVirusProtectionPoliciesConfig = (UpdateVirusProtectionPoliciesConfig) o;
    return Objects.equals(this.isVirusProtectionEnabled, updateVirusProtectionPoliciesConfig.isVirusProtectionEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isVirusProtectionEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateVirusProtectionPoliciesConfig {\n");
    
    sb.append("    isVirusProtectionEnabled: ").append(toIndentedString(isVirusProtectionEnabled)).append("\n");
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
