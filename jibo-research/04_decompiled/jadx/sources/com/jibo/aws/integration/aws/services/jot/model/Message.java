package com.jibo.aws.integration.aws.services.jot.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Message implements Parcelable, Serializable {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() { // from class: com.jibo.aws.integration.aws.services.jot.model.Message.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message[] newArray(int i) {
            return new Message[i];
        }
    };

    @Expose
    private String content;

    @Expose
    private Long created;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9458id;

    @Expose
    private Boolean isEncrypted;

    @Expose
    private Boolean isRead;

    @Expose
    private String loopId;

    @Expose
    private List<MessagePart> parts;

    @Expose
    private String sender;

    @Expose
    private List<String> tags;

    public Message() {
    }

    protected Message(Parcel parcel) {
        this.f9458id = parcel.readString();
        this.loopId = parcel.readString();
        this.content = parcel.readString();
        this.sender = parcel.readString();
        this.parts = new ArrayList();
        parcel.readTypedList(this.parts, MessagePart.CREATOR);
        this.tags = new ArrayList();
        parcel.readStringList(this.tags);
        this.created = Long.valueOf(parcel.readLong());
        this.isRead = Boolean.valueOf(parcel.readByte() != 0);
        this.isEncrypted = Boolean.valueOf(parcel.readByte() != 0);
    }

    public Message(String str, String str2, String str3, List<MessagePart> list, List<String> list2, Long l, boolean z, boolean z2) {
        this.loopId = str;
        this.content = str2;
        this.sender = str3;
        this.parts = list;
        this.tags = list2;
        this.created = l;
        this.isRead = Boolean.valueOf(z);
        this.isEncrypted = Boolean.valueOf(z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if ((message.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (message.getId() != null && !message.getId().equals(getId())) {
            return false;
        }
        if ((message.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (message.getLoopId() != null && !message.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((message.getContent() == null) ^ (getContent() == null)) {
            return false;
        }
        if (message.getContent() != null && !message.getContent().equals(getContent())) {
            return false;
        }
        if ((message.getSender() == null) ^ (getSender() == null)) {
            return false;
        }
        if (message.getSender() != null && !message.getSender().equals(getSender())) {
            return false;
        }
        if ((message.getParts() == null) ^ (getParts() == null)) {
            return false;
        }
        if (message.getParts() != null && !message.getParts().equals(getParts())) {
            return false;
        }
        if ((message.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (message.getTags() != null && !message.getTags().equals(getTags())) {
            return false;
        }
        if ((message.isRead() == null) ^ (isRead() == null)) {
            return false;
        }
        if (message.isRead() != null && !message.isRead().equals(isRead())) {
            return false;
        }
        if ((message.isEncrypted() == null) ^ (isEncrypted() == null)) {
            return false;
        }
        if (message.isEncrypted() != null && !message.isEncrypted().equals(isEncrypted())) {
            return false;
        }
        if ((message.getCreated() == null) ^ (getCreated() == null)) {
            return false;
        }
        return message.getCreated() == null || message.getCreated().equals(getCreated());
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreated() {
        return this.created;
    }

    public String getId() {
        return this.f9458id;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public List<MessagePart> getParts() {
        return this.parts;
    }

    public String getSender() {
        return this.sender;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (((isRead() == null ? 0 : isRead().hashCode()) + (((getCreated() == null ? 0 : getCreated().hashCode()) + (((getTags() == null ? 0 : getTags().hashCode()) + (((getParts() == null ? 0 : getParts().hashCode()) + (((getSender() == null ? 0 : getSender().hashCode()) + (((getContent() == null ? 0 : getContent().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (isEncrypted() != null ? isEncrypted().hashCode() : 0);
    }

    public Boolean isEncrypted() {
        return this.isEncrypted;
    }

    public Boolean isRead() {
        return this.isRead;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreated(Long l) {
        this.created = l;
    }

    public void setEncrypted(Boolean bool) {
        this.isEncrypted = bool;
    }

    public void setId(String str) {
        this.f9458id = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setParts(List<MessagePart> list) {
        this.parts = list;
    }

    public void setRead(boolean z) {
        this.isRead = Boolean.valueOf(z);
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public String toString() {
        return "Message {id='" + this.f9458id + "'loopId='" + this.loopId + "'created='" + this.created + "'sender='" + this.sender + "'tags='" + this.tags + "'content='" + this.content + "'isEncrypted='" + this.isEncrypted + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9458id);
        parcel.writeString(this.loopId);
        parcel.writeString(this.content);
        parcel.writeString(this.sender);
        parcel.writeTypedList(this.parts);
        parcel.writeStringList(this.tags);
        parcel.writeLong(this.created.longValue());
        parcel.writeByte((byte) ((this.isRead == null || !this.isRead.booleanValue()) ? 0 : 1));
        parcel.writeByte((byte) ((this.isEncrypted == null || !this.isEncrypted.booleanValue()) ? 0 : 1));
    }
}
