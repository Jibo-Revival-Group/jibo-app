package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CaseDetailResponse;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CaseDetailRecordModel implements CaseDetailRecord {

    /* JADX INFO: renamed from: A */
    private String f12374A;

    /* JADX INFO: renamed from: B */
    private Date f12375B;

    /* JADX INFO: renamed from: C */
    private Date f12376C;

    /* JADX INFO: renamed from: D */
    private String f12377D;

    /* JADX INFO: renamed from: E */
    private String f12378E;

    /* JADX INFO: renamed from: F */
    private String f12379F;

    /* JADX INFO: renamed from: G */
    private Map<String, String> f12380G;

    /* JADX INFO: renamed from: a */
    private String f12381a;

    /* JADX INFO: renamed from: b */
    private boolean f12382b;

    /* JADX INFO: renamed from: c */
    private String f12383c;

    /* JADX INFO: renamed from: d */
    private String f12384d;

    /* JADX INFO: renamed from: e */
    private String f12385e;

    /* JADX INFO: renamed from: f */
    private String f12386f;

    /* JADX INFO: renamed from: g */
    private String f12387g;

    /* JADX INFO: renamed from: h */
    private String f12388h;

    /* JADX INFO: renamed from: i */
    private String f12389i;

    /* JADX INFO: renamed from: j */
    private String f12390j;

    /* JADX INFO: renamed from: k */
    private String f12391k;

    /* JADX INFO: renamed from: l */
    private String f12392l;

    /* JADX INFO: renamed from: m */
    private String f12393m;

    /* JADX INFO: renamed from: n */
    private String f12394n;

    /* JADX INFO: renamed from: o */
    private String f12395o;

    /* JADX INFO: renamed from: p */
    private String f12396p;

    /* JADX INFO: renamed from: q */
    private String f12397q;

    /* JADX INFO: renamed from: r */
    private boolean f12398r;

    /* JADX INFO: renamed from: s */
    private Date f12399s;

    /* JADX INFO: renamed from: t */
    private boolean f12400t;

    /* JADX INFO: renamed from: u */
    private boolean f12401u;

    /* JADX INFO: renamed from: v */
    private boolean f12402v;

    /* JADX INFO: renamed from: w */
    private String f12403w;

    /* JADX INFO: renamed from: x */
    private Date f12404x;

    /* JADX INFO: renamed from: y */
    private String f12405y;

    /* JADX INFO: renamed from: z */
    private Date f12406z;

    CaseDetailRecordModel(CaseDetailResponse caseDetailResponse) {
        if (caseDetailResponse == null) {
            throw new IllegalArgumentException("CaseDetailResponse cannot be null");
        }
        this.f12381a = caseDetailResponse.m12263a();
        this.f12382b = caseDetailResponse.m12265b();
        this.f12383c = caseDetailResponse.m12266c();
        this.f12384d = caseDetailResponse.m12267d();
        this.f12385e = caseDetailResponse.m12268e();
        this.f12386f = caseDetailResponse.m12269f();
        this.f12387g = caseDetailResponse.m12270g();
        this.f12388h = caseDetailResponse.m12271h();
        this.f12389i = caseDetailResponse.m12272i();
        this.f12390j = caseDetailResponse.m12273j();
        this.f12391k = caseDetailResponse.m12274k();
        this.f12392l = caseDetailResponse.m12275l();
        this.f12393m = caseDetailResponse.m12276m();
        this.f12394n = caseDetailResponse.m12277n();
        this.f12395o = caseDetailResponse.m12278o();
        this.f12396p = caseDetailResponse.m12279p();
        this.f12397q = caseDetailResponse.m12280q();
        this.f12398r = caseDetailResponse.m12281r();
        this.f12399s = caseDetailResponse.m12282s();
        this.f12400t = caseDetailResponse.m12283t();
        this.f12401u = caseDetailResponse.m12284u();
        this.f12402v = caseDetailResponse.m12285v();
        this.f12403w = caseDetailResponse.m12286w();
        this.f12404x = caseDetailResponse.m12287x();
        this.f12405y = caseDetailResponse.m12288y();
        this.f12406z = caseDetailResponse.m12289z();
        this.f12374A = caseDetailResponse.m12256A();
        this.f12375B = caseDetailResponse.m12257B();
        this.f12376C = caseDetailResponse.m12258C();
        this.f12377D = caseDetailResponse.m12259D();
        this.f12378E = caseDetailResponse.m12260E();
        this.f12379F = caseDetailResponse.m12261F();
        this.f12380G = caseDetailResponse.m12262G();
    }

    /* JADX INFO: renamed from: a */
    public static CaseDetailRecordModel m12407a(CaseDetailResponse caseDetailResponse) {
        return new CaseDetailRecordModel(caseDetailResponse);
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: a */
    public String mo12410a() {
        return this.f12381a;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: b */
    public String mo12411b() {
        return this.f12383c;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: c */
    public String mo12412c() {
        return this.f12384d;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: d */
    public String mo12413d() {
        return this.f12385e;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: e */
    public String mo12414e() {
        return this.f12386f;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: f */
    public String mo12415f() {
        return this.f12387g;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: g */
    public String mo12416g() {
        return this.f12388h;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: h */
    public String mo12417h() {
        return this.f12389i;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: i */
    public String mo12418i() {
        return this.f12390j;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: j */
    public String mo12419j() {
        return this.f12391k;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: k */
    public String mo12420k() {
        return this.f12392l;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: l */
    public String mo12421l() {
        return this.f12393m;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: m */
    public String mo12422m() {
        return this.f12394n;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: n */
    public String mo12423n() {
        return this.f12395o;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: o */
    public String mo12424o() {
        return this.f12396p;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: p */
    public String mo12425p() {
        return this.f12397q;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: q */
    public Date mo12426q() {
        return this.f12399s;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: r */
    public String mo12427r() {
        return this.f12403w;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: s */
    public Date mo12428s() {
        return this.f12404x;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: t */
    public String mo12429t() {
        return this.f12405y;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: u */
    public Date mo12430u() {
        return this.f12406z;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: v */
    public String mo12431v() {
        return this.f12374A;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: w */
    public Date mo12432w() {
        return this.f12375B;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: x */
    public Date mo12433x() {
        return this.f12376C;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: y */
    public String mo12434y() {
        return this.f12377D;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: z */
    public String mo12435z() {
        return this.f12378E;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: A */
    public String mo12408A() {
        return this.f12379F;
    }

    @Override // com.salesforce.android.cases.core.model.CaseDetailRecord
    /* JADX INFO: renamed from: B */
    public Map<String, String> mo12409B() {
        return this.f12380G;
    }
}
