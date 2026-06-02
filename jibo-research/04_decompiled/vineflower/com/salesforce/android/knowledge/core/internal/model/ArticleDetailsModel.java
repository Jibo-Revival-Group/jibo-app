package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticleDetailsResponse;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ChatterUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArticleDetailsModel extends ArticleSummaryModel implements ArticleDetails {
   private final List<ArticleDetails.Field> i;
   private final int j;
   private final Date k;
   private final Date l;
   private final ChatterUserModel m;
   private final ChatterUserModel n;

   ArticleDetailsModel(
      String var1,
      String var2,
      String var3,
      String var4,
      String var5,
      int var6,
      double var7,
      Date var9,
      int var10,
      Date var11,
      Date var12,
      ChatterUserModel var13,
      ChatterUserModel var14,
      List<ArticleDetailsModel.FieldModel> var15
   ) {
      super(var1, var2, var3, var4, var5, var6, var7, var9);
      this.j = var10;
      this.k = var11;
      this.l = var12;
      this.m = var13;
      this.n = var14;
      ArrayList var16 = new ArrayList(var15.size());
      var16.addAll(var15);
      this.i = Collections.unmodifiableList(var16);
   }

   public static ArticleDetailsModel a(ArticleDetailsResponse var0) {
      ArrayList var2 = new ArrayList(var0.j().size());
      Iterator var1 = var0.j().iterator();

      while (var1.hasNext()) {
         var2.add(ArticleDetailsModel.FieldModel.a((ArticleDetailsResponse.LayoutItem)var1.next()));
      }

      return new ArticleDetailsModel(
         var0.f(),
         var0.c(),
         var0.l(),
         var0.k(),
         var0.m(),
         var0.a(),
         var0.b(),
         var0.i(),
         var0.n(),
         var0.e(),
         var0.h(),
         ChatterUserModel.a(var0.d()),
         ChatterUserModel.a(var0.g()),
         var2
      );
   }

   public static ArticleDetailsModel a(
      String var0,
      String var1,
      String var2,
      String var3,
      String var4,
      int var5,
      double var6,
      Date var8,
      int var9,
      Date var10,
      Date var11,
      ChatterUserModel var12,
      ChatterUserModel var13,
      List<ArticleDetailsModel.FieldModel> var14
   ) {
      return new ArticleDetailsModel(var0, var1, var2, var3, var4, var5, var6, var8, var9, var10, var11, var12, var13, var14);
   }

   @Override
   public int a() {
      return this.j;
   }

   @Override
   public Date b() {
      return this.k;
   }

   @Override
   public Date c() {
      return this.l;
   }

   @Override
   public ChatterUser d() {
      return this.m;
   }

   @Override
   public ChatterUser e() {
      return this.n;
   }

   @Override
   public List<ArticleDetails.Field> f() {
      return this.i;
   }

   public static class FieldModel implements ArticleDetails.Field {
      private final String a;
      private final String b;
      private final String c;
      private final int d;

      FieldModel(String var1, String var2, String var3, int var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public static ArticleDetailsModel.FieldModel a(ArticleDetailsResponse.LayoutItem var0) {
         byte var2 = 1;
         switch (var0.c()) {
            case "TEXT":
               break;
            case "TEXT_AREA":
               var2 = 2;
               break;
            case "LONG_TEXT_AREA":
               var2 = 3;
               break;
            case "RICH_TEXT_AREA":
               var2 = 4;
               break;
            default:
               var2 = 0;
         }

         return new ArticleDetailsModel.FieldModel(var0.a(), var0.b(), var0.d(), var2);
      }

      public static ArticleDetailsModel.FieldModel a(String var0, String var1, String var2, int var3) {
         return new ArticleDetailsModel.FieldModel(var0, var1, var2, var3);
      }

      @Override
      public String a() {
         return this.a;
      }

      @Override
      public String b() {
         return this.b;
      }

      @Override
      public String c() {
         return this.c;
      }

      @Override
      public int d() {
         return this.d;
      }
   }
}
