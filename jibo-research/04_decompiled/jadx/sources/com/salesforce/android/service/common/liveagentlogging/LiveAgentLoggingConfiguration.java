package com.salesforce.android.service.common.liveagentlogging;

import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentLoggingConfiguration implements Serializable {

    /* JADX INFO: renamed from: a */
    protected static final String[] f13583a = {"la1-c1-dfw.salesforceliveagent.com", "la1-c2-dfw.salesforceliveagent.com", "la2-c1-dfw.salesforceliveagent.com", "la2-c2-dfw.salesforceliveagent.com", "la1-c1-phx.salesforceliveagent.com", "la1-c2-phx.salesforceliveagent.com", "la2-c1-phx.salesforceliveagent.com", "la2-c2-phx.salesforceliveagent.com"};

    /* JADX INFO: renamed from: b */
    private final String[] f13584b;

    /* JADX INFO: renamed from: c */
    private final int f13585c;

    /* JADX INFO: renamed from: d */
    private final int f13586d;

    /* JADX INFO: renamed from: e */
    private final long f13587e;

    protected LiveAgentLoggingConfiguration(Builder builder) {
        this.f13584b = (String[]) builder.f13588a.toArray(new String[0]);
        this.f13585c = builder.f13589b;
        this.f13586d = builder.f13590c;
        this.f13587e = builder.f13591d;
    }

    /* JADX INFO: renamed from: a */
    public String[] m13883a() {
        return this.f13584b;
    }

    /* JADX INFO: renamed from: b */
    public int m13884b() {
        return this.f13585c;
    }

    /* JADX INFO: renamed from: c */
    public int m13885c() {
        return this.f13586d;
    }

    /* JADX INFO: renamed from: d */
    public long m13886d() {
        return this.f13587e;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected List<String> f13588a = new ArrayList();

        /* JADX INFO: renamed from: b */
        protected int f13589b = 20000;

        /* JADX INFO: renamed from: c */
        protected int f13590c = 10;

        /* JADX INFO: renamed from: d */
        protected long f13591d = 15000;

        /* JADX INFO: renamed from: a */
        public LiveAgentLoggingConfiguration m13887a() {
            if (this.f13588a.isEmpty()) {
                this.f13588a.addAll(Arrays.asList(LiveAgentLoggingConfiguration.f13583a));
            }
            Iterator<String> it = this.f13588a.iterator();
            while (it.hasNext()) {
                Arguments.m14238a(it.next());
            }
            return new LiveAgentLoggingConfiguration(this);
        }
    }
}
