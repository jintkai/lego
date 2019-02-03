package com.legoapi.utils;

import com.alibaba.fastjson.JSONObject;
import com.legoapi.entity.HttpLog;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Service
public class MongoDBTool {


    //CodecRegistry pojoCodecRegistry = fromRegistries(fromProviders(PojoCodecProvider.builder().register("com.legoapi.entity").build()));

//    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
//            fromProviders(PojoCodecProvider.builder().automatic(true).build()));


    private MongoClient mongoClient = new MongoClient( "localhost" , 32769 );

    //public MongoClient mongoClient = MongoClients.create("mongodb://localhost:32769,localhost:32769");

    //https://www.cnblogs.com/sa-dan/p/6836055.html

    /**
     * 获取DB
     *
     * @param databaseName
     * @return
     */
    public MongoDatabase getDataBase(String databaseName) {
        return mongoClient.getDatabase(databaseName);
    }

    /**
     * 获取集合(表)
     *
     * @param dbName
     * @param collectionName
     * @return
     */
    public MongoCollection<Document> getCollection(String dbName, String collectionName) {
        return getDataBase(dbName).getCollection(collectionName);
    }

    /**
     * 获取集合列表
     *
     * @param dbName
     * @return
     */
    public List<String> getAllCollection(String dbName) {
        MongoIterable<String> mongoIterable = getDataBase(dbName).listCollectionNames();
        List<String> colls = new ArrayList<>();
        for (String coll : mongoIterable) {
            colls.add(coll);
        }
        return colls;
    }

    /**
     * 获取数据库列表
     *
     * @return
     */
    public MongoIterable<String> getAllDatabase() {
        return mongoClient.listDatabaseNames();
    }

    /**
     * 删除数据库
     *
     * @param dbName
     */
    public void deleteDb(String dbName) {
        getDataBase(dbName).drop();
    }


    /**
     * 根据id查找对象
     *
     * @param coll
     * @param id
     * @return
     */
    public Document findById(MongoCollection<Document> coll, String id) {
        ObjectId objectId = null;
        objectId = new ObjectId(id);
        Document doc = coll.find(Filters.eq("_id", objectId)).first();
        return doc;
    }

    public void insertDoc(MongoCollection<Document> coll, Document document) {
        coll.insertOne(document);
    }

    public void insertDoc(String dbName, String DocName, HttpLog object) {
        String json = JSONObject.toJSONString(object);
        Document document = Document.parse(json);
        document.append("_id",object.getId());
        getDataBase(dbName).getCollection(DocName).insertOne(document);
    }

    public Document findDocument(String dbName, String docName, String id){
        ObjectId objectId = new ObjectId(id);
        Document document = getDataBase(dbName).getCollection(docName).find(Filters.eq("_id",objectId)).first();
        return document;
    }

}
