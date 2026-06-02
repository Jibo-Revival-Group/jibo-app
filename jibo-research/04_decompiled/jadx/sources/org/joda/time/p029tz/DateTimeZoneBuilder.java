package org.joda.time.p029tz;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeZoneBuilder {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static DateTimeZone m16985a(InputStream inputStream, String str) throws IOException {
        return inputStream instanceof DataInput ? m16984a((DataInput) inputStream, str) : m16984a((DataInput) new DataInputStream(inputStream), str);
    }

    /* JADX INFO: renamed from: a */
    public static DateTimeZone m16984a(DataInput dataInput, String str) throws IOException {
        switch (dataInput.readUnsignedByte()) {
            case 67:
                return CachedDateTimeZone.m16977a(PrecalculatedZone.m16995a(dataInput, str));
            case 70:
                FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) m16983a(dataInput), (int) m16983a(dataInput));
                if (fixedDateTimeZone.equals(DateTimeZone.f15751a)) {
                    return DateTimeZone.f15751a;
                }
                return fixedDateTimeZone;
            case 80:
                return PrecalculatedZone.m16995a(dataInput, str);
            default:
                throw new IOException("Invalid encoding");
        }
    }

    /* JADX INFO: renamed from: a */
    static long m16983a(DataInput dataInput) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        switch (unsignedByte >> 6) {
            case 1:
                return ((long) (((unsignedByte << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8) | dataInput.readUnsignedByte())) * 60000;
            case 2:
                return (((((long) unsignedByte) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24)) | ((long) (dataInput.readUnsignedByte() << 16)) | ((long) (dataInput.readUnsignedByte() << 8)) | ((long) dataInput.readUnsignedByte())) * 1000;
            case 3:
                return dataInput.readLong();
            default:
                return ((long) ((unsignedByte << 26) >> 26)) * 1800000;
        }
    }

    private static final class OfYear {

        /* JADX INFO: renamed from: a */
        final char f16172a;

        /* JADX INFO: renamed from: b */
        final int f16173b;

        /* JADX INFO: renamed from: c */
        final int f16174c;

        /* JADX INFO: renamed from: d */
        final int f16175d;

        /* JADX INFO: renamed from: e */
        final boolean f16176e;

        /* JADX INFO: renamed from: f */
        final int f16177f;

        /* JADX INFO: renamed from: a */
        static OfYear m16989a(DataInput dataInput) throws IOException {
            return new OfYear((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) DateTimeZoneBuilder.m16983a(dataInput));
        }

        OfYear(char c, int i, int i2, int i3, boolean z, int i4) {
            if (c != 'u' && c != 'w' && c != 's') {
                throw new IllegalArgumentException("Unknown mode: " + c);
            }
            this.f16172a = c;
            this.f16173b = i;
            this.f16174c = i2;
            this.f16175d = i3;
            this.f16176e = z;
            this.f16177f = i4;
        }

        /* JADX INFO: renamed from: a */
        public long m16993a(long j, int i, int i2) {
            if (this.f16172a == 'w') {
                i += i2;
            } else if (this.f16172a != 's') {
                i = 0;
            }
            long j2 = ((long) i) + j;
            ISOChronology iSOChronologyM16706N = ISOChronology.m16706N();
            long jM16988a = m16988a(iSOChronologyM16706N, iSOChronologyM16706N.mo16411e().mo16436a(iSOChronologyM16706N.mo16411e().mo16443b(iSOChronologyM16706N.mo16393C().mo16443b(j2, this.f16173b), 0), this.f16177f));
            if (this.f16175d != 0) {
                jM16988a = m16992d(iSOChronologyM16706N, jM16988a);
                if (jM16988a <= j2) {
                    jM16988a = m16992d(iSOChronologyM16706N, m16988a(iSOChronologyM16706N, iSOChronologyM16706N.mo16393C().mo16443b(iSOChronologyM16706N.mo16395E().mo16436a(jM16988a, 1), this.f16173b)));
                }
            } else if (jM16988a <= j2) {
                jM16988a = m16988a(iSOChronologyM16706N, iSOChronologyM16706N.mo16395E().mo16436a(jM16988a, 1));
            }
            return jM16988a - ((long) i);
        }

        /* JADX INFO: renamed from: b */
        public long m16994b(long j, int i, int i2) {
            if (this.f16172a == 'w') {
                i += i2;
            } else if (this.f16172a != 's') {
                i = 0;
            }
            long j2 = ((long) i) + j;
            ISOChronology iSOChronologyM16706N = ISOChronology.m16706N();
            long jM16990b = m16990b(iSOChronologyM16706N, iSOChronologyM16706N.mo16411e().mo16436a(iSOChronologyM16706N.mo16411e().mo16443b(iSOChronologyM16706N.mo16393C().mo16443b(j2, this.f16173b), 0), this.f16177f));
            if (this.f16175d != 0) {
                jM16990b = m16992d(iSOChronologyM16706N, jM16990b);
                if (jM16990b >= j2) {
                    jM16990b = m16992d(iSOChronologyM16706N, m16990b(iSOChronologyM16706N, iSOChronologyM16706N.mo16393C().mo16443b(iSOChronologyM16706N.mo16395E().mo16436a(jM16990b, -1), this.f16173b)));
                }
            } else if (jM16990b >= j2) {
                jM16990b = m16990b(iSOChronologyM16706N, iSOChronologyM16706N.mo16395E().mo16436a(jM16990b, -1));
            }
            return jM16990b - ((long) i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfYear)) {
                return false;
            }
            OfYear ofYear = (OfYear) obj;
            return this.f16172a == ofYear.f16172a && this.f16173b == ofYear.f16173b && this.f16174c == ofYear.f16174c && this.f16175d == ofYear.f16175d && this.f16176e == ofYear.f16176e && this.f16177f == ofYear.f16177f;
        }

        public String toString() {
            return "[OfYear]\nMode: " + this.f16172a + "\nMonthOfYear: " + this.f16173b + "\nDayOfMonth: " + this.f16174c + "\nDayOfWeek: " + this.f16175d + "\nAdvanceDayOfWeek: " + this.f16176e + "\nMillisOfDay: " + this.f16177f + '\n';
        }

        /* JADX INFO: renamed from: a */
        private long m16988a(Chronology chronology, long j) {
            try {
                return m16991c(chronology, j);
            } catch (IllegalArgumentException e) {
                if (this.f16173b == 2 && this.f16174c == 29) {
                    while (!chronology.mo16395E().mo16448b(j)) {
                        j = chronology.mo16395E().mo16436a(j, 1);
                    }
                    return m16991c(chronology, j);
                }
                throw e;
            }
        }

        /* JADX INFO: renamed from: b */
        private long m16990b(Chronology chronology, long j) {
            try {
                return m16991c(chronology, j);
            } catch (IllegalArgumentException e) {
                if (this.f16173b == 2 && this.f16174c == 29) {
                    while (!chronology.mo16395E().mo16448b(j)) {
                        j = chronology.mo16395E().mo16436a(j, -1);
                    }
                    return m16991c(chronology, j);
                }
                throw e;
            }
        }

        /* JADX INFO: renamed from: c */
        private long m16991c(Chronology chronology, long j) {
            if (this.f16174c >= 0) {
                return chronology.mo16427u().mo16443b(j, this.f16174c);
            }
            return chronology.mo16427u().mo16436a(chronology.mo16393C().mo16436a(chronology.mo16427u().mo16443b(j, 1), 1), this.f16174c);
        }

        /* JADX INFO: renamed from: d */
        private long m16992d(Chronology chronology, long j) {
            int iMo16434a = this.f16175d - chronology.mo16426t().mo16434a(j);
            if (iMo16434a != 0) {
                if (this.f16176e) {
                    if (iMo16434a < 0) {
                        iMo16434a += 7;
                    }
                } else if (iMo16434a > 0) {
                    iMo16434a -= 7;
                }
                return chronology.mo16426t().mo16436a(j, iMo16434a);
            }
            return j;
        }
    }

    private static final class Recurrence {

        /* JADX INFO: renamed from: a */
        final OfYear f16183a;

        /* JADX INFO: renamed from: b */
        final String f16184b;

        /* JADX INFO: renamed from: c */
        final int f16185c;

        /* JADX INFO: renamed from: a */
        static Recurrence m16996a(DataInput dataInput) throws IOException {
            return new Recurrence(OfYear.m16989a(dataInput), dataInput.readUTF(), (int) DateTimeZoneBuilder.m16983a(dataInput));
        }

        Recurrence(OfYear ofYear, String str, int i) {
            this.f16183a = ofYear;
            this.f16184b = str;
            this.f16185c = i;
        }

        /* JADX INFO: renamed from: a */
        public long m16997a(long j, int i, int i2) {
            return this.f16183a.m16993a(j, i, i2);
        }

        /* JADX INFO: renamed from: b */
        public long m17000b(long j, int i, int i2) {
            return this.f16183a.m16994b(j, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public String m16998a() {
            return this.f16184b;
        }

        /* JADX INFO: renamed from: b */
        public int m16999b() {
            return this.f16185c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            return this.f16185c == recurrence.f16185c && this.f16184b.equals(recurrence.f16184b) && this.f16183a.equals(recurrence.f16183a);
        }

        public String toString() {
            return this.f16183a + " named " + this.f16184b + " at " + this.f16185c;
        }
    }

    private static final class DSTZone extends DateTimeZone {

        /* JADX INFO: renamed from: b */
        final int f16169b;

        /* JADX INFO: renamed from: c */
        final Recurrence f16170c;

        /* JADX INFO: renamed from: d */
        final Recurrence f16171d;

        /* JADX INFO: renamed from: a */
        static DSTZone m16986a(DataInput dataInput, String str) throws IOException {
            return new DSTZone(str, (int) DateTimeZoneBuilder.m16983a(dataInput), Recurrence.m16996a(dataInput), Recurrence.m16996a(dataInput));
        }

        DSTZone(String str, int i, Recurrence recurrence, Recurrence recurrence2) {
            super(str);
            this.f16169b = i;
            this.f16170c = recurrence;
            this.f16171d = recurrence2;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: a */
        public String mo16541a(long j) {
            return m16987i(j).m16998a();
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: b */
        public int mo16543b(long j) {
            return this.f16169b + m16987i(j).m16999b();
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: c */
        public int mo16545c(long j) {
            return this.f16169b;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: f */
        public boolean mo16550f() {
            return false;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: g */
        public long mo16551g(long j) {
            long j2;
            long j3;
            int i = this.f16169b;
            Recurrence recurrence = this.f16170c;
            Recurrence recurrence2 = this.f16171d;
            try {
                long jM16997a = recurrence.m16997a(j, i, recurrence2.m16999b());
                if (j > 0 && jM16997a < 0) {
                    jM16997a = j;
                }
                j2 = jM16997a;
            } catch (ArithmeticException e) {
                j2 = j;
            } catch (IllegalArgumentException e2) {
                j2 = j;
            }
            try {
                long jM16997a2 = recurrence2.m16997a(j, i, recurrence.m16999b());
                if (j <= 0 || jM16997a2 >= 0) {
                    j = jM16997a2;
                }
                j3 = j;
            } catch (ArithmeticException e3) {
                j3 = j;
            } catch (IllegalArgumentException e4) {
                j3 = j;
            }
            return j2 > j3 ? j3 : j2;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: h */
        public long mo16552h(long j) {
            long j2;
            long j3;
            long j4 = j + 1;
            int i = this.f16169b;
            Recurrence recurrence = this.f16170c;
            Recurrence recurrence2 = this.f16171d;
            try {
                long jM17000b = recurrence.m17000b(j4, i, recurrence2.m16999b());
                if (j4 < 0 && jM17000b > 0) {
                    jM17000b = j4;
                }
                j2 = jM17000b;
            } catch (ArithmeticException e) {
                j2 = j4;
            } catch (IllegalArgumentException e2) {
                j2 = j4;
            }
            try {
                long jM17000b2 = recurrence2.m17000b(j4, i, recurrence.m16999b());
                if (j4 >= 0 || jM17000b2 <= 0) {
                    j4 = jM17000b2;
                }
                j3 = j4;
            } catch (ArithmeticException e3) {
                j3 = j4;
            } catch (IllegalArgumentException e4) {
                j3 = j4;
            }
            if (j2 > j3) {
                j3 = j2;
            }
            return j3 - 1;
        }

        @Override // org.joda.time.DateTimeZone
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSTZone)) {
                return false;
            }
            DSTZone dSTZone = (DSTZone) obj;
            return m16548e().equals(dSTZone.m16548e()) && this.f16169b == dSTZone.f16169b && this.f16170c.equals(dSTZone.f16170c) && this.f16171d.equals(dSTZone.f16171d);
        }

        /* JADX INFO: renamed from: i */
        private Recurrence m16987i(long j) {
            long jM16997a;
            int i = this.f16169b;
            Recurrence recurrence = this.f16170c;
            Recurrence recurrence2 = this.f16171d;
            try {
                jM16997a = recurrence.m16997a(j, i, recurrence2.m16999b());
            } catch (ArithmeticException e) {
                jM16997a = j;
            } catch (IllegalArgumentException e2) {
                jM16997a = j;
            }
            try {
                j = recurrence2.m16997a(j, i, recurrence.m16999b());
            } catch (ArithmeticException e3) {
            } catch (IllegalArgumentException e4) {
            }
            return jM16997a > j ? recurrence : recurrence2;
        }
    }

    private static final class PrecalculatedZone extends DateTimeZone {

        /* JADX INFO: renamed from: b */
        private final long[] f16178b;

        /* JADX INFO: renamed from: c */
        private final int[] f16179c;

        /* JADX INFO: renamed from: d */
        private final int[] f16180d;

        /* JADX INFO: renamed from: e */
        private final String[] f16181e;

        /* JADX INFO: renamed from: f */
        private final DSTZone f16182f;

        /* JADX INFO: renamed from: a */
        static PrecalculatedZone m16995a(DataInput dataInput, String str) throws IOException {
            int unsignedByte;
            int unsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[unsignedShort];
            for (int i = 0; i < unsignedShort; i++) {
                strArr[i] = dataInput.readUTF();
            }
            int i2 = dataInput.readInt();
            long[] jArr = new long[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            String[] strArr2 = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                jArr[i3] = DateTimeZoneBuilder.m16983a(dataInput);
                iArr[i3] = (int) DateTimeZoneBuilder.m16983a(dataInput);
                iArr2[i3] = (int) DateTimeZoneBuilder.m16983a(dataInput);
                if (unsignedShort < 256) {
                    try {
                        unsignedByte = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    unsignedByte = dataInput.readUnsignedShort();
                }
                strArr2[i3] = strArr[unsignedByte];
            }
            DSTZone dSTZoneM16986a = null;
            if (dataInput.readBoolean()) {
                dSTZoneM16986a = DSTZone.m16986a(dataInput, str);
            }
            return new PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dSTZoneM16986a);
        }

        private PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DSTZone dSTZone) {
            super(str);
            this.f16178b = jArr;
            this.f16179c = iArr;
            this.f16180d = iArr2;
            this.f16181e = strArr;
            this.f16182f = dSTZone;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: a */
        public String mo16541a(long j) {
            long[] jArr = this.f16178b;
            int iBinarySearch = Arrays.binarySearch(jArr, j);
            if (iBinarySearch >= 0) {
                return this.f16181e[iBinarySearch];
            }
            int i = iBinarySearch ^ (-1);
            if (i < jArr.length) {
                if (i > 0) {
                    return this.f16181e[i - 1];
                }
                return "UTC";
            }
            if (this.f16182f == null) {
                return this.f16181e[i - 1];
            }
            return this.f16182f.mo16541a(j);
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: b */
        public int mo16543b(long j) {
            long[] jArr = this.f16178b;
            int iBinarySearch = Arrays.binarySearch(jArr, j);
            if (iBinarySearch >= 0) {
                return this.f16179c[iBinarySearch];
            }
            int i = iBinarySearch ^ (-1);
            if (i < jArr.length) {
                if (i > 0) {
                    return this.f16179c[i - 1];
                }
                return 0;
            }
            if (this.f16182f == null) {
                return this.f16179c[i - 1];
            }
            return this.f16182f.mo16543b(j);
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: c */
        public int mo16545c(long j) {
            long[] jArr = this.f16178b;
            int iBinarySearch = Arrays.binarySearch(jArr, j);
            if (iBinarySearch >= 0) {
                return this.f16180d[iBinarySearch];
            }
            int i = iBinarySearch ^ (-1);
            if (i < jArr.length) {
                if (i > 0) {
                    return this.f16180d[i - 1];
                }
                return 0;
            }
            if (this.f16182f == null) {
                return this.f16180d[i - 1];
            }
            return this.f16182f.mo16545c(j);
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: f */
        public boolean mo16550f() {
            return false;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: g */
        public long mo16551g(long j) {
            long[] jArr = this.f16178b;
            int iBinarySearch = Arrays.binarySearch(jArr, j);
            int i = iBinarySearch >= 0 ? iBinarySearch + 1 : iBinarySearch ^ (-1);
            if (i < jArr.length) {
                return jArr[i];
            }
            if (this.f16182f != null) {
                long j2 = jArr[jArr.length - 1];
                if (j < j2) {
                    j = j2;
                }
                return this.f16182f.mo16551g(j);
            }
            return j;
        }

        @Override // org.joda.time.DateTimeZone
        /* JADX INFO: renamed from: h */
        public long mo16552h(long j) {
            long[] jArr = this.f16178b;
            int iBinarySearch = Arrays.binarySearch(jArr, j);
            if (iBinarySearch >= 0) {
                if (j > Long.MIN_VALUE) {
                    return j - 1;
                }
                return j;
            }
            int i = iBinarySearch ^ (-1);
            if (i < jArr.length) {
                if (i > 0) {
                    long j2 = jArr[i - 1];
                    if (j2 > Long.MIN_VALUE) {
                        return j2 - 1;
                    }
                    return j;
                }
                return j;
            }
            if (this.f16182f != null) {
                long jMo16552h = this.f16182f.mo16552h(j);
                if (jMo16552h < j) {
                    return jMo16552h;
                }
            }
            long j3 = jArr[i - 1];
            if (j3 > Long.MIN_VALUE) {
                return j3 - 1;
            }
            return j;
        }

        @Override // org.joda.time.DateTimeZone
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrecalculatedZone)) {
                return false;
            }
            PrecalculatedZone precalculatedZone = (PrecalculatedZone) obj;
            if (m16548e().equals(precalculatedZone.m16548e()) && Arrays.equals(this.f16178b, precalculatedZone.f16178b) && Arrays.equals(this.f16181e, precalculatedZone.f16181e) && Arrays.equals(this.f16179c, precalculatedZone.f16179c) && Arrays.equals(this.f16180d, precalculatedZone.f16180d)) {
                if (this.f16182f == null) {
                    if (precalculatedZone.f16182f == null) {
                        return true;
                    }
                } else if (this.f16182f.equals(precalculatedZone.f16182f)) {
                    return true;
                }
            }
            return false;
        }
    }
}
