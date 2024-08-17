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
 * View for event data
 */
@lombok.Builder(setterPrefix = "set")

@Schema(name = "ViewDTO", description = "View for event data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-17T18:04:43.295941+03:00[Europe/Kiev]")
public class ViewDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("views")
  private String views;

  public ViewDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ViewDTO views(String views) {
    this.views = views;
    return this;
  }

  /**
   * Get views
   * @return views
  */
  @NotNull 
  @Schema(name = "views", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getViews() {
    return views;
  }

  public void setViews(String views) {
    this.views = views;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ViewDTO viewDTO = (ViewDTO) o;
    return Objects.equals(this.id, viewDTO.id) &&
        Objects.equals(this.views, viewDTO.views);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, views);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ViewDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
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

