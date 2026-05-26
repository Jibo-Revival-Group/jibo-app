.class public final enum Lcom/segment/analytics/integrations/BasePayload$Channel;
.super Ljava/lang/Enum;
.source "BasePayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/BasePayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Channel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/segment/analytics/integrations/BasePayload$Channel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/segment/analytics/integrations/BasePayload$Channel;

.field public static final enum browser:Lcom/segment/analytics/integrations/BasePayload$Channel;

.field public static final enum mobile:Lcom/segment/analytics/integrations/BasePayload$Channel;

.field public static final enum server:Lcom/segment/analytics/integrations/BasePayload$Channel;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 174
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Channel;

    const-string v1, "browser"

    invoke-direct {v0, v1, v2}, Lcom/segment/analytics/integrations/BasePayload$Channel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Channel;->browser:Lcom/segment/analytics/integrations/BasePayload$Channel;

    .line 175
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Channel;

    const-string v1, "mobile"

    invoke-direct {v0, v1, v3}, Lcom/segment/analytics/integrations/BasePayload$Channel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Channel;->mobile:Lcom/segment/analytics/integrations/BasePayload$Channel;

    .line 176
    new-instance v0, Lcom/segment/analytics/integrations/BasePayload$Channel;

    const-string v1, "server"

    invoke-direct {v0, v1, v4}, Lcom/segment/analytics/integrations/BasePayload$Channel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Channel;->server:Lcom/segment/analytics/integrations/BasePayload$Channel;

    .line 173
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/segment/analytics/integrations/BasePayload$Channel;

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Channel;->browser:Lcom/segment/analytics/integrations/BasePayload$Channel;

    aput-object v1, v0, v2

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Channel;->mobile:Lcom/segment/analytics/integrations/BasePayload$Channel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/segment/analytics/integrations/BasePayload$Channel;->server:Lcom/segment/analytics/integrations/BasePayload$Channel;

    aput-object v1, v0, v4

    sput-object v0, Lcom/segment/analytics/integrations/BasePayload$Channel;->$VALUES:[Lcom/segment/analytics/integrations/BasePayload$Channel;

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
    .line 173
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload$Channel;
    .locals 1

    .prologue
    .line 173
    const-class v0, Lcom/segment/analytics/integrations/BasePayload$Channel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/integrations/BasePayload$Channel;

    return-object v0
.end method

.method public static values()[Lcom/segment/analytics/integrations/BasePayload$Channel;
    .locals 1

    .prologue
    .line 173
    sget-object v0, Lcom/segment/analytics/integrations/BasePayload$Channel;->$VALUES:[Lcom/segment/analytics/integrations/BasePayload$Channel;

    invoke-virtual {v0}, [Lcom/segment/analytics/integrations/BasePayload$Channel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/segment/analytics/integrations/BasePayload$Channel;

    return-object v0
.end method
