package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import java.io.IOException;

final class zzaa implements Runnable {
   private final long a;
   private final WakeLock b;
   private final FirebaseInstanceId c;
   private final zzu d;

   zzaa(FirebaseInstanceId var1, zzu var2, long var3) {
      this.c = var1;
      this.d = var2;
      this.a = var3;
      this.b = ((PowerManager)this.a().getSystemService("power")).newWakeLock(1, "fiid-sync");
      this.b.setReferenceCounted(false);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean a(String var1) {
      boolean var5 = true;
      String[] var6 = var1.split("!");
      boolean var4 = var5;
      if (var6.length == 2) {
         var1 = var6[0];
         String var17 = var6[1];
         byte var3 = -1;
         byte var2 = var3;

         label122: {
            label100: {
               label99: {
                  label98: {
                     label97: {
                        label108: {
                           label109: {
                              try {
                                 switch (var1.hashCode()) {
                                    case 83:
                                       break;
                                    case 84:
                                       break label97;
                                    case 85:
                                       break label109;
                                    default:
                                       break label108;
                                 }
                              } catch (IOException var13) {
                                 var1 = String.valueOf(var13.getMessage());
                                 if (var1.length() != 0) {
                                    break label99;
                                 }
                                 break label98;
                              }

                              var2 = var3;

                              try {
                                 if (!var1.equals("S")) {
                                    break label97;
                                 }
                              } catch (IOException var12) {
                                 var1 = String.valueOf(var12.getMessage());
                                 if (var1.length() != 0) {
                                    break label99;
                                 }
                                 break label98;
                              }

                              var2 = 0;
                              break label97;
                           }

                           var2 = var3;

                           try {
                              if (!var1.equals("U")) {
                                 break label97;
                              }
                           } catch (IOException var11) {
                              var1 = String.valueOf(var11.getMessage());
                              if (var1.length() != 0) {
                                 break label99;
                              }
                              break label98;
                           }

                           var2 = 1;
                           break label97;
                        }

                        var2 = var3;
                     }

                     switch (var2) {
                        case 0:
                           try {
                              this.c.a(var17);
                           } catch (IOException var10) {
                              var1 = String.valueOf(var10.getMessage());
                              if (var1.length() != 0) {
                                 break label99;
                              }
                              break;
                           }

                           var4 = var5;

                           try {
                              if (!FirebaseInstanceId.h()) {
                                 return var4;
                              }

                              Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                              break label122;
                           } catch (IOException var9) {
                              var1 = String.valueOf(var9.getMessage());
                              if (var1.length() != 0) {
                                 break label99;
                              }
                              break;
                           }
                        case 1:
                           try {
                              this.c.b(var17);
                           } catch (IOException var8) {
                              var1 = String.valueOf(var8.getMessage());
                              if (var1.length() != 0) {
                                 break label99;
                              }
                              break;
                           }

                           var4 = var5;

                           try {
                              if (!FirebaseInstanceId.h()) {
                                 return var4;
                              }

                              Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                           } catch (IOException var7) {
                              var1 = String.valueOf(var7.getMessage());
                              if (var1.length() != 0) {
                                 break label99;
                              }
                              break;
                           }

                           var4 = var5;
                           return var4;
                        default:
                           var4 = var5;
                           return var4;
                     }
                  }

                  var1 = new String("Topic sync failed: ");
                  break label100;
               }

               var1 = "Topic sync failed: ".concat(var1);
            }

            Log.e("FirebaseInstanceId", var1);
            var4 = false;
            return var4;
         }

         var4 = var5;
      }

      return var4;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean c() {
      boolean var2 = true;
      zzz var4 = this.c.e();
      boolean var23;
      if (var4 != null && !var4.b(this.d.b())) {
         var23 = var2;
      } else {
         Exception var3;
         label85: {
            try {
               var16 = this.c.f();
            } catch (IOException var14) {
               var3 = var14;
               break label85;
            } catch (SecurityException var15) {
               var3 = var15;
               break label85;
            }

            if (var16 == null) {
               try {
                  Log.e("FirebaseInstanceId", "Token retrieval failed: null");
               } catch (IOException var6) {
                  var3 = var6;
                  break label85;
               } catch (SecurityException var7) {
                  var3 = var7;
                  break label85;
               }

               var23 = false;
            } else {
               try {
                  if (Log.isLoggable("FirebaseInstanceId", 3)) {
                     Log.d("FirebaseInstanceId", "Token successfully retrieved");
                  }
               } catch (IOException var12) {
                  var3 = var12;
                  break label85;
               } catch (SecurityException var13) {
                  var3 = var13;
                  break label85;
               }

               if (var4 != null) {
                  var23 = var2;
                  if (var4 == null) {
                     return var23;
                  }

                  var23 = var2;

                  try {
                     if (var16.equals(var4.a)) {
                        return var23;
                     }
                  } catch (IOException var10) {
                     var3 = var10;
                     break label85;
                  } catch (SecurityException var11) {
                     var3 = var11;
                     break label85;
                  }
               }

               try {
                  Context var19 = this.a();
                  Intent var20 = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                  Intent var5 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                  var5.setClass(var19, FirebaseInstanceIdReceiver.class);
                  var5.putExtra("wrapped_intent", var20);
                  var19.sendBroadcast(var5);
               } catch (IOException var8) {
                  var3 = var8;
                  break label85;
               } catch (SecurityException var9) {
                  var3 = var9;
                  break label85;
               }

               var23 = var2;
            }

            return var23;
         }

         String var17 = String.valueOf(var3.getMessage());
         String var18;
         if (var17.length() != 0) {
            var18 = "Token retrieval failed: ".concat(var17);
         } else {
            var18 = new String("Token retrieval failed: ");
         }

         Log.e("FirebaseInstanceId", var18);
         var23 = false;
      }

      return var23;
   }

   private final boolean d() {
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
      // 00: aload 0
      // 01: getfield com/google/firebase/iid/zzaa.c Lcom/google/firebase/iid/FirebaseInstanceId;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: invokestatic com/google/firebase/iid/FirebaseInstanceId.g ()Lcom/google/firebase/iid/zzy;
      // 0a: invokevirtual com/google/firebase/iid/zzy.a ()Ljava/lang/String;
      // 0d: astore 3
      // 0e: aload 3
      // 0f: ifnonnull 20
      // 12: ldc "FirebaseInstanceId"
      // 14: ldc "topic sync succeeded"
      // 16: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 19: pop
      // 1a: bipush 1
      // 1b: istore 1
      // 1c: aload 2
      // 1d: monitorexit
      // 1e: iload 1
      // 1f: ireturn
      // 20: aload 2
      // 21: monitorexit
      // 22: aload 0
      // 23: aload 3
      // 24: invokespecial com/google/firebase/iid/zzaa.a (Ljava/lang/String;)Z
      // 27: ifne 34
      // 2a: bipush 0
      // 2b: istore 1
      // 2c: goto 1e
      // 2f: astore 3
      // 30: aload 2
      // 31: monitorexit
      // 32: aload 3
      // 33: athrow
      // 34: invokestatic com/google/firebase/iid/FirebaseInstanceId.g ()Lcom/google/firebase/iid/zzy;
      // 37: aload 3
      // 38: invokevirtual com/google/firebase/iid/zzy.a (Ljava/lang/String;)Z
      // 3b: pop
      // 3c: goto 00
      // try (5 -> 8): 29 null
      // try (10 -> 14): 29 null
      // try (16 -> 18): 29 null
      // try (20 -> 22): 29 null
      // try (30 -> 32): 29 null
   }

   final Context a() {
      return this.c.b().a();
   }

   final boolean b() {
      ConnectivityManager var2 = (ConnectivityManager)this.a().getSystemService("connectivity");
      NetworkInfo var3;
      if (var2 != null) {
         var3 = var2.getActiveNetworkInfo();
      } else {
         var3 = null;
      }

      boolean var1;
      if (var3 != null && var3.isConnected()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public final void run() {
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
      // 00: bipush 1
      // 01: istore 1
      // 02: aload 0
      // 03: getfield com/google/firebase/iid/zzaa.b Landroid/os/PowerManager$WakeLock;
      // 06: invokevirtual android/os/PowerManager$WakeLock.acquire ()V
      // 09: aload 0
      // 0a: getfield com/google/firebase/iid/zzaa.c Lcom/google/firebase/iid/FirebaseInstanceId;
      // 0d: bipush 1
      // 0e: invokevirtual com/google/firebase/iid/FirebaseInstanceId.a (Z)V
      // 11: aload 0
      // 12: getfield com/google/firebase/iid/zzaa.d Lcom/google/firebase/iid/zzu;
      // 15: invokevirtual com/google/firebase/iid/zzu.a ()I
      // 18: ifeq 2f
      // 1b: iload 1
      // 1c: ifne 34
      // 1f: aload 0
      // 20: getfield com/google/firebase/iid/zzaa.c Lcom/google/firebase/iid/FirebaseInstanceId;
      // 23: bipush 0
      // 24: invokevirtual com/google/firebase/iid/FirebaseInstanceId.a (Z)V
      // 27: aload 0
      // 28: getfield com/google/firebase/iid/zzaa.b Landroid/os/PowerManager$WakeLock;
      // 2b: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // 2e: return
      // 2f: bipush 0
      // 30: istore 1
      // 31: goto 1b
      // 34: aload 0
      // 35: invokevirtual com/google/firebase/iid/zzaa.b ()Z
      // 38: ifne 52
      // 3b: new com/google/firebase/iid/zzab
      // 3e: astore 2
      // 3f: aload 2
      // 40: aload 0
      // 41: invokespecial com/google/firebase/iid/zzab.<init> (Lcom/google/firebase/iid/zzaa;)V
      // 44: aload 2
      // 45: invokevirtual com/google/firebase/iid/zzab.a ()V
      // 48: aload 0
      // 49: getfield com/google/firebase/iid/zzaa.b Landroid/os/PowerManager$WakeLock;
      // 4c: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // 4f: goto 2e
      // 52: aload 0
      // 53: invokespecial com/google/firebase/iid/zzaa.c ()Z
      // 56: ifeq 72
      // 59: aload 0
      // 5a: invokespecial com/google/firebase/iid/zzaa.d ()Z
      // 5d: ifeq 72
      // 60: aload 0
      // 61: getfield com/google/firebase/iid/zzaa.c Lcom/google/firebase/iid/FirebaseInstanceId;
      // 64: bipush 0
      // 65: invokevirtual com/google/firebase/iid/FirebaseInstanceId.a (Z)V
      // 68: aload 0
      // 69: getfield com/google/firebase/iid/zzaa.b Landroid/os/PowerManager$WakeLock;
      // 6c: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // 6f: goto 2e
      // 72: aload 0
      // 73: getfield com/google/firebase/iid/zzaa.c Lcom/google/firebase/iid/FirebaseInstanceId;
      // 76: aload 0
      // 77: getfield com/google/firebase/iid/zzaa.a J
      // 7a: invokevirtual com/google/firebase/iid/FirebaseInstanceId.a (J)V
      // 7d: goto 68
      // 80: astore 2
      // 81: aload 0
      // 82: getfield com/google/firebase/iid/zzaa.b Landroid/os/PowerManager$WakeLock;
      // 85: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // 88: aload 2
      // 89: athrow
      // try (5 -> 13): 60 null
      // try (15 -> 19): 60 null
      // try (26 -> 36): 60 null
      // try (40 -> 50): 60 null
      // try (54 -> 59): 60 null
   }
}
