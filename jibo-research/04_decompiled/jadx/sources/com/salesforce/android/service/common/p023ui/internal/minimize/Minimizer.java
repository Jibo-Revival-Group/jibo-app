package com.salesforce.android.service.common.p023ui.internal.minimize;

import android.app.Activity;
import android.content.Context;
import com.salesforce.android.service.common.p023ui.internal.minimize.MinimizedViewManager;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Minimizer {

    /* JADX INFO: renamed from: a */
    static final Set<Class<? extends Activity>> f13725a = new HashSet();

    /* JADX INFO: renamed from: b */
    private MinimizeListener f13726b;

    /* JADX INFO: renamed from: c */
    private final MinimizedViewManager f13727c;

    Minimizer(Builder builder) {
        this.f13727c = builder.f13728a;
        this.f13726b = builder.f13729b;
    }

    /* JADX INFO: renamed from: a */
    public boolean m13991a() {
        return this.f13727c.m13980a();
    }

    /* JADX INFO: renamed from: b */
    public void m13992b() {
        if (!m13991a() && this.f13726b != null) {
            this.f13727c.m13979a(this);
            this.f13726b.mo13618c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m13990a(Context context) {
        if (m13991a() && this.f13726b != null) {
            this.f13726b.mo13617b(context);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m13993c() {
        this.f13727c.m13981b();
    }

    /* JADX INFO: renamed from: d */
    public void m13994d() {
        this.f13727c.m13983c();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        MinimizedViewManager f13728a;

        /* JADX INFO: renamed from: b */
        MinimizeListener f13729b;

        /* JADX INFO: renamed from: c */
        ActivityTracker f13730c;

        /* JADX INFO: renamed from: d */
        Set<Class<? extends Activity>> f13731d = new HashSet();

        /* JADX INFO: renamed from: a */
        public Builder m13996a(ActivityTracker activityTracker) {
            this.f13730c = activityTracker;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13995a(MinimizeListener minimizeListener) {
            this.f13729b = minimizeListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Minimizer m13997a() {
            Arguments.m14236a(this.f13730c, "Activity tracker must be provided to the Minimizer");
            if (this.f13728a == null) {
                this.f13728a = new MinimizedViewManager.Builder().m13987a(this.f13730c).m13986a(this.f13729b).m13988a(this.f13731d).m13989a();
            }
            return new Minimizer(this);
        }
    }
}
