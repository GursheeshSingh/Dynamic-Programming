public class Knapsack {

    private static int[] profits;
    private static int[] weights;
    private static int[] states;
    private static int k[][];

    private static final int TOTAL_BAG_CAPACITY = 8;
    private static final int NUMBER_OF_OBJECTS = 4;

    //    public static final int NONE = 0;
    private static final int NOT_INCLUDED = 0;
    private static final int INCLUDED = 1;

    public static void main(String[] args) {

        profits = new int[]{0, 1, 2, 5, 6};
        weights = new int[]{0, 2, 3, 4, 5};
        states = new int[]{0, 0, 0, 0, 0, 0,};

        k = new int[NUMBER_OF_OBJECTS + 1][TOTAL_BAG_CAPACITY + 1];

        int object, bagCapacity;

        for (object = 0; object <= NUMBER_OF_OBJECTS; object++) {

            for (bagCapacity = 0; bagCapacity <= TOTAL_BAG_CAPACITY; bagCapacity++) {

                if (isBagCapacityZero(bagCapacity) || isObjectZero(object)) {
                    k[object][bagCapacity] = 0;
                } else if (isBagUnderweightOrFull(weights[object], bagCapacity)) {
                    k[object][bagCapacity] = Math.max(
                            profits[object] + k[object - 1][bagCapacity - weights[object]],
                            k[object - 1][bagCapacity]);
                } else {
                    k[object][bagCapacity] = k[object - 1][bagCapacity];
                }
            }

        }

        object = NUMBER_OF_OBJECTS;
        bagCapacity = TOTAL_BAG_CAPACITY;

        System.out.println(k[object][bagCapacity]);

        while (object > 0 || bagCapacity > 0) {
/*
            System.out.println("Object = " + object);
            System.out.println("Capacity = " + bagCapacity);
            System.out.println("Value = " + k[object][bagCapacity]);
*/
            if (k[object][bagCapacity] == k[object - 1][bagCapacity]) {
                states[object] = NOT_INCLUDED;
                System.out.println("Object " + object + " = NOT INCLUDED");
            } else {
                states[object] = INCLUDED;
                System.out.println("Object " + object + " = INCLUDED");
                bagCapacity = bagCapacity - weights[object];
            }
            object--;
        }

    }

    private static boolean isBagCapacityZero(int bagCapacity) {
        return (bagCapacity == 0);
    }

    private static boolean isObjectZero(int object) {
        return (object == 0);
    }

    // Underweight - Less weight than it can hold
    // Full - At full Capacity
    private static boolean isBagUnderweightOrFull(int objectWeight, int bagCapacity) {
        return (objectWeight <= bagCapacity);
    }
}
