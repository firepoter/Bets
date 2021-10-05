import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Pertsona;
import exceptions.QuestionAlreadyExist;
import exceptions.UserAlreadyExist;
import utility.TestUtilityDataAccess;

class RegisterDATest {

	static DataAccess sut = new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));;
	static TestUtilityDataAccess testDA = new TestUtilityDataAccess();

	Pertsona berria;
	@Test
	@DisplayName("Test 1:...")
	void test1() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("19/03/1990");
			
			testDA.open();
			testDA.addPertsona();
			testDA.close();
			
			assertThrows(UserAlreadyExist.class, () -> sut.register("Josu", "Loidi", "Gorostidi", "Josulo", "aaaaaaaa", "123456789", "josulo@gmail.com", dat, "admin"));
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
			dat = sdf.parse("19/03/1990");
			String exIzena = "Juan";
			String exAbizena = "Carlos";
			
			berria = sut.register("Juan", "Carlos", "Calvo", "juana123", "123456", "656532320", "juana123@gmail.com", dat, "admin");
			assertEquals(berria.getIzena(), exIzena);
			assertEquals(berria.getAbizena1(), exAbizena);
		}catch(ParseException e) {
			fail("it should be good");
		}
	}
	
	@Test
	@DisplayName("Test 3:...")
	void test3() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("10/07/1999");
			String exIzena = "Jose";
			String exAbizena = "Garcia";
			
			berria = sut.register("Jose", "Garcia", "Perez", "JoseRamon", "aaaaaaaa", "123456789", "JoseRamon@gmail.com", dat, "langilea");
			assertEquals(berria.getIzena(), exIzena);
			assertEquals(berria.getAbizena1(), exAbizena);
		}catch(ParseException e) {
			fail("it should be good");
		}
	}
	
	@Test
	@DisplayName("Test 4:...")
	void test4() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("20/11/2000");
			String exIzena = "Saioa";
			String exAbizena = "Goikoetxea";
			
			berria = sut.register("Saioa", "Goikoetxea", "Ugarte", "Saioo99", "b", "123456789", "Saioo99@gmail.com", dat, "bezeroa");
			assertEquals(berria.getIzena(), exIzena);
			assertEquals(berria.getAbizena1(), exAbizena);
		}catch(ParseException e) {
			fail("it should be good");
		}
	}
	
	@Test
	@DisplayName("Test 5:...")
	void test5() throws UserAlreadyExist {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dat;
			dat = sdf.parse("20/11/2000");
			
			assertThrows(IllegalArgumentException.class, ()-> sut.register("Saioa", "Goikoetxea", "Ugarte", "Saioo99", "b", "123456789", "Saioo99@gmail.com", dat, "ikaslea"));
		}catch(ParseException e) {
			fail("it should be good");
		}
	}
	
	

}
