package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class UrlRedirectCache {
    private static volatile FileLruCache urlRedirectCache;
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";

    UrlRedirectCache() {
    }

    static synchronized FileLruCache getCache() throws IOException {
        if (urlRedirectCache == null) {
            urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
        }
        return urlRedirectCache;
    }

    static Uri getRedirectedUri(Uri uri) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        FileLruCache cache;
        String string;
        InputStreamReader inputStreamReader2;
        Uri uri2 = null;
        boolean z = false;
        if (uri != null) {
            String string2 = uri.toString();
            try {
                cache = getCache();
                string = string2;
                inputStreamReader2 = null;
            } catch (IOException e) {
                inputStreamReader = null;
            } catch (Throwable th2) {
                inputStreamReader = null;
                th = th2;
            }
            while (true) {
                try {
                    InputStream inputStream = cache.get(string, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int i = inputStreamReader.read(cArr, 0, cArr.length);
                            if (i <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, i);
                        }
                        Utility.closeQuietly(inputStreamReader);
                        string = sb.toString();
                        inputStreamReader2 = inputStreamReader;
                        z = true;
                    } catch (IOException e2) {
                    } catch (Throwable th3) {
                        th = th3;
                        Utility.closeQuietly(inputStreamReader);
                        throw th;
                    }
                } catch (IOException e3) {
                    inputStreamReader = inputStreamReader2;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = inputStreamReader2;
                }
                Utility.closeQuietly(inputStreamReader);
            }
            if (z) {
                uri2 = Uri.parse(string);
                Utility.closeQuietly(inputStreamReader2);
            } else {
                Utility.closeQuietly(inputStreamReader2);
            }
        }
        return uri2;
    }

    static void cacheUriRedirect(Uri uri, Uri uri2) throws Throwable {
        OutputStream outputStream;
        Throwable th;
        if (uri != null && uri2 != null) {
            try {
                try {
                    OutputStream outputStreamOpenPutStream = getCache().openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
                    try {
                        outputStreamOpenPutStream.write(uri2.toString().getBytes());
                        Utility.closeQuietly(outputStreamOpenPutStream);
                    } catch (Throwable th2) {
                        outputStream = outputStreamOpenPutStream;
                        th = th2;
                        Utility.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (IOException e) {
                    Utility.closeQuietly(null);
                }
            } catch (Throwable th3) {
                outputStream = null;
                th = th3;
            }
        }
    }

    static void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
        }
    }
}
