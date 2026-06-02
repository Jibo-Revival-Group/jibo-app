package com.salesforce.android.knowledge.ui.internal.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.ui.KnowledgeImageProvider;

public class DataCategoryInfo implements DataCategorySummary {
   private final String a;
   private final String b;
   private final int c;
   private final int d;
   private final KnowledgeImageProvider e;

   protected DataCategoryInfo() {
      this.a = null;
      this.b = null;
      this.c = 0;
      this.d = 0;
      this.e = null;
   }

   protected DataCategoryInfo(DataCategorySummary var1, int var2, KnowledgeImageProvider var3) {
      this.a = var1.a();
      this.b = var1.b();
      this.c = var1.c();
      this.d = var2;
      this.e = var3;
   }

   public static DataCategoryInfo a(DataCategorySummary var0, int var1, KnowledgeImageProvider var2) {
      return new DataCategoryInfo(var0, var1, var2);
   }

   public Drawable a(Context var1) {
      return this.e.a(var1, this);
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
   public int c() {
      return this.c;
   }

   public int d() {
      return this.d;
   }
}
