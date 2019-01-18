package com.google.cloud.partners.pubsub.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import java.util.List;

@AutoValue
@AutoValue.CopyAnnotations
@JsonSerialize(as = TopicConfig.class)
@JsonDeserialize(builder = TopicConfig.Builder.class)
public abstract class TopicConfig {

  public static Builder builder() {
    return Builder.builder();
  }

  @JsonProperty("name")
  public abstract String getName();

  @JsonProperty("kafkaTopic")
  public abstract String getKafkaTopic();

  @JsonProperty("subscriptions")
  public abstract ImmutableList<String> getSubscriptions();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_TopicConfig.Builder();
    }

    @JsonProperty("name")
    public abstract Builder setName(String value);

    @JsonProperty("kafkaTopic")
    public abstract Builder setKafkaTopic(String value);

    @JsonProperty("subscriptions")
    public abstract Builder setSubscriptions(List<String> value);

    public abstract ImmutableList.Builder<String> subscriptionsBuilder();

    public abstract TopicConfig build();
  }
}
