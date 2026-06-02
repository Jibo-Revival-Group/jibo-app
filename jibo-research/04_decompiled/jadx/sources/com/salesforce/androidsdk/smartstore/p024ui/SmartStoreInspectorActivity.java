package com.salesforce.androidsdk.smartstore.p024ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.MultiAutoCompleteTextView;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.smartstore.R;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SmartStoreInspectorActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private String f14341a;

    /* JADX INFO: renamed from: b */
    private boolean f14342b;

    /* JADX INFO: renamed from: c */
    private SmartStore f14343c;

    /* JADX INFO: renamed from: d */
    private MultiAutoCompleteTextView f14344d;

    /* JADX INFO: renamed from: e */
    private EditText f14345e;

    /* JADX INFO: renamed from: f */
    private EditText f14346f;

    /* JADX INFO: renamed from: g */
    private GridView f14347g;

    /* JADX INFO: renamed from: h */
    private String f14348h;

    /* JADX INFO: renamed from: i */
    private String f14349i;

    /* JADX INFO: renamed from: j */
    private JSONArray f14350j;

    @Override // android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity");
        super.onCreate(bundle);
        m14820b();
        setContentView(R.layout.sf__inspector);
        this.f14344d = (MultiAutoCompleteTextView) findViewById(R.id.sf__inspector_query_text);
        this.f14345e = (EditText) findViewById(R.id.sf__inspector_pagesize_text);
        this.f14346f = (EditText) findViewById(R.id.sf__inspector_pageindex_text);
        this.f14347g = (GridView) findViewById(R.id.sf__inspector_result_grid);
    }

    @Override // android.app.Activity
    protected void onResume() {
        SmartStore smartStoreM14666a;
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity");
        super.onResume();
        SmartStoreSDKManager smartStoreSDKManagerM14661H = SmartStoreSDKManager.m14661H();
        if (this.f14342b) {
            smartStoreM14666a = smartStoreSDKManagerM14661H.m14671g(this.f14341a);
        } else {
            smartStoreM14666a = smartStoreSDKManagerM14661H.m14666a(this.f14341a, smartStoreSDKManagerM14661H.m14450o().m14275b(), (String) null);
        }
        this.f14343c = smartStoreM14666a;
        m14817a(this.f14344d);
    }

    /* JADX INFO: renamed from: b */
    private void m14820b() {
        Bundle extras = getIntent().getExtras();
        this.f14342b = extras != null ? extras.getBoolean("isGlobalStore", false) : false;
        this.f14341a = extras == null ? "smartstore" : extras.getString("dbName", "smartstore");
    }

    public void onClearClick(View view) {
        m14822a();
    }

    /* JADX INFO: renamed from: a */
    public void m14822a() {
        this.f14344d.setText("");
        this.f14345e.setText("");
        this.f14346f.setText("");
        this.f14347g.setAdapter((ListAdapter) null);
        this.f14348h = null;
        this.f14349i = null;
        this.f14350j = null;
    }

    public void onRunClick(View view) {
        m14821c();
    }

    public void onSoupsClick(View view) {
        List<String> listM14803d = this.f14343c.m14803d();
        if (listM14803d.size() > 10) {
            this.f14344d.setText(getString(R.string.sf__inspector_soups_query));
        } else {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            Iterator<String> it = listM14803d.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!z2) {
                    sb.append(" union ");
                }
                sb.append("select '");
                sb.append(next);
                sb.append("', count(*) from {");
                sb.append(next);
                sb.append("}");
                z = false;
            }
            this.f14344d.setText(sb.toString());
        }
        m14821c();
    }

    public void onIndicesClick(View view) {
        this.f14344d.setText(getString(R.string.sf__inspector_indices_query));
        m14821c();
    }

    /* JADX INFO: renamed from: c */
    private void m14821c() {
        try {
            String string = this.f14344d.getText().toString();
            if (string.length() == 0) {
                m14818a((String) null, getString(R.string.sf__inspector_no_query_specified));
            } else {
                int iM14815a = m14815a(this.f14345e, 10);
                int iM14815a2 = m14815a(this.f14346f, 0);
                m14819a(this.f14343c.m14786a(QuerySpec.m14744a(string, iM14815a), iM14815a2));
            }
        } catch (Exception e) {
            m14818a(e.getClass().getSimpleName(), e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    private int m14815a(EditText editText, int i) {
        String string = editText.getText().toString();
        return string.length() == 0 ? i : Integer.parseInt(string);
    }

    /* JADX INFO: renamed from: a */
    private void m14818a(String str, String str2) {
        this.f14348h = str;
        this.f14349i = str2;
        new AlertDialog.Builder(this).setTitle(str).setMessage(str2).show();
    }

    /* JADX INFO: renamed from: a */
    private void m14819a(JSONArray jSONArray) throws JSONException {
        this.f14350j = jSONArray;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.sf__inspector_result_cell);
        if (jSONArray.length() == 0) {
            m14818a((String) null, getString(R.string.sf__inspector_no_rows_returned));
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                Object obj = jSONArray2.get(i2);
                arrayAdapter.add(obj instanceof JSONObject ? ((JSONObject) obj).toString(2) : obj.toString());
            }
        }
        this.f14347g.setNumColumns(jSONArray.length() > 0 ? jSONArray.getJSONArray(0).length() : 0);
        this.f14347g.setAdapter((ListAdapter) arrayAdapter);
        m14816a(this.f14347g);
    }

    /* JADX INFO: renamed from: a */
    private void m14816a(GridView gridView) {
        GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(AnimationUtils.loadAnimation(this, android.R.anim.fade_in), CropImageView.DEFAULT_ASPECT_RATIO, 0.1f);
        gridView.setLayoutAnimation(gridLayoutAnimationController);
        gridLayoutAnimationController.start();
    }

    /* JADX INFO: renamed from: a */
    private void m14817a(MultiAutoCompleteTextView multiAutoCompleteTextView) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line);
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(this.f14343c.m14803d());
        for (String str : linkedList) {
            arrayAdapter.add("{" + str + "}");
            arrayAdapter.add("{" + str + ":_soup}");
            arrayAdapter.add("{" + str + ":_soupEntryId}");
            arrayAdapter.add("{" + str + ":_soupLastModifiedDate}");
        }
        try {
            JSONArray jSONArrayM14786a = this.f14343c.m14786a(QuerySpec.m14744a("SELECT soupName, path FROM soup_index_map", 1000), 0);
            for (int i = 0; i < jSONArrayM14786a.length(); i++) {
                JSONArray jSONArray = jSONArrayM14786a.getJSONArray(i);
                arrayAdapter.add("{" + jSONArray.getString(0) + ":" + jSONArray.getString(1) + "}");
            }
        } catch (JSONException e) {
            SmartStoreLogger.m14825a("SmartStoreInspectorActivity", "Error occurred while parsing JSON", e);
        }
        arrayAdapter.add("select");
        arrayAdapter.add("from");
        arrayAdapter.add("where");
        arrayAdapter.add("order by");
        arrayAdapter.add("asc");
        arrayAdapter.add("desc");
        arrayAdapter.add("group by");
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(new QueryTokenizer());
    }
}
