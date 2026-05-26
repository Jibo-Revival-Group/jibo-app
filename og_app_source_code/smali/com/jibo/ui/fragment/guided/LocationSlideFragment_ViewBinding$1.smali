.class Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "LocationSlideFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/guided/LocationSlideFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;Lcom/jibo/ui/fragment/guided/LocationSlideFragment;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding$1;->c:Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->btnSetLocationClick(Landroid/view/View;)V

    .line 34
    return-void
.end method
