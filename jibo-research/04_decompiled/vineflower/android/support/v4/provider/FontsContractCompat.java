package android.support.v4.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontsContractCompat {
   private static final LruCache<String, Typeface> a = new LruCache<>(16);
   private static final SelfDestructiveThread b = new SelfDestructiveThread("fonts", 10, 10000);
   private static final Object c = new Object();
   private static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>>> d = new SimpleArrayMap<>();
   private static final Comparator<byte[]> e = new Comparator<byte[]>() {
      public int a(byte[] var1, byte[] var2) {
         byte var5 = 0;
         int var3;
         if (var1.length != var2.length) {
            var3 = var1.length - var2.length;
         } else {
            int var4 = 0;

            while (true) {
               var3 = var5;
               if (var4 >= var1.length) {
                  break;
               }

               if (var1[var4] != var2[var4]) {
                  var3 = var1[var4] - var2[var4];
                  break;
               }

               var4++;
            }
         }

         return var3;
      }
   };

   public static ProviderInfo a(PackageManager var0, FontRequest var1, Resources var2) throws NameNotFoundException {
      String var5 = var1.a();
      ProviderInfo var4 = var0.resolveContentProvider(var5, 0);
      if (var4 == null) {
         throw new NameNotFoundException("No package found for authority: " + var5);
      }

      if (!var4.packageName.equals(var1.b())) {
         throw new NameNotFoundException("Found content provider " + var5 + ", but package was not " + var1.b());
      }

      List var6 = a(var0.getPackageInfo(var4.packageName, 64).signatures);
      Collections.sort(var6, e);
      List var8 = a(var1, var2);
      int var3 = 0;

      while (true) {
         if (var3 >= var8.size()) {
            var7 = null;
            break;
         }

         ArrayList var9 = new ArrayList((Collection)var8.get(var3));
         Collections.sort(var9, e);
         if (a(var6, var9)) {
            var7 = var4;
            break;
         }

         var3++;
      }

      return var7;
   }

   public static Typeface a(Context param0, FontRequest param1, ResourcesCompat.FontCallback param2, Handler param3, boolean param4, int param5, int param6) {
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
      // 000: aconst_null
      // 001: astore 7
      // 003: new java/lang/StringBuilder
      // 006: dup
      // 007: invokespecial java/lang/StringBuilder.<init> ()V
      // 00a: aload 1
      // 00b: invokevirtual android/support/v4/provider/FontRequest.f ()Ljava/lang/String;
      // 00e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 011: ldc "-"
      // 013: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 016: iload 6
      // 018: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 01b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 01e: astore 9
      // 020: getstatic android/support/v4/provider/FontsContractCompat.a Landroid/support/v4/util/LruCache;
      // 023: aload 9
      // 025: invokevirtual android/support/v4/util/LruCache.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 028: checkcast android/graphics/Typeface
      // 02b: astore 8
      // 02d: aload 8
      // 02f: ifnull 041
      // 032: aload 2
      // 033: ifnull 03c
      // 036: aload 2
      // 037: aload 8
      // 039: invokevirtual android/support/v4/content/res/ResourcesCompat$FontCallback.a (Landroid/graphics/Typeface;)V
      // 03c: aload 8
      // 03e: astore 0
      // 03f: aload 0
      // 040: areturn
      // 041: iload 4
      // 043: ifeq 07c
      // 046: iload 5
      // 048: bipush -1
      // 049: if_icmpne 07c
      // 04c: aload 0
      // 04d: aload 1
      // 04e: iload 6
      // 050: invokestatic android/support/v4/provider/FontsContractCompat.b (Landroid/content/Context;Landroid/support/v4/provider/FontRequest;I)Landroid/support/v4/provider/FontsContractCompat$TypefaceResult;
      // 053: astore 0
      // 054: aload 2
      // 055: ifnull 068
      // 058: aload 0
      // 059: getfield android/support/v4/provider/FontsContractCompat$TypefaceResult.b I
      // 05c: ifne 070
      // 05f: aload 2
      // 060: aload 0
      // 061: getfield android/support/v4/provider/FontsContractCompat$TypefaceResult.a Landroid/graphics/Typeface;
      // 064: aload 3
      // 065: invokevirtual android/support/v4/content/res/ResourcesCompat$FontCallback.a (Landroid/graphics/Typeface;Landroid/os/Handler;)V
      // 068: aload 0
      // 069: getfield android/support/v4/provider/FontsContractCompat$TypefaceResult.a Landroid/graphics/Typeface;
      // 06c: astore 0
      // 06d: goto 03f
      // 070: aload 2
      // 071: aload 0
      // 072: getfield android/support/v4/provider/FontsContractCompat$TypefaceResult.b I
      // 075: aload 3
      // 076: invokevirtual android/support/v4/content/res/ResourcesCompat$FontCallback.a (ILandroid/os/Handler;)V
      // 079: goto 068
      // 07c: new android/support/v4/provider/FontsContractCompat$1
      // 07f: dup
      // 080: aload 0
      // 081: aload 1
      // 082: iload 6
      // 084: aload 9
      // 086: invokespecial android/support/v4/provider/FontsContractCompat$1.<init> (Landroid/content/Context;Landroid/support/v4/provider/FontRequest;ILjava/lang/String;)V
      // 089: astore 1
      // 08a: iload 4
      // 08c: ifeq 0a2
      // 08f: getstatic android/support/v4/provider/FontsContractCompat.b Landroid/support/v4/provider/SelfDestructiveThread;
      // 092: aload 1
      // 093: iload 5
      // 095: invokevirtual android/support/v4/provider/SelfDestructiveThread.a (Ljava/util/concurrent/Callable;I)Ljava/lang/Object;
      // 098: checkcast android/support/v4/provider/FontsContractCompat$TypefaceResult
      // 09b: getfield android/support/v4/provider/FontsContractCompat$TypefaceResult.a Landroid/graphics/Typeface;
      // 09e: astore 0
      // 09f: goto 03f
      // 0a2: aload 2
      // 0a3: ifnonnull 0da
      // 0a6: aconst_null
      // 0a7: astore 0
      // 0a8: getstatic android/support/v4/provider/FontsContractCompat.c Ljava/lang/Object;
      // 0ab: astore 2
      // 0ac: aload 2
      // 0ad: monitorenter
      // 0ae: getstatic android/support/v4/provider/FontsContractCompat.d Landroid/support/v4/util/SimpleArrayMap;
      // 0b1: aload 9
      // 0b3: invokevirtual android/support/v4/util/SimpleArrayMap.containsKey (Ljava/lang/Object;)Z
      // 0b6: ifeq 0e7
      // 0b9: aload 0
      // 0ba: ifnull 0cd
      // 0bd: getstatic android/support/v4/provider/FontsContractCompat.d Landroid/support/v4/util/SimpleArrayMap;
      // 0c0: aload 9
      // 0c2: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0c5: checkcast java/util/ArrayList
      // 0c8: aload 0
      // 0c9: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 0cc: pop
      // 0cd: aload 2
      // 0ce: monitorexit
      // 0cf: aload 7
      // 0d1: astore 0
      // 0d2: goto 03f
      // 0d5: astore 0
      // 0d6: aload 2
      // 0d7: monitorexit
      // 0d8: aload 0
      // 0d9: athrow
      // 0da: new android/support/v4/provider/FontsContractCompat$2
      // 0dd: dup
      // 0de: aload 2
      // 0df: aload 3
      // 0e0: invokespecial android/support/v4/provider/FontsContractCompat$2.<init> (Landroid/support/v4/content/res/ResourcesCompat$FontCallback;Landroid/os/Handler;)V
      // 0e3: astore 0
      // 0e4: goto 0a8
      // 0e7: aload 0
      // 0e8: ifnull 103
      // 0eb: new java/util/ArrayList
      // 0ee: astore 3
      // 0ef: aload 3
      // 0f0: invokespecial java/util/ArrayList.<init> ()V
      // 0f3: aload 3
      // 0f4: aload 0
      // 0f5: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 0f8: pop
      // 0f9: getstatic android/support/v4/provider/FontsContractCompat.d Landroid/support/v4/util/SimpleArrayMap;
      // 0fc: aload 9
      // 0fe: aload 3
      // 0ff: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 102: pop
      // 103: aload 2
      // 104: monitorexit
      // 105: getstatic android/support/v4/provider/FontsContractCompat.b Landroid/support/v4/provider/SelfDestructiveThread;
      // 108: aload 1
      // 109: new android/support/v4/provider/FontsContractCompat$3
      // 10c: dup
      // 10d: aload 9
      // 10f: invokespecial android/support/v4/provider/FontsContractCompat$3.<init> (Ljava/lang/String;)V
      // 112: invokevirtual android/support/v4/provider/SelfDestructiveThread.a (Ljava/util/concurrent/Callable;Landroid/support/v4/provider/SelfDestructiveThread$ReplyCallback;)V
      // 115: aload 7
      // 117: astore 0
      // 118: goto 03f
      // 11b: astore 0
      // 11c: aload 7
      // 11e: astore 0
      // 11f: goto 03f
      // try (70 -> 77): 143 java/lang/InterruptedException
      // try (86 -> 90): 104 null
      // try (92 -> 99): 104 null
      // try (99 -> 101): 104 null
      // try (105 -> 107): 104 null
      // try (118 -> 131): 104 null
      // try (131 -> 133): 104 null
   }

   public static FontsContractCompat.FontFamilyResult a(Context var0, CancellationSignal var1, FontRequest var2) throws NameNotFoundException {
      ProviderInfo var3 = a(var0.getPackageManager(), var2, var0.getResources());
      FontsContractCompat.FontFamilyResult var4;
      if (var3 == null) {
         var4 = new FontsContractCompat.FontFamilyResult(1, null);
      } else {
         var4 = new FontsContractCompat.FontFamilyResult(0, a(var0, var2, var3.authority, var1));
      }

      return var4;
   }

   private static List<List<byte[]>> a(FontRequest var0, Resources var1) {
      List var2;
      if (var0.d() != null) {
         var2 = var0.d();
      } else {
         var2 = FontResourcesParserCompat.a(var1, var0.e());
      }

      return var2;
   }

   private static List<byte[]> a(Signature[] var0) {
      ArrayList var2 = new ArrayList();

      for (int var1 = 0; var1 < var0.length; var1++) {
         var2.add(var0[var1].toByteArray());
      }

      return var2;
   }

   public static Map<Uri, ByteBuffer> a(Context var0, FontsContractCompat.FontInfo[] var1, CancellationSignal var2) {
      HashMap var5 = new HashMap();

      for (FontsContractCompat.FontInfo var6 : var1) {
         if (var6.e() == 0) {
            Uri var7 = var6.a();
            if (!var5.containsKey(var7)) {
               var5.put(var7, TypefaceCompatUtil.a(var0, var2, var7));
            }
         }
      }

      return Collections.unmodifiableMap(var5);
   }

   private static boolean a(List<byte[]> var0, List<byte[]> var1) {
      boolean var4 = false;
      boolean var3;
      if (var0.size() != var1.size()) {
         var3 = var4;
      } else {
         int var2 = 0;

         while (true) {
            if (var2 >= var0.size()) {
               var3 = true;
               break;
            }

            var3 = var4;
            if (!Arrays.equals((byte[])var0.get(var2), (byte[])var1.get(var2))) {
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   static FontsContractCompat.FontInfo[] a(Context param0, FontRequest param1, String param2, CancellationSignal param3) {
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
      // 000: new java/util/ArrayList
      // 003: dup
      // 004: invokespecial java/util/ArrayList.<init> ()V
      // 007: astore 14
      // 009: new android/net/Uri$Builder
      // 00c: dup
      // 00d: invokespecial android/net/Uri$Builder.<init> ()V
      // 010: ldc_w "content"
      // 013: invokevirtual android/net/Uri$Builder.scheme (Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 016: aload 2
      // 017: invokevirtual android/net/Uri$Builder.authority (Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 01a: invokevirtual android/net/Uri$Builder.build ()Landroid/net/Uri;
      // 01d: astore 15
      // 01f: new android/net/Uri$Builder
      // 022: dup
      // 023: invokespecial android/net/Uri$Builder.<init> ()V
      // 026: ldc_w "content"
      // 029: invokevirtual android/net/Uri$Builder.scheme (Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 02c: aload 2
      // 02d: invokevirtual android/net/Uri$Builder.authority (Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 030: ldc_w "file"
      // 033: invokevirtual android/net/Uri$Builder.appendPath (Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 036: invokevirtual android/net/Uri$Builder.build ()Landroid/net/Uri;
      // 039: astore 16
      // 03b: getstatic android/os/Build$VERSION.SDK_INT I
      // 03e: bipush 16
      // 040: if_icmple 173
      // 043: aload 0
      // 044: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 047: astore 0
      // 048: aload 1
      // 049: invokevirtual android/support/v4/provider/FontRequest.c ()Ljava/lang/String;
      // 04c: astore 1
      // 04d: aload 0
      // 04e: aload 15
      // 050: bipush 7
      // 052: anewarray 105
      // 055: dup
      // 056: bipush 0
      // 057: ldc_w "_id"
      // 05a: aastore
      // 05b: dup
      // 05c: bipush 1
      // 05d: ldc_w "file_id"
      // 060: aastore
      // 061: dup
      // 062: bipush 2
      // 063: ldc_w "font_ttc_index"
      // 066: aastore
      // 067: dup
      // 068: bipush 3
      // 069: ldc_w "font_variation_settings"
      // 06c: aastore
      // 06d: dup
      // 06e: bipush 4
      // 06f: ldc_w "font_weight"
      // 072: aastore
      // 073: dup
      // 074: bipush 5
      // 075: ldc_w "font_italic"
      // 078: aastore
      // 079: dup
      // 07a: bipush 6
      // 07c: ldc_w "result_code"
      // 07f: aastore
      // 080: ldc_w "query = ?"
      // 083: bipush 1
      // 084: anewarray 105
      // 087: dup
      // 088: bipush 0
      // 089: aload 1
      // 08a: aastore
      // 08b: aconst_null
      // 08c: aload 3
      // 08d: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
      // 090: astore 0
      // 091: aload 0
      // 092: ifnull 1ee
      // 095: aload 0
      // 096: invokeinterface android/database/Cursor.getCount ()I 1
      // 09b: ifle 1ee
      // 09e: aload 0
      // 09f: ldc_w "result_code"
      // 0a2: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0a7: istore 10
      // 0a9: new java/util/ArrayList
      // 0ac: astore 2
      // 0ad: aload 2
      // 0ae: invokespecial java/util/ArrayList.<init> ()V
      // 0b1: aload 0
      // 0b2: ldc_w "_id"
      // 0b5: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0ba: istore 11
      // 0bc: aload 0
      // 0bd: ldc_w "file_id"
      // 0c0: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0c5: istore 8
      // 0c7: aload 0
      // 0c8: ldc_w "font_ttc_index"
      // 0cb: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0d0: istore 12
      // 0d2: aload 0
      // 0d3: ldc_w "font_weight"
      // 0d6: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0db: istore 7
      // 0dd: aload 0
      // 0de: ldc_w "font_italic"
      // 0e1: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0e6: istore 9
      // 0e8: aload 2
      // 0e9: astore 1
      // 0ea: aload 0
      // 0eb: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 0f0: ifeq 1f1
      // 0f3: iload 10
      // 0f5: bipush -1
      // 0f6: if_icmpeq 1c3
      // 0f9: aload 0
      // 0fa: iload 10
      // 0fc: invokeinterface android/database/Cursor.getInt (I)I 2
      // 101: istore 4
      // 103: iload 12
      // 105: bipush -1
      // 106: if_icmpeq 1c9
      // 109: aload 0
      // 10a: iload 12
      // 10c: invokeinterface android/database/Cursor.getInt (I)I 2
      // 111: istore 5
      // 113: iload 8
      // 115: bipush -1
      // 116: if_icmpne 1cf
      // 119: aload 15
      // 11b: aload 0
      // 11c: iload 11
      // 11e: invokeinterface android/database/Cursor.getLong (I)J 2
      // 123: invokestatic android/content/ContentUris.withAppendedId (Landroid/net/Uri;J)Landroid/net/Uri;
      // 126: astore 1
      // 127: iload 7
      // 129: bipush -1
      // 12a: if_icmpeq 1e0
      // 12d: aload 0
      // 12e: iload 7
      // 130: invokeinterface android/database/Cursor.getInt (I)I 2
      // 135: istore 6
      // 137: iload 9
      // 139: bipush -1
      // 13a: if_icmpeq 1e8
      // 13d: aload 0
      // 13e: iload 9
      // 140: invokeinterface android/database/Cursor.getInt (I)I 2
      // 145: bipush 1
      // 146: if_icmpne 1e8
      // 149: bipush 1
      // 14a: istore 13
      // 14c: new android/support/v4/provider/FontsContractCompat$FontInfo
      // 14f: astore 3
      // 150: aload 3
      // 151: aload 1
      // 152: iload 5
      // 154: iload 6
      // 156: iload 13
      // 158: iload 4
      // 15a: invokespecial android/support/v4/provider/FontsContractCompat$FontInfo.<init> (Landroid/net/Uri;IIZI)V
      // 15d: aload 2
      // 15e: aload 3
      // 15f: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 162: pop
      // 163: goto 0e8
      // 166: astore 1
      // 167: aload 0
      // 168: ifnull 171
      // 16b: aload 0
      // 16c: invokeinterface android/database/Cursor.close ()V 1
      // 171: aload 1
      // 172: athrow
      // 173: aload 0
      // 174: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 177: astore 0
      // 178: aload 1
      // 179: invokevirtual android/support/v4/provider/FontRequest.c ()Ljava/lang/String;
      // 17c: astore 1
      // 17d: aload 0
      // 17e: aload 15
      // 180: bipush 7
      // 182: anewarray 105
      // 185: dup
      // 186: bipush 0
      // 187: ldc_w "_id"
      // 18a: aastore
      // 18b: dup
      // 18c: bipush 1
      // 18d: ldc_w "file_id"
      // 190: aastore
      // 191: dup
      // 192: bipush 2
      // 193: ldc_w "font_ttc_index"
      // 196: aastore
      // 197: dup
      // 198: bipush 3
      // 199: ldc_w "font_variation_settings"
      // 19c: aastore
      // 19d: dup
      // 19e: bipush 4
      // 19f: ldc_w "font_weight"
      // 1a2: aastore
      // 1a3: dup
      // 1a4: bipush 5
      // 1a5: ldc_w "font_italic"
      // 1a8: aastore
      // 1a9: dup
      // 1aa: bipush 6
      // 1ac: ldc_w "result_code"
      // 1af: aastore
      // 1b0: ldc_w "query = ?"
      // 1b3: bipush 1
      // 1b4: anewarray 105
      // 1b7: dup
      // 1b8: bipush 0
      // 1b9: aload 1
      // 1ba: aastore
      // 1bb: aconst_null
      // 1bc: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 1bf: astore 0
      // 1c0: goto 091
      // 1c3: bipush 0
      // 1c4: istore 4
      // 1c6: goto 103
      // 1c9: bipush 0
      // 1ca: istore 5
      // 1cc: goto 113
      // 1cf: aload 16
      // 1d1: aload 0
      // 1d2: iload 8
      // 1d4: invokeinterface android/database/Cursor.getLong (I)J 2
      // 1d9: invokestatic android/content/ContentUris.withAppendedId (Landroid/net/Uri;J)Landroid/net/Uri;
      // 1dc: astore 1
      // 1dd: goto 127
      // 1e0: sipush 400
      // 1e3: istore 6
      // 1e5: goto 137
      // 1e8: bipush 0
      // 1e9: istore 13
      // 1eb: goto 14c
      // 1ee: aload 14
      // 1f0: astore 1
      // 1f1: aload 0
      // 1f2: ifnull 1fb
      // 1f5: aload 0
      // 1f6: invokeinterface android/database/Cursor.close ()V 1
      // 1fb: aload 1
      // 1fc: bipush 0
      // 1fd: anewarray 17
      // 200: invokevirtual java/util/ArrayList.toArray ([Ljava/lang/Object;)[Ljava/lang/Object;
      // 203: checkcast [Landroid/support/v4/provider/FontsContractCompat$FontInfo;
      // 206: areturn
      // 207: astore 1
      // 208: aconst_null
      // 209: astore 0
      // 20a: goto 167
      // try (24 -> 76): 255 null
      // try (78 -> 109): 168 null
      // try (111 -> 114): 168 null
      // try (117 -> 121): 168 null
      // try (124 -> 128): 168 null
      // try (131 -> 137): 168 null
      // try (140 -> 144): 168 null
      // try (147 -> 152): 168 null
      // try (154 -> 167): 168 null
      // try (175 -> 223): 255 null
      // try (230 -> 236): 168 null
   }

   private static FontsContractCompat.TypefaceResult b(Context var0, FontRequest var1, int var2) {
      byte var3 = -3;

      try {
         var7 = a(var0, null, var1);
      } catch (NameNotFoundException var4) {
         return new FontsContractCompat.TypefaceResult(null, -1);
      }

      FontsContractCompat.TypefaceResult var5;
      if (var7.a() == 0) {
         Typeface var6 = TypefaceCompat.a(var0, null, var7.b(), var2);
         if (var6 != null) {
            var3 = 0;
         }

         var5 = new FontsContractCompat.TypefaceResult(var6, var3);
      } else {
         if (var7.a() == 1) {
            var3 = -2;
         }

         var5 = new FontsContractCompat.TypefaceResult(null, var3);
      }

      return var5;
   }

   public static class FontFamilyResult {
      private final int a;
      private final FontsContractCompat.FontInfo[] b;

      public FontFamilyResult(int var1, FontsContractCompat.FontInfo[] var2) {
         this.a = var1;
         this.b = var2;
      }

      public int a() {
         return this.a;
      }

      public FontsContractCompat.FontInfo[] b() {
         return this.b;
      }
   }

   public static class FontInfo {
      private final Uri a;
      private final int b;
      private final int c;
      private final boolean d;
      private final int e;

      public FontInfo(Uri var1, int var2, int var3, boolean var4, int var5) {
         this.a = Preconditions.a(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }

      public Uri a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }

      public boolean d() {
         return this.d;
      }

      public int e() {
         return this.e;
      }
   }

   private static final class TypefaceResult {
      final Typeface a;
      final int b;

      TypefaceResult(Typeface var1, int var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
