package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class ChannelStatistics extends GenericJson {
   @JsonString
   @Key
   private BigInteger commentCount;
   @Key
   private Boolean hiddenSubscriberCount;
   @JsonString
   @Key
   private BigInteger subscriberCount;
   @JsonString
   @Key
   private BigInteger videoCount;
   @JsonString
   @Key
   private BigInteger viewCount;

   public ChannelStatistics clone() {
      return (ChannelStatistics)super.clone();
   }

   public BigInteger getCommentCount() {
      return this.commentCount;
   }

   public Boolean getHiddenSubscriberCount() {
      return this.hiddenSubscriberCount;
   }

   public BigInteger getSubscriberCount() {
      return this.subscriberCount;
   }

   public BigInteger getVideoCount() {
      return this.videoCount;
   }

   public BigInteger getViewCount() {
      return this.viewCount;
   }

   public ChannelStatistics set(String var1, Object var2) {
      return (ChannelStatistics)super.set(var1, var2);
   }

   public ChannelStatistics setCommentCount(BigInteger var1) {
      this.commentCount = var1;
      return this;
   }

   public ChannelStatistics setHiddenSubscriberCount(Boolean var1) {
      this.hiddenSubscriberCount = var1;
      return this;
   }

   public ChannelStatistics setSubscriberCount(BigInteger var1) {
      this.subscriberCount = var1;
      return this;
   }

   public ChannelStatistics setVideoCount(BigInteger var1) {
      this.videoCount = var1;
      return this;
   }

   public ChannelStatistics setViewCount(BigInteger var1) {
      this.viewCount = var1;
      return this;
   }
}
