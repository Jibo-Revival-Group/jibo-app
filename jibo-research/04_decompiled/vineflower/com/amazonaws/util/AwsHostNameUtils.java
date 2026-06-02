package com.amazonaws.util;

import com.amazonaws.regions.Regions;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AwsHostNameUtils {
   private static final Pattern S3_ENDPOINT_PATTERN = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");

   public static String parseRegionName(String var0, String var1) {
      if (var0.endsWith(".jibo.com")) {
         var0 = parseStandardRegionName(var0.substring(0, var0.length() - ".jibo.com".length()));
      } else {
         if (var1 != null) {
            Matcher var3 = Pattern.compile("^(?:.+\\.)?" + Pattern.quote(var1) + "[.-]([a-z0-9-]+)\\.").matcher(var0);
            if (var3.find()) {
               var0 = var3.group(1);
               return var0;
            }
         }

         var0 = "api-dev";
      }

      return var0;
   }

   @Deprecated
   public static String parseServiceName(URI var0) {
      String var2 = var0.getHost();
      if (!var2.endsWith("jibo.com")) {
         throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + var2 + ").");
      }

      String var1 = var2.substring(0, var2.indexOf(".jibo.com"));
      String var3;
      if (!var1.endsWith(".s3") && !S3_ENDPOINT_PATTERN.matcher(var1).matches()) {
         var3 = var1;
         if (var1.indexOf(46) != -1) {
            var3 = var1.substring(0, var1.indexOf(46));
         }
      } else {
         var3 = "s3";
      }

      return var3;
   }

   private static String parseStandardRegionName(String var0) {
      return Regions.ApiDev.getName();
   }
}
