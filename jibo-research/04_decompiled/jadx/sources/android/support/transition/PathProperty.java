package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class PathProperty<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a */
    private final Property<T, PointF> f1226a;

    /* JADX INFO: renamed from: b */
    private final PathMeasure f1227b;

    /* JADX INFO: renamed from: c */
    private final float f1228c;

    /* JADX INFO: renamed from: d */
    private final float[] f1229d;

    /* JADX INFO: renamed from: e */
    private final PointF f1230e;

    /* JADX INFO: renamed from: f */
    private float f1231f;

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1229d = new float[2];
        this.f1230e = new PointF();
        this.f1226a = property;
        this.f1227b = new PathMeasure(path, false);
        this.f1228c = this.f1227b.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f1231f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.f1231f = f.floatValue();
        this.f1227b.getPosTan(this.f1228c * f.floatValue(), this.f1229d, null);
        this.f1230e.x = this.f1229d[0];
        this.f1230e.y = this.f1229d[1];
        this.f1226a.set(t, this.f1230e);
    }
}
