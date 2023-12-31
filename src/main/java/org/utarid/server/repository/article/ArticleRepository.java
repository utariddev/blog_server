package org.utarid.server.repository.article;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.utarid.server.repository.author.AuthorEntity;

import java.util.List;

public interface ArticleRepository extends JpaRepository<AuthorEntity, Integer> {

    @Query("SELECT COUNT(b) FROM ArticleEntity b WHERE b.articleActive = '1'")
    long countActiveArticles();

    @Query("SELECT BAR FROM ArticleEntity BAR, AuthorEntity BAU, CategoryEntity BC, ImageEntity BI " +
            "WHERE BAR.articleAuthor.id = BAU.id " +
            "AND BAR.articleCategory.id = BC.id " +
            "AND BC.blogCategoryImage.id = BI.id " +
            "AND BAR.articleActive = '1' " +
            "ORDER BY BAR.articleUpdateDate DESC")
    List<ArticleEntity> findArticlesWithAuthorAndCategory(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE ArticleEntity y SET y.articleRead = y.articleRead + 1 WHERE y.articleWebTitle = :webTitle")
    void incrementArticleRead(@Param("webTitle") String webTitle);

    @Query("SELECT BAR FROM ArticleEntity BAR, AuthorEntity BAU, CategoryEntity BC, ImageEntity BI " +
            "WHERE BAR.articleAuthor.id = BAU.id " +
            "AND BAR.articleCategory.id = BC.id " +
            "AND BC.blogCategoryImage.id = BI.id " +
            "AND BAR.articleWebTitle = :pArticleTitle")
    ArticleEntity findArticlesByWebTitle(@Param("pArticleTitle") String pArticleTitle);
}
