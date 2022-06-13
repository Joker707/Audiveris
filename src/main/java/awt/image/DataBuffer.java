package java.awt.image;

public class DataBuffer extends java.awt.image.DataBuffer {
    private final MyDataBuffer dataBuffer = new MyDataBuffer();

    private class MyDataBuffer extends DataBuffer {
        public int getElem(int bank, int i) {
            return DataBuffer.this.getElem(bank, i);
        }

        public void setElem(int bank, int i, int val) {
            DataBuffer.this.setElem(bank, i, val);
        }
    }
}
