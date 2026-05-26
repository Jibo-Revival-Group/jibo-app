.class Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout$1;
.super Ljava/lang/Object;
.source "TintedCollapsingToolbarLayout.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->a(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout$1;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2

    .prologue
    .line 122
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout$1;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setToolbarTint(I)V

    .line 123
    return-void
.end method
