package com.segment.analytics;

import com.segment.analytics.PayloadQueue;
import java.io.Closeable;
import java.io.EOFException;
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
public class QueueFile implements Closeable {
    static final int HEADER_LENGTH = 16;
    private final byte[] buffer;
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    final RandomAccessFile raf;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private static final int INITIAL_LENGTH = 4096;
    private static final byte[] ZEROES = new byte[INITIAL_LENGTH];

    public QueueFile(File file) throws IOException {
        this.buffer = new byte[16];
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    QueueFile(RandomAccessFile randomAccessFile) throws IOException {
        this.buffer = new byte[16];
        this.raf = randomAccessFile;
        readHeader();
    }

    private static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static int readInt(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private void readHeader() throws IOException {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        this.fileLength = readInt(this.buffer, 0);
        if (this.fileLength > this.raf.length()) {
            throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
        }
        if (this.fileLength <= 0) {
            throw new IOException("File is corrupt; length stored in header (" + this.fileLength + ") is invalid.");
        }
        this.elementCount = readInt(this.buffer, 4);
        int i = readInt(this.buffer, 8);
        int i2 = readInt(this.buffer, 12);
        this.first = readElement(i);
        this.last = readElement(i2);
    }

    private void writeHeader(int i, int i2, int i3, int i4) throws IOException {
        writeInt(this.buffer, 0, i);
        writeInt(this.buffer, 4, i2);
        writeInt(this.buffer, 8, i3);
        writeInt(this.buffer, 12, i4);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private Element readElement(int i) throws IOException {
        if (i == 0) {
            return Element.NULL;
        }
        ringRead(i, this.buffer, 0, 4);
        return new Element(i, readInt(this.buffer, 0));
    }

    private static void initialize(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileOpen = open(file2);
        try {
            randomAccessFileOpen.setLength(4096L);
            randomAccessFileOpen.seek(0L);
            byte[] bArr = new byte[16];
            writeInt(bArr, 0, INITIAL_LENGTH);
            randomAccessFileOpen.write(bArr);
            randomAccessFileOpen.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileOpen.close();
            throw th;
        }
    }

    private static RandomAccessFile open(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    int wrapPosition(int i) {
        return i < this.fileLength ? i : (i + 16) - this.fileLength;
    }

    private void ringWrite(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iWrapPosition = wrapPosition(i);
        if (iWrapPosition + i3 <= this.fileLength) {
            this.raf.seek(iWrapPosition);
            this.raf.write(bArr, i2, i3);
            return;
        }
        int i4 = this.fileLength - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.write(bArr, i2, i4);
        this.raf.seek(16L);
        this.raf.write(bArr, i2 + i4, i3 - i4);
    }

    private void ringErase(int i, int i2) throws IOException {
        while (i2 > 0) {
            int iMin = Math.min(i2, ZEROES.length);
            ringWrite(i, ZEROES, 0, iMin);
            i2 -= iMin;
            i += iMin;
        }
    }

    void ringRead(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iWrapPosition = wrapPosition(i);
        if (iWrapPosition + i3 <= this.fileLength) {
            this.raf.seek(iWrapPosition);
            this.raf.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.fileLength - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.readFully(bArr, i2, i4);
        this.raf.seek(16L);
        this.raf.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void add(byte[] bArr) throws IOException {
        add(bArr, 0, bArr.length);
    }

    public synchronized void add(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        expandIfNecessary(i2);
        boolean zIsEmpty = isEmpty();
        Element element = new Element(zIsEmpty ? 16 : wrapPosition(this.last.position + 4 + this.last.length), i2);
        writeInt(this.buffer, 0, i2);
        ringWrite(element.position, this.buffer, 0, 4);
        ringWrite(element.position + 4, bArr, i, i2);
        writeHeader(this.fileLength, this.elementCount + 1, zIsEmpty ? element.position : this.first.position, element.position);
        this.last = element;
        this.elementCount++;
        if (zIsEmpty) {
            this.first = this.last;
        }
    }

    private int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        if (this.last.position >= this.first.position) {
            return (this.last.position - this.first.position) + 4 + this.last.length + 16;
        }
        return (((this.last.position + 4) + this.last.length) + this.fileLength) - this.first.position;
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    private void expandIfNecessary(int i) throws IOException {
        int i2 = i + 4;
        int iRemainingBytes = remainingBytes();
        if (iRemainingBytes < i2) {
            int i3 = this.fileLength;
            while (true) {
                iRemainingBytes += i3;
                int i4 = i3 << 1;
                if (i4 < i3) {
                    throw new EOFException("Cannot grow file beyond " + i3 + " bytes");
                }
                if (iRemainingBytes >= i2) {
                    setLength(i4);
                    int iWrapPosition = wrapPosition(this.last.position + 4 + this.last.length);
                    if (iWrapPosition <= this.first.position) {
                        FileChannel channel = this.raf.getChannel();
                        channel.position(this.fileLength);
                        int i5 = iWrapPosition - 16;
                        if (channel.transferTo(16L, i5, channel) != i5) {
                            throw new AssertionError("Copied insufficient number of bytes!");
                        }
                        ringErase(16, i5);
                    }
                    if (this.last.position < this.first.position) {
                        int i6 = (this.fileLength + this.last.position) - 16;
                        writeHeader(i4, this.elementCount, this.first.position, i6);
                        this.last = new Element(i6, this.last.length);
                    } else {
                        writeHeader(i4, this.elementCount, this.first.position, this.last.position);
                    }
                    this.fileLength = i4;
                    return;
                }
                i3 = i4;
            }
        }
    }

    private void setLength(int i) throws IOException {
        this.raf.setLength(i);
        this.raf.getChannel().force(true);
    }

    public synchronized byte[] peek() throws IOException {
        byte[] bArr;
        if (isEmpty()) {
            bArr = null;
        } else {
            int i = this.first.length;
            bArr = new byte[i];
            ringRead(this.first.position + 4, bArr, 0, i);
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        r0 = r4.elementCount;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int forEach(com.segment.analytics.PayloadQueue.ElementVisitor r5) throws java.io.IOException {
        /*
            r4 = this;
            monitor-enter(r4)
            com.segment.analytics.QueueFile$Element r0 = r4.first     // Catch: java.lang.Throwable -> L30
            int r1 = r0.position     // Catch: java.lang.Throwable -> L30
            r0 = 0
        L6:
            int r2 = r4.elementCount     // Catch: java.lang.Throwable -> L30
            if (r0 >= r2) goto L2d
            com.segment.analytics.QueueFile$Element r1 = r4.readElement(r1)     // Catch: java.lang.Throwable -> L30
            com.segment.analytics.QueueFile$ElementInputStream r2 = new com.segment.analytics.QueueFile$ElementInputStream     // Catch: java.lang.Throwable -> L30
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L30
            int r3 = r1.length     // Catch: java.lang.Throwable -> L30
            boolean r2 = r5.read(r2, r3)     // Catch: java.lang.Throwable -> L30
            if (r2 != 0) goto L1f
            int r0 = r0 + 1
        L1d:
            monitor-exit(r4)
            return r0
        L1f:
            int r2 = r1.position     // Catch: java.lang.Throwable -> L30
            int r2 = r2 + 4
            int r1 = r1.length     // Catch: java.lang.Throwable -> L30
            int r1 = r1 + r2
            int r1 = r4.wrapPosition(r1)     // Catch: java.lang.Throwable -> L30
            int r0 = r0 + 1
            goto L6
        L2d:
            int r0 = r4.elementCount     // Catch: java.lang.Throwable -> L30
            goto L1d
        L30:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.segment.analytics.QueueFile.forEach(com.segment.analytics.PayloadQueue$ElementVisitor):int");
    }

    final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.remaining == 0) {
                return -1;
            }
            if (i2 > this.remaining) {
                i2 = this.remaining;
            }
            QueueFile.this.ringRead(this.position, bArr, i, i2);
            this.position = QueueFile.this.wrapPosition(this.position + i2);
            this.remaining -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek(this.position);
            int i = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return i;
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public synchronized void remove() throws IOException {
        remove(1);
    }

    public synchronized void remove(int i) throws IOException {
        synchronized (this) {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (i < 0) {
                throw new IllegalArgumentException("Cannot remove negative (" + i + ") number of elements.");
            }
            if (i != 0) {
                if (i == this.elementCount) {
                    clear();
                } else {
                    if (i > this.elementCount) {
                        throw new IllegalArgumentException("Cannot remove more elements (" + i + ") than present in queue (" + this.elementCount + ").");
                    }
                    int i2 = this.first.position;
                    int iWrapPosition = this.first.position;
                    int i3 = this.first.length;
                    int i4 = 0;
                    for (int i5 = 0; i5 < i; i5++) {
                        i4 += i3 + 4;
                        iWrapPosition = wrapPosition(i3 + iWrapPosition + 4);
                        ringRead(iWrapPosition, this.buffer, 0, 4);
                        i3 = readInt(this.buffer, 0);
                    }
                    writeHeader(this.fileLength, this.elementCount - i, iWrapPosition, this.last.position);
                    this.elementCount -= i;
                    this.first = new Element(iWrapPosition, i3);
                    ringErase(i2, i4);
                }
            }
        }
    }

    public synchronized void clear() throws IOException {
        writeHeader(INITIAL_LENGTH, 0, 0, 0);
        this.raf.seek(16L);
        this.raf.write(ZEROES, 0, 4080);
        this.elementCount = 0;
        this.first = Element.NULL;
        this.last = Element.NULL;
        if (this.fileLength > INITIAL_LENGTH) {
            setLength(INITIAL_LENGTH);
        }
        this.fileLength = INITIAL_LENGTH;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.raf.close();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("fileLength=").append(this.fileLength);
        sb.append(", size=").append(this.elementCount);
        sb.append(", first=").append(this.first);
        sb.append(", last=").append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new PayloadQueue.ElementVisitor() { // from class: com.segment.analytics.QueueFile.1
                boolean first = true;

                @Override // com.segment.analytics.PayloadQueue.ElementVisitor
                public boolean read(InputStream inputStream, int i) throws IOException {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                    return true;
                }
            });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class Element {
        static final int HEADER_LENGTH = 4;
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        Element(int i, int i2) {
            this.position = i;
            this.length = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.position + ", length = " + this.length + "]";
        }
    }
}
