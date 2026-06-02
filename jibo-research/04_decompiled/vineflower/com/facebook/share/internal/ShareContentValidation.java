package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ShareContentValidation {
   private static ShareContentValidation.Validator ApiValidator;
   private static ShareContentValidation.Validator DefaultValidator;
   private static ShareContentValidation.Validator WebShareValidator;

   private static ShareContentValidation.Validator getApiValidator() {
      if (ApiValidator == null) {
         ApiValidator = new ShareContentValidation.ApiValidator();
      }

      return ApiValidator;
   }

   private static ShareContentValidation.Validator getDefaultValidator() {
      if (DefaultValidator == null) {
         DefaultValidator = new ShareContentValidation.Validator();
      }

      return DefaultValidator;
   }

   private static ShareContentValidation.Validator getWebShareValidator() {
      if (WebShareValidator == null) {
         WebShareValidator = new ShareContentValidation.WebShareValidator();
      }

      return WebShareValidator;
   }

   private static void validate(ShareContent var0, ShareContentValidation.Validator var1) throws FacebookException {
      if (var0 == null) {
         throw new FacebookException("Must provide non-null content to share");
      }

      if (var0 instanceof ShareLinkContent) {
         var1.validate((ShareLinkContent)var0);
      } else if (var0 instanceof SharePhotoContent) {
         var1.validate((SharePhotoContent)var0);
      } else if (var0 instanceof ShareVideoContent) {
         var1.validate((ShareVideoContent)var0);
      } else if (var0 instanceof ShareOpenGraphContent) {
         var1.validate((ShareOpenGraphContent)var0);
      } else if (var0 instanceof ShareMediaContent) {
         var1.validate((ShareMediaContent)var0);
      }
   }

   public static void validateForApiShare(ShareContent var0) {
      validate(var0, getApiValidator());
   }

   public static void validateForMessage(ShareContent var0) {
      validate(var0, getDefaultValidator());
   }

   public static void validateForNativeShare(ShareContent var0) {
      validate(var0, getDefaultValidator());
   }

   public static void validateForWebShare(ShareContent var0) {
      validate(var0, getWebShareValidator());
   }

   private static void validateLinkContent(ShareLinkContent var0, ShareContentValidation.Validator var1) {
      Uri var2 = var0.getImageUrl();
      if (var2 != null && !Utility.isWebUri(var2)) {
         throw new FacebookException("Image Url must be an http:// or https:// url");
      }
   }

   private static void validateMediaContent(ShareMediaContent var0, ShareContentValidation.Validator var1) {
      List var2 = var0.getMedia();
      if (var2 != null && !var2.isEmpty()) {
         if (var2.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
         }

         Iterator var3 = var2.iterator();

         while (var3.hasNext()) {
            var1.validate((ShareMedia)var3.next());
         }
      } else {
         throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
      }
   }

   public static void validateMedium(ShareMedia var0, ShareContentValidation.Validator var1) {
      if (var0 instanceof SharePhoto) {
         var1.validate((SharePhoto)var0);
      } else {
         if (!(var0 instanceof ShareVideo)) {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", var0.getClass().getSimpleName()));
         }

         var1.validate((ShareVideo)var0);
      }
   }

   private static void validateOpenGraphAction(ShareOpenGraphAction var0, ShareContentValidation.Validator var1) {
      if (var0 == null) {
         throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
      }

      if (Utility.isNullOrEmpty(var0.getActionType())) {
         throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
      }

      var1.validate(var0, false);
   }

   private static void validateOpenGraphContent(ShareOpenGraphContent var0, ShareContentValidation.Validator var1) {
      var1.validate(var0.getAction());
      String var2 = var0.getPreviewPropertyName();
      if (Utility.isNullOrEmpty(var2)) {
         throw new FacebookException("Must specify a previewPropertyName.");
      }

      if (var0.getAction().get(var2) == null) {
         throw new FacebookException(
            "Property \"" + var2 + "\" was not found on the action. The name of the preview property must match the name of an action property."
         );
      }
   }

   private static void validateOpenGraphKey(String var0, boolean var1) {
      if (var1) {
         String[] var4 = var0.split(":");
         if (var4.length < 2) {
            throw new FacebookException("Open Graph keys must be namespaced: %s", var0);
         }

         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            if (var4[var2].isEmpty()) {
               throw new FacebookException("Invalid key found in Open Graph dictionary: %s", var0);
            }
         }
      }
   }

   private static void validateOpenGraphObject(ShareOpenGraphObject var0, ShareContentValidation.Validator var1) {
      if (var0 == null) {
         throw new FacebookException("Cannot share a null ShareOpenGraphObject");
      }

      var1.validate(var0, true);
   }

   private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer var0, ShareContentValidation.Validator var1, boolean var2) {
      for (String var4 : var0.keySet()) {
         validateOpenGraphKey(var4, var2);
         Object var6 = var0.get(var4);
         if (var6 instanceof List) {
            for (Object var5 : (List)var6) {
               if (var5 == null) {
                  throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
               }

               validateOpenGraphValueContainerObject(var5, var1);
            }
         } else {
            validateOpenGraphValueContainerObject(var6, var1);
         }
      }
   }

   private static void validateOpenGraphValueContainerObject(Object var0, ShareContentValidation.Validator var1) {
      if (var0 instanceof ShareOpenGraphObject) {
         var1.validate((ShareOpenGraphObject)var0);
      } else if (var0 instanceof SharePhoto) {
         var1.validate((SharePhoto)var0);
      }
   }

   private static void validatePhoto(SharePhoto var0) {
      if (var0 == null) {
         throw new FacebookException("Cannot share a null SharePhoto");
      }

      Bitmap var1 = var0.getBitmap();
      Uri var2 = var0.getImageUrl();
      if (var1 == null && var2 == null) {
         throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
      }
   }

   private static void validatePhotoContent(SharePhotoContent var0, ShareContentValidation.Validator var1) {
      List var2 = var0.getPhotos();
      if (var2 != null && !var2.isEmpty()) {
         if (var2.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
         }

         Iterator var3 = var2.iterator();

         while (var3.hasNext()) {
            var1.validate((SharePhoto)var3.next());
         }
      } else {
         throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
      }
   }

   private static void validatePhotoForApi(SharePhoto var0, ShareContentValidation.Validator var1) {
      validatePhoto(var0);
      Bitmap var2 = var0.getBitmap();
      Uri var3 = var0.getImageUrl();
      if (var2 == null && Utility.isWebUri(var3) && !var1.isOpenGraphContent()) {
         throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
      }
   }

   private static void validatePhotoForNativeDialog(SharePhoto var0, ShareContentValidation.Validator var1) {
      validatePhotoForApi(var0, var1);
      if (var0.getBitmap() != null || !Utility.isWebUri(var0.getImageUrl())) {
         Validate.hasContentProvider(FacebookSdk.getApplicationContext());
      }
   }

   private static void validatePhotoForWebDialog(SharePhoto var0, ShareContentValidation.Validator var1) {
      validatePhoto(var0);
   }

   private static void validateVideo(ShareVideo var0, ShareContentValidation.Validator var1) {
      if (var0 == null) {
         throw new FacebookException("Cannot share a null ShareVideo");
      }

      Uri var2 = var0.getLocalUrl();
      if (var2 == null) {
         throw new FacebookException("ShareVideo does not have a LocalUrl specified");
      }

      if (!Utility.isContentUri(var2) && !Utility.isFileUri(var2)) {
         throw new FacebookException("ShareVideo must reference a video that is on the device");
      }
   }

   private static void validateVideoContent(ShareVideoContent var0, ShareContentValidation.Validator var1) {
      var1.validate(var0.getVideo());
      SharePhoto var2 = var0.getPreviewPhoto();
      if (var2 != null) {
         var1.validate(var2);
      }
   }

   private static class ApiValidator extends ShareContentValidation.Validator {
      private ApiValidator() {
      }

      @Override
      public void validate(ShareLinkContent var1) {
         if (!Utility.isNullOrEmpty(var1.getQuote())) {
            throw new FacebookException("Cannot share link content with quote using the share api");
         }
      }

      @Override
      public void validate(ShareMediaContent var1) {
         throw new FacebookException("Cannot share ShareMediaContent using the share api");
      }

      @Override
      public void validate(SharePhoto var1) {
         ShareContentValidation.validatePhotoForApi(var1, this);
      }

      @Override
      public void validate(ShareVideoContent var1) {
         if (!Utility.isNullOrEmpty(var1.getPlaceId())) {
            throw new FacebookException("Cannot share video content with place IDs using the share api");
         }

         if (!Utility.isNullOrEmpty(var1.getPeopleIds())) {
            throw new FacebookException("Cannot share video content with people IDs using the share api");
         }

         if (!Utility.isNullOrEmpty(var1.getRef())) {
            throw new FacebookException("Cannot share video content with referrer URL using the share api");
         }
      }
   }

   private static class Validator {
      private boolean isOpenGraphContent = false;

      private Validator() {
      }

      public boolean isOpenGraphContent() {
         return this.isOpenGraphContent;
      }

      public void validate(ShareLinkContent var1) {
         ShareContentValidation.validateLinkContent(var1, this);
      }

      public void validate(ShareMedia var1) {
         ShareContentValidation.validateMedium(var1, this);
      }

      public void validate(ShareMediaContent var1) {
         ShareContentValidation.validateMediaContent(var1, this);
      }

      public void validate(ShareOpenGraphAction var1) {
         ShareContentValidation.validateOpenGraphAction(var1, this);
      }

      public void validate(ShareOpenGraphContent var1) {
         this.isOpenGraphContent = true;
         ShareContentValidation.validateOpenGraphContent(var1, this);
      }

      public void validate(ShareOpenGraphObject var1) {
         ShareContentValidation.validateOpenGraphObject(var1, this);
      }

      public void validate(ShareOpenGraphValueContainer var1, boolean var2) {
         ShareContentValidation.validateOpenGraphValueContainer(var1, this, var2);
      }

      public void validate(SharePhoto var1) {
         ShareContentValidation.validatePhotoForNativeDialog(var1, this);
      }

      public void validate(SharePhotoContent var1) {
         ShareContentValidation.validatePhotoContent(var1, this);
      }

      public void validate(ShareVideo var1) {
         ShareContentValidation.validateVideo(var1, this);
      }

      public void validate(ShareVideoContent var1) {
         ShareContentValidation.validateVideoContent(var1, this);
      }
   }

   private static class WebShareValidator extends ShareContentValidation.Validator {
      private WebShareValidator() {
      }

      @Override
      public void validate(ShareMediaContent var1) {
         throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
      }

      @Override
      public void validate(SharePhoto var1) {
         ShareContentValidation.validatePhotoForWebDialog(var1, this);
      }

      @Override
      public void validate(ShareVideoContent var1) {
         throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
      }
   }
}
