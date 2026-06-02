package com.google.api.client.googleapis.media;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface MediaHttpDownloaderProgressListener {
    void progressChanged(MediaHttpDownloader mediaHttpDownloader) throws IOException;
}
