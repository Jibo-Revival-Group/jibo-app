.class Lcom/jibo/ui/helpers/skills/ItemFactory$5;
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


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 211
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$5;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$5;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 214
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$5;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$300(Lcom/jibo/ui/helpers/skills/ItemFactory;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 216
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;

    .line 218
    new-instance v1, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;

    invoke-direct {v1}, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;-><init>()V

    .line 219
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getId()I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;->setValue(I)V

    .line 220
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$5;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$300(Lcom/jibo/ui/helpers/skills/ItemFactory;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$5;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    const/4 v3, 0x0

    invoke-interface {v0, v2, v1, v3}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 222
    :cond_0
    return-void
.end method
