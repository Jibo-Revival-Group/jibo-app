.class Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding$5;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "NetworkSelectionFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding$5;->c:Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding$5;->b:Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment_ViewBinding$5;->b:Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;->onShowMacFilteringInfo(Landroid/view/View;)V

    .line 76
    return-void
.end method
