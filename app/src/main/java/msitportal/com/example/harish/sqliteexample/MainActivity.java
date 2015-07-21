package msitportal.com.example.harish.sqliteexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*File folder = getApplicationContext().getDir("database", Context.MODE_PRIVATE);
        File mydb = new File(folder,"login.db");*/


        Log.d("Harish1345 ", "Inserting ..");
        final EditText username = (EditText)findViewById(R.id.user);
        final EditText password = (EditText)findViewById(R.id.pass);
        Button Login = (Button)findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db = new DbHelper(getApplicationContext());
                db.saveLoginInfo(db,username.getText().toString(),password.getText().toString());

               /* Cursor dataCursor = db.getLoginInfo(db,"Harish");*/
                Log.d("Harish1345","Chal gya");
            }
        });
    }
}
