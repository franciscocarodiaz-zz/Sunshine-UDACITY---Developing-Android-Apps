package sunshine.arequa.com.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends ActionBarActivity {

    public static final String DATE_KEY = "forecast_date";

    private final String LOG_TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            // Without passing info between fragment
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new DetailFragment())
//                    .commit();

            // Create the detail fragment and add it to the activity
            // using a fragment transaction, passing the info selected.
            String date = getIntent().getStringExtra(DATE_KEY);

            Bundle arguments = new Bundle();
            arguments.putString(DetailActivity.DATE_KEY, date);

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.weather_detail_container, fragment)
                    .commit();
        }
        Log.v(LOG_TAG,"onCreate()");
    }
    /*
    @Override
    public void onStart() {
        super.onStart();
        Log.v(LOG_TAG,"onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(LOG_TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(LOG_TAG,"onStop()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(LOG_TAG,"onResume()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(LOG_TAG,"onDestroy()");
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
