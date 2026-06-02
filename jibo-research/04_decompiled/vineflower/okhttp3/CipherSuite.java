package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class CipherSuite {
   public static final CipherSuite A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
   public static final CipherSuite B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
   public static final CipherSuite C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
   public static final CipherSuite D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
   public static final CipherSuite E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
   public static final CipherSuite F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
   public static final CipherSuite G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
   public static final CipherSuite H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
   public static final CipherSuite I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
   public static final CipherSuite J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
   public static final CipherSuite K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
   public static final CipherSuite L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
   public static final CipherSuite M = a("TLS_RSA_WITH_NULL_SHA256", 59);
   public static final CipherSuite N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
   public static final CipherSuite O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
   public static final CipherSuite P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
   public static final CipherSuite Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
   public static final CipherSuite R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
   public static final CipherSuite S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
   public static final CipherSuite T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
   public static final CipherSuite U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
   public static final CipherSuite V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
   public static final CipherSuite W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
   public static final CipherSuite X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
   public static final CipherSuite Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
   public static final CipherSuite Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
   static final Comparator<String> a = new Comparator<String>() {
      public int a(String var1, String var2) {
         byte var4 = -1;
         int var3 = 4;
         int var5 = Math.min(var1.length(), var2.length());

         while (true) {
            if (var3 >= var5) {
               int var10 = var1.length();
               var5 = var2.length();
               if (var10 != var5) {
                  var8 = var4;
                  if (var10 >= var5) {
                     var8 = 1;
                  }
               } else {
                  var8 = 0;
               }
               break;
            }

            char var7 = var1.charAt(var3);
            char var6 = var2.charAt(var3);
            if (var7 != var6) {
               if (var7 < var6) {
                  var8 = var4;
               } else {
                  var8 = 1;
               }
               break;
            }

            var3++;
         }

         return var8;
      }
   };
   public static final CipherSuite aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
   public static final CipherSuite aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
   public static final CipherSuite aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
   public static final CipherSuite aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
   public static final CipherSuite aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
   public static final CipherSuite aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
   public static final CipherSuite aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
   public static final CipherSuite aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
   public static final CipherSuite aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
   public static final CipherSuite aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
   public static final CipherSuite aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
   public static final CipherSuite aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
   public static final CipherSuite aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
   public static final CipherSuite aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
   public static final CipherSuite aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
   public static final CipherSuite aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
   public static final CipherSuite aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
   public static final CipherSuite aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
   public static final CipherSuite aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
   public static final CipherSuite aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
   public static final CipherSuite aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
   public static final CipherSuite aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
   public static final CipherSuite aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
   public static final CipherSuite aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
   public static final CipherSuite aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
   public static final CipherSuite aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
   public static final CipherSuite aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
   public static final CipherSuite ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);
   public static final CipherSuite ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
   public static final CipherSuite ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
   public static final CipherSuite ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
   public static final CipherSuite af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
   public static final CipherSuite ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
   public static final CipherSuite ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
   public static final CipherSuite ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
   public static final CipherSuite aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
   public static final CipherSuite ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
   public static final CipherSuite al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
   public static final CipherSuite am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
   public static final CipherSuite an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
   public static final CipherSuite ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
   public static final CipherSuite ap = a("TLS_FALLBACK_SCSV", 22016);
   public static final CipherSuite aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
   public static final CipherSuite ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
   public static final CipherSuite as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
   public static final CipherSuite at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
   public static final CipherSuite au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
   public static final CipherSuite av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
   public static final CipherSuite aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
   public static final CipherSuite ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
   public static final CipherSuite ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
   public static final CipherSuite az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
   public static final CipherSuite b = a("SSL_RSA_WITH_NULL_MD5", 1);
   public static final CipherSuite ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
   public static final CipherSuite bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
   public static final CipherSuite bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
   public static final CipherSuite bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
   public static final CipherSuite be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
   public static final CipherSuite bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
   public static final CipherSuite bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
   public static final CipherSuite bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
   public static final CipherSuite bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
   private static final Map<String, CipherSuite> bk = new TreeMap<>(a);
   public static final CipherSuite c = a("SSL_RSA_WITH_NULL_SHA", 2);
   public static final CipherSuite d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
   public static final CipherSuite e = a("SSL_RSA_WITH_RC4_128_MD5", 4);
   public static final CipherSuite f = a("SSL_RSA_WITH_RC4_128_SHA", 5);
   public static final CipherSuite g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
   public static final CipherSuite h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
   public static final CipherSuite i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
   public static final CipherSuite j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
   public static final CipherSuite k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
   public static final CipherSuite l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
   public static final CipherSuite m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
   public static final CipherSuite n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
   public static final CipherSuite o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
   public static final CipherSuite p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
   public static final CipherSuite q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
   public static final CipherSuite r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
   public static final CipherSuite s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
   public static final CipherSuite t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
   public static final CipherSuite u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
   public static final CipherSuite v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
   public static final CipherSuite w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
   public static final CipherSuite x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
   public static final CipherSuite y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
   public static final CipherSuite z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
   final String bj;

   private CipherSuite(String var1) {
      if (var1 == null) {
         throw new NullPointerException();
      }

      this.bj = var1;
   }

   static List<CipherSuite> a(String... var0) {
      ArrayList var3 = new ArrayList(var0.length);
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.add(a(var0[var1]));
      }

      return Collections.unmodifiableList(var3);
   }

   public static CipherSuite a(String param0) {
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
      // 00: ldc okhttp3/CipherSuite
      // 02: monitorenter
      // 03: getstatic okhttp3/CipherSuite.bk Ljava/util/Map;
      // 06: aload 0
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast okhttp3/CipherSuite
      // 0f: astore 2
      // 10: aload 2
      // 11: astore 1
      // 12: aload 2
      // 13: ifnonnull 2a
      // 16: new okhttp3/CipherSuite
      // 19: astore 1
      // 1a: aload 1
      // 1b: aload 0
      // 1c: invokespecial okhttp3/CipherSuite.<init> (Ljava/lang/String;)V
      // 1f: getstatic okhttp3/CipherSuite.bk Ljava/util/Map;
      // 22: aload 0
      // 23: aload 1
      // 24: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 29: pop
      // 2a: ldc okhttp3/CipherSuite
      // 2c: monitorexit
      // 2d: aload 1
      // 2e: areturn
      // 2f: astore 0
      // 30: ldc okhttp3/CipherSuite
      // 32: monitorexit
      // 33: aload 0
      // 34: athrow
      // try (2 -> 7): 25 null
      // try (11 -> 21): 25 null
   }

   private static CipherSuite a(String var0, int var1) {
      return a(var0);
   }

   public String a() {
      return this.bj;
   }

   @Override
   public String toString() {
      return this.bj;
   }
}
