package sunshine.arequa.com.sunshine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by franciscocarodiaz on 14/01/15.
 */
public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject objWeather = new JSONObject(weatherJsonStr);
        JSONArray arrDays = objWeather.getJSONArray("list");
        JSONObject objDayInfo = (JSONObject) arrDays.get(dayIndex);
        JSONObject objTempInfo = (JSONObject) objDayInfo.getJSONObject("temp");
        Double tempMax = objTempInfo.getDouble("max");

        return tempMax;
    }

}
