package org.dubaichamber.dcmiddleware.dto.scimusermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordWsRequestDTO {
    public List<String> schemas;
    @JsonProperty("Operations")
    public List<Operation> operations;

    @Data
    public static class Operation {
        public String op;
        public Value value;
    }

    @Data
    public static class Value {
        public String password;
    }
}
