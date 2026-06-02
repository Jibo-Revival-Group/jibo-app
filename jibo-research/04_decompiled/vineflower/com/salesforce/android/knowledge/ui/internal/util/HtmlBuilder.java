package com.salesforce.android.knowledge.ui.internal.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HtmlBuilder {
   final Map<String, String[]> a = new HashMap<>();
   final StringBuilder b = new StringBuilder("<!doctype html><html><head>");
   final StringBuilder c = new StringBuilder();
   final List<String> d = new ArrayList<>();
   final List<String> e = new ArrayList<>();

   private HtmlBuilder() {
   }

   public static HtmlBuilder a() {
      return new HtmlBuilder();
   }

   public HtmlBuilder a(String var1) {
      this.b.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"").append(var1).append("\"/>");
      return this;
   }

   public HtmlBuilder a(String var1, String var2) {
      this.c.append("<p class=\"").append(var1).append("\">").append(var2).append("</p>");
      return this;
   }

   public HtmlBuilder a(String var1, String... var2) {
      this.a.put(var1, var2);
      return this;
   }

   public HtmlBuilder b() {
      this.c.append("<section>");
      return this;
   }

   public HtmlBuilder b(String var1) {
      this.d.add(var1);
      return this;
   }

   public HtmlBuilder c() {
      this.c.append("</section>");
      return this;
   }

   public HtmlBuilder c(String var1) {
      this.e.add(var1);
      return this;
   }

   public HtmlBuilder d(String var1) {
      this.c.append("<h1>").append(var1).append("</h1>");
      return this;
   }

   public String d() {
      this.b.append("<style type=\"text/css\">");

      for (Entry var4 : this.a.entrySet()) {
         this.b.append((String)var4.getKey()).append("{");

         for (String var5 : (String[])var4.getValue()) {
            this.b.append(var5).append(";");
         }

         this.b.append("}");
      }

      this.b.append("</style>");

      for (String var9 : this.d) {
         this.b.append("<style type=\"text/css\">");
         this.b.append(var9);
         this.b.append("</style>");
      }

      for (String var7 : this.e) {
         this.c.append("<script>");
         this.c.append(var7);
         this.c.append("</script>");
      }

      return this.b.append("</head><body>").append(this.c).append("</body></html>").toString();
   }

   public HtmlBuilder e(String var1) {
      this.c.append("<p>").append(var1).append("</p>");
      return this;
   }
}
