package com.salesforce.android.knowledge.core.offline;

import android.text.Html;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArticleParser {
   private static final Pattern a = Pattern.compile("<img[^>]+src=\\\"([^\"]+)\\\"[^>]*>");
   private final String b;

   ArticleParser(String var1) {
      this.b = var1;
   }

   List<String> a(ArticleDetails var1) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = var1.f().iterator();

      while (var4.hasNext()) {
         String var6 = ((ArticleDetails.Field)var4.next()).c();
         if (var6 != null) {
            Matcher var5 = a.matcher(var6);

            while (var5.find()) {
               String var2 = var5.group(1);
               String var7;
               if (var2.startsWith("//")) {
                  var7 = "https:" + var2;
               } else {
                  var7 = var2;
                  if (var2.startsWith("/")) {
                     var7 = this.b + var2;
                  }
               }

               var3.add(Html.fromHtml(var7).toString());
            }
         }
      }

      return var3;
   }
}
