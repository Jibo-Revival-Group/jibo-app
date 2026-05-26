.class public Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;
.super Ljava/lang/Object;
.source "InstrumentationEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;,
        Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;,
        Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:J

.field private c:J

.field private d:Ljava/lang/String;

.field private e:Lorg/json/JSONObject;

.field private f:Ljava/lang/String;

.field private g:I

.field private h:Ljava/lang/String;

.field private i:Lorg/json/JSONObject;

.field private j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

.field private k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

.field private l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

.field private m:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:J

.field private q:Lorg/json/JSONObject;

.field private r:Lorg/json/JSONObject;

.field private s:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Ljava/lang/String;JJLjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;Ljava/lang/String;Ljava/lang/String;JLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    .line 93
    iput-wide p2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->b:J

    .line 94
    iput-wide p4, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->c:J

    .line 95
    iput-object p6, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->d:Ljava/lang/String;

    .line 96
    iput-object p7, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->e:Lorg/json/JSONObject;

    .line 97
    iput-object p8, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->f:Ljava/lang/String;

    .line 98
    iput p9, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->g:I

    .line 99
    iput-object p10, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->h:Ljava/lang/String;

    .line 100
    iput-object p11, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->i:Lorg/json/JSONObject;

    .line 101
    iput-object p12, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 102
    iput-object p13, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 103
    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    .line 104
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->m:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    .line 105
    move-object/from16 v0, p16

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->n:Ljava/lang/String;

    .line 106
    move-object/from16 v0, p17

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->o:Ljava/lang/String;

    .line 107
    move-wide/from16 v0, p18

    iput-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->p:J

    .line 108
    move-object/from16 v0, p20

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->q:Lorg/json/JSONObject;

    .line 109
    move-object/from16 v0, p21

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->r:Lorg/json/JSONObject;

    .line 110
    move-object/from16 v0, p22

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->s:Lorg/json/JSONObject;

    .line 111
    return-void
.end method

.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    if-eqz p1, :cond_4

    .line 122
    const-string v0, "eventId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    .line 123
    const-string v0, "startTime"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->b:J

    .line 124
    const-string v0, "endTime"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->c:J

    .line 125
    const-string v0, "name"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->d:Ljava/lang/String;

    .line 126
    const-string v0, "attributes"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->e:Lorg/json/JSONObject;

    .line 127
    const-string v0, "sessionId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->f:Ljava/lang/String;

    .line 128
    const-string v0, "sequenceId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->g:I

    .line 129
    const-string v0, "senderId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->h:Ljava/lang/String;

    .line 130
    const-string v0, "senderContext"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->i:Lorg/json/JSONObject;

    .line 131
    const-string v0, "schemaType"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 132
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 133
    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 135
    :cond_0
    const-string v0, "eventType"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 136
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 137
    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 139
    :cond_1
    const-string v0, "errorType"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 140
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 141
    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    .line 143
    :cond_2
    const-string v0, "deviceAppAttributes"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 144
    if-eqz v0, :cond_3

    .line 145
    new-instance v1, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    invoke-direct {v1, v0}, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;-><init>(Lorg/json/JSONObject;)V

    iput-object v1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->m:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    .line 147
    :cond_3
    const-string v0, "connectionType"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->n:Ljava/lang/String;

    .line 148
    const-string v0, "senderParentId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->o:Ljava/lang/String;

    .line 149
    const-string v0, "sessionStartTime"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->p:J

    .line 150
    const-string v0, "page"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->q:Lorg/json/JSONObject;

    .line 151
    const-string v0, "previousPage"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->r:Lorg/json/JSONObject;

    .line 152
    const-string v0, "marks"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->s:Lorg/json/JSONObject;

    .line 154
    :cond_4
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()J
    .locals 2

    .prologue
    .line 171
    iget-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->b:J

    return-wide v0
.end method

.method public c()J
    .locals 2

    .prologue
    .line 180
    iget-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->c:J

    return-wide v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->d:Ljava/lang/String;

    return-object v0
.end method

.method public e()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->e:Lorg/json/JSONObject;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 380
    if-eqz p1, :cond_0

    instance-of v1, p1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    if-nez v1, :cond_1

    .line 395
    :cond_0
    :goto_0
    return v0

    .line 383
    :cond_1
    check-cast p1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    .line 384
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 392
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 393
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->f:Ljava/lang/String;

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 216
    iget v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->g:I

    return v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->h:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public i()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->i:Lorg/json/JSONObject;

    return-object v0
.end method

.method public j()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    return-object v0
.end method

.method public k()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    return-object v0
.end method

.method public l()Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    return-object v0
.end method

.method public m()Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->m:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    return-object v0
.end method

.method public n()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->n:Ljava/lang/String;

    return-object v0
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->o:Ljava/lang/String;

    return-object v0
.end method

.method public p()J
    .locals 2

    .prologue
    .line 297
    iget-wide v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->p:J

    return-wide v0
.end method

.method public q()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 306
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->q:Lorg/json/JSONObject;

    return-object v0
.end method

.method public r()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->r:Lorg/json/JSONObject;

    return-object v0
.end method

.method public s()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->s:Lorg/json/JSONObject;

    return-object v0
.end method

.method public t()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 333
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 335
    :try_start_0
    const-string v0, "eventId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 336
    const-string v0, "startTime"

    iget-wide v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->b:J

    invoke-virtual {v1, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 337
    const-string v0, "endTime"

    iget-wide v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->c:J

    invoke-virtual {v1, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 338
    const-string v0, "name"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->d:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 339
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->e:Lorg/json/JSONObject;

    if-eqz v0, :cond_0

    .line 340
    const-string v0, "attributes"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->e:Lorg/json/JSONObject;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 342
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->f:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 343
    const-string v0, "sessionId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->f:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 345
    :cond_1
    const-string v0, "sequenceId"

    iget v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->g:I

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 346
    const-string v0, "senderId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->h:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 347
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->i:Lorg/json/JSONObject;

    if-eqz v0, :cond_2

    .line 348
    const-string v0, "senderContext"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->i:Lorg/json/JSONObject;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 350
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    if-eqz v0, :cond_3

    .line 351
    const-string v0, "schemaType"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->j:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 353
    :cond_3
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    if-eqz v0, :cond_4

    .line 354
    const-string v0, "eventType"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->k:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 356
    :cond_4
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    if-eqz v0, :cond_5

    .line 357
    const-string v0, "errorType"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->l:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 359
    :cond_5
    const-string v0, "deviceAppAttributes"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->m:Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->a()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 360
    const-string v0, "connectionType"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->n:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 361
    const-string v0, "senderParentId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->o:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 362
    const-string v0, "sessionStartTime"

    iget-wide v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->p:J

    invoke-virtual {v1, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 363
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->q:Lorg/json/JSONObject;

    if-eqz v0, :cond_6

    .line 364
    const-string v0, "page"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->q:Lorg/json/JSONObject;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 366
    :cond_6
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->r:Lorg/json/JSONObject;

    if-eqz v0, :cond_7

    .line 367
    const-string v0, "previousPage"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->r:Lorg/json/JSONObject;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 369
    :cond_7
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->s:Lorg/json/JSONObject;

    if-eqz v0, :cond_8

    .line 370
    const-string v0, "marks"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->s:Lorg/json/JSONObject;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 375
    :cond_8
    :goto_0
    return-object v1

    .line 372
    :catch_0
    move-exception v0

    .line 373
    const/4 v2, 0x0

    const-string v3, "InstrumentationEvent"

    const-string v4, "Exception thrown while attempting to convert to JSON"

    invoke-static {v2, v3, v4, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
