package com.segment.analytics;

import android.app.Activity;
import android.os.Bundle;
import com.segment.analytics.integrations.AliasPayload;
import com.segment.analytics.integrations.GroupPayload;
import com.segment.analytics.integrations.IdentifyPayload;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.ScreenPayload;
import com.segment.analytics.integrations.TrackPayload;
import com.segment.analytics.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
abstract class IntegrationOperation {
    static final IntegrationOperation FLUSH = new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.13
        @Override // com.segment.analytics.IntegrationOperation
        void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
            integration.flush();
        }

        public String toString() {
            return "Flush";
        }
    };
    static final IntegrationOperation RESET = new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.14
        @Override // com.segment.analytics.IntegrationOperation
        void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
            integration.reset();
        }

        public String toString() {
            return "Reset";
        }
    };

    abstract void run(String str, Integration<?> integration, ProjectSettings projectSettings);

    static boolean isIntegrationEnabled(ValueMap valueMap, String str) {
        if (Utils.isNullOrEmpty(valueMap) || "Segment.io".equals(str)) {
            return true;
        }
        if (valueMap.containsKey(str)) {
            return valueMap.getBoolean(str, true);
        }
        if (valueMap.containsKey(Options.ALL_INTEGRATIONS_KEY)) {
            return valueMap.getBoolean(Options.ALL_INTEGRATIONS_KEY, true);
        }
        return true;
    }

    static IntegrationOperation onActivityCreated(final Activity activity, final Bundle bundle) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivityCreated(activity, bundle);
            }

            public String toString() {
                return "Activity Created";
            }
        };
    }

    static IntegrationOperation onActivityStarted(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivityStarted(activity);
            }

            public String toString() {
                return "Activity Started";
            }
        };
    }

    static IntegrationOperation onActivityResumed(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivityResumed(activity);
            }

            public String toString() {
                return "Activity Resumed";
            }
        };
    }

    static IntegrationOperation onActivityPaused(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivityPaused(activity);
            }

            public String toString() {
                return "Activity Paused";
            }
        };
    }

    static IntegrationOperation onActivityStopped(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivityStopped(activity);
            }

            public String toString() {
                return "Activity Stopped";
            }
        };
    }

    static IntegrationOperation onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivitySaveInstanceState(activity, bundle);
            }

            public String toString() {
                return "Activity Save Instance";
            }
        };
    }

    static IntegrationOperation onActivityDestroyed(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                integration.onActivityDestroyed(activity);
            }

            public String toString() {
                return "Activity Destroyed";
            }
        };
    }

    static IntegrationOperation identify(final IdentifyPayload identifyPayload) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.8
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                if (isIntegrationEnabled(identifyPayload.integrations(), str)) {
                    integration.identify(identifyPayload);
                }
            }

            public String toString() {
                return identifyPayload.toString();
            }
        };
    }

    static IntegrationOperation group(final GroupPayload groupPayload) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.9
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                if (isIntegrationEnabled(groupPayload.integrations(), str)) {
                    integration.group(groupPayload);
                }
            }

            public String toString() {
                return groupPayload.toString();
            }
        };
    }

    static IntegrationOperation track(final TrackPayload trackPayload) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.10
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                ValueMap valueMapIntegrations = trackPayload.integrations();
                ValueMap valueMapTrackingPlan = projectSettings.trackingPlan();
                if (Utils.isNullOrEmpty(valueMapTrackingPlan)) {
                    if (isIntegrationEnabled(valueMapIntegrations, str)) {
                        integration.track(trackPayload);
                        return;
                    }
                    return;
                }
                ValueMap valueMap = valueMapTrackingPlan.getValueMap(trackPayload.event());
                if (Utils.isNullOrEmpty(valueMap)) {
                    if (!Utils.isNullOrEmpty(valueMapIntegrations)) {
                        if (isIntegrationEnabled(valueMapIntegrations, str)) {
                            integration.track(trackPayload);
                            return;
                        }
                        return;
                    }
                    ValueMap valueMap2 = valueMapTrackingPlan.getValueMap("__default");
                    if (Utils.isNullOrEmpty(valueMap2)) {
                        integration.track(trackPayload);
                        return;
                    } else {
                        if (valueMap2.getBoolean("enabled", true) || "Segment.io".equals(str)) {
                            integration.track(trackPayload);
                            return;
                        }
                        return;
                    }
                }
                if (!valueMap.getBoolean("enabled", true)) {
                    if ("Segment.io".equals(str)) {
                        integration.track(trackPayload);
                        return;
                    }
                    return;
                }
                ValueMap valueMap3 = new ValueMap();
                ValueMap valueMap4 = valueMap.getValueMap("integrations");
                if (!Utils.isNullOrEmpty(valueMap4)) {
                    valueMap3.putAll(valueMap4);
                }
                valueMap3.putAll(valueMapIntegrations);
                if (isIntegrationEnabled(valueMap3, str)) {
                    integration.track(trackPayload);
                }
            }

            public String toString() {
                return trackPayload.toString();
            }
        };
    }

    static IntegrationOperation screen(final ScreenPayload screenPayload) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.11
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                if (isIntegrationEnabled(screenPayload.integrations(), str)) {
                    integration.screen(screenPayload);
                }
            }

            public String toString() {
                return screenPayload.toString();
            }
        };
    }

    static IntegrationOperation alias(final AliasPayload aliasPayload) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.12
            {
                super();
            }

            @Override // com.segment.analytics.IntegrationOperation
            public void run(String str, Integration<?> integration, ProjectSettings projectSettings) {
                if (isIntegrationEnabled(aliasPayload.integrations(), str)) {
                    integration.alias(aliasPayload);
                }
            }

            public String toString() {
                return aliasPayload.toString();
            }
        };
    }

    private IntegrationOperation() {
    }
}
