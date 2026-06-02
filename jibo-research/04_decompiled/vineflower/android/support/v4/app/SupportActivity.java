package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;

public class SupportActivity extends Activity implements LifecycleOwner {
   private SimpleArrayMap<Class<? extends SupportActivity.ExtraData>, SupportActivity.ExtraData> mExtraDataMap = new SimpleArrayMap<>();
   private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

   public <T extends SupportActivity.ExtraData> T getExtraData(Class<T> var1) {
      return (T)this.mExtraDataMap.get(var1);
   }

   @Override
   public Lifecycle getLifecycle() {
      return this.mLifecycleRegistry;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ReportFragment.a(this);
   }

   protected void onSaveInstanceState(Bundle var1) {
      this.mLifecycleRegistry.a(Lifecycle.State.CREATED);
      super.onSaveInstanceState(var1);
   }

   public void putExtraData(SupportActivity.ExtraData var1) {
      this.mExtraDataMap.put((Class<? extends SupportActivity.ExtraData>)var1.getClass(), var1);
   }

   public static class ExtraData {
   }
}
