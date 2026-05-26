.class Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "WelcomeFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$2;->c:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->openSignupScreen(Landroid/view/View;)V

    .line 46
    return-void
.end method
