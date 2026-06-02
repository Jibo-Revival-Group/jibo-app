package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a */
    long f2561a;

    /* JADX INFO: renamed from: b */
    boolean f2562b;

    /* JADX INFO: renamed from: c */
    boolean f2563c;

    /* JADX INFO: renamed from: d */
    boolean f2564d;

    /* JADX INFO: renamed from: e */
    private final Runnable f2565e;

    /* JADX INFO: renamed from: f */
    private final Runnable f2566f;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2561a = -1L;
        this.f2562b = false;
        this.f2563c = false;
        this.f2564d = false;
        this.f2565e = new Runnable() { // from class: android.support.v4.widget.ContentLoadingProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar.this.f2562b = false;
                ContentLoadingProgressBar.this.f2561a = -1L;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f2566f = new Runnable() { // from class: android.support.v4.widget.ContentLoadingProgressBar.2
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar.this.f2563c = false;
                if (!ContentLoadingProgressBar.this.f2564d) {
                    ContentLoadingProgressBar.this.f2561a = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2934a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2934a();
    }

    /* JADX INFO: renamed from: a */
    private void m2934a() {
        removeCallbacks(this.f2565e);
        removeCallbacks(this.f2566f);
    }
}
