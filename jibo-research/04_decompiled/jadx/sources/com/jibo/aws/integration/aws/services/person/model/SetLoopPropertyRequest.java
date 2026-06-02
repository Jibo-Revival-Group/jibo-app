package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes.dex */
public class SetLoopPropertyRequest extends JiboPersonRequest {
    private String key;
    private String loopId;
    private JsonObject value;

    public SetLoopPropertyRequest(String str, String str2, JsonObject jsonObject) {
        this.loopId = str;
        this.key = str2;
        this.value = jsonObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetLoopPropertyRequest)) {
            return false;
        }
        SetLoopPropertyRequest setLoopPropertyRequest = (SetLoopPropertyRequest) obj;
        if ((setLoopPropertyRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (setLoopPropertyRequest.getLoopId() != null && !setLoopPropertyRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((setLoopPropertyRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (setLoopPropertyRequest.getKey() != null && !setLoopPropertyRequest.getKey().equals(getKey())) {
            return false;
        }
        if ((setLoopPropertyRequest.getValue() == null) ^ (getKey() == null)) {
            return false;
        }
        return setLoopPropertyRequest.getValue() == null || setLoopPropertyRequest.getValue().equals(getValue());
    }

    public String getKey() {
        return this.key;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public JsonObject getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((getKey() == null ? 0 : getKey().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31) + (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return getClass().getSimpleName() + " {key=" + this.key + ", value=" + this.value.toString() + ", loopId=" + this.loopId + "'}";
    }
}
