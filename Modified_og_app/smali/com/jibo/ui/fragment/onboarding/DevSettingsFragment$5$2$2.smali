.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a(Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;)V
    .locals 0

    .prologue
    .line 316
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;->a:Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 319
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->responseText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;->a:Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 320
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f01000c

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 321
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->responseText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 322
    return-void
.end method
