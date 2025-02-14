package sn.ism.auchan.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.web.dto.response.CategorieAllResponse;

@Mapper
public interface CategorieMapper {
    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);
    // Conversion Entité > DTO
    CategorieAllResponse toDto(Categorie categorie);

    // Conversion DTO > Entité
    Categorie toEntity(CategorieAllResponse dto);
}
