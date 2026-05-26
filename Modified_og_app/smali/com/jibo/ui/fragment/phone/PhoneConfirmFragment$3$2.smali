.class Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;
.super Ljava/lang/Object;
.source "PhoneConfirmFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a(Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iput-object p2, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v1, v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setAccessKeyId(Ljava/lang/String;)V

    .line 175
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v1, v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setSecretAccessKey(Ljava/lang/String;)V

    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-boolean v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->d:Z

    if-eqz v0, :cond_1

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 183
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 185
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 190
    :goto_0
    return-void

    .line 188
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->s()V

    goto :goto_0
.end method
