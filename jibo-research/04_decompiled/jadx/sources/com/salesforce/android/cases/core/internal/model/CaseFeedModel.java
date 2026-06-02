package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ActorResponse;
import com.salesforce.android.cases.core.internal.http.response.BodyResponse;
import com.salesforce.android.cases.core.internal.http.response.CaseFeedResponse;
import com.salesforce.android.cases.core.internal.http.response.PhotoResponse;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.model.Actor;
import com.salesforce.android.cases.core.model.Body;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.Element;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedModel implements CaseFeed {

    /* JADX INFO: renamed from: a */
    private String f12407a;

    /* JADX INFO: renamed from: b */
    private List<ElementModel> f12408b;

    /* JADX INFO: renamed from: c */
    private String f12409c;

    /* JADX INFO: renamed from: d */
    private String f12410d;

    /* JADX INFO: renamed from: a */
    public static CaseFeedModel m12436a(CaseFeedResponse caseFeedResponse) {
        return new CaseFeedModel(caseFeedResponse);
    }

    CaseFeedModel(CaseFeedResponse caseFeedResponse) {
        if (caseFeedResponse == null) {
            throw new IllegalArgumentException("CaseFeedResponse cannot be null");
        }
        this.f12407a = caseFeedResponse.m12290a();
        this.f12409c = caseFeedResponse.m12292c();
        this.f12410d = caseFeedResponse.m12293d();
        this.f12408b = new ArrayList();
        for (CaseFeedResponse.Element element : caseFeedResponse.m12291b()) {
            if (element != null) {
                this.f12408b.add(new ElementModel(element));
            }
        }
    }

    @Override // com.salesforce.android.cases.core.model.CaseFeed
    /* JADX INFO: renamed from: a */
    public List<? extends Element> mo12437a() {
        return this.f12408b == null ? Collections.emptyList() : Collections.unmodifiableList(this.f12408b);
    }

    public class ElementModel implements Element {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ CaseFeedModel f12425a;

        /* JADX INFO: renamed from: b */
        private ActorModel f12426b;

        /* JADX INFO: renamed from: c */
        private BodyModel f12427c;

        /* JADX INFO: renamed from: d */
        private Date f12428d;

        /* JADX INFO: renamed from: e */
        private String f12429e;

        /* JADX INFO: renamed from: f */
        private Date f12430f;

        /* JADX INFO: renamed from: g */
        private String f12431g;

        /* JADX INFO: renamed from: h */
        private String f12432h;

        /* JADX INFO: renamed from: i */
        private String f12433i;

        /* JADX INFO: renamed from: j */
        private String f12434j;

        private ElementModel(CaseFeedModel caseFeedModel, CaseFeedResponse.Element element) {
            this.f12425a = caseFeedModel;
            if (element.m12294a() != null) {
                this.f12426b = new ActorModel(element.m12294a());
            }
            if (element.m12295b() != null) {
                this.f12427c = new BodyModel(element.m12295b());
            }
            this.f12428d = DateUtils.m12608a(element.m12296c());
            this.f12429e = element.m12297d();
            this.f12430f = DateUtils.m12608a(element.m12298e());
            this.f12431g = element.m12299f();
            this.f12432h = element.m12300g();
            this.f12433i = element.m12301h();
            this.f12434j = element.m12302i();
        }

        @Override // com.salesforce.android.cases.core.model.Element
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActorModel mo12445e() {
            return this.f12426b;
        }

        @Override // com.salesforce.android.cases.core.model.Element
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BodyModel mo12444d() {
            return this.f12427c;
        }

        @Override // com.salesforce.android.cases.core.model.Element
        /* JADX INFO: renamed from: c */
        public Date mo12443c() {
            return this.f12428d;
        }
    }

    public class ActorModel implements Actor {

        /* JADX INFO: renamed from: b */
        private String f12412b;

        /* JADX INFO: renamed from: c */
        private String f12413c;

        /* JADX INFO: renamed from: d */
        private String f12414d;

        /* JADX INFO: renamed from: e */
        private String f12415e;

        /* JADX INFO: renamed from: f */
        private boolean f12416f;

        /* JADX INFO: renamed from: g */
        private boolean f12417g;

        /* JADX INFO: renamed from: h */
        private String f12418h;

        /* JADX INFO: renamed from: i */
        private PhotoModel f12419i;

        /* JADX INFO: renamed from: j */
        private String f12420j;

        /* JADX INFO: renamed from: k */
        private String f12421k;

        private ActorModel(ActorResponse actorResponse) {
            this.f12412b = actorResponse.m12244a();
            this.f12413c = actorResponse.m12245b();
            this.f12414d = actorResponse.m12246c();
            this.f12415e = actorResponse.m12247d();
            this.f12416f = actorResponse.m12248e();
            this.f12417g = actorResponse.m12249f();
            this.f12418h = actorResponse.m12250g();
            if (actorResponse.m12251h() != null) {
                this.f12419i = new PhotoModel(actorResponse.m12251h());
            }
            this.f12420j = actorResponse.m12252i();
            this.f12421k = actorResponse.m12253j();
        }

        @Override // com.salesforce.android.cases.core.model.Actor
        /* JADX INFO: renamed from: a */
        public String mo12438a() {
            return this.f12413c;
        }

        @Override // com.salesforce.android.cases.core.model.Actor
        /* JADX INFO: renamed from: b */
        public String mo12439b() {
            return this.f12415e;
        }
    }

    public class PhotoModel {

        /* JADX INFO: renamed from: b */
        private String f12436b;

        /* JADX INFO: renamed from: c */
        private String f12437c;

        /* JADX INFO: renamed from: d */
        private String f12438d;

        /* JADX INFO: renamed from: e */
        private String f12439e;

        /* JADX INFO: renamed from: f */
        private String f12440f;

        /* JADX INFO: renamed from: g */
        private String f12441g;

        private PhotoModel(PhotoResponse photoResponse) {
            this.f12436b = photoResponse.m12340a();
            this.f12437c = photoResponse.m12341b();
            this.f12438d = photoResponse.m12342c();
            this.f12439e = photoResponse.m12343d();
            this.f12440f = photoResponse.m12344e();
            this.f12441g = photoResponse.m12345f();
        }
    }

    public class BodyModel implements Body {

        /* JADX INFO: renamed from: b */
        private boolean f12423b;

        /* JADX INFO: renamed from: c */
        private String f12424c;

        private BodyModel(BodyResponse bodyResponse) {
            this.f12423b = bodyResponse.m12254a();
            this.f12424c = bodyResponse.m12255b();
        }

        @Override // com.salesforce.android.cases.core.model.Body
        /* JADX INFO: renamed from: a */
        public String mo12440a() {
            return this.f12424c;
        }
    }
}
