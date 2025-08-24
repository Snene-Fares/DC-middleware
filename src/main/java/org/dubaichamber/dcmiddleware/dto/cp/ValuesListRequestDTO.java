package org.dubaichamber.dcmiddleware.dto.cp;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValuesListRequestDTO {
    @NotNull
    @NotEmpty
    private String type;
    private String parentValue;
    private String subType;
}
