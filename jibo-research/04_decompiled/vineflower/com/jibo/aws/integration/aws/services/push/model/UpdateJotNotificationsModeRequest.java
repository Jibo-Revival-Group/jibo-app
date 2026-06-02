package com.jibo.aws.integration.aws.services.push.model;

import com.google.gson.annotations.Expose;

public class UpdateJotNotificationsModeRequest extends JiboPushRequest {
   @Expose
   protected JotPushNotificationsMode jotPushMode;

   public UpdateJotNotificationsModeRequest(JotPushNotificationsMode var1) {
      this.jotPushMode = var1;
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
            if (super.equals(var1)) {
               var4 = var5;
               if (var1 instanceof UpdateJotNotificationsModeRequest) {
                  var1 = var1;
                  boolean var2;
                  if (var1.getJotPushMode() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  boolean var3;
                  if (this.getJotPushMode() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getJotPushMode() != null) {
                        var4 = var5;
                        if (!var1.getJotPushMode().equals(this.getJotPushMode())) {
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

   public JotPushNotificationsMode getJotPushMode() {
      return this.jotPushMode;
   }

   @Override
   public int hashCode() {
      int var2 = super.hashCode();
      int var1;
      if (this.getJotPushMode() == null) {
         var1 = 0;
      } else {
         var1 = this.getJotPushMode().hashCode();
      }

      return var1 + var2 * 31;
   }

   public void setJotPushMode(JotPushNotificationsMode var1) {
      this.jotPushMode = this.jotPushMode;
   }

   @Override
   public String toString() {
      return "UpdateJotNotificationsModeRequest {, jotPushMode='" + this.jotPushMode + '\'' + '}';
   }
}
