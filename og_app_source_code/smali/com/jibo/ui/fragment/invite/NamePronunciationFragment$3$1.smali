.class Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;
.super Ljava/lang/Object;
.source "NamePronunciationFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 215
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    const v2, 0x7f10025e

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 216
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 217
    return-void
.end method
