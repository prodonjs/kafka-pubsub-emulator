package com.google.cloud.partners.pubsub.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;

@AutoValue
@AutoValue.CopyAnnotations
@JsonSerialize(as = SecurityConfig.class)
@JsonDeserialize(builder = SecurityConfig.Builder.class)
public abstract class SecurityConfig {

  public static Builder builder() {
    return Builder.builder();
  }

  @JsonProperty("certChainFile")
  public abstract String getCertificateChainFile();

  @JsonProperty("privateKeyFile")
  public abstract String getPrivateKeyFile();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_SecurityConfig.Builder();
    }

    @JsonProperty("certChainFile")
    public abstract Builder setCertificateChainFile(String value);

    @JsonProperty("privateKeyFile")
    public abstract Builder setPrivateKeyFile(String value);

    public abstract SecurityConfig build();
  }
}
