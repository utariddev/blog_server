package org.utarid.server.repository.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.utarid.server.repository.author.AuthorEntity;

public interface ArticleRepository extends JpaRepository<AuthorEntity, Integer> {

    @Query("SELECT COUNT(b) FROM ArticleEntity b WHERE b.articleActive = '1'")
    long countActiveArticles();
}
