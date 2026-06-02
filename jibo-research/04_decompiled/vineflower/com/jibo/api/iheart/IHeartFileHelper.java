package com.jibo.api.iheart;

import android.content.Context;
import com.jibo.api.iheart.model.Genre;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IHeartFileHelper {
   private static final HashMap<String, String> a = new HashMap<>();

   static {
      a.put("CA", "NPR");
   }

   private static String a(Context var0) throws IOException {
      InputStream var2 = var0.getResources().openRawResource(2131689472);
      byte[] var1 = new byte[var2.available()];
      var2.read(var1);
      var2.close();
      return new String(var1, "UTF-8");
   }

   public static List<Genre> a(Context var0, String var1) throws JSONException, IOException {
      ArrayList var3 = new ArrayList();
      String var5 = a(var0);
      if (var5 != null) {
         JSONArray var6 = new JSONArray(var5);

         for (int var2 = 0; var2 < var6.length(); var2++) {
            JSONObject var4 = var6.getJSONObject(var2);
            if (!a(var4, var1)) {
               var3.add(new Genre(var4.getInt("id"), var4.getString("name")));
            }
         }
      }

      return var3;
   }

   private static boolean a(JSONObject var0, String var1) throws JSONException {
      var1 = a.get(var1);
      String var3 = var0.getString("name");
      boolean var2;
      if (var1 != null && var1.toLowerCase().contains(var3.toLowerCase())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
