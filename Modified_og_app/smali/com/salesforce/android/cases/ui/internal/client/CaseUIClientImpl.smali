.class public Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;
.super Ljava/lang/Object;
.source "CaseUIClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/NotificationHandler;
.implements Lcom/salesforce/android/cases/ui/CaseUIClient;


# instance fields
.field private final a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

.field private final b:Lcom/salesforce/android/cases/core/CaseClient;

.field private final c:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

.field private final d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

.field private final e:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;

.field private final f:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

.field private final g:Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;


# direct methods
.method private constructor <init>(Landroid/content/Context;Lcom/salesforce/android/cases/ui/CaseUIConfiguration;Lcom/salesforce/android/cases/core/CaseClient;Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;)V
    .locals 4

    .prologue
    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    .line 93
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->b:Lcom/salesforce/android/cases/core/CaseClient;

    .line 94
    iput-object p4, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->c:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    .line 95
    new-instance v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 97
    sget v0, Lcom/salesforce/android/cases/R$string;->case_notification_channel_id:I

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 98
    sget v1, Lcom/salesforce/android/cases/R$string;->case_notification_channel_name:I

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 99
    new-instance v2, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;

    .line 100
    invoke-virtual {p2}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->a()I

    move-result v3

    invoke-direct {v2, v0, v1, v3}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    iput-object v2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->f:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    .line 101
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->e:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->e:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->f:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;->a(Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;)V

    .line 103
    iput-object p5, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->g:Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;

    .line 105
    instance-of v0, p1, Landroid/app/Application;

    if-eqz v0, :cond_1

    .line 107
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;-><init>()V

    .line 108
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;

    move-result-object v0

    .line 110
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 111
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 114
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    .line 115
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;

    .line 118
    :cond_0
    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a()Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    move-result-object v0

    .line 119
    invoke-static {v0}, Lcom/salesforce/android/service/common/analytics/ServiceAnalytics;->a(Lcom/salesforce/android/service/common/analytics/ServiceAnalyticsListener;)V

    .line 121
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Landroid/content/Context;)V

    .line 122
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$1;-><init>(Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V

    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 129
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;-><init>(Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V

    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 137
    :cond_1
    return-void
.end method

.method private a(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 249
    if-nez p1, :cond_0

    .line 250
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    invoke-virtual {v0}, Ljava/util/Random;->nextInt()I

    move-result v0

    .line 252
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/android/cases/ui/CaseUIConfiguration;Lcom/salesforce/android/cases/core/CaseClient;)Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;
    .locals 6

    .prologue
    .line 142
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    const/4 v1, 0x3

    new-array v1, v1, [Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;

    const/4 v2, 0x0

    new-instance v3, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenterProvider;

    invoke-direct {v3}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenterProvider;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x1

    new-instance v3, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenterProvider;

    invoke-direct {v3}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenterProvider;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x2

    new-instance v3, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenterProvider;

    invoke-direct {v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenterProvider;-><init>()V

    aput-object v3, v1, v2

    .line 143
    invoke-static {v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->a([Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;)Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    move-result-object v4

    new-instance v5, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;

    invoke-direct {v5}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;-><init>()V

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;-><init>(Landroid/content/Context;Lcom/salesforce/android/cases/ui/CaseUIConfiguration;Lcom/salesforce/android/cases/core/CaseClient;Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;)V

    .line 142
    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/CaseClient;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->b:Lcom/salesforce/android/cases/core/CaseClient;

    return-object v0
.end method

.method public a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 164
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 165
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->c(Landroid/content/Context;)V

    .line 169
    :goto_0
    return-void

    .line 167
    :cond_0
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->b(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public a(Landroid/content/Context;Lcom/salesforce/android/cases/core/model/PushNotification;)V
    .locals 6

    .prologue
    .line 213
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d()Ljava/lang/String;

    move-result-object v1

    .line 214
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->c()Ljava/lang/String;

    move-result-object v2

    .line 215
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->e()Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "agent"

    .line 216
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/model/PushNotification;->a()Ljava/lang/String;

    move-result-object v5

    .line 213
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 219
    const/high16 v1, 0x14000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 220
    const/4 v1, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {p1, v1, v0, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 222
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->g:Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->f:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    .line 223
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->a(Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;

    move-result-object v1

    .line 224
    invoke-virtual {v1, p1}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;

    move-result-object v1

    .line 225
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/model/PushNotification;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a(Ljava/lang/CharSequence;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    .line 226
    invoke-virtual {v2}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->c()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/CaseConfiguration;->g()I

    move-result v2

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->a(I)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v1

    const/4 v2, -0x1

    .line 227
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->b(I)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v1

    new-instance v2, Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    invoke-direct {v2}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;-><init>()V

    .line 228
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/model/PushNotification;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->a(Landroid/support/v4/app/NotificationCompat$Style;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v1

    const/4 v2, 0x1

    .line 229
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->a(Z)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    .line 230
    invoke-virtual {v2}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->b()I

    move-result v2

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->c(I)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v1

    .line 231
    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->a(Landroid/app/PendingIntent;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;

    move-result-object v0

    .line 233
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->e:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;

    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/model/PushNotification;->a()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a(Ljava/lang/String;)I

    move-result v2

    .line 234
    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;->a()Landroid/app/Notification;

    move-result-object v0

    .line 233
    invoke-interface {v1, v2, v0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;->a(ILandroid/app/Notification;)V

    .line 235
    return-void

    .line 215
    :cond_0
    const-string v3, "guest"

    goto :goto_0
.end method

.method public a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 192
    invoke-static {p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 193
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/core/model/PushNotification;)V
    .locals 6

    .prologue
    .line 238
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d()Ljava/lang/String;

    move-result-object v1

    .line 239
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->c()Ljava/lang/String;

    move-result-object v2

    .line 240
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->e()Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "authenticated"

    .line 241
    :goto_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/model/PushNotification;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/model/PushNotification;->b()Ljava/lang/String;

    move-result-object v5

    .line 238
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    return-void

    .line 240
    :cond_0
    const-string v3, "guest"

    goto :goto_0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->c()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 156
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;->a(Landroid/content/Context;)V

    .line 157
    return-void
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->c()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->b()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public c(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 160
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->a(Landroid/content/Context;)V

    .line 161
    return-void
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->c()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->c()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->c()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->i()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    return v0
.end method

.method public f()V
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->d:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a()V

    .line 246
    return-void
.end method

.method public g()Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->c:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    return-object v0
.end method
