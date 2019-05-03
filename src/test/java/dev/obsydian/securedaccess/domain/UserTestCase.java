package dev.obsydian.securedaccess.domain;

import dev.obsydian.securedaccess.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class UserTestCase {

	@Test
	public void testCaseNewUser() {

		//Given
		User user1 = new User(1, "Michael", "Magic Mike", "mike@mail.com",
				"password1", LocalDate.of(1980, 1, 1));

		//When
		String realName = user1.getRealName();
		String userName = user1.getUserName();
		String userMail = user1.getUserMail();
		String password = user1.getPassword();
		LocalDate birthday = user1.getBirthDate();

		//Then
		Assert.assertEquals("Michael", realName);
		Assert.assertEquals("Magic Mike", userName);
		Assert.assertEquals("mike@mail.com", userMail);
		Assert.assertEquals("password1", password);
		Assert.assertNotEquals("password2", password);
		Assert.assertEquals(LocalDate.of(1980,1,1), birthday);

	}
}
