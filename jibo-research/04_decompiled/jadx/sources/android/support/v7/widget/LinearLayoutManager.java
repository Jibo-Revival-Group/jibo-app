package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, ItemTouchHelper.ViewDropHandler {

    /* JADX INFO: renamed from: a */
    private LayoutState f3957a;

    /* JADX INFO: renamed from: b */
    private boolean f3958b;

    /* JADX INFO: renamed from: c */
    private boolean f3959c;

    /* JADX INFO: renamed from: d */
    private boolean f3960d;

    /* JADX INFO: renamed from: e */
    private boolean f3961e;

    /* JADX INFO: renamed from: f */
    private boolean f3962f;

    /* JADX INFO: renamed from: g */
    private final LayoutChunkResult f3963g;

    /* JADX INFO: renamed from: h */
    private int f3964h;

    /* JADX INFO: renamed from: i */
    int f3965i;

    /* JADX INFO: renamed from: j */
    OrientationHelper f3966j;

    /* JADX INFO: renamed from: k */
    boolean f3967k;

    /* JADX INFO: renamed from: l */
    int f3968l;

    /* JADX INFO: renamed from: m */
    int f3969m;

    /* JADX INFO: renamed from: n */
    SavedState f3970n;

    /* JADX INFO: renamed from: o */
    final AnchorInfo f3971o;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f3965i = 1;
        this.f3959c = false;
        this.f3967k = false;
        this.f3960d = false;
        this.f3961e = true;
        this.f3968l = -1;
        this.f3969m = Integer.MIN_VALUE;
        this.f3970n = null;
        this.f3971o = new AnchorInfo();
        this.f3963g = new LayoutChunkResult();
        this.f3964h = 2;
        m4300b(i);
        m4302b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3965i = 1;
        this.f3959c = false;
        this.f3967k = false;
        this.f3960d = false;
        this.f3961e = true;
        this.f3968l = -1;
        this.f3969m = Integer.MIN_VALUE;
        this.f3970n = null;
        this.f3971o = new AnchorInfo();
        this.f3963g = new LayoutChunkResult();
        this.f3964h = 2;
        RecyclerView.LayoutManager.Properties propertiesA = m4465a(context, attributeSet, i, i2);
        m4300b(propertiesA.f4091a);
        m4302b(propertiesA.f4093c);
        mo4223a(propertiesA.f4094d);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public boolean mo4307c() {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo4206a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4294a(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.mo4294a(recyclerView, recycler);
        if (this.f3962f) {
            m4521c(recycler);
            recycler.m4598a();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4297a(AccessibilityEvent accessibilityEvent) {
        super.mo4297a(accessibilityEvent);
        if (m4561v() > 0) {
            accessibilityEvent.setFromIndex(m4325m());
            accessibilityEvent.setToIndex(m4326n());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: d */
    public Parcelable mo4310d() {
        if (this.f3970n != null) {
            return new SavedState(this.f3970n);
        }
        SavedState savedState = new SavedState();
        if (m4561v() > 0) {
            m4321i();
            boolean z = this.f3958b ^ this.f3967k;
            savedState.f3995c = z;
            if (z) {
                View viewM4260N = m4260N();
                savedState.f3994b = this.f3966j.mo4407d() - this.f3966j.mo4404b(viewM4260N);
                savedState.f3993a = m4527d(viewM4260N);
                return savedState;
            }
            View viewM4259M = m4259M();
            savedState.f3993a = m4527d(viewM4259M);
            savedState.f3994b = this.f3966j.mo4400a(viewM4259M) - this.f3966j.mo4405c();
            return savedState;
        }
        savedState.m4340b();
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4293a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f3970n = (SavedState) parcelable;
            m4554o();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: e */
    public boolean mo4313e() {
        return this.f3965i == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: f */
    public boolean mo4316f() {
        return this.f3965i == 1;
    }

    /* JADX INFO: renamed from: a */
    public void mo4223a(boolean z) {
        mo4298a((String) null);
        if (this.f3960d != z) {
            this.f3960d = z;
            m4554o();
        }
    }

    /* JADX INFO: renamed from: g */
    public int m4317g() {
        return this.f3965i;
    }

    /* JADX INFO: renamed from: b */
    public void m4300b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        mo4298a((String) null);
        if (i != this.f3965i || this.f3966j == null) {
            this.f3966j = OrientationHelper.m4398a(this, i);
            this.f3971o.f3972a = this.f3966j;
            this.f3965i = i;
            m4554o();
        }
    }

    /* JADX INFO: renamed from: L */
    private void m4258L() {
        if (this.f3965i == 1 || !m4320h()) {
            this.f3967k = this.f3959c;
        } else {
            this.f3967k = this.f3959c ? false : true;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4302b(boolean z) {
        mo4298a((String) null);
        if (z != this.f3959c) {
            this.f3959c = z;
            m4554o();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public View mo4305c(int i) {
        int iV = m4561v();
        if (iV == 0) {
            return null;
        }
        int iD = i - m4527d(m4544i(0));
        if (iD >= 0 && iD < iV) {
            View viewI = m4544i(iD);
            if (m4527d(viewI) == i) {
                return viewI;
            }
        }
        return super.mo4305c(i);
    }

    /* JADX INFO: renamed from: b */
    protected int m4299b(RecyclerView.State state) {
        if (state.m4661d()) {
            return this.f3966j.mo4411f();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4295a(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.m4642d(i);
        m4492a(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    /* JADX INFO: renamed from: d */
    public PointF mo4309d(int i) {
        if (m4561v() == 0) {
            return null;
        }
        int i2 = (i < m4527d(m4544i(0))) != this.f3967k ? -1 : 1;
        if (this.f3965i == 0) {
            return new PointF(i2, CropImageView.DEFAULT_ASPECT_RATIO);
        }
        return new PointF(CropImageView.DEFAULT_ASPECT_RATIO, i2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public void mo4229c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        View viewMo4305c;
        int iMo4400a;
        int i5 = -1;
        if ((this.f3970n != null || this.f3968l != -1) && state.m4662e() == 0) {
            m4521c(recycler);
            return;
        }
        if (this.f3970n != null && this.f3970n.m4339a()) {
            this.f3968l = this.f3970n.f3993a;
        }
        m4321i();
        this.f3957a.f3981a = false;
        m4258L();
        View viewE = m4478E();
        if (!this.f3971o.f3976e || this.f3968l != -1 || this.f3970n != null) {
            this.f3971o.m4327a();
            this.f3971o.f3975d = this.f3967k ^ this.f3960d;
            m4269a(recycler, state, this.f3971o);
            this.f3971o.f3976e = true;
        } else if (viewE != null && (this.f3966j.mo4400a(viewE) >= this.f3966j.mo4407d() || this.f3966j.mo4404b(viewE) <= this.f3966j.mo4405c())) {
            this.f3971o.m4328a(viewE, m4527d(viewE));
        }
        int iM4299b = m4299b(state);
        if (this.f3957a.f3990j >= 0) {
            i = 0;
        } else {
            i = iM4299b;
            iM4299b = 0;
        }
        int iMo4405c = i + this.f3966j.mo4405c();
        int iMo4413g = iM4299b + this.f3966j.mo4413g();
        if (state.m4658a() && this.f3968l != -1 && this.f3969m != Integer.MIN_VALUE && (viewMo4305c = mo4305c(this.f3968l)) != null) {
            if (this.f3967k) {
                iMo4400a = (this.f3966j.mo4407d() - this.f3966j.mo4404b(viewMo4305c)) - this.f3969m;
            } else {
                iMo4400a = this.f3969m - (this.f3966j.mo4400a(viewMo4305c) - this.f3966j.mo4405c());
            }
            if (iMo4400a > 0) {
                iMo4405c += iMo4400a;
            } else {
                iMo4413g -= iMo4400a;
            }
        }
        if (this.f3971o.f3975d) {
            if (this.f3967k) {
                i5 = 1;
            }
        } else if (!this.f3967k) {
            i5 = 1;
        }
        mo4214a(recycler, state, this.f3971o, i5);
        m4488a(recycler);
        this.f3957a.f3992l = m4323k();
        this.f3957a.f3989i = state.m4658a();
        if (this.f3971o.f3975d) {
            m4273b(this.f3971o);
            this.f3957a.f3988h = iMo4405c;
            m4289a(recycler, this.f3957a, state, false);
            int i6 = this.f3957a.f3982b;
            int i7 = this.f3957a.f3984d;
            if (this.f3957a.f3983c > 0) {
                iMo4413g += this.f3957a.f3983c;
            }
            m4265a(this.f3971o);
            this.f3957a.f3988h = iMo4413g;
            this.f3957a.f3984d += this.f3957a.f3985e;
            m4289a(recycler, this.f3957a, state, false);
            int i8 = this.f3957a.f3982b;
            if (this.f3957a.f3983c > 0) {
                int i9 = this.f3957a.f3983c;
                m4280h(i7, i6);
                this.f3957a.f3988h = i9;
                m4289a(recycler, this.f3957a, state, false);
                i4 = this.f3957a.f3982b;
            } else {
                i4 = i6;
            }
            i3 = i4;
            i2 = i8;
        } else {
            m4265a(this.f3971o);
            this.f3957a.f3988h = iMo4413g;
            m4289a(recycler, this.f3957a, state, false);
            i2 = this.f3957a.f3982b;
            int i10 = this.f3957a.f3984d;
            if (this.f3957a.f3983c > 0) {
                iMo4405c += this.f3957a.f3983c;
            }
            m4273b(this.f3971o);
            this.f3957a.f3988h = iMo4405c;
            this.f3957a.f3984d += this.f3957a.f3985e;
            m4289a(recycler, this.f3957a, state, false);
            i3 = this.f3957a.f3982b;
            if (this.f3957a.f3983c > 0) {
                int i11 = this.f3957a.f3983c;
                m4263a(i10, i2);
                this.f3957a.f3988h = i11;
                m4289a(recycler, this.f3957a, state, false);
                i2 = this.f3957a.f3982b;
            }
        }
        if (m4561v() > 0) {
            if (this.f3967k ^ this.f3960d) {
                int iM4261a = m4261a(i2, recycler, state, true);
                int i12 = i3 + iM4261a;
                int iM4271b = m4271b(i12, recycler, state, false);
                i3 = i12 + iM4271b;
                i2 = i2 + iM4261a + iM4271b;
            } else {
                int iM4271b2 = m4271b(i3, recycler, state, true);
                int i13 = i2 + iM4271b2;
                int iM4261a2 = m4261a(i13, recycler, state, false);
                i3 = i3 + iM4271b2 + iM4261a2;
                i2 = i13 + iM4261a2;
            }
        }
        m4275b(recycler, state, i3, i2);
        if (!state.m4658a()) {
            this.f3966j.m4401a();
        } else {
            this.f3971o.m4327a();
        }
        this.f3958b = this.f3960d;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4217a(RecyclerView.State state) {
        super.mo4217a(state);
        this.f3970n = null;
        this.f3968l = -1;
        this.f3969m = Integer.MIN_VALUE;
        this.f3971o.m4327a();
    }

    /* JADX INFO: renamed from: a */
    void mo4214a(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i) {
    }

    /* JADX INFO: renamed from: b */
    private void m4275b(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int iMo4410e;
        int iMo4410e2;
        if (state.m4659b() && m4561v() != 0 && !state.m4658a() && mo4228b()) {
            int i3 = 0;
            int i4 = 0;
            List<RecyclerView.ViewHolder> listM4615c = recycler.m4615c();
            int size = listM4615c.size();
            int iD = m4527d(m4544i(0));
            int i5 = 0;
            while (i5 < size) {
                RecyclerView.ViewHolder viewHolder = listM4615c.get(i5);
                if (viewHolder.isRemoved()) {
                    iMo4410e = i4;
                    iMo4410e2 = i3;
                } else {
                    if (((viewHolder.getLayoutPosition() < iD) != this.f3967k ? (byte) -1 : (byte) 1) == -1) {
                        iMo4410e2 = this.f3966j.mo4410e(viewHolder.itemView) + i3;
                        iMo4410e = i4;
                    } else {
                        iMo4410e = this.f3966j.mo4410e(viewHolder.itemView) + i4;
                        iMo4410e2 = i3;
                    }
                }
                i5++;
                i3 = iMo4410e2;
                i4 = iMo4410e;
            }
            this.f3957a.f3991k = listM4615c;
            if (i3 > 0) {
                m4280h(m4527d(m4259M()), i);
                this.f3957a.f3988h = i3;
                this.f3957a.f3983c = 0;
                this.f3957a.m4335a();
                m4289a(recycler, this.f3957a, state, false);
            }
            if (i4 > 0) {
                m4263a(m4527d(m4260N()), i2);
                this.f3957a.f3988h = i4;
                this.f3957a.f3983c = 0;
                this.f3957a.m4335a();
                m4289a(recycler, this.f3957a, state, false);
            }
            this.f3957a.f3991k = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4269a(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!m4270a(state, anchorInfo) && !m4276b(recycler, state, anchorInfo)) {
            anchorInfo.m4330b();
            anchorInfo.f3973b = this.f3960d ? state.m4662e() - 1 : 0;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4276b(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View viewM4278g;
        int iMo4405c;
        if (m4561v() == 0) {
            return false;
        }
        View viewE = m4478E();
        if (viewE != null && anchorInfo.m4329a(viewE, state)) {
            anchorInfo.m4328a(viewE, m4527d(viewE));
            return true;
        }
        if (this.f3958b != this.f3960d) {
            return false;
        }
        if (anchorInfo.f3975d) {
            viewM4278g = m4277f(recycler, state);
        } else {
            viewM4278g = m4278g(recycler, state);
        }
        if (viewM4278g == null) {
            return false;
        }
        anchorInfo.m4331b(viewM4278g, m4527d(viewM4278g));
        if (!state.m4658a() && mo4228b()) {
            if (this.f3966j.mo4400a(viewM4278g) >= this.f3966j.mo4407d() || this.f3966j.mo4404b(viewM4278g) < this.f3966j.mo4405c()) {
                if (anchorInfo.f3975d) {
                    iMo4405c = this.f3966j.mo4407d();
                } else {
                    iMo4405c = this.f3966j.mo4405c();
                }
                anchorInfo.f3974c = iMo4405c;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4270a(RecyclerView.State state, AnchorInfo anchorInfo) {
        int iMo4400a;
        if (state.m4658a() || this.f3968l == -1) {
            return false;
        }
        if (this.f3968l < 0 || this.f3968l >= state.m4662e()) {
            this.f3968l = -1;
            this.f3969m = Integer.MIN_VALUE;
            return false;
        }
        anchorInfo.f3973b = this.f3968l;
        if (this.f3970n != null && this.f3970n.m4339a()) {
            anchorInfo.f3975d = this.f3970n.f3995c;
            if (anchorInfo.f3975d) {
                anchorInfo.f3974c = this.f3966j.mo4407d() - this.f3970n.f3994b;
                return true;
            }
            anchorInfo.f3974c = this.f3966j.mo4405c() + this.f3970n.f3994b;
            return true;
        }
        if (this.f3969m == Integer.MIN_VALUE) {
            View viewMo4305c = mo4305c(this.f3968l);
            if (viewMo4305c != null) {
                if (this.f3966j.mo4410e(viewMo4305c) > this.f3966j.mo4411f()) {
                    anchorInfo.m4330b();
                    return true;
                }
                if (this.f3966j.mo4400a(viewMo4305c) - this.f3966j.mo4405c() < 0) {
                    anchorInfo.f3974c = this.f3966j.mo4405c();
                    anchorInfo.f3975d = false;
                    return true;
                }
                if (this.f3966j.mo4407d() - this.f3966j.mo4404b(viewMo4305c) < 0) {
                    anchorInfo.f3974c = this.f3966j.mo4407d();
                    anchorInfo.f3975d = true;
                    return true;
                }
                if (anchorInfo.f3975d) {
                    iMo4400a = this.f3966j.mo4404b(viewMo4305c) + this.f3966j.m4403b();
                } else {
                    iMo4400a = this.f3966j.mo4400a(viewMo4305c);
                }
                anchorInfo.f3974c = iMo4400a;
                return true;
            }
            if (m4561v() > 0) {
                anchorInfo.f3975d = (this.f3968l < m4527d(m4544i(0))) == this.f3967k;
            }
            anchorInfo.m4330b();
            return true;
        }
        anchorInfo.f3975d = this.f3967k;
        if (this.f3967k) {
            anchorInfo.f3974c = this.f3966j.mo4407d() - this.f3969m;
            return true;
        }
        anchorInfo.f3974c = this.f3966j.mo4405c() + this.f3969m;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private int m4261a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iMo4407d;
        int iMo4407d2 = this.f3966j.mo4407d() - i;
        if (iMo4407d2 > 0) {
            int i2 = -m4303c(-iMo4407d2, recycler, state);
            int i3 = i + i2;
            if (z && (iMo4407d = this.f3966j.mo4407d() - i3) > 0) {
                this.f3966j.mo4402a(iMo4407d);
                return i2 + iMo4407d;
            }
            return i2;
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    private int m4271b(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iMo4405c;
        int iMo4405c2 = i - this.f3966j.mo4405c();
        if (iMo4405c2 > 0) {
            int i2 = -m4303c(iMo4405c2, recycler, state);
            int i3 = i + i2;
            if (z && (iMo4405c = i3 - this.f3966j.mo4405c()) > 0) {
                this.f3966j.mo4402a(-iMo4405c);
                return i2 - iMo4405c;
            }
            return i2;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private void m4265a(AnchorInfo anchorInfo) {
        m4263a(anchorInfo.f3973b, anchorInfo.f3974c);
    }

    /* JADX INFO: renamed from: a */
    private void m4263a(int i, int i2) {
        this.f3957a.f3983c = this.f3966j.mo4407d() - i2;
        this.f3957a.f3985e = this.f3967k ? -1 : 1;
        this.f3957a.f3984d = i;
        this.f3957a.f3986f = 1;
        this.f3957a.f3982b = i2;
        this.f3957a.f3987g = Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: b */
    private void m4273b(AnchorInfo anchorInfo) {
        m4280h(anchorInfo.f3973b, anchorInfo.f3974c);
    }

    /* JADX INFO: renamed from: h */
    private void m4280h(int i, int i2) {
        this.f3957a.f3983c = i2 - this.f3966j.mo4405c();
        this.f3957a.f3984d = i;
        this.f3957a.f3985e = this.f3967k ? 1 : -1;
        this.f3957a.f3986f = -1;
        this.f3957a.f3982b = i2;
        this.f3957a.f3987g = Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: h */
    protected boolean m4320h() {
        return m4559t() == 1;
    }

    /* JADX INFO: renamed from: i */
    void m4321i() {
        if (this.f3957a == null) {
            this.f3957a = m4322j();
        }
    }

    /* JADX INFO: renamed from: j */
    LayoutState m4322j() {
        return new LayoutState();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: e */
    public void mo4312e(int i) {
        this.f3968l = i;
        this.f3969m = Integer.MIN_VALUE;
        if (this.f3970n != null) {
            this.f3970n.m4340b();
        }
        m4554o();
    }

    /* JADX INFO: renamed from: b */
    public void m4301b(int i, int i2) {
        this.f3968l = i;
        this.f3969m = i2;
        if (this.f3970n != null) {
            this.f3970n.m4340b();
        }
        m4554o();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public int mo4204a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f3965i == 1) {
            return 0;
        }
        return m4303c(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public int mo4225b(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f3965i == 0) {
            return 0;
        }
        return m4303c(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public int mo4304c(RecyclerView.State state) {
        return m4281i(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: d */
    public int mo4308d(RecyclerView.State state) {
        return m4281i(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: e */
    public int mo4311e(RecyclerView.State state) {
        return m4283j(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: f */
    public int mo4315f(RecyclerView.State state) {
        return m4283j(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: g */
    public int mo4318g(RecyclerView.State state) {
        return m4285k(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: h */
    public int mo4319h(RecyclerView.State state) {
        return m4285k(state);
    }

    /* JADX INFO: renamed from: i */
    private int m4281i(RecyclerView.State state) {
        if (m4561v() == 0) {
            return 0;
        }
        m4321i();
        return ScrollbarHelper.m4716a(state, this.f3966j, m4262a(!this.f3961e, true), m4272b(this.f3961e ? false : true, true), this, this.f3961e, this.f3967k);
    }

    /* JADX INFO: renamed from: j */
    private int m4283j(RecyclerView.State state) {
        if (m4561v() == 0) {
            return 0;
        }
        m4321i();
        return ScrollbarHelper.m4715a(state, this.f3966j, m4262a(!this.f3961e, true), m4272b(this.f3961e ? false : true, true), this, this.f3961e);
    }

    /* JADX INFO: renamed from: k */
    private int m4285k(RecyclerView.State state) {
        if (m4561v() == 0) {
            return 0;
        }
        m4321i();
        return ScrollbarHelper.m4717b(state, this.f3966j, m4262a(!this.f3961e, true), m4272b(this.f3961e ? false : true, true), this, this.f3961e);
    }

    /* JADX INFO: renamed from: a */
    private void m4264a(int i, int i2, boolean z, RecyclerView.State state) {
        int iMo4405c;
        this.f3957a.f3992l = m4323k();
        this.f3957a.f3988h = m4299b(state);
        this.f3957a.f3986f = i;
        if (i == 1) {
            this.f3957a.f3988h += this.f3966j.mo4413g();
            View viewM4260N = m4260N();
            this.f3957a.f3985e = this.f3967k ? -1 : 1;
            this.f3957a.f3984d = m4527d(viewM4260N) + this.f3957a.f3985e;
            this.f3957a.f3982b = this.f3966j.mo4404b(viewM4260N);
            iMo4405c = this.f3966j.mo4404b(viewM4260N) - this.f3966j.mo4407d();
        } else {
            View viewM4259M = m4259M();
            this.f3957a.f3988h += this.f3966j.mo4405c();
            this.f3957a.f3985e = this.f3967k ? 1 : -1;
            this.f3957a.f3984d = m4527d(viewM4259M) + this.f3957a.f3985e;
            this.f3957a.f3982b = this.f3966j.mo4400a(viewM4259M);
            iMo4405c = (-this.f3966j.mo4400a(viewM4259M)) + this.f3966j.mo4405c();
        }
        this.f3957a.f3983c = i2;
        if (z) {
            this.f3957a.f3983c -= iMo4405c;
        }
        this.f3957a.f3987g = iMo4405c;
    }

    /* JADX INFO: renamed from: k */
    boolean m4323k() {
        return this.f3966j.mo4414h() == 0 && this.f3966j.mo4409e() == 0;
    }

    /* JADX INFO: renamed from: a */
    void mo4218a(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.f3984d;
        if (i >= 0 && i < state.m4662e()) {
            layoutPrefetchRegistry.mo4187b(i, Math.max(0, layoutState.f3987g));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4292a(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2;
        boolean z;
        if (this.f3970n != null && this.f3970n.m4339a()) {
            z = this.f3970n.f3995c;
            i2 = this.f3970n.f3993a;
        } else {
            m4258L();
            boolean z2 = this.f3967k;
            if (this.f3968l == -1) {
                i2 = z2 ? i - 1 : 0;
                z = z2;
            } else {
                i2 = this.f3968l;
                z = z2;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.f3964h && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.mo4187b(i2, 0);
            i2 += i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4291a(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.f3965i != 0) {
            i = i2;
        }
        if (m4561v() != 0 && i != 0) {
            m4321i();
            m4264a(i > 0 ? 1 : -1, Math.abs(i), true, state);
            mo4218a(state, this.f3957a, layoutPrefetchRegistry);
        }
    }

    /* JADX INFO: renamed from: c */
    int m4303c(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (m4561v() == 0 || i == 0) {
            return 0;
        }
        this.f3957a.f3981a = true;
        m4321i();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        m4264a(i2, iAbs, true, state);
        int iM4289a = this.f3957a.f3987g + m4289a(recycler, this.f3957a, state, false);
        if (iM4289a < 0) {
            return 0;
        }
        if (iAbs > iM4289a) {
            i = i2 * iM4289a;
        }
        this.f3966j.mo4402a(-i);
        this.f3957a.f3990j = i;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4298a(String str) {
        if (this.f3970n == null) {
            super.mo4298a(str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4267a(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m4485a(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                m4485a(i, recycler);
                i--;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4266a(RecyclerView.Recycler recycler, int i) {
        if (i >= 0) {
            int iV = m4561v();
            if (this.f3967k) {
                for (int i2 = iV - 1; i2 >= 0; i2--) {
                    View viewI = m4544i(i2);
                    if (this.f3966j.mo4404b(viewI) > i || this.f3966j.mo4406c(viewI) > i) {
                        m4267a(recycler, iV - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < iV; i3++) {
                View viewI2 = m4544i(i3);
                if (this.f3966j.mo4404b(viewI2) > i || this.f3966j.mo4406c(viewI2) > i) {
                    m4267a(recycler, 0, i3);
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4274b(RecyclerView.Recycler recycler, int i) {
        int iV = m4561v();
        if (i >= 0) {
            int iMo4409e = this.f3966j.mo4409e() - i;
            if (this.f3967k) {
                for (int i2 = 0; i2 < iV; i2++) {
                    View viewI = m4544i(i2);
                    if (this.f3966j.mo4400a(viewI) < iMo4409e || this.f3966j.mo4408d(viewI) < iMo4409e) {
                        m4267a(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = iV - 1; i3 >= 0; i3--) {
                View viewI2 = m4544i(i3);
                if (this.f3966j.mo4400a(viewI2) < iMo4409e || this.f3966j.mo4408d(viewI2) < iMo4409e) {
                    m4267a(recycler, iV - 1, i3);
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4268a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f3981a && !layoutState.f3992l) {
            if (layoutState.f3986f == -1) {
                m4274b(recycler, layoutState.f3987g);
            } else {
                m4266a(recycler, layoutState.f3987g);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m4289a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        int i = layoutState.f3983c;
        if (layoutState.f3987g != Integer.MIN_VALUE) {
            if (layoutState.f3983c < 0) {
                layoutState.f3987g += layoutState.f3983c;
            }
            m4268a(recycler, layoutState);
        }
        int i2 = layoutState.f3983c + layoutState.f3988h;
        LayoutChunkResult layoutChunkResult = this.f3963g;
        while (true) {
            if ((!layoutState.f3992l && i2 <= 0) || !layoutState.m4337a(state)) {
                break;
            }
            layoutChunkResult.m4332a();
            mo4215a(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f3978b) {
                layoutState.f3982b += layoutChunkResult.f3977a * layoutState.f3986f;
                if (!layoutChunkResult.f3979c || this.f3957a.f3991k != null || !state.m4658a()) {
                    layoutState.f3983c -= layoutChunkResult.f3977a;
                    i2 -= layoutChunkResult.f3977a;
                }
                if (layoutState.f3987g != Integer.MIN_VALUE) {
                    layoutState.f3987g += layoutChunkResult.f3977a;
                    if (layoutState.f3983c < 0) {
                        layoutState.f3987g += layoutState.f3983c;
                    }
                    m4268a(recycler, layoutState);
                }
                if (z && layoutChunkResult.f3980d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.f3983c;
    }

    /* JADX INFO: renamed from: a */
    void mo4215a(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int iB;
        int iMo4412f;
        int iA;
        int i;
        int iMo4412f2;
        View viewM4334a = layoutState.m4334a(recycler);
        if (viewM4334a == null) {
            layoutChunkResult.f3978b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM4334a.getLayoutParams();
        if (layoutState.f3991k == null) {
            if (this.f3967k == (layoutState.f3986f == -1)) {
                m4517b(viewM4334a);
            } else {
                m4518b(viewM4334a, 0);
            }
        } else {
            if (this.f3967k == (layoutState.f3986f == -1)) {
                m4493a(viewM4334a);
            } else {
                m4494a(viewM4334a, 0);
            }
        }
        m4495a(viewM4334a, 0, 0);
        layoutChunkResult.f3977a = this.f3966j.mo4410e(viewM4334a);
        if (this.f3965i == 1) {
            if (m4320h()) {
                iMo4412f2 = m4564y() - m4476C();
                iA = iMo4412f2 - this.f3966j.mo4412f(viewM4334a);
            } else {
                iA = m4474A();
                iMo4412f2 = this.f3966j.mo4412f(viewM4334a) + iA;
            }
            if (layoutState.f3986f == -1) {
                iMo4412f = layoutState.f3982b;
                iB = layoutState.f3982b - layoutChunkResult.f3977a;
                i = iMo4412f2;
            } else {
                iB = layoutState.f3982b;
                iMo4412f = layoutChunkResult.f3977a + layoutState.f3982b;
                i = iMo4412f2;
            }
        } else {
            iB = m4475B();
            iMo4412f = iB + this.f3966j.mo4412f(viewM4334a);
            if (layoutState.f3986f == -1) {
                int i2 = layoutState.f3982b;
                iA = layoutState.f3982b - layoutChunkResult.f3977a;
                i = i2;
            } else {
                iA = layoutState.f3982b;
                i = layoutState.f3982b + layoutChunkResult.f3977a;
            }
        }
        m4496a(viewM4334a, iA, iB, i, iMo4412f);
        if (layoutParams.m4572d() || layoutParams.m4573e()) {
            layoutChunkResult.f3979c = true;
        }
        layoutChunkResult.f3980d = viewM4334a.hasFocusable();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: l */
    boolean mo4324l() {
        return (m4563x() == 1073741824 || m4562w() == 1073741824 || !m4484K()) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    int m4314f(int i) {
        switch (i) {
            case 1:
                return (this.f3965i == 1 || !m4320h()) ? -1 : 1;
            case 2:
                return (this.f3965i != 1 && m4320h()) ? -1 : 1;
            case 17:
                return this.f3965i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f3965i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.f3965i != 0 ? Integer.MIN_VALUE : 1;
            case 130:
                return this.f3965i == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* JADX INFO: renamed from: M */
    private View m4259M() {
        return m4544i(this.f3967k ? m4561v() - 1 : 0);
    }

    /* JADX INFO: renamed from: N */
    private View m4260N() {
        return m4544i(this.f3967k ? 0 : m4561v() - 1);
    }

    /* JADX INFO: renamed from: a */
    private View m4262a(boolean z, boolean z2) {
        return this.f3967k ? m4290a(m4561v() - 1, -1, z, z2) : m4290a(0, m4561v(), z, z2);
    }

    /* JADX INFO: renamed from: b */
    private View m4272b(boolean z, boolean z2) {
        return this.f3967k ? m4290a(0, m4561v(), z, z2) : m4290a(m4561v() - 1, -1, z, z2);
    }

    /* JADX INFO: renamed from: f */
    private View m4277f(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3967k ? m4279h(recycler, state) : m4282i(recycler, state);
    }

    /* JADX INFO: renamed from: g */
    private View m4278g(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3967k ? m4282i(recycler, state) : m4279h(recycler, state);
    }

    /* JADX INFO: renamed from: h */
    private View m4279h(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo4209a(recycler, state, 0, m4561v(), state.m4662e());
    }

    /* JADX INFO: renamed from: i */
    private View m4282i(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo4209a(recycler, state, m4561v() - 1, -1, state.m4662e());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View mo4209a(android.support.v7.widget.RecyclerView.Recycler r8, android.support.v7.widget.RecyclerView.State r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            r2 = 0
            r7.m4321i()
            android.support.v7.widget.OrientationHelper r0 = r7.f3966j
            int r5 = r0.mo4405c()
            android.support.v7.widget.OrientationHelper r0 = r7.f3966j
            int r6 = r0.mo4407d()
            if (r11 <= r10) goto L36
            r0 = 1
            r1 = r0
        L14:
            r4 = r2
        L15:
            if (r10 == r11) goto L4e
            android.view.View r3 = r7.m4544i(r10)
            int r0 = r7.m4527d(r3)
            if (r0 < 0) goto L54
            if (r0 >= r12) goto L54
            android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
            android.support.v7.widget.RecyclerView$LayoutParams r0 = (android.support.v7.widget.RecyclerView.LayoutParams) r0
            boolean r0 = r0.m4572d()
            if (r0 == 0) goto L39
            if (r4 != 0) goto L54
            r0 = r2
        L32:
            int r10 = r10 + r1
            r2 = r0
            r4 = r3
            goto L15
        L36:
            r0 = -1
            r1 = r0
            goto L14
        L39:
            android.support.v7.widget.OrientationHelper r0 = r7.f3966j
            int r0 = r0.mo4400a(r3)
            if (r0 >= r6) goto L49
            android.support.v7.widget.OrientationHelper r0 = r7.f3966j
            int r0 = r0.mo4404b(r3)
            if (r0 >= r5) goto L51
        L49:
            if (r2 != 0) goto L54
            r0 = r3
            r3 = r4
            goto L32
        L4e:
            if (r2 == 0) goto L52
        L50:
            r3 = r2
        L51:
            return r3
        L52:
            r2 = r4
            goto L50
        L54:
            r0 = r2
            r3 = r4
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.mo4209a(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, int, int, int):android.view.View");
    }

    /* JADX INFO: renamed from: j */
    private View m4284j(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3967k ? m4287l(recycler, state) : m4288m(recycler, state);
    }

    /* JADX INFO: renamed from: k */
    private View m4286k(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3967k ? m4288m(recycler, state) : m4287l(recycler, state);
    }

    /* JADX INFO: renamed from: l */
    private View m4287l(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return m4306c(0, m4561v());
    }

    /* JADX INFO: renamed from: m */
    private View m4288m(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return m4306c(m4561v() - 1, -1);
    }

    /* JADX INFO: renamed from: m */
    public int m4325m() {
        View viewM4290a = m4290a(0, m4561v(), false, true);
        if (viewM4290a == null) {
            return -1;
        }
        return m4527d(viewM4290a);
    }

    /* JADX INFO: renamed from: n */
    public int m4326n() {
        View viewM4290a = m4290a(m4561v() - 1, -1, false, true);
        if (viewM4290a == null) {
            return -1;
        }
        return m4527d(viewM4290a);
    }

    /* JADX INFO: renamed from: a */
    View m4290a(int i, int i2, boolean z, boolean z2) {
        m4321i();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.f3965i == 0) {
            return this.f4081r.m5001a(i, i2, i3, i4);
        }
        return this.f4082s.m5001a(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: c */
    View m4306c(int i, int i2) {
        byte b;
        int i3;
        int i4;
        m4321i();
        if (i2 > i) {
            b = 1;
        } else {
            b = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b == 0) {
            return m4544i(i);
        }
        if (this.f3966j.mo4400a(m4544i(i)) < this.f3966j.mo4405c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.f3965i == 0) {
            return this.f4081r.m5001a(i, i2, i3, i4);
        }
        return this.f4082s.m5001a(i, i2, i3, i4);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public View mo4210a(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iM4314f;
        View viewM4284j;
        View viewM4260N;
        m4258L();
        if (m4561v() != 0 && (iM4314f = m4314f(i)) != Integer.MIN_VALUE) {
            m4321i();
            m4321i();
            m4264a(iM4314f, (int) (0.33333334f * this.f3966j.mo4411f()), false, state);
            this.f3957a.f3987g = Integer.MIN_VALUE;
            this.f3957a.f3981a = false;
            m4289a(recycler, this.f3957a, state, true);
            if (iM4314f == -1) {
                viewM4284j = m4286k(recycler, state);
            } else {
                viewM4284j = m4284j(recycler, state);
            }
            if (iM4314f == -1) {
                viewM4260N = m4259M();
            } else {
                viewM4260N = m4260N();
            }
            if (!viewM4260N.hasFocusable()) {
                return viewM4284j;
            }
            if (viewM4284j == null) {
                return null;
            }
            return viewM4260N;
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public boolean mo4228b() {
        return this.f3970n == null && this.f3958b == this.f3960d;
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler
    /* JADX INFO: renamed from: a */
    public void mo4296a(View view, View view2, int i, int i2) {
        mo4298a("Cannot drop a view during a scroll or layout calculation");
        m4321i();
        m4258L();
        int iD = m4527d(view);
        int iD2 = m4527d(view2);
        byte b = iD < iD2 ? (byte) 1 : (byte) -1;
        if (this.f3967k) {
            if (b == 1) {
                m4301b(iD2, this.f3966j.mo4407d() - (this.f3966j.mo4400a(view2) + this.f3966j.mo4410e(view)));
                return;
            } else {
                m4301b(iD2, this.f3966j.mo4407d() - this.f3966j.mo4404b(view2));
                return;
            }
        }
        if (b == -1) {
            m4301b(iD2, this.f3966j.mo4400a(view2));
        } else {
            m4301b(iD2, this.f3966j.mo4404b(view2) - this.f3966j.mo4410e(view));
        }
    }

    static class LayoutState {

        /* JADX INFO: renamed from: b */
        int f3982b;

        /* JADX INFO: renamed from: c */
        int f3983c;

        /* JADX INFO: renamed from: d */
        int f3984d;

        /* JADX INFO: renamed from: e */
        int f3985e;

        /* JADX INFO: renamed from: f */
        int f3986f;

        /* JADX INFO: renamed from: g */
        int f3987g;

        /* JADX INFO: renamed from: j */
        int f3990j;

        /* JADX INFO: renamed from: l */
        boolean f3992l;

        /* JADX INFO: renamed from: a */
        boolean f3981a = true;

        /* JADX INFO: renamed from: h */
        int f3988h = 0;

        /* JADX INFO: renamed from: i */
        boolean f3989i = false;

        /* JADX INFO: renamed from: k */
        List<RecyclerView.ViewHolder> f3991k = null;

        LayoutState() {
        }

        /* JADX INFO: renamed from: a */
        boolean m4337a(RecyclerView.State state) {
            return this.f3984d >= 0 && this.f3984d < state.m4662e();
        }

        /* JADX INFO: renamed from: a */
        View m4334a(RecyclerView.Recycler recycler) {
            if (this.f3991k != null) {
                return m4333b();
            }
            View viewM4614c = recycler.m4614c(this.f3984d);
            this.f3984d += this.f3985e;
            return viewM4614c;
        }

        /* JADX INFO: renamed from: b */
        private View m4333b() {
            int size = this.f3991k.size();
            for (int i = 0; i < size; i++) {
                View view = this.f3991k.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.m4572d() && this.f3984d == layoutParams.m4574f()) {
                    m4336a(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        public void m4335a() {
            m4336a((View) null);
        }

        /* JADX INFO: renamed from: a */
        public void m4336a(View view) {
            View viewM4338b = m4338b(view);
            if (viewM4338b == null) {
                this.f3984d = -1;
            } else {
                this.f3984d = ((RecyclerView.LayoutParams) viewM4338b.getLayoutParams()).m4574f();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.view.View m4338b(android.view.View r8) {
            /*
                r7 = this;
                java.util.List<android.support.v7.widget.RecyclerView$ViewHolder> r0 = r7.f3991k
                int r5 = r0.size()
                r2 = 0
                r1 = 2147483647(0x7fffffff, float:NaN)
                r0 = 0
                r4 = r0
            Lc:
                if (r4 >= r5) goto L47
                java.util.List<android.support.v7.widget.RecyclerView$ViewHolder> r0 = r7.f3991k
                java.lang.Object r0 = r0.get(r4)
                android.support.v7.widget.RecyclerView$ViewHolder r0 = (android.support.v7.widget.RecyclerView.ViewHolder) r0
                android.view.View r3 = r0.itemView
                android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
                android.support.v7.widget.RecyclerView$LayoutParams r0 = (android.support.v7.widget.RecyclerView.LayoutParams) r0
                if (r3 == r8) goto L44
                boolean r6 = r0.m4572d()
                if (r6 == 0) goto L2e
                r0 = r1
                r1 = r2
            L28:
                int r2 = r4 + 1
                r4 = r2
                r2 = r1
                r1 = r0
                goto Lc
            L2e:
                int r0 = r0.m4574f()
                int r6 = r7.f3984d
                int r0 = r0 - r6
                int r6 = r7.f3985e
                int r0 = r0 * r6
                if (r0 >= 0) goto L3d
                r0 = r1
                r1 = r2
                goto L28
            L3d:
                if (r0 >= r1) goto L44
                if (r0 != 0) goto L42
            L41:
                return r3
            L42:
                r1 = r3
                goto L28
            L44:
                r0 = r1
                r1 = r2
                goto L28
            L47:
                r3 = r2
                goto L41
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.LayoutState.m4338b(android.view.View):android.view.View");
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.LinearLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        int f3993a;

        /* JADX INFO: renamed from: b */
        int f3994b;

        /* JADX INFO: renamed from: c */
        boolean f3995c;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3993a = parcel.readInt();
            this.f3994b = parcel.readInt();
            this.f3995c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f3993a = savedState.f3993a;
            this.f3994b = savedState.f3994b;
            this.f3995c = savedState.f3995c;
        }

        /* JADX INFO: renamed from: a */
        boolean m4339a() {
            return this.f3993a >= 0;
        }

        /* JADX INFO: renamed from: b */
        void m4340b() {
            this.f3993a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3993a);
            parcel.writeInt(this.f3994b);
            parcel.writeInt(this.f3995c ? 1 : 0);
        }
    }

    static class AnchorInfo {

        /* JADX INFO: renamed from: a */
        OrientationHelper f3972a;

        /* JADX INFO: renamed from: b */
        int f3973b;

        /* JADX INFO: renamed from: c */
        int f3974c;

        /* JADX INFO: renamed from: d */
        boolean f3975d;

        /* JADX INFO: renamed from: e */
        boolean f3976e;

        AnchorInfo() {
            m4327a();
        }

        /* JADX INFO: renamed from: a */
        void m4327a() {
            this.f3973b = -1;
            this.f3974c = Integer.MIN_VALUE;
            this.f3975d = false;
            this.f3976e = false;
        }

        /* JADX INFO: renamed from: b */
        void m4330b() {
            int iMo4405c;
            if (this.f3975d) {
                iMo4405c = this.f3972a.mo4407d();
            } else {
                iMo4405c = this.f3972a.mo4405c();
            }
            this.f3974c = iMo4405c;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3973b + ", mCoordinate=" + this.f3974c + ", mLayoutFromEnd=" + this.f3975d + ", mValid=" + this.f3976e + '}';
        }

        /* JADX INFO: renamed from: a */
        boolean m4329a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.m4572d() && layoutParams.m4574f() >= 0 && layoutParams.m4574f() < state.m4662e();
        }

        /* JADX INFO: renamed from: a */
        public void m4328a(View view, int i) {
            int iM4403b = this.f3972a.m4403b();
            if (iM4403b >= 0) {
                m4331b(view, i);
                return;
            }
            this.f3973b = i;
            if (this.f3975d) {
                int iMo4407d = (this.f3972a.mo4407d() - iM4403b) - this.f3972a.mo4404b(view);
                this.f3974c = this.f3972a.mo4407d() - iMo4407d;
                if (iMo4407d > 0) {
                    int iMo4410e = this.f3974c - this.f3972a.mo4410e(view);
                    int iMo4405c = this.f3972a.mo4405c();
                    int iMin = iMo4410e - (iMo4405c + Math.min(this.f3972a.mo4400a(view) - iMo4405c, 0));
                    if (iMin < 0) {
                        this.f3974c = Math.min(iMo4407d, -iMin) + this.f3974c;
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo4400a = this.f3972a.mo4400a(view);
            int iMo4405c2 = iMo4400a - this.f3972a.mo4405c();
            this.f3974c = iMo4400a;
            if (iMo4405c2 > 0) {
                int iMo4407d2 = (this.f3972a.mo4407d() - Math.min(0, (this.f3972a.mo4407d() - iM4403b) - this.f3972a.mo4404b(view))) - (iMo4400a + this.f3972a.mo4410e(view));
                if (iMo4407d2 < 0) {
                    this.f3974c -= Math.min(iMo4405c2, -iMo4407d2);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public void m4331b(View view, int i) {
            if (this.f3975d) {
                this.f3974c = this.f3972a.mo4404b(view) + this.f3972a.m4403b();
            } else {
                this.f3974c = this.f3972a.mo4400a(view);
            }
            this.f3973b = i;
        }
    }

    protected static class LayoutChunkResult {

        /* JADX INFO: renamed from: a */
        public int f3977a;

        /* JADX INFO: renamed from: b */
        public boolean f3978b;

        /* JADX INFO: renamed from: c */
        public boolean f3979c;

        /* JADX INFO: renamed from: d */
        public boolean f3980d;

        protected LayoutChunkResult() {
        }

        /* JADX INFO: renamed from: a */
        void m4332a() {
            this.f3977a = 0;
            this.f3978b = false;
            this.f3979c = false;
            this.f3980d = false;
        }
    }
}
