package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

final class zzv {
   private static int a = 0;
   private static PendingIntent b;
   private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> c = new SimpleArrayMap<>();
   private final Context d;
   private final zzu e;
   private Messenger f;
   private Messenger g;
   private MessengerCompat h;

   public zzv(Context var1, zzu var2) {
      this.d = var1;
      this.e = var2;
      this.f = new Messenger(new zzw(this, Looper.getMainLooper()));
   }

   private static String a() {
      synchronized (zzv.class) {
         int var0 = a++;
         return Integer.toString(var0);
      }
   }

   private static void a(Context var0, Intent var1) {
      synchronized (zzv.class) {
         if (b == null) {
            Intent var2 = new Intent();
            var2.setPackage("com.google.example.invalidpackage");
            b = PendingIntent.getBroadcast(var0, 0, var2, 0);
         }

         var1.putExtra("app", b);
      }
   }

   private final void a(Message param1) {
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
      // 000: aload 1
      // 001: ifnull 255
      // 004: aload 1
      // 005: getfield android/os/Message.obj Ljava/lang/Object;
      // 008: instanceof android/content/Intent
      // 00b: ifeq 255
      // 00e: aload 1
      // 00f: getfield android/os/Message.obj Ljava/lang/Object;
      // 012: checkcast android/content/Intent
      // 015: astore 2
      // 016: aload 2
      // 017: ldc com/google/android/gms/iid/MessengerCompat
      // 019: invokevirtual java/lang/Class.getClassLoader ()Ljava/lang/ClassLoader;
      // 01c: invokevirtual android/content/Intent.setExtrasClassLoader (Ljava/lang/ClassLoader;)V
      // 01f: aload 2
      // 020: ldc "google.messenger"
      // 022: invokevirtual android/content/Intent.hasExtra (Ljava/lang/String;)Z
      // 025: ifeq 04d
      // 028: aload 2
      // 029: ldc "google.messenger"
      // 02b: invokevirtual android/content/Intent.getParcelableExtra (Ljava/lang/String;)Landroid/os/Parcelable;
      // 02e: astore 2
      // 02f: aload 2
      // 030: instanceof com/google/android/gms/iid/MessengerCompat
      // 033: ifeq 03e
      // 036: aload 0
      // 037: aload 2
      // 038: checkcast com/google/android/gms/iid/MessengerCompat
      // 03b: putfield com/google/firebase/iid/zzv.h Lcom/google/android/gms/iid/MessengerCompat;
      // 03e: aload 2
      // 03f: instanceof android/os/Messenger
      // 042: ifeq 04d
      // 045: aload 0
      // 046: aload 2
      // 047: checkcast android/os/Messenger
      // 04a: putfield com/google/firebase/iid/zzv.g Landroid/os/Messenger;
      // 04d: aload 1
      // 04e: getfield android/os/Message.obj Ljava/lang/Object;
      // 051: checkcast android/content/Intent
      // 054: astore 5
      // 056: aload 5
      // 058: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 05b: astore 1
      // 05c: ldc "com.google.android.c2dm.intent.REGISTRATION"
      // 05e: aload 1
      // 05f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 062: ifne 096
      // 065: ldc "FirebaseInstanceId"
      // 067: bipush 3
      // 068: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 06b: ifeq 088
      // 06e: aload 1
      // 06f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 072: astore 1
      // 073: aload 1
      // 074: invokevirtual java/lang/String.length ()I
      // 077: ifeq 089
      // 07a: ldc "Unexpected response action: "
      // 07c: aload 1
      // 07d: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 080: astore 1
      // 081: ldc "FirebaseInstanceId"
      // 083: aload 1
      // 084: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 087: pop
      // 088: return
      // 089: new java/lang/String
      // 08c: dup
      // 08d: ldc "Unexpected response action: "
      // 08f: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 092: astore 1
      // 093: goto 081
      // 096: aload 5
      // 098: ldc "registration_id"
      // 09a: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 09d: astore 2
      // 09e: aload 2
      // 09f: astore 1
      // 0a0: aload 2
      // 0a1: ifnonnull 0ac
      // 0a4: aload 5
      // 0a6: ldc "unregistered"
      // 0a8: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 0ab: astore 1
      // 0ac: aload 1
      // 0ad: ifnonnull 1a3
      // 0b0: aload 5
      // 0b2: ldc "error"
      // 0b4: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 0b7: astore 2
      // 0b8: aload 2
      // 0b9: ifnonnull 0eb
      // 0bc: aload 5
      // 0be: invokevirtual android/content/Intent.getExtras ()Landroid/os/Bundle;
      // 0c1: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0c4: astore 1
      // 0c5: ldc "FirebaseInstanceId"
      // 0c7: new java/lang/StringBuilder
      // 0ca: dup
      // 0cb: aload 1
      // 0cc: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0cf: invokevirtual java/lang/String.length ()I
      // 0d2: bipush 49
      // 0d4: iadd
      // 0d5: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0d8: ldc "Unexpected response, no error or registration id "
      // 0da: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0dd: aload 1
      // 0de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0e4: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 0e7: pop
      // 0e8: goto 088
      // 0eb: ldc "FirebaseInstanceId"
      // 0ed: bipush 3
      // 0ee: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0f1: ifeq 10e
      // 0f4: aload 2
      // 0f5: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0f8: astore 1
      // 0f9: aload 1
      // 0fa: invokevirtual java/lang/String.length ()I
      // 0fd: ifeq 181
      // 100: ldc "Received InstanceID error "
      // 102: aload 1
      // 103: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 106: astore 1
      // 107: ldc "FirebaseInstanceId"
      // 109: aload 1
      // 10a: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 10d: pop
      // 10e: aload 2
      // 10f: ldc "|"
      // 111: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 114: ifeq 261
      // 117: aload 2
      // 118: ldc "\\|"
      // 11a: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 11d: astore 4
      // 11f: ldc "ID"
      // 121: aload 4
      // 123: bipush 1
      // 124: aaload
      // 125: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 128: ifne 145
      // 12b: aload 2
      // 12c: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 12f: astore 1
      // 130: aload 1
      // 131: invokevirtual java/lang/String.length ()I
      // 134: ifeq 18e
      // 137: ldc "Unexpected structured response "
      // 139: aload 1
      // 13a: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 13d: astore 1
      // 13e: ldc "FirebaseInstanceId"
      // 140: aload 1
      // 141: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 144: pop
      // 145: aload 4
      // 147: arraylength
      // 148: bipush 2
      // 149: if_icmple 19b
      // 14c: aload 4
      // 14e: bipush 2
      // 14f: aaload
      // 150: astore 3
      // 151: aload 4
      // 153: bipush 3
      // 154: aaload
      // 155: astore 4
      // 157: aload 3
      // 158: astore 2
      // 159: aload 4
      // 15b: astore 1
      // 15c: aload 4
      // 15e: ldc ":"
      // 160: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 163: ifeq 16f
      // 166: aload 4
      // 168: bipush 1
      // 169: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 16c: astore 1
      // 16d: aload 3
      // 16e: astore 2
      // 16f: aload 5
      // 171: ldc "error"
      // 173: aload 1
      // 174: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 177: pop
      // 178: aload 0
      // 179: aload 2
      // 17a: aload 1
      // 17b: invokespecial com/google/firebase/iid/zzv.a (Ljava/lang/String;Ljava/lang/String;)V
      // 17e: goto 088
      // 181: new java/lang/String
      // 184: dup
      // 185: ldc "Received InstanceID error "
      // 187: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 18a: astore 1
      // 18b: goto 107
      // 18e: new java/lang/String
      // 191: dup
      // 192: ldc "Unexpected structured response "
      // 194: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 197: astore 1
      // 198: goto 13e
      // 19b: ldc "UNKNOWN"
      // 19d: astore 1
      // 19e: aconst_null
      // 19f: astore 2
      // 1a0: goto 16f
      // 1a3: ldc "\\|ID\\|([^|]+)\\|:?+(.*)"
      // 1a5: invokestatic java/util/regex/Pattern.compile (Ljava/lang/String;)Ljava/util/regex/Pattern;
      // 1a8: aload 1
      // 1a9: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 1ac: astore 2
      // 1ad: aload 2
      // 1ae: invokevirtual java/util/regex/Matcher.matches ()Z
      // 1b1: ifne 1e7
      // 1b4: ldc "FirebaseInstanceId"
      // 1b6: bipush 3
      // 1b7: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 1ba: ifeq 088
      // 1bd: aload 1
      // 1be: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1c1: astore 1
      // 1c2: aload 1
      // 1c3: invokevirtual java/lang/String.length ()I
      // 1c6: ifeq 1da
      // 1c9: ldc "Unexpected response string: "
      // 1cb: aload 1
      // 1cc: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 1cf: astore 1
      // 1d0: ldc "FirebaseInstanceId"
      // 1d2: aload 1
      // 1d3: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 1d6: pop
      // 1d7: goto 088
      // 1da: new java/lang/String
      // 1dd: dup
      // 1de: ldc "Unexpected response string: "
      // 1e0: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 1e3: astore 1
      // 1e4: goto 1d0
      // 1e7: aload 2
      // 1e8: bipush 1
      // 1e9: invokevirtual java/util/regex/Matcher.group (I)Ljava/lang/String;
      // 1ec: astore 1
      // 1ed: aload 2
      // 1ee: bipush 2
      // 1ef: invokevirtual java/util/regex/Matcher.group (I)Ljava/lang/String;
      // 1f2: astore 2
      // 1f3: aload 5
      // 1f5: invokevirtual android/content/Intent.getExtras ()Landroid/os/Bundle;
      // 1f8: astore 3
      // 1f9: aload 3
      // 1fa: ldc "registration_id"
      // 1fc: aload 2
      // 1fd: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 200: aload 0
      // 201: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 204: astore 2
      // 205: aload 2
      // 206: monitorenter
      // 207: aload 0
      // 208: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 20b: aload 1
      // 20c: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 20f: checkcast com/google/android/gms/tasks/TaskCompletionSource
      // 212: astore 4
      // 214: aload 4
      // 216: ifnonnull 24a
      // 219: aload 1
      // 21a: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 21d: astore 1
      // 21e: aload 1
      // 21f: invokevirtual java/lang/String.length ()I
      // 222: ifeq 23d
      // 225: ldc "Missing callback for "
      // 227: aload 1
      // 228: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 22b: astore 1
      // 22c: ldc "FirebaseInstanceId"
      // 22e: aload 1
      // 22f: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 232: pop
      // 233: aload 2
      // 234: monitorexit
      // 235: goto 088
      // 238: astore 1
      // 239: aload 2
      // 23a: monitorexit
      // 23b: aload 1
      // 23c: athrow
      // 23d: new java/lang/String
      // 240: dup
      // 241: ldc "Missing callback for "
      // 243: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 246: astore 1
      // 247: goto 22c
      // 24a: aload 4
      // 24c: aload 3
      // 24d: invokevirtual com/google/android/gms/tasks/TaskCompletionSource.a (Ljava/lang/Object;)V
      // 250: aload 2
      // 251: monitorexit
      // 252: goto 088
      // 255: ldc "FirebaseInstanceId"
      // 257: ldc_w "Dropping invalid message"
      // 25a: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 25d: pop
      // 25e: goto 088
      // 261: aconst_null
      // 262: astore 3
      // 263: aload 2
      // 264: astore 1
      // 265: aload 3
      // 266: astore 2
      // 267: goto 178
      // try (265 -> 271): 290 null
      // try (273 -> 283): 290 null
      // try (283 -> 289): 290 null
      // try (291 -> 293): 290 null
      // try (295 -> 300): 290 null
      // try (301 -> 306): 290 null
   }

