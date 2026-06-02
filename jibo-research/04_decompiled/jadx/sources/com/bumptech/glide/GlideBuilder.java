package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class GlideBuilder {

    /* JADX INFO: renamed from: a */
    private final Context f4717a;

    /* JADX INFO: renamed from: b */
    private Engine f4718b;

    /* JADX INFO: renamed from: c */
    private BitmapPool f4719c;

    /* JADX INFO: renamed from: d */
    private MemoryCache f4720d;

    /* JADX INFO: renamed from: e */
    private ExecutorService f4721e;

    /* JADX INFO: renamed from: f */
    private ExecutorService f4722f;

    /* JADX INFO: renamed from: g */
    private DecodeFormat f4723g;

    /* JADX INFO: renamed from: h */
    private DiskCache.Factory f4724h;

    public GlideBuilder(Context context) {
        this.f4717a = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public GlideBuilder m5268a(DiskCache.Factory factory) {
        this.f4724h = factory;
        return this;
    }

    /* JADX INFO: renamed from: a */
    Glide m5267a() {
        if (this.f4721e == null) {
            this.f4721e = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f4722f == null) {
            this.f4722f = new FifoPriorityThreadPoolExecutor(1);
        }
        MemorySizeCalculator memorySizeCalculator = new MemorySizeCalculator(this.f4717a);
        if (this.f4719c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f4719c = new LruBitmapPool(memorySizeCalculator.getBitmapPoolSize());
            } else {
                this.f4719c = new BitmapPoolAdapter();
            }
        }
        if (this.f4720d == null) {
            this.f4720d = new LruResourceCache(memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.f4724h == null) {
            this.f4724h = new InternalCacheDiskCacheFactory(this.f4717a);
        }
        if (this.f4718b == null) {
            this.f4718b = new Engine(this.f4720d, this.f4724h, this.f4722f, this.f4721e);
        }
        if (this.f4723g == null) {
            this.f4723g = DecodeFormat.DEFAULT;
        }
        return new Glide(this.f4718b, this.f4720d, this.f4719c, this.f4717a, this.f4723g);
    }
}
