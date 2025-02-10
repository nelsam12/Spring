package sn.ism.auchan.devoir.dto.request;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class CommandeRequest {
    private LocalDateTime date;
    private double montant;

}
