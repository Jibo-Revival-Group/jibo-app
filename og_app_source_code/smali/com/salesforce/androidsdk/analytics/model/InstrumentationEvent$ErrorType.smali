.class public final enum Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;
.super Ljava/lang/Enum;
.source "InstrumentationEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ErrorType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

.field public static final enum error:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

.field public static final enum info:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

.field public static final enum warn:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 427
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    const-string v1, "info"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->info:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    .line 428
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    const-string v1, "warn"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->warn:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    .line 429
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    const-string v1, "error"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->error:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    .line 426
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->info:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->warn:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->error:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->$VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

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
    .line 426
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;
    .locals 1

    .prologue
    .line 426
    const-class v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;
    .locals 1

    .prologue
    .line 426
    sget-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->$VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$ErrorType;

    return-object v0
.end method
