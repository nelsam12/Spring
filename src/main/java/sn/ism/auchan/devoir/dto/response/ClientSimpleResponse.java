package sn.ism.auchan.devoir.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ClientSimpleResponse {
    private String nomComplet;
    private String telephone;
}
