package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

public final class VideoFileDetails extends GenericJson {
   @Key
   private List<VideoFileDetailsAudioStream> audioStreams;
   @JsonString
   @Key
   private BigInteger bitrateBps;
   @Key
   private String container;
   @Key
   private String creationTime;
   @JsonString
   @Key
   private BigInteger durationMs;
   @Key
   private String fileName;
   @JsonString
   @Key
   private BigInteger fileSize;
   @Key
   private String fileType;
   @Key
   private List<VideoFileDetailsVideoStream> videoStreams;

   public VideoFileDetails clone() {
      return (VideoFileDetails)super.clone();
   }

   public List<VideoFileDetailsAudioStream> getAudioStreams() {
      return this.audioStreams;
   }

   public BigInteger getBitrateBps() {
      return this.bitrateBps;
   }

   public String getContainer() {
      return this.container;
   }

   public String getCreationTime() {
      return this.creationTime;
   }

   public BigInteger getDurationMs() {
      return this.durationMs;
   }

   public String getFileName() {
      return this.fileName;
   }

   public BigInteger getFileSize() {
      return this.fileSize;
   }

   public String getFileType() {
      return this.fileType;
   }

   public List<VideoFileDetailsVideoStream> getVideoStreams() {
      return this.videoStreams;
   }

   public VideoFileDetails set(String var1, Object var2) {
      return (VideoFileDetails)super.set(var1, var2);
   }

   public VideoFileDetails setAudioStreams(List<VideoFileDetailsAudioStream> var1) {
      this.audioStreams = var1;
      return this;
   }

   public VideoFileDetails setBitrateBps(BigInteger var1) {
      this.bitrateBps = var1;
      return this;
   }

   public VideoFileDetails setContainer(String var1) {
      this.container = var1;
      return this;
   }

   public VideoFileDetails setCreationTime(String var1) {
      this.creationTime = var1;
      return this;
   }

   public VideoFileDetails setDurationMs(BigInteger var1) {
      this.durationMs = var1;
      return this;
   }

   public VideoFileDetails setFileName(String var1) {
      this.fileName = var1;
      return this;
   }

   public VideoFileDetails setFileSize(BigInteger var1) {
      this.fileSize = var1;
      return this;
   }

   public VideoFileDetails setFileType(String var1) {
      this.fileType = var1;
      return this;
   }

   public VideoFileDetails setVideoStreams(List<VideoFileDetailsVideoStream> var1) {
      this.videoStreams = var1;
      return this;
   }
}
