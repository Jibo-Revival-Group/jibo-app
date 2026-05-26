.class public Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;
.source "WiFiSuccessFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/ui/activity/WifiActivity$Mode;

.field btnContinue:Lcom/jibo/ui/view/proxima/CustomFontButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field jiboImage:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtInfo:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 99
    return-void
.end method

.method public h()Z
    .locals 3

    .prologue
    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->b:Lcom/jibo/ui/activity/WifiActivity$Mode;

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    if-ne v0, v1, :cond_0

    .line 86
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 87
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 88
    const-string v1, "ARG_TAB_SELECTED"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 89
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 91
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 93
    const/4 v0, 0x1

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    const-string v0, ""

    return-object v0
.end method

.method public onBtnContinueClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->b:Lcom/jibo/ui/activity/WifiActivity$Mode;

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    if-eq v0, v1, :cond_0

    .line 110
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->h()Z

    .line 118
    :goto_0
    return-void

    .line 112
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 113
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 115
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->k()V

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/WifiActivity;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/WifiActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/WifiActivity;->t()Lcom/jibo/ui/activity/WifiActivity$Mode;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->b:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 53
    const v0, 0x7f0b00a3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0

    .line 51
    :cond_0
    sget-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const v2, 0x7f080174

    .line 58
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 60
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment$1;->a:[I

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->b:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v1}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 80
    :goto_0
    return-void

    .line 62
    :pswitch_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtTitle:Landroid/widget/TextView;

    const v1, 0x7f10036d

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtInfo:Landroid/widget/TextView;

    const v1, 0x7f10036a

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->jiboImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 65
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->btnContinue:Lcom/jibo/ui/view/proxima/CustomFontButton;

    const v1, 0x7f100367

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontButton;->setText(I)V

    goto :goto_0

    .line 68
    :pswitch_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtTitle:Landroid/widget/TextView;

    const v1, 0x7f10036b

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtInfo:Landroid/widget/TextView;

    const v1, 0x7f100368

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->jiboImage:Landroid/widget/ImageView;

    const v1, 0x7f080104

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->btnContinue:Lcom/jibo/ui/view/proxima/CustomFontButton;

    const v1, 0x7f100365

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontButton;->setText(I)V

    goto :goto_0

    .line 74
    :pswitch_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtTitle:Landroid/widget/TextView;

    const v1, 0x7f10036c

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtInfo:Landroid/widget/TextView;

    const v1, 0x7f100369

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->jiboImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 77
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->btnContinue:Lcom/jibo/ui/view/proxima/CustomFontButton;

    const v1, 0x7f100366

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontButton;->setText(I)V

    goto :goto_0

    .line 60
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
