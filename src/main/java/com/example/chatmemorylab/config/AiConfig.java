package com.example.chatmemorylab.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

  @Bean
  ChatClient chatClient(ChatClient.Builder builder, SimpleLoggerAdvisor simpleLoggerAdvisor, ChatMemory chatMemory) {

    return builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build(), simpleLoggerAdvisor).build();
  }

  @Bean
  SimpleLoggerAdvisor simpleLoggerAdvisor() {
    return new SimpleLoggerAdvisor();
  }
}
