.class public Lcom/segment/analytics/Analytics$Builder;
.super Ljava/lang/Object;
.source "Analytics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/Analytics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final application:Landroid/app/Application;

.field private collectDeviceID:Z

.field private connectionFactory:Lcom/segment/analytics/ConnectionFactory;

.field private crypto:Lcom/segment/analytics/Crypto;

.field private defaultOptions:Lcom/segment/analytics/Options;

.field private executor:Ljava/util/concurrent/ExecutorService;

.field private final factories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/segment/analytics/integrations/Integration$Factory;",
            ">;"
        }
    .end annotation
.end field

.field private flushIntervalInMillis:J

.field private flushQueueSize:I

.field private logLevel:Lcom/segment/analytics/Analytics$LogLevel;

.field private middlewares:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/segment/analytics/Middleware;",
            ">;"
        }
    .end annotation
.end field

.field private networkExecutor:Ljava/util/concurrent/ExecutorService;

.field private recordScreenViews:Z

.field private tag:Ljava/lang/String;

.field private trackApplicationLifecycleEvents:Z

.field private trackAttributionInformation:Z

.field private writeKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1082
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1065
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/segment/analytics/Analytics$Builder;->collectDeviceID:Z

    .line 1066
    const/16 v0, 0x14

    iput v0, p0, Lcom/segment/analytics/Analytics$Builder;->flushQueueSize:I

    .line 1067
    const-wide/16 v0, 0x7530

    iput-wide v0, p0, Lcom/segment/analytics/Analytics$Builder;->flushIntervalInMillis:J

    .line 1074
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->factories:Ljava/util/List;

    .line 1076
    iput-boolean v2, p0, Lcom/segment/analytics/Analytics$Builder;->trackApplicationLifecycleEvents:Z

    .line 1077
    iput-boolean v2, p0, Lcom/segment/analytics/Analytics$Builder;->recordScreenViews:Z

    .line 1078
    iput-boolean v2, p0, Lcom/segment/analytics/Analytics$Builder;->trackAttributionInformation:Z

    .line 1083
    if-nez p1, :cond_0

    .line 1084
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1086
    :cond_0
    const-string v0, "android.permission.INTERNET"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->hasPermission(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1087
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "INTERNET permission is required."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1089
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    iput-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    .line 1090
    iget-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    if-nez v0, :cond_2

    .line 1091
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Application context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1094
    :cond_2
    invoke-static {p2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1095
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "writeKey must not be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1097
    :cond_3
    iput-object p2, p0, Lcom/segment/analytics/Analytics$Builder;->writeKey:Ljava/lang/String;

    .line 1098
    return-void
.end method


# virtual methods
.method public build()Lcom/segment/analytics/Analytics;
    .locals 28

    .prologue
    .line 1290
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    invoke-static {v2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1291
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->writeKey:Ljava/lang/String;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    .line 1293
    :cond_0
    sget-object v3, Lcom/segment/analytics/Analytics;->INSTANCES:Ljava/util/List;

    monitor-enter v3

    .line 1294
    :try_start_0
    sget-object v2, Lcom/segment/analytics/Analytics;->INSTANCES:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1295
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Duplicate analytics client created with tag: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ". If you want to use multiple Analytics clients, use a different writeKey or set a tag via the builder during construction."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1302
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 1301
    :cond_1
    :try_start_1
    sget-object v2, Lcom/segment/analytics/Analytics;->INSTANCES:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1302
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1304
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->defaultOptions:Lcom/segment/analytics/Options;

    if-nez v2, :cond_2

    .line 1305
    new-instance v2, Lcom/segment/analytics/Options;

    invoke-direct {v2}, Lcom/segment/analytics/Options;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->defaultOptions:Lcom/segment/analytics/Options;

    .line 1307
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    if-nez v2, :cond_3

    .line 1308
    sget-object v2, Lcom/segment/analytics/Analytics$LogLevel;->NONE:Lcom/segment/analytics/Analytics$LogLevel;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1310
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    if-nez v2, :cond_4

    .line 1311
    new-instance v2, Lcom/segment/analytics/internal/Utils$AnalyticsNetworkExecutorService;

    invoke-direct {v2}, Lcom/segment/analytics/internal/Utils$AnalyticsNetworkExecutorService;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    .line 1313
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->connectionFactory:Lcom/segment/analytics/ConnectionFactory;

    if-nez v2, :cond_5

    .line 1314
    new-instance v2, Lcom/segment/analytics/ConnectionFactory;

    invoke-direct {v2}, Lcom/segment/analytics/ConnectionFactory;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->connectionFactory:Lcom/segment/analytics/ConnectionFactory;

    .line 1316
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->crypto:Lcom/segment/analytics/Crypto;

    if-nez v2, :cond_6

    .line 1317
    invoke-static {}, Lcom/segment/analytics/Crypto;->none()Lcom/segment/analytics/Crypto;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->crypto:Lcom/segment/analytics/Crypto;

    .line 1320
    :cond_6
    new-instance v6, Lcom/segment/analytics/Stats;

    invoke-direct {v6}, Lcom/segment/analytics/Stats;-><init>()V

    .line 1321
    sget-object v14, Lcom/segment/analytics/Cartographer;->INSTANCE:Lcom/segment/analytics/Cartographer;

    .line 1322
    new-instance v13, Lcom/segment/analytics/Client;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->writeKey:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->connectionFactory:Lcom/segment/analytics/ConnectionFactory;

    invoke-direct {v13, v2, v3}, Lcom/segment/analytics/Client;-><init>(Ljava/lang/String;Lcom/segment/analytics/ConnectionFactory;)V

    .line 1324
    new-instance v15, Lcom/segment/analytics/ProjectSettings$Cache;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    invoke-direct {v15, v2, v14, v3}, Lcom/segment/analytics/ProjectSettings$Cache;-><init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;)V

    .line 1327
    new-instance v25, Lcom/segment/analytics/BooleanPreference;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    .line 1329
    invoke-static {v2, v3}, Lcom/segment/analytics/internal/Utils;->getSegmentSharedPreferences(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "opt-out"

    const/4 v4, 0x0

    move-object/from16 v0, v25

    invoke-direct {v0, v2, v3, v4}, Lcom/segment/analytics/BooleanPreference;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    .line 1331
    new-instance v7, Lcom/segment/analytics/Traits$Cache;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    invoke-direct {v7, v2, v14, v3}, Lcom/segment/analytics/Traits$Cache;-><init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;)V

    .line 1332
    invoke-virtual {v7}, Lcom/segment/analytics/Traits$Cache;->isSet()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-virtual {v7}, Lcom/segment/analytics/Traits$Cache;->get()Lcom/segment/analytics/ValueMap;

    move-result-object v2

    if-nez v2, :cond_8

    .line 1333
    :cond_7
    invoke-static {}, Lcom/segment/analytics/Traits;->create()Lcom/segment/analytics/Traits;

    move-result-object v2

    .line 1334
    invoke-virtual {v7, v2}, Lcom/segment/analytics/Traits$Cache;->set(Lcom/segment/analytics/ValueMap;)V

    .line 1337
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-static {v2}, Lcom/segment/analytics/integrations/Logger;->with(Lcom/segment/analytics/Analytics$LogLevel;)Lcom/segment/analytics/integrations/Logger;

    move-result-object v10

    .line 1338
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    .line 1339
    invoke-virtual {v7}, Lcom/segment/analytics/Traits$Cache;->get()Lcom/segment/analytics/ValueMap;

    move-result-object v2

    check-cast v2, Lcom/segment/analytics/Traits;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lcom/segment/analytics/Analytics$Builder;->collectDeviceID:Z

    invoke-static {v3, v2, v4}, Lcom/segment/analytics/AnalyticsContext;->create(Landroid/content/Context;Lcom/segment/analytics/Traits;Z)Lcom/segment/analytics/AnalyticsContext;

    move-result-object v8

    .line 1340
    new-instance v22, Ljava/util/concurrent/CountDownLatch;

    const/4 v2, 0x1

    move-object/from16 v0, v22

    invoke-direct {v0, v2}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 1341
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    move-object/from16 v0, v22

    invoke-virtual {v8, v2, v0, v10}, Lcom/segment/analytics/AnalyticsContext;->attachAdvertisingId(Landroid/content/Context;Ljava/util/concurrent/CountDownLatch;Lcom/segment/analytics/integrations/Logger;)V

    .line 1343
    new-instance v2, Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->factories:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 1344
    sget-object v3, Lcom/segment/analytics/SegmentIntegration;->FACTORY:Lcom/segment/analytics/integrations/Integration$Factory;

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1345
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->factories:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1347
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/segment/analytics/Analytics$Builder;->middlewares:Ljava/util/List;

    invoke-static {v3}, Lcom/segment/analytics/internal/Utils;->immutableCopyOf(Ljava/util/List;)Ljava/util/List;

    move-result-object v27

    .line 1349
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/segment/analytics/Analytics$Builder;->executor:Ljava/util/concurrent/ExecutorService;

    move-object/from16 v20, v0

    .line 1350
    if-nez v20, :cond_9

    .line 1351
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v20

    .line 1354
    :cond_9
    new-instance v3, Lcom/segment/analytics/Analytics;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/segment/analytics/Analytics$Builder;->application:Landroid/app/Application;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/segment/analytics/Analytics$Builder;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/segment/analytics/Analytics$Builder;->defaultOptions:Lcom/segment/analytics/Options;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    .line 1363
    invoke-static {v2}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/segment/analytics/Analytics$Builder;->writeKey:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/segment/analytics/Analytics$Builder;->flushQueueSize:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/segment/analytics/Analytics$Builder;->flushIntervalInMillis:J

    move-wide/from16 v18, v0

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/segment/analytics/Analytics$Builder;->trackApplicationLifecycleEvents:Z

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/segment/analytics/Analytics$Builder;->recordScreenViews:Z

    move/from16 v23, v0

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/segment/analytics/Analytics$Builder;->trackAttributionInformation:Z

    move/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/segment/analytics/Analytics$Builder;->crypto:Lcom/segment/analytics/Crypto;

    move-object/from16 v26, v0

    invoke-direct/range {v3 .. v27}, Lcom/segment/analytics/Analytics;-><init>(Landroid/app/Application;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/Stats;Lcom/segment/analytics/Traits$Cache;Lcom/segment/analytics/AnalyticsContext;Lcom/segment/analytics/Options;Lcom/segment/analytics/integrations/Logger;Ljava/lang/String;Ljava/util/List;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Lcom/segment/analytics/ProjectSettings$Cache;Ljava/lang/String;IJLjava/util/concurrent/ExecutorService;ZLjava/util/concurrent/CountDownLatch;ZZLcom/segment/analytics/BooleanPreference;Lcom/segment/analytics/Crypto;Ljava/util/List;)V

    .line 1354
    return-object v3
.end method

.method public collectDeviceId(Z)Lcom/segment/analytics/Analytics$Builder;
    .locals 0

    .prologue
    .line 1142
    iput-boolean p1, p0, Lcom/segment/analytics/Analytics$Builder;->collectDeviceID:Z

    .line 1143
    return-object p0
.end method

.method public connectionFactory(Lcom/segment/analytics/ConnectionFactory;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1221
    if-nez p1, :cond_0

    .line 1222
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ConnectionFactory must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1224
    :cond_0
    iput-object p1, p0, Lcom/segment/analytics/Analytics$Builder;->connectionFactory:Lcom/segment/analytics/ConnectionFactory;

    .line 1225
    return-object p0
.end method

.method public crypto(Lcom/segment/analytics/Crypto;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1230
    if-nez p1, :cond_0

    .line 1231
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Crypto must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1233
    :cond_0
    iput-object p1, p0, Lcom/segment/analytics/Analytics$Builder;->crypto:Lcom/segment/analytics/Crypto;

    .line 1234
    return-object p0
.end method

.method public defaultOptions(Lcom/segment/analytics/Options;)Lcom/segment/analytics/Analytics$Builder;
    .locals 4

    .prologue
    .line 1153
    if-nez p1, :cond_0

    .line 1154
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "defaultOptions must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1157
    :cond_0
    new-instance v0, Lcom/segment/analytics/Options;

    invoke-direct {v0}, Lcom/segment/analytics/Options;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->defaultOptions:Lcom/segment/analytics/Options;

    .line 1158
    invoke-virtual {p1}, Lcom/segment/analytics/Options;->integrations()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1159
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Ljava/lang/Boolean;

    if-eqz v1, :cond_1

    .line 1160
    iget-object v3, p0, Lcom/segment/analytics/Analytics$Builder;->defaultOptions:Lcom/segment/analytics/Options;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {v3, v1, v0}, Lcom/segment/analytics/Options;->setIntegration(Ljava/lang/String;Z)Lcom/segment/analytics/Options;

    goto :goto_0

    .line 1163
    :cond_1
    iget-object v1, p0, Lcom/segment/analytics/Analytics$Builder;->defaultOptions:Lcom/segment/analytics/Options;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v3}, Lcom/segment/analytics/Options;->setIntegration(Ljava/lang/String;Z)Lcom/segment/analytics/Options;

    goto :goto_0

    .line 1166
    :cond_2
    return-object p0
.end method

.method public disableBundledIntegrations()Lcom/segment/analytics/Analytics$Builder;
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1196
    return-object p0
.end method

.method executor(Ljava/util/concurrent/ExecutorService;)Lcom/segment/analytics/Analytics$Builder;
    .locals 1

    .prologue
    .line 1284
    const-string v0, "executor"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ExecutorService;

    iput-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1285
    return-object p0
.end method

.method public flushInterval(JLjava/util/concurrent/TimeUnit;)Lcom/segment/analytics/Analytics$Builder;
    .locals 3

    .prologue
    .line 1126
    if-nez p3, :cond_0

    .line 1127
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "timeUnit must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1129
    :cond_0
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gtz v0, :cond_1

    .line 1130
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "flushInterval must be greater than zero."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1132
    :cond_1
    invoke-virtual {p3, p1, p2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/segment/analytics/Analytics$Builder;->flushIntervalInMillis:J

    .line 1133
    return-object p0
.end method

.method public flushQueueSize(I)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1107
    if-gtz p1, :cond_0

    .line 1108
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "flushQueueSize must be greater than or equal to zero."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1112
    :cond_0
    const/16 v0, 0xfa

    if-le p1, v0, :cond_1

    .line 1113
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "flushQueueSize must be less than or equal to 250."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1115
    :cond_1
    iput p1, p0, Lcom/segment/analytics/Analytics$Builder;->flushQueueSize:I

    .line 1116
    return-object p0
.end method

.method public logLevel(Lcom/segment/analytics/Analytics$LogLevel;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1186
    if-nez p1, :cond_0

    .line 1187
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "LogLevel must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1189
    :cond_0
    iput-object p1, p0, Lcom/segment/analytics/Analytics$Builder;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1190
    return-object p0
.end method

.method public middleware(Lcom/segment/analytics/Middleware;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1269
    const-string v0, "middleware"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 1270
    iget-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->middlewares:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1271
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->middlewares:Ljava/util/List;

    .line 1273
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->middlewares:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1274
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Middleware is already registered."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1276
    :cond_1
    iget-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->middlewares:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1277
    return-object p0
.end method

.method public networkExecutor(Ljava/util/concurrent/ExecutorService;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1207
    if-nez p1, :cond_0

    .line 1208
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Executor service must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1210
    :cond_0
    iput-object p1, p0, Lcom/segment/analytics/Analytics$Builder;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    .line 1211
    return-object p0
.end method

.method public recordScreenViews()Lcom/segment/analytics/Analytics$Builder;
    .locals 1

    .prologue
    .line 1257
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/segment/analytics/Analytics$Builder;->recordScreenViews:Z

    .line 1258
    return-object p0
.end method

.method public tag(Ljava/lang/String;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1177
    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1178
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "tag must not be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1180
    :cond_0
    iput-object p1, p0, Lcom/segment/analytics/Analytics$Builder;->tag:Ljava/lang/String;

    .line 1181
    return-object p0
.end method

.method public trackApplicationLifecycleEvents()Lcom/segment/analytics/Analytics$Builder;
    .locals 1

    .prologue
    .line 1251
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/segment/analytics/Analytics$Builder;->trackApplicationLifecycleEvents:Z

    .line 1252
    return-object p0
.end method

.method public trackAttributionInformation()Lcom/segment/analytics/Analytics$Builder;
    .locals 1

    .prologue
    .line 1263
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/segment/analytics/Analytics$Builder;->trackAttributionInformation:Z

    .line 1264
    return-object p0
.end method

.method public use(Lcom/segment/analytics/integrations/Integration$Factory;)Lcom/segment/analytics/Analytics$Builder;
    .locals 2

    .prologue
    .line 1239
    if-nez p1, :cond_0

    .line 1240
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Factory must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1242
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$Builder;->factories:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1243
    return-object p0
.end method
