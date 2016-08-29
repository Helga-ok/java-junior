package mytest.logger;

import com.acme.edu.*;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoggerTest {
    //region given
    //endregion

    @Test
    public void shouldPrintTypeAndCharacterWhenCharacterLogged() throws LogException, SaveException {
        //region Given
        Saver saverStub = mock(Saver.class);
        Decorator decoratorStub = mock(Decorator.class);
        Logger logger = new Logger(decoratorStub, saverStub);
        //endregion

        //region When
        logger.log('a');
        //endregion

        //region Then
        verify(saverStub).save("char: a");
        //endregion
    }

    @Test
    public void shouldPrintTypeAndBooleanWhenBooleanLogged() throws LogException, SaveException, DecorateException {
        //region Given
        Saver saverStub = mock(Saver.class);
        Decorator decoratorStub = mock(Decorator.class);
        when(decoratorStub.decorate("primitive: true")).thenReturn("primitive: true");
        Logger logger = new Logger(decoratorStub, saverStub);
        //endregion

        //region When
        logger.log(true);
        //endregion

        //region Then
        verify(decoratorStub).decorate("primitive: true");
        verify(saverStub).save("primitive: true");
        //endregion
    }

    @Test
    public void shouldPrintTypeAndStringWhenStringLogged() throws DecorateException, SaveException, LogException {
        //region Given
        Saver saverStub = mock(Saver.class);
        Decorator decoratorDummy = mock(Decorator.class);
        Logger logger = new Logger(decoratorDummy, saverStub);
        //endregion

        //region When
        logger.log("str1");
        logger.terminate();
        //endregion

        //region Then
        verify(saverStub).save("string: str1");
        //endregion
    }
}
