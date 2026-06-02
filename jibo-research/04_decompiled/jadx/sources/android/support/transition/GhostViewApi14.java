package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.transition.GhostViewImpl;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class GhostViewApi14 extends View implements GhostViewImpl {

    /* JADX INFO: renamed from: a */
    final View f1201a;

    /* JADX INFO: renamed from: b */
    ViewGroup f1202b;

    /* JADX INFO: renamed from: c */
    View f1203c;

    /* JADX INFO: renamed from: d */
    int f1204d;

    /* JADX INFO: renamed from: e */
    Matrix f1205e;

    /* JADX INFO: renamed from: f */
    private int f1206f;

    /* JADX INFO: renamed from: g */
    private int f1207g;

    /* JADX INFO: renamed from: h */
    private final Matrix f1208h;

    /* JADX INFO: renamed from: i */
    private final ViewTreeObserver.OnPreDrawListener f1209i;

    static class Creator implements GhostViewImpl.Creator {
        Creator() {
        }

        @Override // android.support.transition.GhostViewImpl.Creator
        /* JADX INFO: renamed from: a */
        public GhostViewImpl mo1159a(View view, ViewGroup viewGroup, Matrix matrix) {
            GhostViewApi14 ghostViewApi14M1155a = GhostViewApi14.m1155a(view);
            if (ghostViewApi14M1155a == null) {
                FrameLayout frameLayoutM1158a = m1158a(viewGroup);
                if (frameLayoutM1158a == null) {
                    return null;
                }
                ghostViewApi14M1155a = new GhostViewApi14(view);
                frameLayoutM1158a.addView(ghostViewApi14M1155a);
            }
            ghostViewApi14M1155a.f1204d++;
            return ghostViewApi14M1155a;
        }

        @Override // android.support.transition.GhostViewImpl.Creator
        /* JADX INFO: renamed from: a */
        public void mo1160a(View view) {
            GhostViewApi14 ghostViewApi14M1155a = GhostViewApi14.m1155a(view);
            if (ghostViewApi14M1155a != null) {
                ghostViewApi14M1155a.f1204d--;
                if (ghostViewApi14M1155a.f1204d <= 0) {
                    ViewParent parent = ghostViewApi14M1155a.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        viewGroup.endViewTransition(ghostViewApi14M1155a);
                        viewGroup.removeView(ghostViewApi14M1155a);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static FrameLayout m1158a(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = viewGroup;
            while (!(viewGroup2 instanceof FrameLayout)) {
                ViewParent parent = viewGroup2.getParent();
                if (!(parent instanceof ViewGroup)) {
                    return null;
                }
                viewGroup2 = (ViewGroup) parent;
            }
            return (FrameLayout) viewGroup2;
        }
    }

    GhostViewApi14(View view) {
        super(view.getContext());
        this.f1208h = new Matrix();
        this.f1209i = new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.transition.GhostViewApi14.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                GhostViewApi14.this.f1205e = GhostViewApi14.this.f1201a.getMatrix();
                ViewCompat.m2597c(GhostViewApi14.this);
                if (GhostViewApi14.this.f1202b != null && GhostViewApi14.this.f1203c != null) {
                    GhostViewApi14.this.f1202b.endViewTransition(GhostViewApi14.this.f1203c);
                    ViewCompat.m2597c(GhostViewApi14.this.f1202b);
                    GhostViewApi14.this.f1202b = null;
                    GhostViewApi14.this.f1203c = null;
                    return true;
                }
                return true;
            }
        };
        this.f1201a = view;
        setLayerType(2, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1156a(this.f1201a, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.f1201a.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (iArr2[0] - this.f1201a.getTranslationX());
        iArr2[1] = (int) (iArr2[1] - this.f1201a.getTranslationY());
        this.f1206f = iArr2[0] - iArr[0];
        this.f1207g = iArr2[1] - iArr[1];
        this.f1201a.getViewTreeObserver().addOnPreDrawListener(this.f1209i);
        this.f1201a.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f1201a.getViewTreeObserver().removeOnPreDrawListener(this.f1209i);
        this.f1201a.setVisibility(0);
        m1156a(this.f1201a, (GhostViewApi14) null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f1208h.set(this.f1205e);
        this.f1208h.postTranslate(this.f1206f, this.f1207g);
        canvas.setMatrix(this.f1208h);
        this.f1201a.draw(canvas);
    }

    @Override // android.view.View, android.support.transition.GhostViewImpl
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f1201a.setVisibility(i == 0 ? 4 : 0);
    }

    @Override // android.support.transition.GhostViewImpl
    /* JADX INFO: renamed from: a */
    public void mo1157a(ViewGroup viewGroup, View view) {
        this.f1202b = viewGroup;
        this.f1203c = view;
    }

    /* JADX INFO: renamed from: a */
    private static void m1156a(View view, GhostViewApi14 ghostViewApi14) {
        view.setTag(R.id.ghost_view, ghostViewApi14);
    }

    /* JADX INFO: renamed from: a */
    static GhostViewApi14 m1155a(View view) {
        return (GhostViewApi14) view.getTag(R.id.ghost_view);
    }
}
