package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {

    /* JADX INFO: renamed from: a */
    private static final int[] f132a = {0, 4, 8};

    /* JADX INFO: renamed from: c */
    private static SparseIntArray f133c = new SparseIntArray();

    /* JADX INFO: renamed from: b */
    private HashMap<Integer, Constraint> f134b = new HashMap<>();

    static {
        f133c.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f133c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f133c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f133c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f133c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f133c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f133c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f133c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f133c.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f133c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f133c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f133c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f133c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f133c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f133c.append(R.styleable.ConstraintSet_android_orientation, 27);
        f133c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f133c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f133c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f133c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f133c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f133c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f133c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f133c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f133c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f133c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f133c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f133c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f133c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f133c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f133c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f133c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f133c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f133c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 60);
        f133c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 60);
        f133c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 60);
        f133c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 60);
        f133c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 60);
        f133c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f133c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
        f133c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
        f133c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f133c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
        f133c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f133c.append(R.styleable.ConstraintSet_android_layout_width, 23);
        f133c.append(R.styleable.ConstraintSet_android_layout_height, 21);
        f133c.append(R.styleable.ConstraintSet_android_visibility, 22);
        f133c.append(R.styleable.ConstraintSet_android_alpha, 43);
        f133c.append(R.styleable.ConstraintSet_android_elevation, 44);
        f133c.append(R.styleable.ConstraintSet_android_rotationX, 45);
        f133c.append(R.styleable.ConstraintSet_android_rotationY, 46);
        f133c.append(R.styleable.ConstraintSet_android_scaleX, 47);
        f133c.append(R.styleable.ConstraintSet_android_scaleY, 48);
        f133c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
        f133c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
        f133c.append(R.styleable.ConstraintSet_android_translationX, 51);
        f133c.append(R.styleable.ConstraintSet_android_translationY, 52);
        f133c.append(R.styleable.ConstraintSet_android_translationZ, 53);
        f133c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f133c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f133c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f133c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f133c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f133c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f133c.append(R.styleable.ConstraintSet_android_id, 38);
    }

    private static class Constraint {

        /* JADX INFO: renamed from: A */
        public int f135A;

        /* JADX INFO: renamed from: B */
        public int f136B;

        /* JADX INFO: renamed from: C */
        public int f137C;

        /* JADX INFO: renamed from: D */
        public int f138D;

        /* JADX INFO: renamed from: E */
        public int f139E;

        /* JADX INFO: renamed from: F */
        public int f140F;

        /* JADX INFO: renamed from: G */
        public int f141G;

        /* JADX INFO: renamed from: H */
        public int f142H;

        /* JADX INFO: renamed from: I */
        public int f143I;

        /* JADX INFO: renamed from: J */
        public int f144J;

        /* JADX INFO: renamed from: K */
        public int f145K;

        /* JADX INFO: renamed from: L */
        public int f146L;

        /* JADX INFO: renamed from: M */
        public int f147M;

        /* JADX INFO: renamed from: N */
        public float f148N;

        /* JADX INFO: renamed from: O */
        public float f149O;

        /* JADX INFO: renamed from: P */
        public int f150P;

        /* JADX INFO: renamed from: Q */
        public int f151Q;

        /* JADX INFO: renamed from: R */
        public float f152R;

        /* JADX INFO: renamed from: S */
        public boolean f153S;

        /* JADX INFO: renamed from: T */
        public float f154T;

        /* JADX INFO: renamed from: U */
        public float f155U;

        /* JADX INFO: renamed from: V */
        public float f156V;

        /* JADX INFO: renamed from: W */
        public float f157W;

        /* JADX INFO: renamed from: X */
        public float f158X;

        /* JADX INFO: renamed from: Y */
        public float f159Y;

        /* JADX INFO: renamed from: Z */
        public float f160Z;

        /* JADX INFO: renamed from: a */
        boolean f161a;

        /* JADX INFO: renamed from: aa */
        public float f162aa;

        /* JADX INFO: renamed from: ab */
        public float f163ab;

        /* JADX INFO: renamed from: ac */
        public float f164ac;

        /* JADX INFO: renamed from: ad */
        public int f165ad;

        /* JADX INFO: renamed from: ae */
        public int f166ae;

        /* JADX INFO: renamed from: af */
        public int f167af;

        /* JADX INFO: renamed from: ag */
        public int f168ag;

        /* JADX INFO: renamed from: ah */
        public int f169ah;

        /* JADX INFO: renamed from: ai */
        public int f170ai;

        /* JADX INFO: renamed from: b */
        public int f171b;

        /* JADX INFO: renamed from: c */
        public int f172c;

        /* JADX INFO: renamed from: d */
        int f173d;

        /* JADX INFO: renamed from: e */
        public int f174e;

        /* JADX INFO: renamed from: f */
        public int f175f;

        /* JADX INFO: renamed from: g */
        public float f176g;

        /* JADX INFO: renamed from: h */
        public int f177h;

        /* JADX INFO: renamed from: i */
        public int f178i;

        /* JADX INFO: renamed from: j */
        public int f179j;

        /* JADX INFO: renamed from: k */
        public int f180k;

        /* JADX INFO: renamed from: l */
        public int f181l;

        /* JADX INFO: renamed from: m */
        public int f182m;

        /* JADX INFO: renamed from: n */
        public int f183n;

        /* JADX INFO: renamed from: o */
        public int f184o;

        /* JADX INFO: renamed from: p */
        public int f185p;

        /* JADX INFO: renamed from: q */
        public int f186q;

        /* JADX INFO: renamed from: r */
        public int f187r;

        /* JADX INFO: renamed from: s */
        public int f188s;

        /* JADX INFO: renamed from: t */
        public int f189t;

        /* JADX INFO: renamed from: u */
        public float f190u;

        /* JADX INFO: renamed from: v */
        public float f191v;

        /* JADX INFO: renamed from: w */
        public String f192w;

        /* JADX INFO: renamed from: x */
        public int f193x;

        /* JADX INFO: renamed from: y */
        public int f194y;

        /* JADX INFO: renamed from: z */
        public int f195z;

        private Constraint() {
            this.f161a = false;
            this.f174e = -1;
            this.f175f = -1;
            this.f176g = -1.0f;
            this.f177h = -1;
            this.f178i = -1;
            this.f179j = -1;
            this.f180k = -1;
            this.f181l = -1;
            this.f182m = -1;
            this.f183n = -1;
            this.f184o = -1;
            this.f185p = -1;
            this.f186q = -1;
            this.f187r = -1;
            this.f188s = -1;
            this.f189t = -1;
            this.f190u = 0.5f;
            this.f191v = 0.5f;
            this.f192w = null;
            this.f193x = -1;
            this.f194y = -1;
            this.f195z = -1;
            this.f135A = -1;
            this.f136B = -1;
            this.f137C = -1;
            this.f138D = -1;
            this.f139E = -1;
            this.f140F = -1;
            this.f141G = 0;
            this.f142H = -1;
            this.f143I = -1;
            this.f144J = -1;
            this.f145K = -1;
            this.f146L = -1;
            this.f147M = -1;
            this.f148N = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f149O = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f150P = 0;
            this.f151Q = 0;
            this.f152R = 1.0f;
            this.f153S = false;
            this.f154T = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f155U = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f156V = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f157W = 1.0f;
            this.f158X = 1.0f;
            this.f159Y = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f160Z = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f162aa = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f163ab = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f164ac = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f165ad = -1;
            this.f166ae = -1;
            this.f167af = -1;
            this.f168ag = -1;
            this.f169ah = -1;
            this.f170ai = -1;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f161a = this.f161a;
            constraint.f171b = this.f171b;
            constraint.f172c = this.f172c;
            constraint.f174e = this.f174e;
            constraint.f175f = this.f175f;
            constraint.f176g = this.f176g;
            constraint.f177h = this.f177h;
            constraint.f178i = this.f178i;
            constraint.f179j = this.f179j;
            constraint.f180k = this.f180k;
            constraint.f181l = this.f181l;
            constraint.f182m = this.f182m;
            constraint.f183n = this.f183n;
            constraint.f184o = this.f184o;
            constraint.f185p = this.f185p;
            constraint.f186q = this.f186q;
            constraint.f187r = this.f187r;
            constraint.f188s = this.f188s;
            constraint.f189t = this.f189t;
            constraint.f190u = this.f190u;
            constraint.f191v = this.f191v;
            constraint.f192w = this.f192w;
            constraint.f193x = this.f193x;
            constraint.f194y = this.f194y;
            constraint.f190u = this.f190u;
            constraint.f190u = this.f190u;
            constraint.f190u = this.f190u;
            constraint.f190u = this.f190u;
            constraint.f190u = this.f190u;
            constraint.f195z = this.f195z;
            constraint.f135A = this.f135A;
            constraint.f136B = this.f136B;
            constraint.f137C = this.f137C;
            constraint.f138D = this.f138D;
            constraint.f139E = this.f139E;
            constraint.f140F = this.f140F;
            constraint.f141G = this.f141G;
            constraint.f142H = this.f142H;
            constraint.f143I = this.f143I;
            constraint.f144J = this.f144J;
            constraint.f145K = this.f145K;
            constraint.f146L = this.f146L;
            constraint.f147M = this.f147M;
            constraint.f148N = this.f148N;
            constraint.f149O = this.f149O;
            constraint.f150P = this.f150P;
            constraint.f151Q = this.f151Q;
            constraint.f152R = this.f152R;
            constraint.f153S = this.f153S;
            constraint.f154T = this.f154T;
            constraint.f155U = this.f155U;
            constraint.f156V = this.f156V;
            constraint.f157W = this.f157W;
            constraint.f158X = this.f158X;
            constraint.f159Y = this.f159Y;
            constraint.f160Z = this.f160Z;
            constraint.f162aa = this.f162aa;
            constraint.f163ab = this.f163ab;
            constraint.f164ac = this.f164ac;
            constraint.f165ad = this.f165ad;
            constraint.f166ae = this.f166ae;
            constraint.f167af = this.f167af;
            constraint.f168ag = this.f168ag;
            constraint.f169ah = this.f169ah;
            constraint.f170ai = this.f170ai;
            return constraint;
        }

        /* JADX INFO: renamed from: a */
        public void m120a(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.f109d = this.f177h;
            layoutParams.f110e = this.f178i;
            layoutParams.f111f = this.f179j;
            layoutParams.f112g = this.f180k;
            layoutParams.f113h = this.f181l;
            layoutParams.f114i = this.f182m;
            layoutParams.f115j = this.f183n;
            layoutParams.f116k = this.f184o;
            layoutParams.f117l = this.f185p;
            layoutParams.f118m = this.f186q;
            layoutParams.f119n = this.f187r;
            layoutParams.f120o = this.f188s;
            layoutParams.f121p = this.f189t;
            layoutParams.leftMargin = this.f135A;
            layoutParams.rightMargin = this.f136B;
            layoutParams.topMargin = this.f137C;
            layoutParams.bottomMargin = this.f138D;
            layoutParams.f126u = this.f147M;
            layoutParams.f127v = this.f146L;
            layoutParams.f128w = this.f190u;
            layoutParams.f129x = this.f191v;
            layoutParams.f130y = this.f192w;
            layoutParams.f91L = this.f193x;
            layoutParams.f92M = this.f194y;
            layoutParams.f82C = this.f148N;
            layoutParams.f81B = this.f149O;
            layoutParams.f84E = this.f151Q;
            layoutParams.f83D = this.f150P;
            layoutParams.f85F = this.f165ad;
            layoutParams.f86G = this.f166ae;
            layoutParams.f89J = this.f167af;
            layoutParams.f90K = this.f168ag;
            layoutParams.f87H = this.f169ah;
            layoutParams.f88I = this.f170ai;
            layoutParams.f93N = this.f195z;
            layoutParams.f108c = this.f176g;
            layoutParams.f106a = this.f174e;
            layoutParams.f107b = this.f175f;
            layoutParams.width = this.f171b;
            layoutParams.height = this.f172c;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.f140F);
                layoutParams.setMarginEnd(this.f139E);
            }
            layoutParams.m113a();
        }
    }

    /* JADX INFO: renamed from: a */
    void m118a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f134b.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.f134b.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                Constraint constraint = this.f134b.get(Integer.valueOf(id));
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                constraint.m120a(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(constraint.f141G);
                if (Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(constraint.f152R);
                    childAt.setRotationX(constraint.f155U);
                    childAt.setRotationY(constraint.f156V);
                    childAt.setScaleX(constraint.f157W);
                    childAt.setScaleY(constraint.f158X);
                    childAt.setPivotX(constraint.f159Y);
                    childAt.setPivotY(constraint.f160Z);
                    childAt.setTranslationX(constraint.f162aa);
                    childAt.setTranslationY(constraint.f163ab);
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(constraint.f164ac);
                        if (constraint.f153S) {
                            childAt.setElevation(constraint.f154T);
                        }
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            Constraint constraint2 = this.f134b.get(num);
            if (constraint2.f161a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams layoutParamsM112b = constraintLayout.generateDefaultLayoutParams();
                constraint2.m120a(layoutParamsM112b);
                constraintLayout.addView(guideline, layoutParamsM112b);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m117a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                switch (eventType) {
                    case 0:
                        xml.getName();
                        break;
                    case 2:
                        String name = xml.getName();
                        Constraint constraintM115a = m115a(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            constraintM115a.f161a = true;
                        }
                        this.f134b.put(Integer.valueOf(constraintM115a.f173d), constraintM115a);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m114a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    /* JADX INFO: renamed from: a */
    private Constraint m115a(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        m116a(constraint, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    /* JADX INFO: renamed from: a */
    private void m116a(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (f133c.get(index)) {
                case 1:
                    constraint.f185p = m114a(typedArray, index, constraint.f185p);
                    break;
                case 2:
                    constraint.f138D = typedArray.getDimensionPixelSize(index, constraint.f138D);
                    break;
                case 3:
                    constraint.f184o = m114a(typedArray, index, constraint.f184o);
                    break;
                case 4:
                    constraint.f183n = m114a(typedArray, index, constraint.f183n);
                    break;
                case 5:
                    constraint.f192w = typedArray.getString(index);
                    break;
                case 6:
                    constraint.f193x = typedArray.getDimensionPixelOffset(index, constraint.f193x);
                    break;
                case 7:
                    constraint.f194y = typedArray.getDimensionPixelOffset(index, constraint.f194y);
                    break;
                case 8:
                    constraint.f139E = typedArray.getDimensionPixelSize(index, constraint.f139E);
                    break;
                case 9:
                    constraint.f183n = m114a(typedArray, index, constraint.f189t);
                    break;
                case 10:
                    constraint.f188s = m114a(typedArray, index, constraint.f188s);
                    break;
                case 11:
                    constraint.f145K = typedArray.getDimensionPixelSize(index, constraint.f145K);
                    break;
                case 12:
                    constraint.f146L = typedArray.getDimensionPixelSize(index, constraint.f146L);
                    break;
                case 13:
                    constraint.f142H = typedArray.getDimensionPixelSize(index, constraint.f142H);
                    break;
                case 14:
                    constraint.f144J = typedArray.getDimensionPixelSize(index, constraint.f144J);
                    break;
                case 15:
                    constraint.f147M = typedArray.getDimensionPixelSize(index, constraint.f147M);
                    break;
                case 16:
                    constraint.f143I = typedArray.getDimensionPixelSize(index, constraint.f143I);
                    break;
                case 17:
                    constraint.f174e = typedArray.getDimensionPixelOffset(index, constraint.f174e);
                    break;
                case 18:
                    constraint.f175f = typedArray.getDimensionPixelOffset(index, constraint.f175f);
                    break;
                case 19:
                    constraint.f176g = typedArray.getFloat(index, constraint.f176g);
                    break;
                case 20:
                    constraint.f190u = typedArray.getFloat(index, constraint.f190u);
                    break;
                case 21:
                    constraint.f172c = typedArray.getLayoutDimension(index, constraint.f172c);
                    break;
                case 22:
                    constraint.f141G = typedArray.getInt(index, constraint.f141G);
                    constraint.f141G = f132a[constraint.f141G];
                    break;
                case 23:
                    constraint.f171b = typedArray.getLayoutDimension(index, constraint.f171b);
                    break;
                case 24:
                    constraint.f135A = typedArray.getDimensionPixelSize(index, constraint.f135A);
                    break;
                case 25:
                    constraint.f177h = m114a(typedArray, index, constraint.f177h);
                    break;
                case 26:
                    constraint.f178i = m114a(typedArray, index, constraint.f178i);
                    break;
                case 27:
                    constraint.f195z = typedArray.getInt(index, constraint.f195z);
                    break;
                case 28:
                    constraint.f136B = typedArray.getDimensionPixelSize(index, constraint.f136B);
                    break;
                case 29:
                    constraint.f179j = m114a(typedArray, index, constraint.f179j);
                    break;
                case 30:
                    constraint.f180k = m114a(typedArray, index, constraint.f180k);
                    break;
                case 31:
                    constraint.f140F = typedArray.getDimensionPixelSize(index, constraint.f140F);
                    break;
                case 32:
                    constraint.f186q = m114a(typedArray, index, constraint.f186q);
                    break;
                case 33:
                    constraint.f187r = m114a(typedArray, index, constraint.f187r);
                    break;
                case 34:
                    constraint.f137C = typedArray.getDimensionPixelSize(index, constraint.f137C);
                    break;
                case 35:
                    constraint.f182m = m114a(typedArray, index, constraint.f182m);
                    break;
                case 36:
                    constraint.f181l = m114a(typedArray, index, constraint.f181l);
                    break;
                case 37:
                    constraint.f191v = typedArray.getFloat(index, constraint.f191v);
                    break;
                case 38:
                    constraint.f173d = typedArray.getResourceId(index, constraint.f173d);
                    break;
                case 39:
                    constraint.f149O = typedArray.getFloat(index, constraint.f149O);
                    break;
                case 40:
                    constraint.f148N = typedArray.getFloat(index, constraint.f148N);
                    break;
                case 41:
                    constraint.f150P = typedArray.getInt(index, constraint.f150P);
                    break;
                case 42:
                    constraint.f151Q = typedArray.getInt(index, constraint.f151Q);
                    break;
                case 43:
                    constraint.f152R = typedArray.getFloat(index, constraint.f152R);
                    break;
                case 44:
                    constraint.f153S = true;
                    constraint.f154T = typedArray.getFloat(index, constraint.f154T);
                    break;
                case 45:
                    constraint.f155U = typedArray.getFloat(index, constraint.f155U);
                    break;
                case 46:
                    constraint.f156V = typedArray.getFloat(index, constraint.f156V);
                    break;
                case 47:
                    constraint.f157W = typedArray.getFloat(index, constraint.f157W);
                    break;
                case 48:
                    constraint.f158X = typedArray.getFloat(index, constraint.f158X);
                    break;
                case 49:
                    constraint.f159Y = typedArray.getFloat(index, constraint.f159Y);
                    break;
                case 50:
                    constraint.f160Z = typedArray.getFloat(index, constraint.f160Z);
                    break;
                case 51:
                    constraint.f162aa = typedArray.getFloat(index, constraint.f162aa);
                    break;
                case 52:
                    constraint.f163ab = typedArray.getFloat(index, constraint.f163ab);
                    break;
                case 53:
                    constraint.f164ac = typedArray.getFloat(index, constraint.f164ac);
                    break;
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f133c.get(index));
                    break;
                case 60:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f133c.get(index));
                    break;
            }
        }
    }
}
