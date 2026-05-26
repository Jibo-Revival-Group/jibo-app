.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 306
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 309
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;->a:Ljava/lang/Exception;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 310
    return-void
.end method
