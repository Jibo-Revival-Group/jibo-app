.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;
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
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
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
    .line 208
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 210
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    .line 211
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    .line 210
    invoke-static {v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 213
    :try_start_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcKeyText:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Lcom/jibo/aws/integration/util/KeyManager;->getSymmetricalKey(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 222
    :goto_0
    return-void

    .line 214
    :catch_0
    move-exception v0

    .line 216
    sget-object v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 217
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 220
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcKeyText:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
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
    .line 227
    return-void
.end method
