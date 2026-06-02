package com.facebook.internal;

import java.util.EnumSet;

public enum SmartLoginOption {
   Enabled(1L),
   None(0L),
   RequireConfirm(2L);

   private static final SmartLoginOption[] $VALUES = new SmartLoginOption[]{SmartLoginOption.None, SmartLoginOption.Enabled, SmartLoginOption.RequireConfirm};
   public static final EnumSet<SmartLoginOption> ALL = EnumSet.allOf(SmartLoginOption.class);
   private final long mValue;

   SmartLoginOption(long var3) {
      this.mValue = var3;
   }

   public static EnumSet<SmartLoginOption> parseOptions(long var0) {
      EnumSet var3 = EnumSet.noneOf(SmartLoginOption.class);

      for (SmartLoginOption var4 : ALL) {
         if ((var4.getValue() & var0) != 0L) {
            var3.add(var4);
         }
      }

      return var3;
   }

   public long getValue() {
      return this.mValue;
   }
}
