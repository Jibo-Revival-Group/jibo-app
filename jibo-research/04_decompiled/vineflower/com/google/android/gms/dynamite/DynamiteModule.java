package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
   public static final DynamiteModule.zzd a = new com.google.android.gms.dynamite.zzb();
   public static final DynamiteModule.zzd b = new com.google.android.gms.dynamite.zzd();
   public static final DynamiteModule.zzd c = new zze();
   public static final DynamiteModule.zzd d = new zzf();
   public static final DynamiteModule.zzd e = new zzg();
   private static Boolean f;
   private static zzk g;
   private static zzm h;
   private static String i;
   private static final ThreadLocal<DynamiteModule.zza> j = new ThreadLocal<>();
   private static final zzi k = new com.google.android.gms.dynamite.zza();
   private static DynamiteModule.zzd l = new com.google.android.gms.dynamite.zzc();
   private final Context m;

   private DynamiteModule(Context var1) {
      this.m = zzbq.a(var1);
   }

   public static int a(Context var0, String var1) {
      try {
         ClassLoader var10 = var0.getApplicationContext().getClassLoader();
         int var4 = String.valueOf("com.google.android.gms.dynamite.descriptors.").length();
         int var3 = String.valueOf(var1).length();
         int var13 = String.valueOf("ModuleDescriptor").length();
         StringBuilder var5 = new StringBuilder(var4 + 1 + var3 + var13);
         Class var16 = var10.loadClass(
            var5.append("com.google.android.gms.dynamite.descriptors.").append(var1).append(".").append("ModuleDescriptor").toString()
         );
         Field var11 = var16.getDeclaredField("MODULE_ID");
         Field var17 = var16.getDeclaredField("MODULE_VERSION");
         if (var11.get(null).equals(var1)) {
            return var17.getInt(null);
         }

         String var12 = String.valueOf(var11.get(null));
         var13 = String.valueOf(var12).length();
         var3 = String.valueOf(var1).length();
         var5 = new StringBuilder(var13 + 51 + var3);
         Log.e("DynamiteModule", var5.append("Module descriptor id '").append(var12).append("' didn't match expected id '").append(var1).append("'").toString());
         return 0;
      } catch (ClassNotFoundException var6) {
         Log.w(
            "DynamiteModule",
            new StringBuilder(String.valueOf(var1).length() + 45).append("Local module descriptor class for ").append(var1).append(" not found.").toString()
         );
      } catch (Exception var7) {
         String var8 = String.valueOf(var7.getMessage());
         String var9;
         if (var8.length() != 0) {
            var9 = "Failed to load module descriptor class: ".concat(var8);
         } else {
            var9 = new String("Failed to load module descriptor class: ");
         }

         Log.e("DynamiteModule", var9);
      }

      return 0;
   }

   public static int a(Context param0, String param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: ldc com/google/android/gms/dynamite/DynamiteModule
      // 002: monitorenter
      // 003: getstatic com/google/android/gms/dynamite/DynamiteModule.f Ljava/lang/Boolean;
      // 006: astore 6
      // 008: aload 6
      // 00a: astore 5
      // 00c: aload 6
      // 00e: ifnonnull 053
      // 011: aload 0
      // 012: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 015: invokevirtual android/content/Context.getClassLoader ()Ljava/lang/ClassLoader;
      // 018: ldc com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader
      // 01a: invokevirtual java/lang/Class.getName ()Ljava/lang/String;
      // 01d: invokevirtual java/lang/ClassLoader.loadClass (Ljava/lang/String;)Ljava/lang/Class;
      // 020: astore 6
      // 022: aload 6
      // 024: ldc "sClassLoader"
      // 026: invokevirtual java/lang/Class.getDeclaredField (Ljava/lang/String;)Ljava/lang/reflect/Field;
      // 029: astore 5
      // 02b: aload 6
      // 02d: monitorenter
      // 02e: aload 5
      // 030: aconst_null
      // 031: invokevirtual java/lang/reflect/Field.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 034: checkcast java/lang/ClassLoader
      // 037: astore 7
      // 039: aload 7
      // 03b: ifnull 074
      // 03e: aload 7
      // 040: invokestatic java/lang/ClassLoader.getSystemClassLoader ()Ljava/lang/ClassLoader;
      // 043: if_acmpne 067
      // 046: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 049: astore 5
      // 04b: aload 6
      // 04d: monitorexit
      // 04e: aload 5
      // 050: putstatic com/google/android/gms/dynamite/DynamiteModule.f Ljava/lang/Boolean;
      // 053: ldc com/google/android/gms/dynamite/DynamiteModule
      // 055: monitorexit
      // 056: aload 5
      // 058: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 05b: ifeq 173
      // 05e: aload 0
      // 05f: aload 1
      // 060: iload 2
      // 061: invokestatic com/google/android/gms/dynamite/DynamiteModule.c (Landroid/content/Context;Ljava/lang/String;Z)I
      // 064: istore 3
      // 065: iload 3
      // 066: ireturn
      // 067: aload 7
      // 069: invokestatic com/google/android/gms/dynamite/DynamiteModule.a (Ljava/lang/ClassLoader;)V
      // 06c: getstatic java/lang/Boolean.TRUE Ljava/lang/Boolean;
      // 06f: astore 5
      // 071: goto 04b
      // 074: ldc "com.google.android.gms"
      // 076: aload 0
      // 077: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 07a: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 07d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 080: ifeq 094
      // 083: aload 5
      // 085: aconst_null
      // 086: invokestatic java/lang/ClassLoader.getSystemClassLoader ()Ljava/lang/ClassLoader;
      // 089: invokevirtual java/lang/reflect/Field.set (Ljava/lang/Object;Ljava/lang/Object;)V
      // 08c: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 08f: astore 5
      // 091: goto 04b
      // 094: aload 0
      // 095: aload 1
      // 096: iload 2
      // 097: invokestatic com/google/android/gms/dynamite/DynamiteModule.c (Landroid/content/Context;Ljava/lang/String;Z)I
      // 09a: istore 3
      // 09b: getstatic com/google/android/gms/dynamite/DynamiteModule.i Ljava/lang/String;
      // 09e: ifnull 0ae
      // 0a1: getstatic com/google/android/gms/dynamite/DynamiteModule.i Ljava/lang/String;
      // 0a4: invokevirtual java/lang/String.isEmpty ()Z
      // 0a7: istore 4
      // 0a9: iload 4
      // 0ab: ifeq 0bd
      // 0ae: aload 6
      // 0b0: monitorexit
      // 0b1: ldc com/google/android/gms/dynamite/DynamiteModule
      // 0b3: monitorexit
      // 0b4: goto 065
      // 0b7: astore 0
      // 0b8: ldc com/google/android/gms/dynamite/DynamiteModule
      // 0ba: monitorexit
      // 0bb: aload 0
      // 0bc: athrow
      // 0bd: new com/google/android/gms/dynamite/zzh
      // 0c0: astore 7
      // 0c2: aload 7
      // 0c4: getstatic com/google/android/gms/dynamite/DynamiteModule.i Ljava/lang/String;
      // 0c7: invokestatic java/lang/ClassLoader.getSystemClassLoader ()Ljava/lang/ClassLoader;
      // 0ca: invokespecial com/google/android/gms/dynamite/zzh.<init> (Ljava/lang/String;Ljava/lang/ClassLoader;)V
      // 0cd: aload 7
      // 0cf: invokestatic com/google/android/gms/dynamite/DynamiteModule.a (Ljava/lang/ClassLoader;)V
      // 0d2: aload 5
      // 0d4: aconst_null
      // 0d5: aload 7
      // 0d7: invokevirtual java/lang/reflect/Field.set (Ljava/lang/Object;Ljava/lang/Object;)V
      // 0da: getstatic java/lang/Boolean.TRUE Ljava/lang/Boolean;
      // 0dd: putstatic com/google/android/gms/dynamite/DynamiteModule.f Ljava/lang/Boolean;
      // 0e0: aload 6
      // 0e2: monitorexit
      // 0e3: ldc com/google/android/gms/dynamite/DynamiteModule
      // 0e5: monitorexit
      // 0e6: goto 065
      // 0e9: astore 7
      // 0eb: aload 5
      // 0ed: aconst_null
      // 0ee: invokestatic java/lang/ClassLoader.getSystemClassLoader ()Ljava/lang/ClassLoader;
      // 0f1: invokevirtual java/lang/reflect/Field.set (Ljava/lang/Object;Ljava/lang/Object;)V
      // 0f4: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 0f7: astore 5
      // 0f9: goto 04b
      // 0fc: astore 5
      // 0fe: aload 6
      // 100: monitorexit
      // 101: aload 5
      // 103: athrow
      // 104: astore 5
      // 106: aload 5
      // 108: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 10b: astore 6
      // 10d: aload 6
      // 10f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 112: invokevirtual java/lang/String.length ()I
      // 115: istore 3
      // 116: new java/lang/StringBuilder
      // 119: astore 5
      // 11b: aload 5
      // 11d: iload 3
      // 11e: bipush 30
      // 120: iadd
      // 121: invokespecial java/lang/StringBuilder.<init> (I)V
      // 124: ldc "DynamiteModule"
      // 126: aload 5
      // 128: ldc "Failed to load module via V2: "
      // 12a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12d: aload 6
      // 12f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 132: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 135: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 138: pop
      // 139: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 13c: astore 5
      // 13e: goto 04e
      // 141: astore 0
      // 142: aload 0
      // 143: invokevirtual com/google/android/gms/dynamite/DynamiteModule$zzc.getMessage ()Ljava/lang/String;
      // 146: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 149: astore 0
      // 14a: aload 0
      // 14b: invokevirtual java/lang/String.length ()I
      // 14e: ifeq 165
      // 151: ldc_w "Failed to retrieve remote module version: "
      // 154: aload 0
      // 155: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 158: astore 0
      // 159: ldc "DynamiteModule"
      // 15b: aload 0
      // 15c: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 15f: pop
      // 160: bipush 0
      // 161: istore 3
      // 162: goto 065
      // 165: new java/lang/String
      // 168: dup
      // 169: ldc_w "Failed to retrieve remote module version: "
      // 16c: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 16f: astore 0
      // 170: goto 159
      // 173: aload 0
      // 174: aload 1
      // 175: iload 2
      // 176: invokestatic com/google/android/gms/dynamite/DynamiteModule.b (Landroid/content/Context;Ljava/lang/String;Z)I
      // 179: istore 3
      // 17a: goto 065
      // 17d: astore 5
      // 17f: goto 06c
      // 182: astore 5
      // 184: goto 106
      // 187: astore 5
      // 189: goto 106
      // try (2 -> 4): 84 null
      // try (8 -> 21): 121 java/lang/ClassNotFoundException
      // try (8 -> 21): 183 java/lang/IllegalAccessException
      // try (8 -> 21): 181 java/lang/NoSuchFieldException
      // try (8 -> 21): 84 null
      // try (21 -> 26): 116 null
      // try (28 -> 33): 116 null
      // try (33 -> 35): 116 null
      // try (35 -> 37): 84 null
      // try (37 -> 39): 84 null
      // try (42 -> 47): 148 com/google/android/gms/dynamite/DynamiteModule$zzc
      // try (49 -> 51): 179 com/google/android/gms/dynamite/DynamiteModule$zzc
      // try (49 -> 51): 116 null
      // try (51 -> 53): 116 null
      // try (54 -> 66): 116 null
      // try (67 -> 77): 108 com/google/android/gms/dynamite/DynamiteModule$zzc
      // try (67 -> 77): 116 null
      // try (79 -> 81): 116 null
      // try (81 -> 83): 84 null
      // try (85 -> 87): 84 null
      // try (89 -> 103): 108 com/google/android/gms/dynamite/DynamiteModule$zzc
      // try (89 -> 103): 116 null
      // try (103 -> 105): 116 null
      // try (105 -> 107): 84 null
      // try (109 -> 115): 116 null
      // try (117 -> 119): 116 null
      // try (119 -> 121): 121 java/lang/ClassNotFoundException
      // try (119 -> 121): 183 java/lang/IllegalAccessException
      // try (119 -> 121): 181 java/lang/NoSuchFieldException
      // try (119 -> 121): 84 null
      // try (122 -> 147): 84 null
   }

   private static Context a(Context var0, String var1, int var2, Cursor var3, zzm var4) {
      try {
         var0 = com.google.android.gms.dynamic.zzn.a(var4.a(com.google.android.gms.dynamic.zzn.a(var0), var1, var2, com.google.android.gms.dynamic.zzn.a(var3)));
      } catch (Exception var5) {
         String var6 = String.valueOf(var5.toString());
         String var7;
         if (var6.length() != 0) {
            var7 = "Failed to load DynamiteLoader: ".concat(var6);
         } else {
            var7 = new String("Failed to load DynamiteLoader: ");
         }

         Log.e("DynamiteModule", var7);
         var0 = null;
      }

      return var0;
   }

   public static DynamiteModule a(Context param0, DynamiteModule.zzd param1, String param2) throws DynamiteModule.zzc {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 003: invokevirtual java/lang/ThreadLocal.get ()Ljava/lang/Object;
      // 006: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
      // 009: astore 8
      // 00b: new com/google/android/gms/dynamite/DynamiteModule$zza
      // 00e: dup
      // 00f: aconst_null
      // 010: invokespecial com/google/android/gms/dynamite/DynamiteModule$zza.<init> (Lcom/google/android/gms/dynamite/zza;)V
      // 013: astore 9
      // 015: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 018: aload 9
      // 01a: invokevirtual java/lang/ThreadLocal.set (Ljava/lang/Object;)V
      // 01d: aload 1
      // 01e: aload 0
      // 01f: aload 2
      // 020: getstatic com/google/android/gms/dynamite/DynamiteModule.k Lcom/google/android/gms/dynamite/zzi;
      // 023: invokeinterface com/google/android/gms/dynamite/DynamiteModule$zzd.a (Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/dynamite/zzi;)Lcom/google/android/gms/dynamite/zzj; 4
      // 028: astore 10
      // 02a: aload 10
      // 02c: getfield com/google/android/gms/dynamite/zzj.a I
      // 02f: istore 5
      // 031: aload 10
      // 033: getfield com/google/android/gms/dynamite/zzj.b I
      // 036: istore 4
      // 038: aload 2
      // 039: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 03c: invokevirtual java/lang/String.length ()I
      // 03f: istore 3
      // 040: aload 2
      // 041: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 044: invokevirtual java/lang/String.length ()I
      // 047: istore 6
      // 049: new java/lang/StringBuilder
      // 04c: astore 7
      // 04e: aload 7
      // 050: iload 3
      // 051: bipush 68
      // 053: iadd
      // 054: iload 6
      // 056: iadd
      // 057: invokespecial java/lang/StringBuilder.<init> (I)V
      // 05a: ldc "DynamiteModule"
      // 05c: aload 7
      // 05e: ldc_w "Considering local module "
      // 061: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 064: aload 2
      // 065: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 068: ldc_w ":"
      // 06b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06e: iload 5
      // 070: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 073: ldc_w " and remote module "
      // 076: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 079: aload 2
      // 07a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07d: ldc_w ":"
      // 080: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 083: iload 4
      // 085: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 088: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08b: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 08e: pop
      // 08f: aload 10
      // 091: getfield com/google/android/gms/dynamite/zzj.c I
      // 094: ifeq 0b9
      // 097: aload 10
      // 099: getfield com/google/android/gms/dynamite/zzj.c I
      // 09c: bipush -1
      // 09d: if_icmpne 0a8
      // 0a0: aload 10
      // 0a2: getfield com/google/android/gms/dynamite/zzj.a I
      // 0a5: ifeq 0b9
      // 0a8: aload 10
      // 0aa: getfield com/google/android/gms/dynamite/zzj.c I
      // 0ad: bipush 1
      // 0ae: if_icmpne 116
      // 0b1: aload 10
      // 0b3: getfield com/google/android/gms/dynamite/zzj.b I
      // 0b6: ifne 116
      // 0b9: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 0bc: astore 0
      // 0bd: aload 10
      // 0bf: getfield com/google/android/gms/dynamite/zzj.a I
      // 0c2: istore 3
      // 0c3: aload 10
      // 0c5: getfield com/google/android/gms/dynamite/zzj.b I
      // 0c8: istore 4
      // 0ca: new java/lang/StringBuilder
      // 0cd: astore 1
      // 0ce: aload 1
      // 0cf: bipush 91
      // 0d1: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0d4: aload 0
      // 0d5: aload 1
      // 0d6: ldc_w "No acceptable module found. Local version is "
      // 0d9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0dc: iload 3
      // 0dd: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0e0: ldc_w " and remote version is "
      // 0e3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e6: iload 4
      // 0e8: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0eb: ldc "."
      // 0ed: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0f3: aconst_null
      // 0f4: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 0f7: aload 0
      // 0f8: athrow
      // 0f9: astore 0
      // 0fa: aload 9
      // 0fc: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 0ff: ifnull 10c
      // 102: aload 9
      // 104: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 107: invokeinterface android/database/Cursor.close ()V 1
      // 10c: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 10f: aload 8
      // 111: invokevirtual java/lang/ThreadLocal.set (Ljava/lang/Object;)V
      // 114: aload 0
      // 115: athrow
      // 116: aload 10
      // 118: getfield com/google/android/gms/dynamite/zzj.c I
      // 11b: bipush -1
      // 11c: if_icmpne 141
      // 11f: aload 0
      // 120: aload 2
      // 121: invokestatic com/google/android/gms/dynamite/DynamiteModule.b (Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
      // 124: astore 0
      // 125: aload 9
      // 127: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 12a: ifnull 137
      // 12d: aload 9
      // 12f: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 132: invokeinterface android/database/Cursor.close ()V 1
      // 137: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 13a: aload 8
      // 13c: invokevirtual java/lang/ThreadLocal.set (Ljava/lang/Object;)V
      // 13f: aload 0
      // 140: areturn
      // 141: aload 10
      // 143: getfield com/google/android/gms/dynamite/zzj.c I
      // 146: istore 3
      // 147: iload 3
      // 148: bipush 1
      // 149: if_icmpne 209
      // 14c: aload 0
      // 14d: aload 2
      // 14e: aload 10
      // 150: getfield com/google/android/gms/dynamite/zzj.b I
      // 153: invokestatic com/google/android/gms/dynamite/DynamiteModule.a (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
      // 156: astore 7
      // 158: aload 9
      // 15a: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 15d: ifnull 16a
      // 160: aload 9
      // 162: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 165: invokeinterface android/database/Cursor.close ()V 1
      // 16a: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 16d: aload 8
      // 16f: invokevirtual java/lang/ThreadLocal.set (Ljava/lang/Object;)V
      // 172: aload 7
      // 174: astore 0
      // 175: goto 13f
      // 178: astore 11
      // 17a: aload 11
      // 17c: invokevirtual com/google/android/gms/dynamite/DynamiteModule$zzc.getMessage ()Ljava/lang/String;
      // 17f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 182: astore 7
      // 184: aload 7
      // 186: invokevirtual java/lang/String.length ()I
      // 189: ifeq 1ea
      // 18c: ldc_w "Failed to load remote module: "
      // 18f: aload 7
      // 191: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 194: astore 7
      // 196: ldc "DynamiteModule"
      // 198: aload 7
      // 19a: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 19d: pop
      // 19e: aload 10
      // 1a0: getfield com/google/android/gms/dynamite/zzj.a I
      // 1a3: ifeq 1f9
      // 1a6: new com/google/android/gms/dynamite/DynamiteModule$zzb
      // 1a9: astore 7
      // 1ab: aload 7
      // 1ad: aload 10
      // 1af: getfield com/google/android/gms/dynamite/zzj.a I
      // 1b2: bipush 0
      // 1b3: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzb.<init> (II)V
      // 1b6: aload 1
      // 1b7: aload 0
      // 1b8: aload 2
      // 1b9: aload 7
      // 1bb: invokeinterface com/google/android/gms/dynamite/DynamiteModule$zzd.a (Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/dynamite/zzi;)Lcom/google/android/gms/dynamite/zzj; 4
      // 1c0: getfield com/google/android/gms/dynamite/zzj.c I
      // 1c3: bipush -1
      // 1c4: if_icmpne 1f9
      // 1c7: aload 0
      // 1c8: aload 2
      // 1c9: invokestatic com/google/android/gms/dynamite/DynamiteModule.b (Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
      // 1cc: astore 0
      // 1cd: aload 9
      // 1cf: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 1d2: ifnull 1df
      // 1d5: aload 9
      // 1d7: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 1da: invokeinterface android/database/Cursor.close ()V 1
      // 1df: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 1e2: aload 8
      // 1e4: invokevirtual java/lang/ThreadLocal.set (Ljava/lang/Object;)V
      // 1e7: goto 13f
      // 1ea: new java/lang/String
      // 1ed: dup
      // 1ee: ldc_w "Failed to load remote module: "
      // 1f1: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 1f4: astore 7
      // 1f6: goto 196
      // 1f9: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 1fc: astore 0
      // 1fd: aload 0
      // 1fe: ldc_w "Remote load failed. No local fallback found."
      // 201: aload 11
      // 203: aconst_null
      // 204: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
      // 207: aload 0
      // 208: athrow
      // 209: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 20c: astore 0
      // 20d: aload 10
      // 20f: getfield com/google/android/gms/dynamite/zzj.c I
      // 212: istore 3
      // 213: new java/lang/StringBuilder
      // 216: astore 1
      // 217: aload 1
      // 218: bipush 47
      // 21a: invokespecial java/lang/StringBuilder.<init> (I)V
      // 21d: aload 0
      // 21e: aload 1
      // 21f: ldc_w "VersionPolicy returned invalid code:"
      // 222: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 225: iload 3
      // 226: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 229: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 22c: aconst_null
      // 22d: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 230: aload 0
      // 231: athrow
      // try (12 -> 72): 109 null
      // try (72 -> 79): 109 null
      // try (79 -> 109): 109 null
      // try (121 -> 129): 109 null
      // try (140 -> 143): 109 null
      // try (146 -> 152): 164 com/google/android/gms/dynamite/DynamiteModule$zzc
      // try (146 -> 152): 109 null
      // try (165 -> 176): 109 null
      // try (176 -> 202): 109 null
      // try (212 -> 217): 109 null
      // try (218 -> 227): 109 null
      // try (227 -> 248): 109 null
   }

   private static DynamiteModule a(Context param0, String param1, int param2) throws DynamiteModule.zzc {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/google/android/gms/dynamite/DynamiteModule
      // 02: monitorenter
      // 03: getstatic com/google/android/gms/dynamite/DynamiteModule.f Ljava/lang/Boolean;
      // 06: astore 3
      // 07: ldc com/google/android/gms/dynamite/DynamiteModule
      // 09: monitorexit
      // 0a: aload 3
      // 0b: ifnonnull 20
      // 0e: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 11: dup
      // 12: ldc_w "Failed to determine which loading route to use."
      // 15: aconst_null
      // 16: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 19: athrow
      // 1a: astore 0
      // 1b: ldc com/google/android/gms/dynamite/DynamiteModule
      // 1d: monitorexit
      // 1e: aload 0
      // 1f: athrow
      // 20: aload 3
      // 21: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 24: ifeq 30
      // 27: aload 0
      // 28: aload 1
      // 29: iload 2
      // 2a: invokestatic com/google/android/gms/dynamite/DynamiteModule.c (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
      // 2d: astore 0
      // 2e: aload 0
      // 2f: areturn
      // 30: aload 0
      // 31: aload 1
      // 32: iload 2
      // 33: invokestatic com/google/android/gms/dynamite/DynamiteModule.b (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
      // 36: astore 0
      // 37: goto 2e
      // try (2 -> 6): 14 null
      // try (15 -> 17): 14 null
   }

   private static zzk a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/google/android/gms/dynamite/DynamiteModule
      // 02: monitorenter
      // 03: getstatic com/google/android/gms/dynamite/DynamiteModule.g Lcom/google/android/gms/dynamite/zzk;
      // 06: ifnull 12
      // 09: getstatic com/google/android/gms/dynamite/DynamiteModule.g Lcom/google/android/gms/dynamite/zzk;
      // 0c: astore 0
      // 0d: ldc com/google/android/gms/dynamite/DynamiteModule
      // 0f: monitorexit
      // 10: aload 0
      // 11: areturn
      // 12: invokestatic com/google/android/gms/common/zzf.b ()Lcom/google/android/gms/common/zzf;
      // 15: aload 0
      // 16: invokevirtual com/google/android/gms/common/zzf.a (Landroid/content/Context;)I
      // 19: ifeq 24
      // 1c: ldc com/google/android/gms/dynamite/DynamiteModule
      // 1e: monitorexit
      // 1f: aconst_null
      // 20: astore 0
      // 21: goto 10
      // 24: aload 0
      // 25: ldc "com.google.android.gms"
      // 27: bipush 3
      // 28: invokevirtual android/content/Context.createPackageContext (Ljava/lang/String;I)Landroid/content/Context;
      // 2b: invokevirtual android/content/Context.getClassLoader ()Ljava/lang/ClassLoader;
      // 2e: ldc_w "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
      // 31: invokevirtual java/lang/ClassLoader.loadClass (Ljava/lang/String;)Ljava/lang/Class;
      // 34: invokevirtual java/lang/Class.newInstance ()Ljava/lang/Object;
      // 37: checkcast android/os/IBinder
      // 3a: astore 0
      // 3b: aload 0
      // 3c: ifnonnull 55
      // 3f: aconst_null
      // 40: astore 0
      // 41: aload 0
      // 42: ifnull 99
      // 45: aload 0
      // 46: putstatic com/google/android/gms/dynamite/DynamiteModule.g Lcom/google/android/gms/dynamite/zzk;
      // 49: ldc com/google/android/gms/dynamite/DynamiteModule
      // 4b: monitorexit
      // 4c: goto 10
      // 4f: astore 0
      // 50: ldc com/google/android/gms/dynamite/DynamiteModule
      // 52: monitorexit
      // 53: aload 0
      // 54: athrow
      // 55: aload 0
      // 56: ldc_w "com.google.android.gms.dynamite.IDynamiteLoader"
      // 59: invokeinterface android/os/IBinder.queryLocalInterface (Ljava/lang/String;)Landroid/os/IInterface; 2
      // 5e: astore 1
      // 5f: aload 1
      // 60: instanceof com/google/android/gms/dynamite/zzk
      // 63: ifeq 6e
      // 66: aload 1
      // 67: checkcast com/google/android/gms/dynamite/zzk
      // 6a: astore 0
      // 6b: goto 41
      // 6e: new com/google/android/gms/dynamite/zzl
      // 71: dup
      // 72: aload 0
      // 73: invokespecial com/google/android/gms/dynamite/zzl.<init> (Landroid/os/IBinder;)V
      // 76: astore 0
      // 77: goto 41
      // 7a: astore 0
      // 7b: aload 0
      // 7c: invokevirtual java/lang/Exception.getMessage ()Ljava/lang/String;
      // 7f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 82: astore 0
      // 83: aload 0
      // 84: invokevirtual java/lang/String.length ()I
      // 87: ifeq a1
      // 8a: ldc_w "Failed to load IDynamiteLoader from GmsCore: "
      // 8d: aload 0
      // 8e: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 91: astore 0
      // 92: ldc "DynamiteModule"
      // 94: aload 0
      // 95: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 98: pop
      // 99: ldc com/google/android/gms/dynamite/DynamiteModule
      // 9b: monitorexit
      // 9c: aconst_null
      // 9d: astore 0
      // 9e: goto 10
      // a1: new java/lang/String
      // a4: dup
      // a5: ldc_w "Failed to load IDynamiteLoader from GmsCore: "
      // a8: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // ab: astore 0
      // ac: goto 92
      // try (2 -> 8): 40 null
      // try (10 -> 16): 40 null
      // try (19 -> 29): 62 java/lang/Exception
      // try (19 -> 29): 40 null
      // try (35 -> 37): 62 java/lang/Exception
      // try (35 -> 37): 40 null
      // try (37 -> 39): 40 null
      // try (41 -> 43): 40 null
      // try (45 -> 55): 62 java/lang/Exception
      // try (45 -> 55): 40 null
      // try (56 -> 61): 62 java/lang/Exception
      // try (56 -> 61): 40 null
      // try (63 -> 74): 40 null
      // try (74 -> 78): 40 null
      // try (78 -> 80): 40 null
      // try (83 -> 88): 40 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void a(ClassLoader var0) throws DynamiteModule.zzc {
      try {
         var23 = (IBinder)var0.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor().newInstance();
      } catch (ClassNotFoundException var17) {
         throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var17, null);
      } catch (IllegalAccessException var18) {
         throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var18, null);
      } catch (InstantiationException var19) {
         throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var19, null);
      } catch (InvocationTargetException var20) {
         throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var20, null);
      } catch (NoSuchMethodException var21) {
         throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var21, null);
      }

      zzm var24;
      if (var23 == null) {
         var24 = null;
      } else {
         label75: {
            try {
               IInterface var1 = var23.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
               if (var1 instanceof zzm) {
                  var24 = (zzm)var1;
                  break label75;
               }
            } catch (ClassNotFoundException var12) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var12, null);
            } catch (IllegalAccessException var13) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var13, null);
            } catch (InstantiationException var14) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var14, null);
            } catch (InvocationTargetException var15) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var15, null);
            } catch (NoSuchMethodException var16) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var16, null);
            }

            try {
               var24 = new zzn(var23);
            } catch (ClassNotFoundException var7) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var7, null);
            } catch (IllegalAccessException var8) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var8, null);
            } catch (InstantiationException var9) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var9, null);
            } catch (InvocationTargetException var10) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var10, null);
            } catch (NoSuchMethodException var11) {
               throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var11, null);
            }
         }
      }

      try {
         h = var24;
         return;
      } catch (ClassNotFoundException var2) {
         var22 = var2;
      } catch (IllegalAccessException var3) {
         var22 = var3;
      } catch (InstantiationException var4) {
         var22 = var4;
      } catch (InvocationTargetException var5) {
         var22 = var5;
      } catch (NoSuchMethodException var6) {
         var22 = var6;
      }

      throw new DynamiteModule.zzc("Failed to instantiate dynamite loader", var22, null);
   }

   private static int b(Context var0, String var1, boolean var2) {
      zzk var4 = a(var0);
      int var3;
      if (var4 == null) {
         var3 = 0;
      } else {
         try {
            var3 = var4.a(com.google.android.gms.dynamic.zzn.a(var0), var1, var2);
         } catch (RemoteException var5) {
            String var6 = String.valueOf(var5.getMessage());
            String var7;
            if (var6.length() != 0) {
               var7 = "Failed to retrieve remote module version: ".concat(var6);
            } else {
               var7 = new String("Failed to retrieve remote module version: ");
            }

            Log.w("DynamiteModule", var7);
            var3 = 0;
         }
      }

      return var3;
   }

   private static DynamiteModule b(Context var0, String var1) {
      var1 = String.valueOf(var1);
      if (var1.length() != 0) {
         var1 = "Selected local version of ".concat(var1);
      } else {
         var1 = new String("Selected local version of ");
      }

      Log.i("DynamiteModule", var1);
      return new DynamiteModule(var0.getApplicationContext());
   }

   private static DynamiteModule b(Context var0, String var1, int var2) throws DynamiteModule.zzc {
      Log.i(
         "DynamiteModule",
         new StringBuilder(String.valueOf(var1).length() + 51)
            .append("Selected remote version of ")
            .append(var1)
            .append(", version >= ")
            .append(var2)
            .toString()
      );
      zzk var3 = a(var0);
      if (var3 == null) {
         throw new DynamiteModule.zzc("Failed to create IDynamiteLoader.", null);
      }

      try {
         var5 = var3.a(com.google.android.gms.dynamic.zzn.a(var0), var1, var2);
      } catch (RemoteException var4) {
         throw new DynamiteModule.zzc("Failed to load remote module.", var4, null);
      }

      if (com.google.android.gms.dynamic.zzn.a(var5) == null) {
         throw new DynamiteModule.zzc("Failed to load remote module.", null);
      } else {
         return new DynamiteModule(com.google.android.gms.dynamic.zzn.a(var5));
      }
   }

   private static int c(Context param0, String param1, boolean param2) throws DynamiteModule.zzc {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 004: astore 6
      // 006: iload 2
      // 007: ifeq 0b2
      // 00a: ldc_w "api_force_staging"
      // 00d: astore 0
      // 00e: ldc_w "content://com.google.android.gms.chimera/"
      // 011: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 014: invokevirtual java/lang/String.length ()I
      // 017: istore 4
      // 019: aload 0
      // 01a: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 01d: invokevirtual java/lang/String.length ()I
      // 020: istore 3
      // 021: aload 1
      // 022: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 025: invokevirtual java/lang/String.length ()I
      // 028: istore 5
      // 02a: new java/lang/StringBuilder
      // 02d: astore 7
      // 02f: aload 7
      // 031: iload 4
      // 033: bipush 1
      // 034: iadd
      // 035: iload 3
      // 036: iadd
      // 037: iload 5
      // 039: iadd
      // 03a: invokespecial java/lang/StringBuilder.<init> (I)V
      // 03d: aload 6
      // 03f: aload 7
      // 041: ldc_w "content://com.google.android.gms.chimera/"
      // 044: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 047: aload 0
      // 048: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04b: ldc_w "/"
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 051: aload 1
      // 052: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 055: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 058: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 05b: aconst_null
      // 05c: aconst_null
      // 05d: aconst_null
      // 05e: aconst_null
      // 05f: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 062: astore 0
      // 063: aload 0
      // 064: ifnull 072
      // 067: aload 0
      // 068: astore 1
      // 069: aload 0
      // 06a: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 06f: ifne 0b9
      // 072: aload 0
      // 073: astore 1
      // 074: ldc "DynamiteModule"
      // 076: ldc_w "Failed to retrieve remote module version."
      // 079: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 07c: pop
      // 07d: aload 0
      // 07e: astore 1
      // 07f: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 082: astore 6
      // 084: aload 0
      // 085: astore 1
      // 086: aload 6
      // 088: ldc_w "Failed to connect to dynamite module ContentResolver."
      // 08b: aconst_null
      // 08c: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 08f: aload 0
      // 090: astore 1
      // 091: aload 6
      // 093: athrow
      // 094: astore 6
      // 096: aload 0
      // 097: astore 1
      // 098: aload 6
      // 09a: instanceof com/google/android/gms/dynamite/DynamiteModule$zzc
      // 09d: ifeq 121
      // 0a0: aload 0
      // 0a1: astore 1
      // 0a2: aload 6
      // 0a4: athrow
      // 0a5: astore 0
      // 0a6: aload 1
      // 0a7: ifnull 0b0
      // 0aa: aload 1
      // 0ab: invokeinterface android/database/Cursor.close ()V 1
      // 0b0: aload 0
      // 0b1: athrow
      // 0b2: ldc_w "api"
      // 0b5: astore 0
      // 0b6: goto 00e
      // 0b9: aload 0
      // 0ba: astore 1
      // 0bb: aload 0
      // 0bc: bipush 0
      // 0bd: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0c2: istore 3
      // 0c3: aload 0
      // 0c4: astore 6
      // 0c6: iload 3
      // 0c7: ifle 109
      // 0ca: aload 0
      // 0cb: astore 1
      // 0cc: ldc com/google/android/gms/dynamite/DynamiteModule
      // 0ce: monitorenter
      // 0cf: aload 0
      // 0d0: bipush 2
      // 0d1: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0d6: putstatic com/google/android/gms/dynamite/DynamiteModule.i Ljava/lang/String;
      // 0d9: ldc com/google/android/gms/dynamite/DynamiteModule
      // 0db: monitorexit
      // 0dc: aload 0
      // 0dd: astore 1
      // 0de: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 0e1: invokevirtual java/lang/ThreadLocal.get ()Ljava/lang/Object;
      // 0e4: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
      // 0e7: astore 7
      // 0e9: aload 0
      // 0ea: astore 6
      // 0ec: aload 7
      // 0ee: ifnull 109
      // 0f1: aload 0
      // 0f2: astore 1
      // 0f3: aload 0
      // 0f4: astore 6
      // 0f6: aload 7
      // 0f8: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 0fb: ifnonnull 109
      // 0fe: aload 0
      // 0ff: astore 1
      // 100: aload 7
      // 102: aload 0
      // 103: putfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 106: aconst_null
      // 107: astore 6
      // 109: aload 6
      // 10b: ifnull 115
      // 10e: aload 6
      // 110: invokeinterface android/database/Cursor.close ()V 1
      // 115: iload 3
      // 116: ireturn
      // 117: astore 6
      // 119: ldc com/google/android/gms/dynamite/DynamiteModule
      // 11b: monitorexit
      // 11c: aload 0
      // 11d: astore 1
      // 11e: aload 6
      // 120: athrow
      // 121: aload 0
      // 122: astore 1
      // 123: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 126: astore 7
      // 128: aload 0
      // 129: astore 1
      // 12a: aload 7
      // 12c: ldc_w "V2 version check failed"
      // 12f: aload 6
      // 131: aconst_null
      // 132: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
      // 135: aload 0
      // 136: astore 1
      // 137: aload 7
      // 139: athrow
      // 13a: astore 0
      // 13b: aconst_null
      // 13c: astore 1
      // 13d: goto 0a6
      // 140: astore 6
      // 142: aconst_null
      // 143: astore 0
      // 144: goto 096
      // try (0 -> 3): 171 java/lang/Exception
      // try (0 -> 3): 167 null
      // try (7 -> 48): 171 java/lang/Exception
      // try (7 -> 48): 167 null
      // try (52 -> 55): 75 java/lang/Exception
      // try (52 -> 55): 85 null
      // try (57 -> 61): 75 java/lang/Exception
      // try (57 -> 61): 85 null
      // try (63 -> 65): 75 java/lang/Exception
      // try (63 -> 65): 85 null
      // try (67 -> 71): 75 java/lang/Exception
      // try (67 -> 71): 85 null
      // try (73 -> 75): 75 java/lang/Exception
      // try (73 -> 75): 85 null
      // try (78 -> 81): 85 null
      // try (83 -> 85): 85 null
      // try (97 -> 101): 75 java/lang/Exception
      // try (97 -> 101): 85 null
      // try (107 -> 109): 75 java/lang/Exception
      // try (107 -> 109): 85 null
      // try (109 -> 115): 145 null
      // try (117 -> 121): 75 java/lang/Exception
      // try (117 -> 121): 85 null
      // try (129 -> 132): 75 java/lang/Exception
      // try (129 -> 132): 85 null
      // try (134 -> 137): 75 java/lang/Exception
      // try (134 -> 137): 85 null
      // try (146 -> 148): 145 null
      // try (150 -> 152): 75 java/lang/Exception
      // try (150 -> 152): 85 null
      // try (154 -> 156): 85 null
      // try (158 -> 163): 85 null
      // try (165 -> 167): 85 null
   }

   private static DynamiteModule c(Context param0, String param1, int param2) throws DynamiteModule.zzc {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc "DynamiteModule"
      // 02: new java/lang/StringBuilder
      // 05: dup
      // 06: aload 1
      // 07: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0a: invokevirtual java/lang/String.length ()I
      // 0d: bipush 51
      // 0f: iadd
      // 10: invokespecial java/lang/StringBuilder.<init> (I)V
      // 13: ldc_w "Selected remote version of "
      // 16: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 19: aload 1
      // 1a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1d: ldc_w ", version >= "
      // 20: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 23: iload 2
      // 24: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 27: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2a: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 2d: pop
      // 2e: ldc com/google/android/gms/dynamite/DynamiteModule
      // 30: monitorenter
      // 31: getstatic com/google/android/gms/dynamite/DynamiteModule.h Lcom/google/android/gms/dynamite/zzm;
      // 34: astore 3
      // 35: ldc com/google/android/gms/dynamite/DynamiteModule
      // 37: monitorexit
      // 38: aload 3
      // 39: ifnonnull 4e
      // 3c: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 3f: dup
      // 40: ldc_w "DynamiteLoaderV2 was not cached."
      // 43: aconst_null
      // 44: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 47: athrow
      // 48: astore 0
      // 49: ldc com/google/android/gms/dynamite/DynamiteModule
      // 4b: monitorexit
      // 4c: aload 0
      // 4d: athrow
      // 4e: getstatic com/google/android/gms/dynamite/DynamiteModule.j Ljava/lang/ThreadLocal;
      // 51: invokevirtual java/lang/ThreadLocal.get ()Ljava/lang/Object;
      // 54: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
      // 57: astore 4
      // 59: aload 4
      // 5b: ifnull 66
      // 5e: aload 4
      // 60: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 63: ifnonnull 72
      // 66: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 69: dup
      // 6a: ldc_w "No result cursor"
      // 6d: aconst_null
      // 6e: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 71: athrow
      // 72: aload 0
      // 73: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 76: aload 1
      // 77: iload 2
      // 78: aload 4
      // 7a: getfield com/google/android/gms/dynamite/DynamiteModule$zza.a Landroid/database/Cursor;
      // 7d: aload 3
      // 7e: invokestatic com/google/android/gms/dynamite/DynamiteModule.a (Landroid/content/Context;Ljava/lang/String;ILandroid/database/Cursor;Lcom/google/android/gms/dynamite/zzm;)Landroid/content/Context;
      // 81: astore 0
      // 82: aload 0
      // 83: ifnonnull 92
      // 86: new com/google/android/gms/dynamite/DynamiteModule$zzc
      // 89: dup
      // 8a: ldc_w "Failed to get module context"
      // 8d: aconst_null
      // 8e: invokespecial com/google/android/gms/dynamite/DynamiteModule$zzc.<init> (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
      // 91: athrow
      // 92: new com/google/android/gms/dynamite/DynamiteModule
      // 95: dup
      // 96: aload 0
      // 97: invokespecial com/google/android/gms/dynamite/DynamiteModule.<init> (Landroid/content/Context;)V
      // 9a: areturn
      // try (22 -> 26): 34 null
      // try (35 -> 37): 34 null
   }

   public final IBinder a(String var1) throws DynamiteModule.zzc {
      ReflectiveOperationException var2;
      try {
         return (IBinder)this.m.getClassLoader().loadClass(var1).newInstance();
      } catch (ClassNotFoundException var3) {
         var2 = var3;
      } catch (InstantiationException var4) {
         var2 = var4;
      } catch (IllegalAccessException var5) {
         var2 = var5;
      }

      var1 = String.valueOf(var1);
      if (var1.length() != 0) {
         var1 = "Failed to instantiate module class: ".concat(var1);
      } else {
         var1 = new String("Failed to instantiate module class: ");
      }

      throw new DynamiteModule.zzc(var1, var2, null);
   }

   @DynamiteApi
   public static class DynamiteLoaderClassLoader {
      public static ClassLoader sClassLoader;
   }

   static final class zza {
      public Cursor a;

      private zza() {
      }
   }

   static final class zzb implements zzi {
      private final int a;
      private final int b;

      public zzb(int var1, int var2) {
         this.a = var1;
         this.b = 0;
      }

      @Override
      public final int a(Context var1, String var2) {
         return this.a;
      }

      @Override
      public final int a(Context var1, String var2, boolean var3) {
         return 0;
      }
   }

   public static final class zzc extends Exception {
      private zzc(String var1) {
         super(var1);
      }

      private zzc(String var1, Throwable var2) {
         super(var1, var2);
      }
   }

   public interface zzd {
      zzj a(Context var1, String var2, zzi var3) throws DynamiteModule.zzc;
   }
}
