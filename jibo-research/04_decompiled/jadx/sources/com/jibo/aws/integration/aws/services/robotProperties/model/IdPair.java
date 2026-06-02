package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class IdPair implements Serializable {

    @Expose
    private String guid;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9666id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdPair)) {
            return false;
        }
        IdPair idPair = (IdPair) obj;
        if ((idPair.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (idPair.getId() != null && !idPair.getId().equals(getId())) {
            return false;
        }
        if ((idPair.getGuid() == null) ^ (getGuid() == null)) {
            return false;
        }
        return idPair.getGuid() == null || idPair.getGuid().equals(getGuid());
    }

    public String getGuid() {
        return this.guid;
    }

    public String getId() {
        return this.f9666id;
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getGuid() != null ? getGuid().hashCode() : 0);
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setId(String str) {
        this.f9666id = str;
    }

    public String toString() {
        return "CommandResponse {id='" + this.f9666id + "'guid='" + this.guid + "'}";
    }
}
