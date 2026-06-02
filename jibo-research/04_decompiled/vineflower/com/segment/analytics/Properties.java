package com.segment.analytics;

import com.segment.analytics.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Properties extends ValueMap {
   private static final String CATEGORY_KEY = "category";
   private static final String COUPON_KEY = "coupon";
   private static final String CURRENCY_KEY = "currency";
   private static final String DISCOUNT_KEY = "discount";
   private static final String ID_KEY = "id";
   private static final String NAME_KEY = "name";
   private static final String ORDER_ID_KEY = "orderId";
   private static final String PATH_KEY = "path";
   private static final String PRICE_KEY = "price";
   private static final String PRODUCTS_KEY = "products";
   private static final String REFERRER_KEY = "referrer";
   private static final String REPEAT_KEY = "repeat";
   private static final String REVENUE_KEY = "revenue";
   private static final String SHIPPING_KEY = "shipping";
   private static final String SKU_KEY = "sku";
   private static final String SUBTOTAL_KEY = "subtotal";
   private static final String TAX_KEY = "tax";
   private static final String TITLE_KEY = "title";
   private static final String TOTAL_KEY = "total";
   private static final String URL_KEY = "url";
   private static final String VALUE_KEY = "value";

   public Properties() {
   }

   public Properties(int var1) {
      super(var1);
   }

   Properties(Map<String, Object> var1) {
      super(var1);
   }

   public String category() {
      return this.getString("category");
   }

   public String coupon() {
      return this.getString("coupon");
   }

   public String currency() {
      return this.getString("currency");
   }

   public double discount() {
      return this.getDouble("discount", 0.0);
   }

   public boolean isRepeatCustomer() {
      return this.getBoolean("repeat", false);
   }

   public String name() {
      return this.getString("name");
   }

   public String orderId() {
      return this.getString("orderId");
   }

   public String path() {
      return this.getString("path");
   }

   public double price() {
      return this.getDouble("price", 0.0);
   }

   public String productId() {
      return this.getString("id");
   }

   public List<Properties.Product> products() {
      return this.getList("products", Properties.Product.class);
   }

   public List<Properties.Product> products(Properties.Product... var1) {
      return this.products();
   }

   public Properties putCategory(String var1) {
      return this.putValue("category", var1);
   }

   public Properties putCoupon(String var1) {
      return this.putValue("coupon", var1);
   }

   public Properties putCurrency(String var1) {
      return this.putValue("currency", var1);
   }

   public Properties putDiscount(double var1) {
      return this.putValue("discount", var1);
   }

   public Properties putName(String var1) {
      return this.putValue("name", var1);
   }

   public Properties putOrderId(String var1) {
      return this.putValue("orderId", var1);
   }

   public Properties putPath(String var1) {
      return this.putValue("path", var1);
   }

   public Properties putPrice(double var1) {
      return this.putValue("price", var1);
   }

   public Properties putProductId(String var1) {
      return this.putValue("id", var1);
   }

   public Properties putProducts(Properties.Product... var1) {
      if (Utils.isNullOrEmpty(var1)) {
         throw new IllegalArgumentException("products cannot be null or empty.");
      }

      ArrayList var2 = new ArrayList(var1.length);
      Collections.addAll(var2, var1);
      return this.putValue("products", Collections.unmodifiableList(var2));
   }

   public Properties putReferrer(String var1) {
      return this.putValue("referrer", var1);
   }

   public Properties putRepeatCustomer(boolean var1) {
      return this.putValue("repeat", var1);
   }

   public Properties putRevenue(double var1) {
      return this.putValue("revenue", var1);
   }

   public Properties putShipping(double var1) {
      return this.putValue("shipping", var1);
   }

   public Properties putSku(String var1) {
      return this.putValue("sku", var1);
   }

   @Deprecated
   public double putSubtotal() {
      return this.subtotal();
   }

   public Properties putSubtotal(double var1) {
      return this.putValue("subtotal", var1);
   }

   public Properties putTax(double var1) {
      return this.putValue("tax", var1);
   }

   public Properties putTitle(String var1) {
      return this.putValue("title", var1);
   }

   public Properties putTotal(double var1) {
      return this.putValue("total", var1);
   }

   public Properties putUrl(String var1) {
      return this.putValue("url", var1);
   }

   public Properties putValue(double var1) {
      return this.putValue("value", var1);
   }

   public Properties putValue(String var1, Object var2) {
      super.putValue(var1, var2);
      return this;
   }

   public String referrer() {
      return this.getString("referrer");
   }

   public double revenue() {
      return this.getDouble("revenue", 0.0);
   }

   public double shipping() {
      return this.getDouble("shipping", 0.0);
   }

   public String sku() {
      return this.getString("sku");
   }

   public double subtotal() {
      return this.getDouble("subtotal", 0.0);
   }

   public double tax() {
      return this.getDouble("tax", 0.0);
   }

   public String title() {
      return this.getString("title");
   }

   public double total() {
      double var1 = this.getDouble("total", 0.0);
      if (var1 == 0.0) {
         double var3 = this.revenue();
         var1 = var3;
         if (var3 == 0.0) {
            var1 = this.value();
         }
      }

      return var1;
   }

   public String url() {
      return this.getString("url");
   }

   public double value() {
      double var1 = this.getDouble("value", 0.0);
      if (var1 == 0.0) {
         var1 = this.revenue();
      }

      return var1;
   }

   public static class Product extends ValueMap {
      private static final String ID_KEY = "id";
      private static final String NAME_KEY = "name";
      private static final String PRICE_KEY = "price";
      private static final String SKU_KEY = "sku";

      public Product(String var1, String var2, double var3) {
         this.put("id", var1);
         this.put("sku", var2);
         this.put("price", var3);
      }

      private Product(Map<String, Object> var1) {
         super(var1);
      }

      public String id() {
         return this.getString("id");
      }

      public String name() {
         return this.getString("name");
      }

      public double price() {
         return this.getDouble("price", 0.0);
      }

      public Properties.Product putName(String var1) {
         return this.putValue("name", var1);
      }

      public Properties.Product putValue(String var1, Object var2) {
         super.putValue(var1, var2);
         return this;
      }

      public String sku() {
         return this.getString("sku");
      }
   }
}
