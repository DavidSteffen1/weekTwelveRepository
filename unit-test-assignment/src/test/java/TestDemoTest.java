import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class TestDemoTest {

	@BeforeEach
	void setUp() throws Exception {
		@SuppressWarnings("unused")
		TestDemo testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int firstInt, int secondInt, int expected, Boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(firstInt, secondInt)).isEqualTo(expected);
		}
		
		else {assertThatThrownBy(() -> testDemo.addPositive(firstInt, secondInt)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	private TestDemo testDemo = new TestDemo();
	
	static Stream<Arguments> argumentsForAddPositive() {

		return Stream.of(arguments(2, 4, 6, false), arguments(-2, 4, 2, true), 
				arguments(-2, -4, -6, true), arguments(0, 4, 4, true), arguments(8, 14, 22, false));
		
	}
	
	@Test
	protected void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
