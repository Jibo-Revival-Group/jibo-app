package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class ChangeEmailRequest extends JiboAccountRequest {

    @Expose
    private String email;

    @Expose
    private String password;

    public ChangeEmailRequest(String str, String str2) {
        this.email = str;
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangeEmailRequest)) {
            return false;
        }
        ChangeEmailRequest changeEmailRequest = (ChangeEmailRequest) obj;
        if ((changeEmailRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        if (changeEmailRequest.getPassword() != null && !changeEmailRequest.getPassword().equals(getPassword())) {
            return false;
        }
        if ((changeEmailRequest.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        return changeEmailRequest.getEmail() == null || changeEmailRequest.getEmail().equals(getEmail());
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return (((getPassword() == null ? 0 : getPassword().hashCode()) + 31) * 31) + (getEmail() != null ? getEmail().hashCode() : 0);
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {password='" + this.password + "', email='" + this.email + "'}";
    }
}
