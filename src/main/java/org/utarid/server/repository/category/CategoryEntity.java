package org.utarid.server.repository.category;

import jakarta.persistence.*;
import org.utarid.server.repository.image.ImageEntity;

@Entity
@Table(name = "blog_category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "blog_category_name")
    private String blogCategoryName;

    @Column(name = "isActive")
    private Integer isActive;

    @ManyToOne
    @JoinColumn(name = "blog_category_image_id")
    private ImageEntity blogCategoryImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public ImageEntity getBlogCategoryImage() {
        return blogCategoryImage;
    }

    public void setBlogCategoryImage(ImageEntity blogCategoryImage) {
        this.blogCategoryImage = blogCategoryImage;
    }
}
