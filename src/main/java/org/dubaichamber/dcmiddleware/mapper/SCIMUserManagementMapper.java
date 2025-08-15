package org.dubaichamber.dcmiddleware.mapper;

import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ResetPasswordWsRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SCIMUserManagementMapper {
    String RESET_PASSWORD_SCHEMA = "urn:ietf:params:scim:api:messages:2.0:PatchOp";

    @Mapping(source = "newPassword", target = "operations", qualifiedByName = "mapResetOperation")
    @Mapping(source = ".", target = "schemas", qualifiedByName = "mapSchema")
    ResetPasswordWsRequestDTO mapRequest(String newPassword);

    @Named("mapSchema")
    default List<String> mapSchema(String ignored) {
        List<String> result = new ArrayList<>();
        result.add(RESET_PASSWORD_SCHEMA);
        return result;
    }

    @Named("mapResetOperation")
    default List<ResetPasswordWsRequestDTO.Operation> mapResetOperation(String newPassword) {
        List<ResetPasswordWsRequestDTO.Operation> operations = new ArrayList<>();
        ResetPasswordWsRequestDTO.Operation operation = new ResetPasswordWsRequestDTO.Operation();
        operation.setOp("replace");
        operation.getValue().setPassword(newPassword);
        operations.add(operation);
        return operations;
    }
}
