package sn.ism.auchan.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.devoir.dto.response.ClientSimpleResponse;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    // Conversion Entité > DTO
    sn.ism.auchan.web.dto.response.ClientSimpleResponse toDto(Client client);

    // Conversion DTO > Entité
    Client toEntity(ClientSimpleResponse dto);
}
