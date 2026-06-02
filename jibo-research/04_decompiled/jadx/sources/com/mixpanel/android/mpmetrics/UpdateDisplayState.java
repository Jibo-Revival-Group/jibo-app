package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class UpdateDisplayState implements Parcelable {
    public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new Parcelable.Creator<UpdateDisplayState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UpdateDisplayState createFromParcel(Parcel parcel) {
            Bundle bundle = new Bundle(UpdateDisplayState.class.getClassLoader());
            bundle.readFromParcel(parcel);
            return new UpdateDisplayState(bundle);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UpdateDisplayState[] newArray(int i) {
            return new UpdateDisplayState[i];
        }
    };

    /* JADX INFO: renamed from: d */
    private static final ReentrantLock f12043d = new ReentrantLock();

    /* JADX INFO: renamed from: e */
    private static long f12044e = -1;

    /* JADX INFO: renamed from: f */
    private static UpdateDisplayState f12045f = null;

    /* JADX INFO: renamed from: g */
    private static int f12046g = 0;

    /* JADX INFO: renamed from: h */
    private static int f12047h = -1;

    /* JADX INFO: renamed from: a */
    private final String f12048a;

    /* JADX INFO: renamed from: b */
    private final String f12049b;

    /* JADX INFO: renamed from: c */
    private final DisplayState f12050c;

    public static abstract class DisplayState implements Parcelable {
        public static final Parcelable.Creator<DisplayState> CREATOR = new Parcelable.Creator<DisplayState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DisplayState createFromParcel(Parcel parcel) {
                Bundle bundle = new Bundle(DisplayState.class.getClassLoader());
                bundle.readFromParcel(parcel);
                String string = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
                Bundle bundle2 = bundle.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
                if ("InAppNotificationState".equals(string)) {
                    return new InAppNotificationState(bundle2);
                }
                throw new RuntimeException("Unrecognized display state type " + string);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DisplayState[] newArray(int i) {
                return new DisplayState[i];
            }
        };

        private DisplayState() {
        }

        public static final class InAppNotificationState extends DisplayState {
            public static final Parcelable.Creator<InAppNotificationState> CREATOR = new Parcelable.Creator<InAppNotificationState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public InAppNotificationState createFromParcel(Parcel parcel) {
                    Bundle bundle = new Bundle(InAppNotificationState.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new InAppNotificationState(bundle);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public InAppNotificationState[] newArray(int i) {
                    return new InAppNotificationState[i];
                }
            };

            /* JADX INFO: renamed from: c */
            private static String f12052c = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";

            /* JADX INFO: renamed from: d */
            private static String f12053d = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";

            /* JADX INFO: renamed from: a */
            private final InAppNotification f12054a;

            /* JADX INFO: renamed from: b */
            private final int f12055b;

            public InAppNotificationState(InAppNotification inAppNotification, int i) {
                super();
                this.f12054a = inAppNotification;
                this.f12055b = i;
            }

            /* JADX INFO: renamed from: a */
            public InAppNotification m11985a() {
                return this.f12054a;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(f12052c, this.f12054a);
                bundle.putInt(f12053d, this.f12055b);
                parcel.writeBundle(bundle);
            }

            private InAppNotificationState(Bundle bundle) {
                super();
                this.f12054a = (InAppNotification) bundle.getParcelable(f12052c);
                this.f12055b = bundle.getInt(f12053d);
            }
        }
    }

    public static class AnswerMap implements Parcelable {
        public static final Parcelable.Creator<AnswerMap> CREATOR = new Parcelable.Creator<AnswerMap>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnswerMap createFromParcel(Parcel parcel) {
                Bundle bundle = new Bundle(AnswerMap.class.getClassLoader());
                AnswerMap answerMap = new AnswerMap();
                bundle.readFromParcel(parcel);
                for (String str : bundle.keySet()) {
                    answerMap.m11980a(Integer.valueOf(str), bundle.getString(str));
                }
                return answerMap;
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnswerMap[] newArray(int i) {
                return new AnswerMap[i];
            }
        };

        /* JADX INFO: renamed from: a */
        private final HashMap<Integer, String> f12051a = new HashMap<>();

        @SuppressLint({"UseSparseArrays"})
        public AnswerMap() {
        }

        /* JADX INFO: renamed from: a */
        public void m11980a(Integer num, String str) {
            this.f12051a.put(num, str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Bundle bundle = new Bundle();
            for (Map.Entry<Integer, String> entry : this.f12051a.entrySet()) {
                bundle.putString(Integer.toString(entry.getKey().intValue()), entry.getValue());
            }
            parcel.writeBundle(bundle);
        }
    }

    /* JADX INFO: renamed from: a */
    static ReentrantLock m11972a() {
        return f12043d;
    }

    /* JADX INFO: renamed from: b */
    static boolean m11975b() {
        if (!f12043d.isHeldByCurrentThread()) {
            throw new AssertionError();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - f12044e;
        if (f12046g > 0 && jCurrentTimeMillis > 43200000) {
            MPLog.m12026c("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
            f12045f = null;
        }
        return f12045f != null;
    }

    /* JADX INFO: renamed from: a */
    static int m11971a(DisplayState displayState, String str, String str2) {
        if (!f12043d.isHeldByCurrentThread()) {
            throw new AssertionError();
        }
        if (!m11975b()) {
            f12044e = System.currentTimeMillis();
            f12045f = new UpdateDisplayState(displayState, str, str2);
            f12046g++;
            return f12046g;
        }
        MPLog.m12021a("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static void m11973a(int i) {
        f12043d.lock();
        try {
            if (i == f12047h) {
                f12047h = -1;
                f12045f = null;
            }
        } finally {
            f12043d.unlock();
        }
    }

    /* JADX INFO: renamed from: b */
    public static UpdateDisplayState m11974b(int i) {
        UpdateDisplayState updateDisplayState = null;
        f12043d.lock();
        try {
            if (f12047h <= 0 || f12047h == i) {
                if (f12045f != null) {
                    f12044e = System.currentTimeMillis();
                    f12047h = i;
                    updateDisplayState = f12045f;
                }
            }
            return updateDisplayState;
        } finally {
            f12043d.unlock();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.f12048a);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.f12049b);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.f12050c);
        parcel.writeBundle(bundle);
    }

    /* JADX INFO: renamed from: c */
    public DisplayState m11976c() {
        return this.f12050c;
    }

    /* JADX INFO: renamed from: d */
    public String m11977d() {
        return this.f12049b;
    }

    UpdateDisplayState(DisplayState displayState, String str, String str2) {
        this.f12048a = str;
        this.f12049b = str2;
        this.f12050c = displayState;
    }

    private UpdateDisplayState(Bundle bundle) {
        this.f12048a = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.f12049b = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.f12050c = (DisplayState) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }
}
