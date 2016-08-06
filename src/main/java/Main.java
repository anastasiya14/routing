import routing.Impl.JSONtoDataImpl;
import java.util.logging.Logger;

/**
 * Created: 28.03.16 14:38
 *
 * @author Anastasiya Plotnikova
 */
public class Main {
    private static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws Exception {

         JSONtoDataImpl jsoNtoData = new JSONtoDataImpl();
         jsoNtoData.jsonToData();
    }
}
