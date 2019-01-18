package com.google.cloud.partners.pubsub.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;

@AutoValue
@AutoValue.CopyAnnotations
@JsonSerialize(as = EmulatorConfig.class)
@JsonDeserialize(builder = EmulatorConfig.Builder.class)
public abstract class EmulatorConfig {

  public static Builder builder() {
    return Builder.builder();
  }

  @JsonProperty("server")
  public abstract ServerConfig getServer();

  @JsonProperty("pubsub")
  public abstract PubSubConfig getPubSub();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_EmulatorConfig.Builder();
    }

    @JsonProperty("server")
    public abstract Builder setServer(ServerConfig value);

    @JsonProperty("pubsub")
    public abstract Builder setPubSub(PubSubConfig value);

    public abstract EmulatorConfig build();
  }
}
