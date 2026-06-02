package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes.dex */
public class SetAccountPropertyRequest extends JiboPersonRequest {
    private String key;
    private JsonObject value;

    public SetAccountPropertyRequest(String str, JsonObject jsonObject) {
        this.key = str;
        this.value = jsonObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetAccountPropertyRequest)) {
            return false;
        }
        SetAccountPropertyRequest setAccountPropertyRequest = (SetAccountPropertyRequest) obj;
        if ((setAccountPropertyRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (setAccountPropertyRequest.getKey() != null && !setAccountPropertyRequest.getKey().equals(getKey())) {
            return false;
        }
        if ((setAccountPropertyRequest.getValue() == null) ^ (getKey() == null)) {
            return false;
        }
        return setAccountPropertyRequest.getValue() == null || setAccountPropertyRequest.getValue().equals(getValue());
    }

    public String getKey() {
        return this.key;
    }

    public JsonObject getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((getKey() == null ? 0 : getKey().hashCode()) + 31) * 31) + (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return getClass().getSimpleName() + " {key=" + this.key + ", value=" + this.value.toString() + "'}";
    }
}
