.class public final Lcom/google/android/gms/internal/zzewx;
.super Lcom/google/android/gms/internal/zzfjm;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/zzfjm",
        "<",
        "Lcom/google/android/gms/internal/zzewx;",
        ">;"
    }
.end annotation


# instance fields
.field public a:Lcom/google/android/gms/internal/zzews;

.field public b:Lcom/google/android/gms/internal/zzewy;

.field public c:Lcom/google/android/gms/internal/zzewv;


# direct methods
.method public constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzfjm;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/internal/zzewx;->I:I

    return-void
.end method


# virtual methods
.method public final synthetic a(Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :cond_0
    :goto_0
    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzfjj;->a()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    invoke-super {p0, p1, v0}, Lcom/google/android/gms/internal/zzfjm;->a(Lcom/google/android/gms/internal/zzfjj;I)Z

    move-result v0

    if-nez v0, :cond_0

    :sswitch_0
    return-object p0

    :sswitch_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    if-nez v0, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/zzews;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzews;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzfjj;->a(Lcom/google/android/gms/internal/zzfjs;)V

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-nez v0, :cond_2

    new-instance v0, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzfjj;->a(Lcom/google/android/gms/internal/zzfjs;)V

    goto :goto_0

    :sswitch_3
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-nez v0, :cond_3

    new-instance v0, Lcom/google/android/gms/internal/zzewv;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewv;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzfjj;->a(Lcom/google/android/gms/internal/zzfjs;)V

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xa -> :sswitch_1
        0x12 -> :sswitch_2
        0x1a -> :sswitch_3
    .end sparse-switch
.end method

.method public final a(Lcom/google/android/gms/internal/zzfjk;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/zzfjk;->a(ILcom/google/android/gms/internal/zzfjs;)V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/zzfjk;->a(ILcom/google/android/gms/internal/zzfjs;)V

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-eqz v0, :cond_2

    const/4 v0, 0x3

    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/zzfjk;->a(ILcom/google/android/gms/internal/zzfjs;)V

    :cond_2
    invoke-super {p0, p1}, Lcom/google/android/gms/internal/zzfjm;->a(Lcom/google/android/gms/internal/zzfjk;)V

    return-void
.end method

.method protected final b()I
    .locals 3

    invoke-super {p0}, Lcom/google/android/gms/internal/zzfjm;->b()I

    move-result v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/zzfjk;->b(ILcom/google/android/gms/internal/zzfjs;)I

    move-result v1

    add-int/2addr v0, v1

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v1, :cond_1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/zzfjk;->b(ILcom/google/android/gms/internal/zzfjs;)I

    move-result v1

    add-int/2addr v0, v1

    :cond_1
    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-eqz v1, :cond_2

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/zzfjk;->b(ILcom/google/android/gms/internal/zzfjs;)I

    move-result v1

    add-int/2addr v0, v1

    :cond_2
    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p1, p0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v2, p1, Lcom/google/android/gms/internal/zzewx;

    if-nez v2, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/google/android/gms/internal/zzewx;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    if-nez v2, :cond_3

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    if-eqz v2, :cond_4

    move v0, v1

    goto :goto_0

    :cond_3
    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v3, p1, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzews;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    move v0, v1

    goto :goto_0

    :cond_4
    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-nez v2, :cond_5

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v2, :cond_6

    move v0, v1

    goto :goto_0

    :cond_5
    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iget-object v3, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzewy;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    move v0, v1

    goto :goto_0

    :cond_6
    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-nez v2, :cond_7

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-eqz v2, :cond_8

    move v0, v1

    goto :goto_0

    :cond_7
    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    iget-object v3, p1, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzewv;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_8

    move v0, v1

    goto :goto_0

    :cond_8
    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzfjo;->b()Z

    move-result v2

    if-eqz v2, :cond_a

    :cond_9
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    if-eqz v2, :cond_0

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzfjo;->b()Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    goto :goto_0

    :cond_a
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    iget-object v1, p1, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzfjo;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public final hashCode()I
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    add-int/lit16 v0, v0, 0x20f

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    mul-int/lit8 v3, v0, 0x1f

    if-nez v2, :cond_1

    move v0, v1

    :goto_0
    add-int/2addr v0, v3

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    mul-int/lit8 v3, v0, 0x1f

    if-nez v2, :cond_2

    move v0, v1

    :goto_1
    add-int/2addr v0, v3

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    mul-int/lit8 v3, v0, 0x1f

    if-nez v2, :cond_3

    move v0, v1

    :goto_2
    add-int/2addr v0, v3

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzfjo;->b()Z

    move-result v2

    if-eqz v2, :cond_4

    :cond_0
    :goto_3
    add-int/2addr v0, v1

    return v0

    :cond_1
    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzews;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_2
    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewy;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_3
    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewv;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_4
    iget-object v1, p0, Lcom/google/android/gms/internal/zzewx;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzfjo;->hashCode()I

    move-result v1

    goto :goto_3
.end method
