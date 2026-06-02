package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.design.R;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a */
    boolean f571a;

    /* JADX INFO: renamed from: b */
    private BottomSheetBehavior<FrameLayout> f572b;

    /* JADX INFO: renamed from: c */
    private boolean f573c;

    /* JADX INFO: renamed from: d */
    private boolean f574d;

    /* JADX INFO: renamed from: e */
    private BottomSheetBehavior.BottomSheetCallback f575e;

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(Context context, int i) {
        super(context, m555a(context, i));
        this.f571a = true;
        this.f573c = true;
        this.f575e = new BottomSheetBehavior.BottomSheetCallback() { // from class: android.support.design.widget.BottomSheetDialog.4
            @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
            /* JADX INFO: renamed from: a */
            public void mo551a(View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
            /* JADX INFO: renamed from: a */
            public void mo550a(View view, float f) {
            }
        };
        m3344b(1);
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(m556a(i, null, null));
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(m556a(0, view, null));
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m556a(0, view, layoutParams));
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f571a != z) {
            this.f571a = z;
            if (this.f572b != null) {
                this.f572b.m533a(z);
            }
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.f572b != null) {
            this.f572b.m537b(4);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f571a) {
            this.f571a = true;
        }
        this.f573c = z;
        this.f574d = true;
    }

    /* JADX INFO: renamed from: a */
    private View m556a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.f572b = BottomSheetBehavior.m527b(frameLayout2);
        this.f572b.m530a(this.f575e);
        this.f572b.m533a(this.f571a);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.BottomSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BottomSheetDialog.this.f571a && BottomSheetDialog.this.isShowing() && BottomSheetDialog.this.m557a()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.m2583a(frameLayout2, new AccessibilityDelegateCompat() { // from class: android.support.design.widget.BottomSheetDialog.2
            @Override // android.support.v4.view.AccessibilityDelegateCompat
            /* JADX INFO: renamed from: a */
            public void mo365a(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.mo365a(view2, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.f571a) {
                    accessibilityNodeInfoCompat.m2782a(1048576);
                    accessibilityNodeInfoCompat.m2825n(true);
                } else {
                    accessibilityNodeInfoCompat.m2825n(false);
                }
            }

            @Override // android.support.v4.view.AccessibilityDelegateCompat
            /* JADX INFO: renamed from: a */
            public boolean mo558a(View view2, int i2, Bundle bundle) {
                if (i2 != 1048576 || !BottomSheetDialog.this.f571a) {
                    return super.mo558a(view2, i2, bundle);
                }
                BottomSheetDialog.this.cancel();
                return true;
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: android.support.design.widget.BottomSheetDialog.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    /* JADX INFO: renamed from: a */
    boolean m557a() {
        if (!this.f574d) {
            if (Build.VERSION.SDK_INT < 11) {
                this.f573c = true;
            } else {
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
                this.f573c = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            }
            this.f574d = true;
        }
        return this.f573c;
    }

    /* JADX INFO: renamed from: a */
    private static int m555a(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.Theme_Design_Light_BottomSheetDialog;
        }
        return i;
    }
}
