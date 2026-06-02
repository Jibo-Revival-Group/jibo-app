package com.google.maps.model;

/* JADX INFO: loaded from: classes.dex */
public class AutocompletePrediction {
    public String description;
    public MatchedSubstring[] matchedSubstrings;
    public String placeId;
    public AutocompleteStructuredFormatting structuredFormatting;
    public Term[] terms;
    public String[] types;

    public static class MatchedSubstring {
        public int length;
        public int offset;
    }

    public static class Term {
        public int offset;
        public String value;
    }
}
