package com.google.api.client.json;

import com.google.api.client.json.JsonPolymorphicTypeMap;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonParser {
    private static WeakHashMap<Class<?>, Field> cachedTypemapFields = new WeakHashMap<>();
    private static final Lock lock = new ReentrantLock();

    public abstract void close() throws IOException;

    public abstract BigInteger getBigIntegerValue() throws IOException;

    public abstract byte getByteValue() throws IOException;

    public abstract String getCurrentName() throws IOException;

    public abstract JsonToken getCurrentToken();

    public abstract BigDecimal getDecimalValue() throws IOException;

    public abstract double getDoubleValue() throws IOException;

    public abstract JsonFactory getFactory();

    public abstract float getFloatValue() throws IOException;

    public abstract int getIntValue() throws IOException;

    public abstract long getLongValue() throws IOException;

    public abstract short getShortValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract JsonToken nextToken() throws IOException;

    public abstract JsonParser skipChildren() throws IOException;

    public final <T> T parseAndClose(Class<T> cls) throws IOException {
        return (T) parseAndClose((Class) cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> T parseAndClose(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return (T) parse((Class) cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final void skipToKey(String str) throws IOException {
        skipToKey(Collections.singleton(str));
    }

    public final String skipToKey(Set<String> set) throws IOException {
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        while (jsonTokenStartParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (!set.contains(text)) {
                skipChildren();
                jsonTokenStartParsingObjectOrArray = nextToken();
            } else {
                return text;
            }
        }
        return null;
    }

    private JsonToken startParsing() throws IOException {
        JsonToken currentToken = getCurrentToken();
        JsonToken jsonTokenNextToken = currentToken == null ? nextToken() : currentToken;
        Preconditions.checkArgument(jsonTokenNextToken != null, "no JSON input found");
        return jsonTokenNextToken;
    }

    private JsonToken startParsingObjectOrArray() throws IOException {
        JsonToken jsonTokenStartParsing = startParsing();
        switch (jsonTokenStartParsing) {
            case START_OBJECT:
                JsonToken jsonTokenNextToken = nextToken();
                Preconditions.checkArgument(jsonTokenNextToken == JsonToken.FIELD_NAME || jsonTokenNextToken == JsonToken.END_OBJECT, jsonTokenNextToken);
                return jsonTokenNextToken;
            case START_ARRAY:
                return nextToken();
            default:
                return jsonTokenStartParsing;
        }
    }

    public final void parseAndClose(Object obj) throws IOException {
        parseAndClose(obj, (CustomizeJsonParser) null);
    }

    @Beta
    public final void parseAndClose(Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            parse(obj, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> T parse(Class<T> cls) throws IOException {
        return (T) parse((Class) cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> T parse(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        return (T) parse((Type) cls, false, customizeJsonParser);
    }

    public Object parse(Type type, boolean z) throws IOException {
        return parse(type, z, (CustomizeJsonParser) null);
    }

    @Beta
    public Object parse(Type type, boolean z, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                startParsing();
            }
            return parseValue(null, type, new ArrayList<>(), null, customizeJsonParser, true);
        } finally {
            if (z) {
                close();
            }
        }
    }

    public final void parse(Object obj) throws IOException {
        parse(obj, (CustomizeJsonParser) null);
    }

    @Beta
    public final void parse(Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(obj.getClass());
        parse(arrayList, obj, customizeJsonParser);
    }

    private void parse(ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        if (obj instanceof GenericJson) {
            ((GenericJson) obj).setFactory(getFactory());
        }
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        Class<?> cls = obj.getClass();
        ClassInfo classInfoM8976of = ClassInfo.m8976of(cls);
        boolean zIsAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (!zIsAssignableFrom && Map.class.isAssignableFrom(cls)) {
            parseMap(null, (Map) obj, Types.getMapValueParameter(cls), arrayList, customizeJsonParser);
            return;
        }
        while (jsonTokenStartParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (customizeJsonParser == null || !customizeJsonParser.stopAt(obj, text)) {
                FieldInfo fieldInfo = classInfoM8976of.getFieldInfo(text);
                if (fieldInfo != null) {
                    if (fieldInfo.isFinal() && !fieldInfo.isPrimitive()) {
                        throw new IllegalArgumentException("final array/object fields are not supported");
                    }
                    Field field = fieldInfo.getField();
                    int size = arrayList.size();
                    arrayList.add(field.getGenericType());
                    Object value = parseValue(field, fieldInfo.getGenericType(), arrayList, obj, customizeJsonParser, true);
                    arrayList.remove(size);
                    fieldInfo.setValue(obj, value);
                } else if (zIsAssignableFrom) {
                    ((GenericData) obj).set(text, parseValue(null, null, arrayList, obj, customizeJsonParser, true));
                } else {
                    if (customizeJsonParser != null) {
                        customizeJsonParser.handleUnrecognizedKey(obj, text);
                    }
                    skipChildren();
                }
                jsonTokenStartParsingObjectOrArray = nextToken();
            } else {
                return;
            }
        }
    }

    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2) throws IOException {
        return parseArrayAndClose(cls, cls2, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return parseArray(cls, cls2, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls) throws IOException {
        parseArrayAndClose(collection, cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            parseArray(collection, cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2) throws IOException {
        return parseArray(cls, cls2, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        Collection<T> collection = (Collection<T>) Data.newCollectionInstance(cls);
        parseArray(collection, cls2, customizeJsonParser);
        return collection;
    }

    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls) throws IOException {
        parseArray(collection, cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        parseArray(null, collection, cls, new ArrayList<>(), customizeJsonParser);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void parseArray(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        while (jsonTokenStartParsingObjectOrArray != JsonToken.END_ARRAY) {
            collection.add(parseValue(field, type, arrayList, collection, customizeJsonParser, true));
            jsonTokenStartParsingObjectOrArray = nextToken();
        }
    }

    private void parseMap(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        while (jsonTokenStartParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (customizeJsonParser == null || !customizeJsonParser.stopAt(map, text)) {
                map.put(text, parseValue(field, type, arrayList, map, customizeJsonParser, true));
                jsonTokenStartParsingObjectOrArray = nextToken();
            } else {
                return;
            }
        }
    }

    private final Object parseValue(Field field, Type type, ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser, boolean z) throws IOException {
        Type iterableParameter;
        Type typeResolveWildcardTypeOrTypeVariable = Data.resolveWildcardTypeOrTypeVariable(arrayList, type);
        Class<?> rawClass = typeResolveWildcardTypeOrTypeVariable instanceof Class ? (Class) typeResolveWildcardTypeOrTypeVariable : null;
        if (typeResolveWildcardTypeOrTypeVariable instanceof ParameterizedType) {
            rawClass = Types.getRawClass((ParameterizedType) typeResolveWildcardTypeOrTypeVariable);
        }
        if (rawClass == Void.class) {
            skipChildren();
            return null;
        }
        JsonToken currentToken = getCurrentToken();
        try {
            switch (getCurrentToken()) {
                case START_OBJECT:
                case FIELD_NAME:
                case END_OBJECT:
                    Preconditions.checkArgument(!Types.isArray(typeResolveWildcardTypeOrTypeVariable), "expected object or map type but got %s", typeResolveWildcardTypeOrTypeVariable);
                    Field cachedTypemapFieldFor = z ? getCachedTypemapFieldFor(rawClass) : null;
                    Object objNewMapInstance = null;
                    if (rawClass != null && customizeJsonParser != null) {
                        objNewMapInstance = customizeJsonParser.newInstanceForObject(obj, rawClass);
                    }
                    boolean z2 = rawClass != null && Types.isAssignableToOrFrom(rawClass, Map.class);
                    if (cachedTypemapFieldFor != null) {
                        objNewMapInstance = new GenericJson();
                    } else if (objNewMapInstance == null) {
                        if (z2 || rawClass == null) {
                            objNewMapInstance = Data.newMapInstance(rawClass);
                        } else {
                            objNewMapInstance = Types.newInstance(rawClass);
                        }
                    }
                    int size = arrayList.size();
                    if (typeResolveWildcardTypeOrTypeVariable != null) {
                        arrayList.add(typeResolveWildcardTypeOrTypeVariable);
                    }
                    if (z2 && !GenericData.class.isAssignableFrom(rawClass)) {
                        Type mapValueParameter = Map.class.isAssignableFrom(rawClass) ? Types.getMapValueParameter(typeResolveWildcardTypeOrTypeVariable) : null;
                        if (mapValueParameter != null) {
                            parseMap(field, (Map) objNewMapInstance, mapValueParameter, arrayList, customizeJsonParser);
                            return objNewMapInstance;
                        }
                    }
                    parse(arrayList, objNewMapInstance, customizeJsonParser);
                    if (typeResolveWildcardTypeOrTypeVariable != null) {
                        arrayList.remove(size);
                    }
                    if (cachedTypemapFieldFor != null) {
                        Object obj2 = ((GenericJson) objNewMapInstance).get(cachedTypemapFieldFor.getName());
                        Preconditions.checkArgument(obj2 != null, "No value specified for @JsonPolymorphicTypeMap field");
                        String string = obj2.toString();
                        Class<?> clsRef = null;
                        JsonPolymorphicTypeMap.TypeDef[] typeDefArrTypeDefinitions = ((JsonPolymorphicTypeMap) cachedTypemapFieldFor.getAnnotation(JsonPolymorphicTypeMap.class)).typeDefinitions();
                        int length = typeDefArrTypeDefinitions.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                JsonPolymorphicTypeMap.TypeDef typeDef = typeDefArrTypeDefinitions[i];
                                if (!typeDef.key().equals(string)) {
                                    i++;
                                } else {
                                    clsRef = typeDef.ref();
                                }
                            }
                        }
                        boolean z3 = clsRef != null;
                        String strValueOf = String.valueOf(string);
                        Preconditions.checkArgument(z3, strValueOf.length() != 0 ? "No TypeDef annotation found with key: ".concat(strValueOf) : new String("No TypeDef annotation found with key: "));
                        JsonFactory factory = getFactory();
                        JsonParser jsonParserCreateJsonParser = factory.createJsonParser(factory.toString(objNewMapInstance));
                        jsonParserCreateJsonParser.startParsing();
                        return jsonParserCreateJsonParser.parseValue(field, clsRef, arrayList, null, null, false);
                    }
                    return objNewMapInstance;
                case START_ARRAY:
                case END_ARRAY:
                    boolean zIsArray = Types.isArray(typeResolveWildcardTypeOrTypeVariable);
                    Preconditions.checkArgument(typeResolveWildcardTypeOrTypeVariable == null || zIsArray || (rawClass != null && Types.isAssignableToOrFrom(rawClass, Collection.class)), "expected collection or array type but got %s", typeResolveWildcardTypeOrTypeVariable);
                    Collection<Object> collectionNewCollectionInstance = null;
                    if (customizeJsonParser != null && field != null) {
                        collectionNewCollectionInstance = customizeJsonParser.newInstanceForArray(obj, field);
                    }
                    if (collectionNewCollectionInstance == null) {
                        collectionNewCollectionInstance = Data.newCollectionInstance(typeResolveWildcardTypeOrTypeVariable);
                    }
                    if (zIsArray) {
                        iterableParameter = Types.getArrayComponentType(typeResolveWildcardTypeOrTypeVariable);
                    } else if (rawClass == null || !Iterable.class.isAssignableFrom(rawClass)) {
                        iterableParameter = null;
                    } else {
                        iterableParameter = Types.getIterableParameter(typeResolveWildcardTypeOrTypeVariable);
                    }
                    Type typeResolveWildcardTypeOrTypeVariable2 = Data.resolveWildcardTypeOrTypeVariable(arrayList, iterableParameter);
                    parseArray(field, collectionNewCollectionInstance, typeResolveWildcardTypeOrTypeVariable2, arrayList, customizeJsonParser);
                    return zIsArray ? Types.toArray(collectionNewCollectionInstance, Types.getRawArrayComponentType(arrayList, typeResolveWildcardTypeOrTypeVariable2)) : collectionNewCollectionInstance;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    Preconditions.checkArgument(typeResolveWildcardTypeOrTypeVariable == null || rawClass == Boolean.TYPE || (rawClass != null && rawClass.isAssignableFrom(Boolean.class)), "expected type Boolean or boolean but got %s", typeResolveWildcardTypeOrTypeVariable);
                    return currentToken == JsonToken.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
                case VALUE_NUMBER_FLOAT:
                case VALUE_NUMBER_INT:
                    Preconditions.checkArgument(field == null || field.getAnnotation(JsonString.class) == null, "number type formatted as a JSON number cannot use @JsonString annotation");
                    if (rawClass == null || rawClass.isAssignableFrom(BigDecimal.class)) {
                        return getDecimalValue();
                    }
                    if (rawClass == BigInteger.class) {
                        return getBigIntegerValue();
                    }
                    if (rawClass == Double.class || rawClass == Double.TYPE) {
                        return Double.valueOf(getDoubleValue());
                    }
                    if (rawClass == Long.class || rawClass == Long.TYPE) {
                        return Long.valueOf(getLongValue());
                    }
                    if (rawClass == Float.class || rawClass == Float.TYPE) {
                        return Float.valueOf(getFloatValue());
                    }
                    if (rawClass == Integer.class || rawClass == Integer.TYPE) {
                        return Integer.valueOf(getIntValue());
                    }
                    if (rawClass == Short.class || rawClass == Short.TYPE) {
                        return Short.valueOf(getShortValue());
                    }
                    if (rawClass == Byte.class || rawClass == Byte.TYPE) {
                        return Byte.valueOf(getByteValue());
                    }
                    String strValueOf2 = String.valueOf(String.valueOf(typeResolveWildcardTypeOrTypeVariable));
                    throw new IllegalArgumentException(new StringBuilder(strValueOf2.length() + 30).append("expected numeric type but got ").append(strValueOf2).toString());
                case VALUE_STRING:
                    String lowerCase = getText().trim().toLowerCase(Locale.US);
                    if ((rawClass != Float.TYPE && rawClass != Float.class && rawClass != Double.TYPE && rawClass != Double.class) || (!lowerCase.equals("nan") && !lowerCase.equals("infinity") && !lowerCase.equals("-infinity"))) {
                        Preconditions.checkArgument((rawClass != null && Number.class.isAssignableFrom(rawClass) && (field == null || field.getAnnotation(JsonString.class) == null)) ? false : true, "number field formatted as a JSON string must use the @JsonString annotation");
                    }
                    return Data.parsePrimitiveValue(typeResolveWildcardTypeOrTypeVariable, getText());
                case VALUE_NULL:
                    Preconditions.checkArgument(rawClass == null || !rawClass.isPrimitive(), "primitive number field but found a JSON null");
                    if (rawClass != null && (rawClass.getModifiers() & 1536) != 0) {
                        if (Types.isAssignableToOrFrom(rawClass, Collection.class)) {
                            return Data.nullOf(Data.newCollectionInstance(typeResolveWildcardTypeOrTypeVariable).getClass());
                        }
                        if (Types.isAssignableToOrFrom(rawClass, Map.class)) {
                            return Data.nullOf(Data.newMapInstance(rawClass).getClass());
                        }
                    }
                    return Data.nullOf(Types.getRawArrayComponentType(arrayList, typeResolveWildcardTypeOrTypeVariable));
                default:
                    String strValueOf3 = String.valueOf(String.valueOf(currentToken));
                    throw new IllegalArgumentException(new StringBuilder(strValueOf3.length() + 27).append("unexpected JSON node type: ").append(strValueOf3).toString());
            }
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            String currentName = getCurrentName();
            if (currentName != null) {
                sb.append("key ").append(currentName);
            }
            if (field != null) {
                if (currentName != null) {
                    sb.append(", ");
                }
                sb.append("field ").append(field);
            }
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    private static Field getCachedTypemapFieldFor(Class<?> cls) {
        Field field;
        if (cls == null) {
            return null;
        }
        lock.lock();
        try {
            if (cachedTypemapFields.containsKey(cls)) {
                return cachedTypemapFields.get(cls);
            }
            Iterator<FieldInfo> it = ClassInfo.m8976of(cls).getFieldInfos().iterator();
            Field field2 = null;
            while (it.hasNext()) {
                Field field3 = it.next().getField();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) field3.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    Preconditions.checkArgument(field2 == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.checkArgument(Data.isPrimitive(field3.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, field3.getType());
                    JsonPolymorphicTypeMap.TypeDef[] typeDefArrTypeDefinitions = jsonPolymorphicTypeMap.typeDefinitions();
                    HashSet hashSetNewHashSet = Sets.newHashSet();
                    Preconditions.checkArgument(typeDefArrTypeDefinitions.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (JsonPolymorphicTypeMap.TypeDef typeDef : typeDefArrTypeDefinitions) {
                        Preconditions.checkArgument(hashSetNewHashSet.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                    }
                    field = field3;
                } else {
                    field = field2;
                }
                field2 = field;
            }
            cachedTypemapFields.put(cls, field2);
            lock.unlock();
            return field2;
        } finally {
            lock.unlock();
        }
    }
}
