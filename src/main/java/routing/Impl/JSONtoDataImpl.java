package routing.Impl;

import Mesh.Mesh;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;
import routing.JSONtoData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created: 15.06.16 10:37
 *
 * @author Anastasiya Plotnikova
 */
public class JSONtoDataImpl implements JSONtoData  {

    public List<Mesh> jsonToData(String singleWeekDay) throws IOException {
        MongoClient mongoClient = null;
        List<Mesh> nSquareJSON = new ArrayList<Mesh>();
        try {

            mongoClient = new MongoClient("10.130.101.9", 27017);

            // New way to get database
            MongoDatabase db = mongoClient.getDatabase("moto");
            MongoCollection<Document> collection = db.getCollection(singleWeekDay);

            //Query MongoDB
            MongoCursor<Document> cursor = (MongoCursor<Document>) collection.find()
                    .projection(Projections.excludeId())
                   //.limit(10)
                    .iterator();

            try {
                while (cursor.hasNext()) {

                    String json = cursor.next().toJson();
                    //System.out.println(json);
                    //String json = cursor.next().toJson();
                    ObjectMapper mapper = new ObjectMapper();
                    BasicDBObject d=(BasicDBObject) JSON.parse(json);

                    Mesh mesh = new Mesh();
                    //System.out.println(d.get("devices"));
                    //System.out.println(d.get("devices").getClass());
                    mesh.setDevices((BasicDBList)d.get("devices"));
                    //System.out.println(d.get("squareI"));
                    mesh.setSquareI(Long.valueOf(d.get("squareI").toString()));
                    //System.out.println(d.get("squareJ"));
                    mesh.setSquareJ(Long.valueOf(d.get("squareJ").toString()));
                    //System.out.println(d.get("weekDay"));
                    mesh.setWeekDay((Integer)d.get("weekDay"));
                    //System.out.println(d.get("timeZone"));
                    mesh.setTimeZone((Integer)d.get("timeZone"));
                    //System.out.println(d.get("devCount"));
                    mesh.setDevCount((Integer)d.get("devCount"));
                    //System.out.println(d.get("despersion"));
                    mesh.setDespersion((Double)d.get("despersion"));

                    //System.out.println(mesh);
                    nSquareJSON.add(mesh);

                }
                mongoClient.close();
            } catch (Exception w) {
            }


        } finally {
            mongoClient.close();
        }
        return nSquareJSON;
    }
}
