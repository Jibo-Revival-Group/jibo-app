package android.support.v4.view;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a */
    private static final AccessibilityDelegateBaseImpl f2249a;

    /* JADX INFO: renamed from: c */
    private static final View.AccessibilityDelegate f2250c;

    /* JADX INFO: renamed from: b */
    final View.AccessibilityDelegate f2251b = f2249a.mo2485a(this);

    static class AccessibilityDelegateBaseImpl {
        AccessibilityDelegateBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public View.AccessibilityDelegate mo2485a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo2483d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo559a(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    accessibilityDelegateCompat.mo365a(view, AccessibilityNodeInfoCompat.m2779a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo939b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo2481a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    accessibilityDelegateCompat.m2480a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.m2482c(view, accessibilityEvent);
                }
            };
        }

        /* JADX INFO: renamed from: a */
        public AccessibilityNodeProviderCompat mo2484a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2486a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class AccessibilityDelegateApi16Impl extends AccessibilityDelegateBaseImpl {
        AccessibilityDelegateApi16Impl() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl
        /* JADX INFO: renamed from: a */
        public View.AccessibilityDelegate mo2485a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateApi16Impl.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo2483d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo559a(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    accessibilityDelegateCompat.mo365a(view, AccessibilityNodeInfoCompat.m2779a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo939b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo2481a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    accessibilityDelegateCompat.m2480a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.m2482c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    AccessibilityNodeProviderCompat accessibilityNodeProviderCompatM2478a = accessibilityDelegateCompat.m2478a(view);
                    if (accessibilityNodeProviderCompatM2478a != null) {
                        return (AccessibilityNodeProvider) accessibilityNodeProviderCompatM2478a.m2837a();
                    }
                    return null;
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return accessibilityDelegateCompat.mo558a(view, i, bundle);
                }
            };
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl
        /* JADX INFO: renamed from: a */
        public AccessibilityNodeProviderCompat mo2484a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2486a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f2249a = new AccessibilityDelegateApi16Impl();
        } else {
            f2249a = new AccessibilityDelegateBaseImpl();
        }
        f2250c = new View.AccessibilityDelegate();
    }

    /* JADX INFO: renamed from: a */
    View.AccessibilityDelegate m2479a() {
        return this.f2251b;
    }

    /* JADX INFO: renamed from: a */
    public void m2480a(View view, int i) {
        f2250c.sendAccessibilityEvent(view, i);
    }

    /* JADX INFO: renamed from: c */
    public void m2482c(View view, AccessibilityEvent accessibilityEvent) {
        f2250c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: d */
    public boolean mo2483d(View view, AccessibilityEvent accessibilityEvent) {
        return f2250c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: b */
    public void mo939b(View view, AccessibilityEvent accessibilityEvent) {
        f2250c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: a */
    public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
        f2250c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: a */
    public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f2250c.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.m2781a());
    }

    /* JADX INFO: renamed from: a */
    public boolean mo2481a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f2250c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: a */
    public AccessibilityNodeProviderCompat m2478a(View view) {
        return f2249a.mo2484a(f2250c, view);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo558a(View view, int i, Bundle bundle) {
        return f2249a.mo2486a(f2250c, view, i, bundle);
    }
}
