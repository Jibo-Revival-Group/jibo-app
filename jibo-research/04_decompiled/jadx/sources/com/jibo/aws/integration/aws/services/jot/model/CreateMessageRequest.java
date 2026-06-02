package com.jibo.aws.integration.aws.services.jot.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateMessageRequest extends JiboJotRequest {

    @Expose
    private String content;

    @Expose
    private String loopId;

    @Expose
    private List<MessagePart> parts;

    @Expose
    private List<String> tags;

    public CreateMessageRequest() {
    }

    public CreateMessageRequest(String str, String str2, List<MessagePart> list, List<String> list2) {
        this.loopId = str;
        this.content = str2;
        this.parts = list;
        this.tags = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateMessageRequest)) {
            return false;
        }
        CreateMessageRequest createMessageRequest = (CreateMessageRequest) obj;
        if ((createMessageRequest.getContent() == null) ^ (getContent() == null)) {
            return false;
        }
        if (createMessageRequest.getContent() != null && !createMessageRequest.getContent().equals(getContent())) {
            return false;
        }
        if ((createMessageRequest.getParts() == null) ^ (getParts() == null)) {
            return false;
        }
        if (createMessageRequest.getParts() != null && !createMessageRequest.getParts().equals(getParts())) {
            return false;
        }
        if ((createMessageRequest.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (createMessageRequest.getTags() != null && !createMessageRequest.getTags().equals(getTags())) {
            return false;
        }
        if ((createMessageRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return createMessageRequest.getLoopId() == null || createMessageRequest.getLoopId().equals(getLoopId());
    }

    public String getContent() {
        return this.content;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public List<MessagePart> getParts() {
        return this.parts;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (((getParts() == null ? 0 : getParts().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getContent() == null ? 0 : getContent().hashCode()) + 31) * 31)) * 31)) * 31) + (getTags() != null ? getTags().hashCode() : 0);
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setParts(List<MessagePart> list) {
        this.parts = list;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public String toString() {
        return "CreateMessageRequest {content='" + this.content + "'loopId='" + this.loopId + "'}";
    }
}
