package edu.java.lambda03;

import java.util.Arrays;
import java.util.List;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList(
				new Employee(100, "이찬희", "개발1팀", "대리", 400.0),
				new Employee(101, "지대한", "개발2팀", "사원", 350.0),
				new Employee(200, "김다훈", "개발2팀", "과장", 380.0),
				new Employee(201, "유다한", "개발1팀", "부장", 500.0),
				new Employee(300, "강효남", "인사팀", "사원", 300.0),
				new Employee(301, "위태욱", "인사팀", "과장", 1000.0)
		);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		System.out.println("--- 직원 정보 ---");
		for(Employee x : employees) {
			System.out.println(x);
		}
		
		System.out.println();
		
		/* 강사님 */
		employees.forEach(x -> System.out.println(x));
		System.out.println();
		employees.forEach(System.out::println);	// 람다표현식 :: 메서드 참조
		
		
		// 2. 개발 1, 2팀에서 일하는 직원들의 급여의 합계를 출력.
		System.out.println();
		System.out.println("-- 개발팀 급여 ---");
		
		// 강사님과 같음.
		Double developes = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.sum();
		System.out.println("람다:합계 = " + developes);
		
		// 찍먹
		List<Double> em1 = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.map(x -> x.getSalary())
				.toList();
		double sum = 0;
		for(Double x : em1) {
			sum += x;
		}
		System.out.println("합계 = " + sum);
		
		
		
		// 3. 개발 1, 2팀에서 일하는 직원들의 급여의 평균을 출력.
		Double developesAvg = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.average()
				.orElseThrow();	// average()에서 double 타입으로 계산해주고 exception 발생 시 throw
//				.getAsDouble();
		System.out.println("람다:평균 = " + developesAvg);
		
		System.out.println("평균 = " + (sum / em1.size()));
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력.
		System.out.println("-- 사원 급여 ---");
		List<Double> em2 = employees.stream()
				.filter(x -> x.getEmpTitle().equals("사원"))
				.map(x -> x.getSalary())
				.toList();
		sum = 0;
		for(Double x : em2) {
			sum += x;
		}
		System.out.println("합계 = " + sum);
		
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력.
		System.out.println("평균 = " + (sum / em2.size()));
		
		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
		System.out.println("--- 급여가 400 이상인 직원 ---");
		List<Employee> em3 = employees.stream()
				.filter(x -> x.getSalary() >= 400)
				.toList();
		for(Employee x : em3) {
			System.out.println(x);
		}
		
		// 선생님
		employees.stream()
				.filter(x -> x.getSalary() >= 400)
				.forEach(System.out::println);	// x -> System.out.pritnln(x);
		
		
		
		
		
		// 7. 개발 1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력.
		System.out.println("--- 개발 1팀 급여 인상 ---");
		List<Double> em4 = employees.stream()
				.filter(x -> x.getDept().equals("개발1팀"))
				.map(x -> x.getSalary() + x.getSalary() * 0.1)
				.toList();
		sum = 0;
		for(Double x : em4) {
			sum += x;
		}
		System.out.println("인상된 개발 1팀 평균 급여 = " + (sum / em4.size()));
		
		/* 선생님 */
		double result = employees.stream()
				.filter(x -> x.getDept().equals("개발1팀"))
				.mapToDouble(x -> x.getSalary() * 1.1)
				.average()
				.orElseThrow();
		System.out.println("인상된 개발 1팀 평균 급여 = " + result);
		
		
		
		// 8. 직원 리스트에서 "사원"은 몇 명?
		long employee = employees.stream()
				.filter(x -> x.getEmpTitle().equals("사원"))
				.count();
		System.out.println("사원 수 = " + employee);
		
	}

}
