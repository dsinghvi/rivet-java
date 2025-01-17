package com.rivet.api.resources.matchmaker.regions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.matchmaker.common.types.RegionInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = ListRegionsResponse.Builder.class
)
public final class ListRegionsResponse {
  private final List<RegionInfo> regions;

  private int _cachedHashCode;

  ListRegionsResponse(List<RegionInfo> regions) {
    this.regions = regions;
  }

  @JsonProperty("regions")
  public List<RegionInfo> getRegions() {
    return regions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListRegionsResponse && equalTo((ListRegionsResponse) other);
  }

  private boolean equalTo(ListRegionsResponse other) {
    return regions.equals(other.regions);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regions);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ListRegionsResponse{" + "regions: " + regions + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<RegionInfo> regions = new ArrayList<>();

    private Builder() {
    }

    public Builder from(ListRegionsResponse other) {
      regions(other.getRegions());
      return this;
    }

    @JsonSetter(
        value = "regions",
        nulls = Nulls.SKIP
    )
    public Builder regions(List<RegionInfo> regions) {
      this.regions.clear();
      this.regions.addAll(regions);
      return this;
    }

    public Builder addRegions(RegionInfo regions) {
      this.regions.add(regions);
      return this;
    }

    public Builder addAllRegions(List<RegionInfo> regions) {
      this.regions.addAll(regions);
      return this;
    }

    public ListRegionsResponse build() {
      return new ListRegionsResponse(regions);
    }
  }
}
