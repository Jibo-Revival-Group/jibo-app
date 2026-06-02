package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* JADX INFO: renamed from: a */
    static final char[] f15646a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b */
    public static final ByteString f15647b = m16318a(new byte[0]);

    /* JADX INFO: renamed from: c */
    final byte[] f15648c;

    /* JADX INFO: renamed from: d */
    transient int f15649d;

    /* JADX INFO: renamed from: e */
    transient String f15650e;

    ByteString(byte[] bArr) {
        this.f15648c = bArr;
    }

    /* JADX INFO: renamed from: a */
    public static ByteString m16318a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ByteString((byte[]) bArr.clone());
    }

    /* JADX INFO: renamed from: a */
    public static ByteString m16317a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Util.f15699a));
        byteString.f15650e = str;
        return byteString;
    }

    /* JADX INFO: renamed from: a */
    public String mo16323a() {
        String str = this.f15650e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f15648c, Util.f15699a);
        this.f15650e = str2;
        return str2;
    }

    /* JADX INFO: renamed from: b */
    public String mo16330b() {
        return Base64.m16244a(this.f15648c);
    }

    /* JADX INFO: renamed from: c */
    public ByteString mo16331c() {
        return m16321d("MD5");
    }

    /* JADX INFO: renamed from: d */
    public ByteString mo16332d() {
        return m16321d("SHA-1");
    }

    /* JADX INFO: renamed from: e */
    public ByteString mo16333e() {
        return m16321d("SHA-256");
    }

    /* JADX INFO: renamed from: d */
    private ByteString m16321d(String str) {
        try {
            return m16318a(MessageDigest.getInstance(str).digest(this.f15648c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static ByteString m16319b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrM16246a = Base64.m16246a(str);
        if (bArrM16246a != null) {
            return new ByteString(bArrM16246a);
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public String mo16334f() {
        char[] cArr = new char[this.f15648c.length * 2];
        int i = 0;
        for (byte b : this.f15648c) {
            int i2 = i + 1;
            cArr[i] = f15646a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f15646a[b & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: c */
    public static ByteString m16320c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((m16314a(str.charAt(i * 2)) << 4) + m16314a(str.charAt((i * 2) + 1)));
        }
        return m16318a(bArr);
    }

    /* JADX INFO: renamed from: a */
    private static int m16314a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException("Unexpected hex digit: " + c);
        }
        return (c - 'A') + 10;
    }

    /* JADX INFO: renamed from: a */
    public static ByteString m16316a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return new ByteString(bArr);
    }

    /* JADX INFO: renamed from: g */
    public ByteString mo16335g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f15648c.length) {
                byte b = this.f15648c[i2];
                if (b < 65 || b > 90) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.f15648c.clone();
                    bArr[i2] = (byte) (b + 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b2 = bArr[i3];
                        if (b2 >= 65 && b2 <= 90) {
                            bArr[i3] = (byte) (b2 + 32);
                        }
                    }
                    return new ByteString(bArr);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public ByteString mo16324a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i2 > this.f15648c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f15648c.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i != 0 || i2 != this.f15648c.length) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f15648c, i, bArr, 0, i3);
            return new ByteString(bArr);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public byte mo16322a(int i) {
        return this.f15648c[i];
    }

    /* JADX INFO: renamed from: h */
    public int mo16336h() {
        return this.f15648c.length;
    }

    /* JADX INFO: renamed from: i */
    public byte[] mo16337i() {
        return (byte[]) this.f15648c.clone();
    }

    /* JADX INFO: renamed from: a */
    void mo16325a(Buffer buffer) {
        buffer.mo16274c(this.f15648c, 0, this.f15648c.length);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo16326a(int i, ByteString byteString, int i2, int i3) {
        return byteString.mo16327a(i2, this.f15648c, i, i3);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo16327a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f15648c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.m16389a(this.f15648c, i, bArr, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m16328a(ByteString byteString) {
        return mo16326a(0, byteString, 0, byteString.mo16336h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ByteString) && ((ByteString) obj).mo16336h() == this.f15648c.length && ((ByteString) obj).mo16327a(0, this.f15648c, 0, this.f15648c.length);
    }

    public int hashCode() {
        int i = this.f15649d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f15648c);
        this.f15649d = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(ByteString byteString) {
        int iMo16336h = mo16336h();
        int iMo16336h2 = byteString.mo16336h();
        int iMin = Math.min(iMo16336h, iMo16336h2);
        for (int i = 0; i < iMin; i++) {
            int iMo16322a = mo16322a(i) & 255;
            int iMo16322a2 = byteString.mo16322a(i) & 255;
            if (iMo16322a != iMo16322a2) {
                return iMo16322a < iMo16322a2 ? -1 : 1;
            }
        }
        if (iMo16336h == iMo16336h2) {
            return 0;
        }
        return iMo16336h >= iMo16336h2 ? 1 : -1;
    }

    public String toString() {
        if (this.f15648c.length == 0) {
            return "[size=0]";
        }
        String strMo16323a = mo16323a();
        int iM16315a = m16315a(strMo16323a, 64);
        if (iM16315a == -1) {
            if (this.f15648c.length <= 64) {
                return "[hex=" + mo16334f() + "]";
            }
            return "[size=" + this.f15648c.length + " hex=" + mo16324a(0, 64).mo16334f() + "…]";
        }
        String strReplace = strMo16323a.substring(0, iM16315a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iM16315a < strMo16323a.length()) {
            return "[size=" + this.f15648c.length + " text=" + strReplace + "…]";
        }
        return "[text=" + strReplace + "]";
    }

    /* JADX INFO: renamed from: a */
    static int m16315a(String str, int i) {
        int iCharCount = 0;
        int length = str.length();
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 != i) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                    return -1;
                }
                i2++;
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                return iCharCount;
            }
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString byteStringM16316a = m16316a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, byteStringM16316a.f15648c);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f15648c.length);
        objectOutputStream.write(this.f15648c);
    }
}
