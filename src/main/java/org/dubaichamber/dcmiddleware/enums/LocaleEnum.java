package org.dubaichamber.dcmiddleware.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocaleEnum {
    ENGLISH("en", "ENU"),
    ARABIC("ar", "ARA"),
    ;

    private final String value;
    private final String sibelLanguageCode;

    public static LocaleEnum getEnumByValue(String value){
        for(LocaleEnum e : LocaleEnum.values()){
            if(e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }
}