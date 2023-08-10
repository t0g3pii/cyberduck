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
 * Request model for updating syslog settings
 */
@Schema(description = "Request model for updating syslog settings")

public class UpdateSyslogConfig {
  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("host")
  private String host = null;

  @JsonProperty("port")
  private Integer port = null;

  /**
   * Protocol to connect to syslog server
   */
  public enum ProtocolEnum {
    TCP("TCP"),
    UDP("UDP");

    private String value;

    ProtocolEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static ProtocolEnum fromValue(String input) {
      for (ProtocolEnum b : ProtocolEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("protocol")
  private ProtocolEnum protocol = null;

  @JsonProperty("logIpEnabled")
  private Boolean logIpEnabled = null;

  public UpdateSyslogConfig enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Is syslog enabled?
   * @return enabled
  **/
  @Schema(description = "Is syslog enabled?")
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public UpdateSyslogConfig host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Syslog server (IP or FQDN)
   * @return host
  **/
  @Schema(description = "Syslog server (IP or FQDN)")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public UpdateSyslogConfig port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Syslog server port
   * @return port
  **/
  @Schema(description = "Syslog server port")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public UpdateSyslogConfig protocol(ProtocolEnum protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Protocol to connect to syslog server
   * @return protocol
  **/
  @Schema(description = "Protocol to connect to syslog server")
  public ProtocolEnum getProtocol() {
    return protocol;
  }

  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  public UpdateSyslogConfig logIpEnabled(Boolean logIpEnabled) {
    this.logIpEnabled = logIpEnabled;
    return this;
  }

   /**
   * Determines whether user’s IP address is logged.
   * @return logIpEnabled
  **/
  @Schema(description = "Determines whether user’s IP address is logged.")
  public Boolean isLogIpEnabled() {
    return logIpEnabled;
  }

  public void setLogIpEnabled(Boolean logIpEnabled) {
    this.logIpEnabled = logIpEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSyslogConfig updateSyslogConfig = (UpdateSyslogConfig) o;
    return Objects.equals(this.enabled, updateSyslogConfig.enabled) &&
        Objects.equals(this.host, updateSyslogConfig.host) &&
        Objects.equals(this.port, updateSyslogConfig.port) &&
        Objects.equals(this.protocol, updateSyslogConfig.protocol) &&
        Objects.equals(this.logIpEnabled, updateSyslogConfig.logIpEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, host, port, protocol, logIpEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSyslogConfig {\n");
    
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    logIpEnabled: ").append(toIndentedString(logIpEnabled)).append("\n");
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
