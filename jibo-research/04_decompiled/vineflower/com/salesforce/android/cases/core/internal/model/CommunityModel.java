package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CommunitiesListResponse;
import com.salesforce.android.cases.core.model.Community;

public class CommunityModel implements Community {
   private String a;
   private String b;

   private CommunityModel(CommunitiesListResponse.Community var1) {
      this.a = var1.a();
      this.b = var1.b();
   }

   public static CommunityModel a(CommunitiesListResponse.Community var0) {
      return new CommunityModel(var0);
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public String b() {
      return this.b;
   }
}
