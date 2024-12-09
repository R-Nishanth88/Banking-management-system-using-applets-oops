package Practise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

interface Accountable {
    void Withdraw();

    void Deposit();

    void Details();
}

abstract class Account implements Accountable {
    String AccountHolders_name;
    String Sex;
    int AccountNumber;
    String AccountType;
    String PhoneNo;
    String Address;
    long Dob;
    double balance;
    String IFSC;
    String Branch_name;

    void Check_Balance() {
        JOptionPane.showMessageDialog(null, "Your Current Balance is: Rs " + balance);
    }

}

class SavingsAccount extends Account {
    final int RateOfInterest = 3;
    final String AccountType = "Savings Account";
    double temp;

    public void Withdraw() {
        temp = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount to be Withdrawn: "));
        if (temp > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance..!!");
            return;
        } else if (temp > 20000) {
            JOptionPane.showMessageDialog(null, "Withdraw Amount Exceeded, must be below 20,000");
            return;
        } else {
            balance -= temp;
            JOptionPane.showMessageDialog(null, "Withdrawn Successfully..!!  Rs" + temp + " Debited from your Account");
        }
    }

    public void Deposit() {
        temp = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount to Deposit: "));
        balance += temp;
        JOptionPane.showMessageDialog(null, "Deposited Successfully...!!   Rs" + temp + " Credited to your Account.");
    }

    public void Details() {
        JOptionPane.showMessageDialog(null, "Name: " + AccountHolders_name + "\nAccount Number: " + AccountNumber +
                "\nAccountType: " + AccountType + "\nSex: " + Sex + "\nAddress: " + Address + "\nPhone Number: " +
                PhoneNo + "\nBranch Name: " + Branch_name + "\nIFSC: " + IFSC);
    }
}

class CurrentAccount extends Account {
    final int RateOfInterest = 5;
    final String AccountType = "Current Account";
    double temp;

    public void Withdraw() {
        temp = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount to be Withdrawn: "));
        if (temp > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance..!!");
            return;
        } else if (temp > 50000) {
            JOptionPane.showMessageDialog(null, "Withdraw Amount Exceeded, must be below 50,000");
            return;
        } else {
            balance -= temp;
            JOptionPane.showMessageDialog(null, "Withdrawn Successfully..!!");
        }
    }

    public void Deposit() {
        temp = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount to Deposit: "));
        balance += temp;
    }

    public void Details() {
        JOptionPane.showMessageDialog(null, "Name: " + AccountHolders_name + "\nAccount Number: " + AccountNumber +
                "\nAccountType: " + AccountType + "\nSex: " + Sex + "\nAddress: " + Address + "\nPhone Number: " +
                PhoneNo + "\nBranch Name: " + Branch_name + "\nIFSC: " + IFSC);
    }
}

class Customer extends SavingsAccount {
    public Customer() {
        JOptionPane.showMessageDialog(null, "Please Enter the Following Details\n");
        AccountHolders_name = JOptionPane.showInputDialog("Enter Your Name: "); 
        boolean validDate = false;
        while (!validDate) {
            String dobString = JOptionPane.showInputDialog("Date Of Birth(dd/mm/yyyy): ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dobDate = dateFormat.parse(dobString);
                Dob = dobDate.getTime();
                validDate = true; // Set flag to true to exit the loop
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in the format dd/mm/yyyy.");
            }
        }
        Address = JOptionPane.showInputDialog("Enter Your Address: ");
        PhoneNo = JOptionPane.showInputDialog("Phone Number: ");
        balance = Double.parseDouble(JOptionPane.showInputDialog("Initial Balance: "));
    }
}

class Customer2 extends CurrentAccount {
    public Customer2() {
        JOptionPane.showMessageDialog(null, "Please Enter the Following Details\n");
        AccountHolders_name = JOptionPane.showInputDialog("Enter Your Name: ");
        boolean validDate = false;
        while (!validDate) {
            String dobString = JOptionPane.showInputDialog("Date Of Birth(dd/mm/yyyy): ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dobDate = dateFormat.parse(dobString);
                Dob = dobDate.getTime();
                validDate = true; // Set flag to true to exit the loop
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in the format dd/mm/yyyy.");
            }
        }
        Address = JOptionPane.showInputDialog("Enter Your Address: ");
        PhoneNo = JOptionPane.showInputDialog("Phone Number: ");
        balance = Double.parseDouble(JOptionPane.showInputDialog("Initial Balance: "));
    }
}

