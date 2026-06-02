package com.jibo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.gms.common.GoogleApiAvailability;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.service.DeviceRegistrationService;
import com.jibo.service.SyncHelper;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;
import com.jibo.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseFragment extends Fragment implements IBaseFragment, DialogUtils.DialogFragmentWrapperClickListener {
   public static final String f = BaseFragment.class.getSimpleName();
   Unbinder g;
   protected Handler h;
   protected List<AbstractJiboAsyncClient> i = new ArrayList<>();
   protected CircleProgressFragment j = null;
   protected Loop k;

   public BaseFragment() {
      this.h = new Handler(Looper.getMainLooper());
   }

   private void a(float var1) {
      if (((AppCompatActivity)this.getActivity()).getSupportActionBar() != null) {
         ((AppCompatActivity)this.getActivity()).getSupportActionBar().setElevation(var1);
      }

      if (((BaseActivity)this.getActivity()).o() != null && VERSION.SDK_INT >= 21) {
         ((BaseActivity)this.getActivity()).o().setElevation(var1);
      }
   }

   private boolean a() {
      GoogleApiAvailability var3 = GoogleApiAvailability.a();
      int var1 = var3.a(this.getActivity());
      boolean var2;
      if (var1 != 0) {
         if (var3.a(var1)) {
            var3.a(this.getActivity(), var1, 9000).show();
         }

         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      if (100 == var1) {
         this.getActivity().setResult(BaseActivity.d);
         this.getActivity().finish();
      }
   }

   protected void a(ActionBar var1) {
      var1.setTitle(this.o());
   }

   public void a(EditText var1) {
      try {
         if (this.d()) {
            ((InputMethodManager)this.getActivity().getSystemService("input_method")).showSoftInput(var1, 1);
         }
      } catch (Exception var2) {
         LogUtils.a(f, "showSoftwareKeyboard", var2);
      }
   }

   public void a(AbstractJiboAsyncClient var1) {
      Iterator var2 = this.i.iterator();

      do {
         if (!var2.hasNext()) {
            this.i.add(var1);
            break;
         }
      } while ((AbstractJiboAsyncClient)var2.next() != var1);
   }

   public void a(Runnable var1) {
      if (this.d()) {
         this.getActivity().runOnUiThread(var1);
      }
   }

   protected void a(Throwable var1, String var2, boolean var3) {
      this.a(new Runnable(this, var1, var3) {
         final Throwable a;
         final boolean b;
         final BaseFragment c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public void run() {
            this.c.g();
            if (!ErrorHelper.a(null, this.c, this.a) && this.b) {
               UIUtils.a(this.c.getView(), this.a);
            }
         }
      });
   }

   public void a(boolean var1) {
      if (this.d()) {
         ((BaseActivity)this.getActivity()).a(var1);
      }
   }

   public void b(Bundle var1) {
      if (var1.containsKey(Loop.class.getSimpleName())) {
         this.k = (Loop)var1.getParcelable(Loop.class.getSimpleName());
      }

      if (var1.getBoolean("ARGS_SKILL_FRAGMENT", false) && !SkillsJsonParser.isCreated()) {
         if (this.getActivity().getSupportFragmentManager().e() <= 1) {
            this.getActivity().finish();
         } else {
            this.getActivity().getSupportFragmentManager().c();
         }
      }
   }

   public Handler c() {
      return this.h;
   }

   public boolean d() {
      boolean var1;
      if (this.getActivity() != null
         && this.getActivity() instanceof BaseActivity
         && !this.getActivity().isFinishing()
         && !this.isDetached()
         && !this.isRemoving()
         && this.isResumed()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void e() {
      try {
         if (this.d() && this.getActivity().getWindow().getCurrentFocus() != null) {
            ((InputMethodManager)this.getActivity().getSystemService("input_method"))
               .hideSoftInputFromWindow(this.getActivity().getWindow().getCurrentFocus().getWindowToken(), 0);
         }
      } catch (Exception var2) {
         LogUtils.a(f, "hideSoftwareKeyboard", var2);
      }
   }

   public void f() {
      if (this.d()) {
         ((BaseActivity)this.getActivity()).k();
      }
   }

   public void g() {
      if (this.d()) {
         ((BaseActivity)this.getActivity()).l();
      }
   }

   @Override
   public boolean h() {
      return false;
   }

   protected void i() {
      if (this.a() && TextUtils.isEmpty(this.getActivity().getSharedPreferences(this.getString(2131755063), 0).getString("PREF_PUSH_SERVICE_TOKEN", null))) {
         Intent var1 = new Intent(this.getActivity(), DeviceRegistrationService.class);
         ServiceUtils.a(this.getActivity(), var1);
      }
   }

   protected void j() {
      if (this.d()) {
         KeyManager.getInstance(this.getActivity(), EntityData.a(this.getActivity()).i().getId());
         Object var2 = null;

         List var1;
         try {
            var1 = EntityData.a(this.getActivity()).a(true);
         } catch (Exception var3) {
            this.a(var3, "list loops", false);
            if (var3 instanceof UnauthorizedRequestException) {
               this.a(new Runnable(this, var3) {
                  final Exception a;
                  final BaseFragment b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     if (((UnauthorizedRequestException)this.a).getErrorMessage().contains("Clock skew")) {
                        Toast.makeText(this.b.getActivity(), 2131755301, 0).show();
                     }

                     OnBoardingActivity.a(this.b.getActivity(), OnBoardingActivity.j, false);
                  }
               });
               return;
            }

            var1 = (List)var2;
            if (this.d()) {
               SyncHelper.b(this.getActivity());
               var1 = (List)var2;
            }
         }

         this.a(new Runnable(this, var1) {
            final List a;
            final BaseFragment b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               ((OnBoardingActivity)this.b.getActivity()).l();
               ((OnBoardingActivity)this.b.getActivity()).a(this.a, this.b);
            }
         });
      }
   }

   protected void k() {
      if (((AppCompatActivity)this.getActivity()).getSupportActionBar() != null) {
         ((AppCompatActivity)this.getActivity()).getSupportActionBar().hide();
      }
   }

   protected void l() {
      if (((AppCompatActivity)this.getActivity()).getSupportActionBar() != null) {
         ((AppCompatActivity)this.getActivity()).getSupportActionBar().show();
      }
   }

   protected void m() {
      this.a(0.0F);
   }

   protected void n() {
      this.a(this.getResources().getDimension(2131165259));
   }

   protected abstract String o();

   @Override
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      if (this.getActivity() != null && this.getActivity() instanceof BaseActivity) {
         ((BaseActivity)this.getActivity()).l();
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.b(var1);
      } else if (this.getArguments() != null) {
         this.b(this.getArguments());
      }

      this.l();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.g.unbind();
      this.c().removeCallbacksAndMessages(null);

      for (AbstractJiboAsyncClient var2 : this.i) {
         if (var2 != null) {
            try {
               var2.shutdown();
            } catch (Exception var3) {
            }
         }
      }
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.getActivity() != null && ((AppCompatActivity)this.getActivity()).getSupportActionBar() != null) {
         this.a(((AppCompatActivity)this.getActivity()).getSupportActionBar());
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.k != null) {
         var1.putParcelable(Loop.class.getSimpleName(), this.k);
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.g = ButterKnife.a(this, var1);
   }

   protected TabbedActivity p() {
      return (TabbedActivity)this.getActivity();
   }
}
