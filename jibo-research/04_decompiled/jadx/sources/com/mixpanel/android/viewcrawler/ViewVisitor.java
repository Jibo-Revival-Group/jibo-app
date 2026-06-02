package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.Pathfinder;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
abstract class ViewVisitor implements Pathfinder.Accumulator {

    /* JADX INFO: renamed from: a */
    private final List<Pathfinder.PathElement> f12219a;

    /* JADX INFO: renamed from: b */
    private final Pathfinder f12220b = new Pathfinder();

    public interface OnEventListener {
        /* JADX INFO: renamed from: a */
        void mo12048a(View view, String str, boolean z);
    }

    public interface OnLayoutErrorListener {
        /* JADX INFO: renamed from: a */
        void mo12110a(LayoutErrorMessage layoutErrorMessage);
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo12147a();

    public static class LayoutErrorMessage {

        /* JADX INFO: renamed from: a */
        private final String f12231a;

        /* JADX INFO: renamed from: b */
        private final String f12232b;

        public LayoutErrorMessage(String str, String str2) {
            this.f12231a = str;
            this.f12232b = str2;
        }

        /* JADX INFO: renamed from: a */
        public String m12160a() {
            return this.f12231a;
        }

        /* JADX INFO: renamed from: b */
        public String m12161b() {
            return this.f12232b;
        }
    }

    public static class PropertySetVisitor extends ViewVisitor {

        /* JADX INFO: renamed from: a */
        private final Caller f12245a;

        /* JADX INFO: renamed from: b */
        private final Caller f12246b;

        /* JADX INFO: renamed from: c */
        private final WeakHashMap<View, Object> f12247c;

        /* JADX INFO: renamed from: d */
        private final Object[] f12248d;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ void mo12149b(View view) {
            super.mo12149b(view);
        }

