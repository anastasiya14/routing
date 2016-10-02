package routing;

import Mesh.Mesh;

import java.io.IOException;
import java.util.List;

/**
 * Created: 15.06.16 10:36
 *
 * @author Anastasiya Plotnikova
 */
public interface JSONtoData {

    public List<Mesh> jsonToData(String singleWeekDay) throws IOException;
}
