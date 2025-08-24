package org.dubaichamber.dcmiddleware.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SiebelProcessNameEnum {
    CREATE_UPDATE_SR("DC Create Update SR Web WF"),
    GET_LIST_OF_VALUES("DC Get List Of Values WF"),

    ;

    private final String value;
}
