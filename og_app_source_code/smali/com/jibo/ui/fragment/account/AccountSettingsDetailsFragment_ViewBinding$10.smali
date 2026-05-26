.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$10;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment_ViewBinding.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

.field final synthetic b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V
    .locals 0

    .prologue
    .line 133
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$10;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$10;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$10;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->onDevSettings(Landroid/view/View;)Z

    move-result v0

    return v0
.end method
