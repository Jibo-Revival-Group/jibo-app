package com.crashlytics.android.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ClsFileOutputStream extends FileOutputStream {

    /* JADX INFO: renamed from: a */
    public static final FilenameFilter f5148a = new FilenameFilter() { // from class: com.crashlytics.android.core.ClsFileOutputStream.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };

    /* JADX INFO: renamed from: b */
    private final String f5149b;

    /* JADX INFO: renamed from: c */
    private File f5150c;

    /* JADX INFO: renamed from: d */
    private File f5151d;

    /* JADX INFO: renamed from: e */
    private boolean f5152e;

    public ClsFileOutputStream(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f5152e = false;
        this.f5149b = file + File.separator + str;
        this.f5150c = new File(this.f5149b + ".cls_temp");
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.f5152e) {
            this.f5152e = true;
            super.flush();
            super.close();
            File file = new File(this.f5149b + ".cls");
            if (this.f5150c.renameTo(file)) {
                this.f5150c = null;
                this.f5151d = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.f5150c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.f5150c + " -> " + file + str);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5721a() throws IOException {
        if (!this.f5152e) {
            this.f5152e = true;
            super.flush();
            super.close();
        }
    }
}
