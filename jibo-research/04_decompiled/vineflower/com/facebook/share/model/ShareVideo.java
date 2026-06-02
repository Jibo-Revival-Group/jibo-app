package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideo extends ShareMedia {
   public static final Creator<ShareVideo> CREATOR = new Creator<ShareVideo>() {
      public ShareVideo createFromParcel(Parcel var1) {
         return new ShareVideo(var1);
      }

      public ShareVideo[] newArray(int var1) {
         return new ShareVideo[var1];
      }
   };
   private final Uri localUrl;

   ShareVideo(Parcel var1) {
      super(var1);
      this.localUrl = (Uri)var1.readParcelable(Uri.class.getClassLoader());
   }

   private ShareVideo(ShareVideo.Builder var1) {
      super(var1);
      this.localUrl = var1.localUrl;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   public Uri getLocalUrl() {
      return this.localUrl;
   }

   @Override
   public ShareMedia.Type getMediaType() {
      return ShareMedia.Type.VIDEO;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeParcelable(this.localUrl, 0);
   }

   public static final class Builder extends ShareMedia.Builder<ShareVideo, ShareVideo.Builder> {
      private Uri localUrl;

      public ShareVideo build() {
         return new ShareVideo(this);
      }

      ShareVideo.Builder readFrom(Parcel var1) {
         return this.readFrom((ShareVideo)var1.readParcelable(ShareVideo.class.getClassLoader()));
      }

      public ShareVideo.Builder readFrom(ShareVideo var1) {
         ShareVideo.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((ShareVideo.Builder)super.readFrom(var1)).setLocalUrl(var1.getLocalUrl());
         }

         return var2;
      }

      public ShareVideo.Builder setLocalUrl(Uri var1) {
         this.localUrl = var1;
         return this;
      }
   }
}
