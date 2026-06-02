package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.facebook.login.widget.ProfilePictureView;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {

    /* JADX INFO: renamed from: A */
    private int f2803A;

    /* JADX INFO: renamed from: C */
    private CharSequence f2805C;

    /* JADX INFO: renamed from: D */
    private Drawable f2806D;

    /* JADX INFO: renamed from: E */
    private CharSequence f2807E;

    /* JADX INFO: renamed from: F */
    private Drawable f2808F;

    /* JADX INFO: renamed from: G */
    private CharSequence f2809G;

    /* JADX INFO: renamed from: H */
    private Drawable f2810H;

    /* JADX INFO: renamed from: J */
    private Drawable f2812J;

    /* JADX INFO: renamed from: K */
    private ImageView f2813K;

    /* JADX INFO: renamed from: L */
    private TextView f2814L;

    /* JADX INFO: renamed from: M */
    private TextView f2815M;

    /* JADX INFO: renamed from: N */
    private View f2816N;

    /* JADX INFO: renamed from: O */
    private int f2817O;

    /* JADX INFO: renamed from: P */
    private int f2818P;

    /* JADX INFO: renamed from: Q */
    private boolean f2819Q;

    /* JADX INFO: renamed from: a */
    final AppCompatDialog f2822a;

    /* JADX INFO: renamed from: b */
    ListView f2823b;

    /* JADX INFO: renamed from: c */
    Button f2824c;

    /* JADX INFO: renamed from: d */
    Message f2825d;

    /* JADX INFO: renamed from: e */
    Button f2826e;

    /* JADX INFO: renamed from: f */
    Message f2827f;

    /* JADX INFO: renamed from: g */
    Button f2828g;

    /* JADX INFO: renamed from: h */
    Message f2829h;

    /* JADX INFO: renamed from: i */
    NestedScrollView f2830i;

    /* JADX INFO: renamed from: j */
    ListAdapter f2831j;

    /* JADX INFO: renamed from: l */
    int f2833l;

    /* JADX INFO: renamed from: m */
    int f2834m;

    /* JADX INFO: renamed from: n */
    int f2835n;

    /* JADX INFO: renamed from: o */
    int f2836o;

    /* JADX INFO: renamed from: p */
    Handler f2837p;

    /* JADX INFO: renamed from: q */
    private final Context f2838q;

    /* JADX INFO: renamed from: r */
    private final Window f2839r;

    /* JADX INFO: renamed from: s */
    private final int f2840s;

    /* JADX INFO: renamed from: t */
    private CharSequence f2841t;

    /* JADX INFO: renamed from: u */
    private CharSequence f2842u;

    /* JADX INFO: renamed from: v */
    private View f2843v;

    /* JADX INFO: renamed from: w */
    private int f2844w;

    /* JADX INFO: renamed from: x */
    private int f2845x;

    /* JADX INFO: renamed from: y */
    private int f2846y;

    /* JADX INFO: renamed from: z */
    private int f2847z;

    /* JADX INFO: renamed from: B */
    private boolean f2804B = false;

    /* JADX INFO: renamed from: I */
    private int f2811I = 0;

    /* JADX INFO: renamed from: k */
    int f2832k = -1;

    /* JADX INFO: renamed from: R */
    private int f2820R = 0;

    /* JADX INFO: renamed from: S */
    private final View.OnClickListener f2821S = new View.OnClickListener() { // from class: android.support.v7.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            if (view == AlertController.this.f2824c && AlertController.this.f2825d != null) {
                messageObtain = Message.obtain(AlertController.this.f2825d);
            } else if (view == AlertController.this.f2826e && AlertController.this.f2827f != null) {
                messageObtain = Message.obtain(AlertController.this.f2827f);
            } else if (view == AlertController.this.f2828g && AlertController.this.f2829h != null) {
                messageObtain = Message.obtain(AlertController.this.f2829h);
            } else {
                messageObtain = null;
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController.this.f2837p.obtainMessage(1, AlertController.this.f2822a).sendToTarget();
        }
    };

    private static final class ButtonHandler extends Handler {

        /* JADX INFO: renamed from: a */
        private WeakReference<DialogInterface> f2915a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f2915a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case ProfilePictureView.NORMAL /* -3 */:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.f2915a.get(), message.what);
                    break;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3192a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f2838q = context;
        this.f2822a = appCompatDialog;
        this.f2839r = window;
        this.f2837p = new ButtonHandler(appCompatDialog);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f2817O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f2818P = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f2833l = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f2834m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f2835n = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f2836o = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f2819Q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f2840s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        appCompatDialog.m3344b(1);
    }

    /* JADX INFO: renamed from: a */
    static boolean m3193a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m3193a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m3199a() {
        this.f2822a.setContentView(m3194b());
        m3196c();
    }

    /* JADX INFO: renamed from: b */
    private int m3194b() {
        if (this.f2818P == 0) {
            return this.f2817O;
        }
        if (this.f2820R == 1) {
            return this.f2818P;
        }
        return this.f2817O;
    }

    /* JADX INFO: renamed from: a */
    public void m3204a(CharSequence charSequence) {
        this.f2841t = charSequence;
        if (this.f2814L != null) {
            this.f2814L.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3207b(View view) {
        this.f2816N = view;
    }

    /* JADX INFO: renamed from: b */
    public void m3208b(CharSequence charSequence) {
        this.f2842u = charSequence;
        if (this.f2815M != null) {
            this.f2815M.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3200a(int i) {
        this.f2843v = null;
        this.f2844w = i;
        this.f2804B = false;
    }

    /* JADX INFO: renamed from: c */
    public void m3211c(View view) {
        this.f2843v = view;
        this.f2844w = 0;
        this.f2804B = false;
    }

    /* JADX INFO: renamed from: a */
    public void m3203a(View view, int i, int i2, int i3, int i4) {
        this.f2843v = view;
        this.f2844w = 0;
        this.f2804B = true;
        this.f2845x = i;
        this.f2846y = i2;
        this.f2847z = i3;
        this.f2803A = i4;
    }

    /* JADX INFO: renamed from: a */
    public void m3201a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f2837p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case ProfilePictureView.NORMAL /* -3 */:
                this.f2809G = charSequence;
                this.f2829h = message;
                this.f2810H = drawable;
                return;
            case -2:
                this.f2807E = charSequence;
                this.f2827f = message;
                this.f2808F = drawable;
                return;
            case -1:
                this.f2805C = charSequence;
                this.f2825d = message;
                this.f2806D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3206b(int i) {
        this.f2812J = null;
        this.f2811I = i;
        if (this.f2813K != null) {
            if (i != 0) {
                this.f2813K.setVisibility(0);
                this.f2813K.setImageResource(this.f2811I);
            } else {
                this.f2813K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3202a(Drawable drawable) {
        this.f2812J = drawable;
        this.f2811I = 0;
        if (this.f2813K != null) {
            if (drawable != null) {
                this.f2813K.setVisibility(0);
                this.f2813K.setImageDrawable(drawable);
            } else {
                this.f2813K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public int m3210c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f2838q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: renamed from: d */
    public Button m3212d(int i) {
        switch (i) {
            case ProfilePictureView.NORMAL /* -3 */:
                return this.f2828g;
            case -2:
                return this.f2826e;
            case -1:
                return this.f2824c;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m3205a(int i, KeyEvent keyEvent) {
        return this.f2830i != null && this.f2830i.m3049a(keyEvent);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3209b(int i, KeyEvent keyEvent) {
        return this.f2830i != null && this.f2830i.m3049a(keyEvent);
    }

    /* JADX INFO: renamed from: a */
    private ViewGroup m3187a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    /* JADX INFO: renamed from: c */
    private void m3196c() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3 = this.f2839r.findViewById(R.id.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R.id.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R.id.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id.customPanel);
        m3189a(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupM3187a = m3187a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM3187a2 = m3187a(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM3187a3 = m3187a(viewFindViewById9, viewFindViewById6);
        m3197c(viewGroupM3187a2);
        m3198d(viewGroupM3187a3);
        m3195b(viewGroupM3187a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupM3187a == null || viewGroupM3187a.getVisibility() == 8) ? false : true;
        boolean z3 = (viewGroupM3187a3 == null || viewGroupM3187a3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupM3187a2 != null && (viewFindViewById2 = viewGroupM3187a2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2) {
            if (this.f2830i != null) {
                this.f2830i.setClipToPadding(true);
            }
            View viewFindViewById10 = null;
            if (this.f2842u != null || this.f2823b != null) {
                viewFindViewById10 = viewGroupM3187a.findViewById(R.id.titleDividerNoCustom);
            }
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM3187a2 != null && (viewFindViewById = viewGroupM3187a2.findViewById(R.id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (this.f2823b instanceof RecycleListView) {
            ((RecycleListView) this.f2823b).m3216a(z2, z3);
        }
        if (!z) {
            View view = this.f2823b != null ? this.f2823b : this.f2830i;
            if (view != null) {
                m3190a(viewGroupM3187a2, view, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f2823b;
        if (listView != null && this.f2831j != null) {
            listView.setAdapter(this.f2831j);
            int i = this.f2832k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3190a(ViewGroup viewGroup, View view, int i, int i2) {
        final View view2 = null;
        final View viewFindViewById = this.f2839r.findViewById(R.id.scrollIndicatorUp);
        View viewFindViewById2 = this.f2839r.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.m2576a(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (i & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById != null || view2 != null) {
            if (this.f2842u != null) {
                this.f2830i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: android.support.v7.app.AlertController.2
                    @Override // android.support.v4.widget.NestedScrollView.OnScrollChangeListener
                    /* JADX INFO: renamed from: a */
                    public void mo3057a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                        AlertController.m3188a(nestedScrollView, viewFindViewById, view2);
                    }
                });
                this.f2830i.post(new Runnable() { // from class: android.support.v7.app.AlertController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.m3188a(AlertController.this.f2830i, viewFindViewById, view2);
                    }
                });
            } else {
                if (this.f2823b != null) {
                    this.f2823b.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.app.AlertController.4
                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView absListView, int i3) {
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                            AlertController.m3188a(absListView, viewFindViewById, view2);
                        }
                    });
                    this.f2823b.post(new Runnable() { // from class: android.support.v7.app.AlertController.5
                        @Override // java.lang.Runnable
                        public void run() {
                            AlertController.m3188a(AlertController.this.f2823b, viewFindViewById, view2);
                        }
                    });
                    return;
                }
                if (viewFindViewById != null) {
                    viewGroup.removeView(viewFindViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3189a(ViewGroup viewGroup) {
        View viewInflate;
        if (this.f2843v != null) {
            viewInflate = this.f2843v;
        } else if (this.f2844w != 0) {
            viewInflate = LayoutInflater.from(this.f2838q).inflate(this.f2844w, viewGroup, false);
        } else {
            viewInflate = null;
        }
        boolean z = viewInflate != null;
        if (!z || !m3193a(viewInflate)) {
            this.f2839r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f2839r.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f2804B) {
                frameLayout.setPadding(this.f2845x, this.f2846y, this.f2847z, this.f2803A);
            }
            if (this.f2823b != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f3955g = CropImageView.DEFAULT_ASPECT_RATIO;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: b */
    private void m3195b(ViewGroup viewGroup) {
        if (this.f2816N != null) {
            viewGroup.addView(this.f2816N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f2839r.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.f2813K = (ImageView) this.f2839r.findViewById(android.R.id.icon);
        if ((!TextUtils.isEmpty(this.f2841t)) && this.f2819Q) {
            this.f2814L = (TextView) this.f2839r.findViewById(R.id.alertTitle);
            this.f2814L.setText(this.f2841t);
            if (this.f2811I != 0) {
                this.f2813K.setImageResource(this.f2811I);
                return;
            } else if (this.f2812J != null) {
                this.f2813K.setImageDrawable(this.f2812J);
                return;
            } else {
                this.f2814L.setPadding(this.f2813K.getPaddingLeft(), this.f2813K.getPaddingTop(), this.f2813K.getPaddingRight(), this.f2813K.getPaddingBottom());
                this.f2813K.setVisibility(8);
                return;
            }
        }
        this.f2839r.findViewById(R.id.title_template).setVisibility(8);
        this.f2813K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    private void m3197c(ViewGroup viewGroup) {
        this.f2830i = (NestedScrollView) this.f2839r.findViewById(R.id.scrollView);
        this.f2830i.setFocusable(false);
        this.f2830i.setNestedScrollingEnabled(false);
        this.f2815M = (TextView) viewGroup.findViewById(android.R.id.message);
        if (this.f2815M != null) {
            if (this.f2842u != null) {
                this.f2815M.setText(this.f2842u);
                return;
            }
            this.f2815M.setVisibility(8);
            this.f2830i.removeView(this.f2815M);
            if (this.f2823b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f2830i.getParent();
                int iIndexOfChild = viewGroup2.indexOfChild(this.f2830i);
                viewGroup2.removeViewAt(iIndexOfChild);
                viewGroup2.addView(this.f2823b, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m3188a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3198d(ViewGroup viewGroup) {
        int i;
        this.f2824c = (Button) viewGroup.findViewById(android.R.id.button1);
        this.f2824c.setOnClickListener(this.f2821S);
        if (TextUtils.isEmpty(this.f2805C) && this.f2806D == null) {
            this.f2824c.setVisibility(8);
            i = 0;
        } else {
            this.f2824c.setText(this.f2805C);
            if (this.f2806D != null) {
                this.f2806D.setBounds(0, 0, this.f2840s, this.f2840s);
                this.f2824c.setCompoundDrawables(this.f2806D, null, null, null);
            }
            this.f2824c.setVisibility(0);
            i = 1;
        }
        this.f2826e = (Button) viewGroup.findViewById(android.R.id.button2);
        this.f2826e.setOnClickListener(this.f2821S);
        if (TextUtils.isEmpty(this.f2807E) && this.f2808F == null) {
            this.f2826e.setVisibility(8);
        } else {
            this.f2826e.setText(this.f2807E);
            if (this.f2808F != null) {
                this.f2808F.setBounds(0, 0, this.f2840s, this.f2840s);
                this.f2826e.setCompoundDrawables(this.f2808F, null, null, null);
            }
            this.f2826e.setVisibility(0);
            i |= 2;
        }
        this.f2828g = (Button) viewGroup.findViewById(android.R.id.button3);
        this.f2828g.setOnClickListener(this.f2821S);
        if (TextUtils.isEmpty(this.f2809G) && this.f2810H == null) {
            this.f2828g.setVisibility(8);
        } else {
            this.f2828g.setText(this.f2809G);
            if (this.f2806D != null) {
                this.f2806D.setBounds(0, 0, this.f2840s, this.f2840s);
                this.f2824c.setCompoundDrawables(this.f2806D, null, null, null);
            }
            this.f2828g.setVisibility(0);
            i |= 4;
        }
        if (m3192a(this.f2838q)) {
            if (i == 1) {
                m3191a(this.f2824c);
            } else if (i == 2) {
                m3191a(this.f2826e);
            } else if (i == 4) {
                m3191a(this.f2828g);
            }
        }
        if (!(i != 0)) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3191a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a */
        private final int f2916a;

        /* JADX INFO: renamed from: b */
        private final int f2917b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f2917b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f2916a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        /* JADX INFO: renamed from: a */
        public void m3216a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f2916a, getPaddingRight(), z2 ? getPaddingBottom() : this.f2917b);
            }
        }
    }

    public static class AlertParams {

        /* JADX INFO: renamed from: A */
        public int f2861A;

        /* JADX INFO: renamed from: B */
        public int f2862B;

        /* JADX INFO: renamed from: C */
        public int f2863C;

        /* JADX INFO: renamed from: D */
        public int f2864D;

        /* JADX INFO: renamed from: F */
        public boolean[] f2866F;

        /* JADX INFO: renamed from: G */
        public boolean f2867G;

        /* JADX INFO: renamed from: H */
        public boolean f2868H;

        /* JADX INFO: renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f2870J;

        /* JADX INFO: renamed from: K */
        public Cursor f2871K;

        /* JADX INFO: renamed from: L */
        public String f2872L;

        /* JADX INFO: renamed from: M */
        public String f2873M;

        /* JADX INFO: renamed from: N */
        public AdapterView.OnItemSelectedListener f2874N;

        /* JADX INFO: renamed from: O */
        public OnPrepareListViewListener f2875O;

        /* JADX INFO: renamed from: a */
        public final Context f2877a;

        /* JADX INFO: renamed from: b */
        public final LayoutInflater f2878b;

        /* JADX INFO: renamed from: d */
        public Drawable f2880d;

        /* JADX INFO: renamed from: f */
        public CharSequence f2882f;

        /* JADX INFO: renamed from: g */
        public View f2883g;

        /* JADX INFO: renamed from: h */
        public CharSequence f2884h;

        /* JADX INFO: renamed from: i */
        public CharSequence f2885i;

        /* JADX INFO: renamed from: j */
        public Drawable f2886j;

        /* JADX INFO: renamed from: k */
        public DialogInterface.OnClickListener f2887k;

        /* JADX INFO: renamed from: l */
        public CharSequence f2888l;

        /* JADX INFO: renamed from: m */
        public Drawable f2889m;

        /* JADX INFO: renamed from: n */
        public DialogInterface.OnClickListener f2890n;

        /* JADX INFO: renamed from: o */
        public CharSequence f2891o;

        /* JADX INFO: renamed from: p */
        public Drawable f2892p;

        /* JADX INFO: renamed from: q */
        public DialogInterface.OnClickListener f2893q;

        /* JADX INFO: renamed from: s */
        public DialogInterface.OnCancelListener f2895s;

        /* JADX INFO: renamed from: t */
        public DialogInterface.OnDismissListener f2896t;

        /* JADX INFO: renamed from: u */
        public DialogInterface.OnKeyListener f2897u;

        /* JADX INFO: renamed from: v */
        public CharSequence[] f2898v;

        /* JADX INFO: renamed from: w */
        public ListAdapter f2899w;

        /* JADX INFO: renamed from: x */
        public DialogInterface.OnClickListener f2900x;

        /* JADX INFO: renamed from: y */
        public int f2901y;

        /* JADX INFO: renamed from: z */
        public View f2902z;

        /* JADX INFO: renamed from: c */
        public int f2879c = 0;

        /* JADX INFO: renamed from: e */
        public int f2881e = 0;

        /* JADX INFO: renamed from: E */
        public boolean f2865E = false;

        /* JADX INFO: renamed from: I */
        public int f2869I = -1;

        /* JADX INFO: renamed from: P */
        public boolean f2876P = true;

        /* JADX INFO: renamed from: r */
        public boolean f2894r = true;

        public interface OnPrepareListViewListener {
            /* JADX INFO: renamed from: a */
            void m3215a(ListView listView);
        }

        public AlertParams(Context context) {
            this.f2877a = context;
            this.f2878b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX INFO: renamed from: a */
        public void m3214a(AlertController alertController) {
            if (this.f2883g != null) {
                alertController.m3207b(this.f2883g);
            } else {
                if (this.f2882f != null) {
                    alertController.m3204a(this.f2882f);
                }
                if (this.f2880d != null) {
                    alertController.m3202a(this.f2880d);
                }
                if (this.f2879c != 0) {
                    alertController.m3206b(this.f2879c);
                }
                if (this.f2881e != 0) {
                    alertController.m3206b(alertController.m3210c(this.f2881e));
                }
            }
            if (this.f2884h != null) {
                alertController.m3208b(this.f2884h);
            }
            if (this.f2885i != null || this.f2886j != null) {
                alertController.m3201a(-1, this.f2885i, this.f2887k, (Message) null, this.f2886j);
            }
            if (this.f2888l != null || this.f2889m != null) {
                alertController.m3201a(-2, this.f2888l, this.f2890n, (Message) null, this.f2889m);
            }
            if (this.f2891o != null || this.f2892p != null) {
                alertController.m3201a(-3, this.f2891o, this.f2893q, (Message) null, this.f2892p);
            }
            if (this.f2898v != null || this.f2871K != null || this.f2899w != null) {
                m3213b(alertController);
            }
            if (this.f2902z != null) {
                if (this.f2865E) {
                    alertController.m3203a(this.f2902z, this.f2861A, this.f2862B, this.f2863C, this.f2864D);
                    return;
                } else {
                    alertController.m3211c(this.f2902z);
                    return;
                }
            }
            if (this.f2901y != 0) {
                alertController.m3200a(this.f2901y);
            }
        }

        /* JADX INFO: renamed from: b */
        private void m3213b(final AlertController alertController) {
            int i;
            ListAdapter checkedItemAdapter;
            int i2 = android.R.id.text1;
            boolean z = false;
            final RecycleListView recycleListView = (RecycleListView) this.f2878b.inflate(alertController.f2833l, (ViewGroup) null);
            if (this.f2867G) {
                if (this.f2871K == null) {
                    checkedItemAdapter = new ArrayAdapter<CharSequence>(this.f2877a, alertController.f2834m, i2, this.f2898v) { // from class: android.support.v7.app.AlertController.AlertParams.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i3, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i3, view, viewGroup);
                            if (AlertParams.this.f2866F != null && AlertParams.this.f2866F[i3]) {
                                recycleListView.setItemChecked(i3, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    checkedItemAdapter = new CursorAdapter(this.f2877a, this.f2871K, z) { // from class: android.support.v7.app.AlertController.AlertParams.2

                        /* JADX INFO: renamed from: d */
                        private final int f2908d;

                        /* JADX INFO: renamed from: e */
                        private final int f2909e;

                        {
                            Cursor cursor = getCursor();
                            this.f2908d = cursor.getColumnIndexOrThrow(AlertParams.this.f2872L);
                            this.f2909e = cursor.getColumnIndexOrThrow(AlertParams.this.f2873M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(android.R.id.text1)).setText(cursor.getString(this.f2908d));
                            recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2909e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return AlertParams.this.f2878b.inflate(alertController.f2834m, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.f2868H) {
                    i = alertController.f2835n;
                } else {
                    i = alertController.f2836o;
                }
                if (this.f2871K != null) {
                    checkedItemAdapter = new SimpleCursorAdapter(this.f2877a, i, this.f2871K, new String[]{this.f2872L}, new int[]{android.R.id.text1});
                } else if (this.f2899w != null) {
                    checkedItemAdapter = this.f2899w;
                } else {
                    checkedItemAdapter = new CheckedItemAdapter(this.f2877a, i, android.R.id.text1, this.f2898v);
                }
            }
            if (this.f2875O != null) {
                this.f2875O.m3215a(recycleListView);
            }
            alertController.f2831j = checkedItemAdapter;
            alertController.f2832k = this.f2869I;
            if (this.f2900x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        AlertParams.this.f2900x.onClick(alertController.f2822a, i3);
                        if (!AlertParams.this.f2868H) {
                            alertController.f2822a.dismiss();
                        }
                    }
                });
            } else if (this.f2870J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        if (AlertParams.this.f2866F != null) {
                            AlertParams.this.f2866F[i3] = recycleListView.isItemChecked(i3);
                        }
                        AlertParams.this.f2870J.onClick(alertController.f2822a, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            if (this.f2874N != null) {
                recycleListView.setOnItemSelectedListener(this.f2874N);
            }
            if (this.f2868H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f2867G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f2823b = recycleListView;
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }
    }
}
