package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };

    /* JADX INFO: renamed from: a */
    private final int f2048a;

    /* JADX INFO: renamed from: b */
    private final float f2049b;

    RatingCompat(int i, float f) {
        this.f2048a = i;
        this.f2049b = f;
    }

    public String toString() {
        return "Rating:style=" + this.f2048a + " rating=" + (this.f2049b < CropImageView.DEFAULT_ASPECT_RATIO ? "unrated" : String.valueOf(this.f2049b));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f2048a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2048a);
        parcel.writeFloat(this.f2049b);
    }
}
