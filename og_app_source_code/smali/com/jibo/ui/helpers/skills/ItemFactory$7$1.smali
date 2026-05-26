.class Lcom/jibo/ui/helpers/skills/ItemFactory$7$1;
.super Ljava/lang/Object;
.source "ItemFactory.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/ItemFactory$7;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/jibo/ui/helpers/skills/ItemFactory$7;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/ItemFactory$7;)V
    .locals 0

    .prologue
    .line 240
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7$1;->this$1:Lcom/jibo/ui/helpers/skills/ItemFactory$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 243
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7$1;->this$1:Lcom/jibo/ui/helpers/skills/ItemFactory$7;

    iget-object v0, v0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$400(Lcom/jibo/ui/helpers/skills/ItemFactory;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$7$1;->this$1:Lcom/jibo/ui/helpers/skills/ItemFactory$7;

    iget-object v1, v1, Lcom/jibo/ui/helpers/skills/ItemFactory$7;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-interface {v0, v1, v2, v2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 244
    return-void
.end method
