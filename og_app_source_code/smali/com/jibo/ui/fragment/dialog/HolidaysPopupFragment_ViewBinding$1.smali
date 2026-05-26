.class Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "HolidaysPopupFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding;Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding$1;->c:Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->onBtnAddHolidaysClick()V

    .line 32
    return-void
.end method
