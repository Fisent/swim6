package lukzieniewicz.gmail.com.swim6;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView tv1;
    public TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findTextViews();

        registerForContextMenu(tv1);
        registerForContextMenu(tv2);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondaryActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume (){
        super.onResume();
        findTextViews();
    }

    public void findTextViews(){
        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.text2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu moje_menu){
        super.onCreateOptionsMenu(moje_menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meny_layout1, moje_menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.item1:
                tv1.setTextColor(Color.GREEN);
                tv2.setTextColor(Color.GREEN);
                return true;
            case R.id.item2:
                tv1.setTextColor(Color.BLUE);
                tv2.setTextColor(Color.BLUE);
                return true;
            case R.id.item3:
                tv1.setTextColor(Color.RED);
                tv2.setTextColor(Color.RED);
                return true;
            case R.id.item41:
                tv1.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.item42:
                tv1.setBackgroundColor(Color.BLUE);
                tv2.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.item43:
                tv1.setBackgroundColor(Color.RED);
                tv2.setBackgroundColor(Color.RED);
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.text1){
            getMenuInflater().inflate(R.menu.context_menu_layout1, menu);
        }
        if(v.getId() == R.id.text2){
            getMenuInflater().inflate(R.menu.context_menu_layout2, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);


        switch (item.getItemId()){
            case R.id.context_item11:
                tv1.setTextColor(Color.GREEN);
                return true;
            case R.id.context_item_12:
                tv1.setTextColor(Color.BLUE);
                return true;
            case R.id.context_item_13:
                tv1.setTextColor(Color.RED);
                return true;
            case R.id.context_item21:
                tv2.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.context_item22:
                tv2.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.context_item23:
                tv2.setBackgroundColor(Color.RED);
                return true;
        }
        return false;
    }
}