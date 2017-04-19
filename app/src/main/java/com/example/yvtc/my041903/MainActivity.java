package com.example.yvtc.my041903;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String str = sp.getString("username","");
        EditText ed = (EditText)findViewById(R.id.editText);
        ed.setText(str);



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Settings");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //選擇選項
        if(item.getTitle().equals("Settings")){
            Intent it =new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickRead(View v){
        SharedPreferences sp =getSharedPreferences("mydata",MODE_PRIVATE);
        String str = sp.getString("username","");

        SharedPreferences sp2 = PreferenceManager.getDefaultSharedPreferences(this);
        str=sp2.getString("account","");
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(str);
    }

    public void clickWrite(View v){
        SharedPreferences sp = getSharedPreferences("mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        EditText ed = (EditText)findViewById(R.id.editText);
        editor.putString("username",ed.getText().toString());
        editor.commit();
    }
}
