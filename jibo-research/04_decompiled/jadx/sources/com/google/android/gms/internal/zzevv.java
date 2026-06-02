package com.google.android.gms.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzevv extends zzevx {

    /* JADX INFO: renamed from: a */
    private zzevz f7815a;

    /* JADX INFO: renamed from: b */
    private boolean f7816b;

    /* JADX INFO: renamed from: c */
    private long f7817c;

    /* JADX INFO: renamed from: d */
    private boolean f7818d;

    /* JADX INFO: renamed from: e */
    private String f7819e;

    /* JADX INFO: renamed from: f */
    private Integer f7820f;

    /* JADX INFO: renamed from: g */
    private Long f7821g;

    /* JADX INFO: renamed from: h */
    private Long f7822h;

    /* JADX INFO: renamed from: i */
    private Integer f7823i;

    /* JADX INFO: renamed from: j */
    private Integer f7824j;

    /* JADX INFO: renamed from: k */
    private String f7825k;

    /* JADX INFO: renamed from: l */
    private Long f7826l;

    /* JADX INFO: renamed from: m */
    private Long f7827m;

    /* JADX INFO: renamed from: n */
    private Long f7828n;

    /* JADX INFO: renamed from: o */
    private Long f7829o;

    /* JADX INFO: renamed from: p */
    private zzeww[] f7830p;

    private zzevv(zzevz zzevzVar) {
        this(zzevzVar, zzevw.m8544a());
    }

    private zzevv(zzevz zzevzVar, zzevw zzevwVar) {
        super(zzevwVar);
        this.f7816b = false;
        this.f7817c = -1L;
        this.f7818d = false;
        this.f7815a = zzevzVar;
        m8557e();
    }

    /* JADX INFO: renamed from: a */
    public static zzevv m8529a(zzevz zzevzVar) {
        return new zzevv(zzevzVar);
    }

    /* JADX INFO: renamed from: a */
    public final zzevv m8530a(int i) {
        this.f7824j = Integer.valueOf(i);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final zzevv m8531a(long j) {
        this.f7821g = Long.valueOf(j);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final zzevv m8532a(String str) {
        if (str != null) {
            this.f7819e = zzewq.m8606a(zzewq.m8605a(str), 2000);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final Integer m8533a() {
        return this.f7824j;
    }

    /* JADX INFO: renamed from: b */
    public final zzevv m8534b() {
        this.f7823i = 1;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final zzevv m8535b(long j) {
        this.f7822h = Long.valueOf(j);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final zzevv m8536b(String str) {
        if (str != null) {
            switch (str.toUpperCase()) {
                case "GET":
                    this.f7820f = 1;
                    break;
                case "PUT":
                    this.f7820f = 2;
                    break;
                case "POST":
                    this.f7820f = 3;
                    break;
                case "DELETE":
                    this.f7820f = 4;
                    break;
                case "HEAD":
                    this.f7820f = 5;
                    break;
                case "PATCH":
                    this.f7820f = 6;
                    break;
                case "OPTIONS":
                    this.f7820f = 7;
                    break;
                case "TRACE":
                    this.f7820f = 8;
                    break;
                case "CONNECT":
                    this.f7820f = 9;
                    break;
                default:
                    this.f7820f = 0;
                    break;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final long m8537c() {
        return this.f7817c;
    }

    /* JADX INFO: renamed from: c */
    public final zzevv m8538c(long j) {
        this.f7826l = Long.valueOf(j);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final zzevv m8539c(String str) {
        if (str != null) {
            this.f7825k = str;
        }
        return this;
    }

    /* JADX INFO: renamed from: d */
    public final zzevv m8540d(long j) {
        this.f7827m = Long.valueOf(j);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public final zzewv m8541d() {
        m8558f();
        zzewv zzewvVar = new zzewv();
        zzewvVar.f7907a = this.f7819e;
        zzewvVar.f7908b = this.f7820f;
        zzewvVar.f7909c = this.f7821g;
        zzewvVar.f7910d = this.f7822h;
        zzewvVar.f7911e = this.f7823i;
        zzewvVar.f7912f = this.f7824j;
        zzewvVar.f7913g = this.f7825k;
        zzewvVar.f7914h = this.f7826l;
        zzewvVar.f7915i = this.f7827m;
        zzewvVar.f7916j = this.f7828n;
        zzewvVar.f7917k = this.f7829o;
        zzewvVar.f7918l = this.f7830p;
        if (!this.f7816b) {
            if (this.f7815a != null) {
                this.f7815a.m8570a(zzewvVar, m8559g());
            }
            this.f7816b = true;
        } else if (this.f7818d) {
            Log.i("FirebasePerformance", "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
        }
        return zzewvVar;
    }

    /* JADX INFO: renamed from: e */
    public final zzevv m8542e(long j) {
        this.f7817c = j;
        this.f7828n = Long.valueOf(j);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public final zzevv m8543f(long j) {
        this.f7829o = Long.valueOf(j);
        return this;
    }
}
