package com.jibo.aws.integration.aws.services.push.model;

/* JADX INFO: loaded from: classes.dex */
public enum JotPushNotificationsMode {
    always("always"),
    tagged("tagged"),
    none("none");

    private final String name;

    JotPushNotificationsMode(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
