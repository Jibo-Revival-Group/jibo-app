package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, ShareVideoContent.Builder> implements ShareModel {
   public static final Creator<ShareVideoContent> CREATOR = new Creator<ShareVideoContent>() {
      public ShareVideoContent createFromParcel(Parcel var1) {
         return new ShareVideoContent(var1);
      }

      public ShareVideoContent[] newArray(int var1) {
         return new ShareVideoContent[var1];
      }
   };
   private final String contentDescription;
   private final String contentTitle;
   private final SharePhoto previewPhoto;
   private final ShareVideo video;

   ShareVideoContent(Parcel var1) {
      super(var1);
      this.contentDescription = var1.readString();
      this.contentTitle = var1.readString();
      SharePhoto.Builder var2 = new SharePhoto.Builder().readFrom(var1);
      if (var2.getImageUrl() == null && var2.getBitmap() == null) {
         this.previewPhoto = null;
      } else {
         this.previewPhoto = var2.build();
      }

      this.video = new ShareVideo.Builder().readFrom(var1).build();
   }

   private ShareVideoContent(ShareVideoContent.Builder var1) {
      super(var1);
      this.contentDescription = var1.contentDescription;
      this.contentTitle = var1.contentTitle;
      this.previewPhoto = var1.previewPhoto;
      this.video = var1.video;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   public String getContentDescription() {
      return this.contentDescription;
   }

   public String getContentTitle() {
      return this.contentTitle;
   }

   public SharePhoto getPreviewPhoto() {
      return this.previewPhoto;
   }

   public ShareVideo getVideo() {
      return this.video;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.contentDescription);
      var1.writeString(this.contentTitle);
      var1.writeParcelable(this.previewPhoto, 0);
      var1.writeParcelable(this.video, 0);
   }

   public static final class Builder extends ShareContent.Builder<ShareVideoContent, ShareVideoContent.Builder> {
      private String contentDescription;
      private String contentTitle;
      private SharePhoto previewPhoto;
      private ShareVideo video;

      public ShareVideoContent build() {
         return new ShareVideoContent(this);
      }

      public ShareVideoContent.Builder readFrom(ShareVideoContent var1) {
         ShareVideoContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((ShareVideoContent.Builder)super.readFrom(var1))
               .setContentDescription(var1.getContentDescription())
               .setContentTitle(var1.getContentTitle())
               .setPreviewPhoto(var1.getPreviewPhoto())
               .setVideo(var1.getVideo());
         }

         return var2;
      }

      public ShareVideoContent.Builder setContentDescription(String var1) {
         this.contentDescription = var1;
         return this;
      }

      public ShareVideoContent.Builder setContentTitle(String var1) {
         this.contentTitle = var1;
         return this;
      }

      public ShareVideoContent.Builder setPreviewPhoto(SharePhoto var1) {
         if (var1 == null) {
            var1 = null;
         } else {
            var1 = new SharePhoto.Builder().readFrom(var1).build();
         }

         this.previewPhoto = var1;
         return this;
      }

      public ShareVideoContent.Builder setVideo(ShareVideo var1) {
         if (var1 != null) {
            this.video = new ShareVideo.Builder().readFrom(var1).build();
         }

         return this;
      }
   }
}
