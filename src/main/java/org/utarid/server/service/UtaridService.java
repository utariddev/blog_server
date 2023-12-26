package org.utarid.server.service;

import org.springframework.stereotype.Service;
import org.utarid.server.dto.CategoryDTO;
import org.utarid.server.dto.GetCategoriesResponseDTO;
import org.utarid.server.mapper.CategoryMapper;
import org.utarid.server.repository.category.CategoryEntity;
import org.utarid.server.repository.category.CategoryRepository;

import java.util.List;

@Service
public class UtaridService {

    private final CategoryRepository categoryRepository;

    public UtaridService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public GetCategoriesResponseDTO getCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findActiveCategoriesWithImages();
        List<CategoryDTO> categoryDTOList = categoryEntityList.stream().map(CategoryMapper.INSTANCE::categoryEntityToCategoryDTO).toList();
        return new GetCategoriesResponseDTO(new GetCategoriesResponseDTO.Result("success", "1"), categoryDTOList);
    }
}
