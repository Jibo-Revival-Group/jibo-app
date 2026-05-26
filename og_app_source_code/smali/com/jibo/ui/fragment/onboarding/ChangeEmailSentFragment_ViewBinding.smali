.class public Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;
.super Ljava/lang/Object;
.source "ChangeEmailSentFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    .line 25
    const v0, 0x7f0902e5

    const-string v1, "field \'text_instructions\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->text_instructions:Landroid/widget/TextView;

    .line 26
    const v0, 0x7f090076

    const-string v1, "method \'logout\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 27
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;->c:Landroid/view/View;

    .line 28
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 34
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    .line 40
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    .line 43
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->text_instructions:Landroid/widget/TextView;

    .line 45
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment_ViewBinding;->c:Landroid/view/View;

    .line 47
    return-void
.end method
