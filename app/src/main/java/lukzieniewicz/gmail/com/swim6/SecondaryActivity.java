package lukzieniewicz.gmail.com.swim6;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondaryActivity extends AppCompatActivity {

    private boolean[] states = new boolean[3];
    private ActionMode myActionMode;
    private ActionMode.Callback callback = new ActionMode.Callback()
    {
        private int[] ids = new int[4];
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu)
        {
            ids[0] = menu.add("Czerwony tekst").getItemId();
            ids[1] = menu.add("Żółty tekst").getItemId();
            ids[2] = menu.add("Czerwone tło").getItemId();
            ids[3] = menu.add("Żółte tło").getItemId();
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu)
        {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item)
        {
            TextView tv = (TextView) findViewById(R.id.textView3);
            String title = item.getTitle().toString();
            if(title.equals("Czerwony tekst")){
                tv.setTextColor(Color.RED);
                return true;
            }else if(title.equals("Żółty tekst")){
                tv.setTextColor(Color.YELLOW);
                return true;
            }else if(title.equals("Czerwone tło")){
                tv.setBackgroundColor(Color.RED);
                return true;
            }else if(title.equals("Żółte tło")){
                tv.setBackgroundColor(Color.YELLOW);
                return true;
            }else
                return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode)
        {
            myActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        registerForContextMenu(findViewById(R.id.checkbox_controller));

        findViewById(R.id.textView3).setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                if(myActionMode == null)
                    myActionMode = startSupportActionMode(callback);
                return true;
            }
        });
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

        menu.add(Menu.NONE, 1, 0, "pierwszy").setCheckable(true).setChecked(states[0]);
        menu.add(Menu.NONE, 2, 0, "drugi").setCheckable(true).setChecked(states[1]);
        menu.add(Menu.NONE, 3, 0, "trzeci").setCheckable(true).setChecked(states[2]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("tekst 1 - żółte tło");
        menu.add("tekst 1 - czerowne tło");
        menu.add("tekst 2 - żółte tło");
        menu.add("tekst 2 - czerwone tło");
        return super.onCreateOptionsMenu(menu);

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
        String title = item.getTitle().toString();
        switch (title)
        {
            case "tekst 1 - żółte tło":
                findViewById(R.id.textView1).setBackgroundColor(Color.YELLOW);
                break;
            case "tekst 1 - czerowne tło":
                findViewById(R.id.textView1).setBackgroundColor(Color.RED);
                break;
            case "tekst 2 - żółte tło":
                findViewById(R.id.textView2).setBackgroundColor(Color.YELLOW);
                break;
            case "tekst 2 - czerwone tło":
                findViewById(R.id.textView2).setBackgroundColor(Color.RED);
                break;
        }
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
