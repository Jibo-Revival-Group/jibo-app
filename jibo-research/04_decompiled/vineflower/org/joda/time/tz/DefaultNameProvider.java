package org.joda.time.tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DefaultNameProvider implements NameProvider {
   private HashMap<Locale, Map<String, Map<String, Object>>> a = this.a();
   private HashMap<Locale, Map<String, Map<Boolean, Object>>> b = this.a();

   private HashMap a() {
      return new HashMap(7);
   }

   private String[] c(Locale param1, String param2, String param3) {
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
      // 000: aconst_null
      // 001: astore 8
      // 003: aload 0
      // 004: monitorenter
      // 005: aload 1
      // 006: ifnull 011
      // 009: aload 2
      // 00a: ifnull 011
      // 00d: aload 3
      // 00e: ifnonnull 017
      // 011: aconst_null
      // 012: astore 1
      // 013: aload 0
      // 014: monitorexit
      // 015: aload 1
      // 016: areturn
      // 017: aload 0
      // 018: getfield org/joda/time/tz/DefaultNameProvider.a Ljava/util/HashMap;
      // 01b: aload 1
      // 01c: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 01f: checkcast java/util/Map
      // 022: astore 6
      // 024: aload 6
      // 026: ifnonnull 18a
      // 029: aload 0
      // 02a: getfield org/joda/time/tz/DefaultNameProvider.a Ljava/util/HashMap;
      // 02d: astore 7
      // 02f: aload 0
      // 030: invokespecial org/joda/time/tz/DefaultNameProvider.a ()Ljava/util/HashMap;
      // 033: astore 6
      // 035: aload 7
      // 037: aload 1
      // 038: aload 6
      // 03a: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 03d: pop
      // 03e: aload 6
      // 040: aload 2
      // 041: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 046: checkcast java/util/Map
      // 049: astore 9
      // 04b: aload 9
      // 04d: astore 7
      // 04f: aload 9
      // 051: ifnonnull 141
      // 054: aload 0
      // 055: invokespecial org/joda/time/tz/DefaultNameProvider.a ()Ljava/util/HashMap;
      // 058: astore 9
      // 05a: aload 6
      // 05c: aload 2
      // 05d: aload 9
      // 05f: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 064: pop
      // 065: getstatic java/util/Locale.ENGLISH Ljava/util/Locale;
      // 068: invokestatic org/joda/time/DateTimeUtils.a (Ljava/util/Locale;)Ljava/text/DateFormatSymbols;
      // 06b: invokevirtual java/text/DateFormatSymbols.getZoneStrings ()[[Ljava/lang/String;
      // 06e: astore 7
      // 070: aload 7
      // 072: arraylength
      // 073: istore 5
      // 075: bipush 0
      // 076: istore 4
      // 078: iload 4
      // 07a: iload 5
      // 07c: if_icmpge 184
      // 07f: aload 7
      // 081: iload 4
      // 083: aaload
      // 084: astore 6
      // 086: aload 6
      // 088: ifnull 150
      // 08b: aload 6
      // 08d: arraylength
      // 08e: bipush 5
      // 08f: if_icmplt 150
      // 092: aload 2
      // 093: aload 6
      // 095: bipush 0
      // 096: aaload
      // 097: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 09a: ifeq 150
      // 09d: aload 1
      // 09e: invokestatic org/joda/time/DateTimeUtils.a (Ljava/util/Locale;)Ljava/text/DateFormatSymbols;
      // 0a1: invokevirtual java/text/DateFormatSymbols.getZoneStrings ()[[Ljava/lang/String;
      // 0a4: astore 7
      // 0a6: aload 7
      // 0a8: arraylength
      // 0a9: istore 5
      // 0ab: bipush 0
      // 0ac: istore 4
      // 0ae: aload 8
      // 0b0: astore 1
      // 0b1: iload 4
      // 0b3: iload 5
      // 0b5: if_icmpge 0d2
      // 0b8: aload 7
      // 0ba: iload 4
      // 0bc: aaload
      // 0bd: astore 1
      // 0be: aload 1
      // 0bf: ifnull 156
      // 0c2: aload 1
      // 0c3: arraylength
      // 0c4: bipush 5
      // 0c5: if_icmplt 156
      // 0c8: aload 2
      // 0c9: aload 1
      // 0ca: bipush 0
      // 0cb: aaload
      // 0cc: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0cf: ifeq 156
      // 0d2: aload 9
      // 0d4: astore 7
      // 0d6: aload 6
      // 0d8: ifnull 141
      // 0db: aload 9
      // 0dd: astore 7
      // 0df: aload 1
      // 0e0: ifnull 141
      // 0e3: aload 9
      // 0e5: aload 6
      // 0e7: bipush 2
      // 0e8: aaload
      // 0e9: bipush 2
      // 0ea: anewarray 61
      // 0ed: dup
      // 0ee: bipush 0
      // 0ef: aload 1
      // 0f0: bipush 2
      // 0f1: aaload
      // 0f2: aastore
      // 0f3: dup
      // 0f4: bipush 1
      // 0f5: aload 1
      // 0f6: bipush 1
      // 0f7: aaload
      // 0f8: aastore
      // 0f9: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0fe: pop
      // 0ff: aload 6
      // 101: bipush 2
      // 102: aaload
      // 103: aload 6
      // 105: bipush 4
      // 106: aaload
      // 107: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 10a: ifeq 15c
      // 10d: new java/lang/StringBuilder
      // 110: astore 2
      // 111: aload 2
      // 112: invokespecial java/lang/StringBuilder.<init> ()V
      // 115: aload 9
      // 117: aload 2
      // 118: aload 6
      // 11a: bipush 4
      // 11b: aaload
      // 11c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11f: ldc "-Summer"
      // 121: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 124: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 127: bipush 2
      // 128: anewarray 61
      // 12b: dup
      // 12c: bipush 0
      // 12d: aload 1
      // 12e: bipush 4
      // 12f: aaload
      // 130: aastore
      // 131: dup
      // 132: bipush 1
      // 133: aload 1
      // 134: bipush 3
      // 135: aaload
      // 136: aastore
      // 137: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 13c: pop
      // 13d: aload 9
      // 13f: astore 7
      // 141: aload 7
      // 143: aload 3
      // 144: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 149: checkcast [Ljava/lang/String;
      // 14c: astore 1
      // 14d: goto 013
      // 150: iinc 4 1
      // 153: goto 078
      // 156: iinc 4 1
      // 159: goto 0ae
      // 15c: aload 9
      // 15e: aload 6
      // 160: bipush 4
      // 161: aaload
      // 162: bipush 2
      // 163: anewarray 61
      // 166: dup
      // 167: bipush 0
      // 168: aload 1
      // 169: bipush 4
      // 16a: aaload
      // 16b: aastore
      // 16c: dup
      // 16d: bipush 1
      // 16e: aload 1
      // 16f: bipush 3
      // 170: aaload
      // 171: aastore
      // 172: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 177: pop
      // 178: aload 9
      // 17a: astore 7
      // 17c: goto 141
      // 17f: astore 1
      // 180: aload 0
      // 181: monitorexit
      // 182: aload 1
      // 183: athrow
      // 184: aconst_null
      // 185: astore 6
      // 187: goto 09d
      // 18a: goto 03e
      // try (16 -> 22): 210 null
      // try (24 -> 35): 210 null
      // try (35 -> 40): 210 null
      // try (44 -> 59): 210 null
      // try (70 -> 80): 210 null
      // try (80 -> 87): 210 null
      // try (100 -> 110): 210 null
      // try (118 -> 175): 210 null
      // try (177 -> 182): 210 null
      // try (187 -> 207): 210 null
   }

   private String[] c(Locale param1, String param2, String param3, boolean param4) {
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
      // 000: aconst_null
      // 001: astore 8
      // 003: aload 0
      // 004: monitorenter
      // 005: aload 1
      // 006: ifnull 011
      // 009: aload 2
      // 00a: ifnull 011
      // 00d: aload 3
      // 00e: ifnonnull 017
      // 011: aconst_null
      // 012: astore 1
      // 013: aload 0
      // 014: monitorexit
      // 015: aload 1
      // 016: areturn
      // 017: aload 2
      // 018: astore 3
      // 019: aload 2
      // 01a: ldc "Etc/"
      // 01c: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 01f: ifeq 028
      // 022: aload 2
      // 023: bipush 4
      // 024: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 027: astore 3
      // 028: aload 0
      // 029: getfield org/joda/time/tz/DefaultNameProvider.b Ljava/util/HashMap;
      // 02c: aload 1
      // 02d: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 030: checkcast java/util/Map
      // 033: astore 2
      // 034: aload 2
      // 035: ifnonnull 14c
      // 038: aload 0
      // 039: getfield org/joda/time/tz/DefaultNameProvider.b Ljava/util/HashMap;
      // 03c: astore 7
      // 03e: aload 0
      // 03f: invokespecial org/joda/time/tz/DefaultNameProvider.a ()Ljava/util/HashMap;
      // 042: astore 2
      // 043: aload 7
      // 045: aload 1
      // 046: aload 2
      // 047: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 04a: pop
      // 04b: aload 2
      // 04c: aload 3
      // 04d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 052: checkcast java/util/Map
      // 055: astore 9
      // 057: aload 9
      // 059: astore 7
      // 05b: aload 9
      // 05d: ifnonnull 123
      // 060: aload 0
      // 061: invokespecial org/joda/time/tz/DefaultNameProvider.a ()Ljava/util/HashMap;
      // 064: astore 9
      // 066: aload 2
      // 067: aload 3
      // 068: aload 9
      // 06a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 06f: pop
      // 070: getstatic java/util/Locale.ENGLISH Ljava/util/Locale;
      // 073: invokestatic org/joda/time/DateTimeUtils.a (Ljava/util/Locale;)Ljava/text/DateFormatSymbols;
      // 076: invokevirtual java/text/DateFormatSymbols.getZoneStrings ()[[Ljava/lang/String;
      // 079: astore 7
      // 07b: aload 7
      // 07d: arraylength
      // 07e: istore 6
      // 080: bipush 0
      // 081: istore 5
      // 083: iload 5
      // 085: iload 6
      // 087: if_icmpge 147
      // 08a: aload 7
      // 08c: iload 5
      // 08e: aaload
      // 08f: astore 2
      // 090: aload 2
      // 091: ifnull 136
      // 094: aload 2
      // 095: arraylength
      // 096: bipush 5
      // 097: if_icmplt 136
      // 09a: aload 3
      // 09b: aload 2
      // 09c: bipush 0
      // 09d: aaload
      // 09e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a1: ifeq 136
      // 0a4: aload 1
      // 0a5: invokestatic org/joda/time/DateTimeUtils.a (Ljava/util/Locale;)Ljava/text/DateFormatSymbols;
      // 0a8: invokevirtual java/text/DateFormatSymbols.getZoneStrings ()[[Ljava/lang/String;
      // 0ab: astore 7
      // 0ad: aload 7
      // 0af: arraylength
      // 0b0: istore 6
      // 0b2: bipush 0
      // 0b3: istore 5
      // 0b5: aload 8
      // 0b7: astore 1
      // 0b8: iload 5
      // 0ba: iload 6
      // 0bc: if_icmpge 0d9
      // 0bf: aload 7
      // 0c1: iload 5
      // 0c3: aaload
      // 0c4: astore 1
      // 0c5: aload 1
      // 0c6: ifnull 13c
      // 0c9: aload 1
      // 0ca: arraylength
      // 0cb: bipush 5
      // 0cc: if_icmplt 13c
      // 0cf: aload 3
      // 0d0: aload 1
      // 0d1: bipush 0
      // 0d2: aaload
      // 0d3: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d6: ifeq 13c
      // 0d9: aload 9
      // 0db: astore 7
      // 0dd: aload 2
      // 0de: ifnull 123
      // 0e1: aload 9
      // 0e3: astore 7
      // 0e5: aload 1
      // 0e6: ifnull 123
      // 0e9: aload 9
      // 0eb: getstatic java/lang/Boolean.TRUE Ljava/lang/Boolean;
      // 0ee: bipush 2
      // 0ef: anewarray 61
      // 0f2: dup
      // 0f3: bipush 0
      // 0f4: aload 1
      // 0f5: bipush 2
      // 0f6: aaload
      // 0f7: aastore
      // 0f8: dup
      // 0f9: bipush 1
      // 0fa: aload 1
      // 0fb: bipush 1
      // 0fc: aaload
      // 0fd: aastore
      // 0fe: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 103: pop
      // 104: aload 9
      // 106: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 109: bipush 2
      // 10a: anewarray 61
      // 10d: dup
      // 10e: bipush 0
      // 10f: aload 1
      // 110: bipush 4
      // 111: aaload
      // 112: aastore
      // 113: dup
      // 114: bipush 1
      // 115: aload 1
      // 116: bipush 3
      // 117: aaload
      // 118: aastore
      // 119: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 11e: pop
      // 11f: aload 9
      // 121: astore 7
      // 123: aload 7
      // 125: iload 4
      // 127: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 12a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 12f: checkcast [Ljava/lang/String;
      // 132: astore 1
      // 133: goto 013
      // 136: iinc 5 1
      // 139: goto 083
      // 13c: iinc 5 1
      // 13f: goto 0b5
      // 142: astore 1
      // 143: aload 0
      // 144: monitorexit
      // 145: aload 1
      // 146: athrow
      // 147: aconst_null
      // 148: astore 2
      // 149: goto 0a4
      // 14c: goto 04b
      // try (18 -> 26): 177 null
      // try (26 -> 32): 177 null
      // try (34 -> 45): 177 null
      // try (45 -> 50): 177 null
      // try (54 -> 69): 177 null
      // try (80 -> 90): 177 null
      // try (90 -> 97): 177 null
      // try (110 -> 120): 177 null
      // try (128 -> 164): 177 null
      // try (166 -> 172): 177 null
   }

   @Override
   public String a(Locale var1, String var2, String var3) {
      String[] var4 = this.c(var1, var2, var3);
      String var5;
      if (var4 == null) {
         var5 = null;
      } else {
         var5 = var4[0];
      }

      return var5;
   }

   public String a(Locale var1, String var2, String var3, boolean var4) {
      String[] var5 = this.c(var1, var2, var3, var4);
      String var6;
      if (var5 == null) {
         var6 = null;
      } else {
         var6 = var5[0];
      }

      return var6;
   }

   @Override
   public String b(Locale var1, String var2, String var3) {
      String[] var4 = this.c(var1, var2, var3);
      String var5;
      if (var4 == null) {
         var5 = null;
      } else {
         var5 = var4[1];
      }

      return var5;
   }

   public String b(Locale var1, String var2, String var3, boolean var4) {
      String[] var5 = this.c(var1, var2, var3, var4);
      String var6;
      if (var5 == null) {
         var6 = null;
      } else {
         var6 = var5[1];
      }

      return var6;
   }
}
