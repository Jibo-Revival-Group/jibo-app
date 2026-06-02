package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamEncoder implements Encoder<InputStream> {
    @Override // com.bumptech.glide.load.Encoder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean encode(InputStream inputStream, OutputStream outputStream) {
        byte[] bArrM5573b = ByteArrayPool.m5571a().m5573b();
        while (true) {
            try {
                int i = inputStream.read(bArrM5573b);
                if (i != -1) {
                    outputStream.write(bArrM5573b, 0, i);
                } else {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                return false;
            } finally {
                ByteArrayPool.m5571a().m5572a(bArrM5573b);
            }
        }
    }

    @Override // com.bumptech.glide.load.Encoder
    public String getId() {
        return "";
    }
}
