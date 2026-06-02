package android.support.v4.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a */
    private final ArrayList<TabInfo> f1566a;

    /* JADX INFO: renamed from: b */
    private Context f1567b;

    /* JADX INFO: renamed from: c */
    private FragmentManager f1568c;

    /* JADX INFO: renamed from: d */
    private int f1569d;

    /* JADX INFO: renamed from: e */
    private TabHost.OnTabChangeListener f1570e;

    /* JADX INFO: renamed from: f */
    private TabInfo f1571f;

    /* JADX INFO: renamed from: g */
    private boolean f1572g;

    static final class TabInfo {

        /* JADX INFO: renamed from: a */
        final String f1574a;

        /* JADX INFO: renamed from: b */
        final Class<?> f1575b;

        /* JADX INFO: renamed from: c */
        final Bundle f1576c;

        /* JADX INFO: renamed from: d */
        Fragment f1577d;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v4.app.FragmentTabHost.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        String f1573a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1573a = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f1573a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f1573a + "}";
        }
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1566a = new ArrayList<>();
        m1630a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m1630a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f1569d = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f1570e = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransactionMo1471a = null;
        int size = this.f1566a.size();
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = this.f1566a.get(i);
            tabInfo.f1577d = this.f1568c.mo1470a(tabInfo.f1574a);
            if (tabInfo.f1577d != null && !tabInfo.f1577d.isDetached()) {
                if (tabInfo.f1574a.equals(currentTabTag)) {
                    this.f1571f = tabInfo;
                } else {
                    if (fragmentTransactionMo1471a == null) {
                        fragmentTransactionMo1471a = this.f1568c.mo1471a();
                    }
                    fragmentTransactionMo1471a.mo1380b(tabInfo.f1577d);
                }
            }
        }
        this.f1572g = true;
        FragmentTransaction fragmentTransactionM1629a = m1629a(currentTabTag, fragmentTransactionMo1471a);
        if (fragmentTransactionM1629a != null) {
            fragmentTransactionM1629a.mo1385d();
            this.f1568c.mo1477b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1572g = false;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1573a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f1573a);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        FragmentTransaction fragmentTransactionM1629a;
        if (this.f1572g && (fragmentTransactionM1629a = m1629a(str, (FragmentTransaction) null)) != null) {
            fragmentTransactionM1629a.mo1385d();
        }
        if (this.f1570e != null) {
            this.f1570e.onTabChanged(str);
        }
    }

    /* JADX INFO: renamed from: a */
    private FragmentTransaction m1629a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfoM1628a = m1628a(str);
        if (this.f1571f != tabInfoM1628a) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f1568c.mo1471a();
            }
            if (this.f1571f != null && this.f1571f.f1577d != null) {
                fragmentTransaction.mo1380b(this.f1571f.f1577d);
            }
            if (tabInfoM1628a != null) {
                if (tabInfoM1628a.f1577d == null) {
                    tabInfoM1628a.f1577d = Fragment.instantiate(this.f1567b, tabInfoM1628a.f1575b.getName(), tabInfoM1628a.f1576c);
                    fragmentTransaction.mo1365a(this.f1569d, tabInfoM1628a.f1577d, tabInfoM1628a.f1574a);
                } else {
                    fragmentTransaction.mo1383c(tabInfoM1628a.f1577d);
                }
            }
            this.f1571f = tabInfoM1628a;
        }
        return fragmentTransaction;
    }

    /* JADX INFO: renamed from: a */
    private TabInfo m1628a(String str) {
        int size = this.f1566a.size();
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = this.f1566a.get(i);
            if (tabInfo.f1574a.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }
}
