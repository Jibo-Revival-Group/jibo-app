.class Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;
.super Ljava/lang/Object;
.source "AvatarSelectionFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->g()V

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->jiboAvatar:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->c(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Landroid/support/v7/widget/RecyclerView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a(I)V

    .line 150
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->d(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Landroid/support/v7/widget/RecyclerView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 151
    return-void
.end method
