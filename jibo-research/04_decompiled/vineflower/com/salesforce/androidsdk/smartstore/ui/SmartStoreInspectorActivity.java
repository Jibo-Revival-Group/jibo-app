package com.salesforce.androidsdk.smartstore.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.MultiAutoCompleteTextView;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.smartstore.R;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SmartStoreInspectorActivity extends Activity {
   private String a;
   private boolean b;
   private SmartStore c;
   private MultiAutoCompleteTextView d;
   private EditText e;
   private EditText f;
   private GridView g;
   private String h;
   private String i;
   private JSONArray j;

   private int a(EditText var1, int var2) {
      String var3 = var1.getText().toString();
      if (var3.length() != 0) {
         var2 = Integer.parseInt(var3);
      }

      return var2;
   }

   private void a(GridView var1) {
      GridLayoutAnimationController var2 = new GridLayoutAnimationController(AnimationUtils.loadAnimation(this, 17432576), 0.0F, 0.1F);
      var1.setLayoutAnimation(var2);
      var2.start();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(MultiAutoCompleteTextView var1) {
      ArrayAdapter var3 = new ArrayAdapter(this, 17367050);
      LinkedList var4 = new LinkedList();
      var4.addAll(this.c.d());

      for (String var5 : var4) {
         var3.add("{" + var5 + "}");
         var3.add("{" + var5 + ":" + "_soup" + "}");
         var3.add("{" + var5 + ":" + "_soupEntryId" + "}");
         var3.add("{" + var5 + ":" + "_soupLastModifiedDate" + "}");
      }

      label36: {
         try {
            var10 = this.c.a(QuerySpec.a("SELECT soupName, path FROM soup_index_map", 1000), 0);
         } catch (JSONException var8) {
            SmartStoreLogger.a("SmartStoreInspectorActivity", "Error occurred while parsing JSON", var8);
            break label36;
         }

         int var2 = 0;

         while (true) {
            try {
               if (var2 >= var10.length()) {
                  break;
               }

               JSONArray var11 = var10.getJSONArray(var2);
               StringBuilder var6 = new StringBuilder();
               var3.add(var6.append("{").append(var11.getString(0)).append(":").append(var11.getString(1)).append("}").toString());
            } catch (JSONException var7) {
               SmartStoreLogger.a("SmartStoreInspectorActivity", "Error occurred while parsing JSON", var7);
               break;
            }

            var2++;
         }
      }

      var3.add("select");
      var3.add("from");
      var3.add("where");
      var3.add("order by");
      var3.add("asc");
      var3.add("desc");
      var3.add("group by");
      var1.setAdapter(var3);
      var1.setTokenizer(new QueryTokenizer());
   }

   private void a(String var1, String var2) {
      this.h = var1;
      this.i = var2;
      new Builder(this).setTitle(var1).setMessage(var2).show();
   }

   private void a(JSONArray var1) throws JSONException {
      byte var4 = 0;
      this.j = var1;
      ArrayAdapter var6 = new ArrayAdapter(this, R.layout.sf__inspector_result_cell);
      if (var1.length() == 0) {
         this.a(null, this.getString(R.string.sf__inspector_no_rows_returned));
      }

      for (int var2 = 0; var2 < var1.length(); var2++) {
         JSONArray var7 = var1.getJSONArray(var2);

         for (int var3 = 0; var3 < var7.length(); var3++) {
            Object var5 = var7.get(var3);
            String var9;
            if (var5 instanceof JSONObject) {
               var9 = ((JSONObject)var5).toString(2);
            } else {
               var9 = var5.toString();
            }

            var6.add(var9);
         }
      }

      int var8 = var4;
      if (var1.length() > 0) {
         var8 = var1.getJSONArray(0).length();
      }

      this.g.setNumColumns(var8);
      this.g.setAdapter(var6);
      this.a(this.g);
   }

   private void b() {
      boolean var1 = false;
      Bundle var2 = this.getIntent().getExtras();
      if (var2 != null) {
         var1 = var2.getBoolean("isGlobalStore", false);
      }

      this.b = var1;
      String var3;
      if (var2 == null) {
         var3 = "smartstore";
      } else {
         var3 = var2.getString("dbName", "smartstore");
      }

      this.a = var3;
   }

   private void c() {
      try {
         String var3 = this.d.getText().toString();
         if (var3.length() == 0) {
            this.a(null, this.getString(R.string.sf__inspector_no_query_specified));
         } else {
            int var2 = this.a(this.e, 10);
            int var1 = this.a(this.f, 0);
            QuerySpec var5 = QuerySpec.a(var3, var2);
            this.a(this.c.a(var5, var1));
         }
      } catch (Exception var4) {
         this.a(var4.getClass().getSimpleName(), var4.getMessage());
      }
   }

   public void a() {
      this.d.setText("");
      this.e.setText("");
      this.f.setText("");
      this.g.setAdapter(null);
      this.h = null;
      this.i = null;
      this.j = null;
   }

   public void onClearClick(View var1) {
      this.a();
   }

   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity");
      super.onCreate(var1);
      this.b();
      this.setContentView(R.layout.sf__inspector);
      this.d = (MultiAutoCompleteTextView)this.findViewById(R.id.sf__inspector_query_text);
      this.e = (EditText)this.findViewById(R.id.sf__inspector_pagesize_text);
      this.f = (EditText)this.findViewById(R.id.sf__inspector_pageindex_text);
      this.g = (GridView)this.findViewById(R.id.sf__inspector_result_grid);
   }

   public void onIndicesClick(View var1) {
      this.d.setText(this.getString(R.string.sf__inspector_indices_query));
      this.c();
   }

   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity");
      super.onResume();
      SmartStoreSDKManager var1 = SmartStoreSDKManager.H();
      SmartStore var2;
      if (this.b) {
         var2 = var1.g(this.a);
      } else {
         var2 = var1.a(this.a, var1.o().b(), null);
      }

      this.c = var2;
      this.a(this.d);
   }

   public void onRunClick(View var1) {
      this.c();
   }

   public void onSoupsClick(View var1) {
      List var3 = this.c.d();
      if (var3.size() > 10) {
         this.d.setText(this.getString(R.string.sf__inspector_soups_query));
      } else {
         StringBuilder var5 = new StringBuilder();
         Iterator var6 = var3.iterator();

         for (boolean var2 = true; var6.hasNext(); var2 = false) {
            String var4 = (String)var6.next();
            if (!var2) {
               var5.append(" union ");
            }

            var5.append("select '");
            var5.append(var4);
            var5.append("', count(*) from {");
            var5.append(var4);
            var5.append("}");
         }

         this.d.setText(var5.toString());
      }

      this.c();
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity");
      super.onStart();
   }
}
