.class Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;
.super Landroid/view/ViewOutlineProvider;
.source "SalesforceFloatingActionButtonImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;I)V
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iput p2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;->a:I

    invoke-direct {p0}, Landroid/view/ViewOutlineProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public getOutline(Landroid/view/View;Landroid/graphics/Outline;)V
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 271
    new-instance v0, Landroid/graphics/Rect;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;->a:I

    iget v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;->a:I

    invoke-direct {v0, v3, v3, v1, v2}, Landroid/graphics/Rect;-><init>(IIII)V

    invoke-virtual {p2, v0}, Landroid/graphics/Outline;->setOval(Landroid/graphics/Rect;)V

    .line 272
    return-void
.end method
