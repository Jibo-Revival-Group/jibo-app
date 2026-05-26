.class public Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;
.super Ljava/lang/Object;
.source "ChatterUserModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/ChatterUser;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/lang/String;

.field private final e:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->a:Ljava/lang/String;

    .line 40
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->b:Ljava/lang/String;

    .line 41
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->c:Ljava/lang/String;

    .line 42
    iput-object p4, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->d:Ljava/lang/String;

    .line 43
    iput-object p5, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->e:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;
    .locals 6

    .prologue
    .line 47
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    .line 48
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;->e()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;->c()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;
    .locals 6

    .prologue
    .line 53
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->e:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->d:Ljava/lang/String;

    return-object v0
.end method
