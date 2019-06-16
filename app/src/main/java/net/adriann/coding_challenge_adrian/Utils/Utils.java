package net.adriann.coding_challenge_adrian.Utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.stfalcon.imageviewer.StfalconImageViewer;

import net.adriann.coding_challenge_adrian.R;

public class Utils {
    private static final Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    public static void openImageFullscreen(Context context, String url) {
        String[] imagesList = {url};
        new StfalconImageViewer.Builder<>(context, imagesList,
                (imageView, image) -> Glide.with(context)
                        .load(image)
                        .placeholder(R.color.colorPrimaryDark)
                        .into(imageView))
                        .show();
    }
}
