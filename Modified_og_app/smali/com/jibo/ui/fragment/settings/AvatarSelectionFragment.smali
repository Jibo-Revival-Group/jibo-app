.class public Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;
.super Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;
.source "AvatarSelectionFragment.java"


# static fields
.field public static final c:Ljava/lang/String;


# instance fields
.field jiboAvatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private p:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->c:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;-><init>()V

    .line 34
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->p:Z

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 28
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    .line 130
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a(Z)V

    .line 131
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 155
    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Landroid/support/v7/widget/RecyclerView;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->list:Landroid/support/v7/widget/RecyclerView;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)Landroid/support/v7/widget/RecyclerView;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->list:Landroid/support/v7/widget/RecyclerView;

    return-object v0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 117
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 118
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->p:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 119
    return-void

    .line 118
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(I)V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->jiboAvatar:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 69
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    const v0, 0x7f1003fa

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 38
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 40
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->setHasOptionsMenu(Z)V

    .line 42
    if-eqz p1, :cond_1

    .line 43
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 51
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    if-gtz v0, :cond_2

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->p:Z

    .line 52
    return-void

    .line 44
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 45
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    goto :goto_0

    .line 51
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 90
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 92
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->p:Z

    if-eqz v0, :cond_0

    .line 93
    const v0, 0x7f0c0003

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 94
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 96
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 56
    const v0, 0x7f0b0061

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 101
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f090026

    if-ne v0, v1, :cond_0

    .line 102
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 103
    const/4 v0, 0x1

    .line 105
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 73
    invoke-super {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onResume()V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_1

    .line 76
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 86
    :cond_0
    :goto_0
    return-void

    .line 81
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-nez v0, :cond_0

    .line 83
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 111
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 112
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 113
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 61
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->jiboAvatar:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 64
    return-void
.end method
