package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T> extends Property<T, Float> {
   private final Property<T, PointF> a;
   private final PathMeasure b;
   private final float c;
   private final float[] d = new float[2];
   private final PointF e = new PointF();
   private float f;

   PathProperty(Property<T, PointF> var1, Path var2) {
      super(Float.class, var1.getName());
      this.a = var1;
      this.b = new PathMeasure(var2, false);
      this.c = this.b.getLength();
   }

   public Float a(T var1) {
      return this.f;
   }

   public void a(T var1, Float var2) {
      this.f = var2;
      this.b.getPosTan(this.c * var2, this.d, null);
      this.e.x = this.d[0];
      this.e.y = this.d[1];
      this.a.set(var1, this.e);
   }
}
