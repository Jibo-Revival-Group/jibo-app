.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$7;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "DevSettingsFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$7;->c:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$7;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$7;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->onBtnSuspendLoopClick(Landroid/view/View;)V

    .line 111
    return-void
.end method
