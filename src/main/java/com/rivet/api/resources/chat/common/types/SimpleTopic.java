package com.rivet.api.resources.chat.common.types;

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

@JsonDeserialize(
    builder = SimpleTopic.Builder.class
)
public final class SimpleTopic {
  private final Optional<SimpleTopicGroup> group;

  private final Optional<SimpleTopicParty> party;

  private final Optional<SimpleTopicDirect> direct;

  private int _cachedHashCode;

  SimpleTopic(Optional<SimpleTopicGroup> group, Optional<SimpleTopicParty> party,
      Optional<SimpleTopicDirect> direct) {
    this.group = group;
    this.party = party;
    this.direct = direct;
  }

  @JsonProperty("group")
  public Optional<SimpleTopicGroup> getGroup() {
    return group;
  }

  @JsonProperty("party")
  public Optional<SimpleTopicParty> getParty() {
    return party;
  }

  @JsonProperty("direct")
  public Optional<SimpleTopicDirect> getDirect() {
    return direct;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SimpleTopic && equalTo((SimpleTopic) other);
  }

  private boolean equalTo(SimpleTopic other) {
    return group.equals(other.group) && party.equals(other.party) && direct.equals(other.direct);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.group, this.party, this.direct);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SimpleTopic{" + "group: " + group + ", party: " + party + ", direct: " + direct + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<SimpleTopicGroup> group = Optional.empty();

    private Optional<SimpleTopicParty> party = Optional.empty();

    private Optional<SimpleTopicDirect> direct = Optional.empty();

    private Builder() {
    }

    public Builder from(SimpleTopic other) {
      group(other.getGroup());
      party(other.getParty());
      direct(other.getDirect());
      return this;
    }

    @JsonSetter(
        value = "group",
        nulls = Nulls.SKIP
    )
    public Builder group(Optional<SimpleTopicGroup> group) {
      this.group = group;
      return this;
    }

    public Builder group(SimpleTopicGroup group) {
      this.group = Optional.of(group);
      return this;
    }

    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public Builder party(Optional<SimpleTopicParty> party) {
      this.party = party;
      return this;
    }

    public Builder party(SimpleTopicParty party) {
      this.party = Optional.of(party);
      return this;
    }

    @JsonSetter(
        value = "direct",
        nulls = Nulls.SKIP
    )
    public Builder direct(Optional<SimpleTopicDirect> direct) {
      this.direct = direct;
      return this;
    }

    public Builder direct(SimpleTopicDirect direct) {
      this.direct = Optional.of(direct);
      return this;
    }

    public SimpleTopic build() {
      return new SimpleTopic(group, party, direct);
    }
  }
}