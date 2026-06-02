package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

public class LikeContent implements ShareModel {
   public static final Creator<LikeContent> CREATOR = new Creator<LikeContent>() {
      public LikeContent createFromParcel(Parcel var1) {
         return new LikeContent(var1);
      }

      public LikeContent[] newArray(int var1) {
         return new LikeContent[var1];
      }
   };
   private final String objectId;
   private final String objectType;

   LikeContent(Parcel var1) {
      this.objectId = var1.readString();
      this.objectType = var1.readString();
   }

   private LikeContent(LikeContent.Builder var1) {
      this.objectId = var1.objectId;
      this.objectType = var1.objectType;
   }

   public int describeContents() {
      return 0;
   }

   public String getObjectId() {
      return this.objectId;
   }

   public String getObjectType() {
      return this.objectType;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.objectId);
      var1.writeString(this.objectType);
   }

   public static class Builder implements ShareModelBuilder<LikeContent, LikeContent.Builder> {
      private String objectId;
      private String objectType;

      public LikeContent build() {
         return new LikeContent(this);
      }

      public LikeContent.Builder readFrom(LikeContent var1) {
         LikeContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = this.setObjectId(var1.getObjectId()).setObjectType(var1.getObjectType());
         }

         return var2;
      }

      public LikeContent.Builder setObjectId(String var1) {
         this.objectId = var1;
         return this;
      }

      public LikeContent.Builder setObjectType(String var1) {
         this.objectType = var1;
         return this;
      }
   }
}
