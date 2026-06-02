package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class EmailRequest extends JiboAccountRequest {

    @Expose
    private String email;

    public EmailRequest(String str) {
        this.email = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EmailRequest)) {
            return false;
        }
        EmailRequest emailRequest = (EmailRequest) obj;
        if ((emailRequest.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        return emailRequest.getEmail() == null || emailRequest.getEmail().equals(getEmail());
    }

    public String getEmail() {
        return this.email;
    }

    public int hashCode() {
        return (getEmail() == null ? 0 : getEmail().hashCode()) + 31;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {email='" + this.email + "'}";
    }
}
