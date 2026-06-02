package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.util.MPLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

public class Tweaks {
   private final ConcurrentMap<String, Tweaks.TweakValue> a = new ConcurrentHashMap<>();
   private final ConcurrentMap<String, Tweaks.TweakValue> b = new ConcurrentHashMap<>();
   private final List<Tweaks.OnTweakDeclaredListener> c = new ArrayList<>();

   Tweaks() {
   }

   public Map<String, Tweaks.TweakValue> a() {
      synchronized (this) {
         return new HashMap<>(this.a);
      }
   }

   public void a(Tweaks.OnTweakDeclaredListener param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 1
      // 03: ifnonnull 17
      // 06: new java/lang/NullPointerException
      // 09: astore 1
      // 0a: aload 1
      // 0b: ldc "listener cannot be null"
      // 0d: invokespecial java/lang/NullPointerException.<init> (Ljava/lang/String;)V
      // 10: aload 1
      // 11: athrow
      // 12: astore 1
      // 13: aload 0
      // 14: monitorexit
      // 15: aload 1
      // 16: athrow
      // 17: aload 0
      // 18: getfield com/mixpanel/android/mpmetrics/Tweaks.c Ljava/util/List;
      // 1b: aload 1
      // 1c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 21: pop
      // 22: aload 0
      // 23: monitorexit
      // 24: return
      // try (4 -> 11): 11 null
      // try (16 -> 21): 11 null
   }

   public void a(String var1, Object var2) {
      synchronized (this) {
         if (!this.a.containsKey(var1)) {
            var2 = new StringBuilder();
            MPLog.d("MixpanelAPI.Tweaks", var2.append("Attempt to set a tweak \"").append(var1).append("\" which has never been defined.").toString());
         } else {
            Tweaks.TweakValue var6 = this.a.get(var1).a(var2);
            this.a.put(var1, var6);
         }
      }
   }

