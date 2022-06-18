package myAndroid.jai;


import myAndroid.java.awt.RenderingHints;
import myAndroid.java.awt.image.renderable.ParameterBlock;

public class JAI {

    private static JAI defaultInstance;
    private OperationRegistry operationRegistry;


    public static RenderedOp create(String opName, ParameterBlock args, RenderingHints hints) {
        return defaultInstance.createNS(opName, args, hints);
    }


    public RenderedOp createNS(String opName, ParameterBlock args, RenderingHints hints) {
        RenderedOp op = new RenderedOp(this.operationRegistry, opName, args, hints);
        return op;
    }
}
