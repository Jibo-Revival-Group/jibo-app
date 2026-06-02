package com.salesforce.android.knowledge.p022ui.internal.minimize;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;

/* JADX INFO: loaded from: classes.dex */
public class MinimizeContext {

    /* JADX INFO: renamed from: a */
    final Drawable f13357a;

    /* JADX INFO: renamed from: b */
    final ArticleSummary f13358b;

    /* JADX INFO: renamed from: a */
    public static MinimizeContext m13607a(Drawable drawable, ArticleSummary articleSummary) {
        if (drawable != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        return new MinimizeContext(drawable, articleSummary);
    }

    private MinimizeContext(Drawable drawable, ArticleSummary articleSummary) {
        this.f13357a = drawable;
        this.f13358b = articleSummary;
    }

    /* JADX INFO: renamed from: a */
    public Drawable m13608a() {
        return this.f13357a;
    }

    /* JADX INFO: renamed from: b */
    public String m13609b() {
        return this.f13358b.mo13219i();
    }

    /* JADX INFO: renamed from: c */
    public String m13610c() {
        return this.f13358b.mo13217g();
    }
}
