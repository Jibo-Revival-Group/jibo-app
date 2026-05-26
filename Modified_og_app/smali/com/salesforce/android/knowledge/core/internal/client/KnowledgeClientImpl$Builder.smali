.class public Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;
.super Ljava/lang/Object;
.source "KnowledgeClientImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

.field b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

.field c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

.field d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

.field final e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

.field f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)V
    .locals 0

    .prologue
    .line 149
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 150
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    .line 151
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    if-nez v0, :cond_0

    .line 180
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->e()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;-><init>(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->d()Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    .line 183
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    if-nez v0, :cond_1

    .line 184
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->c:Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;

    .line 186
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    if-nez v0, :cond_2

    .line 187
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-static {v0, v1, v2, v3, v4}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    .line 189
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    if-nez v0, :cond_3

    .line 190
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    .line 193
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    if-nez v0, :cond_4

    .line 194
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->e:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->f:Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    .line 197
    :cond_4
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;-><init>(Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;)V

    return-object v0
.end method
