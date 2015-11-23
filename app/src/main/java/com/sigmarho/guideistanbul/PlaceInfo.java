package com.sigmarho.guideistanbul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceInfo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        ImageView imageP = (ImageView) findViewById(R.id.priImage);
        ImageView imageS1 = (ImageView) findViewById(R.id.secImage1);
        ImageView imageS2 = (ImageView) findViewById(R.id.secImage2);
        ImageView imageS3 = (ImageView) findViewById(R.id.secImage3);

        TextView bascDesc = (TextView) findViewById(R.id.basicDesc);
        TextView detDesc = (TextView) findViewById(R.id.detailedDesc);

        Intent i = getIntent();
        String titleSt = i.getExtras().getString("title");
        String bascDescSt = i.getExtras().getString("bascDesc");
        String detDescSt = i.getExtras().getString("detDesc");
        int pic0 = i.getExtras().getInt("pic0");
        int pic1 = i.getExtras().getInt("pic1");
        int pic2 = i.getExtras().getInt("pic2");

        imageP.setImageResource(pic0);
        imageS1.setImageResource(pic1);
        imageS2.setImageResource(pic2);
        imageS3.setImageResource(pic0);


        setTitle(titleSt);
        bascDesc.setText(bascDescSt);
        detDesc.setText(detDescSt);

        int screenSizeW = getResources().getConfiguration().screenWidthDp*getResources().getDisplayMetrics().densityDpi/160;
        screenSizeW = 9*screenSizeW/10;

        System.out.println("Screen size"+Integer.toString(screenSizeW));

        imageP.getLayoutParams().width = (3* screenSizeW) / 4;
        imageS1.getLayoutParams().width = screenSizeW/4;
        imageS2.getLayoutParams().width = screenSizeW/4;
        imageS3.getLayoutParams().width = screenSizeW/4;

        imageP.getLayoutParams().height = 3*(screenSizeW/4);
        imageS1.getLayoutParams().height = screenSizeW/4;
        imageS2.getLayoutParams().height = screenSizeW/4;
        imageS3.getLayoutParams().height = screenSizeW/4;

    }

    //TO DO: Visual fine-tuning

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
