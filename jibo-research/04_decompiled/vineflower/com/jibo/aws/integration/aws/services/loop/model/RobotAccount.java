package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class RobotAccount implements Parcelable, Serializable {
   public static final Creator<RobotAccount> CREATOR = new Creator<RobotAccount>() {
      public RobotAccount createFromParcel(Parcel var1) {
         return new RobotAccount(var1);
      }

      public RobotAccount[] newArray(int var1) {
         return new RobotAccount[var1];
      }
   };
   private String accessKeyId;
   private String friendlyId;
   private String secretAccessKey;

   public RobotAccount() {
   }

   protected RobotAccount(Parcel var1) {
      this.accessKeyId = var1.readString();
      this.secretAccessKey = var1.readString();
      this.friendlyId = var1.readString();
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof RobotAccount) {
            var1 = var1;
            var2 = var3;
            if (this.getAccessKeyId().equals(var1.getAccessKeyId())) {
               var2 = var3;
               if (this.getSecretAccessKey().equals(var1.getSecretAccessKey())) {
                  var2 = this.getFriendlyId().equals(var1.getFriendlyId());
               }
            }
         }
      }

      return var2;
   }

   public String getAccessKeyId() {
      return this.accessKeyId;
   }

   public String getFriendlyId() {
      return this.friendlyId;
   }

   public String getSecretAccessKey() {
      return this.secretAccessKey;
   }

   @Override
   public int hashCode() {
      return (this.getAccessKeyId().hashCode() * 31 + this.getSecretAccessKey().hashCode()) * 31 + this.getFriendlyId().hashCode();
   }

   public void setAccessKeyId(String var1) {
      this.accessKeyId = var1;
   }

   public void setFriendlyId(String var1) {
      this.friendlyId = var1;
   }

   public void setSecretAccessKey(String var1) {
      this.secretAccessKey = var1;
   }

   @Override
   public String toString() {
      return "RobotAccount{accessKeyId='"
         + this.accessKeyId
         + '\''
         + ", secretAccessKey='"
         + this.secretAccessKey
         + '\''
         + ", friendlyId='"
         + this.friendlyId
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.accessKeyId);
      var1.writeString(this.secretAccessKey);
      var1.writeString(this.friendlyId);
   }
}
