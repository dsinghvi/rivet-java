package com.rivet.api.resources.matchmaker.players.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = PlayerConnectedRequest.Builder.class
)
public final class PlayerConnectedRequest {
  private final String playerToken;

  private int _cachedHashCode;

  PlayerConnectedRequest(String playerToken) {
    this.playerToken = playerToken;
  }

  @JsonProperty("player_token")
  public String getPlayerToken() {
    return playerToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PlayerConnectedRequest && equalTo((PlayerConnectedRequest) other);
  }

  private boolean equalTo(PlayerConnectedRequest other) {
    return playerToken.equals(other.playerToken);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.playerToken);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PlayerConnectedRequest{" + "playerToken: " + playerToken + "}";
  }

  public static PlayerTokenStage builder() {
    return new Builder();
  }

  public interface PlayerTokenStage {
    _FinalStage playerToken(String playerToken);

    Builder from(PlayerConnectedRequest other);
  }

  public interface _FinalStage {
    PlayerConnectedRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PlayerTokenStage, _FinalStage {
    private String playerToken;

    private Builder() {
    }

    @Override
    public Builder from(PlayerConnectedRequest other) {
      playerToken(other.getPlayerToken());
      return this;
    }

    @Override
    @JsonSetter("player_token")
    public _FinalStage playerToken(String playerToken) {
      this.playerToken = playerToken;
      return this;
    }

    @Override
    public PlayerConnectedRequest build() {
      return new PlayerConnectedRequest(playerToken);
    }
  }
}
