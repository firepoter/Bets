import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Pertsona;
import exceptions.UserAlreadyExist;

class RegisterBLMockTest {

	DataAccess dataAccess = Mockito.mock(DataAccess.class);

	BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	@DisplayName("Test 4:...")
	void test4() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("19/03/1990");
			Mockito.when(dataAccess.register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class))).thenThrow(UserAlreadyExist.class);
			assertThrows(UserAlreadyExist.class, () -> sut.register("Josu", "Loidi", "Gorostidi", "Josulo", "aaaaaaaa", "123456789", "josulo@gmail.com", dat, "admin"));
		} catch (ParseException e) {
			fail("it should be good");
		}
	}
	
	@Test
	@DisplayName("Test 1:...")
	void test1() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("19/03/1990");
			
			Mockito.doReturn(new Pertsona("Josu", "Loidi", "Gorostidi", "Josulo", "aaaaaaaa", "123456789", "josulo@gmail.com", dat, "admin")).when(dataAccess).register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			Pertsona berria = dataAccess.register("Josu", "Loidi", "Gorostidi", "Josulo", "aaaaaaaa", "123456789", "josulo@gmail.com", dat, "admin");
			
			assertEquals(berria.abizena1, "Josu");
		} catch (ParseException e) {
			fail("it should be good");
		}
	}
	
	@Test
	@DisplayName("Test 2:...")
	void test2() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("10/07/1999");
			
			Mockito.doReturn(new Pertsona("Jose", "Garcia", "Perez", "JoseRamon", "aaaaaaaa", "123456789", "JoseRamon@gmail.com", dat, "langilea")).when(dataAccess).register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			Pertsona berria = dataAccess.register("Jose", "Garcia", "Perez", "JoseRamon", "aaaaaaaa", "123456789", "JoseRamon@gmail.com", dat, "langilea");
			
			assertEquals(berria.abizena1, "Jose");
		} catch (ParseException e) {
			fail("it should be good");
		}
	}
	
	@Test
	@DisplayName("Test 3:...")
	void test3() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("20/11/2000");
			
			Mockito.doReturn(new Pertsona("Saioa", "Goikoetxea", "Ugarte", "Saioo99", "b", "123456789", "Saioo99@gmail.com", dat, "bezeroa")).when(dataAccess).register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			Pertsona berria = dataAccess.register("Saioa", "Goikoetxea", "Ugarte", "Saioo99", "b", "123456789", "Saioo99@gmail.com", dat, "bezeroa");
			
			assertEquals(berria.abizena1, "Saioa");
		} catch (ParseException e) {
			fail("it should be good");
		}
	}


}
