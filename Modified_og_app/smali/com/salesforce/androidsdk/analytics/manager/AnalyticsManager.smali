.class public Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;
.super Ljava/lang/Object;
.source "AnalyticsManager.java"


# instance fields
.field private a:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

.field private b:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

.field private c:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    new-instance v0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;-><init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    .line 57
    iput-object p4, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->b:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    .line 58
    const/4 v0, 0x0

    iput v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->c:I

    .line 59
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b()V

    .line 66
    return-void
.end method

.method public declared-synchronized a(I)V
    .locals 1

    .prologue
    .line 74
    monitor-enter p0

    :try_start_0
    iput p1, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->c:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 75
    monitor-exit p0

    return-void

    .line 74
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    return-void
.end method

.method public declared-synchronized b()I
    .locals 1

    .prologue
    .line 83
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->c:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public c()Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->b:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    return-object v0
.end method

.method public d()Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    return-object v0
.end method
