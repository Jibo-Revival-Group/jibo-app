.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$3;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "NameBirthdayGenderFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$3;->c:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->onBtnNextClick(Landroid/view/View;)V

    .line 71
    return-void
.end method
