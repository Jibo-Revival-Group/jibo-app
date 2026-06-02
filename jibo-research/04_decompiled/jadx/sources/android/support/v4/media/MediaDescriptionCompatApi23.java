package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.v4.media.MediaDescriptionCompatApi21;

/* JADX INFO: loaded from: classes.dex */
class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
    /* JADX INFO: renamed from: h */
    public static Uri m2165h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    static class Builder extends MediaDescriptionCompatApi21.Builder {
        /* JADX INFO: renamed from: b */
        public static void m2166b(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }
}
