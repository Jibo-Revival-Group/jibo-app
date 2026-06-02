package com.segment.analytics;

import android.content.Context;
import com.segment.analytics.internal.Utils;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Traits extends ValueMap {
   private static final String ADDRESS_KEY = "address";
   private static final String AGE_KEY = "age";
   private static final String ANONYMOUS_ID_KEY = "anonymousId";
   private static final String AVATAR_KEY = "avatar";
   private static final String BIRTHDAY_KEY = "birthday";
   private static final String CREATED_AT_KEY = "createdAt";
   private static final String DESCRIPTION_KEY = "description";
   private static final String EMAIL_KEY = "email";
   private static final String EMPLOYEES_KEY = "employees";
   private static final String FAX_KEY = "fax";
   private static final String FIRST_NAME_KEY = "firstName";
   private static final String GENDER_KEY = "gender";
   private static final String INDUSTRY_KEY = "industry";
   private static final String LAST_NAME_KEY = "lastName";
   private static final String NAME_KEY = "name";
   private static final String PHONE_KEY = "phone";
   private static final String TITLE_KEY = "title";
   private static final String USERNAME_KEY = "username";
   private static final String USER_ID_KEY = "userId";
   private static final String WEBSITE_KEY = "website";

   public Traits() {
   }

   public Traits(int var1) {
      super(var1);
   }

   Traits(Map<String, Object> var1) {
      super(var1);
   }

   static Traits create() {
      Traits var0 = new Traits(new Utils.NullableConcurrentHashMap<>());
      var0.putAnonymousId(UUID.randomUUID().toString());
      return var0;
   }

   public Traits.Address address() {
      return this.getValueMap("address", Traits.Address.class);
   }

   public int age() {
      return this.getInt("age", 0);
   }

   public String anonymousId() {
      return this.getString("anonymousId");
   }

   public String avatar() {
      return this.getString("avatar");
   }

   public Date birthday() {
      Object var1 = null;

      Date var4;
      try {
         String var2 = this.getString("birthday");
         if (Utils.isNullOrEmpty(var2)) {
            return (Date)var1;
         }

         var4 = Utils.toISO8601Date(var2);
      } catch (ParseException var3) {
         return (Date)var1;
      }

      return var4;
   }

   public String createdAt() {
      return this.getString("createdAt");
   }

   public String currentId() {
      String var2 = this.userId();
      String var1 = var2;
      if (Utils.isNullOrEmpty(var2)) {
         var1 = this.anonymousId();
      }

      return var1;
   }

   public String description() {
      return this.getString("description");
   }

   public String email() {
      return this.getString("email");
   }

   public long employees() {
      return this.getLong("employees", 0L);
   }

   public String fax() {
      return this.getString("fax");
   }

   public String firstName() {
      return this.getString("firstName");
   }

   public String gender() {
      return this.getString("gender");
   }

   public String industry() {
      return this.getString("industry");
   }

   public String lastName() {
      return this.getString("lastName");
   }

   public String name() {
      String var3 = this.getString("name");
      String var2;
      if (Utils.isNullOrEmpty(var3) && Utils.isNullOrEmpty(this.firstName()) && Utils.isNullOrEmpty(this.lastName())) {
         var2 = null;
      } else {
         var2 = var3;
         if (Utils.isNullOrEmpty(var3)) {
            StringBuilder var4 = new StringBuilder();
            var3 = this.firstName();
            boolean var1 = false;
            if (!Utils.isNullOrEmpty(var3)) {
               var1 = true;
               var4.append(var3);
            }

            var3 = this.lastName();
            if (!Utils.isNullOrEmpty(var3)) {
               if (var1) {
                  var4.append(' ');
               }

               var4.append(var3);
            }

            var2 = var4.toString();
         }
      }

      return var2;
   }

   public String phone() {
      return this.getString("phone");
   }

   public Traits putAddress(Traits.Address var1) {
      return this.putValue("address", var1);
   }

   public Traits putAge(int var1) {
      return this.putValue("age", var1);
   }

   Traits putAnonymousId(String var1) {
      return this.putValue("anonymousId", var1);
   }

   public Traits putAvatar(String var1) {
      return this.putValue("avatar", var1);
   }

   public Traits putBirthday(Date var1) {
      return this.putValue("birthday", Utils.toISO8601Date(var1));
   }

   public Traits putCreatedAt(String var1) {
      return this.putValue("createdAt", var1);
   }

   public Traits putDescription(String var1) {
      return this.putValue("description", var1);
   }

   public Traits putEmail(String var1) {
      return this.putValue("email", var1);
   }

   public Traits putEmployees(long var1) {
      return this.putValue("employees", var1);
   }

   public Traits putFax(String var1) {
      return this.putValue("fax", var1);
   }

   public Traits putFirstName(String var1) {
      return this.putValue("firstName", var1);
   }

   public Traits putGender(String var1) {
      return this.putValue("gender", var1);
   }

   public Traits putIndustry(String var1) {
      return this.putValue("industry", var1);
   }

   public Traits putLastName(String var1) {
      return this.putValue("lastName", var1);
   }

   public Traits putName(String var1) {
      return this.putValue("name", var1);
   }

   public Traits putPhone(String var1) {
      return this.putValue("phone", var1);
   }

   public Traits putTitle(String var1) {
      return this.putValue("title", var1);
   }

   Traits putUserId(String var1) {
      return this.putValue("userId", var1);
   }

   public Traits putUsername(String var1) {
      return this.putValue("username", var1);
   }

   public Traits putValue(String var1, Object var2) {
      super.putValue(var1, var2);
      return this;
   }

   public Traits putWebsite(String var1) {
      return this.putValue("website", var1);
   }

   public String title() {
      return this.getString("title");
   }

   public Traits unmodifiableCopy() {
      return new Traits(Collections.unmodifiableMap(new LinkedHashMap<>(this)));
   }

   public String userId() {
      return this.getString("userId");
   }

   public String username() {
      return this.getString("username");
   }

   public String website() {
      return this.getString("website");
   }

   public static class Address extends ValueMap {
      private static final String ADDRESS_CITY_KEY = "city";
      private static final String ADDRESS_COUNTRY_KEY = "country";
      private static final String ADDRESS_POSTAL_CODE_KEY = "postalCode";
      private static final String ADDRESS_STATE_KEY = "state";
      private static final String ADDRESS_STREET_KEY = "street";

      public Address() {
      }

      public Address(Map<String, Object> var1) {
         super(var1);
      }

      public String city() {
         return this.getString("city");
      }

      public String country() {
         return this.getString("country");
      }

      public String postalCode() {
         return this.getString("postalCode");
      }

      public Traits.Address putCity(String var1) {
         return this.putValue("city", var1);
      }

      public Traits.Address putCountry(String var1) {
         return this.putValue("country", var1);
      }

      public Traits.Address putPostalCode(String var1) {
         return this.putValue("postalCode", var1);
      }

      public Traits.Address putState(String var1) {
         return this.putValue("state", var1);
      }

      public Traits.Address putStreet(String var1) {
         return this.putValue("street", var1);
      }

      public Traits.Address putValue(String var1, Object var2) {
         super.putValue(var1, var2);
         return this;
      }

      public String state() {
         return this.getString("state");
      }

      public String street() {
         return this.getString("street");
      }
   }

   static class Cache extends ValueMap.Cache<Traits> {
      private static final String TRAITS_CACHE_PREFIX = "traits-";

      Cache(Context var1, Cartographer var2, String var3) {
         super(var1, var2, "traits-" + var3, var3, Traits.class);
      }

      public Traits create(Map<String, Object> var1) {
         return new Traits(new Utils.NullableConcurrentHashMap<>(var1));
      }
   }
}
