package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class OrientationHelper {

    /* JADX INFO: renamed from: a */
    protected final RecyclerView.LayoutManager f4052a;

    /* JADX INFO: renamed from: b */
    final Rect f4053b;

    /* JADX INFO: renamed from: c */
    private int f4054c;

    /* JADX INFO: renamed from: a */
    public abstract int mo4400a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo4402a(int i);

    /* JADX INFO: renamed from: b */
    public abstract int mo4404b(View view);

    /* JADX INFO: renamed from: c */
    public abstract int mo4405c();

    /* JADX INFO: renamed from: c */
    public abstract int mo4406c(View view);

    /* JADX INFO: renamed from: d */
    public abstract int mo4407d();

    /* JADX INFO: renamed from: d */
    public abstract int mo4408d(View view);

    /* JADX INFO: renamed from: e */
    public abstract int mo4409e();

    /* JADX INFO: renamed from: e */
    public abstract int mo4410e(View view);

    /* JADX INFO: renamed from: f */
    public abstract int mo4411f();

    /* JADX INFO: renamed from: f */
    public abstract int mo4412f(View view);

    /* JADX INFO: renamed from: g */
    public abstract int mo4413g();

    /* JADX INFO: renamed from: h */
    public abstract int mo4414h();

    /* JADX INFO: renamed from: i */
    public abstract int mo4415i();

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f4054c = Integer.MIN_VALUE;
        this.f4053b = new Rect();
        this.f4052a = layoutManager;
    }

    /* JADX INFO: renamed from: a */
    public void m4401a() {
        this.f4054c = mo4411f();
    }

    /* JADX INFO: renamed from: b */
    public int m4403b() {
        if (Integer.MIN_VALUE == this.f4054c) {
            return 0;
        }
        return mo4411f() - this.f4054c;
    }

    /* JADX INFO: renamed from: a */
    public static OrientationHelper m4398a(RecyclerView.LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return m4397a(layoutManager);
            case 1:
                return m4399b(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* JADX INFO: renamed from: a */
    public static OrientationHelper m4397a(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: android.support.v7.widget.OrientationHelper.1
            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: d */
            public int mo4407d() {
                return this.f4052a.m4564y() - this.f4052a.m4476C();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: e */
            public int mo4409e() {
                return this.f4052a.m4564y();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: a */
            public void mo4402a(int i) {
                this.f4052a.mo4546j(i);
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: c */
            public int mo4405c() {
                return this.f4052a.m4474A();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: e */
            public int mo4410e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.f4052a.m4535f(view) + layoutParams.leftMargin;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: f */
            public int mo4412f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.f4052a.m4538g(view) + layoutParams.topMargin;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: b */
            public int mo4404b(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.f4052a.m4545j(view);
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: a */
            public int mo4400a(View view) {
                return this.f4052a.m4541h(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: c */
            public int mo4406c(View view) {
                this.f4052a.m4501a(view, true, this.f4053b);
                return this.f4053b.right;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: d */
            public int mo4408d(View view) {
                this.f4052a.m4501a(view, true, this.f4053b);
                return this.f4053b.left;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: f */
            public int mo4411f() {
                return (this.f4052a.m4564y() - this.f4052a.m4474A()) - this.f4052a.m4476C();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: g */
            public int mo4413g() {
                return this.f4052a.m4476C();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: h */
            public int mo4414h() {
                return this.f4052a.m4562w();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: i */
            public int mo4415i() {
                return this.f4052a.m4563x();
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public static OrientationHelper m4399b(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: android.support.v7.widget.OrientationHelper.2
            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: d */
            public int mo4407d() {
                return this.f4052a.m4565z() - this.f4052a.m4477D();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: e */
            public int mo4409e() {
                return this.f4052a.m4565z();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: a */
            public void mo4402a(int i) {
                this.f4052a.mo4548k(i);
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: c */
            public int mo4405c() {
                return this.f4052a.m4475B();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: e */
            public int mo4410e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.f4052a.m4538g(view) + layoutParams.topMargin;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: f */
            public int mo4412f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.f4052a.m4535f(view) + layoutParams.leftMargin;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: b */
            public int mo4404b(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.f4052a.m4547k(view);
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: a */
            public int mo4400a(View view) {
                return this.f4052a.m4543i(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: c */
            public int mo4406c(View view) {
                this.f4052a.m4501a(view, true, this.f4053b);
                return this.f4053b.bottom;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: d */
            public int mo4408d(View view) {
                this.f4052a.m4501a(view, true, this.f4053b);
                return this.f4053b.top;
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: f */
            public int mo4411f() {
                return (this.f4052a.m4565z() - this.f4052a.m4475B()) - this.f4052a.m4477D();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: g */
            public int mo4413g() {
                return this.f4052a.m4477D();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: h */
            public int mo4414h() {
                return this.f4052a.m4563x();
            }

            @Override // android.support.v7.widget.OrientationHelper
            /* JADX INFO: renamed from: i */
            public int mo4415i() {
                return this.f4052a.m4562w();
            }
        };
    }
}
