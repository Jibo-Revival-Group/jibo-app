package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    private static final boolean DEBUG = false;
    public static final String HIDDEN_PREFIX = ".";
    public static final String MIME_TYPE_APP = "application/*";
    public static final String MIME_TYPE_AUDIO = "audio/*";
    public static final String MIME_TYPE_IMAGE = "image/*";
    public static final String MIME_TYPE_TEXT = "text/*";
    public static final String MIME_TYPE_VIDEO = "video/*";
    static final String TAG = "FileUtils";
    public static Comparator<File> sComparator = new Comparator<File>() { // from class: com.yalantis.ucrop.util.FileUtils.1
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
        }
    };
    public static FileFilter sFileFilter = new FileFilter() { // from class: com.yalantis.ucrop.util.FileUtils.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile() && !file.getName().startsWith(FileUtils.HIDDEN_PREFIX);
        }
    };
    public static FileFilter sDirFilter = new FileFilter() { // from class: com.yalantis.ucrop.util.FileUtils.3
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && !file.getName().startsWith(FileUtils.HIDDEN_PREFIX);
        }
    };

    private FileUtils() {
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(HIDDEN_PREFIX);
        if (iLastIndexOf >= 0) {
            return str.substring(iLastIndexOf);
        }
        return "";
    }

    public static boolean isLocal(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    public static boolean isMediaUri(Uri uri) {
        return ShareConstants.WEB_DIALOG_PARAM_MEDIA.equalsIgnoreCase(uri.getAuthority());
    }

    public static Uri getUri(File file) {
        if (file != null) {
            return Uri.fromFile(file);
        }
        return null;
    }

    public static File getPathWithoutFilename(File file) {
        if (file != null) {
            if (!file.isDirectory()) {
                String name = file.getName();
                String absolutePath = file.getAbsolutePath();
                String strSubstring = absolutePath.substring(0, absolutePath.length() - name.length());
                if (strSubstring.endsWith("/")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                return new File(strSubstring);
            }
            return file;
        }
        return null;
    }

    public static String getMimeType(File file) {
        String extension = getExtension(file.getName());
        return extension.length() > 0 ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.substring(1)) : "application/octet-stream";
    }

    public static String getMimeType(Context context, Uri uri) {
        return getMimeType(new File(getPath(context, uri)));
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDataColumn(android.content.Context r7, android.net.Uri r8, java.lang.String r9, java.lang.String[] r10) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r0 = "_data"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r1 = "_data"
            r2[r0] = r1
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L36 java.lang.Throwable -> L45
            r5 = 0
            r1 = r8
            r3 = r9
            r4 = r10
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.IllegalArgumentException -> L36 java.lang.Throwable -> L45
            if (r1 == 0) goto L2f
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.IllegalArgumentException -> L4f
            if (r0 == 0) goto L2f
            java.lang.String r0 = "_data"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L4d java.lang.IllegalArgumentException -> L4f
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4d java.lang.IllegalArgumentException -> L4f
            if (r1 == 0) goto L2e
            r1.close()
        L2e:
            return r0
        L2f:
            if (r1 == 0) goto L34
            r1.close()
        L34:
            r0 = r6
            goto L2e
        L36:
            r0 = move-exception
            r1 = r6
        L38:
            java.lang.String r2 = "FileUtils"
            java.lang.String r3 = "getDataColumn: _data"
            android.util.Log.i(r2, r3, r0)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L34
            r1.close()
            goto L34
        L45:
            r0 = move-exception
            r1 = r6
        L47:
            if (r1 == 0) goto L4c
            r1.close()
        L4c:
            throw r0
        L4d:
            r0 = move-exception
            goto L47
        L4f:
            r0 = move-exception
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
                return null;
            }
            if (isDownloadsDocument(uri)) {
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            }
            if (!isMediaDocument(uri)) {
                return null;
            }
            String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = strArrSplit2[0];
            if (Media.TYPE_IMAGE.equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO.equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if (Media.TYPE_AUDIO.equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static File getFile(Context context, Uri uri) {
        String path;
        if (uri == null || (path = getPath(context, uri)) == null || !isLocal(path)) {
            return null;
        }
        return new File(path);
    }

    public static String getReadableFileSize(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        String str = " KB";
        if (i > 1024) {
            f = i / 1024;
            if (f > 1024.0f) {
                f /= 1024.0f;
                if (f > 1024.0f) {
                    f /= 1024.0f;
                    str = " GB";
                } else {
                    str = " MB";
                }
            }
        }
        return String.valueOf(decimalFormat.format(f) + str);
    }

    public static Bitmap getThumbnail(Context context, File file) {
        return getThumbnail(context, getUri(file), getMimeType(file));
    }

    public static Bitmap getThumbnail(Context context, Uri uri) {
        return getThumbnail(context, uri, getMimeType(context, uri));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap getThumbnail(android.content.Context r7, android.net.Uri r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            boolean r0 = isMediaUri(r8)
            if (r0 != 0) goto Lf
            java.lang.String r0 = "FileUtils"
            java.lang.String r1 = "You can only retrieve thumbnails for images and videos."
            android.util.Log.e(r0, r1)
        Le:
            return r6
        Lf:
            if (r8 == 0) goto L67
            android.content.ContentResolver r0 = r7.getContentResolver()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r1 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L5a
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            if (r2 == 0) goto L69
            r2 = 0
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            java.lang.String r3 = "video"
            boolean r3 = r9.contains(r3)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            if (r3 == 0) goto L40
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r4 = 1
            r5 = 0
            android.graphics.Bitmap r6 = android.provider.MediaStore.Video.Thumbnails.getThumbnail(r0, r2, r4, r5)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r0 = r6
        L39:
            if (r1 == 0) goto L3e
            r1.close()
        L3e:
            r6 = r0
            goto Le
        L40:
            java.lang.String r3 = "image/*"
            boolean r3 = r9.contains(r3)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            if (r3 == 0) goto L69
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r4 = 1
            r5 = 0
            android.graphics.Bitmap r6 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(r0, r2, r4, r5)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r0 = r6
            goto L39
        L51:
            r0 = move-exception
            r0 = r6
        L53:
            if (r0 == 0) goto L67
            r0.close()
            r0 = r6
            goto L3e
        L5a:
            r0 = move-exception
            r1 = r6
        L5c:
            if (r1 == 0) goto L61
            r1.close()
        L61:
            throw r0
        L62:
            r0 = move-exception
            goto L5c
        L64:
            r0 = move-exception
            r0 = r1
            goto L53
        L67:
            r0 = r6
            goto L3e
        L69:
            r0 = r6
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.getThumbnail(android.content.Context, android.net.Uri, java.lang.String):android.graphics.Bitmap");
    }

    public static Intent createGetContentIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        return intent;
    }

    public static void copyFile(String str, String str2) throws Throwable {
        FileChannel channel;
        FileChannel channel2;
        FileChannel fileChannel = null;
        try {
            channel = new FileInputStream(new File(str)).getChannel();
            try {
                channel2 = new FileOutputStream(new File(str2)).getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                channel.transferTo(0L, channel.size(), channel2);
                channel.close();
                if (channel != null) {
                    channel.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel2;
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            channel = null;
        }
    }
}
