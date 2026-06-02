package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ImageVideoWrapperEncoder implements Encoder<ImageVideoWrapper> {
    private final Encoder<ParcelFileDescriptor> fileDescriptorEncoder;

    /* JADX INFO: renamed from: id */
    private String f4886id;
    private final Encoder<InputStream> streamEncoder;

    public ImageVideoWrapperEncoder(Encoder<InputStream> encoder, Encoder<ParcelFileDescriptor> encoder2) {
        this.streamEncoder = encoder;
        this.fileDescriptorEncoder = encoder2;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(ImageVideoWrapper imageVideoWrapper, OutputStream outputStream) {
        return imageVideoWrapper.getStream() != null ? this.streamEncoder.encode(imageVideoWrapper.getStream(), outputStream) : this.fileDescriptorEncoder.encode(imageVideoWrapper.getFileDescriptor(), outputStream);
    }

    @Override // com.bumptech.glide.load.Encoder
    public String getId() {
        if (this.f4886id == null) {
            this.f4886id = this.streamEncoder.getId() + this.fileDescriptorEncoder.getId();
        }
        return this.f4886id;
    }
}
