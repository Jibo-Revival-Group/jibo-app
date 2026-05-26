.class Lorg/joda/time/chrono/GJChronology$CutoverField;
.super Lorg/joda/time/field/BaseDateTimeField;
.source "GJChronology.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/joda/time/chrono/GJChronology;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CutoverField"
.end annotation


# instance fields
.field final a:Lorg/joda/time/DateTimeField;

.field final b:Lorg/joda/time/DateTimeField;

.field final c:J

.field final d:Z

.field protected e:Lorg/joda/time/DurationField;

.field protected f:Lorg/joda/time/DurationField;

.field final synthetic g:Lorg/joda/time/chrono/GJChronology;


# direct methods
.method constructor <init>(Lorg/joda/time/chrono/GJChronology;Lorg/joda/time/DateTimeField;Lorg/joda/time/DateTimeField;J)V
    .locals 8

    .prologue
    .line 615
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-wide v4, p4

    invoke-direct/range {v0 .. v6}, Lorg/joda/time/chrono/GJChronology$CutoverField;-><init>(Lorg/joda/time/chrono/GJChronology;Lorg/joda/time/DateTimeField;Lorg/joda/time/DateTimeField;JZ)V

    .line 616
    return-void
.end method

.method constructor <init>(Lorg/joda/time/chrono/GJChronology;Lorg/joda/time/DateTimeField;Lorg/joda/time/DateTimeField;JZ)V
    .locals 10

    .prologue
    .line 626
    const/4 v5, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-wide v6, p4

    move/from16 v8, p6

    invoke-direct/range {v1 .. v8}, Lorg/joda/time/chrono/GJChronology$CutoverField;-><init>(Lorg/joda/time/chrono/GJChronology;Lorg/joda/time/DateTimeField;Lorg/joda/time/DateTimeField;Lorg/joda/time/DurationField;JZ)V

    .line 627
    return-void
.end method

.method constructor <init>(Lorg/joda/time/chrono/GJChronology;Lorg/joda/time/DateTimeField;Lorg/joda/time/DateTimeField;Lorg/joda/time/DurationField;JZ)V
    .locals 1

    .prologue
    .line 637
    iput-object p1, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    .line 638
    invoke-virtual {p3}, Lorg/joda/time/DateTimeField;->a()Lorg/joda/time/DateTimeFieldType;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/joda/time/field/BaseDateTimeField;-><init>(Lorg/joda/time/DateTimeFieldType;)V

    .line 639
    iput-object p2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    .line 640
    iput-object p3, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    .line 641
    iput-wide p5, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    .line 642
    iput-boolean p7, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->d:Z

    .line 645
    invoke-virtual {p3}, Lorg/joda/time/DateTimeField;->d()Lorg/joda/time/DurationField;

    move-result-object v0

    iput-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->e:Lorg/joda/time/DurationField;

    .line 646
    if-nez p4, :cond_0

    .line 647
    invoke-virtual {p3}, Lorg/joda/time/DateTimeField;->e()Lorg/joda/time/DurationField;

    move-result-object p4

    .line 648
    if-nez p4, :cond_0

    .line 649
    invoke-virtual {p2}, Lorg/joda/time/DateTimeField;->e()Lorg/joda/time/DurationField;

    move-result-object p4

    .line 652
    :cond_0
    iput-object p4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->f:Lorg/joda/time/DurationField;

    .line 653
    return-void
.end method


# virtual methods
.method public a(J)I
    .locals 3

    .prologue
    .line 660
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 661
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->a(J)I

    move-result v0

    .line 663
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->a(J)I

    move-result v0

    goto :goto_0
.end method

