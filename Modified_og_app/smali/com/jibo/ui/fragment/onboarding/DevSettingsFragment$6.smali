.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Lcom/jibo/aws/integration/util/Commons$AsyncCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->onBtnSuspendLoopClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/jibo/aws/integration/util/Commons$AsyncCallback",
        "<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
    .locals 0

    .prologue
    .line 367
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 371
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6$1;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 378
    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 3

    .prologue
    .line 382
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Loop has been suspended"

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 383
    return-void
.end method
