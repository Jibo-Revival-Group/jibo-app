package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, ShareOpenGraphContent.Builder> {
   public static final Creator<ShareOpenGraphContent> CREATOR = new Creator<ShareOpenGraphContent>() {
      public ShareOpenGraphContent createFromParcel(Parcel var1) {
         return new ShareOpenGraphContent(var1);
      }

      public ShareOpenGraphContent[] newArray(int var1) {
         return new ShareOpenGraphContent[var1];
      }
   };
   private final ShareOpenGraphAction action;
   private final String previewPropertyName;

   ShareOpenGraphContent(Parcel var1) {
      super(var1);
      this.action = new ShareOpenGraphAction.Builder().readFrom(var1).build();
      this.previewPropertyName = var1.readString();
   }

   private ShareOpenGraphContent(ShareOpenGraphContent.Builder var1) {
      super(var1);
      this.action = var1.action;
      this.previewPropertyName = var1.previewPropertyName;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   public ShareOpenGraphAction getAction() {
      return this.action;
   }

   public String getPreviewPropertyName() {
      return this.previewPropertyName;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeParcelable(this.action, 0);
      var1.writeString(this.previewPropertyName);
   }

   public static final class Builder extends ShareContent.Builder<ShareOpenGraphContent, ShareOpenGraphContent.Builder> {
      private ShareOpenGraphAction action;
      private String previewPropertyName;

      public ShareOpenGraphContent build() {
         return new ShareOpenGraphContent(this);
      }

      public ShareOpenGraphContent.Builder readFrom(ShareOpenGraphContent var1) {
         ShareOpenGraphContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((ShareOpenGraphContent.Builder)super.readFrom(var1)).setAction(var1.getAction()).setPreviewPropertyName(var1.getPreviewPropertyName());
         }

         return var2;
      }

      public ShareOpenGraphContent.Builder setAction(ShareOpenGraphAction var1) {
         if (var1 == null) {
            var1 = null;
         } else {
            var1 = new ShareOpenGraphAction.Builder().readFrom(var1).build();
         }

         this.action = var1;
         return this;
      }

      public ShareOpenGraphContent.Builder setPreviewPropertyName(String var1) {
         this.previewPropertyName = var1;
         return this;
      }
   }
}
