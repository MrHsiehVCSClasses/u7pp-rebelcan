package u7pp;

//factorial of 0 will always be 1 but besides that it's just basic math lol
//multiple current number with number less than one
public class RecursiveFunctions {
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
//use power function from math to multiply base with base raised to a power lower than the original
    public static double pow(double base, int power) {
        if (power == 0) {
            return 1;
        } else {
            return base * pow(base, power - 1);
        }
    }
//if number is 1, then no fibonacci sequence. makes sure number is increasing at an increment of 1 while being added to the number right before it.
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
//checks whether or not the first character of the word matches the one at the end of the string
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        } else {
            String subStr = str.substring(1, str.length() - 1);
            return isPalindrome(subStr);
        }
    }
    //checks if the next number in line is double of the original number 
    public static int nextIsDouble(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return 0;
        } else if (arr[index] * 2 == arr[index + 1]) {
            return 1 + nextIsDouble(arr, index + 1);
        } else {
            return nextIsDouble(arr, index + 1);
        }
    }
    public static String getBinary(int num) {
        if (num <= 1) {
            return Integer.toString(num);
        } else {
            return getBinary(num / 2) + Integer.toString(num % 2);
        }
    }
    //checks whether the number is in the middle
    public static int binarySearch(int[] arr, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
    
        int mid = left + (right - left) / 2;
    
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return binarySearch(arr, value, mid + 1, right);
        } else {
            return binarySearch(arr, value, left, mid - 1);
        }
    }
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        // check if the starting cell is on the map's borders
        if (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length - 1) {
            return true;
        }
        
        // check if the starting cell is surrounded by higher or equal cells
        int currElevation = map[row][col];
        if (row > 0 && map[row-1][col] >= currElevation
                && row < map.length - 1 && map[row+1][col] >= currElevation
                && col > 0 && map[row][col-1] >= currElevation
                && col < map[0].length - 1 && map[row][col+1] >= currElevation) {
            return false;
        }
        
        // try to move to adjacent cells with lower elevation
        if (row > 0 && map[row-1][col] < currElevation && canFlowOffMap(map, row-1, col)) {
            return true;
        }
        if (row < map.length - 1 && map[row+1][col] < currElevation && canFlowOffMap(map, row+1, col)) {
            return true;
        }
        if (col > 0 && map[row][col-1] < currElevation && canFlowOffMap(map, row, col-1)) {
            return true;
        }
        if (col < map[0].length - 1 && map[row][col+1] < currElevation && canFlowOffMap(map, row, col+1)) {
            return true;
        }
        
        // if no path to the border was found
        return false;
    }
    
            
    
}
