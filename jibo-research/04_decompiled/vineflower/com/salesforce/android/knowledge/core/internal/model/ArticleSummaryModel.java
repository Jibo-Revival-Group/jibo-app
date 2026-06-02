package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import java.util.Date;

public class ArticleSummaryModel implements ArticleSummary {
   String a;
   String b;
   String c;
   String d;
   String e;
   int f;
   double g;
   Date h;

   ArticleSummaryModel(String var1, String var2, String var3, String var4, String var5, int var6, double var7, Date var9) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var9;
   }

   static ArticleSummaryModel a(ArticlesResponse.Article var0) {
      return new ArticleSummaryModel(var0.a(), var0.b(), var0.c(), var0.d(), var0.e(), var0.f(), var0.g(), var0.h());
   }

   public static ArticleSummaryModel a(String var0, String var1, String var2, String var3, String var4, int var5, double var6, Date var8) {
      return new ArticleSummaryModel(var0, var1, var2, var3, var4, var5, var6, var8);
   }

   @Override
   public String g() {
      return this.a;
   }

   public String h() {
      return this.b;
   }

   @Override
   public String i() {
      return this.c;
   }

   @Override
   public String j() {
      return this.d;
   }

   public String k() {
      return this.e;
   }

   public int l() {
      return this.f;
   }

   public double m() {
      return this.g;
   }

   public Date n() {
      return this.h;
   }

   @Override
   public String toString() {
      return "ArticleSummary[" + this.c + "]";
   }
}
