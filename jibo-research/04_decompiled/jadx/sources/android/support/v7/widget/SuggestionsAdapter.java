package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    private final SearchManager f4353j;

    /* JADX INFO: renamed from: k */
    private final SearchView f4354k;

    /* JADX INFO: renamed from: l */
    private final SearchableInfo f4355l;

    /* JADX INFO: renamed from: m */
    private final Context f4356m;

    /* JADX INFO: renamed from: n */
    private final WeakHashMap<String, Drawable.ConstantState> f4357n;

    /* JADX INFO: renamed from: o */
    private final int f4358o;

    /* JADX INFO: renamed from: p */
    private boolean f4359p;

    /* JADX INFO: renamed from: q */
    private int f4360q;

    /* JADX INFO: renamed from: r */
    private ColorStateList f4361r;

    /* JADX INFO: renamed from: s */
    private int f4362s;

    /* JADX INFO: renamed from: t */
    private int f4363t;

    /* JADX INFO: renamed from: u */
    private int f4364u;

    /* JADX INFO: renamed from: v */
    private int f4365v;

    /* JADX INFO: renamed from: w */
    private int f4366w;

    /* JADX INFO: renamed from: x */
    private int f4367x;

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f4359p = false;
        this.f4360q = 1;
        this.f4362s = -1;
        this.f4363t = -1;
        this.f4364u = -1;
        this.f4365v = -1;
        this.f4366w = -1;
        this.f4367x = -1;
        this.f4353j = (SearchManager) this.f2572d.getSystemService("search");
        this.f4354k = searchView;
        this.f4355l = searchableInfo;
        this.f4358o = searchView.getSuggestionCommitIconResId();
        this.f4356m = context;
        this.f4357n = weakHashMap;
    }

    /* JADX INFO: renamed from: a */
    public void m4927a(int i) {
        this.f4360q = i;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: a */
    public Cursor mo2936a(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f4354k.getVisibility() != 0 || this.f4354k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursorM4925a = m4925a(this.f4355l, string, 50);
            if (cursorM4925a != null) {
                cursorM4925a.getCount();
                return cursorM4925a;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m4921d(mo2935a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m4921d(mo2935a());
    }

    /* JADX INFO: renamed from: d */
    private void m4921d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: a */
    public void mo2939a(Cursor cursor) {
        if (this.f4359p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo2939a(cursor);
            if (cursor != null) {
                this.f4362s = cursor.getColumnIndex("suggest_text_1");
                this.f4363t = cursor.getColumnIndex("suggest_text_2");
                this.f4364u = cursor.getColumnIndex("suggest_text_2_url");
                this.f4365v = cursor.getColumnIndex("suggest_icon_1");
                this.f4366w = cursor.getColumnIndex("suggest_icon_2");
                this.f4367x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    /* JADX INFO: renamed from: a */
    public View mo2937a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewMo2937a = super.mo2937a(context, cursor, viewGroup);
        viewMo2937a.setTag(new ChildViewCache(viewMo2937a));
        ((ImageView) viewMo2937a.findViewById(R.id.edit_query)).setImageResource(this.f4358o);
        return viewMo2937a;
    }

    private static final class ChildViewCache {

        /* JADX INFO: renamed from: a */
        public final TextView f4368a;

        /* JADX INFO: renamed from: b */
        public final TextView f4369b;

        /* JADX INFO: renamed from: c */
        public final ImageView f4370c;

        /* JADX INFO: renamed from: d */
        public final ImageView f4371d;

        /* JADX INFO: renamed from: e */
        public final ImageView f4372e;

        public ChildViewCache(View view) {
            this.f4368a = (TextView) view.findViewById(android.R.id.text1);
            this.f4369b = (TextView) view.findViewById(android.R.id.text2);
            this.f4370c = (ImageView) view.findViewById(android.R.id.icon1);
            this.f4371d = (ImageView) view.findViewById(android.R.id.icon2);
            this.f4372e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    /* JADX INFO: renamed from: a */
    public void mo2940a(View view, Context context, Cursor cursor) {
        CharSequence charSequenceM4912a;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.f4367x != -1 ? cursor.getInt(this.f4367x) : 0;
        if (childViewCache.f4368a != null) {
            m4915a(childViewCache.f4368a, m4912a(cursor, this.f4362s));
        }
        if (childViewCache.f4369b != null) {
            String strM4912a = m4912a(cursor, this.f4364u);
            if (strM4912a != null) {
                charSequenceM4912a = m4920b((CharSequence) strM4912a);
            } else {
                charSequenceM4912a = m4912a(cursor, this.f4363t);
            }
            if (TextUtils.isEmpty(charSequenceM4912a)) {
                if (childViewCache.f4368a != null) {
                    childViewCache.f4368a.setSingleLine(false);
                    childViewCache.f4368a.setMaxLines(2);
                }
            } else if (childViewCache.f4368a != null) {
                childViewCache.f4368a.setSingleLine(true);
                childViewCache.f4368a.setMaxLines(1);
            }
            m4915a(childViewCache.f4369b, charSequenceM4912a);
        }
        if (childViewCache.f4370c != null) {
            m4914a(childViewCache.f4370c, m4922e(cursor), 4);
        }
        if (childViewCache.f4371d != null) {
            m4914a(childViewCache.f4371d, m4923f(cursor), 8);
        }
        if (this.f4360q == 2 || (this.f4360q == 1 && (i & 1) != 0)) {
            childViewCache.f4372e.setVisibility(0);
            childViewCache.f4372e.setTag(childViewCache.f4368a.getText());
            childViewCache.f4372e.setOnClickListener(this);
            return;
        }
        childViewCache.f4372e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f4354k.m4754a((CharSequence) tag);
        }
    }

    /* JADX INFO: renamed from: b */
    private CharSequence m4920b(CharSequence charSequence) {
        if (this.f4361r == null) {
            TypedValue typedValue = new TypedValue();
            this.f2572d.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f4361r = this.f2572d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f4361r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* JADX INFO: renamed from: a */
    private void m4915a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: e */
    private Drawable m4922e(Cursor cursor) {
        if (this.f4365v == -1) {
            return null;
        }
        Drawable drawableM4911a = m4911a(cursor.getString(this.f4365v));
        return drawableM4911a == null ? m4924g(cursor) : drawableM4911a;
    }

    /* JADX INFO: renamed from: f */
    private Drawable m4923f(Cursor cursor) {
        if (this.f4366w == -1) {
            return null;
        }
        return m4911a(cursor.getString(this.f4366w));
    }

    /* JADX INFO: renamed from: a */
    private void m4914a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: c */
    public CharSequence mo2944c(Cursor cursor) {
        String strM4913a;
        String strM4913a2;
        if (cursor == null) {
            return null;
        }
        String strM4913a3 = m4913a(cursor, "suggest_intent_query");
        if (strM4913a3 != null) {
            return strM4913a3;
        }
        if (this.f4355l.shouldRewriteQueryFromData() && (strM4913a2 = m4913a(cursor, "suggest_intent_data")) != null) {
            return strM4913a2;
        }
        if (!this.f4355l.shouldRewriteQueryFromText() || (strM4913a = m4913a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM4913a;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewMo2937a = mo2937a(this.f2572d, this.f2571c, viewGroup);
            if (viewMo2937a != null) {
                ((ChildViewCache) viewMo2937a.getTag()).f4368a.setText(e.toString());
            }
            return viewMo2937a;
        }
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewB = mo2942b(this.f2572d, this.f2571c, viewGroup);
            if (viewB != null) {
                ((ChildViewCache) viewB.getTag()).f4368a.setText(e.toString());
            }
            return viewB;
        }
    }

    /* JADX INFO: renamed from: a */
    private Drawable m4911a(String str) {
        if (str == null || str.isEmpty() || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f4356m.getPackageName() + "/" + i;
            Drawable drawableM4919b = m4919b(str2);
            if (drawableM4919b == null) {
                Drawable drawableM1832a = ContextCompat.m1832a(this.f4356m, i);
                m4916a(str2, drawableM1832a);
                return drawableM1832a;
            }
            return drawableM4919b;
        } catch (Resources.NotFoundException e) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException e2) {
            Drawable drawableM4919b2 = m4919b(str);
            if (drawableM4919b2 == null) {
                Drawable drawableM4918b = m4918b(Uri.parse(str));
                m4916a(str, drawableM4918b);
                return drawableM4918b;
            }
            return drawableM4919b2;
        }
    }

    /* JADX INFO: renamed from: b */
    private Drawable m4918b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m4926a(uri);
                } catch (Resources.NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f4356m.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                    return drawableCreateFromStream;
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                    return drawableCreateFromStream;
                }
            } finally {
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    /* JADX INFO: renamed from: b */
    private Drawable m4919b(String str) {
        Drawable.ConstantState constantState = this.f4357n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* JADX INFO: renamed from: a */
    private void m4916a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f4357n.put(str, drawable.getConstantState());
        }
    }

    /* JADX INFO: renamed from: g */
    private Drawable m4924g(Cursor cursor) {
        Drawable drawableM4910a = m4910a(this.f4355l.getSearchActivity());
        return drawableM4910a != null ? drawableM4910a : this.f2572d.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX INFO: renamed from: a */
    private Drawable m4910a(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (this.f4357n.containsKey(strFlattenToShortString)) {
            Drawable.ConstantState constantState = this.f4357n.get(strFlattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f4356m.getResources());
        }
        Drawable drawableM4917b = m4917b(componentName);
        this.f4357n.put(strFlattenToShortString, drawableM4917b != null ? drawableM4917b.getConstantState() : null);
        return drawableM4917b;
    }

    /* JADX INFO: renamed from: b */
    private Drawable m4917b(ComponentName componentName) {
        PackageManager packageManager = this.f2572d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m4913a(Cursor cursor, String str) {
        return m4912a(cursor, cursor.getColumnIndex(str));
    }

    /* JADX INFO: renamed from: a */
    private static String m4912a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    Drawable m4926a(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2572d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX INFO: renamed from: a */
    Cursor m4925a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f2572d.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr, null);
    }
}
