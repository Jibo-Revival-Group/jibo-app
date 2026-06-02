package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, ActionMenuView.ActionMenuChildView, View.OnClickListener {

    /* JADX INFO: renamed from: b */
    MenuItemImpl f3250b;

    /* JADX INFO: renamed from: c */
    MenuBuilder.ItemInvoker f3251c;

    /* JADX INFO: renamed from: d */
    PopupCallback f3252d;

    /* JADX INFO: renamed from: e */
    private CharSequence f3253e;

    /* JADX INFO: renamed from: f */
    private Drawable f3254f;

    /* JADX INFO: renamed from: g */
    private ForwardingListener f3255g;

    /* JADX INFO: renamed from: h */
    private boolean f3256h;

    /* JADX INFO: renamed from: i */
    private boolean f3257i;

    /* JADX INFO: renamed from: j */
    private int f3258j;

    /* JADX INFO: renamed from: k */
    private int f3259k;

    /* JADX INFO: renamed from: l */
    private int f3260l;

    public static abstract class PopupCallback {
        /* JADX INFO: renamed from: a */
        public abstract ShowableListMenu mo3513a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f3256h = m3506e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.f3258j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f3260l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f3259k = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3256h = m3506e();
        m3507f();
    }

    /* JADX INFO: renamed from: e */
    private boolean m3506e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f3259k = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f3250b;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public void mo336a(MenuItemImpl menuItemImpl, int i) {
        this.f3250b = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.m3631a((MenuView.ItemView) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f3255g == null) {
            this.f3255g = new ActionMenuItemForwardingListener();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3250b.hasSubMenu() && this.f3255g != null && this.f3255g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3251c != null) {
            this.f3251c.mo3554a(this.f3250b);
        }
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f3251c = itemInvoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f3252d = popupCallback;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public boolean mo337a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f3257i != z) {
            this.f3257i = z;
            if (this.f3250b != null) {
                this.f3250b.m3646h();
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3507f() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.f3253e);
        if (this.f3254f == null || (this.f3250b.m3651m() && (this.f3256h || this.f3257i))) {
            z = true;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f3253e : null);
        CharSequence contentDescription = this.f3250b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f3250b.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f3250b.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.m4985a(this, z3 ? null : this.f3250b.getTitle());
        } else {
            TooltipCompat.m4985a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3254f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f3260l) {
                float f = this.f3260l / intrinsicWidth;
                intrinsicWidth = this.f3260l;
                intrinsicHeight = (int) (intrinsicHeight * f);
            }
            if (intrinsicHeight > this.f3260l) {
                float f2 = this.f3260l / intrinsicHeight;
                intrinsicHeight = this.f3260l;
                intrinsicWidth = (int) (intrinsicWidth * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m3507f();
    }

    /* JADX INFO: renamed from: b */
    public boolean m3508b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f3253e = charSequence;
        m3507f();
    }

    @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
    /* JADX INFO: renamed from: c */
    public boolean mo3509c() {
        return m3508b() && this.f3250b.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
    /* JADX INFO: renamed from: d */
    public boolean mo3510d() {
        return m3508b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean zM3508b = m3508b();
        if (zM3508b && this.f3259k >= 0) {
            super.setPadding(this.f3259k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f3258j) : this.f3258j;
        if (mode != 1073741824 && this.f3258j > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (!zM3508b && this.f3254f != null) {
            super.setPadding((getMeasuredWidth() - this.f3254f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.ForwardingListener
        /* JADX INFO: renamed from: a */
        public ShowableListMenu mo3511a() {
            if (ActionMenuItemView.this.f3252d != null) {
                return ActionMenuItemView.this.f3252d.mo3513a();
            }
            return null;
        }

        @Override // android.support.v7.widget.ForwardingListener
        /* JADX INFO: renamed from: b */
        protected boolean mo3512b() {
            ShowableListMenu showableListMenuMo3511a;
            return ActionMenuItemView.this.f3251c != null && ActionMenuItemView.this.f3251c.mo3554a(ActionMenuItemView.this.f3250b) && (showableListMenuMo3511a = mo3511a()) != null && showableListMenuMo3511a.mo3548f();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
