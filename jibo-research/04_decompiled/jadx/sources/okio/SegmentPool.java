package okio;

/* JADX INFO: loaded from: classes2.dex */
final class SegmentPool {

    /* JADX INFO: renamed from: a */
    static Segment f15691a;

    /* JADX INFO: renamed from: b */
    static long f15692b;

    private SegmentPool() {
    }

    /* JADX INFO: renamed from: a */
    static Segment m16381a() {
        synchronized (SegmentPool.class) {
            if (f15691a != null) {
                Segment segment = f15691a;
                f15691a = segment.f15689f;
                segment.f15689f = null;
                f15692b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    /* JADX INFO: renamed from: a */
    static void m16382a(Segment segment) {
        if (segment.f15689f != null || segment.f15690g != null) {
            throw new IllegalArgumentException();
        }
        if (!segment.f15687d) {
            synchronized (SegmentPool.class) {
                if (f15692b + 8192 <= 65536) {
                    f15692b += 8192;
                    segment.f15689f = f15691a;
                    segment.f15686c = 0;
                    segment.f15685b = 0;
                    f15691a = segment;
                }
            }
        }
    }
}
