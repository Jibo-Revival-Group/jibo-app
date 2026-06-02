package android.support.v4.view.animation;

import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a */
    private final float[] f2486a;

    /* JADX INFO: renamed from: b */
    private final float f2487b;

    protected LookupTableInterpolator(float[] fArr) {
        this.f2486a = fArr;
        this.f2487b = 1.0f / (this.f2486a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int iMin = Math.min((int) ((this.f2486a.length - 1) * f), this.f2486a.length - 2);
        return ((this.f2486a[iMin + 1] - this.f2486a[iMin]) * ((f - (iMin * this.f2487b)) / this.f2487b)) + this.f2486a[iMin];
    }
}
