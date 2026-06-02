package com.salesforce.android.knowledge.p022ui.internal.minimize;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeListener;
import com.salesforce.android.service.common.p023ui.internal.minimize.Minimizer;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

/* JADX INFO: loaded from: classes.dex */
public class MinimizeControl implements MinimizeListener {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f13359a;

    /* JADX INFO: renamed from: b */
    private final KnowledgeUIClientImpl f13360b;

    /* JADX INFO: renamed from: c */
    private final Minimizer f13361c;

    /* JADX INFO: renamed from: d */
    private MinimizeContext f13362d;

    static {
        f13359a = !MinimizeControl.class.desiredAssertionStatus();
    }

    public MinimizeControl(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        this.f13360b = knowledgeUIClientImpl;
        this.f13361c = new Minimizer.Builder().m13995a(this).m13996a(knowledgeUIClientImpl.m13536k()).m13997a();
    }

    /* JADX INFO: renamed from: a */
    public void m13613a(MinimizeContext minimizeContext) {
        if (!m13615a()) {
            this.f13362d = minimizeContext;
            KnowledgeUIAnalyticsEmit.m13381i(minimizeContext.m13610c(), minimizeContext.m13609b());
            this.f13361c.m13992b();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m13611a(Context context) {
        this.f13361c.m13990a(context);
    }

    /* JADX INFO: renamed from: a */
    public boolean m13615a() {
        return this.f13361c.m13991a();
    }

    /* JADX INFO: renamed from: b */
    public void m13616b() {
        this.f13361c.m13994d();
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeListener
    /* JADX INFO: renamed from: c */
    public void mo13618c() {
        this.f13360b.m13537l();
        KnowledgeUIAnalyticsEmit.m13376g();
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeListener
    /* JADX INFO: renamed from: b */
    public void mo13617b(Context context) {
        if (!f13359a && this.f13362d == null) {
            throw new AssertionError();
        }
        KnowledgeUIAnalyticsEmit.m13379h(this.f13362d.m13610c(), this.f13362d.m13609b());
        this.f13360b.m13527a(context);
        this.f13361c.m13993c();
        KnowledgeUIAnalyticsEmit.m13374f();
        this.f13362d = null;
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeListener
    /* JADX INFO: renamed from: d */
    public void mo13619d() {
        this.f13360b.m13539n();
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeListener
    /* JADX INFO: renamed from: a */
    public void mo13612a(ViewGroup viewGroup, Context context) {
        if (!f13359a && this.f13362d == null) {
            throw new AssertionError();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.knowledge_minimized_view_content, viewGroup);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.knowledge_minview_image);
        Drawable drawableM13608a = this.f13362d.m13608a();
        imageView.setImageDrawable(drawableM13608a);
        imageView.setVisibility(drawableM13608a == null ? 8 : 0);
        ((TextView) viewInflate.findViewById(R.id.knowledge_minview_label)).setText(this.f13362d.m13609b());
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeListener
    /* JADX INFO: renamed from: a */
    public void mo13614a(Coordinate coordinate) {
        KnowledgeUIAnalyticsEmit.m13384k();
    }
}
