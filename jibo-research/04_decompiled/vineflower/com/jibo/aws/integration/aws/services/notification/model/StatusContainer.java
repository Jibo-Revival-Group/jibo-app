package com.jibo.aws.integration.aws.services.notification.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class StatusContainer implements Serializable {
   @Expose
   private Boolean connected;

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
               if (var1.getConnected() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getConnected() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getConnected() != null) {
                     var4 = var5;
                     if (!var1.getConnected().equals(this.getConnected())) {
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

   public Boolean getConnected() {
      return this.connected;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getConnected() == null) {
         var1 = 0;
      } else {
         var1 = this.getConnected().hashCode();
      }

      return var1 + 31;
   }

   public void setConnected(Boolean var1) {
      this.connected = var1;
   }

   @Override
   public String toString() {
      return "StatusContainer {connected='" + this.connected + '\'' + '}';
   }
}
