package com.jibo.aws.integration.aws.services.oobe.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class KeysContainer implements Parcelable, Serializable {
   public static final Creator<KeysContainer> CREATOR = new Creator<KeysContainer>() {
      public KeysContainer createFromParcel(Parcel var1) {
         return new KeysContainer(var1);
      }

      public KeysContainer[] newArray(int var1) {
         return new KeysContainer[var1];
      }
   };
   @Expose
   private String accessKeyId;
   @Expose
   private String secretAccessKey;

   private KeysContainer(Parcel var1) {
      this.accessKeyId = var1.readString();
      this.secretAccessKey = var1.readString();
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 != null) {
            var4 = var5;
            if (var1 instanceof KeysContainer) {
               var1 = var1;
               boolean var2;
               if (var1.getAccessKeyId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getAccessKeyId() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getAccessKeyId() != null) {
                     var4 = var5;
                     if (!var1.getAccessKeyId().equals(this.getAccessKeyId())) {
                        return var4;
                     }
                  }

                  var4 = true;
               }
            }
         }
      }

      return var4;
   }

   public String getAccessKeyId() {
      return this.accessKeyId;
   }

   public String getSecretAccessKey() {
      return this.secretAccessKey;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getAccessKeyId() == null) {
         var1 = 0;
      } else {
         var1 = this.getAccessKeyId().hashCode();
      }

      if (this.getSecretAccessKey() != null) {
         var2 = this.getSecretAccessKey().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setAccessKeyId(String var1) {
      this.accessKeyId = var1;
   }

   public void setSecretAccessKey(String var1) {
      this.secretAccessKey = var1;
   }

   @Override
   public String toString() {
      return "KeysContainer {accessKeyId='" + this.accessKeyId + '\'' + ", secretAccessKey='" + this.secretAccessKey + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.accessKeyId);
      var1.writeString(this.secretAccessKey);
   }
}
