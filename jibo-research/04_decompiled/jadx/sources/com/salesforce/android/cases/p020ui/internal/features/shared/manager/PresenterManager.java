package com.salesforce.android.cases.p020ui.internal.features.shared.manager;

import android.support.v4.util.SparseArrayCompat;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider;
import com.yalantis.ucrop.util.FileUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PresenterManager {

    /* JADX INFO: renamed from: a */
    private List<PresenterProvider> f12830a;

    /* JADX INFO: renamed from: b */
    private SparseArrayCompat<BasePresenter> f12831b;

    private PresenterManager(List<PresenterProvider> list) {
        this.f12830a = Collections.unmodifiableList(list);
        this.f12831b = new SparseArrayCompat<>(list.size());
    }

    /* JADX INFO: renamed from: a */
    public static PresenterManager m13014a(PresenterProvider... presenterProviderArr) {
        return new PresenterManager(Arrays.asList(presenterProviderArr));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public <P> P m13016a(CaseUIClient caseUIClient, Class<? extends BasePresenter> cls) {
        BasePresenter basePresenter;
        BasePresenter basePresenterM13015b = m13015b(cls);
        if (basePresenterM13015b == null) {
            for (PresenterProvider presenterProvider : this.f12830a) {
                if (presenterProvider.mo12800a(cls)) {
                    basePresenter = (P) presenterProvider.mo12801b(caseUIClient);
                    this.f12831b.m2461b(cls.hashCode(), basePresenter);
                    break;
                }
            }
            basePresenter = (P) basePresenterM13015b;
        } else {
            basePresenter = (P) basePresenterM13015b;
        }
        if (basePresenter == null) {
            throw new IllegalStateException("Could not create a presenter for the class " + cls.getCanonicalName() + FileUtils.HIDDEN_PREFIX);
        }
        return (P) basePresenter;
    }

    /* JADX INFO: renamed from: a */
    public void m13017a(Class<? extends BasePresenter> cls) {
        BasePresenter basePresenterM2457a = this.f12831b.m2457a(cls.hashCode());
        if (basePresenterM2457a != null) {
            basePresenterM2457a.mo12790e();
        }
        this.f12831b.m2463c(cls.hashCode());
    }

    /* JADX INFO: renamed from: b */
    private BasePresenter m13015b(Class<? extends BasePresenter> cls) {
        return this.f12831b.m2458a(cls.hashCode(), null);
    }
}
