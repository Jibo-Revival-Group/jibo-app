.class Lcom/jibo/ui/helpers/skills/ItemFactory$2;
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
.method constructor <init>(Lcom/jibo/ui/helpers/skills/ItemFactory;ILcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->val$dataItemIndx:I

    iput-object p3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 183
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->val$dataItemIndx:I

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->selectSkill(I)V

    .line 184
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iget v3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;->val$dataItemIndx:I

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$100(Lcom/jibo/ui/helpers/skills/ItemFactory;Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    .line 185
    return-void
.end method
