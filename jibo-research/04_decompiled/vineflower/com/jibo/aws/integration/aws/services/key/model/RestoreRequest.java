package com.jibo.aws.integration.aws.services.key.model;

import android.os.Parcel;
import com.google.gson.annotations.Expose;

public class RestoreRequest extends JiboKeyRequest {
   @Expose
   private String loopId;
   @Expose
   private String passwordHash;

   public RestoreRequest() {
   }

   protected RestoreRequest(Parcel var1) {
      this.loopId = var1.readString();
      this.passwordHash = var1.readString();
   }

   public RestoreRequest(String var1, String var2) {
      this.loopId = var1;
      this.passwordHash = var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof RestoreRequest)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.getLoopId().equals(var1.getLoopId())) {
               var2 = false;
            } else if (this.getPasswordHash() != null) {
               var2 = this.getPasswordHash().equals(var1.getPasswordHash());
            } else if (var1.getPasswordHash() != null) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getPasswordHash() {
      return this.passwordHash;
   }

   @Override
   public int hashCode() {
      int var2 = this.getLoopId().hashCode();
      int var1;
      if (this.getPasswordHash() != null) {
         var1 = this.getPasswordHash().hashCode();
      } else {
         var1 = 0;
      }

      return var1 + var2 * 31;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setPasswordHash(String var1) {
      this.passwordHash = var1;
   }

   @Override
   public String toString() {
      return "RestoreRequest{loopId='" + this.loopId + '\'' + ", passwordHash='" + this.passwordHash + '\'' + '}';
   }
}
