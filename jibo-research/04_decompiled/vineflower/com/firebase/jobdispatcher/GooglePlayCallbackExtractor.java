package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.util.Pair;

final class GooglePlayCallbackExtractor {
   private static Boolean a = null;

   private static String a(Parcel var0) {
      String var1;
      if (a()) {
         var1 = var0.readString();
      } else {
         Object var2 = var0.readValue(null);
         if (!(var2 instanceof String)) {
            Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
            var1 = null;
         } else {
            var1 = (String)var2;
         }
      }

      return var1;
   }

   private static void a(boolean var0) {
      if (!var0) {
         throw new IllegalStateException();
      }
   }

   private static boolean a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 1
      // 02: ldc com/firebase/jobdispatcher/GooglePlayCallbackExtractor
      // 04: monitorenter
      // 05: getstatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a Ljava/lang/Boolean;
      // 08: ifnonnull 5d
      // 0b: new android/os/Bundle
      // 0e: astore 2
      // 0f: aload 2
      // 10: invokespecial android/os/Bundle.<init> ()V
      // 13: aload 2
      // 14: ldc "key"
      // 16: ldc "value"
      // 18: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1b: aload 2
      // 1c: invokestatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.c (Landroid/os/Bundle;)Landroid/os/Parcel;
      // 1f: astore 2
      // 20: aload 2
      // 21: invokevirtual android/os/Parcel.readInt ()I
      // 24: ifle 69
      // 27: bipush 1
      // 28: istore 0
      // 29: iload 0
      // 2a: invokestatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a (Z)V
      // 2d: aload 2
      // 2e: invokevirtual android/os/Parcel.readInt ()I
      // 31: ldc 1279544898
      // 33: if_icmpne 6e
      // 36: bipush 1
      // 37: istore 0
      // 38: iload 0
      // 39: invokestatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a (Z)V
      // 3c: aload 2
      // 3d: invokevirtual android/os/Parcel.readInt ()I
      // 40: bipush 1
      // 41: if_icmpne 73
      // 44: iload 1
      // 45: istore 0
      // 46: iload 0
      // 47: invokestatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a (Z)V
      // 4a: ldc "key"
      // 4c: aload 2
      // 4d: invokevirtual android/os/Parcel.readString ()Ljava/lang/String;
      // 50: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 53: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 56: putstatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a Ljava/lang/Boolean;
      // 59: aload 2
      // 5a: invokevirtual android/os/Parcel.recycle ()V
      // 5d: getstatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a Ljava/lang/Boolean;
      // 60: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 63: istore 0
      // 64: ldc com/firebase/jobdispatcher/GooglePlayCallbackExtractor
      // 66: monitorexit
      // 67: iload 0
      // 68: ireturn
      // 69: bipush 0
      // 6a: istore 0
      // 6b: goto 29
      // 6e: bipush 0
      // 6f: istore 0
      // 70: goto 38
      // 73: bipush 0
      // 74: istore 0
      // 75: goto 46
      // 78: astore 3
      // 79: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 7c: putstatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a Ljava/lang/Boolean;
      // 7f: aload 2
      // 80: invokevirtual android/os/Parcel.recycle ()V
      // 83: goto 5d
      // 86: astore 2
      // 87: ldc com/firebase/jobdispatcher/GooglePlayCallbackExtractor
      // 89: monitorexit
      // 8a: aload 2
      // 8b: athrow
      // 8c: astore 3
      // 8d: aload 2
      // 8e: invokevirtual android/os/Parcel.recycle ()V
      // 91: aload 3
      // 92: athrow
      // try (4 -> 17): 70 null
      // try (17 -> 20): 64 java/lang/RuntimeException
      // try (17 -> 20): 75 null
      // try (22 -> 28): 64 java/lang/RuntimeException
      // try (22 -> 28): 75 null
      // try (30 -> 36): 64 java/lang/RuntimeException
      // try (30 -> 36): 75 null
      // try (38 -> 46): 64 java/lang/RuntimeException
      // try (38 -> 46): 75 null
      // try (46 -> 48): 70 null
      // try (48 -> 51): 70 null
      // try (65 -> 67): 75 null
      // try (67 -> 69): 70 null
      // try (76 -> 80): 70 null
   }

   @SuppressLint("ParcelClassLoader")
   private static Pair<JobCallback, Bundle> b(Bundle param0) {
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
      // 000: new android/os/Bundle
      // 003: dup
      // 004: invokespecial android/os/Bundle.<init> ()V
      // 007: astore 4
      // 009: aload 0
      // 00a: invokestatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.c (Landroid/os/Bundle;)Landroid/os/Parcel;
      // 00d: astore 3
      // 00e: aload 3
      // 00f: invokevirtual android/os/Parcel.readInt ()I
      // 012: ifgt 025
      // 015: ldc "FJD.GooglePlayReceiver"
      // 017: ldc "No callback received, terminating"
      // 019: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 01c: pop
      // 01d: aload 3
      // 01e: invokevirtual android/os/Parcel.recycle ()V
      // 021: aconst_null
      // 022: astore 0
      // 023: aload 0
      // 024: areturn
      // 025: aload 3
      // 026: invokevirtual android/os/Parcel.readInt ()I
      // 029: ldc 1279544898
      // 02b: if_icmpeq 03f
      // 02e: ldc "FJD.GooglePlayReceiver"
      // 030: ldc "No callback received, terminating"
      // 032: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 035: pop
      // 036: aload 3
      // 037: invokevirtual android/os/Parcel.recycle ()V
      // 03a: aconst_null
      // 03b: astore 0
      // 03c: goto 023
      // 03f: aload 3
      // 040: invokevirtual android/os/Parcel.readInt ()I
      // 043: istore 2
      // 044: bipush 0
      // 045: istore 1
      // 046: aconst_null
      // 047: astore 0
      // 048: iload 1
      // 049: iload 2
      // 04a: if_icmpge 14f
      // 04d: aload 3
      // 04e: invokestatic com/firebase/jobdispatcher/GooglePlayCallbackExtractor.a (Landroid/os/Parcel;)Ljava/lang/String;
      // 051: astore 6
      // 053: aload 6
      // 055: ifnonnull 05e
      // 058: iinc 1 1
      // 05b: goto 048
      // 05e: aload 0
      // 05f: ifnonnull 06c
      // 062: ldc "callback"
      // 064: aload 6
      // 066: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 069: ifne 103
      // 06c: aload 3
      // 06d: aconst_null
      // 06e: invokevirtual android/os/Parcel.readValue (Ljava/lang/ClassLoader;)Ljava/lang/Object;
      // 071: astore 5
      // 073: aload 5
      // 075: instanceof java/lang/String
      // 078: ifeq 08a
      // 07b: aload 4
      // 07d: aload 6
      // 07f: aload 5
      // 081: checkcast java/lang/String
      // 084: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 087: goto 058
      // 08a: aload 5
      // 08c: instanceof java/lang/Boolean
      // 08f: ifeq 0a4
      // 092: aload 4
      // 094: aload 6
      // 096: aload 5
      // 098: checkcast java/lang/Boolean
      // 09b: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 09e: invokevirtual android/os/Bundle.putBoolean (Ljava/lang/String;Z)V
      // 0a1: goto 058
      // 0a4: aload 5
      // 0a6: instanceof java/lang/Integer
      // 0a9: ifeq 0be
      // 0ac: aload 4
      // 0ae: aload 6
      // 0b0: aload 5
      // 0b2: checkcast java/lang/Integer
      // 0b5: invokevirtual java/lang/Integer.intValue ()I
      // 0b8: invokevirtual android/os/Bundle.putInt (Ljava/lang/String;I)V
      // 0bb: goto 058
      // 0be: aload 5
      // 0c0: instanceof java/util/ArrayList
      // 0c3: ifeq 0d5
      // 0c6: aload 4
      // 0c8: aload 6
      // 0ca: aload 5
      // 0cc: checkcast java/util/ArrayList
      // 0cf: invokevirtual android/os/Bundle.putParcelableArrayList (Ljava/lang/String;Ljava/util/ArrayList;)V
      // 0d2: goto 058
      // 0d5: aload 5
      // 0d7: instanceof android/os/Bundle
      // 0da: ifeq 0ec
      // 0dd: aload 4
      // 0df: aload 6
      // 0e1: aload 5
      // 0e3: checkcast android/os/Bundle
      // 0e6: invokevirtual android/os/Bundle.putBundle (Ljava/lang/String;Landroid/os/Bundle;)V
      // 0e9: goto 058
      // 0ec: aload 5
      // 0ee: instanceof android/os/Parcelable
      // 0f1: ifeq 172
      // 0f4: aload 4
      // 0f6: aload 6
      // 0f8: aload 5
      // 0fa: checkcast android/os/Parcelable
      // 0fd: invokevirtual android/os/Bundle.putParcelable (Ljava/lang/String;Landroid/os/Parcelable;)V
      // 100: goto 058
      // 103: aload 3
      // 104: invokevirtual android/os/Parcel.readInt ()I
      // 107: bipush 4
      // 108: if_icmpeq 11c
      // 10b: ldc "FJD.GooglePlayReceiver"
      // 10d: ldc "Bad callback received, terminating"
      // 10f: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 112: pop
      // 113: aload 3
      // 114: invokevirtual android/os/Parcel.recycle ()V
      // 117: aconst_null
      // 118: astore 0
      // 119: goto 023
      // 11c: ldc "com.google.android.gms.gcm.PendingCallback"
      // 11e: aload 3
      // 11f: invokevirtual android/os/Parcel.readString ()Ljava/lang/String;
      // 122: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 125: ifne 139
      // 128: ldc "FJD.GooglePlayReceiver"
      // 12a: ldc "Bad callback received, terminating"
      // 12c: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 12f: pop
      // 130: aload 3
      // 131: invokevirtual android/os/Parcel.recycle ()V
      // 134: aconst_null
      // 135: astore 0
      // 136: goto 023
      // 139: new com/firebase/jobdispatcher/GooglePlayJobCallback
      // 13c: dup
      // 13d: aload 3
      // 13e: invokevirtual android/os/Parcel.readStrongBinder ()Landroid/os/IBinder;
      // 141: invokespecial com/firebase/jobdispatcher/GooglePlayJobCallback.<init> (Landroid/os/IBinder;)V
      // 144: astore 0
      // 145: goto 058
      // 148: astore 0
      // 149: aload 3
      // 14a: invokevirtual android/os/Parcel.recycle ()V
      // 14d: aload 0
      // 14e: athrow
      // 14f: aload 0
      // 150: ifnonnull 164
      // 153: ldc "FJD.GooglePlayReceiver"
      // 155: ldc "No callback received, terminating"
      // 157: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 15a: pop
      // 15b: aload 3
      // 15c: invokevirtual android/os/Parcel.recycle ()V
      // 15f: aconst_null
      // 160: astore 0
      // 161: goto 023
      // 164: aload 0
      // 165: aload 4
      // 167: invokestatic android/util/Pair.create (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
      // 16a: astore 0
      // 16b: aload 3
      // 16c: invokevirtual android/os/Parcel.recycle ()V
      // 16f: goto 023
      // 172: goto 058
      // try (7 -> 14): 150 null
      // try (20 -> 28): 150 null
      // try (33 -> 36): 150 null
      // try (43 -> 46): 150 null
      // try (52 -> 56): 150 null
      // try (56 -> 68): 150 null
      // try (69 -> 78): 150 null
      // try (79 -> 88): 150 null
      // try (89 -> 97): 150 null
      // try (98 -> 106): 150 null
      // try (107 -> 115): 150 null
      // try (116 -> 124): 150 null
      // try (129 -> 138): 150 null
      // try (143 -> 149): 150 null
      // try (157 -> 161): 150 null
      // try (166 -> 170): 150 null
   }

   private static Parcel c(Bundle var0) {
      Parcel var1 = Parcel.obtain();
      var0.writeToParcel(var1, 0);
      var1.setDataPosition(0);
      return var1;
   }

   public Pair<JobCallback, Bundle> a(Bundle var1) {
      Pair var2;
      if (var1 == null) {
         Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
         var2 = null;
      } else {
         var2 = b(var1);
      }

      return var2;
   }
}
