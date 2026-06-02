package android.support.design.widget;

import android.content.Context;
import android.support.design.R;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.BaseTransientBottomBar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public final class Snackbar extends BaseTransientBottomBar<Snackbar> {

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        @Override // android.support.design.widget.BaseTransientBottomBar.BaseCallback
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo507a(Snackbar snackbar) {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.BaseCallback
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo508a(Snackbar snackbar, int i) {
        }
    }

    private Snackbar(ViewGroup viewGroup, View view, BaseTransientBottomBar.ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
    }

    /* JADX INFO: renamed from: a */
    public static Snackbar m804a(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroupM805a = m805a(view);
        if (viewGroupM805a == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(viewGroupM805a.getContext()).inflate(R.layout.design_layout_snackbar_include, viewGroupM805a, false);
        Snackbar snackbar = new Snackbar(viewGroupM805a, snackbarContentLayout, snackbarContentLayout);
        snackbar.m807a(charSequence);
        snackbar.m486a(i);
        return snackbar;
    }

    /* JADX INFO: renamed from: a */
    public static Snackbar m803a(View view, int i, int i2) {
        return m804a(view, view.getResources().getText(i), i2);
    }

    /* JADX INFO: renamed from: a */
    private static ViewGroup m805a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                Object parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    /* JADX INFO: renamed from: a */
    public Snackbar m807a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f503b.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Snackbar m806a(int i, View.OnClickListener onClickListener) {
        return m808a(m485a().getText(i), onClickListener);
    }

    /* JADX INFO: renamed from: a */
    public Snackbar m808a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f503b.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.Snackbar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.m489b(1);
                }
            });
        }
        return this;
    }

    /* JADX INFO: renamed from: e */
    public Snackbar m809e(int i) {
        ((SnackbarContentLayout) this.f503b.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }
}
