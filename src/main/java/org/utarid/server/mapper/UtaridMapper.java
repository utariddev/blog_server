package org.utarid.server.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.utarid.server.dto.article.ArticleDTO;
import org.utarid.server.dto.category.CategoryDTO;
import org.utarid.server.dto.constant.ConstantDTO;
import org.utarid.server.repository.article.ArticleEntity;
import org.utarid.server.repository.category.CategoryEntity;
import org.utarid.server.repository.constant.ConstantEntity;

@Mapper
public interface UtaridMapper {
    UtaridMapper INSTANCE = Mappers.getMapper(UtaridMapper.class);

    @Mapping(source = "blogCategoryImage.imagePath", target = "imagePath")
    @Mapping(source = "blogCategoryName", target = "blogCategoryName")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "blogCategoryImage.id", target = "blogCategoryImageId")
    CategoryDTO categoryEntityToCategoryDTO(CategoryEntity entity);

    @Mapping(ignore = true, target = "articleText")
    @Mapping(source = "entity.articleCategory.id", target = "articleCategory")
    @Mapping(source = "entity.articleCategory.blogCategoryName", target = "blogCategoryName")
    @Mapping(source = "entity.articleAuthor.id", target = "articleAuthor")
    @Mapping(source = "entity.articleAuthor.authorName", target = "authorName")
    @Mapping(source = "entity.articleAuthor.authorImage", target = "authorImage")
    @Mapping(source = "entity.articleActive", target = "isActive")
    @Mapping(source = "entity.articleDate", target = "articleDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "entity.articleUpdateDate", target = "articleUpdateDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "entity.articleCategory.blogCategoryImage.id", target = "blogCategoryImageId")
    ArticleDTO articleEntityToArticleDTO(ArticleEntity entity, boolean includeText);

    @AfterMapping
    default void handlePassword(ArticleEntity user, @MappingTarget ArticleDTO dto, boolean includeText) {
        if (includeText) {
            dto.setArticleText(user.getArticleText());
        }
    }


    ConstantDTO constantEntityToConstantDTO(ConstantEntity entity);
}
