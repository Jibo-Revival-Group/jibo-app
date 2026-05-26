.class Lcom/jibo/ui/activity/BaseActivity$7;
.super Ljava/lang/Object;
.source "BaseActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/BaseActivity;->a(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/jibo/ui/activity/BaseActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/BaseActivity;Z)V
    .locals 0

    .prologue
    .line 363
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity$7;->b:Lcom/jibo/ui/activity/BaseActivity;

    iput-boolean p2, p0, Lcom/jibo/ui/activity/BaseActivity$7;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 366
    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity$7;->b:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v1, v1, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    if-eqz v1, :cond_0

    .line 367
    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity$7;->b:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v1, v1, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v0}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 369
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity$7;->b:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v1, v1, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    if-eqz v1, :cond_1

    .line 370
    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity$7;->b:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v1, v1, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    iget-boolean v2, p0, Lcom/jibo/ui/activity/BaseActivity$7;->a:Z

    if-eqz v2, :cond_2

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 371
    :cond_1
    return-void

    .line 370
    :cond_2
    const/16 v0, 0x8

    goto :goto_0
.end method
