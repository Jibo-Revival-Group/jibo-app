package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

public class ViewModelStore {
   private final HashMap<String, ViewModel> a = new HashMap<>();

   final ViewModel a(String var1) {
      return this.a.get(var1);
   }

   public final void a() {
      Iterator var1 = this.a.values().iterator();

      while (var1.hasNext()) {
         ((ViewModel)var1.next()).a();
      }

      this.a.clear();
   }

   final void a(String var1, ViewModel var2) {
      ViewModel var3 = this.a.get(var1);
      if (var3 != null) {
         var3.a();
      }

      this.a.put(var1, var2);
   }
}
