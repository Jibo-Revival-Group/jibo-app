package android.support.v4.app;

import android.arch.lifecycle.ViewModelStore;
import java.util.List;

public class FragmentManagerNonConfig {
   private final List<Fragment> a;
   private final List<FragmentManagerNonConfig> b;
   private final List<ViewModelStore> c;

   FragmentManagerNonConfig(List<Fragment> var1, List<FragmentManagerNonConfig> var2, List<ViewModelStore> var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   List<Fragment> a() {
      return this.a;
   }

   List<FragmentManagerNonConfig> b() {
      return this.b;
   }

   List<ViewModelStore> c() {
      return this.c;
   }
}
