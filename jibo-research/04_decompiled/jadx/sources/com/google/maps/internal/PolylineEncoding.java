package com.google.maps.internal;

import com.google.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PolylineEncoding {
    public static List<LatLng> decode(String str) {
        int i;
        int length = str.length();
        ArrayList arrayList = new ArrayList(length / 2);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = 1;
            int i6 = 0;
            while (true) {
                i = i2 + 1;
                int iCharAt = (str.charAt(i2) - '?') - 1;
                i5 += iCharAt << i6;
                i6 += 5;
                if (iCharAt < 31) {
                    break;
                }
                i2 = i;
            }
            i4 += (i5 & 1) != 0 ? (i5 >> 1) ^ (-1) : i5 >> 1;
            int i7 = 1;
            int i8 = 0;
            while (true) {
                i2 = i + 1;
                int iCharAt2 = (str.charAt(i) - '?') - 1;
                i7 += iCharAt2 << i8;
                i8 += 5;
                if (iCharAt2 < 31) {
                    break;
                }
                i = i2;
            }
            int i9 = ((i7 & 1) != 0 ? (i7 >> 1) ^ (-1) : i7 >> 1) + i3;
            arrayList.add(new LatLng(((double) i4) * 1.0E-5d, ((double) i9) * 1.0E-5d));
            i3 = i9;
        }
        return arrayList;
    }

    public static String encode(List<LatLng> list) {
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        long j2 = 0;
        for (LatLng latLng : list) {
            long jRound = Math.round(latLng.lat * 100000.0d);
            long jRound2 = Math.round(latLng.lng * 100000.0d);
            encode(jRound - j2, stringBuffer);
            encode(jRound2 - j, stringBuffer);
            j = jRound2;
            j2 = jRound;
        }
        return stringBuffer.toString();
    }

    private static void encode(long j, StringBuffer stringBuffer) {
        long j2 = j < 0 ? (j << 1) ^ (-1) : j << 1;
        while (j2 >= 32) {
            stringBuffer.append(Character.toChars((int) (((31 & j2) | 32) + 63)));
            j2 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j2 + 63)));
    }

    public static String encode(LatLng[] latLngArr) {
        return encode((List<LatLng>) Arrays.asList(latLngArr));
    }
}
