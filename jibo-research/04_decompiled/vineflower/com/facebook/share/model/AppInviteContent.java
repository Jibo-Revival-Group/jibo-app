package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class AppInviteContent implements ShareModel {
   public static final Creator<AppInviteContent> CREATOR = new Creator<AppInviteContent>() {
      public AppInviteContent createFromParcel(Parcel var1) {
         return new AppInviteContent(var1);
      }

      public AppInviteContent[] newArray(int var1) {
         return new AppInviteContent[var1];
      }
   };
   private final String applinkUrl;
   private final AppInviteContent.Builder.Destination destination;
   private final String previewImageUrl;
   private final String promoCode;
   private final String promoText;

   AppInviteContent(Parcel var1) {
      this.applinkUrl = var1.readString();
      this.previewImageUrl = var1.readString();
      this.promoText = var1.readString();
      this.promoCode = var1.readString();
      String var2 = var1.readString();
      if (var2.length() > 0) {
         this.destination = AppInviteContent.Builder.Destination.valueOf(var2);
      } else {
         this.destination = AppInviteContent.Builder.Destination.FACEBOOK;
      }
   }

   private AppInviteContent(AppInviteContent.Builder var1) {
      this.applinkUrl = var1.applinkUrl;
      this.previewImageUrl = var1.previewImageUrl;
      this.promoCode = var1.promoCode;
      this.promoText = var1.promoText;
      this.destination = var1.destination;
   }

   public int describeContents() {
      return 0;
   }

   public String getApplinkUrl() {
      return this.applinkUrl;
   }

   public AppInviteContent.Builder.Destination getDestination() {
      AppInviteContent.Builder.Destination var1;
      if (this.destination != null) {
         var1 = this.destination;
      } else {
         var1 = AppInviteContent.Builder.Destination.FACEBOOK;
      }

      return var1;
   }

   public String getPreviewImageUrl() {
      return this.previewImageUrl;
   }

   public String getPromotionCode() {
      return this.promoCode;
   }

   public String getPromotionText() {
      return this.promoText;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.applinkUrl);
      var1.writeString(this.previewImageUrl);
      var1.writeString(this.promoText);
      var1.writeString(this.promoCode);
      var1.writeString(this.destination.toString());
   }

   public static class Builder implements ShareModelBuilder<AppInviteContent, AppInviteContent.Builder> {
      private String applinkUrl;
      private AppInviteContent.Builder.Destination destination;
      private String previewImageUrl;
      private String promoCode;
      private String promoText;

      private boolean isAlphanumericWithSpaces(String var1) {
         boolean var4 = false;
         int var3 = 0;

         while (true) {
            if (var3 >= var1.length()) {
               var4 = true;
               break;
            }

            char var2 = var1.charAt(var3);
            if (!Character.isDigit(var2) && !Character.isLetter(var2) && !Character.isSpaceChar(var2)) {
               break;
            }

            var3++;
         }

         return var4;
      }

      public AppInviteContent build() {
         return new AppInviteContent(this);
      }

      public AppInviteContent.Builder readFrom(AppInviteContent var1) {
         AppInviteContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = this.setApplinkUrl(var1.getApplinkUrl())
               .setPreviewImageUrl(var1.getPreviewImageUrl())
               .setPromotionDetails(var1.getPromotionText(), var1.getPromotionCode())
               .setDestination(var1.getDestination());
         }

         return var2;
      }

      public AppInviteContent.Builder setApplinkUrl(String var1) {
         this.applinkUrl = var1;
         return this;
      }

      public AppInviteContent.Builder setDestination(AppInviteContent.Builder.Destination var1) {
         this.destination = var1;
         return this;
      }

      public AppInviteContent.Builder setPreviewImageUrl(String var1) {
         this.previewImageUrl = var1;
         return this;
      }

      public AppInviteContent.Builder setPromotionDetails(String var1, String var2) {
         if (!TextUtils.isEmpty(var1)) {
            if (var1.length() > 80) {
               throw new IllegalArgumentException("Invalid promotion text, promotionText needs to be between1 and 80 characters long");
            }

            if (!this.isAlphanumericWithSpaces(var1)) {
               throw new IllegalArgumentException("Invalid promotion text, promotionText can only contain alphanumericcharacters and spaces.");
            }

            if (!TextUtils.isEmpty(var2)) {
               if (var2.length() > 10) {
                  throw new IllegalArgumentException("Invalid promotion code, promotionCode can be between1 and 10 characters long");
               }

               if (!this.isAlphanumericWithSpaces(var2)) {
                  throw new IllegalArgumentException("Invalid promotion code, promotionCode can only contain alphanumeric characters and spaces.");
               }
            }
         } else if (!TextUtils.isEmpty(var2)) {
            throw new IllegalArgumentException("promotionCode cannot be specified without a valid promotionText");
         }

         this.promoCode = var2;
         this.promoText = var1;
         return this;
      }

      public enum Destination {
         FACEBOOK("facebook"),
         MESSENGER("messenger");

         private static final AppInviteContent.Builder.Destination[] $VALUES = new AppInviteContent.Builder.Destination[]{
            AppInviteContent.Builder.Destination.FACEBOOK, AppInviteContent.Builder.Destination.MESSENGER
         };
         private final String name;

         Destination(String var3) {
            this.name = var3;
         }

         public boolean equalsName(String var1) {
            boolean var2;
            if (var1 == null) {
               var2 = false;
            } else {
               var2 = this.name.equals(var1);
            }

            return var2;
         }

         @Override
         public String toString() {
            return this.name;
         }
      }
   }
}
