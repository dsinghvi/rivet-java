package com.rivet.api.resources.captcha.config.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ConfigHcaptcha.Builder.class
)
public final class ConfigHcaptcha {
  private final String clientResponse;

  private int _cachedHashCode;

  ConfigHcaptcha(String clientResponse) {
    this.clientResponse = clientResponse;
  }

  @JsonProperty("client_response")
  public String getClientResponse() {
    return clientResponse;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConfigHcaptcha && equalTo((ConfigHcaptcha) other);
  }

  private boolean equalTo(ConfigHcaptcha other) {
    return clientResponse.equals(other.clientResponse);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.clientResponse);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ConfigHcaptcha{" + "clientResponse: " + clientResponse + "}";
  }

  public static ClientResponseStage builder() {
    return new Builder();
  }

  public interface ClientResponseStage {
    _FinalStage clientResponse(String clientResponse);

    Builder from(ConfigHcaptcha other);
  }

  public interface _FinalStage {
    ConfigHcaptcha build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ClientResponseStage, _FinalStage {
    private String clientResponse;

    private Builder() {
    }

    @Override
    public Builder from(ConfigHcaptcha other) {
      clientResponse(other.getClientResponse());
      return this;
    }

    @Override
    @JsonSetter("client_response")
    public _FinalStage clientResponse(String clientResponse) {
      this.clientResponse = clientResponse;
      return this;
    }

    @Override
    public ConfigHcaptcha build() {
      return new ConfigHcaptcha(clientResponse);
    }
  }
}
