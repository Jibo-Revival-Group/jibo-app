.class Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;
.super Ljava/lang/Object;
.source "AvatarsLocationBaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const v1, 0x7f10003d

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 100
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->f(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->d(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->a:I

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b(I)V

    .line 105
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->a:I

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a(I)V

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 107
    return-void
.end method
