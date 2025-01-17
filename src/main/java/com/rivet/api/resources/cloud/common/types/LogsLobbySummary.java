package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = LogsLobbySummary.Builder.class
)
public final class LogsLobbySummary {
  private final UUID lobbyId;

  private final UUID namespaceId;

  private final String lobbyGroupNameId;

  private final UUID regionId;

  private final String createTs;

  private final Optional<String> startTs;

  private final Optional<String> readyTs;

  private final LogsLobbyStatus status;

  private int _cachedHashCode;

  LogsLobbySummary(UUID lobbyId, UUID namespaceId, String lobbyGroupNameId, UUID regionId,
      String createTs, Optional<String> startTs, Optional<String> readyTs, LogsLobbyStatus status) {
    this.lobbyId = lobbyId;
    this.namespaceId = namespaceId;
    this.lobbyGroupNameId = lobbyGroupNameId;
    this.regionId = regionId;
    this.createTs = createTs;
    this.startTs = startTs;
    this.readyTs = readyTs;
    this.status = status;
  }

  @JsonProperty("lobby_id")
  public UUID getLobbyId() {
    return lobbyId;
  }

  @JsonProperty("namespace_id")
  public UUID getNamespaceId() {
    return namespaceId;
  }

  /**
   * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
   */
  @JsonProperty("lobby_group_name_id")
  public String getLobbyGroupNameId() {
    return lobbyGroupNameId;
  }

  @JsonProperty("region_id")
  public UUID getRegionId() {
    return regionId;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("start_ts")
  public Optional<String> getStartTs() {
    return startTs;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("ready_ts")
  public Optional<String> getReadyTs() {
    return readyTs;
  }

  @JsonProperty("status")
  public LogsLobbyStatus getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LogsLobbySummary && equalTo((LogsLobbySummary) other);
  }

  private boolean equalTo(LogsLobbySummary other) {
    return lobbyId.equals(other.lobbyId) && namespaceId.equals(other.namespaceId) && lobbyGroupNameId.equals(other.lobbyGroupNameId) && regionId.equals(other.regionId) && createTs.equals(other.createTs) && startTs.equals(other.startTs) && readyTs.equals(other.readyTs) && status.equals(other.status);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lobbyId, this.namespaceId, this.lobbyGroupNameId, this.regionId, this.createTs, this.startTs, this.readyTs, this.status);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LogsLobbySummary{" + "lobbyId: " + lobbyId + ", namespaceId: " + namespaceId + ", lobbyGroupNameId: " + lobbyGroupNameId + ", regionId: " + regionId + ", createTs: " + createTs + ", startTs: " + startTs + ", readyTs: " + readyTs + ", status: " + status + "}";
  }

  public static LobbyIdStage builder() {
    return new Builder();
  }

  public interface LobbyIdStage {
    NamespaceIdStage lobbyId(UUID lobbyId);

    Builder from(LogsLobbySummary other);
  }

  public interface NamespaceIdStage {
    LobbyGroupNameIdStage namespaceId(UUID namespaceId);
  }

  public interface LobbyGroupNameIdStage {
    RegionIdStage lobbyGroupNameId(String lobbyGroupNameId);
  }

  public interface RegionIdStage {
    CreateTsStage regionId(UUID regionId);
  }

  public interface CreateTsStage {
    StatusStage createTs(String createTs);
  }

  public interface StatusStage {
    _FinalStage status(LogsLobbyStatus status);
  }

  public interface _FinalStage {
    LogsLobbySummary build();

    _FinalStage startTs(Optional<String> startTs);

    _FinalStage startTs(String startTs);

    _FinalStage readyTs(Optional<String> readyTs);

    _FinalStage readyTs(String readyTs);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LobbyIdStage, NamespaceIdStage, LobbyGroupNameIdStage, RegionIdStage, CreateTsStage, StatusStage, _FinalStage {
    private UUID lobbyId;

    private UUID namespaceId;

    private String lobbyGroupNameId;

    private UUID regionId;

    private String createTs;

    private LogsLobbyStatus status;

    private Optional<String> readyTs = Optional.empty();

    private Optional<String> startTs = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(LogsLobbySummary other) {
      lobbyId(other.getLobbyId());
      namespaceId(other.getNamespaceId());
      lobbyGroupNameId(other.getLobbyGroupNameId());
      regionId(other.getRegionId());
      createTs(other.getCreateTs());
      startTs(other.getStartTs());
      readyTs(other.getReadyTs());
      status(other.getStatus());
      return this;
    }

    @Override
    @JsonSetter("lobby_id")
    public NamespaceIdStage lobbyId(UUID lobbyId) {
      this.lobbyId = lobbyId;
      return this;
    }

    @Override
    @JsonSetter("namespace_id")
    public LobbyGroupNameIdStage namespaceId(UUID namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    /**
     * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("lobby_group_name_id")
    public RegionIdStage lobbyGroupNameId(String lobbyGroupNameId) {
      this.lobbyGroupNameId = lobbyGroupNameId;
      return this;
    }

    @Override
    @JsonSetter("region_id")
    public CreateTsStage regionId(UUID regionId) {
      this.regionId = regionId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public StatusStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(LogsLobbyStatus status) {
      this.status = status;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage readyTs(String readyTs) {
      this.readyTs = Optional.of(readyTs);
      return this;
    }

    @Override
    @JsonSetter(
        value = "ready_ts",
        nulls = Nulls.SKIP
    )
    public _FinalStage readyTs(Optional<String> readyTs) {
      this.readyTs = readyTs;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage startTs(String startTs) {
      this.startTs = Optional.of(startTs);
      return this;
    }

    @Override
    @JsonSetter(
        value = "start_ts",
        nulls = Nulls.SKIP
    )
    public _FinalStage startTs(Optional<String> startTs) {
      this.startTs = startTs;
      return this;
    }

    @Override
    public LogsLobbySummary build() {
      return new LogsLobbySummary(lobbyId, namespaceId, lobbyGroupNameId, regionId, createTs, startTs, readyTs, status);
    }
  }
}
