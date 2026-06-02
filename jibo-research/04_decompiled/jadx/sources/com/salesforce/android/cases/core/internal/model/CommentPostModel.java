package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ActorResponse;
import com.salesforce.android.cases.core.internal.http.response.BodyResponse;
import com.salesforce.android.cases.core.internal.http.response.CommentPostResponse;
import com.salesforce.android.cases.core.internal.http.response.PhotoResponse;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.model.Actor;
import com.salesforce.android.cases.core.model.Body;
import com.salesforce.android.cases.core.model.CommentPost;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class CommentPostModel implements CommentPost {

    /* JADX INFO: renamed from: a */
    private ActorModel f12465a;

    /* JADX INFO: renamed from: b */
    private BodyModel f12466b;

    /* JADX INFO: renamed from: c */
    private Date f12467c;

    /* JADX INFO: renamed from: d */
    private String f12468d;

    /* JADX INFO: renamed from: e */
    private Date f12469e;

    /* JADX INFO: renamed from: f */
    private String f12470f;

    /* JADX INFO: renamed from: g */
    private String f12471g;

    /* JADX INFO: renamed from: h */
    private String f12472h;

    /* JADX INFO: renamed from: i */
    private String f12473i;

    /* JADX INFO: renamed from: a */
    public static CommentPostModel m12473a(CommentPostResponse commentPostResponse) {
        return new CommentPostModel(commentPostResponse);
    }

    public CommentPostModel(CommentPostResponse commentPostResponse) {
        if (commentPostResponse == null) {
            throw new IllegalArgumentException("CommentPostResponse cannot be null");
        }
        if (commentPostResponse.m12314a() != null) {
            this.f12465a = new ActorModel(commentPostResponse.m12314a());
        }
        if (commentPostResponse.m12315b() != null) {
            this.f12466b = new BodyModel(commentPostResponse.m12315b());
        }
        this.f12467c = DateUtils.m12608a(commentPostResponse.m12316c());
        this.f12468d = commentPostResponse.m12317d();
        this.f12469e = DateUtils.m12608a(commentPostResponse.m12318e());
        this.f12470f = commentPostResponse.m12319f();
        this.f12471g = commentPostResponse.m12320g();
        this.f12472h = commentPostResponse.m12321h();
        this.f12473i = commentPostResponse.m12322i();
    }

    @Override // com.salesforce.android.cases.core.model.CommentPost
    /* JADX INFO: renamed from: a */
    public Body mo12474a() {
        return this.f12466b;
    }

    @Override // com.salesforce.android.cases.core.model.CommentPost
    /* JADX INFO: renamed from: b */
    public Date mo12475b() {
        return this.f12467c;
    }

    public class ActorModel implements Actor {

        /* JADX INFO: renamed from: b */
        private String f12475b;

        /* JADX INFO: renamed from: c */
        private String f12476c;

        /* JADX INFO: renamed from: d */
        private String f12477d;

        /* JADX INFO: renamed from: e */
        private String f12478e;

        /* JADX INFO: renamed from: f */
        private boolean f12479f;

        /* JADX INFO: renamed from: g */
        private boolean f12480g;

        /* JADX INFO: renamed from: h */
        private String f12481h;

        /* JADX INFO: renamed from: i */
        private PhotoModel f12482i;

        /* JADX INFO: renamed from: j */
        private String f12483j;

        /* JADX INFO: renamed from: k */
        private String f12484k;

        private ActorModel(ActorResponse actorResponse) {
            this.f12475b = actorResponse.m12244a();
            this.f12476c = actorResponse.m12245b();
            this.f12477d = actorResponse.m12246c();
            this.f12478e = actorResponse.m12247d();
            this.f12479f = actorResponse.m12248e();
            this.f12480g = actorResponse.m12249f();
            this.f12481h = actorResponse.m12250g();
            if (actorResponse.m12251h() != null) {
                this.f12482i = new PhotoModel(actorResponse.m12251h());
            }
            this.f12483j = actorResponse.m12252i();
            this.f12484k = actorResponse.m12253j();
        }

        @Override // com.salesforce.android.cases.core.model.Actor
        /* JADX INFO: renamed from: a */
        public String mo12438a() {
            return this.f12476c;
        }

        @Override // com.salesforce.android.cases.core.model.Actor
        /* JADX INFO: renamed from: b */
        public String mo12439b() {
            return this.f12478e;
        }
    }

    public class PhotoModel {

        /* JADX INFO: renamed from: b */
        private String f12489b;

        /* JADX INFO: renamed from: c */
        private String f12490c;

        /* JADX INFO: renamed from: d */
        private String f12491d;

        /* JADX INFO: renamed from: e */
        private String f12492e;

        /* JADX INFO: renamed from: f */
        private String f12493f;

        /* JADX INFO: renamed from: g */
        private String f12494g;

        private PhotoModel(PhotoResponse photoResponse) {
            this.f12489b = photoResponse.m12340a();
            this.f12490c = photoResponse.m12341b();
            this.f12491d = photoResponse.m12342c();
            this.f12492e = photoResponse.m12343d();
            this.f12493f = photoResponse.m12344e();
            this.f12494g = photoResponse.m12345f();
        }
    }

    public class BodyModel implements Body {

        /* JADX INFO: renamed from: b */
        private boolean f12486b;

        /* JADX INFO: renamed from: c */
        private String f12487c;

        private BodyModel(BodyResponse bodyResponse) {
            this.f12486b = bodyResponse.m12254a();
            this.f12487c = bodyResponse.m12255b();
        }

        @Override // com.salesforce.android.cases.core.model.Body
        /* JADX INFO: renamed from: a */
        public String mo12440a() {
            return this.f12487c;
        }
    }
}
