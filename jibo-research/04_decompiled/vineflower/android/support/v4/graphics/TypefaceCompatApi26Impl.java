package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.provider.FontsContractCompat;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
   private static final Class a;
   private static final Constructor b;
   private static final Method c;
   private static final Method d;
   private static final Method e;
   private static final Method f;
   private static final Method g;

   static {
      Method var4 = null;

      Method var1;
      Class var2;
      Constructor var3;
      Method var5;
      Method var6;
      Method var10;
      label18: {
         Method var7;
         label17: {
            try {
               var2 = Class.forName("android.graphics.FontFamily");
               var3 = var2.getConstructor();
               var5 = var2.getMethod(
                  "addFontFromAssetManager",
                  AssetManager.class,
                  String.class,
                  int.class,
                  boolean.class,
                  int.class,
                  int.class,
                  int.class,
                  FontVariationAxis[].class
               );
               var6 = var2.getMethod("addFontFromBuffer", ByteBuffer.class, int.class, FontVariationAxis[].class, int.class, int.class);
               var1 = var2.getMethod("freeze");
               var10 = var2.getMethod("abortCreation");
               var7 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(var2, 1).getClass(), int.class, int.class);
               var7.setAccessible(true);
               break label17;
            } catch (ClassNotFoundException var8) {
               var0 = var8;
            } catch (NoSuchMethodException var9) {
               var0 = var9;
            }

            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + var0.getClass().getName(), var0);
            var10 = null;
            var1 = null;
            var6 = null;
            var5 = null;
            var3 = null;
            var2 = null;
            break label18;
         }

         var4 = var6;
         var6 = var4;
         var4 = var10;
         var10 = var7;
      }

      b = var3;
      a = var2;
      c = var5;
      d = var6;
      e = var1;
      f = var4;
      g = var10;
   }

   private static Typeface a(Object var0) {
      try {
         Object var1 = Array.newInstance(a, 1);
         Array.set(var1, 0, var0);
         return (Typeface)g.invoke(null, var1, -1, -1);
      } catch (IllegalAccessException var2) {
         var0 = var2;
      } catch (InvocationTargetException var3) {
         var0 = var3;
      }

      throw new RuntimeException(var0);
   }

   private static boolean a() {
      if (c == null) {
         Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
      }

      boolean var0;
      if (c != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   private static boolean a(Context var0, Object var1, String var2, int var3, int var4, int var5) {
      try {
         return (Boolean)c.invoke(var1, var0.getAssets(), var2, 0, false, var3, var4, var5, null);
      } catch (IllegalAccessException var7) {
         var9 = var7;
      } catch (InvocationTargetException var8) {
         var9 = var8;
      }

      throw new RuntimeException(var9);
   }

   private static boolean a(Object var0, ByteBuffer var1, int var2, int var3, int var4) {
      try {
         return (Boolean)d.invoke(var0, var1, var2, null, var3, var4);
      } catch (IllegalAccessException var6) {
         var0 = var6;
      } catch (InvocationTargetException var7) {
         var0 = var7;
      }

      throw new RuntimeException(var0);
   }

   private static Object b() {
      ReflectiveOperationException var0;
      try {
         return b.newInstance();
      } catch (IllegalAccessException var1) {
         var0 = var1;
      } catch (InstantiationException var2) {
         var0 = var2;
      } catch (InvocationTargetException var3) {
         var0 = var3;
      }

      throw new RuntimeException(var0);
   }

   private static boolean b(Object var0) {
      try {
         return (Boolean)e.invoke(var0);
      } catch (IllegalAccessException var2) {
         var0 = var2;
      } catch (InvocationTargetException var3) {
         var0 = var3;
      }

      throw new RuntimeException(var0);
   }

   private static void c(Object var0) {
      try {
         f.invoke(var0);
         return;
      } catch (IllegalAccessException var1) {
         var0 = var1;
      } catch (InvocationTargetException var2) {
         var0 = var2;
      }

      throw new RuntimeException(var0);
   }

   @Override
   public Typeface a(Context var1, Resources var2, int var3, String var4, int var5) {
      Typeface var6;
      if (!a()) {
         var6 = super.a(var1, var2, var3, var4, var5);
      } else {
         Object var7 = b();
         if (!a(var1, var7, var4, 0, -1, -1)) {
            c(var7);
            var6 = null;
         } else if (!b(var7)) {
            var6 = null;
         } else {
            var6 = a(var7);
         }
      }

      return var6;
   }

   @Override
   public Typeface a(Context param1, CancellationSignal param2, FontsContractCompat.FontInfo[] param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 3
      // 001: arraylength
      // 002: bipush 1
      // 003: if_icmpge 00a
      // 006: aconst_null
      // 007: astore 1
      // 008: aload 1
      // 009: areturn
      // 00a: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.a ()Z
      // 00d: ifne 0c6
      // 010: aload 0
      // 011: aload 3
      // 012: iload 4
      // 014: invokevirtual android/support/v4/graphics/TypefaceCompatApi26Impl.a ([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
      // 017: astore 10
      // 019: aload 1
      // 01a: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 01d: astore 1
      // 01e: aload 1
      // 01f: aload 10
      // 021: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.a ()Landroid/net/Uri;
      // 024: ldc "r"
      // 026: aload 2
      // 027: invokevirtual android/content/ContentResolver.openFileDescriptor (Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
      // 02a: astore 3
      // 02b: aconst_null
      // 02c: astore 1
      // 02d: aload 3
      // 02e: ifnonnull 05e
      // 031: aconst_null
      // 032: astore 2
      // 033: aload 2
      // 034: astore 1
      // 035: aload 3
      // 036: ifnull 008
      // 039: bipush 0
      // 03a: ifeq 055
      // 03d: aload 3
      // 03e: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 041: aload 2
      // 042: astore 1
      // 043: goto 008
      // 046: astore 1
      // 047: new java/lang/NullPointerException
      // 04a: dup
      // 04b: invokespecial java/lang/NullPointerException.<init> ()V
      // 04e: athrow
      // 04f: astore 1
      // 050: aconst_null
      // 051: astore 1
      // 052: goto 008
      // 055: aload 3
      // 056: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 059: aload 2
      // 05a: astore 1
      // 05b: goto 008
      // 05e: new android/graphics/Typeface$Builder
      // 061: astore 2
      // 062: aload 2
      // 063: aload 3
      // 064: invokevirtual android/os/ParcelFileDescriptor.getFileDescriptor ()Ljava/io/FileDescriptor;
      // 067: invokespecial android/graphics/Typeface$Builder.<init> (Ljava/io/FileDescriptor;)V
      // 06a: aload 2
      // 06b: aload 10
      // 06d: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.c ()I
      // 070: invokevirtual android/graphics/Typeface$Builder.setWeight (I)Landroid/graphics/Typeface$Builder;
      // 073: aload 10
      // 075: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.d ()Z
      // 078: invokevirtual android/graphics/Typeface$Builder.setItalic (Z)Landroid/graphics/Typeface$Builder;
      // 07b: invokevirtual android/graphics/Typeface$Builder.build ()Landroid/graphics/Typeface;
      // 07e: astore 2
      // 07f: aload 2
      // 080: astore 1
      // 081: aload 3
      // 082: ifnull 008
      // 085: bipush 0
      // 086: ifeq 09b
      // 089: aload 3
      // 08a: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 08d: aload 2
      // 08e: astore 1
      // 08f: goto 008
      // 092: astore 1
      // 093: new java/lang/NullPointerException
      // 096: dup
      // 097: invokespecial java/lang/NullPointerException.<init> ()V
      // 09a: athrow
      // 09b: aload 3
      // 09c: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 09f: aload 2
      // 0a0: astore 1
      // 0a1: goto 008
      // 0a4: astore 1
      // 0a5: aload 1
      // 0a6: athrow
      // 0a7: astore 2
      // 0a8: aload 3
      // 0a9: ifnull 0b4
      // 0ac: aload 1
      // 0ad: ifnull 0bf
      // 0b0: aload 3
      // 0b1: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 0b4: aload 2
      // 0b5: athrow
      // 0b6: astore 3
      // 0b7: aload 1
      // 0b8: aload 3
      // 0b9: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 0bc: goto 0b4
      // 0bf: aload 3
      // 0c0: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 0c3: goto 0b4
      // 0c6: aload 1
      // 0c7: aload 3
      // 0c8: aload 2
      // 0c9: invokestatic android/support/v4/provider/FontsContractCompat.a (Landroid/content/Context;[Landroid/support/v4/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
      // 0cc: astore 11
      // 0ce: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.b ()Ljava/lang/Object;
      // 0d1: astore 1
      // 0d2: bipush 0
      // 0d3: istore 5
      // 0d5: aload 3
      // 0d6: arraylength
      // 0d7: istore 7
      // 0d9: bipush 0
      // 0da: istore 6
      // 0dc: iload 6
      // 0de: iload 7
      // 0e0: if_icmpge 13f
      // 0e3: aload 3
      // 0e4: iload 6
      // 0e6: aaload
      // 0e7: astore 10
      // 0e9: aload 11
      // 0eb: aload 10
      // 0ed: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.a ()Landroid/net/Uri;
      // 0f0: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0f5: checkcast java/nio/ByteBuffer
      // 0f8: astore 2
      // 0f9: aload 2
      // 0fa: ifnonnull 103
      // 0fd: iinc 6 1
      // 100: goto 0dc
      // 103: aload 10
      // 105: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.b ()I
      // 108: istore 8
      // 10a: aload 10
      // 10c: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.c ()I
      // 10f: istore 9
      // 111: aload 10
      // 113: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.d ()Z
      // 116: ifeq 133
      // 119: bipush 1
      // 11a: istore 5
      // 11c: aload 1
      // 11d: aload 2
      // 11e: iload 8
      // 120: iload 9
      // 122: iload 5
      // 124: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.a (Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
      // 127: ifne 139
      // 12a: aload 1
      // 12b: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.c (Ljava/lang/Object;)V
      // 12e: aconst_null
      // 12f: astore 1
      // 130: goto 008
      // 133: bipush 0
      // 134: istore 5
      // 136: goto 11c
      // 139: bipush 1
      // 13a: istore 5
      // 13c: goto 0fd
      // 13f: iload 5
      // 141: ifne 14d
      // 144: aload 1
      // 145: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.c (Ljava/lang/Object;)V
      // 148: aconst_null
      // 149: astore 1
      // 14a: goto 008
      // 14d: aload 1
      // 14e: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.b (Ljava/lang/Object;)Z
      // 151: ifne 159
      // 154: aconst_null
      // 155: astore 1
      // 156: goto 008
      // 159: aload 1
      // 15a: invokestatic android/support/v4/graphics/TypefaceCompatApi26Impl.a (Ljava/lang/Object;)Landroid/graphics/Typeface;
      // 15d: iload 4
      // 15f: invokestatic android/graphics/Typeface.create (Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
      // 162: astore 1
      // 163: goto 008
      // 166: astore 2
      // 167: goto 0a8
      // try (18 -> 25): 47 java/io/IOException
      // try (37 -> 39): 42 java/lang/Throwable
      // try (37 -> 39): 47 java/io/IOException
      // try (43 -> 47): 47 java/io/IOException
      // try (51 -> 53): 47 java/io/IOException
      // try (56 -> 71): 92 java/lang/Throwable
      // try (56 -> 71): 191 null
      // try (77 -> 79): 82 java/lang/Throwable
      // try (77 -> 79): 47 java/io/IOException
      // try (83 -> 87): 47 java/io/IOException
      // try (87 -> 89): 47 java/io/IOException
      // try (93 -> 95): 95 null
      // try (100 -> 102): 104 java/lang/Throwable
      // try (100 -> 102): 47 java/io/IOException
      // try (102 -> 104): 47 java/io/IOException
      // try (105 -> 108): 47 java/io/IOException
      // try (109 -> 111): 47 java/io/IOException
   }

   @Override
   public Typeface a(Context var1, FontResourcesParserCompat.FontFamilyFilesResourceEntry var2, Resources var3, int var4) {
      Typeface var10;
      if (!a()) {
         var10 = super.a(var1, var2, var3, var4);
      } else {
         Object var12 = b();

         for (FontResourcesParserCompat.FontFileResourceEntry var11 : var2.a()) {
            String var8 = var11.a();
            int var7 = var11.b();
            byte var5;
            if (var11.c()) {
               var5 = 1;
            } else {
               var5 = 0;
            }

            if (!a(var1, var12, var8, 0, var7, var5)) {
               c(var12);
               Object var14 = null;
               return (Typeface)var14;
            }
         }

         if (!b(var12)) {
            var10 = null;
         } else {
            var10 = a(var12);
         }
      }

      return var10;
   }
}
