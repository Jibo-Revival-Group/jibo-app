package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class GlideUrl {
   private final Headers headers;
   private String safeStringUrl;
   private URL safeUrl;
   private final String stringUrl;
   private final URL url;

   public GlideUrl(String var1) {
      this(var1, Headers.DEFAULT);
   }

   public GlideUrl(String var1, Headers var2) {
      if (TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("String url must not be empty or null: " + var1);
      }

      if (var2 == null) {
         throw new IllegalArgumentException("Headers must not be null");
      }

      this.stringUrl = var1;
      this.url = null;
      this.headers = var2;
   }

   public GlideUrl(URL var1) {
      this(var1, Headers.DEFAULT);
   }

   public GlideUrl(URL var1, Headers var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("URL must not be null!");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("Headers must not be null");
      }

      this.url = var1;
      this.stringUrl = null;
      this.headers = var2;
   }

   private String getSafeStringUrl() {
      if (TextUtils.isEmpty(this.safeStringUrl)) {
         String var2 = this.stringUrl;
         String var1 = var2;
         if (TextUtils.isEmpty(var2)) {
            var1 = this.url.toString();
         }

         this.safeStringUrl = Uri.encode(var1, "@#&=*+-_.,:!?()/~'%");
      }

      return this.safeStringUrl;
   }

   private URL getSafeUrl() throws MalformedURLException {
      if (this.safeUrl == null) {
         this.safeUrl = new URL(this.getSafeStringUrl());
      }

      return this.safeUrl;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 instanceof GlideUrl) {
         var1 = var1;
         var2 = var3;
         if (this.getCacheKey().equals(var1.getCacheKey())) {
            var2 = var3;
            if (this.headers.equals(var1.headers)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public String getCacheKey() {
      String var1;
      if (this.stringUrl != null) {
         var1 = this.stringUrl;
      } else {
         var1 = this.url.toString();
      }

      return var1;
   }

   public Map<String, String> getHeaders() {
      return this.headers.getHeaders();
   }

   @Override
   public int hashCode() {
      return this.getCacheKey().hashCode() * 31 + this.headers.hashCode();
   }

   @Override
   public String toString() {
      return this.getCacheKey() + '\n' + this.headers.toString();
   }

   public URL toURL() throws MalformedURLException {
      return this.getSafeUrl();
   }
}
