/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import ADT.*;
import domain.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MY
 */
public class MainProgram {

    EmployeeListInterface<DeliveryMan> DMList = new EmployeeList<>();
    EmployeeListInterface<Admin> ADList = new EmployeeList<>();
    EmployeeListInterface<HR> HRList = new EmployeeList<>();
    EmployeeListInterface<WorkStatus> wsList = new EmployeeList<>();
    private Employee loginStaff;
    Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    // All Menu Start
    public void menu() {

        String selection = "-1";
        System.out.println("**************************************");
        System.out.println("*Welcome to Faster Deliverymen System*");
        System.out.println("**************************************");
        System.out.println("Please Select The Option Below");
        System.out.println("1. Affiliate Register");
        System.out.println("2. Staff Login");
        System.out.println("3. Customer Login");
        System.out.println("4. Affiliate Login");
        System.out.println("0. Exit");
        while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("0")) {
            System.out.print("Option: ");
            selection = s.nextLine();
            switch (selection) {
                case "1": {
                    //create class at module A and import the module A at this class and den call the method from here
                    //A.RestaurantRegistration();
                    menu();
                    break;
                }
                case "2": {
                    staffMenu();    //calling staff menu interface
                    menu();
                    break;
                }
                case "3": {
                    //C.CustomerLogin();
                    menu();
                    break;
                }
                case "4": {
                    //A.RestaurantLogin(r);
                    /*
                    if (a) {
                        RestaurantMenu(restaurant);
                    }
                     */
                    break;
                }
                case "0": {
                    System.out.println("GoodBye.");
                    break;
                }
                default: {
                    System.out.println("Error, Please Key In Again.\n");
                    break;
                }
            }
        }
    }

    public void staffMenu() {
        Scanner s = new Scanner(System.in);
        boolean login = false;
        while (login == false) {
            System.out.println("*********************************");
            System.out.println("*Welcome to Staff Menu Interface*");
            System.out.println("*********************************");
            System.out.print("Please Enter Staff ID (-1 to back): ");
            String username = s.nextLine();
            if (!username.equals("-1")) {
                boolean success = StaffLogin(username.toUpperCase());
                if (success) {
                    if (loginStaff instanceof DeliveryMan) {
                        System.out.println("\n\n\n");
                        login = true;
                        DMMenu();
                    } else if (loginStaff instanceof HR) {
                        login = true;
                        System.out.println("\n\n\n");
                        HRMenu();
                    } else if (loginStaff instanceof Admin) {
                        System.out.println("\n\n\n");
                        login = true;
                        AdminMenu();
                    } else {
                        username = "-1";
                        login = true;
                    }
                } else {
                    System.out.println("Error. Username Not Found!Please Try Again.\n\n");
                }
            }
            if (username.equals("-1")) {
                login = true;
                System.out.println("\n\n\n");
            }
        }
    }

    public void DMMenu() {
        DeliveryMan DM = (DeliveryMan) loginStaff;
        String selection = "-1";
        Date date = new Date();
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Welcome Back, " + loginStaff.getStaffName() + "\nCurrent Date:" + dateFormat.format(date) + "\nCurrent Status: " + DM.getCurrentAvailable());  //display login staff information
        System.out.println("\nPlease Select The Option Below");
        System.out.println("1. Clock In / Clock Out \n2. Change Deliver Status \n3. View Deliver Schedule\n4. Update Personal Contact Details\n5. Retrive Customer Details\n0. Log Out");

        while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5") && !selection.equals("0")) {
            System.out.print("Option : ");
            selection = s.nextLine();
            switch (selection) {
                case "1": {
                    // D.DeliveryMenClockInOut(DMList, deliveryMen.getStaffID());
                    break;
                }
                case "2": {
                    // D.ChangeDeliverStatus(DMList, deliveryMen.getStaffID());
                    break;
                }
                case "3": {
                    //D.ViewDeliverSchedule(customer, DMList, order, restaurant, deliveryMen.getStaffID());
                    break;
                }
                case "4": {
                    DeliveryManUpdatePersonalDetails();
                    DMMenu();
                    break;
                }
                case "5": {
                    //C.retrieveCustomer();
                    break;
                }
                case "0": {
                    loginStaff = null;
                    System.out.println("Thank You For Using Our System.\nPress Any Key to Continue...");
                    s.nextLine();
                    System.out.println("\n\n\n");
                    break;
                }
                default: {
                    System.out.println("Please Enter Again...");
                }
            }
        }
    }

    public void AdminMenu() {
        String selection = "-1";
        Date date = new Date();
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Welcome Back, " + loginStaff.getStaffName() + "\nCurrent Date:" + dateFormat.format(date) + "\n");  //display login staff information
        System.out.println("Please Select The Option Below");
        System.out.println("1. View Delivery Man Clock In & Clock Out");
        System.out.println("2. Retrieve Delivery Man Pending Delivery");
        System.out.println("3. Generate Total Deliveries Report");
        System.out.println("4. Generate Total Distance Report");
        System.out.println("0. Log Out");
        while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") & !selection.equals("5") && !selection.equals("0")) {
            System.out.print("Option: ");
            selection = s.nextLine();
            switch (selection) {
                case "1": {
                    //D.ViewDeliverManClockInOut(DMList);
                    AdminMenu();
                    break;
                }
                case "2": {
                    //B.RetrieveDeliveryManPendingDeliveryMenu();
                    AdminMenu();
                    break;
                }
                case "3": {
                    //B.generateTotalDeliveriesReportMenu();
                    AdminMenu();
                    break;
                }
                case "4": {
                    //B.generateTotalDistanceReportMenu();
                    AdminMenu();
                    break;
                }
                case "0": {
                    loginStaff = null;
                    System.out.println("Thank You For Using Our System.\nPress Any Key to Continue...");
                    s.nextLine();
                    System.out.println("\n\n\n");
                    break;
                }
                default: {
                    System.out.println("Please Enter Again...\n");
                    break;
                }
            }
        }
    }

    public void HRMenu() {
        String selection = "-1";
        Date date = new Date();
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Welcome Back, " + loginStaff.getStaffName() + "\nCurrent Date:" + dateFormat.format(date) + "\n"); //display login staff information
        System.out.println("Please Select The Option Below");
        System.out.println("1. Add New Delivery Man");
        System.out.println("2. Add New Admin");
        System.out.println("3. Add New HR");
        System.out.println("4. Update Delivery Man Status");
        System.out.println("5. View Staff Details");
        System.out.println("6. Remove Staff");
        System.out.println("0. Log Out");
        while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5") && !selection.equals("6") && !selection.equals("0")) {
            System.out.print("Option: ");
            selection = s.nextLine();
            switch (selection) {
                case "1": {
                    boolean success = AddNewEmployee(1);
                    if (success) {
                        System.out.println("New Employee Added Successfully.\nPress Enter to Continue...");
                        s.nextLine();
                    }
                    System.out.println("\n\n\n");
                    HRMenu();
                    break;
                }
                case "2": {
                    boolean success = AddNewEmployee(2);
                    if (success) {
                        System.out.println("New Employee Added Successfully.\nPress Enter to Continue...");
                        s.nextLine();
                    }
                    System.out.println("\n\n\n");
                    HRMenu();
                    break;
                }
                case "3": {
                    boolean success = AddNewEmployee(3);
                    if (success) {
                        System.out.println("New Employee Added Successfully.\nPress Enter to Continue...");
                        s.nextLine();
                    }
                    System.out.println("\n\n\n");
                    HRMenu();
                    break;
                }
                case "4": {
                    boolean find = false;
                    String ID = "0";
                    while (!find && !ID.equals("-1")) {
                        System.out.print("Please Enter A Delivery Man ID (-1 to back): ");
                        ID = s.nextLine();
                        find = DeliveryManUpdateStatus(ID.toUpperCase());
                        if (!find) {
                            System.out.println("Delivery Man ID Not Found.Please Try Again.\n");
                        }
                    }
                    HRMenu();
                    break;
                }
                case "5": {
                    boolean find = false;
                    while (find == false) {
                        System.out.print("Please Enter A Staff ID (-1 to back): ");
                        String ID = s.nextLine();
                        if (!ID.equals("-1")) {
                            Employee e = DisplayStaffDetails(ID.toUpperCase());
                            if (e == null) {
                                System.out.println("Error. Staff ID Not Found!");
                            } else {
                                find = true;
                                System.out.printf("Staff ID: %s\n"
                                        + "StaffName: %s\n"
                                        + "Staff Phone No: %s\n"
                                        + "Staff Address: %s\n"
                                        + "Staff Position: %s\n"
                                        + "Staff Status: %s\n"
                                        + "Staff Basic Salary: %.2f\n"
                                        + "Press Enter To Continue...", e.getStaffID(), e.getStaffName(), e.getStaffPhNo(), e.getStaffAdds(), e.getStaffPosition(), e.getWorkingStatus(), e.getBasicSalary());
                                s.nextLine();
                            }
                        } else {
                            find = true;
                        }
                    }
                    HRMenu();
                    break;
                }
                case "6": {
                    boolean find = false;
                    while (find == false) {
                        System.out.print("Please Enter A Staff ID (-1 to back): ");
                        String ID = s.nextLine();
                        if (!ID.equals("-1")) {
                            Employee e = DisplayStaffDetails(ID.toUpperCase());
                            if (e == null) {
                                System.out.println("Error. Staff ID Not Found!");
                            } else {
                                find = true;
                                System.out.printf("Staff ID: %s\n"
                                        + "StaffName: %s\n"
                                        + "Staff Phone No: %s\n"
                                        + "Staff Address: %s\n"
                                        + "Staff Position: %s\n"
                                        + "Staff Status: %s\n"
                                        + "Staff Basic Salary: %.2f\n",
                                        e.getStaffID(), e.getStaffName(), e.getStaffPhNo(), e.getStaffAdds(), e.getStaffPosition(), e.getWorkingStatus(), e.getBasicSalary());
                                boolean success = false;
                                while (!success) {
                                    System.out.print("Are You Sure U Want To Remove This? (Y/N) :");
                                    String confirm = s.nextLine();
                                    try {
                                        if (Character.toUpperCase(confirm.charAt(0)) == 'Y') {
                                            boolean remove = true;
                                            for (int i = 1; i <= wsList.getTotalEntries(); i++) {
                                                if (e.getStaffID().equals(wsList.get(i).getDM().getStaffID())) {
                                                    remove = false;
                                                }
                                            }
                                            if (remove) {
                                                boolean removeSuccessfully = false;
                                                if (e instanceof DeliveryMan) {
                                                    removeSuccessfully = DMList.removeStaff(e.getStaffID());
                                                } else if (e instanceof HR) {
                                                    if (!loginStaff.getStaffID().equals(e.getStaffID())) {
                                                        removeSuccessfully = HRList.removeStaff(e.getStaffID());
                                                    }
                                                } else {
                                                    removeSuccessfully = ADList.removeStaff(e.getStaffID());
                                                }

                                                if (removeSuccessfully) {
                                                    System.out.println("Removed Successfully.\nPress Enter to Continue...");
                                                    s.nextLine();
                                                    success = true;
                                                } else {
                                                    System.out.println("Removed Failed. Please Seek for Help from IT department.\nPress Enter to Continue...");
                                                    s.nextLine();
                                                    success = true;
                                                }
                                            } else {
                                                System.out.println("Remove Failed. The Employee has dependency with the work status.\nPress Enter to Continue....");
                                                success = true;
                                                s.nextLine();
                                            }
                                        } else if (Character.toUpperCase(confirm.charAt(0)) == 'N') {
                                            System.out.println("Operation Stopped by user.\nPress Enter to Continue....");
                                            success = true;
                                            s.nextLine();
                                        } else {
                                            System.out.println("Please Enter Only (Y) or (N).\n");
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Please Do Not Leave It Blank!");
                                    }
                                }
                            }
                        } else {
                            find = true;
                        }
                    }
                    HRMenu();
                    break;
                }
                case "0": {
                    loginStaff = null;
                    System.out.println("\nThank You For Using Our System.\nPress Enter to Continue...");
                    s.nextLine();
                    System.out.println("\n\n\n");
                    break;
                }
                default: {
                    System.out.println("Error, Please Key In Again.");
                    break;
                }
            }
        }
    }
    //All Menu End

    //Miw Start
    public boolean StaffLogin(String username) {   //verify the Staff ussername and password
        boolean login = false;
        for (int i = 1; i <= DMList.getTotalEntries(); i++) {  //verify is it delivery man
            if (DMList.get(i).getStaffID().equals(username)) {   //if found username
                if (DMList.get(i).getWorkingStatus().equals("Employed")) {
                    while (login == false) {
                        System.out.print("Please Enter Password (-1 to back): ");
                        String pw = s.nextLine();
                        if (DMList.get(i).getStaffPw().equals(pw)) { //if password correct
                            login = true;
                            System.out.println("Login As " + DMList.get(i).getStaffPosition() + " Successfully!\nPress Enter to Continue...");
                            s.nextLine();
                            loginStaff = DMList.get(i);
                            return true;
                        } else if (pw.equals("-1")) {  //if back
                            loginStaff = null;
                            return true;
                        } else {
                            System.out.println("Error. Wrong Password Entered!Please Try Again.\n");
                        }
                    }
                } else {
                    System.out.println("The ID Had Already Been Deactivated.\nPress Enter to Continue...");
                    s.nextLine();
                    return true;
                }
            }
        }
        for (int i = 1; i <= HRList.getTotalEntries(); i++) {  //verify is it HR
            if (HRList.get(i).getStaffID().equals(username)) {
                if (DMList.get(i).getWorkingStatus().equals("Employed")) {
                    while (login == false) {
                        System.out.print("Please Enter Password (-1 to back): ");
                        String pw = s.nextLine();
                        if (HRList.get(i).getStaffPw().equals(pw)) { //if password correct
                            login = true;
                            System.out.println("Login As " + HRList.get(i).getStaffPosition() + " Successfully!\nPress Enter to Continue...");
                            s.nextLine();
                            loginStaff = HRList.get(i);
                            return true;
                        } else if (pw.equals("-1")) { //if back
                            loginStaff = null;
                            return true;
                        } else {
                            System.out.println("Error. Wrong Password Entered!Please Try Again.\n");
                        }
                    }
                } else {
                    System.out.println("The ID Had Already Been Deactivated.\nPress Enter to Continue...");
                    s.nextLine();
                    return true;
                }
            }
        }
        for (int i = 1; i <= ADList.getTotalEntries(); i++) {  //verify is it Admin
            if (ADList.get(i).getStaffID().equals(username)) {
                if (DMList.get(i).getWorkingStatus().equals("Employed")) {
                    while (login == false) {

                        System.out.print("Please Enter Password (-1 to back): ");
                        String pw = s.nextLine();
                        if (ADList.get(i).getStaffPw().equals(pw)) { //if password correct
                            login = true;
                            System.out.println("Login As " + ADList.get(i).getStaffPosition() + " Successfully!\nPress Enter to Continue...");
                            s.nextLine();
                            loginStaff = ADList.get(i);
                            return true;
                        } else if (pw.equals("-1")) {  //if back
                            loginStaff = null;
                            return true;
                        } else {
                            System.out.println("Error. Wrong Password Entered!Try Again.\n");
                        }
                    }
                } else {
                    System.out.println("The ID Had Already Been Deactivated.\nPress Enter to Continue...");
                    s.nextLine();
                    return true;
                }
            }
        }
        return false;   //username not found
    }

    public Employee DisplayStaffDetails(String StaffID) {
        boolean find = false;
        Employee e = DMList.getEmployeeDetails(StaffID);
        if (e == null) {
            e = HRList.getEmployeeDetails(StaffID);
        }
        if (e == null) {
            e = ADList.getEmployeeDetails(StaffID);
        }
        return e;
    }

    public boolean AddNewEmployee(int choice) {
        String ID = null;
        Calendar joinDate = Calendar.getInstance();
        if (choice == 1) {    //Delivery Man
            ID = String.format("DM%06d", DMList.getTotalEntries() + 1);
        } else if (choice == 2) {  //Admin
            ID = String.format("AD%06d", ADList.getTotalEntries() + 1);
        } else {  //HR
            ID = String.format("HR%06d", HRList.getTotalEntries() + 1);
        }
        System.out.println("\n\nID: " + ID + "(This will be the username)");
        System.out.println("You can exit this interface anytime by enter (-1)");
        System.out.print("Enter Password: ");
        String Pw = s.nextLine();
        if (Pw.equals("-1")) {
            return false;
        }
        System.out.print("Enter Name: ");
        String Name = s.nextLine();
        if (Name.equals("-1")) {
            return false;
        }
        System.out.print("Enter IC: ");
        String IC = s.nextLine();
        if (IC.equals("-1")) {
            return false;
        }
        boolean PhNoFormat = false;
        String PhNo = "";
        while (!PhNoFormat) {
            PhNoFormat = true;
            System.out.print("Enter Phone No: ");
            PhNo = s.nextLine();
            if (PhNo.equals("-1")) {
                return false;
            }
            if (PhNo.length() < 11) {
                PhNoFormat = false;
            }
            for (int i = 0; i < PhNo.length(); i++) {
                if (!Character.isDigit(PhNo.charAt(i))) {
                    if (i != 3) {
                        PhNoFormat = false;
                    } else {
                        if (PhNo.charAt(i) != '-' && PhNo.charAt(i) != ' ') {
                            PhNoFormat = false;
                        }
                    }
                }
            }
            if (!PhNoFormat) {
                System.out.println("Format of Phone Contact Number should only contains INTEGERs and One(1) Dash!\n");
            }
        }
        char Gender = ' ';
        while (Gender != 'M' && Gender != 'F') {
            System.out.print("Enter Gender(M/F): ");
            String G = s.nextLine();
            if (G.equals("-1")) {
                return false;
            } else {
                try {
                    Gender = Character.toUpperCase(G.charAt(0));
                    if (Gender != 'M' && Gender != 'F') {
                        System.out.println("Please Enter only M or F.");
                    }
                } catch (Exception ex) {
                    System.out.println("Please Do Not Leave It Blank!");
                }
            }
        }
        System.out.print("Enter Address: ");
        String Adds = s.nextLine();
        if (Adds.equals("-1")) {
            return false;
        }
        System.out.print("Enter Email: ");
        String Email = s.nextLine();
        if (Email.equals("-1")) {
            return false;
        }
        if (choice == 1) {   //DM
            String Position = "Delivery Man";
            boolean parseDouble = false;
            double Salary = 0;
            while (!parseDouble) {
                try {
                    System.out.print("Enter Basic Salary: ");
                    Salary = s.nextDouble();
                    parseDouble = true;
                    s.nextLine();
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("Salary Must Be Only In Integer!");
                }
            }
            if (Salary == -1) {
                return false;
            }
            String WorkingStatus = "Employed";
            String CurrentAvailable = "Not Yet Clock-In";
            String CurrentLocation = "None";
            double rating = 0.0;
            int totalRated = 0;
            DeliveryMan DM = new DeliveryMan(0, CurrentAvailable, CurrentLocation, rating, totalRated, ID, Pw, Name, IC, PhNo, Gender, Adds, Email, Position, WorkingStatus, Salary, Salary, joinDate);
            boolean success = DMList.addWithICValidation(DM);
            if (success) {
                return true;
            } else {
                System.out.println("Error! The IC have been used!\nPress Enter to Continue...");
                s.nextLine();
                return false;
            }
        } else if (choice == 2) { //Admin
            String Position = "Admin";
            boolean parseDouble = false;
            double annualSale = 0;
            while (!parseDouble) {
                try {
                    System.out.print("Enter Total Annual Sales: ");
                    annualSale = s.nextDouble();
                    parseDouble = true;
                    s.nextLine();
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("Annual Sales Must Be Only In Integer!");
                }
            }
            if (annualSale == -1) {
                return false;
            }
            String WorkingStatus = "Employed";
            Admin admin = new Admin(annualSale, ID, Pw, Name, IC, PhNo, Gender, Adds, Email, Position, WorkingStatus, 0, 0, joinDate);
            admin.calculateSalary();
            boolean success = ADList.addWithICValidation(admin);
            if (success) {
                return true;
            } else {
                System.out.println("Error! The IC have been used!\nPress Enter to Continue...");
                s.nextLine();
                return false;
            }
        } else {//HR
            String Position = "HR";
            boolean parseInt = false;
            int TotalStaffManaged = 0;
            while (!parseInt) {
                try {
                    System.out.print("Enter Total Staff Managed: ");
                    TotalStaffManaged = s.nextInt();
                    parseInt = true;
                    s.nextLine();
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("Total Staff Managed Must Be Only In Integer!");
                }
            }
            if (TotalStaffManaged == -1) {
                return false;
            }
            boolean parseDouble = false;
            double Salary = 0;
            while (!parseDouble) {
                try {
                    System.out.print("Enter Basic Salary: ");
                    Salary = s.nextDouble();
                    parseDouble = true;
                    s.nextLine();
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("Salary Must Be Only In Integer!");
                }
            }
            if (Salary == -1) {
                return false;
            }
            String WorkingStatus = "Employed";
            HR hr = new HR(TotalStaffManaged, ID, Pw, Name, IC, PhNo, Gender, Adds, Email, Position, WorkingStatus, Salary, 0, joinDate);
            hr.calculateSalary();
            boolean success = HRList.addWithICValidation(hr);
            if (success) {
                return true;
            } else {
                System.out.println("Error! The IC have been used!\nPress Enter to Continue...");
                s.nextLine();
                return false;
            }
        }
    }

    public boolean DeliveryManUpdateStatus(String StaffID) {
        boolean find = false;
        for (int i = 1; i <= DMList.getTotalEntries(); i++) {
            if (DMList.get(i).getStaffID().equals(StaffID)) {
                find = true;
                DeliveryMan DM = DMList.get(i);
                if (DM.getWorkingStatus().equals("Employed")) {
                    String choice = "-1";
                    System.out.println("\n\nName: " + DM.getStaffName() + "\nIC: " + DM.getStaffIC());
                    System.out.print("Choose A Reason\n 1. Retired\n 2. Resigned\n 0. Back\n");
                    while (!choice.equals("1") && !choice.equals("2") && !choice.equals("0")) {
                        System.out.print("Your Choice: ");
                        choice = s.nextLine();
                        switch (choice) {
                            case "1": {
                                DM.setWorkingStatus("Retired");
                                boolean success = DMList.updateDeliveryManDetail(DM);
                                if (success) {
                                    System.out.println("\nUpdate Successfully.\nPress Enter to Continue...");
                                    s.nextLine();
                                }
                                break;
                            }
                            case "2": {
                                DM.setWorkingStatus("Resigned");
                                boolean success = DMList.updateDeliveryManDetail(DM);
                                if (success) {
                                    System.out.println("Update Successfully.\nPress Enter to Continue...");
                                    s.nextLine();
                                }
                                break;
                            }
                            case "0": {
                                break;
                            }
                            default: {
                                System.out.println("Error, Please Key In Again.\n");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Error. Delivery Man Already Not Working With Us!\nPress Enter to Continue...");
                    s.nextLine();
                }
            }
        }
        return find;
    }

    public void DeliveryManUpdatePersonalDetails() {
        DeliveryMan DM = (DeliveryMan) loginStaff;
        System.out.println("\n\nYour ID: " + DM.getStaffID() + "\nYour Name: " + DM.getStaffName() + "\nYour Phone No: " + DM.getStaffPhNo() + "\nYour Address: " + DM.getStaffAdds() + "\nYour Email: " + DM.getStaffEmail());
        String choice = "-1";
        System.out.println("What You want do update:\n1. Phone No\n2. Address\n3. Email\n0. Back");
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("0")) {
            System.out.print("Choice: ");
            choice = s.nextLine();
            switch (choice) {
                case "1": {
                    boolean PhNoFormat = false;
                    String newPhNo = null;
                    while (!PhNoFormat) {
                        PhNoFormat = true;
                        System.out.println("\n\nYour Current Phone No: " + DM.getStaffPhNo());
                        System.out.print("New Phone No: ");
                        newPhNo = s.nextLine();
                        if (newPhNo.length() < 11) {
                            PhNoFormat = false;
                        }
                        for (int i = 0; i < newPhNo.length(); i++) {
                            if (!Character.isDigit(newPhNo.charAt(i))) {
                                if (i != 3) {
                                    PhNoFormat = false;
                                } else {
                                    if (newPhNo.charAt(i) != '-' && newPhNo.charAt(i) != ' ') {
                                        PhNoFormat = false;
                                    }
                                }
                            }
                        }
                        if (!PhNoFormat) {
                            System.out.println("Format of Phone Contact Number should only contains INTEGERs and One(1) Dash!\n");
                        }
                    }
                    DM.setStaffPhNo(newPhNo);
                    DMList.updateDeliveryManDetail(DM);
                    System.out.println("Update Phone No Successfully! Press Enter to Continue...");
                    s.nextLine();
                    break;
                }
                case "2": {
                    System.out.println("\n\nYour Current Address: " + DM.getStaffAdds());
                    System.out.print("New Address: ");
                    String newAdds = s.nextLine();
                    DM.setStaffAdds(newAdds);
                    DMList.updateDeliveryManDetail(DM);
                    System.out.println("Update Address Successfully! Press Enter to Continue...");
                    s.nextLine();
                    break;
                }
                case "3": {
                    System.out.println("\n\nYour Current Email: " + DM.getStaffEmail());
                    System.out.print("New Email: ");
                    String newEmail = s.nextLine();
                    DM.setStaffEmail(newEmail);
                    DMList.updateDeliveryManDetail(DM);
                    System.out.println("Update Email Successfully! Press Enter to Continue...");
                    s.nextLine();
                }
                case "0": {
                    System.out.println("\n\n");
                    break;
                }
                default: {
                    System.out.println("Please Enter Again...");
                    break;
                }
            }
        }
    }
    //Miw End

    public static void main(String[] args) {
        MainProgram MP = new MainProgram();
        Calendar HRjoinDate = Calendar.getInstance();
        Calendar ADjoinDate = Calendar.getInstance();
        Calendar DMjoinDate = Calendar.getInstance();
        DMjoinDate.add(Calendar.MONTH, 5);
        HRjoinDate.add(Calendar.MONTH, 1);
        MP.DMList.add(new DeliveryMan(1, "Not Available", "None", 4.0, 1, "DM000001", "123456", "Ong Yi Jun", "971009-02-5213", "012-3456789", 'M', "2345 Lorong 3 Jalan ABC, 51020 KL", "OngYiJun@gmail.com", "Delivery Man", "Employed", 3500, 3500, DMjoinDate));
        MP.HRList.add(new HR(1, "HR000001", "123456", "Ong Ong Jun", "970707-07-0707", "010-2255533", 'M', "Jalan Prima Setapak, KL", "OngOngJun@hotmail.com", "HR", "Employed", 3500, 3750, HRjoinDate));
        MP.ADList.add(new Admin(20000, "AD000001", "123456", "ABC", "123456678", "012-345678", 'M', "22A, Deaman Ap, KL", "E@e.com", "Admin", "Employed", 6000, 6000, ADjoinDate));
        MP.wsList.add(new WorkStatus("WS000001", HRjoinDate, DMjoinDate, 0, 0, MP.DMList.get(1)));
        MP.menu();
        // TODO code application logic here
        /*Calendar date3 = Calendar.getInstance();
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        Calendar date4 = Calendar.getInstance();
        date3.add(Calendar.MINUTE, 5);
        date2.add(Calendar.MINUTE, 3);
        date4.add(Calendar.MINUTE, 1);
        DeliveryMan newEntry = new DeliveryMan(0, "", "", "", "", "", "", "", 'C', "", "", "", "", 0, 0, date1);
        DeliveryMan newEntry3 = new DeliveryMan(0, "", "", "", "", "", "", "", 'C', "", "", "", "", 0, 0, date3);
        DeliveryMan newEntry2 = new DeliveryMan(0, "", "", "", "", "", "", "", 'C', "", "", "", "", 0, 0, date2);
        DeliveryMan newEntry4 = new DeliveryMan(0, "", "", "", "", "", "", "", 'C', "", "", "", "", 0, 0, date4);
        DM.add(newEntry3);
        DM.add(newEntry2);
        DM.add(newEntry);

        System.out.println(DM.get(1).getJoinDate().getTime());
        System.out.println(DM.get(2).getJoinDate().getTime());
        System.out.println(DM.get(3).getJoinDate().getTime() + "\n");

        DM.SortMostExperienceDeliveryMan();

        DM.add(newEntry4);
        System.out.println("\n" + DM.get(1).getJoinDate().getTime());
        System.out.println(DM.get(2).getJoinDate().getTime());
        System.out.println(DM.get(3).getJoinDate().getTime());
        System.out.println(DM.get(4).getJoinDate().getTime() + "\n");

        DM.SortMostExperienceDeliveryMan();

        System.out.println("\n" + DM.get(1).getJoinDate().getTime());
        System.out.println(DM.get(2).getJoinDate().getTime());
        System.out.println(DM.get(3).getJoinDate().getTime());
        System.out.println(DM.get(4).getJoinDate().getTime());*/

    }

}
