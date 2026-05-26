.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


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
    .line 136
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;->a:Landroid/content/SharedPreferences;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 139
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)I

    move-result v0

    if-eq v0, p3, :cond_0

    .line 140
    sget-object v0, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    aget-object v0, v0, p3

    invoke-static {v0}, Lcom/jibo/aws/integration/util/Commons;->setRootEndpoint(Ljava/lang/String;)V

    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREF_END_POINT"

    sget-object v2, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    aget-object v2, v2, p3

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 142
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 144
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-static {v0, p3}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;I)I

    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->logout(Landroid/view/View;)V

    .line 147
    :cond_0
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 152
    return-void
.end method
