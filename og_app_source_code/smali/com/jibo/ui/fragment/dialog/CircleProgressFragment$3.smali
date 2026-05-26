.class Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;
.super Ljava/lang/Object;
.source "CircleProgressFragment.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 115
    invoke-virtual {p1, p0}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne v0, v1, :cond_1

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/text/SpannableStringBuilder;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Landroid/text/SpannableStringBuilder;)V

    .line 121
    :cond_0
    :goto_0
    return-void

    .line 118
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Failure:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne v0, v1, :cond_0

    .line 119
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/text/SpannableStringBuilder;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    goto :goto_0
.end method
