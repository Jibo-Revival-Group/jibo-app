package com.salesforce.android.knowledge.core.model;

import java.util.Date;
import java.util.List;

public interface ArticleDetails extends ArticleSummary {
   int a();

   Date b();

   Date c();

   ChatterUser d();

   ChatterUser e();

   List<ArticleDetails.Field> f();

   interface Field {
      String a();

      String b();

      String c();

      int d();
   }
}
