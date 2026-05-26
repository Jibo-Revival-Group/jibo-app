.class Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "CursorPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/CursorPagerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyDataSetObserver"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/CursorPagerAdapter;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/helpers/CursorPagerAdapter;)V
    .locals 0

    .prologue
    .line 175
    iput-object p1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/helpers/CursorPagerAdapter;Lcom/jibo/ui/helpers/CursorPagerAdapter$1;)V
    .locals 0

    .prologue
    .line 175
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;-><init>(Lcom/jibo/ui/helpers/CursorPagerAdapter;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 2

    .prologue
    .line 179
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a(Lcom/jibo/ui/helpers/CursorPagerAdapter;Z)Z

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c()V

    .line 181
    return-void
.end method

.method public onInvalidated()V
    .locals 2

    .prologue
    .line 185
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a(Lcom/jibo/ui/helpers/CursorPagerAdapter;Z)Z

    .line 186
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c()V

    .line 187
    return-void
.end method
