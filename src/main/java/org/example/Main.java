package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employeeList = new LinkedList<>();
        Employee employee1 = new Employee(1,"Didem","Demir");
        Employee employee2 = new Employee(2,"Begüm","Tokyay");
        Employee employee3 = new Employee(3,"Ömer", "Durmuş");
        Employee employee4 = new Employee(4, "Berkay","Eser");
        Employee employee5 = new Employee(5,"Feyruze","Kekeç");
        Employee employee6 = new Employee(1,"Didem","Demir");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);

        List<Employee> duplicates = findDuplicates(employeeList);
        for(Employee employee:duplicates){
            System.out.println(employee);
        }
        System.out.println("**************");
        Map<Integer,Employee> uniqueMap = findUniques(employeeList);
        for(Map.Entry<Integer,Employee> entry: uniqueMap.entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("**************");
        List<Employee> uniqueEmployees = removeDuplicates(employeeList);
        for(Employee employee : uniqueEmployees){
            System.out.println(employee);
        }


    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> checked = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for(Employee employee: employees){
            if(!checked.add(employee)){
                duplicates.add(employee);
            }
        }
        return duplicates;
    }
    public static Map<Integer,Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Integer> seenIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee != null && !seenIds.contains(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
                seenIds.add(employee.getId());
            }
        }
        return uniqueMap;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees){
        Map<Integer,Integer> countMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null) {
                int id = employee.getId();
                countMap.put(id, countMap.getOrDefault(id, 0) + 1);
            }
        }
        LinkedList<Employee> uniqueList = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                uniqueList.add(employee);
            }
        }
        return uniqueList;
    }
}