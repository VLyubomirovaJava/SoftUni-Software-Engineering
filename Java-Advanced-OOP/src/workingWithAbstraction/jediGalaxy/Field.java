package workingWithAbstraction.jediGalaxy;

public class Field {
private int [][] field;

    public Field(int[] dimension) {
        this.field = new int [dimension[0]][dimension[1]];
        fillMatrix();
    }

    public void setFieldValue(int row, int column, int value) {
        this.field [row][column]=value;
    }


    private void fillMatrix() {
        int value = 0;
        for (int row = 0; row < this.field.length; row++) {
            for (int col = 0; col < this.field[row].length; col++)
            {
                this.field[row][col] = value++;
            }
        }
    }

    public int getLength() {
        return this.field.length;
    }

    public int getInnerLength(int dimension) {
        return  this.field[dimension].length;
    }
    public int getFieldValue(int row, int column){
        return  this.field[row][column];
    }
}
