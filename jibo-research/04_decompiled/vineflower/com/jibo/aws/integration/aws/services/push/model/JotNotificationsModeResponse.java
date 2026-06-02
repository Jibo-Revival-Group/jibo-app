package com.jibo.aws.integration.aws.services.push.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class JotNotificationsModeResponse implements Parcelable, Serializable {
   public static final Creator<JotNotificationsModeResponse> CREATOR = new Creator<JotNotificationsModeResponse>() {
      public JotNotificationsModeResponse createFromParcel(Parcel var1) {
         return new JotNotificationsModeResponse(var1);
      }

      public JotNotificationsModeResponse[] newArray(int var1) {
         return new JotNotificationsModeResponse[var1];
      }
   };
   @Expose
   private String accountId;
   @Expose
   private JotPushNotificationsMode jotPushMode;

   public JotNotificationsModeResponse() {
   }

   protected JotNotificationsModeResponse(Parcel var1) {
      this.jotPushMode = JotPushNotificationsMode.valueOf(var1.readString());
      this.accountId = var1.readString();
   }

   public JotNotificationsModeResponse(String var1, JotPushNotificationsMode var2) {
      this.accountId = var1;
      this.jotPushMode = var2;
   }

   public int describeContents() {
      return 0;
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
            if (var1 instanceof JotNotificationsModeResponse) {
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

                  if (var1.getAccountId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getAccountId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getAccountId() != null) {
                        var4 = var5;
                        if (!var1.getAccountId().equals(this.getAccountId())) {
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

   public String getAccountId() {
      return this.accountId;
   }

   public JotPushNotificationsMode getJotPushMode() {
      return this.jotPushMode;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getJotPushMode() == null) {
         var1 = 0;
      } else {
         var1 = this.getJotPushMode().hashCode();
      }

      if (this.getAccountId() != null) {
         var2 = this.getAccountId().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setJotPushMode(JotPushNotificationsMode var1) {
      this.jotPushMode = var1;
   }

   @Override
   public String toString() {
      return "JotNotificationsModeResponse {jotPushMode='" + this.jotPushMode + '\'' + "accountId='" + this.accountId + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.jotPushMode.getName());
      var1.writeString(this.accountId);
   }
}
