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
@JsonSerialize(as = ProjectConfig.class)
@JsonDeserialize(builder = ProjectConfig.Builder.class)
public abstract class ProjectConfig {

  public static Builder builder() {
    return Builder.builder();
  }

  @JsonProperty("project")
  public abstract String getProject();

  @JsonProperty("topics")
  public abstract ImmutableList<TopicConfig> getTopics();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonCreator
    public static Builder builder() {
      return new AutoValue_ProjectConfig.Builder();
    }

    @JsonProperty("project")
    public abstract Builder setProject(String value);

    @JsonProperty("topics")
    public abstract Builder setTopics(List<TopicConfig> value);

    public abstract ImmutableList.Builder<TopicConfig> topicsBuilder();

    public abstract ProjectConfig build();
  }
}
