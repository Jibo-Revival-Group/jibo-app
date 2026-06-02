package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class AppLink {
   private Uri a;
   private List<AppLink.Target> b;
   private Uri c;

   public AppLink(Uri var1, List<AppLink.Target> var2, Uri var3) {
      this.a = var1;
      List var4 = var2;
      if (var2 == null) {
         var4 = Collections.emptyList();
      }

      this.b = var4;
      this.c = var3;
   }

   public static class Target {
      private final Uri a;
      private final String b;
      private final String c;
      private final String d;

      public Target(String var1, String var2, Uri var3, String var4) {
         this.b = var1;
         this.c = var2;
         this.a = var3;
         this.d = var4;
      }
   }
}
