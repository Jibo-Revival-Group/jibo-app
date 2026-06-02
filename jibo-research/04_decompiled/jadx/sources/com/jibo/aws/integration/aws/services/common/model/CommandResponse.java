package com.jibo.aws.integration.aws.services.common.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CommandResponse implements Serializable {
    private String result;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CommandResponse)) {
            return false;
        }
        CommandResponse commandResponse = (CommandResponse) obj;
        if ((commandResponse.getResult() == null) ^ (getResult() == null)) {
            return false;
        }
        return commandResponse.getResult() == null || commandResponse.getResult().equals(getResult());
    }

    public String getResult() {
        return this.result;
    }

    public int hashCode() {
        return (getResult() == null ? 0 : getResult().hashCode()) + 31;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public String toString() {
        return "CommandResponse {result='" + this.result + "'}";
    }
}
