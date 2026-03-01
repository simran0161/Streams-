import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Question 1
        Employee emp1 = new Employee(1, "Alice ", "IT", 75000.00, "alice.johnson@company.com", Arrays.asList("Java", "Spring", "SQL"));
        Employee emp2 = new Employee(2, "Bob ", "HR", 60000.00, "bob.smith@company.com", Arrays.asList("Recruitment", "Communication", "Onboarding"));
        Employee emp3 = new Employee(3, "Carol ", "Finance", 82000.00, "carol.davis@company.com", Arrays.asList("Accounting", "Excel", "Budgeting"));
        Employee emp4 = new Employee(4, "David ", "Marketing", 70000.00, "david.brown@company.com", Arrays.asList("SEO", "Content Creation", "Analytics"));
        Employee emp5 = new Employee(5, "Emma ", "Operations", 68000.00, "emma.wilson@company.com", Arrays.asList("Project Management", "Logistics", "Leadership"));
        Employee emp6 = new Employee(6, "Frank ", "IT", 78000.00, "frank.miller@company.com", Arrays.asList("Python", "AWS", "Docker"));
        Employee emp7 = new Employee(7, "Grace ", "Finance", 81000.00, "grace.lee@company.com", Arrays.asList("Financial Analysis", "Excel", "SAP"));
        Employee emp8 = new Employee(8, "Henry ", "Marketing", 69000.00, "henry.thompson@company.com", Arrays.asList("Social Media", "Branding", "Email Marketing"));
        List<Employee> employees=Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8);

        System.out.println("Question 1 ........................................");
        List<String> skillsString = emp1.getSkills().stream().collect(Collectors.toList());
        System.out.print("Skills of " + emp1.getName() + ": " );
        for(int i=0;i<skillsString.size();i++){
            if(i==skillsString.size()-1){
                System.out.print(skillsString.get(i));
            }
            else {
                System.out.print(skillsString.get(i) + " , ");
            }
        }
        System.out.println();

        //Question 2
        System.out.println();
        System.out.println("Question 2 ........................................");
        HashMap<Integer,String> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.getId(),emp.getName());
        }
        System.out.println("Account id and name is are stored in Map");

        //Question 3
        System.out.println();
        System.out.println("Question 3 ........................................");
        Map<String,List<Employee>>employeeByDept=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        employeeByDept.forEach((dept, empList) -> {
            System.out.println("Department "+dept + ":");
            empList.forEach(emp -> System.out.println("  " + emp.getName()));
        });

        //Question 4
        System.out.println();
        System.out.println("Question 4 ........................................");
        Map<String,Long>countEmployeeByDept=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        countEmployeeByDept.forEach((dept,count)-> System.out.println("Department "+dept+" : "+count+" employees"));


        //Question 5
        System.out.println();
        System.out.println("Question 5 ........................................");
        Map<String,Double>avgSalaryByDept=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        avgSalaryByDept.forEach((dept,avgsal)-> System.out.println("Department "+dept+" has average salary "+avgsal));


        //Question 6
        System.out.println();
        System.out.println("Question 6 ........................................");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean,List<Integer>>evenOdd=numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println("Even Numbers: "+evenOdd.get(true));
        System.out.println("Odd Numbers: "+evenOdd.get(false));

        //Question 7
        System.out.println();
        System.out.println("Question 7 ........................................");
        Map<Boolean,List<Employee>>empGrt50=employees.stream().collect(Collectors.partitioningBy(n->n.getSalary()>50));
        System.out.println("Employees greater than 50k salary: ");
        empGrt50.get(true).forEach(e-> System.out.println(e.getName()));
        System.out.println("Employees less than equal to 50k salary:");
        empGrt50.get(false).forEach(e -> System.out.println(e.getName()));

        //Question 8
        System.out.println();
        System.out.println("Question 8 ........................................");
        Map<String, Optional<Employee>> highestSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        highestSalary.forEach((dept, empOpt) -> System.out.println(dept + " : " +empOpt.map(Employee::getName).orElse("No Employee")));

        //Question 9
        System.out.println();
        System.out.println("Question 9 ........................................");
        Map<String,List<Employee>>names=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        names.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(e -> System.out.println("   " + e.getName()));
        });

        //Question 10
        System.out.println();
        System.out.println("Question 10 ........................................");
        Map<String, List<String>> deptToNames = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.mapping(Employee::getName, Collectors.toList())));
        deptToNames.forEach((dept, emplist) -> {
            System.out.println("Department: " + dept);
            emplist.forEach(name -> System.out.println("   " + name));
        });

        //Question 11
        System.out.println();
        System.out.println("Question 11 ........................................");
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8, 9));
        List<Integer> flattened = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Single Flatten List: "+flattened);

        //Question 12
        System.out.println();
        System.out.println("Question 12 ........................................");
        List<String> sentences = Arrays.asList(
                "Java is fun",
                "Streams are powerful",
                "I love coding"
        );
        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .collect(Collectors.toList());
        System.out.println(words);

        //Question 13
        System.out.println();
        System.out.println("Question 13 ........................................");
        List<String> uniqueSkills = employees.stream()
                .flatMap(e -> e.getSkills().stream()) // flatten all skill lists
                .distinct()                           // remove duplicates
                .collect(Collectors.toList());
        System.out.println(uniqueSkills);

        //Question 14
        System.out.println();
        System.out.println("Question 14 ........................................");
        List<Order> orders = List.of(
                new Order(List.of(new Item("Pen"), new Item("Book"))),
                new Order(List.of(new Item("Laptop"))),
                new Order(List.of(new Item("Mouse"), new Item("Keyboard"), new Item("USB")))
        );
        long totalcount=orders.stream().flatMap(order->order.getItems().stream()).count();
        System.out.println(totalcount);

        //Question 15
        System.out.println();
        System.out.println("Question 15 ........................................");
        List<List<Integer>> list = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );
        int sumOfEle=list.stream().flatMap(ele->ele.stream()).mapToInt(Integer::byteValue).sum();
        System.out.println(sumOfEle);

        //Question 16
        System.out.println();
        System.out.println("Question 16 ........................................");
        int product=list.stream().flatMap(ele->ele.stream()).reduce(1,(a,b)->a*b);
        System.out.println(product);

        //Question 17
        System.out.println();
        System.out.println("Question 17 ........................................");
        List<List<String>> str = List.of(
                List.of("Simran", "Rahul", "Neha"),
                List.of("Anu", "Shreya"),
                List.of("Sumit", "Shivani", "Ajay")
        );

        String res=str.stream().flatMap(s->s.stream()).reduce("",(s1,s2)->s1.length()>s2.length()?s1:s2);
        System.out.println(res);

        //Question 18
        System.out.println();
        System.out.println("Question 18 ........................................");
        String result=str.stream().flatMap(s->s.stream()).reduce("",(s1,s2)->s1+s2);
        System.out.println(result);

        //Question 19
        System.out.println();
        System.out.println("Question 19 ........................................");
        double maxsalary=employees.stream().map(Employee::getSalary).reduce(0d,(a,b)->a>b?a:b);
        System.out.println(maxsalary);

        //Question 20
        System.out.println();
        System.out.println("Question 20 ........................................");
        Map<String, Integer> map1 = Map.of("A", 10, "B", 20);
        Map<String, Integer> map2 = Map.of("B", 30, "C", 40);
        Map<String, Integer> map3 = Map.of("D", 50);

        List<Map<String, Integer>> maps = List.of(map1, map2, map3);

        Map<String, Integer> merged = maps.stream()
                .reduce(new HashMap<>(), (mp1, mp2) -> {
                    mp1.putAll(mp2); // merge current map into accumulator
                    return mp1;
                });

        System.out.println(merged);
    }
}