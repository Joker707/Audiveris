package myAndroid.omr.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import myAndroid.java.awt.image.BufferedImage;
import org.audiveris.omr.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageLoading {

    private static final Logger logger = LoggerFactory.getLogger(ImageLoading.class);

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * To disallow instantiation.
     */
    private ImageLoading()
    {
    }

    public static Loader getLoader (Path imgPath) {
        // Avoid stupid errors
        if (!Files.exists(imgPath)) {
            logger.warn("File {} does not exist", imgPath);

            return null;
        }

        if (Files.isDirectory(imgPath)) {
            logger.warn("{} is a directory!", imgPath);

            return null;
        }

        String extension = FileUtil.getExtension(imgPath);
        Loader loader;

        if (extension.equalsIgnoreCase(".png")) {

            loader = getPNGLoader(imgPath);
        } else {
            loader = null;
        }

        if (loader == null) {
            logger.warn("Cannot find a loader for {}", imgPath);
        }

        return loader;
    }

    private static Loader getPNGLoader(Path imgPath) {
        logger.debug("getJaiLoader {}", imgPath);

        try {
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(imgPath.toString(), bmOptions);
            BufferedImage image = new BufferedImage(bitmap.getWidth(), bitmap.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

            if ((bitmap != null) && (image.getWidth() > 0) && (image.getHeight() > 0)) {
                return new PNGLoader(image);
            }

            logger.debug("No image read by JAI for {}", imgPath);
        } catch (Exception ex) {
            logger.warn("JAI failed opening {}, {} ", imgPath, ex.toString(), ex);
        }

        return null;
    }


    public static interface Loader
    {

        BufferedImage getImage (int id)
                throws IOException;


        int getImageCount ();
    }


    private static class PNGLoader
            extends AbstractLoader
    {

        private final BufferedImage image; // The single image



        PNGLoader(BufferedImage image) {
            super(1);
            this.image = image;
        }



        @Override
        public BufferedImage getImage (int id)
                throws IOException
        {
            checkId(id);


            return image;
        }
    }



    private abstract static class AbstractLoader
            implements Loader
    {

        /** Count of images available in input file. */
        protected final int imageCount;

        AbstractLoader (int imageCount)
        {
            this.imageCount = imageCount;
        }


        @Override
        public int getImageCount ()
        {
            return imageCount;
        }

        protected void checkId (int id)
        {
            if ((id < 1) || (id > imageCount)) {
                throw new IllegalArgumentException("Invalid image id " + id);
            }
        }
    }
}
