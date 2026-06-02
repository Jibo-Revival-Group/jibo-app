package com.salesforce.android.knowledge.ui;

import com.salesforce.android.knowledge.core.KnowledgeConfiguration;

public class KnowledgeUIConfiguration {
   private final KnowledgeConfiguration a;
   private final String b;
   private KnowledgeImageProvider c;
   private KnowledgeCssProvider d;
   private KnowledgeJsProvider e;
   private String f;

   private KnowledgeUIConfiguration(KnowledgeConfiguration var1, String var2, String var3) {
      this.a = var1;
      this.f = var2;
      this.b = var3;
   }

   public static KnowledgeUIConfiguration a(KnowledgeConfiguration var0, String var1, String var2) {
      return new KnowledgeUIConfiguration(var0, var1, var2);
   }

   @Deprecated
   public KnowledgeConfiguration a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public KnowledgeImageProvider c() {
      return this.c;
   }

   public KnowledgeCssProvider d() {
      return this.d;
   }

   public KnowledgeJsProvider e() {
      return this.e;
   }

   public String f() {
      return this.f;
   }
}
