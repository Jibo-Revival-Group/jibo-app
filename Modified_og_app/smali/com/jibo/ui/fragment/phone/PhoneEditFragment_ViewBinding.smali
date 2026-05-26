.class public Lcom/jibo/ui/fragment/phone/PhoneEditFragment_ViewBinding;
.super Ljava/lang/Object;
.source "PhoneEditFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneEditFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    .line 21
    const v0, 0x7f09020a

    const-string v1, "field \'phone\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->phone:Landroid/widget/EditText;

    .line 22
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    .line 28
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    .line 31
    iput-object v1, v0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->phone:Landroid/widget/EditText;

    .line 32
    return-void
.end method
