package com.google.api.client.util.escape;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    @Override // com.google.api.client.util.escape.Escaper
    public abstract String escape(String str);

    protected abstract char[] escape(int i);

    protected abstract int nextEscapeIndex(CharSequence charSequence, int i, int i2);

    protected final String escapeSlow(String str, int i) {
        int i2;
        int i3;
        int length = str.length();
        char[] cArrCharBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i4 = 0;
        int length2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            int i5 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i;
            if (cArrEscape != null) {
                int i6 = i - i4;
                int length3 = length2 + i6 + cArrEscape.length;
                if (cArrCharBufferFromThreadLocal.length < length3) {
                    cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, ((length3 + length) - i) + 32);
                }
                if (i6 > 0) {
                    str.getChars(i4, i, cArrCharBufferFromThreadLocal, length2);
                    length2 += i6;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrCharBufferFromThreadLocal, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i2 = length2;
                i3 = i5;
            } else {
                int i7 = i4;
                i2 = length2;
                i3 = i7;
            }
            i = nextEscapeIndex(str, i5, length);
            int i8 = i3;
            length2 = i2;
            i4 = i8;
        }
        int i9 = length - i4;
        if (i9 > 0) {
            int i10 = i9 + length2;
            if (cArrCharBufferFromThreadLocal.length < i10) {
                cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, i10);
            }
            str.getChars(i4, length, cArrCharBufferFromThreadLocal, length2);
            length2 = i10;
        }
        return new String(cArrCharBufferFromThreadLocal, 0, length2);
    }

    protected static int codePointAt(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= 55296 && cCharAt <= 57343) {
                if (cCharAt <= 56319) {
                    if (i3 == i2) {
                        return -cCharAt;
                    }
                    char cCharAt2 = charSequence.charAt(i3);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        return Character.toCodePoint(cCharAt, cCharAt2);
                    }
                    throw new IllegalArgumentException(new StringBuilder(83).append("Expected low surrogate but got char '").append(cCharAt2).append("' with value ").append((int) cCharAt2).append(" at index ").append(i3).toString());
                }
                throw new IllegalArgumentException(new StringBuilder(82).append("Unexpected low surrogate character '").append(cCharAt).append("' with value ").append((int) cCharAt).append(" at index ").append(i3 - 1).toString());
            }
            return cCharAt;
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
