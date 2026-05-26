.class Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;
.super Ljava/lang/Object;
.source "JiboPreparationsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->btnNextScreenClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x258

    .line 137
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 161
    :goto_0
    return-void

    .line 140
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1$1;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 149
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)I

    move-result v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;I)V

    .line 152
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->progressView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    .line 153
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 154
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xc8

    .line 155
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setStartDelay(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 156
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)I

    goto :goto_0
.end method
