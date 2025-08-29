package org.dubaichamber.dcmiddleware.dto.scimusermanagement;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UpdateUserRequestDTO {
    private List<OperationDTO> Operations;
    private List<String> schemas;

    @Data
    public static class OperationDTO {
        private String op;
        private String path;
        private Object value;
    }
}
