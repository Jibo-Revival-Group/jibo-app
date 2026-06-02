package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatJellybean {
   private static final Object a = new Object();
   private static Field b;
   private static boolean c;
   private static final Object d = new Object();

   public static Bundle a(Builder var0, NotificationCompat.Action var1) {
      var0.addAction(var1.a(), var1.b(), var1.c());
      Bundle var2 = new Bundle(var1.d());
      if (var1.f() != null) {
         var2.putParcelableArray("android.support.remoteInputs", a(var1.f()));
      }

      if (var1.g() != null) {
         var2.putParcelableArray("android.support.dataRemoteInputs", a(var1.g()));
      }

      var2.putBoolean("android.support.allowGeneratedReplies", var1.e());
      return var2;
   }

   public static Bundle a(Notification param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/app/NotificationCompatJellybean.a Ljava/lang/Object;
      // 03: astore 3
      // 04: aload 3
      // 05: monitorenter
      // 06: getstatic android/support/v4/app/NotificationCompatJellybean.c Z
      // 09: ifeq 12
      // 0c: aload 3
      // 0d: monitorexit
      // 0e: aconst_null
      // 0f: astore 0
      // 10: aload 0
      // 11: areturn
      // 12: getstatic android/support/v4/app/NotificationCompatJellybean.b Ljava/lang/reflect/Field;
      // 15: ifnonnull 48
      // 18: ldc android/app/Notification
      // 1a: ldc "extras"
      // 1c: invokevirtual java/lang/Class.getDeclaredField (Ljava/lang/String;)Ljava/lang/reflect/Field;
      // 1f: astore 1
      // 20: ldc android/os/Bundle
      // 22: aload 1
      // 23: invokevirtual java/lang/reflect/Field.getType ()Ljava/lang/Class;
      // 26: invokevirtual java/lang/Class.isAssignableFrom (Ljava/lang/Class;)Z
      // 29: ifne 3f
      // 2c: ldc "NotificationCompat"
      // 2e: ldc "Notification.extras field is not of type Bundle"
      // 30: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 33: pop
      // 34: bipush 1
      // 35: putstatic android/support/v4/app/NotificationCompatJellybean.c Z
      // 38: aload 3
      // 39: monitorexit
      // 3a: aconst_null
      // 3b: astore 0
      // 3c: goto 10
      // 3f: aload 1
      // 40: bipush 1
      // 41: invokevirtual java/lang/reflect/Field.setAccessible (Z)V
      // 44: aload 1
      // 45: putstatic android/support/v4/app/NotificationCompatJellybean.b Ljava/lang/reflect/Field;
      // 48: getstatic android/support/v4/app/NotificationCompatJellybean.b Ljava/lang/reflect/Field;
      // 4b: aload 0
      // 4c: invokevirtual java/lang/reflect/Field.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 4f: checkcast android/os/Bundle
      // 52: astore 2
      // 53: aload 2
      // 54: astore 1
      // 55: aload 2
      // 56: ifnonnull 69
      // 59: new android/os/Bundle
      // 5c: astore 1
      // 5d: aload 1
      // 5e: invokespecial android/os/Bundle.<init> ()V
      // 61: getstatic android/support/v4/app/NotificationCompatJellybean.b Ljava/lang/reflect/Field;
      // 64: aload 0
      // 65: aload 1
      // 66: invokevirtual java/lang/reflect/Field.set (Ljava/lang/Object;Ljava/lang/Object;)V
      // 69: aload 3
      // 6a: monitorexit
      // 6b: aload 1
      // 6c: astore 0
      // 6d: goto 10
      // 70: astore 0
      // 71: aload 3
      // 72: monitorexit
      // 73: aload 0
      // 74: athrow
      // 75: astore 0
      // 76: ldc "NotificationCompat"
      // 78: ldc "Unable to access notification extras"
      // 7a: aload 0
      // 7b: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 7e: pop
      // 7f: bipush 1
      // 80: putstatic android/support/v4/app/NotificationCompatJellybean.c Z
      // 83: aload 3
      // 84: monitorexit
      // 85: aconst_null
      // 86: astore 0
      // 87: goto 10
      // 8a: astore 0
      // 8b: ldc "NotificationCompat"
      // 8d: ldc "Unable to access notification extras"
      // 8f: aload 0
      // 90: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 93: pop
      // 94: goto 7f
      // try (4 -> 8): 61 null
      // try (12 -> 29): 66 java/lang/IllegalAccessException
      // try (12 -> 29): 79 java/lang/NoSuchFieldException
      // try (12 -> 29): 61 null
      // try (29 -> 31): 61 null
      // try (34 -> 39): 66 java/lang/IllegalAccessException
      // try (34 -> 39): 79 java/lang/NoSuchFieldException
      // try (34 -> 39): 61 null
      // try (39 -> 44): 66 java/lang/IllegalAccessException
      // try (39 -> 44): 79 java/lang/NoSuchFieldException
      // try (39 -> 44): 61 null
      // try (48 -> 56): 66 java/lang/IllegalAccessException
      // try (48 -> 56): 79 java/lang/NoSuchFieldException
      // try (48 -> 56): 61 null
      // try (56 -> 58): 61 null
      // try (62 -> 64): 61 null
      // try (67 -> 72): 61 null
      // try (72 -> 76): 61 null
      // try (80 -> 85): 61 null
   }

   private static Bundle a(RemoteInput var0) {
      Bundle var1 = new Bundle();
      var1.putString("resultKey", var0.a());
      var1.putCharSequence("label", var0.b());
      var1.putCharSequenceArray("choices", var0.c());
      var1.putBoolean("allowFreeFormInput", var0.e());
      var1.putBundle("extras", var0.f());
      Set var2 = var0.d();
      if (var2 != null && !var2.isEmpty()) {
         ArrayList var3 = new ArrayList(var2.size());
         Iterator var4 = var2.iterator();

         while (var4.hasNext()) {
            var3.add((String)var4.next());
         }

         var1.putStringArrayList("allowedDataTypes", var3);
      }

      return var1;
   }

   public static SparseArray<Bundle> a(List<Bundle> var0) {
      SparseArray var3 = null;
      int var2 = var0.size();
      int var1 = 0;

      while (var1 < var2) {
         Bundle var5 = (Bundle)var0.get(var1);
         SparseArray var4 = var3;
         if (var5 != null) {
            var4 = var3;
            if (var3 == null) {
               var4 = new SparseArray();
            }

            var4.put(var1, var5);
         }

         var1++;
         var3 = var4;
      }

      return var3;
   }

   private static Bundle[] a(RemoteInput[] var0) {
      Bundle[] var3;
      if (var0 == null) {
         var3 = null;
      } else {
         Bundle[] var2 = new Bundle[var0.length];

         for (int var1 = 0; var1 < var0.length; var1++) {
            var2[var1] = a(var0[var1]);
         }

         var3 = var2;
      }

      return var3;
   }
}
