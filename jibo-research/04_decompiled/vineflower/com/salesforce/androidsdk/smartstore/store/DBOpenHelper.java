package com.salesforce.androidsdk.smartstore.store;

import android.content.Context;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class DBOpenHelper extends SQLiteOpenHelper {
   private static String a;
   private static Map<String, DBOpenHelper> c = new HashMap<>();
   private String b;

   protected DBOpenHelper(Context var1, String var2) {
      super(var1, var2, null, 3, new DBOpenHelper.DBHook());
      this.a(var1);
      this.b = var2;
      a = var1.getApplicationInfo().dataDir;
   }

   public static DBOpenHelper a(Context var0, String var1, UserAccount var2, String var3) {
      StringBuffer var8 = new StringBuffer(var1);
      if (var2 != null) {
         var8.append(var2.a(var3));
      }

      var8.append(".db");
      String var6 = var8.toString();
      DBOpenHelper var5 = c.get(var6);
      DBOpenHelper var9 = var5;
      if (var5 == null) {
         List var12;
         if (var2 == null) {
            var12 = b(var0, var2, var3);
            var3 = "numGlobalStores";
            var1 = "globalSmartStoreInit";
         } else {
            var12 = a(var0, var2, var3);
            var3 = "numUserStores";
            var1 = "userSmartStoreInit";
         }

         int var4;
         if (var12 == null) {
            var4 = 0;
         } else {
            var4 = var12.size();
         }

         JSONObject var13 = new JSONObject();

         try {
            var13.put(var3, var4);
         } catch (JSONException var7) {
            SmartStoreLogger.a("DBOpenHelper", "Error occurred while creating JSON", var7);
         }

         EventBuilderHelper.a(var1, var2, "DBOpenHelper", var13);
         var9 = new DBOpenHelper(var0, var6);
         c.put(var6, var9);
      }

      return var9;
   }

   public static List<String> a(Context param0, UserAccount param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 04: monitorenter
      // 05: new java/util/ArrayList
      // 08: astore 5
      // 0a: aload 5
      // 0c: invokespecial java/util/ArrayList.<init> ()V
      // 0f: aload 1
      // 10: ifnonnull 19
      // 13: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 15: monitorexit
      // 16: aload 5
      // 18: areturn
      // 19: aload 1
      // 1a: aload 2
      // 1b: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.a (Ljava/lang/String;)Ljava/lang/String;
      // 1e: astore 1
      // 1f: new com/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter
      // 22: astore 2
      // 23: aload 2
      // 24: aload 1
      // 25: invokespecial com/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter.<init> (Ljava/lang/String;)V
      // 28: new java/lang/StringBuilder
      // 2b: astore 6
      // 2d: aload 6
      // 2f: invokespecial java/lang/StringBuilder.<init> ()V
      // 32: aload 6
      // 34: aload 0
      // 35: invokevirtual android/content/Context.getApplicationInfo ()Landroid/content/pm/ApplicationInfo;
      // 38: getfield android/content/pm/ApplicationInfo.dataDir Ljava/lang/String;
      // 3b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3e: ldc "/databases"
      // 40: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 43: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 46: astore 6
      // 48: new java/io/File
      // 4b: astore 0
      // 4c: aload 0
      // 4d: aload 6
      // 4f: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 52: aload 0
      // 53: aload 2
      // 54: invokevirtual java/io/File.list (Ljava/io/FilenameFilter;)[Ljava/lang/String;
      // 57: astore 0
      // 58: aload 0
      // 59: ifnull 13
      // 5c: aload 0
      // 5d: arraylength
      // 5e: ifle 13
      // 61: aload 0
      // 62: arraylength
      // 63: istore 4
      // 65: iload 3
      // 66: iload 4
      // 68: if_icmpge 13
      // 6b: aload 0
      // 6c: iload 3
      // 6d: aaload
      // 6e: astore 2
      // 6f: aload 2
      // 70: ldc ".db"
      // 72: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 75: bipush -1
      // 76: if_icmple 8b
      // 79: aload 5
      // 7b: aload 2
      // 7c: bipush 0
      // 7d: aload 2
      // 7e: aload 1
      // 7f: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 82: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 85: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 8a: pop
      // 8b: iinc 3 1
      // 8e: goto 65
      // 91: astore 0
      // 92: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 94: monitorexit
      // 95: aload 0
      // 96: athrow
      // try (4 -> 8): 76 null
      // try (14 -> 45): 76 null
      // try (47 -> 53): 76 null
      // try (60 -> 74): 76 null
   }

   public static Map<String, DBOpenHelper> a() {
      synchronized (DBOpenHelper.class) {
         return c;
      }
   }

   public static void a(Context var0, UserAccount var1) {
      synchronized (DBOpenHelper.class) {
         c(var0, var1, null);
      }
   }

   private static void a(Context var0, String var1) {
      File var6 = new File(var0.getApplicationInfo().dataDir + "/databases");
      if (var6 != null) {
         DBOpenHelper.SmartStoreFileFilter var5 = new DBOpenHelper.SmartStoreFileFilter(var1);
         File[] var4 = var6.listFiles();
         if (var4 != null) {
            for (File var7 : var4) {
               if (var7 != null && var5.accept(var6, var7.getName())) {
                  var7.delete();
                  c.remove(var7.getName());
               }
            }
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void a(SQLiteDatabase var0, String var1, String var2) {
      File var16 = new File(var0.getPath() + "_external_soup_blobs/");
      if (var16.exists()) {
         File[] var17 = var16.listFiles();
         if (var17 != null) {
            int var5 = var17.length;

            for (int var3 = 0; var3 < var5; var3++) {
               File[] var7 = var17[var3].listFiles();
               if (var7 != null) {
                  for (File var8 : var7) {
                     StringBuilder var10 = new StringBuilder();

                     BufferedReader var9;
                     try {
                        FileReader var11 = new FileReader(var8);
                        var9 = new BufferedReader(var11);
                     } catch (IOException var15) {
                        SmartStoreLogger.a("DBOpenHelper", "Exception occurred while rekeying external files", var15);
                        continue;
                     }

                     while (true) {
                        String var20;
                        try {
                           var20 = var9.readLine();
                        } catch (IOException var13) {
                           SmartStoreLogger.a("DBOpenHelper", "Exception occurred while rekeying external files", var13);
                           break;
                        }

                        if (var20 == null) {
                           try {
                              var9.close();
                              String var18 = Encryptor.a(var10.toString(), var1);
                              var8.delete();
                              FileOutputStream var19 = new FileOutputStream(var8, false);
                              var19.write(Encryptor.b(var18, var2).getBytes());
                              var19.close();
                           } catch (IOException var12) {
                              SmartStoreLogger.a("DBOpenHelper", "Exception occurred while rekeying external files", var12);
                           }
                           break;
                        }

                        try {
                           var10.append(var20).append('\n');
                        } catch (IOException var14) {
                           SmartStoreLogger.a("DBOpenHelper", "Exception occurred while rekeying external files", var14);
                           break;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public static boolean a(File var0) {
      int var2 = 0;
      boolean var5;
      if (var0 != null && var0.exists()) {
         boolean var3 = true;
         boolean var1 = true;
         File[] var7 = var0.listFiles();
         if (var7 != null) {
            int var4 = var7.length;

            while (true) {
               var3 = var1;
               if (var2 >= var4) {
                  break;
               }

               File var6 = var7[var2];
               if (var6.isFile()) {
                  var1 &= var6.delete();
               } else {
                  var1 &= a(var6);
               }

               var2++;
            }
         }

         var5 = var3 & var0.delete();
      } else {
         var5 = false;
      }

      return var5;
   }

   public static List<String> b(Context param0, UserAccount param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 6
      // 03: bipush 0
      // 04: istore 3
      // 05: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 07: monitorenter
      // 08: new java/util/ArrayList
      // 0b: astore 7
      // 0d: aload 7
      // 0f: invokespecial java/util/ArrayList.<init> ()V
      // 12: aload 1
      // 13: ifnull 9f
      // 16: aload 1
      // 17: aload 2
      // 18: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.a (Ljava/lang/String;)Ljava/lang/String;
      // 1b: astore 2
      // 1c: aload 1
      // 1d: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.f ()Ljava/lang/String;
      // 20: astore 1
      // 21: new com/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter
      // 24: astore 6
      // 26: aload 6
      // 28: aload 2
      // 29: aload 1
      // 2a: invokespecial com/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 2d: new java/lang/StringBuilder
      // 30: astore 1
      // 31: aload 1
      // 32: invokespecial java/lang/StringBuilder.<init> ()V
      // 35: aload 1
      // 36: aload 0
      // 37: invokevirtual android/content/Context.getApplicationInfo ()Landroid/content/pm/ApplicationInfo;
      // 3a: getfield android/content/pm/ApplicationInfo.dataDir Ljava/lang/String;
      // 3d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 40: ldc "/databases"
      // 42: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 45: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 48: astore 1
      // 49: new java/io/File
      // 4c: astore 0
      // 4d: aload 0
      // 4e: aload 1
      // 4f: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 52: aload 0
      // 53: aload 6
      // 55: invokevirtual java/io/File.list (Ljava/io/FilenameFilter;)[Ljava/lang/String;
      // 58: astore 1
      // 59: aload 1
      // 5a: ifnull 93
      // 5d: aload 1
      // 5e: arraylength
      // 5f: ifle 93
      // 62: aload 1
      // 63: arraylength
      // 64: istore 4
      // 66: iload 3
      // 67: iload 4
      // 69: if_icmpge 93
      // 6c: aload 1
      // 6d: iload 3
      // 6e: aaload
      // 6f: astore 0
      // 70: aload 0
      // 71: ldc ".db"
      // 73: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 76: istore 5
      // 78: iload 5
      // 7a: bipush -1
      // 7b: if_icmple 8d
      // 7e: aload 7
      // 80: aload 0
      // 81: bipush 0
      // 82: iload 5
      // 84: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 87: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 8c: pop
      // 8d: iinc 3 1
      // 90: goto 66
      // 93: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 95: monitorexit
      // 96: aload 7
      // 98: areturn
      // 99: astore 0
      // 9a: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 9c: monitorexit
      // 9d: aload 0
      // 9e: athrow
      // 9f: aconst_null
      // a0: astore 2
      // a1: aload 6
      // a3: astore 1
      // a4: goto 21
      // try (6 -> 10): 82 null
      // try (12 -> 19): 82 null
      // try (19 -> 47): 82 null
      // try (49 -> 55): 82 null
      // try (62 -> 66): 82 null
      // try (69 -> 76): 82 null
   }

   public static void b(Context var0) {
      synchronized (DBOpenHelper.class) {
         a(var0, "00D");
      }
   }

   public static void b(Context param0, String param1, UserAccount param2, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 02: monitorenter
      // 03: new java/lang/StringBuffer
      // 06: astore 4
      // 08: aload 4
      // 0a: aload 1
      // 0b: invokespecial java/lang/StringBuffer.<init> (Ljava/lang/String;)V
      // 0e: aload 2
      // 0f: ifnull 1d
      // 12: aload 4
      // 14: aload 2
      // 15: aload 3
      // 16: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.a (Ljava/lang/String;)Ljava/lang/String;
      // 19: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 1c: pop
      // 1d: aload 4
      // 1f: ldc ".db"
      // 21: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 24: pop
      // 25: aload 4
      // 27: invokevirtual java/lang/StringBuffer.toString ()Ljava/lang/String;
      // 2a: astore 4
      // 2c: getstatic com/salesforce/androidsdk/smartstore/store/DBOpenHelper.c Ljava/util/Map;
      // 2f: aload 4
      // 31: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 36: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 39: astore 5
      // 3b: aload 5
      // 3d: ifnull 50
      // 40: aload 5
      // 42: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.close ()V
      // 45: getstatic com/salesforce/androidsdk/smartstore/store/DBOpenHelper.c Ljava/util/Map;
      // 48: aload 4
      // 4a: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 4f: pop
      // 50: aload 0
      // 51: aload 4
      // 53: invokevirtual android/content/Context.deleteDatabase (Ljava/lang/String;)Z
      // 56: pop
      // 57: aload 2
      // 58: ifnull 7c
      // 5b: aload 3
      // 5c: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 5f: ifeq 7c
      // 62: new java/lang/StringBuffer
      // 65: astore 3
      // 66: aload 3
      // 67: aload 1
      // 68: invokespecial java/lang/StringBuffer.<init> (Ljava/lang/String;)V
      // 6b: aload 3
      // 6c: aload 2
      // 6d: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.u ()Ljava/lang/String;
      // 70: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 73: pop
      // 74: aload 0
      // 75: aload 3
      // 76: invokevirtual java/lang/StringBuffer.toString ()Ljava/lang/String;
      // 79: invokestatic com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Landroid/content/Context;Ljava/lang/String;)V
      // 7c: new java/lang/StringBuilder
      // 7f: astore 1
      // 80: aload 1
      // 81: aload 0
      // 82: invokevirtual android/content/Context.getApplicationInfo ()Landroid/content/pm/ApplicationInfo;
      // 85: getfield android/content/pm/ApplicationInfo.dataDir Ljava/lang/String;
      // 88: invokespecial java/lang/StringBuilder.<init> (Ljava/lang/String;)V
      // 8b: aload 1
      // 8c: ldc_w "/databases/"
      // 8f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 92: aload 4
      // 94: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 97: ldc "_external_soup_blobs/"
      // 99: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9c: pop
      // 9d: new java/io/File
      // a0: astore 0
      // a1: aload 0
      // a2: aload 1
      // a3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a6: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // a9: aload 0
      // aa: invokestatic com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/io/File;)Z
      // ad: pop
      // ae: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // b0: monitorexit
      // b1: return
      // b2: astore 0
      // b3: ldc "DBOpenHelper"
      // b5: ldc_w "Exception occurred while attemption to delete database"
      // b8: aload 0
      // b9: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // bc: goto ae
      // bf: astore 0
      // c0: ldc com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // c2: monitorexit
      // c3: aload 0
      // c4: athrow
      // try (2 -> 7): 85 java/lang/Exception
      // try (2 -> 7): 91 null
      // try (9 -> 15): 85 java/lang/Exception
      // try (9 -> 15): 91 null
      // try (15 -> 27): 85 java/lang/Exception
      // try (15 -> 27): 91 null
      // try (29 -> 35): 85 java/lang/Exception
      // try (29 -> 35): 91 null
      // try (35 -> 39): 85 java/lang/Exception
      // try (35 -> 39): 91 null
      // try (41 -> 58): 85 java/lang/Exception
      // try (41 -> 58): 91 null
      // try (58 -> 82): 85 java/lang/Exception
      // try (58 -> 82): 91 null
      // try (86 -> 90): 91 null
   }

   public static void c(Context var0, UserAccount var1, String var2) {
      synchronized (DBOpenHelper.class) {
         b(var0, "smartstore", var1, var2);
      }
   }

   public File a(String var1, long var2) {
      return new File(this.a(var1), "soupelt_" + var2);
   }

   public String a(String var1) {
      StringBuilder var2 = new StringBuilder(a);
      var2.append("/databases/").append(this.b).append("_external_soup_blobs/");
      if (var1 != null) {
         var2.append(var1).append('/');
      }

      return var2.toString();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public JSONObject a(String var1, long var2, String var4) {
      try {
         var4 = this.b(var1, var2, var4);
      } catch (JSONException var6) {
         SmartStoreLogger.a("DBOpenHelper", "Exception occurred while attempting to read external soup blob", var6);
         return null;
      }

      if (var4 != null) {
         try {
            return new JSONObject(var4);
         } catch (JSONException var5) {
            SmartStoreLogger.a("DBOpenHelper", "Exception occurred while attempting to read external soup blob", var5);
         }
      }

      return null;
   }

   protected void a(Context var1) {
      SqliteLibraryLoader.a(var1);
   }

   public boolean a(String param1, long param2, String param4, String param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: lload 2
      // 03: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;J)Ljava/io/File;
      // 06: astore 1
      // 07: new java/io/FileOutputStream
      // 0a: astore 8
      // 0c: aload 8
      // 0e: aload 1
      // 0f: bipush 0
      // 10: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;Z)V
      // 13: aconst_null
      // 14: astore 1
      // 15: aload 4
      // 17: aload 5
      // 19: invokestatic com/salesforce/androidsdk/analytics/security/Encryptor.c (Ljava/lang/String;Ljava/lang/String;)[B
      // 1c: astore 4
      // 1e: aload 4
      // 20: ifnull 6b
      // 23: aload 8
      // 25: aload 4
      // 27: invokevirtual java/io/FileOutputStream.write ([B)V
      // 2a: bipush 1
      // 2b: istore 7
      // 2d: iload 7
      // 2f: istore 6
      // 31: aload 8
      // 33: ifnull 43
      // 36: bipush 0
      // 37: ifeq 5f
      // 3a: aload 8
      // 3c: invokevirtual java/io/FileOutputStream.close ()V
      // 3f: iload 7
      // 41: istore 6
      // 43: iload 6
      // 45: ireturn
      // 46: astore 1
      // 47: new java/lang/NullPointerException
      // 4a: dup
      // 4b: invokespecial java/lang/NullPointerException.<init> ()V
      // 4e: athrow
      // 4f: astore 1
      // 50: ldc "DBOpenHelper"
      // 52: ldc_w "Exception occurred while attempting to write external soup blob"
      // 55: aload 1
      // 56: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 59: bipush 0
      // 5a: istore 6
      // 5c: goto 43
      // 5f: aload 8
      // 61: invokevirtual java/io/FileOutputStream.close ()V
      // 64: iload 7
      // 66: istore 6
      // 68: goto 43
      // 6b: aload 8
      // 6d: ifnull 59
      // 70: bipush 0
      // 71: ifeq 85
      // 74: aload 8
      // 76: invokevirtual java/io/FileOutputStream.close ()V
      // 79: goto 59
      // 7c: astore 1
      // 7d: new java/lang/NullPointerException
      // 80: dup
      // 81: invokespecial java/lang/NullPointerException.<init> ()V
      // 84: athrow
      // 85: aload 8
      // 87: invokevirtual java/io/FileOutputStream.close ()V
      // 8a: goto 59
      // 8d: astore 1
      // 8e: aload 1
      // 8f: athrow
      // 90: astore 4
      // 92: aload 8
      // 94: ifnull a0
      // 97: aload 1
      // 98: ifnull ae
      // 9b: aload 8
      // 9d: invokevirtual java/io/FileOutputStream.close ()V
      // a0: aload 4
      // a2: athrow
      // a3: astore 5
      // a5: aload 1
      // a6: aload 5
      // a8: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // ab: goto a0
      // ae: aload 8
      // b0: invokevirtual java/io/FileOutputStream.close ()V
      // b3: goto a0
      // b6: astore 4
      // b8: goto 92
      // try (5 -> 11): 41 java/io/IOException
      // try (13 -> 17): 69 java/lang/Throwable
      // try (13 -> 17): 89 null
      // try (19 -> 22): 69 java/lang/Throwable
      // try (19 -> 22): 89 null
      // try (30 -> 32): 36 java/lang/Throwable
      // try (30 -> 32): 41 java/io/IOException
      // try (37 -> 41): 41 java/io/IOException
      // try (49 -> 51): 41 java/io/IOException
      // try (58 -> 60): 61 java/lang/Throwable
      // try (58 -> 60): 41 java/io/IOException
      // try (62 -> 66): 41 java/io/IOException
      // try (66 -> 68): 41 java/io/IOException
      // try (70 -> 72): 72 null
      // try (77 -> 79): 81 java/lang/Throwable
      // try (77 -> 79): 41 java/io/IOException
      // try (79 -> 81): 41 java/io/IOException
      // try (82 -> 85): 41 java/io/IOException
      // try (86 -> 88): 41 java/io/IOException
   }

   public boolean a(String var1, long var2, JSONObject var4, String var5) {
      return this.a(var1, var2, var4.toString(), var5);
   }

   public boolean a(String var1, Long[] var2) {
      boolean var5 = true;
      int var4 = var2.length;

      for (int var3 = 0; var3 < var4; var3++) {
         var5 &= this.a(var1, var2[var3].longValue()).delete();
      }

      return var5;
   }

   public String b(String param1, long param2, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: lload 2
      // 03: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;J)Ljava/io/File;
      // 06: astore 6
      // 08: new java/io/FileInputStream
      // 0b: astore 5
      // 0d: aload 5
      // 0f: aload 6
      // 11: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 14: new java/io/DataInputStream
      // 17: astore 1
      // 18: aload 1
      // 19: aload 5
      // 1b: invokespecial java/io/DataInputStream.<init> (Ljava/io/InputStream;)V
      // 1e: aload 6
      // 20: invokevirtual java/io/File.length ()J
      // 23: l2i
      // 24: newarray 8
      // 26: astore 6
      // 28: aload 1
      // 29: aload 6
      // 2b: invokevirtual java/io/DataInputStream.readFully ([B)V
      // 2e: aload 6
      // 30: aload 4
      // 32: invokestatic com/salesforce/androidsdk/analytics/security/Encryptor.a ([BLjava/lang/String;)Ljava/lang/String;
      // 35: astore 4
      // 37: aload 4
      // 39: astore 1
      // 3a: aload 5
      // 3c: ifnull 4b
      // 3f: bipush 0
      // 40: ifeq 65
      // 43: aload 5
      // 45: invokevirtual java/io/FileInputStream.close ()V
      // 48: aload 4
      // 4a: astore 1
      // 4b: aload 1
      // 4c: areturn
      // 4d: astore 1
      // 4e: new java/lang/NullPointerException
      // 51: dup
      // 52: invokespecial java/lang/NullPointerException.<init> ()V
      // 55: athrow
      // 56: astore 1
      // 57: ldc "DBOpenHelper"
      // 59: ldc_w "Exception occurred while attempting to read external soup blob"
      // 5c: aload 1
      // 5d: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 60: aconst_null
      // 61: astore 1
      // 62: goto 4b
      // 65: aload 5
      // 67: invokevirtual java/io/FileInputStream.close ()V
      // 6a: aload 4
      // 6c: astore 1
      // 6d: goto 4b
      // 70: astore 1
      // 71: aload 1
      // 72: athrow
      // 73: astore 4
      // 75: aload 5
      // 77: ifnull 83
      // 7a: aload 1
      // 7b: ifnull 91
      // 7e: aload 5
      // 80: invokevirtual java/io/FileInputStream.close ()V
      // 83: aload 4
      // 85: athrow
      // 86: astore 5
      // 88: aload 1
      // 89: aload 5
      // 8b: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 8e: goto 83
      // 91: aload 5
      // 93: invokevirtual java/io/FileInputStream.close ()V
      // 96: goto 83
      // 99: astore 4
      // 9b: aconst_null
      // 9c: astore 1
      // 9d: goto 75
      // try (5 -> 10): 44 java/io/IOException
      // try (10 -> 27): 57 java/lang/Throwable
      // try (10 -> 27): 77 null
      // try (33 -> 35): 39 java/lang/Throwable
      // try (33 -> 35): 44 java/io/IOException
      // try (40 -> 44): 44 java/io/IOException
      // try (52 -> 54): 44 java/io/IOException
      // try (58 -> 60): 60 null
      // try (65 -> 67): 69 java/lang/Throwable
      // try (65 -> 67): 44 java/io/IOException
      // try (67 -> 69): 44 java/io/IOException
      // try (70 -> 73): 44 java/io/IOException
      // try (74 -> 76): 44 java/io/IOException
   }

   public boolean b(String var1) {
      return new File(this.a(var1)).mkdirs();
   }

   public boolean c(String var1) {
      boolean var2;
      if (a != null) {
         var2 = a(new File(this.a(var1)));
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public void onCreate(SQLiteDatabase var1) {
      var1.setLockingEnabled(false);
      SmartStore.a(var1);
   }

   @Override
   public void onOpen(SQLiteDatabase var1) {
      new SmartStore(var1).b();
   }

   @Override
   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      var1.setLockingEnabled(false);
      if (var2 == 1) {
         SmartStore.b(var1);
      }

      if (var2 < 3) {
         SmartStore.a(var1, "soup_names", "soup_attrs", new String[]{"externalStorage"});
      }
   }

   static class DBHook implements SQLiteDatabaseHook {
      @Override
      public void postKey(SQLiteDatabase var1) {
      }

      @Override
      public void preKey(SQLiteDatabase var1) {
         var1.execSQL("PRAGMA cipher_default_kdf_iter = '4000'");
      }
   }

   private static class SmartStoreFileFilter implements FilenameFilter {
      private String a;

      public SmartStoreFileFilter(String var1) {
         this.a = var1;
      }

      String a() {
         return this.a;
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (var2 != null && var2.contains(this.a)) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   private static class SmartStoreGlobalFileFilter extends DBOpenHelper.SmartStoreFileFilter {
      String a;

      public SmartStoreGlobalFileFilter(String var1, String var2) {
         super(var1);
         this.a = var2;
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (this.a() != null && (super.accept(var1, var2) || var2.contains(this.a))) {
            var3 = false;
         } else {
            var3 = true;
         }

         return var3;
      }
   }
}
