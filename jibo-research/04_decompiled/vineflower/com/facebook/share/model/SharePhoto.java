package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto extends ShareMedia {
   public static final Creator<SharePhoto> CREATOR = new Creator<SharePhoto>() {
      public SharePhoto createFromParcel(Parcel var1) {
         return new SharePhoto(var1);
      }

      public SharePhoto[] newArray(int var1) {
         return new SharePhoto[var1];
      }
   };
   private final Bitmap bitmap;
   private final String caption;
   private final Uri imageUrl;
   private final boolean userGenerated;

   SharePhoto(Parcel var1) {
      super(var1);
      this.bitmap = (Bitmap)var1.readParcelable(Bitmap.class.getClassLoader());
      this.imageUrl = (Uri)var1.readParcelable(Uri.class.getClassLoader());
      boolean var2;
      if (var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.userGenerated = var2;
      this.caption = var1.readString();
   }

   private SharePhoto(SharePhoto.Builder var1) {
      super(var1);
      this.bitmap = var1.bitmap;
      this.imageUrl = var1.imageUrl;
      this.userGenerated = var1.userGenerated;
      this.caption = var1.caption;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   public Bitmap getBitmap() {
      return this.bitmap;
   }

   public String getCaption() {
      return this.caption;
   }

   public Uri getImageUrl() {
      return this.imageUrl;
   }

   @Override
   public ShareMedia.Type getMediaType() {
      return ShareMedia.Type.PHOTO;
   }

   public boolean getUserGenerated() {
      return this.userGenerated;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 0;
      super.writeToParcel(var1, var2);
      var1.writeParcelable(this.bitmap, 0);
      var1.writeParcelable(this.imageUrl, 0);
      byte var4 = var3;
      if (this.userGenerated) {
         var4 = 1;
      }

      var1.writeByte((byte)var4);
      var1.writeString(this.caption);
   }

   public static final class Builder extends ShareMedia.Builder<SharePhoto, SharePhoto.Builder> {
      private Bitmap bitmap;
      private String caption;
      private Uri imageUrl;
      private boolean userGenerated;

      static List<SharePhoto> readPhotoListFrom(Parcel var0) {
         List var1 = readListFrom(var0);
         ArrayList var3 = new ArrayList();

         for (ShareMedia var4 : var1) {
            if (var4 instanceof SharePhoto) {
               var3.add((SharePhoto)var4);
            }
         }

         return var3;
      }

      static void writePhotoListTo(Parcel var0, int var1, List<SharePhoto> var2) {
         ShareMedia[] var4 = new ShareMedia[var2.size()];

         for (int var3 = 0; var3 < var2.size(); var3++) {
            var4[var3] = (ShareMedia)var2.get(var3);
         }

         var0.writeParcelableArray(var4, var1);
      }

      public SharePhoto build() {
         return new SharePhoto(this);
      }

      Bitmap getBitmap() {
         return this.bitmap;
      }

      Uri getImageUrl() {
         return this.imageUrl;
      }

      SharePhoto.Builder readFrom(Parcel var1) {
         return this.readFrom((SharePhoto)var1.readParcelable(SharePhoto.class.getClassLoader()));
      }

      public SharePhoto.Builder readFrom(SharePhoto var1) {
         SharePhoto.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((SharePhoto.Builder)super.readFrom(var1))
               .setBitmap(var1.getBitmap())
               .setImageUrl(var1.getImageUrl())
               .setUserGenerated(var1.getUserGenerated())
               .setCaption(var1.getCaption());
         }

         return var2;
      }

      public SharePhoto.Builder setBitmap(Bitmap var1) {
         this.bitmap = var1;
         return this;
      }

      public SharePhoto.Builder setCaption(String var1) {
         this.caption = var1;
         return this;
      }

      public SharePhoto.Builder setImageUrl(Uri var1) {
         this.imageUrl = var1;
         return this;
      }

      public SharePhoto.Builder setUserGenerated(boolean var1) {
         this.userGenerated = var1;
         return this;
      }
   }
}
