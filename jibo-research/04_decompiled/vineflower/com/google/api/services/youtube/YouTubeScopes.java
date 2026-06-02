package com.google.api.services.youtube;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class YouTubeScopes {
   public static final String YOUTUBE = "https://www.googleapis.com/auth/youtube";
   public static final String YOUTUBEPARTNER = "https://www.googleapis.com/auth/youtubepartner";
   public static final String YOUTUBEPARTNER_CHANNEL_AUDIT = "https://www.googleapis.com/auth/youtubepartner-channel-audit";
   public static final String YOUTUBE_FORCE_SSL = "https://www.googleapis.com/auth/youtube.force-ssl";
   public static final String YOUTUBE_READONLY = "https://www.googleapis.com/auth/youtube.readonly";
   public static final String YOUTUBE_UPLOAD = "https://www.googleapis.com/auth/youtube.upload";

   private YouTubeScopes() {
   }

   public static Set<String> all() {
      HashSet var0 = new HashSet();
      var0.add("https://www.googleapis.com/auth/youtube");
      var0.add("https://www.googleapis.com/auth/youtube.force-ssl");
      var0.add("https://www.googleapis.com/auth/youtube.readonly");
      var0.add("https://www.googleapis.com/auth/youtube.upload");
      var0.add("https://www.googleapis.com/auth/youtubepartner");
      var0.add("https://www.googleapis.com/auth/youtubepartner-channel-audit");
      return Collections.unmodifiableSet(var0);
   }
}
