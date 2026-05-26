.class public abstract Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "PhoneBaseFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field protected b:Landroid/view/MenuItem;

.field protected c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

.field protected d:Z

.field protected e:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 49
    new-instance v0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$1;-><init>(Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->e:Ljava/lang/Runnable;

    .line 60
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 41
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method protected a(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 102
    const-string v0, " |\\-|\\(|\\)"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected abstract a()V
.end method

.method protected abstract b()Ljava/lang/String;
.end method

.method protected b(Ljava/lang/Runnable;)V
    .locals 3

    .prologue
    .line 79
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->f()V

    .line 80
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->e()V

    .line 82
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "+1"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;

    invoke-direct {v2, p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment$2;-><init>(Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->sendPhoneVerificationCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 95
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 64
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 66
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->setHasOptionsMenu(Z)V

    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    instance-of v1, v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    if-nez v1, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->d:Z

    .line 69
    return-void

    .line 68
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a()V

    .line 76
    return-void
.end method
