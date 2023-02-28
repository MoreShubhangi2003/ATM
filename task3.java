import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
class ATM{
        String username="",userpin="",status,history="";
        int count=0;
        double balance,amount,limit=10000;
        String login="Login Successful";
        String nologin="Login Failed";

        public boolean create(){
                Scanner sc=new Scanner(System.in);
                System.out.println("*********************************");
                System.out.println("Enter the details to register your account:");
                System.out.println("Enter valid username: (username must be short):");
                this.username=sc.next();
                System.out.println("Enter userpin:");
                this.userpin=sc.next();
                System.out.println("Enter amount to be deposited to create an account:");
                this.balance=sc.nextDouble();
                if(balance<0){
                        System.out.println("Invalid amount!");
                        return false;
                }
                else{
                        return true;
                }
        }
        public boolean details()
        {
                Scanner sc=new Scanner(System.in);
                String username1,userpin1;
                System.out.println("*********************************");
                System.out.println();
                System.out.println("LOGIN");
                System.out.println();
                System.out.println("Enter correct username and userpin to login to your account:");
                System.out.println("Enter username:");
                username1=sc.next();
                System.out.println("Enter userpin:");
                userpin1=sc.next();
                if(username.equals(username1) && userpin.equals(userpin1))
                {
                        System.out.println(login);
                        System.out.println();
                        System.out.println("*********************************");
                        return true;
                }
                else{
                        System.out.println(nologin);
                        System.out.println();
                        System.out.println("*********************************");
                        return false;
                }

        }
        public void withdraw(){
                Scanner sc=new Scanner(System.in);
                System.out.println("*********************************");
                System.out.println("Enter amount to be withdrawn:");
                amount=sc.nextDouble();
                if(amount<=balance && balance!=0)
                {
                        count++;
                        balance-=amount;
                        System.out.println();
                        System.out.println("Balance after withdrawal is: "+balance);
                        status="Time: "+LocalTime.now()+" Date:"+LocalDate.now()+" Debited:"+amount;
                        history=history.concat(status);
                        System.out.println();
                        System.out.println("*********************************");
                }
                else{
                        System.out.println("Amount cannot be debited due to insufficient balance!");
                        System.out.println("*********************************");
                }
        }
        public void deposit(){
                Scanner sc=new Scanner(System.in);
                System.out.println("*********************************");
                System.out.println("Enter amount to be deposited:");
                amount=sc.nextDouble();
                if(amount<=limit)
                {
                        count++;
                        balance+=amount;
                        System.out.println();
                        System.out.println("Balance after depositing is: "+balance);
                        status="Time: "+LocalTime.now()+" Date:"+LocalDate.now()+" Credited:"+amount;
                        history=history.concat("\n"+status);
                        System.out.println();
                        System.out.println("*********************************");
                }
                else{
                        System.out.println();
                        System.out.println("Amount cannot be credited due to exceeded limit!");
                        System.out.println("*********************************");
                }
        }
        public void transfer(){
                Scanner sc= new Scanner(System.in);
                System.out.println("*********************************");
                System.out.println("Enter username of Recipient:");
                String rec=sc.next();
                System.out.println("Enter amount to be transfered:");
                amount=sc.nextDouble();
                if(amount<=balance && amount<=limit)
                {
                        count++;
                        balance-=amount;
                        System.out.println();
                        System.out.println("Rs. "+amount+" transferred to "+rec);
                        System.out.println();
                        status="Time: "+LocalTime.now()+" Date:"+LocalDate.now()+" Transfer of Rs. "+amount+" to "+rec;
                        history=history.concat("\n"+status);
                        System.out.println("*********************************");
                }
                else{
                        System.out.println("Could'nt transfer amount!");
                        System.out.println("*********************************");
                }
        }
        public void transactionhistory(){
                System.out.println();
                System.out.println("Transaction History is: ");
                System.out.println();
                if(count!=0)
                {
                        System.out.println("\n"+history+"\n"+"Current Balance:"+balance);
                        System.out.println("*********************************");
                }
                else{
                        System.out.println("No transactions! "+"Current Balance:"+balance);
                        System.out.println("*********************************");
                }
        }

}
public class task3
{
        public static void main(String[] args) {
                Scanner sc=new Scanner(System.in);
                ATM a=new ATM();
                boolean check1 = a.create();
                if(!check1){
                        System.out.println("Invalid balance!!!");
                        return;
                }
                boolean check2 =  a.details();
                int ch;
                char c;


                if(!check2){
                        System.out.println("Login failed !!!!!");
                        return;
                }


                do{
                        System.out.println("1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Transaction history \n \n Enter your choice:");
                        ch=sc.nextInt();
                        switch(ch){
                                case 1: a.withdraw();
                                        break;
                                case 2:a.deposit();
                                        break;
                                case 3:a.transfer();
                                        break;
                                case 4:a.transactionhistory();
                                        break;
                                default:System.out.println("Invalid choice:");
                                        break;
                        }
                        System.out.println("Do you wish to continue:(y/n)");
                        c=sc.next().charAt(0);
                }
                while(c=='Y' || c=='y');
                if(c=='n' || c=='N')
                {
                        System.out.println("Logged out!");
                }
        }
}
