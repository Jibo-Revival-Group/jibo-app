package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetAccountPropertiesRequest extends JiboPersonRequest {

    @Expose
    private List<String> keys;

    public GetAccountPropertiesRequest(List<String> list) {
        this.keys = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAccountPropertiesRequest)) {
            return false;
        }
        GetAccountPropertiesRequest getAccountPropertiesRequest = (GetAccountPropertiesRequest) obj;
        if ((getAccountPropertiesRequest.getKeys() == null) ^ (getKeys() == null)) {
            return false;
        }
        return getAccountPropertiesRequest.getKeys() == null || getAccountPropertiesRequest.getKeys().equals(getKeys());
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return (getKeys() == null ? 0 : getKeys().hashCode()) + 31;
    }

    public String toString() {
        return getClass().getSimpleName() + " {keys='" + this.keys + "'}";
    }
}
