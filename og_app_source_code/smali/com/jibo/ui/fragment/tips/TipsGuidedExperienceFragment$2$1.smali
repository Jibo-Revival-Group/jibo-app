.class Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;
.super Ljava/lang/Object;
.source "TipsGuidedExperienceFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->a(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a(I)V

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 179
    return-void
.end method
