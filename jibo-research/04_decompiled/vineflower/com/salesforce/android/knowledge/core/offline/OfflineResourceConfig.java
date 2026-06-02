package com.salesforce.android.knowledge.core.offline;

import java.io.File;

public class OfflineResourceConfig {
   private final boolean a = false;
   private final int b = 0;
   private final File c = null;
   private final int d = 1;

   private OfflineResourceConfig() {
   }

   public static OfflineResourceConfig a() {
      return new OfflineResourceConfig();
   }

   public boolean b() {
      return this.a;
   }

   public int c() {
      return this.b;
   }

   public File d() {
      return this.c;
   }

   public int e() {
      return this.d;
   }
}
