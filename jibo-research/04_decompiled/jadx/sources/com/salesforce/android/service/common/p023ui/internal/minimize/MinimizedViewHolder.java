package com.salesforce.android.service.common.p023ui.internal.minimize;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.p023ui.internal.minimize.MinimizeViewDrag;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

/* JADX INFO: loaded from: classes.dex */
class MinimizedViewHolder {

    /* JADX INFO: renamed from: f */
    private static final ServiceLogger f13694f = ServiceLogging.m14203a((Class<?>) MinimizedViewHolder.class);

    /* JADX INFO: renamed from: a */
    final ViewGroup f13695a;

    /* JADX INFO: renamed from: b */
    final ViewGroup f13696b;

    /* JADX INFO: renamed from: c */
    final View f13697c;

    /* JADX INFO: renamed from: d */
    final Listener f13698d;

    /* JADX INFO: renamed from: e */
    final MinimizeViewDrag f13699e;

    interface Listener extends MinimizeViewDrag.Listener {
        /* JADX INFO: renamed from: a */
        void mo13971a(View view);

        /* JADX INFO: renamed from: b */
        void mo13972b(View view);

        /* JADX INFO: renamed from: c */
        void mo13973c(View view);

        /* JADX INFO: renamed from: d */
        void mo13974d(View view);
    }

    MinimizedViewHolder(Builder builder) {
        this.f13695a = builder.f13705a;
        this.f13696b = builder.f13706b;
        this.f13698d = builder.f13708d;
        this.f13699e = builder.f13709e;
        this.f13697c = builder.f13707c;
        m13961a();
    }

    /* JADX INFO: renamed from: a */
    void m13961a() {
        this.f13696b.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(final View view) {
                view.post(new Runnable() { // from class: com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MinimizedViewHolder.this.f13698d.mo13974d(view);
                    }
                });
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                MinimizedViewHolder.this.f13696b.removeOnAttachStateChangeListener(this);
                MinimizedViewHolder.this.f13696b.setOnClickListener(null);
                MinimizedViewHolder.this.f13699e.m13955a();
            }
        });
        this.f13696b.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MinimizedViewHolder.this.f13698d.mo13972b(view);
            }
        });
        this.f13695a.findViewById(R.id.common_minview_close).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MinimizedViewHolder.this.f13698d.mo13973c(view);
            }
        });
        this.f13698d.mo13971a(this.f13697c);
    }

    /* JADX INFO: renamed from: a */
    void m13962a(Activity activity, Coordinate coordinate) {
        m13964b();
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        if (viewGroup != null) {
            viewGroup.addView(this.f13695a);
        } else {
            f13694f.mo14193d("Couldn't find android.R.id.content in {}. Are you calling Activity.setContentView and AppCompatDelegate.setContentView?", activity.getClass().getSimpleName());
            ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f13695a);
        }
        if (coordinate != null) {
            f13694f.mo14187a("Setting minimized location to {} {}", Integer.valueOf(coordinate.m14209a()), Integer.valueOf(coordinate.m14210b()));
            this.f13696b.setX(coordinate.m14209a());
            this.f13696b.setY(coordinate.m14210b());
            ((FrameLayout.LayoutParams) this.f13696b.getLayoutParams()).gravity = 0;
        }
    }

    /* JADX INFO: renamed from: b */
    void m13964b() {
        ViewGroup viewGroup = (ViewGroup) this.f13695a.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f13695a);
        }
    }

    /* JADX INFO: renamed from: a */
    void m13963a(Coordinate coordinate) {
        f13694f.mo14187a("Setting minimized location to {} {}", Integer.valueOf(coordinate.m14209a()), Integer.valueOf(coordinate.m14210b()));
        this.f13696b.setX(coordinate.m14209a());
        this.f13696b.setY(coordinate.m14210b());
    }

    /* JADX INFO: renamed from: b */
    void m13965b(Coordinate coordinate) {
        this.f13696b.animate().x(coordinate.m14209a()).y(coordinate.m14210b()).setDuration(250L).start();
    }

    /* JADX INFO: renamed from: c */
    ViewGroup m13966c() {
        return this.f13695a;
    }

    /* JADX INFO: renamed from: d */
    ViewGroup m13967d() {
        return this.f13696b;
    }

    static class Builder {

        /* JADX INFO: renamed from: a */
        ViewGroup f13705a;

        /* JADX INFO: renamed from: b */
        ViewGroup f13706b;

        /* JADX INFO: renamed from: c */
        View f13707c;

        /* JADX INFO: renamed from: d */
        Listener f13708d;

        /* JADX INFO: renamed from: e */
        MinimizeViewDrag f13709e;

        Builder() {
        }

        /* JADX INFO: renamed from: a */
        Builder m13968a(Listener listener) {
            this.f13708d = listener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        MinimizedViewHolder m13969a(Activity activity) {
            if (this.f13705a == null) {
                this.f13705a = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.minimized_container, (ViewGroup) activity.getWindow().getDecorView(), false);
                ((FrameLayout.LayoutParams) this.f13705a.getLayoutParams()).gravity = 0;
            }
            if (this.f13706b == null) {
                this.f13706b = (ViewGroup) this.f13705a.findViewById(R.id.salesforce_minview_thumbnail);
            }
            if (this.f13707c == null) {
                this.f13707c = this.f13706b.findViewById(R.id.common_minview_content);
            }
            if (this.f13709e == null) {
                this.f13709e = new MinimizeViewDrag.Builder().m13956a(this.f13705a).m13959b(this.f13706b).m13957a(this.f13708d).m13958a();
            }
            return new MinimizedViewHolder(this);
        }
    }

    static class Factory {
        Factory() {
        }

        /* JADX INFO: renamed from: a */
        MinimizedViewHolder m13970a(Activity activity, Listener listener) {
            return new Builder().m13968a(listener).m13969a(activity);
        }
    }
}
