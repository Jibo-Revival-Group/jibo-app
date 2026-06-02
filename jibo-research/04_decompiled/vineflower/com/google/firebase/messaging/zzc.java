package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzfjr;
import com.google.android.gms.internal.zzfkt;
import com.google.android.gms.internal.zzfku;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzc {
   private static Bundle a(String var0, String var1) {
      Bundle var2 = new Bundle();
      var2.putString(var0, var1);
      return var2;
   }

   private static zzfku a(byte[] var0) {
      try {
         var2 = zzfku.a(var0);
      } catch (zzfjr var1) {
         var2 = null;
      }

      return var2;
   }

   private static AppMeasurement a(Context var0) {
      try {
         var2 = AppMeasurement.getInstance(var0);
      } catch (NoClassDefFoundError var1) {
         var2 = null;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Object a(zzfku var0, String var1, zzb var2) {
      Field var4 = null;

      Object var3;
      label96: {
         Bundle var5;
         Class var6;
         try {
            var6 = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            var5 = a(var0.a, var0.b);
            var3 = var6.getConstructor().newInstance();
         } catch (Exception var16) {
            var17 = var16;
            var3 = null;
            break label96;
         }

         label87: {
            label97: {
               try {
                  var6.getField("mOrigin").set(var3, var1);
                  var6.getField("mCreationTimestamp").set(var3, var0.c);
                  var6.getField("mName").set(var3, var0.a);
                  var6.getField("mValue").set(var3, var0.b);
                  if (TextUtils.isEmpty(var0.d)) {
                     break label97;
                  }
               } catch (Exception var15) {
                  var17 = var15;
                  break label96;
               }

               try {
                  var1 = var0.d;
                  break label87;
               } catch (Exception var14) {
                  var17 = var14;
                  break label96;
               }
            }

            var1 = var4;
         }

         label98: {
            try {
               var6.getField("mTriggerEventName").set(var3, var1);
               var4 = var6.getField("mTimedOutEventName");
               if (!TextUtils.isEmpty(var0.j)) {
                  var1 = var0.j;
                  break label98;
               }
            } catch (Exception var13) {
               var17 = var13;
               break label96;
            }

            try {
               var1 = var2.b();
            } catch (Exception var12) {
               var17 = var12;
               break label96;
            }
         }

         label99: {
            try {
               var4.set(var3, var1);
               var6.getField("mTimedOutEventParams").set(var3, var5);
               var6.getField("mTriggerTimeout").set(var3, var0.e);
               var4 = var6.getField("mTriggeredEventName");
               if (!TextUtils.isEmpty(var0.h)) {
                  var1 = var0.h;
                  break label99;
               }
            } catch (Exception var11) {
               var17 = var11;
               break label96;
            }

            try {
               var1 = var2.a();
            } catch (Exception var10) {
               var17 = var10;
               break label96;
            }
         }

         label100: {
            try {
               var4.set(var3, var1);
               var6.getField("mTriggeredEventParams").set(var3, var5);
               var6.getField("mTimeToLive").set(var3, var0.f);
               var22 = var6.getField("mExpiredEventName");
               if (!TextUtils.isEmpty(var0.k)) {
                  var18 = var0.k;
                  break label100;
               }
            } catch (Exception var9) {
               var17 = var9;
               break label96;
            }

            try {
               var18 = var2.c();
            } catch (Exception var8) {
               var17 = var8;
               break label96;
            }
         }

         try {
            var22.set(var3, var18);
            var6.getField("mExpiredEventParams").set(var3, var5);
            return var3;
         } catch (Exception var7) {
            var17 = var7;
         }
      }

      Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var17);
      return var3;
   }

   private static String a(zzfku var0, zzb var1) {
      String var2;
      if (var0 != null && !TextUtils.isEmpty(var0.i)) {
         var2 = var0.i;
      } else {
         var2 = var1.d();
      }

      return var2;
   }

   private static String a(Object var0) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
      return (String)Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(var0);
   }

   private static List<Object> a(AppMeasurement var0, String var1) {
      ArrayList var3 = new ArrayList();

      try {
         Method var4 = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", String.class, String.class);
         var4.setAccessible(true);
         var6 = (List)var4.invoke(var0, var1, "");
      } catch (Exception var5) {
         Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var5);
         var6 = var3;
      }

      if (Log.isLoggable("FirebaseAbtUtil", 2)) {
         int var2 = var6.size();
         Log.v(
            "FirebaseAbtUtil",
            new StringBuilder(String.valueOf(var1).length() + 55)
               .append("Number of currently set _Es for origin: ")
               .append(var1)
               .append(" is ")
               .append(var2)
               .toString()
         );
      }

      return var6;
   }

   private static void a(Context var0, String var1, String var2, String var3, String var4) {
      if (Log.isLoggable("FirebaseAbtUtil", 2)) {
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var1 = "_CE(experimentId) called by ".concat(var1);
         } else {
            var1 = new String("_CE(experimentId) called by ");
         }

         Log.v("FirebaseAbtUtil", var1);
      }

      if (b(var0)) {
         AppMeasurement var9 = a(var0);

         try {
            Method var7 = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", String.class, String.class, Bundle.class);
            var7.setAccessible(true);
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
               int var5 = String.valueOf(var2).length();
               int var6 = String.valueOf(var3).length();
               StringBuilder var12 = new StringBuilder(var5 + 17 + var6);
               Log.v("FirebaseAbtUtil", var12.append("Clearing _E: [").append(var2).append(", ").append(var3).append("]").toString());
            }

            var7.invoke(var9, var2, var4, a(var2, var3));
         } catch (Exception var8) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var8);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void a(Context var0, String var1, byte[] var2, zzb var3, int var4) {
      if (Log.isLoggable("FirebaseAbtUtil", 2)) {
         String var11 = String.valueOf(var1);
         if (var11.length() != 0) {
            var11 = "_SE called by ".concat(var11);
         } else {
            var11 = new String("_SE called by ");
         }

         Log.v("FirebaseAbtUtil", var11);
      }

      if (b(var0)) {
         AppMeasurement var41 = a(var0);
         zzfku var27 = a(var2);
         if (var27 == null) {
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
               Log.v("FirebaseAbtUtil", "_SE failed; either _P was not set, or we couldn't deserialize the _P.");
            }
         } else {
            Iterator var14;
            try {
               Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
               var14 = a(var41, var1).iterator();
            } catch (Exception var24) {
               Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var24);
               return;
            }

            int var29 = 0;

            label125:
            while (true) {
               while (true) {
                  long var9;
                  String var12;
                  String var13;
                  try {
                     if (!var14.hasNext()) {
                        break label125;
                     }

                     StringBuilder var15 = (StringBuilder)var14.next();
                     var13 = a(var15);
                     var12 = b(var15);
                     var9 = (Long)Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty")
                        .getField("mCreationTimestamp")
                        .get(var15);
                     if (var27.a.equals(var13) && var27.b.equals(var12)) {
                        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                           int var35 = String.valueOf(var13).length();
                           var29 = String.valueOf(var12).length();
                           var15 = new StringBuilder(var35 + 23 + var29);
                           Log.v("FirebaseAbtUtil", var15.append("_E is already set. [").append(var13).append(", ").append(var12).append("]").toString());
                        }
                        break;
                     }
                  } catch (Exception var23) {
                     Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var23);
                     return;
                  }

                  boolean var7 = false;

                  int var8;
                  zzfkt[] var42;
                  try {
                     var42 = var27.m;
                     var8 = var42.length;
                  } catch (Exception var19) {
                     Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var19);
                     return;
                  }

                  int var6 = 0;

                  int var5;
                  while (true) {
                     var5 = var7;
                     if (var6 >= var8) {
                        break;
                     }

                     label107: {
                        try {
                           if (var42[var6].a.equals(var13)) {
                              if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                 var6 = String.valueOf(var13).length();
                                 var5 = String.valueOf(var12).length();
                                 StringBuilder var43 = new StringBuilder(var6 + 33 + var5);
                                 Log.v(
                                    "FirebaseAbtUtil",
                                    var43.append("_E is found in the _OE list. [").append(var13).append(", ").append(var12).append("]").toString()
                                 );
                              }
                              break label107;
                           }
                        } catch (Exception var22) {
                           Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var22);
                           return;
                        }

                        var6++;
                        continue;
                     }

                     var5 = 1;
                     break;
                  }

                  if (!var5) {
                     label141: {
                        try {
                           if (var27.c > var9) {
                              if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                 var6 = String.valueOf(var13).length();
                                 var5 = String.valueOf(var12).length();
                                 StringBuilder var45 = new StringBuilder(var6 + 115 + var5);
                                 Log.v(
                                    "FirebaseAbtUtil",
                                    var45.append(
                                          "Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. ["
                                       )
                                       .append(var13)
                                       .append(", ")
                                       .append(var12)
                                       .append("]")
                                       .toString()
                                 );
                              }
                              break label141;
                           }
                        } catch (Exception var21) {
                           Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var21);
                           return;
                        }

                        try {
                           if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                              var5 = String.valueOf(var13).length();
                              var6 = String.valueOf(var12).length();
                              StringBuilder var44 = new StringBuilder(var5 + 109 + var6);
                              Log.v(
                                 "FirebaseAbtUtil",
                                 var44.append("_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [")
                                    .append(var13)
                                    .append(", ")
                                    .append(var12)
                                    .append("]")
                                    .toString()
                              );
                           }
                           continue;
                        } catch (Exception var20) {
                           Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var20);
                           return;
                        }
                     }

                     try {
                        a(var0, var1, var13, var12, a(var27, var3));
                     } catch (Exception var18) {
                        Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var18);
                        return;
                     }
                  }
               }

               var29 = 1;
            }

            if (var29) {
               try {
                  if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                     String var25 = var27.a;
                     String var28 = var27.b;
                     int var36 = String.valueOf(var25).length();
                     var29 = String.valueOf(var28).length();
                     StringBuilder var26 = new StringBuilder(var36 + 44 + var29);
                     Log.v(
                        "FirebaseAbtUtil",
                        var26.append("_E is already set. Not setting it again [").append(var25).append(", ").append(var28).append("]").toString()
                     );
                  }
               } catch (Exception var17) {
                  Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var17);
               }
            } else {
               try {
                  a(var41, var0, var1, var27, var3, 1);
               } catch (Exception var16) {
                  Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var16);
               }
            }
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void a(AppMeasurement var0, Context var1, String var2, zzfku var3, zzb var4, int var5) {
      if (Log.isLoggable("FirebaseAbtUtil", 2)) {
         String var7 = var3.a;
         String var8 = var3.b;
         Log.v(
            "FirebaseAbtUtil",
            new StringBuilder(String.valueOf(var7).length() + 7 + String.valueOf(var8).length())
               .append("_SEI: ")
               .append(var7)
               .append(" ")
               .append(var8)
               .toString()
         );
      }

      List var38;
      label109: {
         label102: {
            try {
               Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
               var38 = a(var0, var2);
               var5 = b(var0, var2);
               if (a(var0, var2).size() < var5) {
                  break label109;
               }

               if (var3.l != 0) {
                  var5 = var3.l;
                  break label102;
               }
            } catch (Exception var20) {
               Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var20);
               return;
            }

            var5 = 1;
         }

         if (var5 != 1) {
            try {
               if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                  String var21 = var3.a;
                  var2 = var3.b;
                  var5 = String.valueOf(var21).length();
                  int var6 = String.valueOf(var2).length();
                  StringBuilder var24 = new StringBuilder(var5 + 44 + var6);
                  Log.v(
                     "FirebaseAbtUtil",
                     var24.append("_E won't be set due to overflow policy. [").append(var21).append(", ").append(var2).append("]").toString()
                  );
                  return;
               }
            } catch (Exception var14) {
               Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var14);
            }

            return;
         }

         String var40;
         String var42;
         try {
            Object var9 = var38.get(0);
            var40 = a(var9);
            var42 = b(var9);
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
               var5 = String.valueOf(var40).length();
               StringBuilder var10 = new StringBuilder(var5 + 38);
               Log.v("FirebaseAbtUtil", var10.append("Clearing _E due to overflow policy: [").append(var40).append("]").toString());
            }
         } catch (Exception var19) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var19);
            return;
         }

         try {
            a(var1, var2, var40, var42, a(var3, var4));
         } catch (Exception var18) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var18);
            return;
         }
      }

      try {
         var39 = var38.iterator();
      } catch (Exception var16) {
         Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var16);
         return;
      }

      while (true) {
         try {
            if (!var39.hasNext()) {
               break;
            }

            String var43 = (String)var39.next();
            String var41 = a(var43);
            var43 = b(var43);
            if (var41.equals(var3.a) && !var43.equals(var3.b) && Log.isLoggable("FirebaseAbtUtil", 2)) {
               int var36 = String.valueOf(var41).length();
               var5 = String.valueOf(var43).length();
               StringBuilder var45 = new StringBuilder(var36 + 77 + var5);
               Log.v(
                  "FirebaseAbtUtil",
                  var45.append("Clearing _E, as only one _V of the same _E can be set atany given time: [")
                     .append(var41)
                     .append(", ")
                     .append(var43)
                     .append("].")
                     .toString()
               );
               a(var1, var2, var41, var43, a(var3, var4));
            }
         } catch (Exception var17) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var17);
            return;
         }
      }

      try {
         var25 = a(var3, var2, var4);
      } catch (Exception var15) {
         Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var15);
         return;
      }

      if (var25 == null) {
         try {
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
               String var22 = var3.a;
               String var26 = var3.b;
               var5 = String.valueOf(var22).length();
               int var37 = String.valueOf(var26).length();
               StringBuilder var28 = new StringBuilder(var5 + 42 + var37);
               Log.v("FirebaseAbtUtil", var28.append("Could not create _CUP for: [").append(var22).append(", ").append(var26).append("]. Skipping.").toString());
            }
         } catch (Exception var13) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var13);
         }
      } else {
         try {
            Method var29 = AppMeasurement.class
               .getDeclaredMethod("setConditionalUserProperty", Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty"));
            var29.setAccessible(true);
            var29.invoke(var0, var25);
         } catch (Exception var12) {
            Exception var23 = var12;

            try {
               Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var23);
            } catch (Exception var11) {
               Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var11);
            }
         }
      }
   }

   private static int b(AppMeasurement var0, String var1) {
      int var2;
      try {
         Method var3 = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", String.class);
         var3.setAccessible(true);
         var2 = (Integer)var3.invoke(var0, var1);
      } catch (Exception var4) {
         Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", var4);
         var2 = 20;
      }

      return var2;
   }

   private static String b(Object var0) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
      return (String)Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(var0);
   }

   private static boolean b(Context var0) {
      boolean var2 = false;
      boolean var1;
      if (a(var0) == null) {
         var1 = var2;
         if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            var1 = var2;
         }
      } else {
         try {
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
         } catch (ClassNotFoundException var3) {
            var1 = var2;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
               Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
               var1 = var2;
            }

            return var1;
         }

         var1 = true;
      }

      return var1;
   }
}
