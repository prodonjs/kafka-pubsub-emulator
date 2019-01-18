package com.google.cloud.partners.pubsub.kafka.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collections;
import org.junit.Test;

public class EmulatorConfigTest {

  private final ObjectMapper objectMapper =
      new ObjectMapper(new YAMLFactory().configure(Feature.MINIMIZE_QUOTES, true))
          .setSerializationInclusion(Include.NON_NULL);

  @Test
  public void configFromYaml() throws IOException {
    String yaml =
        "server:\n"
            + "  port: 8080\n"
            + "pubsub:\n"
            + "  projects:\n"
            + "  - project: project-1\n"
            + "    topics:\n"
            + "    - name: topic-1\n"
            + "      kafkaTopic: kafka-topic-1\n"
            + "      subscriptions:\n"
            + "      - subscription-1\n"
            + "    - name: topic-2\n"
            + "      kafkaTopic: kafka-topic-2\n"
            + "      subscriptions:\n"
            + "      - subscription-1\n"
            + "      - subscription-2\n"
            + "  - project: project-2\n"
            + "    topics:\n"
            + "    - name: topic-1\n"
            + "      kafkaTopic: kafka-topic-1\n"
            + "      subscriptions:\n"
            + "      - subscription-1\n"
            + "    - name: topic-2\n"
            + "      kafkaTopic: kafka-topic-2\n"
            + "      subscriptions:\n"
            + "      - subscription-1\n"
            + "      - subscription-2";
    EmulatorConfig config = objectMapper.readValue(yaml, EmulatorConfig.class);
    System.out.println(config);
  }

  @Test
  public void configToYaml() throws IOException {
    ProjectConfig project1 =
        ProjectConfig.builder()
            .setProject("project-1")
            .setTopics(
                ImmutableList.of(
                    TopicConfig.builder()
                        .setName("topic-1")
                        .setKafkaTopic("kafka-topic-1")
                        .setSubscriptions(Collections.singletonList("subscription-1"))
                        .build(),
                    TopicConfig.builder()
                        .setName("topic-2")
                        .setKafkaTopic("kafka-topic-2")
                        .setSubscriptions(ImmutableList.of("subscription-1", "subscription-2"))
                        .build()))
            .build();
    ProjectConfig project2 = project1.toBuilder().setProject("project-2").build();

    EmulatorConfig config =
        EmulatorConfig.builder()
            .setServer(ServerConfig.builder().setPort(8080).build())
            .setPubSub(
                PubSubConfig.builder().setProjects(ImmutableList.of(project1, project2)).build())
            .build();

    String yaml = objectMapper.writeValueAsString(config);
    System.out.println(yaml);
  }

  @Test
  public void kafkaFromYaml() throws IOException {
    String yaml =
        "bootstrapServers:\n"
            + "- server1:2192\n"
            + "- server2:2192\n"
            + "producerProperties:\n"
            + "  max.poll.records: 1000\n"
            + "producerExecutors: 10\n"
            + "consumerProperties:\n"
            + "  linger.ms: 5\n"
            + "  batch.size: 1000000\n"
            + "  buffer.memory: 32000000\n"
            + "consumersPerSubscription: 4";
    KafkaConfig config = objectMapper.readValue(yaml, KafkaConfig.class);
    System.out.println(config);
  }

  @Test
  public void kafkaToYaml() throws JsonProcessingException {
    KafkaConfig config =
        KafkaConfig.builder()
            .setBootstrapServers(ImmutableList.of("server1:2192", "server2:2192"))
            .setProducerProperties(ImmutableMap.of("max.poll.records", "1000"))
            .setProducerExecutors(10)
            .setConsumerProperties(
                new ImmutableMap.Builder<String, String>()
                    .put("linger.ms", "5")
                    .put("batch.size", "1000000")
                    .put("buffer.memory", "32000000")
                    .build())
            .setConsumersPerSubscription(4)
            .build();
    String yaml = objectMapper.writeValueAsString(config);
    System.out.println(yaml);
  }
}
