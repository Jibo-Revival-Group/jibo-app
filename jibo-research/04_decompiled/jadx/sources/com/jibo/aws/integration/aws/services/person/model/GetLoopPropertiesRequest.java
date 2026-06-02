package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetLoopPropertiesRequest extends JiboPersonRequest {

    @Expose
    private List<String> keys;

    @Expose
    private String loopId;

    public GetLoopPropertiesRequest(String str, List<String> list) {
        this.loopId = str;
        this.keys = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetLoopPropertiesRequest)) {
            return false;
        }
        GetLoopPropertiesRequest getLoopPropertiesRequest = (GetLoopPropertiesRequest) obj;
        if (((getLoopPropertiesRequest.getLoopId() == null) ^ (getLoopId() == null)) || getLoopPropertiesRequest.getLoopId() == null || !getLoopPropertiesRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((getLoopPropertiesRequest.getKeys() == null) ^ (getKeys() == null)) {
            return false;
        }
        return getLoopPropertiesRequest.getKeys() == null || getLoopPropertiesRequest.getKeys().equals(getKeys());
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public int hashCode() {
        return (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31) + (getKeys() != null ? getKeys().hashCode() : 0);
    }

    public String toString() {
        return getClass().getSimpleName() + " {loopId='" + this.loopId + "'keys='" + this.keys + "'}";
    }
}
