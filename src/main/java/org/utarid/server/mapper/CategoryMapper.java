package org.utarid.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.utarid.server.dto.CategoryDTO;
import org.utarid.server.repository.category.CategoryEntity;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "blogCategoryImage.imagePath", target = "imagePath")
    @Mapping(source = "blogCategoryName", target = "blogCategoryName")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "blogCategoryImage.id", target = "blogCategoryImageId")
    CategoryDTO categoryEntityToCategoryDTO(CategoryEntity entity);
}
