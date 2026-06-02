package okio;

import com.facebook.internal.Utility;

/* JADX INFO: loaded from: classes2.dex */
final class Segment {

    /* JADX INFO: renamed from: a */
    final byte[] f15684a;

    /* JADX INFO: renamed from: b */
    int f15685b;

    /* JADX INFO: renamed from: c */
    int f15686c;

    /* JADX INFO: renamed from: d */
    boolean f15687d;

    /* JADX INFO: renamed from: e */
    boolean f15688e;

    /* JADX INFO: renamed from: f */
    Segment f15689f;

    /* JADX INFO: renamed from: g */
    Segment f15690g;

    Segment() {
        this.f15684a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f15688e = true;
        this.f15687d = false;
    }

    Segment(Segment segment) {
        this(segment.f15684a, segment.f15685b, segment.f15686c);
        segment.f15687d = true;
    }

    Segment(byte[] bArr, int i, int i2) {
        this.f15684a = bArr;
        this.f15685b = i;
        this.f15686c = i2;
        this.f15688e = false;
        this.f15687d = true;
    }

    /* JADX INFO: renamed from: a */
    public Segment m16376a() {
        Segment segment = this.f15689f != this ? this.f15689f : null;
        this.f15690g.f15689f = this.f15689f;
        this.f15689f.f15690g = this.f15690g;
        this.f15689f = null;
        this.f15690g = null;
        return segment;
    }

    /* JADX INFO: renamed from: a */
    public Segment m16378a(Segment segment) {
        segment.f15690g = this;
        segment.f15689f = this.f15689f;
        this.f15689f.f15690g = segment;
        this.f15689f = segment;
        return segment;
    }

    /* JADX INFO: renamed from: a */
    public Segment m16377a(int i) {
        Segment segmentM16381a;
        if (i <= 0 || i > this.f15686c - this.f15685b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            segmentM16381a = new Segment(this);
        } else {
            segmentM16381a = SegmentPool.m16381a();
            System.arraycopy(this.f15684a, this.f15685b, segmentM16381a.f15684a, 0, i);
        }
        segmentM16381a.f15686c = segmentM16381a.f15685b + i;
        this.f15685b += i;
        this.f15690g.m16378a(segmentM16381a);
        return segmentM16381a;
    }

    /* JADX INFO: renamed from: b */
    public void m16380b() {
        if (this.f15690g == this) {
            throw new IllegalStateException();
        }
        if (this.f15690g.f15688e) {
            int i = this.f15686c - this.f15685b;
            if (i <= (this.f15690g.f15687d ? 0 : this.f15690g.f15685b) + (8192 - this.f15690g.f15686c)) {
                m16379a(this.f15690g, i);
                m16376a();
                SegmentPool.m16382a(this);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m16379a(Segment segment, int i) {
        if (!segment.f15688e) {
            throw new IllegalArgumentException();
        }
        if (segment.f15686c + i > 8192) {
            if (segment.f15687d) {
                throw new IllegalArgumentException();
            }
            if ((segment.f15686c + i) - segment.f15685b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(segment.f15684a, segment.f15685b, segment.f15684a, 0, segment.f15686c - segment.f15685b);
            segment.f15686c -= segment.f15685b;
            segment.f15685b = 0;
        }
        System.arraycopy(this.f15684a, this.f15685b, segment.f15684a, segment.f15686c, i);
        segment.f15686c += i;
        this.f15685b += i;
    }
}
