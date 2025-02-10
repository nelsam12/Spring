package sn.ism.auchan.devoir.dto.response;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Builder
public class ClientResponseWithCommandes {
    private ClientSimpleResponse client;
    private List<CommandeResponse> commandes;
    private int totalPage;
    private int totalItems;
    private int currentPage;
}
