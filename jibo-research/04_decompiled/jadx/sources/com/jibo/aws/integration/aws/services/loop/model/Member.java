package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Member implements Parcelable, Serializable {
    public static final Parcelable.Creator<Member> CREATOR = new Parcelable.Creator<Member>() { // from class: com.jibo.aws.integration.aws.services.loop.model.Member.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Member createFromParcel(Parcel parcel) {
            return new Member(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Member[] newArray(int i) {
            return new Member[i];
        }
    };

    @Expose
    private MemberAccount account;

    @Expose
    private String accountId;

    @Expose
    private String agreementId;

    @Expose
    private Long created;

    @Expose
    private Enrolled enrolled;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9567id;

    @Expose
    private String legalGuardianId;

    @Expose
    private String loopId;

    @Expose
    private String nickname;

    @Expose
    private String phoneticName;

    @Expose
    private InvitationStatus status;

    @Expose
    private InvitationType type;

    public enum InvitationStatus {
        invited,
        accepted,
        declined,
        removed
    }

    public enum InvitationType {
        incoming,
        outgoing
    }

    public Member() {
    }

    protected Member(Parcel parcel) {
        this.f9567id = parcel.readString();
        this.loopId = parcel.readString();
        this.accountId = parcel.readString();
        this.account = (MemberAccount) parcel.readParcelable(MemberAccount.class.getClassLoader());
        this.enrolled = (Enrolled) parcel.readParcelable(Enrolled.class.getClassLoader());
        int i = parcel.readInt();
        this.status = i != -1 ? InvitationStatus.values()[i] : null;
        int i2 = parcel.readInt();
        this.type = i2 != -1 ? InvitationType.values()[i2] : null;
        this.nickname = parcel.readString();
        this.phoneticName = parcel.readString();
        this.legalGuardianId = parcel.readString();
        this.created = Long.valueOf(parcel.readLong());
        this.agreementId = parcel.readString();
    }

    public Member(String str, String str2, Enrolled enrolled, InvitationStatus invitationStatus, InvitationType invitationType, String str3, String str4, String str5) {
        this.loopId = str;
        this.accountId = str2;
        this.enrolled = enrolled;
        this.status = invitationStatus;
        this.type = invitationType;
        this.nickname = str3;
        this.phoneticName = str4;
        this.legalGuardianId = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Member)) {
            return false;
        }
        Member member = (Member) obj;
        if ((member.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (member.getId() != null && !member.getId().equals(getId())) {
            return false;
        }
        if ((member.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (member.getLoopId() != null && !member.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((member.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        if (member.getAccountId() != null && !member.getAccountId().equals(getAccountId())) {
            return false;
        }
        if ((member.getAccount() == null) ^ (getAccount() == null)) {
            return false;
        }
        if (member.getAccount() != null && !member.getAccount().equals(getAccount())) {
            return false;
        }
        if ((member.getEnrolled() == null) ^ (getEnrolled() == null)) {
            return false;
        }
        if (member.getEnrolled() != null && !member.getEnrolled().equals(getEnrolled())) {
            return false;
        }
        if ((member.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (member.getStatus() != null && !member.getStatus().equals(getStatus())) {
            return false;
        }
        if ((member.getType() == null) ^ (getType() == null)) {
            return false;
        }
        if (member.getType() != null && !member.getType().equals(getType())) {
            return false;
        }
        if ((member.getPhoneticName() == null) ^ (getPhoneticName() == null)) {
            return false;
        }
        if (member.getPhoneticName() != null && !member.getPhoneticName().equals(getPhoneticName())) {
            return false;
        }
        if ((member.getLegalGuardianId() == null) ^ (getLegalGuardianId() == null)) {
            return false;
        }
        if (member.getLegalGuardianId() != null && !member.getLegalGuardianId().equals(getLegalGuardianId())) {
            return false;
        }
        if ((member.getCreated() == null) ^ (getCreated() == null)) {
            return false;
        }
        if (member.getCreated() != null && !member.getCreated().equals(getCreated())) {
            return false;
        }
        if ((member.getAgreementId() == null) ^ (getAgreementId() == null)) {
            return false;
        }
        if (member.getAgreementId() != null && !member.getAgreementId().equals(getAgreementId())) {
            return false;
        }
        if ((member.getNickname() == null) ^ (getNickname() == null)) {
            return false;
        }
        return member.getNickname() == null || member.getNickname().equals(getNickname());
    }

    public MemberAccount getAccount() {
        return this.account;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getAgreementId() {
        return this.agreementId;
    }

    public Long getCreated() {
        return this.created;
    }

    public Enrolled getEnrolled() {
        return this.enrolled;
    }

    public String getId() {
        return this.f9567id;
    }

    public String getLegalGuardianId() {
        return this.legalGuardianId;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPhoneticName() {
        return this.phoneticName;
    }

    public InvitationStatus getStatus() {
        return this.status;
    }

    public InvitationType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((getCreated() == null ? 0 : getCreated().hashCode()) + (((getLegalGuardianId() == null ? 0 : getLegalGuardianId().hashCode()) + (((getPhoneticName() == null ? 0 : getPhoneticName().hashCode()) + (((getNickname() == null ? 0 : getNickname().hashCode()) + (((getType() == null ? 0 : getType().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getEnrolled() == null ? 0 : getEnrolled().hashCode()) + (((getAccountId() == null ? 0 : getAccountId().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getAgreementId() != null ? getAgreementId().hashCode() : 0);
    }

    public boolean isEnrolled() {
        return (this.enrolled != null && this.enrolled.getVoice().booleanValue()) || this.enrolled.getFace().booleanValue();
    }

    public void setAccount(MemberAccount memberAccount) {
        this.account = memberAccount;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAgreementId(String str) {
        this.agreementId = str;
    }

    public void setCreated(Long l) {
        this.created = l;
    }

    public void setEnrolled(Enrolled enrolled) {
        this.enrolled = enrolled;
    }

    public void setId(String str) {
        this.f9567id = str;
    }

    public void setLegalGuardianId(String str) {
        this.legalGuardianId = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPhoneticName(String str) {
        this.phoneticName = str;
    }

    public void setStatus(InvitationStatus invitationStatus) {
        this.status = invitationStatus;
    }

    public void setType(InvitationType invitationType) {
        this.type = invitationType;
    }

    public String toString() {
        return "Member {id='" + this.f9567id + "', loopId='" + this.loopId + "', accountId='" + this.accountId + "', enrolled='" + this.enrolled + "', status='" + this.status + "', type='" + this.type + "', nickname='" + this.nickname + "', phoneticName='" + this.phoneticName + "', legalGuardianId='" + this.legalGuardianId + "', created='" + this.created + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9567id);
        parcel.writeString(this.loopId);
        parcel.writeString(this.accountId);
        parcel.writeParcelable(this.account, i);
        parcel.writeParcelable(this.enrolled, i);
        parcel.writeInt(this.status != null ? this.status.ordinal() : -1);
        parcel.writeInt(this.type != null ? this.type.ordinal() : -1);
        parcel.writeString(this.nickname);
        parcel.writeString(this.phoneticName);
        parcel.writeString(this.legalGuardianId);
        parcel.writeLong(this.created == null ? -1L : this.created.longValue());
        parcel.writeString(this.agreementId);
    }
}
