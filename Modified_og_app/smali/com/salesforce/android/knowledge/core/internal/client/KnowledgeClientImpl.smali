.class public Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;
.super Ljava/lang/Object;
.source "KnowledgeClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/KnowledgeClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

.field private final b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

.field private final c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

.field private final d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

.field private final e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

.field private final f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    .line 75
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    .line 76
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    .line 77
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    .line 78
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    .line 79
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    .line 80
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;
    .locals 1

    .prologue
    .line 70
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;-><init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 124
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    .line 125
    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 126
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 127
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 124
    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    .line 118
    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 119
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 120
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 117
    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    .line 132
    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 133
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 134
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 131
    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    .line 92
    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 93
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 94
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 91
    return-object v0
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/LogoutListener;)V
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Lcom/salesforce/android/knowledge/core/LogoutListener;)V

    .line 114
    return-void
.end method

.method public b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    return-object v0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Landroid/content/Context;)V

    .line 110
    return-void
.end method
