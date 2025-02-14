package sn.ism.auchan.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.web.dto.response.ArticleAllResponse;
import sn.ism.auchan.web.dto.response.ArticleOneResponse;

@Mapper
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
    // Conversion Entité > DTO
    ArticleAllResponse toDto(Article article);
    ArticleOneResponse toDto2(Article article);
    // Conversion DTO > Entité
    Article toEntity(ArticleAllResponse dto);
}
