package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, ShareOpenGraphAction.Builder> {
   public static final Creator<ShareOpenGraphAction> CREATOR = new Creator<ShareOpenGraphAction>() {
      public ShareOpenGraphAction createFromParcel(Parcel var1) {
         return new ShareOpenGraphAction(var1);
      }

      public ShareOpenGraphAction[] newArray(int var1) {
         return new ShareOpenGraphAction[var1];
      }
   };

   ShareOpenGraphAction(Parcel var1) {
      super(var1);
   }

   private ShareOpenGraphAction(ShareOpenGraphAction.Builder var1) {
      super(var1);
   }

   public String getActionType() {
      return this.getString("og:type");
   }

   public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, ShareOpenGraphAction.Builder> {
      private static final String ACTION_TYPE_KEY = "og:type";

      public ShareOpenGraphAction build() {
         return new ShareOpenGraphAction(this);
      }

      ShareOpenGraphAction.Builder readFrom(Parcel var1) {
         return this.readFrom((ShareOpenGraphAction)var1.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
      }

      public ShareOpenGraphAction.Builder readFrom(ShareOpenGraphAction var1) {
         ShareOpenGraphAction.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((ShareOpenGraphAction.Builder)super.readFrom(var1)).setActionType(var1.getActionType());
         }

         return var2;
      }

      public ShareOpenGraphAction.Builder setActionType(String var1) {
         this.putString("og:type", var1);
         return this;
      }
   }
}
