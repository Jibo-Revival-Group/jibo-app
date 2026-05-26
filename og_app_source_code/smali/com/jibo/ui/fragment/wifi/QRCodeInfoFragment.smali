.class public Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;
.source "QRCodeInfoFragment.java"


# instance fields
.field private final a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static synthetic a(Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->a:Ljava/util/ArrayList;

    return-object v0
.end method

.method private b(Landroid/support/v7/app/ActionBar;)V
    .locals 2

    .prologue
    .line 64
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 66
    const v0, 0x7f08005b

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 67
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 60
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->b(Landroid/support/v7/app/ActionBar;)V

    .line 61
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    const v0, 0x7f100432

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onContinue(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 50
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 38
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 3

    .prologue
    .line 71
    const v0, 0x7f0c0005

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 72
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->a:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 76
    :goto_0
    if-eqz v0, :cond_1

    .line 77
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06007b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 95
    :goto_1
    return-void

    .line 75
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 80
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 81
    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 44
    const v0, 0x7f0b00a2

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 99
    const v0, 0x7f090028

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 100
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e8

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->startActivity(Landroid/content/Intent;)V

    .line 101
    const/4 v0, 0x1

    .line 103
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method
