package lab3.MetadataReaders;

import lab3.Info.ImgInfo;
import lab3.Info.Info;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Logger;

public class ImageMetadataReader extends MetadataReader {
    public static Logger logger = lab3.FileManager.getLogger();
    public ImgInfo readMetadata(String filePath) {
        Info info = super.readMetadata(filePath);

            int[] imageSize = getImageSize(filePath);
            if (imageSize != null) {
                logger.info("Image metadata retrieved successful");
                return  new ImgInfo(
                        info.getName(), info.getSize(), info.getLastUpdate(), info.getCreated(),
                        imageSize[0], imageSize[1]
                );

            }

        return null;

    }
    private static int[] getImageSize(String filePath) {
        try {
            File imageFile = new File(filePath);
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            if (bufferedImage != null) {
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                return new int[] { width, height };
            }
        } catch (IOException e) {
            logger.warning("failed to get image size "+e);
        }
        return null;
    }
}
