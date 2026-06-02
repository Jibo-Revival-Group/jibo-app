package com.segment.analytics;

import com.segment.analytics.Analytics;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Options {
    public static final String ALL_INTEGRATIONS_KEY = "All";
    private final Map<String, Object> integrations = new ConcurrentHashMap();

    public Options setIntegration(String str, boolean z) {
        if ("Segment.io".equals(str)) {
            throw new IllegalArgumentException("Segment integration cannot be enabled or disabled.");
        }
        this.integrations.put(str, Boolean.valueOf(z));
        return this;
    }

    public Options setIntegration(Analytics.BundledIntegration bundledIntegration, boolean z) {
        setIntegration(bundledIntegration.key, z);
        return this;
    }

    public Options setIntegrationOptions(String str, Map<String, Object> map) {
        this.integrations.put(str, map);
        return this;
    }

    public Options setIntegrationOptions(Analytics.BundledIntegration bundledIntegration, Map<String, Object> map) {
        this.integrations.put(bundledIntegration.key, map);
        return this;
    }

    public Map<String, Object> integrations() {
        return new LinkedHashMap(this.integrations);
    }
}
