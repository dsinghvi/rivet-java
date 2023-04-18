package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = Message.Builder.class
)
public final class Message {
  private final UUID chatMessageId;

  private final UUID threadId;

  private final String sendTs;

  private final MessageBody body;

  private int _cachedHashCode;

  Message(UUID chatMessageId, UUID threadId, String sendTs, MessageBody body) {
    this.chatMessageId = chatMessageId;
    this.threadId = threadId;
    this.sendTs = sendTs;
    this.body = body;
  }

  @JsonProperty("chat_message_id")
  public UUID getChatMessageId() {
    return chatMessageId;
  }

  @JsonProperty("thread_id")
  public UUID getThreadId() {
    return threadId;
  }

  @JsonProperty("send_ts")
  public String getSendTs() {
    return sendTs;
  }

  @JsonProperty("body")
  public MessageBody getBody() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Message && equalTo((Message) other);
  }

  private boolean equalTo(Message other) {
    return chatMessageId.equals(other.chatMessageId) && threadId.equals(other.threadId) && sendTs.equals(other.sendTs) && body.equals(other.body);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.chatMessageId, this.threadId, this.sendTs, this.body);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Message{" + "chatMessageId: " + chatMessageId + ", threadId: " + threadId + ", sendTs: " + sendTs + ", body: " + body + "}";
  }

  public static ChatMessageIdStage builder() {
    return new Builder();
  }

  public interface ChatMessageIdStage {
    ThreadIdStage chatMessageId(UUID chatMessageId);

    Builder from(Message other);
  }

  public interface ThreadIdStage {
    SendTsStage threadId(UUID threadId);
  }

  public interface SendTsStage {
    BodyStage sendTs(String sendTs);
  }

  public interface BodyStage {
    _FinalStage body(MessageBody body);
  }

  public interface _FinalStage {
    Message build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ChatMessageIdStage, ThreadIdStage, SendTsStage, BodyStage, _FinalStage {
    private UUID chatMessageId;

    private UUID threadId;

    private String sendTs;

    private MessageBody body;

    private Builder() {
    }

    @Override
    public Builder from(Message other) {
      chatMessageId(other.getChatMessageId());
      threadId(other.getThreadId());
      sendTs(other.getSendTs());
      body(other.getBody());
      return this;
    }

    @Override
    @JsonSetter("chat_message_id")
    public ThreadIdStage chatMessageId(UUID chatMessageId) {
      this.chatMessageId = chatMessageId;
      return this;
    }

    @Override
    @JsonSetter("thread_id")
    public SendTsStage threadId(UUID threadId) {
      this.threadId = threadId;
      return this;
    }

    @Override
    @JsonSetter("send_ts")
    public BodyStage sendTs(String sendTs) {
      this.sendTs = sendTs;
      return this;
    }

    @Override
    @JsonSetter("body")
    public _FinalStage body(MessageBody body) {
      this.body = body;
      return this;
    }

    @Override
    public Message build() {
      return new Message(chatMessageId, threadId, sendTs, body);
    }
  }
}