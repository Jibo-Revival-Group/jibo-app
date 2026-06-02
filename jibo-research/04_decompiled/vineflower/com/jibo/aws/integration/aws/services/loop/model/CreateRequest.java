package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

public class CreateRequest extends RobotIdRequest {
   @Expose
   private String name;

   public CreateRequest(String var1, String var2) {
      super(var1);
      this.name = var2;
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
               if (var1.getName() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getName() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getName() != null) {
                     var4 = var5;
                     if (!var1.getName().equals(this.getName())) {
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

   public String getName() {
      return this.name;
   }

   @Override
   public String getServiceMethodName() {
      return "CreateLoop";
   }

   @Override
   public int hashCode() {
      int var2 = super.hashCode();
      int var1;
      if (this.getName() == null) {
         var1 = 0;
      } else {
         var1 = this.getName().hashCode();
      }

      return var1 + var2 * 31;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   @Override
   public String toString() {
      return "CreateRequest {robotId='" + this.getId() + "', " + "name='" + this.name + "'}";
   }
}
