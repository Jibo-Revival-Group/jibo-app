package android.arch.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider {

    /* JADX INFO: renamed from: a */
    private final Factory f67a;

    /* JADX INFO: renamed from: b */
    private final ViewModelStore f68b;

    public interface Factory {
        /* JADX INFO: renamed from: a */
        <T extends ViewModel> T mo99a(Class<T> cls);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this.f67a = factory;
        this.f68b = viewModelStore;
    }

    /* JADX INFO: renamed from: a */
    public <T extends ViewModel> T m97a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) m98a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public <T extends ViewModel> T m98a(String str, Class<T> cls) {
        T t = (T) this.f68b.m100a(str);
        if (!cls.isInstance(t)) {
            if (t != null) {
            }
            T t2 = (T) this.f67a.mo99a(cls);
            this.f68b.m102a(str, t2);
            return t2;
        }
        return t;
    }
}
