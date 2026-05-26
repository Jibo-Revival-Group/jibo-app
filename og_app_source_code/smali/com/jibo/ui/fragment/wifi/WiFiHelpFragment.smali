.class public Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;
.source "WiFiHelpFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public btnWiFiError1Click(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 45
    return-void
.end method

.method public btnWiFiError2Click(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiError2Fragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 51
    return-void
.end method

.method public btnWiFiError3Click(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 55
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e3

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->startActivity(Landroid/content/Intent;)V

    .line 56
    return-void
.end method

.method public btnWiFiError4Click(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 60
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e6

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->startActivity(Landroid/content/Intent;)V

    .line 61
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    const v0, 0x7f10042e

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0

    .prologue
    .line 26
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 33
    const v0, 0x7f0b0099

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 26
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method
