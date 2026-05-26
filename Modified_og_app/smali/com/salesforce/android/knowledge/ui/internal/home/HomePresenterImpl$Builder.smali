.class public Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;
.super Ljava/lang/Object;
.source "HomePresenterImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field final b:Ljava/lang/String;

.field c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 317
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 318
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 319
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->b:Ljava/lang/String;

    .line 320
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;
    .locals 2

    .prologue
    .line 334
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

    if-nez v0, :cond_0

    .line 335
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must supply a color calculator"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 338
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;)V

    return-object v0
.end method

.method public a(Landroid/content/Context;)Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;
    .locals 4

    .prologue
    .line 323
    sget v0, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_brand_primary:I

    invoke-static {p1, v0}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    .line 324
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

    const/16 v2, 0xa

    const/16 v3, 0x8

    invoke-direct {v1, v0, v2, v3}, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;-><init>(III)V

    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

    .line 325
    return-object p0
.end method
