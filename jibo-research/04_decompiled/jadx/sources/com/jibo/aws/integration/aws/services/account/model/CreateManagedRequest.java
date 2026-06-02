package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.account.model.Account;

/* JADX INFO: loaded from: classes.dex */
public class CreateManagedRequest extends JiboAccountRequest {

    @Expose
    private Long birthday;

    @Expose
    private String firstName;

    @Expose
    private Account.Gender gender;

    @Expose
    private Boolean isChild;

    @Expose
    private String lastName;

    @Expose
    private String loopId;

    @Expose
    private String nickName;

    public CreateManagedRequest(String str, String str2, String str3, String str4, Account.Gender gender, Long l, Boolean bool) {
        this.loopId = str;
        this.firstName = str2;
        this.lastName = str3;
        this.nickName = str4;
        this.gender = gender;
        this.birthday = l;
        this.isChild = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateManagedRequest)) {
            return false;
        }
        CreateManagedRequest createManagedRequest = (CreateManagedRequest) obj;
        if ((createManagedRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (createManagedRequest.getLoopId() != null && !createManagedRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((createManagedRequest.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (createManagedRequest.getFirstName() != null && !createManagedRequest.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((createManagedRequest.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (createManagedRequest.getLastName() != null && !createManagedRequest.getLastName().equals(getLastName())) {
            return false;
        }
        if ((createManagedRequest.getNickName() == null) ^ (getNickName() == null)) {
            return false;
        }
        if (createManagedRequest.getNickName() != null && !createManagedRequest.getNickName().equals(getNickName())) {
            return false;
        }
        if ((createManagedRequest.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (createManagedRequest.getGender() != null && !createManagedRequest.getGender().equals(getGender())) {
            return false;
        }
        if ((createManagedRequest.getBirthday() == null) ^ (getBirthday() == null)) {
            return false;
        }
        if (createManagedRequest.getBirthday() != null && !createManagedRequest.getBirthday().equals(getBirthday())) {
            return false;
        }
        if ((createManagedRequest.getIsChild() == null) ^ (getIsChild() == null)) {
            return false;
        }
        return createManagedRequest.getIsChild() == null || createManagedRequest.getIsChild().equals(getIsChild());
    }

    public Long getBirthday() {
        return this.birthday;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Account.Gender getGender() {
        return this.gender;
    }

    public Boolean getIsChild() {
        return this.isChild;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int hashCode() {
        return (((getBirthday() == null ? 0 : getBirthday().hashCode()) + (((getGender() == null ? 0 : getGender().hashCode()) + (((getNickName() == null ? 0 : getNickName().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getIsChild() != null ? getIsChild().hashCode() : 0);
    }

    public void setBirthday(Long l) {
        this.birthday = l;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setGender(Account.Gender gender) {
        this.gender = gender;
    }

    public void setIsChild(Boolean bool) {
        this.isChild = bool;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String toString() {
        return "CreateManagedRequest {loopId='" + this.loopId + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', nickName='" + this.nickName + "', gender='" + this.gender + "', birthday='" + this.birthday + "', isChild='" + this.isChild + "'}";
    }
}
