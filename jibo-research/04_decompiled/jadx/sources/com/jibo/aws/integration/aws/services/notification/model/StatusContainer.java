package com.jibo.aws.integration.aws.services.notification.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class StatusContainer implements Serializable {

    @Expose
    private Boolean connected;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StatusContainer)) {
            return false;
        }
        StatusContainer statusContainer = (StatusContainer) obj;
        if ((statusContainer.getConnected() == null) ^ (getConnected() == null)) {
            return false;
        }
        return statusContainer.getConnected() == null || statusContainer.getConnected().equals(getConnected());
    }

    public Boolean getConnected() {
        return this.connected;
    }

    public int hashCode() {
        return (getConnected() == null ? 0 : getConnected().hashCode()) + 31;
    }

    public void setConnected(Boolean bool) {
        this.connected = bool;
    }

    public String toString() {
        return "StatusContainer {connected='" + this.connected + "'}";
    }
}
