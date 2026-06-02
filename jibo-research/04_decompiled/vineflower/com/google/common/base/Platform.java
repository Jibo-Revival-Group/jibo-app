package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;

final class Platform {
   private static final Logger a = Logger.getLogger(Platform.class.getName());
   private static final PatternCompiler b = b();

   private Platform() {
   }

   static long a() {
      return System.nanoTime();
   }

   static String a(double var0) {
      return String.format(Locale.ROOT, "%.4g", var0);
   }

   private static PatternCompiler b() {
      return new Platform.JdkPatternCompiler();
   }

   private static final class JdkPatternCompiler implements PatternCompiler {
      private JdkPatternCompiler() {
      }
   }
}
