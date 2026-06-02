package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: a */
    private Path f1232a;

    /* JADX INFO: renamed from: b */
    private final Path f1233b = new Path();

    /* JADX INFO: renamed from: c */
    private final Matrix f1234c = new Matrix();

    public PatternPathMotion() {
        this.f1233b.lineTo(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f1232a = this.f1233b;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1261k);
        try {
            String strM1927a = TypedArrayUtils.m1927a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strM1927a == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            m1183a(PathParser.m1938a(strM1927a));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1183a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(CropImageView.DEFAULT_ASPECT_RATIO, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f1234c.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fM1182a = 1.0f / m1182a(f5, f6);
        this.f1234c.postScale(fM1182a, fM1182a);
        this.f1234c.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.f1234c, this.f1233b);
        this.f1232a = path;
    }

    @Override // android.support.transition.PathMotion
    /* JADX INFO: renamed from: a */
    public Path mo1067a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float fM1182a = m1182a(f5, f6);
        double dAtan2 = Math.atan2(f6, f5);
        this.f1234c.setScale(fM1182a, fM1182a);
        this.f1234c.postRotate((float) Math.toDegrees(dAtan2));
        this.f1234c.postTranslate(f, f2);
        Path path = new Path();
        this.f1233b.transform(this.f1234c, path);
        return path;
    }

    /* JADX INFO: renamed from: a */
    private static float m1182a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
