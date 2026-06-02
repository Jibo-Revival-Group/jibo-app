package com.salesforce.androidsdk.rest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClientManager {
   private final AccountManager a;
   private final String b;
   private final ClientManager.LoginOptions c;
   private final boolean d;

   public ClientManager(Context var1, String var2, ClientManager.LoginOptions var3, boolean var4) {
      this.a = AccountManager.get(var1);
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static void a(String param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: ldc com/salesforce/androidsdk/rest/ClientManager
      // 002: monitorenter
      // 003: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 006: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.k ()Landroid/content/Context;
      // 009: invokestatic android/accounts/AccountManager.get (Landroid/content/Context;)Landroid/accounts/AccountManager;
      // 00c: astore 13
      // 00e: aload 13
      // 010: ifnull 37d
      // 013: aload 13
      // 015: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 018: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.B ()Ljava/lang/String;
      // 01b: invokevirtual android/accounts/AccountManager.getAccountsByType (Ljava/lang/String;)[Landroid/accounts/Account;
      // 01e: astore 14
      // 020: aload 14
      // 022: ifnull 37d
      // 025: aload 14
      // 027: arraylength
      // 028: ifle 37d
      // 02b: aload 14
      // 02d: arraylength
      // 02e: istore 3
      // 02f: bipush 0
      // 030: istore 2
      // 031: iload 2
      // 032: iload 3
      // 033: if_icmpge 37d
      // 036: aload 14
      // 038: iload 2
      // 039: aaload
      // 03a: astore 12
      // 03c: aload 13
      // 03e: aload 12
      // 040: ldc "authtoken"
      // 042: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 045: aload 0
      // 046: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 049: astore 19
      // 04b: aload 13
      // 04d: aload 12
      // 04f: invokevirtual android/accounts/AccountManager.getPassword (Landroid/accounts/Account;)Ljava/lang/String;
      // 052: aload 0
      // 053: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 056: astore 21
      // 058: aload 13
      // 05a: aload 12
      // 05c: ldc "loginUrl"
      // 05e: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 061: aload 0
      // 062: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 065: astore 18
      // 067: aload 13
      // 069: aload 12
      // 06b: ldc "id"
      // 06d: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 070: aload 0
      // 071: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 074: astore 16
      // 076: aload 13
      // 078: aload 12
      // 07a: ldc "instanceUrl"
      // 07c: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 07f: aload 0
      // 080: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 083: astore 23
      // 085: aload 13
      // 087: aload 12
      // 089: ldc "orgId"
      // 08b: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 08e: aload 0
      // 08f: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 092: astore 22
      // 094: aload 13
      // 096: aload 12
      // 098: ldc "userId"
      // 09a: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 09d: aload 0
      // 09e: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0a1: astore 17
      // 0a3: aload 13
      // 0a5: aload 12
      // 0a7: ldc "username"
      // 0a9: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 0ac: aload 0
      // 0ad: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0b0: astore 15
      // 0b2: aload 13
      // 0b4: aload 12
      // 0b6: ldc "clientId"
      // 0b8: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 0bb: aload 0
      // 0bc: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0bf: astore 25
      // 0c1: aload 13
      // 0c3: aload 12
      // 0c5: ldc "last_name"
      // 0c7: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 0ca: aload 0
      // 0cb: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0ce: astore 20
      // 0d0: aload 13
      // 0d2: aload 12
      // 0d4: ldc "email"
      // 0d6: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 0d9: aload 0
      // 0da: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0dd: astore 24
      // 0df: aload 13
      // 0e1: aload 12
      // 0e3: ldc "first_name"
      // 0e5: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 0e8: astore 4
      // 0ea: aload 4
      // 0ec: ifnull 3ab
      // 0ef: aload 4
      // 0f1: aload 0
      // 0f2: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0f5: astore 4
      // 0f7: aload 13
      // 0f9: aload 12
      // 0fb: ldc "display_name"
      // 0fd: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 100: astore 5
      // 102: aload 5
      // 104: ifnull 3a5
      // 107: aload 5
      // 109: aload 0
      // 10a: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 10d: astore 5
      // 10f: aload 13
      // 111: aload 12
      // 113: ldc "photoUrl"
      // 115: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 118: astore 6
      // 11a: aload 6
      // 11c: ifnull 39f
      // 11f: aload 6
      // 121: aload 0
      // 122: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 125: astore 6
      // 127: aload 13
      // 129: aload 12
      // 12b: ldc "thumbnailUrl"
      // 12d: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 130: astore 7
      // 132: aload 7
      // 134: ifnull 399
      // 137: aload 7
      // 139: aload 0
      // 13a: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 13d: astore 7
      // 13f: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 142: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.v ()Ljava/util/List;
      // 145: astore 26
      // 147: aload 26
      // 149: ifnull 393
      // 14c: aload 26
      // 14e: invokeinterface java/util/List.isEmpty ()Z 1
      // 153: ifne 393
      // 156: new java/util/HashMap
      // 159: astore 8
      // 15b: aload 8
      // 15d: invokespecial java/util/HashMap.<init> ()V
      // 160: aload 26
      // 162: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 167: astore 10
      // 169: aload 10
      // 16b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 170: ifeq 1ad
      // 173: aload 10
      // 175: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 17a: checkcast java/lang/String
      // 17d: astore 9
      // 17f: aload 13
      // 181: aload 12
      // 183: aload 9
      // 185: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 188: astore 11
      // 18a: aload 11
      // 18c: ifnull 169
      // 18f: aload 8
      // 191: aload 9
      // 193: aload 11
      // 195: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 198: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.t ()Ljava/lang/String;
      // 19b: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 19e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1a3: pop
      // 1a4: goto 169
      // 1a7: astore 0
      // 1a8: ldc com/salesforce/androidsdk/rest/ClientManager
      // 1aa: monitorexit
      // 1ab: aload 0
      // 1ac: athrow
      // 1ad: aload 13
      // 1af: aload 12
      // 1b1: ldc "clientSecret"
      // 1b3: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 1b6: astore 9
      // 1b8: aload 9
      // 1ba: ifnull 38d
      // 1bd: aload 9
      // 1bf: aload 0
      // 1c0: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 1c3: astore 9
      // 1c5: aload 13
      // 1c7: aload 12
      // 1c9: ldc "communityId"
      // 1cb: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 1ce: astore 10
      // 1d0: aload 10
      // 1d2: ifnull 387
      // 1d5: aload 10
      // 1d7: aload 0
      // 1d8: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 1db: astore 10
      // 1dd: aload 13
      // 1df: aload 12
      // 1e1: ldc "communityUrl"
      // 1e3: invokevirtual android/accounts/AccountManager.getUserData (Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
      // 1e6: astore 11
      // 1e8: aload 11
      // 1ea: ifnull 381
      // 1ed: aload 11
      // 1ef: aload 0
      // 1f0: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 1f3: astore 11
      // 1f5: aload 13
      // 1f7: aload 12
      // 1f9: ldc "authtoken"
      // 1fb: aload 19
      // 1fd: aload 1
      // 1fe: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 201: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 204: aload 13
      // 206: aload 12
      // 208: aload 21
      // 20a: aload 1
      // 20b: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 20e: invokevirtual android/accounts/AccountManager.setPassword (Landroid/accounts/Account;Ljava/lang/String;)V
      // 211: aload 13
      // 213: aload 12
      // 215: ldc "loginUrl"
      // 217: aload 18
      // 219: aload 1
      // 21a: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 21d: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 220: aload 13
      // 222: aload 12
      // 224: ldc "id"
      // 226: aload 16
      // 228: aload 1
      // 229: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 22c: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 22f: aload 13
      // 231: aload 12
      // 233: ldc "instanceUrl"
      // 235: aload 23
      // 237: aload 1
      // 238: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 23b: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 23e: aload 13
      // 240: aload 12
      // 242: ldc "orgId"
      // 244: aload 22
      // 246: aload 1
      // 247: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 24a: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 24d: aload 13
      // 24f: aload 12
      // 251: ldc "userId"
      // 253: aload 17
      // 255: aload 1
      // 256: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 259: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 25c: aload 13
      // 25e: aload 12
      // 260: ldc "username"
      // 262: aload 15
      // 264: aload 1
      // 265: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 268: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 26b: aload 13
      // 26d: aload 12
      // 26f: ldc "clientId"
      // 271: aload 25
      // 273: aload 1
      // 274: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 277: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 27a: aload 13
      // 27c: aload 12
      // 27e: ldc "last_name"
      // 280: aload 20
      // 282: aload 1
      // 283: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 286: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 289: aload 13
      // 28b: aload 12
      // 28d: ldc "email"
      // 28f: aload 24
      // 291: aload 1
      // 292: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 295: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 298: aload 4
      // 29a: ifnull 2ac
      // 29d: aload 13
      // 29f: aload 12
      // 2a1: ldc "first_name"
      // 2a3: aload 4
      // 2a5: aload 1
      // 2a6: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 2a9: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 2ac: aload 5
      // 2ae: ifnull 2c0
      // 2b1: aload 13
      // 2b3: aload 12
      // 2b5: ldc "display_name"
      // 2b7: aload 5
      // 2b9: aload 1
      // 2ba: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 2bd: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 2c0: aload 6
      // 2c2: ifnull 2d4
      // 2c5: aload 13
      // 2c7: aload 12
      // 2c9: ldc "photoUrl"
      // 2cb: aload 6
      // 2cd: aload 1
      // 2ce: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 2d1: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 2d4: aload 7
      // 2d6: ifnull 2e8
      // 2d9: aload 13
      // 2db: aload 12
      // 2dd: ldc "thumbnailUrl"
      // 2df: aload 7
      // 2e1: aload 1
      // 2e2: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 2e5: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 2e8: aload 8
      // 2ea: ifnull 33b
      // 2ed: aload 8
      // 2ef: invokeinterface java/util/Map.isEmpty ()Z 1
      // 2f4: ifne 33b
      // 2f7: aload 26
      // 2f9: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2fe: astore 5
      // 300: aload 5
      // 302: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 307: ifeq 33b
      // 30a: aload 5
      // 30c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 311: checkcast java/lang/String
      // 314: astore 6
      // 316: aload 8
      // 318: aload 6
      // 31a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 31f: checkcast java/lang/String
      // 322: astore 4
      // 324: aload 4
      // 326: ifnull 300
      // 329: aload 13
      // 32b: aload 12
      // 32d: aload 6
      // 32f: aload 4
      // 331: aload 1
      // 332: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 335: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 338: goto 300
      // 33b: aload 9
      // 33d: ifnull 34f
      // 340: aload 13
      // 342: aload 12
      // 344: ldc "clientSecret"
      // 346: aload 9
      // 348: aload 1
      // 349: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 34c: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 34f: aload 10
      // 351: ifnull 363
      // 354: aload 13
      // 356: aload 12
      // 358: ldc "communityId"
      // 35a: aload 10
      // 35c: aload 1
      // 35d: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 360: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 363: aload 11
      // 365: ifnull 377
      // 368: aload 13
      // 36a: aload 12
      // 36c: ldc "communityUrl"
      // 36e: aload 11
      // 370: aload 1
      // 371: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.d (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 374: invokevirtual android/accounts/AccountManager.setUserData (Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
      // 377: iinc 2 1
      // 37a: goto 031
      // 37d: ldc com/salesforce/androidsdk/rest/ClientManager
      // 37f: monitorexit
      // 380: return
      // 381: aconst_null
      // 382: astore 11
      // 384: goto 1f5
      // 387: aconst_null
      // 388: astore 10
      // 38a: goto 1dd
      // 38d: aconst_null
      // 38e: astore 9
      // 390: goto 1c5
      // 393: aconst_null
      // 394: astore 8
      // 396: goto 1ad
      // 399: aconst_null
      // 39a: astore 7
      // 39c: goto 13f
      // 39f: aconst_null
      // 3a0: astore 6
      // 3a2: goto 127
      // 3a5: aconst_null
      // 3a6: astore 5
      // 3a8: goto 10f
      // 3ab: aconst_null
      // 3ac: astore 4
      // 3ae: goto 0f7
      // try (2 -> 6): 188 null
      // try (8 -> 13): 188 null
      // try (15 -> 21): 188 null
      // try (30 -> 111): 188 null
      // try (113 -> 117): 188 null
      // try (117 -> 122): 188 null
      // try (124 -> 128): 188 null
      // try (128 -> 133): 188 null
      // try (135 -> 139): 188 null
      // try (139 -> 144): 188 null
      // try (146 -> 150): 188 null
      // try (150 -> 153): 188 null
      // try (155 -> 165): 188 null
      // try (165 -> 177): 188 null
      // try (179 -> 187): 188 null
      // try (193 -> 198): 188 null
      // try (200 -> 204): 188 null
      // try (204 -> 209): 188 null
      // try (211 -> 215): 188 null
      // try (215 -> 220): 188 null
      // try (222 -> 226): 188 null
      // try (226 -> 302): 188 null
      // try (304 -> 311): 188 null
      // try (313 -> 320): 188 null
      // try (322 -> 329): 188 null
      // try (331 -> 338): 188 null
      // try (340 -> 346): 188 null
      // try (346 -> 358): 188 null
      // try (360 -> 367): 188 null
      // try (370 -> 377): 188 null
      // try (379 -> 386): 188 null
      // try (388 -> 395): 188 null
   }

   public Bundle a(
      String var1,
      String var2,
      String var3,
      String var4,
      String var5,
      String var6,
      String var7,
      String var8,
      String var9,
      String var10,
      String var11,
      String var12,
      String var13,
      String var14,
      String var15,
      String var16,
      String var17,
      String var18,
      String var19,
      String var20,
      Map<String, String> var21
   ) {
      Bundle var22 = new Bundle();
      var22.putString("authAccount", var1);
      var22.putString("accountType", this.d());
      var22.putString("username", SalesforceSDKManager.d(var2, var11));
      var22.putString("loginUrl", SalesforceSDKManager.d(var6, var11));
      var22.putString("id", SalesforceSDKManager.d(var7, var11));
      var22.putString("instanceUrl", SalesforceSDKManager.d(var5, var11));
      var22.putString("clientId", SalesforceSDKManager.d(var8, var11));
      var22.putString("orgId", SalesforceSDKManager.d(var9, var11));
      var22.putString("userId", SalesforceSDKManager.d(var10, var11));
      if (var12 != null) {
         var22.putString("clientSecret", SalesforceSDKManager.d(var12, var11));
      }

      if (var13 != null) {
         var22.putString("communityId", SalesforceSDKManager.d(var13, var11));
      }

      if (var14 != null) {
         var22.putString("communityUrl", SalesforceSDKManager.d(var14, var11));
      }

      var22.putString("authtoken", SalesforceSDKManager.d(var4, var11));
      var22.putString("first_name", SalesforceSDKManager.d(var15, var11));
      var22.putString("last_name", SalesforceSDKManager.d(var16, var11));
      var22.putString("display_name", SalesforceSDKManager.d(var17, var11));
      var22.putString("email", SalesforceSDKManager.d(var18, var11));
      var22.putString("photoUrl", SalesforceSDKManager.d(var19, var11));
      var22.putString("thumbnailUrl", SalesforceSDKManager.d(var20, var11));
      List var24 = SalesforceSDKManager.a().v();
      if (var21 != null && !var21.isEmpty()) {
         for (String var25 : var24) {
            var6 = (String)var21.get(var25);
            if (var6 != null) {
               var22.putString(var25, SalesforceSDKManager.d(var6, var11));
            }
         }
      }

      Account var23 = new Account(var1, this.d());
      this.a.addAccountExplicitly(var23, SalesforceSDKManager.d(var3, var11), new Bundle());
      this.a.setAuthToken(var23, "authtoken", SalesforceSDKManager.d(var4, var11));

      for (String var27 : var22.keySet()) {
         this.a.setUserData(var23, var27, var22.getString(var27));
      }

      SalesforceSDKManager.a().o().a(var10, var9);
      return var22;
   }

   public RestClient a() {
      return new RestClient(new RestClient.UnauthenticatedClientInfo(), null, HttpAccess.a, null);
   }

   public RestClient a(Account var1) {
      if (var1 == null) {
         ClientManager.AccountInfoNotFoundException var26 = new ClientManager.AccountInfoNotFoundException("No user account found");
         SalesforceSDKLogger.c("ClientManager", "No user account found", var26);
         throw var26;
      }

      if (SalesforceSDKManager.a().D()) {
         ClientManager.AccountInfoNotFoundException var25 = new ClientManager.AccountInfoNotFoundException("User is logging out");
         SalesforceSDKLogger.c("ClientManager", "User is logging out", var25);
         throw var25;
      }

      String var4;
      if (SalesforceSDKManager.a().C()) {
         var4 = this.c.b;
      } else {
         var4 = SalesforceSDKManager.a().t();
      }

      String var11 = SalesforceSDKManager.e(this.a.getUserData(var1, "authtoken"), var4);
      String var20 = SalesforceSDKManager.e(this.a.getPassword(var1), var4);
      String var18 = SalesforceSDKManager.e(this.a.getUserData(var1, "loginUrl"), var4);
      String var16 = SalesforceSDKManager.e(this.a.getUserData(var1, "id"), var4);
      String var19 = SalesforceSDKManager.e(this.a.getUserData(var1, "instanceUrl"), var4);
      String var17 = SalesforceSDKManager.e(this.a.getUserData(var1, "orgId"), var4);
      String var9 = SalesforceSDKManager.e(this.a.getUserData(var1, "userId"), var4);
      String var14 = SalesforceSDKManager.e(this.a.getUserData(var1, "username"), var4);
      String var13 = this.a.getUserData(var1, "authAccount");
      String var15 = SalesforceSDKManager.e(this.a.getUserData(var1, "clientId"), var4);
      String var10 = SalesforceSDKManager.e(this.a.getUserData(var1, "last_name"), var4);
      String var12 = SalesforceSDKManager.e(this.a.getUserData(var1, "email"), var4);
      String var3 = this.a.getUserData(var1, "first_name");
      String var2 = null;
      if (var3 != null) {
         var2 = SalesforceSDKManager.e(var3, var4);
      }

      String var5 = this.a.getUserData(var1, "display_name");
      var3 = null;
      if (var5 != null) {
         var3 = SalesforceSDKManager.e(var5, var4);
      }

      String var6 = this.a.getUserData(var1, "photoUrl");
      var5 = null;
      if (var6 != null) {
         var5 = SalesforceSDKManager.e(var6, var4);
      }

      String var7 = this.a.getUserData(var1, "thumbnailUrl");
      var6 = null;
      if (var7 != null) {
         var6 = SalesforceSDKManager.e(var7, var4);
      }

      List var21 = SalesforceSDKManager.a().v();
      HashMap var8 = null;
      HashMap var31 = var8;
      if (var21 != null) {
         var31 = var8;
         if (!var21.isEmpty()) {
            var8 = new HashMap();
            Iterator var38 = var21.iterator();

            while (true) {
               var31 = var8;
               if (!var38.hasNext()) {
                  break;
               }

               String var22 = (String)var38.next();
               var7 = this.a.getUserData(var1, var22);
               if (var7 != null) {
                  var8.put(var22, SalesforceSDKManager.e(var7, SalesforceSDKManager.a().t()));
               }
            }
         }
      }

      String var39 = this.a.getUserData(var1, "communityId");
      String var34 = null;
      if (var39 != null) {
         var34 = SalesforceSDKManager.e(var39, var4);
      }

      String var40 = this.a.getUserData(var1, "communityUrl");
      String var24 = null;
      if (var40 != null) {
         var24 = SalesforceSDKManager.e(var40, var4);
      }

      if (var11 == null) {
         throw new ClientManager.AccountInfoNotFoundException("authtoken");
      }

      if (var19 == null) {
         throw new ClientManager.AccountInfoNotFoundException("instanceUrl");
      }

      if (var9 == null) {
         throw new ClientManager.AccountInfoNotFoundException("userId");
      }

      if (var17 == null) {
         throw new ClientManager.AccountInfoNotFoundException("orgId");
      }

      try {
         ClientManager.AccMgrAuthTokenProvider var28 = new ClientManager.AccMgrAuthTokenProvider(this, var19, var11, var20);
         URI var41 = new URI(var19);
         URI var36 = new URI(var18);
         URI var35 = new URI(var16);
         RestClient.ClientInfo var37 = new RestClient.ClientInfo(
            var15, var41, var36, var35, var13, var14, var9, var17, var34, var24, var2, var10, var3, var12, var5, var6, var31
         );
         return new RestClient(var37, var11, HttpAccess.a, var28);
      } catch (URISyntaxException var23) {
         SalesforceSDKLogger.b("ClientManager", "Invalid server URL", var23);
         throw new ClientManager.AccountInfoNotFoundException("invalid server url", var23);
      }
   }

   public RestClient a(UserAccount var1) {
      return this.a(this.b(var1.i()));
   }

   public void a(Account var1, AccountManagerCallback<Boolean> var2) {
      if (var1 != null) {
         this.a.removeAccount(var1, var2, null);
      }
   }

   public void a(Activity var1, ClientManager.RestClientCallback var2) {
      Account var3 = this.c();
      Bundle var4 = this.c.i();
      if (var3 == null) {
         SalesforceSDKLogger.c("ClientManager", "No account of type " + this.b + " found");
         this.a.addAccount(this.d(), "authtoken", null, var4, var1, new ClientManager.AccMgrCallback(this, var2), null);
      } else {
         SalesforceSDKLogger.c("ClientManager", "Found account of type " + this.b);
         var2.a(this.b());
      }
   }

   public void a(String var1) {
      this.a.invalidateAuthToken(this.d(), var1);
   }

   public void a(Account[] var1) {
      ArrayList var4 = new ArrayList();

      for (Account var5 : var1) {
         var4.add(this.a.removeAccount(var5, null, null));
      }

      for (AccountManagerFuture var8 : var4) {
         try {
            var8.getResult();
         } catch (Exception var6) {
            SalesforceSDKLogger.b("ClientManager", "Exception removing old account", var6);
         }
      }
   }

   public Account b(String var1) {
      Account[] var5 = this.a.getAccountsByType(this.d());
      if (var5 != null) {
         for (Account var4 : var5) {
            if (var4.name.equals(var1)) {
               return var4;
            }
         }
      }

      return null;
   }

   public RestClient b() {
      return this.a(this.c());
   }

   public Account c() {
      return SalesforceSDKManager.a().o().c();
   }

   public String d() {
      return this.b;
   }

   public static class AccMgrAuthTokenProvider implements RestClient.AuthTokenProvider {
      private boolean a;
      private final Object b = new Object();
      private final ClientManager c;
      private String d;
      private final String e;
      private String f;
      private long g = -1L;

      public AccMgrAuthTokenProvider(ClientManager var1, String var2, String var3, String var4) {
         this.c = var1;
         this.e = var4;
         this.d = var3;
         this.f = var2;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private Bundle a(Account var1) throws NetworkErrorException {
         String var6 = SalesforceSDKManager.a().t();
         Bundle var4 = new Bundle();
         Context var5 = SalesforceSDKManager.a().k();
         AccountManager var7 = AccountManager.get(var5);
         String var10 = SalesforceSDKManager.e(var7.getPassword(var1), var6);
         String var11 = SalesforceSDKManager.e(var7.getUserData(var1, "loginUrl"), var6);
         String var9 = SalesforceSDKManager.e(var7.getUserData(var1, "clientId"), var6);
         String var8 = SalesforceSDKManager.e(var7.getUserData(var1, "instanceUrl"), var6);
         String var2 = var7.getUserData(var1, "clientSecret");
         String var3;
         if (var2 != null) {
            var3 = SalesforceSDKManager.e(var2, var6);
         } else {
            var3 = null;
         }

         List var12 = SalesforceSDKManager.a().v();
         HashMap var32;
         if (var12 != null && !var12.isEmpty()) {
            var32 = new HashMap();

            for (String var13 : var12) {
               String var14 = var7.getUserData(var1, var13);
               if (var14 != null) {
                  var32.put(var13, SalesforceSDKManager.e(var14, var6));
               }
            }
         } else {
            var32 = null;
         }

         Map var39 = SalesforceSDKManager.a().h().h();

         label155: {
            label139: {
               try {
                  HttpAccess var41 = HttpAccess.a;
                  URI var40 = new URI(var11);
                  var33 = OAuth2.a(var41, var40, var9, var10, var3, var39);
                  if (!var8.equalsIgnoreCase(var33.c)) {
                     var7.setUserData(var1, "instanceUrl", SalesforceSDKManager.d(var33.c, var6));
                  }
               } catch (OAuth2.OAuthFailedException var28) {
                  var30 = var28;
                  if (var28.a()) {
                     break label155;
                  }
                  break label139;
               } catch (Exception var29) {
                  SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var29);
                  throw new NetworkErrorException(var29);
               }

               try {
                  var7.setUserData(var1, "authtoken", SalesforceSDKManager.d(var33.a, var6));
                  var4.putString("authtoken", SalesforceSDKManager.d(var33.a, var6));
                  var4.putString("instanceUrl", SalesforceSDKManager.d(var33.c, var6));
               } catch (OAuth2.OAuthFailedException var26) {
                  var30 = var26;
                  if (var26.a()) {
                     break label155;
                  }
                  break label139;
               } catch (Exception var27) {
                  SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var27);
                  throw new NetworkErrorException(var27);
               }

               if (var12 == null) {
                  return var4;
               }

               try {
                  if (var12.isEmpty()) {
                     return var4;
                  }

                  var35 = var12.iterator();
               } catch (OAuth2.OAuthFailedException var24) {
                  var30 = var24;
                  if (var24.a()) {
                     break label155;
                  }
                  break label139;
               } catch (Exception var25) {
                  SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var25);
                  throw new NetworkErrorException(var25);
               }

               label111:
               while (true) {
                  while (true) {
                     try {
                        if (!var35.hasNext()) {
                           return var4;
                        }

                        var8 = (String)var35.next();
                        if (var33.k != null && var33.k.containsKey(var8)) {
                           var10 = var33.k.get(var8);
                           break;
                        }
                     } catch (OAuth2.OAuthFailedException var22) {
                        var30 = var22;
                        if (var22.a()) {
                           break label155;
                        }
                        break label111;
                     } catch (Exception var23) {
                        SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var23);
                        throw new NetworkErrorException(var23);
                     }

                     if (var32 != null) {
                        try {
                           if (!var32.containsKey(var8)) {
                              continue;
                           }

                           var10 = (String)var32.get(var8);
                        } catch (OAuth2.OAuthFailedException var20) {
                           var30 = var20;
                           if (var20.a()) {
                              break label155;
                           }
                           break label111;
                        } catch (Exception var21) {
                           SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var21);
                           throw new NetworkErrorException(var21);
                        }

                        if (var10 != null) {
                           try {
                              var4.putString(var8, SalesforceSDKManager.d(var10, var6));
                           } catch (OAuth2.OAuthFailedException var18) {
                              var30 = var18;
                              if (var18.a()) {
                                 break label155;
                              }
                              break label111;
                           } catch (Exception var19) {
                              SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var19);
                              throw new NetworkErrorException(var19);
                           }
                        }
                     }
                  }

                  if (var10 != null) {
                     try {
                        var10 = SalesforceSDKManager.d(var10, var6);
                        var4.putString(var8, var10);
                        var7.setUserData(var1, var8, var10);
                     } catch (OAuth2.OAuthFailedException var16) {
                        var30 = var16;
                        if (var16.a()) {
                           break label155;
                        }
                        break;
                     } catch (Exception var17) {
                        SalesforceSDKLogger.b("ClientManager", "Exception thrown while getting new auth token", var17);
                        throw new NetworkErrorException(var17);
                     }
                  }
               }
            }

            var4.putString("errorCode", var30.b().a);
            var4.putString("errorMessage", var30.b().b);
            return var4;
         }

         SalesforceSDKLogger.c("ClientManager", "Invalid Refresh Token: (Error: " + var30.b().a + ", Status Code: " + var30.c() + ")", var30);
         return this.a(var5);
      }

      private Bundle a(Context var1) {
         Bundle var2 = new Bundle();
         Intent var3 = new Intent(var1, SalesforceSDKManager.a().f());
         var3.setPackage(var1.getPackageName());
         var3.setFlags(536870912);
         var2.putParcelable("intent", var3);
         return var2;
      }

      @Override
      public String a() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: aconst_null
         // 001: astore 4
         // 003: aconst_null
         // 004: astore 3
         // 005: aconst_null
         // 006: astore 2
         // 007: ldc "ClientManager"
         // 009: ldc_w "Need new access token"
         // 00c: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.c (Ljava/lang/String;Ljava/lang/String;)V
         // 00f: aload 0
         // 010: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.c Lcom/salesforce/androidsdk/rest/ClientManager;
         // 013: invokevirtual com/salesforce/androidsdk/rest/ClientManager.c ()Landroid/accounts/Account;
         // 016: astore 6
         // 018: aload 6
         // 01a: ifnonnull 01f
         // 01d: aload 2
         // 01e: areturn
         // 01f: aload 0
         // 020: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 023: astore 5
         // 025: aload 5
         // 027: monitorenter
         // 028: aload 0
         // 029: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.a Z
         // 02c: istore 1
         // 02d: iload 1
         // 02e: ifeq 055
         // 031: aload 0
         // 032: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 035: invokevirtual java/lang/Object.wait ()V
         // 038: aload 0
         // 039: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.d Ljava/lang/String;
         // 03c: astore 2
         // 03d: aload 5
         // 03f: monitorexit
         // 040: goto 01d
         // 043: astore 2
         // 044: aload 5
         // 046: monitorexit
         // 047: aload 2
         // 048: athrow
         // 049: astore 2
         // 04a: ldc "ClientManager"
         // 04c: ldc "Exception thrown while getting new auth token"
         // 04e: aload 2
         // 04f: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.b (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         // 052: goto 038
         // 055: aload 0
         // 056: bipush 1
         // 057: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.a Z
         // 05a: aload 5
         // 05c: monitorexit
         // 05d: aload 0
         // 05e: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.c Lcom/salesforce/androidsdk/rest/ClientManager;
         // 061: aload 6
         // 063: invokevirtual com/salesforce/androidsdk/rest/ClientManager.a (Landroid/accounts/Account;)Lcom/salesforce/androidsdk/rest/RestClient;
         // 066: invokevirtual com/salesforce/androidsdk/rest/RestClient.a ()Ljava/lang/String;
         // 069: astore 2
         // 06a: aload 0
         // 06b: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.c Lcom/salesforce/androidsdk/rest/ClientManager;
         // 06e: aload 2
         // 06f: invokevirtual com/salesforce/androidsdk/rest/ClientManager.a (Ljava/lang/String;)V
         // 072: aload 0
         // 073: aload 6
         // 075: invokespecial com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.a (Landroid/accounts/Account;)Landroid/os/Bundle;
         // 078: astore 5
         // 07a: aload 5
         // 07c: ifnonnull 0b8
         // 07f: ldc "ClientManager"
         // 081: ldc_w "Bundle was null while getting auth token"
         // 084: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.b (Ljava/lang/String;Ljava/lang/String;)V
         // 087: aconst_null
         // 088: astore 2
         // 089: aload 4
         // 08b: astore 3
         // 08c: aload 0
         // 08d: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 090: astore 4
         // 092: aload 4
         // 094: monitorenter
         // 095: aload 0
         // 096: bipush 0
         // 097: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.a Z
         // 09a: aload 0
         // 09b: aload 2
         // 09c: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.d Ljava/lang/String;
         // 09f: aload 0
         // 0a0: aload 3
         // 0a1: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.f Ljava/lang/String;
         // 0a4: aload 0
         // 0a5: invokestatic java/lang/System.currentTimeMillis ()J
         // 0a8: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.g J
         // 0ab: aload 0
         // 0ac: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 0af: invokevirtual java/lang/Object.notifyAll ()V
         // 0b2: aload 4
         // 0b4: monitorexit
         // 0b5: goto 01d
         // 0b8: aload 5
         // 0ba: ldc "authtoken"
         // 0bc: invokevirtual android/os/Bundle.getString (Ljava/lang/String;)Ljava/lang/String;
         // 0bf: astore 2
         // 0c0: aload 2
         // 0c1: ifnull 20e
         // 0c4: aload 2
         // 0c5: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
         // 0c8: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.t ()Ljava/lang/String;
         // 0cb: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         // 0ce: astore 2
         // 0cf: aload 5
         // 0d1: ldc "instanceUrl"
         // 0d3: invokevirtual android/os/Bundle.getString (Ljava/lang/String;)Ljava/lang/String;
         // 0d6: astore 4
         // 0d8: aload 4
         // 0da: ifnull 0e9
         // 0dd: aload 4
         // 0df: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
         // 0e2: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.t ()Ljava/lang/String;
         // 0e5: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.e (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         // 0e8: astore 3
         // 0e9: aload 2
         // 0ea: ifnonnull 172
         // 0ed: aload 0
         // 0ee: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.c Lcom/salesforce/androidsdk/rest/ClientManager;
         // 0f1: invokestatic com/salesforce/androidsdk/rest/ClientManager.a (Lcom/salesforce/androidsdk/rest/ClientManager;)Z
         // 0f4: ifeq 108
         // 0f7: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
         // 0fa: ifnonnull 100
         // 0fd: invokestatic android/os/Looper.prepare ()V
         // 100: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
         // 103: aconst_null
         // 104: bipush 0
         // 105: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.a (Landroid/app/Activity;Z)V
         // 108: new android/content/Intent
         // 10b: astore 4
         // 10d: aload 4
         // 10f: ldc_w "access_token_revoked"
         // 112: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
         // 115: aload 4
         // 117: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
         // 11a: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.k ()Landroid/content/Context;
         // 11d: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
         // 120: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
         // 123: pop
         // 124: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
         // 127: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.k ()Landroid/content/Context;
         // 12a: aload 4
         // 12c: invokevirtual android/content/Context.sendBroadcast (Landroid/content/Intent;)V
         // 12f: goto 08c
         // 132: astore 5
         // 134: aload 3
         // 135: astore 4
         // 137: aload 5
         // 139: astore 3
         // 13a: ldc "ClientManager"
         // 13c: ldc_w "Exception thrown while getting auth token"
         // 13f: aload 3
         // 140: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.b (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         // 143: aload 0
         // 144: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 147: astore 3
         // 148: aload 3
         // 149: monitorenter
         // 14a: aload 0
         // 14b: bipush 0
         // 14c: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.a Z
         // 14f: aload 0
         // 150: aload 2
         // 151: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.d Ljava/lang/String;
         // 154: aload 0
         // 155: aload 4
         // 157: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.f Ljava/lang/String;
         // 15a: aload 0
         // 15b: invokestatic java/lang/System.currentTimeMillis ()J
         // 15e: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.g J
         // 161: aload 0
         // 162: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 165: invokevirtual java/lang/Object.notifyAll ()V
         // 168: aload 3
         // 169: monitorexit
         // 16a: goto 0b5
         // 16d: astore 2
         // 16e: aload 3
         // 16f: monitorexit
         // 170: aload 2
         // 171: athrow
         // 172: aload 3
         // 173: ifnull 1c4
         // 176: aload 3
         // 177: aload 0
         // 178: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.f Ljava/lang/String;
         // 17b: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
         // 17e: ifne 1c4
         // 181: new android/content/Intent
         // 184: dup
         // 185: ldc_w "instance_url_updated"
         // 188: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
         // 18b: astore 4
         // 18d: goto 115
         // 190: astore 5
         // 192: aload 3
         // 193: astore 4
         // 195: aload 5
         // 197: astore 3
         // 198: aload 0
         // 199: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 19c: astore 5
         // 19e: aload 5
         // 1a0: monitorenter
         // 1a1: aload 0
         // 1a2: bipush 0
         // 1a3: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.a Z
         // 1a6: aload 0
         // 1a7: aload 2
         // 1a8: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.d Ljava/lang/String;
         // 1ab: aload 0
         // 1ac: aload 4
         // 1ae: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.f Ljava/lang/String;
         // 1b1: aload 0
         // 1b2: invokestatic java/lang/System.currentTimeMillis ()J
         // 1b5: putfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.g J
         // 1b8: aload 0
         // 1b9: getfield com/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider.b Ljava/lang/Object;
         // 1bc: invokevirtual java/lang/Object.notifyAll ()V
         // 1bf: aload 5
         // 1c1: monitorexit
         // 1c2: aload 3
         // 1c3: athrow
         // 1c4: new android/content/Intent
         // 1c7: astore 4
         // 1c9: aload 4
         // 1cb: ldc_w "access_token_refeshed"
         // 1ce: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
         // 1d1: ldc_w "tokenRefresh"
         // 1d4: aconst_null
         // 1d5: ldc "ClientManager"
         // 1d7: aconst_null
         // 1d8: invokestatic com/salesforce/androidsdk/analytics/EventBuilderHelper.a (Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
         // 1db: goto 115
         // 1de: astore 2
         // 1df: aload 4
         // 1e1: monitorexit
         // 1e2: aload 2
         // 1e3: athrow
         // 1e4: astore 2
         // 1e5: aload 5
         // 1e7: monitorexit
         // 1e8: aload 2
         // 1e9: athrow
         // 1ea: astore 3
         // 1eb: aconst_null
         // 1ec: astore 4
         // 1ee: aconst_null
         // 1ef: astore 2
         // 1f0: goto 198
         // 1f3: astore 3
         // 1f4: aconst_null
         // 1f5: astore 4
         // 1f7: goto 198
         // 1fa: astore 3
         // 1fb: goto 198
         // 1fe: astore 3
         // 1ff: aconst_null
         // 200: astore 4
         // 202: aconst_null
         // 203: astore 2
         // 204: goto 13a
         // 207: astore 3
         // 208: aconst_null
         // 209: astore 4
         // 20b: goto 13a
         // 20e: aconst_null
         // 20f: astore 2
         // 210: goto 0cf
         // try (22 -> 25): 36 null
         // try (27 -> 30): 41 java/lang/InterruptedException
         // try (27 -> 30): 36 null
         // try (30 -> 35): 36 null
         // try (37 -> 39): 36 null
         // try (42 -> 46): 36 null
         // try (47 -> 52): 36 null
         // try (62 -> 66): 261 java/lang/Exception
         // try (62 -> 66): 249 null
         // try (68 -> 71): 261 java/lang/Exception
         // try (68 -> 71): 249 null
         // try (80 -> 97): 239 null
         // try (98 -> 102): 261 java/lang/Exception
         // try (98 -> 102): 249 null
         // try (104 -> 109): 261 java/lang/Exception
         // try (104 -> 109): 249 null
         // try (109 -> 113): 267 java/lang/Exception
         // try (109 -> 113): 255 null
         // try (115 -> 120): 267 java/lang/Exception
         // try (115 -> 120): 255 null
         // try (122 -> 129): 149 java/lang/Exception
         // try (122 -> 129): 199 null
         // try (129 -> 133): 149 java/lang/Exception
         // try (129 -> 133): 199 null
         // try (133 -> 138): 149 java/lang/Exception
         // try (133 -> 138): 199 null
         // try (138 -> 148): 149 java/lang/Exception
         // try (138 -> 148): 199 null
         // try (154 -> 158): 259 null
         // try (163 -> 180): 181 null
         // try (182 -> 184): 181 null
         // try (188 -> 198): 149 java/lang/Exception
         // try (188 -> 198): 199 null
         // try (209 -> 226): 244 null
         // try (228 -> 238): 149 java/lang/Exception
         // try (228 -> 238): 199 null
         // try (240 -> 242): 239 null
         // try (245 -> 247): 244 null
      }

      @Override
      public long b() {
         return this.g;
      }

      @Override
      public String c() {
         return this.f;
      }
   }

   private class AccMgrCallback implements AccountManagerCallback<Bundle> {
      static final boolean a;
      final ClientManager b;
      private final ClientManager.RestClientCallback c;

      static {
         boolean var0;
         if (!ClientManager.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         a = var0;
      }

      AccMgrCallback(ClientManager var1, ClientManager.RestClientCallback var2) {
         this.b = var1;
         if (!a && var2 == null) {
            throw new AssertionError("you must supply a RestClientAvailable instance");
         }

         this.c = var2;
      }

      public void run(AccountManagerFuture<Bundle> var1) {
         Object var2 = null;

         try {
            var1.getResult();
            var4 = this.b.b();
         } catch (Exception var3) {
            SalesforceSDKLogger.b("ClientManager", "Exception thrown while creating rest client", var3);
            var4 = (RestClient)var2;
         }

         this.c.a(var4);
      }
   }

   public static class AccountInfoNotFoundException extends RuntimeException {
      AccountInfoNotFoundException(String var1) {
         super(var1);
      }

      public AccountInfoNotFoundException(String var1, Throwable var2) {
         super(var1, var2);
      }
   }

   public static class LoginOptions {
      private String a;
      private String b;
      private final String c;
      private final String d;
      private final String[] e;
      private String f;
      private String g;
      private Map<String, String> h;

      public LoginOptions(String var1, String var2, String var3, String var4, String[] var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }

      public LoginOptions(String var1, String var2, String var3, String var4, String[] var5, String var6) {
         this(var1, var2, var3, var4, var5);
         this.f = var6;
      }

      public LoginOptions(String var1, String var2, String var3, String var4, String[] var5, String var6, String var7) {
         this(var1, var2, var3, var4, var5, var6);
         this.a(var7);
      }

      public LoginOptions(String var1, String var2, String var3, String var4, String[] var5, String var6, String var7, Map<String, String> var8) {
         this(var1, var2, var3, var4, var5, var6, var7);
         this.h = var8;
      }

      public static ClientManager.LoginOptions a(Bundle var0) {
         HashMap var1 = null;
         Serializable var2 = var0.getSerializable("addlParams");
         if (var2 != null) {
            var1 = (HashMap)var2;
         }

         return new ClientManager.LoginOptions(
            var0.getString("loginUrl"),
            var0.getString("passcodeHash"),
            var0.getString("oauthCallbackUrl"),
            var0.getString("oauthClientId"),
            var0.getStringArray("oauthScopes"),
            var0.getString("clientSecret"),
            var0.getString("jwt"),
            var1
         );
      }

      public String a() {
         return this.a;
      }

      public void a(String var1) {
         this.g = var1;
      }

      public String b() {
         return this.b;
      }

      public void b(String var1) {
         this.a = var1;
      }

      public String c() {
         return this.c;
      }

      public void c(String var1) {
         this.a = var1;
      }

      public String d() {
         return this.d;
      }

      public void d(String var1) {
         this.b = var1;
      }

      public String[] e() {
         return this.e;
      }

      public String f() {
         return this.f;
      }

      public String g() {
         return this.g;
      }

      public Map<String, String> h() {
         return this.h;
      }

      public Bundle i() {
         Bundle var1 = new Bundle();
         var1.putString("loginUrl", this.a);
         var1.putString("passcodeHash", this.b);
         var1.putString("oauthCallbackUrl", this.c);
         var1.putString("oauthClientId", this.d);
         var1.putStringArray("oauthScopes", this.e);
         var1.putString("clientSecret", this.f);
         var1.putString("jwt", this.g);
         if (this.h != null && this.h.size() > 0) {
            HashMap var2 = new HashMap();
            var2.putAll(this.h);
            var1.putSerializable("addlParams", var2);
         }

         return var1;
      }
   }

   public interface RestClientCallback {
      void a(RestClient var1);
   }
}
