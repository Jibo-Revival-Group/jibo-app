package com.facebook.messenger;

import android.net.Uri;

public class ShareToMessengerParamsBuilder {
   private Uri mExternalUri;
   private String mMetaData;
   private final String mMimeType;
   private final Uri mUri;

   ShareToMessengerParamsBuilder(Uri var1, String var2) {
      this.mUri = var1;
      this.mMimeType = var2;
   }

   public ShareToMessengerParams build() {
      return new ShareToMessengerParams(this);
   }

   public Uri getExternalUri() {
      return this.mExternalUri;
   }

   public String getMetaData() {
      return this.mMetaData;
   }

   public String getMimeType() {
      return this.mMimeType;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public ShareToMessengerParamsBuilder setExternalUri(Uri var1) {
      this.mExternalUri = var1;
      return this;
   }

   public ShareToMessengerParamsBuilder setMetaData(String var1) {
      this.mMetaData = var1;
      return this;
   }
}
