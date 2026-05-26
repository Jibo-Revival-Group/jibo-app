.class Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;
.super Ljava/lang/Object;
.source "PhoneBaseFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->b(Ljava/lang/Runnable;)V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Runnable;

.field final synthetic b:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->b:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->a:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V
    .locals 2

    .prologue
    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->b:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->g()V

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->b:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->a:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Ljava/lang/Runnable;)V

    .line 93
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->b:Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    const-string v1, "send phone verification code"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 87
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 83
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V

    return-void
.end method
