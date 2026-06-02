package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.io.Serializable;

class AccessTokenAppIdPair implements Serializable {
   private static final long serialVersionUID = 1L;
   private final String accessTokenString;
   private final String applicationId;

   public AccessTokenAppIdPair(AccessToken var1) {
      this(var1.getToken(), FacebookSdk.getApplicationId());
   }

   public AccessTokenAppIdPair(String var1, String var2) {
      String var3 = var1;
      if (Utility.isNullOrEmpty(var1)) {
         var3 = null;
      }

      this.accessTokenString = var3;
      this.applicationId = var2;
   }

   private Object writeReplace() {
      return new AccessTokenAppIdPair.SerializationProxyV1(this.accessTokenString, this.applicationId);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof AccessTokenAppIdPair)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (Utility.areObjectsEqual(var1.accessTokenString, this.accessTokenString)) {
            var2 = var3;
            if (Utility.areObjectsEqual(var1.applicationId, this.applicationId)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public String getAccessTokenString() {
      return this.accessTokenString;
   }

   public String getApplicationId() {
      return this.applicationId;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.accessTokenString == null) {
         var1 = 0;
      } else {
         var1 = this.accessTokenString.hashCode();
      }

      if (this.applicationId != null) {
         var2 = this.applicationId.hashCode();
      }

      return var1 ^ var2;
   }

   static class SerializationProxyV1 implements Serializable {
      private static final long serialVersionUID = -2488473066578201069L;
      private final String accessTokenString;
      private final String appId;

      private SerializationProxyV1(String var1, String var2) {
         this.accessTokenString = var1;
         this.appId = var2;
      }

      private Object readResolve() {
         return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
      }
   }
}
