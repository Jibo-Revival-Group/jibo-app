package com.segment.analytics;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Pair;
import com.segment.analytics.AnalyticsContext;
import com.segment.analytics.integrations.Logger;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
class GetAdvertisingIdTask extends AsyncTask<Context, Void, Pair<String, Boolean>> {
    private final AnalyticsContext analyticsContext;
    private final CountDownLatch latch;
    private final Logger logger;

    GetAdvertisingIdTask(AnalyticsContext analyticsContext, CountDownLatch countDownLatch, Logger logger) {
        this.analyticsContext = analyticsContext;
        this.latch = countDownLatch;
        this.logger = logger;
    }

    private Pair<String, Boolean> getGooglePlayServicesAdvertisingID(Context context) throws Exception {
        Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
        if (((Boolean) objInvoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(objInvoke, new Object[0])).booleanValue()) {
            this.logger.debug("Not collecting advertising ID because isLimitAdTrackingEnabled (Google Play Services) is true.", new Object[0]);
            return Pair.create(null, false);
        }
        return Pair.create((String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]), true);
    }

    private Pair<String, Boolean> getAmazonFireAdvertisingID(Context context) throws Exception {
        ContentResolver contentResolver = context.getContentResolver();
        if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0) {
            this.logger.debug("Not collecting advertising ID because limit_ad_tracking (Amazon Fire OS) is true.", new Object[0]);
            return Pair.create(null, false);
        }
        return Pair.create(Settings.Secure.getString(contentResolver, "advertising_id"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Pair<String, Boolean> doInBackground(Context... contextArr) {
        Context context = contextArr[0];
        try {
            return getGooglePlayServicesAdvertisingID(context);
        } catch (Exception e) {
            this.logger.error(e, "Unable to collect advertising ID from Google Play Services.", new Object[0]);
            try {
                return getAmazonFireAdvertisingID(context);
            } catch (Exception e2) {
                this.logger.error(e2, "Unable to collect advertising ID from Amazon Fire OS.", new Object[0]);
                this.logger.debug("Unable to collect advertising ID from Amazon Fire OS and Google Play Services.", new Object[0]);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Pair<String, Boolean> pair) {
        super.onPostExecute(pair);
        if (pair != null) {
            try {
                AnalyticsContext.Device device = this.analyticsContext.device();
                if (device == null) {
                    this.logger.debug("Not collecting advertising ID because context.device is null.", new Object[0]);
                } else {
                    device.putAdvertisingInfo((String) pair.first, ((Boolean) pair.second).booleanValue());
                    this.latch.countDown();
                }
            } finally {
                this.latch.countDown();
            }
        }
    }
}
