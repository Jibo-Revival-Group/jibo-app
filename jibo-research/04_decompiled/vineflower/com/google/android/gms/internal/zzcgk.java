package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzcgk extends zzcjl {
   zzcgk(zzcim var1) {
      super(var1);
   }

   private final Boolean a(double var1, zzclu var3) {
      try {
         BigDecimal var4 = new BigDecimal(var1);
         var6 = a(var4, var3, Math.ulp(var1));
      } catch (NumberFormatException var5) {
         var6 = null;
      }

      return var6;
   }

   private final Boolean a(long var1, zzclu var3) {
      try {
         BigDecimal var4 = new BigDecimal(var1);
         var6 = a(var4, var3, 0.0);
      } catch (NumberFormatException var5) {
         var6 = null;
      }

      return var6;
   }

   private final Boolean a(zzcls var1, zzcmb var2, long var3) {
      if (var1.d != null) {
         Boolean var9 = this.a(var3, var1.d);
         if (var9 == null) {
            Object var44 = null;
            return (Boolean)var44;
         }

         if (!var9) {
            Boolean var43 = false;
            return var43;
         }
      }

      HashSet var10 = new HashSet();
      zzclt[] var24 = var1.c;
      int var6 = var24.length;
      int var5 = 0;

      while (true) {
         if (var5 >= var6) {
            ArrayMap var25 = new ArrayMap();

            for (zzcmc var27 : var2.a) {
               if (var10.contains(var27.a)) {
                  if (var27.c != null) {
                     var25.put(var27.a, var27.c);
                  } else if (var27.d != null) {
                     var25.put(var27.a, var27.d);
                  } else {
                     if (var27.b == null) {
                        this.t().A().a("Unknown value for param. event, param", this.o().a(var2.b), this.o().b(var27.a));
                        Object var42 = null;
                        return (Boolean)var42;
                     }

                     var25.put(var27.a, var27.b);
                  }
               }
            }

            for (zzclt var29 : var1.c) {
               boolean var8 = Boolean.TRUE.equals(var29.c);
               String var14 = var29.d;
               if (TextUtils.isEmpty(var14)) {
                  this.t().A().a("Event has empty param name. event", this.o().a(var2.b));
                  Object var41 = null;
                  return (Boolean)var41;
               }

               Object var28 = var25.get(var14);
               if (var28 instanceof Long) {
                  if (var29.b == null) {
                     this.t().A().a("No number filter for long param. event, param", this.o().a(var2.b), this.o().b(var14));
                     Object var32 = null;
                     return (Boolean)var32;
                  }

                  Boolean var15 = this.a((Long)var28, var29.b);
                  if (var15 == null) {
                     Object var31 = null;
                     return (Boolean)var31;
                  }

                  boolean var21;
                  if (!var15) {
                     var21 = true;
                  } else {
                     var21 = false;
                  }

                  if (var21 ^ var8) {
                     Boolean var30 = false;
                     return var30;
                  }
               } else if (var28 instanceof Double) {
                  if (var29.b == null) {
                     this.t().A().a("No number filter for double param. event, param", this.o().a(var2.b), this.o().b(var14));
                     Object var35 = null;
                     return (Boolean)var35;
                  }

                  Boolean var16 = this.a((Double)var28, var29.b);
                  if (var16 == null) {
                     Object var34 = null;
                     return (Boolean)var34;
                  }

                  boolean var22;
                  if (!var16) {
                     var22 = true;
                  } else {
                     var22 = false;
                  }

                  if (var22 ^ var8) {
                     Boolean var33 = false;
                     return var33;
                  }
               } else {
                  if (!(var28 instanceof String)) {
                     Boolean var40;
                     if (var28 == null) {
                        this.t().E().a("Missing param for filter. event, param", this.o().a(var2.b), this.o().b(var14));
                        var40 = false;
                     } else {
                        this.t().A().a("Unknown param type. event, param", this.o().a(var2.b), this.o().b(var14));
                        var40 = null;
                     }

                     return var40;
                  }

                  Boolean var17;
                  if (var29.a != null) {
                     var17 = this.a((String)var28, var29.a);
                  } else {
                     if (var29.b == null) {
                        this.t().A().a("No filter for String param. event, param", this.o().a(var2.b), this.o().b(var14));
                        Object var39 = null;
                        return (Boolean)var39;
                     }

                     if (!zzclq.k((String)var28)) {
                        this.t().A().a("Invalid param value for number filter. event, param", this.o().a(var2.b), this.o().b(var14));
                        Object var38 = null;
                        return (Boolean)var38;
                     }

                     var17 = this.a((String)var28, var29.b);
                  }

                  if (var17 == null) {
                     Object var37 = null;
                     return (Boolean)var37;
                  }

                  boolean var23;
                  if (!var17) {
                     var23 = true;
                  } else {
                     var23 = false;
                  }

                  if (var23 ^ var8) {
                     Boolean var36 = false;
                     return var36;
                  }
               }
            }

            var13 = true;
            break;
         }

         zzclt var11 = var24[var5];
         if (TextUtils.isEmpty(var11.d)) {
            this.t().A().a("null or empty param name in filter. event", this.o().a(var2.b));
            var13 = null;
            break;
         }

         var10.add(var11.d);
         var5++;
      }

      return var13;
   }

   private static Boolean a(Boolean var0, boolean var1) {
      if (var0 == null) {
         var0 = null;
      } else {
         var0 = var0 ^ var1;
      }

      return var0;
   }

   private final Boolean a(String var1, int var2, boolean var3, String var4, List<String> var5, String var6) {
      Boolean var9;
      if (var1 == null) {
         var9 = null;
      } else {
         if (var2 == 6) {
            if (var5 == null || var5.size() == 0) {
               Object var12 = null;
               return (Boolean)var12;
            }
         } else if (var4 == null) {
            Object var13 = null;
            return (Boolean)var13;
         }

         String var7 = var1;
         if (!var3) {
            if (var2 == 1) {
               var7 = var1;
            } else {
               var7 = var1.toUpperCase(Locale.ENGLISH);
            }
         }

         switch (var2) {
            case 1:
               byte var10;
               if (var3) {
                  var10 = 0;
               } else {
                  var10 = 66;
               }

               try {
                  var3 = Pattern.compile(var6, var10).matcher(var7).matches();
               } catch (PatternSyntaxException var8) {
                  this.t().A().a("Invalid regular expression in REGEXP audience filter. expression", var6);
                  var9 = null;
                  break;
               }

               var9 = var3;
               break;
            case 2:
               var9 = var7.startsWith(var4);
               break;
            case 3:
               var9 = var7.endsWith(var4);
               break;
            case 4:
               var9 = var7.contains(var4);
               break;
            case 5:
               var9 = var7.equals(var4);
               break;
            case 6:
               var9 = var5.contains(var7);
               break;
            default:
               var9 = null;
         }
      }

      return var9;
   }

   private final Boolean a(String var1, zzclu var2) {
      Object var3 = null;
      Boolean var6;
      if (!zzclq.k(var1)) {
         var6 = (Boolean)var3;
      } else {
         try {
            BigDecimal var4 = new BigDecimal(var1);
            var6 = a(var4, var2, 0.0);
         } catch (NumberFormatException var5) {
            var6 = (Boolean)var3;
         }
      }

      return var6;
   }

   private final Boolean a(String var1, zzclw var2) {
      int var3 = 0;
      String var8 = null;
      ArrayList var9 = null;
      zzbq.a(var2);
      Boolean var7;
      if (var1 == null) {
         var7 = var9;
      } else {
         var7 = var9;
         if (var2.a != null) {
            var7 = var9;
            if (var2.a != 0) {
               if (var2.a == 6) {
                  var7 = var9;
                  if (var2.d == null) {
                     return var7;
                  }

                  var7 = var9;
                  if (var2.d.length == 0) {
                     return var7;
                  }
               } else if (var2.b == null) {
                  var7 = var9;
                  return var7;
               }

               int var5 = var2.a;
               boolean var6;
               if (var2.c != null && var2.c) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               String var12;
               if (!var6 && var5 != 1 && var5 != 6) {
                  var12 = var2.b.toUpperCase(Locale.ENGLISH);
               } else {
                  var12 = var2.b;
               }

               List var11;
               if (var2.d == null) {
                  var11 = null;
               } else {
                  String[] var10 = var2.d;
                  if (var6) {
                     var11 = Arrays.asList(var10);
                  } else {
                     var9 = new ArrayList();
                     int var4 = var10.length;

                     while (true) {
                        var11 = var9;
                        if (var3 >= var4) {
                           break;
                        }

                        var9.add(var10[var3].toUpperCase(Locale.ENGLISH));
                        var3++;
                     }
                  }
               }

               if (var5 == 1) {
                  var8 = var12;
               }

               var7 = this.a(var1, var5, var6, var12, var11, var8);
            }
         }
      }

      return var7;
   }

   private static Boolean a(BigDecimal var0, zzclu var1, double var2) {
      boolean var8 = true;
      boolean var7 = true;
      boolean var5 = true;
      boolean var9 = true;
      boolean var6 = true;
      zzbq.a(var1);
      Object var14;
      if (var1.a != null && var1.a != 0) {
         if (var1.a == 4) {
            if (var1.d == null || var1.e == null) {
               var14 = null;
               return (Boolean)var14;
            }
         } else if (var1.c == null) {
            var14 = null;
            return (Boolean)var14;
         }

         int var4 = var1.a;
         BigDecimal var10;
         BigDecimal var11;
         BigDecimal var15;
         if (var1.a == 4) {
            if (!zzclq.k(var1.d) || !zzclq.k(var1.e)) {
               var14 = null;
               return (Boolean)var14;
            }

            try {
               var11 = new BigDecimal(var1.d);
               var10 = new BigDecimal(var1.e);
            } catch (NumberFormatException var13) {
               var14 = null;
               return (Boolean)var14;
            }

            var15 = null;
         } else {
            if (!zzclq.k(var1.c)) {
               var14 = null;
               return (Boolean)var14;
            }

            try {
               var15 = new BigDecimal(var1.c);
            } catch (NumberFormatException var12) {
               var14 = null;
               return (Boolean)var14;
            }

            var11 = null;
            var10 = null;
         }

         label81: {
            if (var4 == 4) {
               if (var11 == null) {
                  var14 = null;
                  return (Boolean)var14;
               }
            } else if (var15 == null) {
               break label81;
            }

            switch (var4) {
               case 1:
                  if (var0.compareTo(var15) == -1) {
                     var5 = var6;
                  } else {
                     var5 = false;
                  }

                  var14 = var5;
                  return var14;
               case 2:
                  if (var0.compareTo(var15) == 1) {
                     var5 = var8;
                  } else {
                     var5 = false;
                  }

                  var14 = var5;
                  return var14;
               case 3:
                  if (var2 != 0.0) {
                     if (var0.compareTo(var15.subtract(new BigDecimal(var2).multiply(new BigDecimal(2)))) == 1
                        && var0.compareTo(var15.add(new BigDecimal(var2).multiply(new BigDecimal(2)))) == -1) {
                        var5 = var7;
                     } else {
                        var5 = false;
                     }

                     var14 = var5;
                  } else {
                     if (var0.compareTo(var15) != 0) {
                        var5 = false;
                     }

                     var14 = var5;
                  }

                  return var14;
               case 4:
                  if (var0.compareTo(var11) != -1 && var0.compareTo(var10) != 1) {
                     var5 = var9;
                  } else {
                     var5 = false;
                  }

                  var14 = var5;
                  return var14;
            }
         }

         var14 = null;
      } else {
         var14 = null;
      }

      return var14;
   }

   final zzcma[] a(String var1, zzcmb[] var2, zzcmg[] var3) {
      zzbq.a(var1);
      HashSet var18 = new HashSet();
      ArrayMap var16 = new ArrayMap();
      ArrayMap var15 = new ArrayMap();
      ArrayMap var17 = new ArrayMap();
      Map var13 = this.n().e(var1);
      if (var13 != null) {
         for (int var5 : var13.keySet()) {
            zzcmf var19 = (zzcmf)var13.get(var5);
            BitSet var12 = (BitSet)var15.get(var5);
            BitSet var11 = (BitSet)var17.get(var5);
            BitSet var10 = var12;
            if (var12 == null) {
               var10 = new BitSet();
               var15.put(var5, var10);
               var11 = new BitSet();
               var17.put(var5, var11);
            }

            for (int var4 = 0; var4 < var19.a.length << 6; var4++) {
               if (zzclq.a(var19.a, var4)) {
                  this.t().E().a("Filter already evaluated. audience ID, filter ID", var5, var4);
                  var11.set(var4);
                  if (zzclq.a(var19.b, var4)) {
                     var10.set(var4);
                  }
               }
            }

            zzcma var54 = new zzcma();
            var16.put(var5, var54);
            var54.d = false;
            var54.c = var19;
            var54.b = new zzcmf();
            var54.b.b = zzclq.a(var10);
            var54.b.a = zzclq.a(var11);
         }
      }

      if (var2 != null) {
         ArrayMap var65 = new ArrayMap();

         for (zzcmb var20 : var2) {
            zzcgw var43 = this.n().a(var1, var20.b);
            if (var43 == null) {
               this.t().A().a("Event aggregate wasn't created during raw event logging. appId, event", zzchm.a(var1), this.o().a(var20.b));
               var43 = new zzcgw(var1, var20.b, 1L, 1L, var20.c, 0L, null, null, null);
            } else {
               var43 = var43.a();
            }

            this.n().a(var43);
            long var8 = var43.c;
            Map var45 = (Map)var65.get(var20.b);
            if (var45 == null) {
               Map var49 = this.n().f(var1, var20.b);
               var45 = var49;
               if (var49 == null) {
                  var45 = new ArrayMap();
               }

               var65.put(var20.b, var45);
            }

            for (int var6 : var45.keySet()) {
               if (var18.contains(var6)) {
                  this.t().E().a("Skipping failed audience ID", var6);
               } else {
                  zzcma var59 = (zzcma)var16.get(var6);
                  BitSet var55 = (BitSet)var15.get(var6);
                  BitSet var50 = (BitSet)var17.get(var6);
                  if (var59 == null) {
                     zzcma var51 = new zzcma();
                     var16.put(var6, var51);
                     var51.d = true;
                     var55 = new BitSet();
                     var15.put(var6, var55);
                     var50 = new BitSet();
                     var17.put(var6, var50);
                  }

                  for (zzcls var24 : (List)var45.get(var6)) {
                     if (this.t().a(2)) {
                        this.t().E().a("Evaluating filter. audience, filter, event", var6, var24.a, this.o().a(var24.b));
                        this.t().E().a("Filter definition", this.o().a(var24));
                     }

                     if (var24.a == null || var24.a > 256) {
                        this.t().A().a("Invalid event filter ID. appId, id", zzchm.a(var1), String.valueOf(var24.a));
                     } else if (var55.get(var24.a)) {
                        this.t().E().a("Event filter already evaluated true. audience ID, filter ID", var6, var24.a);
                     } else {
                        Boolean var63 = this.a(var24, var20, var8);
                        zzcho var23 = this.t().E();
                        Serializable var60;
                        if (var63 == null) {
                           var60 = "null";
                        } else {
                           var60 = var63;
                        }

                        var23.a("Event filter result", var60);
                        if (var63 == null) {
                           var18.add(var6);
                        } else {
                           var50.set(var24.a);
                           if (var63) {
                              var55.set(var24.a);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (var3 != null) {
         ArrayMap var64 = new ArrayMap();

         for (zzcmg var66 : var3) {
            Map var46 = (Map)var64.get(var66.b);
            if (var46 == null) {
               var46 = this.n().g(var1, var66.b);
               Map var27 = var46;
               if (var46 == null) {
                  var27 = new ArrayMap();
               }

               var64.put(var66.b, var27);
               var46 = var27;
            }

            for (int var41 : var46.keySet()) {
               if (var18.contains(var41)) {
                  this.t().E().a("Skipping failed audience ID", var41);
               } else {
                  zzcma var28 = (zzcma)var16.get(var41);
                  BitSet var52 = (BitSet)var15.get(var41);
                  BitSet var56 = (BitSet)var17.get(var41);
                  if (var28 == null) {
                     zzcma var29 = new zzcma();
                     var16.put(var41, var29);
                     var29.d = true;
                     var52 = new BitSet();
                     var15.put(var41, var52);
                     var56 = new BitSet();
                     var17.put(var41, var56);
                  }

                  for (zzclv var69 : (List)var46.get(var41)) {
                     if (this.t().a(2)) {
                        this.t().E().a("Evaluating filter. audience, filter, property", var41, var69.a, this.o().c(var69.b));
                        this.t().E().a("Filter definition", this.o().a(var69));
                     }

                     if (var69.a == null || var69.a > 256) {
                        this.t().A().a("Invalid property filter ID. appId, id", zzchm.a(var1), String.valueOf(var69.a));
                        var18.add(var41);
                        break;
                     }

                     if (var52.get(var69.a)) {
                        this.t().E().a("Property filter already evaluated true. audience ID, filter ID", var41, var69.a);
                     } else {
                        zzclt var30 = var69.c;
                        Boolean var31;
                        if (var30 == null) {
                           this.t().A().a("Missing property filter. property", this.o().c(var66.b));
                           var31 = null;
                        } else {
                           boolean var7 = Boolean.TRUE.equals(var30.c);
                           if (var66.d != null) {
                              if (var30.b == null) {
                                 this.t().A().a("No number filter for long property. property", this.o().c(var66.b));
                                 var31 = null;
                              } else {
                                 var31 = a(this.a(var66.d, var30.b), var7);
                              }
                           } else if (var66.e != null) {
                              if (var30.b == null) {
                                 this.t().A().a("No number filter for double property. property", this.o().c(var66.b));
                                 var31 = null;
                              } else {
                                 var31 = a(this.a(var66.e, var30.b), var7);
                              }
                           } else if (var66.c != null) {
                              label193:
                              if (var30.a == null) {
                                 if (var30.b == null) {
                                    this.t().A().a("No string or number filter defined. property", this.o().c(var66.b));
                                 } else {
                                    if (zzclq.k(var66.c)) {
                                       var31 = a(this.a(var66.c, var30.b), var7);
                                       break label193;
                                    }

                                    this.t().A().a("Invalid user property value for Numeric number filter. property, value", this.o().c(var66.b), var66.c);
                                 }

                                 var31 = null;
                              } else {
                                 var31 = a(this.a(var66.c, var30.a), var7);
                              }
                           } else {
                              this.t().A().a("User property has no value, property", this.o().c(var66.b));
                              var31 = null;
                           }
                        }

                        zzcho var70 = this.t().E();
                        Serializable var61;
                        if (var31 == null) {
                           var61 = "null";
                        } else {
                           var61 = var31;
                        }

                        var70.a("Property filter result", var61);
                        if (var31 == null) {
                           var18.add(var41);
                        } else {
                           var56.set(var69.a);
                           if (var31) {
                              var52.set(var69.a);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      zzcma[] var48 = new zzcma[var15.size()];
      Iterator var34 = var15.keySet().iterator();
      int var37 = 0;

      while (true) {
         int var40;
         while (true) {
            int var42;
            zzcgo var53;
            while (true) {
               if (!var34.hasNext()) {
                  return Arrays.copyOf(var48, var37);
               }

               var42 = (Integer)var34.next();
               if (!var18.contains(var42)) {
                  zzcma var32 = (zzcma)var16.get(var42);
                  if (var32 == null) {
                     var32 = new zzcma();
                  }

                  var40 = var37 + 1;
                  var48[var37] = var32;
                  var32.a = var42;
                  var32.b = new zzcmf();
                  var32.b.b = zzclq.a((BitSet)var15.get(var42));
                  var32.b.a = zzclq.a((BitSet)var17.get(var42));
                  var53 = this.n();
                  zzcmf var57 = var32.b;
                  var53.Q();
                  var53.c();
                  zzbq.a(var1);
                  zzbq.a(var57);

                  try {
                     var33 = new byte[var57.f()];
                     zzfjk var62 = zzfjk.a(var33, 0, var33.length);
                     var57.a(var62);
                     var62.a();
                     break;
                  } catch (IOException var25) {
                     var53.t().y().a("Configuration loss. Failed to serialize filter results. appId", zzchm.a(var1), var25);
                     var37 = var40;
                  }
               }
            }

            ContentValues var58 = new ContentValues();
            var58.put("app_id", var1);
            var58.put("audience_id", var42);
            var58.put("current_results", var33);

            try {
               if (var53.A().insertWithOnConflict("audience_filter_values", null, var58, 5) == -1L) {
                  var53.t().y().a("Failed to insert filter results (got -1). appId", zzchm.a(var1));
               }
               break;
            } catch (SQLiteException var26) {
               var53.t().y().a("Error storing filter results. appId", zzchm.a(var1), var26);
               var37 = var40;
            }
         }

         var37 = var40;
      }
   }

   @Override
   protected final boolean w() {
      return false;
   }
}
