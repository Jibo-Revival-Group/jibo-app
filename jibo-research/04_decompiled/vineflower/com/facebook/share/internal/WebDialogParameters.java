package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.Locale;
import org.json.JSONException;

public class WebDialogParameters {
   public static Bundle create(AppGroupCreationContent var0) {
      Bundle var1 = new Bundle();
      Utility.putNonEmptyString(var1, "name", var0.getName());
      Utility.putNonEmptyString(var1, "description", var0.getDescription());
      AppGroupCreationContent.AppGroupPrivacy var2 = var0.getAppGroupPrivacy();
      if (var2 != null) {
         Utility.putNonEmptyString(var1, "privacy", var2.toString().toLowerCase(Locale.ENGLISH));
      }

      return var1;
   }

   public static Bundle create(GameRequestContent var0) {
      Bundle var1 = new Bundle();
      Utility.putNonEmptyString(var1, "message", var0.getMessage());
      Utility.putCommaSeparatedStringList(var1, "to", var0.getRecipients());
      Utility.putNonEmptyString(var1, "title", var0.getTitle());
      Utility.putNonEmptyString(var1, "data", var0.getData());
      if (var0.getActionType() != null) {
         Utility.putNonEmptyString(var1, "action_type", var0.getActionType().toString().toLowerCase(Locale.ENGLISH));
      }

      Utility.putNonEmptyString(var1, "object_id", var0.getObjectId());
      if (var0.getFilters() != null) {
         Utility.putNonEmptyString(var1, "filters", var0.getFilters().toString().toLowerCase(Locale.ENGLISH));
      }

      Utility.putCommaSeparatedStringList(var1, "suggestions", var0.getSuggestions());
      return var1;
   }

   public static Bundle create(ShareLinkContent var0) {
      Bundle var1 = createBaseParameters(var0);
      Utility.putUri(var1, "href", var0.getContentUrl());
      Utility.putNonEmptyString(var1, "quote", var0.getQuote());
      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Bundle create(ShareOpenGraphContent var0) {
      Bundle var1 = createBaseParameters(var0);
      Utility.putNonEmptyString(var1, "action_type", var0.getAction().getActionType());

      try {
         var4 = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(var0), false);
      } catch (JSONException var3) {
         throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", var3);
      }

      if (var4 != null) {
         try {
            Utility.putNonEmptyString(var1, "action_properties", var4.toString());
         } catch (JSONException var2) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", var2);
         }
      }

      return var1;
   }

   public static Bundle create(SharePhotoContent var0) {
      Bundle var2 = createBaseParameters(var0);
      String[] var1 = new String[var0.getPhotos().size()];
      Utility.map(var0.getPhotos(), new Utility.Mapper<SharePhoto, String>() {
         public String apply(SharePhoto var1) {
            return var1.getImageUrl().toString();
         }
      }).toArray(var1);
      var2.putStringArray("media", var1);
      return var2;
   }

   public static Bundle createBaseParameters(ShareContent var0) {
      Bundle var1 = new Bundle();
      ShareHashtag var2 = var0.getShareHashtag();
      if (var2 != null) {
         Utility.putNonEmptyString(var1, "hashtag", var2.getHashtag());
      }

      return var1;
   }

   public static Bundle createForFeed(ShareFeedContent var0) {
      Bundle var1 = new Bundle();
      Utility.putNonEmptyString(var1, "to", var0.getToId());
      Utility.putNonEmptyString(var1, "link", var0.getLink());
      Utility.putNonEmptyString(var1, "picture", var0.getPicture());
      Utility.putNonEmptyString(var1, "source", var0.getMediaSource());
      Utility.putNonEmptyString(var1, "name", var0.getLinkName());
      Utility.putNonEmptyString(var1, "caption", var0.getLinkCaption());
      Utility.putNonEmptyString(var1, "description", var0.getLinkDescription());
      return var1;
   }

   public static Bundle createForFeed(ShareLinkContent var0) {
      Bundle var1 = new Bundle();
      Utility.putNonEmptyString(var1, "name", var0.getContentTitle());
      Utility.putNonEmptyString(var1, "description", var0.getContentDescription());
      Utility.putNonEmptyString(var1, "link", Utility.getUriString(var0.getContentUrl()));
      Utility.putNonEmptyString(var1, "picture", Utility.getUriString(var0.getImageUrl()));
      Utility.putNonEmptyString(var1, "quote", var0.getQuote());
      if (var0.getShareHashtag() != null) {
         Utility.putNonEmptyString(var1, "hashtag", var0.getShareHashtag().getHashtag());
      }

      return var1;
   }
}
