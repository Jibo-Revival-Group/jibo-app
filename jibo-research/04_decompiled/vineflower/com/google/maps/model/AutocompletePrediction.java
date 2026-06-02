package com.google.maps.model;

public class AutocompletePrediction {
   public String description;
   public AutocompletePrediction.MatchedSubstring[] matchedSubstrings;
   public String placeId;
   public AutocompleteStructuredFormatting structuredFormatting;
   public AutocompletePrediction.Term[] terms;
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
