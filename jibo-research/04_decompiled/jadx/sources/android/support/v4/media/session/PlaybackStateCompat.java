package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };

    /* JADX INFO: renamed from: a */
    final int f2089a;

    /* JADX INFO: renamed from: b */
    final long f2090b;

    /* JADX INFO: renamed from: c */
    final long f2091c;

    /* JADX INFO: renamed from: d */
    final float f2092d;

    /* JADX INFO: renamed from: e */
    final long f2093e;

    /* JADX INFO: renamed from: f */
    final int f2094f;

    /* JADX INFO: renamed from: g */
    final CharSequence f2095g;

    /* JADX INFO: renamed from: h */
    final long f2096h;

    /* JADX INFO: renamed from: i */
    List<CustomAction> f2097i;

    /* JADX INFO: renamed from: j */
    final long f2098j;

    /* JADX INFO: renamed from: k */
    final Bundle f2099k;

    /* JADX INFO: renamed from: l */
    private Object f2100l;

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f2089a = i;
        this.f2090b = j;
        this.f2091c = j2;
        this.f2092d = f;
        this.f2093e = j3;
        this.f2094f = i2;
        this.f2095g = charSequence;
        this.f2096h = j4;
        this.f2097i = new ArrayList(list);
        this.f2098j = j5;
        this.f2099k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f2089a = parcel.readInt();
        this.f2090b = parcel.readLong();
        this.f2092d = parcel.readFloat();
        this.f2096h = parcel.readLong();
        this.f2091c = parcel.readLong();
        this.f2093e = parcel.readLong();
        this.f2095g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2097i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f2098j = parcel.readLong();
        this.f2099k = parcel.readBundle();
        this.f2094f = parcel.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.f2089a);
        sb.append(", position=").append(this.f2090b);
        sb.append(", buffered position=").append(this.f2091c);
        sb.append(", speed=").append(this.f2092d);
        sb.append(", updated=").append(this.f2096h);
        sb.append(", actions=").append(this.f2093e);
        sb.append(", error code=").append(this.f2094f);
        sb.append(", error message=").append(this.f2095g);
        sb.append(", custom actions=").append(this.f2097i);
        sb.append(", active item id=").append(this.f2098j);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2089a);
        parcel.writeLong(this.f2090b);
        parcel.writeFloat(this.f2092d);
        parcel.writeLong(this.f2096h);
        parcel.writeLong(this.f2091c);
        parcel.writeLong(this.f2093e);
        TextUtils.writeToParcel(this.f2095g, parcel, i);
        parcel.writeTypedList(this.f2097i);
        parcel.writeLong(this.f2098j);
        parcel.writeBundle(this.f2099k);
        parcel.writeInt(this.f2094f);
    }

    /* JADX INFO: renamed from: a */
    public static PlaybackStateCompat m2293a(Object obj) {
        Bundle bundleM2312a;
        if (obj != null && Build.VERSION.SDK_INT >= 21) {
            List<Object> listM2306h = PlaybackStateCompatApi21.m2306h(obj);
            ArrayList arrayList = null;
            if (listM2306h != null) {
                arrayList = new ArrayList(listM2306h.size());
                Iterator<Object> it = listM2306h.iterator();
                while (it.hasNext()) {
                    arrayList.add(CustomAction.m2296a(it.next()));
                }
            }
            if (Build.VERSION.SDK_INT >= 22) {
                bundleM2312a = PlaybackStateCompatApi22.m2312a(obj);
            } else {
                bundleM2312a = null;
            }
            PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.m2299a(obj), PlaybackStateCompatApi21.m2300b(obj), PlaybackStateCompatApi21.m2301c(obj), PlaybackStateCompatApi21.m2302d(obj), PlaybackStateCompatApi21.m2303e(obj), 0, PlaybackStateCompatApi21.m2304f(obj), PlaybackStateCompatApi21.m2305g(obj), arrayList, PlaybackStateCompatApi21.m2307i(obj), bundleM2312a);
            playbackStateCompat.f2100l = obj;
            return playbackStateCompat;
        }
        return null;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* JADX INFO: renamed from: a */
        private final String f2101a;

        /* JADX INFO: renamed from: b */
        private final CharSequence f2102b;

        /* JADX INFO: renamed from: c */
        private final int f2103c;

        /* JADX INFO: renamed from: d */
        private final Bundle f2104d;

        /* JADX INFO: renamed from: e */
        private Object f2105e;

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f2101a = str;
            this.f2102b = charSequence;
            this.f2103c = i;
            this.f2104d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f2101a = parcel.readString();
            this.f2102b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2103c = parcel.readInt();
            this.f2104d = parcel.readBundle();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2101a);
            TextUtils.writeToParcel(this.f2102b, parcel, i);
            parcel.writeInt(this.f2103c);
            parcel.writeBundle(this.f2104d);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public static CustomAction m2296a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.m2308a(obj), PlaybackStateCompatApi21.CustomAction.m2309b(obj), PlaybackStateCompatApi21.CustomAction.m2310c(obj), PlaybackStateCompatApi21.CustomAction.m2311d(obj));
            customAction.f2105e = obj;
            return customAction;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f2102b) + ", mIcon=" + this.f2103c + ", mExtras=" + this.f2104d;
        }
    }
}
