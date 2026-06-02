package com.amazonaws.util;

import com.jibo.aws.integration.util.C0977a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class TimingInfoFullSupport extends TimingInfo {
    private final Map<String, Number> countersByName;
    private final Map<String, List<TimingInfo>> subMeasurementsByName;

    TimingInfoFullSupport(Long l, long j, Long l2) {
        super(l, j, l2);
        this.subMeasurementsByName = new HashMap();
        this.countersByName = new HashMap();
    }

    @Override // com.amazonaws.util.TimingInfo
    public void addSubMeasurement(String str, TimingInfo timingInfo) {
        List<TimingInfo> arrayList = this.subMeasurementsByName.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.subMeasurementsByName.put(str, arrayList);
        }
        if (timingInfo.isEndTimeKnown()) {
            arrayList.add(timingInfo);
        } else {
            C0977a.m10072a(getClass().getSimpleName(), "Skip submeasurement timing info with no end time for " + str);
        }
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map<String, Number> getAllCounters() {
        return this.countersByName;
    }

    @Override // com.amazonaws.util.TimingInfo
    public Number getCounter(String str) {
        return this.countersByName.get(str);
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map<String, List<TimingInfo>> getSubMeasurementsByName() {
        return this.subMeasurementsByName;
    }

    @Override // com.amazonaws.util.TimingInfo
    public void incrementCounter(String str) {
        setCounter(str, (getCounter(str) != null ? r1.intValue() : 0) + 1);
    }

    @Override // com.amazonaws.util.TimingInfo
    public void setCounter(String str, long j) {
        this.countersByName.put(str, Long.valueOf(j));
    }
}
