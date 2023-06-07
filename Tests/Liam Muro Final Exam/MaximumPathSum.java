import java.io.File;
import java.util.Scanner;

public class MaximumPathSum {

    public static int[] getTriangleArr(String fileName) throws java.io.FileNotFoundException {
        int numInts = 0;

        Scanner scTri = new Scanner(new File(fileName));

        while (scTri.hasNextInt()) {
            numInts++;
            scTri.nextInt();
        }

        int[] triangleArr = new int[numInts];

        scTri = new Scanner(new File(fileName));

        for (int i = 0; i < numInts; i++) {
            triangleArr[i] = scTri.nextInt();
        }


        scTri.close();

        return triangleArr;
    }

    public static int getNumRows(int[] triangle) {
        double numRows = ((-1 + Math.sqrt(1 + (8 * triangle.length)))/2);
    
        return (int)numRows;
    }

    public static int getFirstEntry(int line) {
        double lineIndex = ((Math.pow(2 * line + 1, 2) - 1) / 8);
        
    
        return (int)lineIndex;
    }

    public static int getMax(int[] triangle) {
        int[] maxValCache = new int[triangle.length];
        for (int i = 0; i < maxValCache.length; i++) {
            maxValCache[i] = -1;
        }
        int temp = getMaxHelper(triangle,maxValCache,0,0);
        // System.out.println(Arrays.toString(maxValCache));
        return temp;

    }

    public static int getMaxHelper(int[] triangle, int[] valCache, int line, int entry){
        if (line >= getNumRows(triangle)) {
            // return triangle[getFirstEntry(line - 1) + entry];
            return 0;
        }

        if (valCache[getFirstEntry(line) + entry] > -1) {
            return valCache[getFirstEntry(line) + entry];
        }  

        int leftMax = getMaxHelper(triangle, valCache, line + 1, entry);
        int rightMax = getMaxHelper(triangle, valCache, line + 1, entry + 1);

        if (leftMax > rightMax) {
            valCache[getFirstEntry(line) + entry] = leftMax + triangle[getFirstEntry(line) + entry];
        } else {
            valCache[getFirstEntry(line) + entry] = rightMax + triangle[getFirstEntry(line) + entry];
        }
        return valCache[getFirstEntry(line) + entry];

        
    }
    public static void main(String[] args) throws java.io.FileNotFoundException {
        // Scanner console = new Scanner(System.in);
        // System.out.print("Triangle file: ");
        // int[] triangleArr = getTriangleArr(console.nextLine());
        // console.close();

        int[] triangleArr = getTriangleArr(args[0]);

        // System.out.println("Number of entries: " + triangleArr.length);
        // System.out.println("Number of rows: " + getNumRows(triangleArr));
        // System.out.println(getFirstEntry(0) + ", " + triangleArr[getFirstEntry(0)]);

        System.out.println("\tmax: " + getMax(triangleArr));


    }
}
