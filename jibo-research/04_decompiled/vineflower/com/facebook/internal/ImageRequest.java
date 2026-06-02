package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import java.util.Locale;

public class ImageRequest {
   private static final String AUTHORITY = "graph.facebook.com";
   private static final String HEIGHT_PARAM = "height";
   private static final String MIGRATION_PARAM = "migration_overrides";
   private static final String MIGRATION_VALUE = "{october_2012:true}";
   private static final String PATH = "%s/picture";
   private static final String SCHEME = "https";
   public static final int UNSPECIFIED_DIMENSION = 0;
   private static final String WIDTH_PARAM = "width";
   private boolean allowCachedRedirects;
   private ImageRequest.Callback callback;
   private Object callerTag;
   private Context context;
   private Uri imageUri;

   private ImageRequest(ImageRequest.Builder var1) {
      this.context = var1.context;
      this.imageUri = var1.imageUrl;
      this.callback = var1.callback;
      this.allowCachedRedirects = var1.allowCachedRedirects;
      Object var2;
      if (var1.callerTag == null) {
         var2 = new Object();
      } else {
         var2 = var1.callerTag;
      }

      this.callerTag = var2;
   }

   public static Uri getProfilePictureUri(String var0, int var1, int var2) {
      Validate.notNullOrEmpty(var0, "userId");
      var1 = Math.max(var1, 0);
      var2 = Math.max(var2, 0);
      if (var1 == 0 && var2 == 0) {
         throw new IllegalArgumentException("Either width or height must be greater than 0");
      }

      android.net.Uri.Builder var3 = new android.net.Uri.Builder()
         .scheme("https")
         .authority("graph.facebook.com")
         .path(String.format(Locale.US, "%s/picture", var0));
      if (var2 != 0) {
         var3.appendQueryParameter("height", String.valueOf(var2));
      }

      if (var1 != 0) {
         var3.appendQueryParameter("width", String.valueOf(var1));
      }

      var3.appendQueryParameter("migration_overrides", "{october_2012:true}");
      return var3.build();
   }

   public ImageRequest.Callback getCallback() {
      return this.callback;
   }

   public Object getCallerTag() {
      return this.callerTag;
   }

   public Context getContext() {
      return this.context;
   }

   public Uri getImageUri() {
      return this.imageUri;
   }

   public boolean isCachedRedirectAllowed() {
      return this.allowCachedRedirects;
   }

   public static class Builder {
      private boolean allowCachedRedirects;
      private ImageRequest.Callback callback;
      private Object callerTag;
      private Context context;
      private Uri imageUrl;

      public Builder(Context var1, Uri var2) {
         Validate.notNull(var2, "imageUri");
         this.context = var1;
         this.imageUrl = var2;
      }

      public ImageRequest build() {
         return new ImageRequest(this);
      }

      public ImageRequest.Builder setAllowCachedRedirects(boolean var1) {
         this.allowCachedRedirects = var1;
         return this;
      }

      public ImageRequest.Builder setCallback(ImageRequest.Callback var1) {
         this.callback = var1;
         return this;
      }

      public ImageRequest.Builder setCallerTag(Object var1) {
         this.callerTag = var1;
         return this;
      }
   }

   public interface Callback {
      void onCompleted(ImageResponse var1);
   }
}
