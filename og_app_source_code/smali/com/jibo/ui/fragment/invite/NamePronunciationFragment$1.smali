.class Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$1;
.super Ljava/lang/Object;
.source "NamePronunciationFragment.java"

# interfaces
.implements Landroid/text/InputFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$1;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 149
    :goto_0
    if-ge p2, p3, :cond_1

    .line 150
    invoke-interface {p1, p2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Character;->isLetter(C)Z

    move-result v0

    if-nez v0, :cond_0

    .line 151
    const-string v0, ""

    .line 154
    :goto_1
    return-object v0

    .line 149
    :cond_0
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 154
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method
