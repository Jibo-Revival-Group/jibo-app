package android.support.design.widget;

import android.R;
import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* JADX INFO: renamed from: a */
    private static final int[] f580a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b */
    private boolean f581b;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewCompat.m2583a(this, new AccessibilityDelegateCompat() { // from class: android.support.design.widget.CheckableImageButton.1
            @Override // android.support.v4.view.AccessibilityDelegateCompat
            /* JADX INFO: renamed from: a */
            public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
                super.mo559a(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // android.support.v4.view.AccessibilityDelegateCompat
            /* JADX INFO: renamed from: a */
            public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.mo365a(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m2787a(true);
                accessibilityNodeInfoCompat.m2795b(CheckableImageButton.this.isChecked());
            }
        });
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f581b != z) {
            this.f581b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f581b;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f581b);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.f581b ? mergeDrawableStates(super.onCreateDrawableState(f580a.length + i), f580a) : super.onCreateDrawableState(i);
    }
}
