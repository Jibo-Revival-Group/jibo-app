package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.appcompat.R;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class TooltipPopup {

    /* JADX INFO: renamed from: a */
    private final Context f4479a;

    /* JADX INFO: renamed from: b */
    private final View f4480b;

    /* JADX INFO: renamed from: c */
    private final TextView f4481c;

    /* JADX INFO: renamed from: d */
    private final WindowManager.LayoutParams f4482d = new WindowManager.LayoutParams();

    /* JADX INFO: renamed from: e */
    private final Rect f4483e = new Rect();

    /* JADX INFO: renamed from: f */
    private final int[] f4484f = new int[2];

    /* JADX INFO: renamed from: g */
    private final int[] f4485g = new int[2];

    TooltipPopup(Context context) {
        this.f4479a = context;
        this.f4480b = LayoutInflater.from(this.f4479a).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f4481c = (TextView) this.f4480b.findViewById(R.id.message);
        this.f4482d.setTitle(getClass().getSimpleName());
        this.f4482d.packageName = this.f4479a.getPackageName();
        this.f4482d.type = 1002;
        this.f4482d.width = -2;
        this.f4482d.height = -2;
        this.f4482d.format = -3;
        this.f4482d.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.f4482d.flags = 24;
    }

    /* JADX INFO: renamed from: a */
    void m4997a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m4998b()) {
            m4996a();
        }
        this.f4481c.setText(charSequence);
        m4995a(view, i, i2, z, this.f4482d);
        ((WindowManager) this.f4479a.getSystemService("window")).addView(this.f4480b, this.f4482d);
    }

    /* JADX INFO: renamed from: a */
    void m4996a() {
        if (m4998b()) {
            ((WindowManager) this.f4479a.getSystemService("window")).removeView(this.f4480b);
        }
    }

    /* JADX INFO: renamed from: b */
    boolean m4998b() {
        return this.f4480b.getParent() != null;
    }

    /* JADX INFO: renamed from: a */
    private void m4995a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f4479a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f4479a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f4479a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View viewM4994a = m4994a(view);
        if (viewM4994a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewM4994a.getWindowVisibleDisplayFrame(this.f4483e);
        if (this.f4483e.left < 0 && this.f4483e.top < 0) {
            Resources resources = this.f4479a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f4483e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewM4994a.getLocationOnScreen(this.f4485g);
        view.getLocationOnScreen(this.f4484f);
        int[] iArr = this.f4484f;
        iArr[0] = iArr[0] - this.f4485g[0];
        int[] iArr2 = this.f4484f;
        iArr2[1] = iArr2[1] - this.f4485g[1];
        layoutParams.x = (this.f4484f[0] + i) - (viewM4994a.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f4480b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f4480b.getMeasuredHeight();
        int i4 = ((i3 + this.f4484f[1]) - dimensionPixelOffset3) - measuredHeight;
        int i5 = height + this.f4484f[1] + dimensionPixelOffset3;
        if (z) {
            if (i4 >= 0) {
                layoutParams.y = i4;
                return;
            } else {
                layoutParams.y = i5;
                return;
            }
        }
        if (measuredHeight + i5 <= this.f4483e.height()) {
            layoutParams.y = i5;
        } else {
            layoutParams.y = i4;
        }
    }

    /* JADX INFO: renamed from: a */
    private static View m4994a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
