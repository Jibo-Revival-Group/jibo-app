.class public abstract Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;
.super Lcom/jibo/ui/helpers/CursorPagerAdapter;
.source "FragmentStateCursorPagerAdapter.java"


# instance fields
.field private final a:Landroid/support/v4/app/FragmentManager;

.field private b:Landroid/support/v4/app/FragmentTransaction;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v4/app/Fragment$SavedState;",
            ">;"
        }
    .end annotation
.end field

.field private d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v4/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field private e:Landroid/support/v4/app/Fragment;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/FragmentManager;Landroid/database/Cursor;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    invoke-direct {p0, p2}, Lcom/jibo/ui/helpers/CursorPagerAdapter;-><init>(Landroid/database/Cursor;)V

    .line 23
    iput-object v1, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    .line 26
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    .line 27
    iput-object v1, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->e:Landroid/support/v4/app/Fragment;

    .line 31
    iput-object p1, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    .line 32
    return-void
.end method


# virtual methods
.method public a()Landroid/os/Parcelable;
    .locals 5

    .prologue
    .line 138
    const/4 v0, 0x0

    .line 139
    iget-object v1, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 140
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 141
    iget-object v1, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v1, v1, [Landroid/support/v4/app/Fragment$SavedState;

    .line 142
    iget-object v2, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 143
    const-string v2, "states"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V

    .line 145
    :cond_0
    const/4 v1, 0x0

    move-object v2, v0

    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 147
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 148
    if-nez v2, :cond_1

    .line 149
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 151
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "f"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 152
    iget-object v4, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v4, v2, v3, v0}, Landroid/support/v4/app/FragmentManager;->a(Landroid/os/Bundle;Ljava/lang/String;Landroid/support/v4/app/Fragment;)V

    .line 145
    :cond_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 155
    :cond_3
    return-object v2
.end method

.method public abstract a(I)Landroid/support/v4/app/Fragment;
.end method

.method public a(Landroid/view/ViewGroup;Landroid/database/Cursor;I)Ljava/lang/Object;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, p3, :cond_0

    .line 55
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 56
    if-eqz v0, :cond_0

    .line 57
    invoke-virtual {p0, v0, p2, p3}, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a(Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    .line 84
    :goto_0
    return-object v0

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    if-nez v0, :cond_1

    .line 63
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    .line 66
    :cond_1
    invoke-virtual {p0, p3}, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 67
    invoke-virtual {p0, v1, p2, p3}, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a(Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, p3, :cond_2

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment$SavedState;

    .line 72
    if-eqz v0, :cond_2

    .line 73
    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setInitialSavedState(Landroid/support/v4/app/Fragment$SavedState;)V

    .line 76
    :cond_2
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gt v0, p3, :cond_3

    .line 77
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 79
    :cond_3
    invoke-virtual {v1, v3}, Landroid/support/v4/app/Fragment;->setMenuVisibility(Z)V

    .line 80
    invoke-virtual {v1, v3}, Landroid/support/v4/app/Fragment;->setUserVisibleHint(Z)V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0, p3, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 82
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getId()I

    move-result v2

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/app/FragmentTransaction;->a(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-object v0, v1

    .line 84
    goto :goto_0
.end method

.method public a(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 160
    if-eqz p1, :cond_4

    .line 161
    check-cast p1, Landroid/os/Bundle;

    .line 162
    invoke-virtual {p1, p2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 163
    const-string v0, "states"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v3

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 166
    if-eqz v3, :cond_0

    move v1, v2

    .line 167
    :goto_0
    array-length v0, v3

    if-ge v1, v0, :cond_0

    .line 168
    iget-object v4, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    aget-object v0, v3, v1

    check-cast v0, Landroid/support/v4/app/Fragment$SavedState;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 167
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 171
    :cond_0
    invoke-virtual {p1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 172
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 173
    const-string v3, "f"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 174
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 175
    iget-object v4, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v4, p1, v0}, Landroid/support/v4/app/FragmentManager;->a(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    .line 176
    if-eqz v4, :cond_3

    .line 177
    :goto_2
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gt v0, v3, :cond_2

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 180
    :cond_2
    invoke-virtual {v4, v2}, Landroid/support/v4/app/Fragment;->setMenuVisibility(Z)V

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0, v3, v4}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 183
    :cond_3
    const-string v3, "FragmentStatePagerAdapter"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Bad fragment at key "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 188
    :cond_4
    return-void
.end method

.method public abstract a(Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
.end method

.method public a(Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 46
    return-void
.end method

.method public a(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 89
    check-cast p3, Landroid/support/v4/app/Fragment;

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    if-nez v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    .line 96
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gt v0, p2, :cond_1

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 99
    :cond_1
    iget-object v2, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->c:Ljava/util/ArrayList;

    invoke-virtual {p3}, Landroid/support/v4/app/Fragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    .line 100
    invoke-virtual {v0, p3}, Landroid/support/v4/app/FragmentManager;->a(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment$SavedState;

    move-result-object v0

    .line 99
    :goto_1
    invoke-virtual {v2, p2, v0}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->d:Ljava/util/ArrayList;

    invoke-virtual {v0, p2, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {v0, p3}, Landroid/support/v4/app/FragmentTransaction;->a(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 104
    return-void

    :cond_2
    move-object v0, v1

    .line 100
    goto :goto_1
.end method

.method public a(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 133
    check-cast p2, Landroid/support/v4/app/Fragment;

    invoke-virtual {p2}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Landroid/view/ViewGroup;)V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->e()I

    .line 126
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->b:Landroid/support/v4/app/FragmentTransaction;

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->a:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->b()Z

    .line 129
    :cond_0
    return-void
.end method

.method public b(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 108
    check-cast p3, Landroid/support/v4/app/Fragment;

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->e:Landroid/support/v4/app/Fragment;

    if-eq p3, v0, :cond_2

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->e:Landroid/support/v4/app/Fragment;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->e:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/Fragment;->setMenuVisibility(Z)V

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->e:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/Fragment;->setUserVisibleHint(Z)V

    .line 114
    :cond_0
    if-eqz p3, :cond_1

    .line 115
    invoke-virtual {p3, v2}, Landroid/support/v4/app/Fragment;->setMenuVisibility(Z)V

    .line 116
    invoke-virtual {p3, v2}, Landroid/support/v4/app/Fragment;->setUserVisibleHint(Z)V

    .line 118
    :cond_1
    iput-object p3, p0, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;->e:Landroid/support/v4/app/Fragment;

    .line 120
    :cond_2
    return-void
.end method