   private final void a(String param1, String param2) {
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
      // 01: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 1
      // 0a: ifnonnull 48
      // 0d: bipush 0
      // 0e: istore 3
      // 0f: iload 3
      // 10: aload 0
      // 11: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 14: invokevirtual android/support/v4/util/SimpleArrayMap.size ()I
      // 17: if_icmpge 3d
      // 1a: aload 0
      // 1b: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 1e: iload 3
      // 1f: invokevirtual android/support/v4/util/SimpleArrayMap.c (I)Ljava/lang/Object;
      // 22: checkcast com/google/android/gms/tasks/TaskCompletionSource
      // 25: astore 1
      // 26: new java/io/IOException
      // 29: astore 5
      // 2b: aload 5
      // 2d: aload 2
      // 2e: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 31: aload 1
      // 32: aload 5
      // 34: invokevirtual com/google/android/gms/tasks/TaskCompletionSource.a (Ljava/lang/Exception;)V
      // 37: iinc 3 1
      // 3a: goto 0f
      // 3d: aload 0
      // 3e: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 41: invokevirtual android/support/v4/util/SimpleArrayMap.clear ()V
      // 44: aload 4
      // 46: monitorexit
      // 47: return
      // 48: aload 0
      // 49: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 4c: aload 1
      // 4d: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 50: checkcast com/google/android/gms/tasks/TaskCompletionSource
      // 53: astore 5
      // 55: aload 5
      // 57: ifnonnull 8d
      // 5a: aload 1
      // 5b: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 5e: astore 1
      // 5f: aload 1
      // 60: invokevirtual java/lang/String.length ()I
      // 63: ifeq 80
      // 66: ldc "Missing callback for "
      // 68: aload 1
      // 69: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 6c: astore 1
      // 6d: ldc "FirebaseInstanceId"
      // 6f: aload 1
      // 70: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 73: pop
      // 74: aload 4
      // 76: monitorexit
      // 77: goto 47
      // 7a: astore 1
      // 7b: aload 4
      // 7d: monitorexit
      // 7e: aload 1
      // 7f: athrow
      // 80: new java/lang/String
      // 83: dup
      // 84: ldc "Missing callback for "
      // 86: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 89: astore 1
      // 8a: goto 6d
      // 8d: new java/io/IOException
      // 90: astore 1
      // 91: aload 1
      // 92: aload 2
      // 93: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 96: aload 5
      // 98: aload 1
      // 99: invokevirtual com/google/android/gms/tasks/TaskCompletionSource.a (Ljava/lang/Exception;)V
      // 9c: goto 44
      // try (9 -> 28): 61 null
      // try (30 -> 33): 61 null
      // try (33 -> 35): 61 null
      // try (36 -> 42): 61 null
      // try (44 -> 54): 61 null
      // try (54 -> 60): 61 null
      // try (62 -> 64): 61 null
      // try (66 -> 71): 61 null
      // try (72 -> 80): 61 null
   }

