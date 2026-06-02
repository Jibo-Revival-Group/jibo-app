package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Kit;
import org.json.JSONObject;

class DefaultCachedSettingsIo implements CachedSettingsIo {
   private final Kit a;

   public DefaultCachedSettingsIo(Kit var1) {
      this.a = var1;
   }

   @Override
   public JSONObject a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aconst_null
      // 03: astore 3
      // 04: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 07: ldc "Fabric"
      // 09: ldc "Reading cached settings..."
      // 0b: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 10: new java/io/File
      // 13: astore 4
      // 15: new io/fabric/sdk/android/services/persistence/FileStoreImpl
      // 18: astore 1
      // 19: aload 1
      // 1a: aload 0
      // 1b: getfield io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo.a Lio/fabric/sdk/android/Kit;
      // 1e: invokespecial io/fabric/sdk/android/services/persistence/FileStoreImpl.<init> (Lio/fabric/sdk/android/Kit;)V
      // 21: aload 4
      // 23: aload 1
      // 24: invokevirtual io/fabric/sdk/android/services/persistence/FileStoreImpl.a ()Ljava/io/File;
      // 27: ldc "com.crashlytics.settings.json"
      // 29: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 2c: aload 4
      // 2e: invokevirtual java/io/File.exists ()Z
      // 31: ifeq 60
      // 34: new java/io/FileInputStream
      // 37: astore 1
      // 38: aload 1
      // 39: aload 4
      // 3b: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 3e: aload 1
      // 3f: astore 2
      // 40: aload 1
      // 41: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/InputStream;)Ljava/lang/String;
      // 44: astore 4
      // 46: aload 1
      // 47: astore 2
      // 48: new org/json/JSONObject
      // 4b: astore 3
      // 4c: aload 1
      // 4d: astore 2
      // 4e: aload 3
      // 4f: aload 4
      // 51: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 54: aload 1
      // 55: astore 2
      // 56: aload 3
      // 57: astore 1
      // 58: aload 2
      // 59: ldc "Error while closing settings cache file."
      // 5b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 5e: aload 1
      // 5f: areturn
      // 60: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 63: ldc "Fabric"
      // 65: ldc "No cached settings found."
      // 67: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 6c: aconst_null
      // 6d: astore 1
      // 6e: aload 3
      // 6f: astore 2
      // 70: goto 58
      // 73: astore 3
      // 74: aconst_null
      // 75: astore 1
      // 76: aload 1
      // 77: astore 2
      // 78: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 7b: ldc "Fabric"
      // 7d: ldc "Failed to fetch cached settings"
      // 7f: aload 3
      // 80: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 85: aload 1
      // 86: ldc "Error while closing settings cache file."
      // 88: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 8b: aconst_null
      // 8c: astore 1
      // 8d: goto 5e
      // 90: astore 3
      // 91: aload 2
      // 92: astore 1
      // 93: aload 1
      // 94: ldc "Error while closing settings cache file."
      // 96: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 99: aload 3
      // 9a: athrow
      // 9b: astore 1
      // 9c: aload 1
      // 9d: astore 3
      // 9e: aload 2
      // 9f: astore 1
      // a0: goto 93
      // a3: astore 3
      // a4: goto 76
      // try (8 -> 29): 61 java/lang/Exception
      // try (8 -> 29): 77 null
      // try (31 -> 34): 91 java/lang/Exception
      // try (31 -> 34): 85 null
      // try (36 -> 38): 91 java/lang/Exception
      // try (36 -> 38): 85 null
      // try (40 -> 43): 91 java/lang/Exception
      // try (40 -> 43): 85 null
      // try (52 -> 56): 61 java/lang/Exception
      // try (52 -> 56): 77 null
      // try (66 -> 71): 85 null
   }

   @Override
   public void a(long param1, JSONObject param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 03: ldc "Fabric"
      // 05: ldc "Writing settings to cache file..."
      // 07: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 0c: aload 3
      // 0d: ifnull 63
      // 10: aconst_null
      // 11: astore 4
      // 13: aload 3
      // 14: ldc "expires_at"
      // 16: lload 1
      // 17: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 1a: pop
      // 1b: new java/io/FileWriter
      // 1e: astore 5
      // 20: new java/io/File
      // 23: astore 6
      // 25: new io/fabric/sdk/android/services/persistence/FileStoreImpl
      // 28: astore 7
      // 2a: aload 7
      // 2c: aload 0
      // 2d: getfield io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo.a Lio/fabric/sdk/android/Kit;
      // 30: invokespecial io/fabric/sdk/android/services/persistence/FileStoreImpl.<init> (Lio/fabric/sdk/android/Kit;)V
      // 33: aload 6
      // 35: aload 7
      // 37: invokevirtual io/fabric/sdk/android/services/persistence/FileStoreImpl.a ()Ljava/io/File;
      // 3a: ldc "com.crashlytics.settings.json"
      // 3c: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 3f: aload 5
      // 41: aload 6
      // 43: invokespecial java/io/FileWriter.<init> (Ljava/io/File;)V
      // 46: aload 5
      // 48: astore 4
      // 4a: aload 5
      // 4c: aload 3
      // 4d: invokevirtual org/json/JSONObject.toString ()Ljava/lang/String;
      // 50: invokevirtual java/io/FileWriter.write (Ljava/lang/String;)V
      // 53: aload 5
      // 55: astore 4
      // 57: aload 5
      // 59: invokevirtual java/io/FileWriter.flush ()V
      // 5c: aload 5
      // 5e: ldc "Failed to close settings writer."
      // 60: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 63: return
      // 64: astore 6
      // 66: aconst_null
      // 67: astore 3
      // 68: aload 3
      // 69: astore 4
      // 6b: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 6e: ldc "Fabric"
      // 70: ldc "Failed to cache settings"
      // 72: aload 6
      // 74: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 79: aload 3
      // 7a: ldc "Failed to close settings writer."
      // 7c: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 7f: goto 63
      // 82: astore 3
      // 83: aload 4
      // 85: ldc "Failed to close settings writer."
      // 87: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 8a: aload 3
      // 8b: athrow
      // 8c: astore 3
      // 8d: goto 83
      // 90: astore 6
      // 92: aload 5
      // 94: astore 3
      // 95: goto 68
      // try (8 -> 31): 45 java/lang/Exception
      // try (8 -> 31): 59 null
      // try (33 -> 37): 67 java/lang/Exception
      // try (33 -> 37): 65 null
      // try (39 -> 41): 67 java/lang/Exception
      // try (39 -> 41): 65 null
      // try (50 -> 55): 65 null
   }
}
