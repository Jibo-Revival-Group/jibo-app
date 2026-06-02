package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: id */
    @Key
    private String f8513id;

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

    public String getAccessToken() {
        return this.accessToken;
    }

    public Video setAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public VideoAgeGating getAgeGating() {
        return this.ageGating;
    }

    public Video setAgeGating(VideoAgeGating videoAgeGating) {
        this.ageGating = videoAgeGating;
        return this;
    }

    public VideoContentDetails getContentDetails() {
        return this.contentDetails;
    }

    public Video setContentDetails(VideoContentDetails videoContentDetails) {
        this.contentDetails = videoContentDetails;
        return this;
    }

    public String getEtag() {
        return this.etag;
    }

    public Video setEtag(String str) {
        this.etag = str;
        return this;
    }

    public VideoFileDetails getFileDetails() {
        return this.fileDetails;
    }

    public Video setFileDetails(VideoFileDetails videoFileDetails) {
        this.fileDetails = videoFileDetails;
        return this;
    }

    public String getId() {
        return this.f8513id;
    }

    public Video setId(String str) {
        this.f8513id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Video setKind(String str) {
        this.kind = str;
        return this;
    }

    public VideoLiveStreamingDetails getLiveStreamingDetails() {
        return this.liveStreamingDetails;
    }

    public Video setLiveStreamingDetails(VideoLiveStreamingDetails videoLiveStreamingDetails) {
        this.liveStreamingDetails = videoLiveStreamingDetails;
        return this;
    }

    public Map<String, VideoLocalization> getLocalizations() {
        return this.localizations;
    }

    public Video setLocalizations(Map<String, VideoLocalization> map) {
        this.localizations = map;
        return this;
    }

    public VideoMonetizationDetails getMonetizationDetails() {
        return this.monetizationDetails;
    }

    public Video setMonetizationDetails(VideoMonetizationDetails videoMonetizationDetails) {
        this.monetizationDetails = videoMonetizationDetails;
        return this;
    }

    public VideoPlayer getPlayer() {
        return this.player;
    }

    public Video setPlayer(VideoPlayer videoPlayer) {
        this.player = videoPlayer;
        return this;
    }

    public VideoProcessingDetails getProcessingDetails() {
        return this.processingDetails;
    }

    public Video setProcessingDetails(VideoProcessingDetails videoProcessingDetails) {
        this.processingDetails = videoProcessingDetails;
        return this;
    }

    public VideoProjectDetails getProjectDetails() {
        return this.projectDetails;
    }

    public Video setProjectDetails(VideoProjectDetails videoProjectDetails) {
        this.projectDetails = videoProjectDetails;
        return this;
    }

    public VideoRecordingDetails getRecordingDetails() {
        return this.recordingDetails;
    }

    public Video setRecordingDetails(VideoRecordingDetails videoRecordingDetails) {
        this.recordingDetails = videoRecordingDetails;
        return this;
    }

    public VideoSnippet getSnippet() {
        return this.snippet;
    }

    public Video setSnippet(VideoSnippet videoSnippet) {
        this.snippet = videoSnippet;
        return this;
    }

    public VideoStatistics getStatistics() {
        return this.statistics;
    }

    public Video setStatistics(VideoStatistics videoStatistics) {
        this.statistics = videoStatistics;
        return this;
    }

    public VideoStatus getStatus() {
        return this.status;
    }

    public Video setStatus(VideoStatus videoStatus) {
        this.status = videoStatus;
        return this;
    }

    public VideoSuggestions getSuggestions() {
        return this.suggestions;
    }

    public Video setSuggestions(VideoSuggestions videoSuggestions) {
        this.suggestions = videoSuggestions;
        return this;
    }

    public VideoTopicDetails getTopicDetails() {
        return this.topicDetails;
    }

    public Video setTopicDetails(VideoTopicDetails videoTopicDetails) {
        this.topicDetails = videoTopicDetails;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Video set(String str, Object obj) {
        return (Video) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Video clone() {
        return (Video) super.clone();
    }
}
