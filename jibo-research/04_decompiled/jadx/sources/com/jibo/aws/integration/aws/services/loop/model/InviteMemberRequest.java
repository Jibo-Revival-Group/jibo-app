package com.jibo.aws.integration.aws.services.loop.model;

import com.jibo.aws.integration.aws.services.account.model.Account;

/* JADX INFO: loaded from: classes.dex */
public class InviteMemberRequest extends JiboLoopRequest {
    private Boolean asLegalGuardian;
    private Long birthday;
    private String email;
    private String firstName;
    private Account.Gender gender;
    private Boolean isChild;
    private String lastName;

    public InviteMemberRequest(String str, String str2, String str3, String str4, Account.Gender gender, Long l, Boolean bool, Boolean bool2) {
        super(str);
        this.email = str2;
        this.firstName = str3;
        this.lastName = str4;
        this.gender = gender;
        this.birthday = l;
        this.asLegalGuardian = bool;
        this.isChild = bool2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InviteMemberRequest)) {
            return false;
        }
        InviteMemberRequest inviteMemberRequest = (InviteMemberRequest) obj;
        if ((inviteMemberRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (inviteMemberRequest.getLoopId() != null && !inviteMemberRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((inviteMemberRequest.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        if (inviteMemberRequest.getEmail() != null && !inviteMemberRequest.getEmail().equals(getEmail())) {
            return false;
        }
        if ((inviteMemberRequest.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (inviteMemberRequest.getFirstName() != null && !inviteMemberRequest.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((inviteMemberRequest.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (inviteMemberRequest.getLastName() != null && !inviteMemberRequest.getLastName().equals(getLastName())) {
            return false;
        }
        if ((inviteMemberRequest.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (inviteMemberRequest.getGender() != null && !inviteMemberRequest.getGender().equals(getGender())) {
            return false;
        }
        if ((inviteMemberRequest.getBirthday() == null) ^ (getBirthday() == null)) {
            return false;
        }
        if (inviteMemberRequest.getBirthday() != null && !inviteMemberRequest.getBirthday().equals(getBirthday())) {
            return false;
        }
        if ((inviteMemberRequest.getAsLegalGuardian() == null) ^ (getAsLegalGuardian() == null)) {
            return false;
        }
        if (inviteMemberRequest.getAsLegalGuardian() != null && !inviteMemberRequest.getAsLegalGuardian().equals(getAsLegalGuardian())) {
            return false;
        }
        if ((inviteMemberRequest.isChild() == null) ^ (isChild() == null)) {
            return false;
        }
        return inviteMemberRequest.isChild() == null || inviteMemberRequest.isChild().equals(isChild());
    }

    public Boolean getAsLegalGuardian() {
        return this.asLegalGuardian;
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

    public String getLastName() {
        return this.lastName;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "InviteLoopMember";
    }

    public int hashCode() {
        return (((getGender() == null ? 0 : getGender().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((isChild() == null ? 0 : isChild().hashCode()) + (((getAsLegalGuardian() == null ? 0 : getAsLegalGuardian().hashCode()) + (((getEmail() == null ? 0 : getEmail().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getBirthday() != null ? getBirthday().hashCode() : 0);
    }

    public Boolean isChild() {
        return this.isChild;
    }

    public void setAsLegalGuardian(Boolean bool) {
        this.asLegalGuardian = bool;
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

    public void setLastName(String str) {
        this.lastName = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "InviteMemberRequest {loopId='" + this.loopId + "'email='" + this.email + "'firstName='" + this.firstName + "'lastName='" + this.lastName + "'gender='" + this.gender + "'isChild='" + this.isChild + "'asLegalGuardian='" + this.asLegalGuardian + "'}";
    }
}
