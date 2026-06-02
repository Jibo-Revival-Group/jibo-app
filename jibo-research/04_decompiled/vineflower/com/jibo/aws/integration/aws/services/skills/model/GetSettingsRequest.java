package com.jibo.aws.integration.aws.services.skills.model;

import java.util.UUID;

public class GetSettingsRequest extends JiboSkillsRequest {
   private String loopId;
   private String transId = UUID.randomUUID().toString();

   public GetSettingsRequest(String var1) {
      this.loopId = var1;
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
            if (var1 instanceof GetSettingsRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getTransId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getTransId() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getTransId() != null) {
                     var4 = var5;
                     if (!var1.getTransId().equals(this.getTransId())) {
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

   public String getTransId() {
      return this.transId;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getTransId() == null) {
         var1 = 0;
      } else {
         var1 = this.getTransId().hashCode();
      }

      if (this.getLoopId() != null) {
         var2 = this.getLoopId().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setTransId(String var1) {
      this.transId = var1;
   }

   @Override
   public String toString() {
      return "GetSettingsRequest {transId='" + this.transId + ", loopId='" + this.loopId + "'}";
   }
}
