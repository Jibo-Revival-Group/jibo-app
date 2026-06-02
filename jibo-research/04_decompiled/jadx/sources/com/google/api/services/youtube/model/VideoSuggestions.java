package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VideoSuggestions extends GenericJson {

    @Key
    private List<String> editorSuggestions;

    @Key
    private List<String> processingErrors;

    @Key
    private List<String> processingHints;

    @Key
    private List<String> processingWarnings;

    @Key
    private List<VideoSuggestionsTagSuggestion> tagSuggestions;

    public List<String> getEditorSuggestions() {
        return this.editorSuggestions;
    }

    public VideoSuggestions setEditorSuggestions(List<String> list) {
        this.editorSuggestions = list;
        return this;
    }

    public List<String> getProcessingErrors() {
        return this.processingErrors;
    }

    public VideoSuggestions setProcessingErrors(List<String> list) {
        this.processingErrors = list;
        return this;
    }

    public List<String> getProcessingHints() {
        return this.processingHints;
    }

    public VideoSuggestions setProcessingHints(List<String> list) {
        this.processingHints = list;
        return this;
    }

    public List<String> getProcessingWarnings() {
        return this.processingWarnings;
    }

    public VideoSuggestions setProcessingWarnings(List<String> list) {
        this.processingWarnings = list;
        return this;
    }

    public List<VideoSuggestionsTagSuggestion> getTagSuggestions() {
        return this.tagSuggestions;
    }

    public VideoSuggestions setTagSuggestions(List<VideoSuggestionsTagSuggestion> list) {
        this.tagSuggestions = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoSuggestions set(String str, Object obj) {
        return (VideoSuggestions) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoSuggestions clone() {
        return (VideoSuggestions) super.clone();
    }
}
