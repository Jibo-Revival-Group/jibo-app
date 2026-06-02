package com.jibo.p019ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewFastScroller extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private TextView f11577a;

    /* JADX INFO: renamed from: b */
    private View f11578b;

    /* JADX INFO: renamed from: c */
    private RecyclerView f11579c;

    /* JADX INFO: renamed from: d */
    private int f11580d;

    /* JADX INFO: renamed from: e */
    private boolean f11581e;

    /* JADX INFO: renamed from: f */
    private ObjectAnimator f11582f;

    /* JADX INFO: renamed from: g */
    private final RecyclerView.OnScrollListener f11583g;

    public interface BubbleTextGetter {
        /* JADX INFO: renamed from: c */
        String mo11015c(int i);
    }

    public RecyclerViewFastScroller(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11581e = false;
        this.f11582f = null;
        this.f11583g = new RecyclerView.OnScrollListener() { // from class: com.jibo.ui.view.RecyclerViewFastScroller.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            /* JADX INFO: renamed from: a */
            public void mo4164a(RecyclerView recyclerView, int i2, int i3) {
                RecyclerViewFastScroller.this.m11283a();
            }
        };
        m11290a(context);
    }

    public RecyclerViewFastScroller(Context context) {
        super(context);
        this.f11581e = false;
        this.f11582f = null;
        this.f11583g = new RecyclerView.OnScrollListener() { // from class: com.jibo.ui.view.RecyclerViewFastScroller.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            /* JADX INFO: renamed from: a */
            public void mo4164a(RecyclerView recyclerView, int i2, int i3) {
                RecyclerViewFastScroller.this.m11283a();
            }
        };
        m11290a(context);
    }

    public RecyclerViewFastScroller(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11581e = false;
        this.f11582f = null;
        this.f11583g = new RecyclerView.OnScrollListener() { // from class: com.jibo.ui.view.RecyclerViewFastScroller.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            /* JADX INFO: renamed from: a */
            public void mo4164a(RecyclerView recyclerView, int i2, int i3) {
                RecyclerViewFastScroller.this.m11283a();
            }
        };
        m11290a(context);
    }

    /* JADX INFO: renamed from: a */
    protected void m11290a(Context context) {
        if (!this.f11581e) {
            this.f11581e = true;
            setOrientation(0);
            setClipChildren(false);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11289a(int i, int i2, int i3) {
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, true);
        this.f11577a = (TextView) findViewById(i2);
        if (this.f11577a != null) {
            this.f11577a.setVisibility(4);
        }
        this.f11578b = findViewById(i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11580d = i2;
        m11283a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (motionEvent.getX() < this.f11578b.getX() - ViewCompat.m2603g(this.f11578b)) {
                    return false;
                }
                if (this.f11582f != null) {
                    this.f11582f.cancel();
                }
                if (this.f11577a != null && this.f11577a.getVisibility() == 4) {
                    m11287b();
                }
                this.f11578b.setSelected(true);
                break;
                break;
            case 1:
            case 3:
                this.f11578b.setSelected(false);
                m11288c();
                return true;
            case 2:
                break;
            default:
                return super.onTouchEvent(motionEvent);
        }
        float y = motionEvent.getY();
        setBubbleAndHandlePosition(y);
        setRecyclerViewPosition(y);
        return true;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        if (this.f11579c != recyclerView) {
            if (this.f11579c != null) {
                this.f11579c.removeOnScrollListener(this.f11583g);
            }
            this.f11579c = recyclerView;
            if (this.f11579c != null) {
                recyclerView.addOnScrollListener(this.f11583g);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f11579c != null) {
            this.f11579c.removeOnScrollListener(this.f11583g);
            this.f11579c = null;
        }
    }

    private void setRecyclerViewPosition(float f) {
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (this.f11579c != null) {
            int itemCount = this.f11579c.getAdapter().getItemCount();
            if (this.f11578b.getY() != CropImageView.DEFAULT_ASPECT_RATIO) {
                if (this.f11578b.getY() + this.f11578b.getHeight() >= this.f11580d - 5) {
                    f2 = 1.0f;
                } else {
                    f2 = f / this.f11580d;
                }
            }
            int iM11285b = m11285b(0, itemCount - 1, (int) (f2 * itemCount));
            ((LinearLayoutManager) this.f11579c.getLayoutManager()).m4301b(iM11285b, 0);
            String strMo11015c = ((BubbleTextGetter) this.f11579c.getAdapter()).mo11015c(iM11285b);
            if (this.f11577a != null && !TextUtils.isEmpty(strMo11015c)) {
                this.f11577a.setText(strMo11015c);
                this.f11577a.setVisibility(0);
            } else {
                this.f11577a.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private int m11285b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i3), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11283a() {
        if (this.f11577a != null && !this.f11578b.isSelected()) {
            setBubbleAndHandlePosition((this.f11579c.computeVerticalScrollOffset() / (this.f11579c.computeVerticalScrollRange() - this.f11580d)) * this.f11580d);
        }
    }

    private void setBubbleAndHandlePosition(float f) {
        int height = this.f11578b.getHeight();
        this.f11578b.setY(m11285b(0, this.f11580d - height, (int) (f - (height / 2))));
        if (this.f11577a != null) {
            int height2 = this.f11577a.getHeight();
            this.f11577a.setY(m11285b(0, (this.f11580d - height2) - (height / 2), (int) (f - height2)));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m11287b() {
        if (this.f11577a != null) {
            this.f11577a.setVisibility(0);
            if (this.f11582f != null) {
                this.f11582f.cancel();
            }
            this.f11582f = ObjectAnimator.ofFloat(this.f11577a, "alpha", CropImageView.DEFAULT_ASPECT_RATIO, 1.0f).setDuration(100L);
            this.f11582f.start();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m11288c() {
        if (this.f11577a != null) {
            if (this.f11582f != null) {
                this.f11582f.cancel();
            }
            this.f11582f = ObjectAnimator.ofFloat(this.f11577a, "alpha", 1.0f, CropImageView.DEFAULT_ASPECT_RATIO).setDuration(100L);
            this.f11582f.addListener(new AnimatorListenerAdapter() { // from class: com.jibo.ui.view.RecyclerViewFastScroller.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    RecyclerViewFastScroller.this.f11577a.setVisibility(4);
                    RecyclerViewFastScroller.this.f11582f = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    RecyclerViewFastScroller.this.f11577a.setVisibility(4);
                    RecyclerViewFastScroller.this.f11582f = null;
                }
            });
            this.f11582f.start();
        }
    }
}
