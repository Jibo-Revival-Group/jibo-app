package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoStatistics extends GenericJson {
   @JsonString
   @Key
   private BigInteger commentCount;
   @JsonString
   @Key
   private BigInteger dislikeCount;
   @JsonString
   @Key
   private BigInteger favoriteCount;
   @JsonString
   @Key
   private BigInteger likeCount;
   @JsonString
   @Key
   private BigInteger viewCount;

   public VideoStatistics clone() {
      return (VideoStatistics)super.clone();
   }

   public BigInteger getCommentCount() {
      return this.commentCount;
   }

   public BigInteger getDislikeCount() {
      return this.dislikeCount;
   }

   public BigInteger getFavoriteCount() {
      return this.favoriteCount;
   }

   public BigInteger getLikeCount() {
      return this.likeCount;
   }

   public BigInteger getViewCount() {
      return this.viewCount;
   }

   public VideoStatistics set(String var1, Object var2) {
      return (VideoStatistics)super.set(var1, var2);
   }

   public VideoStatistics setCommentCount(BigInteger var1) {
      this.commentCount = var1;
      return this;
   }

   public VideoStatistics setDislikeCount(BigInteger var1) {
      this.dislikeCount = var1;
      return this;
   }

   public VideoStatistics setFavoriteCount(BigInteger var1) {
      this.favoriteCount = var1;
      return this;
   }

   public VideoStatistics setLikeCount(BigInteger var1) {
      this.likeCount = var1;
      return this;
   }

   public VideoStatistics setViewCount(BigInteger var1) {
      this.viewCount = var1;
      return this;
   }
}
