package com.salesforce.android.knowledge.core;

import com.salesforce.android.knowledge.core.offline.OfflineResourceConfig;
import com.salesforce.android.knowledge.core.util.LanguageManager;
import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.Locale;

public class KnowledgeConfiguration {
   private final String a;
   private final OfflineResourceConfig b;
   private final String c;
   private final String d;
   private final UserAccount e;

   KnowledgeConfiguration(KnowledgeConfiguration.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
   }

   public static KnowledgeConfiguration a(String var0) {
      return b(var0).a();
   }

   public static KnowledgeConfiguration.Builder b(String var0) {
      return new KnowledgeConfiguration.Builder(var0);
   }

   public String a() {
      return this.a;
   }

   public OfflineResourceConfig b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   public UserAccount e() {
      return this.e;
   }

   public static class Builder {
      final String a;
      OfflineResourceConfig b;
      String c = LanguageManager.a(Locale.US);
      String d;
      UserAccount e;

      Builder(String var1) {
         this.a = var1;
         if (LanguageManager.b(Locale.getDefault())) {
            var1 = LanguageManager.a(Locale.getDefault());
         } else {
            var1 = this.c;
         }

         this.d = var1;
      }

      public KnowledgeConfiguration a() {
         if (this.b == null) {
            this.b = OfflineResourceConfig.a();
         }

         return new KnowledgeConfiguration(this);
      }
   }
}
