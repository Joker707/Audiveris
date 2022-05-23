package java.awt;

import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;

import awt.Stroke;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public abstract class Graphics2D {

    private final MyGraphics2D graphics2D = new MyGraphics2D();

    public abstract void draw(Shape s);

    public abstract boolean drawImage(Image img,
                                      AffineTransform xform,
                                      ImageObserver obs);

    public abstract void drawRenderedImage(RenderedImage img,
                                           AffineTransform xform);

    public abstract void drawString(String str, int x, int y);

    public abstract void drawString(AttributedCharacterIterator iterator,
                                    int x, int y);

    public abstract void fill(Shape s);

    public abstract void setComposite(Composite comp);

    public abstract void setStroke(Stroke s);

    public abstract void setRenderingHint(RenderingHints.Key hintKey, Object hintValue);

    public abstract void translate(int x, int y);

    public abstract void scale(double sx, double sy);

    public abstract void transform(AffineTransform Tx);

    public abstract void setTransform(AffineTransform Tx);

    public abstract AffineTransform getTransform();

    public abstract Composite getComposite();

    public abstract void setBackground(Color color);

    public abstract Stroke getStroke();

    public abstract void clip(Shape s);

    public abstract FontRenderContext getFontRenderContext();

    public abstract Graphics create();

    public abstract Color getColor();

    public abstract void setColor(Color c);

    public abstract void setPaintMode();

    public abstract void setXORMode(Color c1);

    public abstract Font getFont();

    public abstract void setFont(Font font);

    public abstract FontMetrics getFontMetrics(Font f);

    public abstract Rectangle getClipBounds();

    public abstract void clipRect(int x, int y, int width, int height);

    public abstract void setClip(int x, int y, int width, int height);

    public abstract Shape getClip();

    public abstract void setClip(Shape clip);

    public abstract void copyArea(int x, int y, int width, int height,
                                  int dx, int dy);

    public abstract void drawLine(int x1, int y1, int x2, int y2);

    public abstract void fillRect(int x, int y, int width, int height);

    public abstract void clearRect(int x, int y, int width, int height);

    public abstract void drawRoundRect(int x, int y, int width, int height,
                                       int arcWidth, int arcHeight);

    public abstract void fillRoundRect(int x, int y, int width, int height,
                                       int arcWidth, int arcHeight);

    public abstract void drawOval(int x, int y, int width, int height);

    public abstract void fillOval(int x, int y, int width, int height);

    public abstract void drawArc(int x, int y, int width, int height,
                                 int startAngle, int arcAngle);

    public abstract void fillArc(int x, int y, int width, int height,
                                 int startAngle, int arcAngle);

    public abstract void drawPolyline(int xPoints[], int yPoints[],
                                      int nPoints);

    public abstract void drawPolygon(int xPoints[], int yPoints[],
                                     int nPoints);

    public abstract void fillPolygon(int xPoints[], int yPoints[],
                                     int nPoints);

    public abstract boolean drawImage(Image img, int x, int y,
                                      ImageObserver observer);

    public abstract boolean drawImage(Image img, int x, int y,
                                      int width, int height,
                                      ImageObserver observer);

    public abstract boolean drawImage(Image img, int x, int y,
                                      Color bgcolor,
                                      ImageObserver observer);

    public abstract boolean drawImage(Image img, int x, int y,
                                      int width, int height,
                                      Color bgcolor,
                                      ImageObserver observer);

    public abstract boolean drawImage(Image img,
                                      int dx1, int dy1, int dx2, int dy2,
                                      int sx1, int sy1, int sx2, int sy2,
                                      ImageObserver observer);

    public abstract boolean drawImage(Image img,
                                      int dx1, int dy1, int dx2, int dy2,
                                      int sx1, int sy1, int sx2, int sy2,
                                      Color bgcolor,
                                      ImageObserver observer);

    public abstract void dispose();

    public void drawRect(int x, int y, int width, int height) {
        graphics2D.drawRect(x, y, width, height);
    }

    public void finalize() {
        graphics2D.finalize();
    }

    public String toString() {
        return graphics2D.toString();
    }

    private class MyGraphics2D extends Graphics2D {
        public void draw(Shape s) {
            Graphics2D.this.draw(s);
        }

        public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
            return Graphics2D.this.drawImage(img, xform, obs);
        }

        public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
            Graphics2D.this.drawImage(img, op, x, y);
        }

        public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
            Graphics2D.this.drawRenderedImage(img, xform);
        }

        public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
            Graphics2D.this.drawRenderableImage(img, xform);
        }

        public void drawString(String str, int x, int y) {
            Graphics2D.this.drawString(str, x, y);
        }

        public void drawString(String str, float x, float y) {
            Graphics2D.this.drawString(str, x, y);
        }

        public void drawString(AttributedCharacterIterator iterator, int x, int y) {
            Graphics2D.this.drawString(iterator, x, y);
        }

        public void drawString(AttributedCharacterIterator iterator, float x, float y) {
            Graphics2D.this.drawString(iterator, x, y);
        }

        public void drawGlyphVector(GlyphVector g, float x, float y) {
            Graphics2D.this.drawGlyphVector(g, x, y);
        }

        public void fill(Shape s) {
            Graphics2D.this.fill(s);
        }

        public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
            return Graphics2D.this.hit(rect, s, onStroke);
        }

        public GraphicsConfiguration getDeviceConfiguration() {
            return Graphics2D.this.getDeviceConfiguration();
        }

        public void setComposite(Composite comp) {
            Graphics2D.this.setComposite(comp);
        }

        public void setPaint(Paint paint) {
            Graphics2D.this.setPaint(paint);
        }

        public void setStroke(Stroke s) {
            Graphics2D.this.setStroke(s);
        }

        public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {
            Graphics2D.this.setRenderingHint(hintKey, hintValue);
        }

        public Object getRenderingHint(RenderingHints.Key hintKey) {
            return Graphics2D.this.getRenderingHint(hintKey);
        }

        public void setRenderingHints(Map<?, ?> hints) {
            Graphics2D.this.setRenderingHints(hints);
        }

        public void addRenderingHints(Map<?, ?> hints) {
            Graphics2D.this.addRenderingHints(hints);
        }

        public RenderingHints getRenderingHints() {
            return Graphics2D.this.getRenderingHints();
        }

        public void translate(int x, int y) {
            Graphics2D.this.translate(x, y);
        }

        public void translate(double tx, double ty) {
            Graphics2D.this.translate(tx, ty);
        }

        public void rotate(double theta) {
            Graphics2D.this.rotate(theta);
        }

        public void rotate(double theta, double x, double y) {
            Graphics2D.this.rotate(theta, x, y);
        }

        public void scale(double sx, double sy) {
            Graphics2D.this.scale(sx, sy);
        }

        public void shear(double shx, double shy) {
            Graphics2D.this.shear(shx, shy);
        }

        public void transform(AffineTransform Tx) {
            Graphics2D.this.transform(Tx);
        }

        public void setTransform(AffineTransform Tx) {
            Graphics2D.this.setTransform(Tx);
        }

        public AffineTransform getTransform() {
            return Graphics2D.this.getTransform();
        }

        public Paint getPaint() {
            return Graphics2D.this.getPaint();
        }

        public Composite getComposite() {
            return Graphics2D.this.getComposite();
        }

        public void setBackground(Color color) {
            Graphics2D.this.setBackground(color);
        }

        public Color getBackground() {
            return Graphics2D.this.getBackground();
        }

        public Stroke getStroke() {
            return Graphics2D.this.getStroke();
        }

        public void clip(Shape s) {
            Graphics2D.this.clip(s);
        }

        public FontRenderContext getFontRenderContext() {
            return Graphics2D.this.getFontRenderContext();
        }

        public Graphics create() {
            return Graphics2D.this.create();
        }

        public void translate(int x, int y) {
            Graphics2D.this.translate(x, y);
        }

        public Color getColor() {
            return Graphics2D.this.getColor();
        }

        public void setColor(Color c) {
            Graphics2D.this.setColor(c);
        }

        public void setPaintMode() {
            Graphics2D.this.setPaintMode();
        }

        public void setXORMode(Color c1) {
            Graphics2D.this.setXORMode(c1);
        }

        public Font getFont() {
            return Graphics2D.this.getFont();
        }

        public void setFont(Font font) {
            Graphics2D.this.setFont(font);
        }

        public FontMetrics getFontMetrics(Font f) {
            return Graphics2D.this.getFontMetrics(f);
        }

        public Rectangle getClipBounds() {
            return Graphics2D.this.getClipBounds();
        }

        public void clipRect(int x, int y, int width, int height) {
            Graphics2D.this.clipRect(x, y, width, height);
        }

        public void setClip(int x, int y, int width, int height) {
            Graphics2D.this.setClip(x, y, width, height);
        }

        public Shape getClip() {
            return Graphics2D.this.getClip();
        }

        public void setClip(Shape clip) {
            Graphics2D.this.setClip(clip);
        }

        public void copyArea(int x, int y, int width, int height, int dx, int dy) {
            Graphics2D.this.copyArea(x, y, width, height, dx, dy);
        }

        public void drawLine(int x1, int y1, int x2, int y2) {
            Graphics2D.this.drawLine(x1, y1, x2, y2);
        }

        public void fillRect(int x, int y, int width, int height) {
            Graphics2D.this.fillRect(x, y, width, height);
        }

        public void clearRect(int x, int y, int width, int height) {
            Graphics2D.this.clearRect(x, y, width, height);
        }

        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
            Graphics2D.this.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
        }

        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
            Graphics2D.this.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
        }

        public void drawOval(int x, int y, int width, int height) {
            Graphics2D.this.drawOval(x, y, width, height);
        }

        public void fillOval(int x, int y, int width, int height) {
            Graphics2D.this.fillOval(x, y, width, height);
        }

        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
            Graphics2D.this.drawArc(x, y, width, height, startAngle, arcAngle);
        }

        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
            Graphics2D.this.fillArc(x, y, width, height, startAngle, arcAngle);
        }

        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
            Graphics2D.this.drawPolyline(xPoints, yPoints, nPoints);
        }

        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
            Graphics2D.this.drawPolygon(xPoints, yPoints, nPoints);
        }

        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
            Graphics2D.this.fillPolygon(xPoints, yPoints, nPoints);
        }

        public void drawString(@org.jetbrains.annotations.NotNull String str, int x, int y) {
            Graphics2D.this.drawString(str, x, y);
        }

        public void drawString(AttributedCharacterIterator iterator, int x, int y) {
            Graphics2D.this.drawString(iterator, x, y);
        }

        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return Graphics2D.this.drawImage(img, x, y, observer);
        }

        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            return Graphics2D.this.drawImage(img, x, y, width, height, observer);
        }

        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            return Graphics2D.this.drawImage(img, x, y, bgcolor, observer);
        }

        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            return Graphics2D.this.drawImage(img, x, y, width, height, bgcolor, observer);
        }

        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return Graphics2D.this.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
        }

        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            return Graphics2D.this.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
        }

        public void dispose() {
            Graphics2D.this.dispose();
        }
    }
}
