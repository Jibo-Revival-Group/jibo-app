.class public Lcom/google/maps/model/ComponentFilter;
.super Ljava/lang/Object;
.source "ComponentFilter.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# instance fields
.field public final component:Ljava/lang/String;

.field public final value:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/google/maps/model/ComponentFilter;->component:Ljava/lang/String;

    .line 43
    iput-object p2, p0, Lcom/google/maps/model/ComponentFilter;->value:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public static administrativeArea(Ljava/lang/String;)Lcom/google/maps/model/ComponentFilter;
    .locals 2

    .prologue
    .line 83
    new-instance v0, Lcom/google/maps/model/ComponentFilter;

    const-string v1, "administrative_area"

    invoke-direct {v0, v1, p0}, Lcom/google/maps/model/ComponentFilter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static country(Ljava/lang/String;)Lcom/google/maps/model/ComponentFilter;
    .locals 2

    .prologue
    .line 103
    new-instance v0, Lcom/google/maps/model/ComponentFilter;

    const-string v1, "country"

    invoke-direct {v0, v1, p0}, Lcom/google/maps/model/ComponentFilter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static locality(Ljava/lang/String;)Lcom/google/maps/model/ComponentFilter;
    .locals 2

    .prologue
    .line 73
    new-instance v0, Lcom/google/maps/model/ComponentFilter;

    const-string v1, "locality"

    invoke-direct {v0, v1, p0}, Lcom/google/maps/model/ComponentFilter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static postalCode(Ljava/lang/String;)Lcom/google/maps/model/ComponentFilter;
    .locals 2

    .prologue
    .line 93
    new-instance v0, Lcom/google/maps/model/ComponentFilter;

    const-string v1, "postal_code"

    invoke-direct {v0, v1, p0}, Lcom/google/maps/model/ComponentFilter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static route(Ljava/lang/String;)Lcom/google/maps/model/ComponentFilter;
    .locals 2

    .prologue
    .line 63
    new-instance v0, Lcom/google/maps/model/ComponentFilter;

    const-string v1, "route"

    invoke-direct {v0, v1, p0}, Lcom/google/maps/model/ComponentFilter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/google/maps/model/ComponentFilter;->toUrlValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 4

    .prologue
    .line 53
    const/16 v0, 0x3a

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/google/maps/model/ComponentFilter;->component:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/google/maps/model/ComponentFilter;->value:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/google/maps/internal/StringJoin;->join(C[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
