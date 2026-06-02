package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, ShareLinkContent.Builder> {
   public static final Creator<ShareLinkContent> CREATOR = new Creator<ShareLinkContent>() {
      public ShareLinkContent createFromParcel(Parcel var1) {
         return new ShareLinkContent(var1);
      }

      public ShareLinkContent[] newArray(int var1) {
         return new ShareLinkContent[var1];
      }
   };
   private final String contentDescription;
   private final String contentTitle;
   private final Uri imageUrl;
   private final String quote;

   ShareLinkContent(Parcel var1) {
      super(var1);
      this.contentDescription = var1.readString();
      this.contentTitle = var1.readString();
      this.imageUrl = (Uri)var1.readParcelable(Uri.class.getClassLoader());
      this.quote = var1.readString();
   }

   private ShareLinkContent(ShareLinkContent.Builder var1) {
      super(var1);
      this.contentDescription = var1.contentDescription;
      this.contentTitle = var1.contentTitle;
      this.imageUrl = var1.imageUrl;
      this.quote = var1.quote;
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

   public Uri getImageUrl() {
      return this.imageUrl;
   }

   public String getQuote() {
      return this.quote;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.contentDescription);
      var1.writeString(this.contentTitle);
      var1.writeParcelable(this.imageUrl, 0);
      var1.writeString(this.quote);
   }

   public static final class Builder extends ShareContent.Builder<ShareLinkContent, ShareLinkContent.Builder> {
      private String contentDescription;
      private String contentTitle;
      private Uri imageUrl;
      private String quote;

      public ShareLinkContent build() {
         return new ShareLinkContent(this);
      }

      public ShareLinkContent.Builder readFrom(ShareLinkContent var1) {
         ShareLinkContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((ShareLinkContent.Builder)super.readFrom(var1))
               .setContentDescription(var1.getContentDescription())
               .setImageUrl(var1.getImageUrl())
               .setContentTitle(var1.getContentTitle())
               .setQuote(var1.getQuote());
         }

         return var2;
      }

      public ShareLinkContent.Builder setContentDescription(String var1) {
         this.contentDescription = var1;
         return this;
      }

      public ShareLinkContent.Builder setContentTitle(String var1) {
         this.contentTitle = var1;
         return this;
      }

      public ShareLinkContent.Builder setImageUrl(Uri var1) {
         this.imageUrl = var1;
         return this;
      }

      public ShareLinkContent.Builder setQuote(String var1) {
         this.quote = var1;
         return this;
      }
   }
}
