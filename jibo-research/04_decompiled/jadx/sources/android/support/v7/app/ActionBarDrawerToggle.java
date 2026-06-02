package android.support.v7.app;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* JADX INFO: renamed from: a */
    boolean f2797a;

    /* JADX INFO: renamed from: b */
    private final Delegate f2798b;

    /* JADX INFO: renamed from: c */
    private DrawerArrowDrawable f2799c;

    /* JADX INFO: renamed from: d */
    private boolean f2800d;

    /* JADX INFO: renamed from: e */
    private final int f2801e;

    /* JADX INFO: renamed from: f */
    private final int f2802f;

    public interface Delegate {
        /* JADX INFO: renamed from: a */
        void mo3186a(int i);
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    /* JADX INFO: renamed from: a */
    public void mo3000a(View view, float f) {
        if (this.f2800d) {
            m3184a(Math.min(1.0f, Math.max(CropImageView.DEFAULT_ASPECT_RATIO, f)));
        } else {
            m3184a(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    /* JADX INFO: renamed from: a */
    public void mo2999a(View view) {
        m3184a(1.0f);
        if (this.f2797a) {
            m3185b(this.f2802f);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    /* JADX INFO: renamed from: b */
    public void mo3001b(View view) {
        m3184a(CropImageView.DEFAULT_ASPECT_RATIO);
        if (this.f2797a) {
            m3185b(this.f2801e);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    /* JADX INFO: renamed from: a */
    public void mo2998a(int i) {
    }

    /* JADX INFO: renamed from: b */
    void m3185b(int i) {
        this.f2798b.mo3186a(i);
    }

    /* JADX INFO: renamed from: a */
    private void m3184a(float f) {
        if (f == 1.0f) {
            this.f2799c.m3437a(true);
        } else if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f2799c.m3437a(false);
        }
        this.f2799c.m3436a(f);
    }
}
