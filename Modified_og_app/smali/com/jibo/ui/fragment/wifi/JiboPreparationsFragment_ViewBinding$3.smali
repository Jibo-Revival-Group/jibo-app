.class Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$3;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "JiboPreparationsFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$3;->c:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->btnNextScreenClick(Landroid/view/View;)V

    .line 58
    return-void
.end method
