package android.support.v7.widget;

import android.content.Context;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
   private static final int[] a = new int[]{16843016};
   private final AppCompatTextHelper b = AppCompatTextHelper.a(this);

   public AppCompatCheckedTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 16843720);
   }

   public AppCompatCheckedTextView(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.a(var1), var2, var3);
      this.b.a(var2, var3);
      this.b.a();
      TintTypedArray var4 = TintTypedArray.a(this.getContext(), var2, a, var3, 0);
      this.setCheckMarkDrawable(var4.a(0));
      var4.a();
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.b != null) {
         this.b.a();
      }
   }

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      return AppCompatHintHelper.a(super.onCreateInputConnection(var1), var1, this);
   }

   public void setCheckMarkDrawable(int var1) {
      this.setCheckMarkDrawable(AppCompatResources.b(this.getContext(), var1));
   }

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      if (this.b != null) {
         this.b.a(var1, var2);
      }
   }
}
