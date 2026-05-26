.class Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$1;
.super Ljava/lang/Object;
.source "CircleProgressFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
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
    .line 57
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->dismiss()V

    .line 62
    return-void
.end method
