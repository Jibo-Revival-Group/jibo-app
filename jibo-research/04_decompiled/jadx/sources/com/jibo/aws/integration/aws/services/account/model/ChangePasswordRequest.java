package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class ChangePasswordRequest extends JiboAccountRequest {

    @Expose
    private String newPassword;

    @Expose
    private String oldPassword;

    public ChangePasswordRequest(String str, String str2) {
        this.oldPassword = str;
        this.newPassword = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangePasswordRequest)) {
            return false;
        }
        ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) obj;
        if ((changePasswordRequest.getOldPassword() == null) ^ (getOldPassword() == null)) {
            return false;
        }
        if (changePasswordRequest.getOldPassword() != null && !changePasswordRequest.getOldPassword().equals(getOldPassword())) {
            return false;
        }
        if ((changePasswordRequest.getNewPassword() == null) ^ (getNewPassword() == null)) {
            return false;
        }
        return changePasswordRequest.getNewPassword() == null || changePasswordRequest.getNewPassword().equals(getNewPassword());
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public int hashCode() {
        return (((getOldPassword() == null ? 0 : getOldPassword().hashCode()) + 31) * 31) + (getNewPassword() != null ? getNewPassword().hashCode() : 0);
    }

    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    public void setOldPassword(String str) {
        this.oldPassword = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {oldPassword='" + this.oldPassword + "', newPassword='" + this.newPassword + "'}";
    }
}
