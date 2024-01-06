package org.utarid.server.repository.article;

import jakarta.persistence.*;
import org.utarid.server.repository.author.AuthorEntity;
import org.utarid.server.repository.category.CategoryEntity;

import java.util.Date;

@Entity
@Table(name = "blog_article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "article_text", columnDefinition = "LONGTEXT")
    private String articleText;

    @Column(name = "article_date")
    private Date articleDate;

    @ManyToOne
    @JoinColumn(name = "article_author")
    private AuthorEntity articleAuthor;

    @ManyToOne
    @JoinColumn(name = "article_category")
    private CategoryEntity articleCategory;

    @Column(name = "article_like")
    private int articleLike;

    @Column(name = "article_summary")
    private String articleSummary;

    @Column(name = "article_image")
    private String articleImage;

    @Column(name = "article_read")
    private int articleRead;

    @Column(name = "article_active")
    private String articleActive;

    @Column(name = "article_mobile_markdown", columnDefinition = "LONGTEXT")
    private String articleMobileMarkdown;

    @Column(name = "article_mobile_active", columnDefinition = "LONGTEXT")
    private String articleMobileActive;

    @Column(name = "article_web_title")
    private String articleWebTitle;

    @Column(name = "article_update_date")
    private Date articleUpdateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public AuthorEntity getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(AuthorEntity articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public CategoryEntity getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(CategoryEntity articleCategory) {
        this.articleCategory = articleCategory;
    }

    public int getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(int articleLike) {
        this.articleLike = articleLike;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public int getArticleRead() {
        return articleRead;
    }

    public void setArticleRead(int articleRead) {
        this.articleRead = articleRead;
    }

    public String getArticleActive() {
        return articleActive;
    }

    public void setArticleActive(String articleActive) {
        this.articleActive = articleActive;
    }

    public String getArticleMobileMarkdown() {
        return articleMobileMarkdown;
    }

    public void setArticleMobileMarkdown(String articleMobileMarkdown) {
        this.articleMobileMarkdown = articleMobileMarkdown;
    }

    public String getArticleMobileActive() {
        return articleMobileActive;
    }

    public void setArticleMobileActive(String articleMobileActive) {
        this.articleMobileActive = articleMobileActive;
    }

    public String getArticleWebTitle() {
        return articleWebTitle;
    }

    public void setArticleWebTitle(String articleWebTitle) {
        this.articleWebTitle = articleWebTitle;
    }

    public Date getArticleUpdateDate() {
        return articleUpdateDate;
    }

    public void setArticleUpdateDate(Date articleUpdateDate) {
        this.articleUpdateDate = articleUpdateDate;
    }
}
