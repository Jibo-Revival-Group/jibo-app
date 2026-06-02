package android.support.customtabs;

import android.content.ComponentName;
import android.os.IBinder;

public final class CustomTabsSession {
   private final ICustomTabsCallback a;
   private final ComponentName b;

   IBinder a() {
      return this.a.asBinder();
   }

   ComponentName b() {
      return this.b;
   }
}
