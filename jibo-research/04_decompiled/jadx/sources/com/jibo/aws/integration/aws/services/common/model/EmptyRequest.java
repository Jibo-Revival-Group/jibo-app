package com.jibo.aws.integration.aws.services.common.model;

/* JADX INFO: loaded from: classes.dex */
public abstract class EmptyRequest extends JiboRequestAbstract {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof EmptyRequest);
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "EmptyRequest {}";
    }
}
