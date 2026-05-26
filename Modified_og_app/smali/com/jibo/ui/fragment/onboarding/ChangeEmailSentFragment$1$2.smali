.class Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$2;
.super Ljava/lang/Object;
.source "ChangeEmailSentFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$2;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$2;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->g()V

    .line 141
    return-void
.end method
