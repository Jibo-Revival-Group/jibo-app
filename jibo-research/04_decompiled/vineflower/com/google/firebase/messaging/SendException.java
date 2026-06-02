package com.google.firebase.messaging;

import java.util.Locale;

public final class SendException extends Exception {
   private final int a;

   SendException(String var1) {
      byte var3;
      label35: {
         var3 = 1;
         super(var1);
         if (var1 != null) {
            switch (var1.toLowerCase(Locale.US)) {
               case "invalid_parameters":
               case "missing_to":
                  break label35;
               case "messagetoobig":
                  var3 = 2;
                  break label35;
               case "service_not_available":
                  var3 = 3;
                  break label35;
               case "toomanymessages":
                  var3 = 4;
                  break label35;
            }
         }

         var3 = 0;
      }

      this.a = var3;
   }
}
