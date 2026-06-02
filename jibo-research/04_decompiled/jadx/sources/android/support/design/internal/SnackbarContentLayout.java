package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements BaseTransientBottomBar.ContentViewCallback {

    /* JADX INFO: renamed from: a */
    private TextView f464a;

    /* JADX INFO: renamed from: b */
    private Button f465b;

    /* JADX INFO: renamed from: c */
    private int f466c;

    /* JADX INFO: renamed from: d */
    private int f467d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.f466c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f467d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f464a = (TextView) findViewById(R.id.snackbar_text);
        this.f465b = (Button) findViewById(R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f464a;
    }

    public Button getActionView() {
        return this.f465b;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            r3 = 0
            r2 = 1
            super.onMeasure(r8, r9)
            int r0 = r7.f466c
            if (r0 <= 0) goto L1c
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f466c
            if (r0 <= r1) goto L1c
            int r0 = r7.f466c
            r1 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            super.onMeasure(r8, r9)
        L1c:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = android.support.design.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r4 = android.support.design.R.dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r4)
            android.widget.TextView r4 = r7.f464a
            android.text.Layout r4 = r4.getLayout()
            int r4 = r4.getLineCount()
            if (r4 <= r2) goto L5c
            r4 = r2
        L3d:
            if (r4 == 0) goto L5e
            int r5 = r7.f467d
            if (r5 <= 0) goto L5e
            android.widget.Button r5 = r7.f465b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f467d
            if (r5 <= r6) goto L5e
            int r1 = r0 - r1
            boolean r0 = r7.m401a(r2, r0, r1)
            if (r0 == 0) goto L6a
            r0 = r2
        L56:
            if (r0 == 0) goto L5b
            super.onMeasure(r8, r9)
        L5b:
            return
        L5c:
            r4 = r3
            goto L3d
        L5e:
            if (r4 == 0) goto L68
        L60:
            boolean r0 = r7.m401a(r3, r0, r0)
            if (r0 == 0) goto L6a
            r0 = r2
            goto L56
        L68:
            r0 = r1
            goto L60
        L6a:
            r0 = r3
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.internal.SnackbarContentLayout.onMeasure(int, int):void");
    }

    /* JADX INFO: renamed from: a */
    private boolean m401a(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.f464a.getPaddingTop() != i2 || this.f464a.getPaddingBottom() != i3) {
            m400a(this.f464a, i2, i3);
            return true;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static void m400a(View view, int i, int i2) {
        if (ViewCompat.m2616t(view)) {
            ViewCompat.m2594b(view, ViewCompat.m2603g(view), i, ViewCompat.m2604h(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    @Override // android.support.design.widget.BaseTransientBottomBar.ContentViewCallback
    /* JADX INFO: renamed from: a */
    public void mo402a(int i, int i2) {
        this.f464a.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        this.f464a.animate().alpha(1.0f).setDuration(i2).setStartDelay(i).start();
        if (this.f465b.getVisibility() == 0) {
            this.f465b.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            this.f465b.animate().alpha(1.0f).setDuration(i2).setStartDelay(i).start();
        }
    }

    @Override // android.support.design.widget.BaseTransientBottomBar.ContentViewCallback
    /* JADX INFO: renamed from: b */
    public void mo403b(int i, int i2) {
        this.f464a.setAlpha(1.0f);
        this.f464a.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(i2).setStartDelay(i).start();
        if (this.f465b.getVisibility() == 0) {
            this.f465b.setAlpha(1.0f);
            this.f465b.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(i2).setStartDelay(i).start();
        }
    }
}
