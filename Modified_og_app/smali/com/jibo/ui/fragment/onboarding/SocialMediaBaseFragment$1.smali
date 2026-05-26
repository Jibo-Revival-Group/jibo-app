.class Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$1;
.super Ljava/lang/Object;
.source "SocialMediaBaseFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 59
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 49
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b()V

    .line 54
    return-void
.end method
