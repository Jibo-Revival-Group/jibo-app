package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.jibo.aws.integration.aws.services.account.model.Account;
import java.io.Serializable;
import java.util.Locale;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class MemberAccount implements Parcelable, Serializable {
    public static final Parcelable.Creator<MemberAccount> CREATOR = new Parcelable.Creator<MemberAccount>() { // from class: com.jibo.aws.integration.aws.services.loop.model.MemberAccount.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemberAccount createFromParcel(Parcel parcel) {
            return new MemberAccount(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemberAccount[] newArray(int i) {
            return new MemberAccount[i];
        }
    };
    private Long birthday;
    private String email;
    private String firstName;
    private Account.Gender gender;
    private String lastName;
    private String nickName;
    private String photoUrl;
    private String relationFrom;
    private String relationTo;

    public MemberAccount() {
    }

    private MemberAccount(Parcel parcel) {
        this.email = parcel.readString();
        this.relationTo = parcel.readString();
        this.relationFrom = parcel.readString();
        this.nickName = parcel.readString();
        this.lastName = parcel.readString();
        this.firstName = parcel.readString();
        this.gender = Account.Gender.values()[parcel.readInt()];
        this.birthday = Long.valueOf(parcel.readLong());
        this.photoUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MemberAccount)) {
            return false;
        }
        MemberAccount memberAccount = (MemberAccount) obj;
        if ((memberAccount.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        if (memberAccount.getEmail() != null && !memberAccount.getEmail().equals(getEmail())) {
            return false;
        }
        if ((memberAccount.getRelationTo() == null) ^ (getRelationTo() == null)) {
            return false;
        }
        if (memberAccount.getRelationTo() != null && !memberAccount.getRelationTo().equals(getRelationTo())) {
            return false;
        }
        if ((memberAccount.getRelationFrom() == null) ^ (getRelationFrom() == null)) {
            return false;
        }
        if (memberAccount.getRelationFrom() != null && !memberAccount.getRelationFrom().equals(getRelationFrom())) {
            return false;
        }
        if ((memberAccount.getNickName() == null) ^ (getNickName() == null)) {
            return false;
        }
        if (memberAccount.getNickName() != null && !memberAccount.getNickName().equals(getNickName())) {
            return false;
        }
        if ((memberAccount.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (memberAccount.getLastName() != null && !memberAccount.getLastName().equals(getLastName())) {
            return false;
        }
        if ((memberAccount.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (memberAccount.getFirstName() != null && !memberAccount.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((memberAccount.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (memberAccount.getGender() != null && !memberAccount.getGender().equals(getGender())) {
            return false;
        }
        if ((memberAccount.getPhotoUrl() == null) ^ (getPhotoUrl() == null)) {
            return false;
        }
        if (memberAccount.getPhotoUrl() != null && !memberAccount.getPhotoUrl().equals(getPhotoUrl())) {
            return false;
        }
        if ((memberAccount.getBirthday() == null) ^ (getBirthday() == null)) {
            return false;
        }
        return memberAccount.getBirthday() == null || memberAccount.getBirthday().equals(getBirthday());
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

    public String getFullName() {
        String firstName = getFirstName();
        String lastName = getLastName();
        if (Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
            firstName = getLastName();
            lastName = getFirstName();
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(firstName)) {
            sb.append(firstName);
        }
        if (!TextUtils.isEmpty(lastName)) {
            if (sb.length() > 0) {
                sb.append(TokenParser.f15715SP);
            }
            sb.append(lastName);
        }
        if (sb.length() == 0 && !TextUtils.isEmpty(getNickName())) {
            sb.append(getNickName());
        }
        return sb.toString();
    }

    public Account.Gender getGender() {
        return this.gender;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public String getRelationFrom() {
        return this.relationFrom;
    }

    public String getRelationTo() {
        return this.relationTo;
    }

    public int hashCode() {
        return (((getBirthday() == null ? 0 : getBirthday().hashCode()) + (((getGender() == null ? 0 : getGender().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getNickName() == null ? 0 : getNickName().hashCode()) + (((getRelationFrom() == null ? 0 : getRelationFrom().hashCode()) + (((getRelationTo() == null ? 0 : getRelationTo().hashCode()) + (((getEmail() == null ? 0 : getEmail().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getPhotoUrl() != null ? getPhotoUrl().hashCode() : 0);
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

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public void setRelationFrom(String str) {
        this.relationFrom = str;
    }

    public void setRelationTo(String str) {
        this.relationTo = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {, email='" + this.email + "', relationTo='" + this.relationTo + "', relationFrom='" + this.relationFrom + "', nickName='" + this.nickName + "', lastName='" + this.lastName + "', firstName='" + this.firstName + "', birthday='" + this.birthday + "', photoUrl='" + this.photoUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.email);
        parcel.writeString(this.relationTo);
        parcel.writeString(this.relationFrom);
        parcel.writeString(this.nickName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.firstName);
        parcel.writeInt(this.gender == null ? Account.Gender.other.ordinal() : this.gender.ordinal());
        parcel.writeLong(this.birthday == null ? 0L : this.birthday.longValue());
        parcel.writeString(this.photoUrl);
    }
}
