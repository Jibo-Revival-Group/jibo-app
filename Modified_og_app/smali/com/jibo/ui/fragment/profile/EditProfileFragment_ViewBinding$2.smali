.class Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "EditProfileFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$2;->c:Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->birthdayClick()V

    .line 60
    return-void
.end method
