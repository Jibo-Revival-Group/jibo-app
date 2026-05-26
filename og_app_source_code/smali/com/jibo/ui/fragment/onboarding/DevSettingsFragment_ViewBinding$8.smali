.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$8;
.super Ljava/lang/Object;
.source "DevSettingsFragment_ViewBinding.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$8;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$8;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$8;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->showDevSettings(Landroid/view/View;)Z

    move-result v0

    return v0
.end method