   private final Bundle b(Bundle var1) throws IOException {
      Bundle var3 = this.c(var1);
      Bundle var2 = var3;
      if (var3 != null) {
         var2 = var3;
         if (var3.containsKey("google.messenger")) {
            var1 = this.c(var1);
            var2 = var1;
            if (var1 != null) {
               var2 = var1;
               if (var1.containsKey("google.messenger")) {
                  var2 = null;
               }
            }
         }
      }

      return var2;
   }

   private final Bundle c(Bundle param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: invokestatic com/google/firebase/iid/zzv.a ()Ljava/lang/String;
      // 003: astore 2
      // 004: new com/google/android/gms/tasks/TaskCompletionSource
      // 007: dup
      // 008: invokespecial com/google/android/gms/tasks/TaskCompletionSource.<init> ()V
      // 00b: astore 3
      // 00c: aload 0
      // 00d: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 010: astore 4
      // 012: aload 4
      // 014: monitorenter
      // 015: aload 0
      // 016: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 019: aload 2
      // 01a: aload 3
      // 01b: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 01e: pop
      // 01f: aload 4
      // 021: monitorexit
      // 022: aload 0
      // 023: getfield com/google/firebase/iid/zzv.e Lcom/google/firebase/iid/zzu;
      // 026: invokevirtual com/google/firebase/iid/zzu.a ()I
      // 029: ifne 03d
      // 02c: new java/io/IOException
      // 02f: dup
      // 030: ldc_w "MISSING_INSTANCEID_SERVICE"
      // 033: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 036: athrow
      // 037: astore 1
      // 038: aload 4
      // 03a: monitorexit
      // 03b: aload 1
      // 03c: athrow
      // 03d: new android/content/Intent
      // 040: dup
      // 041: invokespecial android/content/Intent.<init> ()V
      // 044: astore 4
      // 046: aload 4
      // 048: ldc_w "com.google.android.gms"
      // 04b: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
      // 04e: pop
      // 04f: aload 0
      // 050: getfield com/google/firebase/iid/zzv.e Lcom/google/firebase/iid/zzu;
      // 053: invokevirtual com/google/firebase/iid/zzu.a ()I
      // 056: bipush 2
      // 057: if_icmpne 12c
      // 05a: aload 4
      // 05c: ldc_w "com.google.iid.TOKEN_REQUEST"
      // 05f: invokevirtual android/content/Intent.setAction (Ljava/lang/String;)Landroid/content/Intent;
      // 062: pop
      // 063: aload 4
      // 065: aload 1
      // 066: invokevirtual android/content/Intent.putExtras (Landroid/os/Bundle;)Landroid/content/Intent;
      // 069: pop
      // 06a: aload 0
      // 06b: getfield com/google/firebase/iid/zzv.d Landroid/content/Context;
      // 06e: aload 4
      // 070: invokestatic com/google/firebase/iid/zzv.a (Landroid/content/Context;Landroid/content/Intent;)V
      // 073: aload 4
      // 075: ldc_w "kid"
      // 078: new java/lang/StringBuilder
      // 07b: dup
      // 07c: aload 2
      // 07d: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 080: invokevirtual java/lang/String.length ()I
      // 083: bipush 5
      // 084: iadd
      // 085: invokespecial java/lang/StringBuilder.<init> (I)V
      // 088: ldc_w "|ID|"
      // 08b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08e: aload 2
      // 08f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 092: ldc "|"
      // 094: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 097: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 09a: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 09d: pop
      // 09e: ldc "FirebaseInstanceId"
      // 0a0: bipush 3
      // 0a1: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0a4: ifeq 0d4
      // 0a7: aload 4
      // 0a9: invokevirtual android/content/Intent.getExtras ()Landroid/os/Bundle;
      // 0ac: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0af: astore 1
      // 0b0: ldc "FirebaseInstanceId"
      // 0b2: new java/lang/StringBuilder
      // 0b5: dup
      // 0b6: aload 1
      // 0b7: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0ba: invokevirtual java/lang/String.length ()I
      // 0bd: bipush 8
      // 0bf: iadd
      // 0c0: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0c3: ldc_w "Sending "
      // 0c6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c9: aload 1
      // 0ca: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0cd: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0d0: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 0d3: pop
      // 0d4: aload 4
      // 0d6: ldc "google.messenger"
      // 0d8: aload 0
      // 0d9: getfield com/google/firebase/iid/zzv.f Landroid/os/Messenger;
      // 0dc: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
      // 0df: pop
      // 0e0: aload 0
      // 0e1: getfield com/google/firebase/iid/zzv.g Landroid/os/Messenger;
      // 0e4: ifnonnull 0ee
      // 0e7: aload 0
      // 0e8: getfield com/google/firebase/iid/zzv.h Lcom/google/android/gms/iid/MessengerCompat;
      // 0eb: ifnull 156
      // 0ee: invokestatic android/os/Message.obtain ()Landroid/os/Message;
      // 0f1: astore 1
      // 0f2: aload 1
      // 0f3: aload 4
      // 0f5: putfield android/os/Message.obj Ljava/lang/Object;
      // 0f8: aload 0
      // 0f9: getfield com/google/firebase/iid/zzv.g Landroid/os/Messenger;
      // 0fc: ifnull 138
      // 0ff: aload 0
      // 100: getfield com/google/firebase/iid/zzv.g Landroid/os/Messenger;
      // 103: aload 1
      // 104: invokevirtual android/os/Messenger.send (Landroid/os/Message;)V
      // 107: aload 3
      // 108: invokevirtual com/google/android/gms/tasks/TaskCompletionSource.a ()Lcom/google/android/gms/tasks/Task;
      // 10b: ldc2_w 30000
      // 10e: getstatic java/util/concurrent/TimeUnit.MILLISECONDS Ljava/util/concurrent/TimeUnit;
      // 111: invokestatic com/google/android/gms/tasks/Tasks.a (Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
      // 114: checkcast android/os/Bundle
      // 117: astore 3
      // 118: aload 0
      // 119: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 11c: astore 1
      // 11d: aload 1
      // 11e: monitorenter
      // 11f: aload 0
      // 120: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 123: aload 2
      // 124: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 127: pop
      // 128: aload 1
      // 129: monitorexit
      // 12a: aload 3
      // 12b: areturn
      // 12c: aload 4
      // 12e: ldc_w "com.google.android.c2dm.intent.REGISTER"
      // 131: invokevirtual android/content/Intent.setAction (Ljava/lang/String;)Landroid/content/Intent;
      // 134: pop
      // 135: goto 063
      // 138: aload 0
      // 139: getfield com/google/firebase/iid/zzv.h Lcom/google/android/gms/iid/MessengerCompat;
      // 13c: aload 1
      // 13d: invokevirtual com/google/android/gms/iid/MessengerCompat.a (Landroid/os/Message;)V
      // 140: goto 107
      // 143: astore 1
      // 144: ldc "FirebaseInstanceId"
      // 146: bipush 3
      // 147: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 14a: ifeq 156
      // 14d: ldc "FirebaseInstanceId"
      // 14f: ldc_w "Messenger failed, fallback to startService"
      // 152: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 155: pop
      // 156: aload 0
      // 157: getfield com/google/firebase/iid/zzv.e Lcom/google/firebase/iid/zzu;
      // 15a: invokevirtual com/google/firebase/iid/zzu.a ()I
      // 15d: bipush 2
      // 15e: if_icmpne 16d
      // 161: aload 0
      // 162: getfield com/google/firebase/iid/zzv.d Landroid/content/Context;
      // 165: aload 4
      // 167: invokevirtual android/content/Context.sendBroadcast (Landroid/content/Intent;)V
      // 16a: goto 107
      // 16d: aload 0
      // 16e: getfield com/google/firebase/iid/zzv.d Landroid/content/Context;
      // 171: aload 4
      // 173: invokevirtual android/content/Context.startService (Landroid/content/Intent;)Landroid/content/ComponentName;
      // 176: pop
      // 177: goto 107
      // 17a: astore 2
      // 17b: aload 1
      // 17c: monitorexit
      // 17d: aload 2
      // 17e: athrow
      // 17f: astore 1
      // 180: ldc "FirebaseInstanceId"
      // 182: ldc_w "No response"
      // 185: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 188: pop
      // 189: new java/io/IOException
      // 18c: astore 1
      // 18d: aload 1
      // 18e: ldc_w "TIMEOUT"
      // 191: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 194: aload 1
      // 195: athrow
      // 196: astore 3
      // 197: aload 0
      // 198: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 19b: astore 1
      // 19c: aload 1
      // 19d: monitorenter
      // 19e: aload 0
      // 19f: getfield com/google/firebase/iid/zzv.c Landroid/support/v4/util/SimpleArrayMap;
      // 1a2: aload 2
      // 1a3: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 1a6: pop
      // 1a7: aload 1
      // 1a8: monitorexit
      // 1a9: aload 3
      // 1aa: athrow
      // 1ab: astore 1
      // 1ac: aload 1
      // 1ad: invokevirtual java/util/concurrent/ExecutionException.getCause ()Ljava/lang/Throwable;
      // 1b0: astore 3
      // 1b1: aload 3
      // 1b2: instanceof java/io/IOException
      // 1b5: ifeq 1bd
      // 1b8: aload 3
      // 1b9: checkcast java/io/IOException
      // 1bc: athrow
      // 1bd: new java/io/IOException
      // 1c0: astore 1
      // 1c1: aload 1
      // 1c2: aload 3
      // 1c3: invokespecial java/io/IOException.<init> (Ljava/lang/Throwable;)V
      // 1c6: aload 1
      // 1c7: athrow
      // 1c8: astore 2
      // 1c9: aload 1
      // 1ca: monitorexit
      // 1cb: aload 2
      // 1cc: athrow
      // 1cd: astore 1
      // 1ce: goto 180
      // try (11 -> 19): 28 null
      // try (29 -> 31): 28 null
      // try (118 -> 125): 156 android/os/RemoteException
      // try (125 -> 132): 186 java/lang/InterruptedException
      // try (125 -> 132): 235 java/util/concurrent/TimeoutException
      // try (125 -> 132): 213 java/util/concurrent/ExecutionException
      // try (125 -> 132): 198 null
      // try (137 -> 144): 181 null
      // try (151 -> 155): 156 android/os/RemoteException
      // try (182 -> 184): 181 null
      // try (187 -> 198): 198 null
      // try (204 -> 211): 230 null
      // try (214 -> 223): 198 null
      // try (223 -> 230): 198 null
      // try (231 -> 233): 230 null
   }

   final Bundle a(Bundle var1) throws IOException {
      if (this.e.d() >= 12000000) {
         Task var2 = zzi.a(this.d).b(1, var1);

         label41: {
            try {
               var8 = Tasks.a(var2);
               break label41;
            } catch (InterruptedException var4) {
               var7 = var4;
            } catch (ExecutionException var5) {
               var7 = var5;
            }

            if (Log.isLoggable("FirebaseInstanceId", 3)) {
               String var3 = String.valueOf(var7);
               Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(var3).length() + 22).append("Error making request: ").append(var3).toString());
            }

            if (var7.getCause() instanceof zzs && ((zzs)var7.getCause()).a() == 4) {
               return this.b(var1);
            }

            return null;
         }

         var1 = var8;
      } else {
         var1 = this.b(var1);
      }

      return var1;
   }
}
