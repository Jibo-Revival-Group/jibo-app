.class Lcom/jibo/ui/helpers/skills/ItemFactory$1;
.super Ljava/lang/Object;
.source "ItemFactory.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/ItemFactory;->getOnCheckChangeListener(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/widget/CompoundButton$OnCheckedChangeListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

.field final synthetic val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 147
    invoke-virtual {p1}, Landroid/widget/CompoundButton;->getTag()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;

    if-eqz v0, :cond_3

    .line 148
    invoke-virtual {p1}, Landroid/widget/CompoundButton;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;

    iget-object v0, v0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    if-ne v0, v1, :cond_3

    move v1, v2

    .line 155
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 156
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->getValue()Z

    move-result v0

    if-eq v0, p2, :cond_1

    :cond_0
    move v3, v2

    .line 159
    :cond_1
    if-eqz v1, :cond_2

    if-eqz v3, :cond_2

    .line 160
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-static {v0, v1, p2}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$000(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Z)V

    .line 163
    :cond_2
    return-void

    :cond_3
    move v1, v3

    .line 148
    goto :goto_0
.end method
