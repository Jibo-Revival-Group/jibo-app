.class Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "NoLoopsFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$2;->c:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;->onInviteInfo(Landroid/view/View;)V

    .line 41
    return-void
.end method
