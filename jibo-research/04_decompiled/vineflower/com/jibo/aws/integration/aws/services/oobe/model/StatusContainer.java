package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class StatusContainer implements Serializable {
   @Expose
   private Boolean complete;

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
            if (var1 instanceof StatusContainer) {
               var1 = var1;
               boolean var2;
               if (var1.getComplete() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getComplete() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getComplete() != null) {
                     var4 = var5;
                     if (!var1.getComplete().equals(this.getComplete())) {
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

   public Boolean getComplete() {
      return this.complete;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getComplete() == null) {
         var1 = 0;
      } else {
         var1 = this.getComplete().hashCode();
      }

      return var1 + 31;
   }

   public void setComplete(Boolean var1) {
      this.complete = var1;
   }

   @Override
   public String toString() {
      return "StatusContainer {complete='" + this.complete + '\'' + '}';
   }
}
