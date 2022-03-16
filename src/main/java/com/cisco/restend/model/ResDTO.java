package com.cisco.restend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResDTO {
    private Integer resultCode;
    private String resultDescription;
    private List<UserDTO> data;

    public ResDTO(Integer resultCode, String resultDescription) {
        this.resultCode = resultCode;
        this.resultDescription = resultDescription;
    }
}
