package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class StatusContainer implements Serializable {

    @Expose
    private Boolean complete;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StatusContainer)) {
            return false;
        }
        StatusContainer statusContainer = (StatusContainer) obj;
        if ((statusContainer.getComplete() == null) ^ (getComplete() == null)) {
            return false;
        }
        return statusContainer.getComplete() == null || statusContainer.getComplete().equals(getComplete());
    }

    public Boolean getComplete() {
        return this.complete;
    }

    public int hashCode() {
        return (getComplete() == null ? 0 : getComplete().hashCode()) + 31;
    }

    public void setComplete(Boolean bool) {
        this.complete = bool;
    }

    public String toString() {
        return "StatusContainer {complete='" + this.complete + "'}";
    }
}
