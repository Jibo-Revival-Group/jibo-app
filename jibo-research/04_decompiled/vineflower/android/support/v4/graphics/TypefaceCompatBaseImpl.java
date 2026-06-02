package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

class TypefaceCompatBaseImpl implements TypefaceCompat.TypefaceCompatImpl {
   private FontResourcesParserCompat.FontFileResourceEntry a(FontResourcesParserCompat.FontFamilyFilesResourceEntry var1, int var2) {
      return a(var1.a(), var2, new TypefaceCompatBaseImpl.StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>(this) {
         final TypefaceCompatBaseImpl a;

         {
            this.a = var1;
         }

         public int a(FontResourcesParserCompat.FontFileResourceEntry var1) {
            return var1.b();
         }

         public boolean b(FontResourcesParserCompat.FontFileResourceEntry var1) {
            return var1.c();
         }
      });
   }

   private static <T> T a(T[] var0, int var1, TypefaceCompatBaseImpl.StyleExtractor<T> var2) {
      short var3;
      if ((var1 & 1) == 0) {
         var3 = 400;
      } else {
         var3 = 700;
      }

      boolean var8;
      if ((var1 & 2) != 0) {
         var8 = true;
      } else {
         var8 = false;
      }

      Object var9 = null;
      int var4 = Integer.MAX_VALUE;

      for (Object var10 : var0) {
         int var7 = Math.abs(var2.b(var10) - var3);
         byte var5;
         if (var2.a(var10) == var8) {
            var5 = 0;
         } else {
            var5 = 1;
         }

         var5 += var7 * 2;
         if (var9 == null || var4 > var5) {
            var4 = var5;
            var9 = var10;
         }
      }

      return (T)var9;
   }

   @Override
   public Typeface a(Context param1, Resources param2, int param3, String param4, int param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: aload 1
      // 04: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Landroid/content/Context;)Ljava/io/File;
      // 07: astore 7
      // 09: aload 7
      // 0b: ifnonnull 13
      // 0e: aload 4
      // 10: astore 1
      // 11: aload 1
      // 12: areturn
      // 13: aload 7
      // 15: aload 2
      // 16: iload 3
      // 17: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/File;Landroid/content/res/Resources;I)Z
      // 1a: istore 6
      // 1c: iload 6
      // 1e: ifne 2d
      // 21: aload 7
      // 23: invokevirtual java/io/File.delete ()Z
      // 26: pop
      // 27: aload 4
      // 29: astore 1
      // 2a: goto 11
      // 2d: aload 7
      // 2f: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 32: invokestatic android/graphics/Typeface.createFromFile (Ljava/lang/String;)Landroid/graphics/Typeface;
      // 35: astore 1
      // 36: aload 7
      // 38: invokevirtual java/io/File.delete ()Z
      // 3b: pop
      // 3c: goto 11
      // 3f: astore 1
      // 40: aload 7
      // 42: invokevirtual java/io/File.delete ()Z
      // 45: pop
      // 46: aload 4
      // 48: astore 1
      // 49: goto 11
      // 4c: astore 1
      // 4d: aload 7
      // 4f: invokevirtual java/io/File.delete ()Z
      // 52: pop
      // 53: aload 1
      // 54: athrow
      // try (11 -> 16): 32 java/lang/RuntimeException
      // try (11 -> 16): 39 null
      // try (24 -> 28): 32 java/lang/RuntimeException
      // try (24 -> 28): 39 null
   }

   @Override
   public Typeface a(Context var1, CancellationSignal var2, FontsContractCompat.FontInfo[] var3, int var4) {
      Object var5 = null;
      if (var3.length < 1) {
         var1 = var5;
      } else {
         FontsContractCompat.FontInfo var18 = this.a(var3, var4);

         label94: {
            label85: {
               label84: {
                  try {
                     var19 = var1.getContentResolver().openInputStream(var18.a());
                     break label84;
                  } catch (IOException var16) {
                  } finally {
                     ;
                  }

                  var19 = null;
                  break label85;
               }

               try {
                  var1 = this.a((Context)var1, var19);
                  break label94;
               } catch (IOException var14) {
                  var1 = var14;
               } finally {
                  TypefaceCompatUtil.a(var19);
                  throw var1;
               }
            }

            TypefaceCompatUtil.a(var19);
            var1 = var5;
            return (Typeface)var1;
         }

         TypefaceCompatUtil.a(var19);
      }

      return (Typeface)var1;
   }

   @Override
   public Typeface a(Context var1, FontResourcesParserCompat.FontFamilyFilesResourceEntry var2, Resources var3, int var4) {
      FontResourcesParserCompat.FontFileResourceEntry var6 = this.a(var2, var4);
      Typeface var5;
      if (var6 == null) {
         var5 = null;
      } else {
         var5 = TypefaceCompat.a(var1, var3, var6.d(), var6.a(), var4);
      }

      return var5;
   }

   protected Typeface a(Context param1, InputStream param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: aload 1
      // 04: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Landroid/content/Context;)Ljava/io/File;
      // 07: astore 5
      // 09: aload 5
      // 0b: ifnonnull 13
      // 0e: aload 4
      // 10: astore 1
      // 11: aload 1
      // 12: areturn
      // 13: aload 5
      // 15: aload 2
      // 16: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/File;Ljava/io/InputStream;)Z
      // 19: istore 3
      // 1a: iload 3
      // 1b: ifne 2a
      // 1e: aload 5
      // 20: invokevirtual java/io/File.delete ()Z
      // 23: pop
      // 24: aload 4
      // 26: astore 1
      // 27: goto 11
      // 2a: aload 5
      // 2c: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 2f: invokestatic android/graphics/Typeface.createFromFile (Ljava/lang/String;)Landroid/graphics/Typeface;
      // 32: astore 1
      // 33: aload 5
      // 35: invokevirtual java/io/File.delete ()Z
      // 38: pop
      // 39: goto 11
      // 3c: astore 1
      // 3d: aload 5
      // 3f: invokevirtual java/io/File.delete ()Z
      // 42: pop
      // 43: aload 4
      // 45: astore 1
      // 46: goto 11
      // 49: astore 1
      // 4a: aload 5
      // 4c: invokevirtual java/io/File.delete ()Z
      // 4f: pop
      // 50: aload 1
      // 51: athrow
      // try (11 -> 15): 31 java/lang/RuntimeException
      // try (11 -> 15): 38 null
      // try (23 -> 27): 31 java/lang/RuntimeException
      // try (23 -> 27): 38 null
   }

   protected FontsContractCompat.FontInfo a(FontsContractCompat.FontInfo[] var1, int var2) {
      return a(var1, var2, new TypefaceCompatBaseImpl.StyleExtractor<FontsContractCompat.FontInfo>(this) {
         final TypefaceCompatBaseImpl a;

         {
            this.a = var1;
         }

         public int a(FontsContractCompat.FontInfo var1) {
            return var1.c();
         }

         public boolean b(FontsContractCompat.FontInfo var1) {
            return var1.d();
         }
      });
   }

   private interface StyleExtractor<T> {
      boolean a(T var1);

      int b(T var1);
   }
}
