public class Flight {
    private String flightNum;
    private String destination;
    private String pass;
    private String takeOffTime;
    private String arrTime;
    private String gate;
    private String remarks;

    public Flight(String flightNum,String destination,String pass,String takeOffTime,String arrTime,String gate,String remarks) {
        this.flightNum=flightNum;
        this.destination=destination;
        this.pass = pass;
        this.takeOffTime=takeOffTime;
        this.arrTime=arrTime;
        this.gate=gate;
        this.remarks=remarks;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String FlightData(){
        return flightNum+","+destination+","+pass+","+takeOffTime+","+arrTime+","+gate+","+remarks;
    }
}
