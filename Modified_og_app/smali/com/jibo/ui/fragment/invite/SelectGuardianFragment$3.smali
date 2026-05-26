.class Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;
.super Ljava/lang/Object;
.source "SelectGuardianFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->i(Landroid/content/Context;)V

    .line 206
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "https://www.consumer.ftc.gov/articles/0031-protecting-your-childs-privacy-online"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 207
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 208
    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 209
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    .line 213
    :goto_0
    return-void

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const v2, 0x7f100222

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0
.end method
