package app;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/15
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zjyll
 */
public class HelloMongoDB {


    public static void main(String[] args) {
       /* MongoClient mongoClient = new MongoClient("localhost", 27017);
        *//*final Collection<DB> usedDatabases = mongoClient.getUsedDatabases();
        for (DB usedDatabase : usedDatabases) {
            System.out.println(usedDatabase.getName());
        }*//*
        final DB test = mongoClient.getDB("test");*/

        final ServerAddress server = new ServerAddress("localhost", 27017);
        final ArrayList<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
        serverAddresses.add(server);
        final MongoCredential credential = MongoCredential.createCredential("readWrite", "test", "123456".toCharArray());
        final ArrayList<MongoCredential> mongoCredentials = new ArrayList<MongoCredential>();
        mongoCredentials.add(credential);
        final MongoClient mongoClient = new MongoClient(serverAddresses, mongoCredentials);
        final MongoDatabase test = mongoClient.getDatabase("test");
        for (Document document : test.listCollections()) {
            System.out.println(document.toJson());
        }
        final MongoCollection<Document> user = test.getCollection("user");
        System.out.println("========统计数量");
        System.out.println(user.count());
        System.out.println("========查询全部数据");
        for (Document document : user.find()) {
            System.out.println(document.toJson());
        }


        final FindIterable<Document> id = user.find(new BasicDBObject("age", 31));
        System.out.println("========过滤数据");
        for (Document document : id) {
            System.out.println(document.toJson());
        }

       /* final FindIterable<User> users = user.find(new BasicDBObject("age", 31), User.class);
        for (User userItem : users) {

            System.out.println(userItem.toString());
        }*/
        /*final Document replacement = new Document();
        final Document nameDoc = new Document();
        nameDoc.put("userName", "lvli");
        nameDoc.put("nickName", "li");
        replacement.put("name", nameDoc);
        replacement.put("special", "nerse");
        final Document resultDoc = user.findOneAndReplace(new BasicDBObject("_id", "3"), replacement);
        //返回的是更新前的对象
        System.out.println(resultDoc.toJson());*/

        //返回的是删除前的对象
//        final Document delDoc = user.findOneAndDelete(new Document("_id", "3"));

//        System.out.println(delDoc.toJson());

//        final DeleteResult deleteResult = user.deleteMany(new BasicDBObject(2));
//        final long deletedCount = deleteResult.getDeletedCount();
//        System.out.println(deletedCount);
        final Document document = new Document();


        user.insertOne(document);


    }
}
