package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy implements FieldNamingStrategy {
   IDENTITY {
      @Override
      public String translateName(Field var1) {
         return var1.getName();
      }
   },
   LOWER_CASE_WITH_DASHES {
      @Override
      public String translateName(Field var1) {
         return separateCamelCase(var1.getName(), "-").toLowerCase(Locale.ENGLISH);
      }
   },
   LOWER_CASE_WITH_UNDERSCORES {
      @Override
      public String translateName(Field var1) {
         return separateCamelCase(var1.getName(), "_").toLowerCase(Locale.ENGLISH);
      }
   },
   UPPER_CAMEL_CASE {
      @Override
      public String translateName(Field var1) {
         return upperCaseFirstLetter(var1.getName());
      }
   },
   UPPER_CAMEL_CASE_WITH_SPACES {
      @Override
      public String translateName(Field var1) {
         return upperCaseFirstLetter(separateCamelCase(var1.getName(), " "));
      }
   };

   private static final FieldNamingPolicy[] $VALUES = new FieldNamingPolicy[]{
      FieldNamingPolicy.IDENTITY,
      FieldNamingPolicy.UPPER_CAMEL_CASE,
      FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES,
      FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES,
      FieldNamingPolicy.LOWER_CASE_WITH_DASHES
   };

   FieldNamingPolicy() {
   }

   private static String modifyString(char var0, String var1, int var2) {
      if (var2 < var1.length()) {
         var1 = var0 + var1.substring(var2);
      } else {
         var1 = String.valueOf(var0);
      }

      return var1;
   }

   static String separateCamelCase(String var0, String var1) {
      StringBuilder var5 = new StringBuilder();
      int var3 = 0;

      for (int var4 = var0.length(); var3 < var4; var3++) {
         char var2 = var0.charAt(var3);
         if (Character.isUpperCase(var2) && var5.length() != 0) {
            var5.append(var1);
         }

         var5.append(var2);
      }

      return var5.toString();
   }

   static String upperCaseFirstLetter(String var0) {
      StringBuilder var5 = new StringBuilder();
      int var2 = 0;
      char var1 = var0.charAt(0);

      for (int var3 = var0.length(); var2 < var3 - 1 && !Character.isLetter(var1); var1 = var0.charAt(++var2)) {
         var5.append(var1);
      }

      String var4 = var0;
      if (!Character.isUpperCase(var1)) {
         var4 = var5.append(modifyString(Character.toUpperCase(var1), var0, var2 + 1)).toString();
      }

      return var4;
   }
}
