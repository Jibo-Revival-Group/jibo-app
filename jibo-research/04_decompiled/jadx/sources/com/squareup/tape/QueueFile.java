package com.squareup.tape;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class QueueFile {

    /* JADX INFO: renamed from: c */
    private static final Logger f14467c = Logger.getLogger(QueueFile.class.getName());

    /* JADX INFO: renamed from: d */
    private static final byte[] f14468d = new byte[4096];

    /* JADX INFO: renamed from: a */
    final RandomAccessFile f14469a;

    /* JADX INFO: renamed from: b */
    int f14470b;

    /* JADX INFO: renamed from: e */
    private int f14471e;

    /* JADX INFO: renamed from: f */
    private Element f14472f;

    /* JADX INFO: renamed from: g */
    private Element f14473g;

    /* JADX INFO: renamed from: h */
    private final byte[] f14474h = new byte[16];

    public interface ElementReader {
        /* JADX INFO: renamed from: a */
        void mo15053a(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            m15034a(file);
        }
        this.f14469a = m15037b(file);
        m15043e();
    }

    /* JADX INFO: renamed from: b */
    private static void m15040b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* JADX INFO: renamed from: a */
    private static void m15035a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            m15040b(bArr, i, i2);
            i += 4;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m15027a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* JADX INFO: renamed from: e */
    private void m15043e() throws IOException {
        this.f14469a.seek(0L);
        this.f14469a.readFully(this.f14474h);
        this.f14470b = m15027a(this.f14474h, 0);
        if (this.f14470b > this.f14469a.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f14470b + ", Actual length: " + this.f14469a.length());
        }
        if (this.f14470b == 0) {
            throw new IOException("File is corrupt; length stored in header is 0.");
        }
        this.f14471e = m15027a(this.f14474h, 4);
        int iM15027a = m15027a(this.f14474h, 8);
        int iM15027a2 = m15027a(this.f14474h, 12);
        this.f14472f = m15028a(iM15027a);
        this.f14473g = m15028a(iM15027a2);
    }

    /* JADX INFO: renamed from: a */
    private void m15031a(int i, int i2, int i3, int i4) throws IOException {
        m15035a(this.f14474h, i, i2, i3, i4);
        this.f14469a.seek(0L);
        this.f14469a.write(this.f14474h);
    }

    /* JADX INFO: renamed from: a */
    private Element m15028a(int i) throws IOException {
        if (i == 0) {
            return Element.f14478a;
        }
        m15039b(i, this.f14474h, 0, 4);
        return new Element(i, m15027a(this.f14474h, 0));
    }

    /* JADX INFO: renamed from: a */
    private static void m15034a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileM15037b = m15037b(file2);
        try {
            randomAccessFileM15037b.setLength(4096L);
            randomAccessFileM15037b.seek(0L);
            byte[] bArr = new byte[16];
            m15035a(bArr, 4096, 0, 0, 0);
            randomAccessFileM15037b.write(bArr);
            randomAccessFileM15037b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileM15037b.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    private static RandomAccessFile m15037b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public int m15036b(int i) {
        return i < this.f14470b ? i : (i + 16) - this.f14470b;
    }

    /* JADX INFO: renamed from: a */
    private void m15032a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iM15036b = m15036b(i);
        if (iM15036b + i3 <= this.f14470b) {
            this.f14469a.seek(iM15036b);
            this.f14469a.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f14470b - iM15036b;
        this.f14469a.seek(iM15036b);
        this.f14469a.write(bArr, i2, i4);
        this.f14469a.seek(16L);
        this.f14469a.write(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: renamed from: a */
    private void m15030a(int i, int i2) throws IOException {
        while (i2 > 0) {
            int iMin = Math.min(i2, f14468d.length);
            m15032a(i, f14468d, 0, iMin);
            i2 -= iMin;
            i += iMin;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m15039b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iM15036b = m15036b(i);
        if (iM15036b + i3 <= this.f14470b) {
            this.f14469a.seek(iM15036b);
            this.f14469a.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f14470b - iM15036b;
        this.f14469a.seek(iM15036b);
        this.f14469a.readFully(bArr, i2, i4);
        this.f14469a.seek(16L);
        this.f14469a.readFully(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: renamed from: a */
    public void m15047a(byte[] bArr) throws IOException {
        m15048a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15048a(byte[] bArr, int i, int i2) throws IOException {
        m15038b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m15041c(i2);
        boolean zM15049a = m15049a();
        Element element = new Element(zM15049a ? 16 : m15036b(this.f14473g.f14479b + 4 + this.f14473g.f14480c), i2);
        m15040b(this.f14474h, 0, i2);
        m15032a(element.f14479b, this.f14474h, 0, 4);
        m15032a(element.f14479b + 4, bArr, i, i2);
        m15031a(this.f14470b, this.f14471e + 1, zM15049a ? element.f14479b : this.f14472f.f14479b, element.f14479b);
        this.f14473g = element;
        this.f14471e++;
        if (zM15049a) {
            this.f14472f = this.f14473g;
        }
    }

    /* JADX INFO: renamed from: f */
    private int m15044f() {
        if (this.f14471e == 0) {
            return 16;
        }
        if (this.f14473g.f14479b >= this.f14472f.f14479b) {
            return (this.f14473g.f14479b - this.f14472f.f14479b) + 4 + this.f14473g.f14480c + 16;
        }
        return (((this.f14473g.f14479b + 4) + this.f14473g.f14480c) + this.f14470b) - this.f14472f.f14479b;
    }

    /* JADX INFO: renamed from: g */
    private int m15045g() {
        return this.f14470b - m15044f();
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m15049a() {
        return this.f14471e == 0;
    }

    /* JADX INFO: renamed from: c */
    private void m15041c(int i) throws IOException {
        int i2 = i + 4;
        int iM15045g = m15045g();
        if (iM15045g < i2) {
            int i3 = this.f14470b;
            do {
                iM15045g += i3;
                i3 <<= 1;
            } while (iM15045g < i2);
            m15042d(i3);
            int iM15036b = m15036b(this.f14473g.f14479b + 4 + this.f14473g.f14480c);
            if (iM15036b <= this.f14472f.f14479b) {
                FileChannel channel = this.f14469a.getChannel();
                channel.position(this.f14470b);
                int i4 = iM15036b - 16;
                if (channel.transferTo(16L, i4, channel) != i4) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
                m15030a(16, i4);
            }
            if (this.f14473g.f14479b < this.f14472f.f14479b) {
                int i5 = (this.f14470b + this.f14473g.f14479b) - 16;
                m15031a(i3, this.f14471e, this.f14472f.f14479b, i5);
                this.f14473g = new Element(i5, this.f14473g.f14480c);
            } else {
                m15031a(i3, this.f14471e, this.f14472f.f14479b, this.f14473g.f14479b);
            }
            this.f14470b = i3;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m15042d(int i) throws IOException {
        this.f14469a.setLength(i);
        this.f14469a.getChannel().force(true);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15046a(ElementReader elementReader) throws IOException {
        int iM15036b = this.f14472f.f14479b;
        for (int i = 0; i < this.f14471e; i++) {
            Element elementM15028a = m15028a(iM15036b);
            elementReader.mo15053a(new ElementInputStream(elementM15028a), elementM15028a.f14480c);
            iM15036b = m15036b(elementM15028a.f14480c + elementM15028a.f14479b + 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static <T> T m15038b(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    private final class ElementInputStream extends InputStream {

        /* JADX INFO: renamed from: b */
        private int f14482b;

        /* JADX INFO: renamed from: c */
        private int f14483c;

        private ElementInputStream(Element element) {
            this.f14482b = QueueFile.this.m15036b(element.f14479b + 4);
            this.f14483c = element.f14480c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            QueueFile.m15038b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.f14483c <= 0) {
                return -1;
            }
            if (i2 > this.f14483c) {
                i2 = this.f14483c;
            }
            QueueFile.this.m15039b(this.f14482b, bArr, i, i2);
            this.f14482b = QueueFile.this.m15036b(this.f14482b + i2);
            this.f14483c -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f14483c == 0) {
                return -1;
            }
            QueueFile.this.f14469a.seek(this.f14482b);
            int i = QueueFile.this.f14469a.read();
            this.f14482b = QueueFile.this.m15036b(this.f14482b + 1);
            this.f14483c--;
            return i;
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized int m15050b() {
        return this.f14471e;
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m15051c() throws IOException {
        if (m15049a()) {
            throw new NoSuchElementException();
        }
        if (this.f14471e == 1) {
            m15052d();
        } else {
            int i = this.f14472f.f14480c + 4;
            m15030a(this.f14472f.f14479b, i);
            int iM15036b = m15036b(i + this.f14472f.f14479b);
            m15039b(iM15036b, this.f14474h, 0, 4);
            int iM15027a = m15027a(this.f14474h, 0);
            m15031a(this.f14470b, this.f14471e - 1, iM15036b, this.f14473g.f14479b);
            this.f14471e--;
            this.f14472f = new Element(iM15036b, iM15027a);
        }
    }

    /* JADX INFO: renamed from: d */
    public synchronized void m15052d() throws IOException {
        this.f14469a.seek(0L);
        this.f14469a.write(f14468d);
        m15031a(4096, 0, 0, 0);
        this.f14471e = 0;
        this.f14472f = Element.f14478a;
        this.f14473g = Element.f14478a;
        if (this.f14470b > 4096) {
            m15042d(4096);
        }
        this.f14470b = 4096;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("fileLength=").append(this.f14470b);
        sb.append(", size=").append(this.f14471e);
        sb.append(", first=").append(this.f14472f);
        sb.append(", last=").append(this.f14473g);
        sb.append(", element lengths=[");
        try {
            m15046a(new ElementReader() { // from class: com.squareup.tape.QueueFile.1

                /* JADX INFO: renamed from: a */
                boolean f14475a = true;

                @Override // com.squareup.tape.QueueFile.ElementReader
                /* JADX INFO: renamed from: a */
                public void mo15053a(InputStream inputStream, int i) throws IOException {
                    if (this.f14475a) {
                        this.f14475a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f14467c.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class Element {

        /* JADX INFO: renamed from: a */
        static final Element f14478a = new Element(0, 0);

        /* JADX INFO: renamed from: b */
        final int f14479b;

        /* JADX INFO: renamed from: c */
        final int f14480c;

        Element(int i, int i2) {
            this.f14479b = i;
            this.f14480c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f14479b + ", length = " + this.f14480c + "]";
        }
    }
}
