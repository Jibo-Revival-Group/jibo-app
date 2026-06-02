package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import com.google.api.client.repackaged.com.google.common.base.CharMatcher;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
@GwtIncompatible("no precomputation is done in GWT")
final class SmallCharMatcher extends CharMatcher.FastMatcher {

    /* JADX INFO: renamed from: C1 */
    private static final int f8438C1 = -862048943;

    /* JADX INFO: renamed from: C2 */
    private static final int f8439C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.table = cArr;
        this.filter = j;
        this.containsZero = z;
    }

    static int smear(int i) {
        return f8439C2 * Integer.rotateLeft(f8438C1 * i, 15);
    }

    private boolean checkFilter(int i) {
        return 1 == ((this.filter >> i) & 1);
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        if (i == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(i - 1);
        do {
            iHighestOneBit <<= 1;
        } while (((double) iHighestOneBit) * 0.5d < i);
        return iHighestOneBit;
    }

    static CharMatcher from(BitSet bitSet, String str) {
        int i;
        long j = 0;
        int iCardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        char[] cArr = new char[chooseTableSize(iCardinality)];
        int length = cArr.length - 1;
        int iNextSetBit = bitSet.nextSetBit(0);
        while (true) {
            int i2 = iNextSetBit;
            if (i2 != -1) {
                j |= 1 << i2;
                int iSmear = smear(i2);
                while (true) {
                    i = iSmear & length;
                    if (cArr[i] == 0) {
                        break;
                    }
                    iSmear = i + 1;
                }
                cArr[i] = (char) i2;
                iNextSetBit = bitSet.nextSetBit(i2 + 1);
            } else {
                return new SmallCharMatcher(cArr, j, z, str);
            }
        }
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
    public boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c)) {
            return false;
        }
        int length = this.table.length - 1;
        int iSmear = smear(c) & length;
        int i = iSmear;
        while (this.table[i] != 0) {
            if (this.table[i] == c) {
                return true;
            }
            i = (i + 1) & length;
            if (i == iSmear) {
                return false;
            }
        }
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
    void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c : this.table) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}
