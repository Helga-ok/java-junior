package com.acme.edu.fileSaver;

import com.acme.edu.FileSaver;
import com.acme.edu.SaveException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.fest.assertions.Assertions.*;

public class FileSaverTest {
    @Test
    public void shouldPrintTypeAndCharacterWhenCharacterLogged() throws SaveException, IOException {
        //region Given
        String fileName = "log.txt";
        FileSaver fileSaver = new FileSaver(fileName);
        //endregion

        //region When
        String myString = "string";
        fileSaver.save(myString);
        //endregion

        //region Then
        String filePath = "." + File.separator + "logs" + File.separator + fileName;
        String everything = FileUtils.readFileToString(new File(filePath), "UTF-8");
        assertThat(myString).contains(everything);
        //endregion
    }
}
