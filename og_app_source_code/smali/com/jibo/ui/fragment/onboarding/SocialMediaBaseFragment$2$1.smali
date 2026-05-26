.class Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;
.super Ljava/lang/Object;
.source "SocialMediaBaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;->a:Ljava/lang/Exception;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Ljava/lang/Exception;)V

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 73
    return-void
.end method
