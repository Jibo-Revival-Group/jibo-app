.class public Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;
.source "ArticleListRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:I

.field private final d:I

.field private final e:I

.field private final f:Ljava/lang/CharSequence;

.field private final g:I

.field private final h:I


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;)V
    .locals 1

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;)V

    .line 121
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->a:Ljava/lang/String;

    .line 122
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->b:Ljava/lang/String;

    .line 123
    iget v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->c:I

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c:I

    .line 124
    iget v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->d:I

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->d:I

    .line 125
    iget v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->e:I

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->e:I

    .line 126
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->f:Ljava/lang/CharSequence;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->f:Ljava/lang/CharSequence;

    .line 127
    iget v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->g:I

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->g:I

    .line 128
    iget v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->h:I

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->h:I

    .line 129
    return-void
.end method

.method public static a()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 1

    .prologue
    .line 132
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public b()I
    .locals 1

    .prologue
    .line 145
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c:I

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 155
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->d:I

    return v0
.end method

.method public d()Ljava/lang/String;
    .locals 2

    .prologue
    .line 171
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->e:I

    packed-switch v0, :pswitch_data_0

    .line 175
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown query method"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 173
    :pswitch_0
    const-string v0, "BELOW"

    return-object v0

    .line 171
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public e()I
    .locals 1

    .prologue
    .line 185
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->g:I

    return v0
.end method

.method public f()Ljava/lang/String;
    .locals 2

    .prologue
    .line 192
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->g:I

    packed-switch v0, :pswitch_data_0

    .line 200
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown sortBy"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 194
    :pswitch_0
    const-string v0, "LastPublishedDate"

    .line 198
    :goto_0
    return-object v0

    .line 196
    :pswitch_1
    const-string v0, "Title"

    goto :goto_0

    .line 198
    :pswitch_2
    const-string v0, "ViewScore"

    goto :goto_0

    .line 192
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public g()I
    .locals 1

    .prologue
    .line 209
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->h:I

    return v0
.end method

.method public h()Ljava/lang/String;
    .locals 2

    .prologue
    .line 216
    iget v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->h:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 217
    const-string v0, "ASC"

    .line 220
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "DESC"

    goto :goto_0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->b:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public k()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->f:Ljava/lang/CharSequence;

    return-object v0
.end method
