.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "ResetPasswordSentFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$2;->c:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->onOpenEmailAppClick(Landroid/view/View;)V

    .line 43
    return-void
.end method
