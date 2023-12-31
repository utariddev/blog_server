package org.utarid.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.utarid.server.dto.article.ArticleDTO;
import org.utarid.server.dto.category.CategoryDTO;
import org.utarid.server.dto.constant.ConstantDTO;
import org.utarid.server.repository.article.ArticleEntity;
import org.utarid.server.repository.category.CategoryEntity;
import org.utarid.server.repository.contant.ConstantEntity;

@Mapper
public interface UtaridMapper {
    UtaridMapper INSTANCE = Mappers.getMapper(UtaridMapper.class);

    @Mapping(source = "blogCategoryImage.imagePath", target = "imagePath")
    @Mapping(source = "blogCategoryName", target = "blogCategoryName")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "blogCategoryImage.id", target = "blogCategoryImageId")
    CategoryDTO categoryEntityToCategoryDTO(CategoryEntity entity);

    @Mapping(source = "articleCategory.id", target = "articleCategory")
    @Mapping(source = "articleCategory.blogCategoryName", target = "blogCategoryName")
    @Mapping(source = "articleAuthor.id", target = "articleAuthor")
    @Mapping(source = "articleAuthor.authorName", target = "authorName")
    @Mapping(source = "articleAuthor.authorImage", target = "authorImage")
    @Mapping(source = "articleActive", target = "isActive")
    @Mapping(source = "articleDate", target = "articleDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "articleUpdateDate", target = "articleUpdateDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "articleCategory.blogCategoryImage.id", target = "blogCategoryImageId")
    ArticleDTO articleEntityToArticleDTO(ArticleEntity entity);


    ConstantDTO constantEntityToConstantDTO(ConstantEntity entity);
}
