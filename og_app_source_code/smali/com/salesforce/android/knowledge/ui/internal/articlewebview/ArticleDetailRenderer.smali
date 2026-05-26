.class public Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;
.super Ljava/lang/Object;
.source "ArticleDetailRenderer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    }
.end annotation


# static fields
.field static final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected final b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

.field private final c:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

.field private final d:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

.field private final e:I

.field private final f:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$1;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$1;-><init>()V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->a:Ljava/util/List;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)V
    .locals 1

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    sget v0, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_brand_secondary:I

    invoke-static {p1, v0}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->e:I

    .line 91
    sget v0, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_contrast_primary:I

    invoke-static {p1, v0}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->f:I

    .line 92
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 93
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    .line 94
    iput-object p4, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->d:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    .line 95
    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;
    .locals 1

    .prologue
    .line 84
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;-><init>(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 101
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a()Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v0

    .line 103
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->b()Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    iget v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->f:I

    .line 104
    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a(I)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    iget v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->e:I

    .line 105
    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->b(I)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    .line 106
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->c(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    .line 107
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->c()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a(Ljava/util/Date;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    .line 108
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->f()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a(Ljava/util/List;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 109
    invoke-interface {v2, v3}, Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->d:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 110
    invoke-interface {v2, v3}, Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->b(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    .line 112
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->c()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
