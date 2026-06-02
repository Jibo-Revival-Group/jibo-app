package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
   private final AppCompatSeekBarHelper a = new AppCompatSeekBarHelper(this);

   public AppCompatSeekBar(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.seekBarStyle);
   }

   public AppCompatSeekBar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a.a(var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.a.c();
   }

   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      this.a.b();
   }

   protected void onDraw(Canvas var1) {
      synchronized (this) {
         super.onDraw(var1);
         this.a.a(var1);
      }
   }
}
