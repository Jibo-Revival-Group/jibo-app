.class public Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;
.super Ljava/lang/Object;
.source "SignupLoginFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;Landroid/view/View;)V
    .locals 5

    .prologue
    const v4, 0x7f090092

    const v3, 0x7f090075

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

    .line 31
    const-string v0, "field \'btnLogin\' and method \'openLoginScreen\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 32
    const-string v0, "field \'btnLogin\'"

    const-class v2, Landroid/widget/Button;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->btnLogin:Landroid/widget/Button;

    .line 33
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->c:Landroid/view/View;

    .line 34
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    const-string v0, "field \'btnSignUp\' and method \'openSignupScreen\'"

    invoke-static {p2, v4, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 41
    const-string v0, "field \'btnSignUp\'"

    const-class v2, Landroid/widget/Button;

    invoke-static {v1, v4, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->btnSignUp:Landroid/widget/Button;

    .line 42
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->d:Landroid/view/View;

    .line 43
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$2;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    const v0, 0x7f090072

    const-string v1, "field \'btnLearnMore\' and method \'openLearnMoreLink\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 50
    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->btnLearnMore:Landroid/view/View;

    .line 51
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->e:Landroid/view/View;

    .line 52
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    const v0, 0x7f090060

    const-string v1, "method \'onDevSettings\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 59
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->f:Landroid/view/View;

    .line 60
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 66
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

    .line 72
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

    .line 75
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->btnLogin:Landroid/widget/Button;

    .line 76
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->btnSignUp:Landroid/widget/Button;

    .line 77
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->btnLearnMore:Landroid/view/View;

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->c:Landroid/view/View;

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 82
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->d:Landroid/view/View;

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 84
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->e:Landroid/view/View;

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 86
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;->f:Landroid/view/View;

    .line 87
    return-void
.end method
