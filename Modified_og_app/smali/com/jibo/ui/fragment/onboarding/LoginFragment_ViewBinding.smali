.class public Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment_ViewBinding;
.source "LoginFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/LoginFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/LoginFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;Landroid/view/View;)V

    .line 22
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/LoginFragment;

    .line 25
    const v0, 0x7f090323

    const-string v1, "field \'validationMessagePassword\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->validationMessagePassword:Landroid/widget/TextView;

    .line 26
    const v0, 0x7f090067

    const-string v1, "method \'onForgotPasswordClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 27
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;->c:Landroid/view/View;

    .line 28
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/LoginFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 34
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 38
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/LoginFragment;

    .line 39
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 40
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/LoginFragment;

    .line 42
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->validationMessagePassword:Landroid/widget/TextView;

    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment_ViewBinding;->c:Landroid/view/View;

    .line 47
    invoke-super {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment_ViewBinding;->unbind()V

    .line 48
    return-void
.end method
