package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeDialogParameters {
   private static Bundle create(ShareLinkContent var0, boolean var1) {
      Bundle var2 = createBaseParameters(var0, var1);
      Utility.putNonEmptyString(var2, "TITLE", var0.getContentTitle());
      Utility.putNonEmptyString(var2, "DESCRIPTION", var0.getContentDescription());
      Utility.putUri(var2, "IMAGE", var0.getImageUrl());
      Utility.putNonEmptyString(var2, "QUOTE", var0.getQuote());
      return var2;
   }

   private static Bundle create(ShareMediaContent var0, List<Bundle> var1, boolean var2) {
      Bundle var3 = createBaseParameters(var0, var2);
      var3.putParcelableArrayList("MEDIA", new ArrayList(var1));
      return var3;
   }

   private static Bundle create(ShareOpenGraphContent var0, JSONObject var1, boolean var2) {
      Bundle var3 = createBaseParameters(var0, var2);
      Utility.putNonEmptyString(
         var3, "PREVIEW_PROPERTY_NAME", (String)ShareInternalUtility.getFieldNameAndNamespaceFromFullName(var0.getPreviewPropertyName()).second
      );
      Utility.putNonEmptyString(var3, "ACTION_TYPE", var0.getAction().getActionType());
      Utility.putNonEmptyString(var3, "ACTION", var1.toString());
      return var3;
   }

   private static Bundle create(SharePhotoContent var0, List<String> var1, boolean var2) {
      Bundle var3 = createBaseParameters(var0, var2);
      var3.putStringArrayList("PHOTOS", new ArrayList(var1));
      return var3;
   }

   private static Bundle create(ShareVideoContent var0, String var1, boolean var2) {
      Bundle var3 = createBaseParameters(var0, var2);
      Utility.putNonEmptyString(var3, "TITLE", var0.getContentTitle());
      Utility.putNonEmptyString(var3, "DESCRIPTION", var0.getContentDescription());
      Utility.putNonEmptyString(var3, "VIDEO", var1);
      return var3;
   }

   public static Bundle create(UUID var0, ShareContent var1, boolean var2) {
      Validate.notNull(var1, "shareContent");
      Validate.notNull(var0, "callId");
      Bundle var3 = null;
      if (var1 instanceof ShareLinkContent) {
         var3 = create((ShareLinkContent)var1, var2);
      } else if (var1 instanceof SharePhotoContent) {
         SharePhotoContent var5 = (SharePhotoContent)var1;
         var3 = create(var5, ShareInternalUtility.getPhotoUrls(var5, var0), var2);
      } else if (var1 instanceof ShareVideoContent) {
         ShareVideoContent var6 = (ShareVideoContent)var1;
         var3 = create(var6, ShareInternalUtility.getVideoUrl(var6, var0), var2);
      } else if (var1 instanceof ShareOpenGraphContent) {
         ShareOpenGraphContent var7 = (ShareOpenGraphContent)var1;

         try {
            var3 = create(var7, ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(var0, var7), false), var2);
         } catch (JSONException var4) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + var4.getMessage());
         }
      } else if (var1 instanceof ShareMediaContent) {
         ShareMediaContent var8 = (ShareMediaContent)var1;
         var3 = create(var8, ShareInternalUtility.getMediaInfos(var8, var0), var2);
      }

      return var3;
   }

   private static Bundle createBaseParameters(ShareContent var0, boolean var1) {
      Bundle var2 = new Bundle();
      Utility.putUri(var2, "LINK", var0.getContentUrl());
      Utility.putNonEmptyString(var2, "PLACE", var0.getPlaceId());
      Utility.putNonEmptyString(var2, "REF", var0.getRef());
      var2.putBoolean("DATA_FAILURES_FATAL", var1);
      List var3 = var0.getPeopleIds();
      if (!Utility.isNullOrEmpty(var3)) {
         var2.putStringArrayList("FRIENDS", new ArrayList(var3));
      }

      ShareHashtag var4 = var0.getShareHashtag();
      if (var4 != null) {
         Utility.putNonEmptyString(var2, "HASHTAG", var4.getHashtag());
      }

      return var2;
   }
}
