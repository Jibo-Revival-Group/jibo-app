package com.segment.analytics.integrations;

import android.app.Activity;
import android.os.Bundle;
import com.segment.analytics.Analytics;
import com.segment.analytics.ValueMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Integration<T> {

    public interface Factory {
        Integration<?> create(ValueMap valueMap, Analytics analytics);

        String key();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void identify(IdentifyPayload identifyPayload) {
    }

    public void group(GroupPayload groupPayload) {
    }

    public void track(TrackPayload trackPayload) {
    }

    public void alias(AliasPayload aliasPayload) {
    }

    public void screen(ScreenPayload screenPayload) {
    }

    public void flush() {
    }

    public void reset() {
    }

    public T getUnderlyingInstance() {
        return null;
    }
}
