package com.example.chatmemorylab.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

  private final ChatClient chatClient;

  @PostMapping("")
  public ChatClientResponse chat(@RequestBody String message) {

    String conversationId = "test-1";

    return chatClient.prompt().user(message).advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId)).call()
        .chatClientResponse();
  }

}
