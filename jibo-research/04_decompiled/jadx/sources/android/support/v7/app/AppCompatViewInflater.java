package android.support.v7.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {

    /* JADX INFO: renamed from: a */
    private static final Class<?>[] f3020a = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: b */
    private static final int[] f3021b = {R.attr.onClick};

    /* JADX INFO: renamed from: c */
    private static final String[] f3022c = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: d */
    private static final Map<String, Constructor<? extends View>> f3023d = new ArrayMap();

    /* JADX INFO: renamed from: e */
    private final Object[] f3024e = new Object[2];

    /* JADX INFO: renamed from: a */
    final View m3352a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View viewM3364m;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m3345a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = TintContextWrapper.m4950a(context2);
        }
        switch (str) {
            case "TextView":
                viewM3364m = m3350a(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "ImageView":
                viewM3364m = m3353b(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "Button":
                viewM3364m = m3354c(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "EditText":
                viewM3364m = m3355d(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "Spinner":
                viewM3364m = m3356e(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "ImageButton":
                viewM3364m = m3357f(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "CheckBox":
                viewM3364m = m3358g(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "RadioButton":
                viewM3364m = m3359h(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "CheckedTextView":
                viewM3364m = m3360i(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "AutoCompleteTextView":
                viewM3364m = m3361j(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "MultiAutoCompleteTextView":
                viewM3364m = m3362k(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "RatingBar":
                viewM3364m = m3363l(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            case "SeekBar":
                viewM3364m = m3364m(context2, attributeSet);
                m3348a(viewM3364m, str);
                break;
            default:
                viewM3364m = m3351a(context2, str, attributeSet);
                break;
        }
        View viewM3349b = (viewM3364m != null || context == context2) ? viewM3364m : m3349b(context2, str, attributeSet);
        if (viewM3349b != null) {
            m3347a(viewM3349b, attributeSet);
        }
        return viewM3349b;
    }

    /* JADX INFO: renamed from: a */
    protected AppCompatTextView m3350a(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* JADX INFO: renamed from: b */
    protected AppCompatImageView m3353b(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* JADX INFO: renamed from: c */
    protected AppCompatButton m3354c(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* JADX INFO: renamed from: d */
    protected AppCompatEditText m3355d(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    /* JADX INFO: renamed from: e */
    protected AppCompatSpinner m3356e(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    /* JADX INFO: renamed from: f */
    protected AppCompatImageButton m3357f(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    /* JADX INFO: renamed from: g */
    protected AppCompatCheckBox m3358g(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* JADX INFO: renamed from: h */
    protected AppCompatRadioButton m3359h(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* JADX INFO: renamed from: i */
    protected AppCompatCheckedTextView m3360i(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    /* JADX INFO: renamed from: j */
    protected AppCompatAutoCompleteTextView m3361j(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    /* JADX INFO: renamed from: k */
    protected AppCompatMultiAutoCompleteTextView m3362k(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    /* JADX INFO: renamed from: l */
    protected AppCompatRatingBar m3363l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    /* JADX INFO: renamed from: m */
    protected AppCompatSeekBar m3364m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m3348a(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* JADX INFO: renamed from: a */
    protected View m3351a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    private View m3349b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f3024e[0] = context;
            this.f3024e[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return m3346a(context, str, (String) null);
            }
            for (int i = 0; i < f3022c.length; i++) {
                View viewM3346a = m3346a(context, str, f3022c[i]);
                if (viewM3346a != null) {
                    return viewM3346a;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            this.f3024e[0] = null;
            this.f3024e[1] = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3347a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ViewCompat.m2571C(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3021b);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new DeclaredOnClickListener(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private View m3346a(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        Constructor<? extends View> constructor = f3023d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f3020a);
                f3023d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f3024e);
    }

    /* JADX INFO: renamed from: a */
    private static Context m3345a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        if (i != 0) {
            if (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).m3477a() != i) {
                return new ContextThemeWrapper(context, i);
            }
            return context;
        }
        return context;
    }

    private static class DeclaredOnClickListener implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        private final View f3025a;

        /* JADX INFO: renamed from: b */
        private final String f3026b;

        /* JADX INFO: renamed from: c */
        private Method f3027c;

        /* JADX INFO: renamed from: d */
        private Context f3028d;

        public DeclaredOnClickListener(View view, String str) {
            this.f3025a = view;
            this.f3026b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f3027c == null) {
                m3365a(this.f3025a.getContext(), this.f3026b);
            }
            try {
                this.f3027c.invoke(this.f3028d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m3365a(Context context, String str) {
            Method method;
            Context baseContext = context;
            while (baseContext != null) {
                try {
                    if (!baseContext.isRestricted() && (method = baseContext.getClass().getMethod(this.f3026b, View.class)) != null) {
                        this.f3027c = method;
                        this.f3028d = baseContext;
                        return;
                    }
                } catch (NoSuchMethodException e) {
                }
                if (baseContext instanceof ContextWrapper) {
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                } else {
                    baseContext = null;
                }
            }
            int id = this.f3025a.getId();
            throw new IllegalStateException("Could not find method " + this.f3026b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f3025a.getClass() + (id == -1 ? "" : " with id '" + this.f3025a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
    }
}
