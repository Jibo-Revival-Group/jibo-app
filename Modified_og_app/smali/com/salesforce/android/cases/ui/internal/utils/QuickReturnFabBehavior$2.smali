.class Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;
.super Ljava/lang/Object;
.source "QuickReturnFabBehavior.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->b:Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->b:Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Z)Z

    .line 174
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->b:Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 175
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->b:Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->a:Landroid/view/View;

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Landroid/view/View;)V

    .line 177
    :cond_0
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 168
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;->b:Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Z)Z

    .line 169
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0

    .prologue
    .line 180
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 0

    .prologue
    .line 165
    return-void
.end method
