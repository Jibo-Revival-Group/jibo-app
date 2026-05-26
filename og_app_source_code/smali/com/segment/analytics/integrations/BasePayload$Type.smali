.class public final enum Lcom/segment/analytics/integrations/BasePayload$Type;
.super Ljava/lang/Enum;
.source "BasePayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/BasePayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/segment/analytics/integrations/BasePayload$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/segment/analytics/integrations/BasePayload$Type;

.field public static final enum alias:Lcom/segment/analytics/integrations/BasePayload$Type;

.field public static final enum group:Lcom/segment/analytics/integrations/BasePayload$Type;

.field public static final enum identify:Lcom/segment/analytics/integrations/BasePayload$Type;

.field public static final enum screen:Lcom/segment/analytics/integrations/BasePayload$Type;

.field public static final enum track:Lcom/segment/analytics/integrations/BasePayload$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 160
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    const-string v1, "alias"

    invoke-direct {v0, v1, v2}, Lcom/segment/analytics/integrations/BasePayload$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->alias:Lcom/segment/analytics/integrations/BasePayload$Type;

    .line 161
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    const-string v1, "group"

    invoke-direct {v0, v1, v3}, Lcom/segment/analytics/integrations/BasePayload$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->group:Lcom/segment/analytics/integrations/BasePayload$Type;

    .line 162
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    const-string v1, "identify"

    invoke-direct {v0, v1, v4}, Lcom/segment/analytics/integrations/BasePayload$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->identify:Lcom/segment/analytics/integrations/BasePayload$Type;

    .line 163
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    const-string v1, "screen"

    invoke-direct {v0, v1, v5}, Lcom/segment/analytics/integrations/BasePayload$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->screen:Lcom/segment/analytics/integrations/BasePayload$Type;

    .line 164
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    const-string v1, "track"

    invoke-direct {v0, v1, v6}, Lcom/segment/analytics/integrations/BasePayload$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->track:Lcom/segment/analytics/integrations/BasePayload$Type;

    .line 159
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/segment/analytics/integrations/BasePayload$Type;

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Type;->alias:Lcom/segment/analytics/integrations/BasePayload$Type;

    aput-object v1, v0, v2

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Type;->group:Lcom/segment/analytics/integrations/BasePayload$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Type;->identify:Lcom/segment/analytics/integrations/BasePayload$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Type;->screen:Lcom/segment/analytics/integrations/BasePayload$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Type;->track:Lcom/segment/analytics/integrations/BasePayload$Type;

    aput-object v1, v0, v6

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->$VALUES:[Lcom/segment/analytics/integrations/BasePayload$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 159
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload$Type;
    .locals 1

    .prologue
    .line 159
    const-class v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/integrations/BasePayload$Type;

    return-object v0
.end method

.method public static values()[Lcom/segment/analytics/integrations/BasePayload$Type;
    .locals 1

    .prologue
    .line 159
    sget-object v0, Lcom/segment/analytics/integrations/BasePayload$Type;->$VALUES:[Lcom/segment/analytics/integrations/BasePayload$Type;

    invoke-virtual {v0}, [Lcom/segment/analytics/integrations/BasePayload$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/segment/analytics/integrations/BasePayload$Type;

    return-object v0
.end method
