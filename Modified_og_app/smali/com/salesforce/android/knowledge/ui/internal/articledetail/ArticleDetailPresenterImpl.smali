.class public Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;
.super Ljava/lang/Object;
.source "ArticleDetailPresenterImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;,
        Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;
    }
.end annotation


# static fields
.field static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field static final synthetic i:Z


# instance fields
.field final b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field final c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

.field final d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

.field e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

.field f:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

.field g:Landroid/graphics/drawable/Drawable;

.field h:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->i:Z

    .line 46
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void

    .line 44
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    .line 74
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 75
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 76
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;
    .locals 1

    .prologue
    .line 70
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    return-object v0
.end method

.method private c(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;)V
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->i()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(Ljava/lang/String;)V

    .line 123
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b()Z

    move-result v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(Z)V

    .line 124
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->g:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->g:Landroid/graphics/drawable/Drawable;

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(Landroid/graphics/drawable/Drawable;)V

    .line 127
    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 109
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->i:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->j()Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->g:Landroid/graphics/drawable/Drawable;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-static {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->a(Landroid/graphics/drawable/Drawable;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a(Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;)V

    .line 111
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;)V
    .locals 3

    .prologue
    .line 88
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    .line 89
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v0

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->g:Landroid/graphics/drawable/Drawable;

    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;)V

    .line 91
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->f()V

    .line 92
    return-void
.end method

.method public synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 44
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;)V

    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->g()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->i()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->j(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;->a()V

    .line 85
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;)V
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    if-ne p1, v0, :cond_0

    .line 96
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    .line 98
    :cond_0
    return-void
.end method

.method public synthetic b(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 44
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;)V

    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;->b()V

    .line 102
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a()V

    .line 106
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d()V

    .line 115
    return-void
.end method

.method f()V
    .locals 3

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    if-nez v0, :cond_1

    .line 156
    :cond_0
    :goto_0
    return-void

    .line 134
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;->d()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->f:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->f:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    .line 135
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->f()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    const/4 v0, 0x1

    .line 137
    :goto_1
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;->e()Z

    move-result v1

    if-eqz v1, :cond_4

    iget-boolean v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->h:Z

    if-eqz v1, :cond_4

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    const/4 v1, 0x4

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(I)V

    goto :goto_0

    .line 135
    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    .line 139
    :cond_4
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$ArticleDetailsHandler;->e()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 140
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(I)V

    goto :goto_0

    .line 141
    :cond_5
    if-eqz v0, :cond_6

    .line 142
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(I)V

    goto :goto_0

    .line 143
    :cond_6
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->f:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->f:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;)V

    .line 150
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method
