import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.EmpWageServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class EmpWageServiceTest {

	EmpWageServiceImpl service;

	@BeforeEach
	void setup() {

		service = new EmpWageServiceImpl();
	}

	@Test
	void testAddCompany() {

		service.addCompany("TCS", 20, 20, 100);

		service.computeWage();

		int wage = service.getTotalWage("TCS");

		assertTrue(wage >= 0);
	}

	@Test
	void testInvalidCompany() {

		assertThrows(IllegalArgumentException.class, () -> {

			service.addCompany("tcs", 20, 20, 100);
		});
	}
}
