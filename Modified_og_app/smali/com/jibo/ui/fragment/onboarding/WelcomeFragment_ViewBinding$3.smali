.class Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$3;
.super Ljava/lang/Object;
.source "WelcomeFragment_ViewBinding.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$3;->a:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment_ViewBinding$3;->a:Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->onDevSettings(Landroid/view/View;)Z

    move-result v0

    return v0
.end method
