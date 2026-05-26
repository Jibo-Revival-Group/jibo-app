.class public Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;
.super Ljava/lang/Object;
.source "SearchPresenterImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
        ">;"
    }
.end annotation


# static fields
.field static final synthetic a:Z


# instance fields
.field private final b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field private final c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

.field private d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

.field private e:Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;"
        }
    .end annotation
.end field

.field private g:Ljava/lang/CharSequence;

.field private h:I

.field private i:Z

.field private j:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f:Ljava/util/List;

    .line 63
    const-string v0, ""

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->g:Ljava/lang/CharSequence;

    .line 64
    iput v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->h:I

    .line 66
    iput-boolean v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->j:Z

    .line 77
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 78
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    .line 79
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;
    .locals 1

    .prologue
    .line 73
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V

    return-object v0
.end method

.method private d()V
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 161
    const/4 v0, 0x1

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->h:I

    .line 162
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->c()V

    .line 165
    :cond_0
    return-void
.end method

.method private e()V
    .locals 2

    .prologue
    .line 168
    invoke-static {}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->a()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    const/16 v1, 0x14

    .line 169
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->b(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->h:I

    .line 170
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->g:Ljava/lang/CharSequence;

    .line 171
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a(Ljava/lang/CharSequence;)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    .line 175
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 176
    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 177
    return-void
.end method

.method private f()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 180
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-nez v0, :cond_0

    .line 200
    :goto_0
    return-void

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 185
    :goto_1
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v3}, Lcom/salesforce/android/service/common/utilities/control/Async;->e()Z

    move-result v3

    if-eqz v3, :cond_2

    move v3, v1

    .line 187
    :goto_2
    if-eqz v0, :cond_3

    .line 188
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    const/4 v1, 0x4

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(I)V

    goto :goto_0

    :cond_1
    move v0, v2

    .line 184
    goto :goto_1

    :cond_2
    move v3, v2

    .line 185
    goto :goto_2

    .line 189
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->g:Ljava/lang/CharSequence;

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-gt v0, v1, :cond_4

    .line 191
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-interface {v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(I)V

    goto :goto_0

    .line 192
    :cond_4
    if-eqz v3, :cond_5

    .line 194
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(I)V

    goto :goto_0

    .line 195
    :cond_5
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_6

    .line 196
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(I)V

    goto :goto_0

    .line 198
    :cond_6
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(I)V

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 146
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->h:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->h:I

    .line 147
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e()V

    .line 148
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 1

    .prologue
    .line 141
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 143
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;)V
    .locals 3

    .prologue
    .line 90
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f:Ljava/util/List;

    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->i:Z

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(Ljava/util/List;Z)V

    .line 92
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->g:Ljava/lang/CharSequence;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(Ljava/lang/CharSequence;)V

    .line 93
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f()V

    .line 95
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->j:Z

    if-eqz v0, :cond_0

    .line 96
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->e()V

    .line 97
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->j:Z

    .line 99
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 227
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f()V

    .line 228
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ")V"
        }
    .end annotation

    .prologue
    .line 211
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f:Ljava/util/List;

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 212
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->c()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->i:Z

    .line 214
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-nez v0, :cond_0

    .line 224
    :goto_0
    return-void

    .line 218
    :cond_0
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->b()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 219
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v1

    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->i:Z

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a(Ljava/util/List;Z)V

    .line 223
    :goto_1
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->d()V

    goto :goto_0

    .line 221
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v1

    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->i:Z

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->b(Ljava/util/List;Z)V

    goto :goto_1
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 40
    check-cast p2, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 207
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f()V

    .line 208
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 2

    .prologue
    .line 115
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 117
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->g:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 138
    :goto_0
    return-void

    .line 121
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_2

    .line 122
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->c()V

    .line 125
    :cond_2
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->g:Ljava/lang/CharSequence;

    .line 127
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_4

    .line 130
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->h()V

    .line 137
    :cond_3
    :goto_1
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->f()V

    goto :goto_0

    .line 131
    :cond_4
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_3

    .line 132
    invoke-static {p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->a(Ljava/lang/CharSequence;)V

    .line 133
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d()V

    .line 134
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e()V

    goto :goto_1
.end method

.method public synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 40
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->b(Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;)V

    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 151
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 152
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;->a()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public b()V
    .locals 0

    .prologue
    .line 86
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->l()V

    .line 87
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;)V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    if-ne v0, p1, :cond_0

    .line 103
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    .line 105
    :cond_0
    return-void
.end method

.method public synthetic b(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 40
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;)V

    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->c()V

    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->e:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 112
    :cond_0
    return-void
.end method
