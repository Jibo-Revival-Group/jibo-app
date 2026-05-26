.class public Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;
.super Ljava/lang/Object;
.source "MinimizeContext.java"


# instance fields
.field final a:Landroid/graphics/drawable/Drawable;

.field final b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;


# direct methods
.method private constructor <init>(Landroid/graphics/drawable/Drawable;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->a:Landroid/graphics/drawable/Drawable;

    .line 46
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 47
    return-void
.end method

.method public static a(Landroid/graphics/drawable/Drawable;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;
    .locals 1

    .prologue
    .line 38
    if-eqz p0, :cond_0

    .line 39
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    .line 41
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;-><init>(Landroid/graphics/drawable/Drawable;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    return-object v0
.end method


# virtual methods
.method public a()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->a:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->i()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->g()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
