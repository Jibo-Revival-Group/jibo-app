package com.crashlytics.android.core;

public class UserMetaData {
   public static final UserMetaData a = new UserMetaData();
   public final String b;
   public final String c;
   public final String d;

   public UserMetaData() {
      this(null, null, null);
   }

   public UserMetaData(String var1, String var2, String var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   public boolean a() {
      boolean var1;
      if (this.b == null && this.c == null && this.d == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
