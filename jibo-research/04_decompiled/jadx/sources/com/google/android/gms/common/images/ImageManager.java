package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbfl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class ImageManager {

    /* JADX INFO: renamed from: a */
    private static final Object f6490a = new Object();

    /* JADX INFO: renamed from: b */
    private static HashSet<Uri> f6491b = new HashSet<>();

    /* JADX INFO: renamed from: c */
    private final Context f6492c;

    /* JADX INFO: renamed from: d */
    private final Handler f6493d;

    /* JADX INFO: renamed from: e */
    private final ExecutorService f6494e;

    /* JADX INFO: renamed from: f */
    private final zza f6495f;

    /* JADX INFO: renamed from: g */
    private final zzbfl f6496g;

    /* JADX INFO: renamed from: h */
    private final Map<com.google.android.gms.common.images.zza, ImageReceiver> f6497h;

    /* JADX INFO: renamed from: i */
    private final Map<Uri, ImageReceiver> f6498i;

    /* JADX INFO: renamed from: j */
    private final Map<Uri, Long> f6499j;

    @KeepName
    final class ImageReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: a */
        private final Uri f6500a;

        /* JADX INFO: renamed from: b */
        private final ArrayList<com.google.android.gms.common.images.zza> f6501b;

        /* JADX INFO: renamed from: c */
        private /* synthetic */ ImageManager f6502c;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            this.f6502c.f6494e.execute(this.f6502c.new zzb(this.f6500a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        /* JADX INFO: renamed from: a */
        void m7301a(Uri uri, Drawable drawable, boolean z);
    }

    static final class zza extends LruCache<com.google.android.gms.common.images.zzb, Bitmap> {
        @Override // android.support.v4.util.LruCache
        /* JADX INFO: renamed from: a */
        protected final /* synthetic */ void mo2421a(boolean z, com.google.android.gms.common.images.zzb zzbVar, Bitmap bitmap, Bitmap bitmap2) {
            super.mo2421a(z, zzbVar, bitmap, bitmap2);
        }

        @Override // android.support.v4.util.LruCache
        /* JADX INFO: renamed from: b */
        protected final /* synthetic */ int mo2422b(com.google.android.gms.common.images.zzb zzbVar, Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return bitmap2.getHeight() * bitmap2.getRowBytes();
        }
    }

    final class zzb implements Runnable {

        /* JADX INFO: renamed from: a */
        private final Uri f6503a;

        /* JADX INFO: renamed from: b */
        private final ParcelFileDescriptor f6504b;

        public zzb(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f6503a = uri;
            this.f6504b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                String strValueOf = String.valueOf(Thread.currentThread());
                String strValueOf2 = String.valueOf(Looper.getMainLooper().getThread());
                Log.e("Asserts", new StringBuilder(String.valueOf(strValueOf).length() + 56 + String.valueOf(strValueOf2).length()).append("checkNotMainThread: current thread ").append(strValueOf).append(" IS the main thread ").append(strValueOf2).append("!").toString());
                throw new IllegalStateException("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            }
            boolean z = false;
            Bitmap bitmapDecodeFileDescriptor = null;
            if (this.f6504b != null) {
                try {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(this.f6504b.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String strValueOf3 = String.valueOf(this.f6503a);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(strValueOf3).length() + 34).append("OOM while loading bitmap for uri: ").append(strValueOf3).toString(), e);
                    z = true;
                }
                try {
                    this.f6504b.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.f6493d.post(ImageManager.this.new zzd(this.f6503a, bitmapDecodeFileDescriptor, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String strValueOf4 = String.valueOf(this.f6503a);
                Log.w("ImageManager", new StringBuilder(String.valueOf(strValueOf4).length() + 32).append("Latch interrupted while posting ").append(strValueOf4).toString());
            }
        }
    }

    final class zzd implements Runnable {

        /* JADX INFO: renamed from: a */
        private final Uri f6506a;

        /* JADX INFO: renamed from: b */
        private final Bitmap f6507b;

        /* JADX INFO: renamed from: c */
        private final CountDownLatch f6508c;

        /* JADX INFO: renamed from: d */
        private boolean f6509d;

        public zzd(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f6506a = uri;
            this.f6507b = bitmap;
            this.f6509d = z;
            this.f6508c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            zzc.m7397a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f6507b != null;
            if (ImageManager.this.f6495f != null) {
                if (this.f6509d) {
                    ImageManager.this.f6495f.m2419a();
                    System.gc();
                    this.f6509d = false;
                    ImageManager.this.f6493d.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.f6495f.m2418a(new com.google.android.gms.common.images.zzb(this.f6506a), this.f6507b);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f6498i.remove(this.f6506a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.f6501b;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    com.google.android.gms.common.images.zza zzaVar = (com.google.android.gms.common.images.zza) arrayList.get(i);
                    if (z) {
                        zzaVar.m7305a(ImageManager.this.f6492c, this.f6507b, false);
                    } else {
                        ImageManager.this.f6499j.put(this.f6506a, Long.valueOf(SystemClock.elapsedRealtime()));
                        zzaVar.m7306a(ImageManager.this.f6492c, ImageManager.this.f6496g, false);
                    }
                    if (!(zzaVar instanceof com.google.android.gms.common.images.zzd)) {
                        ImageManager.this.f6497h.remove(zzaVar);
                    }
                }
            }
            this.f6508c.countDown();
            synchronized (ImageManager.f6490a) {
                ImageManager.f6491b.remove(this.f6506a);
            }
        }
    }
}