   public void a(String var1, Object var2, Number var3, Number var4, int var5) {
      if (this.a.containsKey(var1)) {
         MPLog.d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + var1 + "\" twice with the same name");
      } else {
         var2 = new Tweaks.TweakValue(var5, var2, var3, var4, var2, var1);
         this.a.put(var1, (Tweaks.TweakValue)var2);
         this.b.put(var1, (Tweaks.TweakValue)var2);
         int var6 = this.c.size();

         for (int var8 = 0; var8 < var6; var8++) {
            this.c.get(var8).a();
         }
      }
   }

   public Map<String, Tweaks.TweakValue> b() {
      synchronized (this) {
         return new HashMap<>(this.b);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean b(String var1, Object var2) {
      boolean var3 = false;
      synchronized (this){} // $VF: monitorenter 
      boolean var5 = false /* VF: Semaphore variable */;

      label38: {
         try {
            var5 = true;
            if (!this.a.containsKey(var1)) {
               var2 = new StringBuilder();
               MPLog.d("MixpanelAPI.Tweaks", var2.append("Attempt to reference a tweak \"").append(var1).append("\" which has never been defined.").toString());
               var5 = false;
               break label38;
            }

            var3 = this.a.get(var1).b.equals(var2);
            var5 = false;
         } finally {
            if (var5) {
               // $VF: monitorexit
            }
         }

         if (!var3) {
            var3 = true;
         } else {
            var3 = false;
         }
      }

      // $VF: monitorexit
      return var3;
   }

   public interface OnTweakDeclaredListener {
      void a();
   }

   public static class TweakValue {
      public final int a;
      private final Object b;
      private final Object c;
      private final Number d;
      private final Number e;
      private final String f;

      private TweakValue(int var1, Object var2, Number var3, Number var4, Object var5, String var6) {
         this.a = var1;
         this.f = var6;
         this.d = var3;
         this.e = var4;
         Object var9 = var2;
         Object var8 = var5;
         if (this.d != null) {
            var9 = var2;
            var8 = var5;
            if (this.e != null) {
               Object var7 = var2;
               if (!this.b(var2)) {
                  var7 = Math.min(Math.max(((Number)var2).longValue(), this.d.longValue()), this.e.longValue());
                  MPLog.d(
                     "MixpanelAPI.Tweaks",
                     "Attempt to define a tweak \""
                        + this.f
                        + "\" with default value "
                        + var7
                        + " out of its bounds ["
                        + this.d
                        + ", "
                        + this.e
                        + "]Tweak \""
                        + this.f
                        + "\" new default value: "
                        + var7
                        + "."
                  );
               }

               var9 = var7;
               var8 = var5;
               if (!this.b(var5)) {
                  var8 = Math.min(Math.max(((Number)var5).longValue(), this.d.longValue()), this.e.longValue());
                  MPLog.d(
                     "MixpanelAPI.Tweaks",
                     "Attempt to define a tweak \""
                        + this.f
                        + "\" with value "
                        + var7
                        + " out of its bounds ["
                        + this.d
                        + ", "
                        + this.e
                        + "]Tweak \""
                        + this.f
                        + "\" new value: "
                        + var8
                        + "."
                  );
                  var9 = var7;
               }
            }
         }

         this.c = var9;
         this.b = var8;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public static Tweaks.TweakValue a(JSONObject var0) {
         Object var9 = null;

         byte var1;
         Serializable var5;
         String var10;
         Number var26;
         Number var29;
         label127: {
            label133: {
               label125: {
                  byte var24;
                  Double var32;
                  Double var33;
                  label124: {
                     label123: {
                        Number var6;
                        label134: {
                           label135: {
                              try {
                                 var10 = var0.getString("name");
                                 var4 = var0.getString("type");
                                 if (!"number".equals(var4)) {
                                    break label125;
                                 }

                                 var27 = var0.getString("encoding");
                                 if ("d".equals(var27)) {
                                    break label135;
                                 }
                              } catch (JSONException var21) {
                                 return (Tweaks.TweakValue)var9;
                              }

                              Object var3 = var9;

                              try {
                                 if (!"l".equals(var27)) {
                                    return (Tweaks.TweakValue)var3;
                                 }

                                 var7 = var0.getLong("value");
                              } catch (JSONException var15) {
                                 var3 = var9;
                                 return (Tweaks.TweakValue)var3;
                              }

                              var24 = 3;

                              label113: {
                                 try {
                                    var8 = var0.getLong("default");
                                    if (!var0.isNull("minimum")) {
                                       var29 = var0.getLong("minimum");
                                       break label113;
                                    }
                                 } catch (JSONException var20) {
                                    var3 = var9;
                                    return (Tweaks.TweakValue)var3;
                                 }

                                 var29 = null;
                              }

                              var26 = var8;
                              var5 = var7;
                              var1 = var24;
                              var6 = var29;

                              try {
                                 if (!var0.isNull("maximum")) {
                                    var22 = var0.getLong("maximum");
                                    break label123;
                                 }
                                 break label134;
                              } catch (JSONException var19) {
                                 var3 = var9;
                                 return (Tweaks.TweakValue)var3;
                              }
                           }

                           var24 = 2;

                           label101: {
                              try {
                                 var33 = var0.getDouble("value");
                                 var32 = var0.getDouble("default");
                                 if (!var0.isNull("minimum")) {
                                    var29 = var0.getDouble("minimum");
                                    break label101;
                                 }
                              } catch (JSONException var18) {
                                 Object var37 = var9;
                                 return (Tweaks.TweakValue)var37;
                              }

                              var29 = null;
                           }

                           var26 = var32;
                           var5 = var33;
                           var1 = var24;
                           var6 = var29;

                           try {
                              if (!var0.isNull("maximum")) {
                                 var22 = var0.getDouble("maximum");
                                 break label124;
                              }
                           } catch (JSONException var17) {
                              Object var38 = var9;
                              return (Tweaks.TweakValue)var38;
                           }
                        }

                        var22 = null;
                        var29 = var6;
                        break label133;
                     }

                     var26 = var8;
                     var5 = var7;
                     var1 = var24;
                     break label133;
                  }

                  var1 = var24;
                  var5 = var33;
                  var26 = var32;
                  break label133;
               }

               label136: {
                  try {
                     if (!"boolean".equals(var4)) {
                        break label136;
                     }
                  } catch (JSONException var16) {
                     Object var39 = var9;
                     return (Tweaks.TweakValue)var39;
                  }

                  var1 = 1;

                  try {
                     var5 = var0.getBoolean("value");
                     var23 = var0.getBoolean("default");
                  } catch (JSONException var14) {
                     Object var40 = var9;
                     return (Tweaks.TweakValue)var40;
                  }

                  var29 = null;
                  var26 = null;
                  break label127;
               }

               Object var41 = var9;

               try {
                  if (!"string".equals(var4)) {
                     return (Tweaks.TweakValue)var41;
                  }
               } catch (JSONException var13) {
                  var41 = var9;
                  return (Tweaks.TweakValue)var41;
               }

               var1 = 4;

               try {
                  var5 = var0.getString("value");
                  var23 = var0.getString("default");
               } catch (JSONException var12) {
                  var41 = var9;
                  return (Tweaks.TweakValue)var41;
               }

               var29 = null;
               var26 = null;
               break label127;
            }

            Number var30 = var26;
            var26 = var29;
            var29 = var22;
            var23 = var30;
         }

         Tweaks.TweakValue var31;
         try {
            var31 = new Tweaks.TweakValue(var1, var23, var26, var29, var5, var10);
         } catch (JSONException var11) {
            Object var44 = var9;
            return (Tweaks.TweakValue)var44;
         }

         return var31;
      }

      private boolean b(Object var1) {
         long var2;
         long var4;
         try {
            var1 = var1;
            if (Math.min(Math.max(var1.longValue(), this.d.longValue()), this.e.longValue()) == this.d.longValue()) {
               return false;
            }

            var4 = Math.min(Math.max(var1.longValue(), this.d.longValue()), this.e.longValue());
            var2 = this.e.longValue();
         } catch (ClassCastException var7) {
            return true;
         }

         return var4 != var2;
      }

      public Tweaks.TweakValue a(Object var1) {
         return new Tweaks.TweakValue(this.a, this.c, this.d, this.e, var1, this.f);
      }

      public String a() {
         String var1 = null;

         label21: {
            String var2;
            try {
               var2 = (String)this.c;
            } catch (ClassCastException var4) {
               break label21;
            }

            var1 = var2;
         }

         String var5;
         try {
            var5 = (String)this.b;
         } catch (ClassCastException var3) {
            return var1;
         }

         return var5;
      }

      public Number b() {
         Integer var2 = 0;
         Number var1 = var2;
         if (this.c != null) {
            try {
               var1 = (Number)this.c;
            } catch (ClassCastException var4) {
               var1 = var2;
            }
         }

         Number var5 = var1;
         if (this.b != null) {
            try {
               var5 = (Number)this.b;
            } catch (ClassCastException var3) {
               var5 = var1;
            }
         }

         return var5;
      }

      public Boolean c() {
         Boolean var2 = false;
         Boolean var1 = var2;
         if (this.c != null) {
            try {
               var1 = (Boolean)this.c;
            } catch (ClassCastException var4) {
               var1 = var2;
            }
         }

         var2 = var1;
         if (this.b != null) {
            try {
               var2 = (Boolean)this.b;
            } catch (ClassCastException var3) {
               var2 = var1;
            }
         }

         return var2;
      }

      public Number d() {
         return this.d;
      }

      public Number e() {
         return this.e;
      }

      public Object f() {
         return this.c;
      }

      public Object g() {
         return this.b;
      }
   }
}
