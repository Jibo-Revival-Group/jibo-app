package com.jibo.aws.integration.aws.services.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class TokenContainer implements Parcelable, Serializable {
    public static final Parcelable.Creator<TokenContainer> CREATOR = new Parcelable.Creator<TokenContainer>() { // from class: com.jibo.aws.integration.aws.services.account.model.TokenContainer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TokenContainer createFromParcel(Parcel parcel) {
            return new TokenContainer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TokenContainer[] newArray(int i) {
            return new TokenContainer[i];
        }
    };

    @Expose
    private Long expires;

    @Expose
    private String token;

    private TokenContainer(Parcel parcel) {
        this.token = parcel.readString();
        this.expires = Long.valueOf(parcel.readLong());
    }

    public TokenContainer(String str) {
        this.token = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TokenContainer)) {
            return false;
        }
        TokenContainer tokenContainer = (TokenContainer) obj;
        if ((tokenContainer.getToken() == null) ^ (getToken() == null)) {
            return false;
        }
        return tokenContainer.getToken() == null || tokenContainer.getToken().equals(getToken());
    }

    public Long getExpires() {
        return this.expires;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((getToken() == null ? 0 : getToken().hashCode()) + 31) * 31) + (getExpires() != null ? getExpires().hashCode() : 0);
    }

    public void setExpires(Long l) {
        this.expires = l;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "TokenContainer {token='" + this.token + "', expires='" + this.expires + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
        parcel.writeLong(this.expires.longValue());
    }
}
