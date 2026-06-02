package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
class MediaDescriptionCompatApi21 {
    /* JADX INFO: renamed from: a */
    public static String m2148a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    /* JADX INFO: renamed from: b */
    public static CharSequence m2150b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    /* JADX INFO: renamed from: c */
    public static CharSequence m2151c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    /* JADX INFO: renamed from: d */
    public static CharSequence m2152d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    /* JADX INFO: renamed from: e */
    public static Bitmap m2153e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    /* JADX INFO: renamed from: f */
    public static Uri m2154f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    /* JADX INFO: renamed from: g */
    public static Bundle m2155g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    /* JADX INFO: renamed from: a */
    public static void m2149a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    /* JADX INFO: renamed from: a */
    public static Object m2147a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    static class Builder {
        /* JADX INFO: renamed from: a */
        public static Object m2156a() {
            return new MediaDescription.Builder();
        }

        /* JADX INFO: renamed from: a */
        public static void m2162a(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        /* JADX INFO: renamed from: a */
        public static void m2161a(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }

        /* JADX INFO: renamed from: b */
        public static void m2163b(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        /* JADX INFO: renamed from: c */
        public static void m2164c(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        /* JADX INFO: renamed from: a */
        public static void m2158a(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        /* JADX INFO: renamed from: a */
        public static void m2159a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        /* JADX INFO: renamed from: a */
        public static void m2160a(Object obj, Bundle bundle) {
            ((MediaDescription.Builder) obj).setExtras(bundle);
        }

        /* JADX INFO: renamed from: a */
        public static Object m2157a(Object obj) {
            return ((MediaDescription.Builder) obj).build();
        }
    }
}
