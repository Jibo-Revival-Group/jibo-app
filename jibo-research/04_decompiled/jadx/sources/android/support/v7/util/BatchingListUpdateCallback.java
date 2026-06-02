package android.support.v7.util;

/* JADX INFO: loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* JADX INFO: renamed from: a */
    final ListUpdateCallback f3131a;

    /* JADX INFO: renamed from: b */
    int f3132b = 0;

    /* JADX INFO: renamed from: c */
    int f3133c = -1;

    /* JADX INFO: renamed from: d */
    int f3134d = -1;

    /* JADX INFO: renamed from: e */
    Object f3135e = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f3131a = listUpdateCallback;
    }

    /* JADX INFO: renamed from: a */
    public void m3442a() {
        if (this.f3132b != 0) {
            switch (this.f3132b) {
                case 1:
                    this.f3131a.mo3438a(this.f3133c, this.f3134d);
                    break;
                case 2:
                    this.f3131a.mo3440b(this.f3133c, this.f3134d);
                    break;
                case 3:
                    this.f3131a.mo3439a(this.f3133c, this.f3134d, this.f3135e);
                    break;
            }
            this.f3135e = null;
            this.f3132b = 0;
        }
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: a */
    public void mo3438a(int i, int i2) {
        if (this.f3132b == 1 && i >= this.f3133c && i <= this.f3133c + this.f3134d) {
            this.f3134d += i2;
            this.f3133c = Math.min(i, this.f3133c);
        } else {
            m3442a();
            this.f3133c = i;
            this.f3134d = i2;
            this.f3132b = 1;
        }
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: b */
    public void mo3440b(int i, int i2) {
        if (this.f3132b == 2 && this.f3133c >= i && this.f3133c <= i + i2) {
            this.f3134d += i2;
            this.f3133c = i;
        } else {
            m3442a();
            this.f3133c = i;
            this.f3134d = i2;
            this.f3132b = 2;
        }
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: c */
    public void mo3441c(int i, int i2) {
        m3442a();
        this.f3131a.mo3441c(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: a */
    public void mo3439a(int i, int i2, Object obj) {
        if (this.f3132b == 3 && i <= this.f3133c + this.f3134d && i + i2 >= this.f3133c && this.f3135e == obj) {
            int i3 = this.f3133c + this.f3134d;
            this.f3133c = Math.min(i, this.f3133c);
            this.f3134d = Math.max(i3, i + i2) - this.f3133c;
        } else {
            m3442a();
            this.f3133c = i;
            this.f3134d = i2;
            this.f3135e = obj;
            this.f3132b = 3;
        }
    }
}
