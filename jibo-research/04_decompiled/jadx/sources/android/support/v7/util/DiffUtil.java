package android.support.v7.util;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {

    /* JADX INFO: renamed from: a */
    private static final Comparator<Snake> f3136a = new Comparator<Snake>() { // from class: android.support.v7.util.DiffUtil.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Snake snake, Snake snake2) {
            int i = snake.f3151a - snake2.f3151a;
            return i == 0 ? snake.f3152b - snake2.f3152b : i;
        }
    };

    /* JADX INFO: renamed from: a */
    public static DiffResult m3443a(Callback callback) {
        return m3444a(callback, true);
    }

    /* JADX INFO: renamed from: a */
    public static DiffResult m3444a(Callback callback, boolean z) {
        int iMo3447a = callback.mo3447a();
        int iMo3449b = callback.mo3449b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, iMo3447a, 0, iMo3449b));
        int iAbs = iMo3447a + iMo3449b + Math.abs(iMo3447a - iMo3449b);
        int[] iArr = new int[iAbs * 2];
        int[] iArr2 = new int[iAbs * 2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeM3445a = m3445a(callback, range.f3147a, range.f3148b, range.f3149c, range.f3150d, iArr, iArr2, iAbs);
            if (snakeM3445a != null) {
                if (snakeM3445a.f3153c > 0) {
                    arrayList.add(snakeM3445a);
                }
                snakeM3445a.f3151a += range.f3147a;
                snakeM3445a.f3152b += range.f3149c;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f3147a = range.f3147a;
                range2.f3149c = range.f3149c;
                if (snakeM3445a.f3155e) {
                    range2.f3148b = snakeM3445a.f3151a;
                    range2.f3150d = snakeM3445a.f3152b;
                } else if (snakeM3445a.f3154d) {
                    range2.f3148b = snakeM3445a.f3151a - 1;
                    range2.f3150d = snakeM3445a.f3152b;
                } else {
                    range2.f3148b = snakeM3445a.f3151a;
                    range2.f3150d = snakeM3445a.f3152b - 1;
                }
                arrayList2.add(range2);
                if (snakeM3445a.f3155e) {
                    if (snakeM3445a.f3154d) {
                        range.f3147a = snakeM3445a.f3151a + snakeM3445a.f3153c + 1;
                        range.f3149c = snakeM3445a.f3152b + snakeM3445a.f3153c;
                    } else {
                        range.f3147a = snakeM3445a.f3151a + snakeM3445a.f3153c;
                        range.f3149c = snakeM3445a.f3152b + snakeM3445a.f3153c + 1;
                    }
                } else {
                    range.f3147a = snakeM3445a.f3151a + snakeM3445a.f3153c;
                    range.f3149c = snakeM3445a.f3152b + snakeM3445a.f3153c;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f3136a);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }

    /* JADX INFO: renamed from: a */
    private static Snake m3445a(Callback callback, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6;
        boolean z;
        int i7;
        boolean z2;
        int i8 = i2 - i;
        int i9 = i4 - i3;
        if (i2 - i < 1 || i4 - i3 < 1) {
            return null;
        }
        int i10 = i8 - i9;
        int i11 = ((i8 + i9) + 1) / 2;
        Arrays.fill(iArr, (i5 - i11) - 1, i5 + i11 + 1, 0);
        Arrays.fill(iArr2, ((i5 - i11) - 1) + i10, i5 + i11 + 1 + i10, i8);
        boolean z3 = i10 % 2 != 0;
        for (int i12 = 0; i12 <= i11; i12++) {
            for (int i13 = -i12; i13 <= i12; i13 += 2) {
                if (i13 == (-i12) || (i13 != i12 && iArr[(i5 + i13) - 1] < iArr[i5 + i13 + 1])) {
                    i7 = iArr[i5 + i13 + 1];
                    z2 = false;
                } else {
                    i7 = iArr[(i5 + i13) - 1] + 1;
                    z2 = true;
                }
                int i14 = i7;
                for (int i15 = i7 - i13; i14 < i8 && i15 < i9 && callback.mo3448a(i + i14, i3 + i15); i15++) {
                    i14++;
                }
                iArr[i5 + i13] = i14;
                if (z3 && i13 >= (i10 - i12) + 1 && i13 <= (i10 + i12) - 1 && iArr[i5 + i13] >= iArr2[i5 + i13]) {
                    Snake snake = new Snake();
                    snake.f3151a = iArr2[i5 + i13];
                    snake.f3152b = snake.f3151a - i13;
                    snake.f3153c = iArr[i5 + i13] - iArr2[i5 + i13];
                    snake.f3154d = z2;
                    snake.f3155e = false;
                    return snake;
                }
            }
            for (int i16 = -i12; i16 <= i12; i16 += 2) {
                int i17 = i16 + i10;
                if (i17 == i12 + i10 || (i17 != (-i12) + i10 && iArr2[(i5 + i17) - 1] < iArr2[i5 + i17 + 1])) {
                    i6 = iArr2[(i5 + i17) - 1];
                    z = false;
                } else {
                    i6 = iArr2[(i5 + i17) + 1] - 1;
                    z = true;
                }
                int i18 = i6;
                for (int i19 = i6 - i17; i18 > 0 && i19 > 0 && callback.mo3448a((i + i18) - 1, (i3 + i19) - 1); i19--) {
                    i18--;
                }
                iArr2[i5 + i17] = i18;
                if (!z3 && i16 + i10 >= (-i12) && i16 + i10 <= i12 && iArr[i5 + i17] >= iArr2[i5 + i17]) {
                    Snake snake2 = new Snake();
                    snake2.f3151a = iArr2[i5 + i17];
                    snake2.f3152b = snake2.f3151a - i17;
                    snake2.f3153c = iArr[i5 + i17] - iArr2[i5 + i17];
                    snake2.f3154d = z;
                    snake2.f3155e = true;
                    return snake2;
                }
            }
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }

    public static abstract class Callback {
        /* JADX INFO: renamed from: a */
        public abstract int mo3447a();

        /* JADX INFO: renamed from: a */
        public abstract boolean mo3448a(int i, int i2);

        /* JADX INFO: renamed from: b */
        public abstract int mo3449b();

        /* JADX INFO: renamed from: b */
        public abstract boolean mo3450b(int i, int i2);

        /* JADX INFO: renamed from: c */
        public Object m3451c(int i, int i2) {
            return null;
        }
    }

    static class Snake {

        /* JADX INFO: renamed from: a */
        int f3151a;

        /* JADX INFO: renamed from: b */
        int f3152b;

        /* JADX INFO: renamed from: c */
        int f3153c;

        /* JADX INFO: renamed from: d */
        boolean f3154d;

        /* JADX INFO: renamed from: e */
        boolean f3155e;

        Snake() {
        }
    }

    static class Range {

        /* JADX INFO: renamed from: a */
        int f3147a;

        /* JADX INFO: renamed from: b */
        int f3148b;

        /* JADX INFO: renamed from: c */
        int f3149c;

        /* JADX INFO: renamed from: d */
        int f3150d;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.f3147a = i;
            this.f3148b = i2;
            this.f3149c = i3;
            this.f3150d = i4;
        }
    }

    public static class DiffResult {

        /* JADX INFO: renamed from: a */
        private final List<Snake> f3137a;

        /* JADX INFO: renamed from: b */
        private final int[] f3138b;

        /* JADX INFO: renamed from: c */
        private final int[] f3139c;

        /* JADX INFO: renamed from: d */
        private final Callback f3140d;

        /* JADX INFO: renamed from: e */
        private final int f3141e;

        /* JADX INFO: renamed from: f */
        private final int f3142f;

        /* JADX INFO: renamed from: g */
        private final boolean f3143g;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.f3137a = list;
            this.f3138b = iArr;
            this.f3139c = iArr2;
            Arrays.fill(this.f3138b, 0);
            Arrays.fill(this.f3139c, 0);
            this.f3140d = callback;
            this.f3141e = callback.mo3447a();
            this.f3142f = callback.mo3449b();
            this.f3143g = z;
            m3453a();
            m3457b();
        }

        /* JADX INFO: renamed from: a */
        private void m3453a() {
            Snake snake = this.f3137a.isEmpty() ? null : this.f3137a.get(0);
            if (snake == null || snake.f3151a != 0 || snake.f3152b != 0) {
                Snake snake2 = new Snake();
                snake2.f3151a = 0;
                snake2.f3152b = 0;
                snake2.f3154d = false;
                snake2.f3153c = 0;
                snake2.f3155e = false;
                this.f3137a.add(0, snake2);
            }
        }

        /* JADX INFO: renamed from: b */
        private void m3457b() {
            int i = this.f3141e;
            int i2 = this.f3142f;
            for (int size = this.f3137a.size() - 1; size >= 0; size--) {
                Snake snake = this.f3137a.get(size);
                int i3 = snake.f3151a + snake.f3153c;
                int i4 = snake.f3152b + snake.f3153c;
                if (this.f3143g) {
                    while (i > i3) {
                        m3454a(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        m3458b(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < snake.f3153c; i5++) {
                    int i6 = snake.f3151a + i5;
                    int i7 = snake.f3152b + i5;
                    int i8 = this.f3140d.mo3450b(i6, i7) ? 1 : 2;
                    this.f3138b[i6] = (i7 << 5) | i8;
                    this.f3139c[i7] = i8 | (i6 << 5);
                }
                i = snake.f3151a;
                i2 = snake.f3152b;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m3454a(int i, int i2, int i3) {
            if (this.f3138b[i - 1] == 0) {
                m3456a(i, i2, i3, false);
            }
        }

        /* JADX INFO: renamed from: b */
        private void m3458b(int i, int i2, int i3) {
            if (this.f3139c[i2 - 1] == 0) {
                m3456a(i, i2, i3, true);
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m3456a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                int i6 = i2 - 1;
                i2--;
                i4 = i6;
                i5 = i;
            } else {
                i4 = i - 1;
                i5 = i - 1;
            }
            int i7 = i5;
            while (i3 >= 0) {
                Snake snake = this.f3137a.get(i3);
                int i8 = snake.f3151a + snake.f3153c;
                int i9 = snake.f3152b + snake.f3153c;
                if (z) {
                    for (int i10 = i7 - 1; i10 >= i8; i10--) {
                        if (this.f3140d.mo3448a(i10, i4)) {
                            int i11 = this.f3140d.mo3450b(i10, i4) ? 8 : 4;
                            this.f3139c[i4] = (i10 << 5) | 16;
                            this.f3138b[i10] = i11 | (i4 << 5);
                            return true;
                        }
                    }
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.f3140d.mo3448a(i4, i12)) {
                            int i13 = this.f3140d.mo3450b(i4, i12) ? 8 : 4;
                            this.f3138b[i - 1] = (i12 << 5) | 16;
                            this.f3139c[i12] = ((i - 1) << 5) | i13;
                            return true;
                        }
                    }
                }
                i7 = snake.f3151a;
                i2 = snake.f3152b;
                i3--;
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void m3461a(RecyclerView.Adapter adapter) {
            m3460a(new AdapterListUpdateCallback(adapter));
        }

        /* JADX INFO: renamed from: a */
        public void m3460a(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            List<PostponedUpdate> arrayList = new ArrayList<>();
            int i = this.f3141e;
            int i2 = this.f3142f;
            int size = this.f3137a.size() - 1;
            int i3 = i2;
            while (size >= 0) {
                Snake snake = this.f3137a.get(size);
                int i4 = snake.f3153c;
                int i5 = snake.f3151a + i4;
                int i6 = snake.f3152b + i4;
                if (i5 < i) {
                    m3459b(arrayList, batchingListUpdateCallback, i5, i - i5, i5);
                }
                if (i6 < i3) {
                    m3455a(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    if ((this.f3138b[snake.f3151a + i7] & 31) == 2) {
                        batchingListUpdateCallback.mo3439a(snake.f3151a + i7, 1, this.f3140d.m3451c(snake.f3151a + i7, snake.f3152b + i7));
                    }
                }
                i = snake.f3151a;
                size--;
                i3 = snake.f3152b;
            }
            batchingListUpdateCallback.m3442a();
        }

        /* JADX INFO: renamed from: a */
        private static PostponedUpdate m3452a(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.f3144a != i || postponedUpdate.f3146c != z) {
                    size--;
                } else {
                    list.remove(size);
                    while (true) {
                        int i2 = size;
                        if (i2 >= list.size()) {
                            return postponedUpdate;
                        }
                        PostponedUpdate postponedUpdate2 = list.get(i2);
                        postponedUpdate2.f3145b = (z ? 1 : -1) + postponedUpdate2.f3145b;
                        size = i2 + 1;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        private void m3455a(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f3143g) {
                listUpdateCallback.mo3438a(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.f3139c[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        listUpdateCallback.mo3438a(i, 1);
                        Iterator<PostponedUpdate> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().f3145b++;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.f3139c[i3 + i4] >> 5;
                        listUpdateCallback.mo3441c(m3452a(list, i6, true).f3145b, i);
                        if (i5 == 4) {
                            listUpdateCallback.mo3439a(i, 1, this.f3140d.m3451c(i6, i3 + i4));
                        }
                        break;
                    case 16:
                        list.add(new PostponedUpdate(i3 + i4, i, false));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString(i5));
                }
            }
        }

        /* JADX INFO: renamed from: b */
        private void m3459b(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f3143g) {
                listUpdateCallback.mo3440b(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.f3138b[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        listUpdateCallback.mo3440b(i + i4, 1);
                        for (PostponedUpdate postponedUpdate : list) {
                            postponedUpdate.f3145b--;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.f3138b[i3 + i4] >> 5;
                        PostponedUpdate postponedUpdateM3452a = m3452a(list, i6, false);
                        listUpdateCallback.mo3441c(i + i4, postponedUpdateM3452a.f3145b - 1);
                        if (i5 == 4) {
                            listUpdateCallback.mo3439a(postponedUpdateM3452a.f3145b - 1, 1, this.f3140d.m3451c(i3 + i4, i6));
                        }
                        break;
                    case 16:
                        list.add(new PostponedUpdate(i3 + i4, i + i4, true));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString(i5));
                }
            }
        }
    }

    private static class PostponedUpdate {

        /* JADX INFO: renamed from: a */
        int f3144a;

        /* JADX INFO: renamed from: b */
        int f3145b;

        /* JADX INFO: renamed from: c */
        boolean f3146c;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.f3144a = i;
            this.f3145b = i2;
            this.f3146c = z;
        }
    }
}
