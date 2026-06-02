package android.support.v7.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewBoundsCheck {

    /* JADX INFO: renamed from: a */
    final Callback f4487a;

    /* JADX INFO: renamed from: b */
    BoundFlags f4488b = new BoundFlags();

    interface Callback {
        /* JADX INFO: renamed from: a */
        int mo4566a();

        /* JADX INFO: renamed from: a */
        int mo4567a(View view);

        /* JADX INFO: renamed from: a */
        View mo4568a(int i);

        /* JADX INFO: renamed from: b */
        int mo4569b();

        /* JADX INFO: renamed from: b */
        int mo4570b(View view);
    }

    ViewBoundsCheck(Callback callback) {
        this.f4487a = callback;
    }

    static class BoundFlags {

        /* JADX INFO: renamed from: a */
        int f4489a = 0;

        /* JADX INFO: renamed from: b */
        int f4490b;

        /* JADX INFO: renamed from: c */
        int f4491c;

        /* JADX INFO: renamed from: d */
        int f4492d;

        /* JADX INFO: renamed from: e */
        int f4493e;

        BoundFlags() {
        }

        /* JADX INFO: renamed from: a */
        void m5006a(int i, int i2, int i3, int i4) {
            this.f4490b = i;
            this.f4491c = i2;
            this.f4492d = i3;
            this.f4493e = i4;
        }

        /* JADX INFO: renamed from: a */
        void m5005a(int i) {
            this.f4489a |= i;
        }

        /* JADX INFO: renamed from: a */
        void m5004a() {
            this.f4489a = 0;
        }

        /* JADX INFO: renamed from: a */
        int m5003a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            if (i == i2) {
                return 2;
            }
            return 4;
        }

        /* JADX INFO: renamed from: b */
        boolean m5007b() {
            if ((this.f4489a & 7) != 0 && (this.f4489a & (m5003a(this.f4492d, this.f4490b) << 0)) == 0) {
                return false;
            }
            if ((this.f4489a & 112) != 0 && (this.f4489a & (m5003a(this.f4492d, this.f4491c) << 4)) == 0) {
                return false;
            }
            if ((this.f4489a & 1792) == 0 || (this.f4489a & (m5003a(this.f4493e, this.f4490b) << 8)) != 0) {
                return (this.f4489a & 28672) == 0 || (this.f4489a & (m5003a(this.f4493e, this.f4491c) << 12)) != 0;
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View m5001a(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            android.support.v7.widget.ViewBoundsCheck$Callback r0 = r8.f4487a
            int r3 = r0.mo4566a()
            android.support.v7.widget.ViewBoundsCheck$Callback r0 = r8.f4487a
            int r4 = r0.mo4569b()
            if (r10 <= r9) goto L3e
            r0 = 1
        Lf:
            r2 = 0
        L10:
            if (r9 == r10) goto L57
            android.support.v7.widget.ViewBoundsCheck$Callback r1 = r8.f4487a
            android.view.View r1 = r1.mo4568a(r9)
            android.support.v7.widget.ViewBoundsCheck$Callback r5 = r8.f4487a
            int r5 = r5.mo4567a(r1)
            android.support.v7.widget.ViewBoundsCheck$Callback r6 = r8.f4487a
            int r6 = r6.mo4570b(r1)
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r7 = r8.f4488b
            r7.m5006a(r3, r4, r5, r6)
            if (r11 == 0) goto L40
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r5 = r8.f4488b
            r5.m5004a()
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r5 = r8.f4488b
            r5.m5005a(r11)
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r5 = r8.f4488b
            boolean r5 = r5.m5007b()
            if (r5 == 0) goto L40
        L3d:
            return r1
        L3e:
            r0 = -1
            goto Lf
        L40:
            if (r12 == 0) goto L59
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r5 = r8.f4488b
            r5.m5004a()
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r5 = r8.f4488b
            r5.m5005a(r12)
            android.support.v7.widget.ViewBoundsCheck$BoundFlags r5 = r8.f4488b
            boolean r5 = r5.m5007b()
            if (r5 == 0) goto L59
        L54:
            int r9 = r9 + r0
            r2 = r1
            goto L10
        L57:
            r1 = r2
            goto L3d
        L59:
            r1 = r2
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ViewBoundsCheck.m5001a(int, int, int, int):android.view.View");
    }

    /* JADX INFO: renamed from: a */
    boolean m5002a(View view, int i) {
        this.f4488b.m5006a(this.f4487a.mo4566a(), this.f4487a.mo4569b(), this.f4487a.mo4567a(view), this.f4487a.mo4570b(view));
        if (i == 0) {
            return false;
        }
        this.f4488b.m5004a();
        this.f4488b.m5005a(i);
        return this.f4488b.m5007b();
    }
}
