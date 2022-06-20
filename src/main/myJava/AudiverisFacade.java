package myJava;


import org.audiveris.omr.OMR;
import org.audiveris.omr.sheet.Book;
import org.audiveris.omr.sheet.BookManager;
import org.audiveris.omr.sheet.SheetStub;
import org.audiveris.omr.sig.SIGraph;
import org.audiveris.omr.step.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class AudiverisFacade {

    private static final Logger logger = LoggerFactory.getLogger(SheetStub.class);

    public List<SIGraph> recognize(Path path) {

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
        } finally {
            // Close (when in batch mode only)
            if (OMR.gui == null) {
                // Make a backup if needed, then save book "in its current status"
                book.store(BookManager.getDefaultSavePath(book), cancelled);

                book.close(null);
            }


        }

        List<SIGraph> graphList = new ArrayList<>();
        for (int i = 0; i < book.getStubs().get(0).getSheet().getSystems().size(); i++) {
            graphList.add(book.getStubs().get(0).getSheet().getSystems().get(i).getSig());
        }
        return graphList;
    }


}
