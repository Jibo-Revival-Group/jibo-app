.class public final enum Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;
.super Ljava/lang/Enum;
.source "InstrumentationEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SchemaType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

.field public static final enum LightningError:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

.field public static final enum LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

.field public static final enum LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

.field public static final enum LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 417
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    const-string v1, "LightningInteraction"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 418
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    const-string v1, "LightningPageView"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 419
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    const-string v1, "LightningPerformance"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 420
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    const-string v1, "LightningError"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningError:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    .line 416
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningInteraction:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPageView:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningPerformance:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->LightningError:Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->$VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

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
    .line 416
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;
    .locals 1

    .prologue
    .line 416
    const-class v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;
    .locals 1

    .prologue
    .line 416
    sget-object v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->$VALUES:[Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent$SchemaType;

    return-object v0
.end method
