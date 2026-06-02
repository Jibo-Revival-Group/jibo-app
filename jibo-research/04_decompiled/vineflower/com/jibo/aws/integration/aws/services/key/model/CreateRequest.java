package com.jibo.aws.integration.aws.services.key.model;

import com.google.gson.annotations.Expose;

public class CreateRequest extends JiboKeyRequest {
   @Expose
   private String loopId;
   @Expose
   private String publicKey;

   public CreateRequest(String var1, String var2) {
      this.loopId = var1;
      this.publicKey = var2;
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
            if (var1 instanceof CreateRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getPublicKey() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getPublicKey() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getPublicKey() != null) {
                     var4 = var5;
                     if (!var1.getPublicKey().equals(this.getPublicKey())) {
                        return var4;
                     }
                  }

                  if (var1.getLoopId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getLoopId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getLoopId() != null) {
                        var4 = var5;
                        if (!var1.getLoopId().equals(this.getLoopId())) {
                           return var4;
                        }
                     }

                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getPublicKey() {
      return this.publicKey;
   }

   @Override
   public String getServiceMethodName() {
      return "CreateRequest";
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getPublicKey() == null) {
         var1 = 0;
      } else {
         var1 = this.getPublicKey().hashCode();
      }

      if (this.getLoopId() != null) {
         var2 = this.getLoopId().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setPublicKey(String var1) {
      this.publicKey = var1;
   }

   @Override
   public String toString() {
      return "CreateRequest {publicKey='" + this.publicKey + '\'' + "loopId='" + this.loopId + '\'' + '}';
   }
}
