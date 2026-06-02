package com.salesforce.android.service.common.p023ui.internal.minimize;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.service.common.p023ui.internal.minimize.MinimizedViewHolder;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class MinimizedViewManager implements MinimizedViewHolder.Listener, ActivityTracker.OnPauseListener, ActivityTracker.OnResumeListener {

    /* JADX INFO: renamed from: a */
    MinimizeListener f13710a;

    /* JADX INFO: renamed from: b */
    final ActivityTracker f13711b;

    /* JADX INFO: renamed from: c */
    final MinimizedViewHolder.Factory f13712c;

    /* JADX INFO: renamed from: d */
    final Set<Class<? extends Activity>> f13713d;

    /* JADX INFO: renamed from: e */
    MinimizedViewHolder f13714e;

    /* JADX INFO: renamed from: f */
    Minimizer f13715f;

    /* JADX INFO: renamed from: g */
    Coordinate f13716g;

    /* JADX INFO: renamed from: h */
    ActivityReference<Activity> f13717h = ActivityReference.m14053a();

    MinimizedViewManager(Builder builder) {
        this.f13711b = builder.f13722b;
        this.f13710a = builder.f13721a;
        this.f13712c = builder.f13723c;
        this.f13713d = builder.f13724d;
    }

    /* JADX INFO: renamed from: a */
    void m13979a(Minimizer minimizer) {
        this.f13711b.m14059a((ActivityTracker.OnResumeListener) this);
        this.f13711b.m14058a((ActivityTracker.OnPauseListener) this);
        this.f13715f = minimizer;
    }

    /* JADX INFO: renamed from: a */
    void m13978a(Activity activity) {
        this.f13717h = ActivityReference.m14054a(activity);
    }

    /* JADX INFO: renamed from: a */
    boolean m13980a() {
        return this.f13714e != null && this.f13717h.m14100b();
    }

    /* JADX INFO: renamed from: b */
    void m13981b() {
        m13976a((MinimizedViewHolder) null);
        m13977d();
    }

    /* JADX INFO: renamed from: c */
    void m13983c() {
        m13981b();
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnResumeListener
    /* JADX INFO: renamed from: b */
    public void mo13982b(Activity activity) {
        m13978a(activity);
        if (activity != null && !this.f13713d.contains(activity.getClass()) && !Minimizer.f13725a.contains(activity.getClass())) {
            m13985d(activity);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnPauseListener
    /* JADX INFO: renamed from: c */
    public void mo13984c(Activity activity) {
        if (this.f13717h.m14098a(activity) && this.f13714e != null) {
            this.f13714e.m13964b();
            this.f13714e = null;
        }
        this.f13717h.m14099b(activity);
    }

    @Override // com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.Listener
    /* JADX INFO: renamed from: a */
    public void mo13971a(View view) {
        if (this.f13710a != null) {
            final ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.removeAllViews();
            this.f13717h.m14097a(new Consumer<Activity>() { // from class: com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewManager.1
                @Override // com.salesforce.android.service.common.utilities.functional.Consumer
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo13033a(Activity activity) {
                    MinimizedViewManager.this.f13710a.mo13612a(viewGroup, activity);
                }
            });
        }
    }

    @Override // com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.Listener
    /* JADX INFO: renamed from: b */
    public void mo13972b(View view) {
        if (this.f13715f != null) {
            this.f13717h.m14097a(new Consumer<Activity>() { // from class: com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewManager.2
                @Override // com.salesforce.android.service.common.utilities.functional.Consumer
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo13033a(Activity activity) {
                    MinimizedViewManager.this.f13715f.m13990a(activity);
                }
            });
        }
    }

    @Override // com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.Listener
    /* JADX INFO: renamed from: c */
    public void mo13973c(View view) {
        if (this.f13710a != null) {
            this.f13710a.mo13619d();
        }
    }

    @Override // com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.Listener
    /* JADX INFO: renamed from: d */
    public void mo13974d(View view) {
        if (this.f13716g != null && this.f13714e != null) {
            Coordinate coordinateM13975a = m13975a(this.f13716g, this.f13714e);
            if (!coordinateM13975a.equals(this.f13716g)) {
                this.f13716g = coordinateM13975a;
                if (this.f13714e != null) {
                    this.f13714e.m13963a(coordinateM13975a);
                }
            }
        }
    }

    @Override // com.salesforce.android.service.common.ui.internal.minimize.MinimizeViewDrag.Listener
    /* JADX INFO: renamed from: a */
    public void mo13960a(Coordinate coordinate) {
        if (this.f13714e != null) {
            this.f13716g = m13975a(coordinate, this.f13714e);
            if (!this.f13716g.equals(coordinate)) {
                this.f13714e.m13965b(this.f13716g);
            }
            this.f13710a.mo13614a(coordinate);
        }
    }

    /* JADX INFO: renamed from: d */
    void m13985d(Activity activity) {
        MinimizedViewHolder minimizedViewHolderM13970a = this.f13712c.m13970a(activity, this);
        minimizedViewHolderM13970a.m13962a(activity, this.f13716g);
        m13976a(minimizedViewHolderM13970a);
    }

    /* JADX INFO: renamed from: a */
    private void m13976a(MinimizedViewHolder minimizedViewHolder) {
        if (this.f13714e != null) {
            this.f13714e.m13964b();
        }
        this.f13714e = minimizedViewHolder;
    }

    /* JADX INFO: renamed from: d */
    private void m13977d() {
        this.f13711b.m14069b((ActivityTracker.OnResumeListener) this);
        this.f13711b.m14068b((ActivityTracker.OnPauseListener) this);
        this.f13717h.clear();
        this.f13715f = null;
    }

    /* JADX INFO: renamed from: a */
    static Coordinate m13975a(Coordinate coordinate, MinimizedViewHolder minimizedViewHolder) {
        ViewGroup viewGroupM13966c = minimizedViewHolder.m13966c();
        ViewGroup viewGroupM13967d = minimizedViewHolder.m13967d();
        int iMax = Math.max(coordinate.m14209a(), 0);
        int iMax2 = Math.max(coordinate.m14210b(), 0);
        if (viewGroupM13967d.getWidth() + iMax > viewGroupM13966c.getWidth()) {
            iMax = viewGroupM13966c.getWidth() - viewGroupM13967d.getWidth();
        }
        if (viewGroupM13967d.getHeight() + iMax2 > viewGroupM13966c.getHeight()) {
            iMax2 = viewGroupM13966c.getHeight() - viewGroupM13967d.getHeight();
        }
        return (iMax == coordinate.m14209a() && iMax2 == coordinate.m14210b()) ? coordinate : Coordinate.m14208a(iMax, iMax2);
    }

    static class Builder {

        /* JADX INFO: renamed from: a */
        MinimizeListener f13721a;

        /* JADX INFO: renamed from: b */
        ActivityTracker f13722b;

        /* JADX INFO: renamed from: c */
        MinimizedViewHolder.Factory f13723c = new MinimizedViewHolder.Factory();

        /* JADX INFO: renamed from: d */
        Set<Class<? extends Activity>> f13724d = new HashSet();

        Builder() {
        }

        /* JADX INFO: renamed from: a */
        Builder m13987a(ActivityTracker activityTracker) {
            this.f13722b = activityTracker;
            return this;
        }

        /* JADX INFO: renamed from: a */
        Builder m13986a(MinimizeListener minimizeListener) {
            this.f13721a = minimizeListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        Builder m13988a(Set<Class<? extends Activity>> set) {
            this.f13724d.addAll(set);
            return this;
        }

        /* JADX INFO: renamed from: a */
        MinimizedViewManager m13989a() {
            Arguments.m14236a(this.f13722b, "ActivityTracker must be provided to the MinimizedViewManager");
            return new MinimizedViewManager(this);
        }
    }
}
