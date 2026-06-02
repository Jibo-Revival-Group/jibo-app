package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.annotations.Expose;

public class GetFriendlyIdsRequest extends JiboRobotPropertiesRequest {
   @Expose
   private Integer count;

   public GetFriendlyIdsRequest(int var1) {
      this.count = var1;
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
            if (var1 instanceof GetFriendlyIdsRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getCount() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getCount() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getCount() != null) {
                     var4 = var5;
                     if (!var1.getCount().equals(this.getCount())) {
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

   public Integer getCount() {
      return this.count;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getCount() == null) {
         var1 = 0;
      } else {
         var1 = this.getCount().hashCode();
      }

      return var1 + 31;
   }

   public void setCount(int var1) {
      this.count = var1;
   }

   @Override
   public String toString() {
      return "FriendlyIdsRequest {count='" + this.count + '\'' + '}';
   }
}
