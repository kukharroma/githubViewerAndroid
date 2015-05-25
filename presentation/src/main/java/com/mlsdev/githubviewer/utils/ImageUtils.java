package com.mlsdev.githubviewer.utils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by fir on 18.11.14.
 */
public class ImageUtils {
    private static DisplayImageOptions.Builder options;

    public static void initDefaultImageLoaderOptions(){
        if (options == null){
            options = new DisplayImageOptions.Builder()
                    .resetViewBeforeLoading(true)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .considerExifParams(true)
                    .displayer(new FadeInBitmapDisplayer(500, true, true, false));
        }
    }

    private static void checkOnInitBuilder(){
        if (options == null){
            throw new RuntimeException("Call ImageUtils.initDefaultImageLoaderOptions() first");
        }
    }

    public static DisplayImageOptions getDefaultImageLoaderOptions(){
        checkOnInitBuilder();
        return options.build();
    }

    public static DisplayImageOptions getDefaultImageLoaderOptions(Integer placeholderResourceId){
        checkOnInitBuilder();
        return options.showImageForEmptyUri(placeholderResourceId)
                .showImageOnFail(placeholderResourceId)
                .showImageOnLoading(placeholderResourceId)
                .build();
    }
}
