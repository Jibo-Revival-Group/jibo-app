package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
   static final Mode a = Mode.SRC_IN;
   private VectorDrawableCompat.VectorDrawableCompatState c;
   private PorterDuffColorFilter d;
   private ColorFilter e;
   private boolean f;
   private boolean g = true;
   private ConstantState h;
   private final float[] i = new float[9];
   private final Matrix j = new Matrix();
   private final Rect k = new Rect();

   VectorDrawableCompat() {
      this.c = new VectorDrawableCompat.VectorDrawableCompatState();
   }

   VectorDrawableCompat(VectorDrawableCompat.VectorDrawableCompatState var1) {
      this.c = var1;
      this.d = this.a(this.d, var1.c, var1.d);
   }

   static int a(int var0, float var1) {
      return (int)(Color.alpha(var0) * var1) << 24 | 16777215 & var0;
   }

   private static Mode a(int var0, Mode var1) {
      Mode var2 = var1;
      switch (var0) {
         case 3:
            var2 = Mode.SRC_OVER;
         case 4:
         case 6:
         case 7:
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
            break;
         case 5:
            var2 = Mode.SRC_IN;
            break;
         case 9:
            var2 = Mode.SRC_ATOP;
            break;
         case 14:
            var2 = Mode.MULTIPLY;
            break;
         case 15:
            var2 = Mode.SCREEN;
            break;
         case 16:
            var2 = Mode.ADD;
            break;
         default:
            var2 = var1;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static VectorDrawableCompat a(Resources var0, int var1, Theme var2) {
      VectorDrawableCompat var13;
      if (VERSION.SDK_INT >= 24) {
         VectorDrawableCompat var3 = new VectorDrawableCompat();
         var3.b = ResourcesCompat.a(var0, var1, var2);
         var3.h = new VectorDrawableCompat.VectorDrawableDelegateState(var3.b.getConstantState());
         var13 = var3;
      } else {
         label46: {
            XmlResourceParser var4;
            AttributeSet var16;
            try {
               var4 = var0.getXml(var1);
               var16 = Xml.asAttributeSet(var4);
            } catch (XmlPullParserException var11) {
               Log.e("VectorDrawableCompat", "parser error", var11);
               break label46;
            } catch (IOException var12) {
               Log.e("VectorDrawableCompat", "parser error", var12);
               break label46;
            }

            while (true) {
               try {
                  var1 = var4.next();
               } catch (XmlPullParserException var9) {
                  Log.e("VectorDrawableCompat", "parser error", var9);
                  break;
               } catch (IOException var10) {
                  Log.e("VectorDrawableCompat", "parser error", var10);
                  break;
               }

               if (var1 == 2 || var1 == 1) {
                  if (var1 != 2) {
                     try {
                        XmlPullParserException var14 = new XmlPullParserException("No start tag found");
                        throw var14;
                     } catch (XmlPullParserException var5) {
                        Log.e("VectorDrawableCompat", "parser error", var5);
                        break;
                     } catch (IOException var6) {
                        Log.e("VectorDrawableCompat", "parser error", var6);
                        break;
                     }
                  } else {
                     try {
                        VectorDrawableCompat var17 = a(var0, var4, var16, var2);
                        return var17;
                     } catch (XmlPullParserException var7) {
                        Log.e("VectorDrawableCompat", "parser error", var7);
                        break;
                     } catch (IOException var8) {
                        Log.e("VectorDrawableCompat", "parser error", var8);
                        break;
                     }
                  }
               }
            }
         }

         var13 = null;
      }

      return var13;
   }

   public static VectorDrawableCompat a(Resources var0, XmlPullParser var1, AttributeSet var2, Theme var3) throws XmlPullParserException, IOException {
      VectorDrawableCompat var4 = new VectorDrawableCompat();
      var4.inflate(var0, var1, var2, var3);
      return var4;
   }

   private void a(TypedArray var1, XmlPullParser var2) throws XmlPullParserException {
      VectorDrawableCompat.VectorDrawableCompatState var4 = this.c;
      VectorDrawableCompat.VPathRenderer var3 = var4.b;
      var4.d = a(TypedArrayUtils.a(var1, var2, "tintMode", 6, -1), Mode.SRC_IN);
      ColorStateList var5 = var1.getColorStateList(1);
      if (var5 != null) {
         var4.c = var5;
      }

      var4.e = TypedArrayUtils.a(var1, var2, "autoMirrored", 5, var4.e);
      var3.d = TypedArrayUtils.a(var1, var2, "viewportWidth", 7, var3.d);
      var3.e = TypedArrayUtils.a(var1, var2, "viewportHeight", 8, var3.e);
      if (var3.d <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      }

      if (var3.e <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
      }

      var3.b = var1.getDimension(3, var3.b);
      var3.c = var1.getDimension(2, var3.c);
      if (var3.b <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires width > 0");
      }

      if (var3.c <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires height > 0");
      }

      var3.setAlpha(TypedArrayUtils.a(var1, var2, "alpha", 4, var3.getAlpha()));
      String var6 = var1.getString(0);
      if (var6 != null) {
         var3.g = var6;
         var3.h.put(var6, var3);
      }
   }

   private boolean a() {
      boolean var1 = true;
      if (VERSION.SDK_INT >= 17) {
         if (!this.isAutoMirrored() || DrawableCompat.i(this) != 1) {
            var1 = false;
         }
      } else {
         var1 = false;
      }

      return var1;
   }

   private void b(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      VectorDrawableCompat.VectorDrawableCompatState var12 = this.c;
      VectorDrawableCompat.VPathRenderer var10 = var12.b;
      ArrayDeque var11 = new ArrayDeque();
      var11.push(var10.a);
      int var7 = var2.getEventType();
      int var8 = var2.getDepth();
      boolean var5 = true;

      while (var7 != 1 && (var2.getDepth() >= var8 + 1 || var7 != 3)) {
         boolean var14;
         if (var7 == 2) {
            String var13 = var2.getName();
            VectorDrawableCompat.VGroup var9 = (VectorDrawableCompat.VGroup)var11.peek();
            if ("path".equals(var13)) {
               VectorDrawableCompat.VFullPath var15 = new VectorDrawableCompat.VFullPath();
               var15.a(var1, var3, var4, var2);
               var9.a.add(var15);
               if (var15.getPathName() != null) {
                  var10.h.put(var15.getPathName(), var15);
               }

               var5 = false;
               var14 = var12.a;
               var12.a = var15.o | var14;
            } else if ("clip-path".equals(var13)) {
               VectorDrawableCompat.VClipPath var16 = new VectorDrawableCompat.VClipPath();
               var16.a(var1, var3, var4, var2);
               var9.a.add(var16);
               if (var16.getPathName() != null) {
                  var10.h.put(var16.getPathName(), var16);
               }

               var12.a = var12.a | var16.o;
            } else if ("group".equals(var13)) {
               VectorDrawableCompat.VGroup var17 = new VectorDrawableCompat.VGroup();
               var17.a(var1, var3, var4, var2);
               var9.a.add(var17);
               var11.push(var17);
               if (var17.getGroupName() != null) {
                  var10.h.put(var17.getGroupName(), var17);
               }

               var12.a = var12.a | var17.c;
            }

            var14 = var5;
         } else {
            var14 = var5;
            if (var7 == 3) {
               var14 = var5;
               if ("group".equals(var2.getName())) {
                  var11.pop();
                  var14 = var5;
               }
            }
         }

         var7 = var2.next();
         var5 = (boolean)var14;
      }

      if (var5) {
         throw new XmlPullParserException("no path defined");
      }
   }

   PorterDuffColorFilter a(PorterDuffColorFilter var1, ColorStateList var2, Mode var3) {
      if (var2 != null && var3 != null) {
         var1 = new PorterDuffColorFilter(var2.getColorForState(this.getState(), 0), var3);
      } else {
         var1 = null;
      }

      return var1;
   }

   Object a(String var1) {
      return this.c.b.h.get(var1);
   }

   void a(boolean var1) {
      this.g = var1;
   }

   public boolean canApplyTheme() {
      if (this.b != null) {
         DrawableCompat.d(this.b);
      }

      return false;
   }

   public void draw(Canvas var1) {
      if (this.b != null) {
         this.b.draw(var1);
      } else {
         this.copyBounds(this.k);
         if (this.k.width() > 0 && this.k.height() > 0) {
            Object var9;
            if (this.e == null) {
               var9 = this.d;
            } else {
               var9 = this.e;
            }

            var1.getMatrix(this.j);
            this.j.getValues(this.i);
            float var3 = Math.abs(this.i[0]);
            float var2 = Math.abs(this.i[4]);
            float var5 = Math.abs(this.i[1]);
            float var4 = Math.abs(this.i[3]);
            if (var5 != 0.0F || var4 != 0.0F) {
               var2 = 1.0F;
               var3 = 1.0F;
            }

            int var6 = (int)(var3 * this.k.width());
            int var7 = (int)(var2 * this.k.height());
            var6 = Math.min(2048, var6);
            var7 = Math.min(2048, var7);
            if (var6 > 0 && var7 > 0) {
               int var8 = var1.save();
               var1.translate(this.k.left, this.k.top);
               if (this.a()) {
                  var1.translate(this.k.width(), 0.0F);
                  var1.scale(-1.0F, 1.0F);
               }

               this.k.offsetTo(0, 0);
               this.c.b(var6, var7);
               if (!this.g) {
                  this.c.a(var6, var7);
               } else if (!this.c.b()) {
                  this.c.a(var6, var7);
                  this.c.c();
               }

               this.c.a(var1, (ColorFilter)var9, this.k);
               var1.restoreToCount(var8);
            }
         }
      }
   }

   public int getAlpha() {
      int var1;
      if (this.b != null) {
         var1 = DrawableCompat.c(this.b);
      } else {
         var1 = this.c.b.getRootAlpha();
      }

      return var1;
   }

   public int getChangingConfigurations() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getChangingConfigurations();
      } else {
         var1 = super.getChangingConfigurations() | this.c.getChangingConfigurations();
      }

      return var1;
   }

   public ConstantState getConstantState() {
      Object var1;
      if (this.b != null && VERSION.SDK_INT >= 24) {
         var1 = new VectorDrawableCompat.VectorDrawableDelegateState(this.b.getConstantState());
      } else {
         this.c.a = this.getChangingConfigurations();
         var1 = this.c;
      }

      return (ConstantState)var1;
   }

   public int getIntrinsicHeight() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getIntrinsicHeight();
      } else {
         var1 = (int)this.c.b.c;
      }

      return var1;
   }

   public int getIntrinsicWidth() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getIntrinsicWidth();
      } else {
         var1 = (int)this.c.b.b;
      }

      return var1;
   }

   public int getOpacity() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getOpacity();
      } else {
         var1 = -3;
      }

      return var1;
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3) throws XmlPullParserException, IOException {
      if (this.b != null) {
         this.b.inflate(var1, var2, var3);
      } else {
         this.inflate(var1, var2, var3, null);
      }
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1, var2, var3, var4);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var5 = this.c;
         var5.b = new VectorDrawableCompat.VPathRenderer();
         TypedArray var6 = TypedArrayUtils.a(var1, var4, var3, AndroidResources.a);
         this.a(var6, var2);
         var6.recycle();
         var5.a = this.getChangingConfigurations();
         var5.k = true;
         this.b(var1, var2, var3, var4);
         this.d = this.a(this.d, var5.c, var5.d);
      }
   }

   public void invalidateSelf() {
      if (this.b != null) {
         this.b.invalidateSelf();
      } else {
         super.invalidateSelf();
      }
   }

   public boolean isAutoMirrored() {
      boolean var1;
      if (this.b != null) {
         var1 = DrawableCompat.b(this.b);
      } else {
         var1 = this.c.e;
      }

      return var1;
   }

   public boolean isStateful() {
      boolean var1;
      if (this.b != null) {
         var1 = this.b.isStateful();
      } else if (!super.isStateful() && (this.c == null || this.c.c == null || !this.c.c.isStateful())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public Drawable mutate() {
      if (this.b != null) {
         this.b.mutate();
      } else if (!this.f && super.mutate() == this) {
         this.c = new VectorDrawableCompat.VectorDrawableCompatState(this.c);
         this.f = true;
      }

      return this;
   }

   @Override
   protected void onBoundsChange(Rect var1) {
      if (this.b != null) {
         this.b.setBounds(var1);
      }
   }

   protected boolean onStateChange(int[] var1) {
      boolean var2;
      if (this.b != null) {
         var2 = this.b.setState(var1);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var3 = this.c;
         if (var3.c != null && var3.d != null) {
            this.d = this.a(this.d, var3.c, var3.d);
            this.invalidateSelf();
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public void scheduleSelf(Runnable var1, long var2) {
      if (this.b != null) {
         this.b.scheduleSelf(var1, var2);
      } else {
         super.scheduleSelf(var1, var2);
      }
   }

   public void setAlpha(int var1) {
      if (this.b != null) {
         this.b.setAlpha(var1);
      } else if (this.c.b.getRootAlpha() != var1) {
         this.c.b.setRootAlpha(var1);
         this.invalidateSelf();
      }
   }

   public void setAutoMirrored(boolean var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         this.c.e = var1;
      }
   }

   public void setColorFilter(ColorFilter var1) {
      if (this.b != null) {
         this.b.setColorFilter(var1);
      } else {
         this.e = var1;
         this.invalidateSelf();
      }
   }

   @Override
   public void setTint(int var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         this.setTintList(ColorStateList.valueOf(var1));
      }
   }

   @Override
   public void setTintList(ColorStateList var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var2 = this.c;
         if (var2.c != var1) {
            var2.c = var1;
            this.d = this.a(this.d, var1, var2.d);
            this.invalidateSelf();
         }
      }
   }

   @Override
   public void setTintMode(Mode var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var2 = this.c;
         if (var2.d != var1) {
            var2.d = var1;
            this.d = this.a(this.d, var2.c, var1);
            this.invalidateSelf();
         }
      }
   }

   public boolean setVisible(boolean var1, boolean var2) {
      if (this.b != null) {
         var1 = this.b.setVisible(var1, var2);
      } else {
         var1 = super.setVisible(var1, var2);
      }

      return var1;
   }

   public void unscheduleSelf(Runnable var1) {
      if (this.b != null) {
         this.b.unscheduleSelf(var1);
      } else {
         super.unscheduleSelf(var1);
      }
   }

   private static class VClipPath extends VectorDrawableCompat.VPath {
      public VClipPath() {
      }

      public VClipPath(VectorDrawableCompat.VClipPath var1) {
         super(var1);
      }

      private void a(TypedArray var1) {
         String var2 = var1.getString(0);
         if (var2 != null) {
            this.n = var2;
         }

         String var3 = var1.getString(1);
         if (var3 != null) {
            this.m = PathParser.b(var3);
         }
      }

      public void a(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
         if (TypedArrayUtils.a(var4, "pathData")) {
            TypedArray var5 = TypedArrayUtils.a(var1, var3, var2, AndroidResources.d);
            this.a(var5);
            var5.recycle();
         }
      }

      @Override
      public boolean a() {
         return true;
      }
   }

   private static class VFullPath extends VectorDrawableCompat.VPath {
      int a = 0;
      float b = 0.0F;
      int c = 0;
      float d = 1.0F;
      int e = 0;
      float f = 1.0F;
      float g = 0.0F;
      float h = 1.0F;
      float i = 0.0F;
      Cap j = Cap.BUTT;
      Join k = Join.MITER;
      float l = 4.0F;
      private int[] p;

      public VFullPath() {
      }

      public VFullPath(VectorDrawableCompat.VFullPath var1) {
         super(var1);
         this.p = var1.p;
         this.a = var1.a;
         this.b = var1.b;
         this.d = var1.d;
         this.c = var1.c;
         this.e = var1.e;
         this.f = var1.f;
         this.g = var1.g;
         this.h = var1.h;
         this.i = var1.i;
         this.j = var1.j;
         this.k = var1.k;
         this.l = var1.l;
      }

      private Cap a(int var1, Cap var2) {
         switch (var1) {
            case 0:
               var2 = Cap.BUTT;
               break;
            case 1:
               var2 = Cap.ROUND;
               break;
            case 2:
               var2 = Cap.SQUARE;
         }

         return var2;
      }

      private Join a(int var1, Join var2) {
         switch (var1) {
            case 0:
               var2 = Join.MITER;
               break;
            case 1:
               var2 = Join.ROUND;
               break;
            case 2:
               var2 = Join.BEVEL;
         }

         return var2;
      }

      private void a(TypedArray var1, XmlPullParser var2) {
         this.p = null;
         if (TypedArrayUtils.a(var2, "pathData")) {
            String var3 = var1.getString(0);
            if (var3 != null) {
               this.n = var3;
            }

            var3 = var1.getString(2);
            if (var3 != null) {
               this.m = PathParser.b(var3);
            }

            this.c = TypedArrayUtils.b(var1, var2, "fillColor", 1, this.c);
            this.f = TypedArrayUtils.a(var1, var2, "fillAlpha", 12, this.f);
            this.j = this.a(TypedArrayUtils.a(var1, var2, "strokeLineCap", 8, -1), this.j);
            this.k = this.a(TypedArrayUtils.a(var1, var2, "strokeLineJoin", 9, -1), this.k);
            this.l = TypedArrayUtils.a(var1, var2, "strokeMiterLimit", 10, this.l);
            this.a = TypedArrayUtils.b(var1, var2, "strokeColor", 3, this.a);
            this.d = TypedArrayUtils.a(var1, var2, "strokeAlpha", 11, this.d);
            this.b = TypedArrayUtils.a(var1, var2, "strokeWidth", 4, this.b);
            this.h = TypedArrayUtils.a(var1, var2, "trimPathEnd", 6, this.h);
            this.i = TypedArrayUtils.a(var1, var2, "trimPathOffset", 7, this.i);
            this.g = TypedArrayUtils.a(var1, var2, "trimPathStart", 5, this.g);
            this.e = TypedArrayUtils.a(var1, var2, "fillType", 13, this.e);
         }
      }

      public void a(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
         TypedArray var5 = TypedArrayUtils.a(var1, var3, var2, AndroidResources.c);
         this.a(var5, var4);
         var5.recycle();
      }

      float getFillAlpha() {
         return this.f;
      }

      int getFillColor() {
         return this.c;
      }

      float getStrokeAlpha() {
         return this.d;
      }

      int getStrokeColor() {
         return this.a;
      }

      float getStrokeWidth() {
         return this.b;
      }

      float getTrimPathEnd() {
         return this.h;
      }

      float getTrimPathOffset() {
         return this.i;
      }

      float getTrimPathStart() {
         return this.g;
      }

      void setFillAlpha(float var1) {
         this.f = var1;
      }

      void setFillColor(int var1) {
         this.c = var1;
      }

      void setStrokeAlpha(float var1) {
         this.d = var1;
      }

      void setStrokeColor(int var1) {
         this.a = var1;
      }

      void setStrokeWidth(float var1) {
         this.b = var1;
      }

      void setTrimPathEnd(float var1) {
         this.h = var1;
      }

      void setTrimPathOffset(float var1) {
         this.i = var1;
      }

      void setTrimPathStart(float var1) {
         this.g = var1;
      }
   }

   private static class VGroup {
      final ArrayList<Object> a;
      float b;
      int c;
      private final Matrix d = new Matrix();
      private float e;
      private float f;
      private float g;
      private float h;
      private float i;
      private float j;
      private final Matrix k;
      private int[] l;
      private String m;

      public VGroup() {
         this.a = new ArrayList<>();
         this.b = 0.0F;
         this.e = 0.0F;
         this.f = 0.0F;
         this.g = 1.0F;
         this.h = 1.0F;
         this.i = 0.0F;
         this.j = 0.0F;
         this.k = new Matrix();
         this.m = null;
      }

      public VGroup(VectorDrawableCompat.VGroup var1, ArrayMap<String, Object> var2) {
         this.a = new ArrayList<>();
         this.b = 0.0F;
         this.e = 0.0F;
         this.f = 0.0F;
         this.g = 1.0F;
         this.h = 1.0F;
         this.i = 0.0F;
         this.j = 0.0F;
         this.k = new Matrix();
         this.m = null;
         this.b = var1.b;
         this.e = var1.e;
         this.f = var1.f;
         this.g = var1.g;
         this.h = var1.h;
         this.i = var1.i;
         this.j = var1.j;
         this.l = var1.l;
         this.m = var1.m;
         this.c = var1.c;
         if (this.m != null) {
            var2.put(this.m, this);
         }

         this.k.set(var1.k);
         ArrayList var4 = var1.a;

         for (int var3 = 0; var3 < var4.size(); var3++) {
            Object var5 = var4.get(var3);
            if (var5 instanceof VectorDrawableCompat.VGroup) {
               VectorDrawableCompat.VGroup var6 = (VectorDrawableCompat.VGroup)var5;
               this.a.add(new VectorDrawableCompat.VGroup(var6, var2));
            } else {
               VectorDrawableCompat.VPath var7;
               if (var5 instanceof VectorDrawableCompat.VFullPath) {
                  var7 = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)var5);
               } else {
                  if (!(var5 instanceof VectorDrawableCompat.VClipPath)) {
                     throw new IllegalStateException("Unknown object in the tree!");
                  }

                  var7 = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)var5);
               }

               this.a.add(var7);
               if (var7.n != null) {
                  var2.put(var7.n, var7);
               }
            }
         }
      }

      private void a() {
         this.k.reset();
         this.k.postTranslate(-this.e, -this.f);
         this.k.postScale(this.g, this.h);
         this.k.postRotate(this.b, 0.0F, 0.0F);
         this.k.postTranslate(this.i + this.e, this.j + this.f);
      }

      private void a(TypedArray var1, XmlPullParser var2) {
         this.l = null;
         this.b = TypedArrayUtils.a(var1, var2, "rotation", 5, this.b);
         this.e = var1.getFloat(1, this.e);
         this.f = var1.getFloat(2, this.f);
         this.g = TypedArrayUtils.a(var1, var2, "scaleX", 3, this.g);
         this.h = TypedArrayUtils.a(var1, var2, "scaleY", 4, this.h);
         this.i = TypedArrayUtils.a(var1, var2, "translateX", 6, this.i);
         this.j = TypedArrayUtils.a(var1, var2, "translateY", 7, this.j);
         String var3 = var1.getString(0);
         if (var3 != null) {
            this.m = var3;
         }

         this.a();
      }

      public void a(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
         TypedArray var5 = TypedArrayUtils.a(var1, var3, var2, AndroidResources.b);
         this.a(var5, var4);
         var5.recycle();
      }

      public String getGroupName() {
         return this.m;
      }

      public Matrix getLocalMatrix() {
         return this.k;
      }

      public float getPivotX() {
         return this.e;
      }

      public float getPivotY() {
         return this.f;
      }

      public float getRotation() {
         return this.b;
      }

      public float getScaleX() {
         return this.g;
      }

      public float getScaleY() {
         return this.h;
      }

      public float getTranslateX() {
         return this.i;
      }

      public float getTranslateY() {
         return this.j;
      }

      public void setPivotX(float var1) {
         if (var1 != this.e) {
            this.e = var1;
            this.a();
         }
      }

      public void setPivotY(float var1) {
         if (var1 != this.f) {
            this.f = var1;
            this.a();
         }
      }

      public void setRotation(float var1) {
         if (var1 != this.b) {
            this.b = var1;
            this.a();
         }
      }

      public void setScaleX(float var1) {
         if (var1 != this.g) {
            this.g = var1;
            this.a();
         }
      }

      public void setScaleY(float var1) {
         if (var1 != this.h) {
            this.h = var1;
            this.a();
         }
      }

      public void setTranslateX(float var1) {
         if (var1 != this.i) {
            this.i = var1;
            this.a();
         }
      }

      public void setTranslateY(float var1) {
         if (var1 != this.j) {
            this.j = var1;
            this.a();
         }
      }
   }

   private static class VPath {
      protected PathParser.PathDataNode[] m = null;
      String n;
      int o;

      public VPath() {
      }

      public VPath(VectorDrawableCompat.VPath var1) {
         this.n = var1.n;
         this.o = var1.o;
         this.m = PathParser.a(var1.m);
      }

      public void a(Path var1) {
         var1.reset();
         if (this.m != null) {
            PathParser.PathDataNode.a(this.m, var1);
         }
      }

      public boolean a() {
         return false;
      }

      public PathParser.PathDataNode[] getPathData() {
         return this.m;
      }

      public String getPathName() {
         return this.n;
      }

      public void setPathData(PathParser.PathDataNode[] var1) {
         if (!PathParser.a(this.m, var1)) {
            this.m = PathParser.a(var1);
         } else {
            PathParser.b(this.m, var1);
         }
      }
   }

   private static class VPathRenderer {
      private static final Matrix k = new Matrix();
      final VectorDrawableCompat.VGroup a;
      float b;
      float c;
      float d;
      float e;
      int f;
      String g;
      final ArrayMap<String, Object> h;
      private final Path i;
      private final Path j;
      private final Matrix l = new Matrix();
      private Paint m;
      private Paint n;
      private PathMeasure o;
      private int p;

      public VPathRenderer() {
         this.b = 0.0F;
         this.c = 0.0F;
         this.d = 0.0F;
         this.e = 0.0F;
         this.f = 255;
         this.g = null;
         this.h = new ArrayMap<>();
         this.a = new VectorDrawableCompat.VGroup();
         this.i = new Path();
         this.j = new Path();
      }

      public VPathRenderer(VectorDrawableCompat.VPathRenderer var1) {
         this.b = 0.0F;
         this.c = 0.0F;
         this.d = 0.0F;
         this.e = 0.0F;
         this.f = 255;
         this.g = null;
         this.h = new ArrayMap<>();
         this.a = new VectorDrawableCompat.VGroup(var1.a, this.h);
         this.i = new Path(var1.i);
         this.j = new Path(var1.j);
         this.b = var1.b;
         this.c = var1.c;
         this.d = var1.d;
         this.e = var1.e;
         this.p = var1.p;
         this.f = var1.f;
         this.g = var1.g;
         if (var1.g != null) {
            this.h.put(var1.g, this);
         }
      }

      private static float a(float var0, float var1, float var2, float var3) {
         return var0 * var3 - var1 * var2;
      }

      private float a(Matrix var1) {
         float var2 = 0.0F;
         float[] var6 = new float[]{0.0F, 1.0F, 1.0F, 0.0F};
         var1.mapVectors(var6);
         float var4 = (float)Math.hypot(var6[0], var6[1]);
         float var5 = (float)Math.hypot(var6[2], var6[3]);
         float var3 = a(var6[0], var6[1], var6[2], var6[3]);
         var4 = Math.max(var4, var5);
         if (var4 > 0.0F) {
            var2 = Math.abs(var3) / var4;
         }

         return var2;
      }

      private void a(VectorDrawableCompat.VGroup var1, Matrix var2, Canvas var3, int var4, int var5, ColorFilter var6) {
         var1.d.set(var2);
         var1.d.preConcat(var1.k);
         var3.save();

         for (int var7 = 0; var7 < var1.a.size(); var7++) {
            Object var8 = var1.a.get(var7);
            if (var8 instanceof VectorDrawableCompat.VGroup) {
               this.a((VectorDrawableCompat.VGroup)var8, var1.d, var3, var4, var5, var6);
            } else if (var8 instanceof VectorDrawableCompat.VPath) {
               this.a(var1, (VectorDrawableCompat.VPath)var8, var3, var4, var5, var6);
            }
         }

         var3.restore();
      }

      private void a(VectorDrawableCompat.VGroup var1, VectorDrawableCompat.VPath var2, Canvas var3, int var4, int var5, ColorFilter var6) {
         float var9 = var4 / this.d;
         float var8 = var5 / this.e;
         float var7 = Math.min(var9, var8);
         Matrix var16 = var1.d;
         this.l.set(var16);
         this.l.postScale(var9, var8);
         var8 = this.a(var16);
         if (var8 != 0.0F) {
            var2.a(this.i);
            Path var17 = this.i;
            this.j.reset();
            if (var2.a()) {
               this.j.addPath(var17, this.l);
               var3.clipPath(this.j);
            } else {
               var2 = var2;
               if (var2.g != 0.0F || var2.h != 1.0F) {
                  float var13 = var2.g;
                  float var12 = var2.i;
                  float var11 = var2.h;
                  float var10 = var2.i;
                  if (this.o == null) {
                     this.o = new PathMeasure();
                  }

                  this.o.setPath(this.i, false);
                  var9 = this.o.getLength();
                  var12 = (var13 + var12) % 1.0F * var9;
                  var10 = (var11 + var10) % 1.0F * var9;
                  var17.reset();
                  if (var12 > var10) {
                     this.o.getSegment(var12, var9, var17, true);
                     this.o.getSegment(0.0F, var10, var17, true);
                  } else {
                     this.o.getSegment(var12, var10, var17, true);
                  }

                  var17.rLineTo(0.0F, 0.0F);
               }

               this.j.addPath(var17, this.l);
               if (var2.c != 0) {
                  if (this.n == null) {
                     this.n = new Paint();
                     this.n.setStyle(Style.FILL);
                     this.n.setAntiAlias(true);
                  }

                  Paint var15 = this.n;
                  var15.setColor(VectorDrawableCompat.a(var2.c, var2.f));
                  var15.setColorFilter(var6);
                  Path var14 = this.j;
                  FillType var18;
                  if (var2.e == 0) {
                     var18 = FillType.WINDING;
                  } else {
                     var18 = FillType.EVEN_ODD;
                  }

                  var14.setFillType(var18);
                  var3.drawPath(this.j, var15);
               }

               if (var2.a != 0) {
                  if (this.m == null) {
                     this.m = new Paint();
                     this.m.setStyle(Style.STROKE);
                     this.m.setAntiAlias(true);
                  }

                  Paint var19 = this.m;
                  if (var2.k != null) {
                     var19.setStrokeJoin(var2.k);
                  }

                  if (var2.j != null) {
                     var19.setStrokeCap(var2.j);
                  }

                  var19.setStrokeMiter(var2.l);
                  var19.setColor(VectorDrawableCompat.a(var2.a, var2.d));
                  var19.setColorFilter(var6);
                  var19.setStrokeWidth(var8 * var7 * var2.b);
                  var3.drawPath(this.j, var19);
               }
            }
         }
      }

      public void a(Canvas var1, int var2, int var3, ColorFilter var4) {
         this.a(this.a, k, var1, var2, var3, var4);
      }

      public float getAlpha() {
         return this.getRootAlpha() / 255.0F;
      }

      public int getRootAlpha() {
         return this.f;
      }

      public void setAlpha(float var1) {
         this.setRootAlpha((int)(255.0F * var1));
      }

      public void setRootAlpha(int var1) {
         this.f = var1;
      }
   }

   private static class VectorDrawableCompatState extends ConstantState {
      int a;
      VectorDrawableCompat.VPathRenderer b;
      ColorStateList c = null;
      Mode d = VectorDrawableCompat.a;
      boolean e;
      Bitmap f;
      ColorStateList g;
      Mode h;
      int i;
      boolean j;
      boolean k;
      Paint l;

      public VectorDrawableCompatState() {
         this.b = new VectorDrawableCompat.VPathRenderer();
      }

      public VectorDrawableCompatState(VectorDrawableCompat.VectorDrawableCompatState var1) {
         if (var1 != null) {
            this.a = var1.a;
            this.b = new VectorDrawableCompat.VPathRenderer(var1.b);
            if (var1.b.n != null) {
               this.b.n = new Paint(var1.b.n);
            }

            if (var1.b.m != null) {
               this.b.m = new Paint(var1.b.m);
            }

            this.c = var1.c;
            this.d = var1.d;
            this.e = var1.e;
         }
      }

      public Paint a(ColorFilter var1) {
         Paint var2;
         if (!this.a() && var1 == null) {
            var2 = null;
         } else {
            if (this.l == null) {
               this.l = new Paint();
               this.l.setFilterBitmap(true);
            }

            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(var1);
            var2 = this.l;
         }

         return var2;
      }

      public void a(int var1, int var2) {
         this.f.eraseColor(0);
         Canvas var3 = new Canvas(this.f);
         this.b.a(var3, var1, var2, null);
      }

      public void a(Canvas var1, ColorFilter var2, Rect var3) {
         Paint var4 = this.a(var2);
         var1.drawBitmap(this.f, null, var3, var4);
      }

      public boolean a() {
         boolean var1;
         if (this.b.getRootAlpha() < 255) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public void b(int var1, int var2) {
         if (this.f == null || !this.c(var1, var2)) {
            this.f = Bitmap.createBitmap(var1, var2, Config.ARGB_8888);
            this.k = true;
         }
      }

      public boolean b() {
         boolean var1;
         if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public void c() {
         this.g = this.c;
         this.h = this.d;
         this.i = this.b.getRootAlpha();
         this.j = this.e;
         this.k = false;
      }

      public boolean c(int var1, int var2) {
         boolean var3;
         if (var1 == this.f.getWidth() && var2 == this.f.getHeight()) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      public int getChangingConfigurations() {
         return this.a;
      }

      public Drawable newDrawable() {
         return new VectorDrawableCompat(this);
      }

      public Drawable newDrawable(Resources var1) {
         return new VectorDrawableCompat(this);
      }
   }

   private static class VectorDrawableDelegateState extends ConstantState {
      private final ConstantState a;

      public VectorDrawableDelegateState(ConstantState var1) {
         this.a = var1;
      }

      public boolean canApplyTheme() {
         return this.a.canApplyTheme();
      }

      public int getChangingConfigurations() {
         return this.a.getChangingConfigurations();
      }

      public Drawable newDrawable() {
         VectorDrawableCompat var1 = new VectorDrawableCompat();
         var1.b = (VectorDrawable)this.a.newDrawable();
         return var1;
      }

      public Drawable newDrawable(Resources var1) {
         VectorDrawableCompat var2 = new VectorDrawableCompat();
         var2.b = (VectorDrawable)this.a.newDrawable(var1);
         return var2;
      }

      public Drawable newDrawable(Resources var1, Theme var2) {
         VectorDrawableCompat var3 = new VectorDrawableCompat();
         var3.b = (VectorDrawable)this.a.newDrawable(var1, var2);
         return var3;
      }
   }
}
