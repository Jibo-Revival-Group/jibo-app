package android.support.transition;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.support.v4.app.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public boolean mo1145a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: b */
    public Object mo1146b(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Transition) obj).clone();
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: c */
    public Object mo1151c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.m1266b((Transition) obj);
        return transitionSet;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1141a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> listG = transitionSet.m1240g();
        listG.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m1669a(listG, arrayList.get(i));
        }
        listG.add(view);
        arrayList.add(view);
        mo1143a(transitionSet, arrayList);
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1140a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            m1673a(view, rect);
            ((Transition) obj).mo1218a(new Transition.EpicenterCallback() { // from class: android.support.transition.FragmentTransitionSupport.1
                @Override // android.support.transition.Transition.EpicenterCallback
                /* JADX INFO: renamed from: a */
                public Rect mo1153a(Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1143a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int iM1272p = transitionSet.m1272p();
                for (int i = 0; i < iM1272p; i++) {
                    mo1143a(transitionSet.m1264b(i), arrayList);
                }
                return;
            }
            if (!m1136a(transition) && m1670a((List) transition.m1240g())) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    transition.mo1232c(arrayList.get(i2));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1136a(Transition transition) {
        return (m1670a((List) transition.m1238f()) && m1670a((List) transition.m1241h()) && m1670a((List) transition.m1242i())) ? false : true;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public Object mo1137a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.m1266b((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m1266b((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m1266b((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: b */
    public void mo1149b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).mo1214a(new Transition.TransitionListener() { // from class: android.support.transition.FragmentTransitionSupport.2
            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: d */
            public void mo1154d(Transition transition) {
            }

            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: a */
            public void mo1088a(Transition transition) {
                transition.mo1227b(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: b */
            public void mo1089b(Transition transition) {
            }

            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: c */
            public void mo1090c(Transition transition) {
            }
        });
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: b */
    public Object mo1147b(Object obj, Object obj2, Object obj3) {
        Transition transitionM1262a = null;
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transitionM1262a = new TransitionSet().m1266b(transition).m1266b(transition2).m1262a(1);
        } else if (transition != null) {
            transitionM1262a = transition;
        } else if (transition2 != null) {
            transitionM1262a = transition2;
        }
        if (transition3 == null) {
            return transitionM1262a;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionM1262a != null) {
            transitionSet.m1266b(transitionM1262a);
        }
        transitionSet.m1266b(transition3);
        return transitionSet;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1138a(ViewGroup viewGroup, Object obj) {
        TransitionManager.m1250a(viewGroup, (Transition) obj);
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1142a(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).mo1214a(new Transition.TransitionListener() { // from class: android.support.transition.FragmentTransitionSupport.3
            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: d */
            public void mo1154d(Transition transition) {
                if (obj2 != null) {
                    FragmentTransitionSupport.this.mo1150b(obj2, arrayList, (ArrayList<View>) null);
                }
                if (obj3 != null) {
                    FragmentTransitionSupport.this.mo1150b(obj3, arrayList2, (ArrayList<View>) null);
                }
                if (obj4 != null) {
                    FragmentTransitionSupport.this.mo1150b(obj4, arrayList3, (ArrayList<View>) null);
                }
            }

            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: a */
            public void mo1088a(Transition transition) {
            }

            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: b */
            public void mo1089b(Transition transition) {
            }

            @Override // android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: c */
            public void mo1090c(Transition transition) {
            }
        });
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1144a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m1240g().clear();
            transitionSet.m1240g().addAll(arrayList2);
            mo1150b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: b */
    public void mo1150b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM1272p = transitionSet.m1272p();
            for (int i = 0; i < iM1272p; i++) {
                mo1150b((Object) transitionSet.m1264b(i), arrayList, arrayList2);
            }
            return;
        }
        if (!m1136a(transition)) {
            List<View> listM1240g = transition.m1240g();
            if (listM1240g.size() == arrayList.size() && listM1240g.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    transition.mo1232c(arrayList2.get(i2));
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.mo1235d(arrayList.get(size2));
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: b */
    public void mo1148b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo1232c(view);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: c */
    public void mo1152c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo1235d(view);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    /* JADX INFO: renamed from: a */
    public void mo1139a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).mo1218a(new Transition.EpicenterCallback() { // from class: android.support.transition.FragmentTransitionSupport.4
                @Override // android.support.transition.Transition.EpicenterCallback
                /* JADX INFO: renamed from: a */
                public Rect mo1153a(Transition transition) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
