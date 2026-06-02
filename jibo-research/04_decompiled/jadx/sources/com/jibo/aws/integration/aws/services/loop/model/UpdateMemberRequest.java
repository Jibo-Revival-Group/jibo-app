package com.jibo.aws.integration.aws.services.loop.model;

import com.jibo.aws.integration.aws.services.account.model.Account;

/* JADX INFO: loaded from: classes.dex */
public class UpdateMemberRequest extends JiboLoopRequest {
    private Long birthday;
    private String email;
    private String firstName;
    private Account.Gender gender;

    /* JADX INFO: renamed from: id */
    private String f9572id;
    private Boolean isChild;
    private String lastName;

    public UpdateMemberRequest(String str, String str2, String str3, String str4, String str5, Account.Gender gender, Long l, Boolean bool) {
        super(str);
        this.f9572id = str2;
        this.email = str3;
        this.firstName = str4;
        this.lastName = str5;
        this.gender = gender;
        this.birthday = l;
        this.isChild = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateMemberRequest)) {
            return false;
        }
        UpdateMemberRequest updateMemberRequest = (UpdateMemberRequest) obj;
        if ((updateMemberRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (updateMemberRequest.getId() != null && !updateMemberRequest.getId().equals(getId())) {
            return false;
        }
        if ((updateMemberRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (updateMemberRequest.getLoopId() != null && !updateMemberRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((updateMemberRequest.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        if (updateMemberRequest.getEmail() != null && !updateMemberRequest.getEmail().equals(getEmail())) {
            return false;
        }
        if ((updateMemberRequest.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (updateMemberRequest.getFirstName() != null && !updateMemberRequest.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((updateMemberRequest.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (updateMemberRequest.getLastName() != null && !updateMemberRequest.getLastName().equals(getLastName())) {
            return false;
        }
        if ((updateMemberRequest.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (updateMemberRequest.getGender() != null && !updateMemberRequest.getGender().equals(getGender())) {
            return false;
        }
        if ((updateMemberRequest.getBirthday() == null) ^ (getBirthday() == null)) {
            return false;
        }
        if (updateMemberRequest.getBirthday() != null && !updateMemberRequest.getBirthday().equals(getBirthday())) {
            return false;
        }
        if ((updateMemberRequest.isChild() == null) ^ (isChild() == null)) {
            return false;
        }
        return updateMemberRequest.isChild() == null || updateMemberRequest.isChild().equals(isChild());
    }

    public Long getBirthday() {
        return this.birthday;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Account.Gender getGender() {
        return this.gender;
    }

    public String getId() {
        return this.f9572id;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "UpdateLoopMember";
    }

    public int hashCode() {
        return (((getGender() == null ? 0 : getGender().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((isChild() == null ? 0 : isChild().hashCode()) + (((getEmail() == null ? 0 : getEmail().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getBirthday() != null ? getBirthday().hashCode() : 0);
    }

    public Boolean isChild() {
        return this.isChild;
    }

    public void setBirthday(Long l) {
        this.birthday = l;
    }

    public void setChild(Boolean bool) {
        this.isChild = bool;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setGender(Account.Gender gender) {
        this.gender = gender;
    }

    public void setId(String str) {
        this.f9572id = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "UpdateMemberRequest {id='" + this.f9572id + "'loopId='" + this.loopId + "'email='" + this.email + "'firstName='" + this.firstName + "'lastName='" + this.lastName + "'gender='" + this.gender + "'isChild='" + this.isChild + "'}";
    }
}
