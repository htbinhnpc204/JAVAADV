public class Bai23 {
        public boolean hoanhao(int n){
            int sum=0;
            for(int i=1;i<n;i++)
                if(n%i==0)
                    sum+=i;
            if (sum==n)
                return true;
            return false;
        }
        public void in (){
            System.out.println("cac so hoan hao <1000 la:");
            for (int i=1;i<=10000;i++)
                if(hoanhao(i))
                    System.out.println(i);
        }
        public static void main(String[] args) {
            Bai23 hh= new Bai23();
            hh.in();
        }
    }

