package io.fabric.sdk.android.services.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class QueueFile implements Closeable {

    /* JADX INFO: renamed from: b */
    private static final Logger f14599b = Logger.getLogger(QueueFile.class.getName());

    /* JADX INFO: renamed from: a */
    int f14600a;

    /* JADX INFO: renamed from: c */
    private final RandomAccessFile f14601c;

    /* JADX INFO: renamed from: d */
    private int f14602d;

    /* JADX INFO: renamed from: e */
    private Element f14603e;

    /* JADX INFO: renamed from: f */
    private Element f14604f;

    /* JADX INFO: renamed from: g */
    private final byte[] f14605g = new byte[16];

    public interface ElementReader {
        /* JADX INFO: renamed from: a */
        void mo5958a(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            m15249a(file);
        }
        this.f14601c = m15252b(file);
        m15256c();
    }

    /* JADX INFO: renamed from: b */
    private static void m15255b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* JADX INFO: renamed from: a */
    private static void m15250a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            m15255b(bArr, i, i2);
            i += 4;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m15242a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* JADX INFO: renamed from: c */
    private void m15256c() throws IOException {
        this.f14601c.seek(0L);
        this.f14601c.readFully(this.f14605g);
        this.f14600a = m15242a(this.f14605g, 0);
        if (this.f14600a > this.f14601c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f14600a + ", Actual length: " + this.f14601c.length());
        }
        this.f14602d = m15242a(this.f14605g, 4);
        int iM15242a = m15242a(this.f14605g, 8);
        int iM15242a2 = m15242a(this.f14605g, 12);
        this.f14603e = m15243a(iM15242a);
        this.f14604f = m15243a(iM15242a2);
    }

    /* JADX INFO: renamed from: a */
    private void m15246a(int i, int i2, int i3, int i4) throws IOException {
        m15250a(this.f14605g, i, i2, i3, i4);
        this.f14601c.seek(0L);
        this.f14601c.write(this.f14605g);
    }

    /* JADX INFO: renamed from: a */
    private Element m15243a(int i) throws IOException {
        if (i == 0) {
            return Element.f14609a;
        }
        this.f14601c.seek(i);
        return new Element(i, this.f14601c.readInt());
    }

    /* JADX INFO: renamed from: a */
    private static void m15249a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileM15252b = m15252b(file2);
        try {
            randomAccessFileM15252b.setLength(4096L);
            randomAccessFileM15252b.seek(0L);
            byte[] bArr = new byte[16];
            m15250a(bArr, 4096, 0, 0, 0);
            randomAccessFileM15252b.write(bArr);
            randomAccessFileM15252b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileM15252b.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    private static RandomAccessFile m15252b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public int m15251b(int i) {
        return i < this.f14600a ? i : (i + 16) - this.f14600a;
    }

    /* JADX INFO: renamed from: a */
    private void m15247a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iM15251b = m15251b(i);
        if (iM15251b + i3 <= this.f14600a) {
            this.f14601c.seek(iM15251b);
            this.f14601c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f14600a - iM15251b;
        this.f14601c.seek(iM15251b);
        this.f14601c.write(bArr, i2, i4);
        this.f14601c.seek(16L);
        this.f14601c.write(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m15254b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iM15251b = m15251b(i);
        if (iM15251b + i3 <= this.f14600a) {
            this.f14601c.seek(iM15251b);
            this.f14601c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f14600a - iM15251b;
        this.f14601c.seek(iM15251b);
        this.f14601c.readFully(bArr, i2, i4);
        this.f14601c.seek(16L);
        this.f14601c.readFully(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: renamed from: a */
    public void m15262a(byte[] bArr) throws IOException {
        m15263a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15263a(byte[] bArr, int i, int i2) throws IOException {
        m15253b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m15257c(i2);
        boolean zM15265b = m15265b();
        Element element = new Element(zM15265b ? 16 : m15251b(this.f14604f.f14610b + 4 + this.f14604f.f14611c), i2);
        m15255b(this.f14605g, 0, i2);
        m15247a(element.f14610b, this.f14605g, 0, 4);
        m15247a(element.f14610b + 4, bArr, i, i2);
        m15246a(this.f14600a, this.f14602d + 1, zM15265b ? element.f14610b : this.f14603e.f14610b, element.f14610b);
        this.f14604f = element;
        this.f14602d++;
        if (zM15265b) {
            this.f14603e = this.f14604f;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m15260a() {
        if (this.f14602d == 0) {
            return 16;
        }
        if (this.f14604f.f14610b >= this.f14603e.f14610b) {
            return (this.f14604f.f14610b - this.f14603e.f14610b) + 4 + this.f14604f.f14611c + 16;
        }
        return (((this.f14604f.f14610b + 4) + this.f14604f.f14611c) + this.f14600a) - this.f14603e.f14610b;
    }

    /* JADX INFO: renamed from: d */
    private int m15258d() {
        return this.f14600a - m15260a();
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m15265b() {
        return this.f14602d == 0;
    }

    /* JADX INFO: renamed from: c */
    private void m15257c(int i) throws IOException {
        int i2 = i + 4;
        int iM15258d = m15258d();
        if (iM15258d < i2) {
            int i3 = this.f14600a;
            do {
                iM15258d += i3;
                i3 <<= 1;
            } while (iM15258d < i2);
            m15259d(i3);
            int iM15251b = m15251b(this.f14604f.f14610b + 4 + this.f14604f.f14611c);
            if (iM15251b < this.f14603e.f14610b) {
                FileChannel channel = this.f14601c.getChannel();
                channel.position(this.f14600a);
                int i4 = iM15251b - 4;
                if (channel.transferTo(16L, i4, channel) != i4) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f14604f.f14610b < this.f14603e.f14610b) {
                int i5 = (this.f14600a + this.f14604f.f14610b) - 16;
                m15246a(i3, this.f14602d, this.f14603e.f14610b, i5);
                this.f14604f = new Element(i5, this.f14604f.f14611c);
            } else {
                m15246a(i3, this.f14602d, this.f14603e.f14610b, this.f14604f.f14610b);
            }
            this.f14600a = i3;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m15259d(int i) throws IOException {
        this.f14601c.setLength(i);
        this.f14601c.getChannel().force(true);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15261a(ElementReader elementReader) throws IOException {
        int iM15251b = this.f14603e.f14610b;
        for (int i = 0; i < this.f14602d; i++) {
            Element elementM15243a = m15243a(iM15251b);
            elementReader.mo5958a(new ElementInputStream(elementM15243a), elementM15243a.f14611c);
            iM15251b = m15251b(elementM15243a.f14611c + elementM15243a.f14610b + 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static <T> T m15253b(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    private final class ElementInputStream extends InputStream {

        /* JADX INFO: renamed from: b */
        private int f14613b;

        /* JADX INFO: renamed from: c */
        private int f14614c;

        private ElementInputStream(Element element) {
            this.f14613b = QueueFile.this.m15251b(element.f14610b + 4);
            this.f14614c = element.f14611c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            QueueFile.m15253b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.f14614c <= 0) {
                return -1;
            }
            if (i2 > this.f14614c) {
                i2 = this.f14614c;
            }
            QueueFile.this.m15254b(this.f14613b, bArr, i, i2);
            this.f14613b = QueueFile.this.m15251b(this.f14613b + i2);
            this.f14614c -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f14614c != 0) {
                QueueFile.this.f14601c.seek(this.f14613b);
                int i = QueueFile.this.f14601c.read();
                this.f14613b = QueueFile.this.m15251b(this.f14613b + 1);
                this.f14614c--;
                return i;
            }
            return -1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f14601c.close();
    }

    /* JADX INFO: renamed from: a */
    public boolean m15264a(int i, int i2) {
        return (m15260a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("fileLength=").append(this.f14600a);
        sb.append(", size=").append(this.f14602d);
        sb.append(", first=").append(this.f14603e);
        sb.append(", last=").append(this.f14604f);
        sb.append(", element lengths=[");
        try {
            m15261a(new ElementReader() { // from class: io.fabric.sdk.android.services.common.QueueFile.1

                /* JADX INFO: renamed from: a */
                boolean f14606a = true;

                @Override // io.fabric.sdk.android.services.common.QueueFile.ElementReader
                /* JADX INFO: renamed from: a */
                public void mo5958a(InputStream inputStream, int i) throws IOException {
                    if (this.f14606a) {
                        this.f14606a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f14599b.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class Element {

        /* JADX INFO: renamed from: a */
        static final Element f14609a = new Element(0, 0);

        /* JADX INFO: renamed from: b */
        final int f14610b;

        /* JADX INFO: renamed from: c */
        final int f14611c;

        Element(int i, int i2) {
            this.f14610b = i;
            this.f14611c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f14610b + ", length = " + this.f14611c + "]";
        }
    }
}
