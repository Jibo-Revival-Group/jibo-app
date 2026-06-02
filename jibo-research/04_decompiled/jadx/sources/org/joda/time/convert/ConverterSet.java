package org.joda.time.convert;

/* JADX INFO: loaded from: classes2.dex */
class ConverterSet {

    /* JADX INFO: renamed from: a */
    private final Converter[] f15982a;

    /* JADX INFO: renamed from: b */
    private Entry[] f15983b = new Entry[16];

    ConverterSet(Converter[] converterArr) {
        this.f15982a = converterArr;
    }

    /* JADX INFO: renamed from: a */
    Converter m16734a(Class<?> cls) throws IllegalStateException {
        Entry[] entryArr = this.f15983b;
        int length = entryArr.length;
        int iHashCode = cls == null ? 0 : cls.hashCode() & (length - 1);
        while (true) {
            Entry entry = entryArr[iHashCode];
            if (entry != null) {
                if (entry.f15984a == cls) {
                    return entry.f15985b;
                }
                int i = iHashCode + 1;
                iHashCode = i >= length ? 0 : i;
            } else {
                Converter converterM16732a = m16732a(this, cls);
                Entry entry2 = new Entry(cls, converterM16732a);
                Entry[] entryArr2 = (Entry[]) entryArr.clone();
                entryArr2[iHashCode] = entry2;
                for (int i2 = 0; i2 < length; i2++) {
                    if (entryArr2[i2] == null) {
                        this.f15983b = entryArr2;
                        return converterM16732a;
                    }
                }
                int i3 = length << 1;
                Entry[] entryArr3 = new Entry[i3];
                for (int i4 = 0; i4 < length; i4++) {
                    Entry entry3 = entryArr2[i4];
                    Class<?> cls2 = entry3.f15984a;
                    int iHashCode2 = cls2 == null ? 0 : cls2.hashCode() & (i3 - 1);
                    while (entryArr3[iHashCode2] != null) {
                        iHashCode2++;
                        if (iHashCode2 >= i3) {
                            iHashCode2 = 0;
                        }
                    }
                    entryArr3[iHashCode2] = entry3;
                }
                this.f15983b = entryArr3;
                return converterM16732a;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m16733a() {
        return this.f15982a.length;
    }

    /* JADX INFO: renamed from: a */
    ConverterSet m16735a(int i, Converter[] converterArr) {
        int i2;
        Converter[] converterArr2 = this.f15982a;
        int length = converterArr2.length;
        if (i >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (converterArr != null) {
            converterArr[0] = converterArr2[i];
        }
        Converter[] converterArr3 = new Converter[length - 1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i3 != i) {
                i2 = i4 + 1;
                converterArr3[i4] = converterArr2[i3];
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        return new ConverterSet(converterArr3);
    }

    /* JADX INFO: renamed from: a */
    private static Converter m16732a(ConverterSet converterSet, Class<?> cls) {
        Converter[] converterArr = converterSet.f15982a;
        int length = converterArr.length;
        int i = length;
        ConverterSet converterSetM16735a = converterSet;
        while (true) {
            int i2 = i - 1;
            if (i2 >= 0) {
                Converter converter = converterArr[i2];
                Class<?> clsMo16729a = converter.mo16729a();
                if (clsMo16729a == cls) {
                    return converter;
                }
                if (clsMo16729a == null || (cls != null && !clsMo16729a.isAssignableFrom(cls))) {
                    converterSetM16735a = converterSetM16735a.m16735a(i2, (Converter[]) null);
                    converterArr = converterSetM16735a.f15982a;
                    length = converterArr.length;
                }
                i = i2;
            } else {
                if (cls == null || length == 0) {
                    return null;
                }
                if (length == 1) {
                    return converterArr[0];
                }
                Converter[] converterArr2 = converterArr;
                ConverterSet converterSet2 = converterSetM16735a;
                int length2 = length;
                while (true) {
                    int i3 = length - 1;
                    if (i3 < 0) {
                        break;
                    }
                    Class<?> clsMo16729a2 = converterArr2[i3].mo16729a();
                    ConverterSet converterSetM16735a2 = converterSet2;
                    int i4 = i3;
                    int i5 = length2;
                    while (true) {
                        i5--;
                        if (i5 >= 0) {
                            if (i5 != i4 && converterArr2[i5].mo16729a().isAssignableFrom(clsMo16729a2)) {
                                converterSetM16735a2 = converterSetM16735a2.m16735a(i5, (Converter[]) null);
                                converterArr2 = converterSetM16735a2.f15982a;
                                length2 = converterArr2.length;
                                i4 = length2 - 1;
                            }
                        }
                    }
                    length = i4;
                    converterSet2 = converterSetM16735a2;
                }
                if (length2 == 1) {
                    return converterArr2[0];
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to find best converter for type \"");
                sb.append(cls.getName());
                sb.append("\" from remaining set: ");
                for (int i6 = 0; i6 < length2; i6++) {
                    Converter converter2 = converterArr2[i6];
                    Class<?> clsMo16729a3 = converter2.mo16729a();
                    sb.append(converter2.getClass().getName());
                    sb.append('[');
                    sb.append(clsMo16729a3 == null ? null : clsMo16729a3.getName());
                    sb.append("], ");
                }
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    static class Entry {

        /* JADX INFO: renamed from: a */
        final Class<?> f15984a;

        /* JADX INFO: renamed from: b */
        final Converter f15985b;

        Entry(Class<?> cls, Converter converter) {
            this.f15984a = cls;
            this.f15985b = converter;
        }
    }
}
