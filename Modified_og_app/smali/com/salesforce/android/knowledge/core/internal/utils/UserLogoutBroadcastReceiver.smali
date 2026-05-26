.class public Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "UserLogoutBroadcastReceiver.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;
    }
.end annotation


# static fields
.field private static final b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

.field private c:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field private d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

.field private e:Lcom/salesforce/android/service/common/http/HttpClient;

.field private final f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/LogoutListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 70
    const-class v0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;)V
    .locals 3

    .prologue
    .line 89
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 90
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->f:Ljava/util/List;

    .line 91
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->b()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    .line 93
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->a()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->a()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->a()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 95
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->c()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.USERSWITCHED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 96
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->c()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.LOGOUT_COMPLETE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Z)V

    .line 99
    return-void

    .line 98
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Z)V
    .locals 2

    .prologue
    .line 181
    if-eqz p1, :cond_0

    .line 182
    sget-object v0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Setting up authenticated Kb access."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 183
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->E()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestClient;->d()Lokhttp3/OkHttpClient;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->a(Lokhttp3/OkHttpClient;)Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->e:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 184
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 190
    :goto_0
    return-void

    .line 186
    :cond_0
    sget-object v0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Setting up unauthenticated Kb access."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->E()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a()Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestClient;->d()Lokhttp3/OkHttpClient;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->a(Lokhttp3/OkHttpClient;)Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->e:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 188
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    const-string v1, "anonymous"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->g(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    goto :goto_0
.end method

.method private a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 169
    if-nez p1, :cond_1

    .line 176
    :cond_0
    :goto_0
    return v0

    .line 172
    :cond_1
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v1

    .line 173
    if-eqz v1, :cond_0

    invoke-interface {v1, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 176
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private d()V
    .locals 2

    .prologue
    .line 158
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    .line 159
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    if-eqz v1, :cond_0

    if-nez v0, :cond_0

    .line 160
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 161
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Z)V

    .line 162
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->f:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/LogoutListener;

    .line 163
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/LogoutListener;->a()V

    goto :goto_0

    .line 166
    :cond_0
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    return-object v0
.end method

.method public a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    if-nez v0, :cond_0

    .line 121
    :goto_0
    return-void

    .line 118
    :cond_0
    invoke-virtual {p1, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 119
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 120
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->f:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/LogoutListener;)V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->f:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 125
    return-void
.end method

.method public b()Lcom/salesforce/android/service/common/http/HttpClient;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->e:Lcom/salesforce/android/service/common/http/HttpClient;

    return-object v0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 135
    :goto_0
    return-void

    .line 133
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    const-string v1, "anonymous"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->h(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 105
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.salesforce.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 106
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;->d()V

    .line 108
    :cond_0
    return-void
.end method
