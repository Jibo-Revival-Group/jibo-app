.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$1;
.super Ljava/lang/Object;
.source "ResetPasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)Landroid/view/MenuItem;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 151
    return-void
.end method
