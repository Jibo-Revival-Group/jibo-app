.class Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$2;
.super Ljava/lang/Object;
.source "FingerprintAuthDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$2;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$2;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->dismiss()V

    .line 142
    return-void
.end method
