.class Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;
.super Ljava/lang/Object;
.source "JiboPreparationsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;I)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    iput p2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->c:[I

    iget v2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;->a:I

    add-int/lit8 v2, v2, 0x1

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 187
    return-void
.end method
