package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a */
    boolean f3919a;

    /* JADX INFO: renamed from: b */
    int f3920b;

    /* JADX INFO: renamed from: c */
    int[] f3921c;

    /* JADX INFO: renamed from: d */
    View[] f3922d;

    /* JADX INFO: renamed from: e */
    final SparseIntArray f3923e;

    /* JADX INFO: renamed from: f */
    final SparseIntArray f3924f;

    /* JADX INFO: renamed from: g */
    SpanSizeLookup f3925g;

    /* JADX INFO: renamed from: h */
    final Rect f3926h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3919a = false;
        this.f3920b = -1;
        this.f3923e = new SparseIntArray();
        this.f3924f = new SparseIntArray();
        this.f3925g = new DefaultSpanSizeLookup();
        this.f3926h = new Rect();
        m4211a(m4465a(context, attributeSet, i, i2).f4092b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f3919a = false;
        this.f3920b = -1;
        this.f3923e = new SparseIntArray();
        this.f3924f = new SparseIntArray();
        this.f3925g = new DefaultSpanSizeLookup();
        this.f3926h = new Rect();
        m4211a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f3919a = false;
        this.f3920b = -1;
        this.f3923e = new SparseIntArray();
        this.f3924f = new SparseIntArray();
        this.f3925g = new DefaultSpanSizeLookup();
        this.f3926h = new Rect();
        m4211a(i);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4223a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo4223a(false);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public int mo4205a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f3965i == 0) {
            return this.f3920b;
        }
        if (state.m4662e() < 1) {
            return 0;
        }
        return m4193a(recycler, state, state.m4662e() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public int mo4226b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f3965i == 1) {
            return this.f3920b;
        }
        if (state.m4662e() < 1) {
            return 0;
        }
        return m4193a(recycler, state, state.m4662e() - 1) + 1;
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
        int iM4193a = m4193a(recycler, state, layoutParams2.m4574f());
        if (this.f3965i == 0) {
            accessibilityNodeInfoCompat.m2794b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.m2835a(layoutParams2.m4232a(), layoutParams2.m4233b(), iM4193a, 1, this.f3920b > 1 && layoutParams2.m4233b() == this.f3920b, false));
        } else {
            accessibilityNodeInfoCompat.m2794b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.m2835a(iM4193a, 1, layoutParams2.m4232a(), layoutParams2.m4233b(), this.f3920b > 1 && layoutParams2.m4233b() == this.f3920b, false));
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: c */
    public void mo4229c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.m4658a()) {
            m4190M();
        }
        super.mo4229c(recycler, state);
        m4189L();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4217a(RecyclerView.State state) {
        super.mo4217a(state);
        this.f3919a = false;
    }

    /* JADX INFO: renamed from: L */
    private void m4189L() {
        this.f3923e.clear();
        this.f3924f.clear();
    }

    /* JADX INFO: renamed from: M */
    private void m4190M() {
        int iV = m4561v();
        for (int i = 0; i < iV; i++) {
            LayoutParams layoutParams = (LayoutParams) m4544i(i).getLayoutParams();
            int iF = layoutParams.m4574f();
            this.f3923e.put(iF, layoutParams.m4233b());
            this.f3924f.put(iF, layoutParams.m4232a());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4220a(RecyclerView recyclerView, int i, int i2) {
        this.f3925g.m4234a();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4219a(RecyclerView recyclerView) {
        this.f3925g.m4234a();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public void mo4227b(RecyclerView recyclerView, int i, int i2) {
        this.f3925g.m4234a();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4222a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3925g.m4234a();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4221a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3925g.m4234a();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo4206a() {
        return this.f3965i == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
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

    /* JADX INFO: renamed from: a */
    public void m4213a(SpanSizeLookup spanSizeLookup) {
        this.f3925g = spanSizeLookup;
    }

    /* JADX INFO: renamed from: N */
    private void m4191N() {
        int iZ;
        if (m4317g() == 1) {
            iZ = (m4564y() - m4476C()) - m4474A();
        } else {
            iZ = (m4565z() - m4477D()) - m4475B();
        }
        m4202m(iZ);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public void mo4212a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        if (this.f3921c == null) {
            super.mo4212a(rect, i, i2);
        }
        int iC = m4476C() + m4474A();
        int iB = m4475B() + m4477D();
        if (this.f3965i == 1) {
            iA2 = m4463a(i2, iB + rect.height(), m4481H());
            iA = m4463a(i, iC + this.f3921c[this.f3921c.length - 1], m4480G());
        } else {
            iA = m4463a(i, iC + rect.width(), m4480G());
            iA2 = m4463a(i2, iB + this.f3921c[this.f3921c.length - 1], m4481H());
        }
        m4540g(iA, iA2);
    }

    /* JADX INFO: renamed from: m */
    private void m4202m(int i) {
        this.f3921c = m4198a(this.f3921c, this.f3920b, i);
    }

    /* JADX INFO: renamed from: a */
    static int[] m4198a(int[] iArr, int i, int i2) {
        int i3;
        int i4 = 0;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    int m4203a(int i, int i2) {
        return (this.f3965i == 1 && m4320h()) ? this.f3921c[this.f3920b - i] - this.f3921c[(this.f3920b - i) - i2] : this.f3921c[i + i2] - this.f3921c[i];
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    void mo4214a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        super.mo4214a(recycler, state, anchorInfo, i);
        m4191N();
        if (state.m4662e() > 0 && !state.m4658a()) {
            m4200b(recycler, state, anchorInfo, i);
        }
        m4192O();
    }

    /* JADX INFO: renamed from: O */
    private void m4192O() {
        if (this.f3922d == null || this.f3922d.length != this.f3920b) {
            this.f3922d = new View[this.f3920b];
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public int mo4204a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        m4191N();
        m4192O();
        return super.mo4204a(i, recycler, state);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public int mo4225b(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        m4191N();
        m4192O();
        return super.mo4225b(i, recycler, state);
    }

    /* JADX INFO: renamed from: b */
    private void m4200b(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        boolean z = i == 1;
        int iM4199b = m4199b(recycler, state, anchorInfo.f3973b);
        if (z) {
            while (iM4199b > 0 && anchorInfo.f3973b > 0) {
                anchorInfo.f3973b--;
                iM4199b = m4199b(recycler, state, anchorInfo.f3973b);
            }
            return;
        }
        int iM4662e = state.m4662e() - 1;
        int i2 = anchorInfo.f3973b;
        int i3 = iM4199b;
        while (i2 < iM4662e) {
            int iM4199b2 = m4199b(recycler, state, i2 + 1);
            if (iM4199b2 <= i3) {
                break;
            }
            i2++;
            i3 = iM4199b2;
        }
        anchorInfo.f3973b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    @Override // android.support.v7.widget.LinearLayoutManager
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
            if (r11 <= r10) goto L2f
            r0 = 1
            r1 = r0
        L14:
            r4 = r2
        L15:
            if (r10 == r11) goto L57
            android.view.View r3 = r7.m4544i(r10)
            int r0 = r7.m4527d(r3)
            if (r0 < 0) goto L5d
            if (r0 >= r12) goto L5d
            int r0 = r7.m4199b(r8, r9, r0)
            if (r0 == 0) goto L32
            r0 = r2
            r3 = r4
        L2b:
            int r10 = r10 + r1
            r2 = r0
            r4 = r3
            goto L15
        L2f:
            r0 = -1
            r1 = r0
            goto L14
        L32:
            android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
            android.support.v7.widget.RecyclerView$LayoutParams r0 = (android.support.v7.widget.RecyclerView.LayoutParams) r0
            boolean r0 = r0.m4572d()
            if (r0 == 0) goto L42
            if (r4 != 0) goto L5d
            r0 = r2
            goto L2b
        L42:
            android.support.v7.widget.OrientationHelper r0 = r7.f3966j
            int r0 = r0.mo4400a(r3)
            if (r0 >= r6) goto L52
            android.support.v7.widget.OrientationHelper r0 = r7.f3966j
            int r0 = r0.mo4404b(r3)
            if (r0 >= r5) goto L5a
        L52:
            if (r2 != 0) goto L5d
            r0 = r3
            r3 = r4
            goto L2b
        L57:
            if (r2 == 0) goto L5b
        L59:
            r3 = r2
        L5a:
            return r3
        L5b:
            r2 = r4
            goto L59
        L5d:
            r0 = r2
            r3 = r4
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.mo4209a(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, int, int, int):android.view.View");
    }

    /* JADX INFO: renamed from: a */
    private int m4193a(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.m4658a()) {
            return this.f3925g.m4237c(i, this.f3920b);
        }
        int iM4608b = recycler.m4608b(i);
        if (iM4608b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.f3925g.m4237c(iM4608b, this.f3920b);
    }

    /* JADX INFO: renamed from: b */
    private int m4199b(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.m4658a()) {
            return this.f3925g.m4236b(i, this.f3920b);
        }
        int i2 = this.f3924f.get(i, -1);
        if (i2 == -1) {
            int iM4608b = recycler.m4608b(i);
            if (iM4608b == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 0;
            }
            return this.f3925g.m4236b(iM4608b, this.f3920b);
        }
        return i2;
    }

    /* JADX INFO: renamed from: c */
    private int m4201c(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.m4658a()) {
            return this.f3925g.mo4230a(i);
        }
        int i2 = this.f3923e.get(i, -1);
        if (i2 == -1) {
            int iM4608b = recycler.m4608b(i);
            if (iM4608b == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 1;
            }
            return this.f3925g.mo4230a(iM4608b);
        }
        return i2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    void mo4218a(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int iMo4230a = this.f3920b;
        for (int i = 0; i < this.f3920b && layoutState.m4337a(state) && iMo4230a > 0; i++) {
            int i2 = layoutState.f3984d;
            layoutPrefetchRegistry.mo4187b(i2, Math.max(0, layoutState.f3987g));
            iMo4230a -= this.f3925g.mo4230a(i2);
            layoutState.f3984d += layoutState.f3985e;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    void mo4215a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int iMakeMeasureSpec;
        int iA;
        View viewM4334a;
        int iMo4415i = this.f3966j.mo4415i();
        boolean z = iMo4415i != 1073741824;
        int i4 = m4561v() > 0 ? this.f3921c[this.f3920b] : 0;
        if (z) {
            m4191N();
        }
        boolean z2 = layoutState.f3985e == 1;
        int i5 = 0;
        int i6 = 0;
        int iM4199b = this.f3920b;
        if (!z2) {
            iM4199b = m4199b(recycler, state, layoutState.f3984d) + m4201c(recycler, state, layoutState.f3984d);
        }
        while (i5 < this.f3920b && layoutState.m4337a(state) && iM4199b > 0) {
            int i7 = layoutState.f3984d;
            int iM4201c = m4201c(recycler, state, i7);
            if (iM4201c > this.f3920b) {
                throw new IllegalArgumentException("Item at position " + i7 + " requires " + iM4201c + " spans but GridLayoutManager has only " + this.f3920b + " spans.");
            }
            iM4199b -= iM4201c;
            if (iM4199b < 0 || (viewM4334a = layoutState.m4334a(recycler)) == null) {
                break;
            }
            i6 += iM4201c;
            this.f3922d[i5] = viewM4334a;
            i5++;
        }
        if (i5 == 0) {
            layoutChunkResult.f3978b = true;
            return;
        }
        m4195a(recycler, state, i5, i6, z2);
        int i8 = 0;
        float f = 0.0f;
        int i9 = 0;
        while (i8 < i5) {
            View view = this.f3922d[i8];
            if (layoutState.f3991k == null) {
                if (z2) {
                    m4517b(view);
                } else {
                    m4518b(view, 0);
                }
            } else if (z2) {
                m4493a(view);
            } else {
                m4494a(view, 0);
            }
            m4519b(view, this.f3926h);
            m4197a(view, iMo4415i, false);
            int iMo4410e = this.f3966j.mo4410e(view);
            if (iMo4410e > i9) {
                i9 = iMo4410e;
            }
            float fMo4412f = (this.f3966j.mo4412f(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f3928b;
            if (fMo4412f <= f) {
                fMo4412f = f;
            }
            i8++;
            f = fMo4412f;
        }
        if (z) {
            m4194a(f, i4);
            i9 = 0;
            int i10 = 0;
            while (i10 < i5) {
                View view2 = this.f3922d[i10];
                m4197a(view2, 1073741824, true);
                int iMo4410e2 = this.f3966j.mo4410e(view2);
                if (iMo4410e2 <= i9) {
                    iMo4410e2 = i9;
                }
                i10++;
                i9 = iMo4410e2;
            }
        }
        for (int i11 = 0; i11 < i5; i11++) {
            View view3 = this.f3922d[i11];
            if (this.f3966j.mo4410e(view3) != i9) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f4096d;
                int i12 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i13 = rect.right + rect.left + layoutParams.leftMargin + layoutParams.rightMargin;
                int iM4203a = m4203a(layoutParams.f3927a, layoutParams.f3928b);
                if (this.f3965i == 1) {
                    iMakeMeasureSpec = m4464a(iM4203a, 1073741824, i13, layoutParams.width, false);
                    iA = View.MeasureSpec.makeMeasureSpec(i9 - i12, 1073741824);
                } else {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - i13, 1073741824);
                    iA = m4464a(iM4203a, 1073741824, i12, layoutParams.height, false);
                }
                m4196a(view3, iMakeMeasureSpec, iA, true);
            }
        }
        layoutChunkResult.f3977a = i9;
        int i14 = 0;
        if (this.f3965i == 1) {
            if (layoutState.f3986f == -1) {
                i14 = layoutState.f3982b;
                i3 = i14 - i9;
                i2 = 0;
                i = 0;
            } else {
                int i15 = layoutState.f3982b;
                i14 = i15 + i9;
                i3 = i15;
                i2 = 0;
                i = 0;
            }
        } else if (layoutState.f3986f == -1) {
            int i16 = layoutState.f3982b;
            i2 = i16;
            i = i16 - i9;
            i3 = 0;
        } else {
            i = layoutState.f3982b;
            i2 = i9 + i;
            i3 = 0;
        }
        int iMo4412f = i14;
        int iB = i3;
        int iMo4412f2 = i2;
        int iA2 = i;
        for (int i17 = 0; i17 < i5; i17++) {
            View view4 = this.f3922d[i17];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.f3965i == 1) {
                if (m4320h()) {
                    iMo4412f2 = m4474A() + this.f3921c[this.f3920b - layoutParams2.f3927a];
                    iA2 = iMo4412f2 - this.f3966j.mo4412f(view4);
                } else {
                    iA2 = m4474A() + this.f3921c[layoutParams2.f3927a];
                    iMo4412f2 = iA2 + this.f3966j.mo4412f(view4);
                }
            } else {
                iB = m4475B() + this.f3921c[layoutParams2.f3927a];
                iMo4412f = iB + this.f3966j.mo4412f(view4);
            }
            m4496a(view4, iA2, iB, iMo4412f2, iMo4412f);
            if (layoutParams2.m4572d() || layoutParams2.m4573e()) {
                layoutChunkResult.f3979c = true;
            }
            layoutChunkResult.f3980d |= view4.hasFocusable();
        }
        Arrays.fill(this.f3922d, (Object) null);
    }

    /* JADX INFO: renamed from: a */
    private void m4197a(View view, int i, boolean z) {
        int iA;
        int iA2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f4096d;
        int i2 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i3 = layoutParams.rightMargin + rect.right + rect.left + layoutParams.leftMargin;
        int iM4203a = m4203a(layoutParams.f3927a, layoutParams.f3928b);
        if (this.f3965i == 1) {
            iA = m4464a(iM4203a, i, i3, layoutParams.width, false);
            iA2 = m4464a(this.f3966j.mo4411f(), m4563x(), i2, layoutParams.height, true);
        } else {
            int iA3 = m4464a(iM4203a, i, i2, layoutParams.height, false);
            iA = m4464a(this.f3966j.mo4411f(), m4562w(), i3, layoutParams.width, true);
            iA2 = iA3;
        }
        m4196a(view, iA, iA2, z);
    }

    /* JADX INFO: renamed from: a */
    private void m4194a(float f, int i) {
        m4202m(Math.max(Math.round(this.f3920b * f), i));
    }

    /* JADX INFO: renamed from: a */
    private void m4196a(View view, int i, int i2, boolean z) {
        boolean zB;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            zB = m4510a(view, i, i2, layoutParams);
        } else {
            zB = m4520b(view, i, i2, layoutParams);
        }
        if (zB) {
            view.measure(i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4195a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i4 = 1;
            i3 = 0;
        } else {
            int i5 = i - 1;
            i = -1;
            i3 = i5;
            i4 = -1;
        }
        int i6 = 0;
        for (int i7 = i3; i7 != i; i7 += i4) {
            View view = this.f3922d[i7];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f3928b = m4201c(recycler, state, m4527d(view));
            layoutParams.f3927a = i6;
            i6 += layoutParams.f3928b;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4211a(int i) {
        if (i != this.f3920b) {
            this.f3919a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f3920b = i;
            this.f3925g.m4234a();
            m4554o();
        }
    }

    public static abstract class SpanSizeLookup {

        /* JADX INFO: renamed from: a */
        final SparseIntArray f3929a = new SparseIntArray();

        /* JADX INFO: renamed from: b */
        private boolean f3930b = false;

        /* JADX INFO: renamed from: a */
        public abstract int mo4230a(int i);

        /* JADX INFO: renamed from: a */
        public void m4234a() {
            this.f3929a.clear();
        }

        /* JADX INFO: renamed from: b */
        int m4236b(int i, int i2) {
            if (!this.f3930b) {
                return mo4231a(i, i2);
            }
            int i3 = this.f3929a.get(i, -1);
            if (i3 == -1) {
                int iMo4231a = mo4231a(i, i2);
                this.f3929a.put(i, iMo4231a);
                return iMo4231a;
            }
            return i3;
        }

        /* JADX INFO: renamed from: a */
        public int mo4231a(int i, int i2) {
            int i3;
            int iMo4230a;
            int iM4235b;
            int iMo4230a2 = mo4230a(i);
            if (iMo4230a2 == i2) {
                return 0;
            }
            if (!this.f3930b || this.f3929a.size() <= 0 || (iM4235b = m4235b(i)) < 0) {
                i3 = 0;
                iMo4230a = 0;
            } else {
                iMo4230a = this.f3929a.get(iM4235b) + mo4230a(iM4235b);
                i3 = iM4235b + 1;
            }
            int i4 = i3;
            while (i4 < i) {
                int iMo4230a3 = mo4230a(i4);
                int i5 = iMo4230a + iMo4230a3;
                if (i5 == i2) {
                    iMo4230a3 = 0;
                } else if (i5 <= i2) {
                    iMo4230a3 = i5;
                }
                i4++;
                iMo4230a = iMo4230a3;
            }
            if (iMo4230a + iMo4230a2 <= i2) {
                return iMo4230a;
            }
            return 0;
        }

        /* JADX INFO: renamed from: b */
        int m4235b(int i) {
            int i2 = 0;
            int size = this.f3929a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f3929a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f3929a.size()) {
                return -1;
            }
            return this.f3929a.keyAt(i4);
        }

        /* JADX INFO: renamed from: c */
        public int m4237c(int i, int i2) {
            int iMo4230a = mo4230a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int iMo4230a2 = mo4230a(i3);
                int i6 = i5 + iMo4230a2;
                if (i6 == i2) {
                    i4++;
                    iMo4230a2 = 0;
                } else if (i6 > i2) {
                    i4++;
                } else {
                    iMo4230a2 = i6;
                }
                i3++;
                i5 = iMo4230a2;
            }
            if (i5 + iMo4230a > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: a */
    public View mo4210a(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iV;
        int i2;
        int iV2;
        int i3;
        int iMin;
        View view2;
        int iMin2;
        int i4;
        View view3;
        View viewE = m4531e(view);
        if (viewE == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewE.getLayoutParams();
        int i5 = layoutParams.f3927a;
        int i6 = layoutParams.f3927a + layoutParams.f3928b;
        if (super.mo4210a(view, i, recycler, state) == null) {
            return null;
        }
        if ((m4314f(i) == 1) != this.f3967k) {
            iV = m4561v() - 1;
            i2 = -1;
            iV2 = -1;
        } else {
            iV = 0;
            i2 = 1;
            iV2 = m4561v();
        }
        boolean z = this.f3965i == 1 && m4320h();
        View view4 = null;
        int i7 = -1;
        int i8 = 0;
        View view5 = null;
        int i9 = -1;
        int i10 = 0;
        int iM4193a = m4193a(recycler, state, iV);
        int i11 = iV;
        while (i11 != iV2) {
            int iM4193a2 = m4193a(recycler, state, i11);
            View viewI = m4544i(i11);
            if (viewI == viewE) {
                break;
            }
            if (viewI.hasFocusable() && iM4193a2 != iM4193a) {
                if (view4 != null) {
                    break;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) viewI.getLayoutParams();
                int i12 = layoutParams2.f3927a;
                int i13 = layoutParams2.f3927a + layoutParams2.f3928b;
                if (!viewI.hasFocusable() || i12 != i5 || i13 != i6) {
                    boolean z2 = false;
                    if ((viewI.hasFocusable() && view4 == null) || (!viewI.hasFocusable() && view5 == null)) {
                        z2 = true;
                    } else {
                        int iMin3 = Math.min(i13, i6) - Math.max(i12, i5);
                        if (viewI.hasFocusable()) {
                            if (iMin3 > i8) {
                                z2 = true;
                            } else if (iMin3 == i8) {
                                if (z == (i12 > i7)) {
                                    z2 = true;
                                }
                            }
                        } else if (view4 == null && m4512a(viewI, false, true)) {
                            if (iMin3 > i10) {
                                z2 = true;
                            } else if (iMin3 == i10) {
                                if (z == (i12 > i9)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    if (z2) {
                        if (viewI.hasFocusable()) {
                            int i14 = layoutParams2.f3927a;
                            int i15 = i10;
                            i3 = i9;
                            view2 = view5;
                            iMin2 = Math.min(i13, i6) - Math.max(i12, i5);
                            iMin = i15;
                            view3 = viewI;
                            i4 = i14;
                        } else {
                            i3 = layoutParams2.f3927a;
                            iMin = Math.min(i13, i6) - Math.max(i12, i5);
                            view2 = viewI;
                            iMin2 = i8;
                            i4 = i7;
                            view3 = view4;
                        }
                    }
                    i11 += i2;
                    view4 = view3;
                    i8 = iMin2;
                    i7 = i4;
                    view5 = view2;
                    i9 = i3;
                    i10 = iMin;
                } else {
                    return viewI;
                }
            }
            iMin = i10;
            i4 = i7;
            i3 = i9;
            view2 = view5;
            iMin2 = i8;
            view3 = view4;
            i11 += i2;
            view4 = view3;
            i8 = iMin2;
            i7 = i4;
            view5 = view2;
            i9 = i3;
            i10 = iMin;
        }
        if (view4 == null) {
            view4 = view5;
        }
        return view4;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /* JADX INFO: renamed from: b */
    public boolean mo4228b() {
        return this.f3970n == null && !this.f3919a;
    }

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        /* JADX INFO: renamed from: a */
        public int mo4230a(int i) {
            return 1;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        /* JADX INFO: renamed from: a */
        public int mo4231a(int i, int i2) {
            return i % i2;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a */
        int f3927a;

        /* JADX INFO: renamed from: b */
        int f3928b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3927a = -1;
            this.f3928b = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3927a = -1;
            this.f3928b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3927a = -1;
            this.f3928b = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3927a = -1;
            this.f3928b = 0;
        }

        /* JADX INFO: renamed from: a */
        public int m4232a() {
            return this.f3927a;
        }

        /* JADX INFO: renamed from: b */
        public int m4233b() {
            return this.f3928b;
        }
    }
}
