public int calPoints(String[] ops) {
    int[] arr = new int[1000];
    int i = 0;

    for (String op : ops) {
        switch (op) {
            case "+":
                arr[i] = arr[i - 1] + arr[i - 2];
                i++;
                break;
            case "D":
                arr[i] = arr[i - 1] * 2;
                i++;
                break;
            case "C":
                i--;
                break;
            default:
                arr[i] = Integer.parseInt(op);
                i++;
                break;
        }
    }

    int sum = 0;
    for (int j = 0; j < i; j++) {
        sum += arr[j];
    }
    return sum;
}