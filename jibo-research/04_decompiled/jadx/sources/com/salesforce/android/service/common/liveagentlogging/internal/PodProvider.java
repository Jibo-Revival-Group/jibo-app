package com.salesforce.android.service.common.liveagentlogging.internal;

import android.support.v4.util.ArraySet;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PodProvider {

    /* JADX INFO: renamed from: a */
    private static String f13632a;

    /* JADX INFO: renamed from: b */
    private final ArraySet<String> f13633b = new ArraySet<>();

    /* JADX INFO: renamed from: c */
    private ArraySet<String> f13634c = new ArraySet<>();

    public PodProvider(Builder builder) {
        if (f13632a != null) {
            this.f13633b.add(f13632a);
            this.f13634c.add(f13632a);
        } else {
            this.f13633b.addAll(Arrays.asList(builder.f13635a));
            this.f13634c.m2393a((ArraySet<? extends String>) this.f13633b);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m13917a() {
        if (this.f13633b.isEmpty()) {
            throw new AllPodsUnavailableException();
        }
        if (this.f13634c.isEmpty()) {
            this.f13634c.m2393a((ArraySet<? extends String>) this.f13633b);
        }
        return this.f13634c.m2395c((int) (Math.random() * ((double) this.f13634c.size())));
    }

    /* JADX INFO: renamed from: a */
    public void m13918a(String str) {
        this.f13633b.remove(str);
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected String[] f13635a;

        /* JADX INFO: renamed from: a */
        Builder m13919a(String... strArr) {
            this.f13635a = strArr;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public PodProvider m13920a() {
            Arguments.m14235a(this.f13635a);
            return new PodProvider(this);
        }
    }
}
