package org.dubaichamber.dcmiddleware.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.dubaichamber.dcmiddleware.enums.LocaleEnum;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocaleUtil {

    public static LocaleEnum getLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        LocaleEnum localeEnum = LocaleEnum.getEnumByValue(locale.getLanguage());
        return localeEnum != null ? localeEnum : LocaleEnum.ENGLISH;
    }

}
