.class public Lcom/jibo/ui/fragment/settings/RobotAboutFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "RobotAboutFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field osVersion:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field ownerEmail:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field ownerName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field serialName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 42
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 97
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 98
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 99
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    const v0, 0x7f100425

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 48
    if-eqz p1, :cond_1

    .line 49
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 50
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 57
    const v0, 0x7f0b0088

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 87
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 90
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 93
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 82
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 83
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const v3, 0x7f100278

    .line 62
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    .line 65
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 66
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerName:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerEmail:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 72
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->osVersion:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getRobotOS(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 73
    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 72
    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->serialName:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getRobotSerialName(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 75
    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 74
    :goto_2
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    return-void

    .line 68
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerName:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 73
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getRobotOS(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 75
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getRobotSerialName(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    goto :goto_2
.end method
