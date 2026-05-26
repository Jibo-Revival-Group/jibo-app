.class Lcom/jibo/ui/activity/TabbedActivity$7;
.super Ljava/lang/Object;
.source "TabbedActivity.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TabbedActivity;->D()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/TabbedActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;)V
    .locals 0

    .prologue
    .line 574
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$7;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 585
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$7;->a:Lcom/jibo/ui/activity/TabbedActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 586
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 580
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$7;->a:Lcom/jibo/ui/activity/TabbedActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 581
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0

    .prologue
    .line 589
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 0

    .prologue
    .line 576
    return-void
.end method
