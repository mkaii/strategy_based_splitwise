import java.util.ArrayList;
import java.util.Scanner;

class User
{
    private String name;
    private int debit;
    private int credit;
    private String email;
    private String mobile_no;



    //more constructors could be created by overloading

    User(String name, String mobile_no)
    {
        this.name=name;
        this.email=email;
        this.mobile_no= mobile_no;
    }
    String get_name()
    {
        return this.name;
    }
    int  get_credit()
    {
        return this.credit;
    }
    void  set_credit(double x)
    {
        this.credit+=x;
    }

    int  get_debit()
    {
        return this.debit;
    }
    void  set_debit(double x)
    {
        this.debit+=x;
    }
}


interface IshareDebit
{
    void slpitMoney();
}

class percentage implements IshareDebit
{
    public void slpitMoney()//y was this made public
    {
        System.out.println("here at percentage");
    }
}

class equal implements IshareDebit
{
    public void slpitMoney()//y was this made public
    {
        System.out.println("here at equally");
    }
}

class group
{
    //member variables
    static int total_groups;
    private int number_of_users;
    private double group_expense;

    private ArrayList<User> arr=new ArrayList<User>();




    IshareDebit i1=new percentage();


    //constructor
    //evrey time a group object is created a constructor should be invoked
    group()
    {
        total_groups++;
    }

    //methods of the group class

    //number of Users in this group
    int get_number_of_users()
    {
        return number_of_users;
    }

    //add user to a group
    void add_user(User user)
    {
        arr.add(user);
        number_of_users++;
    }

    //remove user from a group
    void remove(String match)
    {

        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).get_name() == match)
            {
                arr.remove(i);
                number_of_users--;
                break;
            }
        }

    }

    //display group members
    void all_group_members_right_now()
    {
        for(int i=0;i<arr.size();i++)
        {
            String name=arr.get(i).get_name();
            System.out.println(name + " is present");
        }
    }

    //set group transcation amount
    void set_group_expense()
    {
        System.out.println("State your group expense");
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        this.group_expense+=x;


    }
    //display group_expense at any moment
    void display_current_group_expense()
    {
        System.out.println("group expense is "+ group_expense + " right now");
    }


    //start processing amount for each group
    void process()
    {
        /*
        double x=group_expense/number_of_users;
        for(int i=0;i<arr.size();i++)
        {
            arr.get(i).set_debit(x);
        }*/
        i1.slpitMoney();
    }

    void display_credit_debit_table()
    {
        for(int i=0;i<arr.size();i++)
        {
            User user =arr.get(i);
            //get this users name debit and credit
            String name=user.get_name();
            int credit=user.get_credit();
            int debit=user.get_debit();

            //print these values
            System.out.println("User name : "+name);
            System.out.println(name+"'s debit : "+debit);
            System.out.println(name+"'s credit : "+credit);
            System.out.println();

        }
    }

    //someone paid
    void paid()
    {
        //if i take input here it gives me error ask doubt
        //if i take input here it gives me error ask doubt
        String match;
        int amount;
        Scanner sc=new Scanner(System.in);
        match=sc.next();
        amount=sc.nextInt();

        int i;
        for(i=0;i<arr.size();i++)
        {

            if(arr.get(i).get_name().equals(match))
            {
                System.out.println(match +" paid "+amount+" to the expense");
                System.out.println();
                break;
            }
        }
        arr.get(i).set_credit(amount);
        this.group_expense-=amount;


    }


    void inter_transaction(String name1,String name2,double amount)
    {

        int i;
        for(i=0;i<arr.size();i++)
        {

            if(arr.get(i).get_name() == name1)
            {
                arr.get(i).set_credit(amount);



            }
            else if(arr.get(i).get_name() == name2)
            {
                arr.get(i).set_debit(amount);
            }
        }
    }


}

public class strategy_process {

    public static void main(String[] args)
    {
        // create some users
        User user1 =new User("mainak","9899971695");// create first user
        User user2 =new User("lala","9899971696");// create second user
        User user3 =new User("yash","9899971697");// create third user
        User user4 =new User("anurag","9899971690");
        User user5 =new User("akash","9899971693");

        //create a group object
        group g1=new group();

        g1.add_user(user1);//add user1
        g1.add_user(user2);//add user2
        g1.add_user(user3);//add user3
        g1.add_user(user4);//add user3
        g1.add_user(user5);//add user3

        int count=g1.get_number_of_users();
        System.out.println(" number of users in g1 group are "+ count);


        g1.remove("yash");
        count=g1.get_number_of_users();
        System.out.println(" number of users in g1 group are "+ count);

        //check no of groups created
        System.out.println(group.total_groups);
        //print all group members
        g1.all_group_members_right_now();


        // involve money now
        //group expense: group ko itne paise dene hain
        //*************
        g1.set_group_expense();
        g1.display_current_group_expense();


        //process the amount of the group
        g1.process();
        //***************
        //g1.display_credit_debit_table();

        //g1.paid();//someone paid something for the group_expense

        //g1.display_credit_debit_table();//to check changes

        //suppose there is an inter_group_transaction
        // best way is to create new group


        g1.inter_transaction("mainak","lala",100);



    }
}
