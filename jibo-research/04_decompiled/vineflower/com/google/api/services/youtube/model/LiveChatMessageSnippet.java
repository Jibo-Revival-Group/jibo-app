package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class LiveChatMessageSnippet extends GenericJson {
   @Key
   private String authorChannelId;
   @Key
   private String displayMessage;
   @Key
   private LiveChatFanFundingEventDetails fanFundingEventDetails;
   @Key
   private Boolean hasDisplayContent;
   @Key
   private String liveChatId;
   @Key
   private LiveChatMessageDeletedDetails messageDeletedDetails;
   @Key
   private LiveChatMessageRetractedDetails messageRetractedDetails;
   @Key
   private LiveChatPollClosedDetails pollClosedDetails;
   @Key
   private LiveChatPollEditedDetails pollEditedDetails;
   @Key
   private LiveChatPollOpenedDetails pollOpenedDetails;
   @Key
   private LiveChatPollVotedDetails pollVotedDetails;
   @Key
   private DateTime publishedAt;
   @Key
   private LiveChatSuperChatDetails superChatDetails;
   @Key
   private LiveChatTextMessageDetails textMessageDetails;
   @Key
   private String type;
   @Key
   private LiveChatUserBannedMessageDetails userBannedDetails;

   public LiveChatMessageSnippet clone() {
      return (LiveChatMessageSnippet)super.clone();
   }

   public String getAuthorChannelId() {
      return this.authorChannelId;
   }

   public String getDisplayMessage() {
      return this.displayMessage;
   }

   public LiveChatFanFundingEventDetails getFanFundingEventDetails() {
      return this.fanFundingEventDetails;
   }

   public Boolean getHasDisplayContent() {
      return this.hasDisplayContent;
   }

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public LiveChatMessageDeletedDetails getMessageDeletedDetails() {
      return this.messageDeletedDetails;
   }

   public LiveChatMessageRetractedDetails getMessageRetractedDetails() {
      return this.messageRetractedDetails;
   }

   public LiveChatPollClosedDetails getPollClosedDetails() {
      return this.pollClosedDetails;
   }

   public LiveChatPollEditedDetails getPollEditedDetails() {
      return this.pollEditedDetails;
   }

   public LiveChatPollOpenedDetails getPollOpenedDetails() {
      return this.pollOpenedDetails;
   }

   public LiveChatPollVotedDetails getPollVotedDetails() {
      return this.pollVotedDetails;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public LiveChatSuperChatDetails getSuperChatDetails() {
      return this.superChatDetails;
   }

   public LiveChatTextMessageDetails getTextMessageDetails() {
      return this.textMessageDetails;
   }

   public String getType() {
      return this.type;
   }

   public LiveChatUserBannedMessageDetails getUserBannedDetails() {
      return this.userBannedDetails;
   }

   public LiveChatMessageSnippet set(String var1, Object var2) {
      return (LiveChatMessageSnippet)super.set(var1, var2);
   }

   public LiveChatMessageSnippet setAuthorChannelId(String var1) {
      this.authorChannelId = var1;
      return this;
   }

   public LiveChatMessageSnippet setDisplayMessage(String var1) {
      this.displayMessage = var1;
      return this;
   }

   public LiveChatMessageSnippet setFanFundingEventDetails(LiveChatFanFundingEventDetails var1) {
      this.fanFundingEventDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setHasDisplayContent(Boolean var1) {
      this.hasDisplayContent = var1;
      return this;
   }

   public LiveChatMessageSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public LiveChatMessageSnippet setMessageDeletedDetails(LiveChatMessageDeletedDetails var1) {
      this.messageDeletedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setMessageRetractedDetails(LiveChatMessageRetractedDetails var1) {
      this.messageRetractedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setPollClosedDetails(LiveChatPollClosedDetails var1) {
      this.pollClosedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setPollEditedDetails(LiveChatPollEditedDetails var1) {
      this.pollEditedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setPollOpenedDetails(LiveChatPollOpenedDetails var1) {
      this.pollOpenedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setPollVotedDetails(LiveChatPollVotedDetails var1) {
      this.pollVotedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public LiveChatMessageSnippet setSuperChatDetails(LiveChatSuperChatDetails var1) {
      this.superChatDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setTextMessageDetails(LiveChatTextMessageDetails var1) {
      this.textMessageDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet setType(String var1) {
      this.type = var1;
      return this;
   }

   public LiveChatMessageSnippet setUserBannedDetails(LiveChatUserBannedMessageDetails var1) {
      this.userBannedDetails = var1;
      return this;
   }
}
