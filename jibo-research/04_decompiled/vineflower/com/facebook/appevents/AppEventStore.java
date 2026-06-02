package com.facebook.appevents;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
   private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
   private static final String TAG = AppEventStore.class.getName();

   public static void persistEvents(AccessTokenAppIdPair param0, SessionEventsState param1) {
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
      // 00: ldc com/facebook/appevents/AppEventStore
      // 02: monitorenter
      // 03: invokestatic com/facebook/appevents/internal/AppEventUtility.assertIsNotMainThread ()V
      // 06: invokestatic com/facebook/appevents/AppEventStore.readAndClearStore ()Lcom/facebook/appevents/PersistedEvents;
      // 09: astore 2
      // 0a: aload 2
      // 0b: aload 0
      // 0c: invokevirtual com/facebook/appevents/PersistedEvents.containsKey (Lcom/facebook/appevents/AccessTokenAppIdPair;)Z
      // 0f: ifeq 29
      // 12: aload 2
      // 13: aload 0
      // 14: invokevirtual com/facebook/appevents/PersistedEvents.get (Lcom/facebook/appevents/AccessTokenAppIdPair;)Ljava/util/List;
      // 17: aload 1
      // 18: invokevirtual com/facebook/appevents/SessionEventsState.getEventsToPersist ()Ljava/util/List;
      // 1b: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 20: pop
      // 21: aload 2
      // 22: invokestatic com/facebook/appevents/AppEventStore.saveEventsToDisk (Lcom/facebook/appevents/PersistedEvents;)V
      // 25: ldc com/facebook/appevents/AppEventStore
      // 27: monitorexit
      // 28: return
      // 29: aload 2
      // 2a: aload 0
      // 2b: aload 1
      // 2c: invokevirtual com/facebook/appevents/SessionEventsState.getEventsToPersist ()Ljava/util/List;
      // 2f: invokevirtual com/facebook/appevents/PersistedEvents.addEvents (Lcom/facebook/appevents/AccessTokenAppIdPair;Ljava/util/List;)V
      // 32: goto 21
      // 35: astore 0
      // 36: ldc com/facebook/appevents/AppEventStore
      // 38: monitorexit
      // 39: aload 0
      // 3a: athrow
      // try (2 -> 16): 27 null
      // try (16 -> 18): 27 null
      // try (21 -> 26): 27 null
   }

   public static void persistEvents(AppEventCollection param0) {
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
      // 00: ldc com/facebook/appevents/AppEventStore
      // 02: monitorenter
      // 03: invokestatic com/facebook/appevents/internal/AppEventUtility.assertIsNotMainThread ()V
      // 06: invokestatic com/facebook/appevents/AppEventStore.readAndClearStore ()Lcom/facebook/appevents/PersistedEvents;
      // 09: astore 2
      // 0a: aload 0
      // 0b: invokevirtual com/facebook/appevents/AppEventCollection.keySet ()Ljava/util/Set;
      // 0e: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 13: astore 1
      // 14: aload 1
      // 15: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1a: ifeq 3d
      // 1d: aload 1
      // 1e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 23: checkcast com/facebook/appevents/AccessTokenAppIdPair
      // 26: astore 3
      // 27: aload 2
      // 28: aload 3
      // 29: aload 0
      // 2a: aload 3
      // 2b: invokevirtual com/facebook/appevents/AppEventCollection.get (Lcom/facebook/appevents/AccessTokenAppIdPair;)Lcom/facebook/appevents/SessionEventsState;
      // 2e: invokevirtual com/facebook/appevents/SessionEventsState.getEventsToPersist ()Ljava/util/List;
      // 31: invokevirtual com/facebook/appevents/PersistedEvents.addEvents (Lcom/facebook/appevents/AccessTokenAppIdPair;Ljava/util/List;)V
      // 34: goto 14
      // 37: astore 0
      // 38: ldc com/facebook/appevents/AppEventStore
      // 3a: monitorexit
      // 3b: aload 0
      // 3c: athrow
      // 3d: aload 2
      // 3e: invokestatic com/facebook/appevents/AppEventStore.saveEventsToDisk (Lcom/facebook/appevents/PersistedEvents;)V
      // 41: ldc com/facebook/appevents/AppEventStore
      // 43: monitorexit
      // 44: return
      // try (2 -> 9): 24 null
      // try (9 -> 23): 24 null
      // try (29 -> 31): 24 null
   }

   public static PersistedEvents readAndClearStore() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 1
      // 02: ldc com/facebook/appevents/AppEventStore
      // 04: monitorenter
      // 05: invokestatic com/facebook/appevents/internal/AppEventUtility.assertIsNotMainThread ()V
      // 08: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 0b: astore 3
      // 0c: aload 3
      // 0d: ldc "AppEventsLogger.persistedevents"
      // 0f: invokevirtual android/content/Context.openFileInput (Ljava/lang/String;)Ljava/io/FileInputStream;
      // 12: astore 4
      // 14: new com/facebook/appevents/AppEventStore$MovedClassObjectInputStream
      // 17: astore 0
      // 18: new java/io/BufferedInputStream
      // 1b: astore 2
      // 1c: aload 2
      // 1d: aload 4
      // 1f: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;)V
      // 22: aload 0
      // 23: aload 2
      // 24: invokespecial com/facebook/appevents/AppEventStore$MovedClassObjectInputStream.<init> (Ljava/io/InputStream;)V
      // 27: aload 0
      // 28: astore 1
      // 29: aload 0
      // 2a: invokevirtual com/facebook/appevents/AppEventStore$MovedClassObjectInputStream.readObject ()Ljava/lang/Object;
      // 2d: checkcast com/facebook/appevents/PersistedEvents
      // 30: astore 2
      // 31: aload 0
      // 32: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 35: aload 3
      // 36: ldc "AppEventsLogger.persistedevents"
      // 38: invokevirtual android/content/Context.getFileStreamPath (Ljava/lang/String;)Ljava/io/File;
      // 3b: invokevirtual java/io/File.delete ()Z
      // 3e: pop
      // 3f: aload 2
      // 40: astore 0
      // 41: aload 0
      // 42: astore 1
      // 43: aload 0
      // 44: ifnonnull 4f
      // 47: new com/facebook/appevents/PersistedEvents
      // 4a: dup
      // 4b: invokespecial com/facebook/appevents/PersistedEvents.<init> ()V
      // 4e: astore 1
      // 4f: ldc com/facebook/appevents/AppEventStore
      // 51: monitorexit
      // 52: aload 1
      // 53: areturn
      // 54: astore 0
      // 55: getstatic com/facebook/appevents/AppEventStore.TAG Ljava/lang/String;
      // 58: ldc "Got unexpected exception when removing events file: "
      // 5a: aload 0
      // 5b: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 5e: pop
      // 5f: aload 2
      // 60: astore 0
      // 61: goto 41
      // 64: astore 0
      // 65: ldc com/facebook/appevents/AppEventStore
      // 67: monitorexit
      // 68: aload 0
      // 69: athrow
      // 6a: astore 0
      // 6b: aconst_null
      // 6c: astore 0
      // 6d: aload 0
      // 6e: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 71: aload 3
      // 72: ldc "AppEventsLogger.persistedevents"
      // 74: invokevirtual android/content/Context.getFileStreamPath (Ljava/lang/String;)Ljava/io/File;
      // 77: invokevirtual java/io/File.delete ()Z
      // 7a: pop
      // 7b: aconst_null
      // 7c: astore 0
      // 7d: goto 41
      // 80: astore 0
      // 81: getstatic com/facebook/appevents/AppEventStore.TAG Ljava/lang/String;
      // 84: ldc "Got unexpected exception when removing events file: "
      // 86: aload 0
      // 87: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 8a: pop
      // 8b: aconst_null
      // 8c: astore 0
      // 8d: goto 41
      // 90: astore 2
      // 91: aconst_null
      // 92: astore 0
      // 93: aload 0
      // 94: astore 1
      // 95: getstatic com/facebook/appevents/AppEventStore.TAG Ljava/lang/String;
      // 98: ldc "Got unexpected exception while reading events: "
      // 9a: aload 2
      // 9b: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 9e: pop
      // 9f: aload 0
      // a0: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // a3: aload 3
      // a4: ldc "AppEventsLogger.persistedevents"
      // a6: invokevirtual android/content/Context.getFileStreamPath (Ljava/lang/String;)Ljava/io/File;
      // a9: invokevirtual java/io/File.delete ()Z
      // ac: pop
      // ad: aconst_null
      // ae: astore 0
      // af: goto 41
      // b2: astore 0
      // b3: getstatic com/facebook/appevents/AppEventStore.TAG Ljava/lang/String;
      // b6: ldc "Got unexpected exception when removing events file: "
      // b8: aload 0
      // b9: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // bc: pop
      // bd: aconst_null
      // be: astore 0
      // bf: goto 41
      // c2: astore 0
      // c3: aload 1
      // c4: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // c7: aload 3
      // c8: ldc "AppEventsLogger.persistedevents"
      // ca: invokevirtual android/content/Context.getFileStreamPath (Ljava/lang/String;)Ljava/io/File;
      // cd: invokevirtual java/io/File.delete ()Z
      // d0: pop
      // d1: aload 0
      // d2: athrow
      // d3: astore 1
      // d4: getstatic com/facebook/appevents/AppEventStore.TAG Ljava/lang/String;
      // d7: ldc "Got unexpected exception when removing events file: "
      // d9: aload 1
      // da: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // dd: pop
      // de: goto d1
      // e1: astore 0
      // e2: goto c3
      // e5: astore 2
      // e6: goto 93
      // e9: astore 1
      // ea: goto 6d
      // try (4 -> 7): 57 null
      // try (7 -> 21): 62 java/io/FileNotFoundException
      // try (7 -> 21): 84 java/lang/Exception
      // try (7 -> 21): 113 null
      // try (23 -> 27): 134 java/io/FileNotFoundException
      // try (23 -> 27): 132 java/lang/Exception
      // try (23 -> 27): 130 null
      // try (27 -> 29): 57 null
      // try (29 -> 34): 48 java/lang/Exception
      // try (29 -> 34): 57 null
      // try (40 -> 44): 57 null
      // try (49 -> 54): 57 null
      // try (65 -> 67): 57 null
      // try (67 -> 72): 75 java/lang/Exception
      // try (67 -> 72): 57 null
      // try (76 -> 81): 57 null
      // try (89 -> 94): 130 null
      // try (94 -> 96): 57 null
      // try (96 -> 101): 104 java/lang/Exception
      // try (96 -> 101): 57 null
      // try (105 -> 110): 57 null
      // try (114 -> 116): 57 null
      // try (116 -> 121): 123 java/lang/Exception
      // try (116 -> 121): 57 null
      // try (121 -> 123): 57 null
      // try (124 -> 129): 57 null
   }

   private static void saveEventsToDisk(PersistedEvents param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 03: astore 4
      // 05: new java/io/ObjectOutputStream
      // 08: astore 2
      // 09: new java/io/BufferedOutputStream
      // 0c: astore 1
      // 0d: aload 1
      // 0e: aload 4
      // 10: ldc "AppEventsLogger.persistedevents"
      // 12: bipush 0
      // 13: invokevirtual android/content/Context.openFileOutput (Ljava/lang/String;I)Ljava/io/FileOutputStream;
      // 16: invokespecial java/io/BufferedOutputStream.<init> (Ljava/io/OutputStream;)V
      // 19: aload 2
      // 1a: aload 1
      // 1b: invokespecial java/io/ObjectOutputStream.<init> (Ljava/io/OutputStream;)V
      // 1e: aload 2
      // 1f: astore 1
      // 20: aload 2
      // 21: aload 0
      // 22: invokevirtual java/io/ObjectOutputStream.writeObject (Ljava/lang/Object;)V
      // 25: aload 2
      // 26: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 29: return
      // 2a: astore 3
      // 2b: aconst_null
      // 2c: astore 0
      // 2d: aload 0
      // 2e: astore 1
      // 2f: getstatic com/facebook/appevents/AppEventStore.TAG Ljava/lang/String;
      // 32: ldc "Got unexpected exception while persisting events: "
      // 34: aload 3
      // 35: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 38: pop
      // 39: aload 0
      // 3a: astore 1
      // 3b: aload 4
      // 3d: ldc "AppEventsLogger.persistedevents"
      // 3f: invokevirtual android/content/Context.getFileStreamPath (Ljava/lang/String;)Ljava/io/File;
      // 42: invokevirtual java/io/File.delete ()Z
      // 45: pop
      // 46: aload 0
      // 47: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 4a: goto 29
      // 4d: astore 0
      // 4e: aconst_null
      // 4f: astore 1
      // 50: aload 1
      // 51: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 54: aload 0
      // 55: athrow
      // 56: astore 0
      // 57: goto 50
      // 5a: astore 1
      // 5b: goto 46
      // 5e: astore 3
      // 5f: aload 2
      // 60: astore 0
      // 61: goto 2d
      // try (2 -> 15): 23 java/lang/Exception
      // try (2 -> 15): 43 null
      // try (17 -> 20): 54 java/lang/Exception
      // try (17 -> 20): 50 null
      // try (28 -> 33): 50 null
      // try (35 -> 40): 52 java/lang/Exception
      // try (35 -> 40): 50 null
   }

   private static class MovedClassObjectInputStream extends ObjectInputStream {
      private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
      private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

      public MovedClassObjectInputStream(InputStream var1) throws IOException {
         super(var1);
      }

      @Override
      protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
         ObjectStreamClass var2 = super.readClassDescriptor();
         ObjectStreamClass var1;
         if (var2.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
            var1 = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
         } else {
            var1 = var2;
            if (var2.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1")) {
               var1 = ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
            }
         }

         return var1;
      }
   }
}
