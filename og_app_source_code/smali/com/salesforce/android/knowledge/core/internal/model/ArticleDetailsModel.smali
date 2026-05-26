.class public Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;
.super Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;
.source "ArticleDetailsModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/ArticleDetails;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;
    }
.end annotation


# instance fields
.field private final i:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;",
            ">;"
        }
    .end annotation
.end field

.field private final j:I

.field private final k:Ljava/util/Date;

.field private final l:Ljava/util/Date;

.field private final m:Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

.field private final n:Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;ILjava/util/Date;Ljava/util/Date;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "ID",
            "Ljava/util/Date;",
            "I",
            "Ljava/util/Date;",
            "Ljava/util/Date;",
            "Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;",
            "Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    invoke-direct/range {p0 .. p9}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;)V

    .line 61
    iput p10, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->j:I

    .line 62
    iput-object p11, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->k:Ljava/util/Date;

    .line 63
    iput-object p12, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->l:Ljava/util/Date;

    .line 64
    move-object/from16 v0, p13

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->m:Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    .line 65
    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->n:Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    .line 68
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface/range {p15 .. p15}, Ljava/util/List;->size()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 69
    move-object/from16 v0, p15

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 70
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->i:Ljava/util/List;

    .line 71
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;
    .locals 19

    .prologue
    .line 74
    new-instance v18, Ljava/util/ArrayList;

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->j()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    move-object/from16 v0, v18

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 75
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->j()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;

    .line 76
    invoke-static {v2}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;

    move-result-object v2

    move-object/from16 v0, v18

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 79
    :cond_0
    new-instance v3, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;

    .line 80
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->f()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->c()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->l()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->k()Ljava/lang/String;

    move-result-object v7

    .line 81
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->m()Ljava/lang/String;

    move-result-object v8

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->a()I

    move-result v9

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->b()D

    move-result-wide v10

    .line 82
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->i()Ljava/util/Date;

    move-result-object v12

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->n()I

    move-result v13

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->e()Ljava/util/Date;

    move-result-object v14

    .line 83
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->h()Ljava/util/Date;

    move-result-object v15

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->d()Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;

    move-result-object v2

    invoke-static {v2}, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    move-result-object v16

    .line 84
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->g()Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;

    move-result-object v2

    invoke-static {v2}, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    move-result-object v17

    invoke-direct/range {v3 .. v18}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;ILjava/util/Date;Ljava/util/Date;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Ljava/util/List;)V

    .line 79
    return-object v3
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;ILjava/util/Date;Ljava/util/Date;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "ID",
            "Ljava/util/Date;",
            "I",
            "Ljava/util/Date;",
            "Ljava/util/Date;",
            "Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;",
            "Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;",
            ">;)",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;"
        }
    .end annotation

    .prologue
    .line 103
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p4

    move/from16 v7, p5

    move-wide/from16 v8, p6

    move-object/from16 v10, p8

    move/from16 v11, p9

    move-object/from16 v12, p10

    move-object/from16 v13, p11

    move-object/from16 v14, p12

    move-object/from16 v15, p13

    move-object/from16 v16, p14

    invoke-direct/range {v1 .. v16}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;ILjava/util/Date;Ljava/util/Date;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Ljava/util/List;)V

    return-object v1
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 111
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->j:I

    return v0
.end method

.method public b()Ljava/util/Date;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->k:Ljava/util/Date;

    return-object v0
.end method

.method public c()Ljava/util/Date;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->l:Ljava/util/Date;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/knowledge/core/model/ChatterUser;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->m:Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    return-object v0
.end method

.method public e()Lcom/salesforce/android/knowledge/core/model/ChatterUser;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->n:Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    return-object v0
.end method

.method public f()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;",
            ">;"
        }
    .end annotation

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->i:Ljava/util/List;

    return-object v0
.end method
