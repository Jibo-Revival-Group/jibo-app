.class Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;
.super Ljava/lang/Object;
.source "SalesforceFloatingActionButtonImpl.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

.field final synthetic b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iput-object p2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->a:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 5

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    .line 166
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v2, v2, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->c:Landroid/graphics/drawable/GradientDrawable;

    iget-object v3, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v4, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->a:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v3, v4}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->c(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/drawable/Drawable;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;F)V

    .line 167
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;->b:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 168
    return-void
.end method
