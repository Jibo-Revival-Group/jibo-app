package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
public final class DataHolder extends zzbfm implements Closeable {
   public static final Creator<DataHolder> CREATOR = new zzf();
   private static final DataHolder.zza k = new zze(new String[0], null);
   int a;
   private int b;
   private final String[] c;
   private Bundle d;
   private final CursorWindow[] e;
   private final int f;
   private final Bundle g;
   private int[] h;
   private boolean i = false;
   private boolean j = true;

   DataHolder(int var1, String[] var2, CursorWindow[] var3, int var4, Bundle var5) {
      this.b = var1;
      this.c = var2;
      this.e = var3;
      this.f = var4;
      this.g = var5;
   }

   private DataHolder(DataHolder.zza var1, int var2, Bundle var3) {
      this(var1.a, a(var1, -1), var2, null);
   }

   private DataHolder(String[] var1, CursorWindow[] var2, int var3, Bundle var4) {
      this.b = 1;
      this.c = zzbq.a(var1);
      this.e = zzbq.a(var2);
      this.f = var3;
      this.g = var4;
      this.a();
   }

   private final void a(String var1, int var2) {
      if (this.d == null || !this.d.containsKey(var1)) {
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var1 = "No such column: ".concat(var1);
         } else {
            var1 = new String("No such column: ");
         }

         throw new IllegalArgumentException(var1);
      } else if (this.d()) {
         throw new IllegalArgumentException("Buffer is closed.");
      } else if (var2 < 0 || var2 >= this.a) {
         throw new CursorIndexOutOfBoundsException(var2, this.a);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static CursorWindow[] a(DataHolder.zza var0, int var1) {
      byte var4 = 0;
      CursorWindow[] var33;
      if (var0.a.length == 0) {
         var33 = new CursorWindow[0];
      } else {
         ArrayList var12 = var0.b;
         int var5 = var12.size();
         CursorWindow var10 = new CursorWindow(false);
         ArrayList var11 = new ArrayList();
         var11.add(var10);
         var10.setNumColumns(var0.a.length);
         var1 = 0;
         int var2 = 0;

         while (true) {
            if (var1 >= var5) {
               var33 = var11.toArray(new CursorWindow[var11.size()]);
               break;
            }

            CursorWindow var9 = var10;

            int var43;
            label197: {
               label198: {
                  label199: {
                     try {
                        if (var10.allocRow()) {
                           break label199;
                        }

                        StringBuilder var44 = new StringBuilder(72);
                        Log.d("DataHolder", var44.append("Allocating additional cursor window for large data set (row ").append(var1).append(")").toString());
                        var10 = new CursorWindow(false);
                        var10.setStartPosition(var1);
                        var10.setNumColumns(var0.a.length);
                        var11.add(var10);
                     } catch (RuntimeException var31) {
                        var32 = var31;
                        var2 = var11.size();
                        var1 = var4;
                        break label198;
                     }

                     var9 = var10;

                     try {
                        if (!var10.allocRow()) {
                           Log.e("DataHolder", "Unable to allocate row to hold data.");
                           var11.remove(var10);
                           var33 = var11.toArray(new CursorWindow[var11.size()]);
                           break;
                        }
                     } catch (RuntimeException var30) {
                        var32 = var30;
                        var2 = var11.size();
                        var1 = var4;
                        break label198;
                     }
                  }

                  Map var14;
                  try {
                     var14 = (Map)var12.get(var1);
                  } catch (RuntimeException var29) {
                     var32 = var29;
                     var2 = var11.size();
                     var1 = var4;
                     break label198;
                  }

                  var43 = 0;
                  boolean var6 = true;

                  while (true) {
                     try {
                        if (var43 >= var0.a.length) {
                           break;
                        }
                     } catch (RuntimeException var28) {
                        var32 = var28;
                        var2 = var11.size();
                        var1 = var4;
                        break label198;
                     }

                     if (!var6) {
                        break;
                     }

                     Object var13;
                     try {
                        var47 = var0.a[var43];
                        var13 = var14.get(var47);
                     } catch (RuntimeException var20) {
                        var32 = var20;
                        var2 = var11.size();
                        var1 = var4;
                        break label198;
                     }

                     if (var13 == null) {
                        try {
                           var6 = var9.putNull(var1, var43);
                        } catch (RuntimeException var19) {
                           var32 = var19;
                           var2 = var11.size();
                           var1 = var4;
                           break label198;
                        }
                     } else {
                        label204: {
                           try {
                              if (var13 instanceof String) {
                                 var6 = var9.putString((String)var13, var1, var43);
                                 break label204;
                              }
                           } catch (RuntimeException var23) {
                              var32 = var23;
                              var2 = var11.size();
                              var1 = var4;
                              break label198;
                           }

                           try {
                              if (var13 instanceof Long) {
                                 var6 = var9.putLong((Long)var13, var1, var43);
                                 break label204;
                              }
                           } catch (RuntimeException var27) {
                              var32 = var27;
                              var2 = var11.size();
                              var1 = var4;
                              break label198;
                           }

                           try {
                              if (var13 instanceof Integer) {
                                 var6 = var9.putLong(((Integer)var13).intValue(), var1, var43);
                                 break label204;
                              }
                           } catch (RuntimeException var22) {
                              var32 = var22;
                              var2 = var11.size();
                              var1 = var4;
                              break label198;
                           }

                           long var7;
                           label202: {
                              label152: {
                                 label151: {
                                    try {
                                       if (!(var13 instanceof Boolean)) {
                                          break label152;
                                       }

                                       if ((Boolean)var13) {
                                          break label151;
                                       }
                                    } catch (RuntimeException var26) {
                                       var32 = var26;
                                       var2 = var11.size();
                                       var1 = var4;
                                       break label198;
                                    }

                                    var7 = 0L;
                                    break label202;
                                 }

                                 var7 = 1L;
                                 break label202;
                              }

                              try {
                                 if (var13 instanceof byte[]) {
                                    var6 = var9.putBlob((byte[])var13, var1, var43);
                                    break label204;
                                 }
                              } catch (RuntimeException var25) {
                                 var32 = var25;
                                 var2 = var11.size();
                                 var1 = var4;
                                 break label198;
                              }

                              try {
                                 if (var13 instanceof Double) {
                                    var6 = var9.putDouble((Double)var13, var1, var43);
                                    break label204;
                                 }
                              } catch (RuntimeException var21) {
                                 var32 = var21;
                                 var2 = var11.size();
                                 var1 = var4;
                                 break label198;
                              }

                              try {
                                 if (var13 instanceof Float) {
                                    var6 = var9.putDouble(((Float)var13).floatValue(), var1, var43);
                                    break label204;
                                 }
                              } catch (RuntimeException var24) {
                                 var32 = var24;
                                 var2 = var11.size();
                                 var1 = var4;
                                 break label198;
                              }

                              try {
                                 String var49 = String.valueOf(var13);
                                 var1 = String.valueOf(var47).length();
                                 var2 = String.valueOf(var49).length();
                                 StringBuilder var45 = new StringBuilder(var1 + 32 + var2);
                                 IllegalArgumentException var34 = new IllegalArgumentException(
                                    var45.append("Unsupported object for column ").append(var47).append(": ").append(var49).toString()
                                 );
                                 throw var34;
                              } catch (RuntimeException var15) {
                                 var32 = var15;
                                 var2 = var11.size();
                                 var1 = var4;
                                 break label198;
                              }
                           }

                           try {
                              var6 = var9.putLong(var7, var1, var43);
                           } catch (RuntimeException var18) {
                              var32 = var18;
                              var2 = var11.size();
                              var1 = var4;
                              break label198;
                           }
                        }
                     }

                     var43++;
                  }

                  if (var6) {
                     boolean var42 = false;
                     var43 = var1;
                     var39 = var42;
                     break label197;
                  }

                  if (var2) {
                     try {
                        DataHolder.zzb var35 = new DataHolder.zzb(
                           "Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle."
                        );
                        throw var35;
                     } catch (RuntimeException var16) {
                        var32 = var16;
                        var2 = var11.size();
                        var1 = var4;
                     }
                  } else {
                     label114: {
                        try {
                           StringBuilder var48 = new StringBuilder(74);
                           Log.d(
                              "DataHolder", var48.append("Couldn't populate window data for row ").append(var1).append(" - allocating new window.").toString()
                           );
                           var9.freeLastRow();
                           var9 = new CursorWindow(false);
                           var9.setStartPosition(var1);
                           var9.setNumColumns(var0.a.length);
                           var11.add(var9);
                        } catch (RuntimeException var17) {
                           var32 = var17;
                           var2 = var11.size();
                           var1 = var4;
                           break label114;
                        }

                        var43 = var1 - 1;
                        var39 = true;
                        break label197;
                     }
                  }
               }

               while (var1 < var2) {
                  ((CursorWindow)var11.get(var1)).close();
                  var1++;
               }

               throw var32;
            }

            var2 = var39;
            var1 = var43 + 1;
            var10 = var9;
         }
      }

      return var33;
   }

   public static DataHolder b(int var0) {
      return new DataHolder(k, var0, null);
   }

   public final int a(int var1) {
      int var3 = 0;
      boolean var4;
      if (var1 >= 0 && var1 < this.a) {
         var4 = true;
      } else {
         var4 = false;
      }

      zzbq.a(var4);

      int var2;
      while (true) {
         var2 = var3;
         if (var3 >= this.h.length) {
            break;
         }

         if (var1 < this.h[var3]) {
            var2 = var3 - 1;
            break;
         }

         var3++;
      }

      var1 = var2;
      if (var2 == this.h.length) {
         var1 = var2 - 1;
      }

      return var1;
   }

   public final int a(String var1, int var2, int var3) {
      this.a(var1, var2);
      return this.e[var3].getInt(var2, this.d.getInt(var1));
   }

   public final void a() {
      int var2 = 0;
      this.d = new Bundle();

      for (int var1 = 0; var1 < this.c.length; var1++) {
         this.d.putInt(this.c[var1], var1);
      }

      this.h = new int[this.e.length];
      int var3 = 0;
      int var4 = var2;
      var2 = var3;

      while (var4 < this.e.length) {
         this.h[var4] = var2;
         var3 = this.e[var4].getStartPosition();
         var2 += this.e[var4].getNumRows() - (var2 - var3);
         var4++;
      }

      this.a = var2;
   }

   public final boolean a(String var1) {
      return this.d.containsKey(var1);
   }

   public final int b() {
      return this.f;
   }

   public final String b(String var1, int var2, int var3) {
      this.a(var1, var2);
      return this.e[var3].getString(var2, this.d.getInt(var1));
   }

   public final float c(String var1, int var2, int var3) {
      this.a(var1, var2);
      return this.e[var3].getFloat(var2, this.d.getInt(var1));
   }

   public final Bundle c() {
      return this.g;
   }

   @Override
   public final void close() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/data/DataHolder.i Z
      // 06: ifne 28
      // 09: aload 0
      // 0a: bipush 1
      // 0b: putfield com/google/android/gms/common/data/DataHolder.i Z
      // 0e: bipush 0
      // 0f: istore 1
      // 10: iload 1
      // 11: aload 0
      // 12: getfield com/google/android/gms/common/data/DataHolder.e [Landroid/database/CursorWindow;
      // 15: arraylength
      // 16: if_icmpge 28
      // 19: aload 0
      // 1a: getfield com/google/android/gms/common/data/DataHolder.e [Landroid/database/CursorWindow;
      // 1d: iload 1
      // 1e: aaload
      // 1f: invokevirtual android/database/CursorWindow.close ()V
      // 22: iinc 1 1
      // 25: goto 10
      // 28: aload 0
      // 29: monitorexit
      // 2a: return
      // 2b: astore 2
      // 2c: aload 0
      // 2d: monitorexit
      // 2e: aload 2
      // 2f: athrow
      // try (2 -> 8): 25 null
      // try (10 -> 20): 25 null
      // try (22 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   public final boolean d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 0: aload 0
      // 1: monitorenter
      // 2: aload 0
      // 3: getfield com/google/android/gms/common/data/DataHolder.i Z
      // 6: istore 1
      // 7: aload 0
      // 8: monitorexit
      // 9: iload 1
      // a: ireturn
      // b: astore 2
      // c: aload 0
      // d: monitorexit
      // e: aload 2
      // f: athrow
      // try (2 -> 7): 9 null
      // try (10 -> 12): 9 null
   }

