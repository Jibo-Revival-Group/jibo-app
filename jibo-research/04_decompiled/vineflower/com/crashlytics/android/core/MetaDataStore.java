package com.crashlytics.android.core;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class MetaDataStore {
   private static final Charset a = Charset.forName("UTF-8");
   private final File b;

   public MetaDataStore(File var1) {
      this.b = var1;
   }

   private static String a(JSONObject var0, String var1) {
      String var2 = null;
      if (!var0.isNull(var1)) {
         var2 = var0.optString(var1, null);
      }

      return var2;
   }

   private File c(String var1) {
      return new File(this.b, var1 + "user" + ".meta");
   }

   private File d(String var1) {
      return new File(this.b, var1 + "keys" + ".meta");
   }

   private static UserMetaData e(String var0) throws JSONException {
      JSONObject var1 = new JSONObject(var0);
      return new UserMetaData(a(var1, "userId"), a(var1, "userName"), a(var1, "userEmail"));
   }

   private static Map<String, String> f(String var0) throws JSONException {
      JSONObject var1 = new JSONObject(var0);
      HashMap var2 = new HashMap();
      Iterator var4 = var1.keys();

      while (var4.hasNext()) {
         String var3 = (String)var4.next();
         var2.put(var3, a(var1, var3));
      }

      return var2;
   }

   public UserMetaData a(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokespecial com/crashlytics/android/core/MetaDataStore.c (Ljava/lang/String;)Ljava/io/File;
      // 05: astore 1
      // 06: aload 1
      // 07: invokevirtual java/io/File.exists ()Z
      // 0a: ifne 13
      // 0d: getstatic com/crashlytics/android/core/UserMetaData.a Lcom/crashlytics/android/core/UserMetaData;
      // 10: astore 1
      // 11: aload 1
      // 12: areturn
      // 13: new java/io/FileInputStream
      // 16: astore 2
      // 17: aload 2
      // 18: aload 1
      // 19: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 1c: aload 2
      // 1d: astore 1
      // 1e: aload 2
      // 1f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/InputStream;)Ljava/lang/String;
      // 22: invokestatic com/crashlytics/android/core/MetaDataStore.e (Ljava/lang/String;)Lcom/crashlytics/android/core/UserMetaData;
      // 25: astore 3
      // 26: aload 3
      // 27: astore 1
      // 28: aload 2
      // 29: ldc "Failed to close user metadata file."
      // 2b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 2e: goto 11
      // 31: astore 3
      // 32: aconst_null
      // 33: astore 2
      // 34: aload 2
      // 35: astore 1
      // 36: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 39: ldc "CrashlyticsCore"
      // 3b: ldc "Error deserializing user metadata."
      // 3d: aload 3
      // 3e: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 43: aload 2
      // 44: ldc "Failed to close user metadata file."
      // 46: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 49: getstatic com/crashlytics/android/core/UserMetaData.a Lcom/crashlytics/android/core/UserMetaData;
      // 4c: astore 1
      // 4d: goto 11
      // 50: astore 2
      // 51: aconst_null
      // 52: astore 1
      // 53: aload 1
      // 54: ldc "Failed to close user metadata file."
      // 56: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 59: aload 2
      // 5a: athrow
      // 5b: astore 2
      // 5c: goto 53
      // 5f: astore 3
      // 60: goto 34
      // try (11 -> 16): 28 java/lang/Exception
      // try (11 -> 16): 44 null
      // try (18 -> 22): 54 java/lang/Exception
      // try (18 -> 22): 52 null
      // try (33 -> 38): 52 null
   }

   public Map<String, String> b(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1052)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:502)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokespecial com/crashlytics/android/core/MetaDataStore.d (Ljava/lang/String;)Ljava/io/File;
      // 05: astore 1
      // 06: aload 1
      // 07: invokevirtual java/io/File.exists ()Z
      // 0a: ifne 13
      // 0d: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 10: astore 1
      // 11: aload 1
      // 12: areturn
      // 13: new java/io/FileInputStream
      // 16: astore 2
      // 17: aload 2
      // 18: aload 1
      // 19: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 1c: aload 2
      // 1d: astore 1
      // 1e: aload 2
      // 1f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/InputStream;)Ljava/lang/String;
      // 22: invokestatic com/crashlytics/android/core/MetaDataStore.f (Ljava/lang/String;)Ljava/util/Map;
      // 25: astore 3
      // 26: aload 3
      // 27: astore 1
      // 28: aload 2
      // 29: ldc "Failed to close user metadata file."
      // 2b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 2e: goto 11
      // 31: astore 3
      // 32: aconst_null
      // 33: astore 2
      // 34: aload 2
      // 35: astore 1
      // 36: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 39: ldc "CrashlyticsCore"
      // 3b: ldc "Error deserializing user metadata."
      // 3d: aload 3
      // 3e: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 43: aload 2
      // 44: ldc "Failed to close user metadata file."
      // 46: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 49: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 4c: astore 1
      // 4d: goto 11
      // 50: astore 1
      // 51: aconst_null
      // 52: astore 3
      // 53: aload 1
      // 54: astore 2
      // 55: aload 3
      // 56: ldc "Failed to close user metadata file."
      // 58: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 5b: aload 2
      // 5c: athrow
      // 5d: astore 2
      // 5e: aload 1
      // 5f: astore 3
      // 60: goto 55
      // 63: astore 3
      // 64: goto 34
      // try (11 -> 16): 28 java/lang/Exception
      // try (11 -> 16): 44 null
      // try (18 -> 22): 58 java/lang/Exception
      // try (18 -> 22): 54 null
      // try (33 -> 38): 54 null
   }
}
