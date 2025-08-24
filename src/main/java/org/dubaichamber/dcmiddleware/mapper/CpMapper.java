package org.dubaichamber.dcmiddleware.mapper;

import org.dubaichamber.dcmiddleware.dto.cp.ValuesListRequestDTO;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListWsRequestDTO;
import org.dubaichamber.dcmiddleware.enums.SiebelProcessNameEnum;
import org.dubaichamber.dcmiddleware.util.LocaleUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports =  {LocaleUtil.class, SiebelProcessNameEnum.class})
public interface CpMapper {

    @Mapping(target = "body.languageCode" , expression = "java(LocaleUtil.getLocale().getSibelLanguageCode())")
    @Mapping(target = "body.processName" , expression = "java(SiebelProcessNameEnum.GET_LIST_OF_VALUES.getValue())")
    @Mapping(source = "subType", target = "body.subType")
    @Mapping(source = "type", target = "body.type")
    @Mapping(source = "parentValue", target = "body.parentValue")
    ValuesListWsRequestDTO mapValuesListRequest(ValuesListRequestDTO request);


}
