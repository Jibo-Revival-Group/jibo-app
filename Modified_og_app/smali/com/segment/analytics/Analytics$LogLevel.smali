.class public final enum Lcom/segment/analytics/Analytics$LogLevel;
.super Ljava/lang/Enum;
.source "Analytics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/Analytics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "LogLevel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/segment/analytics/Analytics$LogLevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/segment/analytics/Analytics$LogLevel;

.field public static final enum BASIC:Lcom/segment/analytics/Analytics$LogLevel;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final enum DEBUG:Lcom/segment/analytics/Analytics$LogLevel;

.field public static final enum INFO:Lcom/segment/analytics/Analytics$LogLevel;

.field public static final enum NONE:Lcom/segment/analytics/Analytics$LogLevel;

.field public static final enum VERBOSE:Lcom/segment/analytics/Analytics$LogLevel;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1025
    new-instance v0, Lcom/segment/analytics/Analytics$LogLevel;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2}, Lcom/segment/analytics/Analytics$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/Analytics$LogLevel;->NONE:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1027
    new-instance v0, Lcom/segment/analytics/Analytics$LogLevel;

    const-string v1, "INFO"

    invoke-direct {v0, v1, v3}, Lcom/segment/analytics/Analytics$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/Analytics$LogLevel;->INFO:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1029
    new-instance v0, Lcom/segment/analytics/Analytics$LogLevel;

    const-string v1, "DEBUG"

    invoke-direct {v0, v1, v4}, Lcom/segment/analytics/Analytics$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/Analytics$LogLevel;->DEBUG:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1035
    new-instance v0, Lcom/segment/analytics/Analytics$LogLevel;

    const-string v1, "BASIC"

    invoke-direct {v0, v1, v5}, Lcom/segment/analytics/Analytics$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/Analytics$LogLevel;->BASIC:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1038
    new-instance v0, Lcom/segment/analytics/Analytics$LogLevel;

    const-string v1, "VERBOSE"

    invoke-direct {v0, v1, v6}, Lcom/segment/analytics/Analytics$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/segment/analytics/Analytics$LogLevel;->VERBOSE:Lcom/segment/analytics/Analytics$LogLevel;

    .line 1023
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/segment/analytics/Analytics$LogLevel;

    sget-object v1, Lcom/segment/analytics/Analytics$LogLevel;->NONE:Lcom/segment/analytics/Analytics$LogLevel;

    aput-object v1, v0, v2

    sget-object v1, Lcom/segment/analytics/Analytics$LogLevel;->INFO:Lcom/segment/analytics/Analytics$LogLevel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/segment/analytics/Analytics$LogLevel;->DEBUG:Lcom/segment/analytics/Analytics$LogLevel;

    aput-object v1, v0, v4

    sget-object v1, Lcom/segment/analytics/Analytics$LogLevel;->BASIC:Lcom/segment/analytics/Analytics$LogLevel;

    aput-object v1, v0, v5

    sget-object v1, Lcom/segment/analytics/Analytics$LogLevel;->VERBOSE:Lcom/segment/analytics/Analytics$LogLevel;

    aput-object v1, v0, v6

    sput-object v0, Lcom/segment/analytics/Analytics$LogLevel;->$VALUES:[Lcom/segment/analytics/Analytics$LogLevel;

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
    .line 1023
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/segment/analytics/Analytics$LogLevel;
    .locals 1

    .prologue
    .line 1023
    const-class v0, Lcom/segment/analytics/Analytics$LogLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/Analytics$LogLevel;

    return-object v0
.end method

.method public static values()[Lcom/segment/analytics/Analytics$LogLevel;
    .locals 1

    .prologue
    .line 1023
    sget-object v0, Lcom/segment/analytics/Analytics$LogLevel;->$VALUES:[Lcom/segment/analytics/Analytics$LogLevel;

    invoke-virtual {v0}, [Lcom/segment/analytics/Analytics$LogLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/segment/analytics/Analytics$LogLevel;

    return-object v0
.end method


# virtual methods
.method public log()Z
    .locals 1

    .prologue
    .line 1041
    sget-object v0, Lcom/segment/analytics/Analytics$LogLevel;->NONE:Lcom/segment/analytics/Analytics$LogLevel;

    if-eq p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
