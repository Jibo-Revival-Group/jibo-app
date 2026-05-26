.class Lcom/jibo/ui/fragment/onboarding/SignupFragment$2;
.super Landroid/text/style/ClickableSpan;
.source "SignupFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SignupFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/SignupFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SignupFragment;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SignupFragment;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SignupFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b(Lcom/jibo/ui/fragment/onboarding/SignupFragment;)V

    .line 105
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 108
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 109
    return-void
.end method
