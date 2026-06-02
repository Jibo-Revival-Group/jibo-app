package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class ReportFragment extends Fragment {
   private ReportFragment.ActivityInitializationListener a;

   public static void a(Activity var0) {
      FragmentManager var1 = var0.getFragmentManager();
      if (var1.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
         var1.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
         var1.executePendingTransactions();
      }
   }

   private void a(Lifecycle.Event var1) {
      Activity var2 = this.getActivity();
      if (var2 instanceof LifecycleRegistryOwner) {
         ((LifecycleRegistryOwner)var2).a().a(var1);
      } else if (var2 instanceof LifecycleOwner) {
         Lifecycle var3 = ((LifecycleOwner)var2).getLifecycle();
         if (var3 instanceof LifecycleRegistry) {
            ((LifecycleRegistry)var3).a(var1);
         }
      }
   }

   private void a(ReportFragment.ActivityInitializationListener var1) {
      if (var1 != null) {
         var1.a();
      }
   }

   private void b(ReportFragment.ActivityInitializationListener var1) {
      if (var1 != null) {
         var1.b();
      }
   }

   private void c(ReportFragment.ActivityInitializationListener var1) {
      if (var1 != null) {
         var1.c();
      }
   }

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      this.a(this.a);
      this.a(Lifecycle.Event.ON_CREATE);
   }

   public void onDestroy() {
      super.onDestroy();
      this.a(Lifecycle.Event.ON_DESTROY);
      this.a = null;
   }

   public void onPause() {
      super.onPause();
      this.a(Lifecycle.Event.ON_PAUSE);
   }

   public void onResume() {
      super.onResume();
      this.c(this.a);
      this.a(Lifecycle.Event.ON_RESUME);
   }

   public void onStart() {
      super.onStart();
      this.b(this.a);
      this.a(Lifecycle.Event.ON_START);
   }

   public void onStop() {
      super.onStop();
      this.a(Lifecycle.Event.ON_STOP);
   }

   interface ActivityInitializationListener {
      void a();

      void b();

      void c();
   }
}
