.class public Lcom/salesforce/androidsdk/analytics/transform/AILTNTransform;
.super Ljava/lang/Object;
.source "AILTNTransform.java"

# interfaces
.implements Lcom/salesforce/androidsdk/analytics/transform/Transform;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private b(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;
    .locals 6

    .prologue
    .line 89
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 91
    :try_start_0
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->m()Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    move-result-object v0

    .line 92
    if-eqz v0, :cond_0

    .line 93
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->a()Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 95
    :goto_0
    :try_start_1
    const-string v1, "connectionType"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->n()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 99
    :goto_1
    return-object v0

    .line 96
    :catch_0
    move-exception v0

    move-object v5, v0

    move-object v0, v1

    move-object v1, v5

    .line 97
    :goto_2
    const/4 v2, 0x0

    const-string v3, "AILTNTransform"

    const-string v4, "Exception occurred while transforming JSON"

    invoke-static {v2, v3, v4, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 96
    :catch_1
    move-exception v1

    goto :goto_2

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method private c(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 103
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 105
    :try_start_0
    const-string v2, "version"

    const-string v3, "0.2"

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 106
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->j()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    move-result-object v3

    .line 107
    const-string v2, "schemaType"

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 108
    const-string v2, "id"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 109
    const-string v2, "eventSource"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->d()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 110
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->b()J

    move-result-wide v4

    .line 111
    const-string v2, "ts"

    invoke-virtual {v0, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 112
    const-string v2, "pageStartTime"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->p()J

    move-result-wide v6

    invoke-virtual {v0, v2, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 113
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->c()J

    move-result-wide v6

    .line 114
    sub-long v4, v6, v4

    .line 115
    const-wide/16 v6, 0x0

    cmp-long v2, v4, v6

    if-lez v2, :cond_1

    .line 116
    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v3, v2, :cond_0

    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v2, :cond_d

    .line 118
    :cond_0
    const-string v2, "duration"

    invoke-virtual {v0, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 123
    :cond_1
    :goto_0
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->f()Ljava/lang/String;

    move-result-object v2

    .line 124
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 125
    const-string v4, "clientSessionId"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 127
    :cond_2
    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v3, v2, :cond_3

    .line 128
    const-string v2, "sequence"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->g()I

    move-result v4

    invoke-virtual {v0, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 130
    :cond_3
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->e()Lorg/json/JSONObject;

    move-result-object v2

    .line 131
    if-eqz v2, :cond_4

    .line 132
    const-string v4, "attributes"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 134
    :cond_4
    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v3, v2, :cond_5

    .line 135
    const-string v2, "page"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->q()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v0, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 137
    :cond_5
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->r()Lorg/json/JSONObject;

    move-result-object v2

    .line 138
    if-eqz v2, :cond_6

    sget-object v4, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v4, :cond_6

    .line 139
    const-string v4, "previousPage"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 141
    :cond_6
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->s()Lorg/json/JSONObject;

    move-result-object v2

    .line 142
    if-eqz v2, :cond_8

    sget-object v4, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v3, v4, :cond_7

    sget-object v4, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v4, :cond_8

    .line 144
    :cond_7
    const-string v4, "marks"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 146
    :cond_8
    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eq v3, v2, :cond_9

    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v2, :cond_a

    .line 148
    :cond_9
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/analytics/transform/AILTNTransform;->d(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;

    move-result-object v2

    .line 149
    if-eqz v2, :cond_a

    .line 150
    const-string v4, "locator"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 153
    :cond_a
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->k()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    move-result-object v2

    .line 155
    sget-object v4, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v4, :cond_e

    .line 156
    const-string v2, "defs"

    .line 161
    :goto_1
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_b

    .line 162
    const-string v4, "eventType"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 164
    :cond_b
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->l()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    move-result-object v2

    .line 165
    if-eqz v2, :cond_c

    sget-object v4, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningError:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v4, :cond_c

    .line 166
    const-string v3, "errorType"

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 172
    :cond_c
    :goto_2
    return-object v0

    .line 119
    :cond_d
    sget-object v2, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v2, :cond_1

    .line 120
    const-string v2, "ept"

    invoke-virtual {v0, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 168
    :catch_0
    move-exception v0

    .line 170
    const-string v2, "AILTNTransform"

    const-string v3, "Exception occurred while transforming JSON"

    invoke-static {v1, v2, v3, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_2

    .line 157
    :cond_e
    :try_start_1
    sget-object v4, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-ne v3, v4, :cond_f

    if-eqz v2, :cond_f

    .line 159
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->name()Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v2

    goto :goto_1

    :cond_f
    move-object v2, v1

    goto :goto_1
.end method

.method private d(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 176
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 178
    :try_start_0
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->h()Ljava/lang/String;

    move-result-object v2

    .line 179
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->o()Ljava/lang/String;

    move-result-object v3

    .line 180
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 193
    :cond_0
    :goto_0
    return-object v1

    .line 183
    :cond_1
    const-string v4, "target"

    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 184
    const-string v2, "scope"

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 185
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->i()Lorg/json/JSONObject;

    move-result-object v2

    .line 186
    if-eqz v2, :cond_2

    .line 187
    const-string v3, "context"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    :goto_1
    move-object v1, v0

    .line 193
    goto :goto_0

    .line 189
    :catch_0
    move-exception v0

    .line 191
    const-string v2, "AILTNTransform"

    const-string v3, "Exception occurred while transforming JSON"

    invoke-static {v1, v2, v3, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method public a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 73
    if-nez p1, :cond_0

    .line 85
    :goto_0
    return-object v0

    .line 76
    :cond_0
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/analytics/transform/AILTNTransform;->c(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;

    move-result-object v1

    .line 78
    if-eqz v1, :cond_1

    .line 79
    :try_start_0
    const-string v2, "deviceAttributes"

    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/analytics/transform/AILTNTransform;->b(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    move-object v0, v1

    .line 84
    goto :goto_0

    .line 81
    :catch_0
    move-exception v1

    .line 83
    const-string v2, "AILTNTransform"

    const-string v3, "Exception occurred while transforming JSON"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
