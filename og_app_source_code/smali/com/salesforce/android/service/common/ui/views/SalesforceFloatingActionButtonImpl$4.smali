.class Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SalesforceFloatingActionButtonImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 198
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->c:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, v1, v1, v1, v1}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    .line 199
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->d:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, v1, v1, v1, v1}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    .line 200
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v1, v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->g:Landroid/graphics/drawable/Drawable;

    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget v2, v2, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->i:I

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/drawable/Drawable;I)V

    .line 201
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 202
    return-void
.end method
