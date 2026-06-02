package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* JADX INFO: renamed from: g */
    private static final String[] f1103g = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: h */
    private static final Property<Drawable, PointF> f1104h = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: android.support.transition.ChangeBounds.1

        /* JADX INFO: renamed from: a */
        private Rect f1114a = new Rect();

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f1114a);
            this.f1114a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f1114a);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f1114a);
            return new PointF(this.f1114a.left, this.f1114a.top);
        }
    };

    /* JADX INFO: renamed from: i */
    private static final Property<ViewBounds, PointF> f1105i = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: android.support.transition.ChangeBounds.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.m1092a(pointF);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(ViewBounds viewBounds) {
            return null;
        }
    };

    /* JADX INFO: renamed from: j */
    private static final Property<ViewBounds, PointF> f1106j = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: android.support.transition.ChangeBounds.3
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.m1093b(pointF);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(ViewBounds viewBounds) {
            return null;
        }
    };

    /* JADX INFO: renamed from: k */
    private static final Property<View, PointF> f1107k = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: android.support.transition.ChangeBounds.4
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            ViewUtils.m1301a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }
    };

    /* JADX INFO: renamed from: l */
    private static final Property<View, PointF> f1108l = new Property<View, PointF>(PointF.class, "topLeft") { // from class: android.support.transition.ChangeBounds.5
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            ViewUtils.m1301a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }
    };

    /* JADX INFO: renamed from: m */
    private static final Property<View, PointF> f1109m = new Property<View, PointF>(PointF.class, "position") { // from class: android.support.transition.ChangeBounds.6
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            ViewUtils.m1301a(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }
    };

    /* JADX INFO: renamed from: q */
    private static RectEvaluator f1110q = new RectEvaluator();

    /* JADX INFO: renamed from: n */
    private int[] f1111n;

    /* JADX INFO: renamed from: o */
    private boolean f1112o;

    /* JADX INFO: renamed from: p */
    private boolean f1113p;

    public ChangeBounds() {
        this.f1111n = new int[2];
        this.f1112o = false;
        this.f1113p = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1111n = new int[2];
        this.f1112o = false;
        this.f1113p = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1254d);
        boolean zM1928a = TypedArrayUtils.m1928a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        m1074a(zM1928a);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return f1103g;
    }

    /* JADX INFO: renamed from: a */
    public void m1074a(boolean z) {
        this.f1112o = z;
    }

    /* JADX INFO: renamed from: d */
    private void m1073d(TransitionValues transitionValues) {
        View view = transitionValues.f1324b;
        if (ViewCompat.m2621y(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f1323a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f1323a.put("android:changeBounds:parent", transitionValues.f1324b.getParent());
            if (this.f1113p) {
                transitionValues.f1324b.getLocationInWindow(this.f1111n);
                transitionValues.f1323a.put("android:changeBounds:windowX", Integer.valueOf(this.f1111n[0]));
                transitionValues.f1323a.put("android:changeBounds:windowY", Integer.valueOf(this.f1111n[1]));
            }
            if (this.f1112o) {
                transitionValues.f1323a.put("android:changeBounds:clip", ViewCompat.m2569A(view));
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m1073d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m1073d(transitionValues);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1072a(View view, View view2) {
        if (!this.f1113p) {
            return true;
        }
        TransitionValues transitionValuesB = m1228b(view, true);
        return transitionValuesB == null ? view == view2 : view2 == transitionValuesB.f1324b;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimatorM1178a;
        ObjectAnimator objectAnimator;
        Animator animatorM1273a;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.f1323a;
        Map<String, Object> map2 = transitionValues2.f1323a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view = transitionValues2.f1324b;
        if (m1072a(viewGroup2, viewGroup3)) {
            Rect rect = (Rect) transitionValues.f1323a.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) transitionValues2.f1323a.get("android:changeBounds:bounds");
            int i = rect.left;
            final int i2 = rect2.left;
            int i3 = rect.top;
            final int i4 = rect2.top;
            int i5 = rect.right;
            final int i6 = rect2.right;
            int i7 = rect.bottom;
            final int i8 = rect2.bottom;
            int i9 = i5 - i;
            int i10 = i7 - i3;
            int i11 = i6 - i2;
            int i12 = i8 - i4;
            Rect rect3 = (Rect) transitionValues.f1323a.get("android:changeBounds:clip");
            final Rect rect4 = (Rect) transitionValues2.f1323a.get("android:changeBounds:clip");
            if ((i9 != 0 && i10 != 0) || (i11 != 0 && i12 != 0)) {
                i = (i == i2 && i3 == i4) ? 0 : 1;
                if (i5 != i6 || i7 != i8) {
                    i++;
                }
            }
            if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.f1112o) {
                    ViewUtils.m1301a(view, i, i3, i5, i7);
                    if (i == 2) {
                        if (i9 == i11 && i10 == i12) {
                            animatorM1273a = ObjectAnimatorUtils.m1178a(view, f1109m, m1245l().mo1067a(i, i3, i2, i4));
                        } else {
                            final ViewBounds viewBounds = new ViewBounds(view);
                            ObjectAnimator objectAnimatorM1178a2 = ObjectAnimatorUtils.m1178a(viewBounds, f1105i, m1245l().mo1067a(i, i3, i2, i4));
                            ObjectAnimator objectAnimatorM1178a3 = ObjectAnimatorUtils.m1178a(viewBounds, f1106j, m1245l().mo1067a(i5, i7, i6, i8));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorM1178a2, objectAnimatorM1178a3);
                            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.7
                                private ViewBounds mViewBounds;

                                {
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            animatorM1273a = animatorSet;
                        }
                    } else if (i != i2 || i3 != i4) {
                        animatorM1273a = ObjectAnimatorUtils.m1178a(view, f1108l, m1245l().mo1067a(i, i3, i2, i4));
                    } else {
                        animatorM1273a = ObjectAnimatorUtils.m1178a(view, f1107k, m1245l().mo1067a(i5, i7, i6, i8));
                    }
                } else {
                    ViewUtils.m1301a(view, i, i3, Math.max(i9, i11) + i, Math.max(i10, i12) + i3);
                    if (i == i2 && i3 == i4) {
                        objectAnimatorM1178a = null;
                    } else {
                        objectAnimatorM1178a = ObjectAnimatorUtils.m1178a(view, f1109m, m1245l().mo1067a(i, i3, i2, i4));
                    }
                    Rect rect5 = rect3 == null ? new Rect(0, 0, i9, i10) : rect3;
                    Rect rect6 = rect4 == null ? new Rect(0, 0, i11, i12) : rect4;
                    if (rect5.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        ViewCompat.m2581a(view, rect5);
                        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f1110q, rect5, rect6);
                        objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.8

                            /* JADX INFO: renamed from: h */
                            private boolean f1129h;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                this.f1129h = true;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (!this.f1129h) {
                                    ViewCompat.m2581a(view, rect4);
                                    ViewUtils.m1301a(view, i2, i4, i6, i8);
                                }
                            }
                        });
                        objectAnimator = objectAnimatorOfObject;
                    }
                    animatorM1273a = TransitionUtils.m1273a(objectAnimatorM1178a, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.m1284a(viewGroup4, true);
                    mo1214a(new TransitionListenerAdapter() { // from class: android.support.transition.ChangeBounds.9

                        /* JADX INFO: renamed from: a */
                        boolean f1130a = false;

                        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                        /* JADX INFO: renamed from: a */
                        public void mo1088a(Transition transition) {
                            if (!this.f1130a) {
                                ViewGroupUtils.m1284a(viewGroup4, false);
                            }
                            transition.mo1227b(this);
                        }

                        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                        /* JADX INFO: renamed from: b */
                        public void mo1089b(Transition transition) {
                            ViewGroupUtils.m1284a(viewGroup4, false);
                        }

                        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                        /* JADX INFO: renamed from: c */
                        public void mo1090c(Transition transition) {
                            ViewGroupUtils.m1284a(viewGroup4, true);
                        }
                    });
                    return animatorM1273a;
                }
                return animatorM1273a;
            }
        } else {
            int iIntValue = ((Integer) transitionValues.f1323a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) transitionValues.f1323a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) transitionValues2.f1323a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) transitionValues2.f1323a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue != iIntValue3 || iIntValue2 != iIntValue4) {
                viewGroup.getLocationInWindow(this.f1111n);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmapCreateBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                final float fM1305c = ViewUtils.m1305c(view);
                ViewUtils.m1299a(view, CropImageView.DEFAULT_ASPECT_RATIO);
                ViewUtils.m1297a(viewGroup).mo1281a(bitmapDrawable);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.m1184a(f1104h, m1245l().mo1067a(iIntValue - this.f1111n[0], iIntValue2 - this.f1111n[1], iIntValue3 - this.f1111n[0], iIntValue4 - this.f1111n[1])));
                objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewUtils.m1297a(viewGroup).mo1282b(bitmapDrawable);
                        ViewUtils.m1299a(view, fM1305c);
                    }
                });
                return objectAnimatorOfPropertyValuesHolder;
            }
        }
        return null;
    }

    private static class ViewBounds {

        /* JADX INFO: renamed from: a */
        private int f1133a;

        /* JADX INFO: renamed from: b */
        private int f1134b;

        /* JADX INFO: renamed from: c */
        private int f1135c;

        /* JADX INFO: renamed from: d */
        private int f1136d;

        /* JADX INFO: renamed from: e */
        private View f1137e;

        /* JADX INFO: renamed from: f */
        private int f1138f;

        /* JADX INFO: renamed from: g */
        private int f1139g;

        ViewBounds(View view) {
            this.f1137e = view;
        }

        /* JADX INFO: renamed from: a */
        void m1092a(PointF pointF) {
            this.f1133a = Math.round(pointF.x);
            this.f1134b = Math.round(pointF.y);
            this.f1138f++;
            if (this.f1138f == this.f1139g) {
                m1091a();
            }
        }

        /* JADX INFO: renamed from: b */
        void m1093b(PointF pointF) {
            this.f1135c = Math.round(pointF.x);
            this.f1136d = Math.round(pointF.y);
            this.f1139g++;
            if (this.f1138f == this.f1139g) {
                m1091a();
            }
        }

        /* JADX INFO: renamed from: a */
        private void m1091a() {
            ViewUtils.m1301a(this.f1137e, this.f1133a, this.f1134b, this.f1135c, this.f1136d);
            this.f1138f = 0;
            this.f1139g = 0;
        }
    }
}
