package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BackStackRecord;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackStackRecord.java */
/* JADX INFO: loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: android.support.v4.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };

    /* JADX INFO: renamed from: a */
    final int[] f1428a;

    /* JADX INFO: renamed from: b */
    final int f1429b;

    /* JADX INFO: renamed from: c */
    final int f1430c;

    /* JADX INFO: renamed from: d */
    final String f1431d;

    /* JADX INFO: renamed from: e */
    final int f1432e;

    /* JADX INFO: renamed from: f */
    final int f1433f;

    /* JADX INFO: renamed from: g */
    final CharSequence f1434g;

    /* JADX INFO: renamed from: h */
    final int f1435h;

    /* JADX INFO: renamed from: i */
    final CharSequence f1436i;

    /* JADX INFO: renamed from: j */
    final ArrayList<String> f1437j;

    /* JADX INFO: renamed from: k */
    final ArrayList<String> f1438k;

    /* JADX INFO: renamed from: l */
    final boolean f1439l;

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f1402b.size();
        this.f1428a = new int[size * 6];
        if (!backStackRecord.f1409i) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            BackStackRecord.C0116Op c0116Op = backStackRecord.f1402b.get(i2);
            int i3 = i + 1;
            this.f1428a[i] = c0116Op.f1422a;
            int i4 = i3 + 1;
            this.f1428a[i3] = c0116Op.f1423b != null ? c0116Op.f1423b.mIndex : -1;
            int i5 = i4 + 1;
            this.f1428a[i4] = c0116Op.f1424c;
            int i6 = i5 + 1;
            this.f1428a[i5] = c0116Op.f1425d;
            int i7 = i6 + 1;
            this.f1428a[i6] = c0116Op.f1426e;
            i = i7 + 1;
            this.f1428a[i7] = c0116Op.f1427f;
        }
        this.f1429b = backStackRecord.f1407g;
        this.f1430c = backStackRecord.f1408h;
        this.f1431d = backStackRecord.f1411k;
        this.f1432e = backStackRecord.f1413m;
        this.f1433f = backStackRecord.f1414n;
        this.f1434g = backStackRecord.f1415o;
        this.f1435h = backStackRecord.f1416p;
        this.f1436i = backStackRecord.f1417q;
        this.f1437j = backStackRecord.f1418r;
        this.f1438k = backStackRecord.f1419s;
        this.f1439l = backStackRecord.f1420t;
    }

    public BackStackState(Parcel parcel) {
        this.f1428a = parcel.createIntArray();
        this.f1429b = parcel.readInt();
        this.f1430c = parcel.readInt();
        this.f1431d = parcel.readString();
        this.f1432e = parcel.readInt();
        this.f1433f = parcel.readInt();
        this.f1434g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1435h = parcel.readInt();
        this.f1436i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1437j = parcel.createStringArrayList();
        this.f1438k = parcel.createStringArrayList();
        this.f1439l = parcel.readInt() != 0;
    }

    /* JADX INFO: renamed from: a */
    public BackStackRecord m1393a(FragmentManagerImpl fragmentManagerImpl) {
        int i = 0;
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i2 = 0;
        while (i < this.f1428a.length) {
            BackStackRecord.C0116Op c0116Op = new BackStackRecord.C0116Op();
            int i3 = i + 1;
            c0116Op.f1422a = this.f1428a[i];
            if (FragmentManagerImpl.f1481a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.f1428a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f1428a[i3];
            if (i5 >= 0) {
                c0116Op.f1423b = fragmentManagerImpl.f1492f.get(i5);
            } else {
                c0116Op.f1423b = null;
            }
            int i6 = i4 + 1;
            c0116Op.f1424c = this.f1428a[i4];
            int i7 = i6 + 1;
            c0116Op.f1425d = this.f1428a[i6];
            int i8 = i7 + 1;
            c0116Op.f1426e = this.f1428a[i7];
            c0116Op.f1427f = this.f1428a[i8];
            backStackRecord.f1403c = c0116Op.f1424c;
            backStackRecord.f1404d = c0116Op.f1425d;
            backStackRecord.f1405e = c0116Op.f1426e;
            backStackRecord.f1406f = c0116Op.f1427f;
            backStackRecord.m1370a(c0116Op);
            i2++;
            i = i8 + 1;
        }
        backStackRecord.f1407g = this.f1429b;
        backStackRecord.f1408h = this.f1430c;
        backStackRecord.f1411k = this.f1431d;
        backStackRecord.f1413m = this.f1432e;
        backStackRecord.f1409i = true;
        backStackRecord.f1414n = this.f1433f;
        backStackRecord.f1415o = this.f1434g;
        backStackRecord.f1416p = this.f1435h;
        backStackRecord.f1417q = this.f1436i;
        backStackRecord.f1418r = this.f1437j;
        backStackRecord.f1419s = this.f1438k;
        backStackRecord.f1420t = this.f1439l;
        backStackRecord.m1369a(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1428a);
        parcel.writeInt(this.f1429b);
        parcel.writeInt(this.f1430c);
        parcel.writeString(this.f1431d);
        parcel.writeInt(this.f1432e);
        parcel.writeInt(this.f1433f);
        TextUtils.writeToParcel(this.f1434g, parcel, 0);
        parcel.writeInt(this.f1435h);
        TextUtils.writeToParcel(this.f1436i, parcel, 0);
        parcel.writeStringList(this.f1437j);
        parcel.writeStringList(this.f1438k);
        parcel.writeInt(this.f1439l ? 1 : 0);
    }
}
