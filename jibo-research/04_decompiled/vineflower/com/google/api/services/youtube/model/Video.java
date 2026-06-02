package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

public final class Video extends GenericJson {
   @Key
   private String accessToken;
   @Key
   private VideoAgeGating ageGating;
   @Key
   private VideoContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private VideoFileDetails fileDetails;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private VideoLiveStreamingDetails liveStreamingDetails;
   @Key
   private Map<String, VideoLocalization> localizations;
   @Key
   private VideoMonetizationDetails monetizationDetails;
   @Key
   private VideoPlayer player;
   @Key
   private VideoProcessingDetails processingDetails;
   @Key
   private VideoProjectDetails projectDetails;
   @Key
   private VideoRecordingDetails recordingDetails;
   @Key
   private VideoSnippet snippet;
   @Key
   private VideoStatistics statistics;
   @Key
   private VideoStatus status;
   @Key
   private VideoSuggestions suggestions;
   @Key
   private VideoTopicDetails topicDetails;

   public Video clone() {
      return (Video)super.clone();
   }

   public String getAccessToken() {
      return this.accessToken;
   }

   public VideoAgeGating getAgeGating() {
      return this.ageGating;
   }

   public VideoContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public String getEtag() {
      return this.etag;
   }

   public VideoFileDetails getFileDetails() {
      return this.fileDetails;
   }

   public String getId() {
      return this.id;
   }

   public String getKind() {
      return this.kind;
   }

   public VideoLiveStreamingDetails getLiveStreamingDetails() {
      return this.liveStreamingDetails;
   }

   public Map<String, VideoLocalization> getLocalizations() {
      return this.localizations;
   }

   public VideoMonetizationDetails getMonetizationDetails() {
      return this.monetizationDetails;
   }

   public VideoPlayer getPlayer() {
      return this.player;
   }

   public VideoProcessingDetails getProcessingDetails() {
      return this.processingDetails;
   }

   public VideoProjectDetails getProjectDetails() {
      return this.projectDetails;
   }

   public VideoRecordingDetails getRecordingDetails() {
      return this.recordingDetails;
   }

   public VideoSnippet getSnippet() {
      return this.snippet;
   }

   public VideoStatistics getStatistics() {
      return this.statistics;
   }

   public VideoStatus getStatus() {
      return this.status;
   }

   public VideoSuggestions getSuggestions() {
      return this.suggestions;
   }

   public VideoTopicDetails getTopicDetails() {
      return this.topicDetails;
   }

   public Video set(String var1, Object var2) {
      return (Video)super.set(var1, var2);
   }

   public Video setAccessToken(String var1) {
      this.accessToken = var1;
      return this;
   }

   public Video setAgeGating(VideoAgeGating var1) {
      this.ageGating = var1;
      return this;
   }

   public Video setContentDetails(VideoContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public Video setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Video setFileDetails(VideoFileDetails var1) {
      this.fileDetails = var1;
      return this;
   }

   public Video setId(String var1) {
      this.id = var1;
      return this;
   }

   public Video setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Video setLiveStreamingDetails(VideoLiveStreamingDetails var1) {
      this.liveStreamingDetails = var1;
      return this;
   }

   public Video setLocalizations(Map<String, VideoLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public Video setMonetizationDetails(VideoMonetizationDetails var1) {
      this.monetizationDetails = var1;
      return this;
   }

   public Video setPlayer(VideoPlayer var1) {
      this.player = var1;
      return this;
   }

   public Video setProcessingDetails(VideoProcessingDetails var1) {
      this.processingDetails = var1;
      return this;
   }

   public Video setProjectDetails(VideoProjectDetails var1) {
      this.projectDetails = var1;
      return this;
   }

   public Video setRecordingDetails(VideoRecordingDetails var1) {
      this.recordingDetails = var1;
      return this;
   }

   public Video setSnippet(VideoSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Video setStatistics(VideoStatistics var1) {
      this.statistics = var1;
      return this;
   }

   public Video setStatus(VideoStatus var1) {
      this.status = var1;
      return this;
   }

   public Video setSuggestions(VideoSuggestions var1) {
      this.suggestions = var1;
      return this;
   }

   public Video setTopicDetails(VideoTopicDetails var1) {
      this.topicDetails = var1;
      return this;
   }
}
