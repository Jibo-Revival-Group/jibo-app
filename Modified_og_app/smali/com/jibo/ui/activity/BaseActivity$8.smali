.class Lcom/jibo/ui/activity/BaseActivity$8;
.super Ljava/lang/Object;
.source "BaseActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/BaseActivity;->l()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/BaseActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/BaseActivity;)V
    .locals 0

    .prologue
    .line 376
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity$8;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 379
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$8;->a:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 380
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$8;->a:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 382
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$8;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->j()V

    .line 383
    return-void
.end method
