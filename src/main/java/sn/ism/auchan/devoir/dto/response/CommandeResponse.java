package sn.ism.auchan.devoir.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CommandeResponse {
    private LocalDateTime date;
    private double montant;
}