.method public a(Ljava/util/Locale;)I
    .locals 2

    .prologue
    .line 910
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1}, Lorg/joda/time/DateTimeField;->a(Ljava/util/Locale;)I

    move-result v0

    iget-object v1, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v1, p1}, Lorg/joda/time/DateTimeField;->a(Ljava/util/Locale;)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method public a(JI)J
    .locals 3

    .prologue
    .line 692
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->a(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public a(JJ)J
    .locals 3

    .prologue
    .line 696
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/joda/time/DateTimeField;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public a(JLjava/lang/String;Ljava/util/Locale;)J
    .locals 7

    .prologue
    .line 757
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    .line 758
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/joda/time/DateTimeField;->a(JLjava/lang/String;Ljava/util/Locale;)J

    move-result-wide v0

    .line 759
    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v0, v2

    if-gez v2, :cond_0

    .line 761
    iget-object v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-static {v2}, Lorg/joda/time/chrono/GJChronology;->a(Lorg/joda/time/chrono/GJChronology;)J

    move-result-wide v2

    add-long/2addr v2, v0

    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 762
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->k(J)J

    move-result-wide v0

    .line 776
    :cond_0
    :goto_0
    return-wide v0

    .line 767
    :cond_1
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/joda/time/DateTimeField;->a(JLjava/lang/String;Ljava/util/Locale;)J

    move-result-wide v0

    .line 768
    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v0, v2

    if-ltz v2, :cond_0

    .line 770
    iget-object v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-static {v2}, Lorg/joda/time/chrono/GJChronology;->a(Lorg/joda/time/chrono/GJChronology;)J

    move-result-wide v2

    sub-long v2, v0, v2

    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 771
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->j(J)J

    move-result-wide v0

    goto :goto_0
.end method

.method public a(ILjava/util/Locale;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 676
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->a(ILjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(JLjava/util/Locale;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 668
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 669
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->a(JLjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 671
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->a(JLjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public b(JI)J
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 726
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    .line 727
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->b(JI)J

    move-result-wide v0

    .line 728
    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v0, v2

    if-gez v2, :cond_3

    .line 730
    iget-object v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-static {v2}, Lorg/joda/time/chrono/GJChronology;->a(Lorg/joda/time/chrono/GJChronology;)J

    move-result-wide v2

    add-long/2addr v2, v0

    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 731
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->k(J)J

    move-result-wide v0

    .line 734
    :cond_0
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->a(J)I

    move-result v2

    if-eq v2, p3, :cond_3

    .line 735
    new-instance v0, Lorg/joda/time/IllegalFieldValueException;

    iget-object v1, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v1}, Lorg/joda/time/DateTimeField;->a()Lorg/joda/time/DateTimeFieldType;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, v1, v2, v6, v6}, Lorg/joda/time/IllegalFieldValueException;-><init>(Lorg/joda/time/DateTimeFieldType;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V

    throw v0

    .line 740
    :cond_1
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->b(JI)J

    move-result-wide v0

    .line 741
    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v0, v2

    if-ltz v2, :cond_3

    .line 743
    iget-object v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-static {v2}, Lorg/joda/time/chrono/GJChronology;->a(Lorg/joda/time/chrono/GJChronology;)J

    move-result-wide v2

    sub-long v2, v0, v2

    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v2, v4

    if-ltz v2, :cond_2

    .line 744
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->j(J)J

    move-result-wide v0

    .line 747
    :cond_2
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->a(J)I

    move-result v2

    if-eq v2, p3, :cond_3

    .line 748
    new-instance v0, Lorg/joda/time/IllegalFieldValueException;

    iget-object v1, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v1}, Lorg/joda/time/DateTimeField;->a()Lorg/joda/time/DateTimeFieldType;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, v1, v2, v6, v6}, Lorg/joda/time/IllegalFieldValueException;-><init>(Lorg/joda/time/DateTimeFieldType;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V

    throw v0

    .line 753
    :cond_3
    return-wide v0
.end method

.method public b(ILjava/util/Locale;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 688
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->b(ILjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b(JLjava/util/Locale;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 680
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 681
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->b(JLjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 683
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DateTimeField;->b(JLjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public b(J)Z
    .locals 3

    .prologue
    .line 788
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 789
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->b(J)Z

    move-result v0

    .line 791
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->b(J)Z

    move-result v0

    goto :goto_0
.end method

.method public c(J)I
    .locals 7

    .prologue
    .line 846
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    .line 847
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->c(J)I

    move-result v0

    .line 859
    :cond_0
    :goto_0
    return v0

    .line 850
    :cond_1
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->c(J)I

    move-result v0

    .line 854
    iget-object v1, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v1, p1, p2, v0}, Lorg/joda/time/DateTimeField;->b(JI)J

    move-result-wide v2

    .line 855
    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    .line 856
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    iget-object v1, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    const/4 v4, -0x1

    invoke-virtual {v1, v2, v3, v4}, Lorg/joda/time/DateTimeField;->a(JI)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lorg/joda/time/DateTimeField;->a(J)I

    move-result v0

    goto :goto_0
.end method

.method public d(J)J
    .locals 7

    .prologue
    .line 880
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    .line 881
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->d(J)J

    move-result-wide v0

    .line 882
    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v0, v2

    if-gez v2, :cond_0

    .line 884
    iget-object v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-static {v2}, Lorg/joda/time/chrono/GJChronology;->a(Lorg/joda/time/chrono/GJChronology;)J

    move-result-wide v2

    add-long/2addr v2, v0

    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 885
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->k(J)J

    move-result-wide v0

    .line 891
    :cond_0
    :goto_0
    return-wide v0

    .line 889
    :cond_1
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->d(J)J

    move-result-wide v0

    goto :goto_0
.end method

.method public d()Lorg/joda/time/DurationField;
    .locals 1

    .prologue
    .line 780
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->e:Lorg/joda/time/DurationField;

    return-object v0
.end method

.method public e(J)J
    .locals 7

    .prologue
    .line 895
    iget-wide v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    .line 896
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->e(J)J

    move-result-wide v0

    .line 906
    :cond_0
    :goto_0
    return-wide v0

    .line 898
    :cond_1
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/DateTimeField;->e(J)J

    move-result-wide v0

    .line 899
    iget-wide v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v0, v2

    if-ltz v2, :cond_0

    .line 901
    iget-object v2, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-static {v2}, Lorg/joda/time/chrono/GJChronology;->a(Lorg/joda/time/chrono/GJChronology;)J

    move-result-wide v2

    sub-long v2, v0, v2

    iget-wide v4, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->c:J

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 902
    invoke-virtual {p0, v0, v1}, Lorg/joda/time/chrono/GJChronology$CutoverField;->j(J)J

    move-result-wide v0

    goto :goto_0
.end method

.method public e()Lorg/joda/time/DurationField;
    .locals 1

    .prologue
    .line 784
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->f:Lorg/joda/time/DurationField;

    return-object v0
.end method

.method public f()Lorg/joda/time/DurationField;
    .locals 1

    .prologue
    .line 804
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0}, Lorg/joda/time/DateTimeField;->f()Lorg/joda/time/DurationField;

    move-result-object v0

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 811
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->a:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0}, Lorg/joda/time/DateTimeField;->g()I

    move-result v0

    return v0
.end method

.method public h()I
    .locals 1

    .prologue
    .line 842
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->b:Lorg/joda/time/DateTimeField;

    invoke-virtual {v0}, Lorg/joda/time/DateTimeField;->h()I

    move-result v0

    return v0
.end method

.method protected j(J)J
    .locals 3

    .prologue
    .line 920
    iget-boolean v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->d:Z

    if-eqz v0, :cond_0

    .line 921
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/GJChronology;->c(J)J

    move-result-wide v0

    .line 923
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/GJChronology;->a(J)J

    move-result-wide v0

    goto :goto_0
.end method

.method protected k(J)J
    .locals 3

    .prologue
    .line 928
    iget-boolean v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->d:Z

    if-eqz v0, :cond_0

    .line 929
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/GJChronology;->d(J)J

    move-result-wide v0

    .line 931
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$CutoverField;->g:Lorg/joda/time/chrono/GJChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/GJChronology;->b(J)J

    move-result-wide v0

    goto :goto_0
.end method
