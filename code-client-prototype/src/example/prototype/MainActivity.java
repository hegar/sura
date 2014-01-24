package example.prototype;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost = null;
    private LayoutInflater inflater = null;
    private Resources res = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        inflater = getLayoutInflater();
        res = getResources();
        TabHost.TabSpec spec = null;
        
        spec = createTabSpec("Activity", R.string.tabItemDescActivity, R.drawable.tab_item_activity_icon);
        mTabHost.addTab(spec, ActivityFragment.class, null);
        
        spec = createTabSpec("TCR", R.string.tabItemDescTcr, R.drawable.tab_item_tcr_icon);
        mTabHost.addTab(spec, SecondFragment.class, null);
        
        spec = createTabSpec("Weima", R.string.tabItemDescWeima, R.drawable.tab_item_weima_icon);
        mTabHost.addTab(spec, ThirdFragment.class, null);
        
        spec = createTabSpec("Myself", R.string.tabItemDescMyself, R.drawable.tab_item_myself_icon);
        mTabHost.addTab(spec, ActivityFragment.class, null);
    }
    
    private TabHost.TabSpec createTabSpec(String tabName, int descResId, int imgResId) {
        String desc  = res.getString(descResId);
        Drawable img = res.getDrawable(imgResId);
        
        View view = inflater.inflate(R.layout.tab_item, null);
        ImageView icon = (ImageView) view.findViewById(R.id.tabItemIcon);
        TextView  name = (TextView)  view.findViewById(R.id.tabItemName);
        
        icon.setImageDrawable(img);
        name.setText(desc);
        
        return mTabHost.newTabSpec(tabName).setIndicator(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        inflater = null;
        res = null;
        mTabHost = null;
    }

}
