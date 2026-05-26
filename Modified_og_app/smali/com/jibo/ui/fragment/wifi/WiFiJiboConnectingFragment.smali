.class public Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;
.source "WiFiJiboConnectingFragment.java"


# static fields
.field public static final p:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;->p:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 53
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 54
    return-void
.end method

.method public h()Z
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 46
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;I)Z

    .line 48
    return v2
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    const-string v0, ""

    return-object v0
.end method

.method public onBtnEditWifiClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/wifi/WaitForTapFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;I)Z

    .line 70
    return-void
.end method

.method public onBtnNoScreenClick(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;->h()Z

    .line 64
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 29
    const v0, 0x7f0b009b

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 39
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onResume()V

    .line 41
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;->q()V

    .line 42
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 34
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 35
    return-void
.end method

.method protected s()V
    .locals 0

    .prologue
    .line 76
    return-void
.end method
