package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {

    /* JADX INFO: renamed from: c */
    protected PointF f3998c;

    /* JADX INFO: renamed from: f */
    private final float f4001f;

    /* JADX INFO: renamed from: a */
    protected final LinearInterpolator f3996a = new LinearInterpolator();

    /* JADX INFO: renamed from: b */
    protected final DecelerateInterpolator f3997b = new DecelerateInterpolator();

    /* JADX INFO: renamed from: d */
    protected int f3999d = 0;

    /* JADX INFO: renamed from: e */
    protected int f4000e = 0;

    public LinearSmoothScroller(Context context) {
        this.f4001f = m4344a(context.getResources().getDisplayMetrics());
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    /* JADX INFO: renamed from: a */
    protected void mo4348a() {
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    /* JADX INFO: renamed from: a */
    protected void mo4351a(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int iM4353b = m4353b(view, m4355c());
        int iM4347a = m4347a(view, m4357d());
        int iM4345a = m4345a((int) Math.sqrt((iM4353b * iM4353b) + (iM4347a * iM4347a)));
        if (iM4345a > 0) {
            action.m4652a(-iM4353b, -iM4347a, iM4345a, this.f3997b);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    /* JADX INFO: renamed from: a */
    protected void mo4349a(int i, int i2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (m4649j() == 0) {
            m4645f();
            return;
        }
        this.f3999d = m4343a(this.f3999d, i);
        this.f4000e = m4343a(this.f4000e, i2);
        if (this.f3999d == 0 && this.f4000e == 0) {
            m4350a(action);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    /* JADX INFO: renamed from: b */
    protected void mo4354b() {
        this.f4000e = 0;
        this.f3999d = 0;
        this.f3998c = null;
    }

    /* JADX INFO: renamed from: a */
    protected float m4344a(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: renamed from: a */
    protected int m4345a(int i) {
        return (int) Math.ceil(((double) m4352b(i)) / 0.3356d);
    }

    /* JADX INFO: renamed from: b */
    protected int m4352b(int i) {
        return (int) Math.ceil(Math.abs(i) * this.f4001f);
    }

    /* JADX INFO: renamed from: c */
    protected int m4355c() {
        if (this.f3998c == null || this.f3998c.x == CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0;
        }
        return this.f3998c.x > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : -1;
    }

    /* JADX INFO: renamed from: d */
    protected int m4357d() {
        if (this.f3998c == null || this.f3998c.y == CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0;
        }
        return this.f3998c.y > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : -1;
    }

    /* JADX INFO: renamed from: a */
    protected void m4350a(RecyclerView.SmoothScroller.Action action) {
        PointF pointFM4356c = m4356c(m4648i());
        if (pointFM4356c == null || (pointFM4356c.x == CropImageView.DEFAULT_ASPECT_RATIO && pointFM4356c.y == CropImageView.DEFAULT_ASPECT_RATIO)) {
            action.m4651a(m4648i());
            m4645f();
            return;
        }
        m4639a(pointFM4356c);
        this.f3998c = pointFM4356c;
        this.f3999d = (int) (pointFM4356c.x * 10000.0f);
        this.f4000e = (int) (pointFM4356c.y * 10000.0f);
        action.m4652a((int) (this.f3999d * 1.2f), (int) (this.f4000e * 1.2f), (int) (m4352b(10000) * 1.2f), this.f3996a);
    }

    /* JADX INFO: renamed from: a */
    private int m4343a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    public int m4346a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 <= 0) {
                    int i7 = i4 - i2;
                    if (i7 >= 0) {
                        return 0;
                    }
                    return i7;
                }
                return i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    /* JADX INFO: renamed from: a */
    public int m4347a(View view, int i) {
        RecyclerView.LayoutManager layoutManagerE = m4643e();
        if (layoutManagerE == null || !layoutManagerE.mo4316f()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return m4346a(layoutManagerE.m4543i(view) - layoutParams.topMargin, layoutManagerE.m4547k(view) + layoutParams.bottomMargin, layoutManagerE.m4475B(), layoutManagerE.m4565z() - layoutManagerE.m4477D(), i);
    }

    /* JADX INFO: renamed from: b */
    public int m4353b(View view, int i) {
        RecyclerView.LayoutManager layoutManagerE = m4643e();
        if (layoutManagerE == null || !layoutManagerE.mo4313e()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return m4346a(layoutManagerE.m4541h(view) - layoutParams.leftMargin, layoutManagerE.m4545j(view) + layoutParams.rightMargin, layoutManagerE.m4474A(), layoutManagerE.m4564y() - layoutManagerE.m4476C(), i);
    }

    /* JADX INFO: renamed from: c */
    public PointF m4356c(int i) {
        Object objE = m4643e();
        if (objE instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return ((RecyclerView.SmoothScroller.ScrollVectorProvider) objE).mo4309d(i);
        }
        Log.w("LinearSmoothScroller", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + RecyclerView.SmoothScroller.ScrollVectorProvider.class.getCanonicalName());
        return null;
    }
}
