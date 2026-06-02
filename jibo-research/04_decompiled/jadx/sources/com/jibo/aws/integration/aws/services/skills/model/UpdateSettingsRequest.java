package com.jibo.aws.integration.aws.services.skills.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class UpdateSettingsRequest extends JiboSkillsRequest {
    private JsonObject data;
    private String loopId;
    private String transId;

    public static class UpdateSettingData {
        public String key;
        public UpdateSettingValue value;

        public static class UpdateSettingValue {
            public String dataService;
            public String skillId;
            public JsonElement value;

            public UpdateSettingValue(String str, String str2, JsonElement jsonElement) {
                this.skillId = str;
                this.dataService = str2;
                this.value = jsonElement;
            }
        }

        public UpdateSettingData(String str, UpdateSettingValue updateSettingValue) {
            this.key = str;
            this.value = updateSettingValue;
        }

        public UpdateSettingData(String str, String str2, String str3, JsonElement jsonElement) {
            this.key = str;
            this.value = new UpdateSettingValue(str2, str3, jsonElement);
        }
    }

    public UpdateSettingsRequest(String str, UpdateSettingData updateSettingData) {
        this.loopId = str;
        this.data = new JsonObject();
        this.transId = UUID.randomUUID().toString();
        this.data.m9402a(updateSettingData.key, new Gson().m9343a(updateSettingData.value));
    }

    public UpdateSettingsRequest(String str, String str2, String str3, String str4, JsonElement jsonElement) {
        this(str, new UpdateSettingData(str2, str3, str4, jsonElement));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateSettingsRequest)) {
            return false;
        }
        UpdateSettingsRequest updateSettingsRequest = (UpdateSettingsRequest) obj;
        if ((updateSettingsRequest.getTransId() == null) ^ (getTransId() == null)) {
            return false;
        }
        if (updateSettingsRequest.getTransId() != null && !updateSettingsRequest.getTransId().equals(getTransId())) {
            return false;
        }
        if ((updateSettingsRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (updateSettingsRequest.getLoopId() != null && !updateSettingsRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((updateSettingsRequest.getData() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return updateSettingsRequest.getData() == null || updateSettingsRequest.getData().equals(getData());
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
        return "UpdateSettingsRequest {getTransId=" + getTransId() + ",loopId='" + this.loopId + "'}";
    }
}
