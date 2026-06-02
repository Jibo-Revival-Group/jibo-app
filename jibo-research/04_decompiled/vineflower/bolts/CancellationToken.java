package bolts;

import java.util.Locale;

public class CancellationToken {
   private final CancellationTokenSource a;

   public boolean a() {
      return this.a.a();
   }

   @Override
   public String toString() {
      return String.format(
         Locale.US, "%s@%s[cancellationRequested=%s]", this.getClass().getName(), Integer.toHexString(this.hashCode()), Boolean.toString(this.a.a())
      );
   }
}
