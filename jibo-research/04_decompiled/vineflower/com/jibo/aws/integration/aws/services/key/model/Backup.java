package com.jibo.aws.integration.aws.services.key.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;

public class Backup implements Parcelable {
   public static final Creator<Backup> CREATOR = new Creator<Backup>() {
      public Backup createFromParcel(Parcel var1) {
         return new Backup(var1);
      }

      public Backup[] newArray(int var1) {
         return new Backup[var1];
      }
   };
   @Expose
   private String accountId;
   @Expose
   private String encryptedKey;
   @Expose
   private String loopId;

   public Backup() {
   }

   protected Backup(Parcel var1) {
      this.loopId = var1.readString();
      this.accountId = var1.readString();
      this.encryptedKey = var1.readString();
   }

   public Backup(String var1, String var2, String var3) {
      this.loopId = var1;
      this.accountId = var3;
      this.encryptedKey = var2;
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
         if (var1 instanceof Backup) {
            var1 = var1;
            var2 = var3;
            if (this.getLoopId().equals(var1.getLoopId())) {
               if (this.getAccountId() != null) {
                  var2 = var3;
                  if (!this.getAccountId().equals(var1.getAccountId())) {
                     return var2;
                  }
               } else if (var1.getAccountId() != null) {
                  var2 = var3;
                  return var2;
               }

               var2 = this.getEncryptedKey().equals(var1.getEncryptedKey());
            }
         }
      }

      return var2;
   }

   public String getAccountId() {
      return this.accountId;
   }

   public String getEncryptedKey() {
      return this.encryptedKey;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public int hashCode() {
      int var2 = this.getLoopId().hashCode();
      int var1;
      if (this.getAccountId() != null) {
         var1 = this.getAccountId().hashCode();
      } else {
         var1 = 0;
      }

      return (var1 + var2 * 31) * 31 + this.getEncryptedKey().hashCode();
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setEncryptedKey(String var1) {
      this.encryptedKey = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return "Backup{loopId='" + this.loopId + '\'' + ", accountId='" + this.accountId + '\'' + ", encryptedKey='" + this.encryptedKey + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.loopId);
      var1.writeString(this.accountId);
      var1.writeString(this.encryptedKey);
   }
}
