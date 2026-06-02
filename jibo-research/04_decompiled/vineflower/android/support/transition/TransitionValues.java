package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
   public final Map<String, Object> a = new HashMap<>();
   public View b;
   final ArrayList<Transition> c = new ArrayList<>();

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof TransitionValues && this.b == ((TransitionValues)var1).b && this.a.equals(((TransitionValues)var1).a)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.b.hashCode() * 31 + this.a.hashCode();
   }

   @Override
   public String toString() {
      String var1 = "TransitionValues@" + Integer.toHexString(this.hashCode()) + ":\n";
      var1 = var1 + "    view = " + this.b + "\n";
      var1 = var1 + "    values:";

      for (String var3 : this.a.keySet()) {
         var1 = var1 + "    " + var3 + ": " + this.a.get(var3) + "\n";
      }

      return var1;
   }
}
