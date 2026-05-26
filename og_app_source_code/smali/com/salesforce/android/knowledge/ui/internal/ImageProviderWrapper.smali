.class public Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;
.super Ljava/lang/Object;
.source "ImageProviderWrapper.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    .line 52
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)V

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 63
    const/4 v0, 0x0

    .line 65
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    if-eqz v1, :cond_0

    .line 66
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 70
    :cond_0
    if-eqz v0, :cond_1

    .line 71
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 74
    :cond_1
    return-object v0
.end method

.method public a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;)Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 79
    const/4 v0, 0x0

    .line 81
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    if-eqz v1, :cond_0

    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 86
    :cond_0
    if-eqz v0, :cond_1

    .line 87
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 90
    :cond_1
    return-object v0
.end method
