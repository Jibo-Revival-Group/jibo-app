package org.joda.time.chrono;

import org.joda.time.Chronology;

/* JADX INFO: loaded from: classes2.dex */
abstract class BasicGJChronology extends BasicChronology {

    /* JADX INFO: renamed from: a */
    private static final int[] f15896a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* JADX INFO: renamed from: b */
    private static final int[] f15897b = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* JADX INFO: renamed from: c */
    private static final long[] f15898c = new long[12];

    /* JADX INFO: renamed from: d */
    private static final long[] f15899d = new long[12];

    static {
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 11; i++) {
            j2 += ((long) f15896a[i]) * 86400000;
            f15898c[i + 1] = j2;
            j += ((long) f15897b[i]) * 86400000;
            f15899d[i + 1] = j;
        }
    }

    BasicGJChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: j */
    boolean mo16664j(long j) {
        return mo16427u().mo16434a(j) == 29 && mo16393C().mo16448b(j);
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: a */
    int mo16638a(long j, int i) {
        int iD = (int) ((j - m16653d(i)) >> 10);
        if (mo16656e(i)) {
            if (iD < 15356250) {
                if (iD < 7678125) {
                    if (iD < 2615625) {
                        return 1;
                    }
                    return iD < 5062500 ? 2 : 3;
                }
                if (iD < 10209375) {
                    return 4;
                }
                return iD < 12825000 ? 5 : 6;
            }
            if (iD < 23118750) {
                if (iD < 17971875) {
                    return 7;
                }
                return iD < 20587500 ? 8 : 9;
            }
            if (iD < 25734375) {
                return 10;
            }
            return iD < 28265625 ? 11 : 12;
        }
        if (iD < 15271875) {
            if (iD < 7593750) {
                if (iD >= 2615625) {
                    return iD < 4978125 ? 2 : 3;
                }
                return 1;
            }
            if (iD < 10125000) {
                return 4;
            }
            return iD < 12740625 ? 5 : 6;
        }
        if (iD < 23034375) {
            if (iD < 17887500) {
                return 7;
            }
            return iD < 20503125 ? 8 : 9;
        }
        if (iD < 25650000) {
            return 10;
        }
        return iD < 28181250 ? 11 : 12;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: b */
    int mo16643b(int i, int i2) {
        return mo16656e(i) ? f15897b[i2 - 1] : f15896a[i2 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: e */
    int mo16655e(long j, int i) {
        if (i > 28 || i < 1) {
            return m16663i(j);
        }
        return 28;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: c */
    long mo16650c(int i, int i2) {
        return mo16656e(i) ? f15899d[i2 - 1] : f15898c[i2 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: f */
    long mo16659f(long j, int i) {
        int iA = m16637a(j);
        int iC = m16648c(j, iA);
        int iH = m16662h(j);
        if (iC > 59) {
            if (mo16656e(iA)) {
                if (!mo16656e(i)) {
                    iC--;
                }
            } else if (mo16656e(i)) {
                iC++;
            }
        }
        return m16641a(i, 1, iC) + ((long) iH);
    }
}
