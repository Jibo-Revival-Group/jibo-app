package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzchk extends zzcjl {
   private static String[] a = new String[AppMeasurement.Event.a.length];
   private static String[] b = new String[AppMeasurement.Param.a.length];
   private static String[] c = new String[AppMeasurement.UserProperty.a.length];

   zzchk(zzcim var1) {
      super(var1);
   }

   private final String a(zzcgx var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else if (!this.y()) {
         var2 = var1.toString();
      } else {
         var2 = this.a(var1.b());
      }

      return var2;
   }

   private static String a(String param0, String[] param1, String[] param2, String[] param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 6
      // 03: bipush 0
      // 04: istore 4
      // 06: aload 1
      // 07: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 0a: pop
      // 0b: aload 2
      // 0c: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: pop
      // 10: aload 3
      // 11: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 14: pop
      // 15: aload 1
      // 16: arraylength
      // 17: aload 2
      // 18: arraylength
      // 19: if_icmpne 8d
      // 1c: bipush 1
      // 1d: istore 5
      // 1f: iload 5
      // 21: invokestatic com/google/android/gms/common/internal/zzbq.b (Z)V
      // 24: aload 1
      // 25: arraylength
      // 26: aload 3
      // 27: arraylength
      // 28: if_icmpne 93
      // 2b: iload 6
      // 2d: istore 5
      // 2f: iload 5
      // 31: invokestatic com/google/android/gms/common/internal/zzbq.b (Z)V
      // 34: aload 0
      // 35: astore 7
      // 37: iload 4
      // 39: aload 1
      // 3a: arraylength
      // 3b: if_icmpge 8a
      // 3e: aload 0
      // 3f: aload 1
      // 40: iload 4
      // 42: aaload
      // 43: invokestatic com/google/android/gms/internal/zzclq.a (Ljava/lang/String;Ljava/lang/String;)Z
      // 46: ifeq 9e
      // 49: aload 3
      // 4a: monitorenter
      // 4b: aload 3
      // 4c: iload 4
      // 4e: aaload
      // 4f: ifnonnull 82
      // 52: new java/lang/StringBuilder
      // 55: astore 0
      // 56: aload 0
      // 57: invokespecial java/lang/StringBuilder.<init> ()V
      // 5a: aload 0
      // 5b: aload 2
      // 5c: iload 4
      // 5e: aaload
      // 5f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 62: pop
      // 63: aload 0
      // 64: ldc "("
      // 66: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 69: pop
      // 6a: aload 0
      // 6b: aload 1
      // 6c: iload 4
      // 6e: aaload
      // 6f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 72: pop
      // 73: aload 0
      // 74: ldc ")"
      // 76: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 79: pop
      // 7a: aload 3
      // 7b: iload 4
      // 7d: aload 0
      // 7e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 81: aastore
      // 82: aload 3
      // 83: iload 4
      // 85: aaload
      // 86: astore 7
      // 88: aload 3
      // 89: monitorexit
      // 8a: aload 7
      // 8c: areturn
      // 8d: bipush 0
      // 8e: istore 5
      // 90: goto 1f
      // 93: bipush 0
      // 94: istore 5
      // 96: goto 2f
      // 99: astore 0
      // 9a: aload 3
      // 9b: monitorexit
      // 9c: aload 0
      // 9d: athrow
      // 9e: iinc 4 1
      // a1: goto 34
      // try (49 -> 78): 92 null
      // try (82 -> 84): 92 null
      // try (93 -> 95): 92 null
   }

   private static void a(StringBuilder var0, int var1) {
      for (int var2 = 0; var2 < var1; var2++) {
         var0.append("  ");
      }
   }

   private final void a(StringBuilder var1, int var2, zzclt var3) {
      if (var3 != null) {
         a(var1, var2);
         var1.append("filter {\n");
         a(var1, var2, "complement", var3.c);
         a(var1, var2, "param_name", this.b(var3.d));
         int var6 = var2 + 1;
         zzclw var8 = var3.a;
         if (var8 != null) {
            a(var1, var6);
            var1.append("string_filter");
            var1.append(" {\n");
            if (var8.a != null) {
               String var7 = "UNKNOWN_MATCH_TYPE";
               switch (var8.a) {
                  case 1:
                     var7 = "REGEXP";
                     break;
                  case 2:
                     var7 = "BEGINS_WITH";
                     break;
                  case 3:
                     var7 = "ENDS_WITH";
                     break;
                  case 4:
                     var7 = "PARTIAL";
                     break;
                  case 5:
                     var7 = "EXACT";
                     break;
                  case 6:
                     var7 = "IN_LIST";
               }

               a(var1, var6, "match_type", var7);
            }

            a(var1, var6, "expression", var8.b);
            a(var1, var6, "case_sensitive", var8.c);
            if (var8.d.length > 0) {
               a(var1, var6 + 1);
               var1.append("expression_list {\n");

               for (String var10 : var8.d) {
                  a(var1, var6 + 2);
                  var1.append(var10);
                  var1.append("\n");
               }

               var1.append("}\n");
            }

            a(var1, var6);
            var1.append("}\n");
         }

         this.a(var1, var2 + 1, "number_filter", var3.b);
         a(var1, var2);
         var1.append("}\n");
      }
   }

   private final void a(StringBuilder var1, int var2, String var3, zzclu var4) {
      if (var4 != null) {
         a(var1, var2);
         var1.append(var3);
         var1.append(" {\n");
         if (var4.a != null) {
            var3 = "UNKNOWN_COMPARISON_TYPE";
            switch (var4.a) {
               case 1:
                  var3 = "LESS_THAN";
                  break;
               case 2:
                  var3 = "GREATER_THAN";
                  break;
               case 3:
                  var3 = "EQUAL";
                  break;
               case 4:
                  var3 = "BETWEEN";
            }

            a(var1, var2, "comparison_type", var3);
         }

         a(var1, var2, "match_as_float", var4.b);
         a(var1, var2, "comparison_value", var4.c);
         a(var1, var2, "min_comparison_value", var4.d);
         a(var1, var2, "max_comparison_value", var4.e);
         a(var1, var2);
         var1.append("}\n");
      }
   }

   private static void a(StringBuilder var0, int var1, String var2, zzcmf var3) {
      byte var5 = 0;
      if (var3 != null) {
         int var6 = var1 + 1;
         a(var0, var6);
         var0.append(var2);
         var0.append(" {\n");
         if (var3.b != null) {
            a(var0, var6 + 1);
            var0.append("results: ");
            long[] var12 = var3.b;
            int var7 = var12.length;
            int var4 = 0;

            for (int var10 = 0; var4 < var7; var10++) {
               long var8 = var12[var4];
               if (var10 != 0) {
                  var0.append(", ");
               }

               var0.append(Long.valueOf(var8));
               var4++;
            }

            var0.append('\n');
         }

         if (var3.a != null) {
            a(var0, var6 + 1);
            var0.append("status: ");
            long[] var13 = var3.a;
            int var15 = var13.length;
            var1 = 0;

            for (int var14 = var5; var14 < var15; var1++) {
               long var16 = var13[var14];
               if (var1 != 0) {
                  var0.append(", ");
               }

               var0.append(Long.valueOf(var16));
               var14++;
            }

            var0.append('\n');
         }

         a(var0, var6);
         var0.append("}\n");
      }
   }

   private static void a(StringBuilder var0, int var1, String var2, Object var3) {
      if (var3 != null) {
         a(var0, var1 + 1);
         var0.append(var2);
         var0.append(": ");
         var0.append(var3);
         var0.append('\n');
      }
   }

   private final void a(StringBuilder var1, int var2, zzcma[] var3) {
      if (var3 != null) {
         for (zzcma var5 : var3) {
            if (var5 != null) {
               a(var1, 2);
               var1.append("audience_membership {\n");
               a(var1, 2, "audience_id", var5.a);
               a(var1, 2, "new_audience", var5.d);
               a(var1, 2, "current_data", var5.b);
               a(var1, 2, "previous_data", var5.c);
               a(var1, 2);
               var1.append("}\n");
            }
         }
      }
   }

   private final void a(StringBuilder var1, int var2, zzcmb[] var3) {
      if (var3 != null) {
         for (zzcmb var7 : var3) {
            if (var7 != null) {
               a(var1, 2);
               var1.append("event {\n");
               a(var1, 2, "name", this.a(var7.b));
               a(var1, 2, "timestamp_millis", var7.c);
               a(var1, 2, "previous_timestamp_millis", var7.d);
               a(var1, 2, "count", var7.e);
               zzcmc[] var8 = var7.a;
               if (var8 != null) {
                  for (zzcmc var10 : var8) {
                     if (var10 != null) {
                        a(var1, 3);
                        var1.append("param {\n");
                        a(var1, 3, "name", this.b(var10.a));
                        a(var1, 3, "string_value", var10.b);
                        a(var1, 3, "int_value", var10.c);
                        a(var1, 3, "double_value", var10.d);
                        a(var1, 3);
                        var1.append("}\n");
                     }
                  }
               }

               a(var1, 2);
               var1.append("}\n");
            }
         }
      }
   }

   private final void a(StringBuilder var1, int var2, zzcmg[] var3) {
      if (var3 != null) {
         for (zzcmg var5 : var3) {
            if (var5 != null) {
               a(var1, 2);
               var1.append("user_property {\n");
               a(var1, 2, "set_timestamp_millis", var5.a);
               a(var1, 2, "name", this.c(var5.b));
               a(var1, 2, "string_value", var5.c);
               a(var1, 2, "int_value", var5.d);
               a(var1, 2, "double_value", var5.e);
               a(var1, 2);
               var1.append("}\n");
            }
         }
      }
   }

   private final boolean y() {
      return this.p.f().a(3);
   }

   protected final String a(Bundle var1) {
      String var5;
      if (var1 == null) {
         var5 = null;
      } else if (!this.y()) {
         var5 = var1.toString();
      } else {
         StringBuilder var2 = new StringBuilder();

         for (String var4 : var1.keySet()) {
            if (var2.length() != 0) {
               var2.append(", ");
            } else {
               var2.append("Bundle[{");
            }

            var2.append(this.b(var4));
            var2.append("=");
            var2.append(var1.get(var4));
         }

         var2.append("}]");
         var5 = var2.toString();
      }

      return var5;
   }

   protected final String a(zzcgv var1) {
      String var3;
      if (var1 == null) {
         var3 = null;
      } else if (!this.y()) {
         var3 = var1.toString();
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("Event{appId='");
         var2.append(var1.a);
         var2.append("', name='");
         var2.append(this.a(var1.b));
         var2.append("', params=");
         var2.append(this.a(var1.e));
         var2.append("}");
         var3 = var2.toString();
      }

      return var3;
   }

   protected final String a(zzcha var1) {
      String var3;
      if (var1 == null) {
         var3 = null;
      } else if (!this.y()) {
         var3 = var1.toString();
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("origin=");
         var2.append(var1.c);
         var2.append(",name=");
         var2.append(this.a(var1.a));
         var2.append(",params=");
         var2.append(this.a(var1.b));
         var3 = var2.toString();
      }

      return var3;
   }

   protected final String a(zzcls var1) {
      int var2 = 0;
      String var5;
      if (var1 == null) {
         var5 = "null";
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append("\nevent_filter {\n");
         a(var4, 0, "filter_id", var1.a);
         a(var4, 0, "event_name", this.a(var1.b));
         this.a(var4, 1, "event_count_filter", var1.d);
         var4.append("  filters {\n");
         zzclt[] var6 = var1.c;

         for (int var3 = var6.length; var2 < var3; var2++) {
            this.a(var4, 2, var6[var2]);
         }

         a(var4, 1);
         var4.append("}\n}\n");
         var5 = var4.toString();
      }

      return var5;
   }

   protected final String a(zzclv var1) {
      String var3;
      if (var1 == null) {
         var3 = "null";
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("\nproperty_filter {\n");
         a(var2, 0, "filter_id", var1.a);
         a(var2, 0, "property_name", this.c(var1.b));
         this.a(var2, 1, var1.c);
         var2.append("}\n");
         var3 = var2.toString();
      }

      return var3;
   }

   protected final String a(zzcmd var1) {
      StringBuilder var4 = new StringBuilder();
      var4.append("\nbatch {\n");
      if (var1.a != null) {
         for (zzcme var6 : var1.a) {
            if (var6 != null && var6 != null) {
               a(var4, 1);
               var4.append("bundle {\n");
               a(var4, 1, "protocol_version", var6.a);
               a(var4, 1, "platform", var6.i);
               a(var4, 1, "gmp_version", var6.q);
               a(var4, 1, "uploading_gmp_version", var6.r);
               a(var4, 1, "config_version", var6.E);
               a(var4, 1, "gmp_app_id", var6.y);
               a(var4, 1, "app_id", var6.o);
               a(var4, 1, "app_version", var6.p);
               a(var4, 1, "app_version_major", var6.C);
               a(var4, 1, "firebase_instance_id", var6.B);
               a(var4, 1, "dev_cert_hash", var6.v);
               a(var4, 1, "app_store", var6.n);
               a(var4, 1, "upload_timestamp_millis", var6.d);
               a(var4, 1, "start_timestamp_millis", var6.e);
               a(var4, 1, "end_timestamp_millis", var6.f);
               a(var4, 1, "previous_bundle_start_timestamp_millis", var6.g);
               a(var4, 1, "previous_bundle_end_timestamp_millis", var6.h);
               a(var4, 1, "app_instance_id", var6.u);
               a(var4, 1, "resettable_device_id", var6.s);
               a(var4, 1, "device_id", var6.D);
               a(var4, 1, "limited_ad_tracking", var6.t);
               a(var4, 1, "os_version", var6.j);
               a(var4, 1, "device_model", var6.k);
               a(var4, 1, "user_default_language", var6.l);
               a(var4, 1, "time_zone_offset_minutes", var6.m);
               a(var4, 1, "bundle_sequential_index", var6.w);
               a(var4, 1, "service_upload", var6.z);
               a(var4, 1, "health_monitor", var6.x);
               if (var6.F != 0L) {
                  a(var4, 1, "android_id", var6.F);
               }

               this.a(var4, 1, var6.c);
               this.a(var4, 1, var6.A);
               this.a(var4, 1, var6.b);
               a(var4, 1);
               var4.append("}\n");
            }
         }
      }

      var4.append("}\n");
      return var4.toString();
   }

   protected final String a(String var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1;
         if (this.y()) {
            var2 = a(var1, AppMeasurement.Event.b, AppMeasurement.Event.a, a);
         }
      }

      return var2;
   }

   protected final String b(String var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1;
         if (this.y()) {
            var2 = a(var1, AppMeasurement.Param.b, AppMeasurement.Param.a, b);
         }
      }

      return var2;
   }

   protected final String c(String var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1;
         if (this.y()) {
            if (var1.startsWith("_exp_")) {
               StringBuilder var3 = new StringBuilder();
               var3.append("experiment_id");
               var3.append("(");
               var3.append(var1);
               var3.append(")");
               var2 = var3.toString();
            } else {
               var2 = a(var1, AppMeasurement.UserProperty.b, AppMeasurement.UserProperty.a, c);
            }
         }
      }

      return var2;
   }

   @Override
   protected final boolean w() {
      return false;
   }
}
