package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* JADX INFO: renamed from: b */
    private static AppCompatDrawableManager f3664b;

    /* JADX INFO: renamed from: j */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f3672j;

    /* JADX INFO: renamed from: k */
    private ArrayMap<String, InflateDelegate> f3673k;

    /* JADX INFO: renamed from: l */
    private SparseArrayCompat<String> f3674l;

    /* JADX INFO: renamed from: m */
    private final Object f3675m = new Object();

    /* JADX INFO: renamed from: n */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f3676n = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: o */
    private TypedValue f3677o;

    /* JADX INFO: renamed from: p */
    private boolean f3678p;

    /* JADX INFO: renamed from: a */
    private static final PorterDuff.Mode f3663a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c */
    private static final ColorFilterLruCache f3665c = new ColorFilterLruCache(6);

    /* JADX INFO: renamed from: d */
    private static final int[] f3666d = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* JADX INFO: renamed from: e */
    private static final int[] f3667e = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* JADX INFO: renamed from: f */
    private static final int[] f3668f = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

    /* JADX INFO: renamed from: g */
    private static final int[] f3669g = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* JADX INFO: renamed from: h */
    private static final int[] f3670h = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* JADX INFO: renamed from: i */
    private static final int[] f3671i = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    private interface InflateDelegate {
        /* JADX INFO: renamed from: a */
        Drawable mo3886a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: renamed from: a */
    public static AppCompatDrawableManager m3862a() {
        if (f3664b == null) {
            f3664b = new AppCompatDrawableManager();
            m3866a(f3664b);
        }
        return f3664b;
    }

    /* JADX INFO: renamed from: a */
    private static void m3866a(AppCompatDrawableManager appCompatDrawableManager) {
        if (Build.VERSION.SDK_INT < 24) {
            appCompatDrawableManager.m3867a("vector", new VdcInflateDelegate());
            appCompatDrawableManager.m3867a("animated-vector", new AvdcInflateDelegate());
        }
    }

    /* JADX INFO: renamed from: a */
    public Drawable m3881a(Context context, int i) {
        return m3882a(context, i, false);
    }

    /* JADX INFO: renamed from: a */
    Drawable m3882a(Context context, int i, boolean z) {
        m3880f(context);
        Drawable drawableM3876d = m3876d(context, i);
        if (drawableM3876d == null) {
            drawableM3876d = m3874c(context, i);
        }
        if (drawableM3876d == null) {
            drawableM3876d = ContextCompat.m1832a(context, i);
        }
        if (drawableM3876d != null) {
            drawableM3876d = m3860a(context, i, z, drawableM3876d);
        }
        if (drawableM3876d != null) {
            DrawableUtils.m4116b(drawableM3876d);
        }
        return drawableM3876d;
    }

    /* JADX INFO: renamed from: a */
    public void m3884a(Context context) {
        synchronized (this.f3675m) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f3676n.get(context);
            if (longSparseArray != null) {
                longSparseArray.m2415c();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static long m3856a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* JADX INFO: renamed from: c */
    private Drawable m3874c(Context context, int i) {
        if (this.f3677o == null) {
            this.f3677o = new TypedValue();
        }
        TypedValue typedValue = this.f3677o;
        context.getResources().getValue(i, typedValue, true);
        long jM3856a = m3856a(typedValue);
        Drawable drawableM3861a = m3861a(context, jM3856a);
        if (drawableM3861a == null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                drawableM3861a = new LayerDrawable(new Drawable[]{m3881a(context, R.drawable.abc_cab_background_internal_bg), m3881a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (drawableM3861a != null) {
                drawableM3861a.setChangingConfigurations(typedValue.changingConfigurations);
                m3869a(context, jM3856a, drawableM3861a);
            }
        }
        return drawableM3861a;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m3860a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListM3885b = m3885b(context, i);
        if (colorStateListM3885b != null) {
            if (DrawableUtils.m4117c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableM2000g = DrawableCompat.m2000g(drawable);
            DrawableCompat.m1989a(drawableM2000g, colorStateListM3885b);
            PorterDuff.Mode modeM3857a = m3857a(i);
            if (modeM3857a != null) {
                DrawableCompat.m1992a(drawableM2000g, modeM3857a);
                return drawableM2000g;
            }
            return drawableM2000g;
        }
        if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            m3864a(layerDrawable.findDrawableByLayerId(android.R.id.background), ThemeUtils.m4943a(context, R.attr.colorControlNormal), f3663a);
            m3864a(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.m4943a(context, R.attr.colorControlNormal), f3663a);
            m3864a(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.m4943a(context, R.attr.colorControlActivated), f3663a);
            return drawable;
        }
        if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m3864a(layerDrawable2.findDrawableByLayerId(android.R.id.background), ThemeUtils.m4947c(context, R.attr.colorControlNormal), f3663a);
            m3864a(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.m4943a(context, R.attr.colorControlActivated), f3663a);
            m3864a(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.m4943a(context, R.attr.colorControlActivated), f3663a);
            return drawable;
        }
        if (!m3868a(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX INFO: renamed from: d */
    private Drawable m3876d(Context context, int i) {
        Drawable drawable;
        int next;
        if (this.f3673k == null || this.f3673k.isEmpty()) {
            return null;
        }
        if (this.f3674l != null) {
            String strM2457a = this.f3674l.m2457a(i);
            if ("appcompat_skip_skip".equals(strM2457a) || (strM2457a != null && this.f3673k.get(strM2457a) == null)) {
                return null;
            }
        } else {
            this.f3674l = new SparseArrayCompat<>();
        }
        if (this.f3677o == null) {
            this.f3677o = new TypedValue();
        }
        TypedValue typedValue = this.f3677o;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jM3856a = m3856a(typedValue);
        Drawable drawableM3861a = m3861a(context, jM3856a);
        if (drawableM3861a != null) {
            return drawableM3861a;
        }
        if (typedValue.string == null || !typedValue.string.toString().endsWith(".xml")) {
            drawable = drawableM3861a;
        } else {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f3674l.m2464c(i, name);
                InflateDelegate inflateDelegate = this.f3673k.get(name);
                if (inflateDelegate != null) {
                    drawableM3861a = inflateDelegate.mo3886a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM3861a != null) {
                    drawableM3861a.setChangingConfigurations(typedValue.changingConfigurations);
                    if (m3869a(context, jM3856a, drawableM3861a)) {
                    }
                }
                drawable = drawableM3861a;
            } catch (Exception e) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e);
                drawable = drawableM3861a;
            }
        }
        if (drawable == null) {
            this.f3674l.m2464c(i, "appcompat_skip_skip");
            return drawable;
        }
        return drawable;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m3861a(Context context, long j) {
        synchronized (this.f3675m) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f3676n.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReferenceM2406a = longSparseArray.m2406a(j);
            if (weakReferenceM2406a != null) {
                Drawable.ConstantState constantState = weakReferenceM2406a.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.m2411b(j);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3869a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.f3675m) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f3676n.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray<>();
                    this.f3676n.put(context, longSparseArray);
                }
                longSparseArray.m2412b(j, new WeakReference<>(constantState));
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    Drawable m3883a(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        Drawable drawableM3876d = m3876d(context, i);
        if (drawableM3876d == null) {
            drawableM3876d = vectorEnabledTintResources.m5000a(i);
        }
        if (drawableM3876d != null) {
            return m3860a(context, i, false, drawableM3876d);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    static boolean m3868a(Context context, int i, Drawable drawable) {
        int iRound;
        int i2;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = f3663a;
        if (m3871a(f3666d, i)) {
            i2 = R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            iRound = -1;
        } else if (m3871a(f3668f, i)) {
            i2 = R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            iRound = -1;
        } else if (m3871a(f3669g, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i2 = 16842801;
            iRound = -1;
        } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
            i2 = android.R.attr.colorForeground;
            iRound = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == R.drawable.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            iRound = -1;
        } else {
            iRound = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (DrawableUtils.m4117c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m3858a(ThemeUtils.m4943a(context, i2), mode));
        if (iRound == -1) {
            return true;
        }
        drawable.setAlpha(iRound);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m3867a(String str, InflateDelegate inflateDelegate) {
        if (this.f3673k == null) {
            this.f3673k = new ArrayMap<>();
        }
        this.f3673k.put(str, inflateDelegate);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3871a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static PorterDuff.Mode m3857a(int i) {
        if (i != R.drawable.abc_switch_thumb_material) {
            return null;
        }
        return PorterDuff.Mode.MULTIPLY;
    }

    /* JADX INFO: renamed from: b */
    ColorStateList m3885b(Context context, int i) {
        ColorStateList colorStateListM3878e = m3878e(context, i);
        if (colorStateListM3878e == null) {
            if (i == R.drawable.abc_edit_text_material) {
                colorStateListM3878e = AppCompatResources.m3423a(context, R.color.abc_tint_edittext);
            } else if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                colorStateListM3878e = AppCompatResources.m3423a(context, R.color.abc_tint_switch_track);
            } else if (i == R.drawable.abc_switch_thumb_material) {
                colorStateListM3878e = m3877e(context);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                colorStateListM3878e = m3872b(context);
            } else if (i == R.drawable.abc_btn_borderless_material) {
                colorStateListM3878e = m3873c(context);
            } else if (i == R.drawable.abc_btn_colored_material) {
                colorStateListM3878e = m3875d(context);
            } else if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                colorStateListM3878e = AppCompatResources.m3423a(context, R.color.abc_tint_spinner);
            } else if (m3871a(f3667e, i)) {
                colorStateListM3878e = ThemeUtils.m4946b(context, R.attr.colorControlNormal);
            } else if (m3871a(f3670h, i)) {
                colorStateListM3878e = AppCompatResources.m3423a(context, R.color.abc_tint_default);
            } else if (m3871a(f3671i, i)) {
                colorStateListM3878e = AppCompatResources.m3423a(context, R.color.abc_tint_btn_checkable);
            } else if (i == R.drawable.abc_seekbar_thumb_material) {
                colorStateListM3878e = AppCompatResources.m3423a(context, R.color.abc_tint_seek_thumb);
            }
            if (colorStateListM3878e != null) {
                m3863a(context, i, colorStateListM3878e);
            }
        }
        return colorStateListM3878e;
    }

    /* JADX INFO: renamed from: e */
    private ColorStateList m3878e(Context context, int i) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        if (this.f3672j != null && (sparseArrayCompat = this.f3672j.get(context)) != null) {
            return sparseArrayCompat.m2457a(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m3863a(Context context, int i, ColorStateList colorStateList) {
        if (this.f3672j == null) {
            this.f3672j = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.f3672j.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.f3672j.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.m2464c(i, colorStateList);
    }

    /* JADX INFO: renamed from: b */
    private ColorStateList m3872b(Context context) {
        return m3879f(context, ThemeUtils.m4943a(context, R.attr.colorButtonNormal));
    }

    /* JADX INFO: renamed from: c */
    private ColorStateList m3873c(Context context) {
        return m3879f(context, 0);
    }

    /* JADX INFO: renamed from: d */
    private ColorStateList m3875d(Context context) {
        return m3879f(context, ThemeUtils.m4943a(context, R.attr.colorAccent));
    }

    /* JADX INFO: renamed from: f */
    private ColorStateList m3879f(Context context, int i) {
        int iM4943a = ThemeUtils.m4943a(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{ThemeUtils.f4413a, ThemeUtils.f4416d, ThemeUtils.f4414b, ThemeUtils.f4420h}, new int[]{ThemeUtils.m4947c(context, R.attr.colorButtonNormal), ColorUtils.m1933a(iM4943a, i), ColorUtils.m1933a(iM4943a, i), i});
    }

    /* JADX INFO: renamed from: e */
    private ColorStateList m3877e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListM4946b = ThemeUtils.m4946b(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListM4946b != null && colorStateListM4946b.isStateful()) {
            iArr[0] = ThemeUtils.f4413a;
            iArr2[0] = colorStateListM4946b.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.f4417e;
            iArr2[1] = ThemeUtils.m4943a(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.f4420h;
            iArr2[2] = colorStateListM4946b.getDefaultColor();
        } else {
            iArr[0] = ThemeUtils.f4413a;
            iArr2[0] = ThemeUtils.m4947c(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.f4417e;
            iArr2[1] = ThemeUtils.m4943a(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.f4420h;
            iArr2[2] = ThemeUtils.m4943a(context, R.attr.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        /* JADX INFO: renamed from: a */
        PorterDuffColorFilter m3888a(int i, PorterDuff.Mode mode) {
            return m2417a(Integer.valueOf(m3887b(i, mode)));
        }

        /* JADX INFO: renamed from: a */
        PorterDuffColorFilter m3889a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return m2418a(Integer.valueOf(m3887b(i, mode)), porterDuffColorFilter);
        }

        /* JADX INFO: renamed from: b */
        private static int m3887b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* JADX INFO: renamed from: a */
    static void m3865a(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (DrawableUtils.m4117c(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (tintInfo.f4430d || tintInfo.f4429c) {
            drawable.setColorFilter(m3859a(tintInfo.f4430d ? tintInfo.f4427a : null, tintInfo.f4429c ? tintInfo.f4428b : f3663a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private static PorterDuffColorFilter m3859a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m3858a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* JADX INFO: renamed from: a */
    public static PorterDuffColorFilter m3858a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM3888a = f3665c.m3888a(i, mode);
        if (porterDuffColorFilterM3888a == null) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            f3665c.m3889a(i, mode, porterDuffColorFilter);
            return porterDuffColorFilter;
        }
        return porterDuffColorFilterM3888a;
    }

    /* JADX INFO: renamed from: a */
    private static void m3864a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (DrawableUtils.m4117c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f3663a;
        }
        drawable.setColorFilter(m3858a(i, mode));
    }

    /* JADX INFO: renamed from: f */
    private void m3880f(Context context) {
        if (!this.f3678p) {
            this.f3678p = true;
            Drawable drawableM3881a = m3881a(context, R.drawable.abc_vector_test);
            if (drawableM3881a == null || !m3870a(drawableM3881a)) {
                this.f3678p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3870a(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // android.support.v7.widget.AppCompatDrawableManager.InflateDelegate
        /* JADX INFO: renamed from: a */
        public Drawable mo3886a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.m988a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // android.support.v7.widget.AppCompatDrawableManager.InflateDelegate
        /* JADX INFO: renamed from: a */
        public Drawable mo3886a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.m952a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }
}
