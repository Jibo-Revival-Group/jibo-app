package com.jibo.aws.integration.aws.services.common.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class IdResponse implements Serializable {

    /* JADX INFO: renamed from: id */
    private String f9415id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdResponse)) {
            return false;
        }
        IdResponse idResponse = (IdResponse) obj;
        if ((idResponse.getId() == null) ^ (getId() == null)) {
            return false;
        }
        return idResponse.getId() == null || idResponse.getId().equals(getId());
    }

    public String getId() {
        return this.f9415id;
    }

    public int hashCode() {
        return (getId() == null ? 0 : getId().hashCode()) + 31;
    }

    public void setId(String str) {
        this.f9415id = str;
    }

    public String toString() {
        return "IdResponse {id='" + this.f9415id + "'}";
    }
}
