package com.google.android.gms.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzcir extends zzchf {
   private final zzcim a;
   private Boolean b;
   private String c;

   public zzcir(zzcim var1) {
      this(var1, null);
   }

   private zzcir(zzcim var1, String var2) {
      zzbq.a(var1);
      this.a = var1;
      this.c = null;
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final void a(String var1, boolean var2) {
      boolean var3 = false;
      if (TextUtils.isEmpty(var1)) {
         this.a.f().y().a("Measurement Service called without app package");
         throw new SecurityException("Measurement Service called without app package");
      }

      label70: {
         if (var2) {
            label63: {
               label62: {
                  label71: {
                     try {
                        if (this.b != null) {
                           break label63;
                        }

                        if ("com.google.android.gms".equals(this.c) || zzx.a(this.a.t(), Binder.getCallingUid())) {
                           break label71;
                        }
                     } catch (SecurityException var11) {
                        this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
                        throw var11;
                     }

                     var2 = var3;

                     try {
                        if (!zzq.a(this.a.t()).a(Binder.getCallingUid())) {
                           break label62;
                        }
                     } catch (SecurityException var10) {
                        this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
                        throw var10;
                     }
                  }

                  var2 = true;
               }

               try {
                  this.b = var2;
               } catch (SecurityException var7) {
                  this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
                  throw var7;
               }
            }

            try {
               if (this.b) {
                  break label70;
               }
            } catch (SecurityException var9) {
               this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
               throw var9;
            }
         }

         try {
            if (this.c == null && zzp.zzb(this.a.t(), Binder.getCallingUid(), var1)) {
               this.c = var1;
            }
         } catch (SecurityException var8) {
            this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
            throw var8;
         }

         try {
            if (!var1.equals(this.c)) {
               SecurityException var4 = new SecurityException(String.format("Unknown calling package name '%s'.", var1));
               throw var4;
            }
         } catch (SecurityException var6) {
            this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
            throw var6;
         }
      }

      try {
         ;
      } catch (SecurityException var5) {
         this.a.f().y().a("Measurement Service called with invalid calling package. appId", zzchm.a(var1));
         throw var5;
      }
   }

   private final void b(zzcgi var1, boolean var2) {
      zzbq.a(var1);
      this.a(var1.a, false);
      this.a.o().f(var1.b);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final List<zzcln> a(zzcgi var1, boolean var2) {
      this.b(var1, false);
      Future var3 = this.a.h().a(new zzcjh(this, var1));

      label48: {
         Iterator var5;
         try {
            List var4 = (List)var3.get();
            var17 = new ArrayList(var4.size());
            var5 = var4.iterator();
         } catch (InterruptedException var13) {
            var16 = var13;
            break label48;
         } catch (ExecutionException var14) {
            var16 = var14;
            break label48;
         }

         while (true) {
            zzclp var18;
            try {
               if (!var5.hasNext()) {
                  return var17;
               }

               var18 = (zzclp)var5.next();
            } catch (InterruptedException var11) {
               var16 = var11;
               break;
            } catch (ExecutionException var12) {
               var16 = var12;
               break;
            }

            if (!var2) {
               try {
                  if (zzclq.i(var18.c)) {
                     continue;
                  }
               } catch (InterruptedException var9) {
                  var16 = var9;
                  break;
               } catch (ExecutionException var10) {
                  var16 = var10;
                  break;
               }
            }

            try {
               zzcln var6 = new zzcln(var18);
               var17.add(var6);
            } catch (InterruptedException var7) {
               var16 = var7;
               break;
            } catch (ExecutionException var8) {
               var16 = var8;
               break;
            }
         }
      }

      this.a.f().y().a("Failed to get user attributes. appId", zzchm.a(var1.a), var16);
      return null;
   }

   @Override
   public final List<zzcgl> a(String var1, String var2, zzcgi var3) {
      this.b(var3, false);
      Future var6 = this.a.h().a(new zzciz(this, var3, var1, var2));

      try {
         return (List<zzcgl>)var6.get();
      } catch (InterruptedException var4) {
         var7 = var4;
      } catch (ExecutionException var5) {
         var7 = var5;
      }

      this.a.f().y().a("Failed to get conditional user properties", var7);
      return Collections.emptyList();
   }

   @Override
   public final List<zzcgl> a(String var1, String var2, String var3) {
      this.a(var1, true);
      Future var6 = this.a.h().a(new zzcja(this, var1, var2, var3));

      try {
         return (List<zzcgl>)var6.get();
      } catch (InterruptedException var4) {
         var7 = var4;
      } catch (ExecutionException var5) {
         var7 = var5;
      }

      this.a.f().y().a("Failed to get conditional user properties", var7);
      return Collections.emptyList();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final List<zzcln> a(String var1, String var2, String var3, boolean var4) {
      this.a(var1, true);
      Future var16 = this.a.h().a(new zzciy(this, var1, var2, var3));

      label48: {
         Iterator var6;
         try {
            List var19 = (List)var16.get();
            var18 = new ArrayList(var19.size());
            var6 = var19.iterator();
         } catch (InterruptedException var13) {
            var17 = var13;
            break label48;
         } catch (ExecutionException var14) {
            var17 = var14;
            break label48;
         }

         while (true) {
            try {
               if (!var6.hasNext()) {
                  return var18;
               }

               var20 = (zzclp)var6.next();
            } catch (InterruptedException var11) {
               var17 = var11;
               break;
            } catch (ExecutionException var12) {
               var17 = var12;
               break;
            }

            if (!var4) {
               try {
                  if (zzclq.i(var20.c)) {
                     continue;
                  }
               } catch (InterruptedException var9) {
                  var17 = var9;
                  break;
               } catch (ExecutionException var10) {
                  var17 = var10;
                  break;
               }
            }

            try {
               zzcln var5 = new zzcln(var20);
               var18.add(var5);
            } catch (InterruptedException var7) {
               var17 = var7;
               break;
            } catch (ExecutionException var8) {
               var17 = var8;
               break;
            }
         }
      }

      this.a.f().y().a("Failed to get user attributes. appId", zzchm.a(var1), var17);
      return Collections.emptyList();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final List<zzcln> a(String var1, String var2, boolean var3, zzcgi var4) {
      this.b(var4, false);
      Future var15 = this.a.h().a(new zzcix(this, var4, var1, var2));

      label47: {
         try {
            List var18 = (List)var15.get();
            var17 = new ArrayList(var18.size());
            var19 = var18.iterator();
         } catch (InterruptedException var13) {
            var16 = var13;
            break label47;
         } catch (ExecutionException var14) {
            var16 = var14;
            break label47;
         }

         while (true) {
            zzclp var6;
            try {
               if (!var19.hasNext()) {
                  return var17;
               }

               var6 = (zzclp)var19.next();
            } catch (InterruptedException var11) {
               var16 = var11;
               break;
            } catch (ExecutionException var12) {
               var16 = var12;
               break;
            }

            if (!var3) {
               try {
                  if (zzclq.i(var6.c)) {
                     continue;
                  }
               } catch (InterruptedException var9) {
                  var16 = var9;
                  break;
               } catch (ExecutionException var10) {
                  var16 = var10;
                  break;
               }
            }

            try {
               zzcln var5 = new zzcln(var6);
               var17.add(var5);
            } catch (InterruptedException var7) {
               var16 = var7;
               break;
            } catch (ExecutionException var8) {
               var16 = var8;
               break;
            }
         }
      }

      this.a.f().y().a("Failed to get user attributes. appId", zzchm.a(var4.a), var16);
      return Collections.emptyList();
   }

   @Override
   public final void a(long var1, String var3, String var4, String var5) {
      this.a.h().a(new zzcjj(this, var4, var5, var3, var1));
   }

   @Override
   public final void a(zzcgi var1) {
      this.b(var1, false);
      zzcji var2 = new zzcji(this, var1);
      if (this.a.h().z()) {
         var2.run();
      } else {
         this.a.h().a(var2);
      }
   }

   @Override
   public final void a(zzcgl var1) {
      zzbq.a(var1);
      zzbq.a(var1.c);
      this.a(var1.a, true);
      zzcgl var2 = new zzcgl(var1);
      if (var1.c.a() == null) {
         this.a.h().a(new zzciv(this, var2));
      } else {
         this.a.h().a(new zzciw(this, var2));
      }
   }

   @Override
   public final void a(zzcgl var1, zzcgi var2) {
      zzbq.a(var1);
      zzbq.a(var1.c);
      this.b(var2, false);
      zzcgl var3 = new zzcgl(var1);
      var3.a = var2.a;
      if (var1.c.a() == null) {
         this.a.h().a(new zzcit(this, var3, var2));
      } else {
         this.a.h().a(new zzciu(this, var3, var2));
      }
   }

   @Override
   public final void a(zzcha var1, zzcgi var2) {
      zzbq.a(var1);
      this.b(var2, false);
      this.a.h().a(new zzcjc(this, var1, var2));
   }

   @Override
   public final void a(zzcha var1, String var2, String var3) {
      zzbq.a(var1);
      zzbq.a(var2);
      this.a(var2, true);
      this.a.h().a(new zzcjd(this, var1, var2));
   }

   @Override
   public final void a(zzcln var1, zzcgi var2) {
      zzbq.a(var1);
      this.b(var2, false);
      if (var1.a() == null) {
         this.a.h().a(new zzcjf(this, var1, var2));
      } else {
         this.a.h().a(new zzcjg(this, var1, var2));
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final byte[] a(zzcha var1, String var2) {
      zzbq.a(var2);
      zzbq.a(var1);
      this.a(var2, true);
      this.a.f().D().a("Log and bundle. event", this.a.p().a(var1.a));
      long var5 = this.a.u().c() / 1000000L;
      Future var7 = this.a.h().b(new zzcje(this, var1, var2));

      label37: {
         byte[] var8;
         try {
            var8 = (byte[])var7.get();
         } catch (InterruptedException var13) {
            var15 = var13;
            break label37;
         } catch (ExecutionException var14) {
            var15 = var14;
            break label37;
         }

         byte[] var16 = var8;
         if (var8 == null) {
            try {
               this.a.f().y().a("Log and bundle returned null. appId", zzchm.a(var2));
               var16 = new byte[0];
            } catch (InterruptedException var11) {
               var15 = var11;
               break label37;
            } catch (ExecutionException var12) {
               var15 = var12;
               break label37;
            }
         }

         try {
            long var3 = this.a.u().c() / 1000000L;
            this.a.f().D().a("Log and bundle processed. event, size, time_ms", this.a.p().a(var1.a), var16.length, var3 - var5);
            return var16;
         } catch (InterruptedException var9) {
            var15 = var9;
         } catch (ExecutionException var10) {
            var15 = var10;
         }
      }

      this.a.f().y().a("Failed to log and bundle. appId, event, error", zzchm.a(var2), this.a.p().a(var1.a), var15);
      return null;
   }

   @Override
   public final void b(zzcgi var1) {
      this.b(var1, false);
      this.a.h().a(new zzcis(this, var1));
   }

   @Override
   public final String c(zzcgi var1) {
      this.b(var1, false);
      return this.a.a(var1.a);
   }

   @Override
   public final void d(zzcgi var1) {
      this.a(var1.a, false);
      this.a.h().a(new zzcjb(this, var1));
   }
}
