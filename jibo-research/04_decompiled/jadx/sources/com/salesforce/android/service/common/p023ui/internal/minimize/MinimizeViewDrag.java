package com.salesforce.android.service.common.p023ui.internal.minimize;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
class MinimizeViewDrag implements View.OnDragListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13678a = ServiceLogging.m14203a((Class<?>) MinimizeViewDrag.class);

    /* JADX INFO: renamed from: b */
    private final Listener f13679b;

    /* JADX INFO: renamed from: c */
    private final View f13680c;

    /* JADX INFO: renamed from: d */
    private final View f13681d;

    /* JADX INFO: renamed from: e */
    private final int f13682e;

    /* JADX INFO: renamed from: f */
    private Coordinate f13683f;

    /* JADX INFO: renamed from: g */
    private boolean f13684g;

    /* JADX INFO: renamed from: h */
    private boolean f13685h;

    /* JADX INFO: renamed from: i */
    private float f13686i;

    /* JADX INFO: renamed from: j */
    private float f13687j;

    /* JADX INFO: renamed from: k */
    private Integer f13688k;

    interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13960a(Coordinate coordinate);
    }

    MinimizeViewDrag(Builder builder) {
        this.f13679b = builder.f13691c;
        this.f13680c = builder.f13690b;
        this.f13681d = builder.f13689a;
        this.f13682e = builder.f13692d;
        this.f13680c.setOnTouchListener(this);
        this.f13681d.setOnDragListener(this);
    }

    /* JADX INFO: renamed from: a */
    void m13955a() {
        this.f13680c.setOnTouchListener(null);
        this.f13681d.setOnDragListener(null);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13686i = motionEvent.getX();
            this.f13687j = motionEvent.getY();
            this.f13684g = true;
        } else if (motionEvent.getAction() == 2 && this.f13684g) {
            float x = motionEvent.getX() - this.f13686i;
            float y = motionEvent.getY() - this.f13687j;
            if (Math.sqrt((x * x) + (y * y)) > m13953a(view).intValue()) {
                this.f13683f = Coordinate.m14208a(Math.max((int) motionEvent.getX(), 0), Math.max((int) motionEvent.getY(), 0));
                this.f13685h = true;
                m13954a(view, null, new ShadowBuilder(view, this.f13683f), null, 0);
                this.f13684g = false;
            }
        }
        return false;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        if (!this.f13685h) {
            return false;
        }
        switch (dragEvent.getAction()) {
            case 1:
                this.f13680c.setVisibility(4);
                break;
            case 3:
                if (this.f13683f == null) {
                    this.f13683f = Coordinate.m14208a(0, 0);
                }
                float x = dragEvent.getX() - this.f13683f.m14209a();
                float y = dragEvent.getY() - this.f13683f.m14210b();
                f13678a.mo14187a("Minimized view dropped at {} {}", Float.valueOf(x), Float.valueOf(y));
                this.f13680c.setX(x);
                this.f13680c.setY(y);
                if (this.f13679b != null) {
                    this.f13679b.mo13960a(Coordinate.m14208a((int) x, (int) y));
                }
                break;
            case 4:
                this.f13680c.setAlpha(0.5f);
                this.f13680c.setVisibility(0);
                this.f13680c.animate().alpha(1.0f).setDuration(100L).start();
                this.f13685h = false;
                break;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private Integer m13953a(View view) {
        if (this.f13688k == null) {
            this.f13688k = Integer.valueOf(ViewConfiguration.get(view.getContext()).getScaledTouchSlop());
        }
        return this.f13688k;
    }

    @TargetApi(24)
    /* JADX INFO: renamed from: a */
    private void m13954a(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        if (this.f13682e >= 24) {
            view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        } else {
            view.startDrag(clipData, dragShadowBuilder, obj, i);
        }
    }

    static class ShadowBuilder extends View.DragShadowBuilder {

        /* JADX INFO: renamed from: a */
        Coordinate f13693a;

        ShadowBuilder(View view, Coordinate coordinate) {
            super(view);
            this.f13693a = coordinate;
        }

        @Override // android.view.View.DragShadowBuilder
        public void onDrawShadow(Canvas canvas) {
            getView().draw(canvas);
        }

        @Override // android.view.View.DragShadowBuilder
        public void onProvideShadowMetrics(Point point, Point point2) {
            point.set(getView().getWidth(), getView().getHeight());
            point2.set(this.f13693a.m14209a(), this.f13693a.m14210b());
        }
    }

    static class Builder {

        /* JADX INFO: renamed from: a */
        View f13689a;

        /* JADX INFO: renamed from: b */
        View f13690b;

        /* JADX INFO: renamed from: c */
        Listener f13691c;

        /* JADX INFO: renamed from: d */
        int f13692d = Build.VERSION.SDK_INT;

        Builder() {
        }

        /* JADX INFO: renamed from: a */
        Builder m13956a(View view) {
            this.f13689a = view;
            return this;
        }

        /* JADX INFO: renamed from: b */
        Builder m13959b(View view) {
            this.f13690b = view;
            return this;
        }

        /* JADX INFO: renamed from: a */
        Builder m13957a(Listener listener) {
            this.f13691c = listener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        MinimizeViewDrag m13958a() {
            Arguments.m14236a(this.f13689a, "Builder must be provided with a container view");
            Arguments.m14236a(this.f13690b, "Builder must be provided with the minimized view");
            return new MinimizeViewDrag(this);
        }
    }
}
