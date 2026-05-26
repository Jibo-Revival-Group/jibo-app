.class public abstract Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;
.super Lcom/jibo/ui/fragment/settings/LocationFragment;
.source "AvatarsLocationBaseFragment.java"


# instance fields
.field protected a:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field protected b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field protected list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 31
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object p1
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object p1
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object p1
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method


# virtual methods
.method public abstract b(I)V
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->onCreate(Landroid/os/Bundle;)V

    .line 44
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->setHasOptionsMenu(Z)V

    .line 46
    if-eqz p1, :cond_2

    .line 47
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 52
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 53
    if-eqz v0, :cond_1

    .line 54
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 57
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 58
    return-void

    .line 48
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 49
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 62
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/LocationFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 64
    new-instance v0, Landroid/support/v7/widget/GridLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x4

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v4, v3}, Landroid/support/v7/widget/GridLayoutManager;-><init>(Landroid/content/Context;IIZ)V

    .line 66
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v4}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 67
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v2}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 68
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;

    const v2, 0x7f0b00b6

    iget-object v3, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v3}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v3

    new-instance v4, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;-><init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)V

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;-><init>(IILandroid/view/View$OnClickListener;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 115
    return-void
.end method
