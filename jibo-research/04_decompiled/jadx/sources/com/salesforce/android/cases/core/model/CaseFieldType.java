package com.salesforce.android.cases.core.model;

/* JADX INFO: loaded from: classes.dex */
public enum CaseFieldType {
    UNKNOWN(false),
    TEXT(true),
    EMAIL(true),
    TEXT_AREA(true),
    PICK_LIST(false);

    final boolean textField;

    CaseFieldType(boolean z) {
        this.textField = z;
    }

    public static CaseFieldType fromString(String str) {
        switch (str) {
            case "string":
                return TEXT;
            case "textarea":
                return TEXT_AREA;
            case "email":
                return EMAIL;
            case "picklist":
                return PICK_LIST;
            default:
                return UNKNOWN;
        }
    }

    public boolean isTextField() {
        return this.textField;
    }
}
