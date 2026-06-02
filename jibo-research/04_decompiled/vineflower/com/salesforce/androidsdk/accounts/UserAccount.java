package com.salesforce.androidsdk.accounts;

import android.os.Bundle;
import android.text.TextUtils;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.MapUtil;
import java.util.Map;

public class UserAccount {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;
   private String j;
   private String k;
   private String l;
   private String m;
   private String n;
   private String o;
   private String p;
   private String q;
   private String r;
   private Map<String, String> s;

   public UserAccount(Bundle var1) {
      if (var1 != null) {
         this.a = var1.getString("authToken");
         this.b = var1.getString("refreshToken");
         this.c = var1.getString("loginServer");
         this.d = var1.getString("idUrl");
         this.e = var1.getString("instanceServer");
         this.f = var1.getString("orgId");
         this.g = var1.getString("userId");
         this.h = var1.getString("username");
         this.j = var1.getString("clientId");
         this.i = var1.getString("accountName");
         this.k = var1.getString("communityId");
         this.l = var1.getString("communityUrl");
         this.m = var1.getString("first_name");
         this.n = var1.getString("last_name");
         this.o = var1.getString("display_name");
         this.p = var1.getString("email");
         this.q = var1.getString("photoUrl");
         this.r = var1.getString("thumbnailUrl");
         this.s = MapUtil.a(var1, SalesforceSDKManager.a().v(), this.s);
      }
   }

   public UserAccount(
      String var1,
      String var2,
      String var3,
      String var4,
      String var5,
      String var6,
      String var7,
      String var8,
      String var9,
      String var10,
      String var11,
      String var12,
      String var13,
      String var14,
      String var15,
      String var16,
      String var17,
      String var18,
      Map<String, String> var19
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
      this.j = var10;
      this.k = var11;
      this.l = var12;
      this.m = var13;
      this.n = var14;
      this.o = var15;
      this.p = var16;
      this.q = var17;
      this.r = var18;
      this.s = var19;
      SalesforceSDKManager.a().e("UA");
   }

   public String a() {
      return this.a;
   }

   public String a(String var1) {
      StringBuffer var2 = new StringBuffer("_");
      var2.append(this.f);
      var2.append("_");
      var2.append(this.g);
      var2.append("_");
      if (TextUtils.isEmpty(var1) || var1.equals("000000000000000AAA")) {
         var1 = "internal";
      }

      var2.append(var1);
      return var2.toString();
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   public String e() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 != null) {
         if (!(var1 instanceof UserAccount)) {
            var2 = var3;
         } else {
            var1 = var1;
            var2 = var3;
            if (this.g != null) {
               var2 = var3;
               if (this.f != null) {
                  var2 = var3;
                  if (var1.g() != null) {
                     var2 = var3;
                     if (var1.f() != null) {
                        var2 = var3;
                        if (var1.g().equals(this.g)) {
                           var2 = var3;
                           if (var1.f().equals(this.f)) {
                              var2 = true;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public String f() {
      return this.f;
   }

   public String g() {
      return this.g;
   }

   public String h() {
      return this.h;
   }

   @Override
   public int hashCode() {
      int var1 = this.g.hashCode();
      return var1 ^ this.f.hashCode() + var1 * 37;
   }

   public String i() {
      return this.i;
   }

   public String j() {
      return this.j;
   }

   public String k() {
      return this.k;
   }

   public String l() {
      return this.l;
   }

   public String m() {
      return this.m;
   }

   public String n() {
      return this.o;
   }

   public String o() {
      return this.n;
   }

   public String p() {
      return this.p;
   }

   public String q() {
      return this.q;
   }

   public String r() {
      return this.r;
   }

   public Map<String, String> s() {
      return this.s;
   }

   public String t() {
      StringBuffer var1 = new StringBuffer("_");
      var1.append(this.f);
      return var1.toString();
   }

   public String u() {
      StringBuffer var1 = new StringBuffer("_");
      var1.append(this.f);
      var1.append("_");
      var1.append(this.g);
      return var1.toString();
   }

   public String v() {
      String var2 = "internal";
      String var1 = var2;
      if (!TextUtils.isEmpty(this.k)) {
         var1 = var2;
         if (!this.k.equals("000000000000000AAA")) {
            var1 = this.k;
         }
      }

      return this.a(var1);
   }

   public Bundle w() {
      Bundle var1 = new Bundle();
      var1.putString("authToken", this.a);
      var1.putString("refreshToken", this.b);
      var1.putString("loginServer", this.c);
      var1.putString("idUrl", this.d);
      var1.putString("instanceServer", this.e);
      var1.putString("orgId", this.f);
      var1.putString("userId", this.g);
      var1.putString("username", this.h);
      var1.putString("clientId", this.j);
      var1.putString("accountName", this.i);
      var1.putString("communityId", this.k);
      var1.putString("communityUrl", this.l);
      var1.putString("first_name", this.m);
      var1.putString("last_name", this.n);
      var1.putString("display_name", this.o);
      var1.putString("email", this.p);
      var1.putString("photoUrl", this.q);
      var1.putString("thumbnailUrl", this.r);
      return MapUtil.a(this.s, SalesforceSDKManager.a().v(), var1);
   }
}
