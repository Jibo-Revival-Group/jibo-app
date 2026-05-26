.class public Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;
.source "WiFiTokenGetterFragment.java"


# static fields
.field public static final p:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->p:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 49
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    const-string v0, ""

    return-object v0
.end method

.method public onBtnContinueClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 68
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 69
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 70
    const-class v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 71
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 72
    return-void
.end method

.method public onBtnHelpClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 64
    return-void
.end method

.method public onCloseClick(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->h()Z

    .line 59
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 30
    const v0, 0x7f0b00a2

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 41
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onResume()V

    .line 43
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->a()V

    .line 44
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 35
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 36
    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 37
    return-void
.end method

.method protected s()V
    .locals 3

    .prologue
    .line 80
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 93
    :goto_0
    return-void

    .line 83
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->r()V

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->m:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_1

    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->getView()Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 88
    :cond_1
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 89
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 90
    const-class v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 91
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0
.end method
