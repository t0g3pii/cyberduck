/*
 * DeepAdmin API
 * General API for DeepCloud Admin / Subscription Service
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@deepcloud.swiss
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.deepcloud.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
/**
 * GroupRoles
 */



public class GroupRoles {
  @JsonProperty("group_id")
  private String groupId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("created_at")
  private DateTime createdAt = null;

  @JsonProperty("display_name")
  private String displayName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  @JsonProperty("roles")
  private List<String> roles = new ArrayList<>();

   /**
   * Get groupId
   * @return groupId
  **/
  @Schema(required = true, description = "")
  public String getGroupId() {
    return groupId;
  }

  public GroupRoles name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A unique email address (which could not exist) to reference this entity
   * @return name
  **/
  @Schema(description = "A unique email address (which could not exist) to reference this entity")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @Schema(required = true, description = "")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public GroupRoles displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @Schema(required = true, description = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public GroupRoles description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GroupRoles metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @Schema(description = "")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

   /**
   * Get roles
   * @return roles
  **/
  @Schema(required = true, description = "")
  public List<String> getRoles() {
    return roles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupRoles groupRoles = (GroupRoles) o;
    return Objects.equals(this.groupId, groupRoles.groupId) &&
        Objects.equals(this.name, groupRoles.name) &&
        Objects.equals(this.createdAt, groupRoles.createdAt) &&
        Objects.equals(this.displayName, groupRoles.displayName) &&
        Objects.equals(this.description, groupRoles.description) &&
        Objects.equals(this.metadata, groupRoles.metadata) &&
        Objects.equals(this.roles, groupRoles.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, name, createdAt, displayName, description, metadata, roles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupRoles {\n");
    
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
