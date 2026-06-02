package com.google.android.gms.internal;

public enum zzaxb {
   @Deprecated
   zzeiy("ClientLoginDisabled"),
   @Deprecated
   zzeiz("DeviceManagementRequiredOrSyncDisabled"),
   @Deprecated
   zzeja("SocketTimeout"),
   zzejb("Ok"),
   zzejc("UNKNOWN_ERR"),
   zzejd("NetworkError"),
   zzeje("ServiceUnavailable"),
   zzejf("InternalError"),
   zzejg("BadAuthentication"),
   zzejh("EmptyConsumerPackageOrSig"),
   zzeji("InvalidSecondFactor"),
   zzejj("PostSignInFlowRequired"),
   zzejk("NeedsBrowser"),
   zzejl("Unknown"),
   zzejm("NotVerified"),
   zzejn("TermsNotAgreed"),
   zzejo("AccountDisabled"),
   zzejp("CaptchaRequired"),
   zzejq("AccountDeleted"),
   zzejr("ServiceDisabled"),
   zzejs("NeedPermission"),
   zzejt("NeedRemoteConsent"),
   zzeju("INVALID_SCOPE"),
   zzejv("UserCancel"),
   zzejw("PermissionDenied"),
   zzejx("INVALID_AUDIENCE"),
   zzejy("UNREGISTERED_ON_API_CONSOLE"),
   zzejz("ThirdPartyDeviceManagementRequired"),
   zzeka("DeviceManagementInternalError"),
   zzekb("DeviceManagementSyncDisabled"),
   zzekc("DeviceManagementAdminBlocked"),
   zzekd("DeviceManagementAdminPendingApproval"),
   zzeke("DeviceManagementStaleSyncRequired"),
   zzekf("DeviceManagementDeactivated"),
   zzekg("DeviceManagementScreenlockRequired"),
   zzekh("DeviceManagementRequired"),
   zzeki("ALREADY_HAS_GMAIL"),
   zzekj("WeakPassword"),
   zzekk("BadRequest"),
   zzekl("BadUsername"),
   zzekm("DeletedGmail"),
   zzekn("ExistingUsername"),
   zzeko("LoginFail"),
   zzekp("NotLoggedIn"),
   zzekq("NoGmail"),
   zzekr("RequestDenied"),
   zzeks("ServerError"),
   zzekt("UsernameUnavailable"),
   zzeku("GPlusOther"),
   zzekv("GPlusNickname"),
   zzekw("GPlusInvalidChar"),
   zzekx("GPlusInterstitial"),
   zzeky("ProfileUpgradeError");

   private static final zzaxb[] zzela = new zzaxb[]{
      zzeiy,
      zzeiz,
      zzeja,
      zzejb,
      zzejc,
      zzejd,
      zzeje,
      zzejf,
      zzejg,
      zzejh,
      zzeji,
      zzejj,
      zzejk,
      zzejl,
      zzejm,
      zzejn,
      zzejo,
      zzejp,
      zzejq,
      zzejr,
      zzejs,
      zzejt,
      zzeju,
      zzejv,
      zzejw,
      zzejx,
      zzejy,
      zzejz,
      zzeka,
      zzekb,
      zzekc,
      zzekd,
      zzeke,
      zzekf,
      zzekg,
      zzekh,
      zzeki,
      zzekj,
      zzekk,
      zzekl,
      zzekm,
      zzekn,
      zzeko,
      zzekp,
      zzekq,
      zzekr,
      zzeks,
      zzekt,
      zzeku,
      zzekv,
      zzekw,
      zzekx,
      zzeky
   };
   private final String zzekz;

   zzaxb(String var3) {
      this.zzekz = var3;
   }

   public static boolean zza(zzaxb var0) {
      boolean var1;
      if (!zzejg.equals(var0)
         && !zzejp.equals(var0)
         && !zzejs.equals(var0)
         && !zzejt.equals(var0)
         && !zzejk.equals(var0)
         && !zzejv.equals(var0)
         && !zzeiz.equals(var0)
         && !zzeka.equals(var0)
         && !zzekb.equals(var0)
         && !zzekc.equals(var0)
         && !zzekd.equals(var0)
         && !zzeke.equals(var0)
         && !zzekf.equals(var0)
         && !zzekh.equals(var0)
         && !zzejz.equals(var0)
         && !zzekg.equals(var0)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static final zzaxb zzfb(String var0) {
      zzaxb var3 = null;

      for (zzaxb var4 : values()) {
         if (var4.zzekz.equals(var0)) {
            var3 = var4;
         }
      }

      return var3;
   }
}
