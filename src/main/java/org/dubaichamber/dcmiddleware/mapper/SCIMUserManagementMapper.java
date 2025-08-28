package org.dubaichamber.dcmiddleware.mapper;

import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ResetPasswordWsRequestDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
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
        ResetPasswordWsRequestDTO.Value value = new ResetPasswordWsRequestDTO.Value();
        value.setPassword(newPassword);
        operation.setValue(value);
        operations.add(operation);
        return operations;
    }

    default SimpleUserResponseDTO mapToSimpleUserResponse(ScimUserListWsResponseDTO.Resource resource) {
        if (resource == null) return null;

        SimpleUserResponseDTO dto = new SimpleUserResponseDTO();
        dto.setId(resource.getId());
        dto.setUserName(resource.getUserName());
        dto.setFirstName(resource.getName() != null ? resource.getName().givenName() : null);
        dto.setLastName(resource.getName() != null ? resource.getName().familyName() : null);
        dto.setEmail(resource.getEmails() != null && !resource.getEmails().isEmpty() ? resource.getEmails().get(0) : null);
        dto.setMobile(resource.getPhoneNumbers() != null && !resource.getPhoneNumbers().isEmpty()
                ? resource.getPhoneNumbers().stream()
                .filter(p -> "mobile".equalsIgnoreCase(p.type()))
                .findFirst()
                .map(p -> p.value())
                .orElse(null)
                : null);
        dto.setCountry(resource.getEnterpriseUserExtension() != null ? resource.getEnterpriseUserExtension().country() : null);
        dto.setTitle(resource.getTitle());
        return dto;
    }

    default List<SimpleUserResponseDTO> mapToSimpleUserResponseList(List<ScimUserListWsResponseDTO.Resource> resources) {
        List<SimpleUserResponseDTO> list = new ArrayList<>();
        if (resources != null) {
            for (ScimUserListWsResponseDTO.Resource res : resources) {
                list.add(mapToSimpleUserResponse(res));
            }
        }
        return list;
    }
}
