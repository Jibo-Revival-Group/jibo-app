package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.jibo.aws.integration.helpers.RobotHelper;

/* JADX INFO: loaded from: classes.dex */
public final class zzchk extends zzcjl {

    /* JADX INFO: renamed from: a */
    private static String[] f7216a = new String[AppMeasurement.Event.f8390a.length];

    /* JADX INFO: renamed from: b */
    private static String[] f7217b = new String[AppMeasurement.Param.f8392a.length];

    /* JADX INFO: renamed from: c */
    private static String[] f7218c = new String[AppMeasurement.UserProperty.f8394a.length];

    zzchk(zzcim zzcimVar) {
        super(zzcimVar);
    }

    /* JADX INFO: renamed from: a */
    private final String m8073a(zzcgx zzcgxVar) {
        if (zzcgxVar == null) {
            return null;
        }
        return !m8083y() ? zzcgxVar.toString() : m8084a(zzcgxVar.m8031b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        return r4;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String m8074a(java.lang.String r4, java.lang.String[] r5, java.lang.String[] r6, java.lang.String[] r7) {
        /*
            r1 = 1
            r2 = 0
            com.google.android.gms.common.internal.zzbq.m7373a(r5)
            com.google.android.gms.common.internal.zzbq.m7373a(r6)
            com.google.android.gms.common.internal.zzbq.m7373a(r7)
            int r0 = r5.length
            int r3 = r6.length
            if (r0 != r3) goto L4d
            r0 = r1
        L10:
            com.google.android.gms.common.internal.zzbq.m7382b(r0)
            int r0 = r5.length
            int r3 = r7.length
            if (r0 != r3) goto L4f
        L17:
            com.google.android.gms.common.internal.zzbq.m7382b(r1)
        L1a:
            int r0 = r5.length
            if (r2 >= r0) goto L4c
            r0 = r5[r2]
            boolean r0 = com.google.android.gms.internal.zzclq.m8396a(r4, r0)
            if (r0 == 0) goto L54
            monitor-enter(r7)
            r0 = r7[r2]     // Catch: java.lang.Throwable -> L51
            if (r0 != 0) goto L49
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r0.<init>()     // Catch: java.lang.Throwable -> L51
            r1 = r6[r2]     // Catch: java.lang.Throwable -> L51
            r0.append(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "("
            r0.append(r1)     // Catch: java.lang.Throwable -> L51
            r1 = r5[r2]     // Catch: java.lang.Throwable -> L51
            r0.append(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = ")"
            r0.append(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L51
            r7[r2] = r0     // Catch: java.lang.Throwable -> L51
        L49:
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L51
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L51
        L4c:
            return r4
        L4d:
            r0 = r2
            goto L10
        L4f:
            r1 = r2
            goto L17
        L51:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L51
            throw r0
        L54:
            int r2 = r2 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchk.m8074a(java.lang.String, java.lang.String[], java.lang.String[], java.lang.String[]):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    private static void m8075a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m8076a(StringBuilder sb, int i, zzclt zzcltVar) {
        if (zzcltVar == null) {
            return;
        }
        m8075a(sb, i);
        sb.append("filter {\n");
        m8079a(sb, i, "complement", zzcltVar.f7628c);
        m8079a(sb, i, "param_name", m8091b(zzcltVar.f7629d));
        int i2 = i + 1;
        zzclw zzclwVar = zzcltVar.f7626a;
        if (zzclwVar != null) {
            m8075a(sb, i2);
            sb.append("string_filter");
            sb.append(" {\n");
            if (zzclwVar.f7639a != null) {
                String str = "UNKNOWN_MATCH_TYPE";
                switch (zzclwVar.f7639a.intValue()) {
                    case 1:
                        str = "REGEXP";
                        break;
                    case 2:
                        str = "BEGINS_WITH";
                        break;
                    case 3:
                        str = "ENDS_WITH";
                        break;
                    case 4:
                        str = "PARTIAL";
                        break;
                    case 5:
                        str = "EXACT";
                        break;
                    case 6:
                        str = "IN_LIST";
                        break;
                }
                m8079a(sb, i2, "match_type", str);
            }
            m8079a(sb, i2, "expression", zzclwVar.f7640b);
            m8079a(sb, i2, "case_sensitive", zzclwVar.f7641c);
            if (zzclwVar.f7642d.length > 0) {
                m8075a(sb, i2 + 1);
                sb.append("expression_list {\n");
                for (String str2 : zzclwVar.f7642d) {
                    m8075a(sb, i2 + 2);
                    sb.append(str2);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            m8075a(sb, i2);
            sb.append("}\n");
        }
        m8077a(sb, i + 1, "number_filter", zzcltVar.f7627b);
        m8075a(sb, i);
        sb.append("}\n");
    }

    /* JADX INFO: renamed from: a */
    private final void m8077a(StringBuilder sb, int i, String str, zzclu zzcluVar) {
        if (zzcluVar == null) {
            return;
        }
        m8075a(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzcluVar.f7630a != null) {
            String str2 = "UNKNOWN_COMPARISON_TYPE";
            switch (zzcluVar.f7630a.intValue()) {
                case 1:
                    str2 = "LESS_THAN";
                    break;
                case 2:
                    str2 = "GREATER_THAN";
                    break;
                case 3:
                    str2 = "EQUAL";
                    break;
                case 4:
                    str2 = "BETWEEN";
                    break;
            }
            m8079a(sb, i, "comparison_type", str2);
        }
        m8079a(sb, i, "match_as_float", zzcluVar.f7631b);
        m8079a(sb, i, "comparison_value", zzcluVar.f7632c);
        m8079a(sb, i, "min_comparison_value", zzcluVar.f7633d);
        m8079a(sb, i, "max_comparison_value", zzcluVar.f7634e);
        m8075a(sb, i);
        sb.append("}\n");
    }

    /* JADX INFO: renamed from: a */
    private static void m8078a(StringBuilder sb, int i, String str, zzcmf zzcmfVar) {
        int i2 = 0;
        if (zzcmfVar == null) {
            return;
        }
        int i3 = i + 1;
        m8075a(sb, i3);
        sb.append(str);
        sb.append(" {\n");
        if (zzcmfVar.f7712b != null) {
            m8075a(sb, i3 + 1);
            sb.append("results: ");
            long[] jArr = zzcmfVar.f7712b;
            int length = jArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                Long lValueOf = Long.valueOf(jArr[i4]);
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(lValueOf);
                i4++;
                i5 = i6;
            }
            sb.append('\n');
        }
        if (zzcmfVar.f7711a != null) {
            m8075a(sb, i3 + 1);
            sb.append("status: ");
            long[] jArr2 = zzcmfVar.f7711a;
            int length2 = jArr2.length;
            int i7 = 0;
            while (i2 < length2) {
                Long lValueOf2 = Long.valueOf(jArr2[i2]);
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(lValueOf2);
                i2++;
                i7 = i8;
            }
            sb.append('\n');
        }
        m8075a(sb, i3);
        sb.append("}\n");
    }

    /* JADX INFO: renamed from: a */
    private static void m8079a(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        m8075a(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    /* JADX INFO: renamed from: a */
    private final void m8080a(StringBuilder sb, int i, zzcma[] zzcmaVarArr) {
        if (zzcmaVarArr == null) {
            return;
        }
        for (zzcma zzcmaVar : zzcmaVarArr) {
            if (zzcmaVar != null) {
                m8075a(sb, 2);
                sb.append("audience_membership {\n");
                m8079a(sb, 2, "audience_id", zzcmaVar.f7658a);
                m8079a(sb, 2, "new_audience", zzcmaVar.f7661d);
                m8078a(sb, 2, "current_data", zzcmaVar.f7659b);
                m8078a(sb, 2, "previous_data", zzcmaVar.f7660c);
                m8075a(sb, 2);
                sb.append("}\n");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m8081a(StringBuilder sb, int i, zzcmb[] zzcmbVarArr) {
        if (zzcmbVarArr == null) {
            return;
        }
        for (zzcmb zzcmbVar : zzcmbVarArr) {
            if (zzcmbVar != null) {
                m8075a(sb, 2);
                sb.append("event {\n");
                m8079a(sb, 2, "name", m8090a(zzcmbVar.f7664b));
                m8079a(sb, 2, "timestamp_millis", zzcmbVar.f7665c);
                m8079a(sb, 2, "previous_timestamp_millis", zzcmbVar.f7666d);
                m8079a(sb, 2, "count", zzcmbVar.f7667e);
                zzcmc[] zzcmcVarArr = zzcmbVar.f7663a;
                if (zzcmcVarArr != null) {
                    for (zzcmc zzcmcVar : zzcmcVarArr) {
                        if (zzcmcVar != null) {
                            m8075a(sb, 3);
                            sb.append("param {\n");
                            m8079a(sb, 3, "name", m8091b(zzcmcVar.f7669a));
                            m8079a(sb, 3, "string_value", zzcmcVar.f7670b);
                            m8079a(sb, 3, "int_value", zzcmcVar.f7671c);
                            m8079a(sb, 3, "double_value", zzcmcVar.f7672d);
                            m8075a(sb, 3);
                            sb.append("}\n");
                        }
                    }
                }
                m8075a(sb, 2);
                sb.append("}\n");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m8082a(StringBuilder sb, int i, zzcmg[] zzcmgVarArr) {
        if (zzcmgVarArr == null) {
            return;
        }
        for (zzcmg zzcmgVar : zzcmgVarArr) {
            if (zzcmgVar != null) {
                m8075a(sb, 2);
                sb.append("user_property {\n");
                m8079a(sb, 2, "set_timestamp_millis", zzcmgVar.f7714a);
                m8079a(sb, 2, "name", m8092c(zzcmgVar.f7715b));
                m8079a(sb, 2, "string_value", zzcmgVar.f7716c);
                m8079a(sb, 2, "int_value", zzcmgVar.f7717d);
                m8079a(sb, 2, "double_value", zzcmgVar.f7718e);
                m8075a(sb, 2);
                sb.append("}\n");
            }
        }
    }

    /* JADX INFO: renamed from: y */
    private final boolean m8083y() {
        return this.f7441p.m8233f().m8105a(3);
    }

    /* JADX INFO: renamed from: a */
    protected final String m8084a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!m8083y()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(m8091b(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    protected final String m8085a(zzcgv zzcgvVar) {
        if (zzcgvVar == null) {
            return null;
        }
        if (!m8083y()) {
            return zzcgvVar.toString();
        }
        return "Event{appId='" + zzcgvVar.f7138a + "', name='" + m8090a(zzcgvVar.f7139b) + "', params=" + m8073a(zzcgvVar.f7142e) + "}";
    }

    /* JADX INFO: renamed from: a */
    protected final String m8086a(zzcha zzchaVar) {
        if (zzchaVar == null) {
            return null;
        }
        if (!m8083y()) {
            return zzchaVar.toString();
        }
        return "origin=" + zzchaVar.f7158c + ",name=" + m8090a(zzchaVar.f7156a) + ",params=" + m8073a(zzchaVar.f7157b);
    }

    /* JADX INFO: renamed from: a */
    protected final String m8087a(zzcls zzclsVar) {
        if (zzclsVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        m8079a(sb, 0, "filter_id", zzclsVar.f7620a);
        m8079a(sb, 0, "event_name", m8090a(zzclsVar.f7621b));
        m8077a(sb, 1, "event_count_filter", zzclsVar.f7623d);
        sb.append("  filters {\n");
        for (zzclt zzcltVar : zzclsVar.f7622c) {
            m8076a(sb, 2, zzcltVar);
        }
        m8075a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    protected final String m8088a(zzclv zzclvVar) {
        if (zzclvVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        m8079a(sb, 0, "filter_id", zzclvVar.f7636a);
        m8079a(sb, 0, "property_name", m8092c(zzclvVar.f7637b));
        m8076a(sb, 1, zzclvVar.f7638c);
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    protected final String m8089a(zzcmd zzcmdVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzcmdVar.f7674a != null) {
            for (zzcme zzcmeVar : zzcmdVar.f7674a) {
                if (zzcmeVar != null && zzcmeVar != null) {
                    m8075a(sb, 1);
                    sb.append("bundle {\n");
                    m8079a(sb, 1, "protocol_version", zzcmeVar.f7685a);
                    m8079a(sb, 1, RobotHelper.FIELD_PLATFORM, zzcmeVar.f7693i);
                    m8079a(sb, 1, "gmp_version", zzcmeVar.f7701q);
                    m8079a(sb, 1, "uploading_gmp_version", zzcmeVar.f7702r);
                    m8079a(sb, 1, "config_version", zzcmeVar.f7680E);
                    m8079a(sb, 1, "gmp_app_id", zzcmeVar.f7709y);
                    m8079a(sb, 1, "app_id", zzcmeVar.f7699o);
                    m8079a(sb, 1, "app_version", zzcmeVar.f7700p);
                    m8079a(sb, 1, "app_version_major", zzcmeVar.f7678C);
                    m8079a(sb, 1, "firebase_instance_id", zzcmeVar.f7677B);
                    m8079a(sb, 1, "dev_cert_hash", zzcmeVar.f7706v);
                    m8079a(sb, 1, "app_store", zzcmeVar.f7698n);
                    m8079a(sb, 1, "upload_timestamp_millis", zzcmeVar.f7688d);
                    m8079a(sb, 1, "start_timestamp_millis", zzcmeVar.f7689e);
                    m8079a(sb, 1, "end_timestamp_millis", zzcmeVar.f7690f);
                    m8079a(sb, 1, "previous_bundle_start_timestamp_millis", zzcmeVar.f7691g);
                    m8079a(sb, 1, "previous_bundle_end_timestamp_millis", zzcmeVar.f7692h);
                    m8079a(sb, 1, "app_instance_id", zzcmeVar.f7705u);
                    m8079a(sb, 1, "resettable_device_id", zzcmeVar.f7703s);
                    m8079a(sb, 1, "device_id", zzcmeVar.f7679D);
                    m8079a(sb, 1, "limited_ad_tracking", zzcmeVar.f7704t);
                    m8079a(sb, 1, "os_version", zzcmeVar.f7694j);
                    m8079a(sb, 1, "device_model", zzcmeVar.f7695k);
                    m8079a(sb, 1, "user_default_language", zzcmeVar.f7696l);
                    m8079a(sb, 1, "time_zone_offset_minutes", zzcmeVar.f7697m);
                    m8079a(sb, 1, "bundle_sequential_index", zzcmeVar.f7707w);
                    m8079a(sb, 1, "service_upload", zzcmeVar.f7710z);
                    m8079a(sb, 1, "health_monitor", zzcmeVar.f7708x);
                    if (zzcmeVar.f7681F.longValue() != 0) {
                        m8079a(sb, 1, "android_id", zzcmeVar.f7681F);
                    }
                    m8082a(sb, 1, zzcmeVar.f7687c);
                    m8080a(sb, 1, zzcmeVar.f7676A);
                    m8081a(sb, 1, zzcmeVar.f7686b);
                    m8075a(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    protected final String m8090a(String str) {
        if (str == null) {
            return null;
        }
        return m8083y() ? m8074a(str, AppMeasurement.Event.f8391b, AppMeasurement.Event.f8390a, f7216a) : str;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: b */
    protected final String m8091b(String str) {
        if (str == null) {
            return null;
        }
        return m8083y() ? m8074a(str, AppMeasurement.Param.f8393b, AppMeasurement.Param.f8392a, f7217b) : str;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    /* JADX INFO: renamed from: c */
    protected final String m8092c(String str) {
        if (str == null) {
            return null;
        }
        if (!m8083y()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m8074a(str, AppMeasurement.UserProperty.f8395b, AppMeasurement.UserProperty.f8394a, f7218c);
        }
        return "experiment_id(" + str + ")";
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ zzcgk mo7857e() {
        return super.mo7857e();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ zzcjn mo7858f() {
        return super.mo7858f();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ zzchh mo7859g() {
        return super.mo7859g();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ zzcgu mo7860h() {
        return super.mo7860h();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ zzckg mo7861i() {
        return super.mo7861i();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ zzckc mo7862j() {
        return super.mo7862j();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ zzd mo7863k() {
        return super.mo7863k();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: l */
    public final /* bridge */ /* synthetic */ Context mo7864l() {
        return super.mo7864l();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: n */
    public final /* bridge */ /* synthetic */ zzcgo mo7866n() {
        return super.mo7866n();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: o */
    public final /* bridge */ /* synthetic */ zzchk mo7867o() {
        return super.mo7867o();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ zzclq mo7868p() {
        return super.mo7868p();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: q */
    public final /* bridge */ /* synthetic */ zzcig mo7869q() {
        return super.mo7869q();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ zzclf mo7870r() {
        return super.mo7870r();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: s */
    public final /* bridge */ /* synthetic */ zzcih mo7871s() {
        return super.mo7871s();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: t */
    public final /* bridge */ /* synthetic */ zzchm mo7872t() {
        return super.mo7872t();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: u */
    public final /* bridge */ /* synthetic */ zzchx mo7873u() {
        return super.mo7873u();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: v */
    public final /* bridge */ /* synthetic */ zzcgn mo7874v() {
        return super.mo7874v();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return false;
    }
}
