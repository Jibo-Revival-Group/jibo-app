package com.salesforce.androidsdk.smartstore.store;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.database.SQLiteDatabase;

public class SmartSqlHelper {
   public static final Pattern a = Pattern.compile("\\{([^}]+)\\}");
   private static Map<SQLiteDatabase, SmartSqlHelper> b;

   public static SmartSqlHelper a(SQLiteDatabase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/salesforce/androidsdk/smartstore/store/SmartSqlHelper
      // 02: monitorenter
      // 03: getstatic com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.b Ljava/util/Map;
      // 06: ifnonnull 15
      // 09: new java/util/HashMap
      // 0c: astore 1
      // 0d: aload 1
      // 0e: invokespecial java/util/HashMap.<init> ()V
      // 11: aload 1
      // 12: putstatic com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.b Ljava/util/Map;
      // 15: getstatic com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.b Ljava/util/Map;
      // 18: aload 0
      // 19: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1e: checkcast com/salesforce/androidsdk/smartstore/store/SmartSqlHelper
      // 21: astore 2
      // 22: aload 2
      // 23: astore 1
      // 24: aload 2
      // 25: ifnonnull 3b
      // 28: new com/salesforce/androidsdk/smartstore/store/SmartSqlHelper
      // 2b: astore 1
      // 2c: aload 1
      // 2d: invokespecial com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.<init> ()V
      // 30: getstatic com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.b Ljava/util/Map;
      // 33: aload 0
      // 34: aload 1
      // 35: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 3a: pop
      // 3b: ldc com/salesforce/androidsdk/smartstore/store/SmartSqlHelper
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 0
      // 41: ldc com/salesforce/androidsdk/smartstore/store/SmartSqlHelper
      // 43: monitorexit
      // 44: aload 0
      // 45: athrow
      // try (2 -> 10): 32 null
      // try (10 -> 15): 32 null
      // try (19 -> 28): 32 null
   }

   private String a(SQLiteDatabase var1, String var2, int var3) {
      String var4 = DBHelper.a(var1).h(var1, var2);
      if (var4 == null) {
         this.a("Unknown soup " + var2, var3);
      }

      return var4;
   }

   private String a(SQLiteDatabase var1, String var2, String var3, int var4) {
      Object var5 = null;

      try {
         var7 = DBHelper.a(var1).a(var1, var2, var3);
      } catch (SmartStore.SmartStoreException var6) {
         this.a(var6.getMessage(), var4);
         var7 = (String)var5;
      }

      return var7;
   }

   private void a(String var1, int var2) {
      throw new SmartSqlHelper.SmartSqlException(var1 + " at character " + var2);
   }

   public String a(SQLiteDatabase var1, String var2) {
      String var6 = var2.toLowerCase(Locale.getDefault()).trim();
      if (!var6.startsWith("insert") && !var6.startsWith("update") && !var6.startsWith("delete")) {
         StringBuffer var7 = new StringBuffer();
         Matcher var8 = a.matcher(var2);

         while (var8.find()) {
            String var9 = var8.group();
            var6 = var8.group(1);
            int var4 = var8.start();
            String[] var12 = var6.split(":");
            String var10 = var12[0];
            String var11 = this.a(var1, var10, var4);
            boolean var3;
            if (var2.charAt(var4 - 1) == '.') {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var3) {
               var6 = "";
            } else {
               var6 = var11 + ".";
            }

            boolean var5 = DBHelper.a(var1).f(var1, var10).contains("externalStorage");
            if (var12.length == 1) {
               var8.appendReplacement(var7, var11);
            } else if (var12.length == 2) {
               var9 = var12[1];
               if (var9.equals("_soup")) {
                  if (var5) {
                     var8.appendReplacement(var7, String.format("'%s' as '%s', %s%s as '%s'", var11, "externalStorage", var6, "id", "_soupEntryId"));
                  } else {
                     var8.appendReplacement(var7, var6 + "soup");
                  }
               } else if (var9.equals("_soupEntryId")) {
                  var8.appendReplacement(var7, var6 + "id");
               } else if (var9.equals("_soupCreatedDate")) {
                  var8.appendReplacement(var7, var6 + "created");
               } else if (var9.equals("_soupLastModifiedDate")) {
                  var8.appendReplacement(var7, var6 + "lastModified");
               } else {
                  var8.appendReplacement(var7, this.a(var1, var10, var9, var4).replace("$", "\\$"));
               }
            } else if (var12.length > 2) {
               this.a("Invalid soup/path reference " + var9, var4);
            }
         }

         var8.appendTail(var7);
         return var7.toString().replaceAll("([^ ]+)\\.json_extract\\(soup", "json_extract($1.soup");
      } else {
         throw new SmartSqlHelper.SmartSqlException("Only SELECT are supported");
      }
   }

   public static class SmartSqlException extends SmartStore.SmartStoreException {
      public SmartSqlException(String var1) {
         super(var1);
      }
   }
}
