package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.util.AttributeSet;
import android.view.View;

abstract class BaseFragmentActivityApi14 extends SupportActivity {
   boolean mStartedIntentSenderFromFragment;

   static void checkForValidRequestCode(int var0) {
      if ((-65536 & var0) != 0) {
         throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      }
   }

   abstract View dispatchFragmentsOnCreateView(View var1, String var2, Context var3, AttributeSet var4);

   public View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      View var6 = this.dispatchFragmentsOnCreateView(var1, var2, var3, var4);
      View var5 = var6;
      if (var6 == null) {
         var5 = super.onCreateView(var1, var2, var3, var4);
      }

      return var5;
   }

   public View onCreateView(String var1, Context var2, AttributeSet var3) {
      View var5 = this.dispatchFragmentsOnCreateView(null, var1, var2, var3);
      View var4 = var5;
      if (var5 == null) {
         var4 = super.onCreateView(var1, var2, var3);
      }

      return var4;
   }

   public void startIntentSenderForResult(IntentSender var1, int var2, Intent var3, int var4, int var5, int var6) throws SendIntentException {
      if (!this.mStartedIntentSenderFromFragment && var2 != -1) {
         checkForValidRequestCode(var2);
      }

      super.startIntentSenderForResult(var1, var2, var3, var4, var5, var6);
   }
}
