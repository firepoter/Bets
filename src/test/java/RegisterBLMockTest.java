import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Admin;
import domain.Bezeroa;
import domain.Event;
import domain.Langilea;
import domain.Pertsona;
import exceptions.UserAlreadyExist;

class RegisterBLMockTest {

	DataAccess dataAccess = Mockito.mock(DataAccess.class);

	BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	@DisplayName("Test 4:....")
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
			String cs = "domain.Admin";
			
			Mockito.doReturn(new Admin("Josu", "Loidi", "Gorostidi", "Josulo", "aaaaaaaa", "123456789", "josulo@gmail.com", dat)).when(dataAccess).register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			Pertsona berria = dataAccess.register("Josu", "Loidi", "Gorostidi", "Josulo", "aaaaaaaa", "123456789", "josulo@gmail.com", dat, "admin");
			
			assertEquals(berria.getClass().getName(), cs);
			assertEquals(berria.izena, "Josu");
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
			
			Mockito.doReturn(new Langilea("Jose", "Garcia", "Perez", "JoseRamon", "aaaaaaaa", "123456789", "JoseRamon@gmail.com", dat)).when(dataAccess).register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			Pertsona berria = dataAccess.register("Jose", "Garcia", "Perez", "JoseRamon", "aaaaaaaa", "123456789", "JoseRamon@gmail.com", dat, "langilea");
			
			String cs = "domain.Langilea";
			assertEquals(berria.getClass().getName(), cs);
			assertEquals(berria.izena, "Jose");
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
			
			Mockito.doReturn(new Bezeroa("Saioa", "Goikoetxea", "Ugarte", "Saioo99", "b", "123456789", "Saioo99@gmail.com", dat)).when(dataAccess).register(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			Pertsona berria = dataAccess.register("Saioa", "Goikoetxea", "Ugarte", "Saioo99", "b", "123456789", "Saioo99@gmail.com", dat, "bezeroa");
			
			String cs = "domain.Bezeroa";
			assertEquals(berria.getClass().getName(), cs);
			assertEquals(berria.izena, "Saioa");
		} catch (ParseException e) {
			fail("it should be good");
		}
	}


}
