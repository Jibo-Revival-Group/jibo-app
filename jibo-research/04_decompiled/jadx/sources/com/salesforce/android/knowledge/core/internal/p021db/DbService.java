package com.salesforce.android.knowledge.core.internal.p021db;

import com.salesforce.android.knowledge.core.internal.model.DataCategoryGroupListModel;
import com.salesforce.android.knowledge.core.internal.p021db.ArticleMappingOperation;
import com.salesforce.android.knowledge.core.internal.p021db.ArticleOperation;
import com.salesforce.android.knowledge.core.internal.p021db.DataCategoryGroupOperation;
import com.salesforce.android.knowledge.core.internal.p021db.DataCategoryOperation;
import com.salesforce.android.knowledge.core.internal.p021db.DbWrite;
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

/* JADX INFO: loaded from: classes.dex */
public class DbService {

    /* JADX INFO: renamed from: a */
    private final DbHelper f12918a;

    /* JADX INFO: renamed from: b */
    private final JobQueue f12919b;

    DbService(Builder builder) {
        this.f12918a = builder.f12920a;
        this.f12919b = builder.f12921b;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13130a(String str, MobileSdkUserManager mobileSdkUserManager) {
        return new Builder(str, mobileSdkUserManager);
    }

    /* JADX INFO: renamed from: a */
    public Async<Void> m13133a(DataCategoryGroup dataCategoryGroup) {
        return this.f12919b.m14223a(DbWrite.m13142a(this.f12918a.m13125b()).m13143a(new DataCategoryGroupOperation.WriteList(DataCategoryGroupListModel.m13234a(dataCategoryGroup))).m13144a());
    }

    /* JADX INFO: renamed from: a */
    public Async<DataCategoryGroupList> m13131a() {
        return this.f12919b.m14223a(DbRead.m13127a(this.f12918a.m13125b(), DataCategoryGroupList.class).m13128a(new DataCategoryGroupOperation.ReadList()).m13129a());
    }

    /* JADX INFO: renamed from: a */
    public Async<DataCategoryList> m13137a(DataCategoriesRequest dataCategoriesRequest) {
        return this.f12919b.m14223a(DbRead.m13127a(this.f12918a.m13125b(), DataCategoryList.class).m13128a(new DataCategoryOperation.ReadList(dataCategoriesRequest)).m13129a());
    }

    /* JADX INFO: renamed from: a */
    public Async<ArticleList> m13135a(ArticleListRequest articleListRequest) {
        return this.f12919b.m14223a(DbRead.m13127a(this.f12918a.m13125b(), ArticleList.class).m13128a(new ArticleOperation.ReadList(articleListRequest)).m13129a());
    }

    /* JADX INFO: renamed from: a */
    public Async<ArticleDetails> m13134a(ArticleDetailRequest articleDetailRequest) {
        return this.f12919b.m14223a(DbRead.m13127a(this.f12918a.m13125b(), ArticleDetails.class).m13128a(new ArticleOperation.ReadDetails(articleDetailRequest)).m13129a());
    }

    /* JADX INFO: renamed from: a */
    public Async<Void> m13136a(ArticleListRequest articleListRequest, ArticleList articleList) {
        DbWrite.Builder builderM13143a = DbWrite.m13142a(this.f12918a.m13125b()).m13143a(new ArticleOperation.WriteList(articleList));
        if (articleListRequest.m13317i() != null) {
            builderM13143a.m13143a(new ArticleMappingOperation.WriteList(articleListRequest.m13317i(), articleList));
        }
        return this.f12919b.m14223a(builderM13143a.m13144a());
    }

    /* JADX INFO: renamed from: a */
    public Async<Void> m13132a(ArticleDetails articleDetails) {
        return this.f12919b.m14223a(DbWrite.m13142a(this.f12918a.m13125b()).m13143a(new ArticleOperation.WriteDetails(articleDetails)).m13144a());
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        DbHelper f12920a;

        /* JADX INFO: renamed from: b */
        JobQueue f12921b;

        /* JADX INFO: renamed from: c */
        private final String f12922c;

        /* JADX INFO: renamed from: d */
        private final MobileSdkUserManager f12923d;

        Builder(String str, MobileSdkUserManager mobileSdkUserManager) {
            this.f12922c = str;
            this.f12923d = mobileSdkUserManager;
        }

        /* JADX INFO: renamed from: a */
        public DbService m13138a() {
            if (this.f12920a == null) {
                this.f12920a = new DbHelper(this.f12922c, this.f12923d);
            }
            if (this.f12921b == null) {
                this.f12921b = new JobQueue(Executors.newSingleThreadExecutor(PriorityThreadFactory.m14230a()));
            }
            return new DbService(this);
        }
    }
}
