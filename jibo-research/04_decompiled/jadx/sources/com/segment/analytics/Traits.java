package com.segment.analytics;

import android.content.Context;
import com.segment.analytics.ValueMap;
import com.segment.analytics.internal.Utils;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class Traits extends ValueMap {
    private static final String ADDRESS_KEY = "address";
    private static final String AGE_KEY = "age";
    private static final String ANONYMOUS_ID_KEY = "anonymousId";
    private static final String AVATAR_KEY = "avatar";
    private static final String BIRTHDAY_KEY = "birthday";
    private static final String CREATED_AT_KEY = "createdAt";
    private static final String DESCRIPTION_KEY = "description";
    private static final String EMAIL_KEY = "email";
    private static final String EMPLOYEES_KEY = "employees";
    private static final String FAX_KEY = "fax";
    private static final String FIRST_NAME_KEY = "firstName";
    private static final String GENDER_KEY = "gender";
    private static final String INDUSTRY_KEY = "industry";
    private static final String LAST_NAME_KEY = "lastName";
    private static final String NAME_KEY = "name";
    private static final String PHONE_KEY = "phone";
    private static final String TITLE_KEY = "title";
    private static final String USERNAME_KEY = "username";
    private static final String USER_ID_KEY = "userId";
    private static final String WEBSITE_KEY = "website";

    static Traits create() {
        Traits traits = new Traits(new Utils.NullableConcurrentHashMap());
        traits.putAnonymousId(UUID.randomUUID().toString());
        return traits;
    }

    Traits(Map<String, Object> map) {
        super(map);
    }

    public Traits() {
    }

    public Traits(int i) {
        super(i);
    }

    public Traits unmodifiableCopy() {
        return new Traits((Map<String, Object>) Collections.unmodifiableMap(new LinkedHashMap(this)));
    }

    Traits putUserId(String str) {
        return putValue(USER_ID_KEY, (Object) str);
    }

    public String userId() {
        return getString(USER_ID_KEY);
    }

    Traits putAnonymousId(String str) {
        return putValue(ANONYMOUS_ID_KEY, (Object) str);
    }

    public String anonymousId() {
        return getString(ANONYMOUS_ID_KEY);
    }

    public String currentId() {
        String strUserId = userId();
        return Utils.isNullOrEmpty(strUserId) ? anonymousId() : strUserId;
    }

    public Traits putAddress(Address address) {
        return putValue(ADDRESS_KEY, (Object) address);
    }

    public Address address() {
        return (Address) getValueMap(ADDRESS_KEY, Address.class);
    }

    public Traits putAge(int i) {
        return putValue(AGE_KEY, (Object) Integer.valueOf(i));
    }

    public int age() {
        return getInt(AGE_KEY, 0);
    }

    public Traits putAvatar(String str) {
        return putValue("avatar", (Object) str);
    }

    public String avatar() {
        return getString("avatar");
    }

    public Traits putBirthday(Date date) {
        return putValue("birthday", (Object) Utils.toISO8601Date(date));
    }

    public Date birthday() {
        try {
            String string = getString("birthday");
            if (Utils.isNullOrEmpty(string)) {
                return null;
            }
            return Utils.toISO8601Date(string);
        } catch (ParseException e) {
            return null;
        }
    }

    public Traits putCreatedAt(String str) {
        return putValue(CREATED_AT_KEY, (Object) str);
    }

    public String createdAt() {
        return getString(CREATED_AT_KEY);
    }

    public Traits putDescription(String str) {
        return putValue("description", (Object) str);
    }

    public String description() {
        return getString("description");
    }

    public Traits putEmail(String str) {
        return putValue(EMAIL_KEY, (Object) str);
    }

    public String email() {
        return getString(EMAIL_KEY);
    }

    public Traits putEmployees(long j) {
        return putValue(EMPLOYEES_KEY, (Object) Long.valueOf(j));
    }

    public long employees() {
        return getLong(EMPLOYEES_KEY, 0L);
    }

    public Traits putFax(String str) {
        return putValue(FAX_KEY, (Object) str);
    }

    public String fax() {
        return getString(FAX_KEY);
    }

    public Traits putFirstName(String str) {
        return putValue(FIRST_NAME_KEY, (Object) str);
    }

    public String firstName() {
        return getString(FIRST_NAME_KEY);
    }

    public Traits putGender(String str) {
        return putValue(GENDER_KEY, (Object) str);
    }

    public String gender() {
        return getString(GENDER_KEY);
    }

    public Traits putIndustry(String str) {
        return putValue(INDUSTRY_KEY, (Object) str);
    }

    public String industry() {
        return getString(INDUSTRY_KEY);
    }

    public Traits putLastName(String str) {
        return putValue(LAST_NAME_KEY, (Object) str);
    }

    public String lastName() {
        return getString(LAST_NAME_KEY);
    }

    public Traits putName(String str) {
        return putValue("name", (Object) str);
    }

    public String name() {
        String string = getString("name");
        if (Utils.isNullOrEmpty(string) && Utils.isNullOrEmpty(firstName()) && Utils.isNullOrEmpty(lastName())) {
            return null;
        }
        if (Utils.isNullOrEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            String strFirstName = firstName();
            boolean z = false;
            if (!Utils.isNullOrEmpty(strFirstName)) {
                z = true;
                sb.append(strFirstName);
            }
            String strLastName = lastName();
            if (!Utils.isNullOrEmpty(strLastName)) {
                if (z) {
                    sb.append(TokenParser.f15715SP);
                }
                sb.append(strLastName);
            }
            return sb.toString();
        }
        return string;
    }

    public Traits putPhone(String str) {
        return putValue(PHONE_KEY, (Object) str);
    }

    public String phone() {
        return getString(PHONE_KEY);
    }

    public Traits putTitle(String str) {
        return putValue("title", (Object) str);
    }

    public String title() {
        return getString("title");
    }

    public Traits putUsername(String str) {
        return putValue(USERNAME_KEY, (Object) str);
    }

    public String username() {
        return getString(USERNAME_KEY);
    }

    public Traits putWebsite(String str) {
        return putValue(WEBSITE_KEY, (Object) str);
    }

    public String website() {
        return getString(WEBSITE_KEY);
    }

    @Override // com.segment.analytics.ValueMap
    public Traits putValue(String str, Object obj) {
        super.putValue(str, obj);
        return this;
    }

    public static class Address extends ValueMap {
        private static final String ADDRESS_CITY_KEY = "city";
        private static final String ADDRESS_COUNTRY_KEY = "country";
        private static final String ADDRESS_POSTAL_CODE_KEY = "postalCode";
        private static final String ADDRESS_STATE_KEY = "state";
        private static final String ADDRESS_STREET_KEY = "street";

        public Address() {
        }

        public Address(Map<String, Object> map) {
            super(map);
        }

        @Override // com.segment.analytics.ValueMap
        public Address putValue(String str, Object obj) {
            super.putValue(str, obj);
            return this;
        }

        public Address putCity(String str) {
            return putValue("city", (Object) str);
        }

        public String city() {
            return getString("city");
        }

        public Address putCountry(String str) {
            return putValue("country", (Object) str);
        }

        public String country() {
            return getString("country");
        }

        public Address putPostalCode(String str) {
            return putValue(ADDRESS_POSTAL_CODE_KEY, (Object) str);
        }

        public String postalCode() {
            return getString(ADDRESS_POSTAL_CODE_KEY);
        }

        public Address putState(String str) {
            return putValue("state", (Object) str);
        }

        public String state() {
            return getString("state");
        }

        public Address putStreet(String str) {
            return putValue(ADDRESS_STREET_KEY, (Object) str);
        }

        public String street() {
            return getString(ADDRESS_STREET_KEY);
        }
    }

    static class Cache extends ValueMap.Cache<Traits> {
        private static final String TRAITS_CACHE_PREFIX = "traits-";

        @Override // com.segment.analytics.ValueMap.Cache
        public /* bridge */ /* synthetic */ ValueMap create(Map map) {
            return create((Map<String, Object>) map);
        }

        Cache(Context context, Cartographer cartographer, String str) {
            super(context, cartographer, TRAITS_CACHE_PREFIX + str, str, Traits.class);
        }

        @Override // com.segment.analytics.ValueMap.Cache
        public Traits create(Map<String, Object> map) {
            return new Traits(new Utils.NullableConcurrentHashMap(map));
        }
    }
}
