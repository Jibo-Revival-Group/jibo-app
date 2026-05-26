.class Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$2;
.super Ljava/lang/Object;
.source "CircleProgressFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
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
    .line 79
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$2;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$2;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/graphics/drawable/AnimationDrawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    .line 84
    return-void
.end method
