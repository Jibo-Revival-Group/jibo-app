.class public Lcom/salesforce/androidsdk/analytics/AnalyticsPublisherService;
.super Landroid/app/IntentService;
.source "AnalyticsPublisherService.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    const-string v0, "AnalyticsPublisherService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method private a()V
    .locals 1

    .prologue
    .line 79
    invoke-static {}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    .line 80
    if-eqz v0, :cond_0

    .line 81
    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    move-result-object v0

    .line 82
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->c()V

    .line 84
    :cond_0
    return-void
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 60
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/androidsdk/analytics/AnalyticsPublisherService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 61
    const-string v1, "com.salesforce.androidsdk.analytics.action.ANALYTICS_PUBLISH"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 62
    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 63
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 67
    if-eqz p1, :cond_0

    .line 68
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 69
    const-string v1, "com.salesforce.androidsdk.analytics.action.ANALYTICS_PUBLISH"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/AnalyticsPublisherService;->a()V

    .line 73
    :cond_0
    return-void
.end method
