package android.support.v4.app;

import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: android.support.v4.app.FragmentState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };

    /* JADX INFO: renamed from: a */
    final String f1554a;

    /* JADX INFO: renamed from: b */
    final int f1555b;

    /* JADX INFO: renamed from: c */
    final boolean f1556c;

    /* JADX INFO: renamed from: d */
    final int f1557d;

    /* JADX INFO: renamed from: e */
    final int f1558e;

    /* JADX INFO: renamed from: f */
    final String f1559f;

    /* JADX INFO: renamed from: g */
    final boolean f1560g;

    /* JADX INFO: renamed from: h */
    final boolean f1561h;

    /* JADX INFO: renamed from: i */
    final Bundle f1562i;

    /* JADX INFO: renamed from: j */
    final boolean f1563j;

    /* JADX INFO: renamed from: k */
    Bundle f1564k;

    /* JADX INFO: renamed from: l */
    Fragment f1565l;

    FragmentState(Fragment fragment) {
        this.f1554a = fragment.getClass().getName();
        this.f1555b = fragment.mIndex;
        this.f1556c = fragment.mFromLayout;
        this.f1557d = fragment.mFragmentId;
        this.f1558e = fragment.mContainerId;
        this.f1559f = fragment.mTag;
        this.f1560g = fragment.mRetainInstance;
        this.f1561h = fragment.mDetached;
        this.f1562i = fragment.mArguments;
        this.f1563j = fragment.mHidden;
    }

    FragmentState(Parcel parcel) {
        this.f1554a = parcel.readString();
        this.f1555b = parcel.readInt();
        this.f1556c = parcel.readInt() != 0;
        this.f1557d = parcel.readInt();
        this.f1558e = parcel.readInt();
        this.f1559f = parcel.readString();
        this.f1560g = parcel.readInt() != 0;
        this.f1561h = parcel.readInt() != 0;
        this.f1562i = parcel.readBundle();
        this.f1563j = parcel.readInt() != 0;
        this.f1564k = parcel.readBundle();
    }

    /* JADX INFO: renamed from: a */
    public Fragment m1625a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment, FragmentManagerNonConfig fragmentManagerNonConfig, ViewModelStore viewModelStore) {
        if (this.f1565l == null) {
            Context contextM1464i = fragmentHostCallback.m1464i();
            if (this.f1562i != null) {
                this.f1562i.setClassLoader(contextM1464i.getClassLoader());
            }
            if (fragmentContainer != null) {
                this.f1565l = fragmentContainer.mo1400a(contextM1464i, this.f1554a, this.f1562i);
            } else {
                this.f1565l = Fragment.instantiate(contextM1464i, this.f1554a, this.f1562i);
            }
            if (this.f1564k != null) {
                this.f1564k.setClassLoader(contextM1464i.getClassLoader());
                this.f1565l.mSavedFragmentState = this.f1564k;
            }
            this.f1565l.setIndex(this.f1555b, fragment);
            this.f1565l.mFromLayout = this.f1556c;
            this.f1565l.mRestored = true;
            this.f1565l.mFragmentId = this.f1557d;
            this.f1565l.mContainerId = this.f1558e;
            this.f1565l.mTag = this.f1559f;
            this.f1565l.mRetainInstance = this.f1560g;
            this.f1565l.mDetached = this.f1561h;
            this.f1565l.mHidden = this.f1563j;
            this.f1565l.mFragmentManager = fragmentHostCallback.f1475d;
            if (FragmentManagerImpl.f1481a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f1565l);
            }
        }
        this.f1565l.mChildNonConfig = fragmentManagerNonConfig;
        this.f1565l.mViewModelStore = viewModelStore;
        return this.f1565l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1554a);
        parcel.writeInt(this.f1555b);
        parcel.writeInt(this.f1556c ? 1 : 0);
        parcel.writeInt(this.f1557d);
        parcel.writeInt(this.f1558e);
        parcel.writeString(this.f1559f);
        parcel.writeInt(this.f1560g ? 1 : 0);
        parcel.writeInt(this.f1561h ? 1 : 0);
        parcel.writeBundle(this.f1562i);
        parcel.writeInt(this.f1563j ? 1 : 0);
        parcel.writeBundle(this.f1564k);
    }
}
