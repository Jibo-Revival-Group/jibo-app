package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.account.model.Account;

/* JADX INFO: loaded from: classes.dex */
public class UpdateRequest extends JiboAccountRequest {
    private Long birthday;
    private String email;
    private String firstName;
    private Account.Gender gender;

    /* JADX INFO: renamed from: id */
    private String f9373id;
    private String lastName;
    private Boolean messagingAllowed;
    private String password;
    private String phoneNumber;

    public UpdateRequest(Account account) {
        this.f9373id = account.getId();
        this.email = account.getEmail();
        this.lastName = account.getLastName();
        this.firstName = account.getFirstName();
        this.gender = account.getGender();
        this.birthday = account.getBirthday();
        this.phoneNumber = account.getPhoneNumber();
        this.messagingAllowed = account.isMessagingAllowed();
    }

    public UpdateRequest(String str) {
        this.f9373id = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateRequest)) {
            return false;
        }
        UpdateRequest updateRequest = (UpdateRequest) obj;
        if ((updateRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (updateRequest.getId() != null && !updateRequest.getId().equals(getId())) {
            return false;
        }
        if ((updateRequest.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        if (updateRequest.getEmail() != null && !updateRequest.getEmail().equals(getEmail())) {
            return false;
        }
        if ((updateRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        if (updateRequest.getPassword() != null && !updateRequest.getPassword().equals(getPassword())) {
            return false;
        }
        if ((updateRequest.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (updateRequest.getLastName() != null && !updateRequest.getLastName().equals(getLastName())) {
            return false;
        }
        if ((updateRequest.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (updateRequest.getFirstName() != null && !updateRequest.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((updateRequest.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (updateRequest.getGender() != null && !updateRequest.getGender().equals(getGender())) {
            return false;
        }
        if ((updateRequest.getPhoneNumber() == null) ^ (getPhoneNumber() == null)) {
            return false;
        }
        if (updateRequest.getPhoneNumber() != null && !updateRequest.getPhoneNumber().equals(getPhoneNumber())) {
            return false;
        }
        if ((updateRequest.isMessagingAllowed() == null) ^ (isMessagingAllowed() == null)) {
            return false;
        }
        if (updateRequest.isMessagingAllowed() != null && !updateRequest.isMessagingAllowed().equals(isMessagingAllowed())) {
            return false;
        }
        if ((updateRequest.getBirthday() == null) ^ (getBirthday() == null)) {
            return false;
        }
        return updateRequest.getBirthday() == null || updateRequest.getBirthday().equals(getBirthday());
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
        return this.f9373id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        return (((getPhoneNumber() == null ? 0 : getPhoneNumber().hashCode()) + (((((getGender() == null ? 0 : getGender().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getPassword() == null ? 0 : getPassword().hashCode()) + (((getEmail() == null ? 0 : getEmail().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + getBirthday().hashCode()) * 31)) * 31) + (isMessagingAllowed() != null ? isMessagingAllowed().hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.email == null && this.password == null && this.lastName == null && this.firstName == null && this.gender == null && this.birthday == null && this.phoneNumber == null && this.messagingAllowed == null;
    }

    public Boolean isMessagingAllowed() {
        return this.messagingAllowed;
    }

    public void setBirthday(Long l) {
        this.birthday = l;
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
        this.f9373id = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setMessagingAllowed(Boolean bool) {
        this.messagingAllowed = bool;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String toString() {
        return "UpdateRequest {id='" + this.f9373id + "', email='" + this.email + "', password='********', lastName='" + this.lastName + "', firstName='" + this.firstName + "', birthday='" + this.birthday + "', phoneNumber='" + this.phoneNumber + "', messagingAllowed='" + this.messagingAllowed + "'}";
    }
}
