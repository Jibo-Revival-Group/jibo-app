.class Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;
.super Ljava/lang/Object;
.source "BaseDialogFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;->a(Ljava/lang/Exception;Ljava/lang/String;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Z

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;Ljava/lang/Exception;Z)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->c:Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->a:Ljava/lang/Exception;

    iput-boolean p3, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->b:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 36
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->c:Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->a:Ljava/lang/Exception;

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/ErrorHelper;->a(Landroid/support/v7/app/AppCompatActivity;Landroid/support/v4/app/Fragment;Ljava/lang/Throwable;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 38
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->b:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->c:Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;->b:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->c:Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;->b:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment$1;->a:Ljava/lang/Exception;

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/Throwable;)V

    .line 40
    :cond_0
    return-void
.end method
