package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoFileDetailsAudioStream extends GenericJson {
   @JsonString
   @Key
   private BigInteger bitrateBps;
   @Key
   private Long channelCount;
   @Key
   private String codec;
   @Key
   private String vendor;

   public VideoFileDetailsAudioStream clone() {
      return (VideoFileDetailsAudioStream)super.clone();
   }

   public BigInteger getBitrateBps() {
      return this.bitrateBps;
   }

   public Long getChannelCount() {
      return this.channelCount;
   }

   public String getCodec() {
      return this.codec;
   }

   public String getVendor() {
      return this.vendor;
   }

   public VideoFileDetailsAudioStream set(String var1, Object var2) {
      return (VideoFileDetailsAudioStream)super.set(var1, var2);
   }

   public VideoFileDetailsAudioStream setBitrateBps(BigInteger var1) {
      this.bitrateBps = var1;
      return this;
   }

   public VideoFileDetailsAudioStream setChannelCount(Long var1) {
      this.channelCount = var1;
      return this;
   }

   public VideoFileDetailsAudioStream setCodec(String var1) {
      this.codec = var1;
      return this;
   }

   public VideoFileDetailsAudioStream setVendor(String var1) {
      this.vendor = var1;
      return this;
   }
}
