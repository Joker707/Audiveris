package java.awt.image;

public class SampleModel {
    private final MySampleModel sampleModel = new MySampleModel();

    public int getNumBands() {
        return sampleModel.getNumBands();
    }

    public int getDataType() {
        return sampleModel.getDataType();
    }

    private class MySampleModel extends java.awt.image.SampleModel {
        public int getNumBands() {
            return 0;
        }

        public int getNumDataElements() {
            return java.awt.image.SampleModel.this.getNumDataElements();
        }

        public Object getDataElements(int x, int y, Object obj, DataBuffer data) {
            return java.awt.image.SampleModel.this.getDataElements(x, y, obj, data);
        }

        public void setDataElements(int x, int y, Object obj, DataBuffer data) {
            java.awt.image.SampleModel.this.setDataElements(x, y, obj, data);
        }

        public int getSample(int x, int y, int b, DataBuffer data) {
            return java.awt.image.SampleModel.this.getSample(x, y, b, data);
        }

        public void setSample(int x, int y, int b, int s, DataBuffer data) {
            java.awt.image.SampleModel.this.setSample(x, y, b, s, data);
        }

        public java.awt.image.SampleModel createCompatibleSampleModel(int w, int h) {
            return java.awt.image.SampleModel.this.createCompatibleSampleModel(w, h);
        }

        public java.awt.image.SampleModel createSubsetSampleModel(int[] bands) {
            return java.awt.image.SampleModel.this.createSubsetSampleModel(bands);
        }

        public DataBuffer createDataBuffer() {
            return java.awt.image.SampleModel.this.createDataBuffer();
        }

        public int[] getSampleSize() {
            return java.awt.image.SampleModel.this.getSampleSize();
        }

        public int getSampleSize(int band) {
            return java.awt.image.SampleModel.this.getSampleSize(band);
        }
    }
}
