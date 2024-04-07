import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<String>();
        try {
            FileReader reader = new FileReader(CLASS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray courseJSON = (JSONArray)parser.parse(reader);
            for (int i = 0; i < courseJSON.size(); i++) {
                JSONObject courseJSON = (JSONObject)courseJSON.get(i);
                    String course = (String)courseJSON.get(CLASS_CODE);
                    String title = (String)courseJSON.get(CLASS_TITLE);
                    courses.add(new Course(course));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}