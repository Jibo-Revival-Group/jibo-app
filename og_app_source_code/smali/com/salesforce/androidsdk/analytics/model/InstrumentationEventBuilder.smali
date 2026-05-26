.class public Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
.super Ljava/lang/Object;
.source "InstrumentationEventBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder$EventBuilderException;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

.field private b:Landroid/content/Context;

.field private c:J

.field private d:J

.field private e:Ljava/lang/String;

.field private f:Lorg/json/JSONObject;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Lorg/json/JSONObject;

.field private j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

.field private k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

.field private l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

.field private m:Ljava/lang/String;

.field private n:J

.field private o:Lorg/json/JSONObject;

.field private p:Lorg/json/JSONObject;

.field private q:Lorg/json/JSONObject;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    .line 79
    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->b:Landroid/content/Context;

    .line 80
    return-void
.end method

.method public static final a(Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;Landroid/content/Context;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 1

    .prologue
    .line 74
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;-><init>(Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;Landroid/content/Context;)V

    return-object v0
.end method

.method private b()Ljava/lang/String;
    .locals 4

    .prologue
    .line 292
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 293
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->b:Landroid/content/Context;

    const-string v2, "connectivity"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 294
    if-eqz v0, :cond_1

    .line 295
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 296
    if-eqz v0, :cond_1

    .line 297
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v2

    .line 298
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtypeName()Ljava/lang/String;

    move-result-object v0

    .line 299
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 300
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 301
    const-string v2, ";"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 303
    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 304
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 308
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;
    .locals 25
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder$EventBuilderException;
        }
    .end annotation

    .prologue
    .line 255
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    .line 256
    const/4 v2, 0x0

    .line 257
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-nez v4, :cond_0

    .line 258
    const-string v2, "Mandatory field \'schema type\' not set!"

    .line 260
    :cond_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->e:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 261
    const-string v2, "Mandatory field \'name\' not set!"

    .line 263
    :cond_1
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->c()Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    move-result-object v17

    .line 264
    if-nez v17, :cond_2

    .line 265
    const-string v2, "Mandatory field \'device app attributes\' not set!"

    .line 267
    :cond_2
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    sget-object v5, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v4, v5, :cond_3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    sget-object v5, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v4, v5, :cond_4

    :cond_3
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    if-nez v4, :cond_4

    .line 270
    const-string v2, "Mandatory field \'event type\' not set!"

    .line 272
    :cond_4
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    sget-object v5, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v4, v5, :cond_5

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->o:Lorg/json/JSONObject;

    if-nez v4, :cond_5

    .line 273
    const-string v2, "Mandatory field \'page\' not set!"

    .line 275
    :cond_5
    if-eqz v2, :cond_6

    .line 276
    new-instance v3, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder$EventBuilderException;

    invoke-direct {v3, v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder$EventBuilderException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 278
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->b()I

    move-result v2

    add-int/lit8 v11, v2, 0x1

    .line 279
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->a:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {v2, v11}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a(I)V

    .line 282
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 283
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->c:J

    const-wide/16 v8, 0x0

    cmp-long v2, v4, v8

    if-nez v2, :cond_7

    move-wide v4, v6

    :goto_0
    move-object/from16 v0, p0

    iput-wide v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->c:J

    .line 284
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->n:J

    const-wide/16 v8, 0x0

    cmp-long v2, v4, v8

    if-nez v2, :cond_8

    :goto_1
    move-object/from16 v0, p0

    iput-wide v6, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->n:J

    .line 285
    new-instance v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->c:J

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->d:J

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->f:Lorg/json/JSONObject;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->g:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->h:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->i:Lorg/json/JSONObject;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    move-object/from16 v16, v0

    .line 287
    invoke-direct/range {p0 .. p0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->b()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->m:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->n:J

    move-wide/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->o:Lorg/json/JSONObject;

    move-object/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->p:Lorg/json/JSONObject;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->q:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    invoke-direct/range {v2 .. v24}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;-><init>(Ljava/lang/String;JJLjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;Ljava/lang/String;Ljava/lang/String;JLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    .line 285
    return-object v2

    .line 283
    :cond_7
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->c:J

    goto :goto_0

    .line 284
    :cond_8
    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->n:J

    goto :goto_1
.end method

.method public a(J)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 1

    .prologue
    .line 89
    iput-wide p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->c:J

    .line 90
    return-object p0
.end method

.method public a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 178
    return-object p0
.end method

.method public a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 0

    .prologue
    .line 166
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 167
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->e:Ljava/lang/String;

    .line 112
    return-object p0
.end method

.method public a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->f:Lorg/json/JSONObject;

    .line 123
    return-object p0
.end method

.method public b(J)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 1

    .prologue
    .line 100
    iput-wide p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->d:J

    .line 101
    return-object p0
.end method

.method public b(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEventBuilder;->o:Lorg/json/JSONObject;

    .line 222
    return-object p0
.end method
