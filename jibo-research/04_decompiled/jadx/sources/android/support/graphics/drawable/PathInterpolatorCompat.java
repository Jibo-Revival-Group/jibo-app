package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;
import org.apache.http.protocol.HttpRequestExecutor;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {

    /* JADX INFO: renamed from: a */
    private float[] f1007a;

    /* JADX INFO: renamed from: b */
    private float[] f1008b;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f991l);
        m983a(typedArrayM1926a, xmlPullParser);
        typedArrayM1926a.recycle();
    }

    /* JADX INFO: renamed from: a */
    private void m983a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.m1929a(xmlPullParser, "pathData")) {
            String strM1927a = TypedArrayUtils.m1927a(typedArray, xmlPullParser, "pathData", 4);
            Path pathM1938a = PathParser.m1938a(strM1927a);
            if (pathM1938a == null) {
                throw new InflateException("The path is null, which is created from " + strM1927a);
            }
            m984a(pathM1938a);
            return;
        }
        if (!TypedArrayUtils.m1929a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.m1929a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fM1924a = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "controlX1", 0, CropImageView.DEFAULT_ASPECT_RATIO);
        float fM1924a2 = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "controlY1", 1, CropImageView.DEFAULT_ASPECT_RATIO);
        boolean zM1929a = TypedArrayUtils.m1929a(xmlPullParser, "controlX2");
        if (zM1929a != TypedArrayUtils.m1929a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (!zM1929a) {
            m981a(fM1924a, fM1924a2);
        } else {
            m982a(fM1924a, fM1924a2, TypedArrayUtils.m1924a(typedArray, xmlPullParser, "controlX2", 2, CropImageView.DEFAULT_ASPECT_RATIO), TypedArrayUtils.m1924a(typedArray, xmlPullParser, "controlY2", 3, CropImageView.DEFAULT_ASPECT_RATIO));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m981a(float f, float f2) {
        Path path = new Path();
        path.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        path.quadTo(f, f2, 1.0f, 1.0f);
        m984a(path);
    }

    /* JADX INFO: renamed from: a */
    private void m982a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        m984a(path);
    }

    /* JADX INFO: renamed from: a */
    private void m984a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f1007a = new float[iMin];
        this.f1008b = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.f1007a[i2] = fArr[0];
            this.f1008b[i2] = fArr[1];
        }
        if (Math.abs(this.f1007a[0]) > 1.0E-5d || Math.abs(this.f1008b[0]) > 1.0E-5d || Math.abs(this.f1007a[iMin - 1] - 1.0f) > 1.0E-5d || Math.abs(this.f1008b[iMin - 1] - 1.0f) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.f1007a[0] + "," + this.f1008b[0] + " end:" + this.f1007a[iMin - 1] + "," + this.f1008b[iMin - 1]);
        }
        float f = 0.0f;
        int i3 = 0;
        while (i < iMin) {
            int i4 = i3 + 1;
            float f2 = this.f1007a[i3];
            if (f2 < f) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
            }
            this.f1007a[i] = f2;
            i++;
            f = f2;
            i3 = i4;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        int i;
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f1007a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f < this.f1007a[i3]) {
                i = i2;
            } else {
                int i4 = length;
                i = i3;
                i3 = i4;
            }
            i2 = i;
            length = i3;
        }
        float f2 = this.f1007a[length] - this.f1007a[i2];
        if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return this.f1008b[i2];
        }
        float f3 = (f - this.f1007a[i2]) / f2;
        float f4 = this.f1008b[i2];
        return (f3 * (this.f1008b[length] - f4)) + f4;
    }
}
