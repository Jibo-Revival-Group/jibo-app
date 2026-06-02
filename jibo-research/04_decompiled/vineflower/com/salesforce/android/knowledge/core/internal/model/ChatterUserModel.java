package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticleDetailsResponse;
import com.salesforce.android.knowledge.core.model.ChatterUser;

public class ChatterUserModel implements ChatterUser {
   private final String a;
   private final String b;
   private final String c;
   private final String d;
   private final String e;

   ChatterUserModel(String var1, String var2, String var3, String var4, String var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public static ChatterUserModel a(ArticleDetailsResponse.User var0) {
      return new ChatterUserModel(var0.b(), var0.d(), var0.a(), var0.e(), var0.c());
   }

   public static ChatterUserModel a(String var0, String var1, String var2, String var3, String var4) {
      return new ChatterUserModel(var0, var1, var2, var3, var4);
   }

   @Override
   public String a() {
      return this.c;
   }

   @Override
   public String b() {
      return this.a;
   }

   @Override
   public String c() {
      return this.e;
   }

   @Override
   public String d() {
      return this.b;
   }

   @Override
   public String e() {
      return this.d;
   }
}
