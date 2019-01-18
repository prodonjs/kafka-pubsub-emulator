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
@JsonSerialize(as = PubSubConfig.class)
@JsonDeserialize(builder = PubSubConfig.Builder.class)
public abstract class PubSubConfig {

  public static Builder builder() {
    return Builder.builder();
  }


  @JsonProperty("projects")
  public abstract ImmutableList<ProjectConfig> getProjects();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_PubSubConfig.Builder();
    }

    @JsonProperty("projects")
    public abstract Builder setProjects(List<ProjectConfig> value);

    public abstract ImmutableList.Builder<ProjectConfig> projectsBuilder();

    public abstract PubSubConfig build();
  }
}
