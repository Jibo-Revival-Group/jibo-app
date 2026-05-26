.class public Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;
.super Ljava/lang/Object;
.source "PhotoViewerActivity$PhotoFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    .line 26
    const v0, 0x7f090154

    const-string v1, "field \'image\'"

    const-class v2, Lcom/jibo/ui/view/TouchImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/TouchImageView;

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    .line 27
    const v0, 0x102000d

    const-string v1, "field \'progress\' and method \'onContentClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 28
    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    .line 29
    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;->c:Landroid/view/View;

    .line 30
    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 36
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 41
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    .line 42
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    .line 45
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    .line 48
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    iput-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment_ViewBinding;->c:Landroid/view/View;

    .line 50
    return-void
.end method
