package okhttp3.internal.p026io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes2.dex */
public interface FileSystem {

    /* JADX INFO: renamed from: a */
    public static final FileSystem f15578a = new FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: a */
        public Source mo16168a(File file) throws FileNotFoundException {
            return Okio.m16365a(file);
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: b */
        public Sink mo16170b(File file) throws FileNotFoundException {
            try {
                return Okio.m16369b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return Okio.m16369b(file);
            }
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: c */
        public Sink mo16171c(File file) throws FileNotFoundException {
            try {
                return Okio.m16372c(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return Okio.m16372c(file);
            }
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: d */
        public void mo16172d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: e */
        public boolean mo16173e(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: f */
        public long mo16174f(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: a */
        public void mo16169a(File file, File file2) throws IOException {
            mo16172d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // okhttp3.internal.p026io.FileSystem
        /* JADX INFO: renamed from: g */
        public void mo16175g(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    mo16175g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    /* JADX INFO: renamed from: a */
    Source mo16168a(File file) throws FileNotFoundException;

    /* JADX INFO: renamed from: a */
    void mo16169a(File file, File file2) throws IOException;

    /* JADX INFO: renamed from: b */
    Sink mo16170b(File file) throws FileNotFoundException;

    /* JADX INFO: renamed from: c */
    Sink mo16171c(File file) throws FileNotFoundException;

    /* JADX INFO: renamed from: d */
    void mo16172d(File file) throws IOException;

    /* JADX INFO: renamed from: e */
    boolean mo16173e(File file);

    /* JADX INFO: renamed from: f */
    long mo16174f(File file);

    /* JADX INFO: renamed from: g */
    void mo16175g(File file) throws IOException;
}
