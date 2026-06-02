package com.google.android.gms.internal;

import com.facebook.internal.NativeProtocol;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class zzchc {

    /* JADX INFO: renamed from: J */
    private static zzchd<Boolean> f7169J = zzchd.m8038a("measurement.service_enabled", true, true);

    /* JADX INFO: renamed from: K */
    private static zzchd<Boolean> f7170K = zzchd.m8038a("measurement.service_client_enabled", true, true);

    /* JADX INFO: renamed from: L */
    private static zzchd<Boolean> f7171L = zzchd.m8038a("measurement.log_third_party_store_events_enabled", false, false);

    /* JADX INFO: renamed from: M */
    private static zzchd<Boolean> f7172M = zzchd.m8038a("measurement.log_installs_enabled", false, false);

    /* JADX INFO: renamed from: N */
    private static zzchd<Boolean> f7173N = zzchd.m8038a("measurement.log_upgrades_enabled", false, false);

    /* JADX INFO: renamed from: O */
    private static zzchd<Boolean> f7174O = zzchd.m8038a("measurement.log_androidId_enabled", false, false);

    /* JADX INFO: renamed from: a */
    public static zzchd<Boolean> f7175a = zzchd.m8038a("measurement.upload_dsid_enabled", false, false);

    /* JADX INFO: renamed from: b */
    public static zzchd<Boolean> f7176b = zzchd.m8038a("measurement.event_sampling_enabled", false, false);

    /* JADX INFO: renamed from: c */
    public static zzchd<String> f7177c = zzchd.m8037a("measurement.log_tag", "FA", "FA-SVC");

    /* JADX INFO: renamed from: d */
    public static zzchd<Long> f7178d = zzchd.m8036a("measurement.ad_id_cache_time", 10000L, 10000L);

    /* JADX INFO: renamed from: e */
    public static zzchd<Long> f7179e = zzchd.m8036a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L);

    /* JADX INFO: renamed from: f */
    public static zzchd<Long> f7180f = zzchd.m8036a("measurement.config.cache_time", 86400000L, 3600000L);

    /* JADX INFO: renamed from: g */
    public static zzchd<String> f7181g = zzchd.m8037a("measurement.config.url_scheme", "https", "https");

    /* JADX INFO: renamed from: h */
    public static zzchd<String> f7182h = zzchd.m8037a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");

    /* JADX INFO: renamed from: i */
    public static zzchd<Integer> f7183i = zzchd.m8035a("measurement.upload.max_bundles", 100, 100);

    /* JADX INFO: renamed from: j */
    public static zzchd<Integer> f7184j = zzchd.m8035a("measurement.upload.max_batch_size", NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);

    /* JADX INFO: renamed from: k */
    public static zzchd<Integer> f7185k = zzchd.m8035a("measurement.upload.max_bundle_size", NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);

    /* JADX INFO: renamed from: l */
    public static zzchd<Integer> f7186l = zzchd.m8035a("measurement.upload.max_events_per_bundle", 1000, 1000);

    /* JADX INFO: renamed from: m */
    public static zzchd<Integer> f7187m = zzchd.m8035a("measurement.upload.max_events_per_day", 100000, 100000);

    /* JADX INFO: renamed from: n */
    public static zzchd<Integer> f7188n = zzchd.m8035a("measurement.upload.max_error_events_per_day", 1000, 1000);

    /* JADX INFO: renamed from: o */
    public static zzchd<Integer> f7189o = zzchd.m8035a("measurement.upload.max_public_events_per_day", SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);

    /* JADX INFO: renamed from: p */
    public static zzchd<Integer> f7190p = zzchd.m8035a("measurement.upload.max_conversions_per_day", 500, 500);

    /* JADX INFO: renamed from: q */
    public static zzchd<Integer> f7191q = zzchd.m8035a("measurement.upload.max_realtime_events_per_day", 10, 10);

    /* JADX INFO: renamed from: r */
    public static zzchd<Integer> f7192r = zzchd.m8035a("measurement.store.max_stored_events_per_app", 100000, 100000);

    /* JADX INFO: renamed from: s */
    public static zzchd<String> f7193s = zzchd.m8037a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");

    /* JADX INFO: renamed from: t */
    public static zzchd<Long> f7194t = zzchd.m8036a("measurement.upload.backoff_period", 43200000L, 43200000L);

    /* JADX INFO: renamed from: u */
    public static zzchd<Long> f7195u = zzchd.m8036a("measurement.upload.window_interval", 3600000L, 3600000L);

    /* JADX INFO: renamed from: v */
    public static zzchd<Long> f7196v = zzchd.m8036a("measurement.upload.interval", 3600000L, 3600000L);

    /* JADX INFO: renamed from: w */
    public static zzchd<Long> f7197w = zzchd.m8036a("measurement.upload.realtime_upload_interval", 10000L, 10000L);

    /* JADX INFO: renamed from: x */
    public static zzchd<Long> f7198x = zzchd.m8036a("measurement.upload.debug_upload_interval", 1000L, 1000L);

    /* JADX INFO: renamed from: y */
    public static zzchd<Long> f7199y = zzchd.m8036a("measurement.upload.minimum_delay", 500L, 500L);

    /* JADX INFO: renamed from: z */
    public static zzchd<Long> f7200z = zzchd.m8036a("measurement.alarm_manager.minimum_interval", 60000L, 60000L);

    /* JADX INFO: renamed from: A */
    public static zzchd<Long> f7160A = zzchd.m8036a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L);

    /* JADX INFO: renamed from: B */
    public static zzchd<Long> f7161B = zzchd.m8036a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);

    /* JADX INFO: renamed from: C */
    public static zzchd<Long> f7162C = zzchd.m8036a("measurement.upload.initial_upload_delay_time", 15000L, 15000L);

    /* JADX INFO: renamed from: D */
    public static zzchd<Long> f7163D = zzchd.m8036a("measurement.upload.retry_time", 1800000L, 1800000L);

    /* JADX INFO: renamed from: E */
    public static zzchd<Integer> f7164E = zzchd.m8035a("measurement.upload.retry_count", 6, 6);

    /* JADX INFO: renamed from: F */
    public static zzchd<Long> f7165F = zzchd.m8036a("measurement.upload.max_queue_time", 2419200000L, 2419200000L);

    /* JADX INFO: renamed from: G */
    public static zzchd<Integer> f7166G = zzchd.m8035a("measurement.lifetimevalue.max_currency_tracked", 4, 4);

    /* JADX INFO: renamed from: H */
    public static zzchd<Integer> f7167H = zzchd.m8035a("measurement.audience.filter_result_max_count", 200, 200);

    /* JADX INFO: renamed from: I */
    public static zzchd<Long> f7168I = zzchd.m8036a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
}
