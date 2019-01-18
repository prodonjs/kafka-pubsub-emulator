package com.google.cloud.partners.pubsub.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@AutoValue
@AutoValue.CopyAnnotations
@JsonSerialize(as = KafkaConfig.class)
@JsonDeserialize(builder = KafkaConfig.Builder.class)
public abstract class KafkaConfig {

  public static Builder builder() {
    return Builder.builder();
  }

  @JsonProperty("bootstrapServers")
  public abstract ImmutableList<String> getBootstrapServers();

  @JsonProperty("producerProperties")
  public abstract ImmutableMap<String, String> getProducerProperties();

  @JsonProperty("producerExecutors")
  @Nullable
  public abstract Integer getProducerExecutors();

  @JsonProperty("consumerProperties")
  public abstract ImmutableMap<String, String> getConsumerProperties();

  @JsonProperty("consumersPerSubscription")
  @Nullable
  public abstract Integer getConsumersPerSubscription();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_KafkaConfig.Builder();
    }

    @JsonProperty("bootstrapServers")
    public abstract Builder setBootstrapServers(List<String> value);

    @JsonProperty("producerProperties")
    public abstract Builder setProducerProperties(Map<String, String> value);

    @JsonProperty("producerExecutors")
    public abstract Builder setProducerExecutors(Integer value);

    @JsonProperty("consumerProperties")
    public abstract Builder setConsumerProperties(Map<String, String> value);

    @JsonProperty("consumersPerSubscription")
    public abstract Builder setConsumersPerSubscription(Integer value);

    public abstract KafkaConfig build();
  }
}
