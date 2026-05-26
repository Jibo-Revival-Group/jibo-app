.class Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$1;
.super Ljava/lang/Object;
.source "AboutYouFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 76
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 66
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 71
    return-void
.end method
