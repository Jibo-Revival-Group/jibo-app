package com.jibo.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.utils.LogUtils;
import java.io.Serializable;

public class SingleFragmentActivity extends BaseActivity {
   public static final String h = LogUtils.a(SingleFragmentActivity.class);
   public static final String i = SingleFragmentActivity.class.getName() + ".FRAGMENT_CLASS";
   private Intent j;

   @Override
   public void e() {
      if (this.getCallingActivity() == null) {
         this.d();
      } else {
         super.e();
      }
   }

   public void finish() {
      if (this.j != null) {
         this.setResult(-1, this.j);
      }

      super.finish();
   }

   @Override
   public void onBackPressed() {
      if (this.j != null) {
         this.setResult(-1, this.j);
      }

      super.onBackPressed();
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.SingleFragmentActivity");
      if (this.getIntent().getIntExtra(b, -1) == -1) {
         this.getIntent().putExtra(b, 2131427358);
      }

      super.onCreate(var1);
      if (var1 == null) {
         this.r();
      }
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.SingleFragmentActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.SingleFragmentActivity");
      super.onStart();
   }

   public Intent q() {
      synchronized (this) {
         if (this.j == null) {
            Intent var1 = new Intent();
            this.j = var1;
         }

         return this.j;
      }
   }

   public void r() {
      Fragment var1 = Fragment.instantiate(this, this.getIntent().getStringExtra(i), this.getIntent().getExtras());
      this.getSupportFragmentManager().a().b(2131296575, var1).a(LogUtils.a(var1.getClass().getSimpleName())).d();
   }

   public static class Builder {
      private Context a;
      private Fragment b;
      private Intent c;

      public Builder(Context var1, String var2) {
         this.a = var1;
         this.c = new Intent(var1, SingleFragmentActivity.class);
         this.c.putExtra(SingleFragmentActivity.i, var2);
      }

      public Builder(Fragment var1, String var2) {
         this(var1.getActivity(), var2);
         this.b = var1;
      }

      public Intent a() {
         return this.c;
      }

      public SingleFragmentActivity.Builder a(String var1, int var2) {
         this.c.putExtra(var1, var2);
         return this;
      }

      public SingleFragmentActivity.Builder a(String var1, Parcelable var2) {
         this.c.putExtra(var1, var2);
         return this;
      }

      public SingleFragmentActivity.Builder a(String var1, Serializable var2) {
         this.c.putExtra(var1, var2);
         return this;
      }

      public SingleFragmentActivity.Builder a(String var1, boolean var2) {
         this.c.putExtra(var1, var2);
         return this;
      }

      public void a(int var1) {
         if (TextUtils.isEmpty(this.c.getStringExtra(SingleFragmentActivity.i))) {
            LogUtils.d(SingleFragmentActivity.h, SingleFragmentActivity.i + " must be supplied in Extras!");
         } else if (var1 == -1) {
            LogUtils.a(SingleFragmentActivity.h, "Request code must be supplied!");
         } else if (this.a == null && this.b == null) {
            LogUtils.a(SingleFragmentActivity.h, "Neither context OR fragment must be supplied!");
         } else {
            if (this.b != null) {
               this.b.startActivityForResult(this.c, var1);
            } else if (this.a != null && this.a instanceof Activity) {
               ((Activity)this.a).startActivityForResult(this.c, var1);
            }

            this.b = null;
            this.a = null;
            this.c = null;
         }
      }
   }
}
