package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.ValidationError;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = ValidateGameNamespaceMatchmakerConfigResponse.Builder.class
)
public final class ValidateGameNamespaceMatchmakerConfigResponse {
  private final List<ValidationError> errors;

  private int _cachedHashCode;

  ValidateGameNamespaceMatchmakerConfigResponse(List<ValidationError> errors) {
    this.errors = errors;
  }

  /**
   * @return A list of validation errors.
   */
  @JsonProperty("errors")
  public List<ValidationError> getErrors() {
    return errors;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ValidateGameNamespaceMatchmakerConfigResponse && equalTo((ValidateGameNamespaceMatchmakerConfigResponse) other);
  }

  private boolean equalTo(ValidateGameNamespaceMatchmakerConfigResponse other) {
    return errors.equals(other.errors);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.errors);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ValidateGameNamespaceMatchmakerConfigResponse{" + "errors: " + errors + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<ValidationError> errors = new ArrayList<>();

    private Builder() {
    }

    public Builder from(ValidateGameNamespaceMatchmakerConfigResponse other) {
      errors(other.getErrors());
      return this;
    }

    @JsonSetter(
        value = "errors",
        nulls = Nulls.SKIP
    )
    public Builder errors(List<ValidationError> errors) {
      this.errors.clear();
      this.errors.addAll(errors);
      return this;
    }

    public Builder addErrors(ValidationError errors) {
      this.errors.add(errors);
      return this;
    }

    public Builder addAllErrors(List<ValidationError> errors) {
      this.errors.addAll(errors);
      return this;
    }

    public ValidateGameNamespaceMatchmakerConfigResponse build() {
      return new ValidateGameNamespaceMatchmakerConfigResponse(errors);
    }
  }
}