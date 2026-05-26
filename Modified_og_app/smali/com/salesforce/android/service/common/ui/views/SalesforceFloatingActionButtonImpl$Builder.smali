.class Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
.super Ljava/lang/Object;
.source "SalesforceFloatingActionButtonImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Builder"
.end annotation


# instance fields
.field final a:Landroid/view/View;

.field b:I

.field c:I

.field d:I

.field e:I

.field f:Landroid/graphics/drawable/Drawable;

.field g:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 297
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 298
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a:Landroid/view/View;

    .line 299
    return-void
.end method


# virtual methods
.method public a(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 0

    .prologue
    .line 302
    iput p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->b:I

    .line 303
    return-object p0
.end method

.method public a(Landroid/graphics/drawable/Drawable;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 0

    .prologue
    .line 322
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->f:Landroid/graphics/drawable/Drawable;

    .line 323
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->g:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    .line 333
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->f:Landroid/graphics/drawable/Drawable;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->g:Landroid/graphics/drawable/Drawable;

    .line 335
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;)V

    return-object v0
.end method

.method public b(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 0

    .prologue
    .line 307
    iput p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->c:I

    .line 308
    return-object p0
.end method

.method public b(Landroid/graphics/drawable/Drawable;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 0

    .prologue
    .line 327
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->g:Landroid/graphics/drawable/Drawable;

    .line 328
    return-object p0
.end method

.method public c(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 0

    .prologue
    .line 312
    iput p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->d:I

    .line 313
    return-object p0
.end method

.method public d(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 0

    .prologue
    .line 317
    iput p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->e:I

    .line 318
    return-object p0
.end method
