package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.ResponseBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
final class Utils {

    /* JADX INFO: renamed from: a */
    static final Type[] f16364a = new Type[0];

    /* JADX INFO: renamed from: a */
    static Class<?> m17160a(Type type) {
        m17162a(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m17160a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m17160a(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    /* JADX INFO: renamed from: a */
    static boolean m17170a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return m17169a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m17170a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    /* JADX INFO: renamed from: a */
    static Type m17164a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        return m17164a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        return m17164a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return type;
    }

    /* JADX INFO: renamed from: a */
    private static int m17159a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m17169a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    static int m17158a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    static String m17172b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: renamed from: b */
    static Type m17173b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m17165a(type, cls, m17164a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: a */
    static Type m17165a(Type type, Class<?> cls, Type type2) {
        Type typeM17165a;
        TypeVariable typeVariable;
        do {
            Type type3 = type2;
            if (!(type3 instanceof TypeVariable)) {
                if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                    Class cls2 = (Class) type3;
                    Class<?> componentType = cls2.getComponentType();
                    Type typeM17165a2 = m17165a(type, cls, (Type) componentType);
                    return componentType != typeM17165a2 ? new GenericArrayTypeImpl(typeM17165a2) : cls2;
                }
                if (type3 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type3;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeM17165a3 = m17165a(type, cls, genericComponentType);
                    return genericComponentType != typeM17165a3 ? new GenericArrayTypeImpl(typeM17165a3) : genericArrayType;
                }
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeM17165a4 = m17165a(type, cls, ownerType);
                    boolean z = typeM17165a4 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    boolean z2 = z;
                    Type[] typeArr = actualTypeArguments;
                    for (int i = 0; i < length; i++) {
                        Type typeM17165a5 = m17165a(type, cls, typeArr[i]);
                        if (typeM17165a5 != typeArr[i]) {
                            if (!z2) {
                                typeArr = (Type[]) typeArr.clone();
                                z2 = true;
                            }
                            typeArr[i] = typeM17165a5;
                        }
                    }
                    if (z2) {
                        return new ParameterizedTypeImpl(typeM17165a4, parameterizedType.getRawType(), typeArr);
                    }
                    return parameterizedType;
                }
                if (type3 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type3;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type typeM17165a6 = m17165a(type, cls, lowerBounds[0]);
                        if (typeM17165a6 != lowerBounds[0]) {
                            return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{typeM17165a6});
                        }
                        return wildcardType;
                    }
                    if (upperBounds.length == 1 && (typeM17165a = m17165a(type, cls, upperBounds[0])) != upperBounds[0]) {
                        return new WildcardTypeImpl(new Type[]{typeM17165a}, f16364a);
                    }
                    return wildcardType;
                }
                return type3;
            }
            typeVariable = (TypeVariable) type3;
            type2 = m17166a(type, cls, (TypeVariable<?>) typeVariable);
        } while (type2 != typeVariable);
        return type2;
    }

    /* JADX INFO: renamed from: a */
    private static Type m17166a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsM17161a = m17161a(typeVariable);
        if (clsM17161a != null) {
            Type typeM17164a = m17164a(type, cls, clsM17161a);
            if (typeM17164a instanceof ParameterizedType) {
                return ((ParameterizedType) typeM17164a).getActualTypeArguments()[m17159a((Object[]) clsM17161a.getTypeParameters(), (Object) typeVariable)];
            }
            return typeVariable;
        }
        return typeVariable;
    }

    /* JADX INFO: renamed from: a */
    private static Class<?> m17161a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    static void m17174c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: a */
    static <T> T m17162a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    static boolean m17171a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static ResponseBody m17167a(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.mo15513c().mo16250a(buffer);
        return ResponseBody.m15821a(responseBody.mo15511a(), responseBody.mo15512b(), buffer);
    }

    /* JADX INFO: renamed from: a */
    static <T> void m17168a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    /* JADX INFO: renamed from: a */
    static Type m17163a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
        }
        Type type = actualTypeArguments[i];
        if (type instanceof WildcardType) {
            return ((WildcardType) type).getUpperBounds()[0];
        }
        return type;
    }

    /* JADX INFO: renamed from: d */
    static boolean m17175d(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (m17175d(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return m17175d(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof TypeVariable) && !(type instanceof WildcardType)) {
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    static Type m17176e(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        return m17163a(0, (ParameterizedType) type);
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType {

        /* JADX INFO: renamed from: a */
        private final Type f16366a;

        /* JADX INFO: renamed from: b */
        private final Type f16367b;

        /* JADX INFO: renamed from: c */
        private final Type[] f16368c;

        ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Utils.m17162a(type3, "typeArgument == null");
                Utils.m17174c(type3);
            }
            this.f16366a = type;
            this.f16367b = type2;
            this.f16368c = (Type[]) typeArr.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f16368c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f16367b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f16366a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Utils.m17170a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f16368c) ^ this.f16367b.hashCode()) ^ Utils.m17158a((Object) this.f16366a);
        }

        public String toString() {
            if (this.f16368c.length == 0) {
                return Utils.m17172b(this.f16367b);
            }
            StringBuilder sb = new StringBuilder((this.f16368c.length + 1) * 30);
            sb.append(Utils.m17172b(this.f16367b));
            sb.append("<").append(Utils.m17172b(this.f16368c[0]));
            for (int i = 1; i < this.f16368c.length; i++) {
                sb.append(", ").append(Utils.m17172b(this.f16368c[i]));
            }
            return sb.append(">").toString();
        }
    }

    private static final class GenericArrayTypeImpl implements GenericArrayType {

        /* JADX INFO: renamed from: a */
        private final Type f16365a;

        GenericArrayTypeImpl(Type type) {
            this.f16365a = type;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f16365a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Utils.m17170a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return this.f16365a.hashCode();
        }

        public String toString() {
            return Utils.m17172b(this.f16365a) + "[]";
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {

        /* JADX INFO: renamed from: a */
        private final Type f16369a;

        /* JADX INFO: renamed from: b */
        private final Type f16370b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length == 1) {
                if (typeArr2[0] == null) {
                    throw new NullPointerException();
                }
                Utils.m17174c(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.f16370b = typeArr2[0];
                this.f16369a = Object.class;
                return;
            }
            if (typeArr[0] == null) {
                throw new NullPointerException();
            }
            Utils.m17174c(typeArr[0]);
            this.f16370b = null;
            this.f16369a = typeArr[0];
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f16369a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return this.f16370b != null ? new Type[]{this.f16370b} : Utils.f16364a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Utils.m17170a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (this.f16370b != null ? this.f16370b.hashCode() + 31 : 1) ^ (this.f16369a.hashCode() + 31);
        }

        public String toString() {
            return this.f16370b != null ? "? super " + Utils.m17172b(this.f16370b) : this.f16369a == Object.class ? "?" : "? extends " + Utils.m17172b(this.f16369a);
        }
    }
}
