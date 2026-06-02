package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class ListHolidaysRequest extends JiboPersonRequest {

    @Expose
    private String loopId;

    public ListHolidaysRequest() {
    }

    public ListHolidaysRequest(String str) {
        this.loopId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListHolidaysRequest)) {
            return false;
        }
        ListHolidaysRequest listHolidaysRequest = (ListHolidaysRequest) obj;
        if ((listHolidaysRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return listHolidaysRequest.getLoopId() == null || listHolidaysRequest.getLoopId().equals(getLoopId());
    }

    public String getLoopId() {
        return this.loopId;
    }

    public int hashCode() {
        return (getLoopId() == null ? 0 : getLoopId().hashCode()) + 31;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return "ListHolidaysRequest {loopId='" + this.loopId + "'}";
    }
}
