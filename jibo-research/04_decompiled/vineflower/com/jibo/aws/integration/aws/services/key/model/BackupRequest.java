package com.jibo.aws.integration.aws.services.key.model;

import android.os.Parcel;
import com.google.gson.annotations.Expose;

public class BackupRequest extends JiboKeyRequest {
   @Expose
   private String encryptedKey;
   @Expose
   private String loopId;
   @Expose
   private String passwordHash;

   public BackupRequest() {
   }

   protected BackupRequest(Parcel var1) {
      this.loopId = var1.readString();
      this.encryptedKey = var1.readString();
      this.passwordHash = var1.readString();
   }

   public BackupRequest(String var1, String var2, String var3) {
      this.loopId = var1;
      this.encryptedKey = var2;
      this.passwordHash = var3;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof BackupRequest) {
            var1 = var1;
            var2 = var3;
            if (this.getLoopId().equals(var1.getLoopId())) {
               var2 = var3;
               if (this.getEncryptedKey().equals(var1.getEncryptedKey())) {
                  if (this.getPasswordHash() != null) {
                     var2 = this.getPasswordHash().equals(var1.getPasswordHash());
                  } else {
                     var2 = var4;
                     if (var1.getPasswordHash() != null) {
                        var2 = false;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public String getEncryptedKey() {
      return this.encryptedKey;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getPasswordHash() {
      return this.passwordHash;
   }

   @Override
   public int hashCode() {
      int var3 = this.getLoopId().hashCode();
      int var2 = this.getEncryptedKey().hashCode();
      int var1;
      if (this.getPasswordHash() != null) {
         var1 = this.getPasswordHash().hashCode();
      } else {
         var1 = 0;
      }

      return var1 + (var3 * 31 + var2) * 31;
   }

   public void setEncryptedKey(String var1) {
      this.encryptedKey = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setPasswordHash(String var1) {
      this.passwordHash = var1;
   }

   @Override
   public String toString() {
      return "BackupRequest{loopId='"
         + this.loopId
         + '\''
         + ", encryptedKey='"
         + this.encryptedKey
         + '\''
         + ", passwordHash='"
         + this.passwordHash
         + '\''
         + '}';
   }
}
