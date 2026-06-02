package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class GifBitmapWrapperResourceDecoder implements ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> {
    private static final ImageTypeParser DEFAULT_PARSER = new ImageTypeParser();
    private static final BufferedStreamFactory DEFAULT_STREAM_FACTORY = new BufferedStreamFactory();
    private final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder;
    private final BitmapPool bitmapPool;
    private final ResourceDecoder<InputStream, GifDrawable> gifDecoder;

    /* JADX INFO: renamed from: id */
    private String f4890id;
    private final ImageTypeParser parser;
    private final BufferedStreamFactory streamFactory;

    public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
    }

    GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool, ImageTypeParser imageTypeParser, BufferedStreamFactory bufferedStreamFactory) {
        this.bitmapDecoder = resourceDecoder;
        this.gifDecoder = resourceDecoder2;
        this.bitmapPool = bitmapPool;
        this.parser = imageTypeParser;
        this.streamFactory = bufferedStreamFactory;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<GifBitmapWrapper> decode(ImageVideoWrapper imageVideoWrapper, int i, int i2) throws IOException {
        ByteArrayPool byteArrayPoolM5571a = ByteArrayPool.m5571a();
        byte[] bArrM5573b = byteArrayPoolM5571a.m5573b();
        try {
            GifBitmapWrapper gifBitmapWrapperDecode = decode(imageVideoWrapper, i, i2, bArrM5573b);
            if (gifBitmapWrapperDecode != null) {
                return new GifBitmapWrapperResource(gifBitmapWrapperDecode);
            }
            return null;
        } finally {
            byteArrayPoolM5571a.m5572a(bArrM5573b);
        }
    }

    private GifBitmapWrapper decode(ImageVideoWrapper imageVideoWrapper, int i, int i2, byte[] bArr) throws IOException {
        if (imageVideoWrapper.getStream() != null) {
            return decodeStream(imageVideoWrapper, i, i2, bArr);
        }
        return decodeBitmapWrapper(imageVideoWrapper, i, i2);
    }

    private GifBitmapWrapper decodeStream(ImageVideoWrapper imageVideoWrapper, int i, int i2, byte[] bArr) throws IOException {
        InputStream inputStreamM5449a = this.streamFactory.m5449a(imageVideoWrapper.getStream(), bArr);
        inputStreamM5449a.mark(2048);
        ImageHeaderParser.ImageType imageTypeM5450a = this.parser.m5450a(inputStreamM5449a);
        inputStreamM5449a.reset();
        GifBitmapWrapper gifBitmapWrapperDecodeGifWrapper = null;
        if (imageTypeM5450a == ImageHeaderParser.ImageType.GIF) {
            gifBitmapWrapperDecodeGifWrapper = decodeGifWrapper(inputStreamM5449a, i, i2);
        }
        if (gifBitmapWrapperDecodeGifWrapper == null) {
            return decodeBitmapWrapper(new ImageVideoWrapper(inputStreamM5449a, imageVideoWrapper.getFileDescriptor()), i, i2);
        }
        return gifBitmapWrapperDecodeGifWrapper;
    }

    private GifBitmapWrapper decodeGifWrapper(InputStream inputStream, int i, int i2) throws IOException {
        Resource<GifDrawable> resourceDecode = this.gifDecoder.decode(inputStream, i, i2);
        if (resourceDecode == null) {
            return null;
        }
        GifDrawable gifDrawable = resourceDecode.get();
        if (gifDrawable.getFrameCount() > 1) {
            return new GifBitmapWrapper(null, resourceDecode);
        }
        return new GifBitmapWrapper(new BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
    }

    private GifBitmapWrapper decodeBitmapWrapper(ImageVideoWrapper imageVideoWrapper, int i, int i2) throws IOException {
        Resource<Bitmap> resourceDecode = this.bitmapDecoder.decode(imageVideoWrapper, i, i2);
        if (resourceDecode != null) {
            return new GifBitmapWrapper(resourceDecode, null);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public String getId() {
        if (this.f4890id == null) {
            this.f4890id = this.gifDecoder.getId() + this.bitmapDecoder.getId();
        }
        return this.f4890id;
    }

    static class BufferedStreamFactory {
        BufferedStreamFactory() {
        }

        /* JADX INFO: renamed from: a */
        public InputStream m5449a(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    static class ImageTypeParser {
        ImageTypeParser() {
        }

        /* JADX INFO: renamed from: a */
        public ImageHeaderParser.ImageType m5450a(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).getType();
        }
    }
}
