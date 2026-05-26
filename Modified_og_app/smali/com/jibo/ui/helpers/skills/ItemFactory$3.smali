.class Lcom/jibo/ui/helpers/skills/ItemFactory$3;
.super Ljava/lang/Object;
.source "ItemFactory.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/ItemFactory;->getOnClickLister(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/view/View$OnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

.field final synthetic val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

.field final synthetic val$dataItemIndx:I


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V
    .locals 0

    .prologue
    .line 189
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iput p3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->val$dataItemIndx:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 192
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;

    .line 193
    instance-of v1, p1, Landroid/widget/CompoundButton;

    if-nez v1, :cond_0

    .line 195
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->hasChildren()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 196
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iget v3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->val$dataItemIndx:I

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$100(Lcom/jibo/ui/helpers/skills/ItemFactory;Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    .line 201
    :cond_0
    :goto_0
    return-void

    .line 198
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-static {v0, v1}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$200(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_0
.end method
