package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Encoder {

    /* JADX INFO: renamed from: a */
    private static final int[] f9119a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: a */
    private static int m9722a(ByteMatrix byteMatrix) {
        return MaskUtil.m9739a(byteMatrix) + MaskUtil.m9744b(byteMatrix) + MaskUtil.m9745c(byteMatrix) + MaskUtil.m9746d(byteMatrix);
    }

    /* JADX INFO: renamed from: a */
    public static QRCode m9726a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        CharacterSetECI characterSetECIByName;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        Mode modeM9724a = m9724a(str, str2);
        BitArray bitArray = new BitArray();
        if (modeM9724a == Mode.BYTE && !"ISO-8859-1".equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            m9730a(characterSetECIByName, bitArray);
        }
        m9731a(modeM9724a, bitArray);
        BitArray bitArray2 = new BitArray();
        m9735a(str, modeM9724a, bitArray2, str2);
        Version versionM9725a = m9725a(modeM9724a.getCharacterCountBits(m9725a(bitArray.m9665a() + modeM9724a.getCharacterCountBits(Version.m9699a(1)) + bitArray2.m9665a(), errorCorrectionLevel)) + bitArray.m9665a() + bitArray2.m9665a(), errorCorrectionLevel);
        BitArray bitArray3 = new BitArray();
        bitArray3.m9668a(bitArray);
        m9729a(modeM9724a == Mode.BYTE ? bitArray2.m9671b() : str.length(), versionM9725a, modeM9724a, bitArray3);
        bitArray3.m9668a(bitArray2);
        Version.ECBlocks eCBlocksM9702a = versionM9725a.m9702a(errorCorrectionLevel);
        int iM9703b = versionM9725a.m9703b() - eCBlocksM9702a.m9709c();
        m9728a(iM9703b, bitArray3);
        BitArray bitArrayM9723a = m9723a(bitArray3, versionM9725a.m9703b(), iM9703b, eCBlocksM9702a.m9708b());
        QRCode qRCode = new QRCode();
        qRCode.m9769a(errorCorrectionLevel);
        qRCode.m9770a(modeM9724a);
        qRCode.m9771a(versionM9725a);
        int iM9704c = versionM9725a.m9704c();
        ByteMatrix byteMatrix = new ByteMatrix(iM9704c, iM9704c);
        int iM9721a = m9721a(bitArrayM9723a, errorCorrectionLevel, versionM9725a, byteMatrix);
        qRCode.m9768a(iM9721a);
        MatrixUtil.m9751a(bitArrayM9723a, errorCorrectionLevel, versionM9725a, iM9721a, byteMatrix);
        qRCode.m9772a(byteMatrix);
        return qRCode;
    }

    /* JADX INFO: renamed from: a */
    static int m9720a(int i) {
        if (i < f9119a.length) {
            return f9119a[i];
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private static Mode m9724a(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return m9736a(str) ? Mode.KANJI : Mode.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (m9720a(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9736a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m9721a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            MatrixUtil.m9751a(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int iM9722a = m9722a(byteMatrix);
            if (iM9722a < i) {
                i2 = i3;
            } else {
                iM9722a = i;
            }
            i3++;
            i = iM9722a;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    private static Version m9725a(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionM9699a = Version.m9699a(i2);
            if (versionM9699a.m9703b() - versionM9699a.m9702a(errorCorrectionLevel).m9709c() >= (i + 7) / 8) {
                return versionM9699a;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX INFO: renamed from: a */
    static void m9728a(int i, BitArray bitArray) throws WriterException {
        int i2 = i * 8;
        if (bitArray.m9665a() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.m9665a() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitArray.m9665a() < i2; i3++) {
            bitArray.m9669a(false);
        }
        int iM9665a = bitArray.m9665a() & 7;
        if (iM9665a > 0) {
            while (iM9665a < 8) {
                bitArray.m9669a(false);
                iM9665a++;
            }
        }
        int iM9671b = i - bitArray.m9671b();
        for (int i4 = 0; i4 < iM9671b; i4++) {
            bitArray.m9666a((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.m9665a() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9727a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != (i5 * (i10 + i12)) + ((i9 + i11) * i6)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    /* JADX INFO: renamed from: a */
    static BitArray m9723a(BitArray bitArray, int i, int i2, int i3) throws WriterException {
        if (bitArray.m9671b() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            m9727a(i, i2, i3, i4, iArr, iArr2);
            int i7 = iArr[0];
            byte[] bArr = new byte[i7];
            bitArray.m9667a(i6 * 8, bArr, 0, i7);
            byte[] bArrM9737a = m9737a(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, bArrM9737a));
            int iMax2 = Math.max(i5, i7);
            i4++;
            iMax = Math.max(iMax, bArrM9737a.length);
            i5 = iMax2;
            i6 = iArr[0] + i6;
        }
        if (i2 != i6) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i8 = 0; i8 < i5; i8++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrM9711a = ((BlockPair) it.next()).m9711a();
                if (i8 < bArrM9711a.length) {
                    bitArray2.m9666a(bArrM9711a[i8], 8);
                }
            }
        }
        for (int i9 = 0; i9 < iMax; i9++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrM9712b = ((BlockPair) it2.next()).m9712b();
                if (i9 < bArrM9712b.length) {
                    bitArray2.m9666a(bArrM9712b[i9], 8);
                }
            }
        }
        if (i != bitArray2.m9671b()) {
            throw new WriterException("Interleaving error: " + i + " and " + bitArray2.m9671b() + " differ.");
        }
        return bitArray2;
    }

    /* JADX INFO: renamed from: a */
    static byte[] m9737a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ReedSolomonEncoder(GenericGF.f9085e).m9698a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: a */
    static void m9731a(Mode mode, BitArray bitArray) {
        bitArray.m9666a(mode.getBits(), 4);
    }

    /* JADX INFO: renamed from: a */
    static void m9729a(int i, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        if (i >= (1 << characterCountBits)) {
            throw new WriterException(i + " is bigger than " + ((1 << characterCountBits) - 1));
        }
        bitArray.m9666a(i, characterCountBits);
    }

    /* JADX INFO: renamed from: a */
    static void m9735a(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        switch (mode) {
            case NUMERIC:
                m9732a((CharSequence) str, bitArray);
                return;
            case ALPHANUMERIC:
                m9738b(str, bitArray);
                return;
            case BYTE:
                m9734a(str, bitArray, str2);
                return;
            case KANJI:
                m9733a(str, bitArray);
                return;
            default:
                throw new WriterException("Invalid mode: " + mode);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9732a(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            if (i + 2 < length) {
                bitArray.m9666a((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i + 2) - '0'), 10);
                i += 3;
            } else if (i + 1 < length) {
                bitArray.m9666a((iCharAt * 10) + (charSequence.charAt(i + 1) - '0'), 7);
                i += 2;
            } else {
                bitArray.m9666a(iCharAt, 4);
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static void m9738b(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iM9720a = m9720a(charSequence.charAt(i));
            if (iM9720a == -1) {
                throw new WriterException();
            }
            if (i + 1 < length) {
                int iM9720a2 = m9720a(charSequence.charAt(i + 1));
                if (iM9720a2 == -1) {
                    throw new WriterException();
                }
                bitArray.m9666a((iM9720a * 45) + iM9720a2, 11);
                i += 2;
            } else {
                bitArray.m9666a(iM9720a, 6);
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9734a(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.m9666a(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9733a(String str, BitArray bitArray) throws WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - 33088;
                } else {
                    i = (i3 < 57408 || i3 > 60351) ? -1 : i3 - 49472;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.m9666a((i & 255) + ((i >> 8) * 192), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m9730a(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.m9666a(Mode.ECI.getBits(), 4);
        bitArray.m9666a(characterSetECI.getValue(), 8);
    }
}
