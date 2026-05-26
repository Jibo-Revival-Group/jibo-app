.class Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener$1;
.super Ljava/lang/Object;
.source "AnimatedOnClickListener.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener$1;->b:Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener$1;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2

    .prologue
    .line 87
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener$1;->a:Landroid/view/View;

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/view/View;->setBackgroundColor(I)V

    .line 88
    return-void
.end method
