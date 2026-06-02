package android.support.v4.media.session;

import android.media.session.MediaSession;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi21 {
    /* JADX INFO: renamed from: a */
    public static Object m2288a(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    static class QueueItem {
        /* JADX INFO: renamed from: a */
        public static Object m2289a(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        /* JADX INFO: renamed from: b */
        public static long m2290b(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }
}
