package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;

public class GameRequestValidation {
   public static void validate(GameRequestContent var0) {
      byte var3 = 0;
      Validate.notNull(var0.getMessage(), "message");
      boolean var1;
      if (var0.getObjectId() != null) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      boolean var2;
      if (var0.getActionType() != GameRequestContent.ActionType.ASKFOR && var0.getActionType() != GameRequestContent.ActionType.SEND) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      if (var1 ^ var2) {
         throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
      }

      var2 = var3;
      if (var0.getRecipients() != null) {
         var2 = (byte)1;
      }

      var1 = var2;
      if (var0.getSuggestions() != null) {
         var1 = var2 + 1;
      }

      var2 = var1;
      if (var0.getFilters() != null) {
         var2 = var1 + 1;
      }

      if (var2 > 1) {
         throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
      }
   }
}
