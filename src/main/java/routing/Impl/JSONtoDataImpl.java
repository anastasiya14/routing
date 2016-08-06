package routing.Impl;

import Mesh.POJOjson.Mesh;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
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
public class JSONtoDataImpl implements JSONtoData {

    public List<Mesh> jsonToData() throws IOException {
        MongoClient mongoClient = null;
        List<Mesh> nSquareJSON = new ArrayList<Mesh>();
        try {

            mongoClient = new MongoClient("10.130.101.9", 27017);

            // New way to get database
            MongoDatabase db = mongoClient.getDatabase("moto");
            MongoCollection<Document> collection = db.getCollection("mesh_test6");

            //Query MongoDB
            MongoCursor<Document> cursor = (MongoCursor<Document>) collection.find()
                    .projection(Projections.excludeId())
                   // .limit(10)
                    .iterator();

            try {
                while (cursor.hasNext()) {

                    String json = cursor.next().toJson();
                    // System.out.println(json);

                    ObjectMapper mapper = new ObjectMapper();
                    Mesh mesh = mapper.readValue(json, Mesh.class);
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
