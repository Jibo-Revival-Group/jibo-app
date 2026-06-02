package android.support.v7.widget;

/* JADX INFO: loaded from: classes.dex */
class RtlSpacingHelper {

    /* JADX INFO: renamed from: a */
    private int f4187a = 0;

    /* JADX INFO: renamed from: b */
    private int f4188b = 0;

    /* JADX INFO: renamed from: c */
    private int f4189c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d */
    private int f4190d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e */
    private int f4191e = 0;

    /* JADX INFO: renamed from: f */
    private int f4192f = 0;

    /* JADX INFO: renamed from: g */
    private boolean f4193g = false;

    /* JADX INFO: renamed from: h */
    private boolean f4194h = false;

    RtlSpacingHelper() {
    }

    /* JADX INFO: renamed from: a */
    public int m4708a() {
        return this.f4187a;
    }

    /* JADX INFO: renamed from: b */
    public int m4711b() {
        return this.f4188b;
    }

    /* JADX INFO: renamed from: c */
    public int m4713c() {
        return this.f4193g ? this.f4188b : this.f4187a;
    }

    /* JADX INFO: renamed from: d */
    public int m4714d() {
        return this.f4193g ? this.f4187a : this.f4188b;
    }

    /* JADX INFO: renamed from: a */
    public void m4709a(int i, int i2) {
        this.f4189c = i;
        this.f4190d = i2;
        this.f4194h = true;
        if (this.f4193g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f4187a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f4188b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f4187a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f4188b = i2;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4712b(int i, int i2) {
        this.f4194h = false;
        if (i != Integer.MIN_VALUE) {
            this.f4191e = i;
            this.f4187a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f4192f = i2;
            this.f4188b = i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4710a(boolean z) {
        if (z != this.f4193g) {
            this.f4193g = z;
            if (this.f4194h) {
                if (z) {
                    this.f4187a = this.f4190d != Integer.MIN_VALUE ? this.f4190d : this.f4191e;
                    this.f4188b = this.f4189c != Integer.MIN_VALUE ? this.f4189c : this.f4192f;
                    return;
                } else {
                    this.f4187a = this.f4189c != Integer.MIN_VALUE ? this.f4189c : this.f4191e;
                    this.f4188b = this.f4190d != Integer.MIN_VALUE ? this.f4190d : this.f4192f;
                    return;
                }
            }
            this.f4187a = this.f4191e;
            this.f4188b = this.f4192f;
        }
    }
}
