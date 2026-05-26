.class public Lcom/jibo/ui/fragment/tips/TipsListFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "TipsListFragment.java"


# static fields
.field public static final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private b:Landroid/view/View$OnClickListener;

.field tip0:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tip1:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tip2:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tip3:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tip4:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tip5:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 42
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "TAG_TIP4"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "TAG_TIP0"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "TAG_TIP1"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "TAG_TIP2"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "TAG_TIP3"

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/jibo/utils/Lists;->a([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->a:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 124
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsListFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    .line 66
    return-void
.end method


# virtual methods
.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    const v0, 0x7f10042a

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->setHasOptionsMenu(Z)V

    .line 73
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 104
    const v0, 0x7f0c0009

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 105
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 107
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 77
    const v0, 0x7f0b0094

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 111
    const v0, 0x7f090035

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 112
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e8

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->startActivity(Landroid/content/Intent;)V

    .line 113
    const/4 v0, 0x1

    .line 115
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 82
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 83
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 84
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 87
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip0:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip0:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip1:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 96
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip2:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip3:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip4:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip5:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    return-void

    .line 91
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip0:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
