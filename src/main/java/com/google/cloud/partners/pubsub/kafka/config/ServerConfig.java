package com.google.cloud.partners.pubsub.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

@AutoValue
@AutoValue.CopyAnnotations
@JsonSerialize(as = ServerConfig.class)
@JsonDeserialize(builder = ServerConfig.Builder.class)
public abstract class ServerConfig {

  public static Builder builder() {
    return Builder.builder();
  }

  @JsonProperty("port")
  public abstract Integer getPort();

  @JsonProperty("security")
  @Nullable
  public abstract SecurityConfig getSecurityConfig();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_ServerConfig.Builder();
    }

    @JsonProperty("port")
    public abstract Builder setPort(Integer port);

    @JsonProperty("security")
    public abstract Builder setSecurityConfig(SecurityConfig value);

    public abstract ServerConfig build();
  }
}
