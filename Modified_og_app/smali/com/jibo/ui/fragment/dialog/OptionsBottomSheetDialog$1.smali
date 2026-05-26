.class Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;
.super Ljava/lang/Object;
.source "OptionsBottomSheetDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->b(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;I)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;->b:Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;

    iput p2, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 73
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;->b:Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;->b:Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;

    iget v2, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;->a:I

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a(Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;Landroid/content/DialogInterface;I)V

    .line 74
    return-void
.end method
