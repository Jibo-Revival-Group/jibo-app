.class public Lcom/salesforce/android/cases/core/internal/model/CommunityModel;
.super Ljava/lang/Object;
.source "CommunityModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/Community;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CommunitiesListResponse$Community;)V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommunitiesListResponse$Community;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommunityModel;->a:Ljava/lang/String;

    .line 38
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommunitiesListResponse$Community;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommunityModel;->b:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CommunitiesListResponse$Community;)Lcom/salesforce/android/cases/core/internal/model/CommunityModel;
    .locals 1

    .prologue
    .line 50
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CommunityModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CommunityModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CommunitiesListResponse$Community;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommunityModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommunityModel;->b:Ljava/lang/String;

    return-object v0
.end method
