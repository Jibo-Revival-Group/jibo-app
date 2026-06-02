package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileToStreamDecoder<T> implements ResourceDecoder<File, T> {
    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private final FileOpener fileOpener;
    private ResourceDecoder<InputStream, T> streamDecoder;

    public FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder) {
        this(resourceDecoder, DEFAULT_FILE_OPENER);
    }

    FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder, FileOpener fileOpener) {
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<T> decode(File file, int i, int i2) throws IOException {
        InputStream inputStreamM5442a = null;
        try {
            inputStreamM5442a = this.fileOpener.m5442a(file);
            return this.streamDecoder.decode(inputStreamM5442a, i, i2);
        } finally {
            if (inputStreamM5442a != null) {
                try {
                    inputStreamM5442a.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }

    static class FileOpener {
        FileOpener() {
        }

        /* JADX INFO: renamed from: a */
        public InputStream m5442a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }
}
