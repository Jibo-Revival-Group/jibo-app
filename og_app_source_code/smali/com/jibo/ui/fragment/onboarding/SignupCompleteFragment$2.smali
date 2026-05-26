.class Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$2;
.super Ljava/lang/Object;
.source "SignupCompleteFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 1

    .prologue
    .line 138
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne p1, v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V

    .line 141
    :cond_0
    return-void
.end method
