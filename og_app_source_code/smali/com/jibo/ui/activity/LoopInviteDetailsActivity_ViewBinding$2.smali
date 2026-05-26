.class Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "LoopInviteDetailsActivity_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

.field final synthetic c:Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$2;->c:Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$2;->b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$2;->b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->onDeclineClick(Landroid/view/View;)V

    .line 49
    return-void
.end method
