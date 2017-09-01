package com.example.segundoauqui.scannerw5d3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    private ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        UseTimder();

        Intent intent = getIntent();
        if (intent.getStringExtra("key") != null)
            tv1.setText(getIntent().getStringExtra("key"));
    }

//    public void scanCode(View view) {
//        scannerView = new ZXingScannerView(this);
//        scannerView.setResultHandler(new ZXingScannerResultHnadler());
//
//        setContentView(scannerView);
//        scannerView.startCamera();
//
//    }
//    @Override
//    public void onPause(){
//        super.onPause();
//        scannerView.stopCamera();
//
//    }
//

    private void UseTimder() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {

                //Add the line number to the tag
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });

        }

        //DEBUG
        Timber.d("Hello");

        //VERBOSE
        Timber.v("Log");
    }



    @OnClick({R.id.btnScanCode})
    public void OnClick(View view) {
        Timber.d("Clicked");

        Intent intent = new Intent(this, SimpleScannerActivity.class);
        startActivity(intent);

    }
//
//    class ZXingScannerResultHnadler implements ZXingScannerView.ResultHandler {
//        @Override
//        public void handleResult(Result result) {
//
//            String resultCode = result.getText();
//            Toast.makeText(MainActivity.this, resultCode, Toast.LENGTH_LONG).show();
//
//            setContentView(R.layout.activity_main);
//            scannerView.stopCamera();
//        }

    }


