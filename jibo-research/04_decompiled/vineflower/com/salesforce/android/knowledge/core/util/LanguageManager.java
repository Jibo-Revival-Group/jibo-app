package com.salesforce.android.knowledge.core.util;

import java.util.HashMap;
import java.util.Locale;

public class LanguageManager {
   private static final Locale a = new Locale("da");
   private static final Locale b = new Locale("nl", "NL");
   private static final Locale c = new Locale("fi");
   private static final Locale d = new Locale("no");
   private static final Locale e = new Locale("pt", "BR");
   private static final Locale f = new Locale("ru");
   private static final Locale g = new Locale("es");
   private static final Locale h = new Locale("es", "MX");
   private static final Locale i = new Locale("sv");
   private static final Locale j = new Locale("th");
   private static final HashMap<String, Locale> k = new HashMap<>();
   private static final HashMap<String, Locale> l = new HashMap<>();

   static {
      k.put(Locale.SIMPLIFIED_CHINESE.getLanguage(), Locale.SIMPLIFIED_CHINESE);
      k.put(a.getLanguage(), a);
      k.put(b.getLanguage(), b);
      k.put(Locale.US.getLanguage(), Locale.US);
      k.put(c.getLanguage(), c);
      k.put(Locale.FRENCH.getLanguage(), Locale.FRENCH);
      k.put(Locale.GERMAN.getLanguage(), Locale.GERMAN);
      k.put(Locale.ITALIAN.getLanguage(), Locale.ITALIAN);
      k.put(Locale.JAPANESE.getLanguage(), Locale.JAPANESE);
      k.put(Locale.KOREAN.getLanguage(), Locale.KOREAN);
      k.put(d.getLanguage(), d);
      k.put(e.getLanguage(), e);
      k.put(f.getLanguage(), f);
      k.put(g.getLanguage(), g);
      k.put(i.getLanguage(), i);
      k.put(j.getLanguage(), j);
      l.put(Locale.TRADITIONAL_CHINESE.getCountry(), Locale.TRADITIONAL_CHINESE);
      l.put(h.getCountry(), h);
   }

   public static String a(Locale var0) {
      Locale var2 = l.get(var0.getCountry());
      Locale var1 = var2;
      if (var2 != null) {
         var1 = var2;
         if (!var2.getLanguage().equals(var0.getLanguage())) {
            var1 = null;
         }
      }

      var2 = var1;
      if (var1 == null) {
         var2 = k.get(var0.getLanguage());
      }

      if (var2 == null) {
         throw new IllegalArgumentException("Input Language Not supported: " + var0.toString());
      }

      StringBuilder var3 = new StringBuilder(var2.getLanguage().toLowerCase());
      String var4;
      if (var2.getCountry().isEmpty()) {
         var4 = var3.toString();
      } else {
         var4 = var3.append("-").append(var2.getCountry().toUpperCase()).toString();
      }

      return var4;
   }

   public static boolean b(Locale var0) {
      boolean var1 = false;
      if (var0 != null && k.get(var0.getLanguage()) != null) {
         var1 = true;
      }

      return var1;
   }
}
