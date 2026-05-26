.class Lcom/jibo/JiboViewAddition$1;
.super Ljava/lang/Object;
.source "JiboViewAddition.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/JiboViewAddition;->a(Landroid/view/View;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/JiboViewAddition;


# direct methods
.method constructor <init>(Lcom/jibo/JiboViewAddition;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/jibo/JiboViewAddition$1;->a:Lcom/jibo/JiboViewAddition;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboSupport;->b(Landroid/content/Context;)V

    .line 34
    return-void
.end method
