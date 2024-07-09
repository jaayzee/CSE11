class AveragePositives {
    public static void main(String[] args) {
        double sum = 0;
        double posNum = 0;
        for (int i = 0; i < args.length; i++)
        {
            if (Double.parseDouble(args[i]) > 0) {
                sum += Double.parseDouble(args[i]);
                posNum += 1;
            } else {
                sum += 0;
            }
        }
        if(sum == 0 && posNum == 0) {
            System.out.println(0);
        } else {
            System.out.println(sum/posNum);
        }   
    }
}