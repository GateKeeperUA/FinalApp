package com.example.app;

import static com.example.app.MainActivity.client;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import static com.example.app.MainActivity.nfc_discovered;
import static com.example.app.MainActivity.room;


import androidx.fragment.app.Fragment;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Random;

public class nfcFragment extends Fragment{

    private VideoView videoView;
    //private static final String BROKER_URL = "tcp://yopoitio.duckdns.org:1883";
    private static final String BROKER_URL = "tcp://192.168.0.100:1883";
    private String CLIENT_ID;
    private String topic="DETI/Authenticate";
    private String UID;
    private ImageButton authenticate;
    private View circle;
    private boolean flag = true;
    private CountDownTimer countDownTimer;
    private boolean started_timer = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nfc, container, false);
        authenticate = view.findViewById(R.id.authenticate);
        circle = view.findViewById(R.id.circle_view);

        Random random = new Random();
        CLIENT_ID = String.valueOf(random);
        connect(BROKER_URL,CLIENT_ID);

        subscribeToTopic(topic+"/Confirm");
        subscribeCallback.run();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("NFC Tag", Context.MODE_PRIVATE);
        UID = sharedPreferences.getString("key", "00000000");
        Log.d("Shared_preference", UID);

        authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publishMessage(UID.toLowerCase());
                if(started_timer){
                    countDownTimer.cancel();
                }

                startTimer(2000);
            }
        });

        videoView = view.findViewById(R.id.videoView);
        int resourceId;

        if (nfc_discovered) {
            resourceId = R.raw.nfc_video;
            String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + resourceId;
            videoView.setVideoURI(Uri.parse(videoPath));

            // Start playing the video
            videoView.start();
            nfc_discovered=false;
        }
        else {
            resourceId = R.raw.black;
            String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + resourceId;
            videoView.setVideoURI(Uri.parse(videoPath));

            // Start playing the video
            videoView.start();
            nfc_discovered=false;
        }

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        // Pause video if it's playing
        if (videoView.isPlaying() && nfc_discovered) {
            videoView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Resume video if it's paused
        if (!videoView.isPlaying() && nfc_discovered) {
            videoView.start();
        }
    }

    private void subscribeToTopic(String topic){
        try {
            client.subscribe(topic,2);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public Runnable subscribeCallback = new Runnable() {
        @Override
        public void run() {
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {;
                    String received = new String(message.getPayload());
                    Log.d("MQTT_NFC_receive",received);
                    if(received.equals("1"+UID.toLowerCase())){
                        flag = false;
                        circle.getBackground().setColorFilter(getResources().getColor(R.color.green_trans), PorterDuff.Mode.DARKEN);

                    }
                    else if(received.equals("0"+UID.toLowerCase())){
                        flag = true;
                        circle.getBackground().setColorFilter(getResources().getColor(R.color.red_trans), PorterDuff.Mode.DARKEN);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
        }
    };

    private void publishMessage(String message){
        if(flag){
            try {
                MqttMessage mqttMessage = new MqttMessage(message.getBytes());
                client.publish(topic+"/Enter", mqttMessage.getPayload(),2,false);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    public void connect(String brokerUrl, String clientId) {
        try {
            // Set up the persistence layer
            MemoryPersistence persistence = new MemoryPersistence();

            // Initialize the MQTT client
            client = new MqttClient(brokerUrl, clientId, persistence);

            // Set up the connection options
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);

            // Connect to the broker
            client.connect(connectOptions);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void startTimer(long timeInMillis) {
        started_timer = true;
        countDownTimer = new CountDownTimer(timeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("NFC_color","tick");
            }

            @Override
            public void onFinish() {
                flag = true;
                started_timer = false;
                circle.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.DARKEN);
                Log.d("NFC_color","finished");
            }
        }.start();
    }
}