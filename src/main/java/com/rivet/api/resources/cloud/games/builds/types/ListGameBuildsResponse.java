package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.BuildSummary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = ListGameBuildsResponse.Builder.class
)
public final class ListGameBuildsResponse {
  private final List<BuildSummary> builds;

  private int _cachedHashCode;

  ListGameBuildsResponse(List<BuildSummary> builds) {
    this.builds = builds;
  }

  /**
   * @return A list of build summaries.
   */
  @JsonProperty("builds")
  public List<BuildSummary> getBuilds() {
    return builds;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListGameBuildsResponse && equalTo((ListGameBuildsResponse) other);
  }

  private boolean equalTo(ListGameBuildsResponse other) {
    return builds.equals(other.builds);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.builds);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ListGameBuildsResponse{" + "builds: " + builds + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<BuildSummary> builds = new ArrayList<>();

    private Builder() {
    }

    public Builder from(ListGameBuildsResponse other) {
      builds(other.getBuilds());
      return this;
    }

    @JsonSetter(
        value = "builds",
        nulls = Nulls.SKIP
    )
    public Builder builds(List<BuildSummary> builds) {
      this.builds.clear();
      this.builds.addAll(builds);
      return this;
    }

    public Builder addBuilds(BuildSummary builds) {
      this.builds.add(builds);
      return this;
    }

    public Builder addAllBuilds(List<BuildSummary> builds) {
      this.builds.addAll(builds);
      return this;
    }

    public ListGameBuildsResponse build() {
      return new ListGameBuildsResponse(builds);
    }
  }
}
