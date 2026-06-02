package android.support.v4.media;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* JADX INFO: renamed from: a */
    static final ArrayMap<String, Integer> f2042a = new ArrayMap<>();

    /* JADX INFO: renamed from: c */
    private static final String[] f2043c;

    /* JADX INFO: renamed from: d */
    private static final String[] f2044d;

    /* JADX INFO: renamed from: e */
    private static final String[] f2045e;

    /* JADX INFO: renamed from: b */
    final Bundle f2046b;

    /* JADX INFO: renamed from: f */
    private Object f2047f;

    static {
        f2042a.put("android.media.metadata.TITLE", 1);
        f2042a.put("android.media.metadata.ARTIST", 1);
        f2042a.put("android.media.metadata.DURATION", 0);
        f2042a.put("android.media.metadata.ALBUM", 1);
        f2042a.put("android.media.metadata.AUTHOR", 1);
        f2042a.put("android.media.metadata.WRITER", 1);
        f2042a.put("android.media.metadata.COMPOSER", 1);
        f2042a.put("android.media.metadata.COMPILATION", 1);
        f2042a.put("android.media.metadata.DATE", 1);
        f2042a.put("android.media.metadata.YEAR", 0);
        f2042a.put("android.media.metadata.GENRE", 1);
        f2042a.put("android.media.metadata.TRACK_NUMBER", 0);
        f2042a.put("android.media.metadata.NUM_TRACKS", 0);
        f2042a.put("android.media.metadata.DISC_NUMBER", 0);
        f2042a.put("android.media.metadata.ALBUM_ARTIST", 1);
        f2042a.put("android.media.metadata.ART", 2);
        f2042a.put("android.media.metadata.ART_URI", 1);
        f2042a.put("android.media.metadata.ALBUM_ART", 2);
        f2042a.put("android.media.metadata.ALBUM_ART_URI", 1);
        f2042a.put("android.media.metadata.USER_RATING", 3);
        f2042a.put("android.media.metadata.RATING", 3);
        f2042a.put("android.media.metadata.DISPLAY_TITLE", 1);
        f2042a.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        f2042a.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        f2042a.put("android.media.metadata.DISPLAY_ICON", 2);
        f2042a.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        f2042a.put("android.media.metadata.MEDIA_ID", 1);
        f2042a.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        f2042a.put("android.media.metadata.MEDIA_URI", 1);
        f2042a.put("android.media.metadata.ADVERTISEMENT", 0);
        f2042a.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        f2043c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        f2044d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        f2045e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new Parcelable.Creator<MediaMetadataCompat>() { // from class: android.support.v4.media.MediaMetadataCompat.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaMetadataCompat createFromParcel(Parcel parcel) {
                return new MediaMetadataCompat(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaMetadataCompat[] newArray(int i) {
                return new MediaMetadataCompat[i];
            }
        };
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f2046b = parcel.readBundle();
        this.f2046b.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2046b);
    }

    /* JADX INFO: renamed from: a */
    public static MediaMetadataCompat m2167a(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        MediaMetadataCompatApi21.m2170a(obj, parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        mediaMetadataCompatCreateFromParcel.f2047f = obj;
        return mediaMetadataCompatCreateFromParcel;
    }
}
