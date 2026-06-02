package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.person.model.Holiday;

/* JADX INFO: loaded from: classes.dex */
public class AccountRequest extends JiboAccountRequest {

    @SerializedName(m9428a = Holiday.CATEGORY_BIRTHDAY)
    @Expose
    private Long birthdayMilliseconds;

    @Expose
    private String email;

    @Expose
    private String firstName;

    @Expose
    private Account.Gender gender;

    @Expose
    private String invitationCode;

    @Expose
    private String lastName;
    private transient String operation;

    @Expose
    private String password;

    public AccountRequest(Account account) {
        this.email = account.getEmail();
        this.lastName = account.getLastName();
        this.firstName = account.getFirstName();
        this.gender = account.getGender();
        this.birthdayMilliseconds = account.getBirthday();
    }

    public AccountRequest(String str, String str2, String str3) {
        this.email = str;
        this.password = str2;
        this.operation = str3;
    }

    public AccountRequest(String str, String str2, String str3, String str4) {
        this.email = str;
        this.password = str2;
        this.invitationCode = str3;
        this.operation = str4;
    }

    public AccountRequest(String str, String str2, String str3, String str4, String str5, Account.Gender gender, Long l) {
        this.email = str;
        this.password = str2;
        this.firstName = str3;
        this.lastName = str4;
        this.gender = gender;
        this.birthdayMilliseconds = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountRequest)) {
            return false;
        }
        AccountRequest accountRequest = (AccountRequest) obj;
        if ((accountRequest.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        if (accountRequest.getEmail() != null && !accountRequest.getEmail().equals(getEmail())) {
            return false;
        }
        if ((accountRequest.getInvitationCode() == null) ^ (getInvitationCode() == null)) {
            return false;
        }
        if (accountRequest.getInvitationCode() != null && !accountRequest.getInvitationCode().equals(getInvitationCode())) {
            return false;
        }
        if ((accountRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        if (accountRequest.getPassword() != null && !accountRequest.getPassword().equals(getPassword())) {
            return false;
        }
        if ((accountRequest.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (accountRequest.getFirstName() != null && !accountRequest.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((accountRequest.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (accountRequest.getLastName() != null && !accountRequest.getLastName().equals(getLastName())) {
            return false;
        }
        if ((accountRequest.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (accountRequest.getGender() != null && !accountRequest.getGender().equals(getGender())) {
            return false;
        }
        if ((accountRequest.getBirthdayMilliseconds() == null) ^ (getBirthdayMilliseconds() == null)) {
            return false;
        }
        return accountRequest.getBirthdayMilliseconds() == null || accountRequest.getBirthdayMilliseconds().equals(getBirthdayMilliseconds());
    }

    public Long getBirthdayMilliseconds() {
        return this.birthdayMilliseconds;
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

    public String getInvitationCode() {
        return this.invitationCode;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getPassword() {
        return this.password;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return getOperation();
    }

    public int hashCode() {
        return (((getGender() == null ? 0 : getGender().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((getPassword() == null ? 0 : getPassword().hashCode()) + (((getInvitationCode() == null ? 0 : getInvitationCode().hashCode()) + (((getEmail() == null ? 0 : getEmail().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getBirthdayMilliseconds() != null ? getBirthdayMilliseconds().hashCode() : 0);
    }

    public void setBirthdayMilliseconds(Long l) {
        this.birthdayMilliseconds = l;
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

    public void setInvitationCode(String str) {
        this.invitationCode = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String toString() {
        return "AccountRequest {email='" + this.email + "'invitationCode='" + this.invitationCode + "', password='********', operation='" + this.operation + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', gender='" + this.gender + "', birthdayMilliseconds='" + this.birthdayMilliseconds + "'}";
    }
}
