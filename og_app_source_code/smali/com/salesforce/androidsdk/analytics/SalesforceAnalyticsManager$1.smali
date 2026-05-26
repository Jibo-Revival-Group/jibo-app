.class final Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager$1;
.super Ljava/lang/Object;
.source "SalesforceAnalyticsManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g()Ljava/util/concurrent/ScheduledFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 460
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 464
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/AnalyticsPublisherService;->a(Landroid/content/Context;)V

    .line 465
    return-void
.end method
