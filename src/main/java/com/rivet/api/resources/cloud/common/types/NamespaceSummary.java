package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = NamespaceSummary.Builder.class
)
public final class NamespaceSummary {
  private final UUID namespaceId;

  private final String createTs;

  private final String displayName;

  private final UUID versionId;

  private final String nameId;

  private int _cachedHashCode;

  NamespaceSummary(UUID namespaceId, String createTs, String displayName, UUID versionId,
      String nameId) {
    this.namespaceId = namespaceId;
    this.createTs = createTs;
    this.displayName = displayName;
    this.versionId = versionId;
    this.nameId = nameId;
  }

  @JsonProperty("namespace_id")
  public UUID getNamespaceId() {
    return namespaceId;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty("version_id")
  public UUID getVersionId() {
    return versionId;
  }

  /**
   * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
   */
  @JsonProperty("name_id")
  public String getNameId() {
    return nameId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NamespaceSummary && equalTo((NamespaceSummary) other);
  }

  private boolean equalTo(NamespaceSummary other) {
    return namespaceId.equals(other.namespaceId) && createTs.equals(other.createTs) && displayName.equals(other.displayName) && versionId.equals(other.versionId) && nameId.equals(other.nameId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespaceId, this.createTs, this.displayName, this.versionId, this.nameId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NamespaceSummary{" + "namespaceId: " + namespaceId + ", createTs: " + createTs + ", displayName: " + displayName + ", versionId: " + versionId + ", nameId: " + nameId + "}";
  }

  public static NamespaceIdStage builder() {
    return new Builder();
  }

  public interface NamespaceIdStage {
    CreateTsStage namespaceId(UUID namespaceId);

    Builder from(NamespaceSummary other);
  }

  public interface CreateTsStage {
    DisplayNameStage createTs(String createTs);
  }

  public interface DisplayNameStage {
    VersionIdStage displayName(String displayName);
  }

  public interface VersionIdStage {
    NameIdStage versionId(UUID versionId);
  }

  public interface NameIdStage {
    _FinalStage nameId(String nameId);
  }

  public interface _FinalStage {
    NamespaceSummary build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NamespaceIdStage, CreateTsStage, DisplayNameStage, VersionIdStage, NameIdStage, _FinalStage {
    private UUID namespaceId;

    private String createTs;

    private String displayName;

    private UUID versionId;

    private String nameId;

    private Builder() {
    }

    @Override
    public Builder from(NamespaceSummary other) {
      namespaceId(other.getNamespaceId());
      createTs(other.getCreateTs());
      displayName(other.getDisplayName());
      versionId(other.getVersionId());
      nameId(other.getNameId());
      return this;
    }

    @Override
    @JsonSetter("namespace_id")
    public CreateTsStage namespaceId(UUID namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public DisplayNameStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    /**
     * <p>Represent a resource's readable display name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("display_name")
    public VersionIdStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    @JsonSetter("version_id")
    public NameIdStage versionId(UUID versionId) {
      this.versionId = versionId;
      return this;
    }

    /**
     * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("name_id")
    public _FinalStage nameId(String nameId) {
      this.nameId = nameId;
      return this;
    }

    @Override
    public NamespaceSummary build() {
      return new NamespaceSummary(namespaceId, createTs, displayName, versionId, nameId);
    }
  }
}
