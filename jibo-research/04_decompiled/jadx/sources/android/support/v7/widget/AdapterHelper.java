package android.support.v7.widget;

import android.support.v4.util.Pools;
import android.support.v7.widget.OpReorderer;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AdapterHelper implements OpReorderer.Callback {

    /* JADX INFO: renamed from: a */
    final ArrayList<UpdateOp> f3631a;

    /* JADX INFO: renamed from: b */
    final ArrayList<UpdateOp> f3632b;

    /* JADX INFO: renamed from: c */
    final Callback f3633c;

    /* JADX INFO: renamed from: d */
    Runnable f3634d;

    /* JADX INFO: renamed from: e */
    final boolean f3635e;

    /* JADX INFO: renamed from: f */
    final OpReorderer f3636f;

    /* JADX INFO: renamed from: g */
    private Pools.Pool<UpdateOp> f3637g;

    /* JADX INFO: renamed from: h */
    private int f3638h;

    interface Callback {
        /* JADX INFO: renamed from: a */
        RecyclerView.ViewHolder mo3824a(int i);

        /* JADX INFO: renamed from: a */
        void mo3825a(int i, int i2);

        /* JADX INFO: renamed from: a */
        void mo3826a(int i, int i2, Object obj);

        /* JADX INFO: renamed from: a */
        void mo3827a(UpdateOp updateOp);

        /* JADX INFO: renamed from: b */
        void mo3828b(int i, int i2);

        /* JADX INFO: renamed from: b */
        void mo3829b(UpdateOp updateOp);

        /* JADX INFO: renamed from: c */
        void mo3830c(int i, int i2);

        /* JADX INFO: renamed from: d */
        void mo3831d(int i, int i2);
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.f3637g = new Pools.SimplePool(30);
        this.f3631a = new ArrayList<>();
        this.f3632b = new ArrayList<>();
        this.f3638h = 0;
        this.f3633c = callback;
        this.f3635e = z;
        this.f3636f = new OpReorderer(this);
    }

    /* JADX INFO: renamed from: a */
    void m3808a() {
        m3811a(this.f3631a);
        m3811a(this.f3632b);
        this.f3638h = 0;
    }

    /* JADX INFO: renamed from: b */
    void m3816b() {
        this.f3636f.m4394a(this.f3631a);
        int size = this.f3631a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.f3631a.get(i);
            switch (updateOp.f3639a) {
                case 1:
                    m3804f(updateOp);
                    break;
                case 2:
                    m3799c(updateOp);
                    break;
                case 4:
                    m3801d(updateOp);
                    break;
                case 8:
                    m3798b(updateOp);
                    break;
            }
            if (this.f3634d != null) {
                this.f3634d.run();
            }
        }
        this.f3631a.clear();
    }

    /* JADX INFO: renamed from: c */
    void m3819c() {
        int size = this.f3632b.size();
        for (int i = 0; i < size; i++) {
            this.f3633c.mo3829b(this.f3632b.get(i));
        }
        m3811a(this.f3632b);
        this.f3638h = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m3798b(UpdateOp updateOp) {
        m3805g(updateOp);
    }

    /* JADX INFO: renamed from: c */
    private void m3799c(UpdateOp updateOp) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4 = updateOp.f3640b;
        int i5 = updateOp.f3640b + updateOp.f3642d;
        byte b = -1;
        int i6 = updateOp.f3640b;
        int i7 = 0;
        while (i6 < i5) {
            if (this.f3633c.mo3824a(i6) != null || m3802d(i6)) {
                if (b == 0) {
                    m3803e(mo3807a(2, i4, i7, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b == 1) {
                    m3805g(mo3807a(2, i4, i7, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 = i6 - i7;
                i = i5 - i7;
                i2 = 1;
            } else {
                int i8 = i6;
                i = i5;
                i2 = i7 + 1;
                i3 = i8;
            }
            i7 = i2;
            i5 = i;
            i6 = i3 + 1;
        }
        if (i7 != updateOp.f3642d) {
            mo3809a(updateOp);
            updateOp = mo3807a(2, i4, i7, null);
        }
        if (b == 0) {
            m3803e(updateOp);
        } else {
            m3805g(updateOp);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3801d(UpdateOp updateOp) {
        int i;
        int i2;
        byte b;
        int i3 = updateOp.f3640b;
        int i4 = updateOp.f3640b + updateOp.f3642d;
        int i5 = updateOp.f3640b;
        byte b2 = -1;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f3633c.mo3824a(i5) != null || m3802d(i5)) {
                if (b2 == 0) {
                    m3803e(mo3807a(4, i3, i6, updateOp.f3641c));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                b = 1;
            } else {
                if (b2 == 1) {
                    m3805g(mo3807a(4, i3, i6, updateOp.f3641c));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                b = 0;
            }
            i5++;
            byte b3 = b;
            i6 = i2 + 1;
            i3 = i;
            b2 = b3;
        }
        if (i6 != updateOp.f3642d) {
            Object obj = updateOp.f3641c;
            mo3809a(updateOp);
            updateOp = mo3807a(4, i3, i6, obj);
        }
        if (b2 == 0) {
            m3803e(updateOp);
        } else {
            m3805g(updateOp);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3803e(UpdateOp updateOp) {
        int i;
        boolean z;
        if (updateOp.f3639a == 1 || updateOp.f3639a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM3800d = m3800d(updateOp.f3640b, updateOp.f3639a);
        int i2 = updateOp.f3640b;
        switch (updateOp.f3639a) {
            case 2:
                i = 0;
                break;
            case 3:
            default:
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            case 4:
                i = 1;
                break;
        }
        int i3 = 1;
        int i4 = iM3800d;
        int i5 = i2;
        for (int i6 = 1; i6 < updateOp.f3642d; i6++) {
            int iM3800d2 = m3800d(updateOp.f3640b + (i * i6), updateOp.f3639a);
            switch (updateOp.f3639a) {
                case 2:
                    z = iM3800d2 == i4;
                    break;
                case 3:
                default:
                    z = false;
                    break;
                case 4:
                    z = iM3800d2 == i4 + 1;
                    break;
            }
            if (z) {
                i3++;
            } else {
                UpdateOp updateOpMo3807a = mo3807a(updateOp.f3639a, i4, i3, updateOp.f3641c);
                m3810a(updateOpMo3807a, i5);
                mo3809a(updateOpMo3807a);
                if (updateOp.f3639a == 4) {
                    i5 += i3;
                }
                i3 = 1;
                i4 = iM3800d2;
            }
        }
        Object obj = updateOp.f3641c;
        mo3809a(updateOp);
        if (i3 > 0) {
            UpdateOp updateOpMo3807a2 = mo3807a(updateOp.f3639a, i4, i3, obj);
            m3810a(updateOpMo3807a2, i5);
            mo3809a(updateOpMo3807a2);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3810a(UpdateOp updateOp, int i) {
        this.f3633c.mo3827a(updateOp);
        switch (updateOp.f3639a) {
            case 2:
                this.f3633c.mo3825a(i, updateOp.f3642d);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.f3633c.mo3826a(i, updateOp.f3642d, updateOp.f3641c);
                return;
        }
    }

    /* JADX INFO: renamed from: d */
    private int m3800d(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        for (int size = this.f3632b.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f3632b.get(size);
            if (updateOp.f3639a == 8) {
                if (updateOp.f3640b < updateOp.f3642d) {
                    i3 = updateOp.f3640b;
                    i4 = updateOp.f3642d;
                } else {
                    i3 = updateOp.f3642d;
                    i4 = updateOp.f3640b;
                }
                if (i6 >= i3 && i6 <= i4) {
                    if (i3 == updateOp.f3640b) {
                        if (i2 == 1) {
                            updateOp.f3642d++;
                        } else if (i2 == 2) {
                            updateOp.f3642d--;
                        }
                        i5 = i6 + 1;
                    } else {
                        if (i2 == 1) {
                            updateOp.f3640b++;
                        } else if (i2 == 2) {
                            updateOp.f3640b--;
                        }
                        i5 = i6 - 1;
                    }
                } else if (i6 >= updateOp.f3640b) {
                    i5 = i6;
                } else if (i2 == 1) {
                    updateOp.f3640b++;
                    updateOp.f3642d++;
                    i5 = i6;
                } else {
                    if (i2 == 2) {
                        updateOp.f3640b--;
                        updateOp.f3642d--;
                    }
                    i5 = i6;
                }
                i6 = i5;
            } else if (updateOp.f3640b <= i6) {
                if (updateOp.f3639a == 1) {
                    i6 -= updateOp.f3642d;
                } else if (updateOp.f3639a == 2) {
                    i6 += updateOp.f3642d;
                }
            } else if (i2 == 1) {
                updateOp.f3640b++;
            } else if (i2 == 2) {
                updateOp.f3640b--;
            }
        }
        for (int size2 = this.f3632b.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f3632b.get(size2);
            if (updateOp2.f3639a == 8) {
                if (updateOp2.f3642d == updateOp2.f3640b || updateOp2.f3642d < 0) {
                    this.f3632b.remove(size2);
                    mo3809a(updateOp2);
                }
            } else if (updateOp2.f3642d <= 0) {
                this.f3632b.remove(size2);
                mo3809a(updateOp2);
            }
        }
        return i6;
    }

    /* JADX INFO: renamed from: d */
    private boolean m3802d(int i) {
        int size = this.f3632b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f3632b.get(i2);
            if (updateOp.f3639a == 8) {
                if (m3806a(updateOp.f3642d, i2 + 1) == i) {
                    return true;
                }
            } else if (updateOp.f3639a == 1) {
                int i3 = updateOp.f3640b + updateOp.f3642d;
                for (int i4 = updateOp.f3640b; i4 < i3; i4++) {
                    if (m3806a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    private void m3804f(UpdateOp updateOp) {
        m3805g(updateOp);
    }

    /* JADX INFO: renamed from: g */
    private void m3805g(UpdateOp updateOp) {
        this.f3632b.add(updateOp);
        switch (updateOp.f3639a) {
            case 1:
                this.f3633c.mo3830c(updateOp.f3640b, updateOp.f3642d);
                return;
            case 2:
                this.f3633c.mo3828b(updateOp.f3640b, updateOp.f3642d);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
            case 4:
                this.f3633c.mo3826a(updateOp.f3640b, updateOp.f3642d, updateOp.f3641c);
                return;
            case 8:
                this.f3633c.mo3831d(updateOp.f3640b, updateOp.f3642d);
                return;
        }
    }

    /* JADX INFO: renamed from: d */
    boolean m3821d() {
        return this.f3631a.size() > 0;
    }

    /* JADX INFO: renamed from: a */
    boolean m3812a(int i) {
        return (this.f3638h & i) != 0;
    }

    /* JADX INFO: renamed from: b */
    int m3815b(int i) {
        return m3806a(i, 0);
    }

    /* JADX INFO: renamed from: a */
    int m3806a(int i, int i2) {
        int size = this.f3632b.size();
        int i3 = i;
        while (i2 < size) {
            UpdateOp updateOp = this.f3632b.get(i2);
            if (updateOp.f3639a == 8) {
                if (updateOp.f3640b == i3) {
                    i3 = updateOp.f3642d;
                } else {
                    if (updateOp.f3640b < i3) {
                        i3--;
                    }
                    if (updateOp.f3642d <= i3) {
                        i3++;
                    }
                }
            } else if (updateOp.f3640b > i3) {
                continue;
            } else if (updateOp.f3639a == 2) {
                if (i3 < updateOp.f3640b + updateOp.f3642d) {
                    return -1;
                }
                i3 -= updateOp.f3642d;
            } else if (updateOp.f3639a == 1) {
                i3 += updateOp.f3642d;
            }
            i2++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    boolean m3814a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f3631a.add(mo3807a(4, i, i2, obj));
        this.f3638h |= 4;
        return this.f3631a.size() == 1;
    }

    /* JADX INFO: renamed from: b */
    boolean m3817b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f3631a.add(mo3807a(1, i, i2, null));
        this.f3638h |= 1;
        return this.f3631a.size() == 1;
    }

    /* JADX INFO: renamed from: c */
    boolean m3820c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f3631a.add(mo3807a(2, i, i2, null));
        this.f3638h |= 2;
        return this.f3631a.size() == 1;
    }

    /* JADX INFO: renamed from: a */
    boolean m3813a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f3631a.add(mo3807a(8, i, i2, null));
        this.f3638h |= 8;
        return this.f3631a.size() == 1;
    }

    /* JADX INFO: renamed from: e */
    void m3822e() {
        m3819c();
        int size = this.f3631a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.f3631a.get(i);
            switch (updateOp.f3639a) {
                case 1:
                    this.f3633c.mo3829b(updateOp);
                    this.f3633c.mo3830c(updateOp.f3640b, updateOp.f3642d);
                    break;
                case 2:
                    this.f3633c.mo3829b(updateOp);
                    this.f3633c.mo3825a(updateOp.f3640b, updateOp.f3642d);
                    break;
                case 4:
                    this.f3633c.mo3829b(updateOp);
                    this.f3633c.mo3826a(updateOp.f3640b, updateOp.f3642d, updateOp.f3641c);
                    break;
                case 8:
                    this.f3633c.mo3829b(updateOp);
                    this.f3633c.mo3831d(updateOp.f3640b, updateOp.f3642d);
                    break;
            }
            if (this.f3634d != null) {
                this.f3634d.run();
            }
        }
        m3811a(this.f3631a);
        this.f3638h = 0;
    }

    /* JADX INFO: renamed from: c */
    public int m3818c(int i) {
        int size = this.f3631a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f3631a.get(i3);
            switch (updateOp.f3639a) {
                case 1:
                    if (updateOp.f3640b <= i2) {
                        i2 += updateOp.f3642d;
                    }
                    break;
                case 2:
                    if (updateOp.f3640b > i2) {
                        continue;
                    } else {
                        if (updateOp.f3640b + updateOp.f3642d > i2) {
                            return -1;
                        }
                        i2 -= updateOp.f3642d;
                    }
                    break;
                case 8:
                    if (updateOp.f3640b == i2) {
                        i2 = updateOp.f3642d;
                    } else {
                        if (updateOp.f3640b < i2) {
                            i2--;
                        }
                        if (updateOp.f3642d <= i2) {
                            i2++;
                        }
                    }
                    break;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: f */
    boolean m3823f() {
        return (this.f3632b.isEmpty() || this.f3631a.isEmpty()) ? false : true;
    }

    static class UpdateOp {

        /* JADX INFO: renamed from: a */
        int f3639a;

        /* JADX INFO: renamed from: b */
        int f3640b;

        /* JADX INFO: renamed from: c */
        Object f3641c;

        /* JADX INFO: renamed from: d */
        int f3642d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.f3639a = i;
            this.f3640b = i2;
            this.f3642d = i3;
            this.f3641c = obj;
        }

        /* JADX INFO: renamed from: a */
        String m3832a() {
            switch (this.f3639a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    return "??";
                case 4:
                    return "up";
                case 8:
                    return "mv";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m3832a() + ",s:" + this.f3640b + "c:" + this.f3642d + ",p:" + this.f3641c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            if (this.f3639a != updateOp.f3639a) {
                return false;
            }
            if (this.f3639a == 8 && Math.abs(this.f3642d - this.f3640b) == 1 && this.f3642d == updateOp.f3640b && this.f3640b == updateOp.f3642d) {
                return true;
            }
            if (this.f3642d == updateOp.f3642d && this.f3640b == updateOp.f3640b) {
                return this.f3641c != null ? this.f3641c.equals(updateOp.f3641c) : updateOp.f3641c == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f3639a * 31) + this.f3640b) * 31) + this.f3642d;
        }
    }

    @Override // android.support.v7.widget.OpReorderer.Callback
    /* JADX INFO: renamed from: a */
    public UpdateOp mo3807a(int i, int i2, int i3, Object obj) {
        UpdateOp updateOpMo2438a = this.f3637g.mo2438a();
        if (updateOpMo2438a == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        updateOpMo2438a.f3639a = i;
        updateOpMo2438a.f3640b = i2;
        updateOpMo2438a.f3642d = i3;
        updateOpMo2438a.f3641c = obj;
        return updateOpMo2438a;
    }

    @Override // android.support.v7.widget.OpReorderer.Callback
    /* JADX INFO: renamed from: a */
    public void mo3809a(UpdateOp updateOp) {
        if (!this.f3635e) {
            updateOp.f3641c = null;
            this.f3637g.mo2439a(updateOp);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3811a(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo3809a(list.get(i));
        }
        list.clear();
    }
}
