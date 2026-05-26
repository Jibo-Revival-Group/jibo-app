.class Lcom/jibo/ui/fragment/phone/PhoneEditFragment$2;
.super Ljava/lang/Object;
.source "PhoneEditFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneEditFragment;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->e:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b(Ljava/lang/Runnable;)V

    .line 97
    return-void
.end method
