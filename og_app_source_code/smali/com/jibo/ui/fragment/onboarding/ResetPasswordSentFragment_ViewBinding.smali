.class public Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;
.super Ljava/lang/Object;
.source "ResetPasswordSentFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    .line 28
    const v0, 0x7f0902e5

    const-string v1, "field \'text_instructions\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->text_instructions:Landroid/widget/TextView;

    .line 29
    const v0, 0x7f090086

    const-string v1, "method \'onResendPasswordResetEmailClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 30
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->c:Landroid/view/View;

    .line 31
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    const v0, 0x7f09007c

    const-string v1, "method \'onOpenEmailAppClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 38
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->d:Landroid/view/View;

    .line 39
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    .line 51
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    .line 54
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->text_instructions:Landroid/widget/TextView;

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->c:Landroid/view/View;

    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;->d:Landroid/view/View;

    .line 60
    return-void
.end method
