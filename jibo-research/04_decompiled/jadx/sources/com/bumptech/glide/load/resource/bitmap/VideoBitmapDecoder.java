package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class VideoBitmapDecoder implements BitmapDecoder<ParcelFileDescriptor> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    private MediaMetadataRetrieverFactory factory;
    private int frame;

    public VideoBitmapDecoder() {
        this(DEFAULT_FACTORY, -1);
    }

    VideoBitmapDecoder(MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory, int i) {
        this.factory = mediaMetadataRetrieverFactory;
        this.frame = i;
    }

    public Bitmap decode(ParcelFileDescriptor parcelFileDescriptor, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever mediaMetadataRetrieverM5440a = this.factory.m5440a();
        mediaMetadataRetrieverM5440a.setDataSource(parcelFileDescriptor.getFileDescriptor());
        if (this.frame >= 0) {
            frameAtTime = mediaMetadataRetrieverM5440a.getFrameAtTime(this.frame);
        } else {
            frameAtTime = mediaMetadataRetrieverM5440a.getFrameAtTime();
        }
        mediaMetadataRetrieverM5440a.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
    public String getId() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        /* JADX INFO: renamed from: a */
        public MediaMetadataRetriever m5440a() {
            return new MediaMetadataRetriever();
        }
    }
}
