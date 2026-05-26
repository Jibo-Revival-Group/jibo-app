.class public Lcom/google/maps/internal/ApiConfig;
.super Ljava/lang/Object;
.source "ApiConfig.java"


# instance fields
.field public fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

.field public hostName:Ljava/lang/String;

.field public path:Ljava/lang/String;

.field public requestVerb:Ljava/lang/String;

.field public supportsClientId:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    sget-object v0, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    iput-object v0, p0, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    .line 24
    const-string v0, "https://maps.googleapis.com"

    iput-object v0, p0, Lcom/google/maps/internal/ApiConfig;->hostName:Ljava/lang/String;

    .line 25
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    .line 26
    const-string v0, "GET"

    iput-object v0, p0, Lcom/google/maps/internal/ApiConfig;->requestVerb:Ljava/lang/String;

    .line 29
    iput-object p1, p0, Lcom/google/maps/internal/ApiConfig;->path:Ljava/lang/String;

    .line 30
    return-void
.end method


# virtual methods
.method public fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    .line 34
    return-object p0
.end method

.method public hostName(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/google/maps/internal/ApiConfig;->hostName:Ljava/lang/String;

    .line 39
    return-object p0
.end method

.method public requestVerb(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/google/maps/internal/ApiConfig;->requestVerb:Ljava/lang/String;

    .line 49
    return-object p0
.end method

.method public supportsClientId(Z)Lcom/google/maps/internal/ApiConfig;
    .locals 0

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    .line 44
    return-object p0
.end method
