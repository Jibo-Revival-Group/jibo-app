package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.m2133a(MediaDescriptionCompatApi21.m2147a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* JADX INFO: renamed from: a */
    private final String f2025a;

    /* JADX INFO: renamed from: b */
    private final CharSequence f2026b;

    /* JADX INFO: renamed from: c */
    private final CharSequence f2027c;

    /* JADX INFO: renamed from: d */
    private final CharSequence f2028d;

    /* JADX INFO: renamed from: e */
    private final Bitmap f2029e;

    /* JADX INFO: renamed from: f */
    private final Uri f2030f;

    /* JADX INFO: renamed from: g */
    private final Bundle f2031g;

    /* JADX INFO: renamed from: h */
    private final Uri f2032h;

    /* JADX INFO: renamed from: i */
    private Object f2033i;

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f2025a = str;
        this.f2026b = charSequence;
        this.f2027c = charSequence2;
        this.f2028d = charSequence3;
        this.f2029e = bitmap;
        this.f2030f = uri;
        this.f2031g = bundle;
        this.f2032h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f2025a = parcel.readString();
        this.f2026b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2027c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2028d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2029e = (Bitmap) parcel.readParcelable(null);
        this.f2030f = (Uri) parcel.readParcelable(null);
        this.f2031g = parcel.readBundle();
        this.f2032h = (Uri) parcel.readParcelable(null);
    }

    /* JADX INFO: renamed from: a */
    public String m2134a() {
        return this.f2025a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f2025a);
            TextUtils.writeToParcel(this.f2026b, parcel, i);
            TextUtils.writeToParcel(this.f2027c, parcel, i);
            TextUtils.writeToParcel(this.f2028d, parcel, i);
            parcel.writeParcelable(this.f2029e, i);
            parcel.writeParcelable(this.f2030f, i);
            parcel.writeBundle(this.f2031g);
            parcel.writeParcelable(this.f2032h, i);
            return;
        }
        MediaDescriptionCompatApi21.m2149a(m2135b(), parcel, i);
    }

    public String toString() {
        return ((Object) this.f2026b) + ", " + ((Object) this.f2027c) + ", " + ((Object) this.f2028d);
    }

    /* JADX INFO: renamed from: b */
    public Object m2135b() {
        if (this.f2033i != null || Build.VERSION.SDK_INT < 21) {
            return this.f2033i;
        }
        Object objM2156a = MediaDescriptionCompatApi21.Builder.m2156a();
        MediaDescriptionCompatApi21.Builder.m2162a(objM2156a, this.f2025a);
        MediaDescriptionCompatApi21.Builder.m2161a(objM2156a, this.f2026b);
        MediaDescriptionCompatApi21.Builder.m2163b(objM2156a, this.f2027c);
        MediaDescriptionCompatApi21.Builder.m2164c(objM2156a, this.f2028d);
        MediaDescriptionCompatApi21.Builder.m2158a(objM2156a, this.f2029e);
        MediaDescriptionCompatApi21.Builder.m2159a(objM2156a, this.f2030f);
        Bundle bundle = this.f2031g;
        if (Build.VERSION.SDK_INT < 23 && this.f2032h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f2032h);
        }
        MediaDescriptionCompatApi21.Builder.m2160a(objM2156a, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.m2166b(objM2156a, this.f2032h);
        }
        this.f2033i = MediaDescriptionCompatApi21.Builder.m2157a(objM2156a);
        return this.f2033i;
    }

    /* JADX INFO: renamed from: a */
    public static MediaDescriptionCompat m2133a(Object obj) {
        Bundle bundle;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        builder.m2142a(MediaDescriptionCompatApi21.m2148a(obj));
        builder.m2141a(MediaDescriptionCompatApi21.m2150b(obj));
        builder.m2145b(MediaDescriptionCompatApi21.m2151c(obj));
        builder.m2146c(MediaDescriptionCompatApi21.m2152d(obj));
        builder.m2138a(MediaDescriptionCompatApi21.m2153e(obj));
        builder.m2139a(MediaDescriptionCompatApi21.m2154f(obj));
        Bundle bundleM2155g = MediaDescriptionCompatApi21.m2155g(obj);
        Uri uri = bundleM2155g == null ? null : (Uri) bundleM2155g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        if (uri == null) {
            bundle = bundleM2155g;
        } else if (bundleM2155g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleM2155g.size() == 2) {
            bundle = null;
        } else {
            bundleM2155g.remove("android.support.v4.media.description.MEDIA_URI");
            bundleM2155g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleM2155g;
        }
        builder.m2140a(bundle);
        if (uri != null) {
            builder.m2144b(uri);
        } else if (Build.VERSION.SDK_INT >= 23) {
            builder.m2144b(MediaDescriptionCompatApi23.m2165h(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatM2143a = builder.m2143a();
        mediaDescriptionCompatM2143a.f2033i = obj;
        return mediaDescriptionCompatM2143a;
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private String f2034a;

        /* JADX INFO: renamed from: b */
        private CharSequence f2035b;

        /* JADX INFO: renamed from: c */
        private CharSequence f2036c;

        /* JADX INFO: renamed from: d */
        private CharSequence f2037d;

        /* JADX INFO: renamed from: e */
        private Bitmap f2038e;

        /* JADX INFO: renamed from: f */
        private Uri f2039f;

        /* JADX INFO: renamed from: g */
        private Bundle f2040g;

        /* JADX INFO: renamed from: h */
        private Uri f2041h;

        /* JADX INFO: renamed from: a */
        public Builder m2142a(String str) {
            this.f2034a = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m2141a(CharSequence charSequence) {
            this.f2035b = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m2145b(CharSequence charSequence) {
            this.f2036c = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Builder m2146c(CharSequence charSequence) {
            this.f2037d = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m2138a(Bitmap bitmap) {
            this.f2038e = bitmap;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m2139a(Uri uri) {
            this.f2039f = uri;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m2140a(Bundle bundle) {
            this.f2040g = bundle;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m2144b(Uri uri) {
            this.f2041h = uri;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public MediaDescriptionCompat m2143a() {
            return new MediaDescriptionCompat(this.f2034a, this.f2035b, this.f2036c, this.f2037d, this.f2038e, this.f2039f, this.f2040g, this.f2041h);
        }
    }
}
