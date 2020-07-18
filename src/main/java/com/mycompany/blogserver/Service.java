package com.mycompany.blogserver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ekcdr
 */
@Path("/message")
public class Service {

    @Inject
    private Engine engine;

    @POST
    @Path("/testPost")
    public String testPost(String str) {
        LoggerLib.Logger.print("testPost");
        return "testPost : " + str;
    }

    @GET
    @Path("/testGet")
    public String testGet() {
        return "hello from blog server";
    }

    @POST
    @Path("/getArticles")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticles(String json) {
        LoggerLib.Logger.print("getArticles");

        Result res = new Result();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.createObjectNode();
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

        try {
            JsonNode node = objectMapper.readValue(json, JsonNode.class);

            JsonNode indicatorNode = node.get("indicator");
            if (indicatorNode != null) {
                String indicator = node.get("indicator").textValue();
                dataArray = engine.getArticles(indicator);
            } else {
                throw new Exception("no indicator in json");
            }

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            JsonNode userJsonNode = objectMapper.convertValue(dataArray, JsonNode.class);
            ((ObjectNode) rootNode).set("data", userJsonNode);

            return rootNode.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLES_CLASS_NOT_FOUND_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLES_CLASS_NOT_FOUND_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLES_SQL_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLES_SQL_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLES_IO_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLES_IO_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLES_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLES_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        }
    }

    @POST
    @Path("/getMostReadArticles")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getMostReadArticles(String json) {
        LoggerLib.Logger.print("getMostReadArticles");

        Result res = new Result();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.createObjectNode();
        ArrayList<HashMap<String, String>> dataArray;

        try {
            dataArray = engine.getMostReadArticles();

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            JsonNode userJsonNode = objectMapper.convertValue(dataArray, JsonNode.class);
            ((ObjectNode) rootNode).set("data", userJsonNode);

            return rootNode.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_MOST_READ_ARTICLES_CLASS_NOT_FOUND_EX);
            res.setDesc(Constant.RESULT_DESC_GET_MOST_READ_ARTICLES_CLASS_NOT_FOUND_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_MOST_READ_ARTICLES_SQL_EX);
            res.setDesc(Constant.RESULT_DESC_GET_MOST_READ_ARTICLES_SQL_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_MOST_READ_ARTICLES_EX);
            res.setDesc(Constant.RESULT_DESC_GET_MOST_READ_ARTICLES_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        }
    }

    @POST
    @Path("/getArticle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticle(String json) {
        LoggerLib.Logger.print("getArticle");

        Result res = new Result();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.createObjectNode();
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

        try {
            JsonNode node = objectMapper.readValue(json, JsonNode.class);

            JsonNode indicatorNode = node.get("articleID");
            if (indicatorNode != null) {
                String indicator = indicatorNode.textValue();
                dataArray = engine.getArticle(indicator);
            } else {
                throw new Exception("no articleID in json");
            }

            if (dataArray.isEmpty()) {
                res.setCode(Constant.RESULT_CODE_GET_ARTICLE_NO_ARTICLE_FOUND);
                res.setDesc(Constant.RESULT_DESC_GET_ARTICLE_NO_ARTICLE_FOUND);

                JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
                ((ObjectNode) rootNode).set("result", resJsonNode);
            } else {
                JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
                ((ObjectNode) rootNode).set("result", resJsonNode);

                JsonNode userJsonNode = objectMapper.convertValue(dataArray, JsonNode.class);
                ((ObjectNode) rootNode).set("data", userJsonNode);
            }

            return rootNode.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLE_CLASS_NOT_FOUND_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLE_CLASS_NOT_FOUND_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLE_SQL_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLE_SQL_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLE_IO_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLE_IO_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLE_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLE_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        }
    }

    @POST
    @Path("/getCategories")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategories() {
        LoggerLib.Logger.print("getCategories");

        Result res = new Result();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.createObjectNode();
        ArrayList<HashMap<String, String>> dataArray;

        try {
            dataArray = engine.getCategories();

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            JsonNode userJsonNode = objectMapper.convertValue(dataArray, JsonNode.class);
            ((ObjectNode) rootNode).set("data", userJsonNode);

            return rootNode.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_CATEGORIES_CLASS_NOT_FOUND_EX);
            res.setDesc(Constant.RESULT_DESC_GET_CATEGORIES_CLASS_NOT_FOUND_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_CATEGORIES_SQL_EX);
            res.setDesc(Constant.RESULT_DESC_GET_CATEGORIES_SQL_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        }
    }

    @POST
    @Path("/getArticlesCount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticlesCount() {
        LoggerLib.Logger.print("getArticlesCount");

        Result res = new Result();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.createObjectNode();

        try {
            int articleCount = engine.getArticlesCount();
            HashMap<String, String> data = new HashMap<>();
            data.put("count", String.valueOf(articleCount));

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            JsonNode userJsonNode = objectMapper.convertValue(data, JsonNode.class);
            ((ObjectNode) rootNode).set("data", userJsonNode);

            return rootNode.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLES_COUNT_CLASS_NOT_FOUND_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLES_COUNT_CLASS_NOT_FOUND_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_ARTICLES_COUNT_SQL_EX);
            res.setDesc(Constant.RESULT_DESC_GET_ARTICLES_COUNT_SQL_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        }
    }

    @POST
    @Path("/getCategoryArticles")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategoryArticles(String json) {
        LoggerLib.Logger.print("getCategoryArticles");

        Result res = new Result();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.createObjectNode();
        ArrayList<HashMap<String, String>> dataArray;

        try {
            JsonNode node = objectMapper.readValue(json, JsonNode.class);

            JsonNode categoryNameNode = node.get("categoryName");
            if (categoryNameNode != null) {
                String categoryName = categoryNameNode.textValue();
                dataArray = engine.getCategoryArticles(categoryName);
            } else {
                throw new Exception("no categoryName in json");
            }

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            JsonNode userJsonNode = objectMapper.convertValue(dataArray, JsonNode.class);
            ((ObjectNode) rootNode).set("data", userJsonNode);

            return rootNode.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_CATEGORY_ARTICLES_CLASS_NOT_FOUND_EX);
            res.setDesc(Constant.RESULT_DESC_GET_CATEGORY_ARTICLES_CLASS_NOT_FOUND_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_CATEGORY_ARTICLES_SQL_EX);
            res.setDesc(Constant.RESULT_DESC_GET_CATEGORY_ARTICLES_SQL_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_CATEGORY_ARTICLES_IO_EX);
            res.setDesc(Constant.RESULT_DESC_GET_CATEGORY_ARTICLES_IO_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);

            res.setCode(Constant.RESULT_CODE_GET_CATEGORY_ARTICLES_EX);
            res.setDesc(Constant.RESULT_DESC_GET_CATEGORY_ARTICLES_EX + " : " + ex.getMessage());

            JsonNode resJsonNode = objectMapper.convertValue(res, JsonNode.class);
            ((ObjectNode) rootNode).set("result", resJsonNode);

            return rootNode.toString();
        }
    }
}
