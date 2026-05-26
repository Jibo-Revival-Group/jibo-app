.class public abstract Lcom/segment/analytics/integrations/BasePayload;
.super Lcom/segment/analytics/ValueMap;
.source "BasePayload.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/integrations/BasePayload$Builder;,
        Lcom/segment/analytics/integrations/BasePayload$Channel;,
        Lcom/segment/analytics/integrations/BasePayload$Type;
    }
.end annotation


# static fields
.field static final ANONYMOUS_ID_KEY:Ljava/lang/String; = "anonymousId"

.field static final CHANNEL_KEY:Ljava/lang/String; = "channel"

.field static final CONTEXT_KEY:Ljava/lang/String; = "context"

.field static final INTEGRATIONS_KEY:Ljava/lang/String; = "integrations"

.field static final MESSAGE_ID:Ljava/lang/String; = "messageId"

.field static final TIMESTAMP_KEY:Ljava/lang/String; = "timestamp"

.field static final TYPE_KEY:Ljava/lang/String; = "type"

.field static final USER_ID_KEY:Ljava/lang/String; = "userId"


# direct methods
.method constructor <init>(Lcom/segment/analytics/integrations/BasePayload$Type;Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/segment/analytics/integrations/BasePayload$Type;",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/segment/analytics/ValueMap;-><init>()V

    .line 70
    const-string v0, "channel"

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Channel;->mobile:Lcom/segment/analytics/integrations/BasePayload$Channel;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    const-string v0, "type"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    const-string v0, "messageId"

    invoke-virtual {p0, v0, p2}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    const-string v0, "timestamp"

    invoke-static {p3}, Lcom/segment/analytics/internal/Utils;->toISO8601String(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    const-string v0, "context"

    invoke-virtual {p0, v0, p4}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    const-string v0, "integrations"

    invoke-virtual {p0, v0, p5}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    invoke-static {p6}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 77
    const-string v0, "userId"

    invoke-virtual {p0, v0, p6}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    :cond_0
    const-string v0, "anonymousId"

    invoke-virtual {p0, v0, p7}, Lcom/segment/analytics/integrations/BasePayload;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    return-void
.end method


# virtual methods
.method public anonymousId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    const-string v0, "anonymousId"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/integrations/BasePayload;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public context()Lcom/segment/analytics/AnalyticsContext;
    .locals 2

    .prologue
    .line 146
    const-string v0, "context"

    const-class v1, Lcom/segment/analytics/AnalyticsContext;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/integrations/BasePayload;->getValueMap(Ljava/lang/String;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/AnalyticsContext;

    return-object v0
.end method

.method public integrations()Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 136
    const-string v0, "integrations"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/integrations/BasePayload;->getValueMap(Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    return-object v0
.end method

.method public messageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    const-string v0, "messageId"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/integrations/BasePayload;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 51
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/integrations/BasePayload;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/integrations/BasePayload;

    move-result-object v0

    return-object v0
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/integrations/BasePayload;
    .locals 0

    .prologue
    .line 151
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 152
    return-object p0
.end method

.method public timestamp()Ljava/util/Date;
    .locals 2

    .prologue
    .line 124
    const-string v0, "timestamp"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/integrations/BasePayload;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 125
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 126
    const/4 v0, 0x0

    .line 128
    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->parseISO8601Date(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    goto :goto_0
.end method

.method public abstract toBuilder()Lcom/segment/analytics/integrations/BasePayload$Builder;
.end method

.method public type()Lcom/segment/analytics/integrations/BasePayload$Type;
    .locals 2

    .prologue
    .line 85
    const-class v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    const-string v1, "type"

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/integrations/BasePayload;->getEnum(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    return-object v0
.end method

.method public userId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    const-string v0, "userId"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/integrations/BasePayload;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
