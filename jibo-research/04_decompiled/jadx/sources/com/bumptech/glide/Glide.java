package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader;
import com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import com.bumptech.glide.load.model.stream.StreamFileLoader;
import com.bumptech.glide.load.model.stream.StreamResourceLoader;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.model.stream.StreamUriLoader;
import com.bumptech.glide.load.model.stream.StreamUrlLoader;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.file.StreamFileDataLoadProvider;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableLoadProvider;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.provider.DataLoadProviderRegistry;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Glide {

    /* JADX INFO: renamed from: a */
    private static volatile Glide f4702a;

    /* JADX INFO: renamed from: b */
    private final GenericLoaderFactory f4703b;

    /* JADX INFO: renamed from: c */
    private final Engine f4704c;

    /* JADX INFO: renamed from: d */
    private final BitmapPool f4705d;

    /* JADX INFO: renamed from: e */
    private final MemoryCache f4706e;

    /* JADX INFO: renamed from: f */
    private final DecodeFormat f4707f;

    /* JADX INFO: renamed from: j */
    private final CenterCrop f4711j;

    /* JADX INFO: renamed from: k */
    private final GifBitmapWrapperTransformation f4712k;

    /* JADX INFO: renamed from: l */
    private final FitCenter f4713l;

    /* JADX INFO: renamed from: m */
    private final GifBitmapWrapperTransformation f4714m;

    /* JADX INFO: renamed from: o */
    private final BitmapPreFiller f4716o;

    /* JADX INFO: renamed from: g */
    private final ImageViewTargetFactory f4708g = new ImageViewTargetFactory();

    /* JADX INFO: renamed from: h */
    private final TranscoderRegistry f4709h = new TranscoderRegistry();

    /* JADX INFO: renamed from: n */
    private final Handler f4715n = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i */
    private final DataLoadProviderRegistry f4710i = new DataLoadProviderRegistry();

    /* JADX INFO: renamed from: a */
    public static Glide m5249a(Context context) {
        if (f4702a == null) {
            synchronized (Glide.class) {
                if (f4702a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<GlideModule> listM5494a = new ManifestParser(applicationContext).m5494a();
                    GlideBuilder glideBuilder = new GlideBuilder(applicationContext);
                    Iterator<GlideModule> it = listM5494a.iterator();
                    while (it.hasNext()) {
                        it.next().mo5492a(applicationContext, glideBuilder);
                    }
                    f4702a = glideBuilder.m5267a();
                    Iterator<GlideModule> it2 = listM5494a.iterator();
                    while (it2.hasNext()) {
                        it2.next().mo5491a(applicationContext, f4702a);
                    }
                }
            }
        }
        return f4702a;
    }

    Glide(Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, Context context, DecodeFormat decodeFormat) {
        this.f4704c = engine;
        this.f4705d = bitmapPool;
        this.f4706e = memoryCache;
        this.f4707f = decodeFormat;
        this.f4703b = new GenericLoaderFactory(context);
        this.f4716o = new BitmapPreFiller(memoryCache, bitmapPool, decodeFormat);
        StreamBitmapDataLoadProvider streamBitmapDataLoadProvider = new StreamBitmapDataLoadProvider(bitmapPool, decodeFormat);
        this.f4710i.m5501a(InputStream.class, Bitmap.class, streamBitmapDataLoadProvider);
        FileDescriptorBitmapDataLoadProvider fileDescriptorBitmapDataLoadProvider = new FileDescriptorBitmapDataLoadProvider(bitmapPool, decodeFormat);
        this.f4710i.m5501a(ParcelFileDescriptor.class, Bitmap.class, fileDescriptorBitmapDataLoadProvider);
        ImageVideoDataLoadProvider imageVideoDataLoadProvider = new ImageVideoDataLoadProvider(streamBitmapDataLoadProvider, fileDescriptorBitmapDataLoadProvider);
        this.f4710i.m5501a(ImageVideoWrapper.class, Bitmap.class, imageVideoDataLoadProvider);
        GifDrawableLoadProvider gifDrawableLoadProvider = new GifDrawableLoadProvider(context, bitmapPool);
        this.f4710i.m5501a(InputStream.class, GifDrawable.class, gifDrawableLoadProvider);
        this.f4710i.m5501a(ImageVideoWrapper.class, GifBitmapWrapper.class, new ImageVideoGifDrawableLoadProvider(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool));
        this.f4710i.m5501a(InputStream.class, File.class, new StreamFileDataLoadProvider());
        m5261a(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.Factory());
        m5261a(File.class, InputStream.class, new StreamFileLoader.Factory());
        m5261a(Integer.TYPE, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        m5261a(Integer.TYPE, InputStream.class, new StreamResourceLoader.Factory());
        m5261a(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        m5261a(Integer.class, InputStream.class, new StreamResourceLoader.Factory());
        m5261a(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.Factory());
        m5261a(String.class, InputStream.class, new StreamStringLoader.Factory());
        m5261a(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.Factory());
        m5261a(Uri.class, InputStream.class, new StreamUriLoader.Factory());
        m5261a(URL.class, InputStream.class, new StreamUrlLoader.Factory());
        m5261a(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
        m5261a(byte[].class, InputStream.class, new StreamByteArrayLoader.Factory());
        this.f4709h.register(Bitmap.class, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool));
        this.f4709h.register(GifBitmapWrapper.class, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool)));
        this.f4711j = new CenterCrop(bitmapPool);
        this.f4712k = new GifBitmapWrapperTransformation(bitmapPool, this.f4711j);
        this.f4713l = new FitCenter(bitmapPool);
        this.f4714m = new GifBitmapWrapperTransformation(bitmapPool, this.f4713l);
    }

    /* JADX INFO: renamed from: a */
    public BitmapPool m5257a() {
        return this.f4705d;
    }

    /* JADX INFO: renamed from: a */
    <Z, R> ResourceTranscoder<Z, R> m5258a(Class<Z> cls, Class<R> cls2) {
        return this.f4709h.get(cls, cls2);
    }

    /* JADX INFO: renamed from: b */
    <T, Z> DataLoadProvider<T, Z> m5263b(Class<T> cls, Class<Z> cls2) {
        return this.f4710i.m5500a(cls, cls2);
    }

    /* JADX INFO: renamed from: a */
    <R> Target<R> m5259a(ImageView imageView, Class<R> cls) {
        return this.f4708g.m5553a(imageView, cls);
    }

    /* JADX INFO: renamed from: b */
    Engine m5262b() {
        return this.f4704c;
    }

    /* JADX INFO: renamed from: c */
    GifBitmapWrapperTransformation m5264c() {
        return this.f4712k;
    }

    /* JADX INFO: renamed from: d */
    GifBitmapWrapperTransformation m5265d() {
        return this.f4714m;
    }

    /* JADX INFO: renamed from: f */
    private GenericLoaderFactory m5256f() {
        return this.f4703b;
    }

    /* JADX INFO: renamed from: e */
    public void m5266e() {
        Util.m5592a();
        this.f4706e.clearMemory();
        this.f4705d.clearMemory();
    }

    /* JADX INFO: renamed from: a */
    public void m5260a(int i) {
        Util.m5592a();
        this.f4706e.trimMemory(i);
        this.f4705d.trimMemory(i);
    }

    /* JADX INFO: renamed from: a */
    public static void m5253a(Target<?> target) {
        Util.m5592a();
        Request request = target.getRequest();
        if (request != null) {
            request.mo5521d();
            target.setRequest(null);
        }
    }

    /* JADX INFO: renamed from: a */
    public <T, Y> void m5261a(Class<T> cls, Class<Y> cls2, ModelLoaderFactory<T, Y> modelLoaderFactory) {
        ModelLoaderFactory<T, Y> modelLoaderFactoryRegister = this.f4703b.register(cls, cls2, modelLoaderFactory);
        if (modelLoaderFactoryRegister != null) {
            modelLoaderFactoryRegister.teardown();
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T, Y> ModelLoader<T, Y> m5252a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return m5249a(context).m5256f().buildModelLoader(cls, cls2);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static <T> ModelLoader<T, InputStream> m5251a(Class<T> cls, Context context) {
        return m5252a(cls, InputStream.class, context);
    }

    /* JADX INFO: renamed from: b */
    public static <T> ModelLoader<T, ParcelFileDescriptor> m5255b(Class<T> cls, Context context) {
        return m5252a(cls, ParcelFileDescriptor.class, context);
    }

    /* JADX INFO: renamed from: b */
    public static RequestManager m5254b(Context context) {
        return RequestManagerRetriever.m5469a().m5473a(context);
    }

    /* JADX INFO: renamed from: a */
    public static RequestManager m5250a(FragmentActivity fragmentActivity) {
        return RequestManagerRetriever.m5469a().m5476a(fragmentActivity);
    }
}
