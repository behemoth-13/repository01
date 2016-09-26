package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.ImageReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageTypes;

/**
 * Created by Alex on 12.04.2016.
 */
public  class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes)
    {
        ImageReader imageReader = null;
        if (imageTypes == ImageTypes.JPG)
        {
            imageReader = new com.javarush.test.level16.lesson13.bonus01.common.JpgReader();
        }
            else if (imageTypes == ImageTypes.BMP)
        {
            imageReader = new com.javarush.test.level16.lesson13.bonus01.common.BmpReader();
        }
            else if (imageTypes == ImageTypes.PNG)
        {
            imageReader = new com.javarush.test.level16.lesson13.bonus01.common.PngReader();
        }
            else
        {
            throw new IllegalArgumentException();
        }
        return imageReader;
    }
}
