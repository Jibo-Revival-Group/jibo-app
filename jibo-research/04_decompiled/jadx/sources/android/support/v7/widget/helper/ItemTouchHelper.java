package android.support.v7.widget.helper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {

    /* JADX INFO: renamed from: A */
    private ItemTouchHelperGestureListener f4506A;

    /* JADX INFO: renamed from: C */
    private Rect f4508C;

    /* JADX INFO: renamed from: D */
    private long f4509D;

    /* JADX INFO: renamed from: c */
    float f4512c;

    /* JADX INFO: renamed from: d */
    float f4513d;

    /* JADX INFO: renamed from: e */
    float f4514e;

    /* JADX INFO: renamed from: f */
    float f4515f;

    /* JADX INFO: renamed from: g */
    float f4516g;

    /* JADX INFO: renamed from: h */
    float f4517h;

    /* JADX INFO: renamed from: i */
    float f4518i;

    /* JADX INFO: renamed from: j */
    float f4519j;

    /* JADX INFO: renamed from: l */
    Callback f4521l;

    /* JADX INFO: renamed from: n */
    int f4523n;

    /* JADX INFO: renamed from: p */
    RecyclerView f4525p;

    /* JADX INFO: renamed from: r */
    VelocityTracker f4527r;

    /* JADX INFO: renamed from: u */
    GestureDetectorCompat f4530u;

    /* JADX INFO: renamed from: w */
    private int f4532w;

    /* JADX INFO: renamed from: x */
    private List<RecyclerView.ViewHolder> f4533x;

    /* JADX INFO: renamed from: y */
    private List<Integer> f4534y;

    /* JADX INFO: renamed from: a */
    final List<View> f4510a = new ArrayList();

    /* JADX INFO: renamed from: v */
    private final float[] f4531v = new float[2];

    /* JADX INFO: renamed from: b */
    RecyclerView.ViewHolder f4511b = null;

    /* JADX INFO: renamed from: k */
    int f4520k = -1;

    /* JADX INFO: renamed from: m */
    int f4522m = 0;

    /* JADX INFO: renamed from: o */
    List<RecoverAnimation> f4524o = new ArrayList();

    /* JADX INFO: renamed from: q */
    final Runnable f4526q = new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (ItemTouchHelper.this.f4511b != null && ItemTouchHelper.this.m5056b()) {
                if (ItemTouchHelper.this.f4511b != null) {
                    ItemTouchHelper.this.m5048a(ItemTouchHelper.this.f4511b);
                }
                ItemTouchHelper.this.f4525p.removeCallbacks(ItemTouchHelper.this.f4526q);
                ViewCompat.m2586a(ItemTouchHelper.this.f4525p, this);
            }
        }
    };

    /* JADX INFO: renamed from: z */
    private RecyclerView.ChildDrawingOrderCallback f4535z = null;

    /* JADX INFO: renamed from: s */
    View f4528s = null;

    /* JADX INFO: renamed from: t */
    int f4529t = -1;

    /* JADX INFO: renamed from: B */
    private final RecyclerView.OnItemTouchListener f4507B = new RecyclerView.OnItemTouchListener() { // from class: android.support.v7.widget.helper.ItemTouchHelper.2
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        /* JADX INFO: renamed from: a */
        public boolean mo4161a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            RecoverAnimation recoverAnimationM5055b;
            ItemTouchHelper.this.f4530u.m2500a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.f4520k = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f4512c = motionEvent.getX();
                ItemTouchHelper.this.f4513d = motionEvent.getY();
                ItemTouchHelper.this.m5057c();
                if (ItemTouchHelper.this.f4511b == null && (recoverAnimationM5055b = ItemTouchHelper.this.m5055b(motionEvent)) != null) {
                    ItemTouchHelper.this.f4512c -= recoverAnimationM5055b.f4561l;
                    ItemTouchHelper.this.f4513d -= recoverAnimationM5055b.f4562m;
                    ItemTouchHelper.this.m5046a(recoverAnimationM5055b.f4557h, true);
                    if (ItemTouchHelper.this.f4510a.remove(recoverAnimationM5055b.f4557h.itemView)) {
                        ItemTouchHelper.this.f4521l.m5086d(ItemTouchHelper.this.f4525p, recoverAnimationM5055b.f4557h);
                    }
                    ItemTouchHelper.this.m5049a(recoverAnimationM5055b.f4557h, recoverAnimationM5055b.f4558i);
                    ItemTouchHelper.this.m5052a(motionEvent, ItemTouchHelper.this.f4523n, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.f4520k = -1;
                ItemTouchHelper.this.m5049a((RecyclerView.ViewHolder) null, 0);
            } else if (ItemTouchHelper.this.f4520k != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f4520k)) >= 0) {
                ItemTouchHelper.this.m5054a(actionMasked, motionEvent, iFindPointerIndex);
            }
            if (ItemTouchHelper.this.f4527r != null) {
                ItemTouchHelper.this.f4527r.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.f4511b != null;
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        /* JADX INFO: renamed from: b */
        public void mo4162b(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.f4530u.m2500a(motionEvent);
            if (ItemTouchHelper.this.f4527r != null) {
                ItemTouchHelper.this.f4527r.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f4520k != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int iFindPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f4520k);
                if (iFindPointerIndex >= 0) {
                    ItemTouchHelper.this.m5054a(actionMasked, motionEvent, iFindPointerIndex);
                }
                RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.f4511b;
                if (viewHolder != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (iFindPointerIndex >= 0) {
                                ItemTouchHelper.this.m5052a(motionEvent, ItemTouchHelper.this.f4523n, iFindPointerIndex);
                                ItemTouchHelper.this.m5048a(viewHolder);
                                ItemTouchHelper.this.f4525p.removeCallbacks(ItemTouchHelper.this.f4526q);
                                ItemTouchHelper.this.f4526q.run();
                                ItemTouchHelper.this.f4525p.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (ItemTouchHelper.this.f4527r != null) {
                                ItemTouchHelper.this.f4527r.clear();
                            }
                            break;
                        case 4:
                        case 5:
                        default:
                            return;
                        case 6:
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.f4520k) {
                                ItemTouchHelper.this.f4520k = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                                ItemTouchHelper.this.m5052a(motionEvent, ItemTouchHelper.this.f4523n, actionIndex);
                                return;
                            }
                            return;
                    }
                    ItemTouchHelper.this.m5049a((RecyclerView.ViewHolder) null, 0);
                    ItemTouchHelper.this.f4520k = -1;
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        /* JADX INFO: renamed from: a */
        public void mo4159a(boolean z) {
            if (z) {
                ItemTouchHelper.this.m5049a((RecyclerView.ViewHolder) null, 0);
            }
        }
    };

    public interface ViewDropHandler {
        /* JADX INFO: renamed from: a */
        void mo4296a(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(Callback callback) {
        this.f4521l = callback;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5034a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    /* JADX INFO: renamed from: a */
    public void m5050a(RecyclerView recyclerView) {
        if (this.f4525p != recyclerView) {
            if (this.f4525p != null) {
                m5041e();
            }
            this.f4525p = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f4514e = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.f4515f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                m5040d();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m5040d() {
        this.f4532w = ViewConfiguration.get(this.f4525p.getContext()).getScaledTouchSlop();
        this.f4525p.addItemDecoration(this);
        this.f4525p.addOnItemTouchListener(this.f4507B);
        this.f4525p.addOnChildAttachStateChangeListener(this);
        m5042f();
    }

    /* JADX INFO: renamed from: e */
    private void m5041e() {
        this.f4525p.removeItemDecoration(this);
        this.f4525p.removeOnItemTouchListener(this.f4507B);
        this.f4525p.removeOnChildAttachStateChangeListener(this);
        for (int size = this.f4524o.size() - 1; size >= 0; size--) {
            this.f4521l.m5086d(this.f4525p, this.f4524o.get(0).f4557h);
        }
        this.f4524o.clear();
        this.f4528s = null;
        this.f4529t = -1;
        m5044h();
        m5043g();
    }

    /* JADX INFO: renamed from: f */
    private void m5042f() {
        this.f4506A = new ItemTouchHelperGestureListener();
        this.f4530u = new GestureDetectorCompat(this.f4525p.getContext(), this.f4506A);
    }

    /* JADX INFO: renamed from: g */
    private void m5043g() {
        if (this.f4506A != null) {
            this.f4506A.m5087a();
            this.f4506A = null;
        }
        if (this.f4530u != null) {
            this.f4530u = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5033a(float[] fArr) {
        if ((this.f4523n & 12) != 0) {
            fArr[0] = (this.f4518i + this.f4516g) - this.f4511b.itemView.getLeft();
        } else {
            fArr[0] = this.f4511b.itemView.getTranslationX();
        }
        if ((this.f4523n & 3) != 0) {
            fArr[1] = (this.f4519j + this.f4517h) - this.f4511b.itemView.getTop();
        } else {
            fArr[1] = this.f4511b.itemView.getTranslationY();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: a */
    public void mo4157a(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (this.f4511b != null) {
            m5033a(this.f4531v);
            f = this.f4531v[0];
            f2 = this.f4531v[1];
        } else {
            f = 0.0f;
        }
        this.f4521l.m5079b(canvas, recyclerView, this.f4511b, this.f4524o, this.f4522m, f, f2);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: b */
    public void mo4462b(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f4529t = -1;
        if (this.f4511b != null) {
            m5033a(this.f4531v);
            f = this.f4531v[0];
            f2 = this.f4531v[1];
        } else {
            f = 0.0f;
        }
        this.f4521l.m5070a(canvas, recyclerView, this.f4511b, this.f4524o, this.f4522m, f, f2);
    }

    /* JADX INFO: renamed from: a */
    void m5049a(RecyclerView.ViewHolder viewHolder, int i) {
        float fSignum;
        float fSignum2;
        int i2;
        if (viewHolder != this.f4511b || i != this.f4522m) {
            this.f4509D = Long.MIN_VALUE;
            int i3 = this.f4522m;
            m5046a(viewHolder, true);
            this.f4522m = i;
            if (i == 2) {
                this.f4528s = viewHolder.itemView;
                m5045i();
            }
            int i4 = (1 << ((i * 8) + 8)) - 1;
            boolean z = false;
            if (this.f4511b != null) {
                final RecyclerView.ViewHolder viewHolder2 = this.f4511b;
                if (viewHolder2.itemView.getParent() != null) {
                    final int iM5037c = i3 == 2 ? 0 : m5037c(viewHolder2);
                    m5044h();
                    switch (iM5037c) {
                        case 1:
                        case 2:
                            fSignum = CropImageView.DEFAULT_ASPECT_RATIO;
                            fSignum2 = Math.signum(this.f4517h) * this.f4525p.getHeight();
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            fSignum2 = CropImageView.DEFAULT_ASPECT_RATIO;
                            fSignum = Math.signum(this.f4516g) * this.f4525p.getWidth();
                            break;
                        default:
                            fSignum = CropImageView.DEFAULT_ASPECT_RATIO;
                            fSignum2 = CropImageView.DEFAULT_ASPECT_RATIO;
                            break;
                    }
                    if (i3 == 2) {
                        i2 = 8;
                    } else if (iM5037c > 0) {
                        i2 = 2;
                    } else {
                        i2 = 4;
                    }
                    m5033a(this.f4531v);
                    float f = this.f4531v[0];
                    float f2 = this.f4531v[1];
                    RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder2, i2, i3, f, f2, fSignum, fSignum2) { // from class: android.support.v7.widget.helper.ItemTouchHelper.3
                        @Override // android.support.v7.widget.helper.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            if (!this.f4563n) {
                                if (iM5037c <= 0) {
                                    ItemTouchHelper.this.f4521l.m5086d(ItemTouchHelper.this.f4525p, viewHolder2);
                                } else {
                                    ItemTouchHelper.this.f4510a.add(viewHolder2.itemView);
                                    this.f4560k = true;
                                    if (iM5037c > 0) {
                                        ItemTouchHelper.this.m5051a(this, iM5037c);
                                    }
                                }
                                if (ItemTouchHelper.this.f4528s == viewHolder2.itemView) {
                                    ItemTouchHelper.this.m5058c(viewHolder2.itemView);
                                }
                            }
                        }
                    };
                    recoverAnimation.m5090a(this.f4521l.m5067a(this.f4525p, i2, fSignum - f, fSignum2 - f2));
                    this.f4524o.add(recoverAnimation);
                    recoverAnimation.m5088a();
                    z = true;
                } else {
                    m5058c(viewHolder2.itemView);
                    this.f4521l.m5086d(this.f4525p, viewHolder2);
                }
                this.f4511b = null;
            }
            boolean z2 = z;
            if (viewHolder != null) {
                this.f4523n = (this.f4521l.m5077b(this.f4525p, viewHolder) & i4) >> (this.f4522m * 8);
                this.f4518i = viewHolder.itemView.getLeft();
                this.f4519j = viewHolder.itemView.getTop();
                this.f4511b = viewHolder;
                if (i == 2) {
                    this.f4511b.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.f4525p.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.f4511b != null);
            }
            if (!z2) {
                this.f4525p.getLayoutManager().m4483J();
            }
            this.f4521l.m5080b(this.f4511b, this.f4522m);
            this.f4525p.invalidate();
        }
    }

    /* JADX INFO: renamed from: a */
    void m5051a(final RecoverAnimation recoverAnimation, final int i) {
        this.f4525p.post(new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (ItemTouchHelper.this.f4525p != null && ItemTouchHelper.this.f4525p.isAttachedToWindow() && !recoverAnimation.f4563n && recoverAnimation.f4557h.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.f4525p.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.m4440a((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !ItemTouchHelper.this.m5053a()) {
                        ItemTouchHelper.this.f4521l.mo5071a(recoverAnimation.f4557h, i);
                    } else {
                        ItemTouchHelper.this.f4525p.post(this);
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    boolean m5053a() {
        int size = this.f4524o.size();
        for (int i = 0; i < size; i++) {
            if (!this.f4524o.get(i).f4564o) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010e  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean m5056b() {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.m5056b():boolean");
    }

    /* JADX INFO: renamed from: b */
    private List<RecyclerView.ViewHolder> m5036b(RecyclerView.ViewHolder viewHolder) {
        if (this.f4533x == null) {
            this.f4533x = new ArrayList();
            this.f4534y = new ArrayList();
        } else {
            this.f4533x.clear();
            this.f4534y.clear();
        }
        int iM5083c = this.f4521l.m5083c();
        int iRound = Math.round(this.f4518i + this.f4516g) - iM5083c;
        int iRound2 = Math.round(this.f4519j + this.f4517h) - iM5083c;
        int width = viewHolder.itemView.getWidth() + iRound + (iM5083c * 2);
        int height = viewHolder.itemView.getHeight() + iRound2 + (iM5083c * 2);
        int i = (iRound + width) / 2;
        int i2 = (iRound2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f4525p.getLayoutManager();
        int iM4561v = layoutManager.m4561v();
        for (int i3 = 0; i3 < iM4561v; i3++) {
            View viewM4544i = layoutManager.m4544i(i3);
            if (viewM4544i != viewHolder.itemView && viewM4544i.getBottom() >= iRound2 && viewM4544i.getTop() <= height && viewM4544i.getRight() >= iRound && viewM4544i.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.f4525p.getChildViewHolder(viewM4544i);
                if (this.f4521l.m5074a(this.f4525p, this.f4511b, childViewHolder)) {
                    int iAbs = Math.abs(i - ((viewM4544i.getLeft() + viewM4544i.getRight()) / 2));
                    int iAbs2 = Math.abs(i2 - ((viewM4544i.getBottom() + viewM4544i.getTop()) / 2));
                    int i4 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f4533x.size();
                    int i5 = 0;
                    for (int i6 = 0; i6 < size && i4 > this.f4534y.get(i6).intValue(); i6++) {
                        i5++;
                    }
                    this.f4533x.add(i5, childViewHolder);
                    this.f4534y.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.f4533x;
    }

    /* JADX INFO: renamed from: a */
    void m5048a(RecyclerView.ViewHolder viewHolder) {
        if (!this.f4525p.isLayoutRequested() && this.f4522m == 2) {
            float fM5076b = this.f4521l.m5076b(viewHolder);
            int i = (int) (this.f4518i + this.f4516g);
            int i2 = (int) (this.f4519j + this.f4517h);
            if (Math.abs(i2 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * fM5076b || Math.abs(i - viewHolder.itemView.getLeft()) >= fM5076b * viewHolder.itemView.getWidth()) {
                List<RecyclerView.ViewHolder> listM5036b = m5036b(viewHolder);
                if (listM5036b.size() != 0) {
                    RecyclerView.ViewHolder viewHolderM5068a = this.f4521l.m5068a(viewHolder, listM5036b, i, i2);
                    if (viewHolderM5068a == null) {
                        this.f4533x.clear();
                        this.f4534y.clear();
                        return;
                    }
                    int adapterPosition = viewHolderM5068a.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.f4521l.mo5082b(this.f4525p, viewHolder, viewHolderM5068a)) {
                        this.f4521l.m5072a(this.f4525p, viewHolder, adapterPosition2, viewHolderM5068a, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    /* JADX INFO: renamed from: a */
    public void mo4575a(View view) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    /* JADX INFO: renamed from: b */
    public void mo4576b(View view) {
        m5058c(view);
        RecyclerView.ViewHolder childViewHolder = this.f4525p.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.f4511b != null && childViewHolder == this.f4511b) {
                m5049a((RecyclerView.ViewHolder) null, 0);
                return;
            }
            m5046a(childViewHolder, false);
            if (this.f4510a.remove(childViewHolder.itemView)) {
                this.f4521l.m5086d(this.f4525p, childViewHolder);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m5046a(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.f4524o.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f4524o.get(size);
            if (recoverAnimation.f4557h == viewHolder) {
                recoverAnimation.f4563n |= z;
                if (!recoverAnimation.f4564o) {
                    recoverAnimation.m5091b();
                }
                this.f4524o.remove(size);
                return recoverAnimation.f4559j;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: a */
    public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    /* JADX INFO: renamed from: c */
    void m5057c() {
        if (this.f4527r != null) {
            this.f4527r.recycle();
        }
        this.f4527r = VelocityTracker.obtain();
    }

    /* JADX INFO: renamed from: h */
    private void m5044h() {
        if (this.f4527r != null) {
            this.f4527r.recycle();
            this.f4527r = null;
        }
    }

    /* JADX INFO: renamed from: c */
    private RecyclerView.ViewHolder m5039c(MotionEvent motionEvent) {
        View viewM5047a;
        RecyclerView.LayoutManager layoutManager = this.f4525p.getLayoutManager();
        if (this.f4520k == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(this.f4520k);
        float x = motionEvent.getX(iFindPointerIndex) - this.f4512c;
        float y = motionEvent.getY(iFindPointerIndex) - this.f4513d;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        if (fAbs < this.f4532w && fAbs2 < this.f4532w) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.mo4313e()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.mo4316f()) && (viewM5047a = m5047a(motionEvent)) != null) {
            return this.f4525p.getChildViewHolder(viewM5047a);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    boolean m5054a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder viewHolderM5039c;
        int iM5077b;
        if (this.f4511b != null || i != 2 || this.f4522m == 2 || !this.f4521l.m5081b() || this.f4525p.getScrollState() == 1 || (viewHolderM5039c = m5039c(motionEvent)) == null || (iM5077b = (this.f4521l.m5077b(this.f4525p, viewHolderM5039c) & 65280) >> 8) == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f4512c;
        float f2 = y - this.f4513d;
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if (fAbs < this.f4532w && fAbs2 < this.f4532w) {
            return false;
        }
        if (fAbs > fAbs2) {
            if (f < CropImageView.DEFAULT_ASPECT_RATIO && (iM5077b & 4) == 0) {
                return false;
            }
            if (f > CropImageView.DEFAULT_ASPECT_RATIO && (iM5077b & 8) == 0) {
                return false;
            }
        } else {
            if (f2 < CropImageView.DEFAULT_ASPECT_RATIO && (iM5077b & 1) == 0) {
                return false;
            }
            if (f2 > CropImageView.DEFAULT_ASPECT_RATIO && (iM5077b & 2) == 0) {
                return false;
            }
        }
        this.f4517h = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f4516g = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f4520k = motionEvent.getPointerId(0);
        m5049a(viewHolderM5039c, 1);
        return true;
    }

    /* JADX INFO: renamed from: a */
    View m5047a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f4511b != null) {
            View view = this.f4511b.itemView;
            if (m5034a(view, x, y, this.f4518i + this.f4516g, this.f4519j + this.f4517h)) {
                return view;
            }
        }
        for (int size = this.f4524o.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f4524o.get(size);
            View view2 = recoverAnimation.f4557h.itemView;
            if (m5034a(view2, x, y, recoverAnimation.f4561l, recoverAnimation.f4562m)) {
                return view2;
            }
        }
        return this.f4525p.findChildViewUnder(x, y);
    }

    /* JADX INFO: renamed from: b */
    RecoverAnimation m5055b(MotionEvent motionEvent) {
        if (this.f4524o.isEmpty()) {
            return null;
        }
        View viewM5047a = m5047a(motionEvent);
        for (int size = this.f4524o.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f4524o.get(size);
            if (recoverAnimation.f4557h.itemView == viewM5047a) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m5052a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.f4516g = x - this.f4512c;
        this.f4517h = y - this.f4513d;
        if ((i & 4) == 0) {
            this.f4516g = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, this.f4516g);
        }
        if ((i & 8) == 0) {
            this.f4516g = Math.min(CropImageView.DEFAULT_ASPECT_RATIO, this.f4516g);
        }
        if ((i & 1) == 0) {
            this.f4517h = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, this.f4517h);
        }
        if ((i & 2) == 0) {
            this.f4517h = Math.min(CropImageView.DEFAULT_ASPECT_RATIO, this.f4517h);
        }
    }

    /* JADX INFO: renamed from: c */
    private int m5037c(RecyclerView.ViewHolder viewHolder) {
        if (this.f4522m == 2) {
            return 0;
        }
        int iMo5066a = this.f4521l.mo5066a(this.f4525p, viewHolder);
        int iM5085d = (this.f4521l.m5085d(iMo5066a, ViewCompat.m2601e(this.f4525p)) & 65280) >> 8;
        if (iM5085d == 0) {
            return 0;
        }
        int i = (iMo5066a & 65280) >> 8;
        if (Math.abs(this.f4516g) > Math.abs(this.f4517h)) {
            int iM5035b = m5035b(viewHolder, iM5085d);
            if (iM5035b > 0) {
                return (i & iM5035b) == 0 ? Callback.m5059a(iM5035b, ViewCompat.m2601e(this.f4525p)) : iM5035b;
            }
            int iM5038c = m5038c(viewHolder, iM5085d);
            if (iM5038c > 0) {
                return iM5038c;
            }
            return 0;
        }
        int iM5038c2 = m5038c(viewHolder, iM5085d);
        if (iM5038c2 > 0) {
            return iM5038c2;
        }
        int iM5035b2 = m5035b(viewHolder, iM5085d);
        if (iM5035b2 > 0) {
            return (i & iM5035b2) == 0 ? Callback.m5059a(iM5035b2, ViewCompat.m2601e(this.f4525p)) : iM5035b2;
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    private int m5035b(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) != 0) {
            int i2 = this.f4516g > CropImageView.DEFAULT_ASPECT_RATIO ? 8 : 4;
            if (this.f4527r != null && this.f4520k > -1) {
                this.f4527r.computeCurrentVelocity(1000, this.f4521l.m5075b(this.f4515f));
                float xVelocity = this.f4527r.getXVelocity(this.f4520k);
                float yVelocity = this.f4527r.getYVelocity(this.f4520k);
                int i3 = xVelocity <= CropImageView.DEFAULT_ASPECT_RATIO ? 4 : 8;
                float fAbs = Math.abs(xVelocity);
                if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.f4521l.m5063a(this.f4514e) && fAbs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float width = this.f4525p.getWidth() * this.f4521l.m5064a(viewHolder);
            if ((i & i2) != 0 && Math.abs(this.f4516g) > width) {
                return i2;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    private int m5038c(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) != 0) {
            int i2 = this.f4517h > CropImageView.DEFAULT_ASPECT_RATIO ? 2 : 1;
            if (this.f4527r != null && this.f4520k > -1) {
                this.f4527r.computeCurrentVelocity(1000, this.f4521l.m5075b(this.f4515f));
                float xVelocity = this.f4527r.getXVelocity(this.f4520k);
                float yVelocity = this.f4527r.getYVelocity(this.f4520k);
                int i3 = yVelocity <= CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 2;
                float fAbs = Math.abs(yVelocity);
                if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.f4521l.m5063a(this.f4514e) && fAbs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float height = this.f4525p.getHeight() * this.f4521l.m5064a(viewHolder);
            if ((i & i2) != 0 && Math.abs(this.f4517h) > height) {
                return i2;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: i */
    private void m5045i() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f4535z == null) {
                this.f4535z = new RecyclerView.ChildDrawingOrderCallback() { // from class: android.support.v7.widget.helper.ItemTouchHelper.5
                    @Override // android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback
                    /* JADX INFO: renamed from: a */
                    public int mo4434a(int i, int i2) {
                        if (ItemTouchHelper.this.f4528s != null) {
                            int iIndexOfChild = ItemTouchHelper.this.f4529t;
                            if (iIndexOfChild == -1) {
                                iIndexOfChild = ItemTouchHelper.this.f4525p.indexOfChild(ItemTouchHelper.this.f4528s);
                                ItemTouchHelper.this.f4529t = iIndexOfChild;
                            }
                            return i2 == i + (-1) ? iIndexOfChild : i2 >= iIndexOfChild ? i2 + 1 : i2;
                        }
                        return i2;
                    }
                };
            }
            this.f4525p.setChildDrawingOrderCallback(this.f4535z);
        }
    }

    /* JADX INFO: renamed from: c */
    void m5058c(View view) {
        if (view == this.f4528s) {
            this.f4528s = null;
            if (this.f4535z != null) {
                this.f4525p.setChildDrawingOrderCallback(null);
            }
        }
    }

    public static abstract class Callback {

        /* JADX INFO: renamed from: a */
        private static final ItemTouchUIUtil f4545a;

        /* JADX INFO: renamed from: b */
        private static final Interpolator f4546b = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };

        /* JADX INFO: renamed from: c */
        private static final Interpolator f4547c = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };

        /* JADX INFO: renamed from: d */
        private int f4548d = -1;

        /* JADX INFO: renamed from: a */
        public abstract int mo5066a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        /* JADX INFO: renamed from: a */
        public abstract void mo5071a(RecyclerView.ViewHolder viewHolder, int i);

        /* JADX INFO: renamed from: b */
        public abstract boolean mo5082b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                f4545a = new ItemTouchUIUtilImpl.Api21Impl();
            } else {
                f4545a = new ItemTouchUIUtilImpl.BaseImpl();
            }
        }

        /* JADX INFO: renamed from: a */
        public static int m5059a(int i, int i2) {
            int i3 = i & 789516;
            if (i3 != 0) {
                int i4 = (i3 ^ (-1)) & i;
                if (i2 == 0) {
                    return i4 | (i3 << 2);
                }
                return i4 | ((i3 << 1) & (-789517)) | (((i3 << 1) & 789516) << 2);
            }
            return i;
        }

        /* JADX INFO: renamed from: b */
        public static int m5061b(int i, int i2) {
            return m5062c(0, i2 | i) | m5062c(1, i2) | m5062c(2, i);
        }

        /* JADX INFO: renamed from: c */
        public static int m5062c(int i, int i2) {
            return i2 << (i * 8);
        }

        /* JADX INFO: renamed from: d */
        public int m5085d(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 != 0) {
                int i4 = (i3 ^ (-1)) & i;
                if (i2 == 0) {
                    return i4 | (i3 >> 2);
                }
                return i4 | ((i3 >> 1) & (-3158065)) | (((i3 >> 1) & 3158064) >> 2);
            }
            return i;
        }

        /* JADX INFO: renamed from: b */
        final int m5077b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return m5085d(mo5066a(recyclerView, viewHolder), ViewCompat.m2601e(recyclerView));
        }

        /* JADX INFO: renamed from: c */
        boolean m5084c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (m5077b(recyclerView, viewHolder) & 16711680) != 0;
        }

        /* JADX INFO: renamed from: a */
        public boolean m5074a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        /* JADX INFO: renamed from: a */
        public boolean m5073a() {
            return true;
        }

        /* JADX INFO: renamed from: b */
        public boolean m5081b() {
            return true;
        }

        /* JADX INFO: renamed from: c */
        public int m5083c() {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public float m5064a(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        /* JADX INFO: renamed from: b */
        public float m5076b(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        /* JADX INFO: renamed from: a */
        public float m5063a(float f) {
            return f;
        }

        /* JADX INFO: renamed from: b */
        public float m5075b(float f) {
            return f;
        }

        /* JADX INFO: renamed from: a */
        public RecyclerView.ViewHolder m5068a(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            RecyclerView.ViewHolder viewHolder2;
            int i3;
            int iAbs;
            int iAbs2;
            int i4;
            RecyclerView.ViewHolder viewHolder3;
            int bottom;
            int iAbs3;
            int top;
            int left;
            int right;
            int iAbs4;
            int width = i + viewHolder.itemView.getWidth();
            int height = i2 + viewHolder.itemView.getHeight();
            RecyclerView.ViewHolder viewHolder4 = null;
            int i5 = -1;
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            int i6 = 0;
            while (i6 < size) {
                RecyclerView.ViewHolder viewHolder5 = list.get(i6);
                if (left2 <= 0 || (right = viewHolder5.itemView.getRight() - width) >= 0 || viewHolder5.itemView.getRight() <= viewHolder.itemView.getRight() || (iAbs4 = Math.abs(right)) <= i5) {
                    viewHolder2 = viewHolder4;
                    i3 = i5;
                } else {
                    i3 = iAbs4;
                    viewHolder2 = viewHolder5;
                }
                if (left2 >= 0 || (left = viewHolder5.itemView.getLeft() - i) <= 0 || viewHolder5.itemView.getLeft() >= viewHolder.itemView.getLeft() || (iAbs = Math.abs(left)) <= i3) {
                    iAbs = i3;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 >= 0 || (top = viewHolder5.itemView.getTop() - i2) <= 0 || viewHolder5.itemView.getTop() >= viewHolder.itemView.getTop() || (iAbs2 = Math.abs(top)) <= iAbs) {
                    iAbs2 = iAbs;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 <= 0 || (bottom = viewHolder5.itemView.getBottom() - height) >= 0 || viewHolder5.itemView.getBottom() <= viewHolder.itemView.getBottom() || (iAbs3 = Math.abs(bottom)) <= iAbs2) {
                    i4 = iAbs2;
                    viewHolder3 = viewHolder2;
                } else {
                    viewHolder3 = viewHolder5;
                    i4 = iAbs3;
                }
                i6++;
                viewHolder4 = viewHolder3;
                i5 = i4;
            }
            return viewHolder4;
        }

        /* JADX INFO: renamed from: b */
        public void m5080b(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                f4545a.mo5098b(viewHolder.itemView);
            }
        }

        /* JADX INFO: renamed from: a */
        private int m5060a(RecyclerView recyclerView) {
            if (this.f4548d == -1) {
                this.f4548d = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f4548d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void m5072a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).mo4296a(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.mo4313e()) {
                if (layoutManager.m4541h(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.m4545j(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.mo4316f()) {
                if (layoutManager.m4543i(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.m4547k(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m5070a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.m5092c();
                int iSave = canvas.save();
                mo5069a(canvas, recyclerView, recoverAnimation.f4557h, recoverAnimation.f4561l, recoverAnimation.f4562m, recoverAnimation.f4558i, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                mo5069a(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(iSave2);
            }
        }

        /* JADX INFO: renamed from: b */
        void m5079b(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            boolean z;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                int iSave = canvas.save();
                m5078b(canvas, recyclerView, recoverAnimation.f4557h, recoverAnimation.f4561l, recoverAnimation.f4562m, recoverAnimation.f4558i, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                m5078b(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(iSave2);
            }
            boolean z2 = false;
            int i3 = size - 1;
            while (i3 >= 0) {
                RecoverAnimation recoverAnimation2 = list.get(i3);
                if (recoverAnimation2.f4564o && !recoverAnimation2.f4560k) {
                    list.remove(i3);
                    z = z2;
                } else {
                    z = !recoverAnimation2.f4564o ? true : z2;
                }
                i3--;
                z2 = z;
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        /* JADX INFO: renamed from: d */
        public void m5086d(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            f4545a.mo5096a(viewHolder.itemView);
        }

        /* JADX INFO: renamed from: a */
        public void mo5069a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            f4545a.mo5095a(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        /* JADX INFO: renamed from: b */
        public void m5078b(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            f4545a.mo5097b(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        /* JADX INFO: renamed from: a */
        public long m5067a(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.m4445e() : itemAnimator.m4448g();
        }

        /* JADX INFO: renamed from: a */
        public int m5065a(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int interpolation = (int) (f4546b.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f) * ((int) (m5060a(recyclerView) * ((int) Math.signum(i2)) * f4547c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    public static abstract class SimpleCallback extends Callback {

        /* JADX INFO: renamed from: a */
        private int f4566a;

        /* JADX INFO: renamed from: b */
        private int f4567b;

        public SimpleCallback(int i, int i2) {
            this.f4566a = i2;
            this.f4567b = i;
        }

        /* JADX INFO: renamed from: e */
        public int m5093e(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f4566a;
        }

        /* JADX INFO: renamed from: f */
        public int m5094f(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f4567b;
        }

        @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
        /* JADX INFO: renamed from: a */
        public int mo5066a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return m5061b(m5094f(recyclerView, viewHolder), m5093e(recyclerView, viewHolder));
        }
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: b */
        private boolean f4550b = true;

        ItemTouchHelperGestureListener() {
        }

        /* JADX INFO: renamed from: a */
        void m5087a() {
            this.f4550b = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewM5047a;
            RecyclerView.ViewHolder childViewHolder;
            if (this.f4550b && (viewM5047a = ItemTouchHelper.this.m5047a(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.f4525p.getChildViewHolder(viewM5047a)) != null && ItemTouchHelper.this.f4521l.m5084c(ItemTouchHelper.this.f4525p, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.f4520k) {
                int iFindPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f4520k);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                ItemTouchHelper.this.f4512c = x;
                ItemTouchHelper.this.f4513d = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                ItemTouchHelper.this.f4517h = CropImageView.DEFAULT_ASPECT_RATIO;
                itemTouchHelper.f4516g = CropImageView.DEFAULT_ASPECT_RATIO;
                if (ItemTouchHelper.this.f4521l.m5073a()) {
                    ItemTouchHelper.this.m5049a(childViewHolder, 2);
                }
            }
        }
    }

    private static class RecoverAnimation implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: b */
        private float f4552b;

        /* JADX INFO: renamed from: d */
        final float f4553d;

        /* JADX INFO: renamed from: e */
        final float f4554e;

        /* JADX INFO: renamed from: f */
        final float f4555f;

        /* JADX INFO: renamed from: g */
        final float f4556g;

        /* JADX INFO: renamed from: h */
        final RecyclerView.ViewHolder f4557h;

        /* JADX INFO: renamed from: i */
        final int f4558i;

        /* JADX INFO: renamed from: j */
        final int f4559j;

        /* JADX INFO: renamed from: k */
        public boolean f4560k;

        /* JADX INFO: renamed from: l */
        float f4561l;

        /* JADX INFO: renamed from: m */
        float f4562m;

        /* JADX INFO: renamed from: n */
        boolean f4563n = false;

        /* JADX INFO: renamed from: o */
        boolean f4564o = false;

        /* JADX INFO: renamed from: a */
        private final ValueAnimator f4551a = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.f4558i = i2;
            this.f4559j = i;
            this.f4557h = viewHolder;
            this.f4553d = f;
            this.f4554e = f2;
            this.f4555f = f3;
            this.f4556g = f4;
            this.f4551a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v7.widget.helper.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.m5089a(valueAnimator.getAnimatedFraction());
                }
            });
            this.f4551a.setTarget(viewHolder.itemView);
            this.f4551a.addListener(this);
            m5089a(CropImageView.DEFAULT_ASPECT_RATIO);
        }

        /* JADX INFO: renamed from: a */
        public void m5090a(long j) {
            this.f4551a.setDuration(j);
        }

        /* JADX INFO: renamed from: a */
        public void m5088a() {
            this.f4557h.setIsRecyclable(false);
            this.f4551a.start();
        }

        /* JADX INFO: renamed from: b */
        public void m5091b() {
            this.f4551a.cancel();
        }

        /* JADX INFO: renamed from: a */
        public void m5089a(float f) {
            this.f4552b = f;
        }

        /* JADX INFO: renamed from: c */
        public void m5092c() {
            if (this.f4553d == this.f4555f) {
                this.f4561l = this.f4557h.itemView.getTranslationX();
            } else {
                this.f4561l = this.f4553d + (this.f4552b * (this.f4555f - this.f4553d));
            }
            if (this.f4554e == this.f4556g) {
                this.f4562m = this.f4557h.itemView.getTranslationY();
            } else {
                this.f4562m = this.f4554e + (this.f4552b * (this.f4556g - this.f4554e));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f4564o) {
                this.f4557h.setIsRecyclable(true);
            }
            this.f4564o = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            m5089a(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
