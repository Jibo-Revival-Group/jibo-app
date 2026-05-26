.class public Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;
.super Ljava/lang/Object;
.source "UserLogoutBroadcastReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field private b:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

.field private final c:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 202
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 203
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->a:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 204
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->c:Landroid/content/Context;

    .line 205
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->a:Lcom/salesforce/androidsdk/accounts/UserAccount;

    return-object v0
.end method

.method public b()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->b:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    return-object v0
.end method

.method public c()Landroid/content/Context;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->c:Landroid/content/Context;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->b:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    if-nez v0, :cond_0

    .line 226
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;->b:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    .line 228
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver;-><init>(Lcom/salesforce/android/knowledge/core/internal/utils/UserLogoutBroadcastReceiver$Builder;)V

    return-object v0
.end method
