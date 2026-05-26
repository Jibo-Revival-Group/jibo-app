.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$3;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/content/SharedPreferences;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/content/SharedPreferences;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$3;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$3;->a:Landroid/content/SharedPreferences;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2

    .prologue
    .line 175
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$3;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREF_ENCRYPTION_ENABLED"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 176
    return-void
.end method
