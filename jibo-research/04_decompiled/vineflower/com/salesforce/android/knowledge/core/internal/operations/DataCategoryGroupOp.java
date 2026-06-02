package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.internal.model.DataCategoryGroupListModel;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;

public class DataCategoryGroupOp extends KnowledgeFetchSaveOp<DataCategoryGroupRequest, DataCategoryGroup> {
   final String a;

   public DataCategoryGroupOp(DataCategoryGroupRequest var1, DbService var2, HttpService var3) {
      super(var1, var2, var3);
      this.a = var1.a();
   }

   protected Async<DataCategoryGroup> a(DbService var1, DataCategoryGroupRequest var2) {
      return var1.a().a(new Function<DataCategoryGroupList, DataCategoryGroup>(this) {
         final DataCategoryGroupOp a;

         {
            this.a = var1;
         }

         public DataCategoryGroup a(DataCategoryGroupList var1) {
            for (DataCategoryGroup var3 : var1.a()) {
               if (var3.a().equals(this.a.a)) {
                  return var3;
               }
            }

            throw new DataCategoryGroupOp.DataCategoryGroupNotFoundException(this.a.a);
         }
      });
   }

   protected Async<Void> a(DbService var1, DataCategoryGroupRequest var2, DataCategoryGroup var3) {
      return var1.a(var3);
   }

   protected Async<DataCategoryGroup> a(HttpService var1, DataCategoryGroupRequest var2) {
      return var1.a().a(new Function<DataCategoryGroupsResponse, DataCategoryGroup>(this) {
         final DataCategoryGroupOp a;

         {
            this.a = var1;
         }

         public DataCategoryGroup a(DataCategoryGroupsResponse var1) {
            for (DataCategoryGroup var2x : DataCategoryGroupListModel.a(var1).a()) {
               if (var2x.a().equals(this.a.a)) {
                  return var2x;
               }
            }

            throw new DataCategoryGroupOp.DataCategoryGroupNotFoundException(this.a.a);
         }
      });
   }

   @Override
   protected String b() {
      return "Could not fetch DataCategoryGroup";
   }

   public static class DataCategoryGroupNotFoundException extends RuntimeException {
      public DataCategoryGroupNotFoundException(String var1) {
         super("Data category with the name \"" + var1 + "\" does not exist.");
      }
   }
}
