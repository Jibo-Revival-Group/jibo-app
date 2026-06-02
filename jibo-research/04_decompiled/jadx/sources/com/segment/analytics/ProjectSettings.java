package com.segment.analytics;

import android.content.Context;
import com.segment.analytics.ValueMap;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ProjectSettings extends ValueMap {
    private static final String INTEGRATIONS_KEY = "integrations";
    private static final String PLAN_KEY = "plan";
    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String TRACKING_PLAN_KEY = "track";

    static ProjectSettings create(Map<String, Object> map) {
        map.put(TIMESTAMP_KEY, Long.valueOf(System.currentTimeMillis()));
        return new ProjectSettings(map);
    }

    ProjectSettings(Map<String, Object> map) {
        super((Map<String, Object>) Collections.unmodifiableMap(map));
    }

    long timestamp() {
        return getLong(TIMESTAMP_KEY, 0L);
    }

    ValueMap plan() {
        return getValueMap(PLAN_KEY);
    }

    ValueMap trackingPlan() {
        ValueMap valueMapPlan = plan();
        if (valueMapPlan == null) {
            return null;
        }
        return valueMapPlan.getValueMap(TRACKING_PLAN_KEY);
    }

    ValueMap integrations() {
        return getValueMap(INTEGRATIONS_KEY);
    }

    static class Cache extends ValueMap.Cache<ProjectSettings> {
        private static final String PROJECT_SETTINGS_CACHE_KEY_PREFIX = "project-settings-plan-";

        @Override // com.segment.analytics.ValueMap.Cache
        public /* bridge */ /* synthetic */ ValueMap create(Map map) {
            return create((Map<String, Object>) map);
        }

        Cache(Context context, Cartographer cartographer, String str) {
            super(context, cartographer, PROJECT_SETTINGS_CACHE_KEY_PREFIX + str, str, ProjectSettings.class);
        }

        @Override // com.segment.analytics.ValueMap.Cache
        public ProjectSettings create(Map<String, Object> map) {
            return new ProjectSettings(map);
        }
    }
}