   public final byte[] d(String var1, int var2, int var3) {
      this.a(var1, var2);
      return this.e[var3].getBlob(var2, this.d.getInt(var1));
   }

   public final boolean e(String var1, int var2, int var3) {
      this.a(var1, var2);
      return this.e[var3].isNull(var2, this.d.getInt(var1));
   }

   @Override
   protected final void finalize() throws Throwable {
      try {
         if (this.j && this.e.length > 0 && !this.d()) {
            this.close();
            String var3 = this.toString();
            int var1 = String.valueOf(var3).length();
            StringBuilder var2 = new StringBuilder(var1 + 178);
            Log.e(
               "DataBuffer",
               var2.append(
                     "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: "
                  )
                  .append(var3)
                  .append(")")
                  .toString()
            );
         }
      } finally {
         super.finalize();
      }
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.c, false);
      zzbfp.a(var1, 2, this.e, var2, false);
      zzbfp.a(var1, 3, this.f);
      zzbfp.a(var1, 4, this.g, false);
      zzbfp.a(var1, 1000, this.b);
      zzbfp.a(var1, var3);
      if ((var2 & 1) != 0) {
         this.close();
      }
   }

   public static class zza {
      private final String[] a;
      private final ArrayList<HashMap<String, Object>> b;
      private final String c;
      private final HashMap<Object, Integer> d;
      private boolean e;
      private String f;

      private zza(String[] var1, String var2) {
         this.a = zzbq.a(var1);
         this.b = new ArrayList<>();
         this.c = var2;
         this.d = new HashMap<>();
         this.e = false;
         this.f = null;
      }
   }

   public static final class zzb extends RuntimeException {
      public zzb(String var1) {
         super(var1);
      }
   }
}
