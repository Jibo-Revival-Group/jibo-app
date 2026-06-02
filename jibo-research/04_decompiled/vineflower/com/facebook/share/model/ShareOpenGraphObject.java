package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, ShareOpenGraphObject.Builder> {
   public static final Creator<ShareOpenGraphObject> CREATOR = new Creator<ShareOpenGraphObject>() {
      public ShareOpenGraphObject createFromParcel(Parcel var1) {
         return new ShareOpenGraphObject(var1);
      }

      public ShareOpenGraphObject[] newArray(int var1) {
         return new ShareOpenGraphObject[var1];
      }
   };

   ShareOpenGraphObject(Parcel var1) {
      super(var1);
   }

   private ShareOpenGraphObject(ShareOpenGraphObject.Builder var1) {
      super(var1);
   }

   public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, ShareOpenGraphObject.Builder> {
      public Builder() {
         this.putBoolean("fbsdk:create_object", true);
      }

      public ShareOpenGraphObject build() {
         return new ShareOpenGraphObject(this);
      }

      ShareOpenGraphObject.Builder readFrom(Parcel var1) {
         return this.readFrom((ShareOpenGraphObject)var1.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
      }
   }
}
