package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimationUtilsCompat {
   public static Interpolator a(Context param0, int param1) throws NotFoundException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: getstatic android/os/Build$VERSION.SDK_INT I
      // 003: bipush 21
      // 005: if_icmplt 010
      // 008: aload 0
      // 009: iload 1
      // 00a: invokestatic android/view/animation/AnimationUtils.loadInterpolator (Landroid/content/Context;I)Landroid/view/animation/Interpolator;
      // 00d: astore 0
      // 00e: aload 0
      // 00f: areturn
      // 010: aconst_null
      // 011: astore 2
      // 012: aconst_null
      // 013: astore 4
      // 015: aconst_null
      // 016: astore 3
      // 017: iload 1
      // 018: ldc 17563663
      // 01a: if_icmpne 031
      // 01d: new android/support/v4/view/animation/FastOutLinearInInterpolator
      // 020: dup
      // 021: invokespecial android/support/v4/view/animation/FastOutLinearInInterpolator.<init> ()V
      // 024: astore 0
      // 025: bipush 0
      // 026: ifeq 00e
      // 029: new java/lang/NullPointerException
      // 02c: dup
      // 02d: invokespecial java/lang/NullPointerException.<init> ()V
      // 030: athrow
      // 031: iload 1
      // 032: ldc 17563661
      // 034: if_icmpne 04b
      // 037: new android/support/v4/view/animation/FastOutSlowInInterpolator
      // 03a: dup
      // 03b: invokespecial android/support/v4/view/animation/FastOutSlowInInterpolator.<init> ()V
      // 03e: astore 0
      // 03f: bipush 0
      // 040: ifeq 00e
      // 043: new java/lang/NullPointerException
      // 046: dup
      // 047: invokespecial java/lang/NullPointerException.<init> ()V
      // 04a: athrow
      // 04b: iload 1
      // 04c: ldc 17563662
      // 04e: if_icmpne 065
      // 051: new android/support/v4/view/animation/LinearOutSlowInInterpolator
      // 054: dup
      // 055: invokespecial android/support/v4/view/animation/LinearOutSlowInInterpolator.<init> ()V
      // 058: astore 0
      // 059: bipush 0
      // 05a: ifeq 00e
      // 05d: new java/lang/NullPointerException
      // 060: dup
      // 061: invokespecial java/lang/NullPointerException.<init> ()V
      // 064: athrow
      // 065: aload 0
      // 066: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 069: iload 1
      // 06a: invokevirtual android/content/res/Resources.getAnimation (I)Landroid/content/res/XmlResourceParser;
      // 06d: astore 5
      // 06f: aload 5
      // 071: astore 3
      // 072: aload 5
      // 074: astore 2
      // 075: aload 5
      // 077: astore 4
      // 079: aload 0
      // 07a: aload 0
      // 07b: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 07e: aload 0
      // 07f: invokevirtual android/content/Context.getTheme ()Landroid/content/res/Resources$Theme;
      // 082: aload 5
      // 084: invokestatic android/support/graphics/drawable/AnimationUtilsCompat.a (Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
      // 087: astore 0
      // 088: aload 0
      // 089: astore 2
      // 08a: aload 2
      // 08b: astore 0
      // 08c: aload 5
      // 08e: ifnull 00e
      // 091: aload 5
      // 093: invokeinterface android/content/res/XmlResourceParser.close ()V 1
      // 098: aload 2
      // 099: astore 0
      // 09a: goto 00e
      // 09d: astore 5
      // 09f: aload 3
      // 0a0: astore 2
      // 0a1: new android/content/res/Resources$NotFoundException
      // 0a4: astore 4
      // 0a6: aload 3
      // 0a7: astore 2
      // 0a8: new java/lang/StringBuilder
      // 0ab: astore 0
      // 0ac: aload 3
      // 0ad: astore 2
      // 0ae: aload 0
      // 0af: invokespecial java/lang/StringBuilder.<init> ()V
      // 0b2: aload 3
      // 0b3: astore 2
      // 0b4: aload 4
      // 0b6: aload 0
      // 0b7: ldc "Can't load animation resource ID #0x"
      // 0b9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0bc: iload 1
      // 0bd: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 0c0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0c6: invokespecial android/content/res/Resources$NotFoundException.<init> (Ljava/lang/String;)V
      // 0c9: aload 3
      // 0ca: astore 2
      // 0cb: aload 4
      // 0cd: aload 5
      // 0cf: invokevirtual android/content/res/Resources$NotFoundException.initCause (Ljava/lang/Throwable;)Ljava/lang/Throwable;
      // 0d2: pop
      // 0d3: aload 3
      // 0d4: astore 2
      // 0d5: aload 4
      // 0d7: athrow
      // 0d8: astore 0
      // 0d9: aload 2
      // 0da: ifnull 0e3
      // 0dd: aload 2
      // 0de: invokeinterface android/content/res/XmlResourceParser.close ()V 1
      // 0e3: aload 0
      // 0e4: athrow
      // 0e5: astore 3
      // 0e6: aload 4
      // 0e8: astore 2
      // 0e9: new android/content/res/Resources$NotFoundException
      // 0ec: astore 5
      // 0ee: aload 4
      // 0f0: astore 2
      // 0f1: new java/lang/StringBuilder
      // 0f4: astore 0
      // 0f5: aload 4
      // 0f7: astore 2
      // 0f8: aload 0
      // 0f9: invokespecial java/lang/StringBuilder.<init> ()V
      // 0fc: aload 4
      // 0fe: astore 2
      // 0ff: aload 5
      // 101: aload 0
      // 102: ldc "Can't load animation resource ID #0x"
      // 104: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 107: iload 1
      // 108: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 10b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 111: invokespecial android/content/res/Resources$NotFoundException.<init> (Ljava/lang/String;)V
      // 114: aload 4
      // 116: astore 2
      // 117: aload 5
      // 119: aload 3
      // 11a: invokevirtual android/content/res/Resources$NotFoundException.initCause (Ljava/lang/Throwable;)Ljava/lang/Throwable;
      // 11d: pop
      // 11e: aload 4
      // 120: astore 2
      // 121: aload 5
      // 123: athrow
      // try (18 -> 22): 84 org/xmlpull/v1/XmlPullParserException
      // try (18 -> 22): 125 java/io/IOException
      // try (18 -> 22): 118 null
      // try (31 -> 35): 84 org/xmlpull/v1/XmlPullParserException
      // try (31 -> 35): 125 java/io/IOException
      // try (31 -> 35): 118 null
      // try (44 -> 48): 84 org/xmlpull/v1/XmlPullParserException
      // try (44 -> 48): 125 java/io/IOException
      // try (44 -> 48): 118 null
      // try (54 -> 59): 84 org/xmlpull/v1/XmlPullParserException
      // try (54 -> 59): 125 java/io/IOException
      // try (54 -> 59): 118 null
      // try (65 -> 73): 84 org/xmlpull/v1/XmlPullParserException
      // try (65 -> 73): 125 java/io/IOException
      // try (65 -> 73): 118 null
      // try (87 -> 89): 118 null
      // try (91 -> 93): 118 null
      // try (95 -> 97): 118 null
      // try (99 -> 108): 118 null
      // try (110 -> 114): 118 null
      // try (116 -> 118): 118 null
      // try (128 -> 130): 118 null
      // try (132 -> 134): 118 null
      // try (136 -> 138): 118 null
      // try (140 -> 149): 118 null
      // try (151 -> 155): 118 null
      // try (157 -> 159): 118 null
   }

   private static Interpolator a(Context var0, Resources var1, Theme var2, XmlPullParser var3) throws XmlPullParserException, IOException {
      Object var6 = null;
      int var4 = var3.getDepth();

      while (true) {
         int var5 = var3.next();
         if (var5 == 3 && var3.getDepth() <= var4 || var5 == 1) {
            return (Interpolator)var6;
         }

         if (var5 == 2) {
            AttributeSet var7 = Xml.asAttributeSet(var3);
            String var8 = var3.getName();
            if (var8.equals("linearInterpolator")) {
               var6 = new LinearInterpolator();
            } else if (var8.equals("accelerateInterpolator")) {
               var6 = new AccelerateInterpolator(var0, var7);
            } else if (var8.equals("decelerateInterpolator")) {
               var6 = new DecelerateInterpolator(var0, var7);
            } else if (var8.equals("accelerateDecelerateInterpolator")) {
               var6 = new AccelerateDecelerateInterpolator();
            } else if (var8.equals("cycleInterpolator")) {
               var6 = new CycleInterpolator(var0, var7);
            } else if (var8.equals("anticipateInterpolator")) {
               var6 = new AnticipateInterpolator(var0, var7);
            } else if (var8.equals("overshootInterpolator")) {
               var6 = new OvershootInterpolator(var0, var7);
            } else if (var8.equals("anticipateOvershootInterpolator")) {
               var6 = new AnticipateOvershootInterpolator(var0, var7);
            } else if (var8.equals("bounceInterpolator")) {
               var6 = new BounceInterpolator();
            } else {
               if (!var8.equals("pathInterpolator")) {
                  throw new RuntimeException("Unknown interpolator name: " + var3.getName());
               }

               var6 = new PathInterpolatorCompat(var0, var7, var3);
            }
         }
      }
   }
}
