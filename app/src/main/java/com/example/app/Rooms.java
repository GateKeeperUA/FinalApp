package com.example.app;

import static com.example.app.MainActivity.last_floor;
import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Random;

public class Rooms extends AppCompatActivity {

    private static final String BROKER_URL = "tcp://yopoitio.duckdns.org:1883";
    private String CLIENT_ID;
    public TextView temperature_;
    public TextView humidity_;
    public TextView gas_;
    private MqttClient client;
    private String topic;
    private String temperature;
    private String humidity;
    private String gas;
    private float _temperature;
    private float _humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        temperature_ = findViewById(R.id.temperature_);
        humidity_ = findViewById(R.id.humidity_);
        gas_ = findViewById(R.id.gas_);
        Random random = new Random();
        CLIENT_ID = String.valueOf(random);
        temperature_.setText("No data");
        humidity_.setText("No data");
        gas_.setText("No data");
        connect(BROKER_URL,CLIENT_ID);
        topic = "DETI/"+room;
        subscribeToTopic(topic);
        subscribeCallback.run();
    }

    public void back (View view) {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }

        if(last_floor==1) {
            Intent intent = new Intent(this, floor1.class);
            startActivity(intent);
        }
        else if(last_floor==2) {
            Intent intent = new Intent(this, floor2.class);
            startActivity(intent);
        }
        else if(last_floor==3) {
            Intent intent = new Intent(this, floor3.class);
            startActivity(intent);
        }


    }

    @Override
    protected void onDestroy() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        super.onDestroy();

    }
    private void publishMessage(String topic, String message){
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            client.publish(topic, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    private void subscribeToTopic(String topic){
        try {
            client.subscribe(topic,0);
        } catch (MqttException e) {
            e.printStackTrace();
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

    public Runnable subscribeCallback = new Runnable() {
        @Override
        public void run() {
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    int type = 0;
                    temperature="";
                    humidity="";
                    gas="";
                    String received = new String(message.getPayload());
                    if(received.equals("0 0 0")==false) {
                        for(int i=0;i<received.length();i++){
                            if(received.charAt(i)!=' '){
                                switch (type) {
                                    case 0:
                                        temperature = temperature + received.charAt(i);
                                        break;
                                    case 1:
                                        humidity = humidity + received.charAt(i);
                                        break;
                                    case 2:
                                        gas = gas + received.charAt(i);
                                        break;
                                }
                            }
                            else {
                                type++;
                            }
                        }
                        _temperature = Float.valueOf(temperature)/100;
                        _humidity = Float.valueOf(Math.round(Integer.valueOf(humidity)/10))/100;
                        temperature_.setText(String.valueOf(_temperature)+"ºC");
                        humidity_.setText(String.valueOf(_humidity)+"%");
                        switch (gas) {
                            case "0":
                                gas_.setText("Hazardous");
                                break;
                            case "1":
                                gas_.setText("Very Unhealthy");
                                break;
                            case "2":
                                gas_.setText("Unhealthy");
                                break;
                            case "3":
                                gas_.setText("Unhealthy for Sensitive Groups");
                                break;
                            case "4":
                                gas_.setText("Moderate");
                                break;
                            case "5":
                                gas_.setText("Good");
                                break;
                            default:
                                gas_.setText("Undefined");
                                break;
                        }
                        Log.d("MQTT_received","Temp:"+temperature_+" Hum:"+humidity_+" Gas:"+gas);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
        }
    };
}