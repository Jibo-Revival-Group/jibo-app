package com.jibo.aws.integration.aws.services.common.model;

import java.io.Serializable;

public class CommandResponse implements Serializable {
   private String result;

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
            if (var1 instanceof CommandResponse) {
               var1 = var1;
               boolean var2;
               if (var1.getResult() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getResult() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getResult() != null) {
                     var4 = var5;
                     if (!var1.getResult().equals(this.getResult())) {
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

   public String getResult() {
      return this.result;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getResult() == null) {
         var1 = 0;
      } else {
         var1 = this.getResult().hashCode();
      }

      return var1 + 31;
   }

   public void setResult(String var1) {
      this.result = var1;
   }

   @Override
   public String toString() {
      return "CommandResponse {result='" + this.result + '\'' + '}';
   }
}
