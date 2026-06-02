package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class GifResourceEncoder implements ResourceEncoder<GifDrawable> {
    private static final Factory FACTORY = new Factory();
    private final BitmapPool bitmapPool;
    private final Factory factory;
    private final GifDecoder.BitmapProvider provider;

    public GifResourceEncoder(BitmapPool bitmapPool) {
        this(bitmapPool, FACTORY);
    }

    GifResourceEncoder(BitmapPool bitmapPool, Factory factory) {
        this.bitmapPool = bitmapPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.factory = factory;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(Resource<GifDrawable> resource, OutputStream outputStream) {
        long jM5581a = LogTime.m5581a();
        GifDrawable gifDrawable = resource.get();
        Transformation<Bitmap> frameTransformation = gifDrawable.getFrameTransformation();
        if (frameTransformation instanceof UnitTransformation) {
            return writeDataDirect(gifDrawable.getData(), outputStream);
        }
        GifDecoder gifDecoderDecodeHeaders = decodeHeaders(gifDrawable.getData());
        AnimatedGifEncoder animatedGifEncoderM5448b = this.factory.m5448b();
        if (!animatedGifEncoderM5448b.m5395a(outputStream)) {
            return false;
        }
        for (int i = 0; i < gifDecoderDecodeHeaders.m5356c(); i++) {
            Resource<Bitmap> transformedFrame = getTransformedFrame(gifDecoderDecodeHeaders.m5359f(), frameTransformation, gifDrawable);
            try {
                if (!animatedGifEncoderM5448b.m5394a(transformedFrame.get())) {
                    return false;
                }
                animatedGifEncoderM5448b.m5391a(gifDecoderDecodeHeaders.m5352a(gifDecoderDecodeHeaders.m5357d()));
                gifDecoderDecodeHeaders.m5353a();
                transformedFrame.recycle();
            } finally {
                transformedFrame.recycle();
            }
        }
        boolean zM5393a = animatedGifEncoderM5448b.m5393a();
        if (Log.isLoggable("GifEncoder", 2)) {
            Log.v("GifEncoder", "Encoded gif with " + gifDecoderDecodeHeaders.m5356c() + " frames and " + gifDrawable.getData().length + " bytes in " + LogTime.m5580a(jM5581a) + " ms");
            return zM5393a;
        }
        return zM5393a;
    }

    private boolean writeDataDirect(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    private GifDecoder decodeHeaders(byte[] bArr) {
        GifHeaderParser gifHeaderParserM5446a = this.factory.m5446a();
        gifHeaderParserM5446a.m5377a(bArr);
        GifHeader gifHeaderM5379b = gifHeaderParserM5446a.m5379b();
        GifDecoder gifDecoderM5445a = this.factory.m5445a(this.provider);
        gifDecoderM5445a.m5354a(gifHeaderM5379b, bArr);
        gifDecoderM5445a.m5353a();
        return gifDecoderM5445a;
    }

    private Resource<Bitmap> getTransformedFrame(Bitmap bitmap, Transformation<Bitmap> transformation, GifDrawable gifDrawable) {
        Resource<Bitmap> resourceM5447a = this.factory.m5447a(bitmap, this.bitmapPool);
        Resource<Bitmap> resourceTransform = transformation.transform(resourceM5447a, gifDrawable.getIntrinsicWidth(), gifDrawable.getIntrinsicHeight());
        if (!resourceM5447a.equals(resourceTransform)) {
            resourceM5447a.recycle();
        }
        return resourceTransform;
    }

    @Override // com.bumptech.glide.load.Encoder
    public String getId() {
        return "";
    }

    static class Factory {
        Factory() {
        }

        /* JADX INFO: renamed from: a */
        public GifDecoder m5445a(GifDecoder.BitmapProvider bitmapProvider) {
            return new GifDecoder(bitmapProvider);
        }

        /* JADX INFO: renamed from: a */
        public GifHeaderParser m5446a() {
            return new GifHeaderParser();
        }

        /* JADX INFO: renamed from: b */
        public AnimatedGifEncoder m5448b() {
            return new AnimatedGifEncoder();
        }

        /* JADX INFO: renamed from: a */
        public Resource<Bitmap> m5447a(Bitmap bitmap, BitmapPool bitmapPool) {
            return new BitmapResource(bitmap, bitmapPool);
        }
    }
}
