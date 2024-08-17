package org.test.spring.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * View for viewDto
 */
@lombok.Builder(setterPrefix = "set")

@Schema(name = "View", description = "View for viewDto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-17T18:04:43.295941+03:00[Europe/Kiev]")
public class View implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("x")
  private String x;

  @JsonProperty("xxx")
  private String xxx;

  public View x(String x) {
    this.x = x;
    return this;
  }

  /**
   * Get x
   * @return x
  */
  
  @Schema(name = "x", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public View xxx(String xxx) {
    this.xxx = xxx;
    return this;
  }

  /**
   * Get xxx
   * @return xxx
  */
  
  @Schema(name = "xxx", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getXxx() {
    return xxx;
  }

  public void setXxx(String xxx) {
    this.xxx = xxx;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    View view = (View) o;
    return Objects.equals(this.x, view.x) &&
        Objects.equals(this.xxx, view.xxx);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, xxx);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class View {\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    xxx: ").append(toIndentedString(xxx)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

