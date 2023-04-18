package com.rivet.api.resources.group.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = SearchRequest.Builder.class
)
public final class SearchRequest {
  private final String query;

  private final Optional<String> anchor;

  private final Optional<Double> limit;

  private int _cachedHashCode;

  SearchRequest(String query, Optional<String> anchor, Optional<Double> limit) {
    this.query = query;
    this.anchor = anchor;
    this.limit = limit;
  }

  /**
   * @return The query to match group display names against.
   */
  @JsonProperty("query")
  public String getQuery() {
    return query;
  }

  @JsonProperty("anchor")
  public Optional<String> getAnchor() {
    return anchor;
  }

  /**
   * @return Unsigned 32 bit integer.
   */
  @JsonProperty("limit")
  public Optional<Double> getLimit() {
    return limit;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SearchRequest && equalTo((SearchRequest) other);
  }

  private boolean equalTo(SearchRequest other) {
    return query.equals(other.query) && anchor.equals(other.anchor) && limit.equals(other.limit);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.query, this.anchor, this.limit);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SearchRequest{" + "query: " + query + ", anchor: " + anchor + ", limit: " + limit + "}";
  }

  public static QueryStage builder() {
    return new Builder();
  }

  public interface QueryStage {
    _FinalStage query(String query);

    Builder from(SearchRequest other);
  }

  public interface _FinalStage {
    SearchRequest build();

    _FinalStage anchor(Optional<String> anchor);

    _FinalStage anchor(String anchor);

    _FinalStage limit(Optional<Double> limit);

    _FinalStage limit(Double limit);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements QueryStage, _FinalStage {
    private String query;

    private Optional<Double> limit = Optional.empty();

    private Optional<String> anchor = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(SearchRequest other) {
      query(other.getQuery());
      anchor(other.getAnchor());
      limit(other.getLimit());
      return this;
    }

    /**
     * <p>The query to match group display names against.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("query")
    public _FinalStage query(String query) {
      this.query = query;
      return this;
    }

    /**
     * <p>Unsigned 32 bit integer.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage limit(Double limit) {
      this.limit = Optional.of(limit);
      return this;
    }

    @Override
    @JsonSetter(
        value = "limit",
        nulls = Nulls.SKIP
    )
    public _FinalStage limit(Optional<Double> limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public _FinalStage anchor(String anchor) {
      this.anchor = Optional.of(anchor);
      return this;
    }

    @Override
    @JsonSetter(
        value = "anchor",
        nulls = Nulls.SKIP
    )
    public _FinalStage anchor(Optional<String> anchor) {
      this.anchor = anchor;
      return this;
    }

    @Override
    public SearchRequest build() {
      return new SearchRequest(query, anchor, limit);
    }
  }
}