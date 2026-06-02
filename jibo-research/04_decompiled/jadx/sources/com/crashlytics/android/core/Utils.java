package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class Utils {

    /* JADX INFO: renamed from: a */
    private static final FilenameFilter f5345a = new FilenameFilter() { // from class: com.crashlytics.android.core.Utils.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    };

    /* JADX INFO: renamed from: a */
    static int m6001a(File file, int i, Comparator<File> comparator) {
        return m6002a(file, f5345a, i, comparator);
    }

    /* JADX INFO: renamed from: a */
    static int m6002a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        int i2 = 0;
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            Arrays.sort(fileArrListFiles, comparator);
            int length2 = fileArrListFiles.length;
            i2 = length;
            int i3 = 0;
            while (i3 < length2) {
                File file2 = fileArrListFiles[i3];
                if (i2 <= i) {
                    break;
                }
                file2.delete();
                i3++;
                i2--;
            }
        }
        return i2;
    }
}
