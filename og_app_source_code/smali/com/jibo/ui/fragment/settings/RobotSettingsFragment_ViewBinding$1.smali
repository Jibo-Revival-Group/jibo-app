.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "RobotSettingsFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$1;->c:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->showAbout(Landroid/view/View;)V

    .line 50
    return-void
.end method
