package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes.dex */
public class RobotRequest extends JiboRobotPropertiesRequest {
    private Long created;
    private String guid;

    /* JADX INFO: renamed from: id */
    private String f9668id;
    private JsonObject payload;
    private Long updated;

    public RobotRequest(Robot robot) {
        this.f9668id = robot.getId();
        this.guid = robot.getGuid();
        this.payload = robot.getPayload();
        this.created = robot.getCreatedMilliseconds();
        this.updated = robot.getUpdatedMilliseconds();
    }

    public RobotRequest(String str, String str2, JsonObject jsonObject, long j, long j2) {
        this.f9668id = str;
        this.guid = str2;
        this.payload = jsonObject == null ? new JsonObject() : jsonObject;
        this.created = j == 0 ? null : Long.valueOf(j);
        this.updated = j2 != 0 ? Long.valueOf(j2) : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RobotRequest)) {
            return false;
        }
        RobotRequest robotRequest = (RobotRequest) obj;
        if ((robotRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (robotRequest.getId() != null && !robotRequest.getId().equals(getId())) {
            return false;
        }
        if ((robotRequest.getGuid() == null) ^ (getGuid() == null)) {
            return false;
        }
        if (robotRequest.getGuid() != null && !robotRequest.getGuid().equals(getGuid())) {
            return false;
        }
        if ((robotRequest.getPayload() == null) ^ (getPayload() == null)) {
            return false;
        }
        if (robotRequest.getPayload() != null && !robotRequest.getPayload().equals(getPayload())) {
            return false;
        }
        if ((robotRequest.getUpdatedMilliseconds() == null) ^ (getUpdatedMilliseconds() == null)) {
            return false;
        }
        if (robotRequest.getUpdatedMilliseconds() != null && !robotRequest.getUpdatedMilliseconds().equals(getUpdatedMilliseconds())) {
            return false;
        }
        if ((robotRequest.getCreatedMilliseconds() == null) ^ (getCreatedMilliseconds() == null)) {
            return false;
        }
        return robotRequest.getCreatedMilliseconds() == null || robotRequest.getCreatedMilliseconds().equals(getCreatedMilliseconds());
    }

    public Long getCreatedMilliseconds() {
        return this.created;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getId() {
        return this.f9668id;
    }

    public JsonObject getPayload() {
        return this.payload;
    }

    public Long getUpdatedMilliseconds() {
        return this.updated;
    }

    public int hashCode() {
        return (((getUpdatedMilliseconds() == null ? 0 : getUpdatedMilliseconds().hashCode()) + (((getPayload() == null ? 0 : getPayload().hashCode()) + (((getGuid() == null ? 0 : getGuid().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + (getCreatedMilliseconds() != null ? getCreatedMilliseconds().hashCode() : 0);
    }

    public void setCreatedMilliseconds(Long l) {
        this.created = l;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setId(String str) {
        this.f9668id = str;
    }

    public void setPayload(JsonObject jsonObject) {
        this.payload = jsonObject;
    }

    public void setUpdatedMilliseconds(Long l) {
        this.updated = l;
    }

    public String toString() {
        return "RobotRequest {id='" + this.f9668id + "'guid='" + this.guid + "', payload='" + this.payload + "', updated=" + this.updated + ", created=" + this.created + '}';
    }
}
