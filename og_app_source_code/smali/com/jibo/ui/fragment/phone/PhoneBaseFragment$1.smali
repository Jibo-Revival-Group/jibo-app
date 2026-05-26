.class Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;
.super Ljava/lang/Object;
.source "PhoneBaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 52
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 53
    const-string v0, "PARAM_PHONENUMBER"

    iget-object v2, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 55
    return-void
.end method
