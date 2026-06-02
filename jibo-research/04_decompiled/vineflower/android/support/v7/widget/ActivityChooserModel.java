package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
   static final String a = ActivityChooserModel.class.getSimpleName();
   private static final Object e = new Object();
   private static final Map<String, ActivityChooserModel> f = new HashMap<>();
   final Context b;
   final String c;
   boolean d;
   private final Object g;
   private final List<ActivityChooserModel.ActivityResolveInfo> h;
   private final List<ActivityChooserModel.HistoricalRecord> i;
   private Intent j;
   private ActivityChooserModel.ActivitySorter k;
   private int l;
   private boolean m;
   private boolean n;
   private boolean o;
   private ActivityChooserModel.OnChooseActivityListener p;

   private boolean a(ActivityChooserModel.HistoricalRecord var1) {
      boolean var2 = this.i.add(var1);
      if (var2) {
         this.n = true;
         this.i();
         this.d();
         this.f();
         this.notifyChanged();
      }

      return var2;
   }

   private void d() {
      if (!this.m) {
         throw new IllegalStateException("No preceding call to #readHistoricalData");
      }

      if (this.n) {
         this.n = false;
         if (!TextUtils.isEmpty(this.c)) {
            new ActivityChooserModel.PersistHistoryAsyncTask(this)
               .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList<>(this.i), this.c});
         }
      }
   }

   private void e() {
      boolean var1 = this.g();
      boolean var2 = this.h();
      this.i();
      if (var1 | var2) {
         this.f();
         this.notifyChanged();
      }
   }

   private boolean f() {
      boolean var1;
      if (this.k != null && this.j != null && !this.h.isEmpty() && !this.i.isEmpty()) {
         this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean g() {
      boolean var4 = false;
      boolean var3 = var4;
      if (this.o) {
         var3 = var4;
         if (this.j != null) {
            this.o = false;
            this.h.clear();
            List var5 = this.b.getPackageManager().queryIntentActivities(this.j, 0);
            int var2 = var5.size();

            for (int var1 = 0; var1 < var2; var1++) {
               ResolveInfo var6 = (ResolveInfo)var5.get(var1);
               this.h.add(new ActivityChooserModel.ActivityResolveInfo(var6));
            }

            var3 = true;
         }
      }

      return var3;
   }

   private boolean h() {
      boolean var1 = true;
      if (this.d && this.n && !TextUtils.isEmpty(this.c)) {
         this.d = false;
         this.m = true;
         this.j();
      } else {
         var1 = false;
      }

      return var1;
   }

   private void i() {
      int var2 = this.i.size() - this.l;
      if (var2 > 0) {
         this.n = true;

         for (int var1 = 0; var1 < var2; var1++) {
            ActivityChooserModel.HistoricalRecord var3 = this.i.remove(0);
         }
      }
   }

   private void j() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield android/support/v7/widget/ActivityChooserModel.b Landroid/content/Context;
      // 004: aload 0
      // 005: getfield android/support/v7/widget/ActivityChooserModel.c Ljava/lang/String;
      // 008: invokevirtual android/content/Context.openFileInput (Ljava/lang/String;)Ljava/io/FileInputStream;
      // 00b: astore 5
      // 00d: invokestatic android/util/Xml.newPullParser ()Lorg/xmlpull/v1/XmlPullParser;
      // 010: astore 6
      // 012: aload 6
      // 014: aload 5
      // 016: ldc "UTF-8"
      // 018: invokeinterface org/xmlpull/v1/XmlPullParser.setInput (Ljava/io/InputStream;Ljava/lang/String;)V 3
      // 01d: bipush 0
      // 01e: istore 2
      // 01f: iload 2
      // 020: bipush 1
      // 021: if_icmpeq 034
      // 024: iload 2
      // 025: bipush 2
      // 026: if_icmpeq 034
      // 029: aload 6
      // 02b: invokeinterface org/xmlpull/v1/XmlPullParser.next ()I 1
      // 030: istore 2
      // 031: goto 01f
      // 034: ldc "historical-records"
      // 036: aload 6
      // 038: invokeinterface org/xmlpull/v1/XmlPullParser.getName ()Ljava/lang/String; 1
      // 03d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 040: ifne 087
      // 043: new org/xmlpull/v1/XmlPullParserException
      // 046: astore 6
      // 048: aload 6
      // 04a: ldc "Share records file does not start with historical-records tag."
      // 04c: invokespecial org/xmlpull/v1/XmlPullParserException.<init> (Ljava/lang/String;)V
      // 04f: aload 6
      // 051: athrow
      // 052: astore 8
      // 054: getstatic android/support/v7/widget/ActivityChooserModel.a Ljava/lang/String;
      // 057: astore 6
      // 059: new java/lang/StringBuilder
      // 05c: astore 7
      // 05e: aload 7
      // 060: invokespecial java/lang/StringBuilder.<init> ()V
      // 063: aload 6
      // 065: aload 7
      // 067: ldc "Error reading historical recrod file: "
      // 069: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06c: aload 0
      // 06d: getfield android/support/v7/widget/ActivityChooserModel.c Ljava/lang/String;
      // 070: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 073: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 076: aload 8
      // 078: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 07b: pop
      // 07c: aload 5
      // 07e: ifnull 086
      // 081: aload 5
      // 083: invokevirtual java/io/FileInputStream.close ()V
      // 086: return
      // 087: aload 0
      // 088: getfield android/support/v7/widget/ActivityChooserModel.i Ljava/util/List;
      // 08b: astore 7
      // 08d: aload 7
      // 08f: invokeinterface java/util/List.clear ()V 1
      // 094: aload 6
      // 096: invokeinterface org/xmlpull/v1/XmlPullParser.next ()I 1
      // 09b: istore 2
      // 09c: iload 2
      // 09d: bipush 1
      // 09e: if_icmpne 0b3
      // 0a1: aload 5
      // 0a3: ifnull 086
      // 0a6: aload 5
      // 0a8: invokevirtual java/io/FileInputStream.close ()V
      // 0ab: goto 086
      // 0ae: astore 5
      // 0b0: goto 086
      // 0b3: iload 2
      // 0b4: bipush 3
      // 0b5: if_icmpeq 094
      // 0b8: iload 2
      // 0b9: bipush 4
      // 0ba: if_icmpeq 094
      // 0bd: ldc "historical-record"
      // 0bf: aload 6
      // 0c1: invokeinterface org/xmlpull/v1/XmlPullParser.getName ()Ljava/lang/String; 1
      // 0c6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0c9: ifne 117
      // 0cc: new org/xmlpull/v1/XmlPullParserException
      // 0cf: astore 6
      // 0d1: aload 6
      // 0d3: ldc "Share records file not well-formed."
      // 0d5: invokespecial org/xmlpull/v1/XmlPullParserException.<init> (Ljava/lang/String;)V
      // 0d8: aload 6
      // 0da: athrow
      // 0db: astore 7
      // 0dd: getstatic android/support/v7/widget/ActivityChooserModel.a Ljava/lang/String;
      // 0e0: astore 8
      // 0e2: new java/lang/StringBuilder
      // 0e5: astore 6
      // 0e7: aload 6
      // 0e9: invokespecial java/lang/StringBuilder.<init> ()V
      // 0ec: aload 8
      // 0ee: aload 6
      // 0f0: ldc "Error reading historical recrod file: "
      // 0f2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f5: aload 0
      // 0f6: getfield android/support/v7/widget/ActivityChooserModel.c Ljava/lang/String;
      // 0f9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0fc: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ff: aload 7
      // 101: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 104: pop
      // 105: aload 5
      // 107: ifnull 086
      // 10a: aload 5
      // 10c: invokevirtual java/io/FileInputStream.close ()V
      // 10f: goto 086
      // 112: astore 5
      // 114: goto 086
      // 117: aload 6
      // 119: aconst_null
      // 11a: ldc_w "activity"
      // 11d: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 122: astore 9
      // 124: aload 6
      // 126: aconst_null
      // 127: ldc_w "time"
      // 12a: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 12f: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
      // 132: lstore 3
      // 133: aload 6
      // 135: aconst_null
      // 136: ldc_w "weight"
      // 139: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 13e: invokestatic java/lang/Float.parseFloat (Ljava/lang/String;)F
      // 141: fstore 1
      // 142: new android/support/v7/widget/ActivityChooserModel$HistoricalRecord
      // 145: astore 8
      // 147: aload 8
      // 149: aload 9
      // 14b: lload 3
      // 14c: fload 1
      // 14d: invokespecial android/support/v7/widget/ActivityChooserModel$HistoricalRecord.<init> (Ljava/lang/String;JF)V
      // 150: aload 7
      // 152: aload 8
      // 154: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 159: pop
      // 15a: goto 094
      // 15d: astore 6
      // 15f: aload 5
      // 161: ifnull 169
      // 164: aload 5
      // 166: invokevirtual java/io/FileInputStream.close ()V
      // 169: aload 6
      // 16b: athrow
      // 16c: astore 5
      // 16e: goto 086
      // 171: astore 5
      // 173: goto 169
      // 176: astore 5
      // 178: goto 086
      // try (0 -> 6): 160 java/io/FileNotFoundException
      // try (6 -> 12): 36 org/xmlpull/v1/XmlPullParserException
      // try (6 -> 12): 95 java/io/IOException
      // try (6 -> 12): 149 null
      // try (20 -> 23): 36 org/xmlpull/v1/XmlPullParserException
      // try (20 -> 23): 95 java/io/IOException
      // try (20 -> 23): 149 null
      // try (24 -> 36): 36 org/xmlpull/v1/XmlPullParserException
      // try (24 -> 36): 95 java/io/IOException
      // try (24 -> 36): 149 null
      // try (37 -> 54): 149 null
      // try (56 -> 58): 156 java/io/IOException
      // try (59 -> 64): 36 org/xmlpull/v1/XmlPullParserException
      // try (59 -> 64): 95 java/io/IOException
      // try (59 -> 64): 149 null
      // try (64 -> 67): 36 org/xmlpull/v1/XmlPullParserException
      // try (64 -> 67): 95 java/io/IOException
      // try (64 -> 67): 149 null
      // try (72 -> 74): 75 java/io/IOException
      // try (83 -> 95): 36 org/xmlpull/v1/XmlPullParserException
      // try (83 -> 95): 95 java/io/IOException
      // try (83 -> 95): 149 null
      // try (96 -> 113): 149 null
      // try (115 -> 117): 118 java/io/IOException
      // try (120 -> 148): 36 org/xmlpull/v1/XmlPullParserException
      // try (120 -> 148): 95 java/io/IOException
      // try (120 -> 148): 149 null
      // try (152 -> 154): 158 java/io/IOException
   }

   public int a() {
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
      // 00: aload 0
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 0b: aload 0
      // 0c: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 0f: invokeinterface java/util/List.size ()I 1
      // 14: istore 1
      // 15: aload 3
      // 16: monitorexit
      // 17: iload 1
      // 18: ireturn
      // 19: astore 2
      // 1a: aload 3
      // 1b: monitorexit
      // 1c: aload 2
      // 1d: athrow
      // try (5 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   public int a(ResolveInfo param1) {
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
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 0d: aload 0
      // 0e: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 11: astore 5
      // 13: aload 5
      // 15: invokeinterface java/util/List.size ()I 1
      // 1a: istore 3
      // 1b: bipush 0
      // 1c: istore 2
      // 1d: iload 2
      // 1e: iload 3
      // 1f: if_icmpge 3f
      // 22: aload 5
      // 24: iload 2
      // 25: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 2a: checkcast android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo
      // 2d: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 30: aload 1
      // 31: if_acmpne 39
      // 34: aload 4
      // 36: monitorexit
      // 37: iload 2
      // 38: ireturn
      // 39: iinc 2 1
      // 3c: goto 1d
      // 3f: bipush -1
      // 40: istore 2
      // 41: aload 4
      // 43: monitorexit
      // 44: goto 37
      // 47: astore 1
      // 48: aload 4
      // 4a: monitorexit
      // 4b: aload 1
      // 4c: athrow
      // try (5 -> 13): 36 null
      // try (18 -> 27): 36 null
      // try (33 -> 35): 36 null
      // try (37 -> 39): 36 null
   }

   public ResolveInfo a(int param1) {
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
      // 00: aload 0
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 0b: aload 0
      // 0c: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 0f: iload 1
      // 10: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 15: checkcast android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo
      // 18: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 1b: astore 3
      // 1c: aload 2
      // 1d: monitorexit
      // 1e: aload 3
      // 1f: areturn
      // 20: astore 3
      // 21: aload 2
      // 22: monitorexit
      // 23: aload 3
      // 24: athrow
      // try (5 -> 16): 18 null
      // try (19 -> 21): 18 null
   }

   public Intent b(int param1) {
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
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield android/support/v7/widget/ActivityChooserModel.j Landroid/content/Intent;
      // 0b: ifnonnull 14
      // 0e: aload 3
      // 0f: monitorexit
      // 10: aconst_null
      // 11: astore 2
      // 12: aload 2
      // 13: areturn
      // 14: aload 0
      // 15: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 18: aload 0
      // 19: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 1c: iload 1
      // 1d: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 22: checkcast android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo
      // 25: astore 2
      // 26: new android/content/ComponentName
      // 29: astore 4
      // 2b: aload 4
      // 2d: aload 2
      // 2e: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 31: getfield android/content/pm/ResolveInfo.activityInfo Landroid/content/pm/ActivityInfo;
      // 34: getfield android/content/pm/ActivityInfo.packageName Ljava/lang/String;
      // 37: aload 2
      // 38: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 3b: getfield android/content/pm/ResolveInfo.activityInfo Landroid/content/pm/ActivityInfo;
      // 3e: getfield android/content/pm/ActivityInfo.name Ljava/lang/String;
      // 41: invokespecial android/content/ComponentName.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 44: new android/content/Intent
      // 47: astore 2
      // 48: aload 2
      // 49: aload 0
      // 4a: getfield android/support/v7/widget/ActivityChooserModel.j Landroid/content/Intent;
      // 4d: invokespecial android/content/Intent.<init> (Landroid/content/Intent;)V
      // 50: aload 2
      // 51: aload 4
      // 53: invokevirtual android/content/Intent.setComponent (Landroid/content/ComponentName;)Landroid/content/Intent;
      // 56: pop
      // 57: aload 0
      // 58: getfield android/support/v7/widget/ActivityChooserModel.p Landroid/support/v7/widget/ActivityChooserModel$OnChooseActivityListener;
      // 5b: ifnull 7f
      // 5e: new android/content/Intent
      // 61: astore 5
      // 63: aload 5
      // 65: aload 2
      // 66: invokespecial android/content/Intent.<init> (Landroid/content/Intent;)V
      // 69: aload 0
      // 6a: getfield android/support/v7/widget/ActivityChooserModel.p Landroid/support/v7/widget/ActivityChooserModel$OnChooseActivityListener;
      // 6d: aload 0
      // 6e: aload 5
      // 70: invokeinterface android/support/v7/widget/ActivityChooserModel$OnChooseActivityListener.a (Landroid/support/v7/widget/ActivityChooserModel;Landroid/content/Intent;)Z 3
      // 75: ifeq 7f
      // 78: aload 3
      // 79: monitorexit
      // 7a: aconst_null
      // 7b: astore 2
      // 7c: goto 12
      // 7f: new android/support/v7/widget/ActivityChooserModel$HistoricalRecord
      // 82: astore 5
      // 84: aload 5
      // 86: aload 4
      // 88: invokestatic java/lang/System.currentTimeMillis ()J
      // 8b: fconst_1
      // 8c: invokespecial android/support/v7/widget/ActivityChooserModel$HistoricalRecord.<init> (Landroid/content/ComponentName;JF)V
      // 8f: aload 0
      // 90: aload 5
      // 92: invokespecial android/support/v7/widget/ActivityChooserModel.a (Landroid/support/v7/widget/ActivityChooserModel$HistoricalRecord;)Z
      // 95: pop
      // 96: aload 3
      // 97: monitorexit
      // 98: goto 12
      // 9b: astore 2
      // 9c: aload 3
      // 9d: monitorexit
      // 9e: aload 2
      // 9f: athrow
      // try (5 -> 10): 77 null
      // try (14 -> 60): 77 null
      // try (63 -> 76): 77 null
      // try (78 -> 80): 77 null
   }

   public ResolveInfo b() {
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
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 0b: aload 0
      // 0c: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 0f: invokeinterface java/util/List.isEmpty ()Z 1
      // 14: ifne 2c
      // 17: aload 0
      // 18: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 1b: bipush 0
      // 1c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 21: checkcast android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo
      // 24: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 27: astore 1
      // 28: aload 2
      // 29: monitorexit
      // 2a: aload 1
      // 2b: areturn
      // 2c: aload 2
      // 2d: monitorexit
      // 2e: aconst_null
      // 2f: astore 1
      // 30: goto 2a
      // 33: astore 1
      // 34: aload 2
      // 35: monitorexit
      // 36: aload 1
      // 37: athrow
      // try (5 -> 20): 27 null
      // try (22 -> 24): 27 null
      // try (28 -> 30): 27 null
   }

   public int c() {
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
      // 00: aload 0
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 0b: aload 0
      // 0c: getfield android/support/v7/widget/ActivityChooserModel.i Ljava/util/List;
      // 0f: invokeinterface java/util/List.size ()I 1
      // 14: istore 1
      // 15: aload 2
      // 16: monitorexit
      // 17: iload 1
      // 18: ireturn
      // 19: astore 3
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: aload 3
      // 1d: athrow
      // try (5 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   public void c(int param1) {
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
      // 01: getfield android/support/v7/widget/ActivityChooserModel.g Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial android/support/v7/widget/ActivityChooserModel.e ()V
      // 0b: aload 0
      // 0c: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 0f: iload 1
      // 10: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 15: checkcast android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo
      // 18: astore 4
      // 1a: aload 0
      // 1b: getfield android/support/v7/widget/ActivityChooserModel.h Ljava/util/List;
      // 1e: bipush 0
      // 1f: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 24: checkcast android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo
      // 27: astore 5
      // 29: aload 5
      // 2b: ifnull 78
      // 2e: aload 5
      // 30: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.b F
      // 33: aload 4
      // 35: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.b F
      // 38: fsub
      // 39: ldc_w 5.0
      // 3c: fadd
      // 3d: fstore 2
      // 3e: new android/content/ComponentName
      // 41: astore 5
      // 43: aload 5
      // 45: aload 4
      // 47: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 4a: getfield android/content/pm/ResolveInfo.activityInfo Landroid/content/pm/ActivityInfo;
      // 4d: getfield android/content/pm/ActivityInfo.packageName Ljava/lang/String;
      // 50: aload 4
      // 52: getfield android/support/v7/widget/ActivityChooserModel$ActivityResolveInfo.a Landroid/content/pm/ResolveInfo;
      // 55: getfield android/content/pm/ResolveInfo.activityInfo Landroid/content/pm/ActivityInfo;
      // 58: getfield android/content/pm/ActivityInfo.name Ljava/lang/String;
      // 5b: invokespecial android/content/ComponentName.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 5e: new android/support/v7/widget/ActivityChooserModel$HistoricalRecord
      // 61: astore 4
      // 63: aload 4
      // 65: aload 5
      // 67: invokestatic java/lang/System.currentTimeMillis ()J
      // 6a: fload 2
      // 6b: invokespecial android/support/v7/widget/ActivityChooserModel$HistoricalRecord.<init> (Landroid/content/ComponentName;JF)V
      // 6e: aload 0
      // 6f: aload 4
      // 71: invokespecial android/support/v7/widget/ActivityChooserModel.a (Landroid/support/v7/widget/ActivityChooserModel$HistoricalRecord;)Z
      // 74: pop
      // 75: aload 3
      // 76: monitorexit
      // 77: return
      // 78: fconst_1
      // 79: fstore 2
      // 7a: goto 3e
      // 7d: astore 4
      // 7f: aload 3
      // 80: monitorexit
      // 81: aload 4
      // 83: athrow
      // try (5 -> 19): 58 null
      // try (21 -> 29): 58 null
      // try (29 -> 54): 58 null
      // try (59 -> 61): 58 null
   }

   public static final class ActivityResolveInfo implements Comparable<ActivityChooserModel.ActivityResolveInfo> {
      public final ResolveInfo a;
      public float b;

      public ActivityResolveInfo(ResolveInfo var1) {
         this.a = var1;
      }

      public int a(ActivityChooserModel.ActivityResolveInfo var1) {
         return Float.floatToIntBits(var1.b) - Float.floatToIntBits(this.b);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 == null) {
               var2 = false;
            } else if (this.getClass() != var1.getClass()) {
               var2 = false;
            } else {
               var1 = var1;
               if (Float.floatToIntBits(this.b) != Float.floatToIntBits(var1.b)) {
                  var2 = false;
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return Float.floatToIntBits(this.b) + 31;
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("[");
         var1.append("resolveInfo:").append(this.a.toString());
         var1.append("; weight:").append(new BigDecimal(this.b));
         var1.append("]");
         return var1.toString();
      }
   }

   public interface ActivitySorter {
      void a(Intent var1, List<ActivityChooserModel.ActivityResolveInfo> var2, List<ActivityChooserModel.HistoricalRecord> var3);
   }

   public static final class HistoricalRecord {
      public final ComponentName a;
      public final long b;
      public final float c;

      public HistoricalRecord(ComponentName var1, long var2, float var4) {
         this.a = var1;
         this.b = var2;
         this.c = var4;
      }

      public HistoricalRecord(String var1, long var2, float var4) {
         this(ComponentName.unflattenFromString(var1), var2, var4);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 == null) {
               var2 = false;
            } else if (this.getClass() != var1.getClass()) {
               var2 = false;
            } else {
               var1 = var1;
               if (this.a == null) {
                  if (var1.a != null) {
                     var2 = false;
                     return var2;
                  }
               } else if (!this.a.equals(var1.a)) {
                  var2 = false;
                  return var2;
               }

               if (this.b != var1.b) {
                  var2 = false;
               } else if (Float.floatToIntBits(this.c) != Float.floatToIntBits(var1.c)) {
                  var2 = false;
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         int var1;
         if (this.a == null) {
            var1 = 0;
         } else {
            var1 = this.a.hashCode();
         }

         return ((var1 + 31) * 31 + (int)(this.b ^ this.b >>> 32)) * 31 + Float.floatToIntBits(this.c);
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("[");
         var1.append("; activity:").append(this.a);
         var1.append("; time:").append(this.b);
         var1.append("; weight:").append(new BigDecimal(this.c));
         var1.append("]");
         return var1.toString();
      }
   }

   public interface OnChooseActivityListener {
      boolean a(ActivityChooserModel var1, Intent var2);
   }

   private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
      final ActivityChooserModel a;

      PersistHistoryAsyncTask(ActivityChooserModel var1) {
         this.a = var1;
      }

      public Void a(Object... param1) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: bipush 0
         // 001: istore 2
         // 002: aload 1
         // 003: bipush 0
         // 004: aaload
         // 005: checkcast java/util/List
         // 008: astore 4
         // 00a: aload 1
         // 00b: bipush 1
         // 00c: aaload
         // 00d: checkcast java/lang/String
         // 010: astore 5
         // 012: aload 0
         // 013: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 016: getfield android/support/v7/widget/ActivityChooserModel.b Landroid/content/Context;
         // 019: aload 5
         // 01b: bipush 0
         // 01c: invokevirtual android/content/Context.openFileOutput (Ljava/lang/String;I)Ljava/io/FileOutputStream;
         // 01f: astore 1
         // 020: invokestatic android/util/Xml.newSerializer ()Lorg/xmlpull/v1/XmlSerializer;
         // 023: astore 5
         // 025: aload 5
         // 027: aload 1
         // 028: aconst_null
         // 029: invokeinterface org/xmlpull/v1/XmlSerializer.setOutput (Ljava/io/OutputStream;Ljava/lang/String;)V 3
         // 02e: aload 5
         // 030: ldc "UTF-8"
         // 032: bipush 1
         // 033: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
         // 036: invokeinterface org/xmlpull/v1/XmlSerializer.startDocument (Ljava/lang/String;Ljava/lang/Boolean;)V 3
         // 03b: aload 5
         // 03d: aconst_null
         // 03e: ldc "historical-records"
         // 040: invokeinterface org/xmlpull/v1/XmlSerializer.startTag (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 3
         // 045: pop
         // 046: aload 4
         // 048: invokeinterface java/util/List.size ()I 1
         // 04d: istore 3
         // 04e: iload 2
         // 04f: iload 3
         // 050: if_icmpge 0d4
         // 053: aload 4
         // 055: bipush 0
         // 056: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
         // 05b: checkcast android/support/v7/widget/ActivityChooserModel$HistoricalRecord
         // 05e: astore 6
         // 060: aload 5
         // 062: aconst_null
         // 063: ldc "historical-record"
         // 065: invokeinterface org/xmlpull/v1/XmlSerializer.startTag (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 3
         // 06a: pop
         // 06b: aload 5
         // 06d: aconst_null
         // 06e: ldc "activity"
         // 070: aload 6
         // 072: getfield android/support/v7/widget/ActivityChooserModel$HistoricalRecord.a Landroid/content/ComponentName;
         // 075: invokevirtual android/content/ComponentName.flattenToString ()Ljava/lang/String;
         // 078: invokeinterface org/xmlpull/v1/XmlSerializer.attribute (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 4
         // 07d: pop
         // 07e: aload 5
         // 080: aconst_null
         // 081: ldc "time"
         // 083: aload 6
         // 085: getfield android/support/v7/widget/ActivityChooserModel$HistoricalRecord.b J
         // 088: invokestatic java/lang/String.valueOf (J)Ljava/lang/String;
         // 08b: invokeinterface org/xmlpull/v1/XmlSerializer.attribute (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 4
         // 090: pop
         // 091: aload 5
         // 093: aconst_null
         // 094: ldc "weight"
         // 096: aload 6
         // 098: getfield android/support/v7/widget/ActivityChooserModel$HistoricalRecord.c F
         // 09b: invokestatic java/lang/String.valueOf (F)Ljava/lang/String;
         // 09e: invokeinterface org/xmlpull/v1/XmlSerializer.attribute (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 4
         // 0a3: pop
         // 0a4: aload 5
         // 0a6: aconst_null
         // 0a7: ldc "historical-record"
         // 0a9: invokeinterface org/xmlpull/v1/XmlSerializer.endTag (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 3
         // 0ae: pop
         // 0af: iinc 2 1
         // 0b2: goto 04e
         // 0b5: astore 1
         // 0b6: getstatic android/support/v7/widget/ActivityChooserModel.a Ljava/lang/String;
         // 0b9: new java/lang/StringBuilder
         // 0bc: dup
         // 0bd: invokespecial java/lang/StringBuilder.<init> ()V
         // 0c0: ldc "Error writing historical record file: "
         // 0c2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0c5: aload 5
         // 0c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0ca: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 0cd: aload 1
         // 0ce: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 0d1: pop
         // 0d2: aconst_null
         // 0d3: areturn
         // 0d4: aload 5
         // 0d6: aconst_null
         // 0d7: ldc "historical-records"
         // 0d9: invokeinterface org/xmlpull/v1/XmlSerializer.endTag (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer; 3
         // 0de: pop
         // 0df: aload 5
         // 0e1: invokeinterface org/xmlpull/v1/XmlSerializer.endDocument ()V 1
         // 0e6: aload 0
         // 0e7: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 0ea: bipush 1
         // 0eb: putfield android/support/v7/widget/ActivityChooserModel.d Z
         // 0ee: aload 1
         // 0ef: ifnull 0d2
         // 0f2: aload 1
         // 0f3: invokevirtual java/io/FileOutputStream.close ()V
         // 0f6: goto 0d2
         // 0f9: astore 1
         // 0fa: goto 0d2
         // 0fd: astore 6
         // 0ff: getstatic android/support/v7/widget/ActivityChooserModel.a Ljava/lang/String;
         // 102: astore 5
         // 104: new java/lang/StringBuilder
         // 107: astore 4
         // 109: aload 4
         // 10b: invokespecial java/lang/StringBuilder.<init> ()V
         // 10e: aload 5
         // 110: aload 4
         // 112: ldc "Error writing historical record file: "
         // 114: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 117: aload 0
         // 118: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 11b: getfield android/support/v7/widget/ActivityChooserModel.c Ljava/lang/String;
         // 11e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 121: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 124: aload 6
         // 126: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 129: pop
         // 12a: aload 0
         // 12b: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 12e: bipush 1
         // 12f: putfield android/support/v7/widget/ActivityChooserModel.d Z
         // 132: aload 1
         // 133: ifnull 0d2
         // 136: aload 1
         // 137: invokevirtual java/io/FileOutputStream.close ()V
         // 13a: goto 0d2
         // 13d: astore 1
         // 13e: goto 0d2
         // 141: astore 4
         // 143: getstatic android/support/v7/widget/ActivityChooserModel.a Ljava/lang/String;
         // 146: astore 5
         // 148: new java/lang/StringBuilder
         // 14b: astore 6
         // 14d: aload 6
         // 14f: invokespecial java/lang/StringBuilder.<init> ()V
         // 152: aload 5
         // 154: aload 6
         // 156: ldc "Error writing historical record file: "
         // 158: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 15b: aload 0
         // 15c: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 15f: getfield android/support/v7/widget/ActivityChooserModel.c Ljava/lang/String;
         // 162: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 165: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 168: aload 4
         // 16a: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 16d: pop
         // 16e: aload 0
         // 16f: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 172: bipush 1
         // 173: putfield android/support/v7/widget/ActivityChooserModel.d Z
         // 176: aload 1
         // 177: ifnull 0d2
         // 17a: aload 1
         // 17b: invokevirtual java/io/FileOutputStream.close ()V
         // 17e: goto 0d2
         // 181: astore 1
         // 182: goto 0d2
         // 185: astore 4
         // 187: getstatic android/support/v7/widget/ActivityChooserModel.a Ljava/lang/String;
         // 18a: astore 5
         // 18c: new java/lang/StringBuilder
         // 18f: astore 6
         // 191: aload 6
         // 193: invokespecial java/lang/StringBuilder.<init> ()V
         // 196: aload 5
         // 198: aload 6
         // 19a: ldc "Error writing historical record file: "
         // 19c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 19f: aload 0
         // 1a0: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 1a3: getfield android/support/v7/widget/ActivityChooserModel.c Ljava/lang/String;
         // 1a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 1a9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 1ac: aload 4
         // 1ae: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 1b1: pop
         // 1b2: aload 0
         // 1b3: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 1b6: bipush 1
         // 1b7: putfield android/support/v7/widget/ActivityChooserModel.d Z
         // 1ba: aload 1
         // 1bb: ifnull 0d2
         // 1be: aload 1
         // 1bf: invokevirtual java/io/FileOutputStream.close ()V
         // 1c2: goto 0d2
         // 1c5: astore 1
         // 1c6: goto 0d2
         // 1c9: astore 4
         // 1cb: aload 0
         // 1cc: getfield android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.a Landroid/support/v7/widget/ActivityChooserModel;
         // 1cf: bipush 1
         // 1d0: putfield android/support/v7/widget/ActivityChooserModel.d Z
         // 1d3: aload 1
         // 1d4: ifnull 1db
         // 1d7: aload 1
         // 1d8: invokevirtual java/io/FileOutputStream.close ()V
         // 1db: aload 4
         // 1dd: athrow
         // 1de: astore 1
         // 1df: goto 1db
         // try (12 -> 19): 82 java/io/FileNotFoundException
         // try (21 -> 38): 115 java/lang/IllegalArgumentException
         // try (21 -> 38): 145 java/lang/IllegalStateException
         // try (21 -> 38): 175 java/io/IOException
         // try (21 -> 38): 205 null
         // try (41 -> 80): 115 java/lang/IllegalArgumentException
         // try (41 -> 80): 145 java/lang/IllegalStateException
         // try (41 -> 80): 175 java/io/IOException
         // try (41 -> 80): 205 null
         // try (97 -> 104): 115 java/lang/IllegalArgumentException
         // try (97 -> 104): 145 java/lang/IllegalStateException
         // try (97 -> 104): 175 java/io/IOException
         // try (97 -> 104): 205 null
         // try (110 -> 112): 113 java/io/IOException
         // try (116 -> 134): 205 null
         // try (140 -> 142): 143 java/io/IOException
         // try (146 -> 164): 205 null
         // try (170 -> 172): 173 java/io/IOException
         // try (176 -> 194): 205 null
         // try (200 -> 202): 203 java/io/IOException
         // try (212 -> 214): 216 java/io/IOException
      }
   }
}
