package com.google.android.gms.internal;

enum zzewi {
   zzoco("network", 10, 700, 10, 70),
   zzocp("trace", 10, 300, 10, 30);

   private static final zzewi[] zzocu = new zzewi[]{zzoco, zzocp};
   private final String prefix;
   private final int zzocq;
   private final int zzocr;
   private final int zzocs;
   private final int zzoct;

   zzewi(String var3, int var4, int var5, int var6, int var7) {
      this.prefix = var3;
      this.zzocq = 10;
      this.zzocr = var5;
      this.zzocs = 10;
      this.zzoct = var7;
   }

   @Override
   public final String toString() {
      return this.name();
   }

   public final int zzckf() {
      return this.zzocq;
   }

   public final int zzckg() {
      return this.zzocr;
   }

   public final int zzckh() {
      return this.zzocs;
   }

   public final int zzcki() {
      return this.zzoct;
   }

   public final String zzckj() {
      return String.valueOf(this.prefix).concat("_flimit_time");
   }

   public final String zzckk() {
      return String.valueOf(this.prefix).concat("_flimit_events");
   }

   public final String zzckl() {
      return String.valueOf(this.prefix).concat("_blimit_time");
   }

   public final String zzckm() {
      return String.valueOf(this.prefix).concat("_blimit_events");
   }
}
