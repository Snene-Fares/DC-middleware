package org.dubaichamber.dcmiddleware.config;

import jakarta.servlet.http.HttpServletRequest;
import org.dubaichamber.dcmiddleware.enums.LocaleEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Configuration
public class LocaleConfig extends AcceptHeaderLocaleResolver {
    private final List<Locale> locales;

    public LocaleConfig() {
        locales = Arrays.stream(LocaleEnum.values()).map(LocaleEnum::getValue).map(Locale::new).collect(Collectors.toList());
        Locale.setDefault(new Locale(LocaleEnum.ENGLISH.getValue()));
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        if (headerLang == null || headerLang.isEmpty()) {
            return Locale.getDefault();
        } else {
            return Locale.lookup(Locale.LanguageRange.parse(headerLang), locales);
        }
    }

}