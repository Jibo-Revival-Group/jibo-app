.class public Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;
.super Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;
.source "LoopInfoDialog.java"


# instance fields
.field private d:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field peopleCountMessage:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public okayClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 82
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->dismiss()V

    .line 83
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 49
    new-instance v0, Landroid/support/v7/app/AppCompatDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x1030134

    invoke-direct {v0, v1, v2}, Landroid/support/v7/app/AppCompatDialog;-><init>(Landroid/content/Context;I)V

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b004e

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 52
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 54
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    iput-object v2, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->d:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 56
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->d:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v2

    .line 58
    if-eqz v2, :cond_1

    .line 59
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->d:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getActiveMembersCount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I

    move-result v2

    .line 61
    const/16 v3, 0x10

    if-lt v2, v3, :cond_0

    .line 63
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->peopleCountMessage:Landroid/widget/TextView;

    const v3, 0x7f1001af

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    :goto_0
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AppCompatDialog;->setContentView(Landroid/view/View;)V

    .line 75
    invoke-virtual {v0, v7}, Landroid/support/v7/app/AppCompatDialog;->setCancelable(Z)V

    .line 77
    return-object v0

    .line 65
    :cond_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->peopleCountMessage:Landroid/widget/TextView;

    const v4, 0x7f1001ec

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/Object;

    const/4 v6, 0x0

    rsub-int/lit8 v2, v2, 0x10

    .line 66
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v6

    .line 65
    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 69
    :cond_1
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->text:Landroid/widget/TextView;

    const v3, 0x7f1001ee

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 70
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->peopleCountMessage:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
