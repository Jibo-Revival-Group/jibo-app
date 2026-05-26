.class Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$2;
.super Ljava/lang/Object;
.source "AboutYouFragment.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
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
    .line 94
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 2

    .prologue
    .line 97
    if-eqz p2, :cond_0

    move-object v0, p1

    .line 98
    check-cast v0, Landroid/widget/EditText;

    check-cast p1, Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setSelection(I)V

    .line 100
    :cond_0
    return-void
.end method
