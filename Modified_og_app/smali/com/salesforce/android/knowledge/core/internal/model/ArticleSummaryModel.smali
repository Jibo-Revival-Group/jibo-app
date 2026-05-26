.class public Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;
.super Ljava/lang/Object;
.source "ArticleSummaryModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/ArticleSummary;


# instance fields
.field a:Ljava/lang/String;

.field b:Ljava/lang/String;

.field c:Ljava/lang/String;

.field d:Ljava/lang/String;

.field e:Ljava/lang/String;

.field f:I

.field g:D

.field h:Ljava/util/Date;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;)V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->a:Ljava/lang/String;

    .line 60
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->b:Ljava/lang/String;

    .line 61
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->c:Ljava/lang/String;

    .line 62
    iput-object p4, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->d:Ljava/lang/String;

    .line 63
    iput-object p5, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->e:Ljava/lang/String;

    .line 64
    iput p6, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->f:I

    .line 65
    iput-wide p7, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->g:D

    .line 66
    iput-object p9, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->h:Ljava/util/Date;

    .line 67
    return-void
.end method

.method static a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;
    .locals 11

    .prologue
    .line 70
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;

    .line 71
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->c()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->d()Ljava/lang/String;

    move-result-object v5

    .line 72
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->e()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->f()I

    move-result v7

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->g()D

    move-result-wide v8

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->h()Ljava/util/Date;

    move-result-object v10

    invoke-direct/range {v1 .. v10}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;)V

    .line 70
    return-object v1
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;
    .locals 12

    .prologue
    .line 84
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;

    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move-object/from16 v6, p4

    move/from16 v7, p5

    move-wide/from16 v8, p6

    move-object/from16 v10, p8

    invoke-direct/range {v1 .. v10}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;)V

    return-object v1
.end method


# virtual methods
.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->d:Ljava/lang/String;

    return-object v0
.end method

.method public k()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->e:Ljava/lang/String;

    return-object v0
.end method

.method public l()I
    .locals 1

    .prologue
    .line 112
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->f:I

    return v0
.end method

.method public m()D
    .locals 2

    .prologue
    .line 116
    iget-wide v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->g:D

    return-wide v0
.end method

.method public n()Ljava/util/Date;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->h:Ljava/util/Date;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 129
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ArticleSummary["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
