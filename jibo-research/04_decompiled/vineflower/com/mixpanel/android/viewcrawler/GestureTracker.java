package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class GestureTracker {
   public GestureTracker(MixpanelAPI var1, Activity var2) {
      this.a(var1, var2);
   }

   private OnTouchListener a(MixpanelAPI var1) {
      return new OnTouchListener(this, var1) {
         final MixpanelAPI a;
         final GestureTracker b;
         private long c;
         private long d;
         private int e;
         private long f;
         private boolean g;
         private final int h;
         private final int i;
         private final int j;

         {
            this.b = var1;
            this.a = var2;
            this.c = -1L;
            this.d = -1L;
            this.e = 0;
            this.f = -1L;
            this.g = false;
            this.h = 100;
            this.i = 1000;
            this.j = 2500;
         }

         private void a() {
            this.d = -1L;
            this.c = -1L;
            this.e = 0;
            this.f = -1L;
            this.g = false;
         }

         public boolean onTouch(View var1, MotionEvent var2) {
            if (var2.getPointerCount() > 2) {
               this.a();
            } else {
               switch (var2.getActionMasked()) {
                  case 0:
                     this.d = System.currentTimeMillis();
                     break;
                  case 1:
                     if (System.currentTimeMillis() - this.d < 100L) {
                        if (System.currentTimeMillis() - this.c >= 2500L) {
                           if (this.e == 3) {
                              this.a.b("$ab_gesture1");
                              this.a();
                           }

                           this.e = 0;
                        } else {
                           this.f = System.currentTimeMillis();
                           if (this.e < 4) {
                              this.e++;
                           } else if (this.e == 4) {
                              this.a.b("$ab_gesture2");
                              this.a();
                           } else {
                              this.a();
                           }
                        }
                     }
                  case 2:
                  case 3:
                  case 4:
                  default:
                     break;
                  case 5:
                     if (System.currentTimeMillis() - this.d < 100L) {
                        if (System.currentTimeMillis() - this.f > 1000L) {
                           this.a();
                        }

                        this.c = System.currentTimeMillis();
                        this.g = true;
                     } else {
                        this.a();
                     }
                     break;
                  case 6:
                     if (this.g) {
                        this.d = System.currentTimeMillis();
                     } else {
                        this.a();
                     }
               }
            }

            return false;
         }
      };
   }

   private void a(MixpanelAPI var1, Activity var2) {
      var2.getWindow().getDecorView().setOnTouchListener(this.a(var1));
   }
}
