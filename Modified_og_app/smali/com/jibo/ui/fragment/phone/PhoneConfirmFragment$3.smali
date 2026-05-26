.class Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;
.super Ljava/lang/Object;
.source "PhoneConfirmFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->g()V

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->c(Landroid/content/Context;)V

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$2;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a(Ljava/lang/Runnable;)V

    .line 193
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a(Ljava/lang/Runnable;)V

    .line 161
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 139
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a(Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
