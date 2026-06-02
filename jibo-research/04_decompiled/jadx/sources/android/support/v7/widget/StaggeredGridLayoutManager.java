package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: A */
    private SavedState f4297A;

    /* JADX INFO: renamed from: B */
    private int f4298B;

    /* JADX INFO: renamed from: G */
    private int[] f4303G;

    /* JADX INFO: renamed from: a */
    Span[] f4305a;

    /* JADX INFO: renamed from: b */
    OrientationHelper f4306b;

    /* JADX INFO: renamed from: c */
    OrientationHelper f4307c;

    /* JADX INFO: renamed from: j */
    private int f4314j;

    /* JADX INFO: renamed from: k */
    private int f4315k;

    /* JADX INFO: renamed from: l */
    private final LayoutState f4316l;

    /* JADX INFO: renamed from: m */
    private BitSet f4317m;

    /* JADX INFO: renamed from: o */
    private boolean f4319o;

    /* JADX INFO: renamed from: z */
    private boolean f4320z;

    /* JADX INFO: renamed from: i */
    private int f4313i = -1;

    /* JADX INFO: renamed from: d */
    boolean f4308d = false;

    /* JADX INFO: renamed from: e */
    boolean f4309e = false;

    /* JADX INFO: renamed from: f */
    int f4310f = -1;

    /* JADX INFO: renamed from: g */
    int f4311g = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: h */
    LazySpanLookup f4312h = new LazySpanLookup();

    /* JADX INFO: renamed from: n */
    private int f4318n = 2;

    /* JADX INFO: renamed from: C */
    private final Rect f4299C = new Rect();

    /* JADX INFO: renamed from: D */
    private final AnchorInfo f4300D = new AnchorInfo();

    /* JADX INFO: renamed from: E */
    private boolean f4301E = false;

    /* JADX INFO: renamed from: F */
    private boolean f4302F = true;

    /* JADX INFO: renamed from: H */
    private final Runnable f4304H = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m4853g();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties propertiesA = m4465a(context, attributeSet, i, i2);
        m4848b(propertiesA.f4091a);
        m4843a(propertiesA.f4092b);
        m4846a(propertiesA.f4093c);
        this.f4316l = new LayoutState();
        m4802N();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f4314j = i2;
        m4843a(i);
        this.f4316l = new LayoutState();
        m4802N();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public boolean mo4307c() {
        return this.f4318n != 0;
    }

    /* JADX INFO: renamed from: N */
    private void m4802N() {
        this.f4306b = OrientationHelper.m4398a(this, this.f4314j);
        this.f4307c = OrientationHelper.m4398a(this, 1 - this.f4314j);
    }

    /* JADX INFO: renamed from: g */
    boolean m4853g() {
        int iM4842M;
        int iM4841L;
        if (m4561v() == 0 || this.f4318n == 0 || !m4556q()) {
            return false;
        }
        if (this.f4309e) {
            iM4842M = m4841L();
            iM4841L = m4842M();
        } else {
            iM4842M = m4842M();
            iM4841L = m4841L();
        }
        if (iM4842M == 0 && m4854h() != null) {
            this.f4312h.m4871a();
            m4483J();
            m4554o();
            return true;
        }
        if (!this.f4301E) {
            return false;
        }
        int i = this.f4309e ? -1 : 1;
        LazySpanLookup.FullSpanItem fullSpanItemM4870a = this.f4312h.m4870a(iM4842M, iM4841L + 1, i, true);
        if (fullSpanItemM4870a == null) {
            this.f4301E = false;
            this.f4312h.m4869a(iM4841L + 1);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemM4870a2 = this.f4312h.m4870a(iM4842M, fullSpanItemM4870a.f4333a, i * (-1), true);
        if (fullSpanItemM4870a2 == null) {
            this.f4312h.m4869a(fullSpanItemM4870a.f4333a);
        } else {
            this.f4312h.m4869a(fullSpanItemM4870a2.f4333a + 1);
        }
        m4483J();
        m4554o();
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: l */
    public void mo4550l(int i) {
        if (i == 0) {
            m4853g();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4294a(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        m4513a(this.f4304H);
        for (int i = 0; i < this.f4313i; i++) {
            this.f4305a[i].m4903e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005d A[SYNTHETIC] */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View m4854h() {
        /*
            r12 = this;
            r0 = -1
            r5 = 0
            r3 = 1
            int r1 = r12.m4561v()
            int r1 = r1 + (-1)
            java.util.BitSet r9 = new java.util.BitSet
            int r2 = r12.f4313i
            r9.<init>(r2)
            int r2 = r12.f4313i
            r9.set(r5, r2, r3)
            int r2 = r12.f4314j
            if (r2 != r3) goto L49
            boolean r2 = r12.m4856j()
            if (r2 == 0) goto L49
            r2 = r3
        L20:
            boolean r4 = r12.f4309e
            if (r4 == 0) goto L4b
            r8 = r0
        L25:
            if (r1 >= r8) goto L50
            r4 = r3
        L28:
            r7 = r1
        L29:
            if (r7 == r8) goto Lb5
            android.view.View r6 = r12.m4544i(r7)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams r0 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r0
            android.support.v7.widget.StaggeredGridLayoutManager$Span r1 = r0.f4329a
            int r1 = r1.f4351e
            boolean r1 = r9.get(r1)
            if (r1 == 0) goto L59
            android.support.v7.widget.StaggeredGridLayoutManager$Span r1 = r0.f4329a
            boolean r1 = r12.m4816a(r1)
            if (r1 == 0) goto L52
            r0 = r6
        L48:
            return r0
        L49:
            r2 = r0
            goto L20
        L4b:
            int r1 = r1 + 1
            r8 = r1
            r1 = r5
            goto L25
        L50:
            r4 = r0
            goto L28
        L52:
            android.support.v7.widget.StaggeredGridLayoutManager$Span r1 = r0.f4329a
            int r1 = r1.f4351e
            r9.clear(r1)
        L59:
            boolean r1 = r0.f4330b
            if (r1 == 0) goto L61
        L5d:
            int r0 = r7 + r4
            r7 = r0
            goto L29
        L61:
            int r1 = r7 + r4
            if (r1 == r8) goto L5d
            int r1 = r7 + r4
            android.view.View r10 = r12.m4544i(r1)
            boolean r1 = r12.f4309e
            if (r1 == 0) goto L9d
            android.support.v7.widget.OrientationHelper r1 = r12.f4306b
            int r1 = r1.mo4404b(r6)
            android.support.v7.widget.OrientationHelper r11 = r12.f4306b
            int r11 = r11.mo4404b(r10)
            if (r1 >= r11) goto L7f
            r0 = r6
            goto L48
        L7f:
            if (r1 != r11) goto Lb7
            r1 = r3
        L82:
            if (r1 == 0) goto L5d
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams r1 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r1
            android.support.v7.widget.StaggeredGridLayoutManager$Span r0 = r0.f4329a
            int r0 = r0.f4351e
            android.support.v7.widget.StaggeredGridLayoutManager$Span r1 = r1.f4329a
            int r1 = r1.f4351e
            int r0 = r0 - r1
            if (r0 >= 0) goto Lb1
            r1 = r3
        L96:
            if (r2 >= 0) goto Lb3
            r0 = r3
        L99:
            if (r1 == r0) goto L5d
            r0 = r6
            goto L48
        L9d:
            android.support.v7.widget.OrientationHelper r1 = r12.f4306b
            int r1 = r1.mo4400a(r6)
            android.support.v7.widget.OrientationHelper r11 = r12.f4306b
            int r11 = r11.mo4400a(r10)
            if (r1 <= r11) goto Lad
            r0 = r6
            goto L48
        Lad:
            if (r1 != r11) goto Lb7
            r1 = r3
            goto L82
        Lb1:
            r1 = r5
            goto L96
        Lb3:
            r0 = r5
            goto L99
        Lb5:
            r0 = 0
            goto L48
        Lb7:
            r1 = r5
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.m4854h():android.view.View");
    }

    /* JADX INFO: renamed from: a */
    private boolean m4816a(Span span) {
        if (this.f4309e) {
            if (span.m4901d() < this.f4306b.mo4407d()) {
                return !span.m4898c(span.f4347a.get(span.f4347a.size() + (-1))).f4330b;
            }
        } else if (span.m4895b() > this.f4306b.mo4405c()) {
            return span.m4898c(span.f4347a.get(0)).f4330b ? false : true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m4843a(int i) {
        mo4298a((String) null);
        if (i != this.f4313i) {
            m4855i();
            this.f4313i = i;
            this.f4317m = new BitSet(this.f4313i);
            this.f4305a = new Span[this.f4313i];
            for (int i2 = 0; i2 < this.f4313i; i2++) {
                this.f4305a[i2] = new Span(i2);
            }
            m4554o();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4848b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        mo4298a((String) null);
        if (i != this.f4314j) {
            this.f4314j = i;
            OrientationHelper orientationHelper = this.f4306b;
            this.f4306b = this.f4307c;
            this.f4307c = orientationHelper;
            m4554o();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4846a(boolean z) {
        mo4298a((String) null);
        if (this.f4297A != null && this.f4297A.f4344h != z) {
            this.f4297A.f4344h = z;
        }
        this.f4308d = z;
        m4554o();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4298a(String str) {
        if (this.f4297A == null) {
            super.mo4298a(str);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m4855i() {
        this.f4312h.m4871a();
        m4554o();
    }

    /* JADX INFO: renamed from: O */
    private void m4803O() {
        if (this.f4314j == 1 || !m4856j()) {
            this.f4309e = this.f4308d;
        } else {
            this.f4309e = this.f4308d ? false : true;
        }
    }

    /* JADX INFO: renamed from: j */
    boolean m4856j() {
        return m4559t() == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4212a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        int iC = m4476C() + m4474A();
        int iB = m4475B() + m4477D();
        if (this.f4314j == 1) {
            iA2 = m4463a(i2, iB + rect.height(), m4481H());
            iA = m4463a(i, iC + (this.f4315k * this.f4313i), m4480G());
        } else {
            iA = m4463a(i, iC + rect.width(), m4480G());
            iA2 = m4463a(i2, iB + (this.f4315k * this.f4313i), m4481H());
        }
        m4540g(iA, iA2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public void mo4229c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        m4810a(recycler, state, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0187  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4810a(android.support.v7.widget.RecyclerView.Recycler r9, android.support.v7.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.m4810a(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, boolean):void");
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4217a(RecyclerView.State state) {
        super.mo4217a(state);
        this.f4310f = -1;
        this.f4311g = Integer.MIN_VALUE;
        this.f4297A = null;
        this.f4300D.m4860a();
    }

    /* JADX INFO: renamed from: P */
    private void m4804P() {
        float fMax;
        if (this.f4307c.mo4414h() != 1073741824) {
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            int iV = m4561v();
            int i = 0;
            while (i < iV) {
                View viewI = m4544i(i);
                float fMo4410e = this.f4307c.mo4410e(viewI);
                if (fMo4410e < f) {
                    fMax = f;
                } else {
                    fMax = Math.max(f, ((LayoutParams) viewI.getLayoutParams()).m4864a() ? (1.0f * fMo4410e) / this.f4313i : fMo4410e);
                }
                i++;
                f = fMax;
            }
            int i2 = this.f4315k;
            int iRound = Math.round(this.f4313i * f);
            if (this.f4307c.mo4414h() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, this.f4307c.mo4411f());
            }
            m4852f(iRound);
            if (this.f4315k != i2) {
                for (int i3 = 0; i3 < iV; i3++) {
                    View viewI2 = m4544i(i3);
                    LayoutParams layoutParams = (LayoutParams) viewI2.getLayoutParams();
                    if (!layoutParams.f4330b) {
                        if (m4856j() && this.f4314j == 1) {
                            viewI2.offsetLeftAndRight(((-((this.f4313i - 1) - layoutParams.f4329a.f4351e)) * this.f4315k) - ((-((this.f4313i - 1) - layoutParams.f4329a.f4351e)) * i2));
                        } else {
                            int i4 = layoutParams.f4329a.f4351e * this.f4315k;
                            int i5 = layoutParams.f4329a.f4351e * i2;
                            if (this.f4314j == 1) {
                                viewI2.offsetLeftAndRight(i4 - i5);
                            } else {
                                viewI2.offsetTopAndBottom(i4 - i5);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4811a(AnchorInfo anchorInfo) {
        if (this.f4297A.f4339c > 0) {
            if (this.f4297A.f4339c == this.f4313i) {
                for (int i = 0; i < this.f4313i; i++) {
                    this.f4305a[i].m4903e();
                    int iMo4405c = this.f4297A.f4340d[i];
                    if (iMo4405c != Integer.MIN_VALUE) {
                        if (this.f4297A.f4345i) {
                            iMo4405c += this.f4306b.mo4407d();
                        } else {
                            iMo4405c += this.f4306b.mo4405c();
                        }
                    }
                    this.f4305a[i].m4900c(iMo4405c);
                }
            } else {
                this.f4297A.m4884a();
                this.f4297A.f4337a = this.f4297A.f4338b;
            }
        }
        this.f4320z = this.f4297A.f4346j;
        m4846a(this.f4297A.f4344h);
        m4803O();
        if (this.f4297A.f4337a != -1) {
            this.f4310f = this.f4297A.f4337a;
            anchorInfo.f4324c = this.f4297A.f4345i;
        } else {
            anchorInfo.f4324c = this.f4309e;
        }
        if (this.f4297A.f4341e > 1) {
            this.f4312h.f4331a = this.f4297A.f4342f;
            this.f4312h.f4332b = this.f4297A.f4343g;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4845a(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!m4849b(state, anchorInfo) && !m4824c(state, anchorInfo)) {
            anchorInfo.m4863b();
            anchorInfo.f4322a = 0;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m4824c(RecyclerView.State state, AnchorInfo anchorInfo) {
        int iM4838v;
        if (this.f4319o) {
            iM4838v = m4839w(state.m4662e());
        } else {
            iM4838v = m4838v(state.m4662e());
        }
        anchorInfo.f4322a = iM4838v;
        anchorInfo.f4323b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX INFO: renamed from: b */
    boolean m4849b(RecyclerView.State state, AnchorInfo anchorInfo) {
        int iMo4405c;
        if (state.m4658a() || this.f4310f == -1) {
            return false;
        }
        if (this.f4310f < 0 || this.f4310f >= state.m4662e()) {
            this.f4310f = -1;
            this.f4311g = Integer.MIN_VALUE;
            return false;
        }
        if (this.f4297A == null || this.f4297A.f4337a == -1 || this.f4297A.f4339c < 1) {
            View viewC = mo4305c(this.f4310f);
            if (viewC != null) {
                anchorInfo.f4322a = this.f4309e ? m4841L() : m4842M();
                if (this.f4311g != Integer.MIN_VALUE) {
                    if (anchorInfo.f4324c) {
                        anchorInfo.f4323b = (this.f4306b.mo4407d() - this.f4311g) - this.f4306b.mo4404b(viewC);
                        return true;
                    }
                    anchorInfo.f4323b = (this.f4306b.mo4405c() + this.f4311g) - this.f4306b.mo4400a(viewC);
                    return true;
                }
                if (this.f4306b.mo4410e(viewC) > this.f4306b.mo4411f()) {
                    if (anchorInfo.f4324c) {
                        iMo4405c = this.f4306b.mo4407d();
                    } else {
                        iMo4405c = this.f4306b.mo4405c();
                    }
                    anchorInfo.f4323b = iMo4405c;
                    return true;
                }
                int iMo4400a = this.f4306b.mo4400a(viewC) - this.f4306b.mo4405c();
                if (iMo4400a < 0) {
                    anchorInfo.f4323b = -iMo4400a;
                    return true;
                }
                int iMo4407d = this.f4306b.mo4407d() - this.f4306b.mo4404b(viewC);
                if (iMo4407d < 0) {
                    anchorInfo.f4323b = iMo4407d;
                    return true;
                }
                anchorInfo.f4323b = Integer.MIN_VALUE;
                return true;
            }
            anchorInfo.f4322a = this.f4310f;
            if (this.f4311g == Integer.MIN_VALUE) {
                anchorInfo.f4324c = m4837u(anchorInfo.f4322a) == 1;
                anchorInfo.m4863b();
            } else {
                anchorInfo.m4861a(this.f4311g);
            }
            anchorInfo.f4325d = true;
            return true;
        }
        anchorInfo.f4323b = Integer.MIN_VALUE;
        anchorInfo.f4322a = this.f4310f;
        return true;
    }

    /* JADX INFO: renamed from: f */
    void m4852f(int i) {
        this.f4315k = i / this.f4313i;
        this.f4298B = View.MeasureSpec.makeMeasureSpec(i, this.f4307c.mo4414h());
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public boolean mo4228b() {
        return this.f4297A == null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public int mo4304c(RecyclerView.State state) {
        return m4818b(state);
    }

    /* JADX INFO: renamed from: b */
    private int m4818b(RecyclerView.State state) {
        if (m4561v() == 0) {
            return 0;
        }
        return ScrollbarHelper.m4716a(state, this.f4306b, m4847b(!this.f4302F), m4851c(this.f4302F ? false : true), this, this.f4302F, this.f4309e);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: d */
    public int mo4308d(RecyclerView.State state) {
        return m4818b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: e */
    public int mo4311e(RecyclerView.State state) {
        return m4825i(state);
    }

    /* JADX INFO: renamed from: i */
    private int m4825i(RecyclerView.State state) {
        if (m4561v() == 0) {
            return 0;
        }
        return ScrollbarHelper.m4715a(state, this.f4306b, m4847b(!this.f4302F), m4851c(this.f4302F ? false : true), this, this.f4302F);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: f */
    public int mo4315f(RecyclerView.State state) {
        return m4825i(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: g */
    public int mo4318g(RecyclerView.State state) {
        return m4826j(state);
    }

    /* JADX INFO: renamed from: j */
    private int m4826j(RecyclerView.State state) {
        if (m4561v() == 0) {
            return 0;
        }
        return ScrollbarHelper.m4717b(state, this.f4306b, m4847b(!this.f4302F), m4851c(this.f4302F ? false : true), this, this.f4302F);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: h */
    public int mo4319h(RecyclerView.State state) {
        return m4826j(state);
    }

    /* JADX INFO: renamed from: a */
    private void m4815a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f4330b) {
            if (this.f4314j == 1) {
                m4813a(view, this.f4298B, m4464a(m4565z(), m4563x(), m4475B() + m4477D(), layoutParams.height, true), z);
                return;
            } else {
                m4813a(view, m4464a(m4564y(), m4562w(), m4474A() + m4476C(), layoutParams.width, true), this.f4298B, z);
                return;
            }
        }
        if (this.f4314j == 1) {
            m4813a(view, m4464a(this.f4315k, m4562w(), 0, layoutParams.width, false), m4464a(m4565z(), m4563x(), m4475B() + m4477D(), layoutParams.height, true), z);
        } else {
            m4813a(view, m4464a(m4564y(), m4562w(), m4474A() + m4476C(), layoutParams.width, true), m4464a(this.f4315k, m4563x(), 0, layoutParams.height, false), z);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4813a(View view, int i, int i2, boolean z) {
        boolean zB;
        m4519b(view, this.f4299C);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iM4817b = m4817b(i, layoutParams.leftMargin + this.f4299C.left, layoutParams.rightMargin + this.f4299C.right);
        int iM4817b2 = m4817b(i2, layoutParams.topMargin + this.f4299C.top, layoutParams.bottomMargin + this.f4299C.bottom);
        if (z) {
            zB = m4510a(view, iM4817b, iM4817b2, layoutParams);
        } else {
            zB = m4520b(view, iM4817b, iM4817b2, layoutParams);
        }
        if (zB) {
            view.measure(iM4817b, iM4817b2);
        }
    }

    /* JADX INFO: renamed from: b */
    private int m4817b(int i, int i2, int i3) {
        if (i2 != 0 || i3 != 0) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
            }
            return i;
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4293a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f4297A = (SavedState) parcelable;
            m4554o();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: d */
    public Parcelable mo4310d() {
        int iM4888a;
        if (this.f4297A != null) {
            return new SavedState(this.f4297A);
        }
        SavedState savedState = new SavedState();
        savedState.f4344h = this.f4308d;
        savedState.f4345i = this.f4319o;
        savedState.f4346j = this.f4320z;
        if (this.f4312h != null && this.f4312h.f4331a != null) {
            savedState.f4342f = this.f4312h.f4331a;
            savedState.f4341e = savedState.f4342f.length;
            savedState.f4343g = this.f4312h.f4332b;
        } else {
            savedState.f4341e = 0;
        }
        if (m4561v() > 0) {
            savedState.f4337a = this.f4319o ? m4841L() : m4842M();
            savedState.f4338b = m4857k();
            savedState.f4339c = this.f4313i;
            savedState.f4340d = new int[this.f4313i];
            for (int i = 0; i < this.f4313i; i++) {
                if (this.f4319o) {
                    iM4888a = this.f4305a[i].m4896b(Integer.MIN_VALUE);
                    if (iM4888a != Integer.MIN_VALUE) {
                        iM4888a -= this.f4306b.mo4407d();
                    }
                } else {
                    iM4888a = this.f4305a[i].m4888a(Integer.MIN_VALUE);
                    if (iM4888a != Integer.MIN_VALUE) {
                        iM4888a -= this.f4306b.mo4405c();
                    }
                }
                savedState.f4340d[i] = iM4888a;
            }
        } else {
            savedState.f4337a = -1;
            savedState.f4338b = -1;
            savedState.f4339c = 0;
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4216a(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.m4499a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f4314j == 0) {
            accessibilityNodeInfoCompat.m2794b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.m2835a(layoutParams2.m4865b(), layoutParams2.f4330b ? this.f4313i : 1, -1, -1, layoutParams2.f4330b, false));
        } else {
            accessibilityNodeInfoCompat.m2794b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.m2835a(-1, -1, layoutParams2.m4865b(), layoutParams2.f4330b ? this.f4313i : 1, layoutParams2.f4330b, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4297a(AccessibilityEvent accessibilityEvent) {
        super.mo4297a(accessibilityEvent);
        if (m4561v() > 0) {
            View viewM4847b = m4847b(false);
            View viewM4851c = m4851c(false);
            if (viewM4847b != null && viewM4851c != null) {
                int iD = m4527d(viewM4847b);
                int iD2 = m4527d(viewM4851c);
                if (iD < iD2) {
                    accessibilityEvent.setFromIndex(iD);
                    accessibilityEvent.setToIndex(iD2);
                } else {
                    accessibilityEvent.setFromIndex(iD2);
                    accessibilityEvent.setToIndex(iD);
                }
            }
        }
    }

    /* JADX INFO: renamed from: k */
    int m4857k() {
        View viewM4851c = this.f4309e ? m4851c(true) : m4847b(true);
        if (viewM4851c == null) {
            return -1;
        }
        return m4527d(viewM4851c);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public int mo4205a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f4314j == 0 ? this.f4313i : super.mo4205a(recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public int mo4226b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f4314j == 1 ? this.f4313i : super.mo4226b(recycler, state);
    }

    /* JADX INFO: renamed from: b */
    View m4847b(boolean z) {
        int iMo4405c = this.f4306b.mo4405c();
        int iMo4407d = this.f4306b.mo4407d();
        int iV = m4561v();
        View view = null;
        for (int i = 0; i < iV; i++) {
            View viewI = m4544i(i);
            int iMo4400a = this.f4306b.mo4400a(viewI);
            if (this.f4306b.mo4404b(viewI) > iMo4405c && iMo4400a < iMo4407d) {
                if (iMo4400a < iMo4405c && z) {
                    if (view == null) {
                        view = viewI;
                    }
                } else {
                    return viewI;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: c */
    View m4851c(boolean z) {
        int iMo4405c = this.f4306b.mo4405c();
        int iMo4407d = this.f4306b.mo4407d();
        View view = null;
        for (int iV = m4561v() - 1; iV >= 0; iV--) {
            View viewI = m4544i(iV);
            int iMo4400a = this.f4306b.mo4400a(viewI);
            int iMo4404b = this.f4306b.mo4404b(viewI);
            if (iMo4404b > iMo4405c && iMo4400a < iMo4407d) {
                if (iMo4404b > iMo4407d && z) {
                    if (view == null) {
                        view = viewI;
                    }
                } else {
                    return viewI;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: b */
    private void m4821b(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iMo4407d;
        int iM4834r = m4834r(Integer.MIN_VALUE);
        if (iM4834r != Integer.MIN_VALUE && (iMo4407d = this.f4306b.mo4407d() - iM4834r) > 0) {
            int i = iMo4407d - (-m4850c(-iMo4407d, recycler, state));
            if (z && i > 0) {
                this.f4306b.mo4402a(i);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4823c(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iMo4405c;
        int iM4832q = m4832q(Integer.MAX_VALUE);
        if (iM4832q != Integer.MAX_VALUE && (iMo4405c = iM4832q - this.f4306b.mo4405c()) > 0) {
            int iM4850c = iMo4405c - m4850c(iMo4405c, recycler, state);
            if (z && iM4850c > 0) {
                this.f4306b.mo4402a(-iM4850c);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4819b(int i, RecyclerView.State state) {
        int iMo4411f;
        int iMo4411f2;
        int iM4660c;
        boolean z = false;
        this.f4316l.f3932b = 0;
        this.f4316l.f3933c = i;
        if (!m4558s() || (iM4660c = state.m4660c()) == -1) {
            iMo4411f = 0;
            iMo4411f2 = 0;
        } else {
            if (this.f4309e == (iM4660c < i)) {
                iMo4411f = this.f4306b.mo4411f();
                iMo4411f2 = 0;
            } else {
                iMo4411f2 = this.f4306b.mo4411f();
                iMo4411f = 0;
            }
        }
        if (m4557r()) {
            this.f4316l.f3936f = this.f4306b.mo4405c() - iMo4411f2;
            this.f4316l.f3937g = iMo4411f + this.f4306b.mo4407d();
        } else {
            this.f4316l.f3937g = iMo4411f + this.f4306b.mo4409e();
            this.f4316l.f3936f = -iMo4411f2;
        }
        this.f4316l.f3938h = false;
        this.f4316l.f3931a = true;
        LayoutState layoutState = this.f4316l;
        if (this.f4306b.mo4414h() == 0 && this.f4306b.mo4409e() == 0) {
            z = true;
        }
        layoutState.f3939i = z;
    }

    /* JADX INFO: renamed from: m */
    private void m4827m(int i) {
        this.f4316l.f3935e = i;
        this.f4316l.f3934d = this.f4309e != (i == -1) ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: j */
    public void mo4546j(int i) {
        super.mo4546j(i);
        for (int i2 = 0; i2 < this.f4313i; i2++) {
            this.f4305a[i2].m4902d(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: k */
    public void mo4548k(int i) {
        super.mo4548k(i);
        for (int i2 = 0; i2 < this.f4313i; i2++) {
            this.f4305a[i2].m4902d(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public void mo4227b(RecyclerView recyclerView, int i, int i2) {
        m4822c(i, i2, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4220a(RecyclerView recyclerView, int i, int i2) {
        m4822c(i, i2, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4219a(RecyclerView recyclerView) {
        this.f4312h.m4871a();
        m4554o();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4221a(RecyclerView recyclerView, int i, int i2, int i3) {
        m4822c(i, i2, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4222a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m4822c(i, i2, 4);
    }

    /* JADX INFO: renamed from: c */
    private void m4822c(int i, int i2, int i3) {
        int i4;
        int i5;
        int iM4841L = this.f4309e ? m4841L() : m4842M();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
                i5 = i;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
        } else {
            i4 = i + i2;
            i5 = i;
        }
        this.f4312h.m4875b(i5);
        switch (i3) {
            case 1:
                this.f4312h.m4876b(i, i2);
                break;
            case 2:
                this.f4312h.m4872a(i, i2);
                break;
            case 8:
                this.f4312h.m4872a(i, 1);
                this.f4312h.m4876b(i2, 1);
                break;
        }
        if (i4 > iM4841L) {
            if (i5 <= (this.f4309e ? m4842M() : m4841L())) {
                m4554o();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m4805a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        int iMo4405c;
        int iM4834r;
        Span span;
        int iMo4410e;
        int iMo4410e2;
        int iMo4410e3;
        int iMo4410e4;
        boolean z;
        this.f4317m.set(0, this.f4313i, true);
        if (this.f4316l.f3939i) {
            if (layoutState.f3935e == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (layoutState.f3935e == 1) {
            i = layoutState.f3937g + layoutState.f3932b;
        } else {
            i = layoutState.f3936f - layoutState.f3932b;
        }
        m4807a(layoutState.f3935e, i);
        if (this.f4309e) {
            iMo4405c = this.f4306b.mo4407d();
        } else {
            iMo4405c = this.f4306b.mo4405c();
        }
        boolean z2 = false;
        while (layoutState.m4239a(state) && (this.f4316l.f3939i || !this.f4317m.isEmpty())) {
            View viewM4238a = layoutState.m4238a(recycler);
            LayoutParams layoutParams = (LayoutParams) viewM4238a.getLayoutParams();
            int iF = layoutParams.m4574f();
            int iM4877c = this.f4312h.m4877c(iF);
            boolean z3 = iM4877c == -1;
            if (z3) {
                Span spanM4806a = layoutParams.f4330b ? this.f4305a[0] : m4806a(layoutState);
                this.f4312h.m4873a(iF, spanM4806a);
                span = spanM4806a;
            } else {
                span = this.f4305a[iM4877c];
            }
            layoutParams.f4329a = span;
            if (layoutState.f3935e == 1) {
                m4517b(viewM4238a);
            } else {
                m4518b(viewM4238a, 0);
            }
            m4815a(viewM4238a, layoutParams, false);
            if (layoutState.f3935e == 1) {
                int iM4834r2 = layoutParams.f4330b ? m4834r(iMo4405c) : span.m4896b(iMo4405c);
                iMo4410e2 = iM4834r2 + this.f4306b.mo4410e(viewM4238a);
                if (z3 && layoutParams.f4330b) {
                    LazySpanLookup.FullSpanItem fullSpanItemM4828n = m4828n(iM4834r2);
                    fullSpanItemM4828n.f4334b = -1;
                    fullSpanItemM4828n.f4333a = iF;
                    this.f4312h.m4874a(fullSpanItemM4828n);
                    iMo4410e = iM4834r2;
                } else {
                    iMo4410e = iM4834r2;
                }
            } else {
                int iM4832q = layoutParams.f4330b ? m4832q(iMo4405c) : span.m4888a(iMo4405c);
                iMo4410e = iM4832q - this.f4306b.mo4410e(viewM4238a);
                if (z3 && layoutParams.f4330b) {
                    LazySpanLookup.FullSpanItem fullSpanItemM4829o = m4829o(iM4832q);
                    fullSpanItemM4829o.f4334b = 1;
                    fullSpanItemM4829o.f4333a = iF;
                    this.f4312h.m4874a(fullSpanItemM4829o);
                }
                iMo4410e2 = iM4832q;
            }
            if (layoutParams.f4330b && layoutState.f3934d == -1) {
                if (z3) {
                    this.f4301E = true;
                } else {
                    if (layoutState.f3935e == 1) {
                        z = !m4858m();
                    } else {
                        z = !m4859n();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem fullSpanItemM4880f = this.f4312h.m4880f(iF);
                        if (fullSpanItemM4880f != null) {
                            fullSpanItemM4880f.f4336d = true;
                        }
                        this.f4301E = true;
                    }
                }
            }
            m4814a(viewM4238a, layoutParams, layoutState);
            if (m4856j() && this.f4314j == 1) {
                int iMo4407d = layoutParams.f4330b ? this.f4307c.mo4407d() : this.f4307c.mo4407d() - (((this.f4313i - 1) - span.f4351e) * this.f4315k);
                iMo4410e4 = iMo4407d - this.f4307c.mo4410e(viewM4238a);
                iMo4410e3 = iMo4407d;
            } else {
                int iMo4405c2 = layoutParams.f4330b ? this.f4307c.mo4405c() : (span.f4351e * this.f4315k) + this.f4307c.mo4405c();
                iMo4410e3 = iMo4405c2 + this.f4307c.mo4410e(viewM4238a);
                iMo4410e4 = iMo4405c2;
            }
            if (this.f4314j == 1) {
                m4496a(viewM4238a, iMo4410e4, iMo4410e, iMo4410e3, iMo4410e2);
            } else {
                m4496a(viewM4238a, iMo4410e, iMo4410e4, iMo4410e2, iMo4410e3);
            }
            if (layoutParams.f4330b) {
                m4807a(this.f4316l.f3935e, i);
            } else {
                m4812a(span, this.f4316l.f3935e, i);
            }
            m4809a(recycler, this.f4316l);
            if (this.f4316l.f3938h && viewM4238a.hasFocusable()) {
                if (layoutParams.f4330b) {
                    this.f4317m.clear();
                } else {
                    this.f4317m.set(span.f4351e, false);
                }
            }
            z2 = true;
        }
        if (!z2) {
            m4809a(recycler, this.f4316l);
        }
        if (this.f4316l.f3935e == -1) {
            iM4834r = this.f4306b.mo4405c() - m4832q(this.f4306b.mo4405c());
        } else {
            iM4834r = m4834r(this.f4306b.mo4407d()) - this.f4306b.mo4407d();
        }
        if (iM4834r > 0) {
            return Math.min(layoutState.f3932b, iM4834r);
        }
        return 0;
    }

    /* JADX INFO: renamed from: n */
    private LazySpanLookup.FullSpanItem m4828n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4335c = new int[this.f4313i];
        for (int i2 = 0; i2 < this.f4313i; i2++) {
            fullSpanItem.f4335c[i2] = i - this.f4305a[i2].m4896b(i);
        }
        return fullSpanItem;
    }

    /* JADX INFO: renamed from: o */
    private LazySpanLookup.FullSpanItem m4829o(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4335c = new int[this.f4313i];
        for (int i2 = 0; i2 < this.f4313i; i2++) {
            fullSpanItem.f4335c[i2] = this.f4305a[i2].m4888a(i) - i;
        }
        return fullSpanItem;
    }

    /* JADX INFO: renamed from: a */
    private void m4814a(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f3935e == 1) {
            if (layoutParams.f4330b) {
                m4831p(view);
                return;
            } else {
                layoutParams.f4329a.m4897b(view);
                return;
            }
        }
        if (layoutParams.f4330b) {
            m4833q(view);
        } else {
            layoutParams.f4329a.m4893a(view);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4809a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int iMin;
        int iMin2;
        if (layoutState.f3931a && !layoutState.f3939i) {
            if (layoutState.f3932b == 0) {
                if (layoutState.f3935e == -1) {
                    m4820b(recycler, layoutState.f3937g);
                    return;
                } else {
                    m4808a(recycler, layoutState.f3936f);
                    return;
                }
            }
            if (layoutState.f3935e == -1) {
                int iM4830p = layoutState.f3936f - m4830p(layoutState.f3936f);
                if (iM4830p < 0) {
                    iMin2 = layoutState.f3937g;
                } else {
                    iMin2 = layoutState.f3937g - Math.min(iM4830p, layoutState.f3932b);
                }
                m4820b(recycler, iMin2);
                return;
            }
            int iM4835s = m4835s(layoutState.f3937g) - layoutState.f3937g;
            if (iM4835s < 0) {
                iMin = layoutState.f3936f;
            } else {
                iMin = Math.min(iM4835s, layoutState.f3932b) + layoutState.f3936f;
            }
            m4808a(recycler, iMin);
        }
    }

    /* JADX INFO: renamed from: p */
    private void m4831p(View view) {
        for (int i = this.f4313i - 1; i >= 0; i--) {
            this.f4305a[i].m4897b(view);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m4833q(View view) {
        for (int i = this.f4313i - 1; i >= 0; i--) {
            this.f4305a[i].m4893a(view);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4807a(int i, int i2) {
        for (int i3 = 0; i3 < this.f4313i; i3++) {
            if (!this.f4305a[i3].f4347a.isEmpty()) {
                m4812a(this.f4305a[i3], i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4812a(Span span, int i, int i2) {
        int iM4907i = span.m4907i();
        if (i == -1) {
            if (iM4907i + span.m4895b() <= i2) {
                this.f4317m.set(span.f4351e, false);
            }
        } else if (span.m4901d() - iM4907i >= i2) {
            this.f4317m.set(span.f4351e, false);
        }
    }

    /* JADX INFO: renamed from: p */
    private int m4830p(int i) {
        int iM4888a = this.f4305a[0].m4888a(i);
        for (int i2 = 1; i2 < this.f4313i; i2++) {
            int iM4888a2 = this.f4305a[i2].m4888a(i);
            if (iM4888a2 > iM4888a) {
                iM4888a = iM4888a2;
            }
        }
        return iM4888a;
    }

    /* JADX INFO: renamed from: q */
    private int m4832q(int i) {
        int iM4888a = this.f4305a[0].m4888a(i);
        for (int i2 = 1; i2 < this.f4313i; i2++) {
            int iM4888a2 = this.f4305a[i2].m4888a(i);
            if (iM4888a2 < iM4888a) {
                iM4888a = iM4888a2;
            }
        }
        return iM4888a;
    }

    /* JADX INFO: renamed from: m */
    boolean m4858m() {
        int iM4896b = this.f4305a[0].m4896b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f4313i; i++) {
            if (this.f4305a[i].m4896b(Integer.MIN_VALUE) != iM4896b) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: n */
    boolean m4859n() {
        int iM4888a = this.f4305a[0].m4888a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f4313i; i++) {
            if (this.f4305a[i].m4888a(Integer.MIN_VALUE) != iM4888a) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: r */
    private int m4834r(int i) {
        int iM4896b = this.f4305a[0].m4896b(i);
        for (int i2 = 1; i2 < this.f4313i; i2++) {
            int iM4896b2 = this.f4305a[i2].m4896b(i);
            if (iM4896b2 > iM4896b) {
                iM4896b = iM4896b2;
            }
        }
        return iM4896b;
    }

    /* JADX INFO: renamed from: s */
    private int m4835s(int i) {
        int iM4896b = this.f4305a[0].m4896b(i);
        for (int i2 = 1; i2 < this.f4313i; i2++) {
            int iM4896b2 = this.f4305a[i2].m4896b(i);
            if (iM4896b2 < iM4896b) {
                iM4896b = iM4896b2;
            }
        }
        return iM4896b;
    }

    /* JADX INFO: renamed from: a */
    private void m4808a(RecyclerView.Recycler recycler, int i) {
        while (m4561v() > 0) {
            View viewI = m4544i(0);
            if (this.f4306b.mo4404b(viewI) <= i && this.f4306b.mo4406c(viewI) <= i) {
                LayoutParams layoutParams = (LayoutParams) viewI.getLayoutParams();
                if (layoutParams.f4330b) {
                    for (int i2 = 0; i2 < this.f4313i; i2++) {
                        if (this.f4305a[i2].f4347a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f4313i; i3++) {
                        this.f4305a[i3].m4906h();
                    }
                } else if (layoutParams.f4329a.f4347a.size() != 1) {
                    layoutParams.f4329a.m4906h();
                } else {
                    return;
                }
                m4500a(viewI, recycler);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4820b(RecyclerView.Recycler recycler, int i) {
        for (int iV = m4561v() - 1; iV >= 0; iV--) {
            View viewI = m4544i(iV);
            if (this.f4306b.mo4400a(viewI) >= i && this.f4306b.mo4408d(viewI) >= i) {
                LayoutParams layoutParams = (LayoutParams) viewI.getLayoutParams();
                if (layoutParams.f4330b) {
                    for (int i2 = 0; i2 < this.f4313i; i2++) {
                        if (this.f4305a[i2].f4347a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f4313i; i3++) {
                        this.f4305a[i3].m4905g();
                    }
                } else if (layoutParams.f4329a.f4347a.size() != 1) {
                    layoutParams.f4329a.m4905g();
                } else {
                    return;
                }
                m4500a(viewI, recycler);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: t */
    private boolean m4836t(int i) {
        if (this.f4314j == 0) {
            return (i == -1) != this.f4309e;
        }
        return ((i == -1) == this.f4309e) == m4856j();
    }

    /* JADX INFO: renamed from: a */
    private Span m4806a(LayoutState layoutState) {
        int i;
        int i2;
        Span span;
        Span span2;
        Span span3 = null;
        int i3 = -1;
        if (m4836t(layoutState.f3935e)) {
            i = this.f4313i - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f4313i;
            i3 = 1;
        }
        if (layoutState.f3935e == 1) {
            int iMo4405c = this.f4306b.mo4405c();
            int i4 = i;
            int i5 = Integer.MAX_VALUE;
            while (i4 != i2) {
                Span span4 = this.f4305a[i4];
                int iM4896b = span4.m4896b(iMo4405c);
                if (iM4896b < i5) {
                    span2 = span4;
                } else {
                    iM4896b = i5;
                    span2 = span3;
                }
                i4 += i3;
                span3 = span2;
                i5 = iM4896b;
            }
        } else {
            int iMo4407d = this.f4306b.mo4407d();
            int i6 = i;
            int i7 = Integer.MIN_VALUE;
            while (i6 != i2) {
                Span span5 = this.f4305a[i6];
                int iM4888a = span5.m4888a(iMo4407d);
                if (iM4888a > i7) {
                    span = span5;
                } else {
                    iM4888a = i7;
                    span = span3;
                }
                i6 += i3;
                span3 = span;
                i7 = iM4888a;
            }
        }
        return span3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: f */
    public boolean mo4316f() {
        return this.f4314j == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: e */
    public boolean mo4313e() {
        return this.f4314j == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public int mo4204a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return m4850c(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public int mo4225b(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return m4850c(i, recycler, state);
    }

    /* JADX INFO: renamed from: u */
    private int m4837u(int i) {
        if (m4561v() == 0) {
            return this.f4309e ? 1 : -1;
        }
        return (i < m4842M()) == this.f4309e ? 1 : -1;
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    /* JADX INFO: renamed from: d */
    public PointF mo4309d(int i) {
        int iM4837u = m4837u(i);
        PointF pointF = new PointF();
        if (iM4837u == 0) {
            return null;
        }
        if (this.f4314j == 0) {
            pointF.x = iM4837u;
            pointF.y = CropImageView.DEFAULT_ASPECT_RATIO;
            return pointF;
        }
        pointF.x = CropImageView.DEFAULT_ASPECT_RATIO;
        pointF.y = iM4837u;
        return pointF;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4295a(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.m4642d(i);
        m4492a(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: e */
    public void mo4312e(int i) {
        if (this.f4297A != null && this.f4297A.f4337a != i) {
            this.f4297A.m4885b();
        }
        this.f4310f = i;
        this.f4311g = Integer.MIN_VALUE;
        m4554o();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4291a(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int iM4896b;
        if (this.f4314j != 0) {
            i = i2;
        }
        if (m4561v() != 0 && i != 0) {
            m4844a(i, state);
            if (this.f4303G == null || this.f4303G.length < this.f4313i) {
                this.f4303G = new int[this.f4313i];
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f4313i; i4++) {
                if (this.f4316l.f3934d == -1) {
                    iM4896b = this.f4316l.f3936f - this.f4305a[i4].m4888a(this.f4316l.f3936f);
                } else {
                    iM4896b = this.f4305a[i4].m4896b(this.f4316l.f3937g) - this.f4316l.f3937g;
                }
                if (iM4896b >= 0) {
                    this.f4303G[i3] = iM4896b;
                    i3++;
                }
            }
            Arrays.sort(this.f4303G, 0, i3);
            for (int i5 = 0; i5 < i3 && this.f4316l.m4239a(state); i5++) {
                layoutPrefetchRegistry.mo4187b(this.f4316l.f3933c, this.f4303G[i5]);
                this.f4316l.f3933c += this.f4316l.f3934d;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m4844a(int i, RecyclerView.State state) {
        int i2;
        int iM4842M;
        if (i > 0) {
            iM4842M = m4841L();
            i2 = 1;
        } else {
            i2 = -1;
            iM4842M = m4842M();
        }
        this.f4316l.f3931a = true;
        m4819b(iM4842M, state);
        m4827m(i2);
        this.f4316l.f3933c = this.f4316l.f3934d + iM4842M;
        this.f4316l.f3932b = Math.abs(i);
    }

    /* JADX INFO: renamed from: c */
    int m4850c(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (m4561v() == 0 || i == 0) {
            return 0;
        }
        m4844a(i, state);
        int iM4805a = m4805a(recycler, this.f4316l, state);
        if (this.f4316l.f3932b >= iM4805a) {
            i = i < 0 ? -iM4805a : iM4805a;
        }
        this.f4306b.mo4402a(-i);
        this.f4319o = this.f4309e;
        this.f4316l.f3932b = 0;
        m4809a(recycler, this.f4316l);
        return i;
    }

    /* JADX INFO: renamed from: L */
    int m4841L() {
        int iV = m4561v();
        if (iV == 0) {
            return 0;
        }
        return m4527d(m4544i(iV - 1));
    }

    /* JADX INFO: renamed from: M */
    int m4842M() {
        if (m4561v() == 0) {
            return 0;
        }
        return m4527d(m4544i(0));
    }

    /* JADX INFO: renamed from: v */
    private int m4838v(int i) {
        int iV = m4561v();
        for (int i2 = 0; i2 < iV; i2++) {
            int iD = m4527d(m4544i(i2));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: w */
    private int m4839w(int i) {
        for (int iV = m4561v() - 1; iV >= 0; iV--) {
            int iD = m4527d(m4544i(iV));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo4206a() {
        return this.f4314j == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo4207a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo4208a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public boolean mo4224a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public View mo4210a(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View viewE;
        int iM4842M;
        int iM4909k;
        int iM4909k2;
        int iM4909k3;
        View viewM4891a;
        if (m4561v() != 0 && (viewE = m4531e(view)) != null) {
            m4803O();
            int iM4840x = m4840x(i);
            if (iM4840x == Integer.MIN_VALUE) {
                return null;
            }
            LayoutParams layoutParams = (LayoutParams) viewE.getLayoutParams();
            boolean z = layoutParams.f4330b;
            Span span = layoutParams.f4329a;
            if (iM4840x == 1) {
                iM4842M = m4841L();
            } else {
                iM4842M = m4842M();
            }
            m4819b(iM4842M, state);
            m4827m(iM4840x);
            this.f4316l.f3933c = this.f4316l.f3934d + iM4842M;
            this.f4316l.f3932b = (int) (0.33333334f * this.f4306b.mo4411f());
            this.f4316l.f3938h = true;
            this.f4316l.f3931a = false;
            m4805a(recycler, this.f4316l, state);
            this.f4319o = this.f4309e;
            if (!z && (viewM4891a = span.m4891a(iM4842M, iM4840x)) != null && viewM4891a != viewE) {
                return viewM4891a;
            }
            if (m4836t(iM4840x)) {
                for (int i2 = this.f4313i - 1; i2 >= 0; i2--) {
                    View viewM4891a2 = this.f4305a[i2].m4891a(iM4842M, iM4840x);
                    if (viewM4891a2 != null && viewM4891a2 != viewE) {
                        return viewM4891a2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.f4313i; i3++) {
                    View viewM4891a3 = this.f4305a[i3].m4891a(iM4842M, iM4840x);
                    if (viewM4891a3 != null && viewM4891a3 != viewE) {
                        return viewM4891a3;
                    }
                }
            }
            boolean z2 = (!this.f4308d) == (iM4840x == -1);
            if (!z) {
                if (z2) {
                    iM4909k3 = span.m4908j();
                } else {
                    iM4909k3 = span.m4909k();
                }
                View viewC = mo4305c(iM4909k3);
                if (viewC != null && viewC != viewE) {
                    return viewC;
                }
            }
            if (m4836t(iM4840x)) {
                for (int i4 = this.f4313i - 1; i4 >= 0; i4--) {
                    if (i4 != span.f4351e) {
                        if (z2) {
                            iM4909k2 = this.f4305a[i4].m4908j();
                        } else {
                            iM4909k2 = this.f4305a[i4].m4909k();
                        }
                        View viewC2 = mo4305c(iM4909k2);
                        if (viewC2 != null && viewC2 != viewE) {
                            return viewC2;
                        }
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.f4313i; i5++) {
                    if (z2) {
                        iM4909k = this.f4305a[i5].m4908j();
                    } else {
                        iM4909k = this.f4305a[i5].m4909k();
                    }
                    View viewC3 = mo4305c(iM4909k);
                    if (viewC3 != null && viewC3 != viewE) {
                        return viewC3;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: renamed from: x */
    private int m4840x(int i) {
        switch (i) {
            case 1:
                return (this.f4314j == 1 || !m4856j()) ? -1 : 1;
            case 2:
                return (this.f4314j != 1 && m4856j()) ? -1 : 1;
            case 17:
                return this.f4314j != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f4314j != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.f4314j != 0 ? Integer.MIN_VALUE : 1;
            case 130:
                return this.f4314j == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a */
        Span f4329a;

        /* JADX INFO: renamed from: b */
        boolean f4330b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX INFO: renamed from: a */
        public boolean m4864a() {
            return this.f4330b;
        }

        /* JADX INFO: renamed from: b */
        public final int m4865b() {
            if (this.f4329a == null) {
                return -1;
            }
            return this.f4329a.f4351e;
        }
    }

    class Span {

        /* JADX INFO: renamed from: a */
        ArrayList<View> f4347a = new ArrayList<>();

        /* JADX INFO: renamed from: b */
        int f4348b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c */
        int f4349c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d */
        int f4350d = 0;

        /* JADX INFO: renamed from: e */
        final int f4351e;

        Span(int i) {
            this.f4351e = i;
        }

        /* JADX INFO: renamed from: a */
        int m4888a(int i) {
            if (this.f4348b != Integer.MIN_VALUE) {
                return this.f4348b;
            }
            if (this.f4347a.size() != 0) {
                m4892a();
                return this.f4348b;
            }
            return i;
        }

        /* JADX INFO: renamed from: a */
        void m4892a() {
            LazySpanLookup.FullSpanItem fullSpanItemM4880f;
            View view = this.f4347a.get(0);
            LayoutParams layoutParamsM4898c = m4898c(view);
            this.f4348b = StaggeredGridLayoutManager.this.f4306b.mo4400a(view);
            if (layoutParamsM4898c.f4330b && (fullSpanItemM4880f = StaggeredGridLayoutManager.this.f4312h.m4880f(layoutParamsM4898c.m4574f())) != null && fullSpanItemM4880f.f4334b == -1) {
                this.f4348b -= fullSpanItemM4880f.m4881a(this.f4351e);
            }
        }

        /* JADX INFO: renamed from: b */
        int m4895b() {
            if (this.f4348b != Integer.MIN_VALUE) {
                return this.f4348b;
            }
            m4892a();
            return this.f4348b;
        }

        /* JADX INFO: renamed from: b */
        int m4896b(int i) {
            if (this.f4349c != Integer.MIN_VALUE) {
                return this.f4349c;
            }
            if (this.f4347a.size() != 0) {
                m4899c();
                return this.f4349c;
            }
            return i;
        }

        /* JADX INFO: renamed from: c */
        void m4899c() {
            LazySpanLookup.FullSpanItem fullSpanItemM4880f;
            View view = this.f4347a.get(this.f4347a.size() - 1);
            LayoutParams layoutParamsM4898c = m4898c(view);
            this.f4349c = StaggeredGridLayoutManager.this.f4306b.mo4404b(view);
            if (!layoutParamsM4898c.f4330b || (fullSpanItemM4880f = StaggeredGridLayoutManager.this.f4312h.m4880f(layoutParamsM4898c.m4574f())) == null || fullSpanItemM4880f.f4334b != 1) {
                return;
            }
            this.f4349c = fullSpanItemM4880f.m4881a(this.f4351e) + this.f4349c;
        }

        /* JADX INFO: renamed from: d */
        int m4901d() {
            if (this.f4349c != Integer.MIN_VALUE) {
                return this.f4349c;
            }
            m4899c();
            return this.f4349c;
        }

        /* JADX INFO: renamed from: a */
        void m4893a(View view) {
            LayoutParams layoutParamsM4898c = m4898c(view);
            layoutParamsM4898c.f4329a = this;
            this.f4347a.add(0, view);
            this.f4348b = Integer.MIN_VALUE;
            if (this.f4347a.size() == 1) {
                this.f4349c = Integer.MIN_VALUE;
            }
            if (layoutParamsM4898c.m4572d() || layoutParamsM4898c.m4573e()) {
                this.f4350d += StaggeredGridLayoutManager.this.f4306b.mo4410e(view);
            }
        }

        /* JADX INFO: renamed from: b */
        void m4897b(View view) {
            LayoutParams layoutParamsM4898c = m4898c(view);
            layoutParamsM4898c.f4329a = this;
            this.f4347a.add(view);
            this.f4349c = Integer.MIN_VALUE;
            if (this.f4347a.size() == 1) {
                this.f4348b = Integer.MIN_VALUE;
            }
            if (layoutParamsM4898c.m4572d() || layoutParamsM4898c.m4573e()) {
                this.f4350d += StaggeredGridLayoutManager.this.f4306b.mo4410e(view);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4894a(boolean z, int i) {
            int iM4888a;
            if (z) {
                iM4888a = m4896b(Integer.MIN_VALUE);
            } else {
                iM4888a = m4888a(Integer.MIN_VALUE);
            }
            m4903e();
            if (iM4888a != Integer.MIN_VALUE) {
                if (!z || iM4888a >= StaggeredGridLayoutManager.this.f4306b.mo4407d()) {
                    if (z || iM4888a <= StaggeredGridLayoutManager.this.f4306b.mo4405c()) {
                        if (i != Integer.MIN_VALUE) {
                            iM4888a += i;
                        }
                        this.f4349c = iM4888a;
                        this.f4348b = iM4888a;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: e */
        void m4903e() {
            this.f4347a.clear();
            m4904f();
            this.f4350d = 0;
        }

        /* JADX INFO: renamed from: f */
        void m4904f() {
            this.f4348b = Integer.MIN_VALUE;
            this.f4349c = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: c */
        void m4900c(int i) {
            this.f4348b = i;
            this.f4349c = i;
        }

        /* JADX INFO: renamed from: g */
        void m4905g() {
            int size = this.f4347a.size();
            View viewRemove = this.f4347a.remove(size - 1);
            LayoutParams layoutParamsM4898c = m4898c(viewRemove);
            layoutParamsM4898c.f4329a = null;
            if (layoutParamsM4898c.m4572d() || layoutParamsM4898c.m4573e()) {
                this.f4350d -= StaggeredGridLayoutManager.this.f4306b.mo4410e(viewRemove);
            }
            if (size == 1) {
                this.f4348b = Integer.MIN_VALUE;
            }
            this.f4349c = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: h */
        void m4906h() {
            View viewRemove = this.f4347a.remove(0);
            LayoutParams layoutParamsM4898c = m4898c(viewRemove);
            layoutParamsM4898c.f4329a = null;
            if (this.f4347a.size() == 0) {
                this.f4349c = Integer.MIN_VALUE;
            }
            if (layoutParamsM4898c.m4572d() || layoutParamsM4898c.m4573e()) {
                this.f4350d -= StaggeredGridLayoutManager.this.f4306b.mo4410e(viewRemove);
            }
            this.f4348b = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: i */
        public int m4907i() {
            return this.f4350d;
        }

        /* JADX INFO: renamed from: c */
        LayoutParams m4898c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* JADX INFO: renamed from: d */
        void m4902d(int i) {
            if (this.f4348b != Integer.MIN_VALUE) {
                this.f4348b += i;
            }
            if (this.f4349c != Integer.MIN_VALUE) {
                this.f4349c += i;
            }
        }

        /* JADX INFO: renamed from: j */
        public int m4908j() {
            return StaggeredGridLayoutManager.this.f4308d ? m4889a(this.f4347a.size() - 1, -1, true) : m4889a(0, this.f4347a.size(), true);
        }

        /* JADX INFO: renamed from: k */
        public int m4909k() {
            if (StaggeredGridLayoutManager.this.f4308d) {
                return m4889a(0, this.f4347a.size(), true);
            }
            return m4889a(this.f4347a.size() - 1, -1, true);
        }

        /* JADX INFO: renamed from: a */
        int m4890a(int i, int i2, boolean z, boolean z2, boolean z3) {
            boolean z4;
            boolean z5;
            int iMo4405c = StaggeredGridLayoutManager.this.f4306b.mo4405c();
            int iMo4407d = StaggeredGridLayoutManager.this.f4306b.mo4407d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f4347a.get(i);
                int iMo4400a = StaggeredGridLayoutManager.this.f4306b.mo4400a(view);
                int iMo4404b = StaggeredGridLayoutManager.this.f4306b.mo4404b(view);
                if (z3) {
                    z4 = iMo4400a <= iMo4407d;
                } else {
                    z4 = iMo4400a < iMo4407d;
                }
                if (z3) {
                    z5 = iMo4404b >= iMo4405c;
                } else {
                    z5 = iMo4404b > iMo4405c;
                }
                if (z4 && z5) {
                    if (z && z2) {
                        if (iMo4400a >= iMo4405c && iMo4404b <= iMo4407d) {
                            return StaggeredGridLayoutManager.this.m4527d(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.m4527d(view);
                        }
                        if (iMo4400a < iMo4405c || iMo4404b > iMo4407d) {
                            return StaggeredGridLayoutManager.this.m4527d(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* JADX INFO: renamed from: a */
        int m4889a(int i, int i2, boolean z) {
            return m4890a(i, i2, false, false, z);
        }

        /* JADX INFO: renamed from: a */
        public View m4891a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f4347a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f4347a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f4308d && StaggeredGridLayoutManager.this.m4527d(view2) <= i) || ((!StaggeredGridLayoutManager.this.f4308d && StaggeredGridLayoutManager.this.m4527d(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            int size2 = this.f4347a.size() - 1;
            while (size2 >= 0) {
                View view3 = this.f4347a.get(size2);
                if (StaggeredGridLayoutManager.this.f4308d && StaggeredGridLayoutManager.this.m4527d(view3) >= i) {
                    break;
                }
                if (!StaggeredGridLayoutManager.this.f4308d && StaggeredGridLayoutManager.this.m4527d(view3) <= i) {
                    return view;
                }
                if (!view3.hasFocusable()) {
                    break;
                }
                size2--;
                view = view3;
            }
            return view;
        }
    }

    static class LazySpanLookup {

        /* JADX INFO: renamed from: a */
        int[] f4331a;

        /* JADX INFO: renamed from: b */
        List<FullSpanItem> f4332b;

        LazySpanLookup() {
        }

        /* JADX INFO: renamed from: a */
        int m4869a(int i) {
            if (this.f4332b != null) {
                for (int size = this.f4332b.size() - 1; size >= 0; size--) {
                    if (this.f4332b.get(size).f4333a >= i) {
                        this.f4332b.remove(size);
                    }
                }
            }
            return m4875b(i);
        }

        /* JADX INFO: renamed from: b */
        int m4875b(int i) {
            if (this.f4331a == null || i >= this.f4331a.length) {
                return -1;
            }
            int iM4868g = m4868g(i);
            if (iM4868g == -1) {
                Arrays.fill(this.f4331a, i, this.f4331a.length, -1);
                return this.f4331a.length;
            }
            Arrays.fill(this.f4331a, i, iM4868g + 1, -1);
            return iM4868g + 1;
        }

        /* JADX INFO: renamed from: c */
        int m4877c(int i) {
            if (this.f4331a == null || i >= this.f4331a.length) {
                return -1;
            }
            return this.f4331a[i];
        }

        /* JADX INFO: renamed from: a */
        void m4873a(int i, Span span) {
            m4879e(i);
            this.f4331a[i] = span.f4351e;
        }

        /* JADX INFO: renamed from: d */
        int m4878d(int i) {
            int length = this.f4331a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: renamed from: e */
        void m4879e(int i) {
            if (this.f4331a == null) {
                this.f4331a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f4331a, -1);
            } else if (i >= this.f4331a.length) {
                int[] iArr = this.f4331a;
                this.f4331a = new int[m4878d(i)];
                System.arraycopy(iArr, 0, this.f4331a, 0, iArr.length);
                Arrays.fill(this.f4331a, iArr.length, this.f4331a.length, -1);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4871a() {
            if (this.f4331a != null) {
                Arrays.fill(this.f4331a, -1);
            }
            this.f4332b = null;
        }

        /* JADX INFO: renamed from: a */
        void m4872a(int i, int i2) {
            if (this.f4331a != null && i < this.f4331a.length) {
                m4879e(i + i2);
                System.arraycopy(this.f4331a, i + i2, this.f4331a, i, (this.f4331a.length - i) - i2);
                Arrays.fill(this.f4331a, this.f4331a.length - i2, this.f4331a.length, -1);
                m4866c(i, i2);
            }
        }

        /* JADX INFO: renamed from: c */
        private void m4866c(int i, int i2) {
            if (this.f4332b != null) {
                int i3 = i + i2;
                for (int size = this.f4332b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4332b.get(size);
                    if (fullSpanItem.f4333a >= i) {
                        if (fullSpanItem.f4333a < i3) {
                            this.f4332b.remove(size);
                        } else {
                            fullSpanItem.f4333a -= i2;
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4876b(int i, int i2) {
            if (this.f4331a != null && i < this.f4331a.length) {
                m4879e(i + i2);
                System.arraycopy(this.f4331a, i, this.f4331a, i + i2, (this.f4331a.length - i) - i2);
                Arrays.fill(this.f4331a, i, i + i2, -1);
                m4867d(i, i2);
            }
        }

        /* JADX INFO: renamed from: d */
        private void m4867d(int i, int i2) {
            if (this.f4332b != null) {
                for (int size = this.f4332b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4332b.get(size);
                    if (fullSpanItem.f4333a >= i) {
                        fullSpanItem.f4333a += i2;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: g */
        private int m4868g(int i) {
            if (this.f4332b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemM4880f = m4880f(i);
            if (fullSpanItemM4880f != null) {
                this.f4332b.remove(fullSpanItemM4880f);
            }
            int size = this.f4332b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f4332b.get(i2).f4333a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f4332b.get(i2);
            this.f4332b.remove(i2);
            return fullSpanItem.f4333a;
        }

        /* JADX INFO: renamed from: a */
        public void m4874a(FullSpanItem fullSpanItem) {
            if (this.f4332b == null) {
                this.f4332b = new ArrayList();
            }
            int size = this.f4332b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f4332b.get(i);
                if (fullSpanItem2.f4333a == fullSpanItem.f4333a) {
                    this.f4332b.remove(i);
                }
                if (fullSpanItem2.f4333a >= fullSpanItem.f4333a) {
                    this.f4332b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f4332b.add(fullSpanItem);
        }

        /* JADX INFO: renamed from: f */
        public FullSpanItem m4880f(int i) {
            if (this.f4332b == null) {
                return null;
            }
            for (int size = this.f4332b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4332b.get(size);
                if (fullSpanItem.f4333a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        public FullSpanItem m4870a(int i, int i2, int i3, boolean z) {
            if (this.f4332b == null) {
                return null;
            }
            int size = this.f4332b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f4332b.get(i4);
                if (fullSpanItem.f4333a >= i2) {
                    return null;
                }
                if (fullSpanItem.f4333a >= i) {
                    if (i3 == 0 || fullSpanItem.f4334b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f4336d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* JADX INFO: renamed from: a */
            int f4333a;

            /* JADX INFO: renamed from: b */
            int f4334b;

            /* JADX INFO: renamed from: c */
            int[] f4335c;

            /* JADX INFO: renamed from: d */
            boolean f4336d;

            FullSpanItem(Parcel parcel) {
                this.f4333a = parcel.readInt();
                this.f4334b = parcel.readInt();
                this.f4336d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.f4335c = new int[i];
                    parcel.readIntArray(this.f4335c);
                }
            }

            FullSpanItem() {
            }

            /* JADX INFO: renamed from: a */
            int m4881a(int i) {
                if (this.f4335c == null) {
                    return 0;
                }
                return this.f4335c[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f4333a);
                parcel.writeInt(this.f4334b);
                parcel.writeInt(this.f4336d ? 1 : 0);
                if (this.f4335c != null && this.f4335c.length > 0) {
                    parcel.writeInt(this.f4335c.length);
                    parcel.writeIntArray(this.f4335c);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4333a + ", mGapDir=" + this.f4334b + ", mHasUnwantedGapAfter=" + this.f4336d + ", mGapPerSpan=" + Arrays.toString(this.f4335c) + '}';
            }
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1
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
        int f4337a;

        /* JADX INFO: renamed from: b */
        int f4338b;

        /* JADX INFO: renamed from: c */
        int f4339c;

        /* JADX INFO: renamed from: d */
        int[] f4340d;

        /* JADX INFO: renamed from: e */
        int f4341e;

        /* JADX INFO: renamed from: f */
        int[] f4342f;

        /* JADX INFO: renamed from: g */
        List<LazySpanLookup.FullSpanItem> f4343g;

        /* JADX INFO: renamed from: h */
        boolean f4344h;

        /* JADX INFO: renamed from: i */
        boolean f4345i;

        /* JADX INFO: renamed from: j */
        boolean f4346j;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f4337a = parcel.readInt();
            this.f4338b = parcel.readInt();
            this.f4339c = parcel.readInt();
            if (this.f4339c > 0) {
                this.f4340d = new int[this.f4339c];
                parcel.readIntArray(this.f4340d);
            }
            this.f4341e = parcel.readInt();
            if (this.f4341e > 0) {
                this.f4342f = new int[this.f4341e];
                parcel.readIntArray(this.f4342f);
            }
            this.f4344h = parcel.readInt() == 1;
            this.f4345i = parcel.readInt() == 1;
            this.f4346j = parcel.readInt() == 1;
            this.f4343g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f4339c = savedState.f4339c;
            this.f4337a = savedState.f4337a;
            this.f4338b = savedState.f4338b;
            this.f4340d = savedState.f4340d;
            this.f4341e = savedState.f4341e;
            this.f4342f = savedState.f4342f;
            this.f4344h = savedState.f4344h;
            this.f4345i = savedState.f4345i;
            this.f4346j = savedState.f4346j;
            this.f4343g = savedState.f4343g;
        }

        /* JADX INFO: renamed from: a */
        void m4884a() {
            this.f4340d = null;
            this.f4339c = 0;
            this.f4341e = 0;
            this.f4342f = null;
            this.f4343g = null;
        }

        /* JADX INFO: renamed from: b */
        void m4885b() {
            this.f4340d = null;
            this.f4339c = 0;
            this.f4337a = -1;
            this.f4338b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4337a);
            parcel.writeInt(this.f4338b);
            parcel.writeInt(this.f4339c);
            if (this.f4339c > 0) {
                parcel.writeIntArray(this.f4340d);
            }
            parcel.writeInt(this.f4341e);
            if (this.f4341e > 0) {
                parcel.writeIntArray(this.f4342f);
            }
            parcel.writeInt(this.f4344h ? 1 : 0);
            parcel.writeInt(this.f4345i ? 1 : 0);
            parcel.writeInt(this.f4346j ? 1 : 0);
            parcel.writeList(this.f4343g);
        }
    }

    class AnchorInfo {

        /* JADX INFO: renamed from: a */
        int f4322a;

        /* JADX INFO: renamed from: b */
        int f4323b;

        /* JADX INFO: renamed from: c */
        boolean f4324c;

        /* JADX INFO: renamed from: d */
        boolean f4325d;

        /* JADX INFO: renamed from: e */
        boolean f4326e;

        /* JADX INFO: renamed from: f */
        int[] f4327f;

        AnchorInfo() {
            m4860a();
        }

        /* JADX INFO: renamed from: a */
        void m4860a() {
            this.f4322a = -1;
            this.f4323b = Integer.MIN_VALUE;
            this.f4324c = false;
            this.f4325d = false;
            this.f4326e = false;
            if (this.f4327f != null) {
                Arrays.fill(this.f4327f, -1);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4862a(Span[] spanArr) {
            int length = spanArr.length;
            if (this.f4327f == null || this.f4327f.length < length) {
                this.f4327f = new int[StaggeredGridLayoutManager.this.f4305a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f4327f[i] = spanArr[i].m4888a(Integer.MIN_VALUE);
            }
        }

        /* JADX INFO: renamed from: b */
        void m4863b() {
            this.f4323b = this.f4324c ? StaggeredGridLayoutManager.this.f4306b.mo4407d() : StaggeredGridLayoutManager.this.f4306b.mo4405c();
        }

        /* JADX INFO: renamed from: a */
        void m4861a(int i) {
            if (this.f4324c) {
                this.f4323b = StaggeredGridLayoutManager.this.f4306b.mo4407d() - i;
            } else {
                this.f4323b = StaggeredGridLayoutManager.this.f4306b.mo4405c() + i;
            }
        }
    }
}
