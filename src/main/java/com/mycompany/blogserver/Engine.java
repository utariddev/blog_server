package com.mycompany.blogserver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;

/**
 *
 * @author ekcdr
 */
public class Engine {

    @Inject
    private DatabaseManager databaseManager;

    public ArrayList<HashMap<String, String>> getCategories() throws ClassNotFoundException, SQLException {
        return databaseManager.getCategories();
    }

    public ArrayList<HashMap<String, String>> getArticles(String indicator) throws ClassNotFoundException, SQLException {
        return databaseManager.getArticles(indicator);
    }

    public ArrayList<HashMap<String, String>> getArticle(String articleID) throws ClassNotFoundException, SQLException {
        return databaseManager.getArticle(articleID);
    }

    public ArrayList<HashMap<String, String>> getMostReadArticles() throws ClassNotFoundException, SQLException {
        return databaseManager.getMostReadArticles();
    }

    public ArrayList<HashMap<String, String>> getCategoryArticles(String categoryName) throws ClassNotFoundException, SQLException {
        return databaseManager.getCategoryArticles(categoryName);
    }

    public int getArticlesCount() throws ClassNotFoundException, SQLException {
        return databaseManager.getArticlesCount();
    }
}
