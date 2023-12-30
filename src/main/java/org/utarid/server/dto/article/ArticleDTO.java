package org.utarid.server.dto.article;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleDTO {
    @JsonProperty("article_category")
    private String articleCategory;

    @JsonProperty("author_name")
    private String authorName;

    @JsonProperty("article_read")
    private String articleRead;

    @JsonProperty("article_mobile_active")
    private String articleMobileActive;

    @JsonProperty("article_active")
    private String articleActive;

    @JsonProperty("article_mobile_markdown")
    private String articleMobileMarkdown;

    @JsonProperty("article_text")
    private String articleText;

    @JsonProperty("blog_category_name")
    private String blogCategoryName;

    @JsonProperty("article_web_title")
    private String articleWebTitle;

    @JsonProperty("isActive")
    private String isActive;

    @JsonProperty("author_image")
    private String authorImage;

    @JsonProperty("article_date")
    private String articleDate;

    @JsonProperty("blog_category_image_id")
    private String blogCategoryImageId;

    @JsonProperty("article_image")
    private String articleImage;

    @JsonProperty("article_title")
    private String articleTitle;

    @JsonProperty("article_author")
    private String articleAuthor;

    @JsonProperty("image_path")
    private String imagePath;

    @JsonProperty("article_summary")
    private String articleSummary;

    @JsonProperty("id")
    private String id;

    @JsonProperty("article_like")
    private String articleLike;

    @JsonProperty("article_update_date")
    private String articleUpdateDate;

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getArticleRead() {
        return articleRead;
    }

    public void setArticleRead(String articleRead) {
        this.articleRead = articleRead;
    }

    public String getArticleMobileActive() {
        return articleMobileActive;
    }

    public void setArticleMobileActive(String articleMobileActive) {
        this.articleMobileActive = articleMobileActive;
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

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getArticleWebTitle() {
        return articleWebTitle;
    }

    public void setArticleWebTitle(String articleWebTitle) {
        this.articleWebTitle = articleWebTitle;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getBlogCategoryImageId() {
        return blogCategoryImageId;
    }

    public void setBlogCategoryImageId(String blogCategoryImageId) {
        this.blogCategoryImageId = blogCategoryImageId;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(String articleLike) {
        this.articleLike = articleLike;
    }

    public String getArticleUpdateDate() {
        return articleUpdateDate;
    }

    public void setArticleUpdateDate(String articleUpdateDate) {
        this.articleUpdateDate = articleUpdateDate;
    }
}