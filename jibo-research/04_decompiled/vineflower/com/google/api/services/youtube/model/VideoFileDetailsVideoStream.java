package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoFileDetailsVideoStream extends GenericJson {
   @Key
   private Double aspectRatio;
   @JsonString
   @Key
   private BigInteger bitrateBps;
   @Key
   private String codec;
   @Key
   private Double frameRateFps;
   @Key
   private Long heightPixels;
   @Key
   private String rotation;
   @Key
   private String vendor;
   @Key
   private Long widthPixels;

   public VideoFileDetailsVideoStream clone() {
      return (VideoFileDetailsVideoStream)super.clone();
   }

   public Double getAspectRatio() {
      return this.aspectRatio;
   }

   public BigInteger getBitrateBps() {
      return this.bitrateBps;
   }

   public String getCodec() {
      return this.codec;
   }

   public Double getFrameRateFps() {
      return this.frameRateFps;
   }

   public Long getHeightPixels() {
      return this.heightPixels;
   }

   public String getRotation() {
      return this.rotation;
   }

   public String getVendor() {
      return this.vendor;
   }

   public Long getWidthPixels() {
      return this.widthPixels;
   }

   public VideoFileDetailsVideoStream set(String var1, Object var2) {
      return (VideoFileDetailsVideoStream)super.set(var1, var2);
   }

   public VideoFileDetailsVideoStream setAspectRatio(Double var1) {
      this.aspectRatio = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setBitrateBps(BigInteger var1) {
      this.bitrateBps = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setCodec(String var1) {
      this.codec = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setFrameRateFps(Double var1) {
      this.frameRateFps = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setHeightPixels(Long var1) {
      this.heightPixels = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setRotation(String var1) {
      this.rotation = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setVendor(String var1) {
      this.vendor = var1;
      return this;
   }

   public VideoFileDetailsVideoStream setWidthPixels(Long var1) {
      this.widthPixels = var1;
      return this;
   }
}
