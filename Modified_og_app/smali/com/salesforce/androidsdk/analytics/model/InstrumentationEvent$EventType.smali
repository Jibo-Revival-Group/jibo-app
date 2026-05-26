.class public final enum Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;
.super Ljava/lang/Enum;
.source "InstrumentationEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EventType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

.field public static final enum crud:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

.field public static final enum error:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

.field public static final enum system:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

.field public static final enum user:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 407
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    const-string v1, "user"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->user:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 408
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    const-string v1, "system"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->system:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 409
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    const-string v1, "error"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->error:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 410
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    const-string v1, "crud"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->crud:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    .line 406
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->user:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->system:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->error:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->crud:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->$VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

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
    .line 406
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;
    .locals 1

    .prologue
    .line 406
    const-class v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;
    .locals 1

    .prologue
    .line 406
    sget-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->$VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$EventType;

    return-object v0
.end method
