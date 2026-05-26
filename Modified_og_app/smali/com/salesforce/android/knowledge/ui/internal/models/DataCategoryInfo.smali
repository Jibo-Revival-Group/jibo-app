.class public Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;
.super Ljava/lang/Object;
.source "DataCategoryInfo.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:I

.field private final d:I

.field private final e:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;


# direct methods
.method protected constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a:Ljava/lang/String;

    .line 68
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b:Ljava/lang/String;

    .line 69
    iput v1, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->c:I

    .line 70
    iput v1, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->d:I

    .line 71
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->e:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    .line 72
    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;ILcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a:Ljava/lang/String;

    .line 60
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b:Ljava/lang/String;

    .line 61
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->c()I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->c:I

    .line 62
    iput p2, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->d:I

    .line 63
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->e:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    .line 64
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;ILcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-direct {v0, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;-><init>(Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;ILcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)V

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->e:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    invoke-interface {v0, p1, p0}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 95
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->c:I

    return v0
.end method

.method public d()I
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->d:I

    return v0
.end method
