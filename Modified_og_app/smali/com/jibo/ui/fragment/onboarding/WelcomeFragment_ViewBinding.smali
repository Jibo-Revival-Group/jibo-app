.class public Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;
.super Ljava/lang/Object;
.source "WelcomeFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;Landroid/view/View;)V
    .locals 5

    .prologue
    const v4, 0x7f090092

    const v3, 0x7f090075

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    .line 30
    const-string v0, "field \'btnLogin\' and method \'openLoginScreen\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 31
    const-string v0, "field \'btnLogin\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->btnLogin:Landroid/widget/TextView;

    .line 32
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->c:Landroid/view/View;

    .line 33
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 39
    const-string v0, "field \'btnSignUp\' and method \'openSignupScreen\'"

    invoke-static {p2, v4, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 40
    const-string v0, "field \'btnSignUp\'"

    const-class v2, Landroid/widget/Button;

    invoke-static {v1, v4, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->btnSignUp:Landroid/widget/Button;

    .line 41
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->d:Landroid/view/View;

    .line 42
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$2;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    const v0, 0x7f090060

    const-string v1, "method \'onDevSettings\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 49
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->e:Landroid/view/View;

    .line 50
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 56
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 61
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    .line 62
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    .line 65
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->btnLogin:Landroid/widget/TextView;

    .line 66
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->btnSignUp:Landroid/widget/Button;

    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->c:Landroid/view/View;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->d:Landroid/view/View;

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 73
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;->e:Landroid/view/View;

    .line 74
    return-void
.end method
