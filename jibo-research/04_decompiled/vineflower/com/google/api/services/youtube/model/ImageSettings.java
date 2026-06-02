package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ImageSettings extends GenericJson {
   @Key
   private LocalizedProperty backgroundImageUrl;
   @Key
   private String bannerExternalUrl;
   @Key
   private String bannerImageUrl;
   @Key
   private String bannerMobileExtraHdImageUrl;
   @Key
   private String bannerMobileHdImageUrl;
   @Key
   private String bannerMobileImageUrl;
   @Key
   private String bannerMobileLowImageUrl;
   @Key
   private String bannerMobileMediumHdImageUrl;
   @Key
   private String bannerTabletExtraHdImageUrl;
   @Key
   private String bannerTabletHdImageUrl;
   @Key
   private String bannerTabletImageUrl;
   @Key
   private String bannerTabletLowImageUrl;
   @Key
   private String bannerTvHighImageUrl;
   @Key
   private String bannerTvImageUrl;
   @Key
   private String bannerTvLowImageUrl;
   @Key
   private String bannerTvMediumImageUrl;
   @Key
   private LocalizedProperty largeBrandedBannerImageImapScript;
   @Key
   private LocalizedProperty largeBrandedBannerImageUrl;
   @Key
   private LocalizedProperty smallBrandedBannerImageImapScript;
   @Key
   private LocalizedProperty smallBrandedBannerImageUrl;
   @Key
   private String trackingImageUrl;
   @Key
   private String watchIconImageUrl;

   public ImageSettings clone() {
      return (ImageSettings)super.clone();
   }

   public LocalizedProperty getBackgroundImageUrl() {
      return this.backgroundImageUrl;
   }

   public String getBannerExternalUrl() {
      return this.bannerExternalUrl;
   }

   public String getBannerImageUrl() {
      return this.bannerImageUrl;
   }

   public String getBannerMobileExtraHdImageUrl() {
      return this.bannerMobileExtraHdImageUrl;
   }

   public String getBannerMobileHdImageUrl() {
      return this.bannerMobileHdImageUrl;
   }

   public String getBannerMobileImageUrl() {
      return this.bannerMobileImageUrl;
   }

   public String getBannerMobileLowImageUrl() {
      return this.bannerMobileLowImageUrl;
   }

   public String getBannerMobileMediumHdImageUrl() {
      return this.bannerMobileMediumHdImageUrl;
   }

   public String getBannerTabletExtraHdImageUrl() {
      return this.bannerTabletExtraHdImageUrl;
   }

   public String getBannerTabletHdImageUrl() {
      return this.bannerTabletHdImageUrl;
   }

   public String getBannerTabletImageUrl() {
      return this.bannerTabletImageUrl;
   }

   public String getBannerTabletLowImageUrl() {
      return this.bannerTabletLowImageUrl;
   }

   public String getBannerTvHighImageUrl() {
      return this.bannerTvHighImageUrl;
   }

   public String getBannerTvImageUrl() {
      return this.bannerTvImageUrl;
   }

   public String getBannerTvLowImageUrl() {
      return this.bannerTvLowImageUrl;
   }

   public String getBannerTvMediumImageUrl() {
      return this.bannerTvMediumImageUrl;
   }

   public LocalizedProperty getLargeBrandedBannerImageImapScript() {
      return this.largeBrandedBannerImageImapScript;
   }

   public LocalizedProperty getLargeBrandedBannerImageUrl() {
      return this.largeBrandedBannerImageUrl;
   }

   public LocalizedProperty getSmallBrandedBannerImageImapScript() {
      return this.smallBrandedBannerImageImapScript;
   }

   public LocalizedProperty getSmallBrandedBannerImageUrl() {
      return this.smallBrandedBannerImageUrl;
   }

   public String getTrackingImageUrl() {
      return this.trackingImageUrl;
   }

   public String getWatchIconImageUrl() {
      return this.watchIconImageUrl;
   }

   public ImageSettings set(String var1, Object var2) {
      return (ImageSettings)super.set(var1, var2);
   }

   public ImageSettings setBackgroundImageUrl(LocalizedProperty var1) {
      this.backgroundImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerExternalUrl(String var1) {
      this.bannerExternalUrl = var1;
      return this;
   }

   public ImageSettings setBannerImageUrl(String var1) {
      this.bannerImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerMobileExtraHdImageUrl(String var1) {
      this.bannerMobileExtraHdImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerMobileHdImageUrl(String var1) {
      this.bannerMobileHdImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerMobileImageUrl(String var1) {
      this.bannerMobileImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerMobileLowImageUrl(String var1) {
      this.bannerMobileLowImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerMobileMediumHdImageUrl(String var1) {
      this.bannerMobileMediumHdImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTabletExtraHdImageUrl(String var1) {
      this.bannerTabletExtraHdImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTabletHdImageUrl(String var1) {
      this.bannerTabletHdImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTabletImageUrl(String var1) {
      this.bannerTabletImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTabletLowImageUrl(String var1) {
      this.bannerTabletLowImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTvHighImageUrl(String var1) {
      this.bannerTvHighImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTvImageUrl(String var1) {
      this.bannerTvImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTvLowImageUrl(String var1) {
      this.bannerTvLowImageUrl = var1;
      return this;
   }

   public ImageSettings setBannerTvMediumImageUrl(String var1) {
      this.bannerTvMediumImageUrl = var1;
      return this;
   }

   public ImageSettings setLargeBrandedBannerImageImapScript(LocalizedProperty var1) {
      this.largeBrandedBannerImageImapScript = var1;
      return this;
   }

   public ImageSettings setLargeBrandedBannerImageUrl(LocalizedProperty var1) {
      this.largeBrandedBannerImageUrl = var1;
      return this;
   }

   public ImageSettings setSmallBrandedBannerImageImapScript(LocalizedProperty var1) {
      this.smallBrandedBannerImageImapScript = var1;
      return this;
   }

   public ImageSettings setSmallBrandedBannerImageUrl(LocalizedProperty var1) {
      this.smallBrandedBannerImageUrl = var1;
      return this;
   }

   public ImageSettings setTrackingImageUrl(String var1) {
      this.trackingImageUrl = var1;
      return this;
   }

   public ImageSettings setWatchIconImageUrl(String var1) {
      this.watchIconImageUrl = var1;
      return this;
   }
}
