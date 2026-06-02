package io.fabric.sdk.android.services.events;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class GZIPQueueFileEventStorage extends QueueFileEventStorage {
    public GZIPQueueFileEventStorage(Context context, File file, String str, String str2) throws IOException {
        super(context, file, str, str2);
    }

    @Override // io.fabric.sdk.android.services.events.QueueFileEventStorage
    /* JADX INFO: renamed from: a */
    public OutputStream mo15336a(File file) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
