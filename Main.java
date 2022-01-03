import java.io.*;
import java.util.Scanner;
public class Main  {
    public static File filePath = new File("departure.txt");
    public static Scanner input = new Scanner(System.in);

    public static void insert(Flight fl) {
        try {
            FileWriter w = new FileWriter(filePath, true);
            w.write(fl.FlightData() + "\n");
            w.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static boolean update(String newFlightNum, String newRemarks) {
        String tempPath = "temp.csv";
        File oldFile = filePath;
        File newFile = new File(tempPath);
        String flightNum = "";
        String destination = "";
        String pass = "";
        String takeOffTime = "";
        String arrTime = "";
        String gate = "";
        String remarks = "";
        boolean found=false;
        try {
            PrintWriter w = new PrintWriter((new FileOutputStream(new File(tempPath), true)));
            Scanner s = new Scanner(oldFile).useDelimiter("[,\n]");
            while (s.hasNext()) {
                flightNum = s.next();
                destination = s.next();
                pass = s.next();
                takeOffTime = s.next();
                arrTime = s.next();
                gate = s.next();
                remarks = s.next();
                if (flightNum.equals(newFlightNum)) {
                    w.write(flightNum + "," + destination + "," + pass + "," + takeOffTime + "," + arrTime + "," + gate + "," + newRemarks+"\n");
                    found=true;
                } else {
                    w.write(flightNum + "," + destination + "," + pass + "," + takeOffTime + "," + arrTime + "," + gate + "," + remarks+"\n");
                }
            }
            w.close();
            s.close();
            oldFile.delete();
            File dump = filePath;
            newFile.renameTo(dump);
        } catch (Exception e) {
            System.out.println(e);
        }
        return found;
    }

    public static boolean deleteRec(String dFlightNum) {

        String tempPath = "temp1.csv";
        File oldFile = filePath;
        File newFile = new File(tempPath);
        String flightNum = "";
        String destination = "";
        String pass ="";
        String takeOffTime = "";
        String arrTime = "";
        String gate = "";
        String remarks = "";
        boolean found=false;
        try {
            PrintWriter w = new PrintWriter((new FileOutputStream(new File(tempPath), true)));
            Scanner s = new Scanner(oldFile).useDelimiter("[,\n]");
            while (s.hasNext()) {
                flightNum = s.next();
                destination = s.next();
                pass = s.next();
                takeOffTime = s.next();
                arrTime = s.next();
                gate = s.next();
                remarks = s.next();
                if (!flightNum.equals(dFlightNum)) {
                    w.write(flightNum + "," + destination + "," + pass + "," + takeOffTime + "," + arrTime + "," + gate + "," + remarks + "\n");
                }
                else
                    found=true;
            }
            w.close();
            s.close();
            oldFile.delete();
            File dump = filePath;
            newFile.renameTo(dump);
        } catch (Exception e) {
            System.out.println(e);
        }
        return found;
    }

    public static String search(String sFlightNum) {
        String flightNum = "";
        String destination = "";
        String pass = "";
        String takeOffTime = "";
        String arrTime = "";
        String gate = "";
        String remarks = "";
        try {
            Scanner s = new Scanner(filePath).useDelimiter("[,\n]");
            while (s.hasNext()) {
                flightNum = s.next();
                destination = s.next();
                pass = s.next();
                takeOffTime = s.next();
                arrTime = s.next();
                gate = s.next();
                remarks = s.next();
                if (flightNum.equalsIgnoreCase(sFlightNum)) {
                    return flightNum + "," + destination + "," + pass + "," + takeOffTime + "," + arrTime + "," + gate + "," + remarks;
                }
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return "Not Found";
    }
    public static int rowNum(){
        int cnt=0;
        try {
            Scanner s = new Scanner(filePath).useDelimiter("[\n]");
            while (s.hasNextLine()) {
                s.nextLine();
                cnt++;
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return cnt;
    }
    public static String[][] readAllRow() {
        File oldFile = filePath;
        String flightNum = "";
        String destination = "";
        String pass ="";
        String takeOffTime = "";
        String arrTime = "";
        String gate = "";
        String remarks = "";
        String [][] arr=new String[rowNum()][7];
        try {
            Scanner s = new Scanner(oldFile).useDelimiter("[,\n]");
            int i=0;
            while (s.hasNext()) {
                flightNum = s.next();
                destination = s.next();
                pass = s.next();
                takeOffTime = s.next();
                arrTime = s.next();
                gate = s.next();
                remarks = s.next();
                arr[i][0]=flightNum;
                arr[i][1]=destination;
                arr[i][2]=pass;
                arr[i][3]=takeOffTime;
                arr[i][4]=arrTime;
                arr[i][5]=gate;
                arr[i][6]=remarks;
                i++;
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
//    public static void displayServes() {
//        Scanner input1 = new Scanner(System.in).useDelimiter(",");
//        System.out.println("*****Welcome to Egypt Airport*****");
//        System.out.println("      *****DEPARTURES*****        ");
//        while (true) {
//            System.out.println("How can we help you??");
//            System.out.println("Enter 1 to add new flight");
//            System.out.println("Enter 2 to update flight remarks");
//            System.out.println("Enter 3 to delete canceled flight");
//            System.out.println("Enter 4 to display flight info");
//            System.out.println("Enter 0 to exist");
//            System.out.println("**********************************");
//            int num = input.nextInt();
//            if (num == 0)
//                break;
//            else if (num == 1) {
//                String flightNum;
//                String destination;
//                String pass;
//                String takeOffTime;
//                String arrTime;
//                String gate;
//                String remarks;
//                System.out.println("Enter Flight Data at this pattern with comma");
//                System.out.println("Flight Number, Destination , Number of passengers , Take off time ,Arrival Time , Gate, Remarks");
//                flightNum = input1.next();
//                destination = input1.next();
//                pass = input1.next();
//                takeOffTime = input1.next();
//                arrTime = input1.next();
//                gate = input1.next();
//                remarks = input1.next();
//                Flight f = new Flight(flightNum, destination, pass, takeOffTime, arrTime, gate, remarks);
//                insert(f);
//            } else if (num == 2) {
//                String flightNum;
//                String remarks;
//                System.out.println("Enter the flight number you want to update : ");
//                flightNum = input.next();
//                System.out.println("Enter new remarks : ");
//                remarks = input.next();
//                update(flightNum, remarks);
//            } else if (num == 3) {
//                String flightNum;
//                System.out.println("Enter the flight number you want to delete : ");
//                flightNum = input.next();
//                deleteRec(flightNum);
//            } else {
//                String flightNum;
//                System.out.println("Enter the flight number you want to display : ");
//                flightNum = input.next();
//                search(flightNum);
//            }
//
//        }
//    }

    public static void main(String[] args) {
        new GUI();
//        try {
//            displayServes();
//        }
//        catch (Exception e){
//            System.out.println("Input Mismatch error occurred");
//            displayServes();
//        }
    }
}

