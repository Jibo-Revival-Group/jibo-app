package com.jibo.aws.integration.aws.services.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FacebookPrepareLogin implements Parcelable, Serializable {
    public static final Parcelable.Creator<FacebookPrepareLogin> CREATOR = new Parcelable.Creator<FacebookPrepareLogin>() { // from class: com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLogin.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FacebookPrepareLogin createFromParcel(Parcel parcel) {
            return new FacebookPrepareLogin(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FacebookPrepareLogin[] newArray(int i) {
            return new FacebookPrepareLogin[i];
        }
    };

    @SerializedName(m9428a = "client_id")
    @Expose
    private String clientId;

    @SerializedName(m9428a = ServerProtocol.DIALOG_PARAM_REDIRECT_URI)
    @Expose
    private String redirectUri;

    @SerializedName(m9428a = ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE)
    @Expose
    private String responseType;

    @Expose
    private String scope;

    @Expose
    private String state;

    @Expose
    private String url;

    public FacebookPrepareLogin() {
    }

    protected FacebookPrepareLogin(Parcel parcel) {
        this.url = parcel.readString();
        this.clientId = parcel.readString();
        this.scope = parcel.readString();
        this.responseType = parcel.readString();
        this.state = parcel.readString();
        this.redirectUri = parcel.readString();
    }

    public FacebookPrepareLogin(String str, String str2, String str3, String str4, String str5, String str6) {
        this.url = str;
        this.clientId = str2;
        this.scope = str3;
        this.responseType = str4;
        this.state = str5;
        this.redirectUri = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FacebookPrepareLogin)) {
            return false;
        }
        FacebookPrepareLogin facebookPrepareLogin = (FacebookPrepareLogin) obj;
        if ((facebookPrepareLogin.getUrl() == null) ^ (getUrl() == null)) {
            return false;
        }
        if (facebookPrepareLogin.getUrl() != null && !facebookPrepareLogin.getUrl().equals(getUrl())) {
            return false;
        }
        if ((facebookPrepareLogin.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (facebookPrepareLogin.getClientId() != null && !facebookPrepareLogin.getClientId().equals(getClientId())) {
            return false;
        }
        if ((facebookPrepareLogin.getScope() == null) ^ (getScope() == null)) {
            return false;
        }
        if (facebookPrepareLogin.getScope() != null && !facebookPrepareLogin.getScope().equals(getScope())) {
            return false;
        }
        if ((facebookPrepareLogin.getResponseType() == null) ^ (getResponseType() == null)) {
            return false;
        }
        if (facebookPrepareLogin.getResponseType() != null && !facebookPrepareLogin.getResponseType().equals(getResponseType())) {
            return false;
        }
        if ((facebookPrepareLogin.getState() == null) ^ (getState() == null)) {
            return false;
        }
        if (facebookPrepareLogin.getState() != null && !facebookPrepareLogin.getState().equals(getState())) {
            return false;
        }
        if ((facebookPrepareLogin.getRedirectUri() == null) ^ (getRedirectUri() == null)) {
            return false;
        }
        return facebookPrepareLogin.getRedirectUri() == null || facebookPrepareLogin.getRedirectUri().equals(getRedirectUri());
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getRedirectUri() {
        return this.redirectUri;
    }

    public String getResponseType() {
        return this.responseType;
    }

    public String getScope() {
        return this.scope;
    }

    public String getState() {
        return this.state;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((getState() == null ? 0 : getState().hashCode()) + (((getResponseType() == null ? 0 : getResponseType().hashCode()) + (((getScope() == null ? 0 : getScope().hashCode()) + (((getClientId() == null ? 0 : getClientId().hashCode()) + (((getUrl() == null ? 0 : getUrl().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31) + (getRedirectUri() != null ? getRedirectUri().hashCode() : 0);
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setRedirectUri(String str) {
        this.redirectUri = str;
    }

    public void setResponseType(String str) {
        this.responseType = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "FacebookPrepareLogin {url='" + this.url + "', clientId='" + this.clientId + "', scope='" + this.scope + "', responseType='" + this.responseType + "', state='" + this.state + "', redirectUri='" + this.redirectUri + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.clientId);
        parcel.writeString(this.scope);
        parcel.writeString(this.responseType);
        parcel.writeString(this.state);
        parcel.writeString(this.redirectUri);
    }
}
