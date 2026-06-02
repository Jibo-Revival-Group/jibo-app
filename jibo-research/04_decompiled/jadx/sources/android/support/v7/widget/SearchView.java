package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* JADX INFO: renamed from: i */
    static final AutoCompleteTextViewReflector f4220i = new AutoCompleteTextViewReflector();

    /* JADX INFO: renamed from: A */
    private OnQueryTextListener f4221A;

    /* JADX INFO: renamed from: B */
    private OnCloseListener f4222B;

    /* JADX INFO: renamed from: C */
    private OnSuggestionListener f4223C;

    /* JADX INFO: renamed from: D */
    private View.OnClickListener f4224D;

    /* JADX INFO: renamed from: E */
    private boolean f4225E;

    /* JADX INFO: renamed from: F */
    private boolean f4226F;

    /* JADX INFO: renamed from: G */
    private boolean f4227G;

    /* JADX INFO: renamed from: H */
    private CharSequence f4228H;

    /* JADX INFO: renamed from: I */
    private boolean f4229I;

    /* JADX INFO: renamed from: J */
    private boolean f4230J;

    /* JADX INFO: renamed from: K */
    private int f4231K;

    /* JADX INFO: renamed from: L */
    private boolean f4232L;

    /* JADX INFO: renamed from: M */
    private CharSequence f4233M;

    /* JADX INFO: renamed from: N */
    private CharSequence f4234N;

    /* JADX INFO: renamed from: O */
    private boolean f4235O;

    /* JADX INFO: renamed from: P */
    private int f4236P;

    /* JADX INFO: renamed from: Q */
    private Bundle f4237Q;

    /* JADX INFO: renamed from: R */
    private final Runnable f4238R;

    /* JADX INFO: renamed from: S */
    private Runnable f4239S;

    /* JADX INFO: renamed from: T */
    private final WeakHashMap<String, Drawable.ConstantState> f4240T;

    /* JADX INFO: renamed from: U */
    private final View.OnClickListener f4241U;

    /* JADX INFO: renamed from: V */
    private final TextView.OnEditorActionListener f4242V;

    /* JADX INFO: renamed from: W */
    private final AdapterView.OnItemClickListener f4243W;

    /* JADX INFO: renamed from: a */
    final SearchAutoComplete f4244a;

    /* JADX INFO: renamed from: aa */
    private final AdapterView.OnItemSelectedListener f4245aa;

    /* JADX INFO: renamed from: ab */
    private TextWatcher f4246ab;

    /* JADX INFO: renamed from: b */
    final ImageView f4247b;

    /* JADX INFO: renamed from: c */
    final ImageView f4248c;

    /* JADX INFO: renamed from: d */
    final ImageView f4249d;

    /* JADX INFO: renamed from: e */
    final ImageView f4250e;

    /* JADX INFO: renamed from: f */
    View.OnFocusChangeListener f4251f;

    /* JADX INFO: renamed from: g */
    CursorAdapter f4252g;

    /* JADX INFO: renamed from: h */
    SearchableInfo f4253h;

    /* JADX INFO: renamed from: j */
    View.OnKeyListener f4254j;

    /* JADX INFO: renamed from: k */
    private final View f4255k;

    /* JADX INFO: renamed from: l */
    private final View f4256l;

    /* JADX INFO: renamed from: m */
    private final View f4257m;

    /* JADX INFO: renamed from: n */
    private final View f4258n;

    /* JADX INFO: renamed from: o */
    private UpdatableTouchDelegate f4259o;

    /* JADX INFO: renamed from: p */
    private Rect f4260p;

    /* JADX INFO: renamed from: q */
    private Rect f4261q;

    /* JADX INFO: renamed from: r */
    private int[] f4262r;

    /* JADX INFO: renamed from: s */
    private int[] f4263s;

    /* JADX INFO: renamed from: t */
    private final ImageView f4264t;

    /* JADX INFO: renamed from: u */
    private final Drawable f4265u;

    /* JADX INFO: renamed from: v */
    private final int f4266v;

    /* JADX INFO: renamed from: w */
    private final int f4267w;

    /* JADX INFO: renamed from: x */
    private final Intent f4268x;

    /* JADX INFO: renamed from: y */
    private final Intent f4269y;

    /* JADX INFO: renamed from: z */
    private final CharSequence f4270z;

    public interface OnCloseListener {
        /* JADX INFO: renamed from: a */
        boolean m4772a();
    }

    public interface OnQueryTextListener {
        /* JADX INFO: renamed from: a */
        boolean m4773a(String str);

        /* JADX INFO: renamed from: b */
        boolean m4774b(String str);
    }

    public interface OnSuggestionListener {
        /* JADX INFO: renamed from: a */
        boolean m4775a(int i);

        /* JADX INFO: renamed from: b */
        boolean m4776b(int i);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4260p = new Rect();
        this.f4261q = new Rect();
        this.f4262r = new int[2];
        this.f4263s = new int[2];
        this.f4238R = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.m4761d();
            }
        };
        this.f4239S = new Runnable() { // from class: android.support.v7.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.f4252g != null && (SearchView.this.f4252g instanceof SuggestionsAdapter)) {
                    SearchView.this.f4252g.mo2939a((Cursor) null);
                }
            }
        };
        this.f4240T = new WeakHashMap<>();
        this.f4241U = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.f4247b) {
                    SearchView.this.m4764g();
                    return;
                }
                if (view == SearchView.this.f4249d) {
                    SearchView.this.m4763f();
                    return;
                }
                if (view == SearchView.this.f4248c) {
                    SearchView.this.m4762e();
                } else if (view == SearchView.this.f4250e) {
                    SearchView.this.m4765h();
                } else if (view == SearchView.this.f4244a) {
                    SearchView.this.m4768l();
                }
            }
        };
        this.f4254j = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.f4253h == null) {
                    return false;
                }
                if (SearchView.this.f4244a.isPopupShowing() && SearchView.this.f4244a.getListSelection() != -1) {
                    return SearchView.this.m4758a(view, i2, keyEvent);
                }
                if (SearchView.this.f4244a.m4781a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.m4753a(0, (String) null, SearchView.this.f4244a.getText().toString());
                return true;
            }
        };
        this.f4242V = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.m4762e();
                return true;
            }
        };
        this.f4243W = new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.m4757a(i2, 0, (String) null);
            }
        };
        this.f4245aa = new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.m4756a(i2);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f4246ab = new TextWatcher() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.m4759b(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, R.styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(tintTypedArrayM4955a.m4972g(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        this.f4244a = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f4244a.setSearchView(this);
        this.f4255k = findViewById(R.id.search_edit_frame);
        this.f4256l = findViewById(R.id.search_plate);
        this.f4257m = findViewById(R.id.submit_area);
        this.f4247b = (ImageView) findViewById(R.id.search_button);
        this.f4248c = (ImageView) findViewById(R.id.search_go_btn);
        this.f4249d = (ImageView) findViewById(R.id.search_close_btn);
        this.f4250e = (ImageView) findViewById(R.id.search_voice_btn);
        this.f4264t = (ImageView) findViewById(R.id.search_mag_icon);
        ViewCompat.m2582a(this.f4256l, tintTypedArrayM4955a.m4959a(R.styleable.SearchView_queryBackground));
        ViewCompat.m2582a(this.f4257m, tintTypedArrayM4955a.m4959a(R.styleable.SearchView_submitBackground));
        this.f4247b.setImageDrawable(tintTypedArrayM4955a.m4959a(R.styleable.SearchView_searchIcon));
        this.f4248c.setImageDrawable(tintTypedArrayM4955a.m4959a(R.styleable.SearchView_goIcon));
        this.f4249d.setImageDrawable(tintTypedArrayM4955a.m4959a(R.styleable.SearchView_closeIcon));
        this.f4250e.setImageDrawable(tintTypedArrayM4955a.m4959a(R.styleable.SearchView_voiceIcon));
        this.f4264t.setImageDrawable(tintTypedArrayM4955a.m4959a(R.styleable.SearchView_searchIcon));
        this.f4265u = tintTypedArrayM4955a.m4959a(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.m4985a(this.f4247b, getResources().getString(R.string.abc_searchview_description_search));
        this.f4266v = tintTypedArrayM4955a.m4972g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.f4267w = tintTypedArrayM4955a.m4972g(R.styleable.SearchView_commitIcon, 0);
        this.f4247b.setOnClickListener(this.f4241U);
        this.f4249d.setOnClickListener(this.f4241U);
        this.f4248c.setOnClickListener(this.f4241U);
        this.f4250e.setOnClickListener(this.f4241U);
        this.f4244a.setOnClickListener(this.f4241U);
        this.f4244a.addTextChangedListener(this.f4246ab);
        this.f4244a.setOnEditorActionListener(this.f4242V);
        this.f4244a.setOnItemClickListener(this.f4243W);
        this.f4244a.setOnItemSelectedListener(this.f4245aa);
        this.f4244a.setOnKeyListener(this.f4254j);
        this.f4244a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f4251f != null) {
                    SearchView.this.f4251f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(tintTypedArrayM4955a.m4961a(R.styleable.SearchView_iconifiedByDefault, true));
        int iM4968e = tintTypedArrayM4955a.m4968e(R.styleable.SearchView_android_maxWidth, -1);
        if (iM4968e != -1) {
            setMaxWidth(iM4968e);
        }
        this.f4270z = tintTypedArrayM4955a.m4965c(R.styleable.SearchView_defaultQueryHint);
        this.f4228H = tintTypedArrayM4955a.m4965c(R.styleable.SearchView_queryHint);
        int iM4957a = tintTypedArrayM4955a.m4957a(R.styleable.SearchView_android_imeOptions, -1);
        if (iM4957a != -1) {
            setImeOptions(iM4957a);
        }
        int iM4957a2 = tintTypedArrayM4955a.m4957a(R.styleable.SearchView_android_inputType, -1);
        if (iM4957a2 != -1) {
            setInputType(iM4957a2);
        }
        setFocusable(tintTypedArrayM4955a.m4961a(R.styleable.SearchView_android_focusable, true));
        tintTypedArrayM4955a.m4960a();
        this.f4268x = new Intent("android.speech.action.WEB_SEARCH");
        this.f4268x.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f4268x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f4269y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f4269y.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f4258n = findViewById(this.f4244a.getDropDownAnchor());
        if (this.f4258n != null) {
            this.f4258n.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.m4767k();
                }
            });
        }
        m4737a(this.f4225E);
        m4750r();
    }

    int getSuggestionRowLayout() {
        return this.f4266v;
    }

    int getSuggestionCommitIconResId() {
        return this.f4267w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f4253h = searchableInfo;
        if (this.f4253h != null) {
            m4751s();
            m4750r();
        }
        this.f4232L = m4745m();
        if (this.f4232L) {
            this.f4244a.setPrivateImeOptions("nm");
        }
        m4737a(m4760c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f4237Q = bundle;
    }

    public void setImeOptions(int i) {
        this.f4244a.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f4244a.getImeOptions();
    }

    public void setInputType(int i) {
        this.f4244a.setInputType(i);
    }

    public int getInputType() {
        return this.f4244a.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f4230J || !isFocusable()) {
            return false;
        }
        if (!m4760c()) {
            boolean zRequestFocus = this.f4244a.requestFocus(i, rect);
            if (zRequestFocus) {
                m4737a(false);
            }
            return zRequestFocus;
        }
        return super.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f4230J = true;
        super.clearFocus();
        this.f4244a.clearFocus();
        this.f4244a.setImeVisibility(false);
        this.f4230J = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.f4221A = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f4222B = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f4251f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.f4223C = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f4224D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f4244a.getText();
    }

    /* JADX INFO: renamed from: a */
    public void m4755a(CharSequence charSequence, boolean z) {
        this.f4244a.setText(charSequence);
        if (charSequence != null) {
            this.f4244a.setSelection(this.f4244a.length());
            this.f4234N = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m4762e();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f4228H = charSequence;
        m4750r();
    }

    public CharSequence getQueryHint() {
        if (this.f4228H != null) {
            return this.f4228H;
        }
        if (this.f4253h != null && this.f4253h.getHintId() != 0) {
            return getContext().getText(this.f4253h.getHintId());
        }
        return this.f4270z;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f4225E != z) {
            this.f4225E = z;
            m4737a(z);
            m4750r();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m4763f();
        } else {
            m4764g();
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m4760c() {
        return this.f4226F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f4227G = z;
        m4737a(m4760c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f4229I = z;
        if (this.f4252g instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) this.f4252g).m4927a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f4252g = cursorAdapter;
        this.f4244a.setAdapter(this.f4252g);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f4252g;
    }

    public void setMaxWidth(int i) {
        this.f4231K = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f4231K;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        if (m4760c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                size = this.f4231K > 0 ? Math.min(this.f4231K, size) : Math.min(getPreferredWidth(), size);
                break;
            case 0:
                size = this.f4231K <= 0 ? getPreferredWidth() : this.f4231K;
                break;
            case 1073741824:
                if (this.f4231K > 0) {
                    size = Math.min(this.f4231K, size);
                }
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(getPreferredHeight(), size2);
                break;
            case 0:
                size2 = getPreferredHeight();
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m4736a(this.f4244a, this.f4260p);
            this.f4261q.set(this.f4260p.left, 0, this.f4260p.right, i4 - i2);
            if (this.f4259o == null) {
                this.f4259o = new UpdatableTouchDelegate(this.f4261q, this.f4260p, this.f4244a);
                setTouchDelegate(this.f4259o);
            } else {
                this.f4259o.m4785a(this.f4261q, this.f4260p);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4736a(View view, Rect rect) {
        view.getLocationInWindow(this.f4262r);
        getLocationInWindow(this.f4263s);
        int i = this.f4262r[1] - this.f4263s[1];
        int i2 = this.f4262r[0] - this.f4263s[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    /* JADX INFO: renamed from: a */
    private void m4737a(boolean z) {
        int i = 8;
        this.f4226F = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f4244a.getText());
        this.f4247b.setVisibility(i2);
        m4740b(z2);
        this.f4255k.setVisibility(z ? 8 : 0);
        if (this.f4264t.getDrawable() != null && !this.f4225E) {
            i = 0;
        }
        this.f4264t.setVisibility(i);
        m4748p();
        m4743c(z2 ? false : true);
        m4747o();
    }

    /* JADX INFO: renamed from: m */
    private boolean m4745m() {
        if (this.f4253h == null || !this.f4253h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f4253h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f4268x;
        } else if (this.f4253h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f4269y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == null) ? false : true;
    }

    /* JADX INFO: renamed from: n */
    private boolean m4746n() {
        return (this.f4227G || this.f4232L) && !m4760c();
    }

    /* JADX INFO: renamed from: b */
    private void m4740b(boolean z) {
        int i = 8;
        if (this.f4227G && m4746n() && hasFocus() && (z || !this.f4232L)) {
            i = 0;
        }
        this.f4248c.setVisibility(i);
    }

    /* JADX INFO: renamed from: o */
    private void m4747o() {
        int i = 8;
        if (m4746n() && (this.f4248c.getVisibility() == 0 || this.f4250e.getVisibility() == 0)) {
            i = 0;
        }
        this.f4257m.setVisibility(i);
    }

    /* JADX INFO: renamed from: p */
    private void m4748p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f4244a.getText());
        if (!z2 && (!this.f4225E || this.f4235O)) {
            z = false;
        }
        this.f4249d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f4249d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m4749q() {
        post(this.f4238R);
    }

    /* JADX INFO: renamed from: d */
    void m4761d() {
        int[] iArr = this.f4244a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f4256l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f4257m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f4238R);
        post(this.f4239S);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: renamed from: a */
    void m4754a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* JADX INFO: renamed from: a */
    boolean m4758a(View view, int i, KeyEvent keyEvent) {
        if (this.f4253h == null || this.f4252g == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return m4757a(this.f4244a.getListSelection(), 0, (String) null);
        }
        if (i == 21 || i == 22) {
            this.f4244a.setSelection(i == 21 ? 0 : this.f4244a.length());
            this.f4244a.setListSelection(0);
            this.f4244a.clearListSelection();
            f4220i.m4770a(this.f4244a, true);
            return true;
        }
        if (i != 19 || this.f4244a.getListSelection() != 0) {
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private CharSequence m4742c(CharSequence charSequence) {
        if (this.f4225E && this.f4265u != null) {
            int textSize = (int) (((double) this.f4244a.getTextSize()) * 1.25d);
            this.f4265u.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.f4265u), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    /* JADX INFO: renamed from: r */
    private void m4750r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f4244a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m4742c(queryHint));
    }

    /* JADX INFO: renamed from: s */
    private void m4751s() {
        this.f4244a.setThreshold(this.f4253h.getSuggestThreshold());
        this.f4244a.setImeOptions(this.f4253h.getImeOptions());
        int inputType = this.f4253h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f4253h.getSuggestAuthority() != null) {
                inputType = inputType | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST | 524288;
            }
        }
        this.f4244a.setInputType(inputType);
        if (this.f4252g != null) {
            this.f4252g.mo2939a((Cursor) null);
        }
        if (this.f4253h.getSuggestAuthority() != null) {
            this.f4252g = new SuggestionsAdapter(getContext(), this, this.f4253h, this.f4240T);
            this.f4244a.setAdapter(this.f4252g);
            ((SuggestionsAdapter) this.f4252g).m4927a(this.f4229I ? 2 : 1);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4743c(boolean z) {
        int i;
        if (this.f4232L && !m4760c() && z) {
            i = 0;
            this.f4248c.setVisibility(8);
        } else {
            i = 8;
        }
        this.f4250e.setVisibility(i);
    }

    /* JADX INFO: renamed from: b */
    void m4759b(CharSequence charSequence) {
        Editable text = this.f4244a.getText();
        this.f4234N = text;
        boolean z = !TextUtils.isEmpty(text);
        m4740b(z);
        m4743c(z ? false : true);
        m4748p();
        m4747o();
        if (this.f4221A != null && !TextUtils.equals(charSequence, this.f4233M)) {
            this.f4221A.m4774b(charSequence.toString());
        }
        this.f4233M = charSequence.toString();
    }

    /* JADX INFO: renamed from: e */
    void m4762e() {
        Editable text = this.f4244a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f4221A == null || !this.f4221A.m4773a(text.toString())) {
                if (this.f4253h != null) {
                    m4753a(0, (String) null, text.toString());
                }
                this.f4244a.setImeVisibility(false);
                m4752t();
            }
        }
    }

    /* JADX INFO: renamed from: t */
    private void m4752t() {
        this.f4244a.dismissDropDown();
    }

    /* JADX INFO: renamed from: f */
    void m4763f() {
        if (TextUtils.isEmpty(this.f4244a.getText())) {
            if (this.f4225E) {
                if (this.f4222B == null || !this.f4222B.m4772a()) {
                    clearFocus();
                    m4737a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f4244a.setText("");
        this.f4244a.requestFocus();
        this.f4244a.setImeVisibility(true);
    }

    /* JADX INFO: renamed from: g */
    void m4764g() {
        m4737a(false);
        this.f4244a.requestFocus();
        this.f4244a.setImeVisibility(true);
        if (this.f4224D != null) {
            this.f4224D.onClick(this);
        }
    }

    /* JADX INFO: renamed from: h */
    void m4765h() {
        if (this.f4253h != null) {
            SearchableInfo searchableInfo = this.f4253h;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m4732a(this.f4268x, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m4739b(this.f4269y, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* JADX INFO: renamed from: i */
    void m4766i() {
        m4737a(m4760c());
        m4749q();
        if (this.f4244a.hasFocus()) {
            m4768l();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m4749q();
    }

    @Override // android.support.v7.view.CollapsibleActionView
    /* JADX INFO: renamed from: b */
    public void mo3474b() {
        m4755a("", false);
        clearFocus();
        m4737a(true);
        this.f4244a.setImeOptions(this.f4236P);
        this.f4235O = false;
    }

    @Override // android.support.v7.view.CollapsibleActionView
    /* JADX INFO: renamed from: a */
    public void mo3473a() {
        if (!this.f4235O) {
            this.f4235O = true;
            this.f4236P = this.f4244a.getImeOptions();
            this.f4244a.setImeOptions(this.f4236P | MediaHttpDownloader.MAXIMUM_CHUNK_SIZE);
            this.f4244a.setText("");
            setIconified(false);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        boolean f4284a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4284a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f4284a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f4284a + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4284a = m4760c();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        m4737a(savedState.f4284a);
        requestLayout();
    }

    /* JADX INFO: renamed from: k */
    void m4767k() {
        int dimensionPixelSize;
        int i;
        if (this.f4258n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f4256l.getPaddingLeft();
            Rect rect = new Rect();
            boolean zM5031a = ViewUtils.m5031a(this);
            if (this.f4225E) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                dimensionPixelSize = 0;
            }
            this.f4244a.getDropDownBackground().getPadding(rect);
            if (zM5031a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f4244a.setDropDownHorizontalOffset(i);
            this.f4244a.setDropDownWidth((dimensionPixelSize + ((this.f4258n.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m4757a(int i, int i2, String str) {
        if (this.f4223C != null && this.f4223C.m4776b(i)) {
            return false;
        }
        m4741b(i, 0, null);
        this.f4244a.setImeVisibility(false);
        m4752t();
        return true;
    }

    /* JADX INFO: renamed from: a */
    boolean m4756a(int i) {
        if (this.f4223C != null && this.f4223C.m4775a(i)) {
            return false;
        }
        m4744e(i);
        return true;
    }

    /* JADX INFO: renamed from: e */
    private void m4744e(int i) {
        Editable text = this.f4244a.getText();
        Cursor cursorMo2935a = this.f4252g.mo2935a();
        if (cursorMo2935a != null) {
            if (cursorMo2935a.moveToPosition(i)) {
                CharSequence charSequenceMo2944c = this.f4252g.mo2944c(cursorMo2935a);
                if (charSequenceMo2944c != null) {
                    setQuery(charSequenceMo2944c);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4741b(int i, int i2, String str) {
        Cursor cursorMo2935a = this.f4252g.mo2935a();
        if (cursorMo2935a == null || !cursorMo2935a.moveToPosition(i)) {
            return false;
        }
        m4735a(m4733a(cursorMo2935a, i2, str));
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m4735a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f4244a.setText(charSequence);
        this.f4244a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* JADX INFO: renamed from: a */
    void m4753a(int i, String str, String str2) {
        getContext().startActivity(m4734a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* JADX INFO: renamed from: a */
    private Intent m4734a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f4234N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f4237Q != null) {
            intent.putExtra("app_data", this.f4237Q);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f4253h.getSearchActivity());
        return intent;
    }

    /* JADX INFO: renamed from: a */
    private Intent m4732a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* JADX INFO: renamed from: b */
    private Intent m4739b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.f4237Q != null) {
            bundle.putParcelable("app_data", this.f4237Q);
        }
        Intent intent3 = new Intent(intent);
        String string = "free_form";
        int voiceMaxResults = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            string = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            voiceMaxResults = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* JADX INFO: renamed from: a */
    private Intent m4733a(Cursor cursor, int i, String str) {
        int position;
        String strM4913a;
        try {
            String strM4913a2 = SuggestionsAdapter.m4913a(cursor, "suggest_intent_action");
            if (strM4913a2 == null) {
                strM4913a2 = this.f4253h.getSuggestIntentAction();
            }
            if (strM4913a2 == null) {
                strM4913a2 = "android.intent.action.SEARCH";
            }
            String strM4913a3 = SuggestionsAdapter.m4913a(cursor, "suggest_intent_data");
            if (strM4913a3 == null) {
                strM4913a3 = this.f4253h.getSuggestIntentData();
            }
            if (strM4913a3 != null && (strM4913a = SuggestionsAdapter.m4913a(cursor, "suggest_intent_data_id")) != null) {
                strM4913a3 = strM4913a3 + "/" + Uri.encode(strM4913a);
            }
            return m4734a(strM4913a2, strM4913a3 == null ? null : Uri.parse(strM4913a3), SuggestionsAdapter.m4913a(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.m4913a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: l */
    void m4768l() {
        f4220i.m4769a(this.f4244a);
        f4220i.m4771b(this.f4244a);
    }

    /* JADX INFO: renamed from: a */
    static boolean m4738a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {

        /* JADX INFO: renamed from: a */
        private final View f4290a;

        /* JADX INFO: renamed from: b */
        private final Rect f4291b;

        /* JADX INFO: renamed from: c */
        private final Rect f4292c;

        /* JADX INFO: renamed from: d */
        private final Rect f4293d;

        /* JADX INFO: renamed from: e */
        private final int f4294e;

        /* JADX INFO: renamed from: f */
        private boolean f4295f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f4294e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f4291b = new Rect();
            this.f4293d = new Rect();
            this.f4292c = new Rect();
            m4785a(rect, rect2);
            this.f4290a = view;
        }

        /* JADX INFO: renamed from: a */
        public void m4785a(Rect rect, Rect rect2) {
            this.f4291b.set(rect);
            this.f4293d.set(rect);
            this.f4293d.inset(-this.f4294e, -this.f4294e);
            this.f4292c.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0013  */
        @Override // android.view.TouchDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                r1 = 1
                r0 = 0
                float r2 = r7.getX()
                int r3 = (int) r2
                float r2 = r7.getY()
                int r4 = (int) r2
                int r2 = r7.getAction()
                switch(r2) {
                    case 0: goto L3c;
                    case 1: goto L48;
                    case 2: goto L48;
                    case 3: goto L56;
                    default: goto L13;
                }
            L13:
                r2 = r0
            L14:
                if (r2 == 0) goto L3b
                if (r1 == 0) goto L5b
                android.graphics.Rect r0 = r6.f4292c
                boolean r0 = r0.contains(r3, r4)
                if (r0 != 0) goto L5b
                android.view.View r0 = r6.f4290a
                int r0 = r0.getWidth()
                int r0 = r0 / 2
                float r0 = (float) r0
                android.view.View r1 = r6.f4290a
                int r1 = r1.getHeight()
                int r1 = r1 / 2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
            L35:
                android.view.View r0 = r6.f4290a
                boolean r0 = r0.dispatchTouchEvent(r7)
            L3b:
                return r0
            L3c:
                android.graphics.Rect r2 = r6.f4291b
                boolean r2 = r2.contains(r3, r4)
                if (r2 == 0) goto L13
                r6.f4295f = r1
                r2 = r1
                goto L14
            L48:
                boolean r2 = r6.f4295f
                if (r2 == 0) goto L14
                android.graphics.Rect r5 = r6.f4293d
                boolean r5 = r5.contains(r3, r4)
                if (r5 != 0) goto L14
                r1 = r0
                goto L14
            L56:
                boolean r2 = r6.f4295f
                r6.f4295f = r0
                goto L14
            L5b:
                android.graphics.Rect r0 = r6.f4292c
                int r0 = r0.left
                int r0 = r3 - r0
                float r0 = (float) r0
                android.graphics.Rect r1 = r6.f4292c
                int r1 = r1.top
                int r1 = r4 - r1
                float r1 = (float) r1
                r7.setLocation(r0, r1)
                goto L35
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: a */
        final Runnable f4285a;

        /* JADX INFO: renamed from: b */
        private int f4286b;

        /* JADX INFO: renamed from: c */
        private SearchView f4287c;

        /* JADX INFO: renamed from: d */
        private boolean f4288d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f4285a = new Runnable() { // from class: android.support.v7.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.m4783b();
                }
            };
            this.f4286b = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f4287c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f4286b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public boolean m4781a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f4287c.hasFocus() && getVisibility() == 0) {
                this.f4288d = true;
                if (SearchView.m4738a(getContext())) {
                    SearchView.f4220i.m4770a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f4287c.m4766i();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f4286b <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f4287c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i >= 600 || (i >= 640 && i2 >= 480)) {
                return 192;
            }
            return 160;
        }

        @Override // android.support.v7.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f4288d) {
                removeCallbacks(this.f4285a);
                post(this.f4285a);
            }
            return inputConnectionOnCreateInputConnection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public void m4783b() {
            if (this.f4288d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f4288d = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f4288d = false;
                removeCallbacks(this.f4285a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f4288d = false;
                    removeCallbacks(this.f4285a);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f4288d = true;
            }
        }
    }

    private static class AutoCompleteTextViewReflector {

        /* JADX INFO: renamed from: a */
        private Method f4281a;

        /* JADX INFO: renamed from: b */
        private Method f4282b;

        /* JADX INFO: renamed from: c */
        private Method f4283c;

        AutoCompleteTextViewReflector() {
            try {
                this.f4281a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f4281a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f4282b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f4282b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f4283c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f4283c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
        }

        /* JADX INFO: renamed from: a */
        void m4769a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f4281a != null) {
                try {
                    this.f4281a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4771b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f4282b != null) {
                try {
                    this.f4282b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4770a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f4283c != null) {
                try {
                    this.f4283c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception e) {
                }
            }
        }
    }
}