        public PropertySetVisitor(List<Pathfinder.PathElement> list, Caller caller, Caller caller2) {
            super(list);
            this.f12245a = caller;
            this.f12246b = caller2;
            this.f12248d = new Object[1];
            this.f12247c = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: a */
        public void mo12147a() {
            for (Map.Entry<View, Object> entry : this.f12247c.entrySet()) {
                View key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    this.f12248d[0] = value;
                    this.f12245a.m12041a(key, this.f12248d);
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        /* JADX INFO: renamed from: a */
        public void mo12091a(View view) {
            if (this.f12246b != null) {
                Object[] objArrM12043a = this.f12245a.m12043a();
                if (1 == objArrM12043a.length) {
                    Object obj = objArrM12043a[0];
                    Object objM12040a = this.f12246b.m12040a(view);
                    if (obj != objM12040a) {
                        if (obj != null) {
                            if ((obj instanceof Bitmap) && (objM12040a instanceof Bitmap)) {
                                if (((Bitmap) obj).sameAs((Bitmap) objM12040a)) {
                                    return;
                                }
                            } else if ((obj instanceof BitmapDrawable) && (objM12040a instanceof BitmapDrawable)) {
                                Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
                                Bitmap bitmap2 = ((BitmapDrawable) objM12040a).getBitmap();
                                if (bitmap != null && bitmap.sameAs(bitmap2)) {
                                    return;
                                }
                            } else if (obj.equals(objM12040a)) {
                                return;
                            }
                        }
                        if (!(objM12040a instanceof Bitmap) && !(objM12040a instanceof BitmapDrawable) && !this.f12247c.containsKey(view)) {
                            this.f12248d[0] = objM12040a;
                            if (this.f12245a.m12042a(this.f12248d)) {
                                this.f12247c.put(view, objM12040a);
                            } else {
                                this.f12247c.put(view, null);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            this.f12245a.m12040a(view);
        }
    }

    private static class CycleDetector {
        private CycleDetector() {
        }

        /* JADX INFO: renamed from: a */
        public boolean m12157a(TreeMap<View, List<View>> treeMap) {
            ArrayList arrayList = new ArrayList();
            while (!treeMap.isEmpty()) {
                if (!m12156a(treeMap, treeMap.firstKey(), arrayList)) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: renamed from: a */
        private boolean m12156a(TreeMap<View, List<View>> treeMap, View view, List<View> list) {
            if (list.contains(view)) {
                return false;
            }
            if (treeMap.containsKey(view)) {
                List<View> listRemove = treeMap.remove(view);
                list.add(view);
                int size = listRemove.size();
                for (int i = 0; i < size; i++) {
                    if (!m12156a(treeMap, listRemove.get(i), list)) {
                        return false;
                    }
                }
                list.remove(view);
            }
            return true;
        }
    }

    public static class LayoutUpdateVisitor extends ViewVisitor {

        /* JADX INFO: renamed from: d */
        private static final Set<Integer> f12236d = new HashSet(Arrays.asList(0, 1, 5, 7));

        /* JADX INFO: renamed from: e */
        private static final Set<Integer> f12237e = new HashSet(Arrays.asList(2, 3, 4, 6, 8));

        /* JADX INFO: renamed from: a */
        private final WeakHashMap<View, int[]> f12238a;

        /* JADX INFO: renamed from: b */
        private final List<LayoutRule> f12239b;

        /* JADX INFO: renamed from: c */
        private final String f12240c;

        /* JADX INFO: renamed from: f */
        private boolean f12241f;

        /* JADX INFO: renamed from: g */
        private final OnLayoutErrorListener f12242g;

        /* JADX INFO: renamed from: h */
        private final CycleDetector f12243h;

        public LayoutUpdateVisitor(List<Pathfinder.PathElement> list, List<LayoutRule> list2, String str, OnLayoutErrorListener onLayoutErrorListener) {
            super(list);
            this.f12238a = new WeakHashMap<>();
            this.f12239b = list2;
            this.f12240c = str;
            this.f12241f = true;
            this.f12242g = onLayoutErrorListener;
            this.f12243h = new CycleDetector();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: a */
        public void mo12147a() {
            for (Map.Entry<View, int[]> entry : this.f12238a.entrySet()) {
                View key = entry.getKey();
                int[] value = entry.getValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) key.getLayoutParams();
                for (int i = 0; i < value.length; i++) {
                    layoutParams.addRule(i, value[i]);
                }
                key.setLayoutParams(layoutParams);
            }
            this.f12241f = false;
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: b */
        public void mo12149b(View view) {
            if (this.f12241f) {
                m12150c().m12090a(view, m12148b(), this);
            }
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        /* JADX INFO: renamed from: a */
        public void mo12091a(View view) {
            Set<Integer> set;
            ViewGroup viewGroup = (ViewGroup) view;
            SparseArray<View> sparseArray = new SparseArray<>();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                int id = childAt.getId();
                if (id > 0) {
                    sparseArray.put(id, childAt);
                }
            }
            int size = this.f12239b.size();
            for (int i2 = 0; i2 < size; i2++) {
                LayoutRule layoutRule = this.f12239b.get(i2);
                View view2 = sparseArray.get(layoutRule.f12233a);
                if (view2 != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                    int[] iArr = (int[]) layoutParams.getRules().clone();
                    if (iArr[layoutRule.f12234b] == layoutRule.f12235c) {
                        continue;
                    } else {
                        if (!this.f12238a.containsKey(view2)) {
                            this.f12238a.put(view2, iArr);
                        }
                        layoutParams.addRule(layoutRule.f12234b, layoutRule.f12235c);
                        if (f12236d.contains(Integer.valueOf(layoutRule.f12234b))) {
                            set = f12236d;
                        } else if (f12237e.contains(Integer.valueOf(layoutRule.f12234b))) {
                            set = f12237e;
                        } else {
                            set = null;
                        }
                        if (set != null && !m12162a(set, sparseArray)) {
                            mo12147a();
                            this.f12242g.mo12110a(new LayoutErrorMessage("circular_dependency", this.f12240c));
                            return;
                        }
                        view2.setLayoutParams(layoutParams);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m12162a(Set<Integer> set, SparseArray<View> sparseArray) {
            TreeMap<View, List<View>> treeMap = new TreeMap<>(new Comparator<View>() { // from class: com.mixpanel.android.viewcrawler.ViewVisitor.LayoutUpdateVisitor.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(View view, View view2) {
                    if (view == view2) {
                        return 0;
                    }
                    if (view == null) {
                        return -1;
                    }
                    if (view2 == null) {
                        return 1;
                    }
                    return view2.hashCode() - view.hashCode();
                }
            });
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View viewValueAt = sparseArray.valueAt(i);
                int[] rules = ((RelativeLayout.LayoutParams) viewValueAt.getLayoutParams()).getRules();
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int i2 = rules[it.next().intValue()];
                    if (i2 > 0 && i2 != viewValueAt.getId()) {
                        arrayList.add(sparseArray.get(i2));
                    }
                }
                treeMap.put(viewValueAt, arrayList);
            }
            return this.f12243h.m12157a(treeMap);
        }
    }

    public static class LayoutRule {

        /* JADX INFO: renamed from: a */
        public final int f12233a;

        /* JADX INFO: renamed from: b */
        public final int f12234b;

        /* JADX INFO: renamed from: c */
        public final int f12235c;

        public LayoutRule(int i, int i2, int i3) {
            this.f12233a = i;
            this.f12234b = i2;
            this.f12235c = i3;
        }
    }

    public static class AddAccessibilityEventVisitor extends EventTriggeringVisitor {

        /* JADX INFO: renamed from: a */
        private final int f12221a;

        /* JADX INFO: renamed from: b */
        private final WeakHashMap<View, TrackingAccessibilityDelegate> f12222b;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ void mo12149b(View view) {
            super.mo12149b(view);
        }

        public AddAccessibilityEventVisitor(List<Pathfinder.PathElement> list, int i, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, false);
            this.f12221a = i;
            this.f12222b = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: a */
        public void mo12147a() {
            for (Map.Entry<View, TrackingAccessibilityDelegate> entry : this.f12222b.entrySet()) {
                View key = entry.getKey();
                TrackingAccessibilityDelegate value = entry.getValue();
                View.AccessibilityDelegate accessibilityDelegateM12152d = m12152d(key);
                if (accessibilityDelegateM12152d == value) {
                    key.setAccessibilityDelegate(value.m12153a());
                } else if (accessibilityDelegateM12152d instanceof TrackingAccessibilityDelegate) {
                    ((TrackingAccessibilityDelegate) accessibilityDelegateM12152d).m12154a(value);
                }
            }
            this.f12222b.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        /* JADX INFO: renamed from: a */
        public void mo12091a(View view) {
            View.AccessibilityDelegate accessibilityDelegateM12152d = m12152d(view);
            if (!(accessibilityDelegateM12152d instanceof TrackingAccessibilityDelegate) || !((TrackingAccessibilityDelegate) accessibilityDelegateM12152d).m12155a(m12159d())) {
                TrackingAccessibilityDelegate trackingAccessibilityDelegate = new TrackingAccessibilityDelegate(accessibilityDelegateM12152d);
                view.setAccessibilityDelegate(trackingAccessibilityDelegate);
                this.f12222b.put(view, trackingAccessibilityDelegate);
            }
        }

        /* JADX INFO: renamed from: d */
        private View.AccessibilityDelegate m12152d(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (IllegalAccessException e) {
                return null;
            } catch (NoSuchMethodException e2) {
                return null;
            } catch (InvocationTargetException e3) {
                MPLog.m12029d("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", e3);
                return null;
            }
        }

        private class TrackingAccessibilityDelegate extends View.AccessibilityDelegate {

            /* JADX INFO: renamed from: b */
            private View.AccessibilityDelegate f12224b;

            public TrackingAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
                this.f12224b = accessibilityDelegate;
            }

            /* JADX INFO: renamed from: a */
            public View.AccessibilityDelegate m12153a() {
                return this.f12224b;
            }

            /* JADX INFO: renamed from: a */
            public boolean m12155a(String str) {
                if (AddAccessibilityEventVisitor.this.m12159d() == str) {
                    return true;
                }
                if (this.f12224b instanceof TrackingAccessibilityDelegate) {
                    return ((TrackingAccessibilityDelegate) this.f12224b).m12155a(str);
                }
                return false;
            }

            /* JADX INFO: renamed from: a */
            public void m12154a(TrackingAccessibilityDelegate trackingAccessibilityDelegate) {
                if (this.f12224b == trackingAccessibilityDelegate) {
                    this.f12224b = trackingAccessibilityDelegate.m12153a();
                } else if (this.f12224b instanceof TrackingAccessibilityDelegate) {
                    ((TrackingAccessibilityDelegate) this.f12224b).m12154a(trackingAccessibilityDelegate);
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                if (i == AddAccessibilityEventVisitor.this.f12221a) {
                    AddAccessibilityEventVisitor.this.m12158c(view);
                }
                if (this.f12224b != null) {
                    this.f12224b.sendAccessibilityEvent(view, i);
                }
            }
        }
    }

    public static class AddTextChangeListener extends EventTriggeringVisitor {

        /* JADX INFO: renamed from: a */
        private final Map<TextView, TextWatcher> f12225a;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ void mo12149b(View view) {
            super.mo12149b(view);
        }

        public AddTextChangeListener(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, true);
            this.f12225a = new HashMap();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: a */
        public void mo12147a() {
            for (Map.Entry<TextView, TextWatcher> entry : this.f12225a.entrySet()) {
                entry.getKey().removeTextChangedListener(entry.getValue());
            }
            this.f12225a.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        /* JADX INFO: renamed from: a */
        public void mo12091a(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                TrackingTextWatcher trackingTextWatcher = new TrackingTextWatcher(textView);
                TextWatcher textWatcher = this.f12225a.get(textView);
                if (textWatcher != null) {
                    textView.removeTextChangedListener(textWatcher);
                }
                textView.addTextChangedListener(trackingTextWatcher);
                this.f12225a.put(textView, trackingTextWatcher);
            }
        }

        private class TrackingTextWatcher implements TextWatcher {

            /* JADX INFO: renamed from: b */
            private final View f12227b;

            public TrackingTextWatcher(View view) {
                this.f12227b = view;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddTextChangeListener.this.m12158c(this.f12227b);
            }
        }
    }

    public static class ViewDetectorVisitor extends EventTriggeringVisitor {

        /* JADX INFO: renamed from: a */
        private boolean f12249a;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ void mo12149b(View view) {
            super.mo12149b(view);
        }

        public ViewDetectorVisitor(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, false);
            this.f12249a = false;
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        /* JADX INFO: renamed from: a */
        public void mo12147a() {
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        /* JADX INFO: renamed from: a */
        public void mo12091a(View view) {
            if (view != null && !this.f12249a) {
                m12158c(view);
            }
            this.f12249a = view != null;
        }
    }

    private static abstract class EventTriggeringVisitor extends ViewVisitor {

        /* JADX INFO: renamed from: a */
        private final OnEventListener f12228a;

        /* JADX INFO: renamed from: b */
        private final String f12229b;

        /* JADX INFO: renamed from: c */
        private final boolean f12230c;

        public EventTriggeringVisitor(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener, boolean z) {
            super(list);
            this.f12228a = onEventListener;
            this.f12229b = str;
            this.f12230c = z;
        }

        /* JADX INFO: renamed from: c */
        protected void m12158c(View view) {
            this.f12228a.mo12048a(view, this.f12229b, this.f12230c);
        }

        /* JADX INFO: renamed from: d */
        protected String m12159d() {
            return this.f12229b;
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo12149b(View view) {
        this.f12220b.m12090a(view, this.f12219a, this);
    }

    protected ViewVisitor(List<Pathfinder.PathElement> list) {
        this.f12219a = list;
    }

    /* JADX INFO: renamed from: b */
    protected List<Pathfinder.PathElement> m12148b() {
        return this.f12219a;
    }

    /* JADX INFO: renamed from: c */
    protected Pathfinder m12150c() {
        return this.f12220b;
    }
}
