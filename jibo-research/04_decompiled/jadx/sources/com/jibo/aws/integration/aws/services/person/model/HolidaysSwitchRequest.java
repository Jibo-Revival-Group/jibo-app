package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HolidaysSwitchRequest extends JiboPersonRequest {
    private boolean enable;

    @Expose
    private List<String> ids;

    @Expose
    private String loopId;

    public HolidaysSwitchRequest(boolean z, List<String> list, String str) {
        this.enable = z;
        this.ids = list;
        this.loopId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HolidaysSwitchRequest)) {
            return false;
        }
        HolidaysSwitchRequest holidaysSwitchRequest = (HolidaysSwitchRequest) obj;
        if ((holidaysSwitchRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (holidaysSwitchRequest.getLoopId() != null && !holidaysSwitchRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((holidaysSwitchRequest.getIds() == null) ^ (getIds() == null)) {
            return false;
        }
        return holidaysSwitchRequest.getIds() == null || holidaysSwitchRequest.getIds().equals(getIds());
    }

    public List<String> getIds() {
        return this.ids;
    }

    public String getLoopId() {
        return this.loopId;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return this.enable ? "EnableHolidays" : "DisableHolidays";
    }

    public int hashCode() {
        return (((getIds() == null ? 0 : getIds().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    public void setIds(List<String> list) {
        this.ids = list;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {ids='" + this.ids + "'}";
    }
}
