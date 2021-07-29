import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class MongoTest {

    MongoDatabase mongoDatabase = null;

    // 获取连接
    @BeforeEach
    public void getConnectionTest(){
        //创建连接对象
        MongoClient client = new MongoClient("localhost", 27017);
        //获取MongoDB数据库
        mongoDatabase = client.getDatabase("develop");
        //获取MongoDB中的集合
        MongoCollection collection = mongoDatabase.getCollection("dev");
        //连接成功显示ok
        System.out.println("OK.................");
    }

    // 插入
    @Test
    public void inesrtSingleDocument(){
        //获取集合
        MongoCollection collection = mongoDatabase.getCollection("develop");
        Document docu=new Document();
        docu.append("username","lisi").append("userage",26).append("userdesc","Very Good").append("userlike", Arrays.asList(new String[]{"Music","Sport"}));
        collection.insertOne(docu);
    }

    // 查询
    @Test
    public void selectDocumentAll(){
        MongoCollection collection = mongoDatabase.getCollection("develop");
        //返回的是一个文档的迭代器
        FindIterable<Document> iterable = collection.find();
        MongoCursor<Document> cursor = iterable.iterator();
        while(cursor.hasNext()){
            Document docu = cursor.next();
            System.out.println(docu.get("username")+"\t"+docu.get("userage")+"\t"+docu.get("userdesc")+"\t"+docu.get("userlike"));
        }
    }

    // 根据id查询
    @Test
    public void selectDocumentById(){
        MongoCollection collection = mongoDatabase.getCollection("develop");
        FindIterable<Document> iterable = collection.find(Filters.eq("_id",new ObjectId("5d398cd64b022206d87d168e")));
        MongoCursor<Document> cursor = iterable.iterator();
        while(cursor.hasNext()){
            Document docu = cursor.next();
            System.out.println(docu.get("username")+"\t"+docu.get("userage")+"\t"+docu.get("userdesc")+"\t"+docu.get("userlike"));
        }
    }



}
