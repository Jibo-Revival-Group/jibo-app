.class public Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;
.super Ljava/lang/Object;
.source "SignupCompleteFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f09007c

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    .line 28
    const-string v0, "field \'btnOpenEmailApp\' and method \'onOpenEmailAppClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 29
    const-string v0, "field \'btnOpenEmailApp\'"

    const-class v2, Landroid/widget/Button;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->btnOpenEmailApp:Landroid/widget/Button;

    .line 30
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->c:Landroid/view/View;

    .line 31
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    const v0, 0x7f0902e5

    const-string v1, "field \'text_instructions\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->text_instructions:Landroid/widget/TextView;

    .line 38
    const v0, 0x7f090087

    const-string v1, "method \'onResendVerificationEmailClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 39
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->d:Landroid/view/View;

    .line 40
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    .line 52
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    .line 55
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->btnOpenEmailApp:Landroid/widget/Button;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->text_instructions:Landroid/widget/TextView;

    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->c:Landroid/view/View;

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment_ViewBinding;->d:Landroid/view/View;

    .line 62
    return-void
.end method
