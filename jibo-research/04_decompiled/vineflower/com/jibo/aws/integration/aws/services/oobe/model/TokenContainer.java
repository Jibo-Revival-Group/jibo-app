package com.jibo.aws.integration.aws.services.oobe.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class TokenContainer implements Parcelable, Serializable {
   public static final Creator<TokenContainer> CREATOR = new Creator<TokenContainer>() {
      public TokenContainer createFromParcel(Parcel var1) {
         return new TokenContainer(var1);
      }

      public TokenContainer[] newArray(int var1) {
         return new TokenContainer[var1];
      }
   };
   @Expose
   private Long expires;
   @Expose
   private String token;

   private TokenContainer(Parcel var1) {
      this.token = var1.readString();
      this.expires = var1.readLong();
   }

   public TokenContainer(String var1) {
      this.token = var1;
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
            if (var1 instanceof TokenContainer) {
               var1 = var1;
               boolean var2;
               if (var1.getToken() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getToken() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getToken() != null) {
                     var4 = var5;
                     if (!var1.getToken().equals(this.getToken())) {
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

   public Long getExpires() {
      return this.expires;
   }

   public String getToken() {
      return this.token;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getToken() == null) {
         var1 = 0;
      } else {
         var1 = this.getToken().hashCode();
      }

      if (this.getExpires() != null) {
         var2 = this.getExpires().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setExpires(Long var1) {
      this.expires = var1;
   }

   public void setToken(String var1) {
      this.token = var1;
   }

   @Override
   public String toString() {
      return "TokenContainer {token='" + this.token + '\'' + ", expires='" + this.expires + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.token);
      var1.writeLong(this.expires);
   }
}
