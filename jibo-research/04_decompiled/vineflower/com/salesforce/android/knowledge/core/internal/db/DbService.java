package com.salesforce.android.knowledge.core.internal.db;

import com.salesforce.android.knowledge.core.internal.model.DataCategoryGroupListModel;
import com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import java.util.concurrent.Executors;

public class DbService {
   private final DbHelper a;
   private final JobQueue b;

   DbService(DbService.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
   }

   public static DbService.Builder a(String var0, MobileSdkUserManager var1) {
      return new DbService.Builder(var0, var1);
   }

   public Async<DataCategoryGroupList> a() {
      DbRead var1 = DbRead.a(this.a.b(), DataCategoryGroupList.class).a(new DataCategoryGroupOperation.ReadList()).a();
      return this.b.a(var1);
   }

   public Async<Void> a(ArticleDetails var1) {
      DbWrite var2 = DbWrite.a(this.a.b()).a(new ArticleOperation.WriteDetails(var1)).a();
      return this.b.a(var2);
   }

   public Async<Void> a(DataCategoryGroup var1) {
      DbWrite var2 = DbWrite.a(this.a.b()).a(new DataCategoryGroupOperation.WriteList(DataCategoryGroupListModel.a(var1))).a();
      return this.b.a(var2);
   }

   public Async<ArticleDetails> a(ArticleDetailRequest var1) {
      DbRead var2 = DbRead.a(this.a.b(), ArticleDetails.class).a(new ArticleOperation.ReadDetails(var1)).a();
      return this.b.a(var2);
   }

   public Async<ArticleList> a(ArticleListRequest var1) {
      DbRead var2 = DbRead.a(this.a.b(), ArticleList.class).a(new ArticleOperation.ReadList(var1)).a();
      return this.b.a(var2);
   }

   public Async<Void> a(ArticleListRequest var1, ArticleList var2) {
      DbWrite.Builder var3 = DbWrite.a(this.a.b()).a(new ArticleOperation.WriteList(var2));
      if (var1.i() != null) {
         var3.a(new ArticleMappingOperation.WriteList(var1.i(), var2));
      }

      return this.b.a(var3.a());
   }

   public Async<DataCategoryList> a(DataCategoriesRequest var1) {
      DbRead var2 = DbRead.a(this.a.b(), DataCategoryList.class).a(new DataCategoryOperation.ReadList(var1)).a();
      return this.b.a(var2);
   }

   public static class Builder {
      DbHelper a;
      JobQueue b;
      private final String c;
      private final MobileSdkUserManager d;

      Builder(String var1, MobileSdkUserManager var2) {
         this.c = var1;
         this.d = var2;
      }

      public DbService a() {
         if (this.a == null) {
            this.a = new DbHelper(this.c, this.d);
         }

         if (this.b == null) {
            this.b = new JobQueue(Executors.newSingleThreadExecutor(PriorityThreadFactory.a()));
         }

         return new DbService(this);
      }
   }
}
