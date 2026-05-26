.class Lcom/jibo/ui/helpers/skills/ItemFactory$7;
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
    .line 232
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iput p3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItemIndx:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 235
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 236
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 239
    const v1, 0x7f1000ed

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(I)Landroid/support/v7/app/AlertDialog$Builder;

    .line 240
    const v1, 0x7f100231

    new-instance v2, Lcom/jibo/ui/helpers/skills/ItemFactory$7$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/helpers/skills/ItemFactory$7$1;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory$7;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 246
    const/high16 v1, 0x1040000

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 247
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 254
    :goto_0
    return-void

    .line 249
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iget v3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItemIndx:I

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$100(Lcom/jibo/ui/helpers/skills/ItemFactory;Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    goto :goto_0

    .line 252
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iget v3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItemIndx:I

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$100(Lcom/jibo/ui/helpers/skills/ItemFactory;Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    goto :goto_0
.end method
