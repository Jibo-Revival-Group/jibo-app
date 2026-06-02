package com.jibo.aws.integration.aws.services.skills.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class DeleteSettingsRequest extends JiboSkillsRequest {
    private JsonObject data;
    private String loopId;
    private String transId;

    public static class DeleteSettingData {
        public String key;
        public DeleteSettingValue value;

        public static class DeleteSettingValue {
            public String dataService;
            public String skillId;

            public DeleteSettingValue(String str, String str2) {
                this.skillId = str;
                this.dataService = str2;
            }
        }

        public DeleteSettingData(String str, DeleteSettingValue deleteSettingValue) {
            this.key = str;
            this.value = deleteSettingValue;
        }

        public DeleteSettingData(String str, String str2, String str3) {
            this.key = str;
            this.value = new DeleteSettingValue(str2, str3);
        }
    }

    public DeleteSettingsRequest(String str, DeleteSettingData deleteSettingData) {
        this.loopId = str;
        this.data = new JsonObject();
        this.transId = UUID.randomUUID().toString();
        this.data.m9402a(deleteSettingData.key, new Gson().m9343a(deleteSettingData.value));
    }

    public DeleteSettingsRequest(String str, String str2, String str3, String str4) {
        this(str, new DeleteSettingData(str2, str3, str4));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteSettingsRequest)) {
            return false;
        }
        DeleteSettingsRequest deleteSettingsRequest = (DeleteSettingsRequest) obj;
        if ((deleteSettingsRequest.getTransId() == null) ^ (getTransId() == null)) {
            return false;
        }
        if (deleteSettingsRequest.getTransId() != null && !deleteSettingsRequest.getTransId().equals(getTransId())) {
            return false;
        }
        if ((deleteSettingsRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (deleteSettingsRequest.getLoopId() != null && !deleteSettingsRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((deleteSettingsRequest.getData() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return deleteSettingsRequest.getData() == null || deleteSettingsRequest.getData().equals(getData());
    }

    public JsonObject getData() {
        return this.data;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getTransId() {
        return this.transId;
    }

    public int hashCode() {
        return (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getTransId() == null ? 0 : getTransId().hashCode()) + 31) * 31)) * 31) + (getData() != null ? getData().hashCode() : 0);
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    @Override // com.jibo.aws.integration.aws.services.skills.model.JiboSkillsRequest
    public String toString() {
        return "DeleteSettingsRequest {getTransId=" + getTransId() + ",loopId='" + this.loopId + "'}";
    }
}
