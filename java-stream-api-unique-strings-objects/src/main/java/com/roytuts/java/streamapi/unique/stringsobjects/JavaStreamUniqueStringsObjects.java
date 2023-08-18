package com.roytuts.java.streamapi.unique.stringsobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreamUniqueStringsObjects {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Ani", "Sou", "Lit", "Sum", "Ani", "Sou", "Pab");
		System.out.println("Unique strings");
		List<String> uniqueStrings = strings.stream().distinct().collect(Collectors.toList());
		uniqueStrings.forEach(s -> System.out.println(s));

		System.out.println();

		List<User> userList = createUserList();

		System.out.println("Unique users by name");
		Collection<User> uniqueUsers = userList.stream().collect(Collectors.toMap(User::getName, p -> p, (p, q) -> p))
				.values();
		uniqueUsers.forEach(usr -> System.out.println(usr));

		System.out.println();

		List<User> distinctUsers = userList.stream().filter(distinctByKey(User::getName)).collect(Collectors.toList());
		distinctUsers.forEach(usr -> System.out.println(usr));
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

	private static List<User> createUserList() {
		List<User> userList = new ArrayList<>();

		User e1 = new User("John", "john@email.com", 21);
		User e2 = new User("Martin", "martin@email.com", 19);
		User e3 = new User("Marry", "marry@email.com", 31);
		User e4 = new User("Stephan", "stephen@email.com", 18);
		User e5 = new User("Garry", "garry@email.com", 26);
		User e6 = new User("Marry", "marry2@email.com", 30);
		User e7 = new User("Garry", "garry2@email.com", 25);

		userList.add(e1);
		userList.add(e2);
		userList.add(e3);
		userList.add(e4);
		userList.add(e5);
		userList.add(e6);
		userList.add(e7);

		return userList;
	}

	protected static class User {

		private String name;
		private String email;
		private int age;

		public User() {
		}

		public User(String name, String email, int age) {
			this.name = name;
			this.email = email;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
		}

	}
}
