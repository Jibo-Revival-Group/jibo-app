.class public Lcom/jibo/ui/fragment/guided/LocationSlideFragment;
.super Lcom/jibo/ui/fragment/settings/LocationFragment;
.source "LocationSlideFragment.java"


# instance fields
.field text2:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field topText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 4

    .prologue
    .line 100
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->l:Ljava/lang/String;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    new-instance v0, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;-><init>()V

    .line 102
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 103
    const-string v2, "ARGS_LOCATION"

    iget-object v3, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->l:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    const-string v2, "ARGS_TIMEZONE"

    iget-object v3, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->m:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->setArguments(Landroid/os/Bundle;)V

    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 108
    :cond_0
    return-void
.end method

.method public btnSetLocationClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 93
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->l(Landroid/content/Context;)V

    .line 94
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->btnSetLocationClick(Landroid/view/View;)V

    .line 95
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    const-string v0, ""

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 48
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->onCreate(Landroid/os/Bundle;)V

    .line 50
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->k()V

    .line 51
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->setUserVisibleHint(Z)V

    .line 52
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 56
    const v0, 0x7f0b006f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 8

    .prologue
    const/16 v7, 0x21

    .line 61
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/LocationFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 63
    const v0, 0x7f100150

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 64
    const v1, 0x7f100153

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 65
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 66
    new-instance v3, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const v5, 0x7f06007b

    invoke-static {v4, v5}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 67
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v5, v6

    .line 66
    invoke-virtual {v2, v3, v4, v5, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 68
    new-instance v3, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v4, ""

    sget-object v5, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-direct {v3, v4, v5}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 69
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v5, v6

    .line 68
    invoke-virtual {v2, v3, v4, v5, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 71
    new-instance v3, Lcom/jibo/ui/fragment/guided/LocationSlideFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment$1;-><init>(Lcom/jibo/ui/fragment/guided/LocationSlideFragment;)V

    .line 80
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, v1

    .line 71
    invoke-virtual {v2, v3, v4, v0, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 82
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->text2:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->text2:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 84
    return-void
.end method
