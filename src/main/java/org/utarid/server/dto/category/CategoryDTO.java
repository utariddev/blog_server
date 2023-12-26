package org.utarid.server.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDTO {

    @JsonProperty("image_path")
    private String imagePath;

    @JsonProperty("blog_category_name")
    private String blogCategoryName;

    @JsonProperty("id")
    private String id;

    @JsonProperty("isActive")
    private String isActive;

    @JsonProperty("blog_category_image_id")
    private String blogCategoryImageId;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getBlogCategoryImageId() {
        return blogCategoryImageId;
    }

    public void setBlogCategoryImageId(String blogCategoryImageId) {
        this.blogCategoryImageId = blogCategoryImageId;
    }
}
