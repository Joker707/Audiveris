package myJava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import myAndroid.step.LoadStep;
import java.awt.image.BufferedImage;
import org.audiveris.omr.OMR;
import org.audiveris.omr.sheet.Book;
import org.audiveris.omr.sheet.BookManager;
import org.audiveris.omr.sheet.SheetStub;
import org.audiveris.omr.step.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.List;


public class AudiverisFacade {

    private static final Logger logger = LoggerFactory.getLogger(SheetStub.class);

    public Object recognize(BufferedImage bufferedImage) {

        Path path = Paths.get("test.png");
        final Book book = Book.loadBook(path);

        if (book == null) {
            return null;
        }

        final Path folder = BookManager.getDefaultBookFolder(book);
        boolean cancelled = false;

        try {
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }
            if (book.getStubs().isEmpty()) {
                book.createStubs();

                // Save book to disk immediately (global book info)
                final Path bookPath = BookManager.getDefaultSavePath(book);

            }

            final List<SheetStub> validStubs = Book.getValidStubs(book.getStubs());

//            loadImage(validStubs.get(0).getSheet());

            LoadStep loadStep = new LoadStep();
            loadStep.doit(validStubs.get(0).getSheet());

            boolean ok = book.reachBookStep(OmrStep.PAGE, false, validStubs, false);

            if (!ok) {
                return null;
            }
        } catch (ProcessingCancellationException pce) {
            logger.warn("Cancelled " + book);
            cancelled = true;
            throw pce;
        } catch (IOException ex) {
            logger.warn("Exception occurred " + ex, ex);
            throw new RuntimeException(ex);
        } catch (StepException ignored) {
            logger.info("StepException detected in " + neededSteps);
        } finally {
            // Close (when in batch mode only)
            if (OMR.gui == null) {
                // Make a backup if needed, then save book "in its current status"
                book.store(BookManager.getDefaultSavePath(book), cancelled);

                book.close(null);
            }


        }




        // короче
        // нужно вызвать reachStep(PAGE, false), перед этим инициализировав Sheet etc.

        private final EnumSet<OmrStep> doneSteps = EnumSet.noneOf(OmrStep.class);


        //reach step



    }




    public void processing() {
        //init(?)



        //load book





        //process book





    }



    public Bitmap createImage() {
        File sd = Environment.getExternalStorageDirectory();
        File image = new File(sd+filePath, imageName);
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
        return bitmap;
    }




}
