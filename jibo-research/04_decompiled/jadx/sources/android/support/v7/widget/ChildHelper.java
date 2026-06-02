package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ChildHelper {

    /* JADX INFO: renamed from: a */
    final Callback f3773a;

    /* JADX INFO: renamed from: b */
    final Bucket f3774b = new Bucket();

    /* JADX INFO: renamed from: c */
    final List<View> f3775c = new ArrayList();

    interface Callback {
        /* JADX INFO: renamed from: a */
        int mo4033a();

        /* JADX INFO: renamed from: a */
        int mo4034a(View view);

        /* JADX INFO: renamed from: a */
        void mo4035a(int i);

        /* JADX INFO: renamed from: a */
        void mo4036a(View view, int i);

        /* JADX INFO: renamed from: a */
        void mo4037a(View view, int i, ViewGroup.LayoutParams layoutParams);

        /* JADX INFO: renamed from: b */
        RecyclerView.ViewHolder mo4038b(View view);

        /* JADX INFO: renamed from: b */
        View mo4039b(int i);

        /* JADX INFO: renamed from: b */
        void mo4040b();

        /* JADX INFO: renamed from: c */
        void mo4041c(int i);

        /* JADX INFO: renamed from: c */
        void mo4042c(View view);

        /* JADX INFO: renamed from: d */
        void mo4043d(View view);
    }

    ChildHelper(Callback callback) {
        this.f3773a = callback;
    }

    /* JADX INFO: renamed from: g */
    private void m4006g(View view) {
        this.f3775c.add(view);
        this.f3773a.mo4042c(view);
    }

    /* JADX INFO: renamed from: h */
    private boolean m4007h(View view) {
        if (!this.f3775c.remove(view)) {
            return false;
        }
        this.f3773a.mo4043d(view);
        return true;
    }

    /* JADX INFO: renamed from: a */
    void m4013a(View view, boolean z) {
        m4012a(view, -1, z);
    }

    /* JADX INFO: renamed from: a */
    void m4012a(View view, int i, boolean z) {
        int iM4005f;
        if (i < 0) {
            iM4005f = this.f3773a.mo4033a();
        } else {
            iM4005f = m4005f(i);
        }
        this.f3774b.m4028a(iM4005f, z);
        if (z) {
            m4006g(view);
        }
        this.f3773a.mo4036a(view, iM4005f);
    }

    /* JADX INFO: renamed from: f */
    private int m4005f(int i) {
        if (i < 0) {
            return -1;
        }
        int iMo4033a = this.f3773a.mo4033a();
        int i2 = i;
        while (i2 < iMo4033a) {
            int iM4032e = i - (i2 - this.f3774b.m4032e(i2));
            if (iM4032e == 0) {
                while (this.f3774b.m4030c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iM4032e;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    void m4010a(View view) {
        int iMo4034a = this.f3773a.mo4034a(view);
        if (iMo4034a >= 0) {
            if (this.f3774b.m4031d(iMo4034a)) {
                m4007h(view);
            }
            this.f3773a.mo4035a(iMo4034a);
        }
    }

    /* JADX INFO: renamed from: a */
    void m4009a(int i) {
        int iM4005f = m4005f(i);
        View viewMo4039b = this.f3773a.mo4039b(iM4005f);
        if (viewMo4039b != null) {
            if (this.f3774b.m4031d(iM4005f)) {
                m4007h(viewMo4039b);
            }
            this.f3773a.mo4035a(iM4005f);
        }
    }

    /* JADX INFO: renamed from: b */
    View m4016b(int i) {
        return this.f3773a.mo4039b(m4005f(i));
    }

    /* JADX INFO: renamed from: a */
    void m4008a() {
        this.f3774b.m4026a();
        for (int size = this.f3775c.size() - 1; size >= 0; size--) {
            this.f3773a.mo4043d(this.f3775c.get(size));
            this.f3775c.remove(size);
        }
        this.f3773a.mo4040b();
    }

    /* JADX INFO: renamed from: c */
    View m4018c(int i) {
        int size = this.f3775c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f3775c.get(i2);
            RecyclerView.ViewHolder viewHolderMo4038b = this.f3773a.mo4038b(view);
            if (viewHolderMo4038b.getLayoutPosition() == i && !viewHolderMo4038b.isInvalid() && !viewHolderMo4038b.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m4011a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iM4005f;
        if (i < 0) {
            iM4005f = this.f3773a.mo4033a();
        } else {
            iM4005f = m4005f(i);
        }
        this.f3774b.m4028a(iM4005f, z);
        if (z) {
            m4006g(view);
        }
        this.f3773a.mo4037a(view, iM4005f, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    int m4014b() {
        return this.f3773a.mo4033a() - this.f3775c.size();
    }

    /* JADX INFO: renamed from: c */
    int m4017c() {
        return this.f3773a.mo4033a();
    }

    /* JADX INFO: renamed from: d */
    View m4020d(int i) {
        return this.f3773a.mo4039b(i);
    }

    /* JADX INFO: renamed from: e */
    void m4022e(int i) {
        int iM4005f = m4005f(i);
        this.f3774b.m4031d(iM4005f);
        this.f3773a.mo4041c(iM4005f);
    }

    /* JADX INFO: renamed from: b */
    int m4015b(View view) {
        int iMo4034a = this.f3773a.mo4034a(view);
        if (iMo4034a == -1 || this.f3774b.m4030c(iMo4034a)) {
            return -1;
        }
        return iMo4034a - this.f3774b.m4032e(iMo4034a);
    }

    /* JADX INFO: renamed from: c */
    boolean m4019c(View view) {
        return this.f3775c.contains(view);
    }

    /* JADX INFO: renamed from: d */
    void m4021d(View view) {
        int iMo4034a = this.f3773a.mo4034a(view);
        if (iMo4034a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f3774b.m4027a(iMo4034a);
        m4006g(view);
    }

    /* JADX INFO: renamed from: e */
    void m4023e(View view) {
        int iMo4034a = this.f3773a.mo4034a(view);
        if (iMo4034a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.f3774b.m4030c(iMo4034a)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.f3774b.m4029b(iMo4034a);
        m4007h(view);
    }

    public String toString() {
        return this.f3774b.toString() + ", hidden list:" + this.f3775c.size();
    }

    /* JADX INFO: renamed from: f */
    boolean m4024f(View view) {
        int iMo4034a = this.f3773a.mo4034a(view);
        if (iMo4034a == -1) {
            if (m4007h(view)) {
            }
            return true;
        }
        if (this.f3774b.m4030c(iMo4034a)) {
            this.f3774b.m4031d(iMo4034a);
            if (!m4007h(view)) {
            }
            this.f3773a.mo4035a(iMo4034a);
            return true;
        }
        return false;
    }

    static class Bucket {

        /* JADX INFO: renamed from: a */
        long f3776a = 0;

        /* JADX INFO: renamed from: b */
        Bucket f3777b;

        Bucket() {
        }

        /* JADX INFO: renamed from: a */
        void m4027a(int i) {
            if (i >= 64) {
                m4025b();
                this.f3777b.m4027a(i - 64);
            } else {
                this.f3776a |= 1 << i;
            }
        }

        /* JADX INFO: renamed from: b */
        private void m4025b() {
            if (this.f3777b == null) {
                this.f3777b = new Bucket();
            }
        }

        /* JADX INFO: renamed from: b */
        void m4029b(int i) {
            if (i >= 64) {
                if (this.f3777b != null) {
                    this.f3777b.m4029b(i - 64);
                    return;
                }
                return;
            }
            this.f3776a &= (1 << i) ^ (-1);
        }

        /* JADX INFO: renamed from: c */
        boolean m4030c(int i) {
            if (i < 64) {
                return (this.f3776a & (1 << i)) != 0;
            }
            m4025b();
            return this.f3777b.m4030c(i - 64);
        }

        /* JADX INFO: renamed from: a */
        void m4026a() {
            this.f3776a = 0L;
            if (this.f3777b != null) {
                this.f3777b.m4026a();
            }
        }

        /* JADX INFO: renamed from: a */
        void m4028a(int i, boolean z) {
            if (i >= 64) {
                m4025b();
                this.f3777b.m4028a(i - 64, z);
                return;
            }
            boolean z2 = (this.f3776a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f3776a = (((j ^ (-1)) & this.f3776a) << 1) | (this.f3776a & j);
            if (z) {
                m4027a(i);
            } else {
                m4029b(i);
            }
            if (z2 || this.f3777b != null) {
                m4025b();
                this.f3777b.m4028a(0, z2);
            }
        }

        /* JADX INFO: renamed from: d */
        boolean m4031d(int i) {
            if (i >= 64) {
                m4025b();
                return this.f3777b.m4031d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f3776a & j) != 0;
            this.f3776a &= j ^ (-1);
            long j2 = j - 1;
            this.f3776a = Long.rotateRight((j2 ^ (-1)) & this.f3776a, 1) | (this.f3776a & j2);
            if (this.f3777b != null) {
                if (this.f3777b.m4030c(0)) {
                    m4027a(63);
                }
                this.f3777b.m4031d(0);
                return z;
            }
            return z;
        }

        /* JADX INFO: renamed from: e */
        int m4032e(int i) {
            if (this.f3777b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f3776a);
                }
                return Long.bitCount(this.f3776a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.f3776a & ((1 << i) - 1));
            }
            return this.f3777b.m4032e(i - 64) + Long.bitCount(this.f3776a);
        }

        public String toString() {
            return this.f3777b == null ? Long.toBinaryString(this.f3776a) : this.f3777b.toString() + "xx" + Long.toBinaryString(this.f3776a);
        }
    }
}
