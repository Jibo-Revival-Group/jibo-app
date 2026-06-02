package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class PlaybackStateCompatApi21 {
    /* JADX INFO: renamed from: a */
    public static int m2299a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    /* JADX INFO: renamed from: b */
    public static long m2300b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    /* JADX INFO: renamed from: c */
    public static long m2301c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    /* JADX INFO: renamed from: d */
    public static float m2302d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    /* JADX INFO: renamed from: e */
    public static long m2303e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    /* JADX INFO: renamed from: f */
    public static CharSequence m2304f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    /* JADX INFO: renamed from: g */
    public static long m2305g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    /* JADX INFO: renamed from: h */
    public static List<Object> m2306h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    /* JADX INFO: renamed from: i */
    public static long m2307i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    static final class CustomAction {
        /* JADX INFO: renamed from: a */
        public static String m2308a(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        /* JADX INFO: renamed from: b */
        public static CharSequence m2309b(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        /* JADX INFO: renamed from: c */
        public static int m2310c(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        /* JADX INFO: renamed from: d */
        public static Bundle m2311d(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }
    }
}
