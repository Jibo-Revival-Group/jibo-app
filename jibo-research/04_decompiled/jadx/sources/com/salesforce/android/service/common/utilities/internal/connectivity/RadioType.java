package com.salesforce.android.service.common.utilities.internal.connectivity;

/* JADX INFO: loaded from: classes.dex */
public enum RadioType {
    RTT(7, "1xRTT", false),
    CDMA(4, "CDMA", false),
    EDGE(2, "EDGE", false),
    EHRPD(14, "EHRPD", false),
    EVDO_0(5, "EVDO_0", true),
    EVDO_A(6, "EVDO_A", true),
    EVDO_B(12, "EVDO_B", true),
    GPRS(1, "GPRS", false),
    HSDPA(8, "HSDPA", true),
    HSPA(10, "HSPA", true),
    HSPAP(15, "HSPAP", true),
    HSUPA(9, "HSUPA", true),
    IDEN(11, "IDEN", false),
    LTE(13, "LTE", true),
    UMTS(3, "UMTS", true),
    UNKNOWN(0, "UNKNOWN", false);

    private final boolean mIsFastConnection;
    private final String mRadioName;
    private final int mType;

    RadioType(int i, String str, boolean z) {
        this.mType = i;
        this.mRadioName = str;
        this.mIsFastConnection = z;
    }

    public int getType() {
        return this.mType;
    }

    public String getRadioName() {
        return this.mRadioName;
    }

    public boolean isFastConnection() {
        return this.mIsFastConnection;
    }

    static RadioType fromType(int i) {
        for (RadioType radioType : values()) {
            if (radioType.mType == i) {
                return radioType;
            }
        }
        return UNKNOWN;
    }
}
