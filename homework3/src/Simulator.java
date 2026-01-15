/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * Simulator class
 */

import java.util.ArrayList;

/**
 * It uses to actually carry out the simulation.
 */
public class Simulator {
    /**
     * Doing simulation.
     *
     * @param probability      The probability of a request being introduced per time unit (a double between 0.0 and 1.0, inclusive)
     * @param numberOfFloors   The number of floors in the building (an int greater than 1)
     * @param numberOfElevator The number of elevators in the building (an int greater than 0)
     * @param length           The length of the simulation in time units (an int greater than 0)
     */
    public static void simulate(double probability, int numberOfFloors, int numberOfElevator, int length) throws InvalidStateException {
        ArrayList<Elevator> elevators = new ArrayList<>();
        RequestQueue queue = new RequestQueue();
        BooleanSource source = new BooleanSource(probability);

        //创建电梯
        for (int i = 0; i < numberOfElevator; i++) {
            Elevator e = new Elevator();
            elevators.add(e);
        }

        //进行电梯移动的循环
        int time;
        int totalRequests = 0;
        int currentRequests = 0;
        int totalTime = 0;
        for (time = 1; time <= length; time++) {
            System.out.print("Step " + time + ": ");//输出1

            //判断Request来没来
            if (source.requestArrived()) {
                //设置初始条件
                Request r = new Request(numberOfFloors);
                queue.enqueue(r);
                r.setTimeEntered(time);
                totalRequests++;
                currentRequests++;
                System.out.print("A request arrives from Floor " + r.getSourceFloor() + " to Floor " + r.getDestinationFloor());//输出1
                System.out.println();
            } else {
                System.out.print("Nothing arrives");//输出1
                System.out.println();
            }

            //利用循环对电梯list操作
            for (int i = 0; i < elevators.size(); i++) {
                Elevator e = elevators.get(i);
                int state = e.getElevatorState();
                //以电梯的状态来分配任务，或在单位时间内对电梯位置修改
                switch (state) {
                    //1.电梯空闲

                    case Elevator.IDLE -> {
                        Request next = queue.dequeue();
                        if (next != null) {
                            e.setRequest(next);
                            if (next.getSourceFloor() != e.getCurrentFloor()) {
                                e.setElevatorState(Elevator.TO_SOURCE);
                            } else {
                                e.setElevatorState(Elevator.TO_DESTINATION);
                            }
                        }
                    }

                    //2.电梯前往请求源
                    case Elevator.TO_SOURCE -> {
                        if (e.getCurrentFloor() > e.getRequest().getSourceFloor()) {//电梯需向下
                            e.setCurrentFloor(e.getCurrentFloor() - 1);
                        } else if (e.getCurrentFloor() < e.getRequest().getSourceFloor()) {//电梯需向上
                            e.setCurrentFloor(e.getCurrentFloor() + 1);
                        } else {//电梯到达需求层，改变电梯状态
                            e.setElevatorState(Elevator.TO_DESTINATION);
                            totalTime = totalTime + (time - e.getRequest().getTimeEntered());
                            if (e.getCurrentFloor() > e.getRequest().getDestinationFloor()) {//电梯需向下
                                e.setCurrentFloor(e.getCurrentFloor() - 1);
                            } else {//电梯需向上
                                e.setCurrentFloor(e.getCurrentFloor() + 1);
                            }
                        }
                    }

                    //3.电梯前往目的地
                    case Elevator.TO_DESTINATION -> {
                        if (e.getCurrentFloor() > e.getRequest().getDestinationFloor()) {//电梯需向下
                            e.setCurrentFloor(e.getCurrentFloor() - 1);
                        } else if (e.getCurrentFloor() < e.getRequest().getDestinationFloor()) {//电梯需向上
                            e.setCurrentFloor(e.getCurrentFloor() + 1);
                        } else {//电梯到达需求层，改变需求和电梯状态
                            currentRequests--;
                            e.setRequest(null);
                            e.setElevatorState(Elevator.IDLE);
                            System.out.println("Total Wait Time = " + totalTime + ", Total Requests = " + totalRequests);//输出2
                        }
                    }

                    //异常
                    default -> throw new InvalidStateException("Invalid state");
                }
            }
            if (currentRequests <= elevators.size()) {
                System.out.println("Requests: ");//输出3
            } else {
                System.out.print("Requests: ");
                for (int i = 0; i < queue.size(); i++) {
                    Request r = queue.get(i);
                    if (i == queue.size() - 1) {
                        System.out.print("(" + r.getSourceFloor() + ", " + r.getDestinationFloor() + ", " + r.getTimeEntered() + ")");//输出3
                    } else {
                        System.out.print("(" + r.getSourceFloor() + ", " + r.getDestinationFloor() + ", " + r.getTimeEntered() + "), ");//输出3
                    }
                }
                System.out.println();

            }
            printOutElevators(elevators);//输出4
            System.out.println();
        }
        double average = (double) totalTime / (double) totalRequests;
        System.out.println("Total Wait Time: " + totalTime);
        System.out.println("Total Requests: " + totalRequests);
        System.out.printf("Average Wait Time:% .2f", average);
        System.out.println();
    }

    /**
     * To print all elevators with some format.
     *
     * @param elevators input need to print
     */
    private static void printOutElevators(ArrayList<Elevator> elevators) {
        System.out.print("Elevators: ");
        for (int i = 0; i < elevators.size(); i++) {
            Elevator e = elevators.get(i);
            if (i != elevators.size() - 1) {
                printElevator(e);
                System.out.print("], ");
            } else {
                printElevator(e);
                System.out.print("]");
            }
        }
    }

    /**
     * To print elevators which of them are at one time.
     *
     * @param e elevators list at the same time
     */
    private static void printElevator(Elevator e) {
        System.out.print("[Floor " + e.getCurrentFloor() + ", ");
        if (e.getElevatorState() == Elevator.IDLE) {
            System.out.print("IDLE, ");
            System.out.print("---");
        } else if (e.getElevatorState() == Elevator.TO_SOURCE) {
            System.out.print("TO_SOURCE, ");
            System.out.print("(" + e.getRequest().getSourceFloor() + ", " + e.getRequest().getDestinationFloor() + ", " + e.getRequest().getTimeEntered() + ")");
        } else {
            System.out.print("TO_DESTINATION, ");
            System.out.print("(" + e.getRequest().getSourceFloor() + ", " + e.getRequest().getDestinationFloor() + ", " + e.getRequest().getTimeEntered() + ")");
        }
    }
}

