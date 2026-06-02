package com.jibo.aws.integration.aws.services.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.jibo.aws.integration.C0804R;
import com.jibo.aws.integration.aws.services.common.model.Device;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class Account implements Parcelable, Serializable {
    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>() { // from class: com.jibo.aws.integration.aws.services.account.model.Account.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Account createFromParcel(Parcel parcel) {
            return new Account(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Account[] newArray(int i) {
            return new Account[i];
        }
    };
    private String accessKeyId;
    private Long birthday;
    private List<Device> devices;
    private String email;
    private String firstName;
    private Gender gender;

    /* JADX INFO: renamed from: id */
    private String f9372id;
    private Boolean isActive;
    private String lastName;
    private Boolean messagingAllowed;
    private transient long modified;
    private String phoneNumber;
    private String photoUrl;
    private transient long retrieved;
    private String secretAccessKey;

    public enum Gender {
        male(C0804R.string.jbaws_Male),
        female(C0804R.string.jbaws_Female),
        other(C0804R.string.jbaws_Other),
        they(C0804R.string.jbaws_They);

        private final int nameId;

        Gender(int i) {
            this.nameId = i;
        }

        public int getNameId() {
            return this.nameId;
        }
    }

    public Account() {
    }

    private Account(Parcel parcel) {
        this.f9372id = parcel.readString();
        this.email = parcel.readString();
        this.accessKeyId = parcel.readString();
        this.secretAccessKey = parcel.readString();
        this.devices = new ArrayList();
        parcel.readTypedList(this.devices, Device.CREATOR);
        this.lastName = parcel.readString();
        this.firstName = parcel.readString();
        this.gender = Gender.values()[parcel.readInt()];
        this.birthday = Long.valueOf(parcel.readLong());
        this.isActive = Boolean.valueOf(parcel.readInt() > 0);
        this.photoUrl = parcel.readString();
        this.phoneNumber = parcel.readString();
        this.messagingAllowed = Boolean.valueOf(parcel.readInt() > 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Account)) {
            return false;
        }
        Account account = (Account) obj;
        if ((account.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (account.getId() != null && !account.getId().equals(getId())) {
            return false;
        }
        if ((account.getEmail() == null) ^ (getEmail() == null)) {
            return false;
        }
        if (account.getEmail() != null && !account.getEmail().equals(getEmail())) {
            return false;
        }
        if ((account.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        if (account.getAccessKeyId() != null && !account.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if ((account.getSecretAccessKey() == null) ^ (getSecretAccessKey() == null)) {
            return false;
        }
        if (account.getSecretAccessKey() != null && !account.getSecretAccessKey().equals(getSecretAccessKey())) {
            return false;
        }
        if ((account.getDevices() == null) ^ (getDevices() == null)) {
            return false;
        }
        if (account.getDevices() != null && !account.getDevices().equals(getDevices())) {
            return false;
        }
        if ((account.getLastName() == null) ^ (getLastName() == null)) {
            return false;
        }
        if (account.getLastName() != null && !account.getLastName().equals(getLastName())) {
            return false;
        }
        if ((account.getFirstName() == null) ^ (getFirstName() == null)) {
            return false;
        }
        if (account.getFirstName() != null && !account.getFirstName().equals(getFirstName())) {
            return false;
        }
        if ((account.getGender() == null) ^ (getGender() == null)) {
            return false;
        }
        if (account.getGender() != null && !account.getGender().equals(getGender())) {
            return false;
        }
        if ((account.getBirthday() == null) ^ (getBirthday() == null)) {
            return false;
        }
        if (account.getBirthday() != null && !account.getBirthday().equals(getBirthday())) {
            return false;
        }
        if ((account.isActive() == null) ^ (isActive() == null)) {
            return false;
        }
        if (account.isActive() != null && !account.isActive().equals(isActive())) {
            return false;
        }
        if ((account.getPhoneNumber() == null) ^ (getPhoneNumber() == null)) {
            return false;
        }
        if (account.getPhoneNumber() != null && !account.getPhoneNumber().equals(getPhoneNumber())) {
            return false;
        }
        if ((account.isMessagingAllowed() == null) ^ (isMessagingAllowed() == null)) {
            return false;
        }
        if (account.isMessagingAllowed() != null && !account.isMessagingAllowed().equals(isMessagingAllowed())) {
            return false;
        }
        if ((account.getPhotoUrl() == null) ^ (getPhotoUrl() == null)) {
            return false;
        }
        return account.getPhotoUrl() == null || account.getPhotoUrl().equals(getPhotoUrl());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Long getBirthday() {
        return this.birthday;
    }

    public List<Device> getDevices() {
        return this.devices;
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
        return sb.toString();
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getId() {
        return this.f9372id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public long getModified() {
        return this.modified;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public long getRetrieved() {
        return this.retrieved;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public UpdateRequest getUpdateRequest(Account account) {
        UpdateRequest updateRequest = new UpdateRequest(getId());
        if (getId().equals(account.getId())) {
            if (((account.getEmail() == null) ^ (getEmail() == null)) || ((account.getEmail() != null && !account.getEmail().equals(getEmail())) || (getEmail() != null && !getEmail().equals(account.getEmail())))) {
                updateRequest.setEmail(getEmail());
            }
            if (((account.getLastName() == null) ^ (getLastName() == null)) || ((account.getLastName() != null && !account.getLastName().equals(getLastName())) || (getLastName() != null && !getLastName().equals(account.getLastName())))) {
                updateRequest.setLastName(getLastName());
            }
            if (((account.getFirstName() == null) ^ (getFirstName() == null)) || ((account.getFirstName() != null && !account.getFirstName().equals(getFirstName())) || (getFirstName() != null && !getFirstName().equals(account.getFirstName())))) {
                updateRequest.setFirstName(getFirstName());
            }
            if (((account.getGender() == null) ^ (getGender() == null)) || ((account.getGender() != null && !account.getGender().equals(getGender())) || (getGender() != null && !getGender().equals(account.getGender())))) {
                updateRequest.setGender(getGender());
            }
            if (((account.getBirthday() == null) ^ (getBirthday() == null)) || ((account.getBirthday() != null && !account.getBirthday().equals(getBirthday())) || (getBirthday() != null && !getBirthday().equals(account.getBirthday())))) {
                updateRequest.setBirthday(getBirthday());
            }
            if (((account.getPhoneNumber() == null) ^ (getPhoneNumber() == null)) || ((account.getPhoneNumber() != null && !account.getPhoneNumber().equals(getPhoneNumber())) || (getPhoneNumber() != null && !getPhoneNumber().equals(account.getPhoneNumber())))) {
                updateRequest.setPhoneNumber(getPhoneNumber());
            }
            if (((account.isMessagingAllowed() == null) ^ (isMessagingAllowed() == null)) || ((account.isMessagingAllowed() != null && !account.isMessagingAllowed().equals(isMessagingAllowed())) || (isMessagingAllowed() != null && !isMessagingAllowed().equals(account.isMessagingAllowed())))) {
                updateRequest.setMessagingAllowed(isMessagingAllowed());
            }
        }
        return updateRequest;
    }

    public int hashCode() {
        return (((getPhoneNumber() == null ? 0 : getPhoneNumber().hashCode()) + (((getPhotoUrl() == null ? 0 : getPhotoUrl().hashCode()) + (((isActive() == null ? 0 : isActive().hashCode()) + (((((getGender() == null ? 0 : getGender().hashCode()) + (((getFirstName() == null ? 0 : getFirstName().hashCode()) + (((getLastName() == null ? 0 : getLastName().hashCode()) + (((getDevices() == null ? 0 : getDevices().hashCode()) + (((getSecretAccessKey() == null ? 0 : getSecretAccessKey().hashCode()) + (((getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode()) + (((getEmail() == null ? 0 : getEmail().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + getBirthday().hashCode()) * 31)) * 31)) * 31)) * 31) + (isMessagingAllowed() != null ? isMessagingAllowed().hashCode() : 0);
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public boolean isIncomplete() {
        return TextUtils.isEmpty(getFirstName()) || TextUtils.isEmpty(getLastName()) || getGender() == null;
    }

    public Boolean isMessagingAllowed() {
        return this.messagingAllowed;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setBirthday(Long l) {
        this.birthday = l;
    }

    public void setDevices(List<Device> list) {
        this.devices = list;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(String str) {
        this.f9372id = str;
    }

    public void setIsActive(Boolean bool) {
        this.isActive = bool;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setMessagingAllowed(Boolean bool) {
        this.messagingAllowed = bool;
    }

    public void setModified(long j) {
        this.modified = j;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public void setRetrieved(long j) {
        this.retrieved = j;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {id='" + this.f9372id + "', email='" + this.email + "', accessKeyId='" + this.accessKeyId + "', secretAccessKey='" + this.secretAccessKey + "', devices='[" + this.devices + "]', lastName='" + this.lastName + "', firstName='" + this.firstName + "', birthday='" + this.birthday + "', isActive='" + this.isActive + "', photoUrl='" + this.photoUrl + "', phoneNumber='" + this.phoneNumber + "', messagingAllowed='" + this.messagingAllowed + "'}";
    }

    public void update(Account account) {
        if (account.email != null) {
            this.email = account.email;
        }
        if (account.accessKeyId != null) {
            this.accessKeyId = account.accessKeyId;
        }
        if (account.secretAccessKey != null) {
            this.secretAccessKey = account.secretAccessKey;
        }
        if (account.devices != null) {
            this.devices = account.devices;
        }
        if (account.lastName != null) {
            this.lastName = account.lastName;
        }
        if (account.firstName != null) {
            this.firstName = account.firstName;
        }
        if (account.gender != null) {
            this.gender = account.gender;
        }
        if (account.birthday != null) {
            this.birthday = account.birthday;
        }
        if (account.isActive != null) {
            this.isActive = account.isActive;
        }
        if (account.photoUrl != null) {
            this.photoUrl = account.photoUrl;
        }
        if (account.phoneNumber != null) {
            this.phoneNumber = account.phoneNumber;
        }
        if (account.messagingAllowed != null) {
            this.messagingAllowed = account.messagingAllowed;
        }
    }

    public void update(UpdateRequest updateRequest) {
        if (updateRequest.getEmail() != null) {
            this.email = updateRequest.getEmail();
        }
        if (updateRequest.getLastName() != null) {
            this.lastName = updateRequest.getLastName();
        }
        if (updateRequest.getFirstName() != null) {
            this.firstName = updateRequest.getFirstName();
        }
        if (updateRequest.getGender() != null) {
            this.gender = updateRequest.getGender();
        }
        if (updateRequest.getBirthday() != null) {
            this.birthday = updateRequest.getBirthday();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9372id);
        parcel.writeString(this.email);
        parcel.writeString(this.accessKeyId);
        parcel.writeString(this.secretAccessKey);
        parcel.writeTypedList(this.devices);
        parcel.writeString(this.lastName);
        parcel.writeString(this.firstName);
        parcel.writeInt(this.gender == null ? Gender.other.ordinal() : this.gender.ordinal());
        parcel.writeLong(this.birthday == null ? 0L : this.birthday.longValue());
        parcel.writeInt((this.isActive == null || !this.isActive.booleanValue()) ? 0 : 1);
        parcel.writeString(this.photoUrl);
        parcel.writeString(this.phoneNumber);
        parcel.writeInt((this.messagingAllowed == null || !this.messagingAllowed.booleanValue()) ? 0 : 1);
    }
}
