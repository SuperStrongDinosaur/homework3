package com.example.alex.homework3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.File;
import java.util.Objects;

import static com.example.alex.homework3.MainActivity.IMAGE_FILE;

public class ActionReceiver extends BroadcastReceiver {
    private static final String KAPPA = "http://i3.kym-cdn.com/photos/images/newsfeed/000/925/494/218.png_large";
    private static final String KAPPA_PRIDE = "https://yt3.ggpht.com/-eYKRn5SpMp4/AAAAAAAAAAI/AAAAAAAAAAA/5KYGYFJLCr0/s900-c-k-no-mo-rj-c0xffffff/photo.jpg";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, ImageLoadService.class);
        serviceIntent.putExtra(ImageLoadService.IMAGE_FILE, new File(context.getFilesDir(), IMAGE_FILE).getAbsolutePath());
        if (Objects.equals(intent.getAction(), Intent.ACTION_POWER_CONNECTED)) {
            serviceIntent.putExtra(ImageLoadService.IMAGE_URL, KAPPA);
        } else if (Objects.equals(intent.getAction(), Intent.ACTION_POWER_DISCONNECTED)) {
            serviceIntent.putExtra(ImageLoadService.IMAGE_URL, KAPPA_PRIDE);
        }
        context.startService(serviceIntent);
    }
}
