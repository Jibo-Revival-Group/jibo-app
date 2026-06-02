package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.C0444R;
import com.facebook.FacebookException;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
            synchronized (pendingRequests) {
                DownloaderContext downloaderContext = pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.request = imageRequest;
                    downloaderContext.isCancelled = false;
                    downloaderContext.workItem.moveToFront();
                } else {
                    enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                }
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext == null) {
                z = false;
            } else if (downloaderContext.workItem.cancel()) {
                pendingRequests.remove(requestKey);
                z = true;
            } else {
                downloaderContext.isCancelled = true;
                z = true;
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    public static void clearCache(Context context) {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext();
            downloaderContext.request = imageRequest;
            pendingRequests.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z) {
        final ImageRequest imageRequest;
        final ImageRequest.Callback callback;
        DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
        if (downloaderContextRemovePendingRequest != null && !downloaderContextRemovePendingRequest.isCancelled && (callback = (imageRequest = downloaderContextRemovePendingRequest.request).getCallback()) != null) {
            getHandler().post(new Runnable() { // from class: com.facebook.internal.ImageDownloader.1
                @Override // java.lang.Runnable
                public void run() {
                    callback.onCompleted(new ImageResponse(imageRequest, exc, z, bitmap));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        boolean z2;
        InputStream cachedImageStream;
        Uri redirectedUri;
        if (!z || (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.uri)) == null) {
            z2 = false;
            cachedImageStream = null;
        } else {
            InputStream cachedImageStream2 = ImageResponseCache.getCachedImageStream(redirectedUri, context);
            cachedImageStream = cachedImageStream2;
            z2 = cachedImageStream2 != null;
        }
        if (!z2) {
            cachedImageStream = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
        }
        if (cachedImageStream != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(cachedImageStream);
            Utility.closeQuietly(cachedImageStream);
            issueResponse(requestKey, null, bitmapDecodeStream, z2);
        } else {
            DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
            if (downloaderContextRemovePendingRequest != null && !downloaderContextRemovePendingRequest.isCancelled) {
                enqueueDownload(downloaderContextRemovePendingRequest.request, requestKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0022. Please report as an issue. */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a7: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:36:0x00a7 */
    public static void download(RequestKey requestKey, Context context) throws Throwable {
        HttpURLConnection httpURLConnection;
        Closeable closeable;
        HttpURLConnection httpURLConnection2;
        Exception facebookException;
        Closeable closeable2;
        InputStream inputStreamInterceptAndCacheImageStream;
        Closeable closeable3 = null;
        bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        closeable3 = null;
        Bitmap bitmapDecodeStream = null;
        boolean z = true;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(requestKey.uri.toString()).openConnection()));
            try {
                try {
                    httpURLConnection3.setInstanceFollowRedirects(false);
                } catch (IOException e) {
                    closeable = null;
                    httpURLConnection2 = httpURLConnection3;
                    e = e;
                }
            } catch (Throwable th) {
                httpURLConnection = httpURLConnection3;
                th = th;
            }
            try {
                switch (httpURLConnection3.getResponseCode()) {
                    case 200:
                        inputStreamInterceptAndCacheImageStream = ImageResponseCache.interceptAndCacheImageStream(context, httpURLConnection3);
                        facebookException = null;
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamInterceptAndCacheImageStream);
                        Utility.closeQuietly(inputStreamInterceptAndCacheImageStream);
                        Utility.disconnectQuietly(httpURLConnection3);
                        break;
                    case 301:
                    case 302:
                        try {
                            String headerField = httpURLConnection3.getHeaderField(SkillsJsonParser.TYPE_LOCATION);
                            if (Utility.isNullOrEmpty(headerField)) {
                                z = false;
                                facebookException = null;
                                inputStreamInterceptAndCacheImageStream = null;
                            } else {
                                Uri uri = Uri.parse(headerField);
                                UrlRedirectCache.cacheUriRedirect(requestKey.uri, uri);
                                DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
                                if (downloaderContextRemovePendingRequest != null && !downloaderContextRemovePendingRequest.isCancelled) {
                                    enqueueCacheRead(downloaderContextRemovePendingRequest.request, new RequestKey(uri, requestKey.tag), false);
                                }
                                z = false;
                                facebookException = null;
                                inputStreamInterceptAndCacheImageStream = null;
                            }
                            Utility.closeQuietly(inputStreamInterceptAndCacheImageStream);
                            Utility.disconnectQuietly(httpURLConnection3);
                        } catch (IOException e2) {
                            closeable = null;
                            httpURLConnection2 = httpURLConnection3;
                            e = e2;
                            z = false;
                            Utility.closeQuietly(closeable);
                            Utility.disconnectQuietly(httpURLConnection2);
                            facebookException = e;
                        }
                        break;
                    default:
                        inputStreamInterceptAndCacheImageStream = httpURLConnection3.getErrorStream();
                        StringBuilder sb = new StringBuilder();
                        if (inputStreamInterceptAndCacheImageStream != null) {
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamInterceptAndCacheImageStream);
                            char[] cArr = new char[128];
                            while (true) {
                                int i = inputStreamReader.read(cArr, 0, cArr.length);
                                if (i > 0) {
                                    sb.append(cArr, 0, i);
                                } else {
                                    Utility.closeQuietly(inputStreamReader);
                                }
                            }
                        } else {
                            sb.append(context.getString(C0444R.string.com_facebook_image_download_unknown_error));
                        }
                        facebookException = new FacebookException(sb.toString());
                        Utility.closeQuietly(inputStreamInterceptAndCacheImageStream);
                        Utility.disconnectQuietly(httpURLConnection3);
                        break;
                }
            } catch (IOException e3) {
                httpURLConnection2 = httpURLConnection3;
                e = e3;
            } catch (Throwable th2) {
                closeable3 = closeable2;
                httpURLConnection = httpURLConnection3;
                th = th2;
                Utility.closeQuietly(closeable3);
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            closeable = null;
            httpURLConnection2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        if (z) {
            issueResponse(requestKey, facebookException, bitmapDecodeStream, false);
        }
    }

    private static synchronized Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext downloaderContextRemove;
        synchronized (pendingRequests) {
            downloaderContextRemove = pendingRequests.remove(requestKey);
        }
        return downloaderContextRemove;
    }

    private static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        Uri uri;

        RequestKey(Uri uri, Object obj) {
            this.uri = uri;
            this.tag = obj;
        }

        public int hashCode() {
            return ((this.uri.hashCode() + 1073) * 37) + this.tag.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            return requestKey.uri == this.uri && requestKey.tag == this.tag;
        }
    }

    private static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }
    }

    private static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context, RequestKey requestKey, boolean z) {
            this.context = context;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    private static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context, RequestKey requestKey) {
            this.context = context;
            this.key = requestKey;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ImageDownloader.download(this.key, this.context);
        }
    }
}
