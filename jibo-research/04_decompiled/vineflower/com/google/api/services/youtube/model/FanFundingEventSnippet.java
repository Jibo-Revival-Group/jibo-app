package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class FanFundingEventSnippet extends GenericJson {
   @JsonString
   @Key
   private BigInteger amountMicros;
   @Key
   private String channelId;
   @Key
   private String commentText;
   @Key
   private DateTime createdAt;
   @Key
   private String currency;
   @Key
   private String displayString;
   @Key
   private ChannelProfileDetails supporterDetails;

   public FanFundingEventSnippet clone() {
      return (FanFundingEventSnippet)super.clone();
   }

   public BigInteger getAmountMicros() {
      return this.amountMicros;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public String getCommentText() {
      return this.commentText;
   }

   public DateTime getCreatedAt() {
      return this.createdAt;
   }

   public String getCurrency() {
      return this.currency;
   }

   public String getDisplayString() {
      return this.displayString;
   }

   public ChannelProfileDetails getSupporterDetails() {
      return this.supporterDetails;
   }

   public FanFundingEventSnippet set(String var1, Object var2) {
      return (FanFundingEventSnippet)super.set(var1, var2);
   }

   public FanFundingEventSnippet setAmountMicros(BigInteger var1) {
      this.amountMicros = var1;
      return this;
   }

   public FanFundingEventSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public FanFundingEventSnippet setCommentText(String var1) {
      this.commentText = var1;
      return this;
   }

   public FanFundingEventSnippet setCreatedAt(DateTime var1) {
      this.createdAt = var1;
      return this;
   }

   public FanFundingEventSnippet setCurrency(String var1) {
      this.currency = var1;
      return this;
   }

   public FanFundingEventSnippet setDisplayString(String var1) {
      this.displayString = var1;
      return this;
   }

   public FanFundingEventSnippet setSupporterDetails(ChannelProfileDetails var1) {
      this.supporterDetails = var1;
      return this;
   }
}
