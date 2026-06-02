package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class AppGroupCreationContent implements ShareModel {
   public static final Creator<AppGroupCreationContent> CREATOR = new Creator<AppGroupCreationContent>() {
      public AppGroupCreationContent createFromParcel(Parcel var1) {
         return new AppGroupCreationContent(var1);
      }

      public AppGroupCreationContent[] newArray(int var1) {
         return new AppGroupCreationContent[var1];
      }
   };
   private final String description;
   private final String name;
   private AppGroupCreationContent.AppGroupPrivacy privacy;

   AppGroupCreationContent(Parcel var1) {
      this.name = var1.readString();
      this.description = var1.readString();
      this.privacy = (AppGroupCreationContent.AppGroupPrivacy)var1.readSerializable();
   }

   private AppGroupCreationContent(AppGroupCreationContent.Builder var1) {
      this.name = var1.name;
      this.description = var1.description;
      this.privacy = var1.privacy;
   }

   public int describeContents() {
      return 0;
   }

   public AppGroupCreationContent.AppGroupPrivacy getAppGroupPrivacy() {
      return this.privacy;
   }

   public String getDescription() {
      return this.description;
   }

   public String getName() {
      return this.name;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.name);
      var1.writeString(this.description);
      var1.writeSerializable(this.privacy);
   }

   public enum AppGroupPrivacy {
      Closed,
      Open;

      private static final AppGroupCreationContent.AppGroupPrivacy[] $VALUES = new AppGroupCreationContent.AppGroupPrivacy[]{
         AppGroupCreationContent.AppGroupPrivacy.Open, AppGroupCreationContent.AppGroupPrivacy.Closed
      };
   }

   public static class Builder implements ShareModelBuilder<AppGroupCreationContent, AppGroupCreationContent.Builder> {
      private String description;
      private String name;
      private AppGroupCreationContent.AppGroupPrivacy privacy;

      public AppGroupCreationContent build() {
         return new AppGroupCreationContent(this);
      }

      public AppGroupCreationContent.Builder readFrom(AppGroupCreationContent var1) {
         AppGroupCreationContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = this.setName(var1.getName()).setDescription(var1.getDescription()).setAppGroupPrivacy(var1.getAppGroupPrivacy());
         }

         return var2;
      }

      public AppGroupCreationContent.Builder setAppGroupPrivacy(AppGroupCreationContent.AppGroupPrivacy var1) {
         this.privacy = var1;
         return this;
      }

      public AppGroupCreationContent.Builder setDescription(String var1) {
         this.description = var1;
         return this;
      }

      public AppGroupCreationContent.Builder setName(String var1) {
         this.name = var1;
         return this;
      }
   }
}
