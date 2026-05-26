.class public Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;
.super Ljava/lang/Object;
.source "EventBuilderHelper.java"


# static fields
.field private static a:Z

.field private static final b:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x1

    sput-boolean v0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a:Z

    .line 55
    const/4 v0, 0x2

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->b:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public static a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 82
    sget-boolean v0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a:Z

    if-nez v0, :cond_0

    .line 96
    :goto_0
    return-void

    .line 86
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->C()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 87
    invoke-static {p0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->d(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    goto :goto_0

    .line 89
    :cond_1
    sget-object v0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->b:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public static b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 108
    invoke-static {p0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->d(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 109
    return-void
.end method

.method static synthetic c(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 45
    invoke-static {p0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->d(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method

.method private static d(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 115
    sget-boolean v0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a:Z

    if-nez v0, :cond_1

    .line 150
    :cond_0
    :goto_0
    return-void

    .line 119
    :cond_1
    if-nez p1, :cond_2

    .line 120
    invoke-static {}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object p1

    .line 122
    :cond_2
    if-eqz p1, :cond_0

    .line 125
    invoke-static {p1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    move-result-object v1

    .line 126
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a()Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    move-result-object v0

    .line 127
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v2

    .line 126
    invoke-static {v0, v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a(Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;Landroid/content/Context;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    move-result-object v2

    .line 128
    invoke-virtual {v2, p0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 130
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 132
    :try_start_0
    const-string v0, "context"

    invoke-virtual {v3, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 136
    :goto_1
    invoke-virtual {v2, v3}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->b(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 137
    if-eqz p3, :cond_4

    .line 138
    const-string v0, "startTime"

    invoke-virtual {p3, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a(J)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 139
    const-string v0, "endTime"

    invoke-virtual {p3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "endTime"

    invoke-virtual {p3, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->b(J)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 140
    :cond_3
    invoke-virtual {v2, p3}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 142
    :cond_4
    sget-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    invoke-virtual {v2, v0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 143
    sget-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->system:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    invoke-virtual {v2, v0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    .line 145
    :try_start_1
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    move-result-object v0

    .line 146
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a()Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->d()Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)V
    :try_end_1
    .catch Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder$EventBuilderException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 147
    :catch_0
    move-exception v0

    .line 148
    const-string v1, "EventBuilderHelper"

    const-string v2, "Exception thrown while building event"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 133
    :catch_1
    move-exception v0

    .line 134
    const-string v4, "EventBuilderHelper"

    const-string v5, "Exception thrown while building page object"

    invoke-static {v4, v5, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method
