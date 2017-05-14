package lukzieniewicz.gmail.com.swim6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondaryActivity extends AppCompatActivity {

    private boolean[] states = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        registerForContextMenu(findViewById(R.id.checkbox_controller));

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case 1:
                TextView t = (TextView) findViewById(R.id.check1);
                if(states[0]){
                    t.setText("odznaczony");
                    states[0] = false;
                }
                else{
                    t.setText("zaznaczony");
                    states[0] = true;
                }
                return true;
            case 2:
                TextView t2 = (TextView) findViewById(R.id.check2);
                if(states[1]){
                    t2.setText("odznaczony");
                    states[1] = false;
                }
                else{
                    t2.setText("zaznaczony");
                    states[1] = true;
                }
                return true;
            case 3:
                TextView t3 = (TextView) findViewById(R.id.check3);
                if(states[2]){
                    t3.setText("odznaczony");
                    states[2] = false;
                }
                else{
                    t3.setText("zaznaczony");
                    states[2] = true;
                }
                return true;
        }
        return false;
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(Menu.NONE, 1, 0, "pierwszy").setCheckable(true);
        menu.add(Menu.NONE, 2, 0, "drugi").setCheckable(true);;
        menu.add(Menu.NONE, 3, 0, "trzeci").setCheckable(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, 101, 0, "")
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        for(int i = 0; i<3; i++){
            menu.getItem(i).setChecked(states[i]);
        }
        super.onContextMenuClosed(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public boolean onContextMenuOpened(int featureId, Menu menu) {
        for(int i = 0; i<3 ; i++){
            menu.getItem(i+1).setChecked(states[i]);
        }
        return super.onMenuOpened(featureId, menu);
    }
    */
}
