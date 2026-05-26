.class Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$4;
.super Ljava/lang/Object;
.source "SignupLoginFragment_ViewBinding.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$4;->b:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$4;->a:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment_ViewBinding$4;->a:Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->onDevSettings(Landroid/view/View;)Z

    move-result v0

    return v0
.end method
