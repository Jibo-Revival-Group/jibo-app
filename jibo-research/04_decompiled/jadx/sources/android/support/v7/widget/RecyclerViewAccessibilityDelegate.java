package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a */
    final RecyclerView f4154a;

    /* JADX INFO: renamed from: c */
    final AccessibilityDelegateCompat f4155c = new ItemDelegate(this);

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f4154a = recyclerView;
    }

    /* JADX INFO: renamed from: b */
    boolean m4677b() {
        return this.f4154a.hasPendingAdapterUpdates();
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    /* JADX INFO: renamed from: a */
    public boolean mo558a(View view, int i, Bundle bundle) {
        if (super.mo558a(view, i, bundle)) {
            return true;
        }
        if (!m4677b() && this.f4154a.getLayoutManager() != null) {
            return this.f4154a.getLayoutManager().m4502a(i, bundle);
        }
        return false;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    /* JADX INFO: renamed from: a */
    public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.mo365a(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.m2793b((CharSequence) RecyclerView.class.getName());
        if (!m4677b() && this.f4154a.getLayoutManager() != null) {
            this.f4154a.getLayoutManager().m4486a(accessibilityNodeInfoCompat);
        }
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    /* JADX INFO: renamed from: a */
    public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
        super.mo559a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m4677b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo4297a(accessibilityEvent);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public AccessibilityDelegateCompat m4678c() {
        return this.f4155c;
    }

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a */
        final RecyclerViewAccessibilityDelegate f4156a;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f4156a = recyclerViewAccessibilityDelegate;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo365a(view, accessibilityNodeInfoCompat);
            if (!this.f4156a.m4677b() && this.f4156a.f4154a.getLayoutManager() != null) {
                this.f4156a.f4154a.getLayoutManager().m4499a(view, accessibilityNodeInfoCompat);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public boolean mo558a(View view, int i, Bundle bundle) {
            if (super.mo558a(view, i, bundle)) {
                return true;
            }
            if (!this.f4156a.m4677b() && this.f4156a.f4154a.getLayoutManager() != null) {
                return this.f4156a.f4154a.getLayoutManager().m4511a(view, i, bundle);
            }
            return false;
        }
    }
}
