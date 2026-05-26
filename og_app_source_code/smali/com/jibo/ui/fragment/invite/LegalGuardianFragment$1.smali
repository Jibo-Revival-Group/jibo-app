.class Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;
.super Ljava/lang/Object;
.source "LegalGuardianFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 3

    .prologue
    .line 115
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne p1, v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->k(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 120
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/invite/CongratsFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 121
    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 122
    const-string v1, "ARG_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 123
    const/16 v1, 0x3f9

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 125
    :cond_1
    return-void
.end method
