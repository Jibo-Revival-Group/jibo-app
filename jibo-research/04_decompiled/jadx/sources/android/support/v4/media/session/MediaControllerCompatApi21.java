package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompatApi21 {

    public interface Callback {
        /* JADX INFO: renamed from: a */
        void mo2255a();

        /* JADX INFO: renamed from: a */
        void mo2256a(int i, int i2, int i3, int i4, int i5);

        /* JADX INFO: renamed from: a */
        void mo2257a(Bundle bundle);

        /* JADX INFO: renamed from: a */
        void mo2258a(CharSequence charSequence);

        /* JADX INFO: renamed from: a */
        void mo2259a(Object obj);

        /* JADX INFO: renamed from: a */
        void mo2260a(String str, Bundle bundle);

        /* JADX INFO: renamed from: a */
        void mo2261a(List<?> list);

        /* JADX INFO: renamed from: b */
        void mo2262b(Object obj);
    }

    /* JADX INFO: renamed from: a */
    public static Object m2269a(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    /* JADX INFO: renamed from: a */
    public static Object m2270a(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2272a(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    /* JADX INFO: renamed from: a */
    public static void m2271a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    public static class PlaybackInfo {
        /* JADX INFO: renamed from: a */
        public static AudioAttributes m2274a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        /* JADX INFO: renamed from: b */
        public static int m2275b(Object obj) {
            return m2273a(m2274a(obj));
        }

        /* JADX INFO: renamed from: a */
        private static int m2273a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                default:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
            }
        }
    }

    static class CallbackProxy<T extends Callback> extends MediaController.Callback {

        /* JADX INFO: renamed from: a */
        protected final T f2077a;

        public CallbackProxy(T t) {
            this.f2077a = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f2077a.mo2255a();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            this.f2077a.mo2260a(str, bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f2077a.mo2259a(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f2077a.mo2262b(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f2077a.mo2261a(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f2077a.mo2258a(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            this.f2077a.mo2257a(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f2077a.mo2256a(playbackInfo.getPlaybackType(), PlaybackInfo.m2275b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
