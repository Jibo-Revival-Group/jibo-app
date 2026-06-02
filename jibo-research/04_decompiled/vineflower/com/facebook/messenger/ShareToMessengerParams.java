package com.facebook.messenger;

import android.net.Uri;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ShareToMessengerParams {
   public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
   public static final Set<String> VALID_MIME_TYPES;
   public static final Set<String> VALID_URI_SCHEMES;
   public final Uri externalUri;
   public final String metaData;
   public final String mimeType;
   public final Uri uri;

   static {
      HashSet var0 = new HashSet();
      var0.add("image/*");
      var0.add("image/jpeg");
      var0.add("image/png");
      var0.add("image/gif");
      var0.add("image/webp");
      var0.add("video/*");
      var0.add("video/mp4");
      var0.add("audio/*");
      var0.add("audio/mpeg");
      VALID_MIME_TYPES = Collections.unmodifiableSet(var0);
      var0 = new HashSet();
      var0.add("content");
      var0.add("android.resource");
      var0.add("file");
      VALID_URI_SCHEMES = Collections.unmodifiableSet(var0);
      var0 = new HashSet();
      var0.add("http");
      var0.add("https");
      VALID_EXTERNAL_URI_SCHEMES = Collections.unmodifiableSet(var0);
   }

   ShareToMessengerParams(ShareToMessengerParamsBuilder var1) {
      this.uri = var1.getUri();
      this.mimeType = var1.getMimeType();
      this.metaData = var1.getMetaData();
      this.externalUri = var1.getExternalUri();
      if (this.uri == null) {
         throw new NullPointerException("Must provide non-null uri");
      }

      if (this.mimeType == null) {
         throw new NullPointerException("Must provide mimeType");
      }

      if (!VALID_URI_SCHEMES.contains(this.uri.getScheme())) {
         throw new IllegalArgumentException("Unsupported URI scheme: " + this.uri.getScheme());
      }

      if (!VALID_MIME_TYPES.contains(this.mimeType)) {
         throw new IllegalArgumentException("Unsupported mime-type: " + this.mimeType);
      }

      if (this.externalUri != null && !VALID_EXTERNAL_URI_SCHEMES.contains(this.externalUri.getScheme())) {
         throw new IllegalArgumentException("Unsupported external uri scheme: " + this.externalUri.getScheme());
      }
   }

   public static ShareToMessengerParamsBuilder newBuilder(Uri var0, String var1) {
      return new ShareToMessengerParamsBuilder(var0, var1);
   }
}
