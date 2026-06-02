package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$Gson$Types {

    /* JADX INFO: renamed from: a */
    static final Type[] f8824a = new Type[0];

    /* JADX INFO: renamed from: a */
    public static ParameterizedType m9438a(Type type, Type type2, Type... typeArr) {
        return new ParameterizedTypeImpl(type, type2, typeArr);
    }

    /* JADX INFO: renamed from: a */
    public static GenericArrayType m9437a(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    /* JADX INFO: renamed from: b */
    public static WildcardType m9447b(Type type) {
        Type[] upperBounds;
        if (type instanceof WildcardType) {
            upperBounds = ((WildcardType) type).getUpperBounds();
        } else {
            upperBounds = new Type[]{type};
        }
        return new WildcardTypeImpl(upperBounds, f8824a);
    }

    /* JADX INFO: renamed from: c */
    public static WildcardType m9449c(Type type) {
        Type[] lowerBounds;
        if (type instanceof WildcardType) {
            lowerBounds = ((WildcardType) type).getLowerBounds();
        } else {
            lowerBounds = new Type[]{type};
        }
        return new WildcardTypeImpl(new Type[]{Object.class}, lowerBounds);
    }

    /* JADX INFO: renamed from: d */
    public static Type m9450d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new GenericArrayTypeImpl(m9450d(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    /* JADX INFO: renamed from: e */
    public static Class<?> m9451e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.m9433a(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m9451e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m9451e(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    /* JADX INFO: renamed from: a */
    static boolean m9444a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m9445a(Type type, Type type2) {
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
            return m9444a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m9445a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
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
    static int m9434a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: f */
    public static String m9452f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: renamed from: a */
    static Type m9440a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        return m9440a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
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
                        return m9440a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return type;
    }

    /* JADX INFO: renamed from: b */
    static Type m9446b(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.m9433a(cls2.isAssignableFrom(cls));
        return m9441a(type, cls, m9440a(type, cls, cls2));
    }

    /* JADX INFO: renamed from: g */
    public static Type m9453g(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    /* JADX INFO: renamed from: a */
    public static Type m9439a(Type type, Class<?> cls) {
        Type typeM9446b = m9446b(type, cls, Collection.class);
        if (typeM9446b instanceof WildcardType) {
            typeM9446b = ((WildcardType) typeM9446b).getUpperBounds()[0];
        }
        return typeM9446b instanceof ParameterizedType ? ((ParameterizedType) typeM9446b).getActualTypeArguments()[0] : Object.class;
    }

    /* JADX INFO: renamed from: b */
    public static Type[] m9448b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeM9446b = m9446b(type, cls, Map.class);
        if (typeM9446b instanceof ParameterizedType) {
            return ((ParameterizedType) typeM9446b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* JADX INFO: renamed from: a */
    public static Type m9441a(Type type, Class<?> cls, Type type2) {
        return m9442a(type, cls, type2, new HashSet());
    }

    /* JADX INFO: renamed from: a */
    private static Type m9442a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type typeM9442a;
        Type typeM9443a = type2;
        while (typeM9443a instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) typeM9443a;
            if (!collection.contains(typeVariable)) {
                collection.add(typeVariable);
                typeM9443a = m9443a(type, cls, (TypeVariable<?>) typeVariable);
                if (typeM9443a == typeVariable) {
                    return typeM9443a;
                }
            } else {
                return typeM9443a;
            }
        }
        if ((typeM9443a instanceof Class) && ((Class) typeM9443a).isArray()) {
            Class cls2 = (Class) typeM9443a;
            Class<?> componentType = cls2.getComponentType();
            Type typeM9442a2 = m9442a(type, cls, componentType, collection);
            if (componentType != typeM9442a2) {
                return m9437a(typeM9442a2);
            }
            return cls2;
        }
        if (typeM9443a instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) typeM9443a;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeM9442a3 = m9442a(type, cls, genericComponentType, collection);
            if (genericComponentType != typeM9442a3) {
                return m9437a(typeM9442a3);
            }
            return genericArrayType;
        }
        if (typeM9443a instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) typeM9443a;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeM9442a4 = m9442a(type, cls, ownerType, collection);
            boolean z = typeM9442a4 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            boolean z2 = z;
            Type[] typeArr = actualTypeArguments;
            for (int i = 0; i < length; i++) {
                Type typeM9442a5 = m9442a(type, cls, typeArr[i], collection);
                if (typeM9442a5 != typeArr[i]) {
                    if (!z2) {
                        typeArr = (Type[]) typeArr.clone();
                        z2 = true;
                    }
                    typeArr[i] = typeM9442a5;
                }
            }
            if (z2) {
                return m9438a(typeM9442a4, parameterizedType.getRawType(), typeArr);
            }
            return parameterizedType;
        }
        if (typeM9443a instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) typeM9443a;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeM9442a6 = m9442a(type, cls, lowerBounds[0], collection);
                if (typeM9442a6 != lowerBounds[0]) {
                    return m9449c(typeM9442a6);
                }
                return wildcardType;
            }
            if (upperBounds.length == 1 && (typeM9442a = m9442a(type, cls, upperBounds[0], collection)) != upperBounds[0]) {
                return m9447b(typeM9442a);
            }
            return wildcardType;
        }
        return typeM9443a;
    }

    /* JADX INFO: renamed from: a */
    static Type m9443a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsM9436a = m9436a(typeVariable);
        if (clsM9436a != null) {
            Type typeM9440a = m9440a(type, cls, clsM9436a);
            if (typeM9440a instanceof ParameterizedType) {
                return ((ParameterizedType) typeM9440a).getActualTypeArguments()[m9435a((Object[]) clsM9436a.getTypeParameters(), (Object) typeVariable)];
            }
            return typeVariable;
        }
        return typeVariable;
    }

    /* JADX INFO: renamed from: a */
    private static int m9435a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: a */
    private static Class<?> m9436a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    static void m9454h(Type type) {
        C$Gson$Preconditions.m9433a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {

        /* JADX INFO: renamed from: a */
        private final Type f8826a;

        /* JADX INFO: renamed from: b */
        private final Type f8827b;

        /* JADX INFO: renamed from: c */
        private final Type[] f8828c;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                C$Gson$Preconditions.m9433a(type != null || (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null));
            }
            this.f8826a = type == null ? null : C$Gson$Types.m9450d(type);
            this.f8827b = C$Gson$Types.m9450d(type2);
            this.f8828c = (Type[]) typeArr.clone();
            int length = this.f8828c.length;
            for (int i = 0; i < length; i++) {
                C$Gson$Preconditions.m9432a(this.f8828c[i]);
                C$Gson$Types.m9454h(this.f8828c[i]);
                this.f8828c[i] = C$Gson$Types.m9450d(this.f8828c[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f8828c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f8827b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f8826a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.m9445a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f8828c) ^ this.f8827b.hashCode()) ^ C$Gson$Types.m9434a((Object) this.f8826a);
        }

        public String toString() {
            int length = this.f8828c.length;
            if (length == 0) {
                return C$Gson$Types.m9452f(this.f8827b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(C$Gson$Types.m9452f(this.f8827b)).append("<").append(C$Gson$Types.m9452f(this.f8828c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ").append(C$Gson$Types.m9452f(this.f8828c[i]));
            }
            return sb.append(">").toString();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {

        /* JADX INFO: renamed from: a */
        private final Type f8825a;

        public GenericArrayTypeImpl(Type type) {
            this.f8825a = C$Gson$Types.m9450d(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f8825a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.m9445a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return this.f8825a.hashCode();
        }

        public String toString() {
            return C$Gson$Types.m9452f(this.f8825a) + "[]";
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class WildcardTypeImpl implements Serializable, WildcardType {

        /* JADX INFO: renamed from: a */
        private final Type f8829a;

        /* JADX INFO: renamed from: b */
        private final Type f8830b;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            C$Gson$Preconditions.m9433a(typeArr2.length <= 1);
            C$Gson$Preconditions.m9433a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.m9432a(typeArr2[0]);
                C$Gson$Types.m9454h(typeArr2[0]);
                C$Gson$Preconditions.m9433a(typeArr[0] == Object.class);
                this.f8830b = C$Gson$Types.m9450d(typeArr2[0]);
                this.f8829a = Object.class;
                return;
            }
            C$Gson$Preconditions.m9432a(typeArr[0]);
            C$Gson$Types.m9454h(typeArr[0]);
            this.f8830b = null;
            this.f8829a = C$Gson$Types.m9450d(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f8829a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return this.f8830b != null ? new Type[]{this.f8830b} : C$Gson$Types.f8824a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.m9445a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (this.f8830b != null ? this.f8830b.hashCode() + 31 : 1) ^ (this.f8829a.hashCode() + 31);
        }

        public String toString() {
            if (this.f8830b != null) {
                return "? super " + C$Gson$Types.m9452f(this.f8830b);
            }
            if (this.f8829a == Object.class) {
                return "?";
            }
            return "? extends " + C$Gson$Types.m9452f(this.f8829a);
        }
    }
}
