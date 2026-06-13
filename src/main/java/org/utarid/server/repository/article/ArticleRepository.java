package org.utarid.server.repository.article;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

    @Query("SELECT BAR FROM ArticleEntity BAR " +
            "JOIN AuthorEntity BAU ON BAR.articleAuthor.id = BAU.id " +
            "JOIN CategoryEntity BC ON BAR.articleCategory.id = BC.id " +
            "JOIN ImageEntity BI ON BC.blogCategoryImage.id = BI.id " +
            "WHERE BAR.articleActive = '1' " +
            "AND (BAR.articleTitle ILIKE %:query% " +
            "     OR BAR.articleText ILIKE %:query% " +
            "     OR BAR.articleSummary ILIKE %:query% " +
            "     OR BAR.articleWebTitle ILIKE %:query% " +
            "     OR BAU.authorName ILIKE %:query% " +
            "     OR BC.blogCategoryName ILIKE %:query%) " +
            "ORDER BY BAR.articleUpdateDate DESC")
    List<ArticleEntity> searchArticles(@Param("query") String query, Pageable pageable);

    @Query("SELECT COUNT(BAR) FROM ArticleEntity BAR " +
            "JOIN AuthorEntity BAU ON BAR.articleAuthor.id = BAU.id " +
            "JOIN CategoryEntity BC ON BAR.articleCategory.id = BC.id " +
            "WHERE BAR.articleActive = '1' " +
            "AND (BAR.articleTitle ILIKE %:query% " +
            "     OR BAR.articleText ILIKE %:query% " +
            "     OR BAR.articleSummary ILIKE %:query% " +
            "     OR BAR.articleWebTitle ILIKE %:query% " +
            "     OR BAU.authorName ILIKE %:query% " +
            "     OR BC.blogCategoryName ILIKE %:query%)")
    long countSearchArticles(@Param("query") String query);

    @Query("SELECT BAR.articleWebTitle, BAR.articleTitle, BC.blogCategoryName " +
            "FROM ArticleEntity BAR " +
            "JOIN CategoryEntity BC ON BAR.articleCategory.id = BC.id " +
            "WHERE BAR.articleActive = '1' " +
            "AND (BAR.articleTitle ILIKE %:query% OR BAR.articleWebTitle ILIKE %:query%) " +
            "ORDER BY BAR.articleRead DESC")
    List<Object[]> findTitleSuggestions(@Param("query") String query, Pageable pageable);

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

    @Query("SELECT BAR FROM ArticleEntity BAR " +
            "JOIN AuthorEntity BAU ON BAR.articleAuthor.id = BAU.id " +
            "JOIN CategoryEntity BC ON BAR.articleCategory.id = BC.id " +
            "JOIN ImageEntity BI ON BC.blogCategoryImage.id = BI.id " +
            "WHERE BC.blogCategoryName = :pCategoryName " +
            "AND BAR.articleActive = '1' " +
            "ORDER BY BAR.id DESC")
    List<ArticleEntity> findArticlesByCategory(@Param("pCategoryName") String pCategoryName);

    @Query("SELECT BAR " +
            "FROM ArticleEntity BAR " +
            "JOIN AuthorEntity BAU ON BAR.articleAuthor.id = BAU.id " +
            "JOIN CategoryEntity BC ON BAR.articleCategory.id = BC.id " +
            "JOIN ImageEntity BI ON BC.blogCategoryImage.id = BI.id " +
            "ORDER BY BAR.articleRead DESC")
    List<ArticleEntity> findMostReadArticles(Pageable pageable);
}
