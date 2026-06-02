package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: a */
    private static final float f1096a = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: b */
    private float f1097b;

    /* JADX INFO: renamed from: c */
    private float f1098c;

    /* JADX INFO: renamed from: d */
    private float f1099d;

    /* JADX INFO: renamed from: e */
    private float f1100e;

    /* JADX INFO: renamed from: f */
    private float f1101f;

    /* JADX INFO: renamed from: g */
    private float f1102g;

    public ArcMotion() {
        this.f1097b = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1098c = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1099d = 70.0f;
        this.f1100e = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1101f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1102g = f1096a;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1097b = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1098c = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1099d = 70.0f;
        this.f1100e = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1101f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f1102g = f1096a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1260j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        m1069b(TypedArrayUtils.m1924a(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, CropImageView.DEFAULT_ASPECT_RATIO));
        m1068a(TypedArrayUtils.m1924a(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, CropImageView.DEFAULT_ASPECT_RATIO));
        m1070c(TypedArrayUtils.m1924a(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public void m1068a(float f) {
        this.f1097b = f;
        this.f1100e = m1066d(f);
    }

    /* JADX INFO: renamed from: b */
    public void m1069b(float f) {
        this.f1098c = f;
        this.f1101f = m1066d(f);
    }

    /* JADX INFO: renamed from: c */
    public void m1070c(float f) {
        this.f1099d = f;
        this.f1102g = m1066d(f);
    }

    /* JADX INFO: renamed from: d */
    private static float m1066d(float f) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    @Override // android.support.transition.PathMotion
    /* JADX INFO: renamed from: a */
    public Path mo1067a(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        Path path = new Path();
        path.moveTo(f, f2);
        float f13 = f3 - f;
        float f14 = f4 - f2;
        float f15 = (f14 * f14) + (f13 * f13);
        float f16 = (f + f3) / 2.0f;
        float f17 = (f2 + f4) / 2.0f;
        float f18 = f15 * 0.25f;
        boolean z = f2 > f4;
        if (Math.abs(f13) < Math.abs(f14)) {
            float fAbs = Math.abs(f15 / (2.0f * f14));
            if (z) {
                f11 = f4 + fAbs;
                f12 = f3;
            } else {
                f11 = f2 + fAbs;
                f12 = f;
            }
            f7 = f12;
            f8 = f11;
            f9 = this.f1101f * f18 * this.f1101f;
        } else {
            float f19 = f15 / (f13 * 2.0f);
            if (z) {
                f5 = f + f19;
                f6 = f2;
            } else {
                f5 = f3 - f19;
                f6 = f4;
            }
            f7 = f5;
            f8 = f6;
            f9 = this.f1100e * f18 * this.f1100e;
        }
        float f20 = f16 - f7;
        float f21 = f17 - f8;
        float f22 = (f21 * f21) + (f20 * f20);
        float f23 = this.f1102g * f18 * this.f1102g;
        if (f22 >= f9) {
            f9 = f22 > f23 ? f23 : 0.0f;
        }
        if (f9 != CropImageView.DEFAULT_ASPECT_RATIO) {
            float fSqrt = (float) Math.sqrt(f9 / f22);
            f7 = ((f7 - f16) * fSqrt) + f16;
            f10 = f17 + (fSqrt * (f8 - f17));
        } else {
            f10 = f8;
        }
        path.cubicTo((f + f7) / 2.0f, (f2 + f10) / 2.0f, (f7 + f3) / 2.0f, (f10 + f4) / 2.0f, f3, f4);
        return path;
    }
}