public class BankingSystem extends JFrame {
    static final String KOL_IFSC;
    static final String SRP_IFSC;
    static final String RIS_IFSC;
    static final String BAN_IFSC;
    static String[] UserName = new String[10];
    static String[] password = new String[10];
    static String[] UserName2 = new String[10];
    static String[] password2 = new String[10];
    static Customer[] cs = new Customer[10];
    static Customer2[] cs2 = new Customer2[10];
    static int top = 0, top2 = 0;

    static {
        KOL_IFSC = "KOL0076341";
        SRP_IFSC = "SRP70048353";
        RIS_IFSC = "RIS0037462";
        BAN_IFSC = "BAN00087945";
    }

    public static void main(String... args) {
        new BankingSystem();
    }

    public BankingSystem() {
        setTitle("Banking System");
        setSize(900, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("WELCOME TO THE BANK OF AMRITA");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton registerButton = new JButton("New User Registration");
        JButton loginButton = new JButton("Old User Login");
        JButton exitButton = new JButton("Exit");

        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));

        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = Integer.parseInt(JOptionPane.showInputDialog("Which Account Would You Like to Open:\n1. Savings\n2. Current"));
                switch (choice) {
                    case 1:
                        cs[top] = new Customer();
                        String[] branches = {"Kolkata", "Bangalore", "Mumbai", "Chennai"};
                        int branchChoice = JOptionPane.showOptionDialog(null, "Select your Branch",
                                "Branch", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, branches, branches[0]);
                        switch (branchChoice) {
                            case 0:
                                cs[top].IFSC = KOL_IFSC;
                                cs[top].Branch_name = "Kolkata";
                                break;
                            case 1:
                                cs[top].IFSC = SRP_IFSC;
                                cs[top].Branch_name = "Bangalore";
                                break;
                            case 2:
                                cs[top].IFSC = RIS_IFSC;
                                cs[top].Branch_name = "Mumbai";
                                break;
                            case 3:
                                cs[top].IFSC = BAN_IFSC;
                                cs[top].Branch_name = "Chennai";
                                break;
                            default:
                                cs[top].IFSC = BAN_IFSC;
                                cs[top].Branch_name = "Chennai";
                                break;
                        }

                        String[] genders = {"MALE", "FEMALE", "OTHERS"};
                        int genderChoice = JOptionPane.showOptionDialog(null, "Select your Gender",
                                "Gender", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, genders, genders[0]);
                        cs[top].Sex = genders[genderChoice];

                        while (true) {
                            boolean flag2 = false;
                            String user = JOptionPane.showInputDialog("Enter Your Username: ");
                            String pass = JOptionPane.showInputDialog("Create Your Password: ");
                            for (int i = 0; i < top; i++) {
                                if (user.equals(UserName[i])) {
                                    flag2 = true;
                                    break;
                                }
                            }
                            for (int i = 0; i < top2; i++) {
                                if (user.equals(UserName2[i])) {
                                    flag2 = true;
                                    break;
                                }
                            }
                            if (flag2) {
                                JOptionPane.showMessageDialog(null, "This Username Already Exists... Please Try Again..!!");
                            } else {
                                UserName[top] = user;
                                password[top] = pass;
                                break;
                            }
                        }
                        cs[top].AccountNumber = 647386532 + top;
                        JOptionPane.showMessageDialog(null, "Your Account has been Successfully Created...!!");
                        top++;
                        break;

                    case 2:
                        cs2[top2] = new Customer2();
                        branches = new String[]{"Kolkata", "Bangalore", "Mumbai", "Chennai"};
                        branchChoice = JOptionPane.showOptionDialog(null, "Select your Branch",
                                "Branch", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, branches, branches[0]);
                        switch (branchChoice) {
                            case 0:
                                cs2[top2].IFSC = KOL_IFSC;
                                cs2[top2].Branch_name = "Kolkata";
                                break;
                            case 1:
                                cs2[top2].IFSC = SRP_IFSC;
                                cs2[top2].Branch_name = "Bangalore";
                                break;
                            case 2:
                                cs2[top2].IFSC = RIS_IFSC;
                                cs2[top2].Branch_name = "Mumbai";
                                break;
                            case 3:
                                cs2[top2].IFSC = BAN_IFSC;
                                cs2[top2].Branch_name = "Chennai";
                                break;
                            default:
                                cs2[top2].IFSC = BAN_IFSC;
                                cs2[top2].Branch_name = "Chennai";
                                break;
                        }

                        genders = new String[]{"MALE", "FEMALE", "OTHERS"};
                        genderChoice = JOptionPane.showOptionDialog(null, "Select your Gender",
                                "Gender", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, genders, genders[0]);
                        cs2[top2].Sex = genders[genderChoice];

                        while (true) {
                            boolean flag2 = false;
                            String user = JOptionPane.showInputDialog("Enter Your Username: ");
                            String pass = JOptionPane.showInputDialog("Create Your Password: ");
                            for (int i = 0; i < top; i++) {
                                if (user.equals(UserName[i])) {
                                    flag2 = true;
                                    break;
                                }
                            }
                            for (int i = 0; i < top2; i++) {
                                if (user.equals(UserName2[i])) {
                                    flag2 = true;
                                    break;
                                }
                            }
                            if (flag2) {
                                JOptionPane.showMessageDialog(null, "This Username Already Exists... Please Try Again..!!");
                            } else {
                                UserName2[top2] = user;
                                password2[top2] = pass;
                                break;
                            }
                        }
                        cs2[top2].AccountNumber = 38273925 + top;
                        JOptionPane.showMessageDialog(null, "Your Account has been Successfully Created...!!");
                        top2++;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "You have Entered the Wrong choice...!!");
                        break;
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    String user = JOptionPane.showInputDialog("Username: ");
                    String pass = JOptionPane.showInputDialog("Password: ");
                    int index = -1, flag = 0;
                    for (int i = 0; i <= top; i++) {
                        if (user.equals(UserName[i])) {
                            index = i;
                            flag = 0;
                            break;
                        }
                    }
                    for (int i = 0; i <= top2; i++) {
                        if (user.equals(UserName2[i])) {
                            index = i;
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        if (index != -1 && pass.equals(password[index])) {
                            JOptionPane.showMessageDialog(null, "You Have Successfully logged in...");
                            performTransactions(cs[index]);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Username or password...!!");
                            JOptionPane.showMessageDialog(null, "Please Login Again..");
                        }
                    } else {
                        if (index != -1 && pass.equals(password2[index])) {
                            JOptionPane.showMessageDialog(null, "You Have Successfully logged in...");
                            performTransactions(cs2[index]);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Username or password...!!");
                            JOptionPane.showMessageDialog(null, "Please Enter Again..");
                        }
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Good byee.... Thanks For Using Our Banking System...Please visit again..!!");
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void performTransactions(Account account) {
        while (true) {
            String[] options = {"Withdraw", "Deposit", "Transfer", "Check Balance", "Details", "Change Password", "Close Account", "Logout"};
            int choice = JOptionPane.showOptionDialog(null, "Please select an action:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    account.Withdraw();
                    break;
                case 1:
                    account.Deposit();
                    break;
                case 2:
                    transferFunds(account);
                    break;
                case 3:
                    account.Check_Balance();
                    break;
                case 4:
                    account.Details();
                    break;
                case 5:
                    String newPassword = JOptionPane.showInputDialog("Enter New Password: ");
                    if (account instanceof SavingsAccount)
                        password[getIndex(UserName, account.AccountHolders_name)] = newPassword;
                    else
                        password2[getIndex(UserName2, account.AccountHolders_name)] = newPassword;
                    JOptionPane.showMessageDialog(null, "Password Changed Successfully...!!");
                    break;
                case 6:
                    int index = getIndex(UserName, account.AccountHolders_name);
                    if (account instanceof SavingsAccount) {
                        cs[index] = null;
                        UserName[index] = null;
                        password[index] = null;
                    } else {
                        cs2[index] = null;
                        UserName2[index] = null;
                        password2[index] = null;
                    }
                    JOptionPane.showMessageDialog(null, "Account Closed Successfully...!!");
                    return;
                case 7:
                    JOptionPane.showMessageDialog(null, "Logged Out Successfully...!!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "You Have Entered the Wrong Choice..!!  Please Enter Again..");
                    break;
            }
        }
    }

    private void transferFunds(Account account) {
        String user = JOptionPane.showInputDialog("Enter the Username of the Receiving Account: ");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount to be Transferred: "));
        int index = getIndex(UserName, user);
        if (index != -1) {
            if (account.balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance to Transfer...!!!");
                return;
            } else {
                account.balance -= amount;
                cs[index].balance += amount;
                JOptionPane.showMessageDialog(null, "Successfully Transferred Rs" + amount + " to " + cs[index].AccountHolders_name);
                return;
            }
        }
        index = getIndex(UserName2, user);
        if (index != -1) {
            if (account.balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance to Transfer...!!!");
                return;
            } else {
                account.balance -= amount;
                cs2[index].balance += amount;
                JOptionPane.showMessageDialog(null, "Successfully Transferred Rs" + amount + " to " + cs2[index].AccountHolders_name);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "The Account with Username " + user + " does not exists..!!");
    }

    private int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
