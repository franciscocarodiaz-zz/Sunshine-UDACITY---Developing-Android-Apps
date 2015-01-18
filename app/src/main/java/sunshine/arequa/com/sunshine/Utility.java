package sunshine.arequa.com.sunshine;

/**
 * Created by franciscocarodiaz on 16/01/15.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.widget.Toast;

public class Utility {
    public static String getPreferredLocation(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_location_key),
                context.getString(R.string.pref_location_default));
    }

    private String getLocationFromPreferences(Context context) {
        return getSharedPreferences(context).getString(context.getString(R.string.pref_location_key),
                context.getString(R.string.pref_location_default));
    }

    private String getUnitFromPreferences(Context context) {
        return getSharedPreferences(context).getString(context.getString(R.string.pref_units_key),
                context.getString(R.string.pref_units_metric));
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void showMsg(Context context,String forecast) {
        CharSequence text = forecast;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }


}