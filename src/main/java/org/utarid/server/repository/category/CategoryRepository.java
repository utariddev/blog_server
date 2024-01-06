package org.utarid.server.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Query("SELECT BC FROM CategoryEntity BC JOIN FETCH BC.blogCategoryImage BI WHERE BC.isActive = 1")
    List<CategoryEntity> findActiveCategoriesWithImages();
}
