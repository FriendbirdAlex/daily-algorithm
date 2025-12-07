class Solution {
    public double average(int[] salary) {
        double a=salary.length;
        double max=0;
        double min=salary[0];
        double total=0;
        for(int i =0;i<a;i++){
            if(salary[i]<min){
                min=salary[i];
            }
            if(salary[i]>max){
                max=salary[i];
            }
            total+=salary[i];
        }
        double avg =(total-max-min)/(a-2);
        return avg;
    }
}