package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
   public AutoTransition() {
      this.q();
   }

   public AutoTransition(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.q();
   }

   private void q() {
      this.a(1);
      this.b(new Fade(2)).b(new ChangeBounds()).b(new Fade(1));
   }
}
