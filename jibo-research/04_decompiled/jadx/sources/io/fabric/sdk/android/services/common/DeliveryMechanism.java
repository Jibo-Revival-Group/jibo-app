package io.fabric.sdk.android.services.common;

/* JADX INFO: loaded from: classes2.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);

    public static final String BETA_APP_PACKAGE_NAME = "io.crash.air";

    /* JADX INFO: renamed from: id */
    private final int f14574id;

    DeliveryMechanism(int i) {
        this.f14574id = i;
    }

    public int getId() {
        return this.f14574id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f14574id);
    }

    public static DeliveryMechanism determineFrom(String str) {
        if (BETA_APP_PACKAGE_NAME.equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
