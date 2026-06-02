package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class UpdateNicknameRequest extends JiboLoopRequest {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9573id;

    @Expose
    private String nickname;

    public UpdateNicknameRequest(String str, String str2, String str3) {
        super(str);
        this.f9573id = str2;
        this.nickname = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateNicknameRequest)) {
            return false;
        }
        UpdateNicknameRequest updateNicknameRequest = (UpdateNicknameRequest) obj;
        if ((updateNicknameRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (updateNicknameRequest.getLoopId() != null && !updateNicknameRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((updateNicknameRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (updateNicknameRequest.getId() != null && !updateNicknameRequest.getId().equals(getId())) {
            return false;
        }
        if ((updateNicknameRequest.getNickname() == null) ^ (getNickname() == null)) {
            return false;
        }
        return updateNicknameRequest.getNickname() == null || updateNicknameRequest.getNickname().equals(getNickname());
    }

    public String getId() {
        return this.f9573id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31) + (getNickname() != null ? getNickname().hashCode() : 0);
    }

    public void setId(String str) {
        this.f9573id = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "UpdateNicknameRequest {loopId='" + this.loopId + "', id='" + this.f9573id + "', nickname='" + this.nickname + "'}";
    }
}
