package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ShareHashtag implements ShareModel {
   public static final Creator<ShareHashtag> CREATOR = new Creator<ShareHashtag>() {
      public ShareHashtag createFromParcel(Parcel var1) {
         return new ShareHashtag(var1);
      }

      public ShareHashtag[] newArray(int var1) {
         return new ShareHashtag[var1];
      }
   };
   private final String hashtag;

   ShareHashtag(Parcel var1) {
      this.hashtag = var1.readString();
   }

   private ShareHashtag(ShareHashtag.Builder var1) {
      this.hashtag = var1.hashtag;
   }

   public int describeContents() {
      return 0;
   }

   public String getHashtag() {
      return this.hashtag;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.hashtag);
   }

   public static class Builder implements ShareModelBuilder<ShareHashtag, ShareHashtag.Builder> {
      private String hashtag;

      public ShareHashtag build() {
         return new ShareHashtag(this);
      }

      public String getHashtag() {
         return this.hashtag;
      }

      ShareHashtag.Builder readFrom(Parcel var1) {
         return this.readFrom((ShareHashtag)var1.readParcelable(ShareHashtag.class.getClassLoader()));
      }

      public ShareHashtag.Builder readFrom(ShareHashtag var1) {
         ShareHashtag.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = this.setHashtag(var1.getHashtag());
         }

         return var2;
      }

      public ShareHashtag.Builder setHashtag(String var1) {
         this.hashtag = var1;
         return this;
      }
   }
}
