package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {

    /* JADX INFO: renamed from: a */
    final Callback f4051a;

    interface Callback {
        /* JADX INFO: renamed from: a */
        AdapterHelper.UpdateOp mo3807a(int i, int i2, int i3, Object obj);

        /* JADX INFO: renamed from: a */
        void mo3809a(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.f4051a = callback;
    }

    /* JADX INFO: renamed from: a */
    void m4394a(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int iM4392b = m4392b(list);
            if (iM4392b != -1) {
                m4391a(list, iM4392b, iM4392b + 1);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4391a(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        switch (updateOp2.f3639a) {
            case 1:
                m4393c(list, i, updateOp, i2, updateOp2);
                break;
            case 2:
                m4395a(list, i, updateOp, i2, updateOp2);
                break;
            case 4:
                m4396b(list, i, updateOp, i2, updateOp2);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4395a(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        AdapterHelper.UpdateOp updateOpMo3807a;
        boolean z2 = false;
        if (updateOp.f3640b < updateOp.f3642d) {
            z = updateOp2.f3640b == updateOp.f3640b && updateOp2.f3642d == updateOp.f3642d - updateOp.f3640b;
        } else if (updateOp2.f3640b == updateOp.f3642d + 1 && updateOp2.f3642d == updateOp.f3640b - updateOp.f3642d) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (updateOp.f3642d < updateOp2.f3640b) {
            updateOp2.f3640b--;
        } else if (updateOp.f3642d < updateOp2.f3640b + updateOp2.f3642d) {
            updateOp2.f3642d--;
            updateOp.f3639a = 2;
            updateOp.f3642d = 1;
            if (updateOp2.f3642d == 0) {
                list.remove(i2);
                this.f4051a.mo3809a(updateOp2);
                return;
            }
            return;
        }
        if (updateOp.f3640b <= updateOp2.f3640b) {
            updateOp2.f3640b++;
            updateOpMo3807a = null;
        } else if (updateOp.f3640b < updateOp2.f3640b + updateOp2.f3642d) {
            updateOpMo3807a = this.f4051a.mo3807a(2, updateOp.f3640b + 1, (updateOp2.f3640b + updateOp2.f3642d) - updateOp.f3640b, null);
            updateOp2.f3642d = updateOp.f3640b - updateOp2.f3640b;
        } else {
            updateOpMo3807a = null;
        }
        if (z) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.f4051a.mo3809a(updateOp);
            return;
        }
        if (z2) {
            if (updateOpMo3807a != null) {
                if (updateOp.f3640b > updateOpMo3807a.f3640b) {
                    updateOp.f3640b -= updateOpMo3807a.f3642d;
                }
                if (updateOp.f3642d > updateOpMo3807a.f3640b) {
                    updateOp.f3642d -= updateOpMo3807a.f3642d;
                }
            }
            if (updateOp.f3640b > updateOp2.f3640b) {
                updateOp.f3640b -= updateOp2.f3642d;
            }
            if (updateOp.f3642d > updateOp2.f3640b) {
                updateOp.f3642d -= updateOp2.f3642d;
            }
        } else {
            if (updateOpMo3807a != null) {
                if (updateOp.f3640b >= updateOpMo3807a.f3640b) {
                    updateOp.f3640b -= updateOpMo3807a.f3642d;
                }
                if (updateOp.f3642d >= updateOpMo3807a.f3640b) {
                    updateOp.f3642d -= updateOpMo3807a.f3642d;
                }
            }
            if (updateOp.f3640b >= updateOp2.f3640b) {
                updateOp.f3640b -= updateOp2.f3642d;
            }
            if (updateOp.f3642d >= updateOp2.f3640b) {
                updateOp.f3642d -= updateOp2.f3642d;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.f3640b != updateOp.f3642d) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOpMo3807a != null) {
            list.add(i, updateOpMo3807a);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4393c(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = 0;
        if (updateOp.f3642d < updateOp2.f3640b) {
            i3 = -1;
        }
        if (updateOp.f3640b < updateOp2.f3640b) {
            i3++;
        }
        if (updateOp2.f3640b <= updateOp.f3640b) {
            updateOp.f3640b += updateOp2.f3642d;
        }
        if (updateOp2.f3640b <= updateOp.f3642d) {
            updateOp.f3642d += updateOp2.f3642d;
        }
        updateOp2.f3640b = i3 + updateOp2.f3640b;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* JADX INFO: renamed from: b */
    void m4396b(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp updateOpMo3807a;
        AdapterHelper.UpdateOp updateOpMo3807a2 = null;
        if (updateOp.f3642d < updateOp2.f3640b) {
            updateOp2.f3640b--;
            updateOpMo3807a = null;
        } else if (updateOp.f3642d < updateOp2.f3640b + updateOp2.f3642d) {
            updateOp2.f3642d--;
            updateOpMo3807a = this.f4051a.mo3807a(4, updateOp.f3640b, 1, updateOp2.f3641c);
        } else {
            updateOpMo3807a = null;
        }
        if (updateOp.f3640b <= updateOp2.f3640b) {
            updateOp2.f3640b++;
        } else if (updateOp.f3640b < updateOp2.f3640b + updateOp2.f3642d) {
            int i3 = (updateOp2.f3640b + updateOp2.f3642d) - updateOp.f3640b;
            updateOpMo3807a2 = this.f4051a.mo3807a(4, updateOp.f3640b + 1, i3, updateOp2.f3641c);
            updateOp2.f3642d -= i3;
        }
        list.set(i2, updateOp);
        if (updateOp2.f3642d > 0) {
            list.set(i, updateOp2);
        } else {
            list.remove(i);
            this.f4051a.mo3809a(updateOp2);
        }
        if (updateOpMo3807a != null) {
            list.add(i, updateOpMo3807a);
        }
        if (updateOpMo3807a2 != null) {
            list.add(i, updateOpMo3807a2);
        }
    }

    /* JADX INFO: renamed from: b */
    private int m4392b(List<AdapterHelper.UpdateOp> list) {
        boolean z;
        boolean z2 = false;
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).f3639a == 8) {
                if (z2) {
                    return size;
                }
                z = z2;
            } else {
                z = true;
            }
            size--;
            z2 = z;
        }
        return -1;
    }
}
