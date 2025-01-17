package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GlobalEventIdentityUpdate.Builder.class
)
public final class GlobalEventIdentityUpdate {
  private final Profile identity;

  private int _cachedHashCode;

  GlobalEventIdentityUpdate(Profile identity) {
    this.identity = identity;
  }

  @JsonProperty("identity")
  public Profile getIdentity() {
    return identity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GlobalEventIdentityUpdate && equalTo((GlobalEventIdentityUpdate) other);
  }

  private boolean equalTo(GlobalEventIdentityUpdate other) {
    return identity.equals(other.identity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GlobalEventIdentityUpdate{" + "identity: " + identity + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    _FinalStage identity(Profile identity);

    Builder from(GlobalEventIdentityUpdate other);
  }

  public interface _FinalStage {
    GlobalEventIdentityUpdate build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityStage, _FinalStage {
    private Profile identity;

    private Builder() {
    }

    @Override
    public Builder from(GlobalEventIdentityUpdate other) {
      identity(other.getIdentity());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public _FinalStage identity(Profile identity) {
      this.identity = identity;
      return this;
    }

    @Override
    public GlobalEventIdentityUpdate build() {
      return new GlobalEventIdentityUpdate(identity);
    }
  }
}
