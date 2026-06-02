package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
final class zzckb implements ActivityLifecycleCallbacks {
   private zzcjn a;

   private zzckb(zzcjn var1) {
      this.a = var1;
      super();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final void onActivityCreated(Activity var1, Bundle var2) {
      label107: {
         Intent var4;
         try {
            this.a.t().E().a("onActivityCreated");
            var4 = var1.getIntent();
         } catch (Throwable var15) {
            this.a.t().y().a("Throwable caught in onActivityCreated", var15);
            break label107;
         }

         label104:
         if (var4 != null) {
            Uri var6;
            try {
               var6 = var4.getData();
            } catch (Throwable var14) {
               this.a.t().y().a("Throwable caught in onActivityCreated", var14);
               break label104;
            }

            label100:
            if (var6 != null) {
               try {
                  if (!var6.isHierarchical()) {
                     break label100;
                  }
               } catch (Throwable var13) {
                  this.a.t().y().a("Throwable caught in onActivityCreated", var13);
                  break label100;
               }

               if (var2 == null) {
                  Bundle var5;
                  label92: {
                     label91: {
                        try {
                           var5 = this.a.p().a(var6);
                           this.a.p();
                           if (zzclq.a(var4)) {
                              break label91;
                           }
                        } catch (Throwable var12) {
                           this.a.t().y().a("Throwable caught in onActivityCreated", var12);
                           break label100;
                        }

                        var18 = "auto";
                        break label92;
                     }

                     var18 = "gs";
                  }

                  if (var5 != null) {
                     try {
                        this.a.a(var18, "_cmp", var5);
                     } catch (Throwable var11) {
                        this.a.t().y().a("Throwable caught in onActivityCreated", var11);
                        break label100;
                     }
                  }
               }

               try {
                  var19 = var6.getQueryParameter("referrer");
                  if (TextUtils.isEmpty(var19)) {
                     return;
                  }
               } catch (Throwable var10) {
                  this.a.t().y().a("Throwable caught in onActivityCreated", var10);
                  break label100;
               }

               boolean var3;
               label79: {
                  label78: {
                     try {
                        if (var19.contains("gclid")
                           && (
                              var19.contains("utm_campaign")
                                 || var19.contains("utm_source")
                                 || var19.contains("utm_medium")
                                 || var19.contains("utm_term")
                                 || var19.contains("utm_content")
                           )) {
                           break label78;
                        }
                     } catch (Throwable var9) {
                        this.a.t().y().a("Throwable caught in onActivityCreated", var9);
                        break label100;
                     }

                     var3 = false;
                     break label79;
                  }

                  var3 = true;
               }

               if (!var3) {
                  try {
                     this.a.t().D().a("Activity created with data 'referrer' param without gclid and at least one utm field");
                     return;
                  } catch (Throwable var8) {
                     this.a.t().y().a("Throwable caught in onActivityCreated", var8);
                  }
               } else {
                  try {
                     this.a.t().D().a("Activity created with referrer", var19);
                     if (!TextUtils.isEmpty(var19)) {
                        this.a.a("auto", "_ldl", (Object)var19);
                     }
                  } catch (Throwable var7) {
                     this.a.t().y().a("Throwable caught in onActivityCreated", var7);
                  }
               }
            }
         }
      }

      zzckc var20 = this.a.j();
      if (var2 != null) {
         var2 = var2.getBundle("com.google.firebase.analytics.screen_service");
         if (var2 != null) {
            zzckf var16 = var20.a(var1);
            var16.d = var2.getLong("id");
            var16.b = var2.getString("name");
            var16.c = var2.getString("referrer_name");
         }
      }
   }

   public final void onActivityDestroyed(Activity var1) {
      this.a.j().d(var1);
   }

   public final void onActivityPaused(Activity var1) {
      this.a.j().c(var1);
      zzclf var4 = this.a.r();
      long var2 = var4.k().b();
      var4.s().a(new zzclj(var4, var2));
   }

   public final void onActivityResumed(Activity var1) {
      this.a.j().b(var1);
      zzclf var4 = this.a.r();
      long var2 = var4.k().b();
      var4.s().a(new zzcli(var4, var2));
   }

   public final void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      this.a.j().a(var1, var2);
   }

   public final void onActivityStarted(Activity var1) {
   }

   public final void onActivityStopped(Activity var1) {
   }
}
