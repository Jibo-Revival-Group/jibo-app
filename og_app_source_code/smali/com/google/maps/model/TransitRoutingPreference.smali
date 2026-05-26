.class public final enum Lcom/google/maps/model/TransitRoutingPreference;
.super Ljava/lang/Enum;
.source "TransitRoutingPreference.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/TransitRoutingPreference;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/TransitRoutingPreference;

.field public static final enum FEWER_TRANSFERS:Lcom/google/maps/model/TransitRoutingPreference;

.field public static final enum LESS_WALKING:Lcom/google/maps/model/TransitRoutingPreference;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 8
    new-instance v0, Lcom/google/maps/model/TransitRoutingPreference;

    const-string v1, "LESS_WALKING"

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/TransitRoutingPreference;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitRoutingPreference;->LESS_WALKING:Lcom/google/maps/model/TransitRoutingPreference;

    .line 9
    new-instance v0, Lcom/google/maps/model/TransitRoutingPreference;

    const-string v1, "FEWER_TRANSFERS"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/TransitRoutingPreference;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitRoutingPreference;->FEWER_TRANSFERS:Lcom/google/maps/model/TransitRoutingPreference;

    .line 7
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/google/maps/model/TransitRoutingPreference;

    sget-object v1, Lcom/google/maps/model/TransitRoutingPreference;->LESS_WALKING:Lcom/google/maps/model/TransitRoutingPreference;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/maps/model/TransitRoutingPreference;->FEWER_TRANSFERS:Lcom/google/maps/model/TransitRoutingPreference;

    aput-object v1, v0, v3

    sput-object v0, Lcom/google/maps/model/TransitRoutingPreference;->$VALUES:[Lcom/google/maps/model/TransitRoutingPreference;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/TransitRoutingPreference;
    .locals 1

    .prologue
    .line 7
    const-class v0, Lcom/google/maps/model/TransitRoutingPreference;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/TransitRoutingPreference;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/TransitRoutingPreference;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/google/maps/model/TransitRoutingPreference;->$VALUES:[Lcom/google/maps/model/TransitRoutingPreference;

    invoke-virtual {v0}, [Lcom/google/maps/model/TransitRoutingPreference;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/TransitRoutingPreference;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/google/maps/model/TransitRoutingPreference;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/google/maps/model/TransitRoutingPreference;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
